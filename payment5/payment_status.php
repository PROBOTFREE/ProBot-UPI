<?php
// Define the base directory constant
define('ROOT_DIR', realpath(dirname(__FILE__)) . '/../');

// Securely include files using the ROOT_DIR constant

include ROOT_DIR . 'pages/dbInfo.php';


try {
    // Create a PDO database connection
    $pdo = new PDO("mysql:host=".DB_HOST.";dbname=".DB_NAME, DB_USERNAME, DB_PASSWORD);
    // Set PDO error mode to exception
    $pdo->setAttribute(PDO::ATTR_ERRMODE, PDO::ERRMODE_EXCEPTION);
    // Set character encoding
    $pdo->exec("set names utf8mb4");
} catch(PDOException $e) {
    die("Database connection failed: " . $e->getMessage());
}

function googlepay_trans($token) {
    
    // Define the API URL
$apiUrl = 'https://couponcart.in/api/instance/verify/google-pay'; // Replace with your actual API URL

// Define the user_token you want to send in the request
$user_token = $token; // Replace with the user_token you want to use

// Create an array with the POST data
$data = array(
    'user_token' => $user_token
);

// Initialize cURL session
$curl = curl_init();

// Set cURL options
curl_setopt($curl, CURLOPT_URL, $apiUrl);
curl_setopt($curl, CURLOPT_RETURNTRANSFER, true);
curl_setopt($curl, CURLOPT_POST, true);
curl_setopt($curl, CURLOPT_POSTFIELDS, $data);

// Execute cURL request and store the response
$response = curl_exec($curl);


    curl_close($curl);

    $decodedResponse = json_decode($response, true);
    if (is_array($decodedResponse) && isset($decodedResponse['status']) && $decodedResponse['status']) {
        return $decodedResponse['data']['transactions'];
    } else {
        return $response;
    }
}

function sanitize_input($input) {
    return htmlspecialchars(trim($input), ENT_QUOTES, 'UTF-8');
}

if ($_SERVER['REQUEST_METHOD'] !== 'POST') {
    echo json_encode(['error' => 'Invalid request method. Only POST requests are accepted.']);
    exit;
}

// Validate UTR - it should be set, not empty, exactly 12 digits
    if (isset($_POST['utr']) && !empty($_POST['utr'])) {
        $utr = sanitize_input($_POST['utr']);
        if (!ctype_digit($utr) || strlen($utr) != 12) {
            echo "Error: Invalid UTR. UTR must be exactly 12 digits.";
            exit;
        }
    } else {
        echo "Error: UTR is missing.";
        exit;
    }

    // Validate TransactionId - it should be set, not empty, and alphanumeric
    if (isset($_POST['TransactionId']) && !empty($_POST['TransactionId'])) {
        $transactionId = sanitize_input($_POST['TransactionId']);
        if (!ctype_alnum($transactionId)) {
            echo "Error: Invalid TransactionId. It must be alphanumeric.";
            exit;
        }
    } else {
        echo "Error: TransactionId is missing.";
        exit;
    }
    
$query = "SELECT byteTransactionId, redirect_url, status, user_token, amount FROM orders WHERE byteTransactionId = :transactionId";
$stmt = $pdo->prepare($query);
$stmt->execute(['transactionId' => $transactionId]);
$row = $stmt->fetch(PDO::FETCH_ASSOC);


if ($row['status'] == 'SUCCESS') {
    echo json_encode(['status' => 'success', 'redirect_url' => $row['redirect_url']]);
    exit;
}

