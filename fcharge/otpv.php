<?php
// Function to fetch CSRF token and cookie
function fetchCsrfAndCookie() {
    $ch = curl_init();
    curl_setopt_array($ch, [
        CURLOPT_URL => 'https://www.freecharge.in/api/ims/rest/create/csrf',
        CURLOPT_RETURNTRANSFER => true,
        CURLOPT_HEADER => true,
        CURLOPT_HTTPHEADER => [
            'authority: www.freecharge.in',
            'accept: application/json, text/plain, */*',
            'user-agent: Mozilla/5.0 (Linux; Android 10; K) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/124.0.0.0 Mobile Safari/537.36'
        ],
        CURLOPT_ENCODING => 'gzip, deflate'
    ]);
    $response = curl_exec($ch);

    if (!curl_errno($ch)) {
        $header_size = curl_getinfo($ch, CURLINFO_HEADER_SIZE);
        $header = substr($response, 0, $header_size);
        $body = substr($response, $header_size);

        // Extract CSRF token
        $csrfToken = json_decode($body, true)['csrfRequestIdentifier'] ?? null;

        // Extract cookies
        preg_match_all('/^Set-Cookie:\s*([^;]*)/mi', $header, $matches);
        $cookie = implode('; ', $matches[1]);

        curl_close($ch);

        return [
            'csrfToken' => $csrfToken,
            'cookie' => $cookie,
        ];
    }

    curl_close($ch);
    return null;
}

// Function to verify OTP
function verifyOtp($otpId, $otp, $csrfToken, $cookie) {
    $url = 'https://www.freecharge.in/api/ims/rest/mobileOnly/verify';

    $headers = [
        'authority: www.freecharge.in',
        'accept: application/json, text/plain, */*',
        'accept-language: en-GB,en;q=0.9,gu-IN;q=0.8,gu;q=0.7,en-US;q=0.6',
        'cache-control: no-cache',
        'content-type: application/json',
        "cookie: $cookie",
        "csrfrequestidentifier: $csrfToken",
        'fcchannel: 12',               
        'user-agent: Mozilla/5.0 (Linux; Android 10; K) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/124.0.0.0 Mobile Safari/537.36'
    ];

    $data = [
        'otpId' => $otpId,
        'otp' => $otp,
        'fcChannel' => 12,
        'platformType' => 'WEB',
        'assignedClientId' => '',
        'visitId' => '',
        'increaseTokenSession' => true
    ];

    $ch = curl_init();
    curl_setopt($ch, CURLOPT_URL, $url);
    curl_setopt($ch, CURLOPT_HTTPHEADER, $headers);
    curl_setopt($ch, CURLOPT_RETURNTRANSFER, true);
    curl_setopt($ch, CURLOPT_POST, true);
    curl_setopt($ch, CURLOPT_POSTFIELDS, json_encode($data));
    curl_setopt($ch, CURLOPT_ENCODING, '');
    curl_setopt($ch, CURLOPT_HEADER, true);

    $response = curl_exec($ch);
    $header_size = curl_getinfo($ch, CURLINFO_HEADER_SIZE);
    $header = substr($response, 0, $header_size);
    $body = substr($response, $header_size);
    curl_close($ch);

    preg_match_all('/^Set-Cookie:\s*([^;]+)/mi', $header, $matches);
    $cookies = implode('; ', $matches[1]);

    $json = json_decode($body, true);

    if (json_last_error() === JSON_ERROR_NONE) {
        if (isset($json['data'])) {
            $data = $json['data'];
            $status = 'success';
            $fcWalletId = $data['fcWalletId'] ?? '';
            return [
                'status' => $status,
                'fcWalletId' => $fcWalletId,
                'cookies' => $cookies,
            ];
        } else {
            $status = 'failed';
            $errorMessage = $json['errorMessage'] ?? 'Unknown error';
            return [
                'status' => $status,
                'errorMessage' => $errorMessage,
            ];
        }
    } else {
        return [
            'status' => 'error',
            'errorMessage' => 'Invalid JSON response'
        ];
    }
}

header('Content-Type: application/json');

if ($_SERVER['REQUEST_METHOD'] === 'GET' && isset($_GET['otp']) && isset($_GET['otpid'])) {
    $otp = $_GET['otp'];
    $otpId = $_GET['otpid'];

    // Fetch CSRF token and cookie
    $csrfAndCookie = fetchCsrfAndCookie();
    if ($csrfAndCookie) {
        $csrfToken = $csrfAndCookie['csrfToken'];
        $cookie = $csrfAndCookie['cookie'];

        $result = verifyOtp($otpId, $otp, $csrfToken, $cookie);

        echo json_encode($result);
    } else {
        echo json_encode([
            'status' => 'error',
            'errorMessage' => 'Failed to fetch CSRF token or cookies'
        ]);
    }
} else {
    echo json_encode([
        'status' => 'error',
        'errorMessage' => 'Missing OTP or otpId in request'
    ]);
}
?>
