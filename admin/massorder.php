
<?php
$title .= "Mass  Order";

$smmapi   = new SMMApi();
$fapi     = new socialsmedia_api();

if( $_SESSION["msmbilisim_userlogin"] != 1  || $user["client_type"] == 1  ){
  Header("Location:".site_url('logout'));
}
if( $settings["email_confirmation"] == 1  && $user["email_type"] == 1  ){
  Header("Location:".site_url('confirm_email'));
}


 if( $_POST ):

  foreach ($_POST as $key => $value) {
    $_SESSION["data"][$key]  = $value;
  }
$mass = $_POST["mass"];
$order = explode("|", $mass);

			
				$service = $order[0];
				$link       = $order[1];
                                $quantity   = $order[2]; 


  $ip               = GetIP(); // Uye ıp

    if( !$quantity ): $quantity=0; endif;
  if( substr($link,-1) == "/" ): $link = substr($link,0,-1); endif;
$price    = (service_price($service_detail["service_id"])/1000)*$quantity;

$percent = $user["coustm_rate"]/100;
$price81 = $price*$percent;
$price = $price-$price81;
  $service_detail   = $conn->prepare("SELECT * FROM services WHERE service_id=:id");
  $service_detail-> execute(array("id"=>$service));
  $service_detail   = $service_detail->fetch(PDO::FETCH_ASSOC);
$price    = (service_price($service_detail["service_id"])/1000)*$quantity;
$percent = $user["coustm_rate"]/100;
$price81 = $price*$percent;
$price = $price-$price81;
    if( $service_detail["service_api"] != 0 ):
      $api_detail       = $conn->prepare("SELECT * FROM service_api WHERE id=:id");
      $api_detail       -> execute(array("id"=>$service_detail["service_api"] ));
      $api_detail       = $api_detail->fetch(PDO::FETCH_ASSOC);
    endif;



	// check format
				$order_count = count($order);
				if($order_count > 3  || $order_count <= 2) :
					      $error    = 1;
      $errorText= "Bad  format";
				
    elseif( $service_detail["service_type"] == 1 ):
      $error    = 1;
      $errorText= $languageArray["error.neworder.service.deactive"];
    elseif( empty($link) || empty($quantity) ):
      $error    = 1;
      $errorText= $languageArray["error.neworder.empty"];
    elseif( empty($link) ):
      $error    = 1;
      $errorText= $languageArray["error.neworder.empty"];  
    elseif(  $quantity < $service_detail["service_min"] ):
      $error    = 1;
      $errorText= str_replace("{min}",$service_detail["service_min"],$languageArray["error.neworder.min"]);

    elseif( $quantity > $service_detail["service_max"] ):
      $error    = 1;
      $errorText= str_replace("{max}",$service_detail["service_max"],$languageArray["error.neworder.max"]);
    elseif( ( $price > $user["balance"] ) && $user["balance_type"] == 2 ):
      $error    = 1;
      $errorText= $languageArray["error.neworder.balance.notenough"];
    elseif( ( $user["balance"] - $price < "-".$user["debit_limit"] ) && $user["balance_type"] == 1 ):
      $error    = 1;
      $errorText= $languageArray["error.neworder.balance.notenough"];
    else:


$start_count = 0;
$price    = (service_price($service_detail["service_id"])/1000)*$quantity;
$percent = $user["coustm_rate"]/100;
$price81 = $price*$percent;
$price = $price-$price81;
    if( $service_detail["service_api"] == 0 ):
    $conn->beginTransaction();
          $insert = $conn->prepare("INSERT INTO orders SET order_start=:count, order_profit=:profit, order_error=:error,client_id=:c_id, service_id=:s_id, order_quantity=:quantity, order_charge=:price, order_url=:url, order_create=:create, last_check=:last ");
          $insert = $insert-> execute(array("count"=>$start_count,"c_id"=>$user["client_id"],"error"=>"-","s_id"=>$service_detail["service_id"],"quantity"=>$quantity,"price"=>$price,"profit"=>$price,"url"=>$link,"create"=>date("Y.m.d H:i:s"),"last"=>date("Y.m.d H:i:s")));
            if( $insert ): $last_id = $conn->lastInsertId(); endif;

