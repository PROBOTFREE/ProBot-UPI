<?php
// Define the base directory constant
define('PROJECT_PATH', realpath(dirname(__FILE__)) . '/../../');

// Securely include files using the PROJECT_PATH constant
require_once PROJECT_PATH . 'pages/dbInfo.php'; // Update the path as needed
require_once PROJECT_PATH . 'pages/dbFunctions.php'; // Update the path as needed

try {
    // Create a PDO database connection using the defined constants
    $pdo = new PDO("mysql:host=" . DB_HOST . ";dbname=" . DB_NAME, DB_USERNAME, DB_PASSWORD);

    // Set PDO error mode to exception
    $pdo->setAttribute(PDO::ATTR_ERRMODE, PDO::ERRMODE_EXCEPTION);

    // Set character encoding to utf8mb4
    $pdo->exec("set names utf8mb4");

} catch(PDOException $e) {
    // Handle database connection errors
    //die("Database connection failed: " . $e->getMessage());
}

$content = file_get_contents("php://input");
$update = json_decode($content, true);



// Check if the update is related to a chat member change
if (isset($update["my_chat_member"]) && $update["my_chat_member"]["new_chat_member"]["status"] === "kicked") {
    $chatId = $update["my_chat_member"]["chat"]["id"];

    // Fetch the user's ID first
    $stmt = $pdo->prepare("SELECT id FROM users WHERE telegram_chat_id = :chatId");
    $stmt->bindParam(':chatId', $chatId);
    $stmt->execute();
    $user = $stmt->fetch(PDO::FETCH_ASSOC);

    if ($user) {
        // Update the database to mark the user as unsubscribed and set chat_id to NULL
        $stmt = $pdo->prepare("UPDATE users SET telegram_subscribed = 'off', telegram_chat_id = NULL, telegram_username = NULL WHERE id = :userId");
        $stmt->bindParam(':userId', $user['id']);
        $stmt->execute();
    } else {
        // Log an error or handle the case where the user is not found
    }
}



