<?php


// Dene the absolute path to the functions.php file
define('ABSPATH', dirname(__FILE__) . '/'); // Adjust the path as needed
// Include the database connection file
require_once(ABSPATH . 'header.php');
require_once(ABSPATH . '../pages/dbFunctions.php');
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
// Check if the form is submitted
if ($_SERVER["REQUEST_METHOD"] == "POST" && isset($_POST["create_payout_to_user"])) {
    // Verify CSRF token
   
    $amounttopay = filter_var($_POST["amount"], FILTER_VALIDATE_FLOAT);
    $emailidtopay = filter_var($_POST["email"], FILTER_SANITIZE_STRING);

    // Retrieve user data from the database
    $user_id = $_SESSION["user_id"];
    $sql ="SELECT user_token, acc_ban,wallet FROM users WHERE id = ?";
    $stmt = $conn->prepare($sql);
    $stmt->bind_param("i", $user_id);
    $stmt->execute();
    $result = $stmt->get_result();

    if ($result->num_rows == 1) {
        $row = $result->fetch_assoc();
        $p_apitoken = $row["user_token"];
        $account_status = $row["acc_ban"];
        $userwalletbalance = $row["wallet"];
    }

    if ($userwalletbalance < $amounttopay) {
        
        echo '<script>
        Swal.fire({
            icon: "error",
            title: "Your Wallet Balance is Low So you Cannot Pay To Other User", 
            showConfirmButton: true,
            confirmButtonText: "Ok!",
            allowOutsideClick: false,
            customClass: {
                        popup: "swal2-border-radius",
                        confirmButton: "swal2-confirm-lg",
                    },
            allowEscapeKey: false
        }).then((result) => {
            if (result.isConfirmed) {
                window.location.href = "recharge";
            }
        });
    </script>';
        exit();
    }

    if ($userwalletbalance > $amounttopay) {
        // Search for user with provided email
        $sql = "SELECT id,route_2, wallet FROM users WHERE email = ?";
        $stmt = $conn->prepare($sql);
        $stmt->bind_param("s", $emailidtopay);
        $stmt->execute();
        $result = $stmt->get_result();

        if ($result->num_rows == 1) {
            $row = $result->fetch_assoc();
            $recipient_user_id = $row["id"];
            $recipient_wallet_balance = $row["wallet"];

            // Update recipient's wallet balance
            $new_wallet_balance = $recipient_wallet_balance + $amounttopay;
            $update_sql ="UPDATE users SET wallet = ? WHERE id = ?";
            $update_stmt = $conn->prepare($update_sql);
            $update_stmt->bind_param(
                "di",
                $new_wallet_balance,
                $recipient_user_id
            );
            $update_stmt->execute();
            // Close the statement
            $update_stmt->close();

            // Insert wallet transaction
            $current_date = date("Y-m-d H:i:s");
            $wallet_txnid = generateRandomWalletTxnID();
            $operation_type = "credit"; // Set operation_type to 'credit'
            $sql =
                "INSERT INTO wallet_transactions (user_id, wallet_txnid, date, type, amount, operation_type) VALUES (?, ?, ?, 'Friend Transfer', ?, ?)";
            $stmt = $conn->prepare($sql);
            $stmt->bind_param(
                "dssds",
                $recipient_user_id,
                $wallet_txnid,
                $current_date,
                $amounttopay,
                $operation_type
            );

            $stmt->execute();
            // Close the statement
            $stmt->close();

            //now for user to debit the balance

            // Update the wallet in the users table
            $updateSql ="UPDATE users SET wallet = wallet - ? WHERE id = ?";
            $updateStmt = $conn->prepare($updateSql);

            // Bind parameters for the UPDATE statement
            $updateStmt->bind_param("ds", $amounttopay, $user_id);

            // Execute the UPDATE statement
            $updateStmt->execute();
            // Close the statement
            $updateStmt->close();

            // Insert wallet transaction
            $current_date = date("Y-m-d H:i:s");
            $wallet_txnid = generateRandomWalletTxnID();
            $operation_type = "debit"; // Set operation_type to 'credit'
            $sql =
                "INSERT INTO wallet_transactions (user_id, wallet_txnid, date, type, amount, operation_type) VALUES (?, ?, ?, 'Friend Transfer', ?, ?)";
            $stmt = $conn->prepare($sql);
            $stmt->bind_param(
                "dssds",
                $user_id,
                $wallet_txnid,
                $current_date,
                $amounttopay,
                $operation_type
            );

            $stmt->execute();
            // Close the statement
            $stmt->close();

            echo '<script>
    Swal.fire({
        icon: "success",
        title: "Transfer Successfully! of ₹" + ' .
                json_encode($amounttopay) .
                ',
        showConfirmButton: true,
        confirmButtonText: "Ok!",
        allowOutsideClick: false,
        customClass: {
                        popup: "swal2-border-radius",
                        confirmButton: "swal2-confirm-lg",
                    },
        allowEscapeKey: false
    }).then((result) => {
        if (result.isConfirmed) {
            window.location.href = "pay-to-user"; // Redirect to success page
        }
    });
</script>';
            exit();

            // Handle success message or redirect
            // Your code here for success message or redirect
        } else {
            // Handle error: Email not found
            // Your code here for handling email not found
            $errorpaymessage = "Invalid email or email not found";
            
            echo '<script>
        Swal.fire({
            icon: "error",
            title: "' .
                $errorpaymessage .
                '", // Concatenate PHP variable here
            showConfirmButton: true,
            confirmButtonText: "Ok!",
            allowOutsideClick: false,
            customClass: {
                        popup: "swal2-border-radius",
                        confirmButton: "swal2-confirm-lg",
                    },
            allowEscapeKey: false
        }).then((result) => {
            if (result.isConfirmed) {
                window.location.href = "pay-to-user";
            }
        });
    </script>';
            exit();
        }
    }
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
                        <li class="breadcrumb-item active" aria-current="page">Transfer Funds</li>
                    </ol>
                </nav>
            </div>
        </div>
        <!--end breadcrumb-->

        <div class="row">
            <div class="col-12 col-xl-6">
                <div class="card">
                    <div class="card-body p-4">
                        <h5 class="mb-4">Transfer Funds to Another User</h5>
                        <form class="row g-3" method="post" action="" onsubmit="return validateForm()">
                            <div class="col-md-12">
    <label for="input3" class="form-label">Amount</label>
    <input type="text" name="amount" class="form-control" id="input3" oninput="this.value = this.value.replace(/[^0-9]/g, '')" required>
</div>

                            <div class="col-md-12">
                                <label for="input4" class="form-label">Email Id</label>
                                <input type="text" name ="email" class="form-control" id="input4" required>
                            </div>
                            <div class="col-md-12">
                                <label for="input5" class="form-label">Email Id Confirm</label>
                                <input type="text" name ="email" class="form-control" id="input5" required>
                                
                              
                            </div>
                            <div class="col-md-12">
                                <label for="input5" class="form-label">Current Time ⏰</label>
                                <input type="text" class="form-control"  id="input52" placeholder="currenttime" readonly>
                            </div>

                            
                        
                            <div class="col-md-12">
                                <div class="d-md-flex d-grid align-items-center gap-3">
                                    <button type="submit" class="btn btn-primary px-4" name="create_payout_to_user">Pay Now</button>
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
    var email = document.getElementById("input4").value;
    var emailconfirm = document.getElementById("input5").value;

    // Check if amount is less than 50
    if (parseFloat(amount) < 50) {
        alert("Amount must be at least 50");
        return false; // Prevent form submission
    }

    // Check if both ifsc and account number are empty
    if (email.trim() === "" || emailconfirm.trim() === "") {
        alert("Please enter Email.");
        return false; // Prevent form submission
    }

    // Check if both UPI IDs are not equal
    if (email !== emailconfirm) {
        alert("Email and Confirm Email must be the same.");
        return false; // Prevent form submission
    }



    // Continue with form submission if all conditions pass
    return true; // Allow form submission
}

</script>

</body>

</html>