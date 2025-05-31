<?php

namespace App\Http\Controllers\Gateway\Razorpay;

use App\Models\Deposit;
use App\Http\Controllers\Controller;
use App\Http\Controllers\Gateway\PaymentController;
use Illuminate\Http\Request;
use Session;
use Razorpay\Api\Api;


class ProcessController extends Controller
{
    /*
     * RazorPay Gateway
     */

    public static function process($deposit)
    {
        $razorAcc = json_decode($deposit->gatewayCurrency()->gateway_parameter);

        //  API request and response for creating an order
        $api_key = $razorAcc->key_id;
        $api_secret = $razorAcc->key_secret;

        try {
            $api = new Api($api_key, $api_secret);
            $order = $api->order->create(
                array(
                    'receipt' => $deposit->trx,
                    'amount' => round($deposit->final_amo * 100),
                    'currency' => $deposit->method_currency,
                    'payment_capture' => '0'
                )
            );
        } catch (\Exception $e) {
            $send['error'] = true;
            $send['message'] = $e->getMessage();
            return json_encode($send);
        }


        $deposit->btc_wallet = $order->id;
        $deposit->save();

        $val['key'] = $razorAcc->key_id;
        $val['amount'] = round($deposit->final_amo * 100);
        $val['currency'] = $deposit->method_currency;
        $val['order_id'] = $order['id'];
        $val['buttontext'] = "Pay with Razorpay";
        $val['name'] = auth()->user()->username;
        $val['description'] = "Payment By Razorpay";
        $val['image'] = getImage(getFilePath('logoIcon') .'/logo.png');
        $val['prefill.name'] = auth()->user()->firstname . ' ' . auth()->user()->lastname;
        $val['prefill.email'] = auth()->user()->email;
        $val['prefill.contact'] = auth()->user()->mobile;
        $val['theme.color'] = "#2ecc71";
        $send['val'] = $val;

        $send['method'] = 'POST';


        $alias = $deposit->gateway->alias;

        $send['url'] = route('ipn.'.$alias);
        $send['custom'] = $deposit->trx;
        $send['checkout_js'] = "https://checkout.razorpay.com/v1/checkout.js";
        $send['view'] = 'user.payment.'.$alias;

        return json_encode($send);
    }

    public function ipn(Request $request)
    {

        $deposit = Deposit::where('btc_wallet', $request->razorpay_order_id)->orderBy('id', 'DESC')->first();
        $razorAcc = json_decode($deposit->gatewayCurrency()->gateway_parameter);

        if (!$deposit) {
            $notify[] = ['error', 'Invalid request'];
        }

        $sig = hash_hmac('sha256', $request->razorpay_order_id . "|" . $request->razorpay_payment_id, $razorAcc->key_secret);
        $deposit->detail = $request->all();
        $deposit->save();

        if ($sig == $request->razorpay_signature && $deposit->status == '0') {
            PaymentController::userDataUpdate($deposit);
            $notify[] = ['success', 'Transaction was successful'];
            return to_route(gatewayRedirectUrl(true))->withNotify($notify);
        } else {
            $notify[] = ['error', "Invalid Request"];
            return to_route(gatewayRedirectUrl())->withNotify($notify);
        }

    }
}
