<?php

namespace App\Http\Controllers\Gateway\Paypal;

use App\Models\Deposit;
use App\Http\Controllers\Gateway\PaymentController;
use App\Http\Controllers\Controller;
use App\Lib\CurlRequest;

class ProcessController extends Controller
{

    public static function process($deposit)
    {
        $basic =  gs();
        $paypalAcc = json_decode($deposit->gatewayCurrency()->gateway_parameter);
        $val['cmd'] = '_xclick';
        $val['business'] = trim($paypalAcc->paypal_email);
        $val['cbt'] = $basic->site_name;
        $val['currency_code'] = "$deposit->method_currency";
        $val['quantity'] = 1;
        $val['item_name'] = "Payment To $basic->site_name Account";
        $val['custom'] = "$deposit->trx";
        $val['amount'] = round($deposit->final_amo,2);
        $val['return'] = route(gatewayRedirectUrl(true));
        $val['cancel_return'] = route(gatewayRedirectUrl());
        $val['notify_url'] = route('ipn.'.$deposit->gateway->alias);
        $send['val'] = $val;
        $send['view'] = 'user.payment.redirect';
        $send['method'] = 'post';
        // $send['url'] = 'https://www.sandbox.paypal.com/'; // use for sandbod text
        $send['url'] = 'https://www.paypal.com/cgi-bin/webscr';
        return json_encode($send);
    }

    public function ipn()
    {
        $raw_post_data = file_get_contents('php://input');
        $raw_post_array = explode('&', $raw_post_data);
        $myPost = array();
        foreach ($raw_post_array as $keyval) {
            $keyval = explode('=', $keyval);
            if (count($keyval) == 2)
                $myPost[$keyval[0]] = urldecode($keyval[1]);
        }

        $req = 'cmd=_notify-validate';
        foreach ($myPost as $key => $value) {
            $value = urlencode(stripslashes($value));
            $req .= "&$key=$value";
            $details[$key] = $value;
        }

        // $paypalURL = "https://ipnpb.sandbox.paypal.com/cgi-bin/webscr?"; // use for sandbox text
        $paypalURL = "https://ipnpb.paypal.com/cgi-bin/webscr?";
        $url = $paypalURL . $req;
        $response = CurlRequest::curlContent($url);

        if ($response == "VERIFIED") {
            $deposit = Deposit::where('trx', $_POST['custom'])->orderBy('id', 'DESC')->first();
            $deposit->detail = $details;
            $deposit->save();

            if ($_POST['mc_gross'] == $deposit->final_amo && $deposit->status == '0') {
                PaymentController::userDataUpdate($deposit);
            }
        }
    }
}
