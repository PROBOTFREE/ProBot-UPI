<?php

// Define the base directory constant
define('PROJECT_ROOT', realpath(dirname(__FILE__)) . '/../');

include "../pages/dbFunctions.php";
include "../auth/config.php";



// Check if the request method is POST
if ($_SERVER["REQUEST_METHOD"] != "POST") {
    http_response_code(400); // Bad Request
    $response = array(
        'status' => false,
        'message' => 'Invalid request format'
    );
    // Return the response in JSON format
    header('Content-Type: application/json');
    echo json_encode($response);
    exit; // Stop script execution
}

// Check if the request is a POST request
if ($_SERVER['REQUEST_METHOD'] === 'POST') {
    $required_params = ["user_token", "order_id"];

    foreach ($required_params as $param) {
        if (!isset($_POST[$param]) || empty($_POST[$param])) {
            http_response_code(400); // Bad Request
            echo json_encode([
                "status" => false,
                "message" => "Missing required parameter",
            ]);
            exit();
        }
    }

    // Get input parameters from the data
    $user_token = filter_var($_POST["user_token"], FILTER_SANITIZE_STRING);
    $order_id = filter_var($_POST["order_id"], FILTER_SANITIZE_STRING);
    
    // Check user token validity
    $sql = "SELECT acc_ban, acc_lock, expiry FROM users WHERE user_token = ?";
    $stmt = $conn->prepare($sql);
    
    
    $stmt->bind_param("s", $user_token);
    $stmt->execute();
    $stmt->store_result();

    // Check if user token is valid
    if ($stmt->num_rows === 0) {
        http_response_code(401); // Unauthorized
        echo json_encode([
            "status" => false,
            "message" => "Unauthorized access",
        ]);
        exit();
    }

    $stmt->bind_result($acc_ban, $acc_lock, $expiry);
    $stmt->fetch();
    $stmt->close();

    if ($acc_ban == "on") {
        http_response_code(403); // Forbidden
        echo json_encode([
            "status" => false,
            "message" => "Your Account is Banned",
        ]);
        exit();
    }

    if ($acc_lock >= 3) {
        http_response_code(403); // Forbidden
        echo json_encode([
            "status" => false,
            "message" => "Your Account is Locked",
        ]);
        exit();
    }

    // Prepare the SQL query to fetch order data
    $sql = "SELECT status, amount, utr, create_date FROM orders WHERE user_token = ? AND order_id = ?";
    $stmt = $conn->prepare($sql);
    if (!$stmt) {
        http_response_code(500); // Internal Server Error
        echo json_encode([
            "status" => false,
            "message" => "Database prepare error: " . $conn->error,
        ]);
        exit();
    }

    $stmt->bind_param("ss", $user_token, $order_id);
    $stmt->execute();
    $stmt->store_result();

    if ($stmt->num_rows > 0) {
        $stmt->bind_result($status, $amount, $utr, $create_date);
        $stmt->fetch();

        if ($status === 'SUCCESS') {
            http_response_code(200); // OK
            $response['status'] = true;
            $response['message'] = 'Transaction Successfully';
            $response['result'] = array(
                "txnStatus" => "SUCCESS",
                "orderId" => $order_id,
                'amount' => $amount,
                'date' => $create_date,
                'utr' => $utr // Include UTR if needed
            );
        } elseif ($status === 'FAILURE') {
            http_response_code(200); // OK
            $response['status'] = true;
            $response['message'] = 'Transaction Failed';
            $response['result'] = array(
                "txnStatus" => "FAILURE",
                "orderId" => $order_id,
                'amount' => $amount,
                'date' => $create_date
            );
        } else {
            http_response_code(200); // OK
            $response['status'] = true;
            $response['message'] = 'Transaction Pending';
            $response['result'] = array(
                "txnStatus" => "PENDING",
                "orderId" => $order_id,
                'amount' => $amount,
                'date' => $create_date
            );
        }
    } else {
        http_response_code(404); // Not Found
        $response['status'] = false;
        $response['message'] = 'Order not found';
    }

    $stmt->close();
    
    // Return the response in JSON format
    header('Content-Type: application/json');
    echo json_encode($response);
    exit(); // Stop script execution
}
?>