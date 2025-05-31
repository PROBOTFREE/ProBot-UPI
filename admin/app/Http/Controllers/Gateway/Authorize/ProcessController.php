<?php

namespace App\Http\Controllers\Gateway\Authorize;

use App\Models\Deposit;
use App\Http\Controllers\Gateway\PaymentController;
use App\Http\Controllers\Controller;
use Illuminate\Http\Request;
use Illuminate\Support\Facades\Session;
use net\authorize\api\constants\ANetEnvironment;
use net\authorize\api\contract\v1\CreateTransactionRequest;
use net\authorize\api\contract\v1\CreditCardType;
use net\authorize\api\contract\v1\MerchantAuthenticationType;
use net\authorize\api\contract\v1\PaymentType;
use net\authorize\api\contract\v1\TransactionRequestType;
use net\authorize\api\controller\CreateTransactionController;


class ProcessController extends Controller
{

    public static function process($deposit)
    {
        $alias = $deposit->gateway->alias;
        $send['track'] = $deposit->trx;
        $send['view'] = 'user.payment.'.$alias;
        $send['method'] = 'post';
        $send['url'] = route('ipn.'.$alias);
        return json_encode($send);
    }

    public function ipn(Request $request)
    {
        $track = Session::get('Track');
        $deposit = Deposit::where('trx', $track)->where('status',0)->orderBy('id', 'DESC')->first();
        if ($deposit->status == 1) {
            $notify[] = ['error', 'Invalid request.'];
            return to_route(gatewayRedirectUrl())->withNotify($notify);
        }

        $this->validate($request, [
            'cardNumber' => 'required',
            'cardExpiry' => 'required',
            'cardCVC' => 'required',
        ]);
        $cardNumber = str_replace(' ','',$request->cardNumber);
        $exp = str_replace(' ','',$request->cardExpiry);

        $credentials = json_decode($deposit->gatewayCurrency()->gateway_parameter);

        // Common setup for API credentials
        $merchantAuthentication = new MerchantAuthenticationType();
        $merchantAuthentication->setName($credentials->login_id);
        $merchantAuthentication->setTransactionKey($credentials->transaction_key);

        // Create the payment data for a credit card
        $creditCard = new CreditCardType();
        $creditCard->setCardNumber($cardNumber);
        $creditCard->setExpirationDate($exp);

        $paymentOne = new PaymentType();
        $paymentOne->setCreditCard($creditCard);

        // Create a transaction
        $transactionRequestType = new TransactionRequestType();
        $transactionRequestType->setTransactionType("authCaptureTransaction");
        $transactionRequestType->setAmount($deposit->final_amo);
        $transactionRequestType->setPayment($paymentOne);

        $transactionRequest = new CreateTransactionRequest();
        $transactionRequest->setMerchantAuthentication($merchantAuthentication);
        $transactionRequest->setRefId($deposit->trx);
        $transactionRequest->setTransactionRequest($transactionRequestType);

        $controller = new CreateTransactionController($transactionRequest);
        $response = $controller->executeWithApiResponse(ANetEnvironment::SANDBOX);
        $response = $response->getTransactionResponse();

        if (($response != null) && ($response->getResponseCode() == "1")) {
            PaymentController::userDataUpdate($deposit);
            $notify[] = ['success', 'Payment captured successfully'];
            return to_route(gatewayRedirectUrl(true))->withNotify($notify);
        }
        $notify[] = ['error','Something went wrong'];
        return to_route(gatewayRedirectUrl())->withNotify($notify);

    }
}