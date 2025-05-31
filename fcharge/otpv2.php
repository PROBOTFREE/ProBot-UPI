<?php
function verifyOtp($otpId, $otp, $csrfToken) {
    $url = 'https://www.freecharge.in/api/ims/rest/mobileOnly/verify';


//{"status":"success","fcWalletId":"VjAxIzNhYjBlNzBlLWZhZjQtNDQ5Ni04NTdlLTA5MTM0NTExY2QxZg","cookies":"app_fc=26154316-bcd6-4018-8922-07d9fff35348"}

//{"status":"failed","errorMessage":"We are unable to process your request. Please contact customer support"}


    $headers = [
        'authority: www.freecharge.in',
    'accept: application/json, text/plain, */*',
    'content-type: application/json',
    'AMCV_31C6097459DDBEB40A495C46%40AdobeOrg=870038026%7CMCIDTS%7C19936%7CMCMID%7C37965357631326404297873916691921632147%7CMCOPTOUT-1722441936s%7CNONE%7CvVersion%7C5.0.0; app_fc=1849e4c3-ff87-4a63-b527-683c71448c2b',
    'csrfrequestidentifier: 989d3492-9472-4767-8d54-06493629d8c5',
    'fcchannel: 12',
    'user-agent: Mozilla/5.0 (Linux; Android 10; K) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/124.0.0.0 Mobile Safari/537.36',
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
            $errorMessage = $json['error']['errorMessage'] ?? 'Unknown error';
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

    // CSRF token for this example
    $csrfToken = 'efa559dd-6451-44c9-9d77-1d5c83b9afe3';

    $result = verifyOtp($otpId, $otp, $csrfToken);

    echo json_encode($result);
} else {
    echo json_encode([
        'status' => 'error',
        'errorMessage' => 'Missing OTP or otpId in request'
    ]);
}
?>
