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
<?php

// Check if form was submitted
if ($_SERVER['REQUEST_METHOD'] == 'POST') {
    $long_url = filter_var($_POST['long_url'], FILTER_SANITIZE_URL);
    $link_type = filter_var($_POST['link_type'], FILTER_SANITIZE_STRING);

    $short_url = generateShortUrl();

    // Insert the new URL into the database
    $stmt = $conn->prepare("INSERT INTO short_urls (short_url, long_url, link_type) VALUES (?, ?, ?)");
    $stmt->bind_param("sss", $short_url, $long_url, $link_type);

    if ($stmt->execute()) {
        echo '<script src="https://cdn.jsdelivr.net/npm/sweetalert2@11.0.18"></script>';
        echo '<script>
            Swal.fire({
                icon: "success",
                title: "Short URL created successfully!",
                text: "Short URL: ' . $short_url . '",
                showConfirmButton: true,
                confirmButtonText: "Ok!",
                allowOutsideClick: false,
                allowEscapeKey: false
            }).then((result) => {
                if (result.isConfirmed) {
                    window.location.href = "manage-urls"; // Redirect to another page if needed
                }
            });
        </script>';
    } else {
        echo '<script src="https://cdn.jsdelivr.net/npm/sweetalert2@11.0.18"></script>';
        echo '<script>
            Swal.fire({
                icon: "error",
                title: "Error creating short URL.",
                showConfirmButton: true,
                confirmButtonText: "Ok!",
                allowOutsideClick: false,
                allowEscapeKey: false
            });
        </script>';
    }
    $stmt->close();
    exit;
}
?>

<body>

<div class="wrapper">
    <?php require_once(ABSPATH1 . 'header.php'); ?>

    <div class="page-content-wrapper">
        <div class="page-content">

            <div class="page-breadcrumb d-none d-sm-flex align-items-center mb-3">
                <div class="breadcrumb-title pe-3">Short URL</div>
                <div class="ps-3">
                    <nav aria-label="breadcrumb">
                        <ol class="breadcrumb mb-0 p-0 align-items-center">
                            <li class="breadcrumb-item"><a href="javascript:;"><ion-icon name="home-outline"></ion-icon></a></li>
                            <li class="breadcrumb-item active" aria-current="page">Create Short URL</li>
                        </ol>
                    </nav>
                </div>
            </div>

            <h6 class="mb-0 text-uppercase">Create Short URL</h6>
            <hr/>
            <div class="card">
                <div class="card-body">
                    <form method="POST" action="">
                        

                        <div class="mb-3">
                            <label for="long_url" class="form-label">Long URL</label>
                            <input type="url" class="form-control" id="long_url" name="long_url" required>
                        </div>
                        <div class="mb-3">
                            <label for="link_type" class="form-label">Link Type</label>
                            <input type="text" class="form-control" id="link_type" name="link_type" value="other" readonly>
                        </div>

                        <button type="submit" class="btn btn-primary">Create Short URL</button>
                        <a href="javascript:history.back()" class="btn btn-secondary">Cancel</a>
                    </form>
                </div>
            </div>

        </div>
    </div>
</div>

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
