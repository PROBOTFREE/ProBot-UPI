<?php
$host = "localhost";
$db   = "couponca_upload";
$user = "couponca_upload";
$pass = "couponca_upload";

$conn = new mysqli($host, $user, $pass, $db);

if ($conn->connect_error) {
    die("Connection failed: " . $conn->connect_error);
}
?>
