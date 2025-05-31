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

if ($userdata['totp_user'] == 'on') {
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
                window.location.href = "dashboard";
            }
        });
    </script>';
    exit;
} elseif ($userdata['totp_user'] == 'off') {
    // Your project, make sure to change this to your actual domain or identifier
    $projectName = 'ProbotUpi';
    $encodedSecret = $userdata['totp_secret'];

    // Generate the URL for the QR code
    $issuer = rawurlencode($projectName); // Use rawurlencode instead of urlencode
    $userEmail = rawurlencode($userdata['name']); // User's email or unique identifier
    $qrData = "otpauth://totp/{$issuer}:{$userEmail}?secret={$encodedSecret}&issuer={$issuer}";

    // URL encode the QR data
    $qrDataEncoded = urlencode($qrData);

    // QR code API URL
    $qrApiUrl = "https://api.qrserver.com/v1/create-qr-code/?size=200x200&data={$qrDataEncoded}";

    // SweetAlert2 code to display QR code and OTP form
    echo '<script src="https://cdn.jsdelivr.net/npm/sweetalert2@11.0.18"></script>';
    echo '<script>
        Swal.fire({
            title: "Scan this code in your Authenticator app", // Message to display above the QR code
            html: "<img src=\"' . $qrApiUrl . '\" alt=\"QR Code\">", // QR code image and message
            showConfirmButton: true,
            confirmButtonText: "Confirm", // Text for the confirm button
            showCancelButton: false, // Hide the cancel button
            allowOutsideClick: false,
            allowEscapeKey: false
        }).then((result) => {
            if (result.isConfirmed) {
                // SweetAlert2 code for OTP submission
                Swal.fire({
                    title: "Enter OTP",
                    html: `<form id="otpForm" action="2faconfirm" method="post">
                                <input type="text" id="otp" name="otp" class="swal2-input" maxlength="6" minlength="6" placeholder="Enter OTP" required pattern="[0-9]*" oninput="this.value = this.value.replace(/[^0-9]/g, \'\');">
                                <input type="submit" style="display: none;"> <!-- Hide the submit button -->
                        
                               
                            </form>`,
                    confirmButtonText: "Submit",
                    focusConfirm: false,
                    preConfirm: () => {
                        document.getElementById("otpForm").submit(); // Submit the form when the user clicks "Submit" in the dialog
                    }
                });
            }
        });
    </script>';
    
    exit;
}
?>
