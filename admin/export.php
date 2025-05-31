<?php
 // Define the constant

session_start();


// Define the absolute path to the functions.php file
define('ABSPATH1', dirname(__FILE__) . '/'); // Adjust the path as needed
// Define the absolute path to the config file
define('CONFIG_PATH', dirname(__FILE__) . '/../auth/config.php');

// Include the configuration file securely
include CONFIG_PATH;

include "../pages/dbfunctions.php";
if (!isset($_SESSION['username']) || !isset($_SESSION['user_type']) ) {
    header("location:index");
    exit;
}

$activityTimes = [
    'activity_history' => 5000,
    'admin' => 6000,
    'bharatpe_tokens' => 7000,
    'comming_soon_notifications' => 8000,
    'gift_codes' => 9000,
    'googlepay_tokens' => 10000,
    'googlepay_transactions' => 11000,
    'hdfc' => 12000,
    'orders' => 13000,
    'payment_links' => 14000,
    'paytm_tokens' => 15000,
    'phonepe_tokens' => 16000,
    'plan_orders' => 17000,
    'reports' => 18000,
    'short_urls' => 19000,
    'store_id' => 20000,
    'users' => 21000,
    'wallet_transactions' => 22000,
    'withdrawals' => 23000,
    'withdrawals_upi' => 24000,
];
$activityMessages = [
    'activity_history' => 'Processing Activity History...',
    'admin' => 'Updating Admin Records...',
    'bharatpe_tokens' => 'Handling BharatPe Tokens...',
    'comming_soon_notifications' => 'Processing Notifications...',
    'gift_codes' => 'Generating Gift Codes...',
    'googlepay_tokens' => 'Updating Google Pay Tokens...',
    'googlepay_transactions' => 'Processing Google Pay Transactions...',
    'hdfc' => 'Updating HDFC Records...',
    'orders' => 'Processing Orders...',
    'payment_links' => 'Updating Payment Links...',
    'paytm_tokens' => 'Handling Paytm Tokens...',
    'phonepe_tokens' => 'Updating PhonePe Tokens...',
    'plan_orders' => 'Processing Plan Orders...',
    'reports' => 'Generating Reports...',
    'short_urls' => 'Shortening URLs...',
    'store_id' => 'Updating Store IDs...',
    'users' => 'Updating User Records...',
    'wallet_transactions' => 'Processing Wallet Transactions...',
    'withdrawals' => 'Handling Withdrawals...',
    'withdrawals_upi' => 'Processing Withdrawals via UPI...',
];
$finalMessage = 'Data exported and download starts soon!';

