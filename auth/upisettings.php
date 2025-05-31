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
  
</head>




<?php
$userid=$_SESSION['user_id'];

$errorMessage = ""; // Initialize error message variable
$successMessage = ""; // Initialize success message variable

// Display messages
if (!empty($_SESSION['errorMessage'])) {
    $errorMessage = $_SESSION['errorMessage'];
    unset($_SESSION['errorMessage']); // Remove after showing
}

if (!empty($_SESSION['successMessage'])) {
    $successMessage = $_SESSION['successMessage'];
    unset($_SESSION['successMessage']); // Remove after showing
}

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

if(isset($_POST['addmerchant'])) {
    $bbbytemerchant = mysqli_real_escape_string($conn, $_POST['merchant_name']);
    $no = mysqli_real_escape_string($conn, $_POST['c_mobile']);
    $bbbytetokken = $userdata['user_token'];

    // Define table and phone column mapping
    $merchantMapping = [
        "hdfc" => ["table" => "hdfc", "phone_column" => "number"],
        "phonepe" => ["table" => "phonepe_tokens", "phone_column" => "phoneNumber"],
        "paytm" => ["table" => "paytm_tokens", "phone_column" => "phoneNumber"],
        "bharatpe" => ["table" => "bharatpe_tokens", "phone_column" => "phoneNumber"],
        "googlepay" => ["table" => "googlepay_tokens", "phone_column" => "phoneNumber"],
        "freecharge" => ["table" => "freecharge_tokens", "phone_column" => "phoneNumber"]
    ];

    if (array_key_exists($bbbytemerchant, $merchantMapping)) {
        $table = $merchantMapping[$bbbytemerchant]['table'];
        $phoneColumn = $merchantMapping[$bbbytemerchant]['phone_column'];

        // Check if the number already exists
        $stmt = $conn->prepare("SELECT * FROM $table WHERE $phoneColumn = ?");
        $stmt->bind_param("s", $no);
        $stmt->execute();
        $checkResult = $stmt->get_result();


        if (mysqli_num_rows($checkResult) > 0) {
            $errorMessage = "❌ This phone number already in use. Please use a different phone number";
        } else {
            // Insert into the respective table
            switch ($bbbytemerchant) {
                case "hdfc":
                    $data = "INSERT INTO hdfc (id, number, seassion, device_id, user_token, pin, upi_hdfc, UPI, tidlist, status, mobile) 
                             VALUES ('', '$no', '', '', '$bbbytetokken', '', '', '', '', 'Deactive', '$mobile')";
                    break;
                case "phonepe":
                    $data = "INSERT INTO phonepe_tokens (user_token, phoneNumber, userId, token, refreshToken, name, device_data) 
                             VALUES ('$bbbytetokken', '$no', '', '', '', '', '')";
                    break;
                case "paytm":
                    $data = "INSERT INTO paytm_tokens (user_token, phoneNumber, MID, Upiid) 
                             VALUES ('$bbbytetokken', '$no', '', '')";
                    break;
                case "bharatpe":
                    $data = "INSERT INTO bharatpe_tokens (user_token, phoneNumber, token, cookie, merchantId) 
                             VALUES ('$bbbytetokken', '$no', '', '', '')";
                    break;
                case "googlepay":
                    $data = "INSERT INTO googlepay_tokens (user_token, phoneNumber, Instance_Id, Upiid) 
                             VALUES ('$bbbytetokken', '$no', '', '')";
                    break;
                case "freecharge":
                    $data = "INSERT INTO freecharge_tokens (user_token, phoneNumber, token, cookie, merchantId) 
                             VALUES ('$bbbytetokken', '$no', '', '', '')";
                    break;
            }

            $insert = mysqli_query($conn, $data);

            if ($insert) {
                $successMessage = "✅ Congratulations! Your Merchant Has been Added Successfully!";
            } else {
                $errorMessage = "❌ Failed to add merchant! Contact Support.";
            }
        }
    } else {
        $errorMessage = "❌ Invalid Merchant Selected!";
    }
}



