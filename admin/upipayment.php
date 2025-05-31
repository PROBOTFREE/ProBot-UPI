<?php

$verifySignature = '';
$array = array();
$paramList = array();

$secret = 'CkW9sBRYkQ'; // Your Secret Key.
$status = $_POST['status']; // Payment Status Only, Not Txn Status.
$message = $_POST['message']; // Txn Message.
$cust_Mobile = $_POST['cust_Mobile']; // Txn Message.
$cust_Email = $_POST['cust_Email']; // Txn Message.
$hash = $_POST['hash']; // Encrypted Hash / Generated Only SUCCESS Status.
$checksum = $_POST['checksum']; // Checksum verifySignature / Generated Only SUCCESS Status.

// Payment Status.
if ($status == "SUCCESS") {
    $paramList = hash_decrypt($hash, $secret);
    $verifySignature = RechPayChecksum::verifySignature($paramList, $secret, $checksum);

    // Checksum verify.
    if ($verifySignature) {
        $array = json_decode($paramList);

        // Store the payment response in variables
        $paymentStatus = $status;
        $paymentMessage = $message;
        $paymentHash = $hash;
        $paymentChecksum = $checksum;
        $customerMobile = $cust_Mobile;      //cust mobile SAVE
        $customerEmail = $cust_Email;        //cust email save
        $senderNote = $array->sender_note;   // Store the sender note
        $amount = $array->txnAmount;         // Store the transaction amount
        $orderId = $array->orderId;          // Store the orderId
        $txnStatus = $array->txnStatus;      // Store the transaction status
        $resultInfo = $array->resultInfo;    // Store the result information
        $txnId = $array->txnId;              // Store the transaction ID
        $bankTxnId = $array->bankTxnId;      // Store the bank transaction ID
        $paymentMode = $array->paymentMode;  // Store the payment mode
        $txnDate = $array->txnDate;          // Store the transaction date
        $utr = $array->utr;                  // Store the UTR
        $senderVpa = $array->sender_vpa;     // Store the sender VPA
        $payeeVpa = $array->payee_vpa;       // Store the payee VPA

        
    }
}




 if($status=="SUCCESS")
                      
 {
   $payment = $conn->prepare('SELECT * FROM payments INNER JOIN clients ON clients.client_id=payments.client_id WHERE payments.payment_extra=:extra ');
                $payment->execute(['extra' =>  $orderId]);
                $payment = $payment->fetch(PDO::FETCH_ASSOC);
                
               

                $payment['payment_amount'] = $payment['payment_amount']/80;
                
                 
              // var_dump($settings['site_currency']);exit();endif;
                
                $payment_bonus = $conn->prepare('SELECT * FROM payments_bonus WHERE bonus_method=:method && bonus_from<=:from ORDER BY bonus_from DESC LIMIT 1');
                $payment_bonus->execute(['method' => $method['id'], 'from' => $payment['payment_amount']]);
                $payment_bonus = $payment_bonus->fetch(PDO::FETCH_ASSOC);
                            if( $payment_bonus ) {
                    $amount = $payment['payment_amount'] + (($payment['payment_amount'] * $payment_bonus['bonus_amount']) / 100) - (($payment['payment_amount'] * $extras['fee']) / 100) - (($payment['payment_amount'] * $extras['fee']) / 100);
                } else {
                    $amount = $payment['payment_amount'] - (($payment['payment_amount'] * $extras['fee']) / 100);
                }
                       
                   $conn->beginTransaction();

                $update = $conn->prepare('UPDATE payments SET client_balance=:balance,payment_amount=:amount, payment_status=:status, payment_delivery=:delivery WHERE payment_id=:id ');
                $update = $update->execute(['balance' => $payment['balance'],'amount' =>$amount, 'status' => 3, 'delivery' => 2, 'id' => $payment['payment_id']]);
              
                $balance = $conn->prepare('UPDATE clients SET balance=:balance WHERE client_id=:id ');
                $balance = $balance->execute(['id' => $payment['client_id'], 'balance' => $payment['balance'] + $amount]);

                $insert = $conn->prepare('INSERT INTO client_report SET client_id=:c_id, action=:action, report_ip=:ip, report_date=:date ');
                
                    if($settings["referral"] == 2):
					if(!empty($payment["referral"])):
						if($settings["ref_type"] == 0):
							if($amount < $settings["ref_max"]):
								$refbonus = $amount*$settings["ref_bonus"]/100;
								$refclient = $conn->prepare("SELECT * FROM clients WHERE id=:id");
                                $refclient->execute(array("id"=>$payment["referral"]));
                                $refclient = $refclient->fetch(PDO::FETCH_ASSOC);
								$update	=	$conn->prepare("UPDATE clients SET balance=:balance, refchar=:refchar,reforder=:reforder WHERE id=:id ");
								$update	=	$update-> execute(array("id"=>$payment["referral"],"balance"=>$refclient["balance"] + $refbonus,"refchar"=>$refclient["refchar"] + $refbonus,"reforder"=>$refclient["reforder"] + 1 ));
							endif;
						else:
							$paycontrol	=	$conn->prepare("SELECT * FROM payments WHERE client_id=:id, payment_status=:status ");
							$paycontrol->execute(array("id"=>$payment["client_id"],"status"=>3));
							$payon =  $paycontrol->rowCount();
							if(!$payon):
								if($amount < $settings["ref_max"]):
								$refbonus = $amount*$settings["ref_bonus"]/100;
								$refclient = $conn->prepare("SELECT * FROM clients WHERE id=:id");
                                $refclient->execute(array("id"=>$payment["referral"]));
                                $refclient = $refclient->fetch(PDO::FETCH_ASSOC);
							    $update	=	$conn->prepare("UPDATE clients SET balance=:balance, refchar=:refchar,reforder=:reforder WHERE id=:id ");
								$update	=	$update-> execute(array("id"=>$payment["referral"],"balance"=>$refclient["balance"] + $refbonus,"refchar"=>$refclient["refchar"] + $refbonus,"reforder"=>$refclient["reforder"] + 1 ));
                                endif;
							endif;
						endif;
					endif;
				endif;
 
            if( $payment_bonus ) {
                    $insert = $insert->execute(['c_id' => $payment['client_id'], 'action' => 'New ' . $amount . ' ' . $settings["currency"] . ' payment has been made with ' . $method['method_name'] . ' and included %' . $payment_bonus['bonus_amount'] . ' bonus.', 'ip' => GetIP(), 'date' => date('Y-m-d H:i:s') ]);
                } else {
                    $insert = $insert->execute(['c_id' => $payment['client_id'], 'action' => 'New ' . $amount . ' ' . $settings["currency"] . ' payment has been made with ' . $method['method_name'], 'ip' => GetIP(), 'date' => date('Y-m-d H:i:s') ]);
                }
                if ($update && $balance) {
                    $conn->commit();
                    header('location:'.site_url(addfunds));
                    echo 'OK';
              

  } else {
                    $conn->rollBack();
                    header('location:'.site_url(addfunds));
                    echo 'NO';
      
  }
                       }
                       else
                       {
                   
 header('location:'.site_url(addfunds));
                       }
                       
 
?>