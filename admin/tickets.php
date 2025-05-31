<?php



$title .= $languageArray["tickets.title"];

if( $_SESSION["msmbilisim_userlogin"] != 1  || $user["client_type"] == 1  ){
  Header("Location:".site_url('logout'));
}
if( $settings["email_confirmation"] == 1  && $user["email_type"] == 1  ){
  Header("Location:".site_url('confirm_email'));
}
if( !route(1) ){

  $tickets = $conn->prepare("SELECT * FROM tickets WHERE client_id=:c_id ORDER BY lastupdate_time DESC ");
  $tickets-> execute(array("c_id"=>$user["client_id"]));
  $tickets = $tickets->fetchAll(PDO::FETCH_ASSOC);
  $ticketList = [];
    foreach ($tickets as $ticket) {
      foreach ($ticket as $key => $value) {
        if( $key == "status" ){
          $t[$key] = $languageArray["tickets.status.".$value];
        }else{
          $t[$key] = $value;
        }
      }
      array_push($ticketList,$t);
    }

  if( $_POST ){
    foreach ($_POST as $key => $value) {
      $_SESSION["data"][$key]  = $value;
    }
    $subject  = filter_var($_POST["subject"], FILTER_SANITIZE_STRING);
    $subject  = strip_tags(htmlspecialchars($subject));
    $message  = filter_var($_POST["message"], FILTER_SANITIZE_STRING);
    $message  = strip_tags(htmlspecialchars($message));
      if( empty($subject) ){
        $error    = 1;
        $errorText= $languageArray["error.tickets.new.subject"];
      }elseif( strlen(str_replace(' ','',$message)) < 1 ){
        $error    = 1;
        $errorText= str_replace("{length}","1",$languageArray["error.tickets.new.message.length"]);
      }elseif( open_ticket($user["client_id"]) >=  $settings["tickets_per_user"] ){
        $error    = 1;
        $errorText= str_replace("{limit}",$settings["tickets_per_user"],$languageArray["error.tickets.new.limit"]);
      }else{
        $conn->beginTransaction();
        $insert = $conn->prepare("INSERT INTO tickets SET client_id=:c_id, subject=:subject, time=:time, lastupdate_time=:last_time ");
        $insert = $insert->execute(array("c_id"=>$user["client_id"],"subject"=>$subject,"time"=>date("Y.m.d H:i:s"),"last_time"=>date("Y.m.d H:i:s") ));
          if( $insert ){ $ticket_id = $conn->lastInsertId(); }
        $insert2= $conn->prepare("INSERT INTO ticket_reply SET ticket_id=:t_id, message=:message, time=:time ");
        $insert2= $insert2->execute(array("t_id"=>$ticket_id,"message"=>$message,"time"=>date("Y.m.d H:i:s")));
        $insert3= $conn->prepare("INSERT INTO client_report SET client_id=:c_id, action=:action, report_ip=:ip, report_date=:date ");
        $insert3= $insert3->execute(array("c_id"=>$user["client_id"],"action"=>"New support ticket created#".$ticket_id,"ip"=>GetIP(),"date"=>date("Y-m-d H:i:s") ));
if( $settings["alert_newticket"] == 2 ){
$msg = "Hello,
You have a new message in the ticket.
Follow the link below to see the message:
".site_url()."/admin/tickets/read/".$ticket_id;
        $send = mail($settings["admin_mail"],"New Message",$msg);
} 
        if( $insert && $insert2 && $insert3 ):
          unset($_SESSION["data"]);
          header('Location:'.site_url('tickets/').$ticket_id);
          $conn->commit();
          
        else:
          $error    = 1;
          $errorText= $languageArray["error.tickets.new.fail"];
          $conn->rollBack();
        endif;
      }
  }

}elseif( route(1) && preg_replace('/[^0-9]/', '', route(1)) && !preg_replace('/[^a-zA-Z]/', '', route(1))  ){

if (!countRow(["table" => "tickets", "where" => ["ticket_id" => route(1) ,"client_id" => $user["client_id"] ]])):
        header("Location:" . site_url("tickets"));
        exit();
    else:

  $templateDir  = "open_ticket";



  $ticketUpdate = $conn->prepare("UPDATE tickets SET support_new=:new  WHERE client_id=:c_id && ticket_id=:t_id ");
  $ticketUpdate-> execute(array("c_id"=>$user["client_id"], "new"=>1, "t_id"=>route(1) ));
  $ticketUpdate = $ticketUpdate->fetch(PDO::FETCH_ASSOC);
  $messageList  = $conn->prepare("SELECT * FROM ticket_reply WHERE ticket_id=:t_id ");
  $messageList  -> execute(array("t_id"=>route(1)));
  $messageList  = $messageList->fetchAll(PDO::FETCH_ASSOC);


  $ticketList = $conn->prepare("SELECT * FROM tickets WHERE client_id=:c_id && ticket_id=:t_id ");
  $ticketList-> execute(array("c_id"=>$user["client_id"], "t_id"=>route(1) ));
  $ticketList = $ticketList->fetch(PDO::FETCH_ASSOC);
  $messageList["ticket"]  = $ticketList;
$tickets  = $conn->prepare("SELECT * FROM ticket_reply WHERE ticket_id=:t_id ");
  $tickets -> execute(array("t_id"=>route(1)));
  $tickets = $tickets->fetchAll(PDO::FETCH_ASSOC);
$tickets = $conn->prepare("SELECT * FROM tickets WHERE client_id=:c_id && ticket_id=:t_id ");
  $tickets-> execute(array("c_id"=>$user["client_id"], "t_id"=>route(1) ));
  $tickets = $tickets->fetch(PDO::FETCH_ASSOC);
$ticketsList = [];

     foreach ($tickets as $ticket) {
        
$t["message"] =  $ticket["message"];
        $t["time"] =  $ticket["time"];
       $t["refill_end_date"] =  $refill_end_date;
        $t["show_refill"]  = $ticket["show_refill"];
      $t["id"]    = $ticket["order_id"];

      array_push($ticketsList,$t);
     
    }

endif;



  if( $_POST ){
    foreach ($_POST as $key => $value) {
      $_SESSION["data"][$key]  = $value;
    }
   $message  = str_replace('<script>','',$_POST["message"]);
   $message  = filter_var($message, FILTER_SANITIZE_STRING);
   $message  = strip_tags(htmlspecialchars($message));
            if( empty($message)){
        $error    = 1;
        $errorText= "Message can't be Empty";
      }elseif( strlen(str_replace(' ','',$message)) < 1 ){
        $error    = 1;
        $errorText= str_replace("{length}","1",$languageArray["error.tickets.read.message.length"]);
      }elseif( $ticketList["canmessage"] == 1 ){
        $error    = 1;
        $errorText= $languageArray["error.tickets.read.message.cant"];
      }else{
        $conn->beginTransaction();
        $update = $conn->prepare("UPDATE tickets SET lastupdate_time=:last_time, status=:status, client_new=:new WHERE ticket_id=:t_id ");
        $update = $update->execute(array("last_time"=>date("Y.m.d H:i:s"),"t_id"=>route(1),"new"=>2,"status"=>"pending" ));
        $insert = $conn->prepare("INSERT INTO ticket_reply SET ticket_id=:t_id, message=:message, time=:time ");
        $insert = $insert->execute(array("t_id"=>route(1),"message"=>$message,"time"=>date("Y.m.d H:i:s")));
        $insert3= $conn->prepare("INSERT INTO client_report SET client_id=:c_id, action=:action, report_ip=:ip, report_date=:date ");
        $insert3= $insert3->execute(array("c_id"=>$user["client_id"],"action"=>"Support request answered#".route(1),"ip"=>GetIP(),"date"=>date("Y-m-d H:i:s") ));

if( $settings["alert_newticket"] == 2 ){
$msg = "Hello,
You have a new message in the ticket.
Follow the link below to see the message:
". site_url()."/admin/tickets?search=unread/".$ticket_id;
        $send = mail($settings["admin_mail"],"New Message",$msg);
} 
        if( $update && $insert && $insert3 ):
          unset($_SESSION["data"]);
          $conn->commit();
          header("Location:".site_url('tickets/').route(1));
        else:
          $error    = 1;
          $errorText= $languageArray["error.tickets.read.fail"];
          $conn->rollBack();
        endif;
      }
  }

}elseif( route(1) && preg_replace('/[^a-zA-Z]/', '', route(1))  ){

  header('Location:'.site_url('404'));

}

$status_list  = ["all","pending","answered","closed","paused","expired"];
$search_statu = route(1); if( !route(1) ):  $route[1] = "all";  endif;

  if( !in_array($search_statu,$status_list) ):
    $route[1]         = "all";
  endif;

  if( route(2) ):
    $page         = route(2);
  else:
    $page         = 1;
  endif;
    if( route(1) != "all" ): $search  = "&& ticket_status='".route(1)."'"; else: $search = ""; endif;
    if( !empty($_GET["search"]) ): $search.= " && ( order_url LIKE '%".$_GET["search"]."%' ||  order_id LIKE '%".$_GET["search"]."%' ) "; endif;
    $c_id       = $user["client_id"];
    $to         = 25;
    $count      = $conn->query("SELECT * FROM tickets WHERE client_id='$c_id' $search ")->rowCount();
    $pageCount  = ceil($count/$to);
      if( $page > $pageCount ): $page = 1; endif;
    $where      = ($page*$to)-$to;
    $paginationArr = ["count"=>$pageCount,"current"=>$page,"next"=>$page+1,"previous"=>$page-1];