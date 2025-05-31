<?php
include "../pages/dbFunctions.php";
include "../pages/dbInfo.php";

$servername = DB_HOST;
$username = DB_USERNAME;
$password = DB_PASSWORD;
$dbname = DB_NAME;

$conn = new mysqli($servername, $username, $password, $dbname);

if ($conn->connect_error) {
    die("Connection failed: " . $conn->connect_error);
}

if ($_SERVER['REQUEST_METHOD'] === 'POST') {
    $byteTransactionId = sanitizeInput($_POST['byte_order_status']);
    // continue processing the POST request
} else {
    
   // $byteTransactionId = sanitizeInput($_GET['byte_order_status']);
    // Send a 403 Forbidden HTTP status code
    header('HTTP/1.1 403 Forbidden');
    exit('Forbidden');
    // $order_id = sanitizeInput($_GET['order_id']);
    // $byteTransactionId=sanitizeInput($_GET['byte_order_status']);
}



// Validate $order_id to prevent SQL injection
if (!ctype_alnum($byteTransactionId)) {
    die("Invalid order_id");
}


$sql = "SELECT * FROM orders WHERE byteTransactionId=?";
$stmt = $conn->prepare($sql);
$stmt->bind_param("s", $byteTransactionId);
$stmt->execute();
$result = $stmt->get_result();
$order = $result->fetch_assoc();
$stmt->close();

if (!$order) {
    exit("Transaction not found");
}

$order_id = $order['order_id'];
$db_amount = $order['amount'];
$txn_ref_id=$order['paytm_txn_ref']; //byte trans

$sqlCheckStatus = "SELECT status FROM orders WHERE order_id=?";
$stmtCheckStatus = $conn->prepare($sqlCheckStatus);
$stmtCheckStatus->bind_param("s", $order_id);
$stmtCheckStatus->execute();
$resultCheckStatus = $stmtCheckStatus->get_result();
$rowCheckStatus = $resultCheckStatus->fetch_assoc();
$stmtCheckStatus->close();

if ($rowCheckStatus && $rowCheckStatus['status'] === 'SUCCESS') {
    exit('Order already processed');
}

$sqlDelete = "DELETE FROM reports WHERE status='' AND order_id=?";
$stmtDelete = $conn->prepare($sqlDelete);
$stmtDelete->bind_param("s", $order_id);
$stmtDelete->execute();
$stmtDelete->close();

$tokens = getXbyY("SELECT token, cookie FROM freecharge_tokens WHERE user_token='{$order['user_token']}'")[0] ?? null;
if (!$tokens) exit("Token not found");

$response = curlGet("https://couponcart.in/fcharge/chek.php?token=" . urlencode($tokens['token']) . "&cookie=" . urlencode($tokens['cookie']) . "&txn=" . urlencode($txn_ref_id));

if (!$response) exit("Error fetching API response");

$json = json_decode($response, true);
if (json_last_error() !== JSON_ERROR_NONE) exit("Error decoding JSON response");

$transactionStatus = $json['transactions'][0]['status'] ?? 'PENDING';
$utr = $json['transactions'][0]['utr'] ?? 'N/A';
$vpa = $json['transactions'][0]['upi'] ?? 'N/A';
$payerName = $json['transactions'][0]['payer'] ?? 'No description';
$amount = $json['transactions'][0]['amount'] ?? $db_amount;

if ($transactionStatus === 'SUCCESS') {
    if ($amount == $db_amount) {
    $sql = "UPDATE orders SET status='SUCCESS' WHERE order_id=?";
    $stmt = $conn->prepare($sql);
    $stmt->bind_param("s", $order_id);
    $stmt->execute();
    $stmt->close();

    $sql = "UPDATE reports SET status='TXN_SUCCESS' WHERE order_id=?";
    $stmt = $conn->prepare($sql);
    $stmt->bind_param("s", $order_id);
    $stmt->execute();
    $stmt->close();

    $sql = "UPDATE orders SET utr=? WHERE order_id=?";
    $stmt = $conn->prepare($sql);
    $stmt->bind_param("ss", $UTR, $order_id);
    $stmt->execute();
    $stmt->close();
    echo 'success';
    }
} elseif ($transactionStatus === 'PAYMENT_FAILED') {
    $sql = "UPDATE orders SET status='FAILED' WHERE order_id=?";
    $stmt = $conn->prepare($sql);
    $stmt->bind_param("s", $order_id);
    $stmt->execute();
    $stmt->close();
    
    echo("TXN_FAILED");
} else {
    echo("PENDING");
}
?>
