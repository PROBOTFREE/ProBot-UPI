<?php

namespace App\Http\Controllers\User;

use App\Http\Controllers\Controller;
use App\Lib\FormProcessor;
use App\Lib\HyipLab;
use App\Models\AdminNotification;
use App\Models\Transaction;
use App\Models\Withdrawal;
use App\Models\WithdrawMethod;
use Carbon\Carbon;
use Illuminate\Http\Request;

class WithdrawController extends Controller
{
    public function withdrawMoney()
    {
        $withdrawMethod = WithdrawMethod::where('status', 1)->get();
        $pageTitle      = 'Withdraw Money';

        $isHoliday      = HyipLab::isHoliDay(now()->toDateTimeString(), gs());
        $nextWorkingDay = now()->toDateString();

        if ($isHoliday && !gs()->holiday_withdraw) {
            $nextWorkingDay = HyipLab::nextWorkingDay(24);
            $nextWorkingDay = Carbon::parse($nextWorkingDay)->toDateString();
        }

        return view($this->activeTemplate . 'user.withdraw.methods', compact('pageTitle', 'withdrawMethod', 'isHoliday', 'nextWorkingDay'));
    }

    public function withdrawStore(Request $request)
    {

        $isHoliday = HyipLab::isHoliDay(now()->toDateTimeString(), gs());
        if ($isHoliday && !gs()->holiday_withdraw) {
            $notify[] = ['error', 'Today is holiday. You\'re unable to withdraw today'];
            return back()->withNotify($notify);
        }
        $this->validate($request, [
            'method_code' => 'required',
            'amount'      => 'required|numeric',
        ]);
        $method = WithdrawMethod::where('id', $request->method_code)->where('status', 1)->firstOrFail();
        $user   = auth()->user();
        if ($request->amount < $method->min_limit) {
            $notify[] = ['error', 'Your requested amount is smaller than minimum amount.'];
            return back()->withNotify($notify);
        }
        if ($request->amount > $method->max_limit) {
            $notify[] = ['error', 'Your requested amount is larger than maximum amount.'];
            return back()->withNotify($notify);
        }

        if ($request->amount > $user->interest_wallet) {
            $notify[] = ['error', 'You do not have sufficient balance for withdraw.'];
            return back()->withNotify($notify);
        }

        $charge      = $method->fixed_charge + ($request->amount * $method->percent_charge / 100);
        $afterCharge = $request->amount - $charge;
        $finalAmount = $afterCharge * $method->rate;

        $withdraw               = new Withdrawal();
        $withdraw->method_id    = $method->id; // wallet method ID
        $withdraw->user_id      = $user->id;
        $withdraw->amount       = $request->amount;
        $withdraw->currency     = $method->currency;
        $withdraw->rate         = $method->rate;
        $withdraw->charge       = $charge;
        $withdraw->final_amount = $finalAmount;
        $withdraw->after_charge = $afterCharge;
        $withdraw->trx          = getTrx();
        $withdraw->save();
        session()->put('wtrx', $withdraw->trx);
        return to_route('user.withdraw.preview');
    }

    public function withdrawPreview()
    {
        $withdraw  = Withdrawal::with('method', 'user')->where('trx', session()->get('wtrx'))->where('status', 0)->orderBy('id', 'desc')->firstOrFail();
        $pageTitle = 'Withdraw Preview';
        return view($this->activeTemplate . 'user.withdraw.preview', compact('pageTitle', 'withdraw'));
    }

    public function withdrawSubmit(Request $request)
    {
        $withdraw = Withdrawal::with('method', 'user')->where('trx', session()->get('wtrx'))->where('status', 0)->orderBy('id', 'desc')->firstOrFail();

        $method = $withdraw->method;
        if ($method->status == 0) {
            abort(404);
        }

        $formData = $method->form->form_data;

        $formProcessor  = new FormProcessor();
        $validationRule = $formProcessor->valueValidation($formData);
        $request->validate($validationRule);
        $userData = $formProcessor->processFormData($request, $formData);

        $user = auth()->user();
        if ($user->ts) {
            $response = verifyG2fa($user, $request->authenticator_code);
            if (!$response) {
                $notify[] = ['error', 'Wrong verification code'];
                return back()->withNotify($notify);
            }
        }

        if ($withdraw->amount > $user->interest_wallet) {
            $notify[] = ['error', 'Your request amount is larger then your current balance.'];
            return back()->withNotify($notify);
        }

        $withdraw->status               = 2;
        $withdraw->withdraw_information = $userData;
        $withdraw->save();
        $user->interest_wallet -= $withdraw->amount;
        $user->save();

        $transaction               = new Transaction();
        $transaction->user_id      = $withdraw->user_id;
        $transaction->amount       = $withdraw->amount;
        $transaction->post_balance = $user->interest_wallet;
        $transaction->charge       = $withdraw->charge;
        $transaction->trx_type     = '-';
        $transaction->details      = showAmount($withdraw->final_amount) . ' ' . $withdraw->currency . ' Withdraw Via ' . $withdraw->method->name;
        $transaction->trx          = $withdraw->trx;
        $transaction->wallet_type  = 'interest_wallet';
        $transaction->remark       = 'withdraw';
        $transaction->save();

        $adminNotification            = new AdminNotification();
        $adminNotification->user_id   = $user->id;
        $adminNotification->title     = 'New withdraw request from ' . $user->username;
        $adminNotification->click_url = urlPath('admin.withdraw.details', $withdraw->id);
        $adminNotification->save();

        notify($user, 'WITHDRAW_REQUEST', [
            'method_name'     => $withdraw->method->name,
            'method_currency' => $withdraw->currency,
            'method_amount'   => showAmount($withdraw->final_amount),
            'amount'          => showAmount($withdraw->amount),
            'charge'          => showAmount($withdraw->charge),
            'rate'            => showAmount($withdraw->rate),
            'trx'             => $withdraw->trx,
            'post_balance'    => showAmount($user->interest_wallet),
        ]);

        $notify[] = ['success', 'Withdraw request sent successfully'];
        return to_route('user.withdraw.history')->withNotify($notify);
    }

    public function withdrawLog(Request $request)
    {
        $pageTitle = "Withdraw Log";
        $withdraws = Withdrawal::where('user_id', auth()->id())->where('status', '!=', 0);
        if ($request->search) {
            $withdraws = $withdraws->where('trx', $request->search);
        }
        $withdraws = $withdraws->with('method')->orderBy('id', 'desc')->paginate(getPaginate());
        return view($this->activeTemplate . 'user.withdraw.log', compact('pageTitle', 'withdraws'));
    }
}
