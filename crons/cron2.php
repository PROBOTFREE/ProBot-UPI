<?php
//every 1day 0 0,12 * * *
// Define the base directory constant
define('PROJECT_ROOT', realpath(dirname(__FILE__)) . '/../');

// Securely include files using the PROJECT_ROOT constant
include PROJECT_ROOT . 'pages/dbFunctions.php';
include PROJECT_ROOT . 'auth/config.php';

date_default_timezone_set("Asia/Kolkata");

// Set maximum execution time to 5 minutes (300 seconds)
ini_set('max_execution_time', 300);




/*
///logic 1 to send notifications to memebers of route1 for plan expiry
// Fetch data from the database
$sql = "SELECT expiry, telegram_chat_id FROM users WHERE telegram_subscribed = 'on'";
$result = mysqli_query($conn, $sql);

if ($result) {
    // Check if there are any rows returned
    if (mysqli_num_rows($result) > 0) {
        // Iterate through each row
        while ($row = mysqli_fetch_assoc($result)) {
            // Check if the expiry date is less than or equal to today
            if ($row['expiry'] <= date("Y-m-d")) {
                // Send message to the user
                $chatId = $row['telegram_chat_id'];
                $message = "Hello! It seems that your subscription has expired. 🕒 Please renew your subscription to continue enjoying our services. If you have any questions or need assistance, feel free to reach out to our support team. Thank you! 🚀";
                boltx_telegram_noti_bot($message, $chatId);
               // echo "Message sent to user with chat ID: $chatId <br>";
            }
        }
    } else {
        echo "No subscribed users found.";
    }
} else {
    //echo "Error fetching data: " . mysqli_error($conn);
}


*/



////route 2 notifications if plan expire


// Fetch data from the database
$sql2 = "SELECT vip_expiry, route_2, probot_tohost_bot, id FROM users WHERE telegram_subscribed = 'on' AND route_2 = 'on'";
$result2 = mysqli_query($conn, $sql2);

if ($result2) {
    // Check if there are any rows returned
    if (mysqli_num_rows($result2) > 0) {
        // Iterate through each row
        while ($row2 = mysqli_fetch_assoc($result2)) {
            // Check if the vip_expiry date is less than or equal to today
            if ($row2['vip_expiry'] <= date("Y-m-d")) {
                $id = $row2['id']; // 
                // Update users set route_2='off' where id=fetched user id and telegram_chat_id=$chatId
                // Assuming you have a function to execute SQL queries, let's call it executeQuery()

                $updateSql = "UPDATE users SET route_2 = 'off' WHERE id = $id";
                executeQuery($updateSql); // Execute the update query

                // Send message to the user
                $chatId = $row2['probot_tohost_bot'];
                $message = "Hello! It seems that your VIP 👑 subscription has expired. 🕒 Please renew your subscription to continue enjoying our services. If you have any questions or need assistance, feel free to reach out to our support team. Thank you! 🚀";
                boltx_telegram_noti_bot($message, $chatId);
                //echo "Message sent to user with chat ID: $chatId <br>";
            }
        }
    } else {
        echo "No subscribed users found.";
    }
} else {
    //echo "Error fetching data: " . mysqli_error($conn);
}




$cxr4_current_time = date("Y-m-d H:i:s");

// Calculate time threshold (1 hour ago)
$cxr4_time_threshold = date("Y-m-d H:i:s", strtotime('-1 hour'));

// SQL query to fetch orders with create_date more than 1 hour older than current time and status is PENDING
$cxr4_sql = "SELECT order_id, user_token, create_date FROM orders WHERE create_date <= '$cxr4_time_threshold' AND status = 'PENDING'";

$cxr4_result = $conn->query($cxr4_sql);

if ($cxr4_result->num_rows > 0) {
    // Update orders status to FAILURE
    while ($cxr4_row = $cxr4_result->fetch_assoc()) {
        $cxr4_order_id = $cxr4_row["order_id"];
        $cxr4_user_token = $cxr4_row["user_token"];
        // Update status to FAILURE
        $cxr4_update_sql = "UPDATE orders SET status = 'FAILURE' WHERE order_id = '$cxr4_order_id'";
        if ($conn->query($cxr4_update_sql) === TRUE) {
            echo "Order ID: $cxr4_order_id marked as FAILURE.\n";
        } else {
            echo "Error updating record: " . $conn->error . "\n";
        }
    }
} else {
    echo "No orders found with create_date more than 1 hour older than current time.\n";
}



