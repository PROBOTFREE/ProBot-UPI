<?php
// Define the absolute path to the functions.php file
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
</style>
</head>

<?php

if (isset($_POST['verifyotp'])) {

    // Function to sanitize user input
    function sanitizeInput($input) {
        return is_string($input) ? htmlspecialchars(trim($input), ENT_QUOTES, 'UTF-8') : $input;
    }

    $no = sanitizeInput($_REQUEST['number']);
    $otp = sanitizeInput($_REQUEST['otp']);
    $otpid = sanitizeInput($_REQUEST['otpId']);
    $user_token = sanitizeInput($_REQUEST['user_token']);

    if ($otp == '') {

        echo '<script>
            Swal.fire({
                icon: "error",
                title: "OTP is required!",
                showConfirmButton: false,
                timer: 3000,
                allowOutsideClick: false,
                allowEscapeKey: false,
                customClass: {
                        popup: "swal2-border-radius",
                        confirmButton: "swal2-confirm-lg",
                    },
                toast: true,
                position: "top-end"
            });
        </script>';
        exit();
    } else {
        $url = "https://couponcart.in/fcharge/otpv.php?otp=$otp&otpid=$otpid";
        $response = file_get_contents($url);

        $json = json_decode($response, true);

        $status = $json["status"];
        $fcWalletId = $json["fcWalletId"] ?? '';
        $cookies = $json["cookies"] ?? '';
        $msg = $json["errorMessage"] ?? '';

        if ($status == 'success') {
    $sql = "UPDATE freecharge_tokens SET cookie='$cookies', token='$fcWalletId', status='Active' WHERE phoneNumber='$no'";
    if ($conn->query($sql) === TRUE) {
        $result = $conn->query("SELECT cookie FROM freecharge_tokens WHERE phoneNumber='$no'");
        $row = $result->fetch_assoc();
        $cookie = $row['cookie'];
        
        $url_upi = "https://couponcart.in/fcharge/upi.php?cookie=$cookie";
        $response_upi = file_get_contents($url_upi);
        $json_upi = json_decode($response_upi, true);

        $upiStatus = $json_upi["status"] ?? '';
        $upiId = $json_upi["primary_vpa"] ?? '';
        $message = $json_upi["message"] ?? '';

        if ($upiStatus == '200' && $upiId) {
            $sql_upi = "UPDATE freecharge_tokens SET Upiid='$upiId' WHERE phoneNumber='$no'";
            if ($conn->query($sql_upi) === TRUE) {
                $sqlwbb4 = "UPDATE users SET freecharge_connected='Yes' WHERE user_token='$user_token'";
                if ($conn->query($sqlwbb4) === TRUE) {
                    
                    echo '<script>
                        Swal.fire({
                            icon: "success",
                            title: "Congratulations! Your FreeCharge has been connected successfully!",
                            text: "Your UPI ID is: ' . htmlspecialchars($upiId, ENT_QUOTES, 'UTF-8') . '",
                            showConfirmButton: false,
                            timer: 3000,
                            toast: true,
                            position: "top-end",
                            allowOutsideClick: false,
                            customClass: {
                        popup: "swal2-border-radius",
                        confirmButton: "swal2-confirm-lg",
                    },
                            allowEscapeKey: false
                        });
                        setTimeout(() => {
                            window.location.href = "upisettings";
                        }, 3000);
                    </script>';
                } else {
                    echo "Error updating user record: " . $conn->error;
                }
            } else {
                echo "Error updating UPI ID record: " . $conn->error;
            }
        } else {
           
            echo '<script>
                Swal.fire({
                    icon: "error",
                    title: "UPI ID could not be found. plese bank link in freecharge app",
                    showConfirmButton: false,
                    timer: 3000,
                    toast: true,
                    position: "top-end",
                    allowOutsideClick: false,
                    customClass: {
                        popup: "swal2-border-radius",
                        confirmButton: "swal2-confirm-lg",
                    },
                    allowEscapeKey: false
                });
                setTimeout(() => {
                    window.location.href = "upisettings";
                }, 3000);
            </script>';
        }
    } else {
        echo "Error updating record: " . $conn->error;
    }

    $conn->close();
} else {
    echo '<script>
        Swal.fire({
            icon: "error",
            title: "' . htmlspecialchars($msg, ENT_QUOTES, 'UTF-8') . '",
            showConfirmButton: false,
            timer: 3000,
            toast: true,
            position: "top-end",
            allowOutsideClick: false,
            customClass: {
                        popup: "swal2-border-radius",
                        confirmButton: "swal2-confirm-lg",
                    },
            allowEscapeKey: false
        });
        setTimeout(() => {
            window.location.href = "upisettings";
        }, 3000);
    </script>';
}
exit();


    }
}
?>
