<?php

namespace App\Http\Controllers\Api;

use App\Http\Controllers\Controller;
use App\Lib\FormProcessor;
use App\Models\AdminNotification;
use App\Models\Transaction;
use App\Models\Withdrawal;
use App\Models\WithdrawMethod;
use Illuminate\Http\Request;
use Illuminate\Support\Facades\Validator;

class WithdrawController extends Controller
{
    public function withdrawMethod()
    {
        $withdrawMethod = WithdrawMethod::where('status', 1)->get();
        $notify[]       = 'Withdrawals methods';
        return response()->json([
            'remark'  => 'withdraw_methods',
            'status'  => 'success',
            'message' => ['success' => $notify],
            'data'    => [
                'withdrawMethod' => $withdrawMethod,
            ],
        ]);
    }

    public function withdrawStore(Request $request)
    {
        $validator = Validator::make($request->all(), [
            'method_code' => 'required',
            'amount'      => 'required|numeric',
        ]);

        if ($validator->fails()) {
            return response()->json([
                'remark'  => 'validation_error',
                'status'  => 'error',
                'message' => ['error' => $validator->errors()->all()],
            ]);
        }

        $method = WithdrawMethod::where('id', $request->method_code)->where('status', 1)->first();
        if (!$method) {
            $notify[] = 'Withdraw method not found.';
            return response()->json([
                'remark'  => 'validation_error',
                'status'  => 'error',
                'message' => ['error' => $notify],
            ]);
        }

        $user = auth()->user();
        if ($request->amount < $method->min_limit) {
            $notify[] = 'Your requested amount is smaller than minimum amount.';
            return response()->json([
                'remark'  => 'validation_error',
                'status'  => 'error',
                'message' => ['error' => $notify],
            ]);
        }
        if ($request->amount > $method->max_limit) {
            $notify[] = 'Your requested amount is larger than maximum amount.';
            return response()->json([
                'remark'  => 'validation_error',
                'status'  => 'error',
                'message' => ['error' => $notify],
            ]);
        }

        if ($request->amount > $user->interest_wallet) {
            $notify[] = 'You do not have sufficient balance for withdraw.';
            return response()->json([
                'remark'  => 'validation_error',
                'status'  => 'error',
                'message' => ['error' => $notify],
            ]);
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

        $notify[] = 'Withdraw request created';
        return response()->json([
            'remark'  => 'withdraw_request_created',
            'status'  => 'success',
            'message' => ['success' => $notify],
            'data'    => [
                'trx'           => $withdraw->trx,
                'withdraw_data' => $withdraw,
                'form'          => $method->form->form_data,
            ],
        ]);
    }

    public function withdrawSubmit(Request $request)
    {
        $validator = Validator::make($request->all(), [
            'trx' => 'required',
        ]);

        if ($validator->fails()) {
            return response()->json([
                'remark'  => 'validation_error',
                'status'  => 'error',
                'message' => ['error' => $validator->errors()->all()],
            ]);
        }

        $withdraw = Withdrawal::with('method', 'user')->where('trx', $request->trx)->where('status', 0)->orderBy('id', 'desc')->first();
        if (!$withdraw) {
            $notify[] = 'Withdrawal request not found';
            return response()->json([
                'remark'  => 'validation_error',
                'status'  => 'error',
                'message' => ['error' => $notify],
            ]);
        }

        $method = $withdraw->method;

        if ($method->status == 0) {
            $notify[] = 'Withdraw method not found.';
            return response()->json([
                'remark'  => 'validation_error',
                'status'  => 'error',
                'message' => ['error' => $notify],
            ]);
        }

        $formData       = $method->form->form_data;
        $formProcessor  = new FormProcessor();
        $validationRule = $formProcessor->valueValidation($formData);
        $validator      = Validator::make($request->all(), $validationRule);

        if ($validator->fails()) {
            return response()->json([
                'remark'  => 'validation_error',
                'status'  => 'error',
                'message' => ['error' => $validator->errors()->all()],
            ]);
        }

        $userData = $formProcessor->processFormData($request, $formData);

        $user = auth()->user();
        if ($user->ts) {
            if (!$request->authenticator_code) {
                $notify[] = 'Google authentication is required';
                return response()->json([
                    'remark'  => 'validation_error',
                    'status'  => 'error',
                    'message' => ['error' => $notify],
                ]);
            }
            $response = verifyG2fa($user, $request->authenticator_code);
            if (!$response) {
                $notify[] = 'Wrong verification code';
                return response()->json([
                    'remark'  => 'validation_error',
                    'status'  => 'error',
                    'message' => ['error' => $notify],
                ]);
            }
        }

        if ($withdraw->amount > $user->interest_wallet) {
            $notify[] = 'Your request amount is larger then your current balance.';
            return response()->json([
                'remark'  => 'validation_error',
                'status'  => 'error',
                'message' => ['error' => $notify],
            ]);
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
        ],['push']);

        $notify[] = 'Withdraw request sent successfully';
        return response()->json([
            'remark'  => 'withdraw_confirmed',
            'status'  => 'success',
            'message' => ['success' => $notify],
        ]);
    }

    public function withdrawLog()
    {
        $withdraws = auth()->user()->withdrawals()->with('method')->searchable(['trx'])->apiQuery();

        $notify[] = 'Withdrawals';
        return response()->json([
            'remark'  => 'withdrawals',
            'status'  => 'success',
            'message' => ['success' => $notify],
            'data'    => [
                'withdrawals' => $withdraws,
            ],
        ]);
    }
}
