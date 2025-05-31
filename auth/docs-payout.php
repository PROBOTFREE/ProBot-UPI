<?php
//api docs for payout

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
  
<!--start main wrapper-->
  <main class="main-wrapper">
      <div class="container">
        <h1>API Documentation</h1>
        
        <h2>Create Bank Payout</h2>
        <div class="endpoint">
            <p><span class="method">POST</span> <code>/api/bank/create-order</code></p>
            
            
            
            
            
            <h3>Request Parameters</h3>
            <table>
                <tr><th>Parameter</th><th>Type</th><th>Description</th></tr>
                <tr><td>user_token</td><td>String</td><td>The user's API Key.</td></tr>
                <tr><td>amount</td><td>Float</td><td>The amount to be paid.</td></tr>
                <tr><td>acc_no</td><td>String</td><td>The Account Number of the recipient.</td></tr>
                <tr><td>ifsc</td><td>String</td><td>The IFSC of the recipient.</td></tr>
            </table>
            
            <h3>Request Headers</h3>
            <table>
                <tr><th>Parameter</th><th>Type</th><th>Description</th></tr>
                <tr><td>X-VERIFY</td><td>String</td><td>To Verify Data Integrity.</td></tr>
            </table>
            
            
            <h3>Formula for Generating X-VERIFY</h3>
            <pre>X-VERIFY = hash_hmac('sha256', dataString, secret_key)</pre>
            
            <p style="color: black; font-weight: bold;">Where:</p>
            
            <ul>
                <li style="color: black; font-weight: bold;"><strong>dataString</strong> is a string formed by concatenating parameter names and values in the format <code>parameter1=value1|parameter2=value2|...</code>, sorted by parameter names.</li>
                <li style="color: black; font-weight: bold;"><strong>secret_key</strong> is the user's secret key used for generating the HMAC.</li>
            </ul>
    
    
            <h3>Response</h3>
            <table>
                <tr><th>Parameter</th><th>Type</th><th>Description</th></tr>
                <tr><td>status</td><td>boolean</td><td>Indicates whether the API request was successful or failed.</td></tr>
                <tr><td>result</td><td>object</td><td>Contains result related to the successful API request (if status is true).</td></tr>
                <tr><td>message</td><td>string</td><td>Error message describing the reason for API failure.</td></tr>
            </table>
            
            <section>
        <pre>&lt;?php
// API URL
$api_url = 'https://couponcart.in/api/bank/create-order';

// User input
$user_token = '4b08d135be18fd929fcb254620d6acc5'; // Replace with the user's API Key
$amount = 100; // Replace with the payout amount
$accnumber= 050310101031673; // Replace with acc number
$ifsc="CNRB0000503"; //ifsc code
$secret_key = 'ngOxcT3sR0zSk0uPZfZvihgoM0RIrBE2'; // Your secret key for checksum generation 

// Create an array with POST data
$post_data = [
    'user_token' => $user_token,
    'amount' => $amount,
    'acc_no' => $accnumber,
    'ifsc' =>$ifsc
];

// Function to generate xverify
function generatexverify($data, $secret_key) {
  // Sort the data by keys to ensure consistent order
  ksort($data);
  $dataString = implode('|', array_map(function ($key, $value) {
      return $key . '=' . $value;
  }, array_keys($data), $data));
  return hash_hmac('sha256', $dataString, $secret_key);
}

// Generate xverify
$xverify = generatexverify($post_data, $secret_key);

// Initialize cURL session
$ch = curl_init($api_url);

// Prepare the headers including the X-Verify custom header
$headers = [
    'Content-Type: application/x-www-form-urlencoded', // Set the content type
    'X-VERIFY: ' . $xverify, // Send the xverify in the headers
];

// Set cURL options
curl_setopt($ch, CURLOPT_RETURNTRANSFER, true);
curl_setopt($ch, CURLOPT_POST, true);
curl_setopt($ch, CURLOPT_POSTFIELDS, http_build_query($post_data)); // Use http_build_query to format POST data
curl_setopt($ch, CURLOPT_HTTPHEADER, $headers); // Ensure headers are correctly set

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
    "result": {
        "withdraw_id": "PAYOUT123",
        "time": 1716729846
    }
}
</pre>

<p><span class="method">RESPONSE (Error)</span></p>
<pre>
{
    "status": false,
    "message": "Insufficient Balance",
}
</pre>

    </section>
            
    </div>
    
        <h2>Create UPI Payout</h2>
        <div class="endpoint">
            <p><span class="method">POST</span> <code>/api/upi/create-order</code></p>
            
            <h3>Request Parameters</h3>
            <table>
            <tr>
                <th>Parameter</th><th>Type</th><th>Description</th>
            </tr>
            <tr>
                <td >user_token</td><td >string</td><td >The user's API Key.</td>
            </tr>
            <tr>
                <td >amount</td><td >float</td><td >The amount to be paid.</td>
            </tr>
            <tr>
                <td>upi_id</td><td>string</td><td>The Upi Id of the recipient.</td>
            </tr>
        </table>
        
        <h3>Request Headers</h3>
            <table>
                <tr><th>Parameter</th><th>Type</th><th>Description</th></tr>
                <tr><td>X-VERIFY</td><td>String</td><td>To Verify Data Integrity.</td></tr>
            </table>
            
            
            <h3>Formula for Generating X-VERIFY</h3>
            <pre>X-VERIFY = hash_hmac('sha256', dataString, secret_key)</pre>
            
            <p style="color: black; font-weight: bold;">Where:</p>
            
            <ul>
                <li style="color: black; font-weight: bold;"><strong>dataString</strong> is a string formed by concatenating parameter names and values in the format <code>parameter1=value1|parameter2=value2|...</code>, sorted by parameter names.</li>
                <li style="color: black; font-weight: bold;"><strong>secret_key</strong> is the user's secret key used for generating the HMAC.</li>
            </ul>
            
            <h3>Response</h3>
            <table>
                <tr><th>Parameter</th><th>Type</th><th>Description</th></tr>
                <tr><td>status</td><td>boolean</td><td>Indicates whether the API request was successful or failed.</td></tr>
                <tr><td>result</td><td>object</td><td>Contains result related to the successful API request (if status is true).</td></tr>
                <tr><td>message</td><td>string</td><td>Error message describing the reason for API failure.</td></tr>
            </table>
            
            <section>
        <p><span class="method">REQUEST</span></p>
        <pre>&lt;?php
