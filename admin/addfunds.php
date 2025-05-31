<?php

use PayPalCheckoutSdk\Core\PayPalHttpClient;
use PayPalCheckoutSdk\Core\SandboxEnvironment;
use PayPalCheckoutSdk\Core\ProductionEnvironment;
use PayPalCheckoutSdk\Orders\OrdersCreateRequest;
use Mollie\Api\MollieApiClient;
use GuzzleHttp\Client;
require_once 'app/classes/pbsmmcheck.php';

$title.= " Add Funds";

if( $_SESSION["msmbilisim_userlogin"] != 1  || $user["client_type"] == 1  ){
    Header("Location:".site_url('logout'));
}

if( $settings["email_confirmation"] == 1  && $user["email_type"] == 1  ){
  Header("Location:".site_url('confirm_email'));
}


$paymentsList = $conn->prepare("SELECT * FROM payment_methods WHERE method_type=:type && id!=:id6 && id!=:id10 && id!=:id14 ORDER BY method_line ASC ");
$paymentsList->execute(array("type" => 2, "id6" => 6, "id10" => 10, "id14" => 14  ));
$paymentsList = $paymentsList->fetchAll(PDO::FETCH_ASSOC);
foreach ($paymentsList as $index => $payment) {
    $extra = json_decode($payment["method_extras"], true);
    $methodList[$index]["method_name"] = $extra["name"];
    $methodList[$index]["id"] = $payment["id"];
}
$PaytmQR = $conn->prepare("SELECT * FROM payment_methods WHERE id=:id ");
$PaytmQR->execute(array("id" => 14));
$PaytmQR = $PaytmQR->fetch(PDO::FETCH_ASSOC);
$PaytmQRimg = json_decode($PaytmQR['method_extras'], true);
$PaytmQRimage = $PaytmQRimg["merchant_key"];
$bankPayment = $conn->prepare("SELECT * FROM payment_methods WHERE id=:id ");
$bankPayment->execute(array("id" => 6));
$bankPayment = $bankPayment->fetch(PDO::FETCH_ASSOC);
$bankList = $conn->prepare("SELECT * FROM bank_accounts");
$bankList->execute(array());
$bankList = $bankList->fetchAll(PDO::FETCH_ASSOC);
$payoneerPayment = $conn->prepare("SELECT * FROM payment_methods WHERE id=:id ");
$payoneerPayment->execute(array("id" => 10));
$payoneerPayment = $payoneerPayment->fetch(PDO::FETCH_ASSOC);
$payoneerPaymentExtra = json_decode($payoneerPayment['method_extras'], true);

$clid =$user['client_id']; 

$searchh = "WHERE payments.client_id=$clid && payments.payment_status='3' ";
$transaction_logs = $conn->prepare("SELECT * FROM payments INNER JOIN payment_methods ON payment_methods.id=payments.payment_method INNER JOIN clients ON clients.client_id=payments.client_id $searchh ORDER BY payments.payment_id DESC");
$transaction_logs->execute(array());
$transaction_logs = $transaction_logs->fetchAll(PDO::FETCH_ASSOC);

