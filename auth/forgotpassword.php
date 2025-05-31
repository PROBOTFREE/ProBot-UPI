<?php
// Define the forget password link
$forgetpasslink = "https://t.me/probot_tohost_bot?genpass";

// Redirect the user to the forget password link
header("Location: $forgetpasslink");
exit; // Ensure script execution stops after the redirection
?>