?>
<!--start main wrapper-->
<main class="main-wrapper">
  <div class="main-content">
      
    
   <div class="container-fluid d-flex justify-content-center align-items-center flex-column vh-100">
       
       <div id="error-message" class="error-message message-box <?php echo (!empty($errorMessage)) ? 'show' : ''; ?>" style="display: <?php echo (!empty($errorMessage)) ? 'flex' : 'none'; ?>;">
    <span id="error-text"><?php echo htmlspecialchars($errorMessage, ENT_QUOTES, 'UTF-8'); ?></span>
    <button class="close-btn" onclick="closeMessage('error-message')">✖</button>
</div>

<!-- Success Message -->
<div id="success-message" class="success-message message-box <?php echo (!empty($successMessage)) ? 'show' : ''; ?>" style="display: <?php echo (!empty($successMessage)) ? 'flex' : 'none'; ?>;">
    <span id="success-text"><?php echo htmlspecialchars($successMessage, ENT_QUOTES, 'UTF-8'); ?></span>
    <button class="close-btn" onclick="closeMessage('success-message')">✖</button>
</div>
       
    <div class="card shadow-lg p-4" style="max-width: 450px; width: 100%;">
        <div class="card-body">
            <h5 class="mb-4 text-center fw-bold">Add Merchant</h5>
            <form method="POST" action="<?php echo htmlspecialchars($_SERVER['PHP_SELF']); ?>">
                
                <!-- Mobile Number Input -->
                <div class="mb-3">
                    <label for="input50" class="form-label fw-semibold">Mobile Number</label>
                    <div class="input-group">
                        <input type="text" class="form-control" id="input50" name="c_mobile" placeholder="Enter mobile number" minlength="10" maxlength="10" oninput="this.value = this.value.replace(/[^0-9]/g, '');" required>
                    </div>
                </div>

                <!-- Merchant Account Selection -->
                <div class="mb-3">
                    <label for="input46" class="form-label fw-semibold">Select Merchant Account</label>
                    <div class="input-group">
                        <select class="form-select" id="input46" name="merchant_name">
                            <option value="hdfc">HDFC Vyapar</option>
                            <option value="phonepe">PhonePe</option>
                            <option value="paytm">Paytm</option>
                            <option value="bharatpe">BharatPe</option>
                            <option value="googlepay">Google Pay</option>
                            <option value="freecharge">Free Charge</option>
                            <option value="amazonpay">Amazon Pay (Coming Soon)</option>
                        </select>
                    </div>
                </div>

                <!-- Buttons -->
                <div class="d-flex justify-content-center gap-3 mt-3">
                    <button type="submit" name="addmerchant" class="btn btn-primary w-50">Add Merchant</button>
                    <a href="#" onclick="checkRoute(event)" class="btn btn-outline-secondary w-50">Verify Now</a>
                </div>
            </form>
            <?php if (!$isExpired) { ?>
            <!-- View Merchant Link -->
            <div class="text-center mt-4">
                <a href="upisettingslist" class="text-decoration-none fw-semibold text-primary">
                View Merchant → 
                </a>
            </div>
            <?php } ?>
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
        function closeMessage(id) {
    let element = document.getElementById(id);
    if (element) {
        element.style.opacity = "0";
        setTimeout(() => {
            element.classList.remove("show");  // Remove show class
            element.style.display = "none";  // Hide it properly
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


    function checkRoute(event) {
    event.preventDefault();
    var isexpired = <?php echo json_encode($isExpired); ?>;
    var errorBox = document.getElementById("error-message");
    var errorSpan = document.getElementById("error-text");

    if (!isexpired) {
        window.location.href = "upisettingslist";
    } else {
        
            errorSpan.textContent = "❌ Please buy the VIP Plan to get access";
            errorBox.style.display = "flex";  // Ensure it is visible
            errorBox.classList.add("show");

            // Remove display: none in case it was hidden before
            errorBox.style.opacity = "1";  

            setTimeout(() => {
                closeMessage("error-message");
            }, 5000); // Auto-hide after 5 seconds
        
    }
}

</script>
	
	
  <script src="assets/plugins/simplebar/js/simplebar.min.js"></script>
  <script src="assets/js/main.js"></script>
  
</body>

</html>