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

//fetch username 
$sql = "SELECT name FROM users Where id=?";
$stmt = $conn->prepare($sql);
$stmt->bind_param("i", $user_id);
$stmt->execute();
$result = $stmt->get_result();
if ($result->num_rows > 0) {
    $row = $result->fetch_assoc();
    $username = $row['name'];
} else {
    $username = "Guest"; // Fallback if the user is not found
}


// Fetch notifications
$current_time = date("Y-m-d H:i:s");
$sql = "SELECT * FROM comming_soon_notifications WHERE expiry_time > ?";
$stmt = $conn->prepare($sql);
$stmt->bind_param("s", $current_time);
$stmt->execute();
$result = $stmt->get_result();
$cxrpendingnotificationscount = 0;

while ($row = $result->fetch_assoc()) {
    $message = htmlspecialchars($row['message'], ENT_QUOTES, 'UTF-8');
    $type = htmlspecialchars($row['type'], ENT_QUOTES, 'UTF-8');
    echo "<script>
            Swal.fire({
              title: '$message',
              icon: '$type',
              customClass: {
                        popup: 'swal2-border-radius',
                        confirmButton: 'swal2-confirm-lg',
                    },
            });
          </script>";
    $cxrpendingnotificationscount++;
}

$userid = $_SESSION['user_id'];

// Get the current date and the date one week ago
$current_date = date('Y-m-d');
$one_week_ago = date('Y-m-d', strtotime('-1 week'));

// Get the date two weeks ago
$two_weeks_ago = date('Y-m-d', strtotime('-2 weeks'));

// Prepare the SQL query for this week
$sql_this_week = "SELECT SUM(amount) as total_this_week 
                  FROM orders 
                  WHERE user_id = ? 
                  AND status = 'SUCCESS'
                  AND create_date BETWEEN ? AND ?";

// Prepare and execute the statement for this week
if ($stmt = $conn->prepare($sql_this_week)) {
    // Bind parameters
    $stmt->bind_param("iss", $userid, $one_week_ago, $current_date);
    // Execute the query
    $stmt->execute();
    // Bind the result to the variable
    $stmt->bind_result($total_this_week);
    // Fetch the result
    $stmt->fetch();
    // Close the statement
    $stmt->close();
} else {
    // Handle query preparation error
    //echo "Error preparing the query for this week: " . $conn->error;
}

// Prepare the SQL query for last week
$sql_last_week = "SELECT SUM(amount) as total_last_week 
                  FROM orders 
                  WHERE user_id = ? 
                  AND status = 'SUCCESS'
                  AND create_date BETWEEN ? AND ?";

// Prepare and execute the statement for last week
if ($stmt = $conn->prepare($sql_last_week)) {
    // Bind parameters
    $stmt->bind_param("iss", $userid, $two_weeks_ago, $one_week_ago);
    // Execute the query
    $stmt->execute();
    // Bind the result to the variable
    $stmt->bind_result($total_last_week);
    // Fetch the result
    $stmt->fetch();
    // Close the statement
    $stmt->close();
} else {
    // Handle query preparation error
   // echo "Error preparing the query for last week: " . $conn->error;
}

// Calculate the weekly transaction ratio
if ($total_last_week > 0) {
    $weekly_transaction_ratio = $total_this_week / $total_last_week;
} else {
    $weekly_transaction_ratio = ($total_this_week > 0) ? 1 : 0; // Avoid division by zero
}

// Save the result in the $cxrweeklypayment variable
$cxrweeklypayment = $total_this_week;

// Get the current date and the date one month ago
$cxr_current_date = date('Y-m-d');
$cxr_one_month_ago = date('Y-m-d', strtotime('-1 month'));

// Prepare the SQL query to count orders for the past month
$cxr_sql = "SELECT COUNT(*) as cxr_total_orders 
            FROM orders 
            WHERE user_id = ? 
            AND create_date BETWEEN ? AND ?";

