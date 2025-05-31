<?php

include "../config.php";
session_start();
// Regenerate the session ID

if (!isset($_SESSION['username'])) {
    header("location:../index");
    exit;
}

if (isset($_POST['theme'])) {
    $_SESSION['theme'] = $_POST['theme'];
    
    // Log the theme change to a text file
    $logFile = 'theme_change_log.txt';
    $currentDateTime = date('Y-m-d H:i:s');
    $logMessage = $currentDateTime . " - Theme changed to: " . $_POST['theme'] . "\n";
    
    file_put_contents($logFile, $logMessage, FILE_APPEND);

    echo 'Theme updated';
} else {
    echo 'No theme provided';
}
?>
