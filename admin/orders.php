<?php


$title .= $languageArray["orders.title"];

if( $_SESSION["msmbilisim_userlogin"] != 1  || $user["client_type"] == 1  ){
  Header("Location:".site_url('logout'));
}

if( $settings["email_confirmation"] == 1  && $user["email_type"] == 1  ){
  Header("Location:".site_url('confirm_email'));
}



if( route(1) == "cancel" ):
    $order_id = route(2);
    $row      =   $conn->prepare("SELECT * FROM orders WHERE order_id=:id && ( order_status=:status ) ");
    $row      ->  execute(array("id"=>$order_id,"status"=>"Pending" ));
      if( $row->rowCount() ):
        $row    = $row->fetch(PDO::FETCH_ASSOC);
      
        $order  = $conn->prepare("SELECT * FROM orders WHERE order_id=:id ");
        $order  = $conn->prepare("SELECT * FROM orders INNER JOIN services ON services.service_id = orders.service_id INNER JOIN service_api ON services.service_api = service_api.id WHERE orders.order_id=:id ");
        $order ->execute(array("id"=>$order_id));
        $order  = $order->fetch(PDO::FETCH_ASSOC);
        $order = json_decode(json_encode($order),true);
        
        
          $services  = $conn->prepare("SELECT * FROM services WHERE service_id=:id ");
        $services ->execute(array("id"=>$order["service_id"]));
        $services  = $services->fetch(PDO::FETCH_ASSOC);
        $services = json_decode(json_encode($services),true);
        

  if($order["service_api"]  == 0) :


        $update = $conn->prepare("UPDATE orders SET order_status=:status WHERE order_id=:id  ");
        $update->execute(array("id"=>$order_id,"status"=>"Canceled"  ));
        $insert= $conn->prepare("INSERT INTO client_report SET client_id=:c_id, action=:action, report_ip=:ip, report_date=:date ");
        $insert= $insert->execute(array("c_id"=>$user["client_id"],"action"=>"Order has been canceled & Refund money for User#".$row["order_id"],"ip"=>GetIP(),"date"=>date("Y-m-d H:i:s") ));
      endif;
else:
       $smmapi   = new SMMApi();
       
       $get_refill = $smmapi->action(array('key' => $order["api_key"],'action' =>'cancel','order'=>$order["api_orderid"]),$order["api_url"]);
endif;
    Header("Location:".site_url('orders'));
    exit();
  endif;
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
    
      
      if( !empty(urldecode($_POST["refill"])) ):
         
         $order_id = $_POST["order_id"];
       // header("Location:".site_url("admin/"));
        
        $order  = $conn->prepare("SELECT * FROM orders WHERE order_id=:id ");
        $order  = $conn->prepare("SELECT * FROM orders INNER JOIN services ON services.service_id = orders.service_id INNER JOIN service_api ON services.service_api = service_api.id WHERE orders.order_id=:id ");
        $order ->execute(array("id"=>$order_id));
        $order  = $order->fetch(PDO::FETCH_ASSOC);
        $order = json_decode(json_encode($order),true);
        
        
          $services  = $conn->prepare("SELECT * FROM services WHERE service_id=:id ");
        $services ->execute(array("id"=>$order["service_id"]));
        $services  = $services->fetch(PDO::FETCH_ASSOC);
        $services = json_decode(json_encode($services),true);
        

  if($order["service_api"]  == 0) :

        $order  = $conn->prepare("SELECT * FROM orders WHERE order_id=:id ");
        $order  = $conn->prepare("SELECT * FROM orders INNER JOIN services ON services.service_id = orders.service_id  WHERE orders.order_id=:id ");
        $order ->execute(array("id"=>$order_id));
        $order  = $order->fetch(PDO::FETCH_ASSOC);
        $order = json_decode(json_encode($order),true);
        
        
          $services  = $conn->prepare("SELECT * FROM services WHERE service_id=:id ");
        $services ->execute(array("id"=>$order["service_id"]));
        $services  = $services->fetch(PDO::FETCH_ASSOC);
        $services = json_decode(json_encode($services),true);
        

  
            
       
          
$insert = $conn->prepare("INSERT INTO refill_status SET client_id=:client_id , order_id=:order_id , refill_apiid=:refill_apiid ,order_apiid=:order_apiid , refill_response=:refill_response , creation_date=:creation_date , ending_date=:date , refill_where=:refill_where,  order_url=:order_url , service_name=:service_name ");
            $insert ->execute(array("client_id"=>$order["client_id"] , "order_id"=>$order["order_id"] , "refill_apiid"=> "0" , "order_apiid"=> "0", "refill_response"=>"Success" , "date"=> date("Y-m-d H:i:s") ,  "creation_date"=> date("Y-m-d H:i:s") , "refill_where" => "site" , "order_url"=>$order[order_url] , "service_name"=>$order[service_name]));
             
             
            if(!$insert):

             die;
            endif;
$update = $conn->prepare("UPDATE orders SET refill=:refill WHERE order_id=:id  ");
        $update->execute(array("id"=>$order["order_id"] , "refill"=> 2));

if($update):
            header("Location:".site_url("refill"));
           endif;     

            

            
