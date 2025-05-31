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
$bytepaytmtxnref=$cxrrrowOrders['paytm_txn_ref']; //byte trans
$db_merchantTransactionId =$bytepaytmtxnref;  //byte trans


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
$db_amount =$rowOrders['amount'];


$sqlSelectUser = "SELECT * FROM users WHERE user_token=?";
$stmtSelectUser = $conn->prepare($sqlSelectUser);
$stmtSelectUser->bind_param("s", $user_token);
$stmtSelectUser->execute();
$resultSelectUser = $stmtSelectUser->get_result();
$rowUser = $resultSelectUser->fetch_assoc();
$stmtSelectUser->close();

$callback_url = $rowUser['callback_url'];
$megabyteuserid= $rowUser['id'];



// Fetch MID from paytm_tokens table
$sqlSelectMid = "SELECT MID FROM paytm_tokens WHERE user_token=?";
$stmtSelectMid = $conn->prepare($sqlSelectMid);
$stmtSelectMid->bind_param("s", $user_token);
$stmtSelectMid->execute();
$resultSelectMid = $stmtSelectMid->get_result();
$rowMid = $resultSelectMid->fetch_assoc();
$stmtSelectMid->close();

if ($rowMid) {
    $bytemerchantid = $rowMid['MID'];
} else {
    die("MID not found for user_token: $user_token");
}
   
   
$mid = $bytemerchantid; // Replace with your actual MID
$txn_ref_id = $bytepaytmtxnref; // Replace with your actual transaction reference ID

// Create the JSON data
$JsonData = json_encode(array("MID" => $mid, "ORDERID" => $txn_ref_id));

// Initialize cURL session
$ch = curl_init();

// Set cURL options
curl_setopt($ch, CURLOPT_URL, "https://securegw.paytm.in/order/status?JsonData=" . urlencode($JsonData));
curl_setopt($ch, CURLOPT_RETURNTRANSFER, true);

// Execute the cURL request and store the response
$response = curl_exec($ch);

// Check for cURL errors
if (curl_errno($ch)) {
    echo 'cURL Error: ' . curl_error($ch);
}

// Close cURL session
curl_close($ch);

// Decode the JSON response into a PHP array
$responseArray = json_decode($response, true);

// Check if decoding was successful
if ($responseArray !== null) {
    
    if ($responseArray['STATUS'] == "TXN_SUCCESS" && $responseArray['MID'] == $mid && $responseArray['ORDERID'] == $txn_ref_id) {

        // Pretty print the JSON response wrapped in <pre> tags
      //  echo "<pre>" . json_encode($responseArray, JSON_PRETTY_PRINT) . "</pre>";
       $transactionId= $responseArray['TXNID'];
        $paymentState=$responseArray['STATUS'];
        $vpa="test@paytm";
        $user_name="NULL";
        $paymentApp=$responseArray['GATEWAYNAME'];
        $amount=$responseArray['TXNAMOUNT'];
        $transactionNote=$responseArray['MERC_UNQ_REF'];
        $cxrmerchantTransactionId=$responseArray['ORDERID'];
        $bytehackamount=$amount;
        $UTR=$responseArray['BANKTXNID'];
        
        
          $sqlInsertReport = "INSERT INTO reports (transactionId, status, order_id, vpa, user_name, paymentApp, amount, user_token, transactionNote, merchantTransactionId, user_id) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
$stmtInsertReport = $conn->prepare($sqlInsertReport);

// Assuming $cxrmerchantTransactionId and $transactionNote are strings.
$stmtInsertReport->bind_param("sssssssssss", $transactionId, $paymentState, $order_id, $vpa, $user_name, $paymentApp, $amount, $user_token, $transactionNote, $cxrmerchantTransactionId, $megabyteuserid);

if ($stmtInsertReport->execute() === TRUE) {
    $stmtInsertReport->close();
}

        
        
    } else {
        
        echo "Payment pending";
    }

} else {
    echo "Failed to decode JSON response";
}

    

//hard logic

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
$db_transactionNote=$rowReports['transactionNote'];  //note



if ($db_status == 'TXN_SUCCESS' && $cxrmerchantTransactionId==$db_merchantTransactionId && $bytehackamount== $db_amount) {
    // Data to be sent
$postData = array(
    'order_id' => htmlspecialchars_decode($order_id),
    'status' => 'SUCCESS',
    'remark1' => urlencode($cxrremark1)
);

// URL to which the request is sent
$url = $callback_url;

// Initialize cURL
$ch = curl_init($url);

// Set cURL options
curl_setopt($ch, CURLOPT_RETURNTRANSFER, true); // This will not output the response
curl_setopt($ch, CURLOPT_POST, true);
curl_setopt($ch, CURLOPT_POSTFIELDS, http_build_query($postData));

// Execute the POST request
curl_exec($ch);

// Close cURL session
curl_close($ch);

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
} else {
    echo 'PENDING';
}

if ($db_status == 'FAILURE' || $db_status == 'FAILED' || $db_status == 'UPI_BACKBONE_ERROR') {
    echo 'FAILURE';
}

$conn->close();
?>
