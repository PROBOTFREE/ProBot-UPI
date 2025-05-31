<?php

// Define the base directory constant
define('BASE_PATH', realpath(dirname(__FILE__)) . '/../');

// Securely include files using the BASE_PATH constant
include BASE_PATH . 'pages/dbFunctions.php';
include BASE_PATH . 'pages/dbInfo.php';
include BASE_PATH . 'auth/config.php';


if ($_SERVER["REQUEST_METHOD"] !== "POST") {
    header("Content-Type: application/json");
    $json = ["status" => false, "message" => "Unauthorized Access"];
    echo json_encode($json);
    exit(); // Stop further script execution if the request is not POST
}

// Check if the API request method is POST
if ($_SERVER["REQUEST_METHOD"] == "POST") {
 // Attempt to get the 'X-Verify' header. If not set, return an error.
    if (!isset($_SERVER["HTTP_X_VERIFY"])) {
         $response = [
        "status" => false,
        "message" => "Missing X-Verify header.",
    ];
    echo json_encode($response);
    exit();
    
    } /// x verify
    


$user_token = filter_var($_POST["user_token"], FILTER_SANITIZE_STRING);
$withdrawalAmount = filter_var($_POST["amount"], FILTER_VALIDATE_INT);
$bankAccountNumber = filter_var($_POST["acc_no"], FILTER_SANITIZE_STRING);
$ifscCode = filter_var($_POST["ifsc"], FILTER_SANITIZE_STRING);



$sql_pbbyt = "SELECT * FROM users where user_token='$user_token'";
$res_pbbyt = getXbyY($sql_pbbyt);

if (empty($res_pbbyt)) { //invalid token
    echo json_encode([
        "status" => false,
        "message" => "Invalid Account",
    ]);
    exit();
}

$bydb_unq_user_id = $res_pbbyt[0]["id"];
$userwalletbalance = $res_pbbyt[0]["wallet"];
$user_secret_key= $res_pbbyt[0]["secret_key"];




 // Data to be used for generating the checksum
        $post_data_for_checksum = [
            "user_token" => $user_token,
            "amount" => $_POST["amount"],
            "acc_no" => $_POST["acc_no"],
            "ifsc" => $_POST["ifsc"],
        ];

        // Generate server-side checksum for comparison
        $server_checksum = generateChecksum(
            $post_data_for_checksum,
            $user_secret_key
        );

        $clientx_checksum = $_SERVER["HTTP_X_VERIFY"];

        // Compare checksums
        if ($server_checksum !== $clientx_checksum) {
            echo json_encode([
        "status" => false,
        "message" => "Checksum validation failed.",
    ]);
    exit();
        }
        

if ($withdrawalAmount < 100) {
    echo json_encode([
        "status" => false,
        "message" => "Amount Cannot Be Less Than 100",
    ]);
    exit();
}



if ($withdrawalAmount > $userwalletbalance) {
    echo json_encode([
        "status" => false,
        "message" => "Your Wallet Balance Is Low",
    ]);
    exit();
}

$cxrvip = $res_pbbyt[0]["route_2"];
$cxrvipexpiry = $res_pbbyt[0]["vip_expiry"];
$isuserbanned=$res_pslq_pbbyt[0]["acc_ban"];
$isacc_lock=$res_pslq_pbbyt[0]["acc_lock"];

if ($cxrvip !== "on") {
    echo json_encode([
        "status" => false,
        "message" => "Your VIP is not Enabled",
    ]);
    exit();
}

$today = date("Y-m-d");

if ($cxrvipexpiry <= $today) {
    echo json_encode([
        "status" => false,
        "message" => "Your VIP Plan Expired Please Renew",
    ]);
    exit();
}

 if($isuserbanned=="on"){
         http_response_code(403); // Forbidden
            echo json_encode([
                "status" => false,
                "message" => "Your Account is Banned",
            ]);
            exit();
    }
    
    if($isacc_lock >= 3){
        
         http_response_code(403); // Forbidden
            echo json_encode([
                "status" => false,
                "message" => "Your Account is Locked",
            ]);
            exit();
    }
    
if($cxrbankpayout==false){
    
     $response = [
        "status" => false,
        "message" => "Bank Payout Server Is Under Maintaince.",
    ];
    echo json_encode($response);
exit;
}

// Assuming these variables are defined somewhere

// Calculate total withdrawal amount including fees
$totalWithdrawalAmount = $withdrawalAmount + ($withdrawalAmount * $withdrawalFeePercentage) + $withdrawalFixedFee;

// Check if user has enough balance for withdrawal including fees
if ($totalWithdrawalAmount > $userwalletbalance) {
    echo json_encode([
        "status" => false,
        "message" => "Insufficient Balance",
    ]);
    exit();
}

// Define the current date and time in Y-m-d H:i:s format
$currentDateTime = date("Y-m-d H:i:s");
$withdraw_id = generateRandomPayoutID(); // Assuming generateRandomPayoutID() is a function that generates a unique ID

// Prepare the SQL insert statement
$sql = "INSERT INTO withdrawals (user_id, amount, bank_account_number, ifsc_code, status, created_at, withdraw_id) 
        VALUES (?, ?, ?, ?, 'pending', ?, ?)";

// Prepare and bind parameters
$stmt = $conn->prepare($sql);
$stmt->bind_param("isssss", $userId, $withdrawalAmount, $bankAccountNumber, $ifscCode, $currentDateTime, $withdraw_id);

// Set parameters and execute the statement
$userId = $bydb_unq_user_id;
$stmt->execute();


// Get the current date and time
        $current_date = date("Y-m-d H:i:s");

        // Generate a random wallet transaction ID
        $wallet_txnid = generateRandomWalletTxnID();

        $operation_type = "debit"; // Set operation_type to 'debit'
        $cxrsql ="INSERT INTO wallet_transactions (user_id, wallet_txnid, date, type, amount, operation_type) VALUES (?, ?, ?, 'Payout', ?, ?)";
        $cxrstmt = $conn->prepare($cxrsql);
        $cxrstmt->bind_param(
            "dssds",
            $userId,
            $wallet_txnid,
            $current_date,
            $totalWithdrawalAmount,
            $operation_type
        );

        $cxrstmt->execute();
        // Close the statement
        $cxrstmt->close();
        

// Prepare and execute the SQL update statement to deduct the withdrawal amount from the user's wallet balance
$deductQuery = "UPDATE users SET wallet = wallet - ? WHERE id = ?";
$stmtDeduct = $conn->prepare($deductQuery);
$stmtDeduct->bind_param("di", $totalWithdrawalAmount, $userId);
$stmtDeduct->execute();

// Check if the insertion was successful
if ($stmt->affected_rows > 0) {
    echo json_encode([
        "status" => true,
        "message" => "Withdraw Created Successfully",
        "result" => [
            "withdraw_id" => $withdraw_id,
            "time" => time(),
        ],
    ]);
    exit;
} else {
    echo json_encode([
        "status" => false,
        "message" => "Withdraw Request Failed",
    ]);
     exit;
}

// Close the statements and database connection
$stmt->close();
$stmtDeduct->close();
$conn->close();

}// if condtion for post

?>
