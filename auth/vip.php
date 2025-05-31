<?php
// PHP code

// Define the absolute path to the functions.php file
define('ABSPATH', dirname(__FILE__) . '/'); // Adjust the path as needed

require_once(ABSPATH . 'header.php');

include "../pages/dbFunctions.php";
?>
<head>
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

$latest_purchased_plan = null; // Initialize before using


$userid=$_SESSION['user_id'];
// Get the current date and time range for today
// Prepare the SQL query to sum the amount with status 'SUCCESS' for lifetime
$cxr_2sql = "SELECT SUM(amount) as cxr_2total_amount 
             FROM orders 
             WHERE user_id = ? 
             AND status = 'SUCCESS'";

// Prepare and execute the statement
if ($cxr_2stmt = $conn->prepare($cxr_2sql)) {
    // Bind parameters
    $cxr_2stmt->bind_param("i", $userid);
    // Execute the query
    $cxr_2stmt->execute();
    // Bind the result to the variable
    $cxr_2stmt->bind_result($cxr_2total_amount);
    // Fetch the result
    $cxr_2stmt->fetch();
    // Save the result in the $cxr_2today_success_amount variable
    $cxr_2lifetime_success_amount = $cxr_2total_amount ?? 0;
    // Close the statement
    $cxr_2stmt->close();
} else {
    // Handle query preparation error
   // echo "Error preparing the query: " . $conn->error;
}

// Prepare the SQL query to sum the amount with status 'completed' for lifetime
$cxr_3sql = "SELECT SUM(amount) as cxr_3total_amount 
             FROM withdrawals 
             WHERE user_id = ? 
             AND status = 'completed'";

// Prepare and execute the statement
if ($cxr_3stmt = $conn->prepare($cxr_3sql)) {
    // Bind parameters
    $cxr_3stmt->bind_param("i", $userid);
    // Execute the query
    $cxr_3stmt->execute();
    // Bind the result to the variable
    $cxr_3stmt->bind_result($cxr_3total_amount);
    // Fetch the result
    $cxr_3stmt->fetch();
    // Save the result in the $cxr_3today_success_amount variable
    $cxr_3lifetime_success_amount = $cxr_3total_amount ?? 0;
    // Close the statement
    $cxr_3stmt->close();
} else {
    // Handle query preparation error
  //  echo "Error preparing the query: " . $conn->error;
}

// Prepare the SQL query to sum the amount with status 'completed' for lifetime
$cxr_4sql = "SELECT SUM(amount) as cxr_4total_amount 
             FROM withdrawals_upi 
             WHERE user_id = ? 
             AND status = 'completed'";

// Prepare and execute the statement
if ($cxr_4stmt = $conn->prepare($cxr_4sql)) {
    // Bind parameters
    $cxr_4stmt->bind_param("i", $userid);
    // Execute the query
    $cxr_4stmt->execute();
    // Bind the result to the variable
    $cxr_4stmt->bind_result($cxr_4total_amount);
    // Fetch the result
    $cxr_4stmt->fetch();
    // Save the result in the $cxr_4today_success_amount variable
    $cxr_4lifetime_success_amount = $cxr_4total_amount ?? 0;
    // Close the statement
    $cxr_4stmt->close();
} else {
    // Handle query preparation error
  //  echo "Error preparing the query: " . $conn->error;
}


$cxrlifetimepayoutofboth=$cxr_3lifetime_success_amount+$cxr_4lifetime_success_amount;


// Fetch user data
$query = "SELECT company, wallet, frozenwallet, route_2, vip_expiry, telegram_username FROM users WHERE id = ?";
$stmt = $conn->prepare($query);
$stmt->bind_param("i", $userid);
$stmt->execute();
$result = $stmt->get_result();
$userdata = $result->fetch_assoc();
$stmt->close();

// Fetch route_2 from the database
$query = "SELECT route_2, vip_expiry FROM users WHERE id = ?";
$stmt = $conn->prepare($query);
$stmt->bind_param("i", $userid);
$stmt->execute();
$stmt->bind_result($route_2, $vip_expiry);
$stmt->fetch();
$stmt->close();

// Check if VIP has expired
$today = date("Y-m-d"); // Get current date
$isExpired = ($vip_expiry < $today) ? true : false; // Check expiration


if ($route_2 == 'off') {
    echo '<script>
        Swal.fire({
            icon: "error",
            title: "Subscribe Vip",
            text: "Please subscribe to the VIP plan to get access.",
            showConfirmButton: true,
            confirmButtonText: "Subscribe Now",
            allowOutsideClick: false,
            customClass: {
                        popup: "swal2-border-radius",
                        confirmButton: "swal2-confirm-lg",
                    },
            allowEscapeKey: false
        }).then((result) => {
            if (result.isConfirmed) {
                window.location.href = "subscription";
            }
        });
    </script>';
    exit;
}

if ($isExpired == 'true') {
    echo '<script>
        Swal.fire({
            icon: "error",
            title: "Subscribe Vip",
            text: "Please renue the VIP plan to get access.",
            showConfirmButton: true,
            confirmButtonText: "Subscribe Now",
            allowOutsideClick: false,
            customClass: {
                        popup: "swal2-border-radius",
                        confirmButton: "swal2-confirm-lg",
                    },
            allowEscapeKey: false
        }).then((result) => {
            if (result.isConfirmed) {
                window.location.href = "subscription";
            }
        });
    </script>';
    exit;
}

