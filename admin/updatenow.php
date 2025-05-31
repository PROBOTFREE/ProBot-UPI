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

$currentVersion = '1.0';
$newVersion = '3.0'; // New version to update to
$newUpdate = true; // Assume new update is available

// Additional PHP variables for realistic simulation
$downloadSize = '50 MB';
$downloadTime = 70000; // Simulate download time (70 seconds)
$installationTime = 50000; // Simulate installation time (50 seconds)
$updateMessage = "The update process will now start. Please wait...";
$installationMessage = "Installation in progress. Your system may restart during this process.";
$cleanupTime = 40000; // Simulate cleanup time after installation (40 seconds)

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
    .swal2-progress {
        position: relative;
        height: 50px;
        width: 100%;
        max-width: 600px;
        background-color: #444; /* Dark background for better visibility */
        border-radius: 25px; /* More rounded edges for a smoother look */
        overflow: hidden;
        margin-top: 20px;
        text-align: center;
        color: #fff;
        box-shadow: 0 8px 16px rgba(0, 0, 0, 0.3); /* Enhanced shadow for a modern feel */
    }

    .swal2-progress-bar {
        position: absolute;
        height: 100%;
        width: 0%;
        background: linear-gradient(90deg, #4caf50, #81c784); /* Smooth gradient */
        transition: width 0.4s ease-in-out;
        border-radius: 25px; /* Rounded edges to match container */
        box-shadow: 0 0 15px rgba(0, 0, 0, 0.3); /* Glow effect */
    }

    .swal2-progress-bar::before {
        content: "";
        position: absolute;
        top: 0;
        left: 0;
        height: 100%;
        width: 100%;
        background: inherit;
        filter: blur(10px); /* Enhanced blur effect for modern design */
    }

    #progress-percent {
        position: absolute;
        width: 100%;
        top: 0;
        left: 0;
        z-index: 1;
        line-height: 50px;
        font-weight: 600;
        font-size: 1.4rem;
        color: #fff; /* Ensure text is visible */
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
            const currentVersion = '<?php echo $currentVersion; ?>';
            const newVersion = '<?php echo $newVersion; ?>';
            const newUpdate = <?php echo $newUpdate ? 'true' : 'false'; ?>;
            const downloadSize = '<?php echo $downloadSize; ?>';
            const downloadTime = <?php echo $downloadTime; ?>;
            const installationTime = <?php echo $installationTime; ?>;
            const cleanupTime = <?php echo $cleanupTime; ?>;
            const updateMessage = '<?php echo $updateMessage; ?>';
            const installationMessage = '<?php echo $installationMessage; ?>';

            if (newUpdate) {
                Swal.fire({
                    title: 'Checking for Updates',
                    text: 'Please wait while we check for updates...',
                    allowOutsideClick: false,
                    didOpen: () => {
                        Swal.showLoading();
                        // Simulate checking update
                        setTimeout(() => {
                            Swal.fire({
                                title: 'Update Available',
                                text: `A new version ${newVersion} is available. Do you want to update?`,
                                icon: 'info',
                                showCancelButton: true,
                                confirmButtonText: 'Yes, Update!',
                                cancelButtonText: 'No, Thanks',
                                allowOutsideClick: false
                            }).then((result) => {
                                if (result.isConfirmed) {
                                    // Simulate update process
                                    Swal.fire({
                                        title: `Updating to Version ${newVersion}`,
                                        html: `
                                            <p>${updateMessage}</p>
                                            <div class="swal2-progress" id="progress-container">
                                                <div class="swal2-progress-bar" id="progress-bar"></div>
                                                <span id="progress-percent">0% (0/${downloadSize})</span>
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

                                            // Simulate download progress
                                            const downloadInterval = setInterval(() => {
                                                width += (100 / (downloadTime / 100)); // Increment progress
                                                progressBar.style.width = width + '%';
                                                progressPercent.innerText = `${Math.min(Math.round(width), 100)}% (${Math.round(width * 0.5)} MB)`;
                                                if (width >= 100) {
                                                    clearInterval(downloadInterval);
                                                    setTimeout(() => {
                                                        // Simulate installation progress
                                                        Swal.update({
                                                            title: `Updating to Version ${newVersion}`,
                                                            html: `
                                                                <p>${installationMessage}</p>
                                                                <div class="swal2-progress" id="progress-container">
                                                                    <div class="swal2-progress-bar" id="progress-bar"></div>
                                                                    <span id="progress-percent">0% (0/${downloadSize})</span>
                                                                </div>
                                                            `
                                                        });
                                                        let installWidth = 0;
                                                        const installInterval = setInterval(() => {
                                                            installWidth += (100 / (installationTime / 100)); // Increment progress
                                                            progressBar.style.width = installWidth + '%';
                                                            progressPercent.innerText = `${Math.min(Math.round(installWidth), 100)}% (Installing)`;
                                                            if (installWidth >= 100) {
                                                                clearInterval(installInterval);
                                                                setTimeout(() => {
                                                                    // Simulate cleanup process
                                                                    Swal.update({
                                                                        title: `Finalizing Update`,
                                                                        html: `
                                                                            <p>Cleaning up old files...</p>
                                                                            <div class="swal2-progress" id="progress-container">
                                                                                <div class="swal2-progress-bar" id="progress-bar"></div>
                                                                                <span id="progress-percent">0% (0/${downloadSize})</span>
                                                                            </div>
                                                                        `
                                                                    });
                                                                    let cleanupWidth = 0;
                                                                    const cleanupInterval = setInterval(() => {
                                                                        cleanupWidth += (100 / (cleanupTime / 100)); // Increment progress
                                                                        progressBar.style.width = cleanupWidth + '%';
                                                                        progressPercent.innerText = `${Math.min(Math.round(cleanupWidth), 100)}% (Cleaning up)`;
                                                                        if (cleanupWidth >= 100) {
                                                                            clearInterval(cleanupInterval);
                                                                            Swal.close(); // Close the progress bar
                                                                            Swal.fire({
                                                                                title: 'Update Complete',
                                                                                text: `Successfully updated to version ${newVersion}.`,
                                                                                icon: 'success',
                                                                                showConfirmButton: true,
                                                                                confirmButtonText: 'OK',
                                                                                allowOutsideClick: false
                                                                            }).then(() => {
                                                                                // Redirect to a dashboard or main page after update
                                                                                window.location.href = 'dashboard.php'; // Update this URL to your actual dashboard URL
                                                                            });
                                                                        }
                                                                    }, cleanupTime / 100); // Adjust the interval based on the cleanup time
                                                                }, 1000); // Simulate a short delay before cleanup starts
                                                            }
                                                        }, installationTime / 100); // Adjust the interval based on the installation time
                                                    }, 1000); // Simulate a short delay before installation starts
                                                }
                                            }, downloadTime / 100); // Adjust the interval based on the download time
                                        }
                                    });
                                } else {
                                    Swal.fire({
                                        title: 'Update Cancelled',
                                        text: 'You can update later from your settings.',
                                        icon: 'info',
                                        confirmButtonText: 'OK'
                                    });
                                }
                            });
                        }, 2000); // Simulate a delay in checking updates
                    }
                });
            }
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
<script src="assets/js/table-datatable.js"></script>

<!-- Main JS -->
<script src="assets/js/main.js"></script>

</body>
</html>
