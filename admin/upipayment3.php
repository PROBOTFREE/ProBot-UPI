<?php
$successResponseData = $_COOKIE['payment_success'];
$method_id = 184;

$method = $conn->prepare("SELECT * FROM payment_methods WHERE id=:id ");
$method->execute(array("id" => $method_id));
$method = $method->fetch(PDO::FETCH_ASSOC);
$extra = json_decode($method["method_extras"], true);
$responseData = json_decode($successResponseData, true);
$payment = $responseData['gateway_txn'];
$userToken = $extra['salt_key'];
$gatewayTxn = $payment;

$checkStatusEndpointURL = 'https://nortaxsmm.in/payment/check_order.php';
$checkStatusURL = $checkStatusEndpointURL . '?user_token=' . urlencode($userToken) . '&gateway_txn=' . urlencode($gatewayTxn);

$curl = curl_init();
curl_setopt_array($curl, [
    CURLOPT_URL => $checkStatusURL,
    CURLOPT_RETURNTRANSFER => true,
]);
$response = curl_exec($curl);

if ($response === false) {
    $errorMessage = curl_error($curl);
    echo 'cURL Error: ' . $errorMessage;
} else {
    curl_close($curl);
    $responseData = json_decode($response, true);

    if ($responseData === null) {
        echo 'JSON decoding error';
    } else {
        if (isset($responseData['status'])) {
            $paymentStatus = $responseData['status'];
$successResponseData = $_COOKIE['payment_success'];
$respon = json_decode($successResponseData, true);
            if ($paymentStatus === 'SUCCESS') {
                $payment = $conn->prepare('SELECT * FROM payments INNER JOIN clients ON clients.client_id=payments.client_id WHERE payments.payment_extra=:extra ');
                $payment->execute(['extra' =>  $respon['gateway_txn']]);
                $payment = $payment->fetch(PDO::FETCH_ASSOC);
                $payment['payment_amount'] = $payment['payment_amount'] / 80;
                // var_dump($settings['site_currency']);exit();endif;
                
                $payment_bonus = $conn->prepare('SELECT * FROM payments_bonus WHERE bonus_method=:method && bonus_from<=:from ORDER BY bonus_from DESC LIMIT 1');
                $payment_bonus->execute(['method' => $method['id'], 'from' => $payment['payment_amount']]);
                $payment_bonus = $payment_bonus->fetch(PDO::FETCH_ASSOC);
                
                if ($payment_bonus) {
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

                if ($payment_bonus) {
                    $insert = $insert->execute(['c_id' => $payment['client_id'], 'action' => 'New ' . $amount . ' ' . $settings["currency"] . ' payment has been made with ' . $method['method_name'] . ' and included %' . $payment_bonus['bonus_amount'] . ' bonus.', 'ip' => GetIP(), 'date' => date('Y-m-d H:i:s')]);
                } else {
                    $insert = $insert->execute(['c_id' => $payment['client_id'], 'action' => 'New ' . $amount . ' ' . $settings["currency"] . ' payment has been made with ' . $method['method_name'], 'ip' => GetIP(), 'date' => date('Y-m-d H:i:s')]);
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
            } else {
                header('location:'.site_url(addfunds));
            }
        } else {
            header('location:'.site_url(addfunds));
        }
    }
}
?>