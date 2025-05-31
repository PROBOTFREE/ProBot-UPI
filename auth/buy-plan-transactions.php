<?php

// Dene the absolute path to the functions.php file
define('ABSPATH', dirname(__FILE__) . '/'); // Adjust the path as needed
// Include the database connection file
require_once(ABSPATH . 'header.php');

// Set the default timezone to Asia/Kolkata
date_default_timezone_set('Asia/Kolkata');


?>
<head>
 <!--favicon-->

  <!--plugins-->
  <link href="assets/plugins/perfect-scrollbar/css/perfect-scrollbar.css" rel="stylesheet">
  <link rel="stylesheet" type="text/css" href="assets/plugins/metismenu/metisMenu.min.css">
  <link rel="stylesheet" type="text/css" href="assets/plugins/metismenu/mm-vertical.css">
  <link rel="stylesheet" type="text/css" href="assets/plugins/simplebar/css/simplebar.css">
  <!--bootstrap css-->
  <link href="assets/css/bootstrap.min.css" rel="stylesheet">
  <link href="assets/plugins/datatable/css/dataTables.bootstrap5.min.css" rel="stylesheet" />
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
// Query to fetch the latest active subscription
$query = "SELECT plan_id, expiry_date FROM plan_orders 
          WHERE user_id = ? AND status = 'success' 
          ORDER BY created_at DESC 
          LIMIT 1";

$stmt = $conn->prepare($query);
$stmt->bind_param("i", $user_id);
$stmt->execute();
$stmt->bind_result($plan_id, $expiry_date);

if ($stmt->fetch()) {
    // Map plan_id to plan name
    $planNames = [
        1 => "Basic Pack",
        2 => "Starter Pack",
        3 => "Business Pack",
        4 => "Enterprise Pack"
    ];
    
    $activePlan = $planNames[$plan_id] ?? "Unknown Plan";
}

$stmt->close();


// Fetch subscription history
$query = "SELECT plan_id, amount, created_at, expiry_date, status FROM plan_orders 
          WHERE user_id = ? 
          ORDER BY created_at DESC";

$stmt = $conn->prepare($query);
$stmt->bind_param("i", $user_id);
$stmt->execute();
$stmt->bind_result($plan_id, $amount, $created_at, $expiry_date, $status);

$planHistory = [];

while ($stmt->fetch()) {
    $planHistory[] = [
        'plan_name' => $planNames[$plan_id] ?? "Unknown Plan",
        'amount' => $amount,
        'created_at' => $created_at,
        'expiry_date' => $expiry_date,
        'status' => ucfirst($status)
    ];
}

$stmt->close();
?>

 <!--start main wrapper-->
  <main class="main-wrapper">
    <div class="main-content">
        
<div class="row d-flex justify-content-center">
    <div class="col-12">
        <div class="card rounded-4 w-100 p-3">
            <div class="card-body d-flex align-items-center gap-3 flex-column flex-md-row text-center text-md-start">
                <div class="flex-grow-1">
                    <h5 class="mb-2 text-wrap" style="word-break: break-word; font-size: 1.75rem;
    font-weight: 700;">
                        Active Subscription
                    </h5>
                    <p class="text-secondary mt-2 mb-0 text-wrap" style="word-break: break-word;">
                        Here, you can view your account's active subscription and upgrade it as well
                    </p>
                </div>
                
            </div>
        </div>
    </div>
</div>

<div class="col-12">
    <div class="card card-border">
        <div class="card-body">
            <div class="row">
                <!-- Business Plan-->
                <div class="row">
                    <div class="col-12">
                        <div class="d-flex flex-column justify-content-center align-items-center pb-4 m-4">
                            <div class="d-flex justify-content-center align-items-center">
                                <svg width="100" height="100" viewBox="0 0 800 800" fill="none" xmlns="http://www.w3.org/2000/svg"><rect x="40" y="127" width="720" height="546" rx="241" fill="#199B7B"></rect><path d="M290.333 547.667C371.703 547.667 437.667 481.704 437.667 400.334C437.667 318.963 371.703 253 290.333 253C208.963 253 143 318.963 143 400.334C143 481.704 208.963 547.667 290.333 547.667Z" fill="#15715B"></path>
                                </svg>
                                </div>
                                
                                <?php if ($activePlan): ?>
                            <h3 class="text-center mt-4 mb-1 content-heading">Active Plan: <?php echo htmlspecialchars($activePlan); ?></h3>
                            <small class="text-center text-muted">Enjoy your subscription benefits!</small>
                        <?php else: ?>
                            <h3 class="text-center mt-4 mb-1 content-heading">Your plan has expired. Please Renew your plan.</h3>
                            <small class="text-center text-muted">Kindly go to plan page and renew plan.</small>
                            <a class="mt-4 btn btn-primary" href="subscription">Renew Plan</a>
                        <?php endif; ?>
                        
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        
        <div class="col-12">
    <div class="card card-border">
        <div class="card-body">
            <h5 class="mb-3">Subscription History</h5>
            <div class="table-responsive">
                <table class="table">
                    <thead>
                        <tr>
                            <th>Plan Name</th>
                            <th>Amount</th>
                            <th>Start Date</th>
                            <th>Expiry Date</th>
                            <th>Status</th>
                        </tr>
                    </thead>
                    <tbody>
                        <?php if (!empty($planHistory)): ?>
                            <?php foreach ($planHistory as $history): ?>
                                <tr>
                                    <td><?php echo htmlspecialchars($history['plan_name']); ?></td>
                                    <td>₹<?php echo htmlspecialchars($history['amount']); ?></td>
                                    <td><?php echo htmlspecialchars($history['created_at']); ?></td>
                                    <td><?php echo htmlspecialchars($history['expiry_date']); ?></td>
                                    <td>
                                        <span class="badge bg-<?php echo ($history['status'] == 'Success') ? 'success' : 'warning'; ?>">
                                            <?php echo htmlspecialchars($history['status']); ?>
                                        </span>
                                    </td>
                                </tr>
                            <?php endforeach; ?>
                        <?php else: ?>
                            <tr>
                                <td colspan="5" class="text-center">No subscription history found.</td>
                            </tr>
                        <?php endif; ?>
                    </tbody>
                </table>
            </div>
        </div>
    </div>
</div>

        
    </div>
  </main>
  
  
  <!--end main wrapper-->



  <!--plugins-->
  <script src="assets/js/jquery.min.js"></script>
  <!--plugins-->
  <script src="assets/plugins/perfect-scrollbar/js/perfect-scrollbar.js"></script>
  <script src="assets/plugins/metismenu/metisMenu.min.js"></script>
  <script src="assets/plugins/apexchart/apexcharts.min.js"></script>
  <script src="assets/js/index.js"></script>
  <script src="assets/plugins/peity/jquery.peity.min.js"></script>
  <script>
    $(".data-attributes span").peity("donut")
  </script>
  <script src="assets/plugins/simplebar/js/simplebar.min.js"></script>
  <script src="assets/js/main.js"></script>


</body>

</html>