<?php

// Dene the absolute path to the functions.php file
define('ABSPATH', dirname(__FILE__) . '/'); // Adjust the path as needed
// Include the database connection file
require_once(ABSPATH . 'header.php');
require_once(ABSPATH . '../pages/dbFunctions.php');
// Set the default timezone to Asia/Kolkata
date_default_timezone_set('Asia/Kolkata');

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

if ($userdata['route_2'] == 'off') {
    // Show SweetAlert2 error message
    echo '<script>
        Swal.fire({
            icon: "error",
            title: "Subscribe Vip",
            text: "Please subscribe to the VIP plan.",
            showConfirmButton: true,
            confirmButtonText: "Maybe later",
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



// Check if any of the withdrawal form fields are set
if($_SERVER["REQUEST_METHOD"] == "POST" && isset($_POST['create_payout'])  && isset($_POST['withdrawalAmount']) && isset($_POST['upiid'])) {
    
    
    
   
    if($cxrupipayout==false){
    
echo '<script>
    Swal.fire({
        icon: "error",
        title: "Bank Payout Under Maintaince!",
        showConfirmButton: true, // Show the confirm button
        confirmButtonText: "Ok!", // Set text for the confirm button
        allowOutsideClick: false,
        customClass: {
                        popup: "swal2-border-radius",
                        confirmButton: "swal2-confirm-lg",
                    },
        allowEscapeKey: false // Prevent the user from closing the popup by pressing Escape key
    }).then((result) => {
        if (result.isConfirmed) {
            window.location.href = "pay-to-bank"; // Redirect to "pay-to-bank" when the user clicks the confirm button
        }
    });
</script>';
exit;
}

    
    // Get user's current balance
    $userBalance = $userdata['wallet'];
    // Sanitize and validate the input data
    $withdrawalAmount = filter_var($_POST['withdrawalAmount'], FILTER_VALIDATE_FLOAT);
 
    $upiidtopay = filter_var($_POST['upiid'], FILTER_SANITIZE_STRING);
    
    
    
    
//hard ifsc check logic end
    // Check if withdrawal amount is valid
    if (!is_numeric($withdrawalAmount) || $withdrawalAmount < 100) {
        echo '<script>
            Swal.fire({
                icon: "error",
                title: "Invalid Withdrawal Amount!",
                text: "Withdrawal amount must be at least 100.",
                showConfirmButton: true,
                confirmButtonText: "Ok",
                allowOutsideClick: false,
                customClass: {
                        popup: "swal2-border-radius",
                        confirmButton: "swal2-confirm-lg",
                    },
                allowEscapeKey: false
            }).then((result) => {
                if (result.isConfirmed) {
                    window.location.href = "dashboard";
                }
            });
        </script>';
        exit(); // Stop processing the request
    }

    // Check if withdrawal amount is greater than user's balance
    if ($withdrawalAmount > $userBalance) {
        echo '<script>
            Swal.fire({
                icon: "error",
                title: "Insufficient Balance!",
                text: "Your withdrawal amount exceeds your current balance.",
                showConfirmButton: true,
                confirmButtonText: "Ok",
                allowOutsideClick: false,
                customClass: {
                        popup: "swal2-border-radius",
                        confirmButton: "swal2-confirm-lg",
                    },
                allowEscapeKey: false
            }).then((result) => {
                if (result.isConfirmed) {
                    window.location.href = "dashboard";
                }
            });
        </script>';
        exit(); // Stop processing the request
    }

    // Calculate total withdrawal amount including fees
    $totalWithdrawalAmount = $withdrawalAmount + ($withdrawalAmount * $withdrawalFeePercentage) + $withdrawalFixedFee;

    // Check if user has enough balance for withdrawal including fees
    if ($totalWithdrawalAmount > $userBalance) {
        echo '<script>
            Swal.fire({
                icon: "error",
                title: "Insufficient Balance!",
                text: "Your withdrawal amount including fees exceeds your current balance.",
                showConfirmButton: true,
                confirmButtonText: "Ok",
                allowOutsideClick: false,
                customClass: {
                        popup: "swal2-border-radius",
                        confirmButton: "swal2-confirm-lg",
                    },
                allowEscapeKey: false
            }).then((result) => {
                if (result.isConfirmed) {
                    window.location.href = "dashboard";
                }
            });
        </script>';
        exit(); // Stop processing the request
    }

    // Connect to your database (assuming you have already established a database connection)

 // Prepare the SQL statement
$sql = "INSERT INTO activity_history (user_id, action, ip_address, device_information) VALUES (?, ?, ?, ?)";

// Prepare and bind parameters
$stmt = mysqli_prepare($conn, $sql);
mysqli_stmt_bind_param($stmt, "isss", $user_id, $action, $ip_address, $device_info);

// Set the parameters' values
$user_id =$_SESSION['user_id']; // Assuming user_id is stored in session
$action = "Withdraw";
$ip_address = getUserIP(); // Assuming this function retrieves the user's IP address
$device_info = getDeviceInformation(); // Assuming this function retrieves device information

// Execute the statement
mysqli_stmt_execute($stmt);

// Close statement
mysqli_stmt_close($stmt);


    // Define the current date and time in YmdHis format
$currentDateTime = date("Y-m-d H:i:s");
$withdraw_id = generateRandomPayoutID(); // Assuming generateRandomPayoutID() is a function that generates a unique ID

// Prepare the SQL insert statement
$sql = "INSERT INTO withdrawals_upi (user_id, amount, upi_id, status, created_at, withdraw_id) 
        VALUES (?, ?, ?, 'pending', ?, ?)";

// Prepare and bind parameters
$stmt = $conn->prepare($sql);
$stmt->bind_param("issss", $userId, $withdrawalAmount, $upiidtopay, $currentDateTime, $withdraw_id);

// Set parameters and execute the statement
$userId = $userdata['id'];
$withdrawalAmount = $withdrawalAmount;
$upiidtopay = $upiidtopay;
$stmt->execute();

$current_date = date("Y-m-d H:i:s");

        // Generate a random wallet transaction ID
        $wallet_txnid = generateRandomWalletTxnID();

        $operation_type = "debit"; // Set operation_type to 'debit'
        $cxrsql ="INSERT INTO wallet_transactions (user_id, wallet_txnid, date, type, amount, operation_type) VALUES (?, ?, ?, 'Payout', ?, ?)";
        $cxrstmt = $conn->prepare($cxrsql);
        $cxrstmt->bind_param(
            "dssds",
            $userId,
            $wallet_txnid,
            $current_date,
            $totalWithdrawalAmount,
            $operation_type
        );

        $cxrstmt->execute();
        // Close the statement
        $cxrstmt->close();
        
    
    // Prepare and execute the SQL update statement to deduct the withdrawal amount from the user's wallet balance
$deductQuery = "UPDATE users SET wallet = wallet - ? WHERE id = ?";
$stmtDeduct = $conn->prepare($deductQuery);
$stmtDeduct->bind_param("di", $totalWithdrawalAmount, $userId);
$stmtDeduct->execute();
// Close the statement and database connection
$stmtDeduct->close();
    // Check if the insertion was successful
    if ($stmt->affected_rows > 0) {
         // Close the statement and database connection
    $stmt->close();
        // Insertion successful
    
        echo '<script>
            Swal.fire({
                icon: "success",
                title: "Withdrawal Successful!",
                text: "Your withdrawal request has been submitted successfully.",
                showConfirmButton: true,
                confirmButtonText: "Ok",
                allowOutsideClick: false,
                customClass: {
                        popup: "swal2-border-radius",
                        confirmButton: "swal2-confirm-lg",
                    },
                allowEscapeKey: false
            }).then((result) => {
                if (result.isConfirmed) {
                    window.location.href = "dashboard";
                }
            });
        </script>';
        exit;
    } else {
        // Insertion failed
        echo '<script>
            Swal.fire({
                icon: "error",
                title: "Withdrawal Failed!",
                text: "Failed to process your withdrawal request. Please try again later.",
                showConfirmButton: true,
                confirmButtonText: "Ok",
                allowOutsideClick: false,
                customClass: {
                        popup: "swal2-border-radius",
                        confirmButton: "swal2-confirm-lg",
                    },
                allowEscapeKey: false
            }).then((result) => {
                if (result.isConfirmed) {
                    window.location.href = "dashboard";
                }
            });
        </script>';
        exit(); // Stop processing the request
    }

  
    $conn->close();
    
    // Perform withdrawal processing logic here
    // Insert the withdrawal details into the database, update user's balance, etc.
    
    // Further processing...
    // Redirect or show success message
}
?>




<!--start main wrapper-->
<main class="main-wrapper">
    <div class="main-content">
        <!--breadcrumb-->
        <div class="page-breadcrumb d-none d-sm-flex align-items-center mb-3">
            <div class="breadcrumb-title pe-3">Service</div>
            <div class="ps-3">
                <nav aria-label="breadcrumb">
                    <ol class="breadcrumb mb-0 p-0">
                        <li class="breadcrumb-item"><a href="javascript:;"><i class="bx bx-home-alt"></i></a>
                        </li>
                        <li class="breadcrumb-item active" aria-current="page">Create Payout</li>
                    </ol>
                </nav>
            </div>
        </div>
        <!--end breadcrumb-->

        <div class="row">
            <div class="col-12 col-xl-6">
                <div class="card">
                    <div class="card-body p-4">
                        <h5 class="mb-4">Pay to Upi ID (Server1)</h5>
                        <form class="row g-3" method="post" action="" onsubmit="return validateForm()">
                            <div class="col-md-12">
    <label for="input3" class="form-label">Amount</label>
    <input type="text" name="withdrawalAmount" class="form-control" id="input3" oninput="this.value = this.value.replace(/[^0-9]/g, '')" required>
</div>

                            <div class="col-md-12">
                                <label for="input4" class="form-label">Upi ID</label>
                                <input type="text" name ="upiid" class="form-control" id="input4" required>
                            </div>
                            <div class="col-md-12">
                                <label for="input5" class="form-label">Upi ID Confirm</label>
                                <input type="text" name ="upiid" class="form-control" id="input5" required>
                                
                               
                            </div>
                            <div class="col-md-12">
                                <label for="input5" class="form-label">Current Time ⏰</label>
                                <input type="text" class="form-control"  id="input52" placeholder="currenttime" readonly>
                            </div>

                            
                            
                            <div class="col-md-12">
                                <div class="d-md-flex d-grid align-items-center gap-3">
                                    <button type="submit" class="btn btn-primary px-4" name="create_payout">Pay Now</button>
                                    <button type="reset" class="btn btn-light px-4">Reset</button>
                                </div>
                            </div>
                        </form>
                    </div>
                </div>
            </div>
            
            
           <div class="col-12 col-xl-6">
    <div class="card">
        <div class="card-body p-4">
            <h5 class="mb-4">Instructions</h5>
            <form class="row g-3">
                <p>👉 Please note that the payout process may take up to 15 minutes or longer. Kindly wait patiently to complete.</p>
                <p>👉 Additionally, ensure that you have provided correct payment details to avoid any delays.</p>
                <p>👉 If you have any further questions or concerns, don't hesitate to contact us. We're here to help you every step of the way.</p>
                <p>👉 For updates on your transaction status, please check your Telegram inbox regularly. We'll keep you informed.</p>
                <p>👉Your satisfaction is our top priority. We strive to provide you with the best service possible. Thank you for choosing us!.</p>
                <p>👉Wishing You Success and Happiness!</p>
                <br>
                <br>
                
            </form>
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
<script src="assets/plugins/datatable/js/jquery.dataTables.min.js"></script>
<script src="assets/plugins/datatable/js/dataTables.bootstrap5.min.js"></script>

<script src="assets/plugins/simplebar/js/simplebar.min.js"></script>
<script src="assets/js/main.js"></script>

<script>
    function updateTime() {
        var now = new Date();
        var hour = now.getHours();
        var ampm = hour >= 12 ? 'PM' : 'AM';
        hour = hour % 12;
        hour = hour ? hour : 12; // handle midnight (0 hours)
        var formattedTime = padZero(hour) + ':' + padZero(now.getMinutes()) + ':' + padZero(now.getSeconds()) + ' ' + ampm;
        document.getElementById('input52').value = formattedTime; // Update the second input field
    }

    function padZero(num) {
        return (num < 10 ? '0' : '') + num;
    }

    updateTime(); // Call the function initially to display the current time
    setInterval(updateTime, 1000); // Update the time every second
</script>


<script>
    function validateForm() {
    var amount = document.getElementById("input3").value;
    var upi_id = document.getElementById("input4").value;
    var confirm_upi_id = document.getElementById("input5").value;

    // Check if amount is less than 100
    if (parseFloat(amount) < 100) {
        alert("Amount must be at least 100");
        return false; // Prevent form submission
    }

    // Check if both UPI IDs are empty
    if (upi_id.trim() === "" || confirm_upi_id.trim() === "") {
        alert("Please enter UPI ID and Confirm UPI ID.");
        return false; // Prevent form submission
    }

    // Check if both UPI IDs are not equal
    if (upi_id !== confirm_upi_id) {
        alert("UPI ID and Confirm UPI ID must be the same.");
        return false; // Prevent form submission
    }

    // Validate UPI ID format
    var upiRegex = /^[^\s@]+@[^\s@]+$/; // Regex pattern for UPI ID format
    if (!upiRegex.test(upi_id) || !upiRegex.test(confirm_upi_id)) {
        alert("UPI ID must be in the correct format. Example: user@upi_provider");
        return false; // Prevent form submission
    }

    // Continue with form submission if all conditions pass
    return true; // Allow form submission
}

</script>

</body>

</html>