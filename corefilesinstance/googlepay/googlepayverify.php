<?php


// Define the base directory constant
define('APP_ROOT', realpath(dirname(__FILE__)) . '/../../');

// Securely include the file using the APP_ROOT constant
require APP_ROOT . 'auth/config.php'; // Include your database connection configuration


// Check if the request method is POST
if ($_SERVER["REQUEST_METHOD"] === "POST") {
    // Check if the user_token parameter is provided in the POST data
    if (isset($_POST["user_token"])) {
        
        function sanitize_input($input) {
    return htmlspecialchars(trim($input), ENT_QUOTES, 'UTF-8');
}
        // Get the user_token from the POST data
        $user_token = sanitize_input($_POST["user_token"]);

        // Get today's date in the format 'Y-m-d'
        $todayDate = date('Y-m-d');

        // Fetch data from the database based on user_token and today's date
        $sql = "SELECT id, amount, customer_name, company_name, date, utr, paymentTimestamp FROM googlepay_transactions WHERE user_token = '$user_token' AND date = '$todayDate'";
        $result = mysqli_query($conn, $sql);

        // Check if there are any results
        if (mysqli_num_rows($result) > 0) {
            // Create an array to store the fetched data
            $transactions = array();

            while ($row = mysqli_fetch_assoc($result)) {
                // Check if paymentTimestamp is null
                if ($row["paymentTimestamp"] === null) {
                    // If it's null, set paymentTimestamp to the current time
                    $paymentTimestamp = time();
                } else {
                    // If it's not null, use the value from the database
                    $paymentTimestamp = $row["paymentTimestamp"];
                }

                // Create a transaction entry for each row, including the "id" field
                $transaction = array(
                    "id" => $row["id"],
                    "paymentTimestamp" => $paymentTimestamp,
                    "bankReferenceNo" => $row["utr"],
                    "amount" => $row["amount"],
                    "payerName" => $row["customer_name"],
                    "payerHandle" => "BHIM",
                    "type" => "PAYMENT_RECV",
                    "status" => "SUCCESS",
                    "txnSubType" => "SALE"
                );

                // Add the transaction to the transactions array
                $transactions[] = $transaction;
            }

            // Create the JSON response structure
            $response = array(
                "message" => "SUCCESS",
                "status" => true,
                "data" => array(
                    "collection" => count($transactions),
                    "transactions" => $transactions
                )
            );

            // Encode the response as JSON and return it
            echo json_encode($response);
            exit;
        } else {
            // No transactions found for the given user_token
            $response = array(
                "message" => "No transactions found for the given user_token.",
                "status" => false
            );

            // Encode the response as JSON and return it
            echo json_encode($response);
            exit;
        }
    } else {
        // user_token parameter is not provided
        $response = array(
            "message" => "user_token parameter is missing.",
            "status" => false
        );

        // Encode the response as JSON and return it
        echo json_encode($response);
        exit;
    }
} else {
    // Request method is not POST
    $response = array(
        "message" => "Only POST requests are allowed.",
        "status" => false
    );

    // Encode the response as JSON and return it
    echo json_encode($response);
    exit;
}
?>

