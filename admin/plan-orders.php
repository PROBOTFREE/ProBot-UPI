<?php
 // Define the constant

session_start();


// Dene the absolute path to the functions.php file
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


$sql = "SELECT id, order_id, user_id,status, amount, plan_id, plan_type, notifi_send, created_at 
        FROM plan_orders 
        ORDER BY created_at ASC";
$result = $conn->query($sql);


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
    

 <!--start wrapper-->
    <div class="wrapper">
       
       
        <?php require_once(ABSPATH1 . 'header.php'); ?>


        <!-- start page content wrapper-->
        <div class="page-content-wrapper">
          <!-- start page content-->
         <div class="page-content">

          <!--start breadcrumb-->
          <div class="page-breadcrumb d-none d-sm-flex align-items-center mb-3">
            <div class="breadcrumb-title pe-3">Settings</div>
            <div class="ps-3">
              <nav aria-label="breadcrumb">
                <ol class="breadcrumb mb-0 p-0 align-items-center">
                  <li class="breadcrumb-item"><a href="javascript:;"><ion-icon name="home-outline"></ion-icon></a>
                  </li>
                  <li class="breadcrumb-item active" aria-current="page">Plan Orders</li>
                </ol>
              </nav>
            </div>
            <div class="ms-auto">
              <div class="btn-group">
                <button type="button" class="btn btn-outline-primary">Settings</button>
                <button type="button" class="btn btn-outline-primary split-bg-primary dropdown-toggle dropdown-toggle-split" data-bs-toggle="dropdown">	<span class="visually-hidden">Toggle Dropdown</span>
                </button>
                <div class="dropdown-menu dropdown-menu-right dropdown-menu-lg-end">	<a class="dropdown-item" href="javascript:;">Action</a>
                  <a class="dropdown-item" href="javascript:;">Another action</a>
                  <a class="dropdown-item" href="javascript:;">Something else here</a>
                  <div class="dropdown-divider"></div>	<a class="dropdown-item" href="javascript:;">Separated link</a>
                </div>
              </div>
            </div>
          </div>
          <!--end breadcrumb-->


         <h6 class="mb-0 text-uppercase">Plan Orders Data</h6>
<hr/>
<div class="card">
    <div class="card-body">
        <div class="table-responsive">
            <table id="example" class="table table-striped table-bordered" style="width:100%">
                <thead>
                    <tr>
                                        <th>S. No</th>
                                        <th>Order Id</th>
                                        <th>Status</th>
                                        <th>User Id</th>
                                        <th>Amount</th>
                                        <th>Plan Id</th>
                                        <th>Plan Type</th>
                                        <th>Notification Sent</th>
                                        <th>Created At</th>
                                    </tr>
                </thead>
                <tbody>
                                    <?php
$serial_number = 1; // Initialize a counter variable
if ($result->num_rows > 0) {
    while($row = $result->fetch_assoc()) {
        $status = $row["status"]; // Define the status variable here

        // Determine the Bootstrap class based on status
        $status_class = '';
        if ($status == "cancel") {
            $status_class = 'text-danger'; // Red color for cancelled status
        } elseif ($status == "success") {
            $status_class = 'text-success'; // Green color for success status
        } elseif ($status == "pending") {
            $status_class = 'text-warning'; // Yellow color for pending status
        } else {
            $status_class = 'text-secondary'; // Default color for other statuses
        }

        echo "<tr>";
        echo "<td>" . $serial_number++ . "</td>";
        echo "<td>" . $row["order_id"] . "</td>";
        echo "<td class='$status_class'>" . $status . "</td>"; // Apply Bootstrap class here
        echo "<td>" . $row["user_id"] . "</td>";
        echo "<td>₹ " . number_format($row["amount"], 2) . "</td>";
        echo "<td>" . $row["plan_id"] . "</td>";
        echo "<td>" . $row["plan_type"] . "</td>";
        echo "<td>" . ($row["notifi_send"] ? 'Yes' : 'No') . "</td>";
        echo "<td>" . $row["created_at"] . "</td>";
        echo "</tr>";
    }
} else {
    echo "<tr><td colspan='9'>No records found</td></tr>";
}
?>

            </table>
        </div>
    </div>
</div>

				
				
			
             

          </div>
          <!-- end page content-->
         </div>
         


         <!--Start Back To Top Button-->
		     <a href="javaScript:;" class="back-to-top"><ion-icon name="arrow-up-outline"></ion-icon></a>
			 <!--End Back To Top Button-->
	  
			


         <!--start overlay-->
          <div class="overlay nav-toggle-icon"></div>
         <!--end overlay-->

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