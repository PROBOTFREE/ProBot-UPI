<?php
if( $panel["panel_status"] == "suspended" ): include 'app/views/frozen.twig';exit(); endif;
if( $panel["panel_status"] == "frozen" ): include 'app/views/frozen.twig';exit(); endif;

$route[0]	=	"neworder";

$order	=	$conn->prepare("SELECT * FROM orders INNER JOIN services ON services.service_id=orders.service_id WHERE client_id=:client && order_id=:orderid ");
$order-> execute(array("client"=>$user["client_id"],"orderid"=>route(1) ));

if( !$order->rowCount() ):
	Header("Location:".site_url());
else:
	$order	=	$order->fetch(PDO::FETCH_ASSOC);
	$order_data                     = ['success'=>1,'id'=>route(1),"service"=>$order["service_name"],"link"=>$order["order_url"],"quantity"=>$order["order_quantity"],"price"=>$order["order_charge"],"balance"=>$user["balance"] ];
	$_SESSION["data"]["services"]   = $order["service_id"];
	$_SESSION["data"]["categories"] = $order["category_id"];
	$_SESSION["data"]["order"]      = $order_data;
endif;

$title .= $languageArray["neworder.title"];

$smmapi   = new SMMApi();
$fapi     = new socialsmedia_api();

if( $_SESSION["msmbilisim_userlogin"] != 1  || $user["client_type"] == 1  ){
  Header("Location:".site_url('logout'));
}

$categoriesRows = $conn->prepare("SELECT * FROM categories WHERE category_type=:type  ORDER BY categories.category_line ASC ");
$categoriesRows->execute(array("type"=>2));
$categoriesRows = $categoriesRows->fetchAll(PDO::FETCH_ASSOC);

$categories = [];
  foreach ( $categoriesRows as $categoryRow ) {
    $search = $conn->prepare("SELECT * FROM clients_category WHERE category_id=:category && client_id=:c_id ");
    $search->execute(array("category"=>$categoryRow["category_id"],"c_id"=>$user["client_id"]));
    if( $categoryRow["category_secret"] == 2 || $search->rowCount() ):
      $rows     = $conn->prepare("SELECT * FROM services WHERE category_id=:id ORDER BY service_line ASC");
      $rows     ->execute(array("id"=>$categoryRow["category_id"] ));
      $rows     = $rows->fetchAll(PDO::FETCH_ASSOC);
      $services = [];
        foreach ( $rows as $row ) {
          $s["service_price"] = service_price($row["service_id"]);
          $s["service_id"]    = $row["service_id"];
						$multiName   =  json_decode($row["name_lang"],true);
							if( $multiName[$user["lang"]] ):
								$s["service_name"] = $multiName[$user["lang"]];
							else:
								$s["service_name"] = $row["service_name"];
							endif;
          $s["service_min"]   = $row["service_min"];
          $s["service_max"]   = $row["service_max"];
          $search = $conn->prepare("SELECT * FROM clients_service WHERE service_id=:service && client_id=:c_id ");
          $search->execute(array("service"=>$row["service_id"],"c_id"=>$user["client_id"]));
          if( $row["service_secret"] == 2 || $search->rowCount() ):
            array_push($services,$s);
          endif;
        }
      $c["category_name"]          = $categoryRow["category_name"];
      $c["category_id"]            = $categoryRow["category_id"];
      $c["services"]               = $services;
      array_push($categories,$c);
    endif;

  }