// Prepare and execute the statement
if ($cxr_stmt = $conn->prepare($cxr_sql)) {
    // Bind parameters
    $cxr_stmt->bind_param("iss", $userid, $cxr_one_month_ago, $cxr_current_date);
    // Execute the query
    $cxr_stmt->execute();
    // Bind the result to the variable
    $cxr_stmt->bind_result($cxr_total_orders);
    // Fetch the result
    $cxr_stmt->fetch();
    // Save the result in the $cxr_monthapiorderscount variable
    $cxr_monthapiorderscount = $cxr_total_orders?? 0;
    // Close the statement
    $cxr_stmt->close();
} else {
    // Handle query preparation error
    // echo "Error preparing the query: " . $conn->error;
}

// Get the current date and time range for today
$cxr_2current_date_start = date('Y-m-d 00:00:00');
$cxr_2current_date_end = date('Y-m-d 23:59:59');

// Prepare the SQL query to sum the amount for today with status 'SUCCESS'
$cxr_2sql = "SELECT SUM(amount) as cxr_2total_amount 
             FROM orders 
             WHERE user_id = ? 
             AND create_date BETWEEN ? AND ? 
             AND status = 'SUCCESS'";

// Prepare and execute the statement
if ($cxr_2stmt = $conn->prepare($cxr_2sql)) {
    // Bind parameters
    $cxr_2stmt->bind_param("iss", $userid, $cxr_2current_date_start, $cxr_2current_date_end);
    // Execute the query
    $cxr_2stmt->execute();
    // Bind the result to the variable
    $cxr_2stmt->bind_result($cxr_2total_amount);
    // Fetch the result
    $cxr_2stmt->fetch();
    // Save the result in the $cxr_2today_success_amount variable
    $cxr_2today_success_amount = $cxr_2total_amount?? 0;
    // Close the statement
    $cxr_2stmt->close();
} else {
    // Handle query preparation error
    // echo "Error preparing the query: " . $conn->error;
}

// Get the current time and the time 24 hours ago
$cxr_3current_time = date('Y-m-d H:i:s');
$cxr_3time_24_hours_ago = date('Y-m-d H:i:s', strtotime('-24 hours'));

// Prepare the SQL query to sum the amount for the last 24 hours with status 'completed'
$cxr_3sql = "SELECT SUM(amount) as cxr_3total_amount 
             FROM withdrawals 
             WHERE user_id = ? 
             AND created_at BETWEEN ? AND ? 
             AND status = 'completed'";

// Prepare and execute the statement
if ($cxr_3stmt = $conn->prepare($cxr_3sql)) {
    // Bind parameters
    $cxr_3stmt->bind_param("iss", $userid, $cxr_3time_24_hours_ago, $cxr_3current_time);
    // Execute the query
    $cxr_3stmt->execute();
    // Bind the result to the variable
    $cxr_3stmt->bind_result($cxr_3total_amount);
    // Fetch the result
    $cxr_3stmt->fetch();
    // Check if the result is null or zero and assign zero if so
    $cxr_3last24hourpayouttotalamount = $cxr_3total_amount ?? 0;
    // Close the statement
    $cxr_3stmt->close();
} else {
    // Handle query preparation error
    // echo "Error preparing the query: " . $conn->error;
}

// Prepare the SQL query to sum the lifetime payout amount with status 'completed'
$cxr_4sql = "SELECT SUM(amount) as cxr_4total_amount 
             FROM withdrawals 
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
    // Check if the result is null and assign zero if so
    $cxr_4lifetimepayoutamount = $cxr_4total_amount ?? 0;
    // Close the statement
    $cxr_4stmt->close();
} else {
    // Handle query preparation error
    // echo "Error preparing the query: " . $conn->error;
}





// Get the current year and the previous year
$cxr_5current_year = date('Y');
$cxr_5previous_year = $cxr_5current_year - 1;

// Prepare the SQL query to sum the amount for the current year with status 'completed'
$cxr_5sql_current_year = "SELECT SUM(amount) as cxr_5total_amount 
                          FROM withdrawals 
                          WHERE user_id = ? 
                          AND YEAR(created_at) = ? 
                          AND status = 'completed'";

