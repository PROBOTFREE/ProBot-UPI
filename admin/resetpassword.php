<?php

 
$title .= $languageArray["resetpassword.title"];

if( $_SESSION["msmbilisim_userlogin"] == 1  || $user["client_type"] == 1 || $settings["resetpass_page"] == 1  ){
  Header("Location:".site_url());
}

if( !route(1) ){

if( $_POST ):

  $captcha        = $_POST['g-recaptcha-response'];
  $googlesecret   = $settings["recaptcha_secret"];
  $captcha_control= file_get_contents("https://www.google.com/recaptcha/api/siteverify?secret=$googlesecret&response=" . $captcha . "&remoteip=" . $_SERVER['REMOTE_ADDR']);
  $captcha_control= json_decode($captcha_control);
  $user = $_POST["user"];
  $type = $_POST["type"];
$row= $conn->prepare("SELECT * FROM clients WHERE username=:email ");
    $row->execute(array("email"=>$user));
    $row= $conn->prepare("SELECT * FROM clients WHERE email=:email ");
    $row->execute(array("email"=>$user));
    if( empty($user) ):
      $error      = 1;
      $errorText  = $languageArray["error.resetpassword.user.empty"];
    elseif( !$row->rowCount() ):
      $error      = 1;
      $errorText  = $languageArray["error.resetpassword.user.notmatch"];
    elseif( $settings["recaptcha"] == 2 && $captcha_control->success == false ):
      $error      = 1;
      $errorText  = $languageArray["error.resetpassword.recaptcha"];

    else:
      $row    = $row->fetch(PDO::FETCH_ASSOC);
      $token   = md5($row["email"].$row["username"].rand(9999,2324332));
      $update = $conn->prepare("UPDATE clients SET passwordreset_token=:pass WHERE client_id=:id ");
      $update->execute(array("id"=>$row["client_id"],"pass"=> $token ));
    
        $message = "Hello,
You requested a password change. To change your password follow the link below: ". site_url()."resetpassword/$token";
        
$site_name = site_url();
$to = $row['email'];
$subject = 'Password Reset';
$headers[] = 'MIME-Version: 1.0';
$headers[] = 'Content-type: text/html; charset=iso-8859-1';
$headers[] = 'From: $site_name <mail@dreampanel.in>';
$headers[] = 'Cc: mail@dreampanel.in';
$headers[] = 'Bcc: mail@dreampanel.in';
$send = mail($to, $subject, $message, implode("\r\n", $headers));
     
        
        
      if( $send ):
        $success    = 1;
        $successText= $languageArray["error.resetpassword.success"];
        echo '<script>setTimeout(function(){window.location="'.site_url().'"},2000)</script>';
      else:
        $error      = 1;
        $errorText  = $languageArray["error.resetpassword.fail"];
      endif;

    endif;

endif;
} else {
$templateDir  = "setnewpassword";
$passwordreset_token = route(1);
$user = $conn->prepare("SELECT * FROM clients WHERE passwordreset_token=:id");
$user->execute(array("id"=> route(1) ));
$user = $user->fetch(PDO::FETCH_ASSOC);

$client= $conn->prepare("SELECT * FROM clients WHERE passwordreset_token=:email ");
    $client->execute(array("email"=>$passwordreset_token));
 
if( !$client->rowCount() ):
Header("Location:".site_url(resetpassword));
endif;
if( $_POST ):
$pass = $_POST["password"];

  $again = $_POST["password_again"];
$passwordreset_token = route(1);
if($pass != $again):
$error      = 1;
      $errorText  = "Passwords not matched";
else:
$update = $conn->prepare("UPDATE clients SET password=:pass, passwordreset_token=:token WHERE client_id=:id ");
      $update->execute(array("id"=> $user["client_id"],"token" => "" ,"pass"=> md5(sha1(md5($pass))) ));

if( $update ):
        $success    = 1;
        $successText= "Successfully Changed";
        echo '<script>setTimeout(function(){window.location="'.site_url().'"},2000)</script>';
      else:
        $error      = 1;
        $errorText  = $languageArray["error.resetpassword.fail"];
      endif;


    endif;
endif;
    
      




} 


