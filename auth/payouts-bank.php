<?php
// PHP code


// Define the absolute path to the functions.php file
define('ABSPATH', dirname(__FILE__) . '/'); // Adjust the path as needed

require_once(ABSPATH . 'header.php');
require_once(ABSPATH . '../pages/dbFunctions.php');
// Retrieve user ID from the session
$user_id = $_SESSION['user_id'];

// Query to retrieve payouts history for the user
$sql = "SELECT withdraw_id, created_at, amount,ifsc_code, bank_account_number, status FROM withdrawals WHERE user_id = ? ORDER BY created_at DESC";
$stmt = $conn->prepare($sql);
$stmt->bind_param("i", $user_id);
$stmt->execute();
$result = $stmt->get_result();
// Close the statement
$stmt->close();
?>
<head>
<!--favicon-->
  <link rel="icon" href="assets/images/favicon-32x32.png" type="image/png">

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
  </head>
<!--start main wrapper-->
<main class="main-wrapper">
  <div class="main-content">
    <!--breadcrumb-->
    <div class="page-breadcrumb d-none d-sm-flex align-items-center mb-3">
      <div class="breadcrumb-title pe-3">Service Area</div>
      <div class="ps-3">
        <nav aria-label="breadcrumb">
          <ol class="breadcrumb mb-0 p-0">
            <li class="breadcrumb-item"><a href="javascript:;"><i class="bx bx-home-alt"></i></a>
            </li>
            <li class="breadcrumb-item active" aria-current="page">Payouts History</li>
          </ol>
        </nav>
      </div>
    </div>
    <!--end breadcrumb-->
    
    <h6 class="mb-0 text-uppercase">Bank PAYOUTS</h6>
    <hr>
    <div class="card">
      <div class="card-body">
        <div class="table-responsive">
          <table id="example" class="table table-striped table-bordered" style="width:100%">
            <thead>
              <tr>
                <th>No</th>
                <th>Payout ID</th>
                <th>Date</th>
                <th>Time</th>
                <th>Amount</th>
                <th>Acc No</th>
                <th>IFSC</th>
                <th>Status</th>
              </tr>
            </thead>
            <tbody>
              <?php $row_num = 1; // Initialize row number ?>
              <?php while ($row = $result->fetch_assoc()): ?>
              <tr>
                <td><?php echo $row_num++; ?></td>
                <td><?php echo $row['withdraw_id']; ?></td>
                <td><?php
                  // Convert the database datetime to the desired format for date
                  $date = strtotime($row['created_at']);
                  $formatted_date = date('Y-m-d', $date);
                  echo $formatted_date;
                  ?></td>
                <td><?php
                  // Convert the database datetime to the desired format for time
                  $time = strtotime($row['created_at']);
                  $formatted_time = date('h:i:s A', $time);
                  echo $formatted_time;
                  ?></td>
                <td>₹<?php echo $row['amount']; ?></td>
                <td><?php echo $row['bank_account_number']; ?></td>
                <td><?php echo $row['ifsc_code']; ?></td>
                <td style="color: <?php echo ($row['status'] == 'completed') ? 'green' : (($row['status'] == 'pending') ? 'orange' : (($row['status'] == 'processing') ? 'blue' : 'red')); ?>">
    <?php echo htmlspecialchars($row['status'], ENT_QUOTES, 'UTF-8'); ?>
</td>


              </tr>
              <?php endwhile; ?>
            </tbody>
          </table>
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
  <script src="assets/plugins/datatable/js/jquery.dataTables.min.js"></script>
	<script src="assets/plugins/datatable/js/dataTables.bootstrap5.min.js"></script>
	<script>
		$(document).ready(function() {
			$('#example').DataTable();
		  } );
	</script>
	<script>
		$(document).ready(function() {
			var table = $('#example2').DataTable( {
				lengthChange: false,
				buttons: [ 'copy', 'excel', 'pdf', 'print']
			} );
		 
			table.buttons().container()
				.appendTo( '#example2_wrapper .col-md-6:eq(0)' );
		} );
	</script>
  <script src="assets/plugins/simplebar/js/simplebar.min.js"></script>
  <script src="assets/js/main.js"></script>
  
</body>

</html>