if( $insert ): 
          $update = $conn->prepare("UPDATE clients SET balance=:balance, spent=:spent WHERE client_id=:id");
          $update = $update-> execute(array("balance"=>$user["balance"]-$price,"spent"=>$user["spent"]+$price,"id"=>$user["client_id"]));
     endif;
     $insert2= $conn->prepare("INSERT INTO client_report SET client_id=:c_id, action=:action, report_ip=:ip, report_date=:date ");
          $insert2= $insert2->execute(array("c_id"=>$user["client_id"],"action"=>$price." New Order #".$last_id.".","ip"=>GetIP(),"date"=>date("Y-m-d H:i:s") ));
            if( $insert && $update && $insert2 ):

$select = $conn->prepare("SELECT * FROM panel_info WHERE panel_id=:id");
            $select->execute(array("id" => 1));
            $select  = $select->fetch(PDO::FETCH_ASSOC);
           
            //update orders 
            $update = $conn->prepare("UPDATE panel_info SET panel_thismonthorders=:panel_thismonthorders ,  panel_orders=:panel_orders WHERE panel_id=:id");
            $update = $update->execute(array("id" => 1 , "panel_thismonthorders" => $select["panel_thismonthorders"] + 1 , "panel_orders" => $select["panel_orders"] + 1 ));
              $conn->commit();
              unset($_SESSION["data"]);
              $user = $conn->prepare("SELECT * FROM clients WHERE client_id=:id");
              $user->execute(array("id"=>$_SESSION["msmbilisim_userid"] ));
              $user = $user->fetch(PDO::FETCH_ASSOC);
              $user['auth']                   = $_SESSION["msmbilisim_userlogin"];
              $order_data                     = ['success'=>1,'id'=>$last_id,"service"=>$service_detail["service_name"],"link"=>$link,"quantity"=>$quantity,"price"=>$price,"balance"=>$user["balance"] ];
              $_SESSION["data"]["services"]   = $_POST["services"];
              $_SESSION["data"]["categories"] = $_POST["categories"];
              $_SESSION["data"]["order"]      = $order_data;
				        header("Location:".site_url("order/".$last_id));
              

 else:
              $conn->rollBack();
              $error    = 1;
              $errorText= $languageArray["error.neworder.fail"];
            endif;  

else:
          


$conn->beginTransaction();

          /* API SİPARİŞİ GEÇ BAŞLA */
          if( $api_detail["api_type"] == 1 ):
            ## Standart api başla ##

                ## Standart başla ##
                $order    = $smmapi->action(array('key' =>$api_detail["api_key"],'action' =>'add','service'=>$service_detail["api_service"],'link'=>$link,'quantity'=>$quantity),$api_detail["api_url"]);
                if( @!$order->order ):
                  $error    = json_encode($order);
                  $order_id = "";
                else:
                  $error    = "-";
                  $order_id = @$order->order;
          endif;


$orderstatus= $smmapi->action(array('key' =>$api_detail["api_key"],'action' =>'status','order'=>$order_id),$api_detail["api_url"]);
              $balance    = $smmapi->action(array('key' =>$api_detail["api_key"],'action' =>'balance'),$api_detail["api_url"]);
              $api_charge = $orderstatus->charge;


