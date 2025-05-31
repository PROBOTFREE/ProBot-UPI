<?php

// Dene the absolute path to the functions.php file
define('ABSPATH', dirname(__FILE__) . '/'); // Adjust the path as needed
// Include the database connection file
require_once(ABSPATH . 'header.php');


?>
<head>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
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
  
  <!-- SweetAlert2 -->
    <script src="https://cdn.jsdelivr.net/npm/sweetalert2@11"></script>
    
    <style>
    
        
    .message-box {
        opacity: 0;
        transition: opacity 0.5s ease-in-out;
    }
    
    .message-box.show {
        opacity: 1;
    }
    
    .success-message {
    max-width: 450px;
    width: 100%;
    margin: 20px auto;
    padding: 10px;
    background-color: #d4edda;
    color: #155724;
    border: 1px solid #c3e6cb;
    border-radius: 5px;
    text-align: center;
    font-weight: bold;
    position: relative;
    align-items: center;
    justify-content: space-between;
    display: flex;
}

    .error-message {
        max-width: 450px;
        width: 100%;
        margin: 20px auto;
        padding: 10px;
        background-color: #f8d7da;
        color: #721c24;
        border: 1px solid #f5c6cb;
        border-radius: 5px;
        text-align: center;
        font-weight: bold;
        position: relative;
        align-items: center;
        justify-content: space-between;
        display: flex; /* Always display, hide using JS */
    }
    .close-btn {
        background: none;
        border: none;
        font-size: 18px;
        font-weight: bold;
        color: #721c24;
        cursor: pointer;
        margin-left: 10px;
    }
</style>

  
  <style>
.swal2-border-radius {
    border-radius: 20px !important; /* Adjust the value as needed */
}
.swal2-confirm-lg {
        border-radius: 50px !important; /* Adjust the value as needed */
        font-size: 18px !important; /* Larger text */
        padding: 14px 40px !important; /* Increased width padding */
        min-width: 150px !important; /* Ensures wider button */
    }
</style>
  
</head>




<?php

$userid=$_SESSION['user_id'];

$errorMessage = ""; // Initialize error message variable
$successMessage = ""; // Initialize success message variable

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
$isExpired = ($vip_expiry !== null && $vip_expiry < $today);

// Set error message if VIP is expired
if ($isExpired) {
    $errorMessage = "❌ Please renew the VIP plan to get access!";
}


if (isset($_POST['delete'])) {
    

    $merchant_type = mysqli_real_escape_string($conn, $_POST['merchant_type']);
    $token = $userdata['user_token'];

    // Initialize the delete and update queries
    $del = "";
    $update = "";

    // Construct the delete and update queries based on merchant type
    if ($merchant_type == 'hdfc') {
        $del = "DELETE FROM hdfc WHERE user_token = '$token'";
        $update = "UPDATE users SET hdfc_connected = 'No' WHERE user_token = '$token'";
    } elseif ($merchant_type == 'phonepe') {
        $del = "DELETE FROM phonepe_tokens WHERE user_token = '$token'";
        $update = "UPDATE users SET phonepe_connected = 'No' WHERE user_token = '$token'";
        
        // Add a query to delete from the store_id table as well
        $del_store_id = "DELETE FROM store_id WHERE user_token = '$token'";
        mysqli_query($conn, $del_store_id);
    } elseif ($merchant_type == 'paytm') {
        $del = "DELETE FROM paytm_tokens WHERE user_token = '$token'";
        $update = "UPDATE users SET paytm_connected = 'No' WHERE user_token = '$token'";
    } elseif ($merchant_type == 'bharatpe') {
        $del = "DELETE FROM bharatpe_tokens WHERE user_token = '$token'";
        $update = "UPDATE users SET bharatpe_connected = 'No' WHERE user_token = '$token'";
    }  elseif ($merchant_type == 'googlepay') {
        
        $del = "DELETE FROM googlepay_tokens WHERE user_token = '$token'";
        $update = "UPDATE users SET googlepay_connected = 'No' WHERE user_token = '$token'";
        
    } elseif ($merchant_type == 'freecharge') { 
            $del = "DELETE FROM freecharge_tokens WHERE user_token = '$token'"; $update = "UPDATE users SET freecharge_connected = 'No' WHERE user_token = '$token'";
    }

    // Execute the delete query
    $res_del = mysqli_query($conn, $del);

    // Execute the update query
    $res_update = mysqli_query($conn, $update);

    if ($res_del && $res_update) {
        $successMessage = "✅ Congratulations! Your Merchant Has been Deleted Successfully!";
    } else {
       
       $errorMessage = "❌ Error: Could not delete merchant. Please try again.";
    }
}

?>

<!--start main wrapper-->
<main class="main-wrapper">
  <div class="main-content">
      
<h6 class="mb-0 text-uppercase">
    <a href="upisettings">← Go Back</a>
