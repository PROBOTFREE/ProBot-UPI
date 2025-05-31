<?php
// Define the base directory constant
define('PROJECT_ROOT', realpath(dirname(__FILE__)) . '/../');

// Securely include files using the PROJECT_ROOT constant
include PROJECT_ROOT . 'pages/dbFunctions.php';
include PROJECT_ROOT . 'pages/dbInfo.php';
include PROJECT_ROOT . 'auth/config.php';


function isInteger($value)
{
    return filter_var($value, FILTER_VALIDATE_INT) !== false;
}

function isCustomerNumberValid($value)
{
    return isInteger($value) && strlen($value) <= 10;
}

function RandomNumber($length)
{
    $str = "";
    for ($i = 0; $i < $length; $i++) {
        $str .= mt_rand(0, 9);
    }
    return $str;
}

function GenRandomString($length = 10)
{
    $characters =
        "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
    $charactersLength = strlen($characters);
    $randomString = "";
    for ($i = 0; $i < $length; $i++) {
        $randomString .= $characters[rand(0, $charactersLength - 1)];
    }
    return $randomString;
}

function generateUniqueToken()
{
    $token = time() . bin2hex(random_bytes(16)) . rand(1, 50);
    return hash("sha256", $token);
}

if ($_SERVER["REQUEST_METHOD"] != "POST") {
    http_response_code(400); // Bad Request
    header("Content-Type: application/json");
    $json = ["status" => false, "message" => "Unauthorized Access"];
    echo json_encode($json);
    exit(); // Stop further script execution if the request is not POST
}

