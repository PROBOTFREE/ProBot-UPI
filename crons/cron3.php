<?php
//every 1min

// Define the base directory constant
define('PROJECT_ROOT', realpath(dirname(__FILE__)) . '/../');

// Securely include files using the PROJECT_ROOT constant
include PROJECT_ROOT . 'pages/dbFunctions.php';
include PROJECT_ROOT . 'auth/config.php';

date_default_timezone_set("Asia/Kolkata");
// Assuming $conn is defined in the auth config




///webhook sender


// Fetching data from orders table where status is SUCCESS and webhook_sent is 'no'
$query = "SELECT user_id, order_id, remark1, remark2,amount, status,customer_mobile FROM orders WHERE status = 'SUCCESS' AND webhook_sent = 'no'";
$result = mysqli_query($conn, $query);

// Check for errors in the query execution
if (!$result) {
    echo "no pending webhook";
}

// Loop through the fetched orders
while ($row = mysqli_fetch_assoc($result)) {
    $user_id = $row['user_id']; // Get user ID
    $order_id = $row['order_id']; // Get order ID
    $remark1 = $row['remark1']; // Get remark1
    $remark2 = $row['remark2']; // Get remark2
    $status = $row['status']; // Get status
    $amount1=$row['amount']; // Get Amount
    $cxmobile=$row['customer_mobile']; //customber mobile

    // Fetching callback_url from users table based on user ID
    $query_user = "SELECT callback_url FROM users WHERE id = '$user_id'";
    $result_user = mysqli_query($conn, $query_user);

    

    // Fetch callback_url if user exists
    if (mysqli_num_rows($result_user) > 0) {
        $user_row = mysqli_fetch_assoc($result_user);
        $callback_url = $user_row['callback_url']; // Get callback_url


      
        // Data to be sent
        $postData = array(
            'status' => $status,
            'order_id' => $order_id,
            'customer_mobile' =>$cxmobile,
            'amount'=>$amount1,
            'remark1' => $remark1,
            'remark2' => $remark2
        );

        // Initialize cURL
        $ch = curl_init($callback_url);

        // Set cURL options
        curl_setopt_array($ch, [
            CURLOPT_RETURNTRANSFER => true, // This will not output the response
            CURLOPT_POST => true,
            CURLOPT_POSTFIELDS => http_build_query($postData)
        ]);

        // Execute the POST request
        $response = curl_exec($ch);

    
       

        // Update webhook_sent status to 'yes' in the orders table
        $update_query = "UPDATE orders SET webhook_sent = 'yes' WHERE order_id = '$order_id'";
        $update_result = mysqli_query($conn, $update_query);


        // Close cURL session
        curl_close($ch);
    }
}



//delete older payment link

// Current time
$cxr1current_time = date("Y-m-d H:i:s");

// Calculate time threshold (30 minutes ago)
$cxr1time_threshold = date("Y-m-d H:i:s", strtotime('-30 minutes'));

// SQL query to delete rows with created_at more than 30 minutes older than current time
$cxr1sql = "DELETE FROM payment_links WHERE created_at <= '$cxr1time_threshold'";

if ($conn->query($cxr1sql) === TRUE) {
    $deleted_rows = $conn->affected_rows;
    echo "$deleted_rows rows deleted successfully from payment_links.\n";
} else {
   // echo "Error deleting rows: " . $conn->error . "\n";
}


//delete older short link

// Current time
$cxr2current_time = date("Y-m-d H:i:s");

// Calculate time threshold (30 minutes ago)
$cxr2time_threshold = date("Y-m-d H:i:s", strtotime('-30 minutes'));

// SQL query to delete rows with created_at more than 30 minutes older than current time
// and link_type is 'paylink'
$cxr2sql = "DELETE FROM short_urls WHERE created_at <= '$cxr2time_threshold' AND link_type = 'paylink'";

if ($conn->query($cxr2sql) === TRUE) {
    $deleted_rows = $conn->affected_rows;
    echo "$deleted_rows rows deleted successfully from short_urls.\n";
} else {
    echo "Error deleting rows: " . $conn->error . "\n";
}



