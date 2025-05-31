<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <!-- Include SweetAlert2 and jQuery -->
    <script src="https://cdn.jsdelivr.net/npm/sweetalert2@11"></script>
    <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
    <title>PROBOT PAYMENTS</title>
    <style>
        body {
            background: #667eea;
            background: -webkit-linear-gradient(to right, #764ba2, #667eea);
            background: linear-gradient(to right, #764ba2, #667eea);
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
            margin: 0;
            font-family: Arial, sans-serif;
        }
        
        .qr-wrapper {
            padding: 10px;
            background: rgba(255, 255, 255, 0.2);
            border-radius: 12px;
        }
        
        .qr-container {
            background: #fff;
            padding: 20px;
            box-shadow: 0 8px 16px rgba(0, 0, 0, 0.1);
            text-align: center;
            width: 300px;
            border-radius: 8px;
        }
        
        .qr-title {
            background: #343a40;
            color: #fff;
            padding: 10px;
            font-size: 18px;
            border-top-left-radius: 8px;
            border-top-right-radius: 8px;
        }
        
        .qr-code {
            padding: 10px;
            margin: 20px auto;
            display: inline-block;
            border: 4px solid; /* Required for gradient borders */
            border-image-slice: 1;
            border-width: 4px;
            border-image-source: linear-gradient(45deg, #f3ec78, #af4261); /* Gradient border */
            border-radius: 8px;
            box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
        }
        
        .amount {
            font-size: 16px;
            margin: 20px 0;
            color: #343a40;
        }
        
        .validity {
    font-size: 12px;
    color: #000000; /* Changing color to black */
    /* Other properties remain unchanged */
}

        .pay-button {
            display: none;
            background-color: #4CAF50;
            color: white;
            padding: 10px 20px;
            margin: 10px 0;
            border: none;
            border-radius: 5px;
            cursor: pointer;
            font-size: 16px;
        }

        @media screen and (max-width: 768px) {
            .pay-button {
                display: inline-block;
            }
        }
    </style>
</head>
<?php




// Define the base directory constant
define('ROOT_DIR', realpath(dirname(__FILE__)) . '/../');

// Securely include files using the ROOT_DIR constant
include ROOT_DIR . 'pages/dbFunctions.php';
include ROOT_DIR . 'auth/config.php';
include ROOT_DIR . 'pages/dbInfo.php';



// Verify if the POST request contains the expected parameters
if(isset($_POST['upiId']) && isset($_POST['cxr_XsRFtoken'])) {
    // Retrieve the values from POST
    $upiId = filter_var($_POST['upiId'], FILTER_SANITIZE_STRING);
$cxr_XsRFtoken = filter_var($_POST['cxr_XsRFtoken'], FILTER_SANITIZE_STRING);

    
} else {
    // Handle the case where one or both values are not set
    echo "Error: Missing POST parameters";
    exit;
}


$link_token = sanitizeInput($_GET["token"]);

// Fetch order_id based on the token from the payment_links table
$sql_fetch_order_id = "SELECT order_id, created_at,nonce FROM payment_links WHERE link_token = '$link_token'";
$result = getXbyY($sql_fetch_order_id);

if (count($result) === 0) {
    // Token not found or expired
    echo "Token not found or expired";
    exit;
}

$order_id = $result[0]['order_id'];
$created_at = strtotime($result[0]['created_at']);
$current_time = time();
$dbnonce= $result[0]['nonce'];

// Check if the token has expired (more than 5 minutes)
if (($current_time - $created_at) > (5 * 60)) {
    echo "Token has expired";
    exit;
}

if ($cxr_XsRFtoken!=$dbnonce){
    echo "XSRF TOKEN EXPIRED";
    exit;
}





$slq_p = "SELECT * FROM orders where order_id='$order_id'";
$res_p = getXbyY($slq_p);    
$amount = $res_p[0]['amount'];
$user_token = $res_p[0]['user_token'];
$redirect_url = $res_p[0]['redirect_url'];
$upiLink = $res_p[0]['upiLink'];
$upiLink=str_replace("https://","","$upiLink");
$method = $res_p[0]['method'];
$hdfc_txn = $res_p[0]['HDFC_TXNID'];
$cxrdesc= $res_p[0]['description'];

if ($method!="HDFC"){
    
     echo "error";
    exit;
}

// Data to be sent in the cURL request
$data = array(
    'user_token' => $user_token,
    'upi_id' => $upiId
);

echo '<div id="loader" style="display: block; position: fixed; z-index: 9999; top: 50%; left: 50%; transform: translate(-50%, -50%);">Loading...</div>';

// Initialize cURL session
$ch = curl_init();

// Set cURL options
curl_setopt($ch, CURLOPT_URL, 'https://couponcart.in/HDFCSoft/upiverify');
curl_setopt($ch, CURLOPT_POST, 1);
curl_setopt($ch, CURLOPT_POSTFIELDS, http_build_query($data));
curl_setopt($ch, CURLOPT_RETURNTRANSFER, true);

// Execute cURL request and get the response
$response = curl_exec($ch);
echo '<script>document.getElementById("loader").style.display = "none";</script>';

// Close cURL session
curl_close($ch);



// Decode the JSON string
$responseArray = json_decode($response, true);

if ($responseArray['status']==="Success"){
    
    $isupiidvalid=true;
    $updateQuery = "UPDATE payment_links SET payee_vpa = ? WHERE link_token = ? AND order_id = ?";
    
    // Prepare the statement
    $stmt = $conn->prepare($updateQuery);
    
    // Bind parameters
    $stmt->bind_param("sss", $upiId, $link_token, $order_id);
    $stmt->execute();
    $stmt->close();
    
    // Endpoint URL
$url = 'https://couponcart.in/HDFCSoft/upicollect';
$params = array(
    'cxrxsrftoken' => $cxr_XsRFtoken,
    'token' => $link_token
);

echo '<div id="loader" style="display: block; position: fixed; z-index: 9999; top: 50%; left: 50%; transform: translate(-50%, -50%);">Loading...</div>';
// Initialize cURL
$cxrcurl = curl_init();

// Set cURL options
curl_setopt($cxrcurl, CURLOPT_URL, $url);
curl_setopt($cxrcurl, CURLOPT_POST, 1);
curl_setopt($cxrcurl, CURLOPT_POSTFIELDS, $params);
curl_setopt($cxrcurl, CURLOPT_RETURNTRANSFER, true);

// Execute cURL request
$response = curl_exec($cxrcurl);
echo '<script>document.getElementById("loader").style.display = "none";</script>';
$cxrdecode=json_decode($response, true);


if ($cxrdecode['status']=="InProgress"){
    
     $mTxnid=$cxrdecode['mTxnid'];
     $updateQuery1 = "UPDATE orders SET HDFC_TXNID = ? WHERE description = ? AND order_id = ?";
    
    // Prepare the statement
    $stmt = $conn->prepare($updateQuery1);
    
    // Bind parameters
    $stmt->bind_param("sss", $mTxnid, $cxrdesc, $order_id);
    // Execute the statement and check for success
if ($stmt->execute()) {
    
    header("Location: https://couponcart.in/payment/instant-pay/confirm/$link_token");
exit; // Ensure that subsequent code is not executed
    
    
} else {
    echo "Update failed: Possible reasons - order_id/user_token not found or HDFC_TXNID is already set to '$mTxnid'.";
}
    
}


else{
    
    
    
}

// Close cURL session
curl_close($cxrcurl);

    
    
        
}

elseif ($responseArray['status']==="Failed")
{
    // Reset payee_vpa to null where link_token and order_id match
    $resetQuery = "UPDATE payment_links SET payee_vpa = NULL WHERE link_token = ? AND order_id = ?";
    
    // Prepare the statement
    $stmt = $conn->prepare($resetQuery);
    
    // Bind parameters
    $stmt->bind_param("ss", $link_token, $order_id);
    
    $stmt->execute();
    
    echo '
<script src="https://cdn.jsdelivr.net/npm/sweetalert2@11.0.18/dist/sweetalert2.all.min.js"></script>
<script>
    window.onload = function() {
        Swal.fire({
            icon: "error",
            title: "Upi Id is Invaalid",
            showConfirmButton: false, // Remove the confirm button
            timer: 1500, // Set a timer for the popup to close after 1.5 seconds
            allowOutsideClick: false, // Prevent the user from closing the popup by clicking outside
            allowEscapeKey: false // Prevent the user from closing the popup by pressing Escape key
        }).then((result) => {
            if (result.dismiss === Swal.DismissReason.timer) {
                window.location.href = "https://couponcart.in/payment/instant-pay/'.$link_token.'"; // Redirect to instant-pay with link token
            }
        });
    }
</script>';
exit;

   
}





 
