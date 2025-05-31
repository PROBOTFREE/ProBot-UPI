<?php
function generate_key($customer_id, $email, $secret = "mySuperSecret") {
    $data = $customer_id . "|" . $email . "|" . $secret;
    return base64_encode($data);
}

// Example
echo generate_key("1", "customer@example.com");
?>
