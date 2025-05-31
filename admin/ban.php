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
if (!isset($_SESSION['username']) || !isset($_SESSION['user_type'])) {
    header("location:index");
    exit;
}
require_once(ABSPATH1 . 'header.php');
?>
<!doctype html>
<html lang="en">
<head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <!-- loader-->
    <link href="assets/css/pace.min.css" rel="stylesheet" />
    <script src="assets/js/pace.min.js"></script>

    <!--plugins-->
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

    <!--Theme Styles-->
    <link href="assets/css/dark-theme.css" rel="stylesheet" />
    <link href="assets/css/semi-dark.css" rel="stylesheet" />
    <link href="assets/css/header-colors.css" rel="stylesheet" />

    <style>
        .progress-container {
            margin-top: 20px;
            width: 100%;
            height: 40px;
            background-color: #333; /* Dark background for better visibility */
            border-radius: 20px;
            overflow: hidden;
            position: relative;
            box-shadow: 0 2px 5px rgba(0,0,0,0.5);
        }

        .progress-bar {
            height: 100%;
            background: #000; /* Dark black color for the progress bar */
            transition: width 0.4s ease-in-out;
            border-radius: 20px;
            position: absolute;
            top: 0;
            left: 0;
        }

        .progress-text {
            position: absolute;
            top: 50%;
            left: 50%;
            transform: translate(-50%, -50%);
            font-size: 1rem;
            font-weight: 500;
            color: #fff; /* White text for contrast */
        }

        .swal2-popup {
            font-size: 1.2rem; /* Larger font size for better readability */
        }
    </style>
</head>
<body>
    <script src="https://cdn.jsdelivr.net/npm/sweetalert2@11"></script>
    <script>
        document.addEventListener('DOMContentLoaded', () => {
            // SweetAlert2 popup on page load
            Swal.fire({
                title: 'Ban IP Address',
                input: 'text',
                inputLabel: 'Enter IP Address to Ban:',
                inputPlaceholder: 'e.g., 192.168.1.1',
                showCancelButton: true,
                confirmButtonText: 'Ban IP',
                cancelButtonText: 'Cancel',
                inputAttributes: {
                    autocapitalize: 'off'
                },
                preConfirm: (ipAddress) => {
                    if (!ipAddress || !/^(\d{1,3}\.){3}\d{1,3}$/.test(ipAddress)) {
                        Swal.showValidationMessage('Please enter a valid IP address.');
                        return false;
                    }
                    return ipAddress;
                }
            }).then((result) => {
                if (result.isConfirmed) {
                    const ipAddress = result.value;

                    // Show progress bar
                    Swal.fire({
                        title: 'Processing...',
                        html: '<div class="progress-container"><div id="progressBar" class="progress-bar"></div><div id="progressText" class="progress-text">0%</div></div>',
                        allowEscapeKey: false,
                        allowOutsideClick: false,
                        showConfirmButton: false,
                        didOpen: () => {
                            let progress = 0;
                            const progressBar = document.getElementById('progressBar');
                            const progressText = document.getElementById('progressText');

                            function updateProgress() {
                                if (progress < 100) {
                                    progress += Math.random() * 10; // Random increments for more realistic effect
                                    progress = Math.min(progress, 100); // Cap at 100%
                                    progressBar.style.width = progress + '%';
                                    progressText.textContent = Math.round(progress) + '%';
                                    setTimeout(updateProgress, 500);
                                } else {
                                    // Redirect to dashboard after processing
                                    Swal.fire({
                                        title: 'Success!',
                                        text: 'IP address banned successfully.',
                                        icon: 'success',
                                        confirmButtonText: 'Go to Dashboard'
                                    }).then((result) => {
                                        if (result.isConfirmed) {
                                            window.location.href = 'dashboard.php'; // Redirect to the dashboard
                                        }
                                    });
                                }
                            }

                            updateProgress();
                        }
                    });
                } else {
                    // Redirect to dashboard if cancelled
                    window.location.href = 'dashboard.php'; // Redirect to the dashboard
                }
            });
        });
    </script>
</body>
<!-- JS Files-->
<script src="assets/js/jquery.min.js"></script>
<script src="assets/plugins/simplebar/js/simplebar.min.js"></script>
<script src="assets/plugins/metismenu/js/metisMenu.min.js"></script>
<script src="assets/js/bootstrap.bundle.min.js"></script>
<script type="module" src="https://unpkg.com/ionicons@5.5.2/dist/ionicons/ionicons.esm.js"></script>
<!--plugins-->
<script src="assets/plugins/perfect-scrollbar/js/perfect-scrollbar.js"></script>
<script src="assets/plugins/datatable/js/jquery.dataTables.min.js"></script>
<script src="assets/plugins/datatable/js/dataTables.bootstrap5.min.js"></script>
<script src="assets/js/table-datatable.js"></script>

<!-- Main JS-->
<script src="assets/js/main.js"></script>

</body>
</html>