if( $_POST ):

  foreach ($_POST as $key => $value) {
    $_SESSION["data"][$key]  = $value;
  }

  $ip               = GetIP(); // Uye ıp
  $service          = htmlspecialchars($_POST["services"]);// Ürün id
  $quantity         = htmlspecialchars($_POST["quantity"]); // Sipariş miktarı
    if( !$quantity ): $quantity=0; endif;
  $link             = htmlspecialchars($_POST["link"]); // Sipariş link
  if( substr($link,-1) == "/" ): $link = substr($link,0,-1); endif;
  $username         = htmlspecialchars($_POST["username"]); // abonelik, hangi kullanıcıya olacak
  $posts            = htmlspecialchars($_POST["posts"]); // abonelik, kaç gönderiye gitsin
  $delay            = htmlspecialchars($_POST["delay"]); // Abonelik, gecikme süresi
  $otoMin           = htmlspecialchars($_POST["min"]); // abonelik, minimum miktar
  $otoMax           = htmlspecialchars($_POST["max"]);// abonelik, maksimum tutar
  $comments         = htmlspecialchars($_POST["comments"]); //custom comments
  $runs             = htmlspecialchars($_POST["runs"]); // dripfeed kaç kez gitsin
    if( !$runs ): $runs=1; endif;
  $interval         = htmlspecialchars($_POST["interval"]); // dripfeed gecikme süresi
  $dripfeedon       = htmlspecialchars($_POST["check"]); // dripfeed aktif
  $expiry           = htmlspecialchars($_POST["expiry"]);
  $expiry           = date("Y-m-d", strtotime(str_replace('/', '-', $expiry)));
  $subscriptions    = 1;
  $service_detail   = $conn->prepare("SELECT * FROM services WHERE service_id=:id");
  $service_detail-> execute(array("id"=>$service));
  $service_detail   = $service_detail->fetch(PDO::FETCH_ASSOC);

    if( $service_detail["service_api"] != 0 ):
      $api_detail       = $conn->prepare("SELECT * FROM service_api WHERE id=:id");
      $api_detail       -> execute(array("id"=>$service_detail["service_api"] ));
      $api_detail       = $api_detail->fetch(PDO::FETCH_ASSOC);
    endif;

    if( $service_detail["service_package"] == 2 ):
      $quantity = $service_detail["service_min"];
      $price    = service_price($service_detail["service_id"]);
      $extras   = "";
    elseif( $service_detail["service_package"] == 3 || $service_detail["service_package"] == 4 ):
      $quantity = count(explode("\n",$comments));// count custom comments
      $extras   = json_encode(["comments"=>$comments]);
    elseif( $service_detail["service_package"] == 11 ||  $service_detail["service_package"] == 12 ||  $service_detail["service_package"] == 13 ):
      $extras           = "";
      $quantity         = $otoMin."-".$otoMax; // Sipariş miktarı
      $link             = $username; // Sipariş link
      $subscriptions    = 2;
      $price            = 0;
    elseif( $service_detail["service_package"] == 14 ||  $service_detail["service_package"] == 15 ):
      $extras           = "";
      $link             = $username; // Sipariş link
      $subscriptions    = 2;
      $quantity         = $service_detail["service_min"];
      $price            = service_price($service["service_id"]);
      $posts            = $service_detail["service_autopost"];
      $delay            = 0;
      $time             = '+'.$service_detail["service_autotime"].' days';
      $expiry           = date('Y-m-d H:i:s', strtotime($time));
      $otoMin           = $service_detail["service_min"];
      $otoMax           = $service_detail["service_min"];
    else:
      $extras   = "";
    endif;

    if( $service_detail["service_package"] == 14 || $service_detail["service_package"] == 15 ){
      $subscriptions_status = "limit";
      $expiry               = date("Y-m-d", strtotime('+'.$service_detail["service_autotime"].' days'));
    }else{
      $subscriptions_status = "active";
    }

		if( $service_detail["service_package"] == 14 || $service_detail["service_package"] == 15 ):
      $price    = service_price($service_detail["service_id"]);
		elseif( $service_detail["service_package"] != 2 && $service_detail["service_package"] != 11 && $service_detail["service_package"] != 12 && $service_detail["service_package"] != 13 ):
      $price    = (service_price($service_detail["service_id"])/1000)*$quantity;
    endif;

    if( $dripfeedon == 1 ):
      $dripfeedon             = 2;
      $dripfeed_totalquantity = $quantity*$runs; //dripfeed toplam gönderim miktarı
      $dripfeed_totalcharges  = service_price($service_detail["service_id"])*$dripfeed_totalquantity/1000; //dripfeed toplam gönderim ücreti
      $price                  = service_price($service_detail["service_id"])*$dripfeed_totalquantity/1000; //dripfeed toplam gönderim ücreti
    else:
      $dripfeedon             = 1;
      $dripfeed_totalcharges  = "";
      $dripfeed_totalquantity = "";
    endif;

    if( $service_detail["want_username"] == 2 ):
      $private_type = "username";
      $countRow     = $conn->prepare("SELECT * FROM orders WHERE order_url=:url && ( order_status=:statu || order_status=:statu2 || order_status=:statu3 ) && dripfeed=:dripfeed && subscriptions_type=:subscriptions_type ");
      $countRow    -> execute(array("url"=>$link,"statu"=>"pending","statu2"=>"inprogress","statu3"=>"processing","dripfeed"=>1,"subscriptions_type"=>1 ));
      $countRow     = $countRow->rowCount();
    else:
      $private_type = "url";
      if( substr($link,0,7) == "http://" ): $linkSearch = substr($link,7); endif; if( substr($linkSearch,0,8) == "https://" ): $linkSearch = substr($linkSearch,8); endif; if( substr($linkSearch,0,4) == "www." ): $linkSearch = substr($link,4); endif;
      $countRow     = $conn->prepare("SELECT * FROM orders WHERE order_url LIKE :url && ( order_status=:statu || order_status=:statu2 || order_status=:statu3 ) && dripfeed=:dripfeed && subscriptions_type=:subscriptions_type ");
      $countRow    -> execute(array("url"=>'%'.$linkSearch.'%',"statu"=>"pending","statu2"=>"inprogress","statu3"=>"processing","dripfeed"=>1,"subscriptions_type"=>1 ));
      $countRow     = $countRow->rowCount();
    endif;
    if( $service_detail["start_count"] == "none"  ): $start_count = "0"; else: $start_count = instagramCount(["type"=>$private_type,"url"=>$link,"search"=>$service_detail["start_count"]]); endif;

    if( $service_detail["service_type"] == 1 ):
      $error    = 1;
      $errorText= $languageArray["error.neworder.service.deactive"];
    elseif( $service_detail["service_package"] == 1 && ( empty($link) || empty($quantity) ) ):
      $error    = 1;
      $errorText= $languageArray["error.neworder.empty"];
    elseif( $service_detail["service_package"] == 2 && empty($link) ):
      $error    = 1;
      $errorText= $languageArray["error.neworder.empty"];
    elseif( $service_detail["service_package"] == 3 && ( empty($link) || empty($comments) ) ):
      $error    = 1;
      $errorText= $languageArray["error.neworder.empty"];
    elseif( ($service_detail["service_package"] == 14 || $service_detail["service_package"] == 15) && empty($username)  ):
      $error    = 1;
      $errorText= $languageArray["error.neworder.empty"];
    elseif( $service_detail["service_package"] == 4 && ( empty($link) || empty($comments) ) ):
      $error    = 1;
      $errorText= $languageArray["error.neworder.empty"];
    elseif( ( $service_detail["service_package"] == 1 || $service_detail["service_package"] == 2 || $service_detail["service_package"] == 3 || $service_detail["service_package"] == 4 ) && $quantity < $service_detail["service_min"] ):
      $error    = 1;
      $errorText= str_replace("{min}",$service_detail["service_min"],$languageArray["error.neworder.min"]);
    elseif( ( $service_detail["service_package"] == 1 || $service_detail["service_package"] == 2 || $service_detail["service_package"] == 3 || $service_detail["service_package"] == 4 ) && $quantity > $service_detail["service_max"] ):
      $error    = 1;
      $errorText= str_replace("{max}",$service_detail["service_max"],$languageArray["error.neworder.max"]);
    elseif( $dripfeedon == 2 && ( empty($runs) || empty($interval) ) ):
      $error    = 1;
      $errorText= $languageArray["error.neworder.empty"];
    elseif( $dripfeedon == 2 && $dripfeed_totalquantity > $service_detail["service_max"] ):
      $error    = 1;
      $errorText= str_replace("{max}",$service_detail["service_max"],$languageArray["error.neworder.max"]);
    elseif( ($service_detail["service_package"] == 11 ||$service_detail["service_package"] == 12 ||$service_detail["service_package"] == 13  ) && empty($username) ):
      $error    = 1;
      $errorText= $languageArray["error.neworder.empty"];
    elseif( ($service_detail["service_package"] == 11 ||$service_detail["service_package"] == 12 ||$service_detail["service_package"] == 13  ) && empty($otoMin) ):
      $error    = 1;
      $errorText= $languageArray["error.neworder.empty"];
    elseif( ($service_detail["service_package"] == 11 ||$service_detail["service_package"] == 12 ||$service_detail["service_package"] == 13  ) && empty($otoMax) ):
      $error    = 1;
      $errorText= $languageArray["error.neworder.empty"];
    elseif( ($service_detail["service_package"] == 11 ||$service_detail["service_package"] == 12 ||$service_detail["service_package"] == 13  ) && empty($posts) ):
      $error    = 1;
      $errorText= $languageArray["error.neworder.empty"];
    elseif( ( $service_detail["service_package"] == 11 || $service_detail["service_package"] == 12 || $service_detail["service_package"] == 13  ) && $otoMax < $otoMin ):
      $error    = 1;
      $errorText= $languageArray["error.neworder.min.largest.max"];
    elseif( ( $service_detail["service_package"] == 11 || $service_detail["service_package"] == 12 || $service_detail["service_package"] == 13  ) && $otoMin < $service_detail["service_min"] ):
      $error    = 1;
      $errorText= str_replace("{min}",$service_detail["service_min"],$languageArray["error.neworder.min"]);
    elseif( ( $service_detail["service_package"] == 11 || $service_detail["service_package"] == 12 || $service_detail["service_package"] == 13  ) && $otoMax > $service_detail["service_max"] ):
      $error    = 1;
      $errorText= str_replace("{max}",$service_detail["service_max"],$languageArray["error.neworder.max"]);
    elseif( instagramProfilecheck(["type"=>$private_type,"url"=>$link,"return"=>"private"]) && $service_detail["instagram_private"] == 2 ):
      $error    = 1;
      $errorText= $languageArray["error.neworder.profile.secret"];
    elseif( $service_detail["instagram_second"] == 1 && $countRow && ( $service_detail["service_package"] != 11 && $service_detail["service_package"] != 12 && $service_detail["service_package"] != 13 && $service_detail["service_package"] != 14 && $service_detail["service_package"] != 15 ) ):
      $error    = 1;
      $errorText= $languageArray["error.neworder.there.order"];
    elseif( ( $price > $user["balance"] ) && $user["balance_type"] == 2 ):
      $error    = 1;
      $errorText= $languageArray["error.neworder.balance.notenough"];
    elseif( ( $user["balance"] - $price < "-".$user["debit_limit"] ) && $user["balance_type"] == 1 ):
      $error    = 1;
      $errorText= $languageArray["error.neworder.balance.notenough"];
    else:

      /* Sipariş ver - başla */
        if( $service_detail["service_api"] == 0 ):
          /* manuel sipariş - başla */
          $conn->beginTransaction();
          $insert = $conn->prepare("INSERT INTO orders SET order_start=:count, order_profit=:profit, order_error=:error,client_id=:c_id, service_id=:s_id, order_quantity=:quantity, order_charge=:price, order_url=:url, order_create=:create, order_extras=:extra, last_check=:last ");
          $insert = $insert-> execute(array("count"=>$start_count,"c_id"=>$user["client_id"],"error"=>"-","s_id"=>$service_detail["service_id"],"quantity"=>$quantity,"price"=>$price,"profit"=>$price,"url"=>$link,"create"=>date("Y.m.d H:i:s"),"last"=>date("Y.m.d H:i:s"),"extra"=>$extras));
            if( $insert ): $last_id = $conn->lastInsertId(); endif;
          $update = $conn->prepare("UPDATE clients SET balance=:balance, spent=:spent WHERE client_id=:id");
          $update = $update-> execute(array("balance"=>$user["balance"]-$price,"spent"=>$user["spent"]+$price,"id"=>$user["client_id"]));
          $insert2= $conn->prepare("INSERT INTO client_report SET client_id=:c_id, action=:action, report_ip=:ip, report_date=:date ");
          $insert2= $insert2->execute(array("c_id"=>$user["client_id"],"action"=>$price." New Order #".$last_id.".","ip"=>GetIP(),"date"=>date("Y-m-d H:i:s") ));
            if ( $insert && $update && $insert2 ):
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
                if( $settings["alert_newmanuelservice"] == 2 ):
                  if( $settings["alert_type"] == 3 ):   $sendmail = 1; $sendsms  = 1; elseif( $settings["alert_type"] == 2 ): $sendmail = 1; $sendsms=0; elseif( $settings["alert_type"] == 1 ): $sendmail=0; $sendsms  = 1; endif;
                  if( $sendsms ):
                    SMSUser($settings["admin_telephone"],"Websiteniz #".$last_id." idli yeni bir sipariş mevcut.");
                  endif;
                  if( $sendmail ):
                    sendMail(["subject"=>"Yeni sipariş mevcut.","body"=>"Websiteniz #".$last_id." idli yeni bir sipariş mevcut.","mail"=>$settings["admin_mail"]]);
                  endif;
                endif;
            else:
              $conn->rollBack();
              $error    = 1;
              $errorText= $languageArray["error.neworder.fail"];
            endif;
          /* manuel sipariş - bitir */
        else:

          /* api ile sipariş - başla */
          $conn->beginTransaction();

          /* API SİPARİŞİ GEÇ BAŞLA */
          if( $api_detail["api_type"] == 1 ):
            ## Standart api başla ##
              if( $service_detail["service_package"] == 1 || $service_detail["service_package"] == 2 ):
                ## Standart başla ##
                $order    = $smmapi->action(array('key' =>$api_detail["api_key"],'action' =>'add','service'=>$service_detail["api_service"],'link'=>$link,'quantity'=>$quantity),$api_detail["api_url"]);
                if( @!$order->order ):
                  $error    = json_encode($order);
                  $order_id = "";
                else:
                  $error    = "-";
                  $order_id = @$order->order;
                endif;
                ## Standart bitti ##
              elseif( $service_detail["service_package"] == 3 ):
                ## Custom comments başla ##
                $order    = $smmapi->action(array('key' =>$api_detail["api_key"],'action' =>'add','service'=>$service_detail["api_service"],'link'=>$link,'comments'=>$comments),$api_detail["api_url"]);
                if( @!$order->order ):
                  $error    = json_encode($order);
                  $order_id = "";
                else:
                  $error    = "-";
                  $order_id = @$order->order;
                endif;
                ## Custom comments bitti ##
              elseif( $service_detail["service_package"] == 11 || $service_detail["service_package"] == 12 || $service_detail["service_package"] == 13 || $service_detail["service_package"] == 14 || $service_detail["service_package"] == 15  ):
                ## oto başla ##
                  $error    = "-";
                  $order_id = "";
                ## oto bitti ##
              else:
              endif;
              $orderstatus= $smmapi->action(array('key' =>$api_detail["api_key"],'action' =>'status','order'=>$order_id),$api_detail["api_url"]);
              $balance    = $smmapi->action(array('key' =>$api_detail["api_key"],'action' =>'balance'),$api_detail["api_url"]);
              $api_charge = $orderstatus->charge;
                if( !$api_charge ): $api_charge = 0; endif;
              if( $currency == "INR" ):
