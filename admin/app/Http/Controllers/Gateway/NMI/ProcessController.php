<?php

namespace App\Http\Controllers\Gateway\NMI;

use App\Models\Deposit;
use App\Http\Controllers\Gateway\PaymentController;
use App\Http\Controllers\Controller;
use App\Lib\CurlRequest;
use Illuminate\Support\Facades\Session;

class ProcessController extends Controller
{

    public static function process($deposit)
    {
        $credentials = json_decode($deposit->gatewayCurrency()->gateway_parameter);

        $xmlRequest = new \DOMDocument('1.0','UTF-8');
        $xmlRequest->formatOutput = true;
        $xmlSale = $xmlRequest->createElement('sale');

        self::appendXmlNode($xmlRequest, $xmlSale,'api-key',$credentials->api_key);
        self::appendXmlNode($xmlRequest, $xmlSale,'redirect-url',route('ipn.NMI'));
        self::appendXmlNode($xmlRequest, $xmlSale, 'amount', $deposit->amount);

        self::appendXmlNode($xmlRequest, $xmlSale, 'currency', $deposit->method_currency);

        self::appendXmlNode($xmlRequest, $xmlSale, 'order-id', $deposit->trx);
        $xmlRequest->appendChild($xmlSale);

        $data = CurlRequest::curlPostContent('https://secure.nmi.com/api/v2/three-step',$xmlRequest->saveXML(),["Content-type: text/xml"]);

        $gwResponse = new \SimpleXMLElement($data);
        if ((string)$gwResponse->result == 1 ) {
            $formURL = $gwResponse->{'form-url'};
        } else {
            $send['error'] = true;
            $send['message'] = 'Something went wrong';
            return json_encode($send);
        }
        $formURL = (array)$formURL;
        $formURL = $formURL[0];
        $alias = $deposit->gateway->alias;
        $send['url'] = $formURL;
        $send['view'] = 'user.payment.'.$alias;
        $send['method'] = 'POST';
        return json_encode($send);

    }

    public function ipn(){
        $tokenId = $_GET['token-id'];

        $track = Session::get('Track');
        $deposit = Deposit::where('trx', $track)->orderBy('id', 'DESC')->first();

        $credentials = json_decode($deposit->gatewayCurrency()->gateway_parameter);

        $xmlRequest = new \DOMDocument('1.0','UTF-8');
        $xmlRequest->formatOutput = true;
        $xmlCompleteTransaction = $xmlRequest->createElement('complete-action');
        self::appendXmlNode($xmlRequest, $xmlCompleteTransaction,'api-key',$credentials->api_key);
        self::appendXmlNode($xmlRequest, $xmlCompleteTransaction,'token-id',$tokenId);
        $xmlRequest->appendChild($xmlCompleteTransaction);

        $data = CurlRequest::curlPostContent('https://secure.nmi.com/api/v2/three-step',$xmlRequest->saveXML(),["Content-type: text/xml"]);
        $gwResponse = @new \SimpleXMLElement((string)$data);
        if ($gwResponse->result == 1) {
            $deposit->detail = $gwResponse;
            $deposit->save();
            PaymentController::userDataUpdate($deposit);
            $notify[] = ['success', 'Payment captured successfully'];
            return to_route(gatewayRedirectUrl(true))->withNotify($notify);
        }
        $notify[] = ['error', 'Something went wrong'];
        return to_route(gatewayRedirectUrl())->withNotify($notify);

    }


    public static function appendXmlNode($domDocument, $parentNode, $name, $value) {
        $childNode      = $domDocument->createElement($name);
        $childNodeValue = $domDocument->createTextNode($value);
        $childNode->appendChild($childNodeValue);
        $parentNode->appendChild($childNode);
    }
}