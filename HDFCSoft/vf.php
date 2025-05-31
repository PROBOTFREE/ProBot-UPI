
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


$no = sanitizeInput($_REQUEST['no']);
$otp = sanitizeInput($_REQUEST['otp']);
$sessionId = sanitizeInput($_REQUEST['sessionId']);
$deviceid = sanitizeInput($_REQUEST['deviceid']);

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
  
$PAYLOAD=encrypt('{"loginId":"'.$no.'","otp":"'.$otp.'"}',$aeskey,$aesiv);
$key=RsaPcs1($aeskey);
$iv=base64_encode($aesiv);
$url="https://hdfcmmp.mintoak.com/OneAppAuth/VerifyOTP";
$data0='{"KEY":"'.$key.'","IV":"'.$iv.'","PAYLOAD":"'.$PAYLOAD.'"}';
$headers = array("Host: hdfcmmp.mintoak.com","motoken: ","sessionid: $sessionId","content-type: application/json","accept-encoding: gzip","user-agent: okhttp/4.9.1");
$userdetils=request($url,$data0,POST,$headers,0);
$userdetils=decrypt($userdetils,$aeskey,$aesiv);
$json = json_decode($userdetils,true);
$status=$json["status"];
$respMessage=$json["respMessage"];
$statusCode=$json["statusCode"];

echo '{"status":"'.$status.'","respMessage":"'.$respMessage.'","deviceid":"'.$deviceid.'","statusCode":"'.$statusCode.'"}';



}

if(!isset($no))
{
// echo"<center><br><form action='' method='GET'>
// <input  type='text' name='no' placeholder='ENTER USER_ID'><br><br>
// <input  type='text' name='password' placeholder='ENTER Password'><br><br>

// <button  id='button'>Start</button></form></center>";
}

?>