$price    = (service_price($service_detail["service_id"])/1000)*$quantity;
$percent = $user["coustm_rate"]/100;
$price81 = $price*$percent;
$price = $price-$price81;
$profit = $price-$api_charge;

            $insert = $conn->prepare("INSERT INTO orders SET order_error=:error, order_detail=:detail, client_id=:c_id, api_orderid=:order_id, service_id=:s_id, order_quantity=:quantity, order_charge=:price, order_url=:url,
              order_create=:create, last_check=:last_check, order_api=:api, api_serviceid=:api_serviceid, api_charge=:api_charge, order_profit=:profit
              ");


            $insert = $insert-> execute(array("c_id"=>$user["client_id"],"detail"=>json_encode($order),"error"=>$error,"s_id"=>$service_detail["service_id"],"quantity"=>$quantity,"price"=>$price,"url"=>$link,
              "create"=>date("Y.m.d H:i:s"),"order_id"=>$order_id,"last_check"=>date("Y.m.d H:i:s"),"api"=>$api_detail["id"],
              "api_serviceid"=>$service_detail["api_service"],"profit"=>$profit,"api_charge"=>$api_charge
            ));
              if( $insert ): $last_id = $conn->lastInsertId(); endif;
if ($settings["alert_orderfail"] == 2) {
                            $errorMessage = json_decode($error, true);
                            if ($error != "-") {
                                $msg = "Order Got Failed Order id : " . $last_id .  "
Order Error : " . $errorMessage["error"]  . " 
View Fail orders in admin panel :
". site_url(). "admin/orders/1/failed"; 
        $send = mail($settings["admin_mail"],"Failed Orders Information",$msg);
                            }
                        }
if( $insert ): 
            $update = $conn->prepare("UPDATE clients SET balance=:balance, spent=:spent WHERE client_id=:id");
            $update = $update-> execute(array("balance"=>$user["balance"]-$price,"spent"=>$user["spent"]+$price,"id"=>$user["client_id"]));
      endif;
      $insert2= $conn->prepare("INSERT INTO client_report SET client_id=:c_id, action=:action, report_ip=:ip, report_date=:date ");
            $insert2= $insert2->execute(array("c_id"=>$user["client_id"],"action"=>$price." New Order #".$last_id.".","ip"=>GetIP(),"date"=>date("Y-m-d H:i:s") ));
 if( $settings["alert_apibalance"] == 2 && $api_detail["api_limit"] > $balance  && $api_detail["api_alert"] == 2 ):
                    $msg = "Provider balance is lesser than limit! 
". $api_detail["api_name"]." api available balance :".$balance;
        $send = mail($settings['admin_mail'],"Provider balance notification",$msg);
                      
                    endif;


              if( $insert && $update && ( $order_id || $error ) && $insert2 ):
$select = $conn->prepare("SELECT * FROM panel_info WHERE panel_id=:id");
            $select->execute(array("id" => 1));
            $select  = $select->fetch(PDO::FETCH_ASSOC);
           
            //update orders 
            $update = $conn->prepare("UPDATE panel_info SET panel_thismonthorders=:panel_thismonthorders ,  panel_orders=:panel_orders WHERE panel_id=:id");
            $update = $update->execute(array("id" => 1 , "panel_thismonthorders" => $select["panel_thismonthorders"] + 1 , "panel_orders" => $select["panel_orders"] + 1 ));
                $error  = 0;
                $conn->commit();
                unset($_SESSION["data"]);
                $user = $conn->prepare("SELECT * FROM clients WHERE client_id=:id");
                $user->execute(array("id"=>$_SESSION["msmbilisim_userid"] ));
                $user = $user->fetch(PDO::FETCH_ASSOC);
                $user['auth']                   = $_SESSION["msmbilisim_userlogin"];
                $order_data = ['success'=>1,'id'=>$last_id,"service"=>$service_detail["service_name"],"link"=>$link,"quantity"=>$quantity,"price"=>$price,"balance"=>$user["balance"] ];
                $_SESSION["data"]["services"]   = $_POST["services"];
                $_SESSION["data"]["categories"] = $_POST["categories"];
                $_SESSION["data"]["order"]      = $order_data;
                header("Location:".site_url("order/".$last_id));
                  
              else:
                $conn->rollBack();
                $error    = 1;
                $errorText= $languageArray["error.neworder.fail"];
              endif;


endif;
endif;
endif;
endif;

?>