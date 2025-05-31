<?php
// PHP code
echo '<script src="https://cdn.jsdelivr.net/npm/sweetalert2@11"></script>';

// Define the absolute path to the functions.php file
define('ABSPATH', dirname(__FILE__) . '/'); // Adjust the path as needed

require_once(ABSPATH . 'header.php');

require_once(ABSPATH . '../pages/dbFunctions.php');

// Initialize variables for API token and secret key
// Initialize variables for API token, secret key, and additional user information
$user_token = '';
$secret_key = '';
$callback_url = '';
$email = '';
$accountStatus = '';
$walletBalance = 0.00;
$totpUser = '';

// Retrieve the current API token, secret key, and additional user information from the database based on id
$userId = $_SESSION['user_id']; // Get the user's ID from the session
$sql = "SELECT user_token,secret_key, callback_url, email, acc_ban, company, totp_user FROM users WHERE id = ?";

// Prepare the SQL statement
$stmt = $conn->prepare($sql);

// Bind the user_id parameter
$stmt->bind_param("i", $userId);

// Execute the query
$stmt->execute();

// Bind the result to variables
$stmt->bind_result($user_token,$secret_key , $callback_url, $email, $accountStatus, $company, $totpUser);

// Fetch the result
$stmt->fetch();


// Close the statement
$stmt->close();
if (empty($callback_url)) {
    $callback_url = "No Webhook URL Is Set";
}

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

if (isset($_POST['generate_token'])) {
    $bbbyteuserid = (int) $_SESSION['user_id'];

    // Secure API Key Generation
    $key = generateApiKey(); 
    $secret_key = bin2hex(random_bytes(32)); 

    // Use a transaction to update all tables atomically
    $conn->begin_transaction();

    try {
        // Update users table securely
        $keyquery = "UPDATE `users` SET user_token=?, secret_key=? WHERE mobile=?";
        $stmt = $conn->prepare($keyquery);
        $stmt->bind_param("sss", $key, $secret_key, $mobile);
        $stmt->execute();
        $stmt->close();

        // List of tables that need updating
        $tables = ['orders', 'reports', 'hdfc', 'bharatpe_tokens', 'phonepe_tokens', 'store_id', 'paytm_tokens', 'googlepay_transactions', 'googlepay_tokens'];

        // Execute prepared statements for all tables
        $updateQuery = "UPDATE `%s` SET user_token=? WHERE user_id=?";
        foreach ($tables as $table) {
            $query = sprintf($updateQuery, $table);
            $stmt = $conn->prepare($query);
            $stmt->bind_param("si", $key, $bbbyteuserid);
            $stmt->execute();
            $stmt->close();
        }

        // Commit transaction
        $conn->commit();

        // Secure success message
        echo '<script>
            Swal.fire({
                icon: "success",
                title: "New API Key generated!",
                confirmButtonText: "Ok!",
                customClass: {
                        popup: "swal2-border-radius",
                        confirmButton: "swal2-confirm-lg",
                    },
                allowOutsideClick: false
            }).then((result) => {
                if (result.isConfirmed) {
                    window.location.href = "api_keys";
                }
            });
        </script>';
        exit;
    } catch (Exception $e) {
        $conn->rollback(); // Rollback if any query fails

        echo '<script>
            Swal.fire({
                icon: "error",
                title: "Failed to generate API key.",
                confirmButtonText: "Ok!",
                customClass: {
                        popup: "swal2-border-radius",
                        confirmButton: "swal2-confirm-lg",
                    },
                allowOutsideClick: false
            }).then((result) => {
                if (result.isConfirmed) {
                    window.location.href = "api_keys";
                }
            });
        </script>';
        exit;
    }
}

