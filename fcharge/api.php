<?php

$searchComment = $_GET['txn'] ?? null;
$token = $_GET['token'] ?? null;
$cookie = "app_fc=" . $token;

if (empty($searchComment) || empty($token)) {
    echo json_encode(['status' => '400', 'message' => 'Missing required parameters: txn or token']);
    exit;
}

$url = "https://www.freecharge.in/thv/listv3?fcAppType=MSITE";

$ch = curl_init($url);
curl_setopt($ch, CURLOPT_RETURNTRANSFER, true);
curl_setopt($ch, CURLOPT_HTTPHEADER, [
    "Content-Type: application/json",
    "Cookie: $cookie",
    "User-Agent: Mozilla/5.0 (Linux; Android 10; K) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/124.0.0.0 Mobile Safari/537.36"
]);

$data = [
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
    echo json_encode(['status' => '500', 'message' => 'cURL error: ' . curl_error($ch)]);
    curl_close($ch);
    exit;
}

curl_close($ch);

$responseData = json_decode($response, true);


if (isset($responseData['data']['globalTransactions']) && is_array($responseData['data']['globalTransactions'])) {
    $results = [];
    $transactionsFound = false;

    foreach ($responseData['data']['globalTransactions'] as $transaction) {
        $txnDetails = $transaction['txnDetails'] ?? [];
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
                'status' => $txnDetails['status'] ?? 'UNKNOWN',
                'message' => 'Payment Found',
                'txnid' => $commentValue ?? 'N/A',
                'utr' => $upiTransactionId ?? 'N/A',
                'amount' => $txnDetails['amount'] ?? 0,
                'upi' => $transaction['subtitle'] ?? 'N/A',
                'payer' => $transaction['title'] ?? 'N/A',
                'date' => isset($txnDetails['timestamp']) ? date('Y-m-d H:i:s', $txnDetails['timestamp'] / 1000) : 'N/A'
            ];
        }
    }

    if ($transactionsFound) {
        echo json_encode($results);
    } else {
        echo json_encode(['status' => 'PENDING', 'message' => 'No transactions found']);
    }
} else {
    echo json_encode(['status' => 'FAILED', 'message' => 'INVALID TOKEN OR TOKEN EXPIRED']);
}
