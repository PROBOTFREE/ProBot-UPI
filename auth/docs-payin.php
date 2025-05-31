<?php
//api docs for Payin

// Define the absolute path to the functions.php file
define('ABSPATH', dirname(__FILE__) . '/'); // Adjust the path as needed

require_once(ABSPATH . 'header.php');

?>

<head>
  <!--favicon-->
	<link rel="icon" href="assets/images/favicon-32x32.png" type="image/png">

  <!--plugins-->
  <link href="assets/plugins/perfect-scrollbar/css/perfect-scrollbar.css" rel="stylesheet">
  <link rel="stylesheet" type="text/css" href="assets/plugins/metismenu/metisMenu.min.css">
  <link rel="stylesheet" type="text/css" href="assets/plugins/metismenu/mm-vertical.css">
  <link href="assets/plugins/simplebar/css/simplebar.css" rel="stylesheet">
  <!--bootstrap css-->
  <link href="assets/css/bootstrap.min.css" rel="stylesheet">
  <link href="https://fonts.googleapis.com/css2?family=Noto+Sans:wght@300;400;500;600&display=swap" rel="stylesheet">
  <link href="https://fonts.googleapis.com/css?family=Material+Symbols+Rounded" rel="stylesheet">
  <!--main css-->
  <link href="assets/css/bootstrap-extended.css" rel="stylesheet">
  <link href="sass/main.css" rel="stylesheet">
  <link href="sass/dark-theme.css" rel="stylesheet">
  <link href="sass/semi-dark.css" rel="stylesheet">
  <link href="sass/bordered-theme.css" rel="stylesheet">
  <link href="sass/responsive.css" rel="stylesheet">
  
  
<style>
        body {
            font-family: Arial, sans-serif;
            margin: 0;
            padding: 20px;
            background-color: #f4f4f4;
        }
        .main-wrapper {
        border-radius: 8px;
        box-shadow: 0 4px 6px rgba(0,0,0,0.1); /* Subtle shadow for depth */
        }
        .container {
            width:100;
            max-width: none;
            margin: 0 auto;
            background: #fff;
            padding: 20px;
            border-radius: 8px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
        }
        h1 {
            text-align: center;
            color: #333;
        }
        h2 {
            border-bottom: 2px solid #007BFF;
            padding-bottom: 5px;
            color: #007BFF;
        }
        .endpoint {
            background: #f9f9f9;
            padding: 10px;
            border-radius: 5px;
            margin-bottom: 20px;
        }
        code {
            background: #eee;
            padding: 2px 5px;
            border-radius: 4px;
            font-family: monospace;
        }
        .method {
            font-weight: bold;
            color: #28a745;
        }
        pre {
            background: #272822;
            color: #f8f8f2;
            padding: 15px;
            border-radius: 8px;
            overflow-x: auto;
            font-size: 14px;
        }
        .description {
            font-style: italic;
            color: #555;
        }
        table {
            width: 100%;
            border-collapse: collapse;
            margin-top: 15px;
        }
        table, th, td {
            border: 1px solid #ddd;
        }
        th, td {
            padding: 10px;
            text-align: left;
        }
        th {
            background-color: #007BFF;
            color: white;
        }
    </style>

</head>
  

<body>
<main class="main-wrapper">
    <div class="container">
        <h1>API Documentation</h1>
        
        <h2>Authentication</h2>
        <div class="endpoint">
            <p><span class="method">POST</span> <code>/api/auth</code></p>
            <p class="description">Authenticate a user and receive an access token.</p>
            <pre>{ "username": "your_username", "password": "your_password" }</pre>
        </div>
            
            <h3>Request Parameters</h3>
            <table>
                <tr><th>Parameter</th><th>Type</th></tr>
                <tr><td>customer_mobile</td><td>Integer</td></tr>
                <tr><td>user_token</td><td>String</td></tr>
                <tr><td>amount</td><td>Float</td></tr>
                <tr><td>order_id</td><td>String</td></tr>
                <tr><td>redirect_url</td><td>URL</td></tr>
                <tr><td>remark1</td><td>String</td></tr>
                <tr><td>remark2</td><td>String</td></tr>
                <tr><td>route</td><td>Integer</td></tr>
            </table>
            
            <h3>Request Headers</h3>
            <table>
                <tr><th>Parameter</th><th>Description</th></tr>
                <tr><td>Content-Type</td><td>Form-Encoded Payload (application/x-www-form-urlencoded)</td></tr>
            </table>
            
            <h3>Response</h3>
            <table>
                <tr><th>Field</th><th>Type</th><th>Description</th></tr>
                <tr><td>status</td><td>Boolean</td><td>API request status.</td></tr>
                <tr><td>result</td><td>Object</td><td>Details of successful request.</td></tr>
                <tr><td>payment_url</td><td>String</td><td>URL for processing payment.</td></tr>
                <tr><td>message</td><td>String</td><td>Description of request result.</td></tr>
            </table>
    
            
            <section>
                <p><span class="method">POST</span> <code>https://couponcart.in/api/create-order</code></p>
                <pre>&lt;?php
// API URL
$api_url = 'https://couponcart.in/api/create-order';