//update plan for user

$sql = "SELECT order_id, amount, plan_id, user_id FROM plan_orders WHERE status = 'pending'";
$cxr_result = $conn->query($sql);

if ($cxr_result->num_rows > 0) {
    // Loop through each pending order
    while ($cxr_row = $cxr_result->fetch_assoc()) {
        $cxr_order_id = $cxr_row["order_id"];
        $cxr_amount = $cxr_row["amount"];
        $cxr_plan_id = $cxr_row["plan_id"];
        $cxr_user_id = $cxr_row["user_id"];

        // Fetch the status of the order from the 'orders' table
        $cxr_order_status_sql = "SELECT status FROM orders WHERE order_id = '$cxr_order_id'";
        $cxr_order_status_result = mysqli_query($conn, $cxr_order_status_sql);

        if ($cxr_order_status_result) {
            $cxr_order_status_row = mysqli_fetch_assoc($cxr_order_status_result);
            $cxr_rowstatusoforders = $cxr_order_status_row['status'];

            // Check if transaction is successful
            if ($cxr_rowstatusoforders == 'SUCCESS') {
                // Update order status in the database
                $cxr_update_sql = "UPDATE plan_orders SET status = 'success' WHERE order_id = '$cxr_order_id'";
                mysqli_query($conn, $cxr_update_sql);

                // Determine months to add based on plan_id
                if ($cxr_plan_id == 1) {
                    $cxr_monthsToAdd = 1; // 1 month add
                } elseif ($cxr_plan_id == 2) {
                    $cxr_monthsToAdd = 3; // 3 months add
                } elseif ($cxr_plan_id == 3) {
                    $cxr_monthsToAdd = 1; // 1 month add
                } elseif ($cxr_plan_id == 4) {
                    $cxr_monthsToAdd = 12; // 12 months add
                }

                // Update user's expiry or vip_expiry based on plan_id
                if ($cxr_plan_id == 1 || $cxr_plan_id == 2) {
                    $cxr_sql = "UPDATE users SET expiry = DATE_ADD(expiry, INTERVAL $cxr_monthsToAdd MONTH) WHERE id = '$cxr_user_id'";
                    $cxr_rrrr = mysqli_query($conn, $cxr_sql);
                } elseif ($cxr_plan_id == 3 || $cxr_plan_id == 4) {
                    $cxr_sql2 = "UPDATE users SET vip_expiry = DATE_ADD(vip_expiry, INTERVAL $cxr_monthsToAdd MONTH) WHERE id = '$cxr_user_id'";
                    $cxr_rrrr2 = mysqli_query($conn, $cxr_sql2);
                    $cxr_sql11 = "UPDATE users SET expiry = DATE_ADD(expiry, INTERVAL $cxr_monthsToAdd MONTH) WHERE id = '$cxr_user_id'";
                    $cxr_rrrr11111 = mysqli_query($conn, $cxr_sql11);

                    // Also update route_2 to 'on'
                    $cxr_sql3 = "UPDATE users SET route_2 = 'on' WHERE id = '$cxr_user_id'";
                    $cxr_rrrr3 = mysqli_query($conn, $cxr_sql3);
                }
            } elseif ($cxr_rowstatusoforders == 'FAILURE') {
                // Update order status to cancel in the database
                $cxr_update_sql = "UPDATE plan_orders SET status = 'cancel' WHERE order_id = '$cxr_order_id'";
                mysqli_query($conn, $cxr_update_sql);
            } else {
                // Transaction is still pending
                echo "Transaction for order $cxr_order_id is still pending.";
            }
        } else {
            // Handle error fetching order status
            echo "Error fetching order status for order $cxr_order_id.";
        }
    }
} else {
    echo "No pending orders found.";
}

//update plan for user



//send plan notification to user

// SQL query to select columns from the plan_orders table where notifi_send is 'no' and status is 'success'
$cxr2_query = "SELECT order_id, amount, plan_type, user_id FROM plan_orders WHERE notifi_send = 'no' AND status = 'success'";