// Webhook URL update
if (isset($_POST['update_webhook'])) {
    function isValidUrl($url) {
        return filter_var($url, FILTER_VALIDATE_URL);
    }

    $bytecallbackurl = trim($_POST['webhook_url']);

    if (!isValidUrl($bytecallbackurl)) {
        echo '<script>
            Swal.fire({
                icon: "error",
                title: "Invalid webhook URL!",
                confirmButtonText: "Ok!",
                customClass: {
                        popup: "swal2-border-radius",
                        confirmButton: "swal2-confirm-lg",
                    },
                allowOutsideClick: false
            }).then((result) => {
                if (result.isConfirmed) {
                    window.location.href = "api_keys";
                }
            });
        </script>';
        exit();
    }

    // Update webhook URL securely
    $keyquery = "UPDATE `users` SET callback_url=? WHERE mobile=?";
    $stmt = $conn->prepare($keyquery);
    $stmt->bind_param("ss", $bytecallbackurl, $mobile);
    $stmt->execute();

    if ($stmt->affected_rows > 0) {
        echo '<script>
            Swal.fire({
                icon: "success",
                title: "Webhook URL updated successfully!",
                confirmButtonText: "Ok!",
                customClass: {
                        popup: "swal2-border-radius",
                        confirmButton: "swal2-confirm-lg",
                    },
                allowOutsideClick: false
            }).then((result) => {
                if (result.isConfirmed) {
                    window.location.href = "api_keys";
                }
            });
        </script>';
    } else {
        echo '<script>
            Swal.fire({
                icon: "error",
                title: "Error updating Webhook. Please try again later!",
                confirmButtonText: "Ok!",
                customClass: {
                        popup: "swal2-border-radius",
                        confirmButton: "swal2-confirm-lg",
                    },
                allowOutsideClick: false
            }).then((result) => {
                if (result.isConfirmed) {
                    window.location.href = "api_keys";
                }
            });
        </script>';
    }

    $stmt->close();
}
?>


<!--start main wrapper-->
<main class="main-wrapper">
    <div class="main-content">
        <!--breadcrumb-->
        <div class="page-breadcrumb d-none d-sm-flex align-items-center mb-3">
            <div class="breadcrumb-title pe-3">API Credentials</div>
            
        </div>
        <!--end breadcrumb-->
        
<div class="row">
    <!-- API Key Section -->
    <div class="col-12"> <!-- Full-width column -->
        <div class="card">
            <div class="card-body">
                <div class="row">
                    <div class="col-md-2">
                        <div class="row h-100" id="hide_border">
                            <div class="col-4 col-md-12">
                                <div class="d-flex align-items-center justify-content-md-center mb-md-0">
                                    <!-- SVG Logo -->
                                    <svg class="avatar-img" width="80" height="80" viewBox="0 0 800 800" fill="none" xmlns="http://www.w3.org/2000/svg">
                                        <path d="M539.668 66.6667H260.335C139.001 66.6667 66.668 139 66.668 260.333V539.333C66.668 661 139.001 733.333 260.335 733.333H539.335C660.668 733.333 733.001 661 733.001 539.667V260.333C733.335 139 661.001 66.6667 539.668 66.6667Z" fill="#199B7B"></path>
                                        <path d="M529.657 270.336C480.323 221.336 400.323 221.336 351.323 270.336C316.99 304.336 306.657 353.67 319.99 397.003L241.657 475.337C236.324 481.003 232.324 492.003 233.657 500.003L238.657 536.337C240.324 548.337 251.657 559.67 263.657 561.337L299.99 566.67C307.99 567.67 318.99 564.337 324.657 558.337L338.323 544.67C341.657 541.67 341.657 536.337 338.323 533.003L305.99 500.67C301.324 496.003 301.324 488.003 305.99 483.003C310.657 478.337 318.657 478.337 323.657 483.003L355.99 515.337C358.99 518.337 364.323 518.337 367.657 515.337L402.99 480.337C445.99 493.67 495.323 483.337 529.657 449.337C578.99 399.67 578.99 319.669 529.657 270.336ZM441.657 400.003C418.657 400.003 399.99 381.337 399.99 358.337C399.99 335.337 418.657 316.669 441.657 316.669C464.656 316.669 483.323 335.337 483.323 358.337C483.323 381.337 464.656 400.003 441.657 400.003Z" fill="#15715B"></path>
                                    </svg>
                                </div>
                            </div>
                        </div>
                    </div>

                    <div class="col-md-10">
                        <h3 class="mb-4 content-heading">API Credentials</h3>
                        <form class="row g-3" method="POST">
                            <div class="col-md-12">
                                <label class="form-label">API Key</label>
                                <input id="api_key" class="form-control w-100" type="text" value="<?php echo htmlspecialchars($user_token, ENT_QUOTES, 'UTF-8'); ?>" disabled>
                            </div>

                            <div class="col-md-12 d-flex align-items-end">
                                <button type="submit" name="generate_token" class="btn btn-success px-3 rounded me-2">
                                    Create New API Keys
                                </button>

                                <button type="button" class="btn btn-outline-primary d-flex align-items-center" id="copy_key" onclick="copyAPIKey()">
                <span class="feather-icon" id="copy_icon">
                    <svg xmlns="http://www.w3.org/2000/svg" width="24" height="24" viewBox="0 0 24 24" fill="none" stroke="currentColor" stroke-width="2" stroke-linecap="round" stroke-linejoin="round" class="feather feather-copy">
                        <rect x="9" y="9" width="13" height="13" rx="2" ry="2"></rect>
                        <path d="M5 15H4a2 2 0 0 1-2-2V4a2 2 0 0 1 2-2h9a2 2 0 0 1 2 2v1"></path>
                    </svg>
                </span>
                <span id="copy_text" class="ms-2">Copy</span>
            </button>
                            </div>
                        </form>
                    </div> 
                </div>
            </div>
        </div>
    </div> <!-- End Full-width Column -->
