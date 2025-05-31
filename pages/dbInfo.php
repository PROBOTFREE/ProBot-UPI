<?php
error_reporting(0);
date_default_timezone_set('Asia/Kolkata');

function connect_database() {
	$fetchType = "array";
	$dbHost    = "localhost";
	$dbLogin   = "couponca_upi";
	$dbPwd     = "couponca_upi";
	$dbName    = "couponca_upi";
	$con       = mysqli_connect($dbHost, $dbLogin, $dbPwd, $dbName);
	if (!$con) {
		die("Database Connection failes" . mysqli_connect_errno());
	}
	return ($con);
}

// Database configuration
define('DB_HOST', 'localhost');
define('DB_USERNAME', 'couponca_upi');
define('DB_PASSWORD', 'couponca_upi');
define('DB_NAME', 'couponca_upi');
?>