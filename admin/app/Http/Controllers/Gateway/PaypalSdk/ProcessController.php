<?php

namespace App\Http\Controllers\Gateway\PaypalSdk;

use App\Http\Controllers\Controller;
use App\Http\Controllers\Gateway\PaymentController;
use App\Http\Controllers\Gateway\PaypalSdk\Core\PayPalHttpClient;
use App\Http\Controllers\Gateway\PaypalSdk\Core\ProductionEnvironment;
use App\Http\Controllers\Gateway\PaypalSdk\Core\SandboxEnvironment;
use App\Http\Controllers\Gateway\PaypalSdk\Orders\OrdersCaptureRequest;
use App\Http\Controllers\Gateway\PaypalSdk\Orders\OrdersCreateRequest;
use App\Http\Controllers\Gateway\PaypalSdk\PayPalHttp\HttpException;
use App\Models\Deposit;

class ProcessController extends Controller
{

    public static function process($deposit)
    {
        $paypalAcc = json_decode($deposit->gatewayCurrency()->gateway_parameter);




        // Creating an environment
        $clientId = $paypalAcc->clientId;
        $clientSecret = $paypalAcc->clientSecret;
        $environment = new ProductionEnvironment($clientId, $clientSecret);
        $client = new PayPalHttpClient($environment);
        $request = new OrdersCreateRequest();
        $request->prefer('return=representation');
        $request->body = [
                             "intent" => "CAPTURE",
                             "purchase_units" => [[
                                 "reference_id" =>$deposit->trx,
                                 "amount" => [
                                     "value" => round($deposit->final_amo,2),
                                     "currency_code" => $deposit->method_currency
                                 ]
                             ]],
                             "application_context" => [
                                  "cancel_url" => route(gatewayRedirectUrl()),
                                  "return_url" => route('ipn.'.$deposit->gateway->alias)
                             ]
                         ];

        try {
            $response = $client->execute($request);

               $deposit->btc_wallet = $response->result->id;
               $deposit->save();

            $send['redirect'] = true;
            $send['redirect_url'] = $response->result->links[1]->href;
        }catch (HttpException $ex) {
            $send['error'] = true;
            $send['message'] = 'Failed to process with api';
        }

        return json_encode($send);
    }

    public function ipn()
    {
        $request = new OrdersCaptureRequest($_GET['token']);
        $request->prefer('return=representation');

        try {
            $deposit = Deposit::where('btc_wallet',$_GET['token'])->where('status',0)->firstOrFail();
            $paypalAcc = json_decode($deposit->gatewayCurrency()->gateway_parameter);
            $clientId = $paypalAcc->clientId;
            $clientSecret = $paypalAcc->clientSecret;
            $environment = new ProductionEnvironment($clientId, $clientSecret);
            $client = new PayPalHttpClient($environment);

            $response = $client->execute($request);

            if(@$response->result->status == 'COMPLETED'){
                $deposit->detail = json_decode(json_encode($response->result->payer));
                $deposit->save();

                PaymentController::userDataUpdate($deposit);

                $notify[] = ['success', 'Payment captured successfully'];
                return to_route(gatewayRedirectUrl(true))->withNotify($notify);

            }else{

                $notify[] = ['error', 'Payment captured failed'];
                return to_route(gatewayRedirectUrl())->withNotify($notify);
            }

        }catch (HttpException $ex) {
            return to_route(gatewayRedirectUrl());
        }
    }

}
