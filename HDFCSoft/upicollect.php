<?php
error_reporting(0);
include ('../auth/config.php');
// Set the default time zone to Asia/Kolkata
date_default_timezone_set('Asia/Kolkata');
function RandomNumber($length)
{
    $str = "";
    for ($i = 0; $i < $length; $i++) {
        $str .= mt_rand(0, 9);
    }
    return $str;
}


// Check if the request method is POST
if ($_SERVER['REQUEST_METHOD'] === 'POST') {
    // Check if both parameters are provided in the POST request
    if (isset($_POST['cxrxsrftoken']) && isset($_POST['token'])) {
        // Retrieve the values from POST
        $cxrxsrftoken = $_POST['cxrxsrftoken'];
        $token = $_POST['token'];

        // Fetch data from the database based on provided conditions
        $sql = "SELECT order_id, payee_vpa,created_at FROM payment_links WHERE link_token = ? AND nonce = ?";
        $stmt = $conn->prepare($sql);
        $stmt->bind_param("ss", $token, $cxrxsrftoken);
        $stmt->execute();
        $result = $stmt->get_result();
 
        // Check if any rows are returned
        if ($result->num_rows > 0) {
            // Fetch the data
            $row = $result->fetch_assoc();
            $order_id = $row['order_id'];
            $payee_vpa = $row['payee_vpa'];
            $created_at = strtotime($row['created_at']);
            
             // Check if the token has expired (more than 5 minutes)
            if ((time() - $created_at) > (5 * 60)) {
                echo json_encode(array("status" => "error", "message" => "Token has expired"));
                exit;
            }
            
            
            // Query to fetch data from orders table based on order_id
            $sql_orders = "SELECT description, amount, customer_mobile, user_token FROM orders WHERE order_id = ?";
            $stmt_orders = $conn->prepare($sql_orders);
            $stmt_orders->bind_param("i", $order_id);
            $stmt_orders->execute();
            $result_orders = $stmt_orders->get_result();

            /// Check if any rows are returned
if ($result_orders->num_rows > 0) {
    // Fetch the data from orders table
    $row_orders = $result_orders->fetch_assoc();
    $description = $row_orders['description'];
    $amount = $row_orders['amount'];
    $customer_mobile = $row_orders['customer_mobile'];
    $user_token = $row_orders['user_token'];
    
    

    // Query to fetch data from hdfc table based on user_token
    $sql_hdfc = "SELECT seassion, tidlist FROM hdfc WHERE user_token = ?";
    $stmt_hdfc = $conn->prepare($sql_hdfc);
    $stmt_hdfc->bind_param("s", $user_token);
    $stmt_hdfc->execute();
    $result_hdfc = $stmt_hdfc->get_result();

    // Check if any rows are returned
    if ($result_hdfc->num_rows > 0) {
        // Fetch the data from hdfc table
        $row_hdfc = $result_hdfc->fetch_assoc();
        $session = $row_hdfc['seassion'];
        $tidlist = $row_hdfc['tidlist'];
        
        $cxrsmm=true;
        
        // Return the fetched data as JSON response
       // echo json_encode(array("status" => "success", "order_id" => $order_id, "payee_vpa" => $payee_vpa, "description" => $description, "amount" => $amount, "customer_mobile" => $customer_mobile, "user_token" => $user_token, "seassion" => $session, "tidlist" => $tidlist));
        //exit;
    } else {
        // If no rows are returned from hdfc table
        echo json_encode(array("status" => "error", "message" => "No data found in hdfc table for the provided user_token"));
    }

    // Close the statement for hdfc query
    $stmt_hdfc->close();
} else {
    // If no rows are returned from orders table
    echo json_encode(array("status" => "error", "message" => "No data found in orders table for the provided order_id"));
}

            // Close the statement for orders query
            $stmt_orders->close();
        } else {
            // If no rows are returned from payment_links table
            echo json_encode(array("status" => "error", "message" => "No data found for the provided conditions"));
        }

        // Close the database connection and statement
        $stmt->close();
        $conn->close();
    } else {
        // If either parameter is missing in the POST request
        echo json_encode(array("status" => "error", "message" => "Missing parameters"));
    }
} else {
    // If the request method is not POST
    echo json_encode(array("status" => "error", "message" => "Only POST requests are allowed"));
}








