<?php

namespace App\Http\Controllers\User;

use App\Http\Controllers\Controller;
use App\Http\Controllers\Gateway\PaymentController;
use App\Lib\HyipLab;
use App\Models\GatewayCurrency;
use App\Models\Invest;
use App\Models\Plan;
use Illuminate\Http\Request;

class InvestController extends Controller
{
    public function invest(Request $request)
    {
        $request->validate([
            'amount'        => 'required|min:0',
            'plan_id'       => 'required',
            'wallet_type'   => 'required',
        ]);
        $user   = auth()->user();
        $plan   = Plan::where('status',1)->findOrFail($request->plan_id);
        $amount = $request->amount;

        //Check limit
        if($plan->fixed_amount > 0){
            if ($amount != $plan->fixed_amount) {
                $notify[] = ['error','Please check the investment limit'];
                return back()->withNotify($notify);
            }
        }else{
            if ($request->amount < $plan->minimum || $request->amount > $plan->maximum) {
                $notify[] = ['error','Please check the investment limit'];
                return back()->withNotify($notify);
            }
        }

        $wallet = $request->wallet_type;

        //Direct checkout
        if ($wallet != 'deposit_wallet' && $wallet != 'interest_wallet') {

            $gate = GatewayCurrency::whereHas('method', function ($gate) {
                $gate->where('status', 1);
            })->find($request->wallet_type);

            if (!$gate) {
                $notify[] = ['error', 'Invalid gateway'];
                return back()->withNotify($notify);
            }

            if ($gate->min_amount > $request->amount || $gate->max_amount < $request->amount) {
                $notify[] = ['error', 'Please follow deposit limit'];
                return back()->withNotify($notify);
            }

            $data = PaymentController::insertDeposit($gate,$request->amount,$plan);
            session()->put('Track', $data->trx);
            return to_route('user.deposit.confirm');
        }

        if ($request->amount > $user->$wallet) {
            $notify[] = ['error', 'Your balance is not sufficient'];
            return back()->withNotify($notify);
        }

        $hyip = new HyipLab($user, $plan);
        $hyip->invest($amount, $wallet);

        $notify[] = ['success','Invested to plan successfully'];
        return back()->withNotify($notify);
    }

    public function statistics()
    {
        $pageTitle = 'Invest Statistics';
        $invests    = Invest::where('user_id',auth()->id())->orderBy('id','desc')->with('plan')->where('status',1)->paginate(getPaginate(10));
        $activePlan = Invest::where('user_id', auth()->id())->where('status', 1)->count();

        $investChart = Invest::where('user_id',auth()->id())->with('plan')->groupBy('plan_id')->select('plan_id')->selectRaw("SUM(amount) as investAmount")->orderBy('investAmount', 'desc')->get();
        return view($this->activeTemplate.'user.invest_statistics',compact('pageTitle','invests','investChart', 'activePlan'));
    }

    public function log()
    {
        $pageTitle = 'Invest Logs';
        $invests = Invest::where('user_id',auth()->id())->orderBy('id','desc')->with('plan')->paginate(getPaginate());
        return view($this->activeTemplate.'user.invests',compact('pageTitle','invests'));
    }
}