// Execute the query
$cxr2_result = mysqli_query($conn, $cxr2_query);

// Check if there are any results
if (mysqli_num_rows($cxr2_result) > 0) {
    // Fetch and store data into variables
    while ($cxr2_row = mysqli_fetch_assoc($cxr2_result)) {
        $cxr2_order_id = $cxr2_row["order_id"];
        $cxr2_amount = $cxr2_row["amount"];
        $cxr2_plan_type = $cxr2_row["plan_type"];
        $cxr2_user_id = $cxr2_row["user_id"];
 
        // SQL query to fetch telegram_chat_id, expiry, and vip_expiry from users table based on user_id 
        $cxr2_user_query = "SELECT probot_tohost_bot, expiry, vip_expiry FROM users WHERE id = $cxr2_user_id AND telegram_subscribed = 'on'";
        $cxr2_user_result = mysqli_query($conn, $cxr2_user_query);

        // Check if there are any results
        if (mysqli_num_rows($cxr2_user_result) > 0) {
            // Fetch the telegram_chat_id, expiry, and vip_expiry
            $cxr2_user_row = mysqli_fetch_assoc($cxr2_user_result);
            $cxr2_telegram_chat_id = $cxr2_user_row["probot_tohost_bot"];
            $cxr2_expiry = $cxr2_user_row["expiry"];
            $cxr2_vip_expiry = $cxr2_user_row["vip_expiry"];
            
            if ($cxr2_plan_type == "route1") {
                $cxr2_datetosend = $cxr2_expiry;
                $cxr2_additional_message = "";
            } elseif ($cxr2_plan_type == "route2") {
                $cxr2_datetosend = $cxr2_vip_expiry;
                $cxr2_additional_message = "\n\n✨ As a VIP member, you now have exclusive access to premium features!";
            }

            // Prepare message
            $cxr2_responseMessage = "Hello! 😊\n\n";
            $cxr2_responseMessage .= "We are thrilled to inform you that your plan has been activated successfully! 🎉\n\n";
            $cxr2_responseMessage .= "Here are your plan details:\n";
            $cxr2_responseMessage .= "💵 Amount: ₹$cxr2_amount\n";
            $cxr2_responseMessage .= "📅 Plan Expiry Date: $cxr2_datetosend\n";
            $cxr2_responseMessage .= "$cxr2_additional_message\n\n";
            $cxr2_responseMessage .= "Thank you for choosing us! If you have any questions, feel free to reach out.\n\n";

            // Send notification to Telegram bot function
            boltx_telegram_noti_bot($cxr2_responseMessage, $cxr2_telegram_chat_id);

            // Output success message
          //  echo "Notification sent successfully to Telegram chat ID: $cxr2_telegram_chat_id<br>";

            // Update notifi_send to 'yes' for the current order_id
            $cxr2_update_query = "UPDATE plan_orders SET notifi_send = 'yes' WHERE order_id = '$cxr2_order_id'";
            $cxr2_update_result = mysqli_query($conn, $cxr2_update_query);

            if ($cxr2_update_result) {
                echo "notifi_send updated to 'yes' for order ID: $cxr2_order_id<br>";
            }
        } else {
            echo "No telegram_chat_id found for user with ID: $cxr2_user_id<br>";
        }
    }
} else {
   // echo "No results found";
}


//every1 minute




////////////////// orders notification send to user on telegram

// SQL query to select columns from the orders table where notifi_send is 'no' and status is 'SUCCESS'
$query = "SELECT order_id, amount, byteTransactionId, method, create_date, user_id FROM orders WHERE notifi_send = 'no' AND status = 'SUCCESS'";

// Execute the query
$result = mysqli_query($conn, $query);

