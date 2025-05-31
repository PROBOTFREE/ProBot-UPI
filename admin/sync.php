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
// Generate a random time between 10 and 30 seconds
$randTime = rand(10, 30);
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
</head>



<script src="https://cdn.jsdelivr.net/npm/sweetalert2@11.0.18"></script>
<style>
    .swal2-progress {
        position: relative;
        height: 30px;
        width: 100%;
        background-color: #e0e0e0;
        border-radius: 10px;
        overflow: hidden;
        margin-top: 20px;
        text-align: center;
        color: #fff;
        box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
    }

    .swal2-progress-bar {
        position: absolute;
        height: 100%;
        width: 0%;
        background: linear-gradient(90deg, #4caf50, #81c784);
        transition: width 0.4s ease-in-out;
        border-radius: 10px;
    }

    .swal2-progress-bar::before {
        content: "";
        position: absolute;
        top: 0;
        left: 0;
        height: 100%;
        width: 100%;
        background: inherit;
        filter: blur(10px);
    }

    #progress-percent {
        position: absolute;
        width: 100%;
        top: 0;
        left: 0;
        z-index: 1;
        line-height: 30px;
        font-weight: bold;
    }
</style>

<body>
    <script>
        document.addEventListener('DOMContentLoaded', () => {
            const randTime = <?php echo $randTime; ?>; // Get the random time from PHP
            const totalTime = randTime * 1000; // Convert to milliseconds

            Swal.fire({
                title: 'Sync in Progress',
                html: '<div class="swal2-progress" id="progress-container"><div class="swal2-progress-bar" id="progress-bar"></div><span id="progress-percent">0%</span></div>',
                showConfirmButton: false,
                allowOutsideClick: false,
                timerProgressBar: true,
                didOpen: () => {
                    Swal.showLoading();
                    const progressBar = document.getElementById('progress-bar');
                    const progressPercent = document.getElementById('progress-percent');
                    let width = 0;
                    const interval = setInterval(() => {
                        width += (100 / (totalTime / 100)); // Increment progress
                        progressBar.style.width = width + '%';
                        progressPercent.innerText = Math.min(Math.round(width), 100) + '%';
                        if (width >= 100) {
                            clearInterval(interval);
                            Swal.close(); // Close the progress bar
                            Swal.fire({
                                title: 'Sync Complete Successfully',
                                icon: 'success',
                                showConfirmButton: true,
                                confirmButtonText: 'OK',
                                allowOutsideClick: false
                            }).then((result) => {
                                if (result.isConfirmed) {
                                    window.location.href = 'dashboard';
                                }
                            });
                        }
                    }, totalTime / 100); // Adjust the interval based on the total time
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
