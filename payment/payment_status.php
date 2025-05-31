<?php
error_reporting(0);

// Define the base directory constant
define('ROOT_DIR', realpath(dirname(__FILE__)) . '/../');

// Securely include files using the ROOT_DIR constant
include ROOT_DIR . 'pages/dbFunctions.php';
include ROOT_DIR . 'auth/config.php';
include ROOT_DIR . 'pages/dbInfo.php';


// Sanitizing the $order_id parameter retrieved using $_GET
$order_id = sanitizeInput($_GET['order_id']);


// Validate $order_id to prevent SQL injection
if (!ctype_alnum($order_id)) {
    die("Invalid order_id");
}

$slq_p = "SELECT * FROM orders where order_id='$order_id'";
$res_p = getXbyY($slq_p);    
$user_token = $res_p[0]['user_token'];
$db_description = $res_p[0]['description'];
$hdfc_txn = $res_p[0]['HDFC_TXNID'];
$db_amount = $res_p[0]['amount'];
$db_byte_status = $res_p[0]['status'];
$bbbyteremark1 = $res_p[0]['remark1'];

if ($db_byte_status == "SUCCESS") {
    echo "Order already processed";
    exit;
}

$slq_p = "SELECT * FROM hdfc where user_token='$user_token'";
$res_p = getXbyY($slq_p);    
$seassion_id_hdfc = $res_p[0]['seassion'];
$hdfc_number = $res_p[0]['number'];        

$slq_pc = "SELECT * FROM users where user_token='$user_token'";
$res_pc = getXbyY($slq_pc);    
$callback_url = $res_pc[0]['callback_url'];
$mobile = $res_pc[0]['mobile'];
$name = $res_pc[0]['name'];
$megabyteuserid = $res_pc[0]['id'];

$txn_data = file_get_contents('https://'.$server.'/payment/mstatement.php?no='.$hdfc_number.'&session='.$seassion_id_hdfc.'');         
$json0 = json_decode($txn_data, true);
$results = $json0["transactionParams"];

$query0 = "SELECT * FROM reports WHERE order_id = '$order_id'";
$result1 = mysqli_query($conn, $query0);

$rows = count($results);

for ($i = 0; $i < $rows; $i++) { 
    $txnid = $results[$i]["txnid"];
    $amount = $results[$i]["amount"];
    $Status = $results[$i]["status"];
    $utr = $results[$i]["utr"];
    $txnmessage = $results[$i]["txnmessage"];
    $description = $results[$i]["description"];
    $payerVpa = $results[$i]["payerVpa"];
    $issuerRefNo = $results[$i]["issuerRefNo"];
    $paymentApp = $results[$i]["paymentApp"];
    
    if ($Status == '3' && $txnid == $hdfc_txn && $description == $db_description && $amount == $db_amount) {
        if (mysqli_num_rows($result1) == 0) {
            $bytetoday = date("Y-m-d H:i:s");
            $sql = "INSERT INTO reports (transactionId, status, vpa, paymentApp, amount, user_token, UTR, description, mobile, date, user_id)
                    VALUES ('$txnid', '$Status', '$payerVpa', '$paymentApp', '$amount', '$user_token', '$issuerRefNo', '$description', '$mobile', '$bytetoday', '$megabyteuserid')";
            setXbyY($sql);

            $sq = "UPDATE `orders` SET status='SUCCESS' WHERE order_id='$order_id'";
            setXbyY($sq);
        }
    } elseif ($Status == '4' && $txnid == $hdfc_txn && $description == $db_description) {
        if (mysqli_num_rows($result1) == 0) {
            $sqlv = "INSERT INTO reports (transactionId, status, vpa, paymentApp, amount, user_token, UTR, description, mobile, user_id) 
                     VALUES ('$txnid', '$Status', '$payerVpa', '$paymentApp', '$amount', '$user_token', '$issuerRefNo', '$description', '$mobile', '$megabyteuserid')";
            setXbyY($sqlv);

            $sq = "UPDATE `orders` SET status='FAILURE' WHERE order_id='$order_id'";
            setXbyY($sq);
        }
    }

    $sql = "UPDATE reports SET order_id='$order_id' WHERE description='$db_description'";
    setXbyY($sql);
}

$slq_p = "SELECT * FROM reports where description='$db_description'";
$res_pp = getXbyY($slq_p);    
$db_status = $res_pp[0]['status'];
if ($db_status == '3') {
    echo 'success';  
} elseif ($db_status == '4') {
    echo 'FAILURE';    
} else {
    echo 'PENDING';
}
?>