// Check if there are any results
if (mysqli_num_rows($result) > 0) {
    // Fetch and store data into variables
    while ($row = mysqli_fetch_assoc($result)) {
        $order_id = $row["order_id"];
        $amount = $row["amount"];
        $byteTransactionId = $row["byteTransactionId"];
        $create_date = $row["create_date"];
        $user_id = $row["user_id"];
        $merchantmethod = $row['method'];

        // SQL query to fetch telegram_chat_id from users table based on user_id 
        $user_query = "SELECT telegram_chat_id FROM users WHERE id = $user_id AND telegram_subscribed = 'on'";
        $user_result = mysqli_query($conn, $user_query);

        // Check if there are any results
        if (mysqli_num_rows($user_result) > 0) {
            // Fetch the telegram_chat_id
            $user_row = mysqli_fetch_assoc($user_result);
            $telegram_chat_id = $user_row["probot_tohost_bot"];

            // Prepare message
            $responseMessage = "Hello😊,\n"; // Greet the user with their name
            $responseMessage .= "🎉 Your transaction has been completed successfully! 🎉\n\n";
            $responseMessage .= "📦 Order ID: $order_id\n";
            $responseMessage .= "💵 Amount: ₹$amount\n";
            $responseMessage .= "🔖 Transaction ID: $byteTransactionId\n";
            $responseMessage .= "🏦 Merchant: $merchantmethod\n";
            $responseMessage .= "📅 Create Date: $create_date";

            // Send notification to Telegram bot function
            boltx_telegram_noti_bot($responseMessage, $telegram_chat_id);

            // Output success message
          //  echo "Notification sent successfully to Telegram chat ID: $telegram_chat_id<br>";

            // Update notifi_send to 'yes' for the current order_id
            $update_query = "UPDATE orders SET notifi_send = 'yes' WHERE order_id = '$order_id'";
            $update_result = mysqli_query($conn, $update_query);

            if ($update_result) {
               // echo "notifi_send updated to 'yes' for order ID: $order_id<br>";
            }
        } else {
            //echo "No telegram_chat_id found for user with ID: $user_id<br>";
        }
    }
} else {
   // echo "No results found";
} 
//order send logic end



////////////////// Bank Payout notification send to user on telegram

// SQL query to select columns from the withdrawals table where notifi_send is 'no' and status is 'completed'
$query = "SELECT withdraw_id, amount, bank_account_number, ifsc_code, created_at, user_id FROM withdrawals WHERE notifi_send = 'no' AND status = 'completed'";

// Execute the query
$result = mysqli_query($conn, $query);

// Check if there are any results
if (mysqli_num_rows($result) > 0) {
    // Fetch and store data into variables
    while ($row = mysqli_fetch_assoc($result)) {
        $withdraw_id = $row["withdraw_id"];
        $amount = $row["amount"];
        $bank_account_number = $row["bank_account_number"];
        $created_at = $row["created_at"];
        $user_id = $row["user_id"];
        $ifsc_code = $row['ifsc_code'];

        // SQL query to fetch telegram_chat_id from users table based on user_id
        $user_query = "SELECT probot_tohost_bot FROM users WHERE id = $user_id AND telegram_subscribed = 'on'";
        $user_result = mysqli_query($conn, $user_query);

        // Check if there are any results
        if (mysqli_num_rows($user_result) > 0) {
            // Fetch the telegram_chat_id
            $user_row = mysqli_fetch_assoc($user_result);
            $telegram_chat_id = $user_row["probot_tohost_bot"];

            // Prepare message
            $responseMessage = "Hello 😊,\n\n";
            $responseMessage .= "🎉 Congratulations! Your Payout has been successfully processed. 🎉\n\n";
            $responseMessage .= "Here are the details:\n";
            $responseMessage .= "📦 Withdrawal ID: $withdraw_id\n";
            $responseMessage .= "💵 Amount: ₹$amount\n";
            $responseMessage .= "🏦 Bank Account Number: $bank_account_number\n";
            $responseMessage .= "🔑 IFSC Code: $ifsc_code\n";
            $responseMessage .= "📅 Date of Payout: $created_at\n\n";
            $responseMessage .= "If you have any questions or concerns, feel free to reach out to our support team. Thank you for choosing us!\n\n";

            // Send notification to Telegram bot function
            boltx_telegram_noti_bot($responseMessage, $telegram_chat_id);


            // Update notifi_send to 'yes' for the current withdraw_id
            $update_query = "UPDATE withdrawals SET notifi_send = 'yes' WHERE withdraw_id = '$withdraw_id'"; // Fix here
            $update_result = mysqli_query($conn, $update_query);

            if ($update_result) {
              //  echo "notifi_send updated to 'yes' for withdraw ID: $withdraw_id<br>";
            }
        } else {
         //   echo "No telegram_chat_id found for user with ID: $user_id<br>";
        }
    }
} else {
   // echo "No results found";
} ///////////payout notify send