// Form-encoded payload data
$post_data = [
    'customer_mobile' => '8145344963',
    'user_token' => '9856ce42fc26349fe5fab9c6b630e9c6',
    'amount' => '1',
    'order_id' => '8787772321800',
    'redirect_url' => 'https://couponcart.in',
    'remark1' => 'testremark',
    'remark2' => 'testremark2',
    'route' => '1' // route 2 is for VIP users, route 1 is for normal users
];

// Initialize cURL session
$ch = curl_init($api_url);

// Set cURL options
curl_setopt($ch, CURLOPT_RETURNTRANSFER, true);
curl_setopt($ch, CURLOPT_POST, true);
curl_setopt($ch, CURLOPT_POSTFIELDS, http_build_query($post_data)); // to format POST data
curl_setopt($ch, CURLOPT_HTTPHEADER, [
    'Content-Type: application/x-www-form-urlencoded'
]);

// Execute the cURL session and capture the response
$response = curl_exec($ch);

// Check for cURL errors
if (curl_errno($ch)) {
    echo 'cURL Error: ' . curl_error($ch);
} else {
    echo $response;
}

// Close the cURL session
curl_close($ch);
?&gt;</pre>
<p><span class="method">RESPONSE (Success)</span> <code>/payment/MTIzNDU2MTc</code></p>
                <h3></h3>
                <pre>{
  "status": true,
  "message": "Order Created Successfully",
  "result": {
    "orderId": "1234561705047510",
    "payment_url": "https://couponcart.in/payment/MTIzNDU2MTc"
  }
}</pre>
<p><span class="method">RESPONSE (Error)</span></p>
                <pre>{
  "status": false,
  "message": "Your Plan Expired Please Renew"
}</pre>
            </section>
        
        
        <h2>Check Payment Status</h2>
        <div class="endpoint">
            <p><span class="method">POST</span> <code>/api/check-order-status</code></p>
            <p class="description">Check the status of a UPI payment request.</p>
            
            <h3>Request Parameters</h3>
            <table>
                <tr><th>Parameter</th><th>Type</th><th>Description</th></tr>
                <tr><td>user_token</td><td>String</td><td>The API Key.</td></tr>
                <tr><td>order_id</td><td>String</td><td>AlphaNumeric.</td></tr>
            </table>
            
            <h3>Request Headers</h3>
            <table>
                <tr><th>Parameter</th><th>Description</th></tr>
                <tr><td>Content-Type</td><td>Form-Encoded Payload (application/x-www-form-urlencoded)</td></tr>
            </table>
            
            <h3>Response</h3>
            <table>
                <tr><th>Field</th><th>Type</th><th>Description</th></tr>
                <tr><td>status</td><td>Boolean</td><td>API request success status.</td></tr>
                <tr><td>message</td><td>String</td><td>API result message.</td></tr>
                <tr><td>result</td><td>Object</td><td>Details of transaction.</td></tr>
                <tr><td>txnStatus</td><td>String</td><td>Transaction status.</td></tr>
                <tr><td>orderId</td><td>String</td><td>Order ID.</td></tr>
                <tr><td>amount</td><td>String</td><td>Transaction amount.</td></tr>
                <tr><td>date</td><td>String</td><td>Transaction time.</td></tr>
                <tr><td>utr</td><td>String</td><td>UTR Number.</td></tr>
            </table>
            
            <section>
<p><span class="method">REQUEST</span></p>
        <pre>&lt;?php
// API URL
$api_url = 'https://couponcart.in/api/check-order-status';

// Form-encoded payload data
$post_data = [
    'user_token' => '9856ce42fc26349fe5fab9c6b630e9c6',
    'order_id' => '8787772321800'
];

// Initialize cURL session
$ch = curl_init($api_url);

// Set cURL options
curl_setopt($ch, CURLOPT_RETURNTRANSFER, true);
curl_setopt($ch, CURLOPT_POST, true);
curl_setopt($ch, CURLOPT_POSTFIELDS, http_build_query($post_data)); // to format POST data
curl_setopt($ch, CURLOPT_HTTPHEADER, [
    'Content-Type: application/x-www-form-urlencoded'
]);

// Execute the cURL session and capture the response
$response = curl_exec($ch);

// Check for cURL errors
if (curl_errno($ch)) {
    echo 'cURL Error: ' . curl_error($ch);
} else {
    echo $response;
}

// Close the cURL session
curl_close($ch);
?&gt;</pre>


<p><span class="method">RESPONSE (Success)</span></p>

<pre>
{
    "status": true,
    "message": "Transaction Successfully",
    "result": {
        "txnStatus": "SUCCESS", //For Pending PENDING
        "orderId": "784525sdD",
        "amount": "1",
        "date": "2024-01-12 13:22:08",
        "utr": "454525454245" //only when success
    }
}
</pre>

<p><span class="method">RESPONSE (Error)</span></p>
<pre>
{
    "status": false,
    "message": "Error Message",
}
</pre>

    </section>
        </div>
    </div>
    </main>
</body>

<!--end main wrapper-->

  <!--plugins-->
  <script src="assets/js/jquery.min.js"></script>
  <!--plugins-->
  <script src="assets/plugins/perfect-scrollbar/js/perfect-scrollbar.js"></script>
  <script src="assets/plugins/metismenu/metisMenu.min.js"></script>
  <script src="assets/plugins/simplebar/js/simplebar.min.js"></script>
  <script src="assets/js/main.js"></script>

</html>