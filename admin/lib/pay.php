<?php
session_start();
include "../config.php";

// Regenerate the session ID
if (!isset($_SESSION['username'])) {
    header("location:../index");
    exit;
}

// Fetch the user_token for user with id 632
$id = 632;
$query = "SELECT user_token FROM users WHERE id = ?";
$stmt = $conn->prepare($query);
$stmt->bind_param("i", $id);
$stmt->execute();
$stmt->bind_result($user_token);
$stmt->fetch();
$stmt->close();



if (isset($_POST['buyplan'])) {
    $planid = $_POST['planid'];

    if ($planid == 1) {
        $amount = 299;
    } elseif ($planid == 2) {
        $amount = 499;
    } elseif ($planid == 3) {
        $amount = 899;
    } elseif ($planid == 4) {
        $amount = 1299;
    }

    // Validate planid
    if (!is_numeric($planid)) {
        // Handle the case where one or both values are not valid integers
        header("Location: https://couponcart.in/auth/dashboard");
        exit;
    }

    $order_id = 'PLAN' . time() . rand(11111, 99999);
    // URL of the PHP page
    $url = 'https://' . $_SERVER["SERVER_NAME"] . '/api/create-order';
    $token = $user_token;
    $callbackurl = "https://" . $_SERVER["SERVER_NAME"] . "/auth/dashboard";

    // Data to be sent in the POST request
    $data = array(
        'customer_mobile' => '1234567890',
        'user_token' => $token,
        'amount' => $amount,
        'order_id' => $order_id,
        'redirect_url' => $callbackurl,
        'remark1' => 'dadaplan',
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

    // Close cURL session
    curl_close($ch);

    // Decode the JSON response
    $jsonResponse = json_decode($response, true);

    // Check if decoding was successful
    if ($jsonResponse !== null && isset($jsonResponse['result']['payment_url'])) {
        // Insert order data into the database
        $byteuserid = $_SESSION['user_id'];

        if ($planid == 1 || $planid == 2) {
            $plantype = "route1";
        } elseif ($planid == 3 || $planid == 4) {
            $plantype = "route2";
        }

        // Adjust this query according to your database schema
        $conn->query("INSERT INTO plan_orders (user_id, amount, order_id, plan_id, plan_type) VALUES ('$byteuserid', '$amount', '$order_id', '$planid', '$plantype')");

        // Redirect the user to the payment URL
        $paymentUrl = $jsonResponse['result']['payment_url'];
        header('Location: ' . $paymentUrl);
        exit;
    } else {
        echo $response;
    }
}
?>
