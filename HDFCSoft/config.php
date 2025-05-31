<?php


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
curl_setopt($ch, CURLOPT_FOLLOWLOCATION, 1);
curl_setopt($ch, CURLOPT_ENCODING, 'gzip');  
curl_setopt($ch, CURLOPT_HEADER, $yes);
 $output1= curl_exec ($ch); 
  return $output1;
  }
  
  function RsaPcs1($data){
    $public_key = file_get_contents('public.key');
    $rsa = openssl_public_encrypt($data,$rsa_key,$public_key,OPENSSL_PKCS1_OAEP_PADDING);
    return base64_encode($rsa_key);    
}

function encrypt($data,$key,$iv)
{
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


 function decrypt($data,$key,$iv)
{

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
