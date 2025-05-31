<?php


$title .= $languageArray["subscriptions.title"];

if( $_SESSION["msmbilisim_userlogin"] != 1  || $user["client_type"] == 1  ){
  Header("Location:".site_url('logout'));
}
if( $settings["email_confirmation"] == 1  && $user["email_type"] == 1  ){
  Header("Location:".site_url('confirm_email'));
}
  if( route(1) == "pause" ):
    $order_id = route(2);
    $row      =   $conn->prepare("SELECT * FROM orders WHERE order_id=:id && ( subscriptions_status=:status || subscriptions_status=:status2 ) ");
    $row      ->  execute(array("id"=>$order_id,"status"=>"active","status2"=>"expired" ));
      if( $row->rowCount() ):
        $row    = $row->fetch(PDO::FETCH_ASSOC);
        $update = $conn->prepare("UPDATE orders SET subscriptions_status=:status WHERE order_id=:id  ");
        $update->execute(array("id"=>$order_id,"status"=>"paused"  ));
        $insert= $conn->prepare("INSERT INTO client_report SET client_id=:c_id, action=:action, report_ip=:ip, report_date=:date ");
        $insert= $insert->execute(array("c_id"=>$user["client_id"],"action"=>"Abonelik durduruldu #".$row["order_id"],"ip"=>GetIP(),"date"=>date("Y-m-d H:i:s") ));
      endif;
    Header("Location:".site_url('subscriptions'));
    exit();
  elseif( route(1) == "resume" ):
    $order_id = route(2);
    $row      =   $conn->prepare("SELECT * FROM orders WHERE order_id=:id && subscriptions_status=:status ");
    $row      ->  execute(array("id"=>$order_id,"status"=>"paused" ));
      if( $row->rowCount() ):
        $row    = $row->fetch(PDO::FETCH_ASSOC);
        $update = $conn->prepare("UPDATE orders SET subscriptions_status=:status WHERE order_id=:id  ");
        $update->execute(array("id"=>$order_id,"status"=>"active"  ));
        $insert= $conn->prepare("INSERT INTO client_report SET client_id=:c_id, action=:action, report_ip=:ip, report_date=:date ");
        $insert= $insert->execute(array("c_id"=>$user["client_id"],"action"=>"Abonelik aktifleştirildi #".$row["order_id"],"ip"=>GetIP(),"date"=>date("Y-m-d H:i:s") ));
      endif;
    Header("Location:".site_url('subscriptions'));
    exit();
  elseif( route(1) == "stop" ):
    $order_id = route(2);
    $row      =   $conn->prepare("SELECT * FROM orders WHERE order_id=:id && ( subscriptions_status=:status || subscriptions_status=:status2 ) ");
    $row      ->  execute(array("id"=>$order_id,"status"=>"paused","status2"=>"active" ));
      if( $row->rowCount() ):
        $row    = $row->fetch(PDO::FETCH_ASSOC);
        $update = $conn->prepare("UPDATE orders SET subscriptions_status=:status WHERE order_id=:id  ");
        $update->execute(array("id"=>$order_id,"status"=>"canceled"  ));
        $insert= $conn->prepare("INSERT INTO client_report SET client_id=:c_id, action=:action, report_ip=:ip, report_date=:date ");
        $insert= $insert->execute(array("c_id"=>$user["client_id"],"action"=>"Abonelik iptal edildi #".$row["order_id"],"ip"=>GetIP(),"date"=>date("Y-m-d H:i:s") ));
      endif;
    Header("Location:".site_url('subscriptions'));
    exit();
  endif;

$status_list  = ["all","active","completed","canceled","paused","expired"];
$search_statu = route(1); if( !route(1) ):  $route[1] = "all";  endif;

  if( !in_array($search_statu,$status_list) ):
    $route[1]         = "all";
  endif;

  if( route(2) ):
    $page         = route(2);
  else:
    $page         = 1;
  endif;
    if( route(1) != "all" ): $search  = "&& subscriptions_status='".route(1)."'"; else: $search = ""; endif;
    if( !empty($_GET["search"]) ): $search.= " && ( order_url LIKE '%".$_GET["search"]."%' ||  order_id LIKE '%".$_GET["search"]."%' ) "; endif;
    $c_id       = $user["client_id"];
    $to         = 25;
    $count      = $conn->query("SELECT * FROM orders WHERE client_id='$c_id' && dripfeed='1' && subscriptions_type='2' $search ")->rowCount();
    $pageCount  = ceil($count/$to);
      if( $page > $pageCount ): $page = 1; endif;
    $where      = ($page*$to)-$to;
    $paginationArr = ["count"=>$pageCount,"current"=>$page,"next"=>$page+1,"previous"=>$page-1];

  $orders = $conn->prepare("SELECT * FROM orders INNER JOIN services WHERE services.service_id = orders.service_id && orders.dripfeed=:dripfeed && orders.subscriptions_type=:subs && orders.client_id=:c_id $search ORDER BY orders.order_id DESC LIMIT $where,$to ");
  $orders-> execute(array("c_id"=>$user["client_id"],"dripfeed"=>1,"subs"=>2 ));
  $orders = $orders->fetchAll(PDO::FETCH_ASSOC);
  $ordersList = [];

    foreach ($orders as $order) {
      $o["id"]              = $order["order_id"];
      $o["date_created"]    = date("d.m.Y H:i:s", (strtotime($order["order_create"])+$user["timezone"]) );
      $o["date_updated"]    = date("d.m.Y H:i:s", (strtotime($order["last_check"])+$user["timezone"]) );
      $o["date_expiry"]     = date("d.m.Y", strtotime($order["subscriptions_expiry"]) ); if( $o["date_expiry"] == "01.01.1970 00:00" ): $o["date_expiry"] = ""; endif;
      $o["link"]            = $order["order_url"];
      $o["service"]         = $order["service_name"];
      $o["posts"]           = $order["subscriptions_posts"];
      $o["current_count"]   = $order["subscriptions_delivery"];
      $o["quantity_min"]    = $order["subscriptions_min"];
      $o["quantity_max"]    = $order["subscriptions_max"];
      $o["delay"]           = ($order["subscriptions_delay"]/60); if( $o["delay"] == 0 ): $o["delay"] = "Gecikme yok"; endif;
      $o["status_name"]     = $languageArray["subscriptions.status.".$order["subscriptions_status"]];
      $o["status"]          = $order["subscriptions_status"];
      array_push($ordersList,$o);
    }