// Prepare and execute the statement for the current year
if ($cxr_5stmt = $conn->prepare($cxr_5sql_current_year)) {
    // Bind parameters
    $cxr_5stmt->bind_param("ii", $userid, $cxr_5current_year);
    // Execute the query
    $cxr_5stmt->execute();
    // Bind the result to the variable
    $cxr_5stmt->bind_result($cxr_5yearly_amount_sum);
    // Fetch the result
    $cxr_5stmt->fetch();
    // Check if the result is null and assign zero if so
    $cxr_5yearly_amount_sum = $cxr_5yearly_amount_sum ?? 0;
    // Close the statement
    $cxr_5stmt->close();
} else {
    // Handle query preparation error
    // echo "Error preparing the query: " . $conn->error;
}

// Prepare the SQL query to sum the amount for the previous year with status 'completed'
$cxr_5sql_previous_year = "SELECT SUM(amount) as cxr_5total_amount 
                           FROM withdrawals 
                           WHERE user_id = ? 
                           AND YEAR(created_at) = ? 
                           AND status = 'completed'";

// Prepare and execute the statement for the previous year
if ($cxr_5stmt = $conn->prepare($cxr_5sql_previous_year)) {
    // Bind parameters
    $cxr_5stmt->bind_param("ii", $userid, $cxr_5previous_year);
    // Execute the query
    $cxr_5stmt->execute();
    // Bind the result to the variable
    $cxr_5stmt->bind_result($cxr_5previous_year_amount_sum);
    // Fetch the result
    $cxr_5stmt->fetch();
    // Check if the result is null and assign zero if so
    $cxr_5previous_year_amount_sum = $cxr_5previous_year_amount_sum ?? 0;
    // Close the statement
    $cxr_5stmt->close();
} else {
    // Handle query preparation error
    // echo "Error preparing the query: " . $conn->error;
}

// Calculate the difference and the yearly percentage change
$cxr_5difference = $cxr_5yearly_amount_sum - $cxr_5previous_year_amount_sum;
if ($cxr_5previous_year_amount_sum != 0) {
    $cxr_5yearlypercentage_change = ($cxr_5difference / $cxr_5previous_year_amount_sum) * 100;
} else {
    $cxr_5yearlypercentage_change = $cxr_5yearly_amount_sum > 0 ? 100 : 0; // Avoid division by zero
}
// Determine the appropriate arrow and CSS class based on the percentage change
$arrow_icon = $cxr_5yearlypercentage_change >= 0 ? 'arrow_upward' : 'arrow_downward';
$arrow_class = $cxr_5yearlypercentage_change >= 0 ? 'bg-success text-success' : 'bg-danger text-danger';




// Get the current month and the previous month
$cxr_6current_month_start = date('Y-m-01');
$cxr_6current_month_end = date('Y-m-t');
$cxr_6previous_month_start = date('Y-m-01', strtotime('first day of last month'));
$cxr_6previous_month_end = date('Y-m-t', strtotime('last day of last month'));

// Prepare the SQL query to sum the amount for the current month with status 'completed'
$cxr_6sql_current_month = "SELECT SUM(amount) as cxr_6total_amount 
                           FROM withdrawals 
                           WHERE user_id = ? 
                           AND created_at BETWEEN ? AND ? 
                           AND status = 'completed'";

// Prepare and execute the statement for the current month
if ($cxr_6stmt = $conn->prepare($cxr_6sql_current_month)) {
    // Bind parameters
    $cxr_6stmt->bind_param("iss", $userid, $cxr_6current_month_start, $cxr_6current_month_end);
    // Execute the query
    $cxr_6stmt->execute();
    // Bind the result to the variable
    $cxr_6stmt->bind_result($cxr_6monthly_amount_sum);
    // Fetch the result
    $cxr_6stmt->fetch();
    // Check if the result is null and assign zero if so
    $cxr_6monthly_amount_sum = $cxr_6monthly_amount_sum ?? 0;
    // Close the statement
    $cxr_6stmt->close();
} else {
    // Handle query preparation error
    // echo "Error preparing the query: " . $conn->error;
}