if (isset($update["message"])) {
    //safe zone to define and get data from telegram
    $message = $update["message"];
    $chatId = $message["chat"]["id"];
    $username = isset($message["from"]["username"]) ? $message["from"]["username"] : null;    
    $firstName=$message["from"]["first_name"];
    $lastName=$message["from"]["last_name"];
    $cxrmessageid=$message["message_id"];
    
    
    if (isset($message["text"]) && strpos($message["text"], "/start") === 0) {
        // Extract the start parameter (if any)
        $textParts = explode(' ', $message["text"]);
        $startParam = count($textParts) > 1 ? $textParts[1] : null;

        // Create the response message for /start command
      //  $responseMessage = "Bot started with start parameter: $startParam, by user with chat ID: $chatId";
        
        
    try {
            $pdo->beginTransaction();

            $stmt = $pdo->prepare("SELECT id FROM users WHERE merchant_id = :merchant_id AND telegram_subscribed = 'off'");
            $stmt->bindParam(':merchant_id', $startParam);
            $stmt->execute();

            if ($stmt->rowCount() > 0) {
                $user = $stmt->fetch(PDO::FETCH_ASSOC);

                $updateStmt = $pdo->prepare("UPDATE users SET telegram_subscribed = 'on', telegram_chat_id = :chatId, telegram_username = :username WHERE id = :userId AND merchant_id = :merchantId");
                $updateStmt->bindParam(':chatId', $chatId);
                $updateStmt->bindParam(':username', $username);
                $updateStmt->bindParam(':userId', $user['id']);
                $updateStmt->bindParam(':merchantId', $startParam);
                $updateStmt->execute();

                $pdo->commit();
                
                // Call the boltx_telegram_noti_bot function with the updated message and chat ID
            $message = "🎉 Hello, " . $firstName . " " . $lastName . "! You are successfully subscribed to Telegram notifications! 📢";
               boltx_telegram_noti_bot($message,$chatId);
               exit;
                
            } else {
                // No matching user found
                exit;
            }

        } catch (PDOException $e) {
            $pdo->rollBack();
            die("Database error: " . $e->getMessage());
    }

    
    } //> close condition for start
    
    //total payment parameter start
    elseif (isset($message["text"]) && strpos($message["text"], "/totalpayment") === 0) {
        // Handle /totalpayment command
        try {
            // Search for user in the users table
            $stmt = $pdo->prepare("SELECT id FROM users WHERE telegram_chat_id = :chatId AND telegram_subscribed = 'on'");
            $stmt->bindParam(':chatId', $chatId);
            $stmt->execute();

            if ($stmt->rowCount() > 0) {
                $user = $stmt->fetch(PDO::FETCH_ASSOC);

                // Calculate total payment for the current day
                // Calculate total payment for the current day with status 'SUCCESS'
                // Calculate total payment for the current day with status 'SUCCESS'
                  $today = date('Y-m-d');
                  $totalStmt = $pdo->prepare("SELECT COUNT(*) AS num_rows, SUM(amount) AS total_amount FROM orders WHERE user_id = :userId AND DATE(create_date) = :today AND status = 'SUCCESS'");
                  $totalStmt->bindParam(':userId', $user['id']);
                  $totalStmt->bindParam(':today', $today);
                  $totalStmt->execute();

                  $totalResult = $totalStmt->fetch(PDO::FETCH_ASSOC);
                  $numRows = $totalResult['num_rows'] ?? 0;
                  $totalAmount = $totalResult['total_amount'] ?? 0;
                  // Prepare and send the response message
                  $responseMessage = "Hello😊,\n"; // Greet the user with their name
                  $responseMessage .= "$firstName $lastName\n\n"; // Greet the user with their name
                  $responseMessage .= "🌟 Today Payment Summary 🌟\n";
                  $responseMessage .= "📊 Total Orders: $numRows\n";
                  $responseMessage .= "💰 Total Payment: ₹$totalAmount\n";
                  $responseMessage .= "🎉 Thank you for choosing us!\n";

                  // Call the boltx_telegram_noti_bot function with the updated message and chat ID
                  boltx_telegram_noti_bot($responseMessage, $chatId);
                  exit;     
                
                // Code to send response back to user via Telegram API
            } else {
                // Handle the case where no matching user is found
                $responseMessage = "User not found or not subscribed.";
                exit;
                // Code to send response back to user via Telegram API
            }
        } catch (PDOException $e) {
            die("Database error: " . $e->getMessage());
        }
    } //> close bracket for conditions elseif for the start paramter /totalpayment


// Handle /genapi command
elseif (isset($message["text"]) && strpos($message["text"], "/genapi") === 0) {
    try {
        // Search for user in the users table with valid conditions
        $stmt = $pdo->prepare("SELECT id, merchant_id FROM users WHERE telegram_chat_id = :chatId AND telegram_subscribed = 'on'");
        $stmt->bindParam(':chatId', $chatId);
        $stmt->execute();

        if ($stmt->rowCount() > 0) {
            $user = $stmt->fetch(PDO::FETCH_ASSOC);
            $merchantId = $user['merchant_id'];

            $uniqueNumber = mt_rand(1000000000, 9999999999);
            $uniqueNumber = str_pad($uniqueNumber, 10, '0', STR_PAD_LEFT);

            // Generate a new API key
            $newApiKey = md5($uniqueNumber);

            // Update the user's API key in the database
            $updateStmt = $pdo->prepare("UPDATE users SET user_token = :newApiKey WHERE id = :userId AND merchant_id = :merchantId");
            $updateStmt->bindParam(':newApiKey', $newApiKey);
            $updateStmt->bindParam(':userId', $user['id']);
            $updateStmt->bindParam(':merchantId', $merchantId);
            $updateStmt->execute();

            // Update user_token in other tables
            $bbbyteuserid = $user['id'];
            $key = $newApiKey;

            // Define queries to update user_token in various tables
            $queries = [
                "UPDATE orders SET user_token = :key WHERE user_id = :userId",
                "UPDATE reports SET user_token = :key WHERE user_id = :userId",
                "UPDATE hdfc SET user_token = :key WHERE user_id = :userId",
                "UPDATE bharatpe_tokens SET user_token = :key WHERE user_id = :userId",
                "UPDATE phonepe_tokens SET user_token = :key WHERE user_id = :userId",
                "UPDATE store_id SET user_token = :key WHERE user_id = :userId",
                "UPDATE paytm_tokens SET user_token = :key WHERE user_id = :userId",
                "UPDATE googlepay_transactions SET user_token = :key WHERE user_id = :userId",
                "UPDATE googlepay_tokens SET user_token = :key WHERE user_id = :userId"
            ];

            foreach ($queries as $query) {
                $updateStmt = $pdo->prepare($query);
                $updateStmt->bindParam(':key', $key);
                $updateStmt->bindParam(':userId', $bbbyteuserid);
                $updateStmt->execute();
            }

            // Prepare and send the response message
            $responseMessage = "Hello😊,\n";
            $responseMessage .= "$firstName $lastName\n\n";
            $responseMessage .= "✅ New API Key generated successfully: $newApiKey\n";
            $responseMessage .= "👍 You can now use this API Key to securely process payments through our payment gateway.\n";
            $responseMessage .= "💳 To make a payment, simply include this API Key in your payment request.\n";
            $responseMessage .= "🔒 Your transactions are now protected with this unique key!\n";

            // Call the boltx_telegram_noti_bot function with the updated message and chat ID
            boltx_telegram_noti_bot($responseMessage, $chatId);
            exit;
        } else {
            // Handle the case where no matching user is found
            $responseMessage = "User not found or not subscribed.";
            exit;
        }
    } catch (PDOException $e) {
        die("Database error: " . $e->getMessage());
    }
}//> close condition for /genapi

 // Handle /paymentstatus command
elseif (isset($message["text"]) && strpos($message["text"], "/paymentstatus") === 0) {
    // Check if the user has provided a transaction ID
    $textParts = explode(' ', $message["text"]);
    if (count($textParts) < 2) {
        // User didn't provide a transaction ID, so guide them on how to do it
        $responseMessage = "To check the payment status, please enter the command as follows:\n/paymentstatus [transaction_id]";
        boltx_telegram_noti_bot($responseMessage, $chatId);
        exit;
    } else {
        // User provided a transaction ID, proceed with status check
        $transactionId = trim($textParts[1]);
        try {
            // Search for user in the users table with valid conditions that he subsribed on and have valid telegram_chat_id
            $stmt = $pdo->prepare("SELECT id, merchant_id FROM users WHERE telegram_chat_id = :chatId AND telegram_subscribed = 'on'");
            $stmt->bindParam(':chatId', $chatId);
            $stmt->execute();

            if ($stmt->rowCount() > 0) {
                $user = $stmt->fetch(PDO::FETCH_ASSOC);
                $merchantId = $user['merchant_id'];
                $userId = $user['id']; // Get the user's id

                // Search for the transaction in the 'orders' table for the specific user
                $stmt = $pdo->prepare("SELECT * FROM orders WHERE order_id = :transactionId AND user_id = :userId");
                $stmt->bindParam(':transactionId', $transactionId);
                $stmt->bindParam(':userId', $userId); // Bind the user's id
                $stmt->execute();

                if ($stmt->rowCount() > 0) {
                    $order = $stmt->fetch(PDO::FETCH_ASSOC);
                    // Prepare and send the response message with the transaction status and details
                    $responseMessage = "Hello😊,\n"; // Greet the user with their name
                    $responseMessage .= "$firstName $lastName\n\n"; // Greet the user with their name
                    $responseMessage .= "📊 Payment Status Details 📊\n\n";
                    $responseMessage .= "🔖 Status: {$order['status']}\n";
                    $responseMessage .= "🆔 Order ID: {$order['order_id']}\n";
                    $responseMessage .= "💰 Amount: ₹{$order['amount']}\n";
                    $responseMessage .= "📅 Date: {$order['create_date']}\n";
                    $responseMessage .= "🏦 Merchant: {$order['method']}\n";
                    $responseMessage .= "📱 Customer Mobile: {$order['customer_mobile']}\n";
                    // Check if UTR is null or not and display accordingly
                    if ($order['utr'] !== null && $order['utr'] !== '') {
                        // UTR is not null and not empty
                        $responseMessage .= "🔍 UTR: {$order['utr']}\n";
                    } else {
                        // UTR is either null or empty
                        $responseMessage .= "🔍 UTR: Not Available\n";
                    }
                    $responseMessage .= "📝 Remark 1: {$order['remark1']}\n";
                    $responseMessage .= "📝 Remark 2: {$order['remark2']}\n";
                    $responseMessage .= "🔐 Transaction ID: {$order['byteTransactionId']}\n";
                    // Send the response message back to the user via Telegram API
                    boltx_telegram_noti_bot($responseMessage, $chatId);
                    exit;

                } else {
                    // Handle the case where no matching transaction is found
                    $responseMessage = "Transaction ID not found.";
                    // Send the response message back to the user via Telegram API
                    boltx_telegram_noti_bot($responseMessage, $chatId);
                    exit;
                }
            } else {
                // Handle the case where no matching user is found
                $responseMessage = "User not found or not subscribed.";
                exit;
            }
        } catch (PDOException $e) {
            // Handle database error
          //  $responseMessage = "Database error: " . $e->getMessage();
        }
    }

} //> close condition for /paymentstatus

// Handle /paylink command
elseif (isset($message["text"]) && strpos($message["text"], "/paylink") === 0) {
    // Check if the user has provided an amount
    $textParts = explode(' ', $message["text"]);
    if (count($textParts) < 2) {
        // User didn't provide an amount, so guide them on how to do it
        $responseMessage = "To generate a payment link, please enter the command as follows:\n/paylink [amount]";
        boltx_telegram_noti_bot($responseMessage, $chatId);
        exit;
    } else {
        // User provided an amount, proceed with payment link generation
        $amount = trim($textParts[1]);

        // Search for user in the users table with valid conditions
        $stmt = $pdo->prepare("SELECT id, user_token,route_2,vip_expiry, merchant_id FROM users WHERE telegram_chat_id = :chatId AND telegram_subscribed = 'on'");
        $stmt->bindParam(':chatId', $chatId);
        $stmt->execute();

        if ($stmt->rowCount() > 0) {
            $user = $stmt->fetch(PDO::FETCH_ASSOC);
            $merchantId = $user['merchant_id'];
            $userId = $user['id'];
            $cxrpaylinkuser_token = $user['user_token'];
            $userroute=$user['route_2'];
            $cxrvipexpiry=$user['vip_expiry'];
            $today = date("Y-m-d");
            if ($userroute == 'on' && $cxrvipexpiry >= $today) {
            $routetouse = 2;
            }
            else{
                $routetouse=1;
            }

            // Generate a payment link logic goes here
            // You can generate the payment link and store it if needed

            // URL of the PHP page
            $url = 'https://couponcart.in/api/create-order';
            $tmeorderid="tme" . uniqid() . uniqid() . time() . mt_rand();

            // Data to be sent in the POST request
            $data = array(
                'customer_mobile' => '1234567890',
                'user_token' => $cxrpaylinkuser_token,
                'amount' => $amount,
                'order_id' => $tmeorderid,
                'redirect_url' => 'https://couponcart.in/success',
                'remark1' => 'telegramlink',
                'remark2' => 'test2',
                'route' =>$routetouse,
            );

            // Initialize cURL session
            $ch = curl_init();

            // Set cURL options
            curl_setopt($ch, CURLOPT_URL, $url);
            curl_setopt($ch, CURLOPT_POST, 1);
            curl_setopt($ch, CURLOPT_POSTFIELDS, http_build_query($data));
            curl_setopt($ch, CURLOPT_RETURNTRANSFER, true);

            // Execute cURL session and store the response
            $response = curl_exec($ch);

            // Close cURL session
            curl_close($ch);

            // Decode the JSON response
            $jsonResponse = json_decode($response, true);

            // Check if decoding was successful and if payment_url is set
            if (isset($jsonResponse['status']) && $jsonResponse['status'] === true && isset($jsonResponse['result']['payment_url'])) {
                // Payment URL is available
                $paymentUrl = $jsonResponse['result']['payment_url'];
                
                
                $shortUrl = generateShortUrl(); // Assuming this function generates a short URL
                $createdAt = date("Y-m-d H:i:s");
                
                // Prepare the SQL statement with parameter placeholders
               // Prepare the SQL statement with parameter placeholders
               $sql = "INSERT INTO short_urls (short_url, long_url, created_at, link_type) VALUES (?, ?, ?, 'paylink')";


                // Prepare the statement
                $stmt = $pdo->prepare($sql);

                // Bind parameters
                $stmt->bindParam(1, $shortUrl);
                $stmt->bindParam(2, $paymentUrl);
                $stmt->bindParam(3, $createdAt);
                $stmt->execute();

                // Close statement
                $stmt->closeCursor();

                // Close connection (if needed)
                // No need to close the connection if you want to reuse $pdo elsewhere

                $paymentUrltoshow = "https://couponcart.in/shrt/" . $shortUrl;

                // Prepare and send the response message with the payment link
                $responseMessage = "Hello😊,\n"; // Greet the user with their name
                $responseMessage .= "$firstName $lastName\n\n"; // Greet the user with their name
                $responseMessage .= "✨ Payment Link Generated ✨\n\n";
                 $responseMessage .= "🆔 Order ID: {$tmeorderid}\n";
                $responseMessage .= "💲 Amount: ₹$amount\n";
                $responseMessage .= "👇 Click the link above to proceed with the payment.\n";
                $responseMessage .= "🔗 Payment Link: $paymentUrltoshow\n";
            } else {
                // Payment URL is not available or generation failed
                $responseMessage = "Oops! 😔 We apologize, but we are unable to generate a payment link at the moment due to the following reason:\n\n❗️ {$jsonResponse['message']} ❗️";
            }

            // Send the response message back to the user via Telegram API
            boltx_telegram_noti_bot($responseMessage, $chatId);
            exit;

        } else {
            // Handle the case where no matching user is found
            $responseMessage = "User not found or not subscribed.";
            exit;
        }
    }
}  //> close condition for /paylink command

// Handle /setwebhook command
elseif (isset($message["text"]) && strpos($message["text"], "/setwebhook") === 0) {
    // Check if the user has provided a webhook URL
    $textParts = explode(' ', $message["text"]);
    if (count($textParts) < 2) {
        // User didn't provide a webhook URL, so guide them on how to do it
        $responseMessage = "To set a webhook URL, please enter the command as follows:\n/setwebhook [webhook_url]";
        boltx_telegram_noti_bot($responseMessage, $chatId);
                exit;
    } else {
        // User provided a webhook URL, proceed with webhook URL setting
        $webhookUrl = trim($textParts[1]);

        // Search for user in the users table with valid conditions
        $stmt = $pdo->prepare("SELECT id, merchant_id,company FROM users WHERE telegram_chat_id = :chatId AND telegram_subscribed = 'on'");
        $stmt->bindParam(':chatId', $chatId);
        $stmt->execute();

        if ($stmt->rowCount() > 0) {
            $user = $stmt->fetch(PDO::FETCH_ASSOC);
            $merchantId = $user['merchant_id'];
            $userId = $user['id']; // Added user's ID
            $webhookcompanyname= $user['company']; // Added company's ID

            // Check if the webhook URL is in a proper format (you can add more validation as needed)
            if (filter_var($webhookUrl, FILTER_VALIDATE_URL)) {
                // Update the user's callback_url in the database with a specific user ID
                $updateStmt = $pdo->prepare("UPDATE users SET callback_url = :webhookUrl WHERE merchant_id = :merchantId AND id = :userId");
                $updateStmt->bindParam(':webhookUrl', $webhookUrl);
                $updateStmt->bindParam(':merchantId', $merchantId);
                $updateStmt->bindParam(':userId', $userId); // Added user's ID parameter
                $updateStmt->execute();

                // Prepare and send the response message with emojis
                $responseMessage = "Hello😊,\n"; // Greet the user with their name
                $responseMessage .= "$firstName $lastName\n\n"; // Greet the user with their name
                $responseMessage .= "✅ Webhook URL successfully updated for Company ID: $webhookcompanyname\n";
                $responseMessage .= "🔗 New Webhook URL: $webhookUrl";
                // Send the response message back to the user via Telegram API
                boltx_telegram_noti_bot($responseMessage, $chatId);
                exit;

            } else {
                // Handle the case where the provided webhook URL is not in a proper format
                $responseMessage = "Invalid webhook URL format. Please provide a valid URL.";
                boltx_telegram_noti_bot($responseMessage, $chatId);
                exit;
            }
        } else {
            // Handle the case where no matching user is found
            $responseMessage = "User not found or not subscribed.";
            exit;
        }
    }

}//> close condition for /setwebhook command

// Handle /userinfo command
elseif (isset($message["text"]) && strpos($message["text"], "/userinfo") === 0) {
    // Check if the user is subscribed and has a valid telegram_chat_id
    $stmt = $pdo->prepare("SELECT id, merchant_id FROM users WHERE telegram_chat_id = :chatId AND telegram_subscribed = 'on'");
    $stmt->bindParam(':chatId', $chatId);
    $stmt->execute();

    if ($stmt->rowCount() > 0) {
        $user = $stmt->fetch(PDO::FETCH_ASSOC);
        $merchantId = $user['merchant_id'];

        // Fetch user information from the 'users' table
        $infoStmt = $pdo->prepare("SELECT name, mobile, email, company, expiry, callback_url, phonepe_connected, hdfc_connected, paytm_connected, bharatpe_connected, googlepay_connected, amazonpay_connected FROM users WHERE id = :userId AND merchant_id = :merchantId");
        $infoStmt->bindParam(':userId', $user['id']);
        $infoStmt->bindParam(':merchantId', $merchantId);
        $infoStmt->execute();

        if ($infoStmt->rowCount() > 0) {
            $userInfo = $infoStmt->fetch(PDO::FETCH_ASSOC);

            // Prepare and send the response message with user information
            $responseMessage = "Hello😊,\n"; // Greet the user with their name
            $responseMessage .= "$firstName $lastName\n\n"; // Greet the user with their name
            $responseMessage .= "👤 User Information 👤\n\n";
            $responseMessage .= "👥 Name: {$userInfo['name']}\n";
            $responseMessage .= "📱 Mobile: {$userInfo['mobile']}\n";
            $responseMessage .= "📧 Email: {$userInfo['email']}\n";
            $responseMessage .= "🏢 Company: {$userInfo['company']}\n";
            $responseMessage .= "⏳ Plan Expiry Date :{$userInfo['expiry']}\n";
            $responseMessage .= "🌐 Callback URL: {$userInfo['callback_url']}\n";
            $responseMessage .= "📲 PhonePe Connected: {$userInfo['phonepe_connected']}\n";
            $responseMessage .= "🏦 HDFC Connected: {$userInfo['hdfc_connected']}\n";
            $responseMessage .= "💳 Paytm Connected: {$userInfo['paytm_connected']}\n";
            $responseMessage .= "💼 BharatPe Connected: {$userInfo['bharatpe_connected']}\n";
            $responseMessage .= "📱 Google Pay Connected: {$userInfo['googlepay_connected']}\n";
            $responseMessage .= "🛒 Amazon Pay Connected: {$userInfo['amazonpay_connected']}\n";
             // Send the response message back to the user via Telegram API
             boltx_telegram_noti_bot($responseMessage, $chatId);
             exit;
        } else {
            // Handle the case where no user information is found
            $responseMessage = "User information not found.";
             // Send the response message back to the user via Telegram API
             boltx_telegram_noti_bot($responseMessage, $chatId);
             exit;
        }
    } else {
        // Handle the case where no matching user is found
        $responseMessage = "User not found or not subscribed.";
    }

}//> Close Condition for /userinfo command


// Handle /syncmerchant command
elseif (isset($message["text"]) && strpos($message["text"], "/syncmerchant") === 0) {
    // Check if the user is subscribed and has a valid telegram_chat_id
    $stmt = $pdo->prepare("SELECT id, merchant_id FROM users WHERE telegram_chat_id = :chatId AND telegram_subscribed = 'on'");
    $stmt->bindParam(':chatId', $chatId);
    $stmt->execute();

    if ($stmt->rowCount() > 0) {
        $user = $stmt->fetch(PDO::FETCH_ASSOC);
        $merchantId = $user['merchant_id'];

        // Get the current date and time in Y-m-d H:i:s format
        $currentDateTime = date('Y-m-d H:i:s');

        // Prepare the response message for syncing merchant with the current date and time
        $responseMessage = "✅ Merchant has been synced successfully at $currentDateTime!";
        // Send the response message back to the user via Telegram API
        boltx_telegram_noti_bot($responseMessage, $chatId);
        exit;
    } else {
        // Handle the case where no matching user is found
        $responseMessage = "User not found or not subscribed.";
        exit;
    }
}//> Close Condition for /syncmerchant command

// Handle /transactions command
elseif (isset($message["text"]) && strpos($message["text"], "/transactions") === 0) {
    // Check if the user is subscribed and has a valid telegram_chat_id
    $stmt = $pdo->prepare("SELECT id, merchant_id FROM users WHERE telegram_chat_id = :chatId AND telegram_subscribed = 'on'");
    $stmt->bindParam(':chatId', $chatId);
    $stmt->execute();

    if ($stmt->rowCount() > 0) {
        $user = $stmt->fetch(PDO::FETCH_ASSOC);
        $merchantId = $user['merchant_id'];
        $userId = $user['id'];

        // Extract the limit from the command
        $textParts = explode(' ', $message["text"]);
        if (count($textParts) < 2) {
            // User didn't provide a limit, so guide them on how to do it
            $responseMessage = "To check recent transactions, please enter the command as follows:\n/transactions [limit]";
            // Send the response message back to the user via Telegram API
            boltx_telegram_noti_bot($responseMessage, $chatId);
            exit;
        } else {
            $limit = intval($textParts[1]); // Convert limit to integer

            if ($limit > 0) {
                // Limit the maximum number of transactions that a user can fetch to 10
                if ($limit > 10) {
                    $limit = 10;
                }

                $stmt = $pdo->prepare("SELECT * FROM orders WHERE user_id = :userId ORDER BY create_date DESC LIMIT :limit");
                $stmt->bindParam(':userId', $userId);
                $stmt->bindParam(':limit', $limit, PDO::PARAM_INT); // Bind limit as an integer
                $stmt->execute();


                $fetchedRowCount = $stmt->rowCount(); // Get the number of fetched rows

                if ($fetchedRowCount > 0) {
                    // Check if the fetched row count is less than the requested limit
                    if ($fetchedRowCount < $limit) {
                        $responseMessage = "Try with a lower limit as there are fewer transactions available.";
                        // Send the response message back to the user via Telegram API
                        boltx_telegram_noti_bot($responseMessage, $chatId);
                        exit;
                    } else {
                        // Initialize the custom label for the serial number
                        $customLabel = "🌟 Transaction Number"; // Change this label as you like
                        // Initialize the serial number to 1
                        $serialNumber = 1;


                        // Loop through the transactions and send each as a separate message
                        while ($order = $stmt->fetch(PDO::FETCH_ASSOC)) {
                            // Add the custom label with the serial number at the beginning of each responseMessage
                            $responseMessage = "Hello😊,\n"; // Greet the user with their name
                            $responseMessage .= "$firstName $lastName\n\n"; // Greet the user with their name
                            $responseMessage .= "$customLabel: $serialNumber\n\n"; // Custom label with serial number
                            $responseMessage .= "🆔 Order ID: {$order['order_id']}\n";
                            $responseMessage .= "💰 Amount: ₹{$order['amount']}\n";
                            $responseMessage .= "🔖 Status: {$order['status']}\n";
                            $responseMessage .= "📅 Date: {$order['create_date']}\n";
                            $responseMessage .= "🏦 Merchant: {$order['method']}\n";
                            // Check if UTR is null or not and display accordingly
                            if ($order['utr'] !== null && $order['utr'] !== '') {
                                // UTR is not null and not empty
                                $responseMessage .= "🔍 UTR: {$order['utr']}\n";
                            } else {
                                // UTR is either null or empty
                                $responseMessage .= "🔍 UTR: Not Available\n";
                            }
                            $responseMessage .= "📝 Remark 1: {$order['remark1']}\n";
                            $responseMessage .= "📝 Remark 2: {$order['remark2']}\n";
                            $responseMessage .= "🔐 Transaction ID: {$order['byteTransactionId']}\n\n";

                            // Send the response message back to the user via Telegram API
                            boltx_telegram_noti_bot($responseMessage, $chatId);

                            // Increment the serial number for the next transaction
                            $serialNumber++;
                        }
                        exit; // Exit after sending all messages
                    }
                } else {
                    // Handle the case where no transactions are found
                    $responseMessage = "No transactions found for this user.";
                    // Send the response message back to the user via Telegram API
                    boltx_telegram_noti_bot($responseMessage, $chatId);
                    exit;
                }
            } else {
                // Handle invalid limit input
                $responseMessage = "Please enter a valid positive integer as the limit.";
                // Send the response message back to the user via Telegram API
                boltx_telegram_noti_bot($responseMessage, $chatId);
                exit;
            }
        }
    } else {
        // Handle the case where no matching user is found
        $responseMessage = "User not found or not subscribed.";
        exit;
    }
    
} //> close block for /transactions command

// Handle /support command
elseif (strpos($message["text"], "/support") === 0) {
    // Prepare and send the response message
        $responseMessage = "Hello, $firstName $lastName 😊\n"; // Greet the user with their name
        $responseMessage .= "Here's how you can contact our support team:\n";
        $responseMessage .= "📞 **Contact our support team** 🆘\n\n";
        $responseMessage .= "📧 **Email Us:** [support@gamercart.shop](mailto:support@gamercart.shop)\n";
        $responseMessage .= "🌐 **Website:** [PROBOT Support](https://gamercart.shop)\n";

        // Call the boltx_telegram_noti_bot function with the updated message and chat ID
        boltx_telegram_noti_bot($responseMessage, $chatId);
        exit;
}//> close block for /support command


    
// Handle /integrate command
elseif (strpos($message["text"], "/integrate") === 0) {
    // Handle /integrate command
    $responseMessage = "Hello, $firstName $lastName 😊\n"; // Greet the user with their name
    $responseMessage .= "Here's how you can contact our support team:\n";
    $responseMessage .= "📞 **Contact our support team** 🆘\n\n";
    $responseMessage .= "📧 **Email Us:** [support@gamercart.shop](mailto:support@gamercart.shop)\n";
    $responseMessage .= "🌐 **Website:** [PROBOT Support](https://gamercart.shop)\n";
    $responseMessage .= "💼 For custom development, contact our expert team!\n";
    
    // Send the response message back to the user via Telegram API
    boltx_telegram_noti_bot($responseMessage, $chatId);
    exit;
}//> close block for /integrate command

    
// Handle /help command
elseif (strpos($message["text"], "/help") === 0) {
    $responseMessage = " **PROBOT Bot Help Menu** \n\n";
    $responseMessage .= "Here are the available commands and their descriptions:\n\n";
    $responseMessage .= "1. `/totalpayment` - Get total payment for the current day.\n";
    $responseMessage .= "2. `/genapi` - Generate a new API Key.\n";
    $responseMessage .= "3. `/paymentstatus [transaction_id]` - Check the status of a payment (Replace `[transaction_id]` with the actual ID).\n";
    $responseMessage .= "4. `/paylink [amount]` - Generate a payment link (Replace `[amount]` with the desired amount).\n";
    $responseMessage .= "5. `/setwebhook [webhook_url]` - Set a webhook URL (Replace `[webhook_url]` with your URL).\n";
    $responseMessage .= "6. `/userinfo` - Get your user information.\n";
    $responseMessage .= "7. `/syncmerchant` - Sync your merchant account.\n";
    $responseMessage .= "8. `/transactions [limit]` - Get recent transactions (Replace `[limit]` with the number of transactions to fetch).\n";
    $responseMessage .= "9. `/support` - Contact our support team \n";
    $responseMessage .= "10. `/integrate` - Learn how to integrate a payment gateway into your website \n";
    $responseMessage .= "11. `/help` - Display this help menu.\n";
    
    // Send the response message back to the user via Telegram API
    boltx_telegram_noti_bot($responseMessage, $chatId);
    exit;
}//> close block for /help command


    
} //for if (isset($update["message"])) for this close bracket
?>





