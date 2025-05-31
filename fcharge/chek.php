<?php

$searchComment = isset($_GET['txn']) ? $_GET['txn'] : '';
$cookie = isset($_GET['cookie']) ? $_GET['cookie'] : '';
$token = isset($_GET['token']) ? $_GET['token'] : '';

$url = "https://www.freecharge.in/thv/listv3?fcAppType=MSITE";

$ch = curl_init($url);
curl_setopt($ch, CURLOPT_RETURNTRANSFER, true);
curl_setopt($ch, CURLOPT_HTTPHEADER, [
    "Content-Type: application/json",
    "Cookie: $cookie",
    "User-Agent: Mozilla/5.0 (Linux; Android 10; K) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/124.0.0.0 Mobile Safari/537.36"
]);

$data = [
    'userImsId' => $token,
    'isAndroid' => false,
    'fromDate' => null,
    'toDate' => null,
    'paymentStatus' => '',
    'paymentDirection' => ''
];
curl_setopt($ch, CURLOPT_POST, true);
curl_setopt($ch, CURLOPT_POSTFIELDS, json_encode($data));

$response = curl_exec($ch);

if (curl_errno($ch)) {
    echo json_encode(['status' => '500', 'message' => 'Payment Not Found']);
    exit;
}
curl_close($ch);

$data = json_decode($response, true);
if (isset($data['data']['globalTransactions'])) {
    $transactionsFound = false;
    $results = [];
    foreach ($data['data']['globalTransactions'] as $transaction) {
        $txnDetails = $transaction['txnDetails'];
        $billerInfo = $transaction['billerInfo']['billerMetaData'][1]['sectionDetails'] ?? [];

        $commentFound = false;
        $upiTransactionId = null;

        foreach ($billerInfo as $info) {
            if ($info['name'] === "Comments" && $info['value'] === $searchComment) {
                $commentFound = true;
                $commentValue = $info['value'];
            }

            if ($info['name'] === "UPI Transaction ID") {
                $upiTransactionId = $info['value'];
            }
        }               

        if ($commentFound) {
            $transactionsFound = true;
            $results[] = [
                'status' => $txnDetails['status'],
                'txnid' => $commentValue,
                'utr' => $upiTransactionId,
                'amount' => $txnDetails['amount'],
                'upi' => $transaction['subtitle'],
                'payer' => $transaction['title'],
                'date' => date('Y-m-d H:i:s', $txnDetails['timestamp'] / 1000)
            ];
        }
    }

    if ($transactionsFound) {
        echo json_encode(['status' => '200', 'message' => 'Payment Found', 'transactions' => $results]);
    } else {
        echo json_encode(['status' => '500', 'message' => 'Payment Not Found']);
    }
} else {
    echo json_encode(['status' => '500', 'message' => 'Payment Not Found']);
}
?>
