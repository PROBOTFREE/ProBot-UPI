<?php
include "config.php";
session_start();
// Regenerate the session ID


if (isset($_SESSION['username'])) {
    $mobile = $_SESSION['username'];
    $user = "SELECT * FROM users WHERE mobile = '$mobile'";
    $uu = mysqli_query($conn, $user);
    $userdata = mysqli_fetch_array($uu);
} else {

   header("location:index");
   exit;
}


 
// Set the default timezone to 'Asia/Kolkata' (Kolkata, India)
date_default_timezone_set('Asia/Kolkata');
$cxdate=date('Y-m-d H:i:s');
// Get the file, timestamp, and hash from the query parameters
// Retrieve and sanitize input parameters
$file = filter_var($_GET['file'], FILTER_SANITIZE_STRING);
$timestamp = filter_var($_GET['timestamp'], FILTER_SANITIZE_STRING);
$hash = filter_var($_GET['hash'], FILTER_SANITIZE_STRING);


// Validate the timestamp and hash
if (validateTimestamp($timestamp) && validateHash($file, $timestamp, $hash)) {
    $tempDirectory = 'sdk_temp_dir'; // Temporary directory where the file is stored

    // Set the path to the temporary file
    $tempFilePath = $tempDirectory . '/' . $file;

    // Check if the file exists and is readable
    if (file_exists($tempFilePath) && is_readable($tempFilePath)) {
        // Save values in the database (assuming you have set up the database connection)
        
            // Set the appropriate headers to initiate the download
            header('Content-Type: application/zip');
            header('Content-Disposition: attachment; filename="' . $file . '"');
            header('Content-Length: ' . filesize($tempFilePath));

            // Read and output the file content
            readfile($tempFilePath);

            // Delete the temporary file
            unlink($tempFilePath);

            // Exit the script
            exit;
        
    } else {
        // File not found or not readable, display an error message
        echo 'File not found.';
        // Additional error handling or redirection
        exit;
    }
} else {
    // Invalid timestamp or hash, display an error message or deny access
    echo 'Invalid download link.';
    // Additional error handling or redirection
    exit;
}

// Function to validate the timestamp
function validateTimestamp($timestamp) {
    // You can define your own validation logic here
    // For example, ensure the timestamp is not too old or in the future
    $currentTimestamp = time();
    $maxValidTimestamp = $currentTimestamp + 3600; // Allowing a 1-hour validity period
    return ($timestamp >= $currentTimestamp && $timestamp <= $maxValidTimestamp);
}

// Function to validate the hash
function validateHash($file, $timestamp, $hash) {
    $secretKey = '92e32db150c9d96f9bbcd17b4e0848f5'; // Secret key used for generating the URL
    $expectedHash = hash('sha256', $file . $timestamp . $secretKey);
    return ($hash === $expectedHash);
}