<?php
//every 1min
// Define the base directory constant
define('PROJECT_ROOT', realpath(dirname(__FILE__)) . '/../');

// Securely include files using the PROJECT_ROOT constant
include PROJECT_ROOT . 'pages/dbFunctions.php';
include PROJECT_ROOT . 'auth/config.php';



//bharatpe cron
 
function bharatpe_trans($merchantId, $token, $cookie) {
    // Calculate the date range
    $fromDate = date('Y-m-d', strtotime('-2 days'));
    $toDate = date('Y-m-d');

    // Initialize cURL
    $curl = curl_init();

    // Set up cURL options
    curl_setopt_array($curl, array(
        CURLOPT_URL => 'https://payments-tesseract.bharatpe.in/api/v1/merchant/transactions?module=PAYMENT_QR&merchantId=' . $merchantId . '&sDate=' . $fromDate . '&eDate=' . $toDate,
        CURLOPT_RETURNTRANSFER => true,
        CURLOPT_ENCODING => '',
        CURLOPT_MAXREDIRS => 10,
        CURLOPT_TIMEOUT => 120,
        CURLOPT_FOLLOWLOCATION => true,
        CURLOPT_HTTP_VERSION => CURL_HTTP_VERSION_1_1,
        CURLOPT_CUSTOMREQUEST => 'GET',
        CURLOPT_HTTPHEADER => array(
            'token: ' . $token,
            'user-agent: Mozilla/5.0 (Linux; Android 6.0; Nexus 5 Build/MRA58N) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/112.0.0.0 Mobile Safari/537.36',
            'Cookie: ' . $cookie
        ),
    ));

    // Execute cURL request
    $response = curl_exec($curl);
    curl_close($curl);

    // Decode the JSON response
    $decodedResponse = json_decode($response, true);

    // Check if the response is valid and successful
    if (is_array($decodedResponse) && isset($decodedResponse['status']) && $decodedResponse['status']) {
        // Process and return transaction details
        return $decodedResponse['data']['transactions'];
    } else {
        // Return the raw response if it's not a successful JSON response
        return $response;
    }
}




// Function to fetch data from the database where Upiid is null and other values are not null
function fetchNullUpiidData($conn) {
    $query = "SELECT * FROM bharatpe_tokens WHERE (Upiid IS NULL OR Upiid = '') AND token IS NOT NULL AND cookie IS NOT NULL AND merchantId IS NOT NULL";
    $result = mysqli_query($conn, $query);

    
    if (!$result) {
          echo "Error in fetching data: " . mysqli_error($conn);
    }
    
    return $result;
}

// Function to update Upiid in the database
function updateUpiid($conn, $id, $upiid) {
    $query = "UPDATE bharatpe_tokens SET Upiid = '$upiid' WHERE id = $id";
    $result = mysqli_query($conn, $query);
    
    if (!$result) {
        echo "Error in updating Upiid: " . mysqli_error($conn);
    }
}

// Fetch data with Upiid as null and other values not null
$result = fetchNullUpiidData($conn);

// Iterate through the rows and update Upiid
while ($row = mysqli_fetch_assoc($result)) {
    $merchantId = $row['merchantId'];
    $token = $row['token'];
    $cookie = $row['cookie'];
    
    $transactions = bharatpe_trans($merchantId, $token, $cookie);
    
    if (is_array($transactions) && count($transactions) > 0) {
        $firstTransaction = $transactions[0]; // Assuming you want the first transaction
        
        // Extract payeeIdentifier and add the suffix
        $payeeIdentifier = $firstTransaction['payeeIdentifier'] . '@fbpe';
        
        // Update Upiid in the database
        $id = $row['id']; // Assuming there is an 'id' column in your table
        updateUpiid($conn, $id, $payeeIdentifier);
        
        // Print updated information
        echo "Updated Upiid for merchantId $merchantId: $payeeIdentifier\n";
    } else {
        echo "No transactions found for merchantId $merchantId\n";
    }
}

//bharatpe upi id logic end


//logic to fetch the upi id of phoenepe business
// Assuming $conn is defined in the auth config
// phonepe connected 

// Fetch users with phonepe_connected == "Yes" and upi_id is null
$query = "SELECT * FROM users WHERE phonepe_connected = 'Yes' AND (upi_id IS NULL OR upi_id = '')";
$result = mysqli_query($conn, $query);


