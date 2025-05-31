

<?php

error_reporting(0);

include "../pages/dbFunctions.php";
include "../pages/dbInfo.php";


$no = filter_var($_REQUEST['no'], FILTER_SANITIZE_STRING);
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
$mo = RandomStriing(4);
$ma = RandomStriing(12);
$mb = RandomStriing(8);
$mc = RandomStriing(4);
$md = RandomStriing(4);
$me = RandomStriing(4);
$mf = RandomStriing(12);
$mg = RandomStriing(8);
$mh = RandomStriing(4);
$mi = RandomStriing(4);
$mj = RandomStriing(11);
$mk = RandomStriing(35);
 $farm="$mb-$md-$mc-$mh-$mf";
 $sfarm="$mg-$mh-$mi-$me-$ma";
  date_default_timezone_set("Asia/Calcutta"); 
 $milliseconds = floor(microtime(true) * 1000);
 


if(isset($no))
{

$servername = DB_HOST;
$username = DB_USERNAME;
$password = DB_PASSWORD;
$dbname = DB_NAME;
$conn = new mysqli($servername, $username, $password, $dbname);
// Check connection
if ($conn->connect_error) {
  die("Connection failed: " . $conn->connect_error);
}


$slq_p = "SELECT * FROM phonepe_tokens where user_token='$no'";
        $res_p = getXbyY($slq_p);    
 $device_data = $res_p[0]['device_data'];
 $name = $res_p[0]['name']; 
 $refreshToken = $res_p[0]['refreshToken'];
 $phoneNumber = $res_p[0]['phoneNumber']; 
$token = $res_p[0]['token']; 
$userId = $res_p['userId'];
$user_token = $res_p[0]['user_token']; 

if($no=="$user_token"){

  
        $device_data=hex2bin($device_data);
 $acc = rtrim($f_contents[$x]);
$ex=explode("||",$device_data);
 $fingerprint=$ex[0];
 $xdevicefingerpint=$ex[1];
 $ip=$ex[2];


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
    include "cheksum.php";
    
  
 $bbk="/apis/merchant-insights/v1/auth/refresh";
  $url="https://business-api.phonepe.com$bbk";
 $data0='{}';
 $lenth=strlen($data0);

 $checksum=checksum("$bbk$data0");

  
     $headers = array("Host: business-api.phonepe.com","x-refresh-token: $refreshToken","x-auth-token: $token","x-farm-request-id: $farm","x-app-id: bd309814ea4c45078b9b25bd52a576de","x-merchant-id: PHONEPEBUSINESS","x-source-type: PB_APP","x-source-platform: ANDROID","x-source-locale: en","x-source-version: 1290004046","fingerprint: $fingerprint","x-device-fingerprint: $xdevicefingerpint","x-app-version: 0.4.46","x-request-sdk-checksum: $checksum","content-type: application/json; charset=utf-8","content-length: $lenth","accept-encoding: gzip","user-agent: okhttp/3.12.13","X-Forwarded-For: $ip");

$userdetils=request($url,$data0,POST,$headers,0);

      $json0=json_decode($userdetils,1);
$token=$json0["token"];
$refreshToken=$json0["refreshToken"];

if($token==""){
    
    echo '{"data":"invelid data","status":"faill"}';
    
}else{


      // //////////updating data/////////
$sql = "UPDATE phonepe_tokens SET refreshToken='$refreshToken' WHERE user_token='$no'";
setXbyY($sql);

$sql = "UPDATE phonepe_tokens SET token='$token' WHERE user_token='$no'";
setXbyY($sql);

/////////////////////////
##########################3
$slq_p1 = "SELECT * FROM store_id where user_token='$no'";
        $res_p1 = getXbyY($slq_p1);    
        $groupValue = $res_p1[0]['groupValue'];

 $bbk="/apis/merchant-insights/v3/transactions/list";
  $url="https://business-api.phonepe.com/apis/merchant-insights/v3/transactions/list";
  
 $data0='{"transactionType":"FORWARD","filters":{"status":["COMPLETED"],"merchantIds":["'.$groupValue.'"],"storeIds":[]},"from":1672252200000,"to":'.$milliseconds.',"offset":0,"size":3}';

 $lenth=strlen($data0);

$checksum=checksum_2("$bbk$data0");

  $headers = array("Host: business-api.phonepe.com","authorization: Bearer $token","x-farm-request-id: $farm","x-app-id: bd309814ea4c45078b9b25bd52a576de","x-merchant-id: PHONEPEBUSINESS","x-source-type: PB_APP","x-source-platform: ANDROID","x-source-locale: en","x-source-version: 1290004046","fingerprint: $fingerprint","x-device-fingerprint: $xdevicefingerpint","x-app-version: 0.4.46","x-request-sdk-checksum: $checksum","content-type: application/json; charset=utf-8","content-length: $lenth","accept-encoding: gzip","user-agent: okhttp/3.12.13","X-Forwarded-For: $ip");

$userdetils=request($url,$data0,POST,$headers,0);
echo "$userdetils";
// echo $results='{"message":"success","txn":{"All":'.$userdetils.'}}';
// echo $lenth=strlen($userdetils);





  
}}else{
    
     echo '{"data":"invelid Token","status":"faill"}';
    
}

}

if(!isset($no))
{
echo"<center><br><form action='' method='GET'>

<input  type='text' name='no' placeholder='ENTER Number'><br><br>


<button  id='button'>LogIn</button></form></center>";
}

?>
