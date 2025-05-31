<?php

$cookie = isset($_GET['cookie']) ? $_GET['cookie'] : '';

if (empty($cookie)) {
    echo json_encode(['status' => '400', 'message' => 'Cookie parameter missing']);
    exit;
}

$ch = curl_init();
curl_setopt($ch, CURLOPT_URL, "https://www.freecharge.in/rest/upi/v2/upistatus");
curl_setopt($ch, CURLOPT_RETURNTRANSFER, true);
curl_setopt($ch, CURLOPT_HTTPHEADER, [
    'authority: www.freecharge.in',
    'accept: application/json, text/plain, */*', 
    'content-type: application/json',
    "cookie: $cookie",
    'csrfrequestidentifier: 1042afee-e78f-47da-9901-f04a1e678737',   
    'user-agent: Mozilla/5.0 (Linux; Android 10; K) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/124.0.0.0 Mobile Safari/537.36'
]);
curl_setopt($ch, CURLOPT_POST, true);
curl_setopt($ch, CURLOPT_POSTFIELDS, json_encode(['device' => ['app' => '', 'id' => '']]));
curl_setopt($ch, CURLOPT_ENCODING, "gzip, deflate");

$response = curl_exec($ch);

if ($response === false) {
    echo json_encode(['status' => '500', 'message' => 'Curl error: ' . curl_error($ch)]);
    curl_close($ch);
    exit;
}

curl_close($ch);

$responseData = json_decode($response, true);

$primaryVpa = null;
$secondaryVpa = null;
if (isset($responseData['data']['vpas'])) {
    foreach ($responseData['data']['vpas'] as $vpa) {
        if ($vpa['status'] === 'PRIMARY') {
            $primaryVpa = $vpa['vpa'];
        } elseif ($vpa['status'] === 'SECONDARY') {
            $secondaryVpa = $vpa['vpa'];
        }
    }
}

if ($primaryVpa === null && $secondaryVpa === null) {
    $response = [
        'status' => '500',
        'message' => 'Please link bank account in Freecharge',      
    ];
} else {
    $response = [
        'status' => '200',
        'message' => 'VPA found',
        'primary_vpa' => $primaryVpa,
        'secondary_vpa' => $secondaryVpa,        
    ];
}

header('Content-Type: application/json');
echo json_encode($response);

?>
