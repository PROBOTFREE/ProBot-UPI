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
if(isset($_POST['Verify'])){ //from last page
    
    if ($userdata['hdfc_connected']=="Yes"){
        // Show SweetAlert2 error message
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
        exit();
    }
    
    // Function to sanitize user input
    function sanitizeInput($input) {
        if (is_string($input)) {
            return htmlspecialchars(trim($input), ENT_QUOTES, 'UTF-8');
        } else {
            // Handle non-string input here (e.g., arrays, objects, etc.) if needed.
            return $input;
        }
    } 
    
    function curlGet2($url) {
        $ch = curl_init();
        curl_setopt($ch, CURLOPT_URL, $url); 
        curl_setopt($ch, CURLOPT_RETURNTRANSFER, true); 
        curl_setopt($ch, CURLOPT_SSL_VERIFYPEER, false); 
        $response = curl_exec($ch);
        if(curl_errno($ch)) {
            echo 'cURL error: ' . curl_error($ch);
        }
        curl_close($ch);
        return $response;
    }

    $no = filter_var($_REQUEST['hdfc_mobile'], FILTER_VALIDATE_INT);
    $url = 'https://' . $server . '/HDFCSoft/login.php?no=' . $no;
    $response = curlGet2($url);
    $json = json_decode($response, true);
    $status = $json["status"];
    $respMessage = $json["respMessage"];
    $sessionId = $json["sessionId"];
    $deviceid = $json["deviceid"];

    if ($status == 'Success') {
        // Show success message

        echo '<script>
            Swal.fire({
                title: "Your OTP Has Been Sent!!",
                text: "Please click Ok button!!",
                icon: "success",
                confirmButtonText: "Ok"
            }).then((result) => {
                if (result.isConfirmed) {
                    Swal.fire({
                        title: "HDFC UPI Settings",
                        html: `
                            <form id="hdfcForm" method="POST" action="hdfc_verify" class="mb-2">
                                <div class="row" id="merchant">
                                    <div class="col-md-12 mb-2">
                                        <label for="OTP">Enter OTP</label>
                                        <input type="number" name="OTP" id="OTP" placeholder="Enter OTP" class="form-control" required>
                                    </div>
                                    <div class="col-md-12 mb-2">
                                        <label for="PIN">Enter PIN</label>
                                        <input type="number" name="PIN" id="PIN" placeholder="Enter PIN" class="form-control" required>
                                    </div>
                                    <input type="hidden" name="number" value="' . $no . '">
                                    <input type="hidden" name="UPI" value="">
                                    <input type="hidden" name="user_token" value="' . $userdata['user_token'] . '">
                                  
                                    <input type="hidden" name="seassion" value="' . $sessionId . '">
                                    <input type="hidden" name="deviceid" value="' . $deviceid . '">
                                    <div class="col-md-12 mb-2">
                                        <button type="submit" name="verifyotp" class="btn btn-primary btn-block mt-2">Verify OTP</button>
                                    </div>
                                </div>
                            </form>
                        `,
                        showCancelButton: false,
                        showConfirmButton: false,
                        customClass: {
                            popup: "swal2-custom-popup",
                            title: "swal2-title",
                            content: "swal2-content",
                            confirmButton: "swal2-confirm-lg",
                            cancelButton: "swal2-confirm-lg",
                        },
                        allowOutsideClick: false,
                        allowEscapeKey: false
                    });
                }
            });
        </script>';
    } else {
        // Show SweetAlert2 error message
        
        echo '<script>
            Swal.fire({
                icon: "error",
                title: "' . $respMessage . '!",
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
        exit();
    }
} ////if(isset($_POST['Verify'])){ action from veirfy page


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
