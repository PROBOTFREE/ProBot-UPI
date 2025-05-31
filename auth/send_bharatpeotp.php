<?php

// Dene the absolute path to the functions.php file
define('ABSPATH', dirname(__FILE__) . '/'); // Adjust the path as needed
// Include the database connection file
require_once(ABSPATH . 'header.php');


?>
<head>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <!--favicon-->
  <link rel="icon" href="assets/images/favicon-32x32.png" type="image/png">

  <!--plugins-->
  <link href="assets/plugins/perfect-scrollbar/css/perfect-scrollbar.css" rel="stylesheet">
  <link rel="stylesheet" type="text/css" href="assets/plugins/metismenu/metisMenu.min.css">
  <link rel="stylesheet" type="text/css" href="assets/plugins/metismenu/mm-vertical.css">
  <link rel="stylesheet" type="text/css" href="assets/plugins/simplebar/css/simplebar.css">
  <!--bootstrap css-->
  <link href="assets/css/bootstrap.min.css" rel="stylesheet">
  <link href="assets/plugins/datatable/css/dataTables.bootstrap5.min.css" rel="stylesheet" />
  <link href="https://fonts.googleapis.com/css2?family=Noto+Sans:wght@300;400;500;600&display=swap" rel="stylesheet">
  <link href="https://fonts.googleapis.com/css?family=Material+Symbols+Rounded" rel="stylesheet">
  <!--main css-->
  <link href="assets/css/bootstrap-extended.css" rel="stylesheet">
  <link href="sass/main.css" rel="stylesheet">
  <link href="sass/dark-theme.css" rel="stylesheet">
  <link href="sass/semi-dark.css" rel="stylesheet">
  <link href="sass/bordered-theme.css" rel="stylesheet">
  <link href="sass/responsive.css" rel="stylesheet">
  
   <!-- SweetAlert2 -->
    <script src="https://cdn.jsdelivr.net/npm/sweetalert2@11"></script>
  
  <style>
.swal2-border-radius {
    border-radius: 20px !important; /* Adjust the value as needed */
}
.swal2-confirm-lg {
        border-radius: 50px !important; /* Adjust the value as needed */
        font-size: 18px !important; /* Larger text */
        padding: 14px 40px !important; /* Increased width padding */
        min-width: 150px !important; /* Ensures wider button */
    }
    .swal2-input-radius{
        border-radius: 16px !important; /* Adjust the value as needed */
    }
    
    .swal2-custom-popup {
            max-width: 600px;
            padding: 2em;
            border-radius: 20px !important; /* Adjust the value as needed */
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
        }
        .swal2-title {
            font-size: 24px;
            margin-bottom: 1em;
            color: #333;
            font-weight: bold;
        }
        .swal2-content {
            text-align: left;
        }
        .swal2-content form {
            display: flex;
            flex-direction: column;
        }
        .swal2-content .row {
            display: flex;
            flex-wrap: wrap;
        }
        .swal2-content .col-md-12 {
            flex: 0 0 100%;
            max-width: 100%;
            padding: 0 15px;
            box-sizing: border-box;
        }
        .swal2-content label {
            font-weight: bold;
            color: #555;
            margin-bottom: 5px;
        }
        .swal2-content input {
            margin-top: 0.5em;
            padding: 0.5em;
            font-size: 16px;
            border: 1px solid #ccc;
            border-radius: 5px;
        }
        .swal2-content .btn-block {
            width: 100%;
            margin-top: 1em;
            padding: 0.75em;
            font-size: 16px;
            background-color: #007bff;
            border: none;
            border-radius: 5px;
            color: white;
            cursor: pointer;
        }
        .swal2-content .btn-block:hover {
            background-color: #0056b3;
        }
</style>

</head>



<?php

// Function to sanitize user input
    function sanitizeInput($input) {
        if (is_string($input)) {
            return htmlspecialchars(trim($input), ENT_QUOTES, 'UTF-8');
        } else {
            // Handle non-string input here (e.g., arrays, objects, etc.) if needed.
            return $input;
        }
    }


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

    // Return the decoded JSON response
    return $decodedResponse;
}