if ($_POST && $_POST["payment_bank"]):
    foreach ($_POST as $key => $value):
        $_SESSION["data"][$key] = $value;
    endforeach;
    $bank = $_POST["payment_bank"];
    $amount = $_POST["payment_bank_amount"];
    $gonderen = $_POST["payment_gonderen"];
    $method_id = 6;
    $extras = json_encode($_POST);
    if (open_bankpayment($user["client_id"]) >= 2) {
        unset($_SESSION["data"]);
        $error = 1;
        $errorText = 'You have 2 payment notifications pending approval, you cannot create new notifications.';
    } elseif (empty($bank)) {
        $error = 1;
        $errorText = 'Please select a valid bank account.';
    } elseif (!is_numeric($amount)) {
        $error = 1;
        $errorText = 'Please enter a valid amount.';
    } elseif (empty($gonderen)) {
        $error = 1;
        $errorText = 'Please enter a valid sender name.';
    } else {
        $insert = $conn->prepare("INSERT INTO payments SET client_id=:c_id, payment_amount=:amount, payment_method=:method, payment_create_date=:date, payment_ip=:ip, payment_extra=:extras, payment_bank=:bank ");
        $insert->execute(array("c_id" => $user["client_id"], "amount" => $amount, "method" => $method_id, "date" => date("Y.m.d H:i:s"), "ip" => GetIP(), "extras" => $extras, "bank" => $bank));
        if ($insert) {
            unset($_SESSION["data"]);
            $success = 1;
            $successText = 'Your payment notification has been received.';
            if ($settings["alert_newbankpayment"] == 2):
                if ($settings["alert_type"] == 3):
                    $sendmail = 1;
                    $sendsms = 1;
                elseif ($settings["alert_type"] == 2):
                    $sendmail = 1;
                    $sendsms = 0;
                elseif ($settings["alert_type"] == 1):
                    $sendmail = 0;
                    $sendsms = 1;
                endif;
                if ($sendsms):
                    SMSUser($settings["admin_telephone"], "New payment request created on your site and ID is: #" . $conn->lastInsertId());
                endif;
                if ($sendmail):
                    sendMail(["subject" => "New payment request", "body" => "New payment request created on your site and ID is: #" . $conn->lastInsertId(), "mail" => $settings["admin_mail"]]);
                endif;
            endif;
        } else {
            $error = 1;
            $errorText = 'An error occurred while alert sending, please try again later..';
        }
    } elseif ($_POST && $_POST["payment_type"]):
        foreach ($_POST as $key => $value):
            $_SESSION["data"][$key] = $value;
        endforeach;
        $method_id = $_POST["payment_type"];
        $amount = $_POST["payment_amount"];
         if($_POST["paytmqr_orderid"] !="" ){
            $paytmqr_orderid = $_POST["paytmqr_orderid"];
        }
        $extras = json_encode($_POST);
        $method = $conn->prepare("SELECT * FROM payment_methods WHERE id=:id ");
        $method->execute(array("id" => $method_id));
        $method = $method->fetch(PDO::FETCH_ASSOC);
        $extra = json_decode($method["method_extras"], true);
        $paymentCode = createPaymentCode();
        $amount_fee = ($amount + ($amount * $extra["fee"] / 100));
        if (empty($method_id)) {
            $error = 1;
            $errorText = 'Please select a valid payment method.';
        } elseif (!is_numeric($amount)) {
            $error = 1;
            $errorText = 'Please enter a valid amount.';
        } elseif ($amount < $method["method_min"]) {
            $error = 1;
            $errorText = 'Minimum payment amount ' . $settings["csymbol"] . $method["method_min"];
        } elseif ($amount > $method["method_max"] && $method["method_max"] != 0) {
            $error = 1;
            $errorText = 'Maximum payment amount ' . $settings["csymbol"] . $method["method_max"];
        } else {
            // $currentcur = '{"rates": {"USD": "1"}}';
            // $ch = curl_init();
            // curl_setopt($ch, CURLOPT_URL, 'https://api.exchangeratesapi.io/latest?base='.$settings['site_currency']);
            // curl_setopt($ch, CURLOPT_RETURNTRANSFER, 1);
            // $currentcur = curl_exec($ch);
            // $currentcur = json_decode($currentcur);

            // if(isset($currentcur->error){
            //     if(defined($getcur.'_')) { constant($getcur.'_') }else{
            //         die('There\'s a problem with currency. Please contact with admin.')
            //     } 
            // }

           if ($method_id == 1):
               
                   
                $pp_amount_fee = str_replace(',', '.', $amount_fee);
                
                $clientId = $extra["client_id"];
                $clientSecret = $extra["client_secret"];
                
                 include_once( $_SERVER['DOCUMENT_ROOT']."/pswlicence/paypal/paypal-checkout-sdk/lib/PayPalCheckoutSdk/Core/ProductionEnvironment.php"); 
                  
                $environment = new ProductionEnvironment($clientId, $clientSecret);
                 include_once( $_SERVER['DOCUMENT_ROOT']."/pswlicence/paypal/paypal-checkout-sdk/lib/PayPalCheckoutSdk/Core/PayPalHttpClient.php"); 
                
            
                $client = new PayPalHttpClient($environment);
               

                // Construct a request object and set desired parameters
                // Here, OrdersCreateRequest() creates a POST request to /v2/checkout/orders
                 include_once( $_SERVER['DOCUMENT_ROOT']."/pswlicence/paypal/paypal-checkout-sdk/lib/PayPalCheckoutSdk/Orders/OrdersCreateRequest.php"); 
                echo "<pre>"; 
                $request = new OrdersCreateRequest();
                $request->prefer('return=representation');
                $icid = md5(rand(1,999999));
                $request->body = [
                                    "intent" => "CAPTURE",
                                    "purchase_units" => [[
                                        "amount" => [
                                            "value" => $pp_amount_fee,
                                            "currency_code" => $settings['site_currency']
                                        ],
                                        "invoice_id" => $icid,
                                        "custom_id" => $user['client_id']
                                    ]],
                                    "application_context" => [
                                        "cancel_url" => site_url(),
                                        "return_url" => site_url()
                                    ] 
                                ];

                $response = json_decode(json_encode($client->execute($request)),true);
                if ($response['result']['links'][1]['href']):
                    unset($_SESSION["data"]);
                    $insert = $conn->prepare("INSERT INTO payments SET client_id=:c_id, payment_amount=:amount, payment_privatecode=:code, payment_method=:method, payment_mode=:mode, payment_create_date=:date, payment_ip=:ip, payment_extra=:extra");
                    $insert->execute(array("c_id" => $user['client_id'], "amount" => $amount, "code" => $paymentCode, "method" => $method_id, "mode" => "Auto", "date" => date("Y.m.d H:i:s"), "ip" => GetIP(), "extra" => $icid));
                    $success = 1;
                    $successText = "Your payment was initiated successfully, you are being redirected..";
                    $payment_url = $response['result']['links'][1]['href'];
                else:
                    $error = 1;
                    $errorText = "There was an error starting your payment, please try again later..";
                endif;

			
				elseif($method_id==35):
                $m_shop = $extra["m_shop"];
                $m_orderid = md5(rand(1,999999));
                $m_amount = number_format($amount, 2, '.', '');
                $m_curr = $settings['site_currency'];
                $m_desc = base64_encode('Payeer Orders');
                $m_key = $extra["client_secret"];

                $arHash = array(
                    $m_shop,
                    $m_orderid,
                    $m_amount,
                    $m_curr,
                    $m_desc
                );

            

                $arHash[] = $m_key;

                $sign = strtoupper(hash('sha256', implode(':', $arHash)));

                unset($_SESSION["data"]);
                $insert = $conn->prepare("INSERT INTO payments SET client_id=:c_id, payment_amount=:amount, payment_privatecode=:code, payment_method=:method, payment_mode=:mode, payment_create_date=:date, payment_ip=:ip, payment_extra=:extra");
                $insert->execute(array("c_id" => $user['client_id'], "amount" => $amount, "code" => $paymentCode, "method" => $method_id, "mode" => "Auto", "date" => date("Y.m.d H:i:s"), "ip" => GetIP(), "extra" => $m_orderid));
                $success = 1;
                $successText = "Your payment was initiated successfully, you are being redirected..";
                ?>
                <form id="payeer_payment" method="post" action="https://payeer.com/merchant/">
                <input type="hidden" name="m_shop" value="<?=$m_shop?>">
                <input type="hidden" name="m_orderid" value="<?=$m_orderid?>">
                <input type="hidden" name="m_amount" value="<?=$m_amount?>">
                <input type="hidden" name="m_curr" value="<?=$m_curr?>">
                <input type="hidden" name="m_desc" value="<?=$m_desc?>">
                <input type="hidden" name="m_sign" value="<?=$sign?>">
                <?php /*
                <input type="hidden" name="form[ps]" value="2609">
                <input type="hidden" name="form[curr[2609]]" value="USD">
                */ ?>
                <?php /*
                <input type="hidden" name="m_params" value="<?=$m_params?>">
                <input type="hidden" name="m_cipher_method" value="AES-256-CBC">
                */ ?>
                <input type="submit" style="display: none;" name="m_process" value="send" />
                <script type="text/javascript" src="//code.jquery.com/jquery-3.3.1.min.js"></script>
                <script>
                    $("form#payeer_payment").submit();
                </script>
                <?php
                // $arGetParams = array(
                //     'm_shop' => $m_shop,
                //     'm_orderid' => $m_orderid,
                //     'm_amount' => $m_amount,
                //     'm_curr' => $m_curr,
                //     'm_desc' => $m_desc,
                //     'm_sign' => $sign,
                //     );
                // $url = 'https://payeer.com/merchant/?'.http_build_query($arGetParams);
                
                // $payment_url = $url;
					
			
			

                 elseif ($method_id == 26):

        // purchase.php

//

        $MERCHANT_KEY = $extra['merchant_key'];
        $SALT         = $extra['salt_key'];

$PAYU_BASE_URL = "https://secure.payu.in"; // LIVE mode
        // $PAYU_BASE_URL = "https://test.payu.in"; // TEST mode

        $posted = [
            'key'              => $MERCHANT_KEY,
            'txnid'            => substr(hash('sha256', mt_rand() . microtime()), 0, 20),
            'amount'           => (double)$amount,
            'productinfo'      => 'Recharge',
            'firstname'        => $user['first_name'],
            'email'            => $user['email'],
            'phone'            => $user['phone'],
            'surl'             => site_url('payment/payumoney'),
            'furl'             => site_url(),
            'service_provider' => 'payu_paisa', // <================= DONT send this in TEST mode
        ];
// Hash Sequence
        $hashSequence = "key|txnid|amount|productinfo|firstname|email|udf1|udf2|udf3|udf4|udf5|udf6|udf7|udf8|udf9|udf10";

        $hashVarsSeq = explode('|', $hashSequence);
        $hash_string = '';

        foreach ($hashVarsSeq as $hash_var) {
            $hash_string .= isset($posted[$hash_var]) ? $posted[$hash_var] : '';
            $hash_string .= '|';
        }

        $hash_string .= $SALT;
        $hash = strtolower(hash('sha512', $hash_string));
        $posted['hash'] = $hash ;
        $action         = $PAYU_BASE_URL . '/_payment';

        $order_id                     = $posted["txnid"];
       
        $insert                       = $conn->prepare("INSERT INTO payments SET client_id=:c_id, payment_amount=:amount, payment_privatecode=:code, payment_method=:method, payment_mode=:mode, payment_create_date=:date, payment_ip=:ip, payment_extra=:extra");
        $insert->execute(array("c_id" => $user['client_id'], "amount" => $amount, "code" => $paymentCode, "method" => $method_id, "mode" => "", "date" => date("Y.m.d H:i:s"), "ip" => GetIP(), "extra" => $order_id));

// Redirects to PayUMoney
        // $payumoney->initializePurchase($params)->send();
        echo '<div class="dimmer active" style="min-height: 400px;">
          <div class="loader"></div>
          <div class="dimmer-content">
            <center><h2>Please do not refresh this page</h2></center>
            <svg xmlns="http://www.w3.org/2000/svg" xmlns:xlink="http://www.w3.org/1999/xlink" style="margin:auto;background:#fff;display:block;" width="200px" height="200px" viewBox="0 0 100 100" preserveAspectRatio="xMidYMid">
              <circle cx="50" cy="50" r="32" stroke-width="8" stroke="#e15b64" stroke-dasharray="50.26548245743669 50.26548245743669" fill="none" stroke-linecap="round">
                <animateTransform attributeName="transform" type="rotate" dur="1s" repeatCount="indefinite" keyTimes="0;1" values="0 50 50;360 50 50"></animateTransform>
              </circle>
              <circle cx="50" cy="50" r="23" stroke-width="8" stroke="#f8b26a" stroke-dasharray="36.12831551628262 36.12831551628262" stroke-dashoffset="36.12831551628262" fill="none" stroke-linecap="round">
                <animateTransform attributeName="transform" type="rotate" dur="1s" repeatCount="indefinite" keyTimes="0;1" values="0 50 50;-360 50 50"></animateTransform>
              </circle>
            </svg>
             <form action="'.$action.'" method="post" name="payuForm" id="pay">
            <input type="hidden" name="key"         value="' . $posted["key"] . '" />
            <input type="hidden" name="hash"        value="' . $posted["hash"] . '" />
            <input type="hidden" name="txnid"       value="' . $posted["txnid"] . '" />
            <input type="hidden" name="amount"      value="' . $posted["amount"] . '" />
            <input type="hidden" name="productinfo" value="' . $posted["productinfo"] . '" />
            <input type="hidden" name="firstname"   value="' . $posted["firstname"] . '" />
            <input type="hidden" name="email"       value="' . $posted["email"] . '" />
            <input type="hidden" name="phone"       value="' . $posted["phone"] . '" />
            <input type="hidden" name="surl"        value="' . $posted["surl"] . '" />
            <input type="hidden" name="furl"        value="' . $posted["furl"] . '" />

            <input type="hidden" name="service_provider" value="' . $posted["service_provider"] . '" size="68" />
            


              <script type="text/javascript">
                document.getElementById("pay").submit();
              </script>
            </form>
          </div>
        </div>';

// paytm upi gateway

      elseif ($method_id == 182):
  $prefix = "CXRSMMPAYORDER_";               

     $icid = $prefix . uniqid(); 
setcookie("my_cookie",$icid, time()+300, "/");
  $orderId =$icid;
 $insert = $conn->prepare("INSERT INTO payments SET client_id=:c_id, payment_amount=:amount, payment_privatecode=:code, payment_method=:method, payment_mode=:mode, payment_create_date=:date, payment_ip=:ip, payment_extra=:extra");
                $insert->execute(array("c_id" => $user['client_id'], "amount" => $amount, "code" => $paymentCode, "method" => $method_id, "mode" => "Automatic", "date" => date("Y.m.d H:i:s"), "ip" => GetIP(), "extra" =>  $icid));
                
 
error_reporting(0);
$token = '1aa71d-a68d8b-6eb89d-b6f45c-4cd7e8'; // Your Token,which  you got 
$secret = 'CkW9sBRYkQ'; // Your Secret Key, which you got 
$RECHPAY_ENVIRONMENT = 'PROD'; // PROD, TEST

$checkSum = "";
$upiuid = "";
$paramList = array();

$cust_Mobile = '1818188181';
$cust_Email = $user['email'];

$txnAmount = $amount;
$txnNote = "paymentfrom_".$user['username'];

 $data=site_url('upipayment');

$TXN_URL='https://pbsmm.store/order/paytm';

$upiuid = 'paytmqr281005050101ur1e74pf8v8u@paytm'; // Its Paytm Business UPI Unique ID. Put your Paytm Business UPI Unique ID

$paramList["cust_Mobile"] = $cust_Mobile;
$paramList["cust_Email"] = $cust_Email;



// Create an array having all required parameters for creating checksum.
$paramList["upiuid"] = $upiuid;
$paramList["token"] = $token;
$paramList["orderId"] = $orderId ;
$paramList["txnAmount"] = $txnAmount;
$paramList["txnNote"] = $txnNote;
$paramList["callback_url"] =  $data;

$checkSum = RechPayChecksum::generateSignature($paramList,$secret);
	 
echo '<form method="post" action="' . $TXN_URL . '" name="f1">
        <table border="1">
            <tbody>';
foreach($paramList as $name => $value) {
    echo '<input type="hidden" name="' . $name .'" value="' . $value . '">';
}
echo '<input type="hidden" name="checksum" value="' . $checkSum . '">
            </tbody>
        </table>
        <script type="text/javascript">
            document.f1.submit();
        </script>
    </form>';

//upi gateway.com  ==183 

    elseif ($method_id == 183):
                      
         
        $icid = md5(rand(1,99));
    
    $insert = $conn->prepare("INSERT INTO payments SET client_id=:c_id, payment_amount=:amount, payment_privatecode=:code, payment_method=:method, payment_mode=:mode, payment_create_date=:date, payment_ip=:ip, payment_extra=:extra");
                   $insert->execute(array("c_id" => $user['client_id'], "amount" => $amount, "code" => $paymentCode, "method" => $method_id, "mode" => "Automatic", "date" => date("Y.m.d H:i:s"), "ip" => GetIP(), "extra" =>  $icid));
                   
    
    
   $key = $extra['key'];    // you can get your key from https://merchant.upigateway.com/user/api_credentials
       
        
    $data=site_url('upipayment1');
   
   $key = $extra['key'];    // you can get your key from https://merchant.upigateway.com/user/api_credentials
        $content = json_encode(array(
            "key"=> $key,
            "client_txn_id"=> $icid, // order id or your own transaction id
            "amount"=> $amount, 
            "p_info"=> "ADD FUND IN PANEL",
            "customer_name"=> "Jon Doe", // customer name
            "customer_email"=> $user['email'], // customer email
            "customer_mobile"=> "9876543210", // customer mobile number
            "redirect_url"=> $data, // redirect url after payment, with ?client_txn_id=&txn_id=
            "udf1"=> "user defined field 1", // udf1, udf2 and udf3 are used to save other order related data, like customer id etc.
            "udf2"=> "user defined field 2",
            "udf3"=> "user defined field 3",
        ));
        $url = "https://merchant.upigateway.com/api/create_order";
        $curl = curl_init($url);
        curl_setopt($curl, CURLOPT_HEADER, false);
        curl_setopt($curl, CURLOPT_RETURNTRANSFER, true);
        curl_setopt($curl, CURLOPT_HTTPHEADER,
                array("Content-type: application/json"));
        curl_setopt($curl, CURLOPT_POST, true);
        curl_setopt($curl, CURLOPT_POSTFIELDS, $content);
        $json_response = curl_exec($curl);
        $status = curl_getinfo($curl, CURLINFO_HTTP_CODE);
        if ( $status != 200 ) {
            // You can handle Error yourself.
            die("Error: call to URL $url failed with status $status, response $json_response, curl_error " . curl_error($curl) . ", curl_errno " . curl_errno($curl));
        }
        curl_close($curl);
        $response = json_decode($json_response, true);
        if($response["status"] == true){
            // Method 1
            // redirect to payment page of UPI
        $extra=$response["data"]["payment_url"];
            
            // Method 2
            // echo "<script>window.location.href='".$response["data"]["payment_url"]."'</script>";
            // die();
        }else{
            $extra= $response['msg'];
        }
   
   header("Location: ".$extra);

//phone pe upi gateway id =184

   elseif ($method_id == 184):
    
    $SALT    = $extra['salt_key'];

$userToken =  $SALT;
$amount = $amount;
$orderID = uniqid();
$redirectURL = site_url('upipayment3');


$endpointURL = 'https://nortaxsmm.in/payment/create_order.php';
$queryParams = http_build_query([
'user_token' => $userToken,
'amount' => $amount,
'order_id' => $orderID,
'redirect_url' => $redirectURL
]);
$requestURL = $endpointURL . '?' . $queryParams;


$curl = curl_init();


curl_setopt_array($curl, [
CURLOPT_URL => $requestURL,
CURLOPT_RETURNTRANSFER => true,
CURLOPT_FOLLOWLOCATION => true,
]);


$response = curl_exec($curl);


if ($response === false) {

$errorMessage = curl_error($curl);
echo 'cURL Error: ' . $errorMessage;
} else {

curl_close($curl);
setcookie('payment_success', $response, time() + (15 * 60)); // Cookie will expire in 15 minutes


$responseData = json_decode($response, true);


if ($responseData === null) {

  echo 'JSON decoding error';
} else {

  if (isset($responseData['payment_link'])) {

      $paymentLink = $responseData['payment_link'];
  $icid = $responseData['gateway_txn'];

$insert = $conn->prepare("INSERT INTO payments SET client_id=:c_id, payment_amount=:amount, payment_privatecode=:code, payment_method=:method, payment_mode=:mode, payment_create_date=:date, payment_ip=:ip, payment_extra=:extra");
             $insert->execute(array("c_id" => $user['client_id'], "amount" => $amount, "code" => $paymentCode, "method" => $method_id, "mode" => "Automatic", "date" => date("Y.m.d H:i:s"), "ip" => GetIP(), "extra" =>  $icid));
             

      header('Location: ' . $paymentLink);
      exit();
  } else {

      echo 'Payment link not found in the response';
  }
}
}



            elseif ($method_id == 2):
                unset($_SESSION["data"]);
                $icid = md5(rand(1,999999));
                $getcur = $extra['currency'];
                $lastcur = isset($currentcur->error) ? defined($getcur.'_') ? constant($getcur.'_') : die('There\'s a problem with currency. Please contact with admin.') : $currentcur->rates->$getcur;
                $insert = $conn->prepare("INSERT INTO payments SET client_id=:c_id, payment_amount=:amount, payment_privatecode=:code, payment_method=:method, payment_mode=:mode, payment_create_date=:date, payment_ip=:ip, payment_extra=:extra");
                $insert = $insert->execute(array("c_id" => $user['client_id'], "amount" => $amount, "code" => $paymentCode, "method" => $method_id, "mode" => "Auto", "date" => date("Y.m.d H:i:s"), "ip" => GetIP(), "extra" => $icid));
                if ($insert):
                    $success = 1;
                    $successText = "Your payment was initiated successfully, you are being redirected..";
                    $payment_url = site_url('lib/stripe/index.php');
                else:
                    $error = 1;
                    $errorText = "There was an error starting your payment, please try again later..";
                endif;
            elseif ($method_id == 8):
               $amount = (double) $amount;

        $web_id = $extra['merchant_id'];

        // $users = session('user_current_info');
        $order_id = strtotime(NOW);
        $cashmaal = array(
            'amount'      => $amount,
            'email'       => $user['email'],
            'web_id'      => $web_id,
            // 'success_url'    => site_url('payment/coinpayments'),
            'success_url' => site_url('payment/coinpayments'),
            'cancel_url'  => site_url('/'),
            'order_id'    => $order_id,

            'memo'        => "Balance recharge - " . $user['email'],

        );

        $_SESSION['coinpayment'] = ['user_id' => $user['client_id'], 'order_id' => $order_id];
//  var_dump($cashmaal);
        //  exit();

        $insert = $conn->prepare("INSERT INTO payments SET client_id=:c_id, payment_amount=:amount, payment_privatecode=:code, payment_method=:method, payment_mode=:mode, payment_create_date=:date, payment_ip=:ip, payment_extra=:extra");
        $insert->execute(array("c_id" => $user['client_id'], "amount" => $amount, "code" => $paymentCode, "method" => $method_id, "mode" => "", "date" => date("Y.m.d H:i:s"), "ip" => GetIP(), "extra" => $order_id));
        $success     = 1;
        $successText = "Your payment was initiated successfully, you are being redirected..";

        echo '<div class="dimmer active" style="min-height: 400px;">
          <div class="loader"></div>
          <div class="dimmer-content">
            <center><h2>Please do not refresh this page</h2></center>
            <svg xmlns="http://www.w3.org/2000/svg" xmlns:xlink="http://www.w3.org/1999/xlink" style="margin:auto;background:#fff;display:block;" width="200px" height="200px" viewBox="0 0 100 100" preserveAspectRatio="xMidYMid">
              <circle cx="50" cy="50" r="32" stroke-width="8" stroke="#e15b64" stroke-dasharray="50.26548245743669 50.26548245743669" fill="none" stroke-linecap="round">
                <animateTransform attributeName="transform" type="rotate" dur="1s" repeatCount="indefinite" keyTimes="0;1" values="0 50 50;360 50 50"></animateTransform>
              </circle>
              <circle cx="50" cy="50" r="23" stroke-width="8" stroke="#f8b26a" stroke-dasharray="36.12831551628262 36.12831551628262" stroke-dashoffset="36.12831551628262" fill="none" stroke-linecap="round">
                <animateTransform attributeName="transform" type="rotate" dur="1s" repeatCount="indefinite" keyTimes="0;1" values="0 50 50;-360 50 50"></animateTransform>
              </circle>
            </svg>
            <form action="https://www.coinpayments.net/index.php" id="cashmaal" method="post" id="coinPayForm">

             <input type="hidden" name="item_name" value="Deposit">

            <input type="hidden" name="merchant" value="' . $cashmaal["web_id"] . '">


        <input type="hidden" name="currency" value="USD">
        <input type="hidden" name="amountf" value="' . $cashmaal["amount"] . '">
        <input type="hidden" name="ipn_url" value="https://viralsmmpanel.com/payment/coinpayments">
        <input type="hidden" name="success_url" value="' . $cashmaal["success_url"] . '">
        <input type="hidden" name="cancel_url" value="' . $cashmaal["cancel_url"] . '">
        <input type="hidden" name="buyer_name" value="' . $user['firstame'] . ' ">
        <input type="hidden" name="buyer_email" value="' . $cashmaal["email"] . '">
        <input type="hidden" name="custom" value="' . $cashmaal["order_id"] . '">
        <input type="hidden" name="cmd" value="_pay">
        <input type="hidden" name="want_shipping" value="0">
              <script type="text/javascript">
                document.getElementById("cashmaal").submit();
              </script>
            </form>
          </div>
        </div>';
            elseif ($method_id == 9):
                require_once("pswlicence/2checkout/2checkout-php/lib/Twocheckout.php");
                Twocheckout::privateKey($extra['private_key']);
                Twocheckout::sellerId($extra['seller_id']);

                // If you want to turn off SSL verification (Please don't do this in your production environment)
                Twocheckout::verifySSL(false);  // this is set to true by default

                // To use your sandbox account set sandbox to true
                Twocheckout::sandbox(false);

                // All methods return an Array by default or you can set the format to 'json' to get a JSON response.
                Twocheckout::format('json');

                $icid = md5(rand(1,999999));
                $getcur = $extra['currency'];
                $lastcur = isset($currentcur->error) ? defined($getcur.'_') ? constant($getcur.'_') : die('There\'s a problem with currency. Please contact with admin.') : $currentcur->rates->$getcur;
                $tc_amount = str_replace(',', '.', $amount_fee);
                $params = array(
                    'sid' => $icid,
                    'mode' => '2CO',
                    'li_0_name' => 'Add Balance',
                    'li_0_price' => number_format($tc_amount * $lastcur, 2, '.', '')
                );

                unset($_SESSION["data"]);
                $insert = $conn->prepare("INSERT INTO payments SET client_id=:c_id, payment_amount=:amount, payment_privatecode=:code, payment_method=:method, payment_mode=:mode, payment_create_date=:date, payment_ip=:ip, payment_extra=:extra");
                $insert->execute(array("c_id" => $user['client_id'], "amount" => $amount, "code" => $paymentCode, "method" => $method_id, "mode" => "Auto", "date" => date("Y.m.d H:i:s"), "ip" => GetIP(), "extra" => $icid));
                $success = 1;
                $successText = "Your payment was initiated successfully, you are being redirected..";
                Twocheckout_Charge::form($params, 'auto');
            elseif ($method_id == 11):
                $mollie = new MollieApiClient();
                $mollie->setApiKey($extra['live_api_key']);

                $icid = md5(rand(1,999999));
                $getcur = $extra['currency'];
                $lastcur = isset($currentcur->error) ? defined($getcur.'_') ? constant($getcur.'_') : die('There\'s a problem with currency. Please contact with admin.') : $currentcur->rates->$getcur;
                $ml_amount = str_replace(',', '.', $amount_fee);
                $payment = $mollie->payments->create([
                    "amount" => [
                        "currency" => $extra['currency'],
                        "value" => number_format($ml_amount * $lastcur, 2, '.', '')
                    ],
                    "description" => $user["email"],
                    "redirectUrl" => site_url(),
                    "webhookUrl" => site_url('payment/mollie'),
                    "metadata" => [
                        "order_id" => $icid,
                    ],
                ]);

                unset($_SESSION["data"]);
                $insert = $conn->prepare("INSERT INTO payments SET client_id=:c_id, payment_amount=:amount, payment_privatecode=:code, payment_method=:method, payment_mode=:mode, payment_create_date=:date, payment_ip=:ip, payment_extra=:extra");
                $insert->execute(array("c_id" => $user['client_id'], "amount" => $amount, "code" => $paymentCode, "method" => $method_id, "mode" => "Auto", "date" => date("Y.m.d H:i:s"), "ip" => GetIP(), "extra" => $icid));
                $success = 1;
                $successText = "Your payment was initiated successfully, you are being redirected..";
                $payment_url = $payment->getCheckoutUrl();
			
			
			
			
			elseif ($method_id == 32):
			
			
			
			
        $amount = (double)$amount;

       
        
       // $users = session('user_current_info');
        // $order_id = strtotime(NOW);
   
  
    
    $insert = $conn->prepare("INSERT INTO payments SET client_id=:c_id, payment_amount=:amount, payment_privatecode=:code, payment_method=:method, payment_mode=:mode, payment_create_date=:date, payment_ip=:ip, payment_extra=:extra");
          $insert->execute(array("c_id" => $user['client_id'], "amount" => $amount, "code" => $paymentCode, "method" => $method_id, "mode" => "", "date" => date("Y.m.d H:i:s"), "ip" => GetIP(), "extra" => $order_id));
          $success = 1;
          $successText = "Your payment was initiated successfully, you are being redirected..";
    
        $data = [
             "redirect_url"=> "https://webhook.site/8c16529b-dab9-4a62-af0e-ea759d1f7abf",
            "business_name" => "SMMFRONT", 
            "customer_email" => $user['email'], 
            "customer_name" => $user['client_id'].','.$paymentCode.','.$method_id.','.$order_id, 
            "local_price" => [
                  "amount" => $amount, 
                  "currency" => "USD" 
               ], 
            "memo" => "Balance recharge - ".  $user['email'] 
         ];  
         $fields_string = json_encode($data);
$ch = curl_init();

curl_setopt($ch, CURLOPT_URL, 'https://api.commerce.coinbase.com/invoices');
curl_setopt($ch, CURLOPT_RETURNTRANSFER, 1);
curl_setopt($ch, CURLOPT_POST, 1);
curl_setopt($ch, CURLOPT_POSTFIELDS, $fields_string);

$headers = array();
$headers[] = 'Content-Type: application/json';
$headers[] = 'X-Cc-Api-Key: '.$extra['api_key'];
$headers[] = 'X-Cc-Version: 2018-03-22';
curl_setopt($ch, CURLOPT_HTTPHEADER, $headers);

$result = curl_exec($ch);
if (curl_errno($ch)) {
    echo 'Error:' . curl_error($ch);
}
curl_close($ch);

   
$result=json_decode($result);
header('location:'.$result->data->hosted_url);
			
			
			
			elseif ($method_id == 33):
                    
    $amount = (double)$amount;

      $web_id = $extra['purse'];
      
     // $users = session('user_current_info');
      $order_id = strtotime(NOW);
      $webmoney = array(
        'amount'   => $amount,
        'email'    => $user['email'],
        'web_id'   => $web_id,
        'success_url'    => site_url('payment/Webmoney'),
        // 'success_url'=>"	https://webhook.site/8c16529b-dab9-4a62-af0e-ea759d1f7abf",
        'cancel_url'     => site_url('/'),
        'order_id'     => $order_id,
      
        'memo'            => "Balance recharge - ".  $user['email'],

      );
//  var_dump($cashmaal);
//  exit();
  
  $insert = $conn->prepare("INSERT INTO payments SET client_id=:c_id, payment_amount=:amount, payment_privatecode=:code, payment_method=:method, payment_mode=:mode, payment_create_date=:date, payment_ip=:ip, payment_extra=:extra");
        $insert->execute(array("c_id" => $user['client_id'], "amount" => $amount, "code" => $paymentCode, "method" => $method_id, "mode" => "", "date" => date("Y.m.d H:i:s"), "ip" => GetIP(), "extra" => $order_id));
        $success = 1;
        $successText = "Your payment was initiated successfully, you are being redirected..";
  
  

     echo '<div class="dimmer active" style="min-height: 400px;">
      <div class="loader"></div>
      <div class="dimmer-content">
        <center><h2>Please do not refresh this page</h2></center>
        <svg xmlns="http://www.w3.org/2000/svg" xmlns:xlink="http://www.w3.org/1999/xlink" style="margin:auto;background:#fff;display:block;" width="200px" height="200px" viewBox="0 0 100 100" preserveAspectRatio="xMidYMid">
          <circle cx="50" cy="50" r="32" stroke-width="8" stroke="#e15b64" stroke-dasharray="50.26548245743669 50.26548245743669" fill="none" stroke-linecap="round">
            <animateTransform attributeName="transform" type="rotate" dur="1s" repeatCount="indefinite" keyTimes="0;1" values="0 50 50;360 50 50"></animateTransform>
          </circle>
          <circle cx="50" cy="50" r="23" stroke-width="8" stroke="#f8b26a" stroke-dasharray="36.12831551628262 36.12831551628262" stroke-dashoffset="36.12831551628262" fill="none" stroke-linecap="round">
            <animateTransform attributeName="transform" type="rotate" dur="1s" repeatCount="indefinite" keyTimes="0;1" values="0 50 50;-360 50 50"></animateTransform>
          </circle>
        </svg>
        <form id=pay name=pay method="POST" action="https://merchant.wmtransfer.com/lmi/payment.asp">
            <input type="hidden" name="LMI_PAYMENT_AMOUNT" value="'.$amount.'">
            <input type="hidden" name="LMI_PAYMENT_DESC" value="'.$webmoney["memo"].'">
            <input type="hidden" name="LMI_PAYMENT_NO" value="1">
            <input type="hidden" name="LMI_PAYEE_PURSE" value="'.$web_id.'">
            <input type="hidden" name="LMI_SIM_MODE" value="0">
           
            <input type="hidden" name="LMI_SUCCESS_URL" value="'.site_url('payment/Webmoney').'">
            <input type="hidden" name="LMI_SUCCESS_METHOD" value="1">
            <input type="hidden" name="LMI_FAIL_URL" value="'.site_url().'">
            <input type="hidden" name="LMI_FAIL_METHOD" value="2">
        
            <input type="hidden" name="FIELD_1" value="'.$user["user_id"].'">
            <input type="hidden" name="FIELD_2" value="'. $order_id.'">
            

          <script type="text/javascript">
            document.getElementById("pay").submit();
          </script>
        </form>
      </div>
    </div>';




       elseif ($method_id == 34):
             
        // Project Data
        $amount=(double)$amount;
        $domain = 'unitpay.money'; // Your working domain: unitpay.money or unitpay.ru
        $secretKey  = $extra['secret_key'];
        $publicId   =$extra['reg_email'];
        
        $hash = $_SERVER['HTTP_USER_AGENT'] . $_SERVER['REMOTE_ADDR'].time().rand();   
     
        $orderId        = sha1($data).'-'.$user['client_id'].'-'.$method_id; 
        $order_id=$orderId;
        $_SESSION["unitpay_order_id"] = $order_id;
        $insert = $conn->prepare("INSERT INTO payments SET client_id=:c_id, payment_amount=:amount, payment_privatecode=:code, payment_method=:method, payment_mode=:mode, payment_create_date=:date, payment_ip=:ip, payment_extra=:extra");
        $insert->execute(array("c_id" => $user['client_id'], "amount" => $amount, "code" => $paymentCode, "method" => $method_id, "mode" => "", "date" => date("Y.m.d H:i:s"), "ip" => GetIP(), "extra" => $order_id));
        $success = 1;
        $successText = "Your payment was initiated successfully, you are being redirected..";
      
        include (dirname(dirname(__DIR__)).'/UnitPay.php');
   
        
        // My item Info
        $itemName = 'Recharge Balance';
        
        // My Order Data

        $hash = $_SERVER['HTTP_USER_AGENT'] . $_SERVER['REMOTE_ADDR'].time().rand();   
     
        $orderId        = sha1($data); 
        $orderSum       = $amount;
        $orderDesc      = 'Payment for item "' . $itemName . '"';
        $orderCurrency  = 'USD';
        
        $unitPay = new UnitPay($domain, $secretKey);
        
        $unitPay
            ->setBackUrl(site_url('payment/UnitPay'))
            ->setCustomerEmail($user['email'])
            ->setCustomerPhone($user['phone'])
            ->setCashItems(array(
               new CashItem($itemName, 1, $orderSum) 
            ));
     
        $redirectUrl = $unitPay->form(
            $publicId,
            $orderSum,
            $orderId,
            $orderDesc,
            $orderCurrency
        );
        
        header("Location: " . $redirectUrl);
        
        
			
			
            elseif ($method_id == 12):
                require_once("lib/encdec_paytm.php");

                $checkSum = "";
                $paramList = array();

                $amount_fee = $amount_fee;

                $icid = md5(rand(1,999999));
                $getcur = $extra['currency'];
                // $lastcur = isset($currentcur->error) ? defined($getcur.'_') ? constant($getcur.'_') : die('There\'s a problem with currency. Please contact with admin.') : $currentcur->rates->$getcur;
                
                
                
                $ptm_amount = str_replace(',', '.', $amount_fee);

                $paramList["MID"] = $extra['merchant_mid'];
                $paramList["ORDER_ID"] = $icid;
                $paramList["CUST_ID"] = $user['client_id'];
                $paramList["EMAIL"] = $user['email'];
                $paramList["INDUSTRY_TYPE_ID"] = "Retail";
                $paramList["CHANNEL_ID"] = "WEB";
                $paramList["TXN_AMOUNT"] = number_format($ptm_amount , 2, '.', '');
                $paramList["WEBSITE"] = $extra['merchant_website'];
                $paramList["CALLBACK_URL"] = site_url('payment/paytm');

                $checkSum = getChecksumFromArray($paramList, $extra['merchant_key']);

                unset($_SESSION["data"]);
                $insert = $conn->prepare("INSERT INTO payments SET client_id=:c_id, payment_amount=:amount, payment_privatecode=:code, payment_method=:method, payment_mode=:mode, payment_create_date=:date, payment_ip=:ip, payment_extra=:extra");
                $insert->execute(array("c_id" => $user['client_id'], "amount" => $amount/$settings['inr_value'], "code" => $paymentCode, "method" => $method_id, "mode" => "Auto", "date" => date("Y.m.d H:i:s"), "ip" => GetIP(), "extra" => $icid));
                $success = 1;
                $successText = "Your payment was initiated successfully, you are being redirected..";
                echo '<form method="post" action="https://securegw.paytm.in/theia/processTransaction" name="f1">
                    <table border="1">
                        <tbody>';
                        foreach($paramList as $name => $value) {
                            echo '<input type="hidden" name="' . $name .'" value="' . $value . '">';
                        }
                        echo '<input type="hidden" name="CHECKSUMHASH" value="'. $checkSum .'">
                        </tbody>
                    </table>
                    <script type="text/javascript">
                        document.f1.submit();
                    </script>
                </form>';
            elseif ($method_id == 13):
                unset($_SESSION["data"]);
                $im_amount_fee = str_replace(',', '.', $amount_fee);
                $icid = md5(rand(1,999999));
                $getcur = $extra['currency'];
                $lastcur = isset($currentcur->error) ? defined($getcur.'_') ? constant($getcur.'_') : die('There\'s a problem with currency. Please contact with admin.') : $currentcur->rates->$getcur;
                $getamo = number_format($im_amount_fee * $lastcur, 2, '.', '');
                $jsondata = json_encode(array('c' => $getcur, 'a' => $getamo));
                
                $insert = $conn->prepare("INSERT INTO payments SET client_id=:c_id, payment_amount=:amount, payment_privatecode=:code, payment_method=:method, payment_mode=:mode, payment_create_date=:date, payment_ip=:ip, payment_extra=:extra, data=:data");
                $insert->execute(array("c_id" => $user['client_id'], "amount" => $amount, "code" => $paymentCode, "method" => $method_id, "mode" => "Auto", "date" => date("Y.m.d H:i:s"), "ip" => GetIP(), "extra" => $icid, "data" => $jsondata));
                if ($insert):
                    $success = 1;
                    $successText = "Your payment was initiated successfully, you are being redirected..";
                    $payment_url = site_url('lib/pay/instamojo-payment.php?hash='.$icid);
                else:
                    $error = 1;
                    $errorText = "There was an error starting your payment, please try again later..";
                endif;
            elseif ($method_id == 31):
                    
                    $amount = (double)$amount;
                
                    $client_id = $extra['usd'];
                    
                   // $users = session('user_current_info');
                    $order_id = strtotime('NOW');
                    $perfectmoney = array(
                        'PAYEE_ACCOUNT' 	=> $client_id,
                        'PAYEE_NAME' 		=> $extra['merchant_website'],
                        'PAYMENT_UNITS' 	=> "USD",
                        'STATUS_URL' 		=> site_url('payment/perfectmoney'),
                        'PAYMENT_URL' 		=> site_url('payment/perfectmoney'),
                        'NOPAYMENT_URL' 	=> site_url('payment/perfectmoney'),
                        'BAGGAGE_FIELDS' 	=> 'IDENT',
                        'ORDER_NUM' 		=> $order_id,
                        'PAYMENT_ID' 		=> strtotime('NOW'),
                        'CUST_NUM' 		    => "USERID" . rand(10000,99999999),
                        'memo' 		        => "Balance recharge - ".  $user['email'],
        
                    );
                    $tnx_id = $perfectmoney['PAYMENT_ID'];
                    
                    $insert = $conn->prepare("INSERT INTO payments SET client_id=:c_id, payment_amount=:amount, payment_privatecode=:code, payment_method=:method, payment_mode=:mode, payment_create_date=:date, payment_ip=:ip, payment_extra=:extra");
                    $insert->execute(array("c_id" => $user['client_id'], "amount" => $amount, "code" => $paymentCode, "method" => $method_id, "mode" => "Auto", "date" => date("Y.m.d H:i:s"), "ip" => GetIP(), "extra" => $tnx_id));
                    $success = 1;
                    $successText = "Your payment was initiated successfully, you are being redirected..";
                    
                    
                
                 echo '<div class="dimmer active" style="min-height: 400px;">
                  <div class="loader"></div>
                  <div class="dimmer-content">
                    <center><h2>Please do not refresh this page</h2></center>
                    <svg xmlns="http://www.w3.org/2000/svg" xmlns:xlink="http://www.w3.org/1999/xlink" style="margin:auto;background:#fff;display:block;" width="200px" height="200px" viewBox="0 0 100 100" preserveAspectRatio="xMidYMid">
                      <circle cx="50" cy="50" r="32" stroke-width="8" stroke="#e15b64" stroke-dasharray="50.26548245743669 50.26548245743669" fill="none" stroke-linecap="round">
                        <animateTransform attributeName="transform" type="rotate" dur="1s" repeatCount="indefinite" keyTimes="0;1" values="0 50 50;360 50 50"></animateTransform>
                      </circle>
                      <circle cx="50" cy="50" r="23" stroke-width="8" stroke="#f8b26a" stroke-dasharray="36.12831551628262 36.12831551628262" stroke-dashoffset="36.12831551628262" fill="none" stroke-linecap="round">
                        <animateTransform attributeName="transform" type="rotate" dur="1s" repeatCount="indefinite" keyTimes="0;1" values="0 50 50;-360 50 50"></animateTransform>
                      </circle>
                    </svg>
                    <form method="post" action="https://perfectmoney.is/api/step1.asp" id="redirection_form">
                      <input type="hidden" name="PAYMENT_AMOUNT" value="'.$amount.'">
                      <input type="hidden" name="PAYEE_ACCOUNT" value="'.$perfectmoney["PAYEE_ACCOUNT"].'">
                      <input type="hidden" name="PAYEE_NAME" value="'.$perfectmoney["PAYEE_NAME"].'">
                      <input type="hidden" name="PAYMENT_UNITS" value="'.$perfectmoney["PAYMENT_UNITS"].'">
                      <input type="hidden" name="STATUS_URL" value="'.$perfectmoney["STATUS_URL"].'">
                      <input type="hidden" name="PAYMENT_URL" value="'.$perfectmoney["PAYMENT_URL"].'">
                      <input type="hidden" name="NOPAYMENT_URL" value="'.$perfectmoney["NOPAYMENT_URL"].'">
                      <input type="hidden" name="BAGGAGE_FIELDS" value="'.$perfectmoney["BAGGAGE_FIELDS"].'">
                      <input type="hidden" name="ORDER_NUM" value="'.$perfectmoney["ORDER_NUM"].'">
                      <input type="hidden" name="CUST_NUM" value="'.$perfectmoney["CUST_NUM"].'">
                      <input type="hidden" name="PAYMENT_ID" value="'.$perfectmoney["PAYMENT_ID"].'>
                      <input type="hidden" name="PAYMENT_URL_METHOD" value="POST">
                      <input type="hidden" name="NOPAYMENT_URL_METHOD" value="POST">
                      <input type="hidden" name="SUGGESTED_MEMO" value="'.$perfectmoney["memo"].'">
                      <script type="text/javascript">
                        document.getElementById("redirection_form").submit();
                      </script>
                    </form>
                  </div>
                </div>';
            
        
            elseif ($method_id == 14):
                 require_once($_SERVER['DOCUMENT_ROOT']."/lib/paytm/encdec_paytm.php");
    
                    $icid = $paytmqr_orderid;
                    //$icid = "ORDS57382437";
    
                    $TXN_AMOUNT = $amount;
            
                    $responseParamList = array();

                	$requestParamList = array();

                	$requestParamList = array("MID" => $extra['merchant_mid'] , "ORDERID" => $icid);  
                	
                    if (!countRow(['table' => 'payments', 'where' => ['client_id' => $user['client_id'], 'payment_method' => 14, 'payment_status' => 3, 'payment_delivery' => 2, 'payment_extra' => $icid]]) &&
                	!countRow(['table' => 'payments', 'where' => ['payment_extra' => $icid]])) {
                        $responseParamList = getTxnStatusNew($requestParamList);

                        if($amount == $responseParamList["TXNAMOUNT"]) {
    
    
                            $insert = $conn->prepare("INSERT INTO payments SET client_id=:c_id, payment_amount=:amount, payment_privatecode=:code, payment_method=:method, payment_mode=:mode, payment_create_date=:date, payment_ip=:ip, payment_extra=:extra");
                            $insert->execute(array("c_id" => $user['client_id'], "amount" => $amount, "code" => $paymentCode, "method" => $method_id, "mode" => "Auto", "date" => date("Y.m.d H:i:s"), "ip" => GetIP(), "extra" => $icid));
                            $success = 1;
                            $successText = "Your payment was initiated successfully, you are being redirected..";
                            
                            echo '<form method="post" action="'.site_url('payment/paytmqr').'" name="f1">
                            		<table border="1">
                            			<tbody>';
                            			foreach($requestParamList as $name => $value) {
                            				echo '<input type="hidden" name="' .$name.'" value="' .$value .'">';
                            			}
                            			echo '</tbody>
                            			</table>
                            		<script type="text/javascript">
                            			document.f1.submit();
                            		</script>
                            	</form>';
                            	
                        }else{
                    	    $error = 1;
                            $errorText = "Amount is invalid";
                	    }
                        	
                	}else{
                	    $error = 1;
                        $errorText = "This transaction id is already used";
                	}
                    	
                    	
                    
            elseif ($method_id == 15):
                unset($_SESSION["data"]);
                $rp_amount_fee = str_replace(',', '.', $amount_fee);
                $icid = md5(rand(1,999999));
                $getcur = $extra['currency'];
                $lastcur = isset($currentcur->error) ? defined($getcur.'_') ? constant($getcur.'_') : die('There\'s a problem with currency. Please contact with admin.') : $currentcur->rates->$getcur;
                $getamo = number_format($rp_amount_fee * $lastcur, 2, '.', '');
                $jsondata = json_encode(array('c' => $getcur, 'a' => $getamo));
                
                $insert = $conn->prepare("INSERT INTO payments SET client_id=:c_id, payment_amount=:amount, payment_privatecode=:code, payment_method=:method, payment_mode=:mode, payment_create_date=:date, payment_ip=:ip, payment_extra=:extra, data=:data");
                $insert->execute(array("c_id" => $user['client_id'], "amount" => $amount, "code" => $paymentCode, "method" => $method_id, "mode" => "Auto", "date" => date("Y.m.d H:i:s"), "ip" => GetIP(), "extra" => $icid, "data" => $jsondata));
                if ($insert):
                    $success = 1;
                    $successText = "Your payment was initiated successfully, you are being redirected..";
                    $payment_url = site_url('lib/pay/razorpay-payment.php?hash='.$icid);
                else:
                    $error = 1;
                    $errorText = "There was an error starting your payment, please try again later..";
                endif;
            elseif ($method_id == 16):
                unset($_SESSION["data"]);
                $ic_amount_fee = str_replace(',', '.', $amount_fee);
                $icid = md5(rand(1,999999));
                $getcur = $extra['currency'];
                $lastcur = isset($currentcur->error) ? defined($getcur.'_') ? constant($getcur.'_') : die('There\'s a problem with currency. Please contact with admin.') : $currentcur->rates->$getcur;
                $getamo = number_format($ic_amount_fee * $lastcur, 2, '.', '');
                $jsondata = json_encode(array('c' => $getcur, 'a' => $getamo));
                
                $insert = $conn->prepare("INSERT INTO payments SET client_id=:c_id, payment_amount=:amount, payment_privatecode=:code, payment_method=:method, payment_mode=:mode, payment_create_date=:date, payment_ip=:ip, payment_extra=:extra, data=:data");
                $insert->execute(array("c_id" => $user['client_id'], "amount" => $amount, "code" => $paymentCode, "method" => $method_id, "mode" => "Auto", "date" => date("Y.m.d H:i:s"), "ip" => GetIP(), "extra" => $icid, "data" => $jsondata));
                if ($insert):
                    $success = 1;
                    $successText = "Your payment was initiated successfully, you are being redirected..";
                    $payment_url = site_url('lib/pay/iyzico-payment.php?hash='.$icid);
                else:
                    $error = 1;
                    $errorText = "There was an error starting your payment, please try again later..";
                endif;
            elseif ($method_id == 17):
                unset($_SESSION["data"]);
                $ae_amount_fee = str_replace(',', '.', $amount_fee);
                $icid = md5(rand(1,999999));
                $getcur = $extra['currency'];
                $lastcur = isset($currentcur->error) ? defined($getcur.'_') ? constant($getcur.'_') : die('There\'s a problem with currency. Please contact with admin.') : $currentcur->rates->$getcur;
                $getamo = number_format($ae_amount_fee * $lastcur, 2, '.', '');
                $jsondata = json_encode(array('c' => $getcur, 'a' => $getamo));
                
                $insert = $conn->prepare("INSERT INTO payments SET client_id=:c_id, payment_amount=:amount, payment_privatecode=:code, payment_method=:method, payment_mode=:mode, payment_create_date=:date, payment_ip=:ip, payment_extra=:extra, data=:data");
                $insert->execute(array("c_id" => $user['client_id'], "amount" => $amount, "code" => $paymentCode, "method" => $method_id, "mode" => "Auto", "date" => date("Y.m.d H:i:s"), "ip" => GetIP(), "extra" => $icid, "data" => $jsondata));
                if ($insert):
                    $success = 1;
                    $successText = "Your payment was initiated successfully, you are being redirected..";
                    $payment_url = site_url('lib/pay/authorize-net-payment.php?hash='.$icid);
                else:
                    $error = 1;
                    $errorText = "There was an error starting your payment, please try again later..";
                endif;
            elseif ($method_id == 18):
                unset($_SESSION["data"]);
                $mp_amount_fee = str_replace(',', '.', $amount_fee);
                $icid = md5(rand(1,999999));
                $getcur = $extra['currency'];
$unit_price = $amount;
                $lastcur = isset($currentcur->error) ? defined($getcur.'_') ? constant($getcur.'_') : die('There\'s a problem with currency. Please contact with admin.') : $currentcur->rates->$getcur;
                $getamo = number_format($mp_amount_fee * $lastcur, 2, '.', '');
                $jsondata = json_encode(array('c' => $getcur, 'a' => $getamo));
                
                $insert = $conn->prepare("INSERT INTO payments SET client_id=:c_id, payment_amount=:amount, payment_privatecode=:code, payment_method=:method, payment_mode=:mode, payment_create_date=:date, payment_ip=:ip, payment_extra=:extra, data=:data");
                $insert->execute(array("c_id" => $user['client_id'], "amount" => $amount, "code" => $paymentCode, "method" => $method_id, "mode" => "Auto", "date" => date("Y.m.d H:i:s"), "ip" => GetIP(), "extra" => $icid, "data" => $jsondata));
                if ($insert):
                    $success = 1;
                    $successText = "Your payment was initiated successfully, you are being redirected..";
                    $payment_url = site_url('lib/pay/mercadopago-payment.php?hash='.$icid);
                else:
                    $error = 1;
                    $errorText = "There was an error starting your payment, please try again later..";
                endif;
            elseif ($method_id == 19):

                
                
                
                unset($_SESSION["data"]);
                $pm_amount_fee = str_replace(',', '.', $amount_fee);
               
                $pm_amount_fee = $pm_amount_fee  * $settings["dolar_charge"];
                $merchant_key = $extra["merchant_key"];
                $salt_key = $extra["salt_key"];
                $icid1 = md5(rand(1,999999));
                $productinfo = "Digital-Services";
                $firstname = $user["name"];
                $email = $user["email"];
                $udf1 = "abc";
                $udf2 = "def";
                $udf3 = "ghi";
                $udf4 = "jkl";
                $udf5 = "mno";
               
                $hash = $merchant_key .'|' . $icid1 .'|' . $pm_amount_fee .'|' . $productinfo .'|' . 
                $productinfo . '|' . $firstname .'|' . $email . '|'.  $udf1 .'|' . $udf2 . '|'. $udf3 . '|'. 
                $udf4 . '|'. $udf5 . '||||||'.  $salt_key;
                $icid = hash('sha512' , $hash);
             
                // exit();

                $getcur = $extra['currency'];
                // $lastcur = isset($currentcur->error) ? defined($getcur.'_') ? constant($getcur.'_') : die('There\'s a problem with currency. Please contact with admin.') : $currentcur->rates->$getcur;
                $getamo = number_format($pm_amount_fee, 2, '.', '');
                $fd = json_encode(array('c' => $getcur, 'a' => $getamo));
                
                $insert = $conn->prepare("INSERT INTO payments SET client_id=:c_id, payment_amount=:amount, payment_privatecode=:code, payment_method=:method, payment_mode=:mode, payment_create_date=:date, payment_ip=:ip, payment_extra=:extra, payment_extraa=:payment_extraaa");
                $insert->execute(array("c_id" => $user['client_id'], "amount" => $amount, "code" => $paymentCode, "method" => $method_id, "mode" => "Auto", "date" => date("Y.m.d H:i:s"), "ip" => GetIP(), "extra" => $icid, "payment_extraaa" => $fd));
                if ($insert):
                    $success = 1;
                    $successText = "Your payment was initiated successfully, you are being redirected..";
                    $payment_url = site_url('lib/pay/payumoney-payment.php?hash='.$icid);
                else:
                    $error = 1;
                    $errorText = "There was an error starting your payment, please try again later..";
                endif;
             elseif ($method_id == 22):
                unset($_SESSION["data"]);
                /*require_once("lib/encdec_paytm.php");*/
                $icid = md5(rand(1,999999));
                $getcur = $extra['currency'];
                $lastcur = 1;
                $ptm_amount = str_replace(',', '.', $amount_fee);
              
                $paramList = array();

                $paramList["amount"] = number_format($ptm_amount * $lastcur, 2, '.', '');
                $paramList["currency"] = $getcur;
                $paramList["succes_url"] = site_url('payment/cashmaal');
                $paramList["cancel_url"] = site_url('payment/cashmaal');
                $paramList["client_email"] = $user['email'];
                $paramList["web_id"] = $extra['web_id'];
                $paramList["order_id"] = $icid;
                unset($_SESSION["data"]);
                if($extra['web_id']==''):
                    $error = 1;
                    $errorText = "Admin has not configured this gateway yet..";
                else:
                    //haina
                    $insert = $conn->prepare("INSERT INTO payments SET client_id=:c_id, payment_amount=:amount, payment_privatecode=:code, payment_method=:method, payment_mode=:mode, payment_create_date=:date, payment_ip=:ip, payment_extra=:extra");
                    $insert->execute(array("c_id" => $user['client_id'], "amount" => $amount, "code" => $paymentCode, "method" => $method_id, "mode" => "Auto", "date" => date("Y.m.d H:i:s"), "ip" => GetIP(), "extra" => $icid));
                    if($insert):
                        $success = 1;
                        $successText = "Your payment was initiated successfully, you are being redirected..";
                        echo '<form method="post" action="https://www.cashmaal.com/Pay/" name="f2">
                        <table border="1">
                            <tbody>
                             <input type="hidden" name="pay_method" value="">';
                            foreach($paramList as $name => $value) {
                                echo '<input type="hidden" name="' . $name .'" value="' . $value . '">';
                            }
                            echo '<input type="hidden" name="addi_info" value="eg. John Domain renewal payment">';
                            echo '<center>Redirecting...<input type="hidden" name="Submit" value="Pay With Cash-Maal"></center>
                            </tbody>
                        </table>
                        <script type="text/javascript">
                            document.f2.submit();
                        </script>
                        </form>';
                        
                    else:
                        $error = 1;
                        $errorText = "There was an error starting your payment, please try again later..";
                
                    endif;
             
                endif;
            
            elseif ($method_id == 7):
                $merchant_id = $extra["merchant_id"];
                $merchant_key = $extra["merchant_key"];
                $merchant_salt = $extra["merchant_salt"];
                $email = $user["email"];
                $payment_amount = $amount_fee * 100;
                $merchant_oid = rand(9999,9999999);
                $user_name = $user["name"];
                $user_address = "Belirtilmemiş";
                $user_phone = $user["telephone"];
                $payment_type = "eft";
                $user_ip = GetIP();
                $timeout_limit = "360";
                $debug_on = 1;
                $test_mode = 0;
                $no_installment = 0;
                $max_installment = 0;
                $hash_str = $merchant_id . $user_ip . $merchant_oid . $email . $payment_amount . $payment_type . $test_mode;
                $paytr_token = base64_encode(hash_hmac('sha256', $hash_str . $merchant_salt, $merchant_key, true));
                $post_vals = array('merchant_id' => $merchant_id, 'user_ip' => $user_ip, 'merchant_oid' => $merchant_oid, 'email' => $email, 'payment_amount' => $payment_amount, 'payment_type' => $payment_type, 'paytr_token' => $paytr_token, 'debug_on' => $debug_on, 'timeout_limit' => $timeout_limit, 'test_mode' => $test_mode);
                $ch = curl_init();
                curl_setopt($ch, CURLOPT_URL, "https://www.paytr.com/odeme/api/get-token");
                curl_setopt($ch, CURLOPT_RETURNTRANSFER, 1);
                curl_setopt($ch, CURLOPT_POST, 1);
                curl_setopt($ch, CURLOPT_POSTFIELDS, $post_vals);
                curl_setopt($ch, CURLOPT_SSL_VERIFYPEER, 0);
                curl_setopt($ch, CURLOPT_SSL_VERIFYHOST, 0);
                curl_setopt($ch, CURLOPT_FRESH_CONNECT, true);
                curl_setopt($ch, CURLOPT_TIMEOUT, 20);
                $result = @curl_exec($ch);
                if (curl_errno($ch)) die("PAYTR IFRAME connection error. err:" . curl_error($ch));
                curl_close($ch);
                $result = json_decode($result, 1);
                if ($result['status'] == 'success'):
                    unset($_SESSION["data"]);
                    $token = $result['token'];
                    $insert = $conn->prepare("INSERT INTO payments SET client_id=:c_id, payment_amount=:amount, payment_privatecode=:code, payment_method=:method, payment_mode=:mode, payment_create_date=:date, payment_ip=:ip, payment_extra=:extra");
                    $insert->execute(array("c_id" => $user["client_id"], "amount" => $amount, "code" => $paymentCode, "method" => $method_id, "mode" => "Auto", "date" => date("Y.m.d H:i:s"), "ip" => GetIP(), "extra" => $merchant_oid));
                    $success = 1;
                    $successText = "Your payment was initiated successfully, you are being redirected..";
                    $payment_url = "https://www.paytr.com/odeme/api/" . $token;
                else:
                    $error = 1;
                    $errorText = "There was an error starting your payment, please try again later..";
                endif;
            elseif ($method_id == 4):
                $getcur = $extra['currency'];
                $lastcur = isset($currentcur->error) ? defined($getcur.'_') ? constant($getcur.'_') : die('There\'s a problem with currency. Please contact with admin.') : $currentcur->rates->$getcur;
                $merchant_id = $extra["merchant_id"];
                $merchant_key = $extra["merchant_key"];
                $merchant_salt = $extra["merchant_salt"];
                $email = $user["email"];
                $payment_amount = $amount_fee * 100;
                $payment_amount = str_replace(',','',number_format($payment_amount * $lastcur));
                $merchant_oid = rand(9999,9999999);
                $user_name = $user["name"];
                $user_address = "Belirtilmemiş";
                $user_phone = $user["telephone"];
                $currency = $extra['currency'];
                $merchant_ok_url = URL;
                $merchant_fail_url = URL;
                $user_basket = base64_encode(json_encode(array(array($amount . " " . $currency . " Bakiye", $amount_fee, 1))));
                $user_ip = GetIP();
                $timeout_limit = "360";
                $debug_on = 1;
                $test_mode = 0;
                $no_installment = 0;
                $max_installment = 0;
                $hash_str = $merchant_id . $user_ip . $merchant_oid . $email . $payment_amount . $user_basket . $no_installment . $max_installment . $currency . $test_mode;
                $paytr_token = base64_encode(hash_hmac('sha256', $hash_str . $merchant_salt, $merchant_key, true));
                $post_vals = array('merchant_id' => $merchant_id, 'user_ip' => $user_ip, 'merchant_oid' => $merchant_oid, 'email' => $email, 'payment_amount' => $payment_amount, 'paytr_token' => $paytr_token, 'user_basket' => $user_basket, 'debug_on' => $debug_on, 'no_installment' => $no_installment, 'max_installment' => $max_installment, 'user_name' => $user_name, 'user_address' => $user_address, 'user_phone' => $user_phone, 'merchant_ok_url' => $merchant_ok_url, 'merchant_fail_url' => $merchant_fail_url, 'timeout_limit' => $timeout_limit, 'currency' => $currency, 'test_mode' => $test_mode);
                $ch = curl_init();
                curl_setopt($ch, CURLOPT_URL, "https://www.paytr.com/odeme/api/get-token");
                curl_setopt($ch, CURLOPT_RETURNTRANSFER, 1);
                curl_setopt($ch, CURLOPT_POST, 1);
                curl_setopt($ch, CURLOPT_POSTFIELDS, $post_vals);
                curl_setopt($ch, CURLOPT_SSL_VERIFYPEER, 0);
                curl_setopt($ch, CURLOPT_SSL_VERIFYHOST, 0);
                curl_setopt($ch, CURLOPT_FRESH_CONNECT, true);
                curl_setopt($ch, CURLOPT_TIMEOUT, 20);
                $result = @curl_exec($ch);
                if (curl_errno($ch)) die("PAYTR IFRAME connection error. err:" . curl_error($ch));
                curl_close($ch);
                $result = json_decode($result, 1);
                if ($result['status'] == 'success'):
                    unset($_SESSION["data"]);
                    $token = $result['token'];
                    $insert = $conn->prepare("INSERT INTO payments SET client_id=:c_id, payment_amount=:amount, payment_privatecode=:code, payment_method=:method, payment_mode=:mode, payment_create_date=:date, payment_ip=:ip, payment_extra=:extra");
                    $insert->execute(array("c_id" => $user["client_id"], "amount" => $amount, "code" => $paymentCode, "method" => $method_id, "mode" => "Auto", "date" => date("Y.m.d H:i:s"), "ip" => GetIP(), "extra" => $merchant_oid));
                    $success = 1;
                    $successText = "Your payment was initiated successfully, you are being redirected..";
                    $payment_url = "https://www.paytr.com/odeme/guvenli/" . $token;
                else:
                    $error = 1;
                    $errorText = "There was an error starting your payment, please try again later..";
                endif;
            elseif ($method_id == 5):
                $getcur = $extra['currency'];
                $lastcur = isset($currentcur->error) ? defined($getcur.'_') ? constant($getcur.'_') : die('There\'s a problem with currency. Please contact with admin.') : $currentcur->rates->$getcur;
                $payment_types = "";
                foreach ($extra["payment_type"] as $i => $v) {
                    $payment_types.= $v . ",";
                }
                $amount_fee = $amount_fee * 100;
                $amount_fee = number_format($amount_fee * $lastcur, 2, '.', '');
                $payment_types = substr($payment_types, 0, -1);
                $hashOlustur = base64_encode(hash_hmac('sha256', $user["email"] . "|" . $user["email"] . "|" . $user['client_id'] . $extra['apiKey'], $extra['apiSecret'], true));
                $postData = array('apiKey' => $extra['apiKey'], 'hash' => $hashOlustur, 'returnData' => $user["email"], 'userEmail' => $user["email"], 'userIPAddress' => GetIP(), 'userID' => $user["client_id"], 'proApi' => TRUE, 'productData' => ["name" => $amount . $settings['currency'] . " Tutarında Bakiye (" . $paymentCode . ")", "amount" => $amount_fee, "extraData" => $paymentCode, "paymentChannel" => $payment_types,
                "commissionType" => $extra["commissionType"]
                ]);
                $curl = curl_init();
                curl_setopt_array($curl, array(CURLOPT_URL => "http://api.paywant.com/gateway.php", CURLOPT_RETURNTRANSFER => true, CURLOPT_ENCODING => "", CURLOPT_MAXREDIRS => 10, CURLOPT_TIMEOUT => 30, CURLOPT_HTTP_VERSION => CURL_HTTP_VERSION_1_1, CURLOPT_CUSTOMREQUEST => "POST", CURLOPT_POSTFIELDS => http_build_query($postData),));
                $response = curl_exec($curl);
                $err = curl_error($curl);
                if (!$err):
                    $jsonDecode = json_decode($response, false);
                    if ($jsonDecode->Status == 100):
                        if (!strpos($jsonDecode->Message, "https")) $jsonDecode->Message = str_replace("http", "https", $jsonDecode->Message);
                        unset($_SESSION["data"]);
                        $insert = $conn->prepare("INSERT INTO payments SET client_id=:c_id, payment_amount=:amount, payment_privatecode=:code, payment_method=:method, payment_mode=:mode, payment_create_date=:date, payment_ip=:ip ");
                        $insert->execute(array("c_id" => $user["client_id"], "amount" => $amount, "code" => $paymentCode, "method" => $method_id, "mode" => "Auto", "date" => date("Y.m.d H:i:s"), "ip" => GetIP()));
                        $success = 1;
                        $successText = "Your payment was initiated successfully, you are being redirected..";
                        $payment_url = $jsonDecode->Message;
                    else:
                        //echo $response; // Dönen hatanın ne olduğunu bastır
                        $error = 1;
                        $errorText = "There was an error starting your payment, please try again later.." . $response;
                    endif;
                else:
                    $error = 1;
                    $errorText = "There was an error starting your payment, please try again later..";
                endif;
            elseif ($method_id == 3):
                if ($extra["processing_fee"]):
                    $amount_fee = $amount_fee + "0.49";
                endif;
                $getcur = $extra['currency'];
                $lastcur = isset($currentcur->error) ? defined($getcur.'_') ? constant($getcur.'_') : die('There\'s a problem with currency. Please contact with admin.') : $currentcur->rates->$getcur;
                $form_data = ["website_index" => $extra["website_index"], "apikey" => $extra["apiKey"], "apisecret" => $extra["apiSecret"], "item_name" => "Bakiye Ekleme", "order_id" => $paymentCode, "buyer_name" => $user["name"], "buyer_surname" => " ", "buyer_email" => $user["email"], "buyer_phone" => $user["telephone"], "city" => "NA", "billing_address" => "NA", "ucret" => number_format($amount_fee * $lastcur, 2, '.', '')];
                print_r(generate_shopier_form(json_decode(json_encode($form_data))));
                if ($_SESSION["data"]["payment_shopier"] == true):
                    $insert = $conn->prepare("INSERT INTO payments SET client_id=:c_id, payment_amount=:amount, payment_privatecode=:code, payment_method=:method, payment_mode=:mode, payment_create_date=:date, payment_ip=:ip ");
                    $insert->execute(array("c_id" => $user['client_id'], "amount" => $amount, "code" => $paymentCode, "method" => $method_id, "mode" => "Auto", "date" => date("Y.m.d H:i:s"), "ip" => GetIP()));
                    $success = 1;
                    $successText = "Your payment was initiated successfully, you are being redirected..";
                    $payment_url = $response;
                    unset($_SESSION["data"]);
                else:
                    $error = 1;
                    $errorText = "There was an error starting your payment, please try again later..";
                endif;
            endif;
        }
    endif;
    if ($payment_url):
        echo '<script>setInterval(function(){window.location="' . $payment_url . '"},2000)</script>';
    endif;