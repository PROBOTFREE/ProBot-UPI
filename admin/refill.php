<?php

if( $panel["panel_status"] == "suspended" ): include 'app/views/frozen.twig';exit(); endif;
if( $panel["panel_status"] == "frozen" ): include 'app/views/frozen.twig';exit(); endif;


$title .= $languageArray["refills.title"];

if( $_SESSION["msmbilisim_userlogin"] != 1  || $user["client_type"] == 1  ){
  Header("Location:".site_url('logout'));
}

 if( $settings["email_confirmation"] == 1  && $user["email_type"] == 1  ){
  Header("Location:".site_url('confirm_email'));
}

$smmapi   = new SMMApi();
$fapi     = new socialsmedia_api();

$status_list  = ["all","Pending","Refilling","Completed","Rejected","Error","canceled"];
$search_statu = route(1); if( !route(1) ):  $route[1] = "all";  endif;

  if( !in_array($search_statu,$status_list) ):
    $route[1]         = "all";
  endif;

$status_list  = ["all","Pending","Refilling","Completed","Rejected","Error","canceled"];
$search_statu = route(1); if( !route(1) ):  $route[1] = "all";  endif;

  if( !in_array($search_statu,$status_list) ):
    $route[1]         = "all";
  endif;

  if( route(2) ):
    $page         = route(2);
  else:
    $page         = 1;
  endif;
    if( route(1) != "all" ): $search  = "&& refill_status='".route(1)."'"; else: $search = ""; endif;
    if( !empty(urldecode($_GET["search"])) ): $search.= " && ( order_url LIKE '%".urldecode($_GET["search"])."%' || order_id LIKE '%".urldecode($_GET["search"])."%' ) "; endif;
    if( !empty($_GET["subscription"]) ): $search.= " && ( subscriptions_id LIKE '%".$_GET["subscription"]."%'  ) "; endif;
    if( !empty($_GET["dripfeed"]) ): $search.= " && ( dripfeed_id LIKE '%".$_GET["dripfeed"]."%'  ) "; endif;
    $c_id       = $user["client_id"];
    $to         = 25;
    $count      = $conn->query("SELECT * FROM refill_status WHERE client_id='$c_id' $search ")->rowCount();
    $pageCount  = ceil($count/$to);
      if( $page > $pageCount ): $page = 1; endif;
    $where      = ($page*$to)-$to;
    $paginationArr = ["count"=>$pageCount,"current"=>$page,"next"=>$page+1,"previous"=>$page-1];

    $orders = $conn->prepare("SELECT * FROM refill_status WHERE client_id=:c_id $search ORDER BY order_id DESC LIMIT $where,$to ");
    $orders-> execute(array("c_id"=>$user["client_id"]));
    $orders = $orders->fetchAll(PDO::FETCH_ASSOC);

  $ordersList = [];

    foreach ($orders as $order) {
      $o["id"]    = $order["order_id"];
      $o["date"]  = date("Y-m-d H:i:s", (strtotime($order["creation_date"])+$user["timezone"]));
      $o["link"]    = $order["order_url"];
      $o["service"]  = $order["service_name"];
      $o["status"]  = $languageArray["orders.status.".$order["order_status"]];
      $o["refill_id"]  = $order["id"];
$o["refill_status"]  = $order["refill_status"];
$o["show_refill"] = $order["show_refill"];
      if( $order["order_status"] == "completed" && substr($order["order_remains"], 0,1) == "-" ):
        $o["remains"]  = "+".substr($order["order_remains"], 1);
      else:
        $o["remains"]  = $order["order_remains"];
      endif;
      array_push($ordersList,$o);
    }