if(isset($_POST['verifyotp'])) {
    
   
    
    $bbbyteuserid=$_SESSION['user_id'];
    
  $bbytebharatpeuserid=  $userdata['user_token'];
  $bbytebharatpeusermid = sanitizeInput($_POST["MID"]);
  $bbytebharatpeusertoken= sanitizeInput($_POST["token"]);
  $bbytebharatpeusercookie= sanitizeInput($_POST["cookie"]);
  
    
    

// Call the function and store the response in a variable
// Call the function and store the response in a variable
$response = bharatpe_trans($bbytebharatpeusermid, $bbytebharatpeusertoken, $bbytebharatpeusercookie);

// Check if the response is an array or an object, then encode to JSON for readability
if (is_array($response) || is_object($response)) {
   // echo json_encode($response, JSON_PRETTY_PRINT);

    // Check if the response has 'message' as 'SUCCESS' and 'status' as true
    if (isset($response['message']) && $response['message'] === 'SUCCESS' &&
        isset($response['status']) && $response['status'] === true) {
        // Add your specific code here that should run when the condition is met
        // For example: echo "Condition met. Message is SUCCESS and status is true.";
        
        $bbytebharatpestatus=true;
    }

} else {
    // If it's not an array or an object, just echo the raw response
    $bbytebharatpestatus=false;
    //echo $response;
}


if($bbytebharatpestatus==true) {   
    
    
$sqlw = "UPDATE bharatpe_tokens SET merchantId='$bbytebharatpeusermid', token='$bbytebharatpeusertoken', status='Active', user_id=$bbbyteuserid, cookie='$bbytebharatpeusercookie' WHERE user_token='$bbytebharatpeuserid'";
$result = mysqli_query($conn, $sqlw);

 $sqlUpdateUser = "UPDATE users SET bharatpe_connected='Yes' WHERE user_token='$bbytebharatpeuserid'";
    $resultUpdateUser = mysqli_query($conn, $sqlUpdateUser);

   if ($result) {
      
echo '<script>
    Swal.fire({
        icon: "success",
        title: "Congratulations! Your Bharatpe Hasbeen Connected Successfully!",
        showConfirmButton: true, // Show the confirm button
        confirmButtonText: "Ok!", // Set text for the confirm button
        allowOutsideClick: false, 
        customClass: {
                        popup: "swal2-border-radius",
                        confirmButton: "swal2-confirm-lg",
                    },
        allowEscapeKey: false // Prevent the user from closing the popup by pressing Escape key
    }).then((result) => {
        if (result.isConfirmed) {
            window.location.href = "upisettings"; // Redirect to "upisettings" when the user clicks the confirm button
        }
    });
</script>';

    //exit;
    
    
} else {
    // Query failed
  //  echo "Error: " . mysqli_error($conn);
  
echo '<script>
    Swal.fire({
        icon: "error",
        title: "Please Try Again Later!!",
        showConfirmButton: true, // Show the confirm button
        confirmButtonText: "Ok!", // Set text for the confirm button
        allowOutsideClick: false, 
        customClass: {
                        popup: "swal2-border-radius",
                        confirmButton: "swal2-confirm-lg",
                    },
        allowEscapeKey: false // Prevent the user from closing the popup by pressing Escape key
    }).then((result) => {
        if (result.isConfirmed) {
            window.location.href = "upisettings"; // Redirect to "upisettings" when the user clicks the confirm button
        }
    });
</script>';
exit;

  
}

} elseif (!$bbytebharatpestatus){
    
echo '<script>
    Swal.fire({
        icon: "error",
        title: "Invaild BharatPe Details!!",
        showConfirmButton: true, // Show the confirm button
        confirmButtonText: "Ok!", // Set text for the confirm button
        allowOutsideClick: false, 
        customClass: {
                        popup: "swal2-border-radius",
                        confirmButton: "swal2-confirm-lg",
                    },
        allowEscapeKey: false // Prevent the user from closing the popup by pressing Escape key
    }).then((result) => {
        if (result.isConfirmed) {
            window.location.href = "upisettings"; // Redirect to "upisettings" when the user clicks the confirm button
        }
    });
</script>';
exit;
    
    
}
    
}

