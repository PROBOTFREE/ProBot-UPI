<?php
function fetchCsrfAndCookies() {
    $ch = curl_init();
    curl_setopt_array($ch, [
        CURLOPT_URL => 'https://www.freecharge.in/api/ims/rest/create/csrf',
        CURLOPT_RETURNTRANSFER => true,
        CURLOPT_HEADER => true,
        CURLOPT_HTTPHEADER => [         
           'user-agent: Mozilla/5.0 (Linux; Android 10; K) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/124.0.0.0 Mobile Safari/537.36'
        ],
        CURLOPT_ENCODING => 'gzip, deflate'
    ]);
    $response = curl_exec($ch);

    if (curl_errno($ch)) {
        echo 'cURL error: ' . curl_error($ch);
        curl_close($ch);
        return null;
    }

    $header_size = curl_getinfo($ch, CURLINFO_HEADER_SIZE);
    $header = substr($response, 0, $header_size);
    $body = substr($response, $header_size);

    $csrfToken = json_decode($body, true)['csrfRequestIdentifier'] ?? 'Not found';

    preg_match_all('/^Set-Cookie:\s*([^;]*)/mi', $header, $matches);
    $cookie = implode('; ', $matches[1]);

    curl_close($ch);

    return ['csrfToken' => $csrfToken, 'cookie' => $cookie];
}

function generateKeys($csrfToken, $cookie) {
    $url = 'https://www.freecharge.in/api/ems/nosession/v2/external/encryption/generatekeys';
    $ch = curl_init($url);
    curl_setopt($ch, CURLOPT_RETURNTRANSFER, true);
    curl_setopt($ch, CURLOPT_POST, true);
    curl_setopt($ch, CURLOPT_HTTPHEADER, [        
        'content-type: application/json',       
        'user-agent: Mozilla/5.0 (Linux; Android 10; K) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/124.0.0.0 Mobile Safari/537.36',
        "csrfrequestidentifier: $csrfToken",
        "cookie: $cookie"
    ]);
    curl_setopt($ch, CURLOPT_POSTFIELDS, json_encode([]));
    $response = curl_exec($ch);
    if (curl_errno($ch)) {
        echo 'cURL error: ' . curl_error($ch);
        curl_close($ch);
        return null;
    }
    curl_close($ch);
    $data = json_decode($response, true);
    
    return $data;
}

function requestOtp($mobileNumber, $csrfToken, $publicKey, $symmetricKey, $cookie) {
    $url = 'https://www.freecharge.in/api/ims/rest/otp/send/login/signup';

    $headers = [               
        'content-type: application/json',
        "cookie: $cookie",
        "cske: $symmetricKey",
        "csrfrequestidentifier: $csrfToken",
        'fcchannel: 12',        
        "pke: $publicKey",       
        'user-agent: Mozilla/5.0 (Linux; Android 10; K) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/124.0.0.0 Mobile Safari/537.36',
    ];

    $data = [
        'mobileNumber' => $mobileNumber,
        'fcChannel' => 12,
        'platformType' => 'WEB'
    ];

    $ch = curl_init();
    curl_setopt($ch, CURLOPT_URL, $url);
    curl_setopt($ch, CURLOPT_HTTPHEADER, $headers);
    curl_setopt($ch, CURLOPT_RETURNTRANSFER, true);
    curl_setopt($ch, CURLOPT_POST, true);
    curl_setopt($ch, CURLOPT_POSTFIELDS, json_encode($data));
    curl_setopt($ch, CURLOPT_ENCODING, '');

    $response = curl_exec($ch);

    if (curl_errno($ch)) {
        echo 'cURL error: ' . curl_error($ch);
        curl_close($ch);
        return null;
    }

    curl_close($ch);

    $data = json_decode($response, true);
    
    return $data;
}

$mobileNumber = isset($_GET['no']) ? $_GET['no'] : '';

$csrfAndCookies = fetchCsrfAndCookies();
if ($csrfAndCookies === null) {
    echo json_encode(['status' => 'failed', 'error' => 'Error fetching CSRF token and cookies.']);
    exit;
}

$csrfToken = $csrfAndCookies['csrfToken'];
$cookie = $csrfAndCookies['cookie'];

$keys = generateKeys($csrfToken, $cookie);
if ($keys === null) {
    echo json_encode(['status' => 'failed', 'error' => 'Error generating keys.']);
    exit;
}

$publicKey = isset($keys['data']['pke']) ? $keys['data']['pke'] : '';
$symmetricKey = isset($keys['data']['cske']) ? $keys['data']['cske'] : '';

$response = requestOtp($mobileNumber, $csrfToken, $publicKey, $symmetricKey, $cookie);

if (isset($response['error']) && $response['error'] !== null) {
    $status = 'failed';
    $errorMessage = $response['error']['errorMessage'];
    $responseData = ['status' => $status, 'msg' => $errorMessage];
} else {
    $status = 'success';
    $responseData = ['status' => $status, 'data' => $response['data']];
}

header('Content-Type: application/json');
echo json_encode($responseData);
?>
