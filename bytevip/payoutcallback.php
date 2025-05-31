<?php

// Define the base directory constant
define('SITE_ROOT', realpath(dirname(__FILE__)) . '/../');

// Securely include files using the SITE_ROOT constant
include SITE_ROOT . 'pages/dbFunctions.php';
include SITE_ROOT . 'auth/config.php';


// Function to generate the signature
function generateSign(array $params, $secretKey)
{
    ksort($params);
    $string = [];
    foreach ($params as $key => $value) {
        if ($key === 'sign' || $key === 'signType') continue;  // Skip 'sign' and 'signType'
        $string[] = $key . '=' . $value;
    }
    $signStr = implode('&', $string) . '&key=' . $secretKey;

    return md5($signStr);
}

// Use the actual POST array in a live environment
$params = $_POST;

// Get the API key from your configuration
$secretkey = 'ADxI7o2AEwVAZMZPGH8bzmPF6iKt9bFk'; // Replace with your actual secret key

// Generate the signature using specific POST parameters
$generatedSign = generateSign($params, $secretkey);

// Verify the signature
if (isset($params['sign']) && $params['sign'] === $generatedSign) {
    
    $order_no=$_POST['merTransferId'];
        $order_realityamount=$_POST['transferAmount'];
        $result=$_POST['tradeResult'];
        
     // Fetch the withdrawal record where status is 'processing'
    $query = "SELECT user_id, amount, bank_account_number, ifsc_code, created_at 
              FROM withdrawals 
              WHERE withdraw_id = '$order_no' AND status = 'processing'";
    $result_set = mysqli_query($conn, $query);

    if ($row = mysqli_fetch_assoc($result_set)) {
        $user_id = $row['user_id'];
        $amount = $row['amount'];
        $bank_account_number = $row['bank_account_number'];
        $ifsc_code = $row['ifsc_code'];
        $created_at = $row['created_at'];

        if ($result == 1 && $amount == $order_realityamount) {
            // Update status to 'completed'
            $update_query = "UPDATE withdrawals SET status = 'completed' WHERE withdraw_id = '$order_no'";
            mysqli_query($conn, $update_query);
        } elseif ($result == 2 && $order_realityamount==$amount) {
            // Update status to 'cancelled'
            $update_query = "UPDATE withdrawals SET status = 'cancelled' WHERE withdraw_id = '$order_no'";
            mysqli_query($conn, $update_query);

            // Fetch the user's Telegram chat ID if subscribed
            $telegram_chat_id_query = "SELECT telegram_chat_id FROM users WHERE id = '$user_id' AND telegram_subscribed = 'on'";
            $telegram_chat_id_result = mysqli_query($conn, $telegram_chat_id_query);
            if ($telegram_chat_id_row = mysqli_fetch_assoc($telegram_chat_id_result)) {
                $telegram_chat_id = $telegram_chat_id_row['upiseva1bot'];

                $responseMessage = "Hello😊,\n\n";
                $responseMessage .= "We are really sorry, your payout request has failed. Please check the details and try again.\n\n";
                $responseMessage .= "Here are the details of your request:\n";
                $responseMessage .= "📦 **Withdraw ID**: $order_no\n";
                $responseMessage .= "💵 **Amount**: ₹$amount\n";
                $responseMessage .= "🏦 **Bank Account Number**: $bank_account_number\n";
                $responseMessage .= "🔑 **IFSC Code**: $ifsc_code\n";
                $responseMessage .= "📅 **Request Date**: $created_at\n\n";
                $responseMessage .= "Thank you for your patience!";

                // Send notification to Telegram bot
                boltx_telegram_noti_bot($responseMessage, $telegram_chat_id);
            }
        }
    }
    

    
    // Signature is valid, log the successful callback
    //file_put_contents("payoutcallback.txt", print_r($params, true));
    echo "success";
    exit;
} else {
    // Signature is invalid, log the failed callback
    //file_put_contents("callback_failed.txt", print_r($params, true), FILE_APPEND);
    echo "Error: Signature verification failed.";
}

?>
