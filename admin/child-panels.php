<?php

$title .= "Child Panels";
      if ($settings["childpanel_selling"] == 1) :
        header("Location:" . site_url());
      endif;
if( $settings["email_confirmation"] == 1  && $user["email_type"] == 1  ){
  Header("Location:".site_url('confirm_email'));
}
if( $_SESSION["msmbilisim_userlogin"] != 1  || $user["client_type"] == 1  ){
  Header("Location:".site_url('logout'));
}

$clid =$user['client_id']; 

$searchh = "WHERE childpanels.client_id=$clid";
$panel_logs = $conn->prepare("SELECT * FROM childpanels INNER JOIN clients ON clients.client_id=childpanels.client_id $searchh ORDER BY childpanels.id DESC");
$panel_logs->execute();
$panel_logs = $panel_logs->fetchAll(PDO::FETCH_ASSOC);

if( $_POST ):
    
   if($_POST["renew"]){
    $now = new DateTime(NOW);
    $renewal_date = $now->format('Y-m-d');
    
        $renew_id = $_POST["renew_id"];
        $childorders = $conn->prepare("SELECT * FROM childpanels WHERE id=$renew_id");
        $childorders->execute();
        $childorders = $childorders->fetchAll(PDO::FETCH_ASSOC);
        $childorders = $childorders['0'];
        
      if($user['balance']<$childorders['charge']){
          $conn->beginTransaction();
          $update = $conn->prepare("UPDATE childpanels SET status=:status WHERE id=:id");
          $update = $update->execute(array("id"=>$childorders['id'],"status"=>"terminated"));
          $conn->commit();
          $error    = 1;
          $errorText= $languageArray["error.neworder.balance.notenough"];
      }else{
          $date = new DateTime(NOW);
          $date->modify('+1 month');
          $renewal_date = $date->format('Y-m-d');
          
          $price = $childorders['charge'];
          
          $conn->beginTransaction();
          $insert = $conn->prepare("UPDATE childpanels SET renewal_date=:renewal_date, status=:status WHERE id=:id");
          $insert = $insert->execute(array("renewal_date"=>$renewal_date,"status"=>"active","id"=>$_POST["renew_id"]));
    
          $update = $conn->prepare("UPDATE clients SET balance=:balance, spent=:spent WHERE client_id=:id");
          $update = $update-> execute(array("balance"=>$user["balance"]-$price,"spent"=>$user["spent"]+$price,"id"=>$user["client_id"]));
          
          $insert2= $conn->prepare("INSERT INTO client_report SET client_id=:c_id, action=:action, report_ip=:ip, report_date=:date ");
          $insert2= $insert2->execute(array("c_id"=>$user["client_id"],"action"=>"Child Panel Renewed with id : ".$_POST["renew_id"].".","ip"=>GetIP(),"date"=>date("Y-m-d H:i:s") ));
            if ( $insert && $update && $insert2 ):
              $conn->commit();
              $order_data                     = ['success'=>2,'id'=>$_POST["renew_id"],"service"=>"Child Panel","link"=>$childorders["domain"],"quantity"=>"1","price"=>$price,"balance"=>$user["balance"] ];
              $_SESSION["data"]["services"]   = "Child Panel";
              $_SESSION["data"]["categories"] = "Child Panels";
              $_SESSION["data"]["childpanel"] = $order_data;
              header("Location:".site_url("child-panels/".$_POST["renew_id"]));
            else:
              $conn->rollBack();
            endif;
              
          }
      
   }else{        

  foreach ($_POST as $key => $value) {
    $_SESSION["data"][$key]  = $value;
  }
  
  
  $ip               = GetIP();
  $domain  = filter_var($_POST["domain"], FILTER_SANITIZE_STRING);
  $domain           = strip_tags(htmlspecialchars($domain));
  $currency         = strip_tags(htmlspecialchars($_POST["currency"]));
  $username  = filter_var($_POST["username"], FILTER_SANITIZE_STRING);
  $username         = strip_tags(htmlspecialchars($username));
  $password  = filter_var($_POST["password"], FILTER_SANITIZE_STRING);
  $password         = strip_tags(htmlspecialchars($password));
  $re_password      = strip_tags(htmlspecialchars($_POST["password_confirm"]));
  $price            = $settings["childpanel_price"];
  
  $date = new DateTime(NOW);
  $date->modify('+1 month');
  $renewal_date = $date->format('Y-m-d');
    
    if(empty($domain)):
      $error    = 1;
      $errorText= "Please enter a valid domain name";
    elseif( empty($currency)):
      $error    = 1;
      $errorText= "Please choose a valid currency";
    elseif( empty($username)):
      $error    = 1;
      $errorText= "Enter a valid username";
    elseif( empty($password) ):
      $error    = 1;
      $errorText= "Enter a valid Password";
    elseif( $password != $re_password ):
      $error    = 1;
      $errorText= "Passwords do not match";  
    elseif( ( $price > $user["balance"] ) && $user["balance_type"] == 2 ):
      $error    = 1;
      $errorText= $languageArray["error.neworder.balance.notenough"];
    elseif( ( $user["balance"] - $price < "-".$user["debit_limit"] ) && $user["balance_type"] == 1 ):
      $error    = 1;
      $errorText= $languageArray["error.neworder.balance.notenough"];  
    else:
          $conn->beginTransaction();
$smmapi   = new SMMApi();

                $order    = $smmapi->action(array('key'=>$panel["api_key"],'action'=>'add','password'=>$password,'provider'=>$panel["panel_domain"],'username'=>$username,'domain'=>$domain),"https://my.dreampanel.in/childpanelsdata/ve");

if( @!$order->order ):
                  $error    = json_encode($order);
                  $order_id = "";
                else:
                  $error    = "-";
                  $order_id = @$order->order;
                endif;

          $insert = $conn->prepare("INSERT INTO childpanels SET client_id=:c_id, domain=:domain, currency=:currency, child_username=:username, charge=:charge, child_password=:password, renewal_date=:renewal_date, date_created=:last,dreampanel_id=:did,keyc=:keyc ");

          $insert = $insert-> execute(array("c_id"=>$user["client_id"],"domain"=>$domain,"currency"=>$currency,"username"=>$username,"charge"=>$price,"password"=>$password,"renewal_date"=>$renewal_date,"did"=> $order_id,"last"=>date("Y.m.d H:i:s"),"keyc"=>$panel["api_key"])); 

            if( $insert ): $last_id = $conn->lastInsertId(); endif;

          $update = $conn->prepare("UPDATE clients SET balance=:balance, spent=:spent WHERE client_id=:id");
          $update = $update-> execute(array("balance"=>$user["balance"]-$price,"spent"=>$user["spent"]+$price,"id"=>$user["client_id"]));
          $insert2= $conn->prepare("INSERT INTO client_report SET client_id=:c_id, action=:action, report_ip=:ip, report_date=:date ");
          $insert2= $insert2->execute(array("c_id"=>$user["client_id"],"action"=>"New Child Panel Order with id : ".$last_id.".","ip"=>GetIP(),"date"=>date("Y-m-d H:i:s") ));
            if ( $insert && $update && $insert2 ):
                            //echo "done"; die();
              $conn->commit();
              unset($_SESSION["data"]);
              $user = $conn->prepare("SELECT * FROM clients WHERE client_id=:id");
              $user->execute(array("id"=>$_SESSION["msmbilisim_userid"] ));
              $user = $user->fetch(PDO::FETCH_ASSOC);
              $user['auth']                   = $_SESSION["msmbilisim_userlogin"];
              $order_data                     = ['success'=>1,'id'=>$last_id,"service"=>"Child Panel","link"=>$domain,"quantity"=>"1","price"=>$price,"balance"=>$user["balance"] ];
              $_SESSION["data"]["services"]   = "Child Panel";
              $_SESSION["data"]["categories"] = "Child Panels";
              $_SESSION["data"]["childpanel"] = $order_data;
				        header("Location:".site_url("child-panels/".$last_id));
            else:
              $conn->rollBack();
              $error    = 1;
              $errorText= "Child Panel order failed";
            endif;
     
 endif;
 

  }  
endif;

?>