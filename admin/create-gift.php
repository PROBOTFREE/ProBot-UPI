<?php
 // Define the constant

session_start();


// Define the absolute path to the functions.php file
define('ABSPATH1', dirname(__FILE__) . '/'); // Adjust the path as needed
// Include the database connection file
// Define the base directory constant
define('BASE_PATH', realpath(dirname(__FILE__)) . '../');
// Define the absolute path to the config file
define('CONFIG_PATH', dirname(__FILE__) . '/../auth/config.php');

// Include the configuration file securely
include CONFIG_PATH;

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
<body>
<?php
require_once(ABSPATH1 . 'header.php');
if ($_SERVER['REQUEST_METHOD'] == 'POST') {
    $code = filter_var($_POST['code'], FILTER_SANITIZE_STRING);
    $amount = filter_var($_POST['amount'], FILTER_SANITIZE_NUMBER_FLOAT, FILTER_FLAG_ALLOW_FRACTION);
    $expiry_date = filter_var($_POST['expiry_date'], FILTER_SANITIZE_STRING);
    $is_redeemed = filter_var($_POST['is_redeemed'], FILTER_SANITIZE_STRING);
    $max_redemptions = filter_var($_POST['max_redemptions'], FILTER_SANITIZE_NUMBER_INT);
    $current_redemptions = filter_var($_POST['current_redemptions'], FILTER_SANITIZE_NUMBER_INT);

    $sql = $conn->prepare("INSERT INTO gift_codes (code, amount, expiry_date, is_redeemed, max_redemptions, current_redemptions) VALUES (?, ?, ?, ?, ?, ?)");
    $sql->bind_param("sdsiii", $code, $amount, $expiry_date, $is_redeemed, $max_redemptions, $current_redemptions);

    if ($sql->execute()) {
        echo '<script src="https://cdn.jsdelivr.net/npm/sweetalert2@11.0.18"></script>';
        echo '<script>
            Swal.fire({
                icon: "success",
                title: "Gift Code created successfully!!",
                showConfirmButton: true,
                confirmButtonText: "Ok!",
                allowOutsideClick: false,
                allowEscapeKey: false
            }).then((result) => {
                if (result.isConfirmed) {
                    window.location.href = "manage-gift-codes"; // Redirect to "manage-gift-codes" or another page
                }
            });
        </script>';
    } else {
        echo '<script src="https://cdn.jsdelivr.net/npm/sweetalert2@11.0.18"></script>';
        echo '<script>
            Swal.fire({
                icon: "error",
                title: "Error creating gift code.",
                showConfirmButton: true,
                confirmButtonText: "Ok!",
                allowOutsideClick: false,
                allowEscapeKey: false
            });
        </script>';
    }
    exit;
}
?>


<div class="wrapper">
    <?php require_once(ABSPATH1 . 'header.php'); ?>

    <div class="page-content-wrapper">
        <div class="page-content">

            <div class="page-breadcrumb d-none d-sm-flex align-items-center mb-3">
                <div class="breadcrumb-title pe-3">Gift Codes</div>
                <div class="ps-3">
                    <nav aria-label="breadcrumb">
                        <ol class="breadcrumb mb-0 p-0 align-items-center">
                            <li class="breadcrumb-item"><a href="javascript:;"><ion-icon name="home-outline"></ion-icon></a></li>
                            <li class="breadcrumb-item active" aria-current="page">Create Gift Code</li>
                        </ol>
                    </nav>
                </div>
            </div>

            <h6 class="mb-0 text-uppercase">Create Gift Code</h6>
            <hr/>
            <div class="card">
                <div class="card-body">
                    <form method="POST" action="">
                       

                        <div class="mb-3">
                            <label for="code" class="form-label">Code</label>
                            <input type="text" class="form-control" id="code" name="code" required>
                        </div>
                        <div class="mb-3">
                            <label for="amount" class="form-label">Amount</label>
                            <input type="number" step="0.01" class="form-control" id="amount" name="amount" required>
                        </div>
                        <div class="mb-3">
                            <label for="expiry_date" class="form-label">Expiry Date</label>
                            <input type="date" class="form-control" id="expiry_date" name="expiry_date" required>
                        </div>
                        <div class="mb-3">
                            <label for="is_redeemed" class="form-label">Is Redeemed</label>
                            <select class="form-control" id="is_redeemed" name="is_redeemed" required>
                                <option value="no">No</option>
                                <option value="yes">Yes</option>
                            </select>
                        </div>
                        <div class="mb-3">
                            <label for="max_redemptions" class="form-label">Max Redemptions</label>
                            <input type="number" class="form-control" id="max_redemptions" name="max_redemptions" required>
                        </div>
                        <div class="mb-3">
                            <label for="current_redemptions" class="form-label">Current Redemptions</label>
                            <input type="number" class="form-control" id="current_redemptions" name="current_redemptions" required>
                        </div>

                        <button type="submit" class="btn btn-primary">Create</button>
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