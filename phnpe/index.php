

<?php
error_reporting(0);
   function sentotp($work,$no,$otp,$otp_toekn,$device_data){
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


         function rand_float($st_num=0,$end_num=1,$mul=1000000)
{
if ($st_num>$end_num) return false;
return mt_rand($st_num*$mul,$end_num*$mul)/$mul;
}

// Random Location
$latitude = rand_float(10.00,25.99);
$longitude = rand_float(27.00,80.99);
$radius = rand(1,100);
$constant = "69";
//Minimum and Maximum Geo location setup
 
//Minimum longitude $lng_min = $longitude - $radius / abs(cos(deg2rad($latitude)) * $constant); 

//Maximum longitudel
$lng = substr($longitude + $radius / abs(cos(deg2rad($latitude)) * $constant),0,10);

// Minimum latitude
$lat = substr($latitude - ($radius / $constant),0,10); 
//Maximum latitude  $lat_max = $latitude + ($radius / $constant);


// Random IP 
$z=rand(1,240);
$x=rand(1,240);
$c=rand(1,240);
$v=rand(1,240);

$ip=$z.".".$x.".".$c.".".$v;
    
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
        include "checksumop.php";
    if($work=="1"){
 $datahash=hash('sha256', $nom);
   $aa= substr("$datahash",0,32);
    $datahassh=hash('sha256', $db);
   $aa2= substr("$datahassh",0,32);
   $deviceFingerprint=''.$mom.'c2RtNjM2-cWNvbQ-';
   
 $fingerprint="$aa2.$aa.Xiaomi.$mon";
   $bbk="/apis/merchant-insights/v3/auth/sendOtp";
  $url="https://business-api.phonepe.com$bbk";
 $data0='{"type":"OTP","phoneNumber":"'.$no.'","deviceFingerprint":"'.$deviceFingerprint.'"}';
 $lenth=strlen($data0);

  $checksum=checksum("$bbk$data0");
  
    $headers = array("Host: business-api.phonepe.com","x-app-id: bd309814ea4c45078b9b25bd52a576de","x-merchant-id: PHONEPEBUSINESS","x-source-type: PB_APP","x-source-platform: ANDROID","x-source-locale: en","x-source-version: 1290004046","fingerprint: $fingerprint","x-device-fingerprint: $deviceFingerprint","x-app-version: 0.4.46","x-request-sdk-checksum: $checksum","content-type: application/json; charset=utf-8","content-length: $lenth","accept-encoding: gzip","user-agent: okhttp/3.12.13 ","X-Forwarded-For: $ip");

$userdetils=request($url,$data0,POST,$headers,0);
//echo $userdetils;
      $json0=json_decode($userdetils,1);
$token=$json0["token"];
$expiryl=$json0["expiry"];
if($expiryl=="600,"){
    $device=bin2hex("$fingerprint||$deviceFingerprint||$ip");
    $results='{"otpSended":"true","phoneNumber":"'.$no.'","token":"'.$token.'","device":"'.$device.'"}';


    
}else{
   $results='{"otpSended":"false","phoneNumber":"'.$no.'"}';
  
} 
        
    }elseif($work=="2"){
        
        $encode_device_data=$device_data;
        $device_data=hex2bin($device_data);
 $acc = rtrim($f_contents[$x]);
$ex=explode("||",$device_data);
 $fingerprint=$ex[0];
 $xdevicefingerpint=$ex[1];
 $ip=$ex[2];


   $bbk="/apis/merchant-insights/v3/auth/login";
  $url="https://business-api.phonepe.com$bbk";
 $fact2=substr($xdevicefingerpint,0,16);
$g1=explode(".",$fingerprint)[3]; 
$osid=explode(".",$fingerprint)[0]; 
$xdhp=explode(".",$fingerprint)[1]; 
$milliseconds = floor(microtime(true) * 1000);
 
 $data0='{"type":"OTP","clientContext":"{\"device\":{\"identifier\":{\"macAddress\":\"00:00:00:00:00:00\",\"fact1\":\"\",\"fact2\":\"'.$fact2.'\",\"fact3\":\"NA\",\"gd\":{\"g1\":\"'.$g1.'\"},\"omid\":\"Xiaomi\",\"osid\":\"'.$osid.'\",\"pid\":\"NA\",\"xdhp\":\"'.$xdhp.'\"},\"location\":{\"latitude\":0,\"longitude\":0,\"confidence\":0,\"locs\":-1},\"network\":{\"ipv4\":\"'.$ip.'\",\"ipv6\":\"NA\",\"bssid\":\"NA\",\"ssid\":\"<unknown ssid>\",\"essid\":\"NA\",\"ipm\":1},\"cellularNetwork\":{\"dualSim\":false,\"towers\":[]},\"security\":{\"as\":false,\"emulated\":false,\"rooted\":false,\"safetyNetScore\":0.5,\"dsec\":1,\"emuChk\":false,\"rck\":{\"a\":false,\"b\":\"\"},\"macct\":{}},\"software\":{\"os\":{\"name\":\"Android\",\"version\":\"30\",\"manu\":\"Xiaomi\",\"model\":\"Xiaomi\",\"buildTime\":\"'.$milliseconds.'\"}},\"call\":{\"cs\":0,\"lcs\":\"0,\",\"vcs\":0},\"ui\":{\"doa\":0,\"doaN\":[]}}}","deviceFingerprint":"'.$xdevicefingerpint.'","otp":"'.$otp.'","token":"'.$otp_toekn.'","phoneNumber":"'.$no.'"}';
  
  
 $lenth=strlen($data0);
   $checksum=checksumopp("$bbk$data0");

      $headers = array("Host: business-api.phonepe.com","x-app-id: bd309814ea4c45078b9b25bd52a576de","x-merchant-id: PHONEPEBUSINESS","x-source-type: PB_APP","x-source-platform: ANDROID","x-source-locale: en","x-source-version: 1290004046","fingerprint: $fingerprint","x-device-fingerprint: $xdevicefingerpint","x-app-version: 0.4.46","x-request-sdk-checksum: $checksum","content-type: application/json; charset=utf-8","content-length: $lenth","accept-encoding: gzip","user-agent: okhttp/3.12.13","X-Forwarded-For: $ip");
$userdetils=request($url,$data0,POST,$headers,0);
//echo $userdetils;
      $json0=json_decode($userdetils,1);
$userId=$json0["userId"];
$success=$json0["success"];
$token=$json0["token"];
$refreshToken=$json0["refreshToken"];
$namee=$json0["name"];

if($success=="true,"){
    //refreshtoken
      $bbk="/apis/merchant-insights/v1/auth/refresh";
  $url="https://business-api.phonepe.com$bbk";
 $data0='{}';
 $lenth=strlen($data0);
 $checksum=checksum_2("$bbk$data0");
 
   $headers = array("Host: business-api.phonepe.com","x-refresh-token: $refreshToken","x-auth-token: $token","x-farm-request-id: $farm","x-app-id: bd309814ea4c45078b9b25bd52a576de","x-merchant-id: PHONEPEBUSINESS","x-source-type: PB_APP","x-source-platform: ANDROID","x-source-locale: en","x-source-version: 1290004046","fingerprint: $fingerprint","x-device-fingerprint: $xdevicefingerpint","x-app-version: 0.4.46","x-request-sdk-checksum: $checksum","content-type: application/json; charset=utf-8","content-length: $lenth","accept-encoding: gzip","user-agent: okhttp/3.12.13","X-Forwarded-For: $ip");

$userdetils=request($url,$data0,POST,$headers,0);
//echo $userdetils;
      $json0=json_decode($userdetils,1);
$token=$json0["token"];
$refreshToken=$json0["refreshToken"];

//marchenaccount showing

##################################################33
   $bbk1="/apis/merchant-insights/v1/user/merchant/groupInfoList";
  $url="https://business-api.phonepe.com$bbk1";
 $data0='';
$checksum = file_get_contents("https://couponcart.in/phnpe/checksum_my.php?trd=$bbk1");
  $checksum= substr("$checksum",4);
  
    $headers = array("Host: business-api.phonepe.com","authorization: Bearer $token","x-farm-request-id: $farm","content-type: application/json","x-app-id: bd309814ea4c45078b9b25bd52a576de","x-merchant-id: PHONEPEBUSINESS","x-source-type: PB_APP","x-source-platform: ANDROID","x-source-locale: en","x-source-version: 1290004046","fingerprint: $fingerprint","x-device-fingerprint: $xdevicefingerpint","x-app-version: 0.4.46","x-request-sdk-checksum: $checksum","accept-encoding: gzip","user-agent: okhttp/3.12.13","X-Forwarded-For: $ip");

$userGroupNamespace=request($url,$data0,GET,$headers,0);
//echo $userGroupNamespace;
##################################################33
  $results='{"message":"success","number":"'.$no.'","userId":"'.$userId.'","token":"'.$token.'","refreshToken":"'.$refreshToken.'","name":"'.$namee.'","device_data":"'.$encode_device_data.'","userGroupNamespace":{"All":'.$userGroupNamespace.'}}';
 // echo "$results<br>";
    
}else{
    
    $results='{"message":"INVALID_OTP","messages":"Incorrect OTP, Please Re-enter OTP"}';

}
       
    }elseif($work=="3"){
        
        $encode_device_data=$otp;
        $device_data=hex2bin($otp);
 $acc = rtrim($f_contents[$x]);
$ex=explode("||",$device_data);
 $fingerprint=$ex[0];
 $xdevicefingerpint=$ex[1];
 $ip=$ex[2];


      $bbk="/apis/merchant-insights/v1/user/updateSession";
  $url="https://business-api.phonepe.com$bbk";
 $data0='{"userGroupId":'.$otp_toekn.'}';
 $lenth=strlen($data0);
 $checksum=checksum("$bbk$data0");

$headers = array("Host: business-api.phonepe.com","authorization: Bearer $no","x-farm-request-id: $sfarm","x-app-id: bd309814ea4c45078b9b25bd52a576de","x-merchant-id: PHONEPEBUSINESS","x-source-type: PB_APP","x-source-platform: ANDROID","x-source-locale: en","x-source-version: 1290004046","fingerprint: $fingerprint","x-device-fingerprint: $xdevicefingerpint","x-app-version: 0.4.46","x-request-sdk-checksum: $checksum","content-type: application/json; charset=utf-8","content-length: $lenth","accept-encoding: gzip","user-agent: okhttp/3.12.13","X-Forwarded-For: $ip");

$userdetils=request($url,$data0,POST,$headers,0);
//echo $userdetils;
      $json0=json_decode($userdetils,1);
$success=$json0["success"];
$token=$json0["token"];
$refreshToken=$json0["refreshToken"];
$groupValue=$json0["groupValue"];

if($success=="true,"){
    
          $bbk="/apis/zencast/v1/device/register/appType/BUSINESS";
          
  $url="https://business-api.phonepe.com$bbk";
  
 $data0='{"deviceId":"'.$xdevicefingerpint.'","cloudMessagingId":"'.$mj.':APA91bFoXn4MyT6MlF0IPiHtv-4LvGsXVlnyA1cwyTogpVWPkh04KtUoyXYObXISTIvzq0l-o6oJPzwK-5VcSsTQUMG9wk8caJ58'.$mk.'","osName":"ANDROID","osVersion":"9","brand":"xiaomi","model":"Redmi","appName":"PHONEPEBUSINESS","appVersion":"0.4.46","appVersionCode":"1290004046"}';
 $lenth=strlen($data0);
 $checksum=checksum_2("$bbk$data0");
 
$headers = array("Host: business-api.phonepe.com","authorization: Bearer $no","x-farm-request-id: $sfarm","x-app-id: bd309814ea4c45078b9b25bd52a576de","x-merchant-id: PHONEPEBUSINESS","x-source-type: PB_APP","x-source-platform: ANDROID","x-source-locale: en","x-source-version: 1290004046","fingerprint: $fingerprint","x-device-fingerprint: $xdevicefingerpint","x-app-version: 0.4.46","x-request-sdk-checksum: $checksum","content-type: application/json; charset=utf-8","content-length: $lenth","accept-encoding: gzip","user-agent: okhttp/3.12.13","X-Forwarded-For: $ip");

$userdetils=request($url,$data0,POST,$headers,0);
//echo $userdetils;
    
      $results='{"message":"success","token":"'.$token.'","refreshToken":"'.$refreshToken.'","groupValue":"'.$groupValue.'"}';
}else{
    
        $results='{"message":"INVALID_DATA","messages":"Incorrect Please Contact Admin"}';
    
}

##################################################33
}



    return $results;
}


 