$tidList = $tidlist;
$sessionid = $session;
$cnumber = $customer_mobile;

$dis = $description;




  




function request($url, $data0, $type, $headers, $yes) {
    $typee = "CURLOPT_$type";
    $ch = curl_init($url);   
    curl_setopt($ch, CURLOPT_HTTPHEADER, $headers);
    curl_setopt($ch, constant($typee), 1);      
    curl_setopt($ch, CURLOPT_POSTFIELDS, $data0);       
    curl_setopt($ch, CURLOPT_SSL_VERIFYPEER, 0);
    curl_setopt($ch, CURLOPT_SSL_VERIFYHOST, 0);
    curl_setopt($ch, CURLOPT_CUSTOMREQUEST, $type);
    curl_setopt($ch, CURLOPT_RETURNTRANSFER, 1);
    curl_setopt($ch, CURLOPT_FOLLOWLOCATION, 1);
    curl_setopt($ch, CURLOPT_ENCODING, 'gzip');  
    curl_setopt($ch, CURLOPT_HEADER, $yes);
    $output1 = curl_exec($ch); 
    return $output1;
}

function RsaPcs1($data) {
    $public_key = file_get_contents('public.key');
    openssl_public_encrypt($data, $rsa_key, $public_key, OPENSSL_PKCS1_OAEP_PADDING);
    return base64_encode($rsa_key);    
}

function encrypt($data, $key, $iv) {
    $tag = '';
    $encrypted = openssl_encrypt(
        $data,
        'aes-128-gcm',
        $key,
        OPENSSL_RAW_DATA,
        $iv,
        $tag,
        '',
        16
    );

    return base64_encode($encrypted . $tag);
}

$aeskey = random_bytes(16);
$aesiv = random_bytes(16);

function decrypt($data, $key, $iv) {
    $data = base64_decode($data);
    $tag = substr($data, strlen($data) - 16);
    $data = substr($data, 0, strlen($data) - 16);

    try {
        return openssl_decrypt(
            $data,
            'aes-128-gcm',
            $key,
            OPENSSL_RAW_DATA,
            $iv,
            $tag
        );
    } catch (\Exception $e) {
        return false;
    }
}


function RandomString($length) {
    $keys = array_merge(range('9', '0'), range('a', 'f'));
    $key = '';
    for($i = 0; $i < $length; $i++) {
        $key .= $keys[array_rand($keys)];
    }
    return $key;
}



$bb = RandomNumber(4);
$db = RandomNumber(7);
$nom = RandomNumber(18);
$gmaill = "$fname$bb";
$tz = 'Asia/Kolkata';   
date_default_timezone_set($tz);
$ipp = long2ip(rand());
$newDateTime = date('Y-m-d');
$result = uniqid();


if($cxrsmm) {
    $newDateTime = date('Y-m-d');
$payerVpa=$payee_vpa;
   $PAYLOAD = encrypt('{"terminalId":"'.$tidList.'","amount":"'.$amount.'.00","description":"'.$dis.'","customerMobileNumber":"'.$cnumber.'","appTxnid":"2560'.$db.'","pgId":1,"redemptionId":[],"payerVpa":"'.$payerVpa.'"}', $aeskey, $aesiv);


    $key = RsaPcs1($aeskey);
    $iv = base64_encode($aesiv);
    $url="https://hdfcmmp.mintoak.com/HDFC/OneApp/UPICollect";
    $data0 = '{"KEY":"'.$key.'","IV":"'.$iv.'","PAYLOAD":"'.$PAYLOAD.'"}';
    $headers = array("Host: hdfcmmp.mintoak.com","motoken: ","sessionid: $sessionid","content-type: application/json","accept-encoding: gzip","user-agent: okhttp/4.9.1");
    $userdetils = request($url, $data0, 'POST', $headers, 0);
    $userdetils1 = decrypt($userdetils, $aeskey, $aesiv);
    $decoded_details = json_decode($userdetils1, true);
    
    
  
      echo $userdetils1;
        exit; 
    
    
    
    
    

} else {
    // Handle the case when 'no' parameter is missing.
    echo '{"error":"no parameter is missing"}';
}