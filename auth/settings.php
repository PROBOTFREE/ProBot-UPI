<?php
// PHP code
echo '<script src="https://cdn.jsdelivr.net/npm/sweetalert2@11"></script>';

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
    <link rel="stylesheet" type="text/css" href="assets/plugins/simplebar/css/simplebar.css">
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
    
    <!-- SweetAlert2 -->
    <script src="https://cdn.jsdelivr.net/npm/sweetalert2@11"></script>
  

</head>


<?php


// Initialize variables for API token and secret key
// Initialize variables for API token, secret key, and additional user information
$apiToken = '';
$secretKey = '';
$name = '';
$email = '';
$accountStatus = '';
$walletBalance = 0.00;
$totpUser = '';

// Retrieve the current API token, secret key, and additional user information from the database based on id
$userId = $_SESSION['user_id']; // Get the user's ID from the session
$sql = "SELECT telegram_subscribed,telegram_username, wallet, email, acc_ban, company, totp_user FROM users WHERE id = ?";

// Prepare the SQL statement
$stmt = $conn->prepare($sql);

// Bind the user_id parameter
$stmt->bind_param("i", $userId);

// Execute the query
$stmt->execute();

// Bind the result to variables
$stmt->bind_result($telegram_subscribed,$telegram_username , $walletbal, $email, $accountStatus, $company, $totpUser);

// Fetch the result
$stmt->fetch();


// Close the statement
$stmt->close();

if ($telegram_subscribed=="on"){
    $telegram_subscribed="Active";
}
else{
    $telegram_subscribed="Inactive";
}

if (isset($_REQUEST['change_password'])) {
    
 

    // Assuming $mobile is already defined in header.php
    $sanitizedMobile = mysqli_real_escape_string($conn, $mobile);
    
    // Sanitize input using mysqli_real_escape_string
    $current_password = mysqli_real_escape_string($conn, $_REQUEST['current_password']);
    $new_password = mysqli_real_escape_string($conn, $_REQUEST['new_password']);
    $confirm_password = mysqli_real_escape_string($conn, $_REQUEST['confirm_password']);

    // Retrieve the hashed password from the database
    $query = "SELECT `password` FROM `users` WHERE `mobile` = '$sanitizedMobile'";
    $result = mysqli_query($conn, $query);
    
    if ($result) {
        $row = mysqli_fetch_assoc($result);
        $hashedPasswordFromDB = $row['password'];
        
        // Check if the current password matches the stored hashed password
        if (password_verify($current_password, $hashedPasswordFromDB)) {
            if ($new_password === $confirm_password) {
                // Hash the new password using bcrypt
                $newpass = password_hash($new_password, PASSWORD_DEFAULT);
                
                // Update the password in the database
                $passwor = "UPDATE `users` SET `password` = '$newpass' WHERE `mobile` = '$sanitizedMobile'";
                $up = mysqli_query($conn, $passwor);
                
                if ($up) {
                    // Password changed successfully
                    echo '<script>
                        Swal.fire({
                            icon: "success",
                            title: "Password Changed Successfully",
                            text: "Your password has been updated.",
                            showConfirmButton: true,
                            confirmButtonText: "Ok",
                            customClass: {
                        popup: "swal2-border-radius",
                        confirmButton: "swal2-confirm-lg",
                    },
                        }).then((result) => {
                            if (result.isConfirmed) {
                                window.location.href = "settings";
                            }
                        });
                    </script>';
                    exit;
                } else {
                    // Password update failed, handle the error
                    echo '<script>
                        Swal.fire({
                            icon: "error",
                            title: "Password Update Failed",
                            text: "Please try again later.",
                            showConfirmButton: true,
                            confirmButtonText: "Try Again",
                            customClass: {
                        popup: "swal2-border-radius",
                        confirmButton: "swal2-confirm-lg",
                    },
                        }).then((result) => {
                            if (result.isConfirmed) {
                                window.location.href = "settings";
                            }
                        });
                    </script>';
                    exit;
                }
            } else {
                // New Password and Confirm Password do not match
                echo '<script>
                    Swal.fire({
                        icon: "error",
                        title: "New Password and Confirm Password Do Not Match",
                        showConfirmButton: true,
                        confirmButtonText: "Try Again",
                        customClass: {
                        popup: "swal2-border-radius",
                        confirmButton: "swal2-confirm-lg",
                    },
                    }).then((result) => {
                        if (result.isConfirmed) {
                            window.location.href = "settings";
                        }
                    });
                </script>';
                exit;
            }
        } else {
            // Current Password does not match
            echo '<script>
                Swal.fire({
                    icon: "error",
                    title: "Current Password Does Not Match",
                    showConfirmButton: true,
                    confirmButtonText: "Try Again",
                    customClass: {
                        popup: "swal2-border-radius",
                        confirmButton: "swal2-confirm-lg",
                    },
                }).then((result) => {
                    if (result.isConfirmed) {
                        window.location.href = "settings";
                    }
                });
            </script>';
            exit;
        }
    } else {
        // Database query error
        echo '<script>
            Swal.fire({
                icon: "error",
                title: "Please try again later.",
                text: "Please try again later.",
                showConfirmButton: true,
                confirmButtonText: "Try Again",
                customClass: {
                        popup: "swal2-border-radius",
                        confirmButton: "swal2-confirm-lg",
                    },
            }).then((result) => {
                if (result.isConfirmed) {
                    window.location.href = "settings";
                }
            });
        </script>';
        exit;
    }
}


?>

