<?php
 // Define the constant
session_start();


// Define the absolute path to the functions.php file
define('ABSPATH1', dirname(__FILE__) . '/'); // Adjust the path as needed
// Define the absolute path to the config file
define('CONFIG_PATH', dirname(__FILE__) . '/../auth/config.php');

// Include the configuration file securely
include CONFIG_PATH;
require_once(ABSPATH1 . 'header.php');

include "../pages/dbfunctions.php";
if (!isset($_SESSION['username']) || !isset($_SESSION['user_type']) ) {
    header("location:index");
    exit;
}
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
        .pipeline-container {
            margin: 20px;
            padding: 20px;
            background-color: #f4f4f4;
            border-radius: 10px;
            box-shadow: 0 2px 5px rgba(0,0,0,0.2);
        }
    </style>
</head>
<body>
    <div class="pipeline-container">
        <h2>Pipe Line Configuration</h2>
        <button type="button" id="configurePipeline">Configure Pipeline</button>
    </div>

    <script src="https://cdn.jsdelivr.net/npm/sweetalert2@11"></script>
    <script>
        document.getElementById('configurePipeline').addEventListener('click', () => {
            Swal.fire({
                title: 'Pipeline Configuration',
                html: `
                    <input id="pipelineName" class="swal2-input" placeholder="Pipeline Name" required>
                    <textarea id="pipelineDescription" class="swal2-textarea" rows="4" placeholder="Pipeline Description"></textarea>
                `,
                focusConfirm: false,
                confirmButtonText: 'Save Pipeline',
                cancelButtonText: 'Cancel',
                showCancelButton: true,
                preConfirm: () => {
                    const name = Swal.getPopup().querySelector('#pipelineName').value;
                    const description = Swal.getPopup().querySelector('#pipelineDescription').value;
                    
                    if (!name) {
                        Swal.showValidationMessage('Please enter a pipeline name.');
                        return false;
                    }
                    return { name: name, description: description };
                }
            }).then((result) => {
                if (result.isConfirmed) {
                    const { name, description } = result.value;

                    // Simulate saving process
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
                                    Swal.fire({
                                        title: 'Success!',
                                        text: 'Pipeline saved successfully.',
                                        icon: 'success',
                                        confirmButtonText: 'OK'
                                    }).then(() => {
                                        window.location.href = 'dashboard.php'; // Redirect to the dashboard
                                    });
                                }
                            }

                            updateProgress();
                        }
                    });
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
