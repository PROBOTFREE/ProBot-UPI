<?php

$title .= "updates";


if( $_SESSION["msmbilisim_userlogin"] != 1  || $user["client_type"] == 1  ){
  Header("Location:".site_url('logout'));
}
if(!$general["updates_show"] == 2 ){
  Header("Location:".site_url(''));
}

if( $settings["email_confirmation"] == 1  && $user["email_type"] == 1  ){
  Header("Location:".site_url('confirm_email'));
}




 
   $status_list  = ["all","pending","inprogress","completed","partial","processing","canceled"];
$search_statu = route(1); if( !route(1) ):  $route[1] = "all";  endif;

  if( !in_array($search_statu,$status_list) ):
    $route[1]         = "all";
  endif;

  if( route(2) ):
    $page         = route(2);
  else:
    $page         = 1;
  endif;
    if( route(1) != "all" ): $search  = "&& order_status='".route(1)."'"; else: $search = ""; endif;
    if( !empty(urldecode($_GET["search"])) ): $search.= " && ( order_url LIKE '%".urldecode($_GET["search"])."%' || order_id LIKE '%".urldecode($_GET["search"])."%' ) "; endif;
    if( !empty($_GET["subscription"]) ): $search.= " && ( subscriptions_id LIKE '%".$_GET["subscription"]."%'  ) "; endif;
    if( !empty($_GET["dripfeed"]) ): $search.= " && ( dripfeed_id LIKE '%".$_GET["dripfeed"]."%'  ) "; endif;
    
    
    
   
    
    $to         = 25;
    $count      = $conn->query("SELECT * FROM updates $search ")->rowCount();
    $pageCount  = ceil($count/$to);
      if( $page > $pageCount ): $page = 1; endif;
    $where      = ($page*$to)-$to;
    $paginationArr = ["count"=>$pageCount,"current"=>$page,"next"=>$page+1,"previous"=>$page-1];

    $orders = $conn->prepare("SELECT * FROM updates INNER JOIN services WHERE services.service_id = updates.service_id  $search ORDER BY updates.u_id DESC LIMIT $where,$to ");
    $orders-> execute(array( ));
    $orders = $orders->fetchAll(PDO::FETCH_ASSOC);

  $ordersList = [];

     foreach ($orders as $order) {
        
        
             
   
      $o["id"]    = $order["u_id"];
$o["service_id"]    = $order["service_id"];
$o["service_name"]    = $order["service_name"];
      $o["date"]  = date("Y-m-d H:i:s", (strtotime($order["date"])));
      $o["action"]    = $order["action"];
      $o["description"]  = $order["description"];

      array_push($ordersList,$o);
     
    }