else:
            
       $smmapi   = new SMMApi();
       
       $get_refill = $smmapi->action(array('key' => $order["api_key"],'action' =>'refill','order'=>$order["api_orderid"]),$order["api_url"]);
       
        
        $get_refill = json_decode(json_encode($get_refill), true);    
            
            
        // print_r($get_refill);
        
        
        $refill_id = $get_refill[refill];
        $refill_placed_status = $get_refill[status];
        $refill_error = $get_refill[error];
        
        
        
        
        
            
        if($refill_id || $refill_placed_status ){
            // echo "Refill placed";
            
            
            // Closing refill button of that order : 
            
             $update = $conn -> prepare("UPDATE orders SET refill=:refill WHERE order_id=:order_id");
             $update -> execute(array("order_id"=>$order["order_id"] , "refill"=>"2"));
             if(!$update):
                die;
             endif;
            
            
            //inserting the refill in table and redirecting user to refill page
           
            // $now = new DateTime(NOW);
            // $refill_placed_time = $now->format('Y-m-d H:i:s');
            
          

            // $now->modify('+1 day');
            // $refill_end_time = $now->format('Y-m-d H:i:s');
        
            $refill_placed_time = date("Y-m-d H:i:s");
            $refill_end_time = strtotime($refill_placed_time) + 86400;
        
            $refill_end_time = date("Y-m-d H:i:s" , $refill_end_time);
            
            if(empty($refill_id)){
            $refill_id = "0";
            }
            
            $insert = $conn->prepare("INSERT INTO refill_status SET client_id=:client_id , order_id=:order_id , refill_apiid=:refill_apiid ,order_apiid=:order_apiid , refill_response=:refill_response , creation_date=:creation_date , ending_date=:ending_date ,  order_url=:order_url , service_name=:service_name ");
            $insert ->execute(array("client_id"=>$order["client_id"] , "order_id"=>$order["order_id"] , "refill_apiid"=> $refill_id , "order_apiid"=>$order["api_orderid"] , "refill_response"=>"Success" , "creation_date"=>$refill_placed_time , "ending_date" => $refill_end_time , "order_url"=>$order[order_url] , "service_name"=>$order[service_name]));
             
             
            if(!$insert):
             die;
            endif;
            header("Location:".site_url("refill"));
            
      
        }else {
            
          
               //refill not placed
                echo "<script>alert('Refill will be available later.' );</script>";
                
                
            // // Closing refill button of that order : 
            
            //  $update = $conn -> prepare("UPDATE orders SET refill=:refill WHERE order_id=:order_id");
            //  $update -> execute(array("order_id"=>$order["order_id"] , "refill"=>"2"));
            //  if(!$update):
            //     die;
            //  endif;
           
        }
    
    
   
    
    
    endif;
    endif;
    
     //refilll
    
    
    
    
    
    
    
    
    $c_id       = $user["client_id"];
    $to         = 25;
    $count      = $conn->query("SELECT * FROM orders WHERE client_id='$c_id' && dripfeed='1' && subscriptions_type='1' $search ")->rowCount();
    $pageCount  = ceil($count/$to);
      if( $page > $pageCount ): $page = 1; endif;
    $where      = ($page*$to)-$to;
    $paginationArr = ["count"=>$pageCount,"current"=>$page,"next"=>$page+1,"previous"=>$page-1];

    $orders = $conn->prepare("SELECT * FROM orders INNER JOIN services WHERE services.service_id = orders.service_id && orders.dripfeed=:dripfeed && orders.subscriptions_type=:subs && orders.client_id=:c_id $search ORDER BY orders.order_id DESC LIMIT $where,$to ");
    $orders-> execute(array("c_id"=>$user["client_id"],"dripfeed"=>1,"subs"=>1 ));
    $orders = $orders->fetchAll(PDO::FETCH_ASSOC);

  $ordersList = [];

     foreach ($orders as $order) {
        
        
             
        

          $d1= new DateTime($order["order_create"]); // first date
          $d2= new DateTime(date("Y-m-d H:i:s")); // second date
$day = $order["refill_days"];
$today = $order["last_check"];
$d3 = date ("Y-m-d h:i:s", strtotime ($today ."+ $day days"));
 $interval= $d1->diff($d2); // get difference between two dates
          $diff = ($interval->days * $order["refill_hours"] ) + $interval->h;


 if($order["order_status"] == "completed" ):

 if($order["show_refill"] == "true" ):

  if($today < $d3):

  if($diff >= $order["refill_hours"] ):

              $refillbutton = "true";

endif;
endif;
endif;
endif;
if($order["order_status"] == "pending" ):

if($order["cancelbutton"] == 1 ):

              $cancelbutton = "true";
endif;

else:

$cancelbutton = "false";
endif;

$o["refill_available_at"] =  $diff;
        $o["refillbutton"] =  $refillbutton;
       $o["refill_end_date"] =  $refill_end_date;
        $o["show_refill"]  = $order["show_refill"];
      $o["id"]    = $order["order_id"];

      $o["order_api"]    = $order["order_api"];

      $o["cancel_button"]    = $cancelbutton;
$o["order_where"]    = $order["order_where"];
      $o["date"]  = date("Y-m-d H:i:s", (strtotime($order["order_create"])));
      $o["link"]    = $order["order_url"];
      $o["charge"]  = $order["order_charge"];
      $o["start_count"]  = $order["order_start"];
      $o["quantity"]  = $order["order_quantity"];
      $o["service"]  = $order["service_name"];
$o["refill"]  = $order["refill"];
      $o["status"]  = $languageArray["orders.status.".$order["order_status"]];
      if( $order["order_status"] == "completed" && substr($order["order_remains"], 0,1) == "-" ):
        $o["remains"]  = "+".substr($order["order_remains"], 1);
      else:
        $o["remains"]  = $order["order_remains"];
      endif;
      array_push($ordersList,$o);
     
    }