$profit = ($price-$api_charge) / 74;
        else:
       $profit = $price-$api_charge;
endif;
                $balance = $balance->balance;
            ## Standart api bitti ##
          elseif( $api_detail["api_type"] == 3 ):
            if( $service_detail["service_package"] == 1 || $service_detail["service_package"] == 2 ):
                ## Standart başla ##
                $order    = $fapi->query(array('cmd'=>'orderadd','token' =>$api_detail["api_key"],'apiurl'=>$api_detail["api_url"],'orders'=>[['service'=>$service_detail["api_service"],'amount'=>$quantity,'data'=>$link]] ));
                if( @$order[0][0]['status'] == "error" ):
                  $error    = json_encode($order);
                  $order_id = "";
                  $api_charge = "0";
                  $currencycharge = 1;
                else:
                  $error    = "-";
                  $order_id = @$order[0][0]["id"];
                  $orderstatus= $fapi->query(array('cmd'=>'orderstatus','token' => $api_detail["api_key"],'apiurl'=>$api_detail["api_url"],'orderid'=>[$order_id]));
                  $balance    = $fapi->query(array('cmd'=>'profile','token' =>$api_detail["api_key"],'apiurl'=>$api_detail["api_url"]));
                  $api_charge = $orderstatus[$order_id]["order"]["price"];
                  if( $currency == "INR" ):
$profit = ($price-$api_charge) / 74;
        else:
       $profit = $price-$api_charge;
endif;
                endif;
                ## Standart bitti ##
              elseif( $service_detail["service_package"] == 11 || $service_detail["service_package"] == 12 || $service_detail["service_package"] == 13  ):
                ## oto başla ##
                  $error    = "-";
                  $order_id = "";
                ## oto bitti ##
              else:
              endif;

          else:
          endif;
          /* API SİPARİŞ GEÇ BİTTİ */
            if( $dripfeedon == 2 ):
              $insert = $conn->prepare("INSERT INTO orders SET order_start=:count, order_error=:error, client_id=:c_id, api_orderid=:order_id, service_id=:s_id, order_quantity=:quantity, order_charge=:price,
                order_url=:url,
                order_create=:create, order_extras=:extra, last_check=:last_check, order_api=:api, api_serviceid=:api_serviceid, dripfeed=:drip, dripfeed_totalcharges=:totalcharges, dripfeed_runs=:runs,
                dripfeed_interval=:interval, dripfeed_totalquantity=:totalquantity, dripfeed_delivery=:delivery
                ");
              $insert = $insert-> execute(array("count"=>$start_count,"c_id"=>$user["client_id"],"error"=>"-","s_id"=>$service_detail["service_id"],"quantity"=>$quantity,"price"=>$price,"url"=>$link,
                "create"=>date("Y.m.d H:i:s"),"extra"=>$extras,"order_id"=>0,"last_check"=>date("Y.m.d H:i:s"),"api"=>$api_detail["id"],
                "api_serviceid"=>$service_detail["api_service"],"drip"=>$dripfeedon,"totalcharges"=>$dripfeed_totalcharges,"runs"=>$runs,
                "interval"=>$interval,"totalquantity"=>$dripfeed_totalquantity,"delivery"=>1
              ));
                if( $insert ): $dripfeed_id = $conn->lastInsertId(); endif;
$select = $conn->prepare("SELECT * FROM panel_info WHERE panel_id=:id");
            $select->execute(array("id" => 1));
            $select  = $select->fetch(PDO::FETCH_ASSOC);
           
            //update orders 
            $update = $conn->prepare("UPDATE panel_info SET panel_thismonthorders=:panel_thismonthorders ,  panel_orders=:panel_orders WHERE panel_id=:id");
            $update = $update->execute(array("id" => 1 , "panel_thismonthorders" => $select["panel_thismonthorders"] + 1 , "panel_orders" => $select["panel_orders"] + 1 ));

            else:
              $dripfeed_id  = 0;
            endif;

            $insert = $conn->prepare("INSERT INTO orders SET order_start=:count, order_error=:error, order_detail=:detail, client_id=:c_id, api_orderid=:order_id, service_id=:s_id, order_quantity=:quantity, order_charge=:price, order_url=:url,
              order_create=:create, order_extras=:extra, last_check=:last_check, order_api=:api, api_serviceid=:api_serviceid, subscriptions_status=:s_status,
              subscriptions_type=:subscriptions, subscriptions_username=:username, subscriptions_posts=:posts, subscriptions_delay=:delay, subscriptions_min=:min,
              subscriptions_max=:max, subscriptions_expiry=:expiry, dripfeed_id=:dripfeed_id, api_charge=:api_charge, api_currencycharge=:api_currencycharge, order_profit=:profit
              ");
            $insert = $insert-> execute(array("count"=>$start_count,"c_id"=>$user["client_id"],"detail"=>json_encode($order),"error"=>$error,"s_id"=>$service_detail["service_id"],"quantity"=>$quantity,"price"=>$price / $runs,"url"=>$link,
              "create"=>date("Y.m.d H:i:s"),"extra"=>$extras,"order_id"=>$order_id,"last_check"=>date("Y.m.d H:i:s"),"api"=>$api_detail["id"],
              "api_serviceid"=>$service_detail["api_service"],"s_status"=>$subscriptions_status,"subscriptions"=>$subscriptions,"username"=>$username,
              'posts'=>$posts,
              "delay"=>$delay,"min"=>$otoMin,"max"=>$otoMax,"expiry"=>$expiry,"dripfeed_id"=>$dripfeed_id,"profit"=>$profit,"api_charge"=>$api_charge,"api_currencycharge"=>$currencycharge
            ));
              if( $insert ): $last_id = $conn->lastInsertId(); endif;
            $update = $conn->prepare("UPDATE clients SET balance=:balance, spent=:spent WHERE client_id=:id");
            $update = $update-> execute(array("balance"=>$user["balance"]-$price,"spent"=>$user["spent"]+$price,"id"=>$user["client_id"]));
            $insert2= $conn->prepare("INSERT INTO client_report SET client_id=:c_id, action=:action, report_ip=:ip, report_date=:date ");
$insert2= $insert2->execute(array("c_id"=>$user["client_id"],"action"=>$price." New Order #".$last_id.".","ip"=>GetIP(),"date"=>date("Y-m-d H:i:s") ));

              if ( $insert && $update && ( $order_id || $error ) && $insert2 ):


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
            
if( $settings["alert_apibalance"] == 2 && $api_detail["api_limit"] > $balance  && $api_detail["api_alert"] == 2 ):
                    $msg = "Provider balance is lesser than limit! 
". $api_detail["api_name"]." api available balance :".$balance;
        $send = mail($settings['admin_mail'],"Provider balance notification",$msg);
                      
                    endif;

                  if( $api_detail["api_limit"] < $balance ):
                    $update = $conn->prepare("UPDATE service_api SET api_alert=:alert WHERE id=:id ");
                    $update->execute(array("id"=>$api_detail["id"],"alert"=>2));
                  endif;
              else:
                $conn->rollBack();
                $error    = 1;
                $errorText= $languageArray["error.neworder.fail"];
              endif;
          /* api ile sipariş - bitir */
        endif;
      /* Sipariş ver - bitir */
    endif;

endif;
