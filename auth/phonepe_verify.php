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
</head>
<style>
    .swal2-custom-popup {
        max-width: 600px;
        padding: 2em;
        border-radius: 10px;
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
<?php
include "../pages/dbFunctions.php";
include "../pages/dbInfo.php";
include "../phnpe/index.php";

if(isset($_POST['verifyotp'])){ // received from last page send_phonepeotp
    
   
    // Use $_POST to retrieve data
    $otp = filter_var($_POST["otp"], FILTER_SANITIZE_STRING);
    $numbero = filter_var($_POST["no"], FILTER_SANITIZE_STRING);
    $upi = filter_var($_POST["upi"], FILTER_SANITIZE_STRING);
    $otp_toekn = filter_var($_POST["otp_toekn"], FILTER_SANITIZE_STRING);
    $device_data = filter_var($_POST["device_data"], FILTER_SANITIZE_STRING);
    $user_token = filter_var($_POST['user_token'], FILTER_SANITIZE_STRING);
    
    // OTP verification logic
    $otpferfyy = sentotp("2", $numbero, $otp, $otp_toekn, $device_data);
    $json0 = json_decode($otpferfyy, 1);
    $message = $json0["message"];
    $phoneNumber = $json0["number"];
    $userId = $json0["userId"];
    $token = $json0["token"];
    $refreshToken = $json0["refreshToken"];
    $name = $json0["name"];
    $device_datar = $json0["device_data"];
    $b = json_decode($otpferfyy);

    if ($message == "success") {
        $sql = "UPDATE users SET upi_id='$upi' WHERE user_token='$user_token'";
        setXbyY($sql);

        $sql = "DELETE FROM phonepe_tokens WHERE user_token='$user_token'";
        if ($conn->query($sql) === TRUE) {}

        $bbbyteuserid = $_SESSION['user_id'];
        $sql = "INSERT INTO phonepe_tokens (user_token, phoneNumber, userId, token, refreshToken, name, device_data, user_id)
                VALUES ('$user_token', '$phoneNumber', '$userId', '$token', '$refreshToken', '$name', '$device_data', $bbbyteuserid)";
        if ($conn->query($sql) === TRUE) {}

        $i = 0;
        $storeForms = '';
        while ($b->{'userGroupNamespace'}->{'All'}[$i]->{'merchantName'}) {
            $unitId = ($b->{'userGroupNamespace'}->{'All'}["$i"]->{'merchantName'});
            $roleName = ($b->{'userGroupNamespace'}->{'All'}["$i"]->{'roleName'});
            $groupValue = ($b->{'userGroupNamespace'}->{'All'}["$i"]->{'userGroupNamespace'}->{'groupValue'});
            $groupId = ($b->{'userGroupNamespace'}->{'All'}["$i"]->{'userGroupNamespace'}->{'groupId'});

            $storeForms .= "
            <form action='store' method='POST'>
                <input type='hidden' name='unitId' value='$unitId'>
                <input type='hidden' name='roleName' value='$roleName'>
                <input type='hidden' name='groupValue' value='$groupValue'>
                <input type='hidden' name='groupId' value='$groupId'>
                <input type='hidden' name='user_token' value='$user_token'>
                
                <button id='$unitId' name='$unitId' class='btn btn-primary mb-2'>$unitId</button>
            </form><br><br>";
            $i++;
        }

        echo '<script src="https://cdn.jsdelivr.net/npm/sweetalert2@11.0.18"></script>';
        echo '<script>
            Swal.fire({
                title: "Select Your Store",
                html: `' . $storeForms . '`,
                showCancelButton: false,
                showConfirmButton: false,
                customClass: {
                    popup: "swal2-custom-popup",
                    title: "swal2-title",
                    content: "swal2-content"
                },
                allowOutsideClick: false,
                allowEscapeKey: false
            });
        </script>';
        exit();
    } else {
        // Show SweetAlert2 error message
        echo '<script src="https://cdn.jsdelivr.net/npm/sweetalert2@11.0.18"></script>';
        echo '<script>
            Swal.fire({
                icon: "error",
                title: "Incorrect OTP, Please try again later",
                showConfirmButton: true,
                confirmButtonText: "Ok!",
                allowOutsideClick: false,
                allowEscapeKey: false
            }).then((result) => {
                if (result.isConfirmed) {
                    window.location.href = "upisettings";
                }
            });
        </script>';
        exit();
    }
}//verify otp isset from last page



else{
     echo '<script src="https://cdn.jsdelivr.net/npm/sweetalert2@11.0.18"></script>';
echo '<script>
    Swal.fire({
        icon: "error",
        title: "Form Not Submitted!!",
        showConfirmButton: true, // Show the confirm button
        confirmButtonText: "Ok!", // Set text for the confirm button
        allowOutsideClick: false, // Prevent the user from closing the popup by clicking outside
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