</div>


        <div class="row">
    <!-- API Key Section -->
    <div class="col-12"> <!-- Full-width column -->
        <div class="card">
            <div class="card-body">
                <div class="row">
                    <div class="col-md-2">
                        <div class="row h-100" id="hide_border">
                            <div class="col-4 col-md-12">
                                <div class="d-flex align-items-center justify-content-md-center mb-md-0">
                                    <!-- SVG Logo -->
                                    <svg class="avatar-img" width="80" height="80" viewBox="0 0 800 800" fill="none" xmlns="http://www.w3.org/2000/svg"><path d="M539.66 66.6667H260.659C139.326 66.6667 66.9922 139 66.9922 260.333V539.333C66.9922 660.667 139.326 733 260.659 733H539.66C660.993 733 733.326 660.667 733.326 539.333V260.333C733.326 139 660.993 66.6667 539.66 66.6667Z" fill="#199B7B"></path><path d="M282.295 547C281.678 547 280.751 547 280.134 547C250.174 544.225 222.067 530.35 201.064 508.151C151.645 456.352 151.645 372.179 201.064 320.381L268.706 249.466C292.797 224.183 325.228 210 359.821 210C394.414 210 426.845 223.875 450.936 249.466C500.355 301.264 500.355 385.437 450.936 437.236L417.27 472.694C408.313 481.943 393.796 482.252 384.53 473.619C375.264 464.677 374.955 450.186 383.603 440.936L417.27 405.479C450.01 371.255 450.01 315.448 417.27 281.532C386.692 249.466 332.95 249.466 302.063 281.532L234.421 352.447C201.682 386.671 201.682 442.478 234.421 476.393C247.703 490.576 265.617 499.21 284.458 501.06C297.121 502.293 306.387 513.701 305.151 526.342C304.225 538.059 294.032 547 282.295 547Z" fill="#15715B"></path><path d="M440.058 590C405.498 590 373.098 576.132 349.029 550.553C299.657 498.779 299.657 414.647 349.029 362.876L382.664 327.434C391.612 318.189 406.115 317.88 415.372 326.509C424.629 335.446 424.935 349.933 416.295 359.178L382.664 394.615C349.955 428.823 349.955 484.603 382.664 518.503C413.212 550.553 466.9 550.861 497.757 518.503L565.337 447.625C598.046 413.417 598.046 357.634 565.337 323.735C552.069 309.559 534.172 300.931 515.349 299.081C502.698 297.849 493.44 286.446 494.675 273.811C495.909 261.176 507.014 251.622 519.974 253.163C549.906 256.245 577.989 269.804 598.972 291.993C648.343 343.766 648.343 427.899 598.972 479.672L531.395 550.553C507.018 576.132 474.618 590 440.058 590Z" fill="#15715B"></path></svg>
                                </div>
                            </div>
                        </div>
                    </div>

                    <div class="col-md-10">
                        <h3 class="mb-4 content-heading">Webhook URL</h3>
                        <form class="row g-3" form method="POST">

                            <div class="col-md-12">
                                <label for="input4" class="form-label">Webhook Url</label>
                                <input type="text" class="form-control" name ="webhook_url" id="input4" value="<?php echo $callback_url; ?>">
                            </div>
                            

                            <div class="col-md-12">
                                <div class="d-md-flex d-grid align-items-center gap-3">
                                    <button type="submit" name ="update_webhook" class="btn btn-light px-4">Update Webhook</button>
                                </div>
                            </div>
                        </form>
                    </div>
                </div>
            </div> <!-- End Full-width Column -->
        </div>
            
            
        <div class="col-12">
    <div class="card">
        <div class="card-body p-4">
            <h5 class="mb-4">Instructions for API</h5>
            <form class="row g-3">
                <ul class="list-unstyled">
                    <li class="d-flex align-items-start mb-2">
                        <span class="me-2">🔑</span> Do not share your API key and payout API key with anyone.
                    </li>
                    <li class="d-flex align-items-start mb-2">
                        <span class="me-2">⚠️</span> We will not be responsible if anyone uses your API to withdraw your funds.
                    </li>
                    <li class="d-flex align-items-start mb-2">
                        <span class="me-2">🔒</span> Ensure that your API keys are stored securely.
                    </li>
                    <li class="d-flex align-items-start mb-2">
                        <span class="me-2">🔍</span> Regularly check your account for any unauthorized activity.
                    </li>
                    <li class="d-flex align-items-start mb-2">
                        <span class="me-2">📞</span> Contact support immediately if you suspect any security breaches.
                    </li>
                    <li class="d-flex align-items-start mb-2">
                        <span class="me-2">📜</span> Follow best practices for API security to protect your funds.
                    </li>
                    <li class="d-flex align-items-start mb-2">
                        <span class="me-2">💡</span> Always use strong, unique passwords for your account to enhance security.
                    </li>
                </ul>
            </form>
        </div>
    </div>