// API URL
$api_url = 'https://couponcart.in/api/bank/create-order';

// User input
$user_token = '4b08d135be18fd929fcb254620d6acc5'; // Replace with the user's API token
$amount = 100; // Replace with the payout amount
$upiid= "test@paytm"; // Replace with upi id
$secret_key = 'ngOxcT3sR0zSk0uPZfZvihgoM0RIrBE2'; // Your secret key for checksum generation 

// Create an array with POST data
$post_data = [
    'user_token' => $user_token,
    'amount' => $amount,
    'upi_id' => $upiid
];

// Function to generate xverify
function generatexverify($data, $secret_key) {
  // Sort the data by keys to ensure consistent order
  ksort($data);
  $dataString = implode('|', array_map(function ($key, $value) {
      return $key . '=' . $value;
  }, array_keys($data), $data));
  return hash_hmac('sha256', $dataString, $secret_key);
}

// Generate xverify
$xverify = generatexverify($post_data, $secret_key);

// Initialize cURL session
$ch = curl_init($api_url);

// Prepare the headers including the X-Verify custom header
$headers = [
    'Content-Type: application/x-www-form-urlencoded', // Set the content type
    'X-VERIFY: ' . $xverify, // Send the xverify in the headers
];

// Set cURL options
curl_setopt($ch, CURLOPT_RETURNTRANSFER, true);
curl_setopt($ch, CURLOPT_POST, true);
curl_setopt($ch, CURLOPT_POSTFIELDS, http_build_query($post_data)); // Use http_build_query to format POST data
curl_setopt($ch, CURLOPT_HTTPHEADER, $headers); // Ensure headers are correctly set

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
    "result": {
        "withdraw_id": "PAYOUT123",
        "time": 1716729846
    }
}
</pre>

<p><span class="method">RESPONSE (Error)</span></p>
<pre>
{
    "status": false,
    "message": "Insufficient Balance",
}
</pre>

    </section>
            
</div>


        <h2>Check Payout Status</h2>
        <div class="endpoint">
            <p><span class="method">POST</span> <code>/api/payout-status</code></p>
            

        <table>
            <tr>
                <th>Parameter</th><th>Type</th><th>Description</th>
            </tr>
            <tr>
                <td>user_token</td><td>string</td><td>The user's API Key.</td>
            </tr>
            <tr>
                <td>withdraw_id</td><td>string</td><td>The ID of the payout to check.</td>
            </tr>
            <tr>
                <td>payout_type</td><td>string</td><td>The Type of the payout to check.</td>
            </tr>
        </table>
        
        <p style="color: black; font-weight: bold;" >This API allows you to verify the status of a payout by providing the <strong>withdraw_id</strong>.</p>
            
            
            <section>
                       <p><span class="method">POST</span></p>     
        <pre>&lt;?php
// Define the API endpoint URL
$api_url = 'https://couponcart.in/api/payout-status'; // Replace with the actual API endpoint URL

// User input - Replace 'your_user_token_here' with the actual API token
$user_token = '1234'; // Replace with your API token
$withdraw_id = 'pZcaX1694233009'; // Replace with the Withdraw ID you want to check

// Create an array with POST data
$post_data = [
    'user_token' => $user_token, // Make sure this contains your API token
    'withdraw_id' => $withdraw_id,
    'payout_type' => "upi",  //for bank use "bank" for upi use "upi"
];

// Initialize cURL session
$ch = curl_init($api_url);

// Set cURL options
curl_setopt($ch, CURLOPT_RETURNTRANSFER, true);
curl_setopt($ch, CURLOPT_POST, true);
curl_setopt($ch, CURLOPT_POSTFIELDS, http_build_query($post_data)); // Use http_build_query to format as x-www-form-urlencoded
curl_setopt($ch, CURLOPT_HTTPHEADER, [
    'Content-Type: application/x-www-form-urlencoded', // Set the content type here
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
    "message": "Withdraw Successfully", //for Pending Withdraw Pending
    "result": {
        "txnStatus": "SUCCESS", //For Pending PENDING
        "withdraw_id": "WMNJG1715431835",
        "amount": "1",
        "date": "2024-01-12 13:22:08"
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
  <!--end main wrapper-->


  <!--plugins-->
  <script src="assets/js/jquery.min.js"></script>
  <!--plugins-->
  <script src="assets/plugins/perfect-scrollbar/js/perfect-scrollbar.js"></script>
  <script src="assets/plugins/metismenu/metisMenu.min.js"></script>
  <script src="assets/plugins/simplebar/js/simplebar.min.js"></script>
  <script src="assets/js/main.js"></script>


</body>

</html>