</h6>

    <hr>
    <?php if (!empty($errorMessage)) { ?>
    <div id="error-message" class="error-message message-box">
        <span><?php echo $errorMessage; ?></span>
        <button class="close-btn" onclick="closeMessage('error-message')">✖</button>
    </div>
<?php } ?>

<?php if (!empty($successMessage)) { ?>
    <div id="success-message" class="success-message message-box">
        <span><?php echo $successMessage; ?></span>
        <button class="close-btn" onclick="closeMessage('success-message')">✖</button>
    </div>
<?php } ?>

    
    <?php if (!$isExpired) { ?>
    <div class="card">
      <div class="card-body">
        <div class="table-responsive">
          <table id="example" class="table table-striped" style="width:100%">
            <thead>
              <tr>
                <th>No</th>
                <th>Merchant Type</th>
                <th>Merchant Number</th>
                <th>Last Sync</th>
                <th>Status</th>
                <th>Verify</th>
                <th>Delete</th>
              </tr>
            </thead>
            <tbody>
                    <?php
                    $cxrrrrtoken = $userdata['user_token'];
                    $fetchData = "
                        SELECT 'hdfc' AS merchant_type, id, number, date, status FROM hdfc WHERE user_token = '$cxrrrrtoken' 
                        UNION ALL 
                        SELECT 'phonepe' AS merchant_type, sl AS id, phoneNumber AS number, date, status FROM phonepe_tokens WHERE user_token = '$cxrrrrtoken'
                        UNION ALL
                        SELECT 'paytm' AS merchant_type, id, phoneNumber AS number, date, status FROM paytm_tokens WHERE user_token = '$cxrrrrtoken'
                        UNION ALL
                        SELECT 'bharatpe' AS merchant_type, id, phoneNumber AS number, date, status FROM bharatpe_tokens WHERE user_token = '$cxrrrrtoken'
                        UNION ALL
                        SELECT 'googlepay' AS merchant_type, id, phoneNumber AS number, date, status FROM googlepay_tokens WHERE user_token = '$cxrrrrtoken'
                        UNION ALL
                        SELECT 'freecharge' AS merchant_type, id, phoneNumber AS number, date, status FROM freecharge_tokens WHERE user_token = '$cxrrrrtoken'
                    ";

                    $ssData = mysqli_query($conn, $fetchData);

                    if (mysqli_num_rows($ssData) > 0) {
                        $counter = 1;
                        while ($merchant = mysqli_fetch_array($ssData)) {
                            $class = ($merchant['status'] == 'Active') ? 'badge badge-success' : 'badge badge-danger';
                            ?>
                            <tr>
                                <td><?php echo $counter++; ?></td>
                                <td><?php echo !empty($merchant['merchant_type']) ? strtoupper(htmlspecialchars($merchant['merchant_type'], ENT_QUOTES, 'UTF-8')) : ''; ?></td>
                                <td><?php echo !empty($merchant['number']) ? htmlspecialchars($merchant['number'], ENT_QUOTES, 'UTF-8') : ''; ?></td>
                                <td>
                                    <button type="button" class="btn ripple btn-primary px-2"><?php echo !empty($merchant['date']) ? htmlspecialchars($merchant['date'], ENT_QUOTES, 'UTF-8') : ''; ?></button>
                                    
                                    </td>
                                    </button>
                                <td style="color: <?php echo ($merchant['status'] == 'Active') ? 'green' : (($merchant['status'] != 'Active') ? 'red' : 'yellow'); ?>">
    <?php echo htmlspecialchars($merchant['status'], ENT_QUOTES, 'UTF-8'); ?>
</td>

                                <td>
    <?php
    if ($merchant['merchant_type'] == 'hdfc') {
        // HDFC specific actions
        ?>
        <form action="send_hdfcotp" method="post">
            <input type="hidden" name="hdfc_mobile" value="<?php echo $merchant['number']; ?>">
            
            <button class="btn ripple btn-primary px-2" name="Verify">Verify</button>
        </form>
        <?php
    } elseif ($merchant['merchant_type'] == 'phonepe') {
        // Phonepe specific actions
        ?>
        <form action="send_phonepeotp" method="post">
            <input type="hidden" name="phonepe_mobile" value="<?php echo $merchant['number']; ?>">
            
            <button class="btn ripple btn-primary px-2" name="Verify">Verify</button>
        </form>
        <?php
    } elseif ($merchant['merchant_type'] == 'paytm') {
        // Paytm specific actions
        ?>
        <form action="send_paytmotp" method="post">
            <input type="hidden" name="paytm_mobile" value="<?php echo $merchant['number']; ?>">
            
            <button class="btn ripple btn-primary px-2" name="Verify">Verify</button>
        </form>
        <?php
    } elseif ($merchant['merchant_type'] == 'bharatpe') {
        // Bharatpe specific actions
        ?>
        <form action="send_bharatpeotp" method="post">
            <input type="hidden" name="bharatpe_mobile" value="<?php echo $merchant['number']; ?>">
            
            <button class="btn ripple btn-primary px-2" name="Verify">Verify</button>
        </form>
        <?php
    } elseif ($merchant['merchant_type'] == 'googlepay') {
        ?>
        <form action="send_googlepayotp" method="post">
            <input type="hidden" name="googlepay_mobile" value="<?php echo $merchant['number']; ?>">
            
            <button class="btn ripple btn-primary px-2" name="Verify">Verify</button>
        </form>
        <?php
    } elseif ($merchant['merchant_type'] == 'freecharge') {
        ?>
        <form action="send_freechargeotp" method="post">
            <input type="hidden" name="freecharge_mobile" value="<?php echo $merchant['number']; ?>">
             
            <button class="btn ripple btn-primary px-2" name="Verify">Verify</button>
        </form>
         
       <?php
        }
    ?>
</td>
<td>
    <?php
    if ($merchant['merchant_type'] == 'hdfc') {
        // HDFC specific actions
        ?>
        <form method="POST" action="<?php echo htmlspecialchars($_SERVER["PHP_SELF"]); ?>">
            <input type="hidden" name="hdfc_mobile" value="<?php echo $merchant['number']; ?>">
            <input type="hidden" name="merchant_type" value="hdfc">
            
           
            <button class="btn ripple btn-danger px-2" name="delete">Delete</button>
        </form>
        <?php
    } elseif ($merchant['merchant_type'] == 'phonepe') {
        // Phonepe specific actions
        ?>
        <form method="POST" action="<?php echo htmlspecialchars($_SERVER["PHP_SELF"]); ?>">
            <input type="hidden" name="phonepe_mobile" value="<?php echo $merchant['number']; ?>">
            
          
            <input type="hidden" name="merchant_type" value="phonepe">
            <button class="btn ripple btn-danger px-2" name="delete">Delete</button>
        </form>
        <?php
    } elseif ($merchant['merchant_type'] == 'paytm') {
        // Paytm specific actions
        ?>
        <form method="POST" action="<?php echo htmlspecialchars($_SERVER["PHP_SELF"]); ?>">
            <input type="hidden" name="paytm_mobile" value="<?php echo $merchant['number']; ?>">
            
         
            <input type="hidden" name="merchant_type" value="paytm">
            <button class="btn ripple btn-danger px-2" name="delete">Delete</button>
        </form>
        <?php
    } elseif ($merchant['merchant_type'] == 'bharatpe') {
        // Bharatpe specific actions
        ?>
        <form method="POST" action="<?php echo htmlspecialchars($_SERVER["PHP_SELF"]); ?>">
            <input type="hidden" name="bharatpe_mobile" value="<?php echo $merchant['number']; ?>">
            
           
            <input type="hidden" name="merchant_type" value="bharatpe">
            <button class="btn ripple btn-danger px-2" name="delete">Delete</button>
        </form>
        <?php
    } elseif ($merchant['merchant_type'] == 'googlepay') {
        ?>
        <form method="POST" action="<?php echo htmlspecialchars($_SERVER["PHP_SELF"]); ?>">
            <input type="hidden" name="googlepay_mobile" value="<?php echo $merchant['number']; ?>">
            
           
            <input type="hidden" name="merchant_type" value="googlepay">
            <button class="btn ripple btn-danger px-2" name="delete">Delete</button>
        </form>
        <?php
    } elseif ($merchant['merchant_type'] == 'freecharge') {
        ?>
        <form method="POST" action="<?php echo htmlspecialchars($_SERVER["PHP_SELF"]); ?>">
         <input type="hidden" name="freecharge_mobile" value="<?php echo $merchant['number']; ?>">
          
          
          <input type="hidden" name="merchant_type" value="freecharge">
           <button class="btn ripple btn-danger px-2" name="delete">Delete</button>
         </form>
        <?php
    }
    ?>
</td>
                            </tr>
                            <?php
                        }
                    }
                    ?>
                </tbody>
          </table>
        </div>
      </div>
    </div>
    <?php } ?>
    
    
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
        function closeMessage(id) {
    let element = document.getElementById(id);
    if (element) {
        element.style.opacity = "0";
        setTimeout(() => {
            element.style.display = "none"; // Hide instead of removing
        }, 500);
    }
}


        
        // Auto-show message with fade-in
        document.addEventListener("DOMContentLoaded", function () {
        let errorBox = document.getElementById("error-message");
        let successBox = document.getElementById("success-message");

        if (errorBox) {
            errorBox.classList.add("show");
            setTimeout(() => closeMessage("error-message"), 5000);
        }

        if (successBox) {
            successBox.classList.add("show");
            setTimeout(() => closeMessage("success-message"), 5000);
        }
        });

    </script>
	
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

