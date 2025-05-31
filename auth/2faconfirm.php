<?php

// Dene the absolute path to the functions.php file
define('ABSPATH', dirname(__FILE__) . '/'); // Adjust the path as needed
// Include the database connection file
require_once(ABSPATH . 'header.php');

?>
<head>
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

</head>
<?php
$sanitizedMobile = mysqli_real_escape_string($conn, $mobile);
include "../pages/dbFunctions.php";
if ($userdata["totp_user"] == "on") {
    // Show SweetAlert2 error message
    echo '<script src="https://cdn.jsdelivr.net/npm/sweetalert2@11.0.18"></script>';
    echo '<script>
        Swal.fire({
            icon: "error",
            title: "2FA Already Setup!!",
            showConfirmButton: true,
            confirmButtonText: "Ok!",
            allowOutsideClick: false,
            allowEscapeKey: false
        }).then((result) => {
            if (result.isConfirmed) {
                window.location.href = "developers";
            }
        });
    </script>';
    exit();
} elseif ($userdata["totp_user"] == "off") {
    $encodedSecret = $userdata["totp_secret"];

    
    // Verify OTP
    if ($_SERVER["REQUEST_METHOD"] == "POST") {
        
    

        $userInputotp = $_POST["otp"];

        // Validate OTP
        if (strlen($userInputotp) == 6 && ctype_digit($userInputotp)) {
            // OTP is valid
            //echo "OTP validated successfully!";
        } else {
            // OTP is not valid
            echo "Invalid OTP!";
            // Exit if you want to stop further execution
            exit();
        }

        $currentOtp = totp($encodedSecret);

        if ($currentOtp == $userInputotp) {
            // OTP is valid, update 'users' table
            $updateQuery = "UPDATE users SET totp_user = 'on' WHERE mobile = '$sanitizedMobile'";
            if (mysqli_query($conn, $updateQuery)) {
                // Show SweetAlert2 success message
                echo '<script src="https://cdn.jsdelivr.net/npm/sweetalert2@11.0.18"></script>';
                echo '<script>
                    Swal.fire({
                        icon: "success",
                        title: "OTP Verified Authenticator Added Successfully!",
                        showConfirmButton: true,
                        confirmButtonText: "Ok!",
                        allowOutsideClick: false,
                        allowEscapeKey: false
                    }).then((result) => {
                        if (result.isConfirmed) {
                            window.location.href = "dashboard"; // Redirect to success page
                        }
                    });
                </script>';
                exit();
            } else {
                // Error updating the database
                echo '<script src="https://cdn.jsdelivr.net/npm/sweetalert2@11.0.18"></script>';
                echo '<script>
                    Swal.fire({
                        icon: "error",
                        title: "Error!",
                        text: "Try again later.",
                        showConfirmButton: true,
                        confirmButtonText: "Ok!",
                        allowOutsideClick: false,
                        allowEscapeKey: false
                    }).then((result) => {
                        if (result.isConfirmed) {
                            window.location.href = "2fa"; // Redirect to 2FA page
                        }
                    });
                </script>';
                exit();
            }
        } else {
            // OTP is invalid, show SweetAlert2 error message
            echo '<script src="https://cdn.jsdelivr.net/npm/sweetalert2@11.0.18"></script>';
            echo '<script>
    Swal.fire({
        icon: "error",
        title: "Invalid OTP!",
        text: "The OTP you entered is invalid. Please try again.",
        showConfirmButton: true,
        allowOutsideClick: false,
        allowEscapeKey: false
    }).then((result) => {
        if (result.isConfirmed) {
            window.location.href = "2fa"; // Redirect to 2FA page
        }
    });
</script>';
            exit();
        }
    } ///

    //if form is not submited then redirect to 2fa page
    // If form is not submitted, redirect to 2FA page
    // If form is not submitted, redirect to 2FA page with SweetAlert2 confirmation
    echo '<script src="https://cdn.jsdelivr.net/npm/sweetalert2@11.0.18"></script>';
    echo '<script>
    Swal.fire({
        icon: "info",
        title: "Redirecting to 2FA Page",
        text: "You are being redirected to the 2FA page.",
        showConfirmButton: false,
        timer: 2000, // Timer for auto close in milliseconds
        allowOutsideClick: false,
        allowEscapeKey: false
    }).then(() => {
        window.location.href = "2fa"; // Redirect to 2FA page
    });
</script>';
    exit();
}
?>