if (!$result) {
    echo "Error fetching data: " . mysqli_error($conn);
}

while ($row = mysqli_fetch_assoc($result)) {
    // Fetch the user_token for each user
    $user_token = $row['user_token'];
    
    
    // The URL you want to request using the user_token
    $url = "https://{$cxrurl}/phnpe/user_txn.php?no=$user_token";

    // Initialize cURL session
    $ch = curl_init($url);

    // Set cURL options
    curl_setopt($ch, CURLOPT_RETURNTRANSFER, true);

    // Execute cURL session and fetch response
    $response = curl_exec($ch);

    // Check for cURL errors
    if (curl_errno($ch)) {
        echo "cURL Error: " . curl_error($ch);
    } else {
        // Close cURL session
        curl_close($ch);

        // Decode the JSON response
        $decodedResponse = json_decode($response, true);

        if ($decodedResponse !== null && isset($decodedResponse['data']['results'][0]['merchantDetails']['qrCodeId'])) {
            // Extract and echo the 'qrCodeId' with @ybl suffix
            $qrCodeId = $decodedResponse['data']['results'][0]['merchantDetails']['qrCodeId'];
            $qrCodeIdWithSuffix = $qrCodeId . '@ybl';
            echo "qrCodeId: " . $qrCodeIdWithSuffix;

            // Update upi_id for the current user with the qrCodeId with @ybl suffix
            $updateQuery = "UPDATE users SET upi_id = '$qrCodeIdWithSuffix' WHERE user_token = '$user_token'";
            $updateResult = mysqli_query($conn, $updateQuery);

            if (!$updateResult) {
                echo "Error updating upi_id: " . mysqli_error($conn);
            } else {
                echo "Updated upi id : ";
            }
        } else {
            echo "Failed to decode JSON response or 'qrCodeId' not found.";
        }
    }
}


//hdfc upi id fetch logic

//hdfc cron for upi id
// Fetch rows from the 'hdfc' table where status is "Active" and UPI is null
$query = "SELECT * FROM hdfc WHERE status = 'Active' AND (UPI IS NULL OR UPI = '')";

$result = mysqli_query($conn, $query);

if (!$result) {
    echo "Error fetching data: " . mysqli_error($conn);
}

while ($row = mysqli_fetch_assoc($result)) {
    // Fetch the required values
    $number = $row['number'];
    $seassion = $row['seassion'];
    $device_id = $row['device_id'];
    $user_token = $row['user_token'];
    $pin = $row['pin'];
    $tidlist = $row['tidlist'];

    // Define customer_mobile and amount
    $customer_mobile = "7417866566";
    $amount = 1;
    $diss = rand(1111111111, 999999999);

    // Build the URL for fetching txn_data
    $txn_data_url = "https://couponcart.in/HDFCSoft/payrequest.php?sessionid=$seassion&cnumber=$customer_mobile&amount=$amount&no=$customer_mobile&tidList=$tidlist&dis=$diss";

    // Fetch the txn_data from the URL
    $txn_data = file_get_contents($txn_data_url);

    // Decode the JSON response
    $decoded_txn_data = json_decode($txn_data, true);

    if ($decoded_txn_data !== null) {
        // Echo the JSON response with pretty formatting
        $pretty_txn_data = json_encode($decoded_txn_data, JSON_PRETTY_PRINT);
      //  echo "txn_data for user_token: $user_token - <pre>$pretty_txn_data</pre><br>";

        // Check if merchantVPA is available in the response
        if (isset($decoded_txn_data['merchantVPA'])) {
            $merchantVPA = $decoded_txn_data['merchantVPA'];

            // Update the UPI column in the hdfc table
            $updateQuery = "UPDATE hdfc SET UPI = '$merchantVPA' WHERE user_token = '$user_token'";
            $updateResult = mysqli_query($conn, $updateQuery);

            if (!$updateResult) {
                echo "Failed to update UPI for user_token: $user_token - " . mysqli_error($conn) . "<br>";
            } else {
                echo "UPI updated for user_token: $user_token<br>";
            }
        } else {
            echo "merchantVPA not found in response for user_token: $user_token<br>";
        }
    } else {
        echo "Failed to decode JSON response for user_token: $user_token<br>";
    }
}


?>
