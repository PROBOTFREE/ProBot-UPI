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




$no = filter_var($_REQUEST['no'], FILTER_SANITIZE_STRING);
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
$mon = RandomStriing(15);
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
$mj = RandomStriing(22);
$mk = RandomStriing(35);
 $farm="$mb-$md-$mc-$mh-$mf";
 $sfarm="$mg-$mh-$mi-$me-$ma";


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
  
  //userhaders
   $referfile = file_get_contents('usersdb.json');
$jsondecode=json_decode($referfile,1);
$uuu = $jsondecode["$no"] ["User"];
$acc = rtrim($f_contents[$x]);
$ex=explode("||",$uuu);
$usernumber=$ex[0];
$userid=$ex[1];
 $fingerprint=$ex[4];
$device_fingerprint=$ex[5];
$ip=$ex[6];
//userstoken
$data_file="refresh_Token/$no.json";
 $tmoken = file_get_contents($data_file);
$utkn=json_decode($tmoken,1);
 $token = $utkn["token"];
 $refreshToken = $utkn["refreshToken"];


  $bbk="/apis/merchant-insights/v1/auth/refresh";
  $url="https://business-api.phonepe.com$bbk";
 $data0='{}';
 $lenth=strlen($data0);

 $checksum=checksum("$bbk$data0");

  $headers = array("Host: business-api.phonepe.com","x-refresh-token: $refreshToken","x-auth-token: $token","x-farm-request-id: $farm","x-app-id: bd309814ea4c45078b9b25bd52a576de","x-merchant-id: PHONEPEBUSINESS","x-source-type: PB_APP","x-source-platform: ANDROID","x-source-locale: en","x-source-version: 1290004039","fingerprint: $device_fingerprint","x-device-fingerprint: $fingerprint","x-app-version: 0.4.39","x-request-sdk-checksum: $checksum","content-type: application/json; charset=utf-8","content-length: $lenth","accept-encoding: gzip","user-agent: okhttp/3.12.13","X-Forwarded-For: $ip");

$userdetils=request($url,$data0,POST,$headers,0);
echo $userdetils;
      $json0=json_decode($userdetils,1);
$token=$json0["token"];
$refreshToken=$json0["refreshToken"];

if($token==""){
    
}else{

$data= ' {
      "token":"'.$token.'",
      "refreshToken":"'.$refreshToken.'"
  }';
    
file_put_contents('refresh_Token/'.$no.'.json', $data);
}
##################################################33
   $bbk1="/apis/merchant-insights/v1/user/merchant/groupInfoList";
  $url="https://business-api.phonepe.com$bbk1";
 $data0='';
$checksum = file_get_contents("https://couponcart.in/phnpe/checksum_my.php?trd=$bbk1");
  $checksum= substr("$checksum",4);
  $headers = array("Host: business-api.phonepe.com","authorization: Bearer $token","x-farm-request-id: $farm","content-type: application/json","x-app-id: bd309814ea4c45078b9b25bd52a576de","x-merchant-id: PHONEPEBUSINESS","x-source-type: PB_APP","x-source-platform: ANDROID","x-source-locale: en","x-source-version: 1290004039","fingerprint: $device_fingerprint","x-device-fingerprint: $fingerprint","x-app-version: 0.4.39","x-request-sdk-checksum: $checksum","accept-encoding: gzip","user-agent: okhttp/3.12.13","X-Forwarded-For: $ip");

$userdetils=request($url,$data0,GET,$headers,0);
echo $userdetils;
      $json0=json_decode($userdetils,1);
echo $groupValue=$json0["1"]["userGroupNamespace"]["groupValue"];
$groupId=$json0["1"]["userGroupNamespace"]["groupId"];
##################################################33
   $bbk1="/apis/merchant-insights/v1/user/updateSession";
   
  $url="https://business-api.phonepe.com$bbk1";
  
 $data0='{"userGroupId":8115176}';
 
 $lenth=strlen($data0);
$checksum = file_get_contents("https://couponcart.in/phnpe/checksum_my.php?trd=$bbk1$data0");
  $checksum= substr("$checksum",4);
  $headers = array("Host: business-api.phonepe.com","authorization: Bearer $token","x-farm-request-id: $sfarm","x-app-id: bd309814ea4c45078b9b25bd52a576de","x-merchant-id: PHONEPEBUSINESS","x-source-type: PB_APP","x-source-platform: ANDROID","x-source-locale: en","x-source-version: 1290004039","fingerprint: $device_fingerprint","x-device-fingerprint: $fingerprint","x-app-version: 0.4.39","x-request-sdk-checksum: $checksum","content-type: application/json; charset=utf-8","content-length: $lenth","accept-encoding: gzip","user-agent: okhttp/3.12.13","X-Forwarded-For: $ip");

 $userdetils=request($url,$data0,POST,$headers,0);
echo "<br>$userdetils<br>";
      $json0=json_decode($userdetils,1);
$token=$json0["token"];
$refreshToken=$json0["refreshToken"];

if($token==""){
    
}else{

$data= ' {
      "token":"'.$token.'",
      "refreshToken":"'.$refreshToken.'"
  }';
    
file_put_contents('refresh_Token/'.$no.'.json', $data);
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
