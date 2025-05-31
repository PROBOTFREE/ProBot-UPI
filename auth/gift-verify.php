
<?php
// PHP code


// Define the absolute path to the functions.php file
define('ABSPATH', dirname(__FILE__) . '/'); // Adjust the path as needed

require_once(ABSPATH . 'header.php');
require_once(ABSPATH . '../pages/dbFunctions.php');
?>

<head>
  <!--favicon-->
	<link rel="icon" href="assets/images/favicon-32x32.png" type="image/png">

  <!--plugins-->
  <link href="assets/plugins/perfect-scrollbar/css/perfect-scrollbar.css" rel="stylesheet">
  <link rel="stylesheet" type="text/css" href="assets/plugins/metismenu/metisMenu.min.css">
  <link rel="stylesheet" type="text/css" href="assets/plugins/metismenu/mm-vertical.css">
  <link href="assets/plugins/simplebar/css/simplebar.css" rel="stylesheet">
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
  <script src="https://cdn.jsdelivr.net/npm/sweetalert2@11"></script>

</head>
<!--bootstrap js-->
  <script src="assets/js/bootstrap.bundle.min.js"></script>

  <!--plugins-->
  <script src="assets/js/jquery.min.js"></script>
  <!--plugins-->
  <script src="assets/plugins/perfect-scrollbar/js/perfect-scrollbar.js"></script>
  <script src="assets/plugins/metismenu/metisMenu.min.js"></script>
  <script src="assets/plugins/simplebar/js/simplebar.min.js"></script>
  <script src="assets/js/main.js"></script>



<?php
// Check if the form is submitted
if ($_SERVER["REQUEST_METHOD"] == "POST" && isset($_POST['gift_code'])) {
    
    
           

    // Check if the redeem_gift button is clicked

    // Your code to redeem the gift code
    $gift_code_to_redeem = filter_var($_POST["gift_code"], FILTER_SANITIZE_STRING);


    // Check if the gift code is valid and not redeemed
    $sql = "SELECT * FROM gift_codes WHERE code = ? AND is_redeemed = 0 AND expiry_date >= CURDATE()";
    $stmt = $conn->prepare($sql);
  
    
    $stmt->bind_param("s", $gift_code_to_redeem);
    $stmt->execute();
    $result = $stmt->get_result();
    // Close the statement
    $stmt->close();
    
    if ($result->num_rows > 0) {
        $row = $result->fetch_assoc();
        $amount = $row['amount'];
        $sql_update = "UPDATE gift_codes SET is_redeemed = 1 WHERE code = ?";
        $stmt_update = $conn->prepare($sql_update);
        
        $stmt_update->bind_param("s", $gift_code_to_redeem);
        $userId=$_SESSION['user_id'];
         // Insert wallet transaction
    // Insert gift wallet transaction
$current_date = date("Y-m-d H:i:s");
$wallet_txnid = generateRandomWalletTxnID();
$operation_type = 'credit'; // Set operation_type to 'credit'
$sql = "INSERT INTO wallet_transactions (user_id, wallet_txnid, date, type, amount, operation_type) VALUES (?, ?, ?, 'Gift', ?, ?)";
$stmt = $conn->prepare($sql);
$stmt->bind_param("dssds", $userId, $wallet_txnid, $current_date, $amount, $operation_type);

$stmt->execute();
// Close the statement
$stmt->close();
    // Update the wallet in the users table
    $updateSql = "UPDATE users SET wallet = wallet + ? WHERE id = ?";
    $updateStmt = $conn->prepare($updateSql);
    
    // Bind parameters for the UPDATE statement
    $updateStmt->bind_param("ds", $amount, $userId);
    
    // Execute the UPDATE statement
    $updateStmt->execute();
    // Close the statement
$updateStmt->close();
    
        
        if ($stmt_update->execute()) {
            // Close the statement
$stmt_update->close();
            // Display success message with SweetAlert2
      

 echo '<script>
                        Swal.fire({
                            icon: "success",
                            title: "Gift code redeemed successfully!",
                           text: "Amount: ' . $amount . '",
                        }).then(function() {
                            window.location = "dashboard";
                        });
                    </script>';
                    exit;
        } else {
            // Display error message with SweetAlert2
            // Display error message with SweetAlert2
echo '<script>
        Swal.fire({
            title: "Error",
            text: "Error redeeming gift code",
            icon: "error"
        }).then(function() {
            window.location = "dashboard"; // Redirect to another page
        });
      </script>';
      exit;
        }
    } else {
        // Display invalid or expired gift code message with SweetAlert2
        // Display invalid or expired gift code message with SweetAlert2
echo '<script>
        Swal.fire({
            title: "Invalid or expired gift code",
            icon: "error"
        }).then(function() {
            window.location = "dashboard"; // Redirect to another page
        });
      </script>';
      exit;
    }

}

else{
    echo '<script>
        Swal.fire({
            title: "form submit error",
            icon: "error"
        }).then(function() {
            window.location = "dashboard"; // Redirect to another page
        });
      </script>';
      exit;
}
?>



</body>
</html>
