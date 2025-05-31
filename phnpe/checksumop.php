

<?php


  function checksumopp($data) {
 function RandomString($length) {
    $keys = array_merge(range('9', '0'), range('a', 'f'));
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
$mh = RandomString(4);
$mi = RandomString(4);
$mj = RandomString(22);
$mk = RandomString(35);
 $advikey="$mb-$md-$mc-$mh-$mf";
// echo "<br>";
// $advikey="d016d08a-14ae-56c3-594d-6430e2c860f9";
    function keygen($advid){
    $ket="1lgVNAAtWyq06UfYjM/UBnJ5ZSA=";
  $aa1= substr("$ket",0,1);
  $a1= substr("$ket",1,1);
  $a2= substr("$ket",2,1);
  $a3= substr("$ket",3,1);
  $a4= substr("$ket",4,1);
  $a5= substr("$ket",5,1);
  $a6= substr("$ket",6,1);
  $a7= substr("$ket",7,1);
  $a8= substr("$ket",8,1);
  $a9= substr("$ket",9,1);
  $a10= substr("$ket",10,1);
  $a11= substr("$ket",11,1);
  $a12= substr("$ket",12,1);
  $a13= substr("$ket",13,1);
  $a14= substr("$ket",14,1);
  $a15= substr("$ket",15,1);
    $adv=$advid;
  $aa= substr("$adv",0,1);
  $ab= substr("$adv",1,1);
  $ac= substr("$adv",2,1);
  $ad= substr("$adv",3,1);
  $ae= substr("$adv",4,1);
  $af= substr("$adv",5,1);
  $ag= substr("$adv",6,1);
  $ah= substr("$adv",7,1);
  $ai= substr("$adv",8,1);
  $aj= substr("$adv",9,1);
  $ak= substr("$adv",10,1);
  $al= substr("$adv",11,1);
  $am= substr("$adv",12,1);
  $an= substr("$adv",13,1);
  $ao= substr("$adv",14,1);
  $ap= substr("$adv",15,1);
  
$str="$aa1$aa$a1$ab$a2$ac$a3$ad$a4$ae$a5$af$a6$ag$a7$ah$a8$ai$a9$aj$a10$ak$a11$al$a12$am$a13$an$a14$ao$a15$ap";
return $str;
}
$keytry=keygen($advikey);
 $aeskey=hash('sha1', $keytry,1);
$fatrs=$data;
 $datahash=base64_encode(hash('sha256', $fatrs,1));
date_default_timezone_set("Asia/Calcutta");   //India time (GMT+5:30)
 $milliseconds = floor(microtime(true) * 1000);

          function encryptt($data,$hkey) {
$bytes=array(-105,119,-106,-10,5,69,-40,84,43,-49,61,-70,59,-57,-8,-125,41,111,-106,-15);

$key="";
for($i=0;$i< count($bytes);$i++){
$key.=chr($bytes[$i]);
}
$encryptedd = openssl_encrypt($data,"AES-128-ECB",$hkey,OPENSSL_RAW_DATA);
$encc = base64_encode($encryptedd);
return "$encc";
}
 $encc=encryptt("$milliseconds###$datahash",$aeskey);


    function fnalsing($advid,$enc){
    $ket=$enc;
  $aa1= substr("$ket",0,4);
  $a1= substr("$ket",4,4);
  $a2= substr("$ket",8,4);
  $a3= substr("$ket",12);
  $a4= substr("$ket",4,1);
  $a5= substr("$ket",5,1);
  $a6= substr("$ket",6,1);
  $a7= substr("$ket",7,1);
  $a8= substr("$ket",8,1);
  $a9= substr("$ket",9,1);
  $a10= substr("$ket",10,1);
  $a11= substr("$ket",11,1);
  $a12= substr("$ket",12,1);
  $a13= substr("$ket",13,1);
  $a14= substr("$ket",14,1);
  $a15= substr("$ket",15,1);
    $adv=$advid;
  $aa= substr("$adv",0,4);
  $ab= substr("$adv",4,4);
  $ac= substr("$adv",8,4);
  $ad= substr("$adv",12,4);
  $ae= substr("$adv",4,1);
  $af= substr("$adv",5,1);
  $ag= substr("$adv",6,1);
  $ah= substr("$adv",7,1);
  $ai= substr("$adv",8,1);
  $aj= substr("$adv",9,1);
  $ak= substr("$adv",10,1);
  $al= substr("$adv",11,1);
  $am= substr("$adv",12,1);
  $an= substr("$adv",13,1);
  $ao= substr("$adv",14,1);
  $ap= substr("$adv",15,1);
  
$str=base64_encode("$aa$aa1$ab$a1$ac$a2$ad$a3");
return $str;
}

$fainalsungeture=fnalsing($advikey,$encc);


    return "$fainalsungeture";
}