<!--start main wrapper-->
<main class="main-wrapper">
    <div class="main-content">
        <!--breadcrumb-->
        <div class="page-breadcrumb d-none d-sm-flex align-items-center mb-3">
            <div class="breadcrumb-title pe-3">Settings</div>
            <div class="ps-3">
                <nav aria-label="breadcrumb">
                    <ol class="breadcrumb mb-0 p-0">
                        <li class="breadcrumb-item"><a href="javascript:;"><i class="bx bx-home-alt"></i></a>
                        </li>
                        <li class="breadcrumb-item active" aria-current="page">My Profile</li>
                    </ol>
                </nav>
            </div>
        </div>
        <!--end breadcrumb-->

        <div class="row">
            <div class="col-12 col-xl-6">
                <div class="card">
                    <div class="card-body p-4">
                        <h5 class="mb-4">My Information & Details</h5>
                        <form class="row g-3" form method="POST">
                             <div class="col-md-12">
                                <label for="input5" class="form-label">Company Name</label>
                                <input type="text" class="form-control" id="input5" value="<?php echo $company; ?>" readonly >
                            </div>
                            <div class="col-md-12">
                                <label for="input3" class="form-label">Wallet Balance</label>
                                <input type="text" class="form-control" id="input3" value="₹<?php echo $walletbal; ?>" readonly>
                            </div>
                            <div class="col-md-12">
                                <label for="input4" class="form-label">Email</label>
                                <input type="email" class="form-control" id="input4" value="<?php echo $email; ?>" readonly>
                            </div>
                            <div class="col-md-12">
                                <label for="input5" class="form-label">Telegram Username</label>
                                
                                <input type="text" class="form-control" name="secret_key" id="input7" value="<?php echo $telegram_username; ?>" readonly>
                            </div>
                            <div class="col-md-12">
                                <label for="input5" class="form-label">Telegram Notifications</label>
                                <input type="text" class="form-control" name="api_token" id="input6" value="<?php echo $telegram_subscribed; ?>" readonly>
                            </div>
                            
                            
                        </form>
                    </div>
                </div>
            </div>
            <div class="col-12 col-xl-6">
                <div class="card">
                    <div class="card-body p-4">
                        <h5 class="mb-4">Password Settings & 2FA</h5>
                        <form class="row g-3" form method="POST">
                            <div class="col-md-12">
                                <label for="input15" class="form-label">Account Status</label>
                                <div class="position-relative input-icon">
                                    <input type="text" class="form-control" id="input14" value="<?php echo ($accountStatus == "off") ? 'Active' : 'Inactive'; ?>" readonly>
                                    <span class="position-absolute top-50 translate-middle-y"><i
                                            class="material-symbols-rounded fs-5">person_outline</i></span>
                                </div>
                            </div>
                            
                            <div class="col-md-12">
                                <label for="input15" class="form-label">2Factor Authentication Status</label>
                                <div class="position-relative input-icon">
                                    <input type="text" class="form-control" id="input15" value="<?php echo ($totpUser == "on") ? 'Active' : 'Inactive'; ?>" readonly>
                                    <span class="position-absolute top-50 translate-middle-y"><i
                                            class="material-symbols-rounded fs-5">person_outline</i></span>
                                </div>
                            </div>
                            <div class="col-md-12">
                                <label for="input17" class="form-label"> Old Password</label>
                                <div class="position-relative input-icon">
                                    <input type="password" class="form-control" id="input17" placeholder="Old Password" name="current_password">
                                    <span class="position-absolute top-50 translate-middle-y"><i
                                            class="material-symbols-rounded fs-5">lock_open</i></span>
                                </div>
                            </div>
                            <div class="col-md-12">
                                <label for="input18" class="form-label">New Password</label>
                                <div class="position-relative input-icon">
                                    <input type="text" class="form-control" id="input18" placeholder="New Password" name="new_password">
                                    <span class="position-absolute top-50 translate-middle-y"><i
                                            class="material-symbols-rounded fs-5">lock_open</i></span>
                                </div>
                            </div>
                            <div class="col-md-12">
                                <label for="input16" class="form-label">Confirm New Password</label>
                                <div class="position-relative input-icon">
                                    <input type="text" class="form-control" id="input16" placeholder="New Password" name="confirm_password">
                                    
                                 
                                    <span class="position-absolute top-50 translate-middle-y"><i
                                            class="material-symbols-rounded fs-5">lock_open</i></span>
                                </div>
                            </div>
                            
                            
                            
                            
                            <div class="col-md-12">
                                <div class="d-md-flex d-grid align-items-center gap-3">
                                    <button type="submit" name="change_password" class="btn btn-primary px-4">Submit</button>
                                </div>
                            </div>
                        </form>
                    </div>
                </div>
            </div>
        </div><!--end row-->
    </div>
</main>
<!--end main wrapper-->

<script>
function refreshPage() {
    location.reload();
}
</script>

<!--plugins-->
<script src="assets/js/jquery.min.js"></script>
<!--plugins-->
<script src="assets/plugins/perfect-scrollbar/js/perfect-scrollbar.js"></script>
<script src="assets/plugins/metismenu/metisMenu.min.js"></script>
<script src="assets/plugins/datatable/js/jquery.dataTables.min.js"></script>
<script src="assets/plugins/datatable/js/dataTables.bootstrap5.min.js"></script>

<script src="assets/plugins/simplebar/js/simplebar.min.js"></script>
<script src="assets/js/main.js"></script>


</body>

</html>

