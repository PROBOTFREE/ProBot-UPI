<?php

namespace App\Http\Controllers\Gateway\Cashmaal;

use App\Models\Deposit;
use App\Models\GatewayCurrency;
use App\Http\Controllers\Controller;
use App\Http\Controllers\Gateway\PaymentController;
use Illuminate\Http\Request;

class ProcessController extends Controller
{
    /*
     * Cashmaal
     */

    public static function process($deposit)
    {
    	$cashmaal = json_decode($deposit->gatewayCurrency());
    	$param = json_decode($cashmaal->gateway_parameter);
        $val['pay_method'] = " ";
        $val['amount'] = getAmount($deposit->final_amo);
        $val['currency'] = $cashmaal->currency;
        $val['succes_url'] = route(gatewayRedirectUrl(true));
        $val['cancel_url'] = route(gatewayRedirectUrl());
        $val['client_email'] = auth()->user()->email;
        $val['web_id'] = $param->web_id;
        $val['order_id'] = $deposit->trx;
        $val['addi_info'] = "Deposit";
        $send['url'] = 'https://www.cashmaal.com/Pay/';
        $send['method'] = 'post';
        $send['view'] = 'user.payment.redirect';
        $send['val'] = $val;
        return json_encode($send);
    }

    public function ipn(Request $request)
    {

    	$gateway = GatewayCurrency::where('gateway_alias','Cashmaal')->where('currency',$request->currency)->first();
        $IPN_key=json_decode($gateway->gateway_parameter)->ipn_key;
        $web_id=json_decode($gateway->gateway_parameter)->web_id;


        $deposit = Deposit::where('trx', $_POST['order_id'])->orderBy('id', 'DESC')->first();
        if ($request->ipn_key != $IPN_key && $web_id != $request->web_id) {
        	$notify[] = ['error','Data invalid'];
        	return to_route(gatewayRedirectUrl())->withNotify($notify);
        }

        if ($request->status == 2) {
        	$notify[] = ['info','Payment in pending'];
        	return to_route(gatewayRedirectUrl())->withNotify($notify);
        }

        if ($request->status != 1) {
        	$notify[] = ['error','Data invalid'];
        	return to_route(gatewayRedirectUrl())->withNotify($notify);
        }

		if($_POST['status'] == 1 && $deposit->status == 0 && $_POST['currency'] == $deposit->method_currency ){
			PaymentController::userDataUpdate($deposit);
            $notify[] = ['success', 'Transaction is successful'];
		}else{
			$notify[] = ['error','Payment failed'];
        	return to_route(gatewayRedirectUrl())->withNotify($notify);
		}
		return to_route(gatewayRedirectUrl(true))->withNotify($notify);
    }
}
