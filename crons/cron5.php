<?php

date_default_timezone_set("Asia/Kolkata");


// Define the base directory constant
define('SITE_ROOT', realpath(dirname(__FILE__)) . '/../');

// Securely include files using the SITE_ROOT constant
include SITE_ROOT . 'pages/dbFunctions.php';
include SITE_ROOT . 'auth/config.php';


// Fetch pending withdrawals
$query = "SELECT * FROM withdrawals WHERE status = 'pending'";
$result = mysqli_query($conn, $query);

while ($row = mysqli_fetch_assoc($result)) {
    $withdraw_id = $row['withdraw_id'];
    $user_id = $row['user_id'];
    $amount = $row['amount'];
    $bank_account_number = $row['bank_account_number'];
    $ifsc_code = $row['ifsc_code'];
    $created_at = $row['created_at'];

    // Generate signature
    // Function to generate the signature
    function generateSign(array $params, $secretkey)
    {
        ksort($params);
        $string = [];
        foreach ($params as $key => $value) {
            if ($key == 'sign' || $key == 'sign_type') continue; // Exclude 'sign' and 'sign_type'
            $string[] = $key . '=' . $value;
        }
        $signStr = implode('&', $string) . '&key=' . $secretkey;
    
        return md5($signStr);
    }
    // Payment request address
    $url = 'https://pay.sunpayonline.xyz/pay/transfer';
   
   $payoutcallbackurl = "https://{$_SERVER['SERVER_NAME']}/bytevip/payoutcallback";
    // API key
$apiKey = '5be13d529fba44e796164272b39927ed'; // Replace 'your_api_key' with your actual API key

// Fetch current date and time
$currentDateTime = date('Y-m-d H:i:s');

// Payment request parameters
$paymentParams = array(
    'mch_id' => '202000302',
    'mch_transferId' => $withdraw_id,
    'transfer_amount' => $amount,
    'apply_date' => date('Y-m-d H:i:s'), // Current time
    'bank_code' => 'IDPT0001', //fix for bank
    'receive_name' => 'aman bhai',
    'receive_account' => $bank_account_number,
    'remark' => $ifsc_code,  //ifsc
    'back_url'=> $payoutcallbackurl,
    'sign_type' => 'MD5', // Signature method
);

// Generate signature
$signature = generateSign($paymentParams, $apiKey);

// Add signature to parameters
$paymentParams['sign'] = $signature;

// Convert payment parameters to URL-encoded string
$encodedParams = http_build_query($paymentParams);

// cURL request
$ch = curl_init($url);
curl_setopt($ch, CURLOPT_POST, 1);
curl_setopt($ch, CURLOPT_POSTFIELDS, $encodedParams);
curl_setopt($ch, CURLOPT_RETURNTRANSFER, true);

// Execute cURL request
$response = curl_exec($ch);


    // Close cURL session
    curl_close($ch);
    



    // Check response
    $responseData = json_decode($response, true);
    if ($responseData['respCode'] == 'SUCCESS' && isset($responseData['tradeNo'])) {
        
        // Update status to 'processing'
        $update_query = "UPDATE withdrawals SET status = 'processing' WHERE withdraw_id = '$withdraw_id'";
        mysqli_query($conn, $update_query);
        
        // Fetch telegram_chat_id from users table
        $telegram_chat_id_query = "SELECT upiseva1bot FROM users WHERE id = '$user_id' AND telegram_subscribed = 'on'";
        $telegram_chat_id_result = mysqli_query($conn, $telegram_chat_id_query);
        if ($telegram_chat_id_row = mysqli_fetch_assoc($telegram_chat_id_result)) {
            $telegram_chat_id = $telegram_chat_id_row['upiseva1bot'];
            
            // Notification message
            $responseMessage = "Hello😊,\n\n";
            $responseMessage .= "🎉 Great news! Your payout request has been successfully received. 🎉\n\n";
            $responseMessage .= "Here are the details of your request:\n";
            $responseMessage .= "📦 **Withdraw ID**: $withdraw_id\n";
            $responseMessage .= "💵 **Amount**: ₹$amount\n";
            $responseMessage .= "🏦 **Bank Account Number**: $bank_account_number\n";
            $responseMessage .= "🔑 **IFSC Code**: $ifsc_code\n";
            $responseMessage .= "📅 **Request Date**: $created_at\n\n";
            $responseMessage .= "Your payout request is being processed and will be completed shortly. Thank you for your patience!";

            // Send notification to Telegram bot
            boltx_telegram_noti_bot($responseMessage, $telegram_chat_id);
        }
        // Echo payout request has been sent
        echo "Payout request for Withdraw ID: $withdraw_id has been sent.<br>";
    } else {
        // Payout failed, handle error
        echo "Error: " . $response;
    }

    // Close CURL
    curl_close($ch);
}

// Close database connection
mysqli_close($conn);
?>