// bharatpe end verify


//form start

if(isset($_POST['Verify'])) {
    
   

    
    $bharatpe_mobile = sanitizeInput($_POST["bharatpe_mobile"]);
    
    
    if ($userdata['bharatpe_connected']=="Yes"){
        
         
echo '<script>
    Swal.fire({
        icon: "error",
        title: "Merchant Already Connected !!",
        showConfirmButton: true, // Show the confirm button
        confirmButtonText: "Ok!", // Set text for the confirm button
        allowOutsideClick: false, 
        customClass: {
                        popup: "swal2-border-radius",
                        confirmButton: "swal2-confirm-lg",
                    },
        allowEscapeKey: false // Prevent the user from closing the popup by pressing Escape key
    }).then((result) => {
        if (result.isConfirmed) {
            window.location.href = "upisettings"; // Redirect to "upisettings" when the user clicks the confirm button
        }
    });
</script>';
exit;

        
        
    }

    // Now, you can use the $bharatpe_mobile variable as needed
?>
    <script>
        Swal.fire({
            title: 'Bharatpe UPI Settings',
            html: `
                <form id="bharatpeForm" method="POST" action="<?php echo htmlspecialchars($_SERVER["PHP_SELF"]); ?>" class="mb-2">
                    <div class="row" id="merchant">
                        <div class="col-md-12 mb-2">
                            <label for="MID">Enter Merchant ID</label>
                            <input type="text" name="MID" id="MID" placeholder="Enter Merchant ID" class="form-control" required>
                        </div>
                        <div class="col-md-12 mb-2">
                            <label for="cookie">Enter BharatPe Cookie</label>
                            <input type="text" name="cookie" id="cookie" placeholder="Enter Bharatpe Cookie" class="form-control" required>
                        </div>
                        <div class="col-md-12 mb-2">
                            <label for="token">Enter BharatPe Token</label>
                            <input type="text" name="token" id="token" placeholder="Enter BharatPe Token" class="form-control" required>
                            
                        </div>
                        <div class="col-md-12 mb-2">
                            <button type="submit" name="verifyotp" class="btn btn-primary btn-block mt-2">Verify BharatPe</button>
                        </div>
                    </div>
                </form>
            `,
            showCancelButton: false,
            showConfirmButton: false,
            customClass: {
                popup: 'swal2-custom-popup',
                title: 'swal2-title',
                content: 'swal2-content',
                confirmButton: 'swal2-confirm-lg',
                cancelButton: 'swal2-confirm-lg',
            },
            allowOutsideClick: false,
            allowEscapeKey: false
        });
    </script>

    <?php
} // End of if(isset($_POST['Verify']))

else{
    
echo '<script>
    Swal.fire({
        icon: "error",
        title: "Form Not Submitted!!",
        showConfirmButton: true, // Show the confirm button
        confirmButtonText: "Ok!", // Set text for the confirm button
        allowOutsideClick: false, 
        customClass: {
                        popup: "swal2-border-radius",
                        confirmButton: "swal2-confirm-lg",
                    },
        allowEscapeKey: false // Prevent the user from closing the popup by pressing Escape key
    }).then((result) => {
        if (result.isConfirmed) {
            window.location.href = "upisettings"; // Redirect to "upisettings" when the user clicks the confirm button
        }
    });
</script>';
exit;
}
?>

  <!--plugins-->
  <script src="assets/js/jquery.min.js"></script>
  <!--plugins-->
  <script src="assets/plugins/perfect-scrollbar/js/perfect-scrollbar.js"></script>
  <script src="assets/plugins/metismenu/metisMenu.min.js"></script>
  <script src="assets/plugins/simplebar/js/simplebar.min.js"></script>
  <script src="assets/js/main.js"></script>


</body>

</html>