if ($row['status'] == 'PENDING') {
    $user_token = $row['user_token'];
    $tokenQuery = "SELECT phoneNumber, Instance_Id, created_at FROM googlepay_tokens WHERE user_token = :user_token";
    $tokenStmt = $pdo->prepare($tokenQuery);
    $tokenStmt->execute(['user_token' => $user_token]);
    $tokenRow = $tokenStmt->fetch(PDO::FETCH_ASSOC);

    if ($tokenRow) {
        $transactions = googlepay_trans($user_token);

        if (is_array($transactions)) {
            $bank_reference_no = sanitize_input($utr);
            if (!preg_match('/^\d{12}$/', $bank_reference_no)) {
                echo json_encode(['error' => 'Invalid UTR format.']);
                exit;
            }

            $matched_transaction = null;
            foreach ($transactions as $transaction) {
                if ($transaction['bankReferenceNo'] == $bank_reference_no) {
                    $matched_transaction = $transaction;
                    break;
                }
            }

            if ($matched_transaction) {
                
                //amtch utr
                
                //safe to prevent amount bug
                
                // Check to prevent amount mismatch
    if ($row['amount'] != $matched_transaction['amount']) {
        // Handle the mismatch case
        
         echo json_encode(['status' => 'pending', 'redirect_url' => $row['redirect_url'], 'error' => 'Price Error Occured.']);
         exit;
    }
    // Fetching user_id (assuming it's the "id" column) based on user_token
    $fetchUserIdQuery = "SELECT id FROM users WHERE user_token = :user_token";
    $fetchUserIdStmt = $pdo->prepare($fetchUserIdQuery);
    $fetchUserIdStmt->execute(['user_token' => $user_token]);
    $userRow = $fetchUserIdStmt->fetch(PDO::FETCH_ASSOC);
    $megabyteuserid = $userRow['id'];            
                
    $updateQuery = "UPDATE orders SET status = 'SUCCESS', utr = :utr WHERE byteTransactionId = :transactionId";
    $updateStmt = $pdo->prepare($updateQuery);
    $updateStmt->execute(['transactionId' => $transactionId, 'utr' => $matched_transaction['bankReferenceNo']]);

    $fetchQuery = "SELECT remark1, remark2, order_id, redirect_url FROM orders WHERE byteTransactionId = :transactionId";
    $fetchStmt = $pdo->prepare($fetchQuery);
    $fetchStmt->execute(['transactionId' => $transactionId]);
    $orderRow = $fetchStmt->fetch(PDO::FETCH_ASSOC);

    // Fetching callback_url from users table
    $callbackQuery = "SELECT callback_url FROM users WHERE user_token = :user_token";
    $callbackStmt = $pdo->prepare($callbackQuery);
    $callbackStmt->execute(['user_token' => $user_token]);
    $userRow = $callbackStmt->fetch(PDO::FETCH_ASSOC);

    $reportTransactionId = rand(1111111111, 9999999999);
    $insertQuery = "INSERT INTO reports (transactionId, status, order_id, vpa, paymentApp, amount, user_token, UTR, description, user_id) VALUES (?, 'SUCCESS', ?, 'test@bharatpe', ?, ?, ?, ?, ?, ?)";
    $insertStmt = $pdo->prepare($insertQuery);
    $insertStmt->execute([$reportTransactionId, $orderRow['order_id'], $matched_transaction['payerHandle'], $matched_transaction['amount'], $user_token, $matched_transaction['bankReferenceNo'], rand(1111111111, 9999999999), $megabyteuserid]);

    $callback_url = $userRow['callback_url']; 
    $remark1 = $orderRow['remark1'];
    // Update the callback URLs with remark1 parameter
    
    



    echo json_encode(['status' => 'success', 'redirect_url' => $orderRow['redirect_url']]);
    exit;
}


//safe env

 else {   
     
     //wrong utr
     
     echo json_encode(['status' => 'invalid', 'redirect_url' => $row['redirect_url'], 'error' => 'Transaction not found.']);
               exit;

                
            }
        } else {
            
            echo json_encode(['status' => 'pending', 'redirect_url' => $row['redirect_url'], 'error' => 'Error fetching transactions.']);
exit;


        }
    } else {  
        
        //user token error
        
         echo json_encode(['status' => 'pending', 'redirect_url' => $row['redirect_url'], 'error' => 'Token information not found.']);
exit;
        
       
    }
} else {
    
    //status error in table orders
    
    echo json_encode(['status' => 'pending', 'redirect_url' => $row['redirect_url'], 'error' => 'Unhandled transaction status.']);
exit;

    
}
?>