// Prepare the SQL query to sum the amount for the previous month with status 'completed'
$cxr_6sql_previous_month = "SELECT SUM(amount) as cxr_6total_amount 
                            FROM withdrawals 
                            WHERE user_id = ? 
                            AND created_at BETWEEN ? AND ? 
                            AND status = 'completed'";

// Prepare and execute the statement for the previous month
if ($cxr_6stmt = $conn->prepare($cxr_6sql_previous_month)) {
    // Bind parameters
    $cxr_6stmt->bind_param("iss", $userid, $cxr_6previous_month_start, $cxr_6previous_month_end);
    // Execute the query
    $cxr_6stmt->execute();
    // Bind the result to the variable
    $cxr_6stmt->bind_result($cxr_6previous_month_amount_sum);
    // Fetch the result
    $cxr_6stmt->fetch();
    // Check if the result is null and assign zero if so
    $cxr_6previous_month_amount_sum = $cxr_6previous_month_amount_sum ?? 0;
    // Close the statement
    $cxr_6stmt->close();
} else {
    // Handle query preparation error
    // echo "Error preparing the query: " . $conn->error;
}

// Calculate the difference and the monthly percentage change
$cxr_6difference = $cxr_6monthly_amount_sum - $cxr_6previous_month_amount_sum;
if ($cxr_6previous_month_amount_sum != 0) {
    $cxr_6monthlypercentage_change = ($cxr_6difference / $cxr_6previous_month_amount_sum) * 100;
} else {
    $cxr_6monthlypercentage_change = $cxr_6monthly_amount_sum > 0 ? 100 : 0; // Avoid division by zero
}



////6 month


// Get the current date and calculate the start date of the current 6-month period
$CXR_7current_date = date('Y-m-d');
$CXR_7current_6months_start = date('Y-m-d', strtotime('-6 months', strtotime($CXR_7current_date)));

// Calculate the start date and end date of the previous 6-month period
$CXR_7previous_6months_start = date('Y-m-d', strtotime('-12 months', strtotime($CXR_7current_date)));
$CXR_7previous_6months_end = date('Y-m-d', strtotime('-6 months', strtotime($CXR_7current_date)));

// Prepare the SQL query to sum the amount for the current 6 months with status 'completed'
$CXR_7sql_current_6months = "SELECT SUM(amount) as CXR_7total_amount 
                             FROM withdrawals 
                             WHERE user_id = ? 
                             AND created_at BETWEEN ? AND ? 
                             AND status = 'completed'";

// Prepare and execute the statement for the current 6 months
if ($CXR_7stmt = $conn->prepare($CXR_7sql_current_6months)) {
    // Bind parameters
    $CXR_7stmt->bind_param("iss", $userid, $CXR_7current_6months_start, $CXR_7current_date);
    // Execute the query
    $CXR_7stmt->execute();
    // Bind the result to the variable
    $CXR_7stmt->bind_result($CXR_7semiannual_amount_sum);
    // Fetch the result
    $CXR_7stmt->fetch();
    // Check if the result is null and assign zero if so
    $CXR_7semiannual_amount_sum = $CXR_7semiannual_amount_sum ?? 0;
    // Close the statement
    $CXR_7stmt->close();
} else {
    // Handle query preparation error
    // echo "Error preparing the query: " . $conn->error;
}

// Prepare the SQL query to sum the amount for the previous 6 months with status 'completed'
$CXR_7sql_previous_6months = "SELECT SUM(amount) as CXR_7total_amount 
                              FROM withdrawals 
                              WHERE user_id = ? 
                              AND created_at BETWEEN ? AND ? 
                              AND status = 'completed'";

// Prepare and execute the statement for the previous 6 months
if ($CXR_7stmt = $conn->prepare($CXR_7sql_previous_6months)) {
    // Bind parameters
    $CXR_7stmt->bind_param("iss", $userid, $CXR_7previous_6months_start, $CXR_7previous_6months_end);
    // Execute the query
    $CXR_7stmt->execute();
    // Bind the result to the variable
    $CXR_7stmt->bind_result($CXR_7previous_semiannual_amount_sum);
    // Fetch the result
    $CXR_7stmt->fetch();
    // Check if the result is null and assign zero if so
    $CXR_7previous_semiannual_amount_sum = $CXR_7previous_semiannual_amount_sum ?? 0;
    // Close the statement
    $CXR_7stmt->close();
} else {
    // Handle query preparation error
    // echo "Error preparing the query: " . $conn->error;
}

