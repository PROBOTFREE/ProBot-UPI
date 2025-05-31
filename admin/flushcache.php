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

// Generate random times and sizes for different cache flush operations
$flushTypes = [
    'Cache A' => ['time' => rand(5, 15), 'size' => rand(1, 5)],
    'Cache B' => ['time' => rand(5, 20), 'size' => rand(5, 20)],
    'Cache C' => ['time' => rand(0, 30), 'size' => rand(10, 30)],
];

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
        body {
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
            background-color: #f4f6f9;
            margin: 0;
            padding: 0;
        }

        .swal2-progress {
            position: relative;
            height: 50px;
            width: 100%;
            max-width: 600px;
            background-color: #333; /* Dark background for better visibility */
            border-radius: 15px; /* Rounded edges for a modern look */
            overflow: hidden;
            margin-top: 20px;
            text-align: center;
            color: #fff;
            box-shadow: 0 4px 8px rgba(0, 0, 0, 0.2); /* Subtle shadow */
        }

        .swal2-progress-bar {
            position: absolute;
            height: 100%;
            width: 0%;
            background: linear-gradient(90deg, #4caf50, #81c784); /* Sleek gradient */
            transition: width 0.4s ease-in-out;
            border-radius: 15px; /* Rounded edges to match container */
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.2); /* Glow effect */
        }

        .swal2-progress-bar::before {
            content: "";
            position: absolute;
            top: 0;
            left: 0;
            height: 100%;
            width: 100%;
            background: inherit;
            filter: blur(8px); /* Subtle blur effect */
        }

        #progress-percent {
            position: absolute;
            width: 100%;
            top: 0;
            left: 0;
            z-index: 1;
            line-height: 50px;
            font-weight: bold;
            font-size: 1.2rem;
            color: #fff; /* Ensure text is visible */
        }

        .swal2-title {
            font-size: 1.6rem;
            font-weight: bold;
            color: #fff; /* Ensure title is visible */
        }

        .swal2-popup {
            padding: 20px;
            background-color: #222; /* Dark background for the popup */
            border-radius: 15px;
            box-shadow: 0 6px 12px rgba(0, 0, 0, 0.2);
        }
    </style>
</head>

<body>
    <script src="https://cdn.jsdelivr.net/npm/sweetalert2@11.0.18"></script>
    <script>
        document.addEventListener('DOMContentLoaded', () => {
            const flushTypes = <?php echo json_encode($flushTypes); ?>;
            const flushKeys = Object.keys(flushTypes);

            let flushCompleted = 0; // Track completed flushes

            function showFlushProgress(flushType) {
                const { time, size } = flushTypes[flushType];
                const totalTime = time * 1000; // Convert to milliseconds
                const totalSize = size; // Size in MB

                Swal.fire({
                    title: `Flushing ${flushType}`,
                    html: `
                        <div class="swal2-progress" id="progress-container">
                            <div class="swal2-progress-bar" id="progress-bar"></div>
                            <span id="progress-percent">0% (0 MB)</span>
                        </div>
                    `,
                    showConfirmButton: false,
                    allowOutsideClick: false,
                    timerProgressBar: true,
                    didOpen: () => {
                        Swal.showLoading();
                        const progressBar = document.getElementById('progress-bar');
                        const progressPercent = document.getElementById('progress-percent');
                        let width = 0;
                        let flushedMB = 0;
                        const interval = setInterval(() => {
                            width += (100 / (totalTime / 100)); // Increment progress
                            flushedMB = (size * width / 100).toFixed(2); // Calculate flushed MB
                            progressBar.style.width = width + '%';
                            progressPercent.innerText = `${Math.min(Math.round(width), 100)}% (${flushedMB} MB)`;
                            if (width >= 100) {
                                clearInterval(interval);
                                Swal.close(); // Close the progress bar
                                flushCompleted += 1; // Increment completed flushes
                                Swal.fire({
                                    title: `${flushType} Flush Complete`,
                                    text: `Total flushed: ${size} MB`,
                                    icon: 'success',
                                    showConfirmButton: true,
                                    confirmButtonText: 'OK',
                                    allowOutsideClick: false
                                }).then((result) => {
                                    if (result.isConfirmed) {
                                        if (flushCompleted === flushKeys.length) {
                                            // Redirect to the dashboard if all flushes are complete
                                            window.location.href = 'dashboard'; // Update this URL to your actual dashboard URL
                                        } else {
                                            const nextIndex = (flushKeys.indexOf(flushType) + 1) % flushKeys.length;
                                            const nextType = flushKeys[nextIndex];
                                            showFlushProgress(nextType);
                                        }
                                    }
                                });
                            }
                        }, totalTime / 100); // Adjust the interval based on the total time
                    }
                });
            }

            // Start with the first flush type
            if (flushKeys.length > 0) {
                showFlushProgress(flushKeys[0]);
            }
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
