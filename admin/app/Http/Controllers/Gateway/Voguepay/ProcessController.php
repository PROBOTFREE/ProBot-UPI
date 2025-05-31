<?php

namespace App\Http\Controllers\Gateway\Voguepay;

use App\Models\Deposit;
use App\Http\Controllers\Controller;
use Illuminate\Http\Request;
use App\Http\Controllers\Gateway\PaymentController;
use App\Lib\CurlRequest;

class ProcessController extends Controller
{
    /*
     * Vogue Pay Gateway
     */

    public static function process($deposit)
    {
        $vogueAcc = json_decode($deposit->gatewayCurrency()->gateway_parameter);
        $send['v_merchant_id'] = $vogueAcc->merchant_id;


        $alias = $deposit->gateway->alias;

        $send['notify_url'] = route('ipn.'.$alias);
        $send['cur'] = $deposit->method_currency;
        $send['merchant_ref'] = $deposit->trx;
        $send['memo'] = 'Payment';
        $send['store_id'] = $deposit->user_id;
        $send['custom'] = $deposit->trx;
        $send['Buy'] = round($deposit->final_amo,2);
        $alias = $deposit->gateway->alias;
        $send['view'] = 'user.payment.' . $alias;
        return json_encode($send);
    }

    public function ipn(Request $request)
    {
        $request->validate([
            'transaction_id' => 'required'
        ]);

        $trx = $request->transaction_id;
        $url = "https://voguepay.com/?v_transaction_id=$trx&type=json";
        $response = CurlRequest::curlContent($url);
        $vougueData = json_decode($response);
        $track = $vougueData->merchant_ref;

        $deposit = Deposit::where('trx', $track)->orderBy('id', 'DESC')->first();
        $vogueAcc = json_decode($deposit->gatewayCurrency()->gateway_parameter);
        if ($vougueData->status == "Approved" && $vougueData->merchant_id == $vogueAcc->merchant_id && $vougueData->total == getAmount($deposit->final_amo) && $vougueData->cur_iso == $deposit->method_currency &&  $deposit->status == '0') {
            //Update User Data
            PaymentController::userDataUpdate($deposit);
        }
    }
}
