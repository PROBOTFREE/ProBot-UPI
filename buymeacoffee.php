<?php

include "auth/config.php";

error_reporting(E_ALL);
ini_set('display_errors', 1);

// Fetch the user_token for user with id 632
$id = 642;
$query = "SELECT user_token FROM users WHERE id = ?";
$stmt = $conn->prepare($query);
$stmt->bind_param("i", $id);
$stmt->execute();
$stmt->bind_result($user_token);
$stmt->fetch();
$stmt->close();

// Debugging: Check if user_token is fetched
echo "User Token: " . $user_token . PHP_EOL;

// Generate a secure token
$secureToken = bin2hex(random_bytes(16)); // Generates a unique 32-character token
$order_id = '123456' . time(); // Generate order_id once and use it everywhere




// URL of the PHP page
$url = 'https://couponcart.in/api/create-order';

// Data to be sent in the POST request
$data = array(
    'customer_mobile' => '1234567890',
    'user_token' => $user_token,
    'amount' => 1,
    'order_id' => $order_id,
    'secure_token'=> $secureToken,
    'redirect_url' => 'https://couponcart.in/status/success.php?token=' . $secureToken,
    'remark1' => 'test1',
    'remark2' => 'test2',
    'route' => 1,
);

// Initialize cURL session
$ch = curl_init();

// Set cURL options
curl_setopt($ch, CURLOPT_URL, $url);
curl_setopt($ch, CURLOPT_POST, 1);
curl_setopt($ch, CURLOPT_POSTFIELDS, http_build_query($data));
curl_setopt($ch, CURLOPT_RETURNTRANSFER, true);

// Execute cURL session and store the response
$response = curl_exec($ch);

// Debugging: Output cURL response
var_dump($response);

// Check for cURL errors
if (curl_errno($ch)) {
    echo 'cURL Error: ' . curl_error($ch);
    curl_close($ch);
    exit;
}

curl_close($ch);

// Decode the JSON response
$jsonResponse = json_decode($response, true);

// Debugging: Output decoded JSON
print_r($jsonResponse);

// Check if decoding was successful
if ($jsonResponse !== null) {
    if (isset($jsonResponse['result']['payment_url'])) {
        // Redirect the user to the payment URL
        $paymentUrl = $jsonResponse['result']['payment_url'];
        header('Location: ' . $paymentUrl);
        exit;
    } else {
        echo "Payment URL not found in the response";
    }
} else {
    echo "Failed to decode JSON response: " . $response;
    exit;
}
?>
