<?php

// Define the base directory constant
define('BASE_PATH', realpath(dirname(__FILE__)) . '/../');

// Securely include files using the BASE_PATH constant
include BASE_PATH . 'pages/dbFunctions.php';
include BASE_PATH . 'pages/dbInfo.php';
include BASE_PATH . 'auth/config.php';


// Return the response in JSON format
header('Content-Type: application/json');

if ($_SERVER["REQUEST_METHOD"] !== "POST") {
    header("Content-Type: application/json");
    $json = ["status" => false, "message" => "Unauthorized Access"];
    echo json_encode($json);
    exit(); // Stop further script execution if the request is not POST
}

// Check if the API request method is POST
if ($_SERVER["REQUEST_METHOD"] == "POST") {





$user_token = filter_var($_POST["user_token"], FILTER_SANITIZE_STRING);
$withdraw_id= filter_var($_POST["withdraw_id"], FILTER_SANITIZE_STRING);
$payout_type = filter_var($_POST["payout_type"], FILTER_SANITIZE_STRING);

$sql_pbbyt = "SELECT * FROM users where user_token='$user_token'";
$res_pbbyt = getXbyY($sql_pbbyt);

if (empty($res_pbbyt)) {///
    echo json_encode([
        "status" => false,
        "message" => "Invalid Account",
    ]);
    exit();
}

$bydb_unq_user_id = $res_pbbyt[0]["id"];
$userwalletbalance = $res_pbbyt[0]["wallet"];
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


if ($payout_type == "bank") {
// Prepare the SQL query to fetch withdrawals data
$sql = "SELECT status, amount, created_at FROM withdrawals WHERE user_id = ? AND withdraw_id = ?";

$stmt = $conn->prepare($sql);
$stmt->bind_param("ss", $bydb_unq_user_id, $withdraw_id);
$stmt->execute();
$stmt->bind_result($status, $amount,$create_date);

$response = array();

if ($stmt->fetch()) {
    if ($status === 'completed') { // Check if status is 'completed'
        http_response_code(200); // OK
        $response['status'] = true;
        $response['message'] = 'Withdraw Successfully';
        $response['result'] = array(
            "txnStatus" => "SUCCESS",
            "withdraw_id" => $withdraw_id,
            'amount' => $amount,
            'date' => $create_date ///,
            //'utr' => $utr
        );
        echo json_encode($response);
        exit(); // Stop script execution
    } elseif ($status === 'cancelled') { // Check if status is 'cancelled'
        http_response_code(200); // OK
        $response['status'] = true;
        $response['message'] = 'Withdraw Failed';
        $response['result'] = array(
            "txnStatus" => "FAILURE",
            "withdraw_id" => $withdraw_id,
            'amount' => $amount,
            'date' => $create_date
        );
        echo json_encode($response);
        exit(); // Stop script execution
    } else {
        http_response_code(200); // OK
        $response['status'] = true;
        $response['message'] = 'Withdraw Pending';
        $response['result'] = array(
            "txnStatus" => "PENDING",
            "withdraw_id" => $withdraw_id,
            'amount' => $amount,
            'date' => $create_date
        );
        echo json_encode($response);
        exit(); // Stop script execution
    }
} else {
    http_response_code(404); // Not Found
    $response['status'] = false;
    $response['message'] = 'Withdraw not found';
    echo json_encode($response);
        exit(); // Stop script execution
}
} //if condition for bank

elseif ($payout_type == "upi"){
    
// Prepare the SQL query to fetch withdrawals_upi data
$sql = "SELECT status, amount, created_at FROM withdrawals_upi WHERE user_id = ? AND withdraw_id = ?";

$stmt = $conn->prepare($sql);
$stmt->bind_param("ss", $bydb_unq_user_id, $withdraw_id);
$stmt->execute();
$stmt->bind_result($status, $amount,$create_date);

$response = array();

if ($stmt->fetch()) {
    if ($status === 'completed') { // Check if status is 'completed'
        http_response_code(200); // OK
        $response['status'] = true;
        $response['message'] = 'Withdraw Successfully';
        $response['result'] = array(
            "txnStatus" => "SUCCESS",
            "withdraw_id" => $withdraw_id,
            'amount' => $amount,
            'date' => $create_date ///,
            //'utr' => $utr
        );
        echo json_encode($response);
        exit(); // Stop script execution
    } elseif ($status === 'cancelled') { // Check if status is 'cancelled'
        http_response_code(200); // OK
        $response['status'] = true;
        $response['message'] = 'Withdraw Failed';
        $response['result'] = array(
            "txnStatus" => "FAILURE",
            "withdraw_id" => $withdraw_id,
            'amount' => $amount,
            'date' => $create_date
        );
        echo json_encode($response);
        exit(); // Stop script execution
    } else {
        http_response_code(200); // OK
        $response['status'] = true;
        $response['message'] = 'Withdraw Pending';
        $response['result'] = array(
            "txnStatus" => "PENDING",
            "withdraw_id" => $withdraw_id,
            'amount' => $amount,
            'date' => $create_date
        );
        echo json_encode($response);
        exit(); // Stop script execution
    }
} else {
    http_response_code(404); // Not Found
    $response['status'] = false;
    $response['message'] = 'Withdraw not found';
    echo json_encode($response);
        exit(); // Stop script execution
}
    
}



}//post brakcet

?>
