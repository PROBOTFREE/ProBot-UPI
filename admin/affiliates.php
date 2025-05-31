<?php



//check if user already has an account

if ($_COOKIE['u_login'] != "ok") {

   $ref_code =  $_GET['ref'];

  
   $user = $conn->prepare("SELECT * FROM clients WHERE ref_code=:ref_code");
   $user->execute(array("ref_code" => $ref_code));
   $user = $user->fetch(PDO::FETCH_ASSOC);

       

   //check if this refferal code exist and active

   if (countRow(['table' => 'clients', 'where' => ['ref_code' => $ref_code]])) {

      //    referral_clicks

      if (countRow(['table' => 'referral', 'where' => ['referral_code' => $ref_code]])) {
         if ($_COOKIE['u_visited'] != 1) {
            $select = $conn->prepare("SELECT * FROM referral WHERE referral_code=:referral_code");
            $select->execute(array("referral_code" => $ref_code));
            $select  = $select->fetch(PDO::FETCH_ASSOC);
           
            //update signup value
            $update = $conn->prepare("UPDATE referral SET referral_clicks=:referral_clicks ,  referral_client_id=:referral_client_id, referral_status=:referral_status WHERE referral_code=:referral_code");
            $update = $update->execute(array("referral_client_id" => $user["client_id"] , "referral_code" => $ref_code, "referral_clicks" => $select["referral_clicks"] + 1,"referral_status"=> 2 ));
            setcookie("u_visited",  1 , strtotime('+1 days'), '/', null, null, true);
         }
      } else {
         //insert

         
     




         $insert = $conn->prepare("INSERT INTO referral SET referral_code=:referral_code , referral_client_id=:referral_client_id");
         $insert->execute(array("referral_code" => $ref_code , 
      "referral_client_id" => $user["client_id"]));

         $update = $conn->prepare("UPDATE referral SET referral_clicks=:referral_clicks  WHERE referral_code=:referral_code");
         $update = $update->execute(array("referral_clicks" => 1,  "referral_code" => $ref_code));
         setcookie("u_visited",  1 , strtotime('+1 days'), '/', null, null, true);
      }






      setcookie("ref", $ref_code, strtotime('+7 days'), '/', null, null, true);
      header('Location:' . site_url(''));
   } else {
      //    wrong refferal code , do nothing
      header('Location:' . site_url(''));
   }
} else {
   header('Location:' . site_url(''));
}
