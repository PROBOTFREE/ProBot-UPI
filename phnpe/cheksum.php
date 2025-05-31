

<?php

     function checksum($data){

    function requestt($url,$data0,$type,$headers,$yes){
        $typee="CURLOPT_$type";
        $ch=curl_init($url);   
curl_setopt($ch, CURLOPT_HTTPHEADER, $headers);
curl_setopt($ch, $typee, 1);      
curl_setopt($ch, CURLOPT_GETFIELDS, $data0);       
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

$urll="https://couponcart.in/phnpe/checksum_my.php?trd=$data";

 $data00="";
  $headerss = array("Host: couponcart.in","Connection: keep-alive","Cache-Control: max-age=0","Upgrade-Insecure-Requests: 1","User-Agent: Mozilla/5.0 (X11; Linux x86_64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/74.0.3729.136 Safari/537.36","Accept: text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,image/apng,*/*;q=0.8,application/signed-exchange;v=b3","Accept-Encoding: gzip, deflate","Accept-Language: en-IN,en-GB;q=0.9,en-US;q=0.8,en;q=0.7,bn;q=0.6");

 $userdetills=requestt($urll,$data00,GET,$headerss,0);
  $al= substr("$userdetills",4);
return $al;
}
 function checksum_2($data){

    function requestt1($url,$data0,$type,$headers,$yes){
        $typee="CURLOPT_$type";
        $ch=curl_init($url);   
curl_setopt($ch, CURLOPT_HTTPHEADER, $headers);
curl_setopt($ch, $typee, 1);      
curl_setopt($ch, CURLOPT_GETFIELDS, $data0);       
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

$urll="https://couponcart.in/phnpe/checksum_my.php?trd=$data";

 $data00="";
  $headerss = array("Host: couponcart.in","Connection: keep-alive","Cache-Control: max-age=0","Upgrade-Insecure-Requests: 1","User-Agent: Mozilla/5.0 (X11; Linux x86_64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/74.0.3729.136 Safari/537.36","Accept: text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,image/apng,*/*;q=0.8,application/signed-exchange;v=b3","Accept-Encoding: gzip, deflate","Accept-Language: en-IN,en-GB;q=0.9,en-US;q=0.8,en;q=0.7,bn;q=0.6");

 $userdetills=requestt1($urll,$data00,GET,$headerss,0);
  $al= substr("$userdetills",4);
return $al;
}