</div>
            
            
        </div><!--end row-->
    </div>
</main>
<!--end main wrapper-->

<script>

function copyAPIKey() {
    // Get the API Key value
    let apiKey = document.getElementById('api_key').value;

    // Copy to clipboard
    navigator.clipboard.writeText(apiKey).then(() => {
        let copyButton = document.getElementById('copy_key');
        let icon = document.getElementById('copy_icon');
        let text = document.getElementById('copy_text');

        // Change icon to checkmark and text to "Copied!"
        icon.innerHTML = `
            <svg xmlns="http://www.w3.org/2000/svg" width="24" height="24" viewBox="0 0 24 24" fill="none" stroke="currentColor" stroke-width="2" stroke-linecap="round" stroke-linejoin="round" class="feather feather-check">
                <polyline points="20 6 9 17 4 12"></polyline>
            </svg>
        `;
        text.innerText = "Copied!";

        // Reset icon and text after 2 seconds
        setTimeout(() => {
            icon.innerHTML = `
                <svg xmlns="http://www.w3.org/2000/svg" width="24" height="24" viewBox="0 0 24 24" fill="none" stroke="currentColor" stroke-width="2" stroke-linecap="round" stroke-linejoin="round" class="feather feather-copy">
                    <rect x="9" y="9" width="13" height="13" rx="2" ry="2"></rect>
                    <path d="M5 15H4a2 2 0 0 1-2-2V4a2 2 0 0 1 2-2h9a2 2 0 0 1 2 2v1"></path>
                </svg>
            `;
            text.innerText = "Copy";
        }, 2000);
    }).catch(err => {
        console.error('Failed to copy:', err);
    });
}


    function updateTime() {
        var now = new Date();
        var hour = now.getHours();
        var ampm = hour >= 12 ? 'PM' : 'AM';
        hour = hour % 12;
        hour = hour ? hour : 12; // handle midnight (0 hours)
        var formattedTime = padZero(hour) + ':' + padZero(now.getMinutes()) + ':' + padZero(now.getSeconds()) + ' ' + ampm;
        document.getElementById('input52').value = formattedTime; // Update the second input field
    }

    function padZero(num) {
        return (num < 10 ? '0' : '') + num;
    }

    updateTime(); // Call the function initially to display the current time
    setInterval(updateTime, 1000); // Update the time every second
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

