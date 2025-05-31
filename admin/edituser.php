<?php
 // Define the constant

session_start();


// Define the absolute path to the functions.php file
define('ABSPATH1', dirname(__FILE__) . '/'); // Adjust the path as needed
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

if (isset($_GET['mobile'])) {
    $mobile = filter_var($_GET['mobile'], FILTER_SANITIZE_NUMBER_INT);
    
    $sql = $conn->prepare("SELECT company, mobile, merchant_id, email, acc_ban, wallet, password, expiry, vip_expiry, route_1, route_2 FROM users WHERE mobile = ?");
    $sql->bind_param("s", $mobile);
    $sql->execute();
    $result = $sql->get_result();

    if ($result->num_rows == 1) {
        $user = $result->fetch_assoc();
    } else {
        echo "User not found.";
        exit;
    }
} else {
    echo "Invalid request.";
    exit;
}

?>
<!doctype html>
<html lang="en">
<head>
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

    <title>Edit User</title>
</head>
<body>

<?php
require_once(ABSPATH1 . 'header.php');
if ($_SERVER['REQUEST_METHOD'] == 'POST') {
    $company = filter_var($_POST['company'], FILTER_SANITIZE_STRING);
    $mobile = filter_var($_POST['mobile'], FILTER_SANITIZE_NUMBER_INT);
    $merchant_id = filter_var($_POST['merchant_id'], FILTER_SANITIZE_STRING);
    $email = filter_var($_POST['email'], FILTER_SANITIZE_EMAIL);
    $acc_ban = filter_var($_POST['acc_ban'], FILTER_SANITIZE_STRING);
    $wallet = filter_var($_POST['wallet'], FILTER_SANITIZE_STRING);
    $password = filter_var($_POST['password'], FILTER_SANITIZE_STRING);
    $expiry = filter_var($_POST['expiry'], FILTER_SANITIZE_STRING); // Ensure correct format
    $vip_expiry = filter_var($_POST['vip_expiry'], FILTER_SANITIZE_STRING); // Ensure correct format
    $route_1 = filter_var($_POST['route_1'], FILTER_SANITIZE_STRING);
    $route_2 = filter_var($_POST['route_2'], FILTER_SANITIZE_STRING);

    $sql = $conn->prepare("UPDATE users SET company=?, merchant_id=?, email=?, acc_ban=?, wallet=?, password=?, expiry=?, vip_expiry=?, route_1=?, route_2=? WHERE mobile=?");
    $sql->bind_param("ssssssssssi", $company, $merchant_id, $email, $acc_ban, $wallet, $password, $expiry, $vip_expiry, $route_1, $route_2, $mobile);

    if ($sql->execute()) {
        // Show SweetAlert2 success message
        echo '<script src="https://cdn.jsdelivr.net/npm/sweetalert2@11.0.18"></script>';
        echo '<script>
            Swal.fire({
                icon: "success",
                title: "User updated successfully!!",
                showConfirmButton: true, // Show the confirm button
                confirmButtonText: "Ok!", // Set text for the confirm button
                allowOutsideClick: false, // Prevent the user from closing the popup by clicking outside
                allowEscapeKey: false // Prevent the user from closing the popup by pressing Escape key
            }).then((result) => {
                if (result.isConfirmed) {
                    window.location.href = "manage-users"; // Redirect to "manage-users" when the user clicks the confirm button
                }
            });
        </script>';
        exit;
    } else {
        // Show SweetAlert2 error message
        echo '<script src="https://cdn.jsdelivr.net/npm/sweetalert2@11.0.18"></script>';
        echo '<script>
            Swal.fire({
                icon: "error",
                title: "Update failed!!",
                showConfirmButton: true, // Show the confirm button
                confirmButtonText: "Ok!", // Set text for the confirm button
                allowOutsideClick: false, // Prevent the user from closing the popup by clicking outside
                allowEscapeKey: false // Prevent the user from closing the popup by pressing Escape key
            }).then((result) => {
                if (result.isConfirmed) {
                    window.location.href = "manage-users"; // Redirect to "manage-users" when the user clicks the confirm button
                }
            });
        </script>';
        exit;
    }
}
?>
<!--start wrapper-->
<div class="wrapper">

    <?php require_once(ABSPATH1 . 'header.php'); ?>

    <!-- start page content wrapper-->
    <div class="page-content-wrapper">
        <!-- start page content-->
        <div class="page-content">

            <!--start breadcrumb-->
            <div class="page-breadcrumb d-none d-sm-flex align-items-center mb-3">
                <div class="breadcrumb-title pe-3">Remittances</div>
                <div class="ps-3">
                    <nav aria-label="breadcrumb">
                        <ol class="breadcrumb mb-0 p-0 align-items-center">
                            <li class="breadcrumb-item"><a href="javascript:;"><ion-icon name="home-outline"></ion-icon></a></li>
                            <li class="breadcrumb-item active" aria-current="page">Edit User</li>
                        </ol>
                    </nav>
                </div>
            </div>
            <!--end breadcrumb-->

            <h6 class="mb-0 text-uppercase">Edit User</h6>
            <hr/>
            <div class="card">
                <div class="card-body">
                    <form method="POST" action="">
                        

                        <div class="mb-3">
                            <label for="company" class="form-label">Company</label>
                            <input type="text" class="form-control" id="company" name="company" value="<?php echo htmlspecialchars($user['company']); ?>" required>
                        </div>
                        <div class="mb-3">
                            <label for="mobile" class="form-label">Mobile</label>
                            <input type="text" class="form-control" id="mobile" name="mobile" value="<?php echo htmlspecialchars($user['mobile']); ?>" required>
                        </div>
                        <div class="mb-3">
                            <label for="merchant_id" class="form-label">Merchant ID</label>
                            <input type="text" class="form-control" id="merchant_id" name="merchant_id" value="<?php echo htmlspecialchars($user['merchant_id']); ?>" required>
                        </div>
                        <div class="mb-3">
                            <label for="email" class="form-label">Email</label>
                            <input type="email" class="form-control" id="email" name="email" value="<?php echo htmlspecialchars($user['email']); ?>" required>
                        </div>
                        <div class="mb-3">
                            <label for="acc_ban" class="form-label">Account Banned</label>
                            <select class="form-control" id="acc_ban" name="acc_ban" required>
                                <option value="off" <?php echo ($user['acc_ban'] == 'off') ? 'selected' : ''; ?>>Off</option>
                                <option value="on" <?php echo ($user['acc_ban'] == 'on') ? 'selected' : ''; ?>>On</option>
                            </select>
                        </div>

                        <div class="mb-3">
                            <label for="wallet" class="form-label">Wallet</label>
                            <input type="text" class="form-control" id="wallet" name="wallet" value="<?php echo htmlspecialchars($user['wallet']); ?>" required>
                        </div>
                        <div class="mb-3">
                            <label for="password" class="form-label">Password</label>
                            <input type="password" class="form-control" id="password" name="password" value="<?php echo htmlspecialchars($user['password']); ?>" required>
                        </div>
                        
                        <div class="mb-3">
                            <label for="expiry" class="form-label">Expiry Date</label>
                            <input type="date" class="form-control" id="expiry" name="expiry" value="<?php echo htmlspecialchars($user['expiry']); ?>" required>
                        </div>
                        <div class="mb-3">
                            <label for="vip_expiry" class="form-label">VIP Expiry Date</label>
                            <input type="date" class="form-control" id="vip_expiry" name="vip_expiry" value="<?php echo htmlspecialchars($user['vip_expiry']); ?>" required>
                        </div>
                        <div class="mb-3">
                            <label for="route_1" class="form-label">Route 1</label>
                            <select class="form-control" id="route_1" name="route_1" required>
                                <option value="on" <?php echo ($user['route_1'] == 'on') ? 'selected' : ''; ?>>On</option>
                                <option value="off" <?php echo ($user['route_1'] == 'off') ? 'selected' : ''; ?>>Off</option>
                            </select>
                        </div>
                        <div class="mb-3">
                            <label for="route_2" class="form-label">Route 2</label>
                            <select class="form-control" id="route_2" name="route_2" required>
                                <option value="on" <?php echo ($user['route_2'] == 'on') ? 'selected' : ''; ?>>On</option>
                                <option value="off" <?php echo ($user['route_2'] == 'off') ? 'selected' : ''; ?>>Off</option>
                            </select>
                        </div>

                        <button type="submit" class="btn btn-primary">Update</button>
                        <a href="javascript:history.back()" class="btn btn-secondary">Cancel</a>
                    </form>
                </div>
            </div>

        </div>
        <!-- end page content-->
    </div>

</div>
<!--end wrapper-->


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