require_once(ABSPATH1 . 'header.php');
?>
<!doctype html>
<html lang="en">
<head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <!-- loader -->
    <link href="assets/css/pace.min.css" rel="stylesheet" />
    <script src="assets/js/pace.min.js"></script>

    <!-- plugins -->
    <link href="assets/plugins/perfect-scrollbar/css/perfect-scrollbar.css" rel="stylesheet" />
    <link href="assets/plugins/simplebar/css/simplebar.css" rel="stylesheet" />
    <link href="assets/plugins/metismenu/css/metisMenu.min.css" rel="stylesheet" />
    <link href="assets/plugins/datatable/css/dataTables.bootstrap5.min.css" rel="stylesheet" />

    <!-- CSS Files -->
    <link href="assets/css/bootstrap.min.css" rel="stylesheet">
    <link href="assets/css/bootstrap-extended.css" rel="stylesheet">
    <link href="assets/css/style.css" rel="stylesheet">
    <link href="assets/css/icons.css" rel="stylesheet">
    <link href="https://fonts.googleapis.com/css2?family=Roboto:wght@400;500&display=swap" rel="stylesheet">

    <!-- Theme Styles -->
    <link href="assets/css/dark-theme.css" rel="stylesheet" />
    <link href="assets/css/semi-dark.css" rel="stylesheet" />
    <link href="assets/css/header-colors.css" rel="stylesheet" />

    <style>
        .swal2-progress-container {
            margin-top: 20px;
            width: 100%;
            max-width: 600px;
            height: 40px;
            background-color: #444; /* Dark background for progress bar */
            border-radius: 20px; /* Rounded edges */
            overflow: hidden;
            position: relative;
            text-align: center;
            color: #fff;
            box-shadow: 0 8px 16px rgba(0, 0, 0, 0.3); /* Enhanced shadow */
        }

        .swal2-progress-bar {
            height: 100%;
            background: linear-gradient(90deg, #4caf50, #81c784); /* Smooth gradient */
            transition: width 0.4s ease-in-out;
            border-radius: 20px; /* Rounded edges to match container */
            box-shadow: 0 0 15px rgba(0, 0, 0, 0.3); /* Glow effect */
        }

        .swal2-title {
            font-size: 1.8rem;
            font-weight: 700;
            color: #fff; /* Ensure title is visible */
        }

        .swal2-popup {
            padding: 25px;
            background-color: #333; /* Dark background for the popup */
            border-radius: 20px;
            box-shadow: 0 8px 16px rgba(0, 0, 0, 0.3);
            color: #fff; /* Text color for readability */
        }

        .swal2-popup p {
            font-size: 1.2rem;
            line-height: 1.6;
        }

        .swal2-confirm, .swal2-cancel {
            border-radius: 20px; /* Rounded buttons */
            padding: 10px 20px;
            font-size: 1rem;
        }

        .swal2-confirm {
            background-color: #4caf50; /* Confirm button color */
            border: none;
            color: #fff;
        }

        .swal2-cancel {
            background-color: #f44336; /* Cancel button color */
            border: none;
            color: #fff;
        }
    </style>

</head>

<body>
    <script src="https://cdn.jsdelivr.net/npm/sweetalert2@11.0.18"></script>
    <script>
        document.addEventListener('DOMContentLoaded', () => {
            const activityTimes = <?php echo json_encode($activityTimes); ?>;
            const activityMessages = <?php echo json_encode($activityMessages); ?>;
            const finalMessage = '<?php echo $finalMessage; ?>';

            // Initialize progress bar
            let progress = 0;
            const totalActivities = Object.keys(activityTimes).length;
            const progressBar = document.createElement('div');
            progressBar.classList.add('swal2-progress-bar');
            const progressContainer = document.createElement('div');
            progressContainer.classList.add('swal2-progress-container');
            progressContainer.appendChild(progressBar);
            document.body.appendChild(progressContainer);

            function updateProgressBar(percent) {
                progressBar.style.width = percent + '%';
            }

            function processActivities() {
                let activityKeys = Object.keys(activityTimes);
                let i = 0;
                function processNextActivity() {
                    if (i < activityKeys.length) {
                        let activity = activityKeys[i];
                        Swal.fire({
                            title: `Processing ${activity}`,
                            text: activityMessages[activity],
                            allowOutsideClick: false,
                            didOpen: () => {
                                Swal.showLoading();
                                setTimeout(() => {
                                    progress = ((i + 1) / totalActivities) * 100;
                                    updateProgressBar(progress);
                                    Swal.close();
                                    i++;
                                    processNextActivity();
                                }, activityTimes[activity]);
                            }
                        });
                    } else {
                        Swal.fire({
                            title: 'Data Exported',
                            text: finalMessage,
                            icon: 'success',
                            confirmButtonText: 'OK',
                            allowOutsideClick: false
                        }).then(() => {
                            // Redirect to a dashboard or main page after update
                            window.location.href = 'dashboard'; // Update this URL to your actual dashboard URL
                        });
                    }
                }
                processNextActivity();
            }

            // Trigger the process when the page is loaded
            processActivities();
        });
    </script>
</body>

<!-- JS Files -->
<script src="assets/js/jquery.min.js"></script>
<script src="assets/plugins/simplebar/js/simplebar.min.js"></script>
<script src="assets/plugins/metismenu/js/metisMenu.min.js"></script>
<script src="assets/js/bootstrap.bundle.min.js"></script>
<script type="module" src="https://unpkg.com/ionicons@5.5.2/dist/ionicons/ionicons.esm.js"></script>
<!-- plugins -->
<script src="assets/plugins/perfect-scrollbar/js/perfect-scrollbar.js"></script>
<script src="assets/plugins/datatable/js/jquery.dataTables.min.js"></script>
<script src="assets/plugins/datatable/js/dataTables.bootstrap5.min.js"></script>

<script src="assets/js/app.js"></script>
</html>
