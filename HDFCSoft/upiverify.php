<?php
error_reporting(0);

include ('../auth/config.php');

if ($_SERVER['REQUEST_METHOD'] === 'POST') {
    // Check if both user_token and upi_id are set in the POST request
    if (isset($_POST['user_token']) && isset($_POST['upi_id'])) {
        // You can process the received data here
        $userToken = filter_var($_POST['user_token'], FILTER_SANITIZE_STRING);
        $upiId = $_POST['upi_id'];
        
        // Example: Save the data to a database
        // Replace this with your own database handling logic
        // $pdo = new PDO("mysql:host=localhost;dbname=mydatabase", "username", "password");
        // $stmt = $pdo->prepare("INSERT INTO user_data (user_token, upi_id) VALUES (?, ?)");
        // $stmt->execute([$userToken, $upiId]);
    } else {
        // If either user_token or upi_id is missing in the POST request
        echo json_encode(array("status" => "error", "message" => "Missing user_token or upi_id"));
    }
} else {
    // If the request method is not POST
    echo json_encode(array("status" => "error", "message" => "Only POST requests are allowed"));
    exit;
}


// Assuming $user_token is already defined or fetched from somewhere
$user_token = $userToken; // Assuming $user_token is defined elsewhere

$sql = "SELECT seassion, tidList FROM hdfc WHERE user_token = ?";
$stmt = $conn->prepare($sql);
$stmt->bind_param("s", $user_token);
$stmt->execute();
$result = $stmt->get_result();

// Check if the query returned any rows
if ($result->num_rows > 0) {
    // Fetch seassion and tidList values and store them in variables
    $row = $result->fetch_assoc();
    $session_value = $row['seassion'];
    $cxrtidList = $row['tidList'];

    // Now you have the session and tidList values in $session_value and $tidList variables respectively
    // You can use these variables as needed
    // For example:
    //echo "Session value: " . $session_value;
// echo "tidList value: " . $tidList;


} else {
    echo "No session value found for the given user_token";
    exit;
}

// Close the database connection
$stmt->close();
$conn->close();



function RandomNumber($length)
{
    $str = "";
    for ($i = 0; $i < $length; $i++) {
        $str .= mt_rand(0, 9);
    }
    return $str;
}




$tidList = $cxrtidList;
$sessionid = $session_value;





  




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



    $newDateTime = date('Y-m-d');
    $vpa=$upiId;
   $PAYLOAD = encrypt('{"vpa":"' . $vpa . '","terminalId":"' . $tidList . '"}', $aeskey, $aesiv);

    $key = RsaPcs1($aeskey);
    $iv = base64_encode($aesiv);
    $url="https://hdfcmmp.mintoak.com/HDFC/V9/ValidateVPA";
    $data0 = '{"KEY":"'.$key.'","IV":"'.$iv.'","PAYLOAD":"'.$PAYLOAD.'"}';
    $headers = array("Host: hdfcmmp.mintoak.com","motoken: ","sessionid: $sessionid","content-type: application/json","accept-encoding: gzip","user-agent: okhttp/4.9.1");
    $userdetils = request($url, $data0, 'POST', $headers, 0);
    $userdetils = decrypt($userdetils, $aeskey, $aesiv);
    $decoded_details = json_decode($userdetils, true);
    $status = $decoded_details['status'];
    
     if ($status === 'Success' && $decoded_details['statusCode']==='S101') {
            // Handle success condition
            // Send a response back to the user
        echo json_encode(array("status" => "Success", "message" => "Upiid is valid"));
        exit;
        } elseif ($status === 'Failed'&& $decoded_details['statusCode']==='P119') {
            ;
            echo json_encode(array("status" => 'Failed', "message" => "Upiid is invalid"));
        exit;
        }
        else{
            
            echo $userdetils; // Echo the response from cURL
            exit;
        }
    
    
    
    
    
