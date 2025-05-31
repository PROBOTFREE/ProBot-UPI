
<?php

$title .= EarnMoney;

if( $_SESSION["msmbilisim_userlogin"] != 1  || $user["client_type"] == 1  ){
  Header("Location:".site_url('logout'));
}
if( $settings["email_confirmation"] == 1  && $user["email_type"] == 1  ){
  Header("Location:".site_url('confirm_email'));
}
      if ($settings["promotion"] == 1) :
        header("Location:" . site_url());
      endif;

if( !route(1) ){

  $earn = $conn->prepare("SELECT * FROM earn WHERE client_id=:c_id ");
  $earn-> execute(array("c_id"=>$user["client_id"]));
  $earn = $earn->fetchAll(PDO::FETCH_ASSOC);
 
  if( $_POST ){
    foreach ($_POST as $key => $value) {
      $_SESSION["data"][$key]  = $value;
    }
    $link  = $_POST["link"];
      if( empty($link) ){
        $error    = 1;
        $errorText= "Enter Valid Link";
      }else{
        $conn->beginTransaction();
        $insert = $conn->prepare("INSERT INTO earn SET client_id=:c_id, link=:link ");
        $insert = $insert->execute(array("c_id"=>$user["client_id"],"link"=>$link ));
          if( $insert ){ $ticket_id = $conn->lastInsertId(); }
       
        if( $insert ):
          unset($_SESSION["data"]);
          header('Location:'.site_url('earn/').$earn_id);
          $conn->commit();
          if( $settings["alert_newticket"] == 2 ):
            if( $settings["alert_type"] == 3 ):   $sendmail = 1; $sendsms  = 1; elseif( $settings["alert_type"] == 2 ): $sendmail = 1; $sendsms=0; elseif( $settings["alert_type"] == 1 ): $sendmail=0; $sendsms  = 1; endif;
            if( $sendsms ):
              SMSUser($settings["admin_telephone"],"On your website #".$ticket_id."You has a new Promotion Link.");
            endif;
            if( $sendmail ):
              sendMail(["subject"=>"New support request available.","body"=>"On your website #".$ticket_id." You has a Promotion Link","mail"=>$settings["admin_mail"]]);
            endif;
          endif;
        else:
          $error    = 1;
          $errorText= "Failed";
          $conn->rollBack();
        endif;
      }
  }


}elseif( route(1) && preg_replace('/[^a-zA-Z]/', '', route(1))  ){

  header('Location:'.site_url('404'));

}






$earn = $conn->prepare("SELECT * FROM earn WHERE client_id=:c_id ");
  $earn-> execute(array("c_id"=>$user["client_id"]));
  $earn = $earn->fetchAll(PDO::FETCH_ASSOC);
  $earnList = [];

    foreach ($earn as $earn ) {
      
$e["id"]  = $earn["earn_id"];
   $e["link"]  = $earn["link"]; 
$e["note"]  = $earn["earn_note"];
$e["status"]  = $earn["status"];   
      array_push($earnList,$e);
    }