// Calculate the difference and the semiannual percentage change
$CXR_7difference = $CXR_7semiannual_amount_sum - $CXR_7previous_semiannual_amount_sum;
if ($CXR_7previous_semiannual_amount_sum != 0) {
    $CXR_7semiannualpercentage_change = ($CXR_7difference / $CXR_7previous_semiannual_amount_sum) * 100;
} else {
    $CXR_7semiannualpercentage_change = $CXR_7semiannual_amount_sum > 0 ? 100 : 0; // Avoid division by zero
}

//cxrharder
/////fetcch number of rows where bank withdraws

// Prepare the SQL query to fetch the number of completed withdrawals for the specified user
$cxr_99query = "SELECT COUNT(*) as count FROM withdrawals WHERE status = 'completed' AND user_id = ?";
$cxr_99stmt = $conn->prepare($cxr_99query);
$cxr_99stmt->bind_param("i", $userid);
$cxr_99stmt->execute();
$cxr_99result = $cxr_99stmt->get_result();

// Fetch the number of rows and assign it to the variable
$cxr_99row = $cxr_99result->fetch_assoc();
$cxr_99completed_withdrawals = $cxr_99row['count'];

$cxr_99stmt->close();


/////fetcch number of rows where upi payout withdraws
// Prepare the SQL query to fetch the number of completed withdrawals for the specified user
$cxr100query = "SELECT COUNT(*) as count FROM withdrawals_upi WHERE status = 'completed' AND user_id = ?";
$cxr100stmt = $conn->prepare($cxr100query);
$cxr100stmt->bind_param("i", $userid);
$cxr100stmt->execute();
$cxr100result = $cxr100stmt->get_result();

// Fetch the number of rows and assign it to the variable
$cxr100row = $cxr100result->fetch_assoc();
$cxr100completed_withdrawals = $cxr100row['count'];

$cxr100stmt->close();


//for expriry check 
// Fetch created_at from the database
$query = "SELECT created_at FROM users WHERE id = ?";
$stmt = $conn->prepare($query);
$stmt->bind_param("i", $userid);
$stmt->execute();
$stmt->bind_result($created_at);
$stmt->fetch();
$stmt->close();

$trialEndDate = date("Y-m-d", strtotime($created_at . ' +7 days')); // Add 7 days
$today = date("Y-m-d"); // Get current date

$isExpired = ($today > $trialEndDate) ? true : false; // Check if trial is expired

?>

 <!--start main wrapper-->
  <main class="main-wrapper">
    <div class="main-content">
        
        <div class="d-flex flex-wrap justify-content-between flex-1"><div class="mb-lg-0 mb-2 me-8">
            <h1 class="pg-title" style="font-size: 1.75rem;">Welcome, <?php echo htmlspecialchars($username); ?></h1>
            <p>Accept payments online hassle-free with our QR code service.</p>
            </div>
            <div class="pg-header-action-wrap">
            </div>
        </div>
        
        
      <?php if ($isExpired != 'true') { ?>
<div class="row">
    <div class="col-12">
        <div class="card rounded-4 w-100 p-3">
            <div class="card-body d-flex align-items-center gap-3 flex-column flex-md-row text-center text-md-start">
                <img src="assets/images/demo_aadhaar.png" alt="KYC" class="img-fluid" style="max-width: 100px; height: auto; object-fit: contain;" />
                <div class="flex-grow-1">
                    <h5 class="mb-2 text-wrap" style="word-break: break-word;">
                        Complete KYC process quickly in just 10 seconds
                    </h5>
                    <p class="text-secondary mt-2 mb-0 text-wrap" style="word-break: break-word;">
                        Complete KYC Verification & Enjoy Uninterrupted Access to PROBOT UPI Services
                    </p>
                </div>
                <div class="mt-3 mt-md-0 ms-md-auto d-flex align-items-center justify-content-center">
                    <a class="d-flex flex-row align-items-center text-decoration-none text-primary" href="kyc">
                        <span class="icon text-center me-1">
                            <span class="feather-icon">
                                <svg xmlns="http://www.w3.org/2000/svg" width="24" height="24" viewBox="0 0 24 24" fill="none" stroke="currentColor" stroke-width="2" stroke-linecap="round" stroke-linejoin="round" class="feather feather-check-circle">
                                    <circle cx="12" cy="12" r="10"></circle>
                                    <path d="M9 12l2 2 4-4"></path>
                                </svg>
                            </span>
                        </span>
                    <span class="text-decoration-underline">Verify Now</span>
                    </a>
                </div>
            </div>
        </div>
    </div>
</div>

<?php } ?>