////////////////// UPI Payout notification send to user on telegram

// SQL query to select columns from the withdrawals_upi table where notifi_send is 'no' and status is 'completed'
$cxcr_1query = "SELECT withdraw_id, amount, upi_id, created_at, user_id FROM withdrawals_upi WHERE notifi_send = 'no' AND status = 'completed'";

// Execute the query
$cxcr_1result = mysqli_query($conn, $cxcr_1query);

// Check if there are any results
if (mysqli_num_rows($cxcr_1result) > 0) {
    // Fetch and store data into variables
    while ($cxcr_1row = mysqli_fetch_assoc($cxcr_1result)) {
        $cxcr_1withdraw_id = $cxcr_1row["withdraw_id"];
        $cxcr_1amount = $cxcr_1row["amount"];
        $cxcr_1upi_id = $cxcr_1row["upi_id"];
        $cxcr_1created_at = $cxcr_1row["created_at"];
        $cxcr_1user_id = $cxcr_1row["user_id"];

        // SQL query to fetch telegram_chat_id from users table based on user_id
        $cxcr_1user_query = "SELECT probot_tohost_bot FROM users WHERE id = $cxcr_1user_id AND telegram_subscribed = 'on'";
        $cxcr_1user_result = mysqli_query($conn, $cxcr_1user_query);

        // Check if there are any results
        if (mysqli_num_rows($cxcr_1user_result) > 0) {
            // Fetch the telegram_chat_id
            $cxcr_1user_row = mysqli_fetch_assoc($cxcr_1user_result);
            $cxcr_1telegram_chat_id = $cxcr_1user_row["probot_tohost_bot"];

            // Prepare message
            $cxcr_1responseMessage = "Hello 😊,\n\n";
            $cxcr_1responseMessage .= "🎉 Congratulations! Your Payout has been successfully processed. 🎉\n\n";
            $cxcr_1responseMessage .= "Here are the details:\n";
            $cxcr_1responseMessage .= "📦 Withdrawal ID: $cxcr_1withdraw_id\n";
            $cxcr_1responseMessage .= "💵 Amount: ₹$cxcr_1amount\n";
            $cxcr_1responseMessage .= "🏦 UPI ID: $cxcr_1upi_id\n";
            $cxcr_1responseMessage .= "📅 Date of Payout: $cxcr_1created_at\n\n";
            $cxcr_1responseMessage .= "If you have any questions or concerns, feel free to reach out to our support team. Thank you for choosing us!\n\n";

            // Send notification to Telegram bot function
            boltx_telegram_noti_bot($cxcr_1responseMessage, $cxcr_1telegram_chat_id);

            // Update notifi_send to 'yes' for the current withdraw_id
            $cxcr_1update_query = "UPDATE withdrawals_upi SET notifi_send = 'yes' WHERE withdraw_id = '$cxcr_1withdraw_id'";
            $cxcr_1update_result = mysqli_query($conn, $cxcr_1update_query);

            if ($cxcr_1update_result) {
              //  echo "notifi_send updated to 'yes' for withdraw ID: $cxcr_1withdraw_id<br>";
            }
        } else {
            //echo "No telegram_chat_id found for user with ID: $cxcr_1user_id<br>";
        }
    }
} else {
   // echo "No results found";
}

