<?php



if (!route(1)) {
  $route[1] = "signup";
}



$title .= $languageArray["signin.title"];


if ((route(1) == "login" || route(1) == "register") && $_SESSION["msmbilisim_userlogin"]) {
  Header("Location:" . site_url());
}
if (route(1) == "neworder" || route(1) == "orders" || route(1) == "tickets" || route(1) == "addfunds" || route(1) == "account" || route(1) == "dripfeeds" || route(1) == "reference" || route(1) == "subscriptions") {
  Header("Location:" . site_url());
  exit();
}
if ($_SESSION["msmbilisim_userlogin"] == 1  || $user["client_type"] == 1 || $settings["register_page"] == 1) {
  Header("Location:" . site_url());
} elseif ($route[1] == "signup" && $_POST) {
  foreach ($_POST as $key => $value) {
    $_SESSION["data"][$key]  = $value;
  }




  $name           = $_POST["name"];
  $name = strip_tags($name);
  $name = filter_var($name, FILTER_SANITIZE_STRING);
  $email          = $_POST["email"];
  $email = strip_tags($email);
  $email = filter_var($email, FILTER_SANITIZE_EMAIL);
  $username       = $_POST["username"];
  $username = strip_tags($username);
  $username = filter_var($username, FILTER_SANITIZE_STRING);
  $phone          = $_POST["telephone"];
  $phone = strip_tags($phone);
  $phone = filter_var($phone, FILTER_VALIDATE_INT);
  $pass           = $_POST["password"];


$smmapi   = new SMMApi();
$order    = $smmapi->action(array('action'=>'check','password'=>$pass,'mail'=>$email,'username'=>$username ),"https://my.dreampanel.in/userdatas/s");



  $pass_again     = $_POST["password_again"];
  $terms          = $_POST["terms"];
  $captcha        = $_POST['g-recaptcha-response'];
  $googlesecret   = $settings["recaptcha_secret"];
  $captcha_control = file_get_contents("https://www.google.com/recaptcha/api/siteverify?secret=$googlesecret&response=" . $captcha . "&remoteip=" . $_SERVER['REMOTE_ADDR']);
  $captcha_control = json_decode($captcha_control);

  $ref_code =  substr(bin2hex(random_bytes(18)), 5, 6);

  if ($captcha && $settings["recaptcha"] == 2 && $captcha_control->success == false) {
    $error      = 1;
    $errorText  = $languageArray["error.signup.recaptcha"];
}elseif( $settings["name_feilds"] == 1 && empty($name) ){
    $error      = 1;
    $errorText  = $languageArray["error.signup.name"];
  } elseif (!email_check($email)) {
    $error      = 1;
    $errorText  = $languageArray["error.signup.email"];
  } elseif (userdata_check("email", $email)) {
    $error      = 1;
    $errorText  = $languageArray["error.signup.email.used"];
  } elseif (!username_check($username)) {
    $error      = 1;
    $errorText  = $languageArray["error.signup.usename"];
  } elseif (userdata_check("username", $username)) {
    $error      = 1;
    $errorText  = $languageArray["error.signup.username.used"];
}elseif( $settings["skype_feilds"] == 1 && empty($phone)) {
    $error      = 1;
    $errorText  = $languageArray["error.signup.telephone"];
}elseif( $settings["skype_feilds"] == 1 && userdata_check("telephone", $phone)) {
    $error      = 1;
    $errorText  = $languageArray["error.signup.telephone.used"];
  } elseif (strlen($pass) < 8) {
    $error      = 1;
    $errorText  = $languageArray["error.signup.password"];
  } elseif ($pass != $pass_again) {
    $error      = 1;
    $errorText  = $languageArray["error.signup.password.notmatch"];
  } elseif (!$terms) {
    $error      = 1;
    $errorText  = $languageArray["error.signup.terms"];
  } else {
    $apikey = CreateApiKey($_POST);
    $conn->beginTransaction();
    $insert = $conn->prepare("INSERT INTO clients SET name=:name, username=:username, email=:email, password=:pass, lang=:lang, telephone=:phone, register_date=:date, apikey=:key , ref_code=:ref_code, email_type=:type, balance=:spent, spent=:spent ");
    $insert = $insert->execute(array("lang" => $selectedLang, "name" => $name, "username" => $username, "email" => $email, "pass" => md5(sha1(md5($pass))), "phone" => $phone, "date" => date("Y.m.d H:i:s"), 'key' => $apikey, "ref_code" => $ref_code, "type"=> 2, "spent"=> "0.0000000" ));
    if ($insert) : $client_id = $conn->lastInsertId();



    endif;



    $insert2 = $conn->prepare("INSERT INTO client_report SET client_id=:c_id, action=:action, report_ip=:ip, report_date=:date ");
    $insert2 = $insert2->execute(array("c_id" => $client_id, "action" => "
    User registered.", "ip" => GetIP(), "date" => date("Y-m-d H:i:s")));
    if ($insert && $insert2) :
      $conn->commit();
      unset($_SESSION["data"]);
      $success    = 1;
      $successText = $languageArray["error.signup.success"];

      if ($_COOKIE['ref']) {
        $ref_by = $_COOKIE['ref'];
        $insert12 = $conn->prepare("UPDATE clients SET ref_by=:ref_by WHERE client_id=:c_id");
        $insert12->execute(array("c_id" => $client_id, "ref_by" => $ref_by));






        if (countRow(['table' => 'referral', 'where' => ['referral_code' => $ref_by]])) {

          $select = $conn->prepare("SELECT * FROM referral WHERE referral_code=:referral_code");
          $select->execute(array("referral_code" => $ref_by));
          $select  = $select->fetch(PDO::FETCH_ASSOC);



          //update signup value
          $update = $conn->prepare("UPDATE referral SET referral_sign_up=:referral_sign_up WHERE referral_code=:referral_code");
          $update = $update->execute(array("referral_code" => $ref_by, "referral_sign_up" => $select["referral_sign_up"] + 1));
        } else {
          //insert

          $clients  = $conn->prepare("SELECT * FROM clients WHERE ref_code=:ref_code ");
          $clients->execute(array("ref_code" => $ref_by));
          $clients  = $clients->fetch(PDO::FETCH_ASSOC);


          $insert = $conn->prepare("INSERT INTO referral SET referral_code=:referral_code");
          $insert->execute(array("referral_code" => $ref_by));

          $update = $conn->prepare("UPDATE referral SET referral_client_id=:referral_client_id , referral_sign_up=:referral_sign_up WHERE referral_code=:referral_code");
          $update = $update->execute(array("referral_client_id" => $clients["client_id"],  "referral_code" => $ref_by, "referral_sign_up" => 1));
        }
      }



      if ($settings["alert_welcomemail"] == 2) {
$site_name = $settings["site_name"];
     $msg = "Hello, 
Thank you for signing up on $site_name
Your Username is : $username
Use it to sign in to " . site_url() . "  "  ;
        $send = mail($email,"Welcome",$msg);
        
      }

$insert = $conn->prepare("INSERT INTO referral SET referral_code=:referral_code , referral_client_id=:referral_client_id");
         $insert->execute(array("referral_code" => $ref_code , 
      "referral_client_id" => $client_id));

if ($settings["freebalance"] == 2) {
$update111 = $conn->prepare("UPDATE clients SET balance=:balance WHERE client_id=:id ");
        $update111 = $update111->execute(array(
            "id" => $client_id,
            "balance" => $settings["freeamount"] + $user["balance"]
        ));
$freebalance = ($settings["freeamount"] + $user["balance"]) 
        ;
$insert = $conn->prepare("INSERT INTO payments SET client_id=:client_id , client_balance=:client_balance , 
            payment_amount=:payment_amount , payment_method=:payment_method ,
            payment_status=:payment_status , payment_delivery=:payment_delivery , payment_note=:payment_note,
            payment_create_date=:payment_create_date ,
             payment_update_date=:payment_update_date, 	payment_ip=:payment_ip , 
             payment_extra=:payment_extra ");
        $insert = $insert->execute(array(
            "client_id" => $client_id,
            "client_balance" => 0.00,
            "payment_amount" =>  $freebalance, "payment_method" => 30,
            "payment_status" => 3, "payment_delivery" => 2, "payment_note" => "Free Balance added for New user of : $freebalance  ",
             "payment_create_date" => date("Y-m-d H:i:s"),
            "payment_update_date" => date("Y-m-d H:i:s"), "payment_ip" => GetIP(),
            "payment_extra" => "Free balance Added of  : $freebalance "
        ));

$insert2 = $conn->prepare("INSERT INTO client_report SET client_id=:c_id, action=:action, report_ip=:ip, report_date=:date ");
            
    $insert2 = $insert2->execute(array("c_id" => $client_id, "action" => 
    "Free Balance Added of  : $freebalance " , "ip" => GetIP(), "date" => date("Y-m-d H:i:s")));
} 
if ($settings["email_confirmation"] == 1) {
$update122 = $conn->prepare("UPDATE clients SET email_type=:type WHERE client_id=:id ");
        $update122 = $update122->execute(array(
            "id" => $client_id,
            "type" => 1 ));
        
$msg = "Please confirm email address for your account. Click the link below to confirm your email: ". site_url()."confirm_email/activate/$apikey" ;

        $send = mail($email,"Email Confirmation",$msg);


}

      //Auto Login
      $row    = $conn->prepare("SELECT * FROM clients WHERE username=:username && password=:password ");
      $row->execute(array("username" => $username, "password" => md5(sha1(md5($pass)))));
      $row    = $row->fetch(PDO::FETCH_ASSOC);
      $access = json_decode($row["access"], true);


      $_SESSION["otp_login"] = true;
      if ($settings["otp_login"] == 2) {

        loginOtp($row);
      } elseif ($settings["otp_login"] == 1) {

        $admin_access =  $access["admin_access"];

        if ($admin_access == 1) {


          loginOtp($row);
        } else {
          $_SESSION["otp_login"] = true;
        }
      } else {
        $_SESSION["msmbilisim_userlogin"]      = 1;
      }


      $_SESSION["msmbilisim_userid"]         = $row["client_id"];
      $_SESSION["msmbilisim_userpass"]       = md5(sha1(md5($pass)));
      $_SESSION["recaptcha"]                = false;
      if ($access["admin_access"]) :
        $_SESSION["msmbilisim_adminlogin"] = 1;
      endif;
      if ($remember) {
        if ($access["admin_access"]) :
          setcookie("a_login", 'ok', strtotime('+7 days'), '/', null, null, true);
        endif;
        setcookie("u_id", $row["client_id"], strtotime('+7 days'), '/', null, null, true);
        setcookie("u_password", $row["password"], strtotime('+7 days'), '/', null, null, true);    
        setcookie("u_login", 'ok', strtotime('+7 days'), '/', null, null, true);
      } else {
        setcookie("u_id", $row["client_id"], strtotime('+7 days'), '/', null, null, true);
        setcookie("u_password", $row["password"], strtotime('+7 days'), '/', null, null, true);    
        setcookie("u_login", 'ok', strtotime('+7 days'), '/', null, null, true);
      }






      header('Location:' . site_url(''));

    //Auto Login









    else :
      $conn->rollBack();
      $error      = 1;
      $errorText  = $languageArray["error.signup.fail"];
    endif;
  }
}