<!--<div class="row">
    <div class="col-12">
        <div class="card rounded-4 w-100">
            <div class="card-body d-flex align-items-center gap-3 px-4">
                <img src="assets/images/demo_aadhaar.png" alt="Image description" style="width: 120px; height: 80px;" />
                <div>
                    <h5 class="mb-2">Complete KYC process quickly in just 10 seconds</h5>
                    <h6 class="text-secondary mt-2">Complete KYC Verification & Enjoy Uninterrupted Access to UPIGateway Services</h6>
                </div>
                <div class="mt-3 mt-md-0 ms-auto d-md-flex align-items-center justify-content-center flex-column h-100">
                    <a class="d-flex flex-row" href="#">
                        <span class="icon text-center">
                            <span class="feather-icon">
                                
                                <svg xmlns="http://www.w3.org/2000/svg" width="24" height="24" viewBox="0 0 24 24" fill="none" stroke="currentColor" stroke-width="2" stroke-linecap="round" stroke-linejoin="round" class="feather feather-check-circle"><path d="M22 11.08V12a10 10 0 1 1-5.93-9.14"></path><polyline points="22 4 12 14.01 9 11.01"></polyline></svg>
                            </span>
                        </span>
                        <span class="me-1"><u> Verify Now</u></span>
                    </a>
                </div>
            </div>
        </div>
    </div>
</div>
-->
        <div class="row">
          <div class="col-12 col-xl-4 d-flex">
             <div class="card rounded-4 w-100">
               <div class="card-body">
                 <div class="d-flex align-items-center gap-3 mb-2">
                    <div class="">
                      <h2 class="mb-0">₹<?php echo intval($cxrweeklypayment); ?></h2>
                    </div>
                    <div class="">
                      <p class="dash-lable d-flex align-items-center gap-1 rounded mb-0 <?php echo ($weekly_transaction_ratio < 0) ? 'bg-danger text-danger' : 'bg-success text-success'; ?> bg-opacity-10">
                <span class="material-symbols-rounded fs-6">
                    <?php echo ($weekly_transaction_ratio < 0) ? 'arrow_downward' : 'arrow_upward'; ?>
                </span>
                    <?php echo number_format(abs($weekly_transaction_ratio), 2); ?>%
                        </p>

                    </div>
                  </div>
                  <p class="mb-0">Average Weekly Payments</p>
                   <div id="chart1"></div>
               </div>
             </div>
          </div>
          
          
          <div class="col-12 col-xl-8 d-flex flex-wrap gap-3">
  
  <div class="card rounded-4 flex-grow-1">
    <div class="card-body text-center p-4">
      <a href="javascript:;" class="mb-2 wh-48 bg-primary bg-opacity-10 text-primary rounded-circle d-flex align-items-center justify-content-center mx-auto">
        <i class="material-symbols-rounded">shopping_cart</i>
      </a>
      <h3 class="mb-0"><?php echo $cxr_total_orders?></h3>
      <p class="mb-0">API Orders</p>
    </div>
  </div>

  <div class="card rounded-4 flex-grow-1">
    <div class="card-body text-center p-4">
      <a href="javascript:;" class="mb-2 wh-48 bg-success bg-opacity-10 text-success rounded-circle d-flex align-items-center justify-content-center mx-auto">
        <i class="material-symbols-rounded">print</i>
      </a>
      <h3 class="mb-0">₹<?php echo $cxr_2today_success_amount?></h3>
      <p class="mb-0">Transactions</p>
    </div>
  </div>

  <div class="card rounded-4 flex-grow-1">
    <div class="card-body text-center p-4">
      <a href="javascript:;" class="mb-2 wh-48 bg-danger bg-opacity-10 text-danger rounded-circle d-flex align-items-center justify-content-center mx-auto">
        <i class="material-symbols-rounded">notifications</i>
      </a>
      <h3 class="mb-0"><?php echo $cxrpendingnotificationscount?></h3>
      <p class="mb-0">Notifications</p>
    </div>
  </div>

  <div class="card rounded-4 flex-grow-1">
    <div class="card-body text-center p-4">
      <a href="javascript:;" class="mb-2 wh-48 bg-info bg-opacity-10 text-info rounded-circle d-flex align-items-center justify-content-center mx-auto">
        <i class="material-symbols-rounded">payment</i>
      </a>
      <h3 class="mb-0">₹<?php echo $cxr_3last24hourpayouttotalamount?></h3>
      <p class="mb-0">Payouts</p>
    </div>
  </div>

