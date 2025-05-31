<?php
include "config.php";
session_start();
session_destroy();
session_unset();

// Redirect without showing any message
header("Location: index"); // Replace "index" with your desired landing page
exit();
?>
