

<?php

error_reporting(0);
// Function to sanitize user input
function sanitizeInput($input) {
    if (is_string($input)) {
        return htmlspecialchars(trim($input), ENT_QUOTES, 'UTF-8');
    } else {
        // Handle non-string input here (e.g., arrays, objects, etc.) if needed.
        return $input;
    }
}



$no = filter_var($_REQUEST['no'], FILTER_VALIDATE_INT);
$pin = filter_var($_REQUEST['pin'], FILTER_VALIDATE_INT);
$sessionid = filter_var($_REQUEST['sessionid'], FILTER_SANITIZE_STRING);




 function RandomString($length) {
    $keys = array_merge(range('9', '0'), range('a', 'f'));
    for($i=0; $i < $length; $i++) {
        $key .= $keys[array_rand($keys)];
    }
    return $key;
}

 function Randomng($length) {
    $keys = array_merge(range('1', '7'));
    for($i=0; $i < $length; $i++) {
        $key .= $keys[array_rand($keys)];
    }
    return $key;
}
 
$mom = RandomString(16);
$mon = RandomString(15);
$mo = RandomString(4);
$ma = RandomString(12);
$mb = RandomString(8);
$mc = RandomString(4);
$md = RandomString(4);
$me = RandomString(4);
$mf = RandomString(12);
$mg = RandomString(8);
$mh = RandomString(3);
$mi = RandomString(4);
$mj = RandomString(22);
$mk = RandomString(35);
$advid="$mb-$md-$mc-$mh-$mf";
$cku="$mg-$mi-$me-$mo-$ma";

function RandomNumber($length){
$str="";
for($i=0;$i<$length;$i++){
$str.=mt_rand(0,9);
}
return $str;
}
$bb = RandomNumber(4);
$db = RandomNumber(8);
$nom = RandomNumber(18);
$gmaill= "$fname$bb";
  $tz = 'Asia/Kolkata';   
   date_default_timezone_set($tz);
$ipp=long2ip(rand());
 $newDateTime = date('d\/Y h:t A');
$result = uniqid();
  include("config.php");
  

if(isset($no))
{

$PAYLOAD=encrypt('{"loginId":"'.$no.'","authType":"mPin","mPin":"'.$pin.'","fcmToken":"","appInstanceId":"","simID":""}',$aeskey,$aesiv);
$key=RsaPcs1($aeskey);
$iv=base64_encode($aesiv);
$url="https://hdfcmmp.mintoak.com/OneAppAuth/VerifyPin";
$data0='{"KEY":"'.$key.'","IV":"'.$iv.'","PAYLOAD":"'.$PAYLOAD.'"}';
$headers = array("Host: hdfcmmp.mintoak.com","motoken: ","sessionid: $sessionid","content-type: application/json","accept-encoding: gzip","user-agent: okhttp/4.9.1");
$userdetils=request($url,$data0,POST,$headers,0);
echo $userdetils=decrypt($userdetils,$aeskey,$aesiv);
$json = json_decode($userdetils,true);
$status=$json["status"];
$respMessage=$json["respMessage"];
$isMpinSet=$json["isMpinSet"];
$statusCode=$json["statusCode"];
$sessionId=$json["sessionId"];
$loginName=$json["loginName"];
$signUpStatus=$json["signUpStatus"];
$isTouchIdSet=$json["isTouchIdSet"];
$isFaceIdSet=$json["isFaceIdSet"];
$updateType=$json["updateType"];
//echo '{"status":"'.$status.'","respMessage":"'.$respMessage.'","statusCode":"'.$statusCode.'","isMpinSet":'.$isMpinSet.',"isTouchIdSet":'.$isTouchIdSet.',"isFaceIdSet":'.$isFaceIdSet.',"updateType":"'.$updateType.'","sessionId":"'.$sessionId.'","mobileNumber":"'.$no.'","loginName":"'.$loginName.'","loginType":"MobileNumber","signUpStatus":"'.$signUpStatus.'"}';
        
// if($status=="Success"){
//     if($respMessage=="OTP Sent "){
        

// //          echo "<center><b><font color='#0A9B26' size='5'>status $status <br>Hi.. $loginName <br>respMessage $respMessage <br> isMpinSet $isMpinSet <br>signUpStatus $signUpStatus<br></font><br></center>"; 
        
// //         echo"<center><br><form action='vf.php' method='GET'>
// // <input  type='text' name='no' value='$no'>
// // <input  type='text' name='otp' placeholder='ENTER OTP'><br><br>
// // <input  type='text' name='sessionId' value='$sessionId'>
// // <input  type='text' name='deviceid' value='$mom'>

// // <button  id='button'>Start</button></form></center>";
        
        
//     }else{
        
//         echo "otp not sent";
//     }
    
    
    
// }else{
    
//       echo "mobile not register";
// }



}

if(!isset($no))
{
// echo"<center><br><form action='' method='GET'>
// <input  type='text' name='no' placeholder='ENTER NUMBER'><br><br>

// <button  id='button'>Start</button></form></center>";
}

?>