</div>

        
        <div class="row">
          <div class="col-12 col-xl-5 col-xxl-4 d-flex">
            <div class="card rounded-4 w-100 shadow-none bg-transparent border-0">
               <div class="card-body p-0">
                 <div class="row g-4">
                    <div class="col-12 col-xl-6 d-flex">
                      <div class="card mb-0 rounded-4 w-100">
                       <div class="card-body">
                         <div class="d-flex align-items-start justify-content-between mb-3">
                           <div class="">
                             <h4 class="mb-0"><?php echo $cxr100completed_withdrawals;?></h4>
                             <p class="mb-0">Upi Payouts</p>
                           </div>
                           <div class="dropdown">
                             <a href="javascript:;" class="dropdown-toggle-nocaret options dropdown-toggle"
                               data-bs-toggle="dropdown">
                               <span class="material-symbols-rounded fs-5">more_vert</span>
                             </a>
                             <ul class="dropdown-menu">
                               <li><a class="dropdown-item" href="javascript:;">Action</a></li>
                             </ul>
                           </div>
                         </div>
                         
                         
                         <div class="chart-container2">
                           <div id="chart3"></div>
                         </div>
                         <div class="text-center">
                          <p class="mb-0"><span class="text-success me-1">12.5%</span> from last month</p>
                        </div>
                       </div>
                      </div>
                   </div>
                   <div class="col-12 col-xl-6 d-flex">
                    <div class="card mb-0 rounded-4 w-100">
                     <div class="card-body">
                       <div class="d-flex align-items-start justify-content-between mb-1">
                         <div class="">
                           <h4 class="mb-0"><?php echo $cxr_99completed_withdrawals; ?></h4>
                           <p class="mb-0">Bank Payouts</p>
                         </div>
                         <div class="dropdown">
                           <a href="javascript:;" class="dropdown-toggle-nocaret options dropdown-toggle"
                             data-bs-toggle="dropdown">
                             <span class="material-symbols-rounded fs-5">more_vert</span>
                           </a>
                           <ul class="dropdown-menu">
                             <li><a class="dropdown-item" href="javascript:;">Action</a></li>
                           </ul>
                         </div>
                       </div>
                       
                       
                      
                       <div class="chart-container2">
                         <div id="chart2"></div>
                       </div>
                       <div class="text-center">
                         <p class="mb-0">₹<?php echo intval($cxr_4lifetimepayoutamount); ?> Total LifeTime Bank Payout Amount</p>
                       </div>
                     </div>
                    </div>
                 </div>
                   <div class="col-12 col-xl-12">
                    <div class="card rounded-4 mb-0">
                      <div class="card-body">
                        <div class="d-flex align-items-center gap-3 mb-2">
                           <div class="">
                             <h2 class="mb-0">₹<?php echo $cxr_5yearly_amount_sum ?></h2>
                           </div>
                           <div class="">
                             <p class="dash-lable d-flex align-items-center gap-1 rounded mb-0 bg-success text-success bg-opacity-10"><span class="material-symbols-rounded fs-6">arrow_upward</span><?php echo number_format($cxr_5yearlypercentage_change, 2) . "%"; ?></p>
                           </div>
                         </div>
                         <p class="mb-0">Payouts This Year</p>
                          <div class="mt-4">
                            <p class="mb-2 d-flex align-items-center justify-content-between">
     <?php  
    echo intval(number_format($cxr_5difference, 2));
