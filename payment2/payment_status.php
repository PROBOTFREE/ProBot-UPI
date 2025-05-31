<?php
error_reporting(0);
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



$sqlSelectOrderscxr = "SELECT * FROM orders WHERE byteTransactionId=?";
$stmtSelectOrderscxr = $conn->prepare($sqlSelectOrderscxr);
$stmtSelectOrderscxr->bind_param("s", $byteTransactionId);
$stmtSelectOrderscxr->execute();
$resultSelectOrders = $stmtSelectOrderscxr->get_result();
$cxrrrowOrders = $resultSelectOrders->fetch_assoc();
$stmtSelectOrderscxr->close();

if (!$cxrrrowOrders) {
    die("Byter error");
}


$order_id = $cxrrrowOrders['order_id'];
$bytehackamount=$cxrrrowOrders['amount'];





// Check if the order has already been processed
$sqlCheckStatus = "SELECT status FROM orders WHERE order_id=?";
$stmtCheckStatus = $conn->prepare($sqlCheckStatus);
$stmtCheckStatus->bind_param("s", $order_id);
$stmtCheckStatus->execute();
$resultCheckStatus = $stmtCheckStatus->get_result();
if ($resultCheckStatus->num_rows > 0) {
    $rowCheckStatus = $resultCheckStatus->fetch_assoc();
    if ($rowCheckStatus['status'] === 'SUCCESS') {
        echo 'Order already processed';
        $stmtCheckStatus->close();
        $conn->close();
        exit;
    }
}
$stmtCheckStatus->close();

$sqlDelete = "DELETE FROM reports WHERE status='' AND order_id=?";
$stmtDelete = $conn->prepare($sqlDelete);
$stmtDelete->bind_param("s", $order_id);
$stmtDelete->execute();
$stmtDelete->close();

$sqlSelectOrders = "SELECT * FROM orders WHERE order_id=?";
$stmtSelectOrders = $conn->prepare($sqlSelectOrders);
$stmtSelectOrders->bind_param("s", $order_id);
$stmtSelectOrders->execute();
$resultSelectOrders = $stmtSelectOrders->get_result();
$rowOrders = $resultSelectOrders->fetch_assoc();
$stmtSelectOrders->close();

if (!$rowOrders) {
    die("Order not found");
}

$user_token = $rowOrders['user_token'];
$gateway_txn = $rowOrders['gateway_txn'];
$cxrremark1 = $rowOrders['remark1'];

$sqlSelectUser = "SELECT * FROM users WHERE user_token=?";
$stmtSelectUser = $conn->prepare($sqlSelectUser);
$stmtSelectUser->bind_param("s", $user_token);
$stmtSelectUser->execute();
$resultSelectUser = $stmtSelectUser->get_result();
$rowUser = $resultSelectUser->fetch_assoc();
$stmtSelectUser->close();

$callback_url = $rowUser['callback_url'];
$megabyteuserid=$rowUser['id'];

$txn_data = file_get_contents('https://couponcart.in/phnpe/user_txn.php?no=' . $user_token . ''); 
$txn_data = substr($txn_data, 6);

$obj = json_decode($txn_data);
$data = $obj->data;

$jsonData = json_decode($txn_data, true);
$data = $jsonData["data"];
$results = $data["results"];

foreach ($results as $result) {
    
    if ($result['merchantTransactionId']==$byteTransactionId){
    
    $cxrmerchantTransactionId=$result["merchantTransactionId"];
    $customerDetails = $result["customerDetails"];
    $user_name = $customerDetails["userName"];
    $paymentApp = $result["paymentApp"];
    $paymentApp = $paymentApp["paymentApp"];
    $logo = $paymentApp["logo"];

    $amount = $result["amount"];
    $amount = $amount / 100;
    $transactionId = $result["transactionId"]; //== utr number
    $paymentState = $result["payResponseCode"]; //success or fail
    $transactionDate = $result["transactionDate"];
    $transactionNote = $result["transactionNote"];
    $transactionDate = date('m/d/Y', $transactionDate);
    $Status = $result["Status"];
    $UTR = $result["utr"];
    $vpa = $result["vpa"];
    


   $sqlInsertReport = "INSERT INTO reports (transactionId, status, order_id, vpa, user_name, paymentApp, amount, user_token, transactionNote, merchantTransactionId, user_id) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
$stmtInsertReport = $conn->prepare($sqlInsertReport);

// Assuming $cxrmerchantTransactionId and $transactionNote are strings.
$stmtInsertReport->bind_param("sssssssssss", $transactionId, $paymentState, $order_id, $vpa, $user_name, $paymentApp, $amount, $user_token, $transactionNote, $cxrmerchantTransactionId, $megabyteuserid);

if ($stmtInsertReport->execute() === TRUE) {
    $stmtInsertReport->close();
}


}
}

$sqlSelectReports = "SELECT * FROM reports WHERE order_id=?";
$stmtSelectReports = $conn->prepare($sqlSelectReports);
$stmtSelectReports->bind_param("s", $order_id);
$stmtSelectReports->execute();
$resultSelectReports = $stmtSelectReports->get_result();
$rowReports = $resultSelectReports->fetch_assoc();
$stmtSelectReports->close();

$db_status = $rowReports['status'];
$db_user_token = $rowReports['user_token'];
$db_transactionId = $rowReports['transactionId'];  //utr
$db_amount=$rowReports['amount'];
$db_merchantTransactionId=$rowReports['merchantTransactionId']; //byte trans
$db_transactionNote=$rowReports['transactionNote'];  //note



if ($db_status == 'SUCCESS' && $byteTransactionId==$db_merchantTransactionId && $bytehackamount== $db_amount) {
    $callback = $callback_url . '?order_id=' . htmlspecialchars_decode($order_id) . '&status=SUCCESS&gateway_txn=' . htmlspecialchars_decode($gateway_txn) . '&remark1=' . urlencode($cxrremark1);
    file_get_contents($callback);

    $sql = "UPDATE orders SET status='SUCCESS' WHERE order_id=?";
    $stmt = $conn->prepare($sql);
    $stmt->bind_param("s", $order_id);
    $stmt->execute();
    $stmt->close();

    $sql = "UPDATE reports SET status='SUCCESS' WHERE order_id=?";
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
} else {
    echo 'PENDING';
}

if ($db_status == 'FAILURE' || $db_status == 'FAILED' || $db_status == 'UPI_BACKBONE_ERROR') {
    echo 'FAILURE';
}

$conn->close();
?>