?>

<!--start main wrapper-->
<main class="main-wrapper">
    <div class="main-content">
        <!--breadcrumb-->
        <div class="page-breadcrumb d-none d-sm-flex align-items-center mb-3">
            <div class="breadcrumb-title pe-3">Vip Menu</div>
            <div class="ps-3">
                <nav aria-label="breadcrumb">
                    <ol class="breadcrumb mb-0 p-0">
                        <li class="breadcrumb-item"><a href="javascript:;"><i class="bx bx-home-alt"></i></a>
                        </li>
                        <li class="breadcrumb-item active" aria-current="page">My Vip Profile</li>
                    </ol>
                </nav>
            </div>
        </div>
        <!--end breadcrumb-->

        <div class="row">
            <div class="col-12 col-xl-6">
                <div class="card">
                    <div class="card-body p-4">
                        <h5 class="mb-4">My Vip Information</h5>
                        <form class="row g-3" form method="POST">
                            <div class="col-md-12">
                                <label for="input3" class="form-label">Company Name</label>
                                <input type="text" class="form-control" id="input3" value="<?php echo htmlspecialchars($userdata['company'], ENT_QUOTES, 'UTF-8'); ?>" readonly>
                            </div>
                            <div class="col-md-12">
                                <label for="input5" class="form-label">Wallet Balance</label>
                                <input type="text" class="form-control" id="input5" value="₹<?php echo htmlspecialchars($userdata['wallet'], ENT_QUOTES, 'UTF-8'); ?>" readonly >
                            </div>
                            <div class="col-md-12">
                                <label for="input5" class="form-label">Frozen Balance</label>
                                <input type="text" class="form-control" id="input6" value="₹<?php echo htmlspecialchars($userdata['frozenwallet'], ENT_QUOTES, 'UTF-8'); ?>" readonly>
                            </div>
                            <div class="col-md-12">
                                <label for="input4" class="form-label">Device</label>
                                <input type="email" class="form-control" id="input4" value="<?php 
    // Call the getDeviceInformation function and store the result
    $deviceInfo = getDeviceInformation();
    echo htmlspecialchars($deviceInfo, ENT_QUOTES, 'UTF-8'); ?>" readonly>
                            </div>
                            <div class="col-md-12">
                                <label for="input5" class="form-label">Location</label>
                                <input type="text" class="form-control" name="secret_key" id="input7" value="<?php echo "INDIA"; ?>" readonly>
                            </div>
                            
                            
                            
                            
                        </form>
                    </div>
                </div>
            </div>
            <div class="col-12 col-xl-6">
                <div class="card">
                    <div class="card-body p-4">
                        <h5 class="mb-4">Status & Collection Data</h5>
                        <form class="row g-3" form method="POST">
                            <div class="col-md-12">
                                <label for="input15" class="form-label">Vip Account Status</label>
                                <div class="position-relative input-icon">
                                    <input type="text" class="form-control" id="input14" value="<?php echo ($userdata['route_2'] == "on") ? 'Active' : 'Inactive'; ?>" readonly>
                                    <span class="position-absolute top-50 translate-middle-y"><i
                                            class="material-symbols-rounded fs-5">person_outline</i></span>
                                </div>
                            </div>
                            
                            <div class="col-md-12">
                                <label for="input15" class="form-label">Vip Plan Expiry</label>
                                <div class="position-relative input-icon">
                                    <input type="text" class="form-control" id="input15" value="<?php echo $userdata['vip_expiry']; ?>" readonly>
                                    <span class="position-absolute top-50 translate-middle-y"><i
                                            class="material-symbols-rounded fs-5">calendar_today</i></span>
                                </div>
                            </div>
                            <div class="col-md-12">
                                <label for="input17" class="form-label"> Telegram Name</label>
                                <div class="position-relative input-icon">
                                    <input type="text" class="form-control" id="input17" value="<?php echo $userdata['telegram_username']; ?>" readonly>
                                    <span class="position-absolute top-50 translate-middle-y"><i
                                            class="material-symbols-rounded fs-5">lock_open</i></span>
                                </div>
                            </div>
                            <div class="col-md-12">
                                <label for="input18" class="form-label">Total Lifetime collection</label>
                                <div class="position-relative input-icon">
                                    <input type="text" class="form-control" id="input18" value="₹<?php echo $cxr_2lifetime_success_amount; ?>" readonly>
                                    <span class="position-absolute top-50 translate-middle-y"><i
                                            class="material-symbols-rounded fs-5">lock_open</i></span>
                                </div>
                            </div>
                            <div class="col-md-12">
                                <label for="input16" class="form-label">Total Lifetime Payout</label>
                                <div class="position-relative input-icon">
                                    <input type="text" class="form-control" id="input16" value="₹<?php echo $cxrlifetimepayoutofboth; ?>" readonly>
                                    
                                    <span class="position-absolute top-50 translate-middle-y"><i
                                            class="material-symbols-rounded fs-5">lock_open</i></span>
                                </div>
                            </div>
                            
                            
                            
    
                            
                        </form>
                    </div>
                </div>
            </div>
        </div><!--end row-->
    </div>
</main>
<!--end main wrapper-->

<script>
function refreshPage() {
    location.reload();
}
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

