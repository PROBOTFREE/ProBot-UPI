<?php

namespace App\Http\Controllers\Gateway\Paystack;

use App\Models\Deposit;
use App\Http\Controllers\Controller;
use App\Http\Controllers\Gateway\PaymentController;
use Illuminate\Http\Request;

class ProcessController extends Controller
{
    /*
     * PayStack Gateway
     */

    public static function process($deposit)
    {
        $paystackAcc = json_decode($deposit->gatewayCurrency()->gateway_parameter);

        $alias = $deposit->gateway->alias;


        $send['key'] = $paystackAcc->public_key;
        $send['email'] = auth()->user()->email;
        $send['amount'] = $deposit->final_amo * 100;
        $send['currency'] = $deposit->method_currency;
        $send['ref'] = $deposit->trx;
        $send['view'] = 'user.payment.'.$alias;
        return json_encode($send);
    }



    public function ipn(Request $request)
    {
        $request->validate([
            'reference' => 'required',
            'paystack-trxref' => 'required',
        ]);
        $track = $request->reference;
        $deposit = Deposit::where('trx', $track)->orderBy('id', 'DESC')->first();
        $paystackAcc = json_decode($deposit->gatewayCurrency()->gateway_parameter);
        $secret_key = $paystackAcc->secret_key;

        $result = array();
        //The parameter after verify/ is the transaction reference to be verified
        $url = 'https://api.paystack.co/transaction/verify/' . $track;
        $ch = curl_init();
        curl_setopt($ch, CURLOPT_URL, $url);
        curl_setopt($ch, CURLOPT_RETURNTRANSFER, 1);
        curl_setopt($ch, CURLOPT_HTTPHEADER, ['Authorization: Bearer ' . $secret_key]);
        $response = curl_exec($ch);
        curl_close($ch);

        if ($response) {
            $result = json_decode($response, true);

            if ($result) {
                if ($result['data']) {

                    $deposit->detail = $result['data'];
                    $deposit->save();

                    if ($result['data']['status'] == 'success') {

                        $am = $result['data']['amount']/100;
                        $sam = round($deposit->final_amo, 2);

                        if ($am == $sam && $result['data']['currency'] == $deposit->method_currency  && $deposit->status == '0') {
                            PaymentController::userDataUpdate($deposit);
                            $notify[] = ['success', 'Payment captured successfully'];
                            return to_route(gatewayRedirectUrl(true))->withNotify($notify);
                        } else {
                            $notify[] = ['error', 'Less amount paid. Please contact with admin.'];
                        }
                    } else {
                        $notify[] = ['error', $result['data']['gateway_response']];
                    }
                } else {
                    $notify[] = ['error', $result['message']];
                }
            } else {
                $notify[] = ['error', 'Something went wrong while executing'];
            }
        } else {
            $notify[] = ['error', 'Something went wrong while executing'];
        }
        return to_route(gatewayRedirectUrl())->withNotify($notify);
    }
}