?> left to Goal<span class="">
    <?php echo number_format($cxr_5yearlypercentage_change, 2) . "%"; ?>
    </span>
</p>

                            <div class="progress w-100" style="height: 7px;">
                             <!-- <div class="progress-bar bg-primary" style="width: 65%"></div>-->
                             <div class="progress-bar bg-primary" style="width: <?php echo $cxr_5yearlypercentage_change; ?>%;"></div>
                            </div>
                          </div>
                          
                      </div>
                    </div>
                  </div>

                 </div><!--end row-->
               </div>
            </div>  
          </div> 
          <div class="col-12 col-xl-7 col-xxl-8 d-flex">
            <div class="card w-100 rounded-4">
               <div class="card-body">
                <div class="d-flex align-items-start justify-content-between mb-3">
                  <div class="">
                    <h5 class="mb-0 fw-bold">Sales & Views</h5>
                  </div>
                  <div class="dropdown">
                    <a href="javascript:;" class="dropdown-toggle-nocaret options dropdown-toggle"
                      data-bs-toggle="dropdown">
                      <span class="material-symbols-rounded fs-5">more_vert</span>
                    </a>
                    <ul class="dropdown-menu">
                      <li><a class="dropdown-item" href="javascript:;">Action</a></li>
                    </ul>
                  </div>
                 </div>
                 
                 
                 
                  <div id="chart4"></div>
                  <div id="chart5"></div>
                  <div class="d-flex flex-column flex-lg-row align-items-start justify-content-around border p-3 rounded-4 mt-3 gap-3">
                    <div class="d-flex align-items-center gap-4">
                      <div class="">
                        <p class="mb-0 data-attributes">
                          <span
                            data-peity='{ "fill": ["#0d6efd", "rgb(0 0 0 / 10%)"], "innerRadius": 32, "radius": 40 }'>5/7</span>
                        </p>
                      </div>
                      <diiv class="">
                        <p class="mb-1 fs-6 fw-bold">Monthly Payouts</p>
                        <h2 class="mb-0">₹<?php echo $cxr_6monthly_amount_sum?></h2>
                        <p class="mb-0"><span class="text-success me-2 fw-medium"><?php echo $cxr_6monthlypercentage_change?>%</span><span><?php echo number_format($cxr_6monthly_amount_sum/83, 2); ?> USD</span></p>
                      </diiv>
                    </div>
                    <div class="vr"></div>
                    <div class="d-flex align-items-center gap-4">
                      <div class="">
                        <p class="mb-0 data-attributes">
                          <span
                            data-peity='{ "fill": ["#6f42c1", "rgb(0 0 0 / 10%)"], "innerRadius": 32, "radius": 40 }'>5/7</span>
                        </p>
                      </div>
                      <div class="">
                        <p class="mb-1 fs-6 fw-bold">Semi-Annual</p>
                        <h2 class="mb-0">₹<?php echo $CXR_7semiannual_amount_sum?></h2>
                        <p class="mb-0">
    <span class="text-success me-2 fw-medium"><?php echo $CXR_7semiannualpercentage_change; ?>%</span>
    <span><?php echo number_format($CXR_7semiannual_amount_sum / 83, 2); ?> USD</span>
                      </div>
                    </div>
                  </div>
               </div>
            </div>  
          </div> 
        </div><!--end row-->
        

        

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