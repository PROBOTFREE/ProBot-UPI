<?php
//payment callback
// Set the default timezone to Asia/Kolkata
date_default_timezone_set('Asia/Kolkata');

// Define the base directory constant
define('SITE_ROOT', realpath(dirname(__FILE__)) . '/../');

// Securely include files using the SITE_ROOT constant
include SITE_ROOT . 'pages/dbFunctions.php';
include SITE_ROOT . 'auth/config.php';


function generateSignforcallback(array $params, $secretKey)
{
    ksort($params);
    $string = [];
    foreach ($params as $key => $value) {
        if ($key == 'sign') continue;
        $string[] = $key . '=' . $value;
    }
    $signStr = implode('&', $string) . '&key=' . $secretKey;

    return md5($signStr);
}

if ($_SERVER["REQUEST_METHOD"] === "POST") {
    // Define the specific POST parameters needed for generating the signature
    $params = array(
        'tradeResult' => $_POST['tradeResult'],
        'oriAmount' => $_POST['oriAmount'],
        'amount' => $_POST['amount'],
        'mchId' => $_POST['mchId'],
        'orderNo' => $_POST['orderNo'],
        'mchOrderNo' => $_POST['mchOrderNo'],
        'merRetMsg' => $_POST['merRetMsg'],
        'orderDate' => $_POST['orderDate']
    );

    // Get the API key from your configuration
    $apiKey = '5be13d529fba44e796164272b39927ed'; // Replace 'your_api_key' with your actual API key

    // Generate the signature using specific POST parameters
    $generatedSign = generateSignforcallback($params, $apiKey);

    // Verify the signature
    if (isset($_POST['sign']) && $_POST['sign'] === $generatedSign) {
        // Signature is valid
        
        // Check if the order status is not already SUCCESS
        $check_stmt = $conn->prepare("SELECT status, user_id FROM orders WHERE order_id = ?");
        $check_stmt->bind_param("s", $_POST['mchOrderNo']);
        $check_stmt->execute();
        $check_stmt->bind_result($status, $user_id);
        $check_stmt->fetch();
        $check_stmt->close();

        if ($status !== 'SUCCESS') {
            // Prepare and execute SQL query to update order status
            $stmt = $conn->prepare("SELECT amount FROM orders WHERE order_id = ? AND status = 'PENDING'");
            $stmt->bind_param("s", $_POST['mchOrderNo']);
            $stmt->execute();
            $stmt->store_result();

            // Check if the order exists and amount matches
            if ($stmt->num_rows > 0) {
                $stmt->bind_result($amount);
                $stmt->fetch();
                if ($amount == $_POST['amount'] && $_POST['tradeResult'] == 1) { //means success
                    // Update status to SUCCESS
                    $utr = rand(111111111111, 999999999999); // Generate random 12-digit number
                    $update_stmt = $conn->prepare("UPDATE orders SET status = 'SUCCESS', utr = ? WHERE order_id = ?");
                    $update_stmt->bind_param("ss", $utr, $_POST['mchOrderNo']);
                    $update_stmt->execute();
                   // echo "Order status updated successfully.";
                    
                    // Insert wallet transaction
            $current_date = date("Y-m-d H:i:s");
            $wallet_txnid = generateRandomWalletTxnID();
            $operation_type = "credit"; // Set operation_type to 'credit'
            $sql ="INSERT INTO wallet_transactions (user_id, wallet_txnid, date, type, amount, operation_type) VALUES (?, ?, ?, 'PayIn', ?, ?)";
            $stmt1 = $conn->prepare($sql);
            $stmt1->bind_param(
                "dssds",
                $user_id,
                $wallet_txnid,
                $current_date,
                $amount,
                $operation_type
            );

            $stmt1->execute();
            // Close the statement
            $stmt1->close(); 
                      
                      
                    // Update user's wallet balance
                    $update_wallet_stmt = $conn->prepare("UPDATE users SET wallet = wallet + ? WHERE id = ?");
                    $update_wallet_stmt->bind_param("di", $amount, $user_id);
                    $update_wallet_stmt->execute();
                    //echo "User's wallet balance updated successfully.";
                } else {
                    echo "Error: Amount or trade result does not match.";
                }
            } else {
                echo "Error: Order not found or status is not PENDING.";
            }

            // Close statements
            $stmt->close();
            $update_stmt->close();
            $update_wallet_stmt->close();
        } else {
            echo "Order status is already SUCCESS. No action needed.";
        }

        // Close database connection
        $conn->close();
    } else {
        // Signature is invalid
        // Save the POST parameters to a text file even if signature verification fails
        file_put_contents("callback_failed.txt", print_r($_POST, true), FILE_APPEND);
        echo "Error: Signature verification failed.";
    }
} else {
    // If the request method is not POST, print an error message
    echo "Error: This page expects a POST request.";
}
echo "success";
?>
