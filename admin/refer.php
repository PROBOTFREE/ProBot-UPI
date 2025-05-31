     <?php
if( $panel["panel_status"] == "suspended" ): include 'app/views/frozen.twig';exit(); endif;
if( $panel["panel_status"] == "frozen" ): include 'app/views/frozen.twig';exit(); endif;


      $title .= "Refer & Earn";

      if ($settings["service_list"] == 1 && !$_SESSION["msmbilisim_userlogin"]) :
        header("Location:" . site_url());
      endif;
if( $settings["email_confirmation"] == 1  && $user["email_type"] == 1  ){
  Header("Location:".site_url('confirm_email'));
}
      if ($settings["referral_status"] == 1) :
        header("Location:" . site_url());
      endif;



      if ($_POST) :


        

        $ref_code =  $_POST["ref_code"];

        $ref_payoutss =  $conn->prepare("SELECT * FROM 
        referral_payouts WHERE r_p_code=:r_p_code and r_p_status=:r_p_status ");
        $ref_payoutss->execute(array("r_p_code" => $ref_code, "r_p_status" => 0));
        $ref_payoutss  = $ref_payoutss->fetch(PDO::FETCH_ASSOC);


        if ($ref_payoutss) {

          $error = "1";
          $errorText = "Already a payout pending , Try again Later !";
        } else {

          $ref_content  = $conn->prepare("SELECT * FROM referral WHERE referral_code=:referral_code ");
          $ref_content->execute(array("referral_code" => $ref_code));
          $ref_content  = $ref_content->fetch(PDO::FETCH_ASSOC);





          $referral_total_commision = $ref_content["referral_total_commision"];
          $referral_earned_commision = $ref_content["referral_earned_commision"];
          $referral_requested_commision = $ref_content["referral_requested_commision"];
          $referral_rejected_commision = $ref_content["referral_rejected_commision"];


          $referral_paid_remaining = $referral_total_commision - ($referral_earned_commision +
            $referral_requested_commision + $referral_rejected_commision);

          if ($referral_paid_remaining < $settings["referral_payout"]) {
            header("Location:" . site_url('refer'));
          }


          $insert  = $conn->prepare("INSERT INTO referral_payouts SET r_p_code=:r_p_code 
    , r_p_amount_requested=:r_p_amount_requested , r_p_requested_at=:r_p_requested_at , 
    r_p_updated_at=:r_p_updated_at");
          $insert = $insert->execute(array(
            "r_p_code" => $ref_code, "r_p_requested_at" => date("Y-m-d H:i:s"),
            "r_p_amount_requested" => $referral_paid_remaining, "r_p_updated_at" => date("Y-m-d H:i:s")
          ));




          if ($insert) {
            $success = "1";
            $successText = "Payout Request Added, It may take 2-7 days to process.";


            $update  = $conn->prepare("UPDATE referral SET 
          referral_requested_commision=:referral_requested_commision WHERE 
          referral_code=:referral_code");
            $update = $update->execute(array(
              "referral_code" => $ref_code,
              "referral_requested_commision" => $referral_paid_remaining
            ));
          } else {
            $error = "1";
            $errorText = "Some Problem Occured , Try again Later !";
          }
        }



      // exit();


      endif;



      ?>