<?php
function sanitize_input($input) {
    return htmlspecialchars(trim($input), ENT_QUOTES, 'UTF-8');
}
// Define the base directory constant
define('APP_ROOT', realpath(dirname(__FILE__)) . '/../../');

// Securely include the file using the APP_ROOT constant
require APP_ROOT . 'auth/config.php'; // Include your database connection configuration




// Get instance_id and instance_secret from the URL parameters
$instance_id = sanitize_input($_GET['instance']);
$instance_secret = sanitize_input($_GET['secret']);



// Check if instance_id and instance_secret match a record in the users table
$query = "SELECT id, user_token FROM users WHERE instance_id = ? AND instance_secret = ?";
$stmt = $conn->prepare($query);
$stmt->bind_param("ss", $instance_id, $instance_secret);
$stmt->execute();
$result = $stmt->get_result();

if ($result->num_rows !== 1) {
    // Code to execute when the conditions are not met
    echo "failure"; // Replace with the code you want to execute
    exit;
} else {
    // Matching record found, fetch id and user_token
    $row = $result->fetch_assoc();
    $user_id = $row['id'];
    $user_token = $row['user_token'];
    
    // Now $user_id and $user_token contain the values from the matched record
    // You can use them as needed
}

if ($_SERVER['REQUEST_METHOD'] === 'POST') {
    $jsonData = file_get_contents("php://input");
    $data = json_decode($jsonData, true);
    
    // Ensure JSON data was successfully decoded
    if ($data === null) {
        
        $response = array('error' => 'Invalid JSON data.');
            echo json_encode($response);
        exit;
    }

   // Extract information from the JSON data
            $message = $data['message'];

            // Define the required keywords and pattern
            $requiredKeywords = array('INR', 'has been received from', 'by', 'on', 'at', 'IST with ID', 'Axis Bank');

            // Check if all required keywords are present in the message
            $isValidMessage = true;
            foreach ($requiredKeywords as $keyword) {
                if (strpos($message, $keyword) === false) {
                    $isValidMessage = false;
                    break;
                }
            }
    
    
    if ($isValidMessage) {
                // Extract the UTR ID
                preg_match('/with ID (\d+)/', $message, $matches);
                $utr = $matches[1];

                //dont worry conn is already defined in config.php

                // Check if UTR ID already exists in the database
                $checkSql = "SELECT COUNT(*) FROM googlepay_transactions WHERE utr = ?";
                $checkStmt = $conn->prepare($checkSql);
                $checkStmt->bind_param("s", $utr);
                $checkStmt->execute();
                $checkStmt->bind_result($count);
                $checkStmt->fetch();
                $checkStmt->close();

                if ($count == 0) {
                    // UTR ID doesn't exist, proceed with insertion
                    // Extract the amount, customer name, company name, and date as before
                    preg_match('/INR ([0-9.]+)/', $message, $matches);
                    $amount = $matches[1];

                    preg_match('/from (.*?) by/', $message, $matches);
                    $customerName = trim($matches[1]);

                    preg_match('/by (.*?) on/', $message, $matches);
                    $companyName = trim($matches[1]);

                    $date = date("Y-m-d H:i:s");

                    // Get the current timestamp using time() function
$paymentTimestamp = time();

// Insert data into googlepay_transactions table with paymentTimestamp
$insertSql = "INSERT INTO googlepay_transactions (user_token, user_id, amount, customer_name, company_name, date, utr, paymentTimestamp) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
$stmt = $conn->prepare($insertSql);
$stmt->bind_param("ssdssssd", $user_token, $user_id, $amount, $customerName, $companyName, $date, $utr, $paymentTimestamp);


        if ($stmt->execute()) {
            // Data successfully inserted
            $response = array('message' => 'Data received and saved successfully.');
            echo json_encode($response);
            exit;
        } else {
            // Error in database insertion
            $response = array('error' => 'Error in database insertion.');
            echo json_encode($response);
            exit;
        }

        $stmt->close();
                } else {
                    // Duplicate UTR ID, return an error
                    http_response_code(400); // Bad Request
                    echo json_encode(array('error' => 'Duplicate UTR ID.'));
                    exit;
                }

                $conn->close();
            } else {
                // Invalid message
                http_response_code(400); // Bad Request
                echo json_encode(array('error' => 'Invalid message.'));
                exit;
            }
    
    
} else {
    echo json_encode(array('error' => 'Invalid POST request'));
    
    exit;
}
?>