if ($_SERVER["REQUEST_METHOD"] == "POST") {
    header("Content-Type: application/json");



    $customer_mobile = $_POST["customer_mobile"];
    $user_token = $_POST["user_token"];
    $amount = $_POST["amount"];
    $order_id = $_POST["order_id"];
    $redirect_url = $_POST["redirect_url"];
    $secureToken = $_POST["secure_token"];
    $remark1 = $_POST["remark1"];
    $remark2 = $_POST["remark2"];
    $route = $_POST["route"];
    
    

    $byteorderid = "PROBOT" . rand(1111, 9999) . time();

    
    $slq_pbbyt = "SELECT * FROM users where user_token='$user_token'";
    $res_pslq_pbbyt = getXbyY($slq_pbbyt);
   
    
    $bydb_unq_user_id = $res_pslq_pbbyt[0]["id"];
    $bydb_order_hdfc_conn = $res_pslq_pbbyt[0]["hdfc_connected"];
    $bydb_order_phonepe_conn = $res_pslq_pbbyt[0]["phonepe_connected"];
    $bydb_order_paytm_conn = $res_pslq_pbbyt[0]["paytm_connected"];
    $bydb_order_bharatpe_conn = $res_pslq_pbbyt[0]["bharatpe_connected"];
    $bydb_order_googlepay_conn = $res_pslq_pbbyt[0]["googlepay_connected"];
    $bydb_order_freecharge_conn = $res_pslq_pbbyt[0]["freecharge_connected"];
    

    $cxrvip = $res_pslq_pbbyt[0]["route_2"];
    $cxrvipexpiry = $res_pslq_pbbyt[0]["vip_expiry"];
    $isuserbanned=$res_pslq_pbbyt[0]["acc_ban"];
    $isacc_lock=$res_pslq_pbbyt[0]["acc_lock"];
    
   
    //check if already order exist for that user_token
    // New validation for order_id
    $check_order_id_query = "SELECT * FROM orders WHERE order_id='$order_id' AND user_token='$user_token'";
    $existing_order_result = getXbyY($check_order_id_query);

    if (!empty($existing_order_result)) {
        http_response_code(400); // Bad Request
        echo json_encode([
            "status" => false,
            "message" => "Order ID already exists for this user",
        ]);
        exit();
    }

    //vip 

    if ($route == "2") {
        if ($cxrvip != "on") {
             http_response_code(403); // Forbidden
            echo json_encode([
                "status" => false,
                "message" => "Your VIP is not Enabled",
            ]);
            exit();
        }

        $today = date("Y-m-d");

        if ($cxrvipexpiry <= $today) {
             http_response_code(403); // Forbidden
            echo json_encode([
                "status" => false,
                "message" => "Your VIP Plan Expired Please Renew",
            ]);
            exit();
        }
        
        if ($amount < 100) {
             http_response_code(403); // Forbidden
            echo json_encode([
                "status" => false,
                "message" => "Amount cannot Be less than 100",
            ]);
            exit();
        }
        
        
        
            $link_token = generateUniqueToken();

            $cxrtoday = date("Y-m-d H:i:s");

            // Insert the link_token into the payment_links table with the current date and time
            $sql_insert_link = "INSERT INTO payment_links (link_token, order_id, created_at) VALUES ('$link_token', '$order_id', '$cxrtoday')";
            setXbyY($sql_insert_link);

            // Construct the payment link
            $payment_link ="https://couponcart.in/bytevip/instant-pay/" . $link_token;
            $gateway_txn1 = rand(1000000000, 9999999999);

            $method = "VIPPAY";
            $currentTimestamp = date("Y-m-d H:i:s");
            $sql = "INSERT INTO orders (gateway_txn, amount, order_id, status, user_token, utr, customer_mobile, redirect_url, method, create_date, remark1, remark2, user_id, byteTransactionId, route, secure_token)
    VALUES ('$gateway_txn1', '$amount', '$order_id', 'PENDING', '$user_token', '', '$customer_mobile', '$redirect_url', '$method', '$currentTimestamp', '$remark1', '$remark2', '$bydb_unq_user_id', '$byteorderid', '2', '$secureToken')";

            setXbyY($sql);
http_response_code(201); // Created
            echo json_encode([
                "status" => true,
                "message" => "Order Created Successfully",
                "result" => [
                    "orderId" => $order_id,
                    "payment_url" => $payment_link,
                ],
            ]);
            exit();
        
    } //route 2 bracket end //vip 

    if ($bydb_order_hdfc_conn == "Yes") {
        if ($amount > 2000) {
            http_response_code(400); // Bad Request
            echo json_encode([
                "status" => false,
                "message" => "In HDFC MAxiumum 2000 Allowed",
            ]);
            exit();
        }

        $today = date("Y-m-d");
        $slq_p = "SELECT * FROM users where user_token='$user_token'";
        $res_p = getXbyY($slq_p);
        $expire_date = $res_p[0]["expiry"];

        if ($expire_date >= $today) {
            // Generate a unique payment link token
            $link_token = generateUniqueToken();

            $cxrtoday = date("Y-m-d H:i:s");

            // Insert the link_token into the payment_links table with the current date and time
            $sql_insert_link = "INSERT INTO payment_links (link_token, order_id, created_at) VALUES ('$link_token', '$order_id', '$cxrtoday')";
            setXbyY($sql_insert_link);

            // Construct the payment link
            $payment_link ="https://couponcart.in/payment/instant-pay/" . $link_token;
            $gateway_txn1 = rand(1000000000, 9999999999);

            $method = "HDFC";
            $currentTimestamp = date("Y-m-d H:i:s");
            $mTxnid = "";
            $diss = RandomNumber(18);
            $sql = "INSERT INTO orders (gateway_txn, amount, order_id, status, user_token, utr, customer_mobile, redirect_url, method, upiLink, description, create_date, remark1, remark2, user_id, byteTransactionId, secure_token)
    VALUES ('$gateway_txn1', '$amount', '$order_id', 'PENDING', '$user_token', '', '$customer_mobile', '$redirect_url', '$method', '$upiLink', '$diss', '$currentTimestamp', '$remark1', '$remark2', '$bydb_unq_user_id', '$byteorderid', '$secureToken')";

            setXbyY($sql);
           http_response_code(201); // Created
            echo json_encode([
                "status" => true,
                "message" => "Order Created Successfully",
                "result" => [
                    "orderId" => $order_id,
                    "payment_url" => $payment_link,
                ],
            ]);
            exit();
        } else {
            http_response_code(400); // Bad Request
            echo json_encode([
                "status" => false,
                "message" => "Your Plan Expired Please Renew",
            ]);
            exit();
        }
    }

    // <-- Close the HDFC block here
    //phonepe else if logic start
    elseif ($bydb_order_phonepe_conn == "Yes") {
        $today = date("Y-m-d");
        $slq_p = "SELECT * FROM users where user_token='$user_token'";
        $res_p = getXbyY($slq_p);
        $expire_date = $res_p[0]["expiry"];

        if ($expire_date >= $today) {
            // Generate a unique payment link token
            $link_token = generateUniqueToken();

            $cxrtoday = date("Y-m-d H:i:s");

            // Insert the link_token into the payment_links table with the current date and time
            $sql_insert_link = "INSERT INTO payment_links (link_token, order_id, created_at) VALUES ('$link_token', '$order_id', '$cxrtoday')";
            setXbyY($sql_insert_link);

            // Construct the payment link
            $payment_link ="https://couponcart.in/payment2/instant-pay/" . $link_token;

            $order_id2 = base64_encode($order_id);
            $gateway_txn = uniqid();
            $currentTimestamp = date("Y-m-d H:i:s");

            $sql = "INSERT INTO orders (gateway_txn, amount, order_id, status, user_token, utr, customer_mobile, redirect_url, Method, byteTransactionId, create_date, remark1, remark2, user_id, secure_token)
VALUES ('$gateway_txn', '$amount', '$order_id', 'PENDING', '$user_token', '', '$customer_mobile', '$redirect_url', 'PhonePe', '$byteorderid', '$currentTimestamp', '$remark1', '$remark2', '$bydb_unq_user_id', '$secureToken')";

            setXbyY($sql);
http_response_code(201); // Created
            echo json_encode([
                "status" => true,
                "message" => "Order Created Successfully",
                "result" => [
                    "orderId" => $order_id,
                    "payment_url" => $payment_link,
                ],
            ]);
            exit();
        } else {
            http_response_code(400); // Bad Request
            echo json_encode([
                "status" => false,
                "message" => "Your Plan Expired Please Renew",
            ]);
            exit();
        }
    }

    // <-- Close the phonepe block here
    //paytm else if logic start
    elseif ($bydb_order_paytm_conn == "Yes") {
        $today = date("Y-m-d");
        $slq_p = "SELECT * FROM users where user_token='$user_token'";
        $res_p = getXbyY($slq_p);
        $expire_date = $res_p[0]["expiry"];

        if ($expire_date >= $today) {
            // Generate a unique payment link token
            $link_token = generateUniqueToken();

            $cxrtoday = date("Y-m-d H:i:s");

            // Insert the link_token into the payment_links table with the current date and time
            $sql_insert_link = "INSERT INTO payment_links (link_token, order_id, created_at) VALUES ('$link_token', '$order_id', '$cxrtoday')";
            setXbyY($sql_insert_link);

            // Construct the payment link
            $payment_link =
                "https://couponcart.in/payment3/instant-pay/" . $link_token;

            $order_id2 = base64_encode($order_id);
            $gateway_txn = uniqid();
            $currentTimestamp = date("Y-m-d H:i:s");
            $bytetxn_ref_id = GenRandomString() . time();

            $sql = "INSERT INTO orders (paytm_txn_ref, gateway_txn, amount, order_id, status, user_token, utr, customer_mobile, redirect_url, Method, byteTransactionId, create_date, remark1, remark2, user_id, secure_token)
VALUES ('$bytetxn_ref_id', '$gateway_txn', '$amount', '$order_id', 'PENDING', '$user_token', '', '$customer_mobile', '$redirect_url', 'Paytm', '$byteorderid', '$currentTimestamp', '$remark1', '$remark2', '$bydb_unq_user_id', '$secureToken')";

            setXbyY($sql);
http_response_code(201); // Created
            echo json_encode([
                "status" => true,
                "message" => "Order Created Successfully",
                "result" => [
                    "orderId" => $order_id,
                    "payment_url" => $payment_link,
                ],
            ]);
            exit();
        } else {
            http_response_code(400); // Bad Request
            echo json_encode([
                "status" => false,
                "message" => "Your Plan Expired Please Renew",
            ]);
            exit();
        }
    }

    // <-- Close the paytm block here
    //Bharatpe else if logic start
    elseif ($bydb_order_bharatpe_conn == "Yes") {
        $today = date("Y-m-d");
        $slq_p = "SELECT * FROM users where user_token='$user_token'";
        $res_p = getXbyY($slq_p);
        $expire_date = $res_p[0]["expiry"];

        if ($expire_date >= $today) {
            // Generate a unique payment link token
            $link_token = generateUniqueToken();

            $cxrtoday = date("Y-m-d H:i:s");

            // Insert the link_token into the payment_links table with the current date and time
            $sql_insert_link = "INSERT INTO payment_links (link_token, order_id, created_at) VALUES ('$link_token', '$order_id', '$cxrtoday')";
            setXbyY($sql_insert_link);

            // Construct the payment link
            $payment_link =
                "https://couponcart.in/payment4/instant-pay/" . $link_token;

            $gateway_txn = uniqid();
            $currentTimestamp = date("Y-m-d H:i:s");
            $sql = "INSERT INTO orders (gateway_txn, amount, order_id, status, user_token, utr, customer_mobile, redirect_url, Method, byteTransactionId, create_date, remark1, remark2, user_id, secure_token)
VALUES ('$gateway_txn', '$amount', '$order_id', 'PENDING', '$user_token', '', '$customer_mobile', '$redirect_url', 'Bharatpe', '$byteorderid', '$currentTimestamp', '$remark1', '$remark2', '$bydb_unq_user_id', '$secureToken')";

            setXbyY($sql);
 http_response_code(201); // Created
            echo json_encode([
                "status" => true,
                "message" => "Order Created Successfully",
                "result" => [
                    "orderId" => $order_id,
                    "payment_url" => $payment_link,
                ],
            ]);
            exit();
        } else {
            http_response_code(400); // Bad Request
            echo json_encode([
                "status" => false,
                "message" => "Your Plan Expired Please Renew",
            ]);
            exit();
        }
    }

    // <-- Close the Bharatpe block here
    //GooglePay else if logic start
    elseif ($bydb_order_googlepay_conn == "Yes") {
        $today = date("Y-m-d");
        $slq_p = "SELECT * FROM users where user_token='$user_token'";
        $res_p = getXbyY($slq_p);
        $expire_date = $res_p[0]["expiry"];

        if ($expire_date >= $today) {
            // Generate a unique payment link token
            $link_token = generateUniqueToken();

            $cxrtoday = date("Y-m-d H:i:s");

            // Insert the link_token into the payment_links table with the current date and time
            $sql_insert_link = "INSERT INTO payment_links (link_token, order_id, created_at) VALUES ('$link_token', '$order_id', '$cxrtoday')";
            setXbyY($sql_insert_link);

            // Construct the payment link
            $payment_link ="https://couponcart.in/payment5/instant-pay/" . $link_token;

            $gateway_txn = uniqid();
            $currentTimestamp = date("Y-m-d H:i:s");
            $sql = "INSERT INTO orders (gateway_txn, amount, order_id, status, user_token, utr, customer_mobile, redirect_url, Method, byteTransactionId, create_date, remark1, remark2, user_id, secure_token)
VALUES ('$gateway_txn', '$amount', '$order_id', 'PENDING', '$user_token', '', '$customer_mobile', '$redirect_url', 'Googlepay', '$byteorderid', '$currentTimestamp', '$remark1', '$remark2', '$bydb_unq_user_id', '$secureToken')";

            setXbyY($sql);
 http_response_code(201); // Created
            echo json_encode([
                "status" => true,
                "message" => "Order Created Successfully",
                "result" => [
                    "orderId" => $order_id,
                    "payment_url" => $payment_link,
                ],
            ]);
            exit();
        } else {
            http_response_code(400); // Bad Request
            echo json_encode([
                "status" => false,
                "message" => "Your Plan Expired Please Renew",
            ]);
            exit();
        }
    }
    
    //freecharge else if logic start
    elseif ($bydb_order_freecharge_conn == "Yes") {
        $today = date("Y-m-d");
        $slq_p = "SELECT * FROM users where user_token='$user_token'";
        $res_p = getXbyY($slq_p);
        $expire_date = $res_p[0]["expiry"];

        if ($expire_date >= $today) {
            // Generate a unique payment link token
            $link_token = generateUniqueToken();

            $cxrtoday = date("Y-m-d H:i:s");
            $bytetxn_ref_id = GenRandomString() . time();

            // Insert the link_token into the payment_links table with the current date and time
            $sql_insert_link = "INSERT INTO payment_links (link_token, order_id, created_at) VALUES ('$link_token', '$order_id', '$cxrtoday')";
            setXbyY($sql_insert_link);

            // Construct the payment link
            $payment_link ="https://couponcart.in/freecharge/instant-pay/" . $link_token;

            $gateway_txn = uniqid();
            $currentTimestamp = date("Y-m-d H:i:s");
            $sql = "INSERT INTO orders (paytm_txn_ref, gateway_txn, amount, order_id, status, user_token, utr, customer_mobile, redirect_url, Method, byteTransactionId, create_date, remark1, remark2, user_id, secure_token)
VALUES ('$bytetxn_ref_id', '$gateway_txn', '$amount', '$order_id', 'PENDING', '$user_token', '', '$customer_mobile', '$redirect_url', 'Freecharge', '$byteorderid', '$currentTimestamp', '$remark1', '$remark2', '$bydb_unq_user_id', '$secureToken')";

            setXbyY($sql);
 http_response_code(201); // Created
            echo json_encode([
                "status" => true,
                "message" => "Order Created Successfully",
                "result" => [
                    "orderId" => $order_id,
                    "payment_url" => $payment_link,
                ],
            ]);
            exit();
        } else {
            http_response_code(400); // Bad Request
            echo json_encode([
                "status" => false,
                "message" => "Your Plan Expired Please Renew",
            ]);
            exit();
        }
    }

    // <-- Close the GooglePay block here
    elseif (
        $bydb_order_hdfc_conn == "No" ||
        $bydb_order_phonepe_conn == "No" ||
        $bydb_order_paytm_conn == "No" ||
        $bydb_order_bharatpe_conn == "No" ||
        $bydb_order_googlepay_conn == "No" ||
        $bydb_order_freecharge_conn == "No"
    ) {
        http_response_code(400); // Bad Request
        echo json_encode([
            "status" => false,
            "message" => "Merchant Not Linked",
        ]);
        exit();
    }
}
?>
