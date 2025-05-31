<?php
if( $panel["panel_status"] == "suspended" ): include 'app/views/frozen.twig';exit(); endif;
if( $panel["panel_status"] == "frozen" ): include 'app/views/frozen.twig';exit(); endif;
$title .= "Kupon Kullan";

if( $_SESSION["msmbilisim_userlogin"] != 1  || $user["client_type"] == 1  ){
  Header("Location:".site_url('logout'));
}
if( $settings["email_confirmation"] == 1  && $user["email_type"] == 1  ){
  Header("Location:".site_url('confirm_email'));
}
if( !route(1) ){
	
	
	
	
	
	
	
	
	
  if( $_POST ){
    foreach ($_POST as $key => $value) {
      $_SESSION["data"][$key]  = $value;
    }
	
	
    $kuponadi  = $_POST["kuponadi"];
	
	
	
      if( empty($kuponadi) ){
        $error    = 1;
        $errorText= "Lütfen tüm alanları doldurun.";
      }else{
		  
		  
		  
		$varmi = $conn->prepare("SELECT count(*) as toplam FROM kuponlar WHERE kuponadi = ?");
		$varmi->execute([$kuponadi]);
		$count = $varmi->fetch(PDO::FETCH_ASSOC);
		
		if($count["toplam"]>0){
			
			$kuponal = $conn->prepare("SELECT * FROM kuponlar WHERE kuponadi = ?");
			$kuponal->execute([$kuponadi]);
			$kuponal = $kuponal->fetch(PDO::FETCH_ASSOC);
			
			
			if($kuponal["adet"]>0){
				
				//kullanmismi
			$kullanmismi = $conn->prepare("SELECT * FROM kupon_kullananlar WHERE uye_id=:uye_id and kuponadi =:kuponadi");
			$kullanmismi->execute(array("uye_id"=>$user["client_id"], "kuponadi"=>$kuponal["kuponadi"]));
			$kullanmismi = $kullanmismi->fetch(PDO::FETCH_ASSOC);
			
			if($kullanmismi>0){
				
				 $error    = 1;
				$errorText= "Bu kuponu zaten kullandınız.";
		  
			}else{
				
				
				$uyebakiye = $conn->prepare("SELECT * FROM clients WHERE client_id=:client_id");
				$uyebakiye->execute(array("client_id"=>$user["client_id"]));
				$uyebakiye = $uyebakiye->fetch(PDO::FETCH_ASSOC);
				$uyebakiyesi = $uyebakiye["balance"];
				


				
				
				$yenibakiye = $kuponal["tutar"]+$uyebakiyesi;
				
				
				$conn->beginTransaction();
				$bakiyeguncelle = $conn->prepare("UPDATE clients SET balance=:balances  WHERE client_id=:c_id ");
				$bakiyeguncelle-> execute(array("c_id"=>$user["client_id"], "balances"=>$yenibakiye ));
				
				$adetdusur = $conn->prepare("UPDATE kuponlar SET adet=adet-1 WHERE id=:kupon_id ");
				$adetdusur-> execute(array("kupon_id"=>$kuponal["id"] ));
				
				$kullanildi = $conn->prepare("insert into kupon_kullananlar SET uye_id=:uye_id,kuponadi=:kuponadi,tutar=:tutar ");
				$kullanildi-> execute(array("uye_id"=>$user["client_id"], "kuponadi"=>$kuponal["kuponadi"],"tutar"=>$kuponal["tutar"] ));
				$conn->commit();
				
				
				$success    = 1;
				$successText= "Kupon karşılığı bakiyenize eklenmiştir. Teşekkürler.";
				
				
			}
			//kullanmismi
				
			}else{
				 $error    = 1;
				$errorText= "Bu kupon tükenmiştir.";
			}
			
			
			
		}else{
		  $error    = 1;
          $errorText= "Kupon bulunamadı.";
		}
		
		
		
      }
  }
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	



}elseif( route(1) && preg_replace('/[^a-zA-Z]/', '', route(1))  ){

  header('Location:'.site_url('404'));

}
