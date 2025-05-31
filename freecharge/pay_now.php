<!DOCTYPE html>
<html lang="en">
<?php

date_default_timezone_set("Asia/Kolkata");
include "../pages/dbFunctions.php";
include "../pages/dbInfo.php";

?>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <!-- Include SweetAlert2 and jQuery -->
    <script src="https://cdn.jsdelivr.net/npm/sweetalert2@11"></script>
    <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
    <title>Probot Payments</title>
<style>
        * {
            margin: 0;
            padding: 0;
            box-sizing: border-box;
            font-family: Arial, sans-serif;
        }

        body {
            background-color: #f3f4f7;
            display: flex;
            justify-content: center; /* Horizontally center */
            align-items: center; /* Vertically center */
            flex-direction: column;
            min-height: 100vh;
        }
        
        .amount {
            font-size: 20px;
            margin: 15px 0;
        }

        .container {
            width: 95%;
            max-width: 400px;
            padding: 20px;
            text-align: center;
            margin: 15px auto;
            background-color: #ffffff;
            border-radius: 14px;
            box-shadow: 0px 4px 12px rgba(0, 0, 0, 0.1);
            padding-bottom: 20px;
        }

        .header {
            background-color: #2C3E88;
            padding: 15px;
            color: white;
            display: flex;
            align-items: center;
            
            border-radius: 10px;
            font-size: 18px;
            font-weight: bold;
            position: relative;
        }

        .header img {
            width: 50px;
            border-radius: 20%;
            margin-right: 10px;
        }

        .header .company-info {
            display: flex;
            flex-direction: column;
        }
        

        .company-info h1 {
            font-size: 16px;
            font-weight: 700;
        }

        .trusted-business {
            display: flex;
            
            align-items: center;
            margin-top: 5px;
        }

        .trusted-business img {
            width: 20px;
            margin-left: 5px;
        }

        .price-summary {
            background-color: #f2f3f7;
            padding: 15px;
            font-size: 14px;
            text-align: center;
            font-weight: bold;
        }

        /* QR Code Section */
        .qr-section {
            padding: 15px;
            border-radius: 10px;
            align-items: center;
        }

        .qr-section img {
            
            width: 200px;
            height: 200px;
            border-radius: 10px;
        }

        .qr-section .center {
            text-align: center;
        }

        .qr-section .center span {
            display: block;
            font-size: 14px;
            font-weight: 400;
            margin-bottom: 10px;
        }
        
        .swal2-border-radius {
            border-radius: 20px !important; /* Adjust the value as needed */
        }
        
        .swal2-confirm-lg {
            border-radius: 50px !important; /* Adjust the value as needed */
            font-size: 18px !important; /* Larger text */
            padding: 14px 40px !important; /* Increased width padding */
            min-width: 150px !important; /* Ensures wider button */
        }
        
        .swal2-input-radius{
            border-radius: 16px !important; /* Adjust the value as needed */
        }
        
        .subtitle {
            font-size: 18px;
            margin: 20px;
        }

        .upi-icons {
            padding: 15px;
            display: flex;
            justify-content: center;
            gap: 10px;
        }

        .upi-icons img {
            width: 40px;
            height: 40px;
            border-radius: 50%; /* Make icons round */
        }

        .payment-options {
            padding: 15px;
        }

        .payment-options h2 {
            font-size: 16px;
            margin-bottom: 10px;
        }

        /* Updated Recommended Section */
        .recommended {
            background-color: #f9f9f9;
            padding: 0;
            border-radius: 10px;
            margin-bottom: 15px;
            overflow: hidden;
        }

        .payment-method {
            display: flex;
            align-items: center;
            padding: 10px;
            border-bottom: 1px solid #e0e0e0;
            cursor: pointer;
        }

        .payment-method img {
            width: 24px;
            margin-right: 10px;
        }

        .payment-method:last-child {
            border-bottom: none;
        }

        .payment-method span {
            margin-left: 10px;
        }

        /* UPI Grid for 2 options per row */
        .upi-grid {
            display: flex;
            flex-wrap: wrap;
            gap: 10px;
        }
        
        @media (max-width: 768px) {
            .icons {
                display: none;
            }
        }
        
        .upi-options {
            display: flex;
            align-items: center;
            width: 48%;
            padding: 10px;
            border: 1px solid #e0e0e0;
            border-radius: 10px;
            cursor: pointer;
            background-color: #fff;
        }

        .upi-options img {
            width: 24px;
            margin-right: 10px;
        }

        /* Timer Style */
        .timer {
            text-align: center;
            font-size: 16px;
            padding: 10px;
            color: red;
        }
        
        .btn-custom-1 {
            background-size: 200%;
            background: #031f3a;
            color: #ffffff;
            padding: 12px 35px;
            font-size: var(--fs-8);
            font-weight: var(--fw-500);
            border-radius: 50px;
            box-shadow: 0 8px 20px rgba(0, 0, 0, 0.20);
            cursor: pointer;
            transition: var(--transition-2);
            border: solid #d5d5d5;
        }
        
        .instructions {
            padding: 10px;
            padding: 0px 10px 10px 10px;
            font-size: 16px;
        }

        /* Footer layout: price and button side by side */
        .footer {
            margin-top: auto;
            display: flex;
            justify-content: space-between;
            align-items: center;
            padding: 15px;
            background-color: #f3f4f7;
            border-top: 1px solid #e0e0e0;
        }

        .footer .price {
            font-size: 18px;
            font-weight: bold;
        }

        .footer button {
            background-color: #000;
            color: #fff;
            border: none;
            padding: 10px 20px;
            border-radius: 5px;
            cursor: pointer;
            font-weight: bold;
        }
        
        .apps_container {
        border: 2px solid #ddd;
        border-radius: 10px;
        display: inline-block;
        margin-right: 15px;
        padding: 15px;
        }
        
        .apps_container img {
        height: 24px;
        }
        
        .apps_container a {
        display: block;
        }
        
         @media (min-width: 768px) {
            .mobile-only {
                display: none;
            }
        }

    </style>
        <!-- Website Lock -->
</head>

<?php

$link_token = sanitizeInput($_GET["token"]);

// Fetch order_id based on the token from the payment_links table
$sql_fetch_order_id = "SELECT order_id, created_at FROM payment_links WHERE link_token = '$link_token'";
$result = getXbyY($sql_fetch_order_id);

if (count($result) === 0) {
    echo "Token not found or expired";
    exit;
}

$order_id = $result[0]['order_id'];
$created_at = strtotime($result[0]['created_at']);
$current_time = time();

// Check if the token has expired (more than 5 minutes)
if (($current_time - $created_at) > (5 * 60)) {
    echo "Token has expired";
    exit;
}

$slq_p = "SELECT * FROM orders where order_id='$order_id'";
$res_p = getXbyY($slq_p);    
$amount = $res_p[0]['amount'];
$user_token = $res_p[0]['user_token'];
$redirect_url = $res_p[0]['redirect_url'];
$cxrkalwaremark = $res_p[0]['byteTransactionId'];  //remark
$cxrbytectxnref = $res_p[0]['paytm_txn_ref'];
$order_status = $res_p[0]['status'];

$slq_p = "SELECT * FROM freecharge_tokens where user_token='$user_token'";
        $res_p = getXbyY($slq_p);    
$upi_id = $res_p[0]['Upiid']; //upi id from paytm tokens

if($redirect_url==''){
$redirect_url='https://couponcart.in/';    
}
    


if ($order_status === 'SUCCESS') {
        echo "<script>
            document.addEventListener('DOMContentLoaded', function() {
                Swal.fire({
                    toast: true,
                    position: 'top-end',
                    icon: 'success',
                    title: 'Order already paid',
                    showConfirmButton: false,
                    timer: 3000
                }).then(() => {
                    window.location.href = '$redirect_url';
                });
            });
        </script>";
        exit;
}

 $slq_p = "SELECT * FROM users where user_token='$user_token'";
        $res_p = getXbyY($slq_p);    
 $unitId=$res_p[0]['name'];
 
$orders = "upi://pay?pa=$upi_id&am=$amount&pn=$unitId&tn=$cxrbytectxnref&tr=$cxrbytectxnref";

$GpayOrders = "tez://upi/pay?pa=$upi_id&am=$amount&pn=$unitId&tn=$asdasd23&tr=$cxrbytectxnref";

$PaytmOrders = "paytmmp://pay?pa=$upi_id&am=$amount&pn=$unitId&tn=$asdasd23&tr=$cxrbytectxnref";


$qr_code_url = "https://api.qrserver.com/v1/create-qr-code/?size=300x300&data=" . urlencode($orders);

?>

<body>
    <div class="container">
        <!-- Header Section -->
        <div class="header">
            <img src="https://couponcart.in/favicon.ico" alt="Company Logo">
            <div class="company-info">
                <h1><?php echo $unitId?></h1>
                <div class="trusted-business">
                    <img src="https://d6xcmfyh68wv8.cloudfront.net/assets/trusted-badge/1st-fold/top-illustration-mob.svg" alt="Trusted Badge">
                     <p>Verified</p>
                </div>
            </div>
        </div>
        
        <!-- QR Code Section -->

            <div class="qr-section">
                <div class="subtitle">Pay With UPI QR</div>
                
                <img id="qrCode" src="<?php echo $qr_code_url; ?>" alt="QR Code">
        <!--Payment amount -->
            <div class="amount">Amount : ₹ <?php echo number_format($amount, 2); ?></div>
        
        </div>
        
         <!--Payment instruction-->
        
        <div class="instructions">Scan the QR using any UPI app on your phone.</div>
        <div class="icons">
        <div class="upi-icons">
                    <img src="https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQyVO9LUWF81Ov6LZR50eDNu5rNFCpkn0LwYQ&s" alt="Google Pay">
                    <img src="https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTo4x8kSTmPUq4PFzl4HNT0gObFuEhivHOFYg&s" alt="PhonePe">
                    <img src="https://w7.pngwing.com/pngs/305/719/png-transparent-paytm-ecommerce-shopping-social-icons-circular-color-icon-thumbnail.png" alt="PayTM">
                    <img src="https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRSouM4icV33KEDtJakZiySZN3HH2LPfv3-BA&s" alt="BHIM">
                </div>
                </div>
        <!-- Payment Options Section -->
        <div class="payment-options" style="text-align: center;">
        <!-- Button Section -->
            <div class="button-section">
                <a onclick="downloadQRCode()">
                <button class="btn-custom-1">Save QR Code</button>
                </a>
            </div>

            <div class="amount text-center mobile-only" style="margin: 15px 0;padding: 10px;">
            <p class="pay_mode_label">Pay using any UPi Apps</p>
            </div>
  
            <div class="apps_container mobile-only">
                <a class="paybyupiappsbtn" onclick="payViaGpay()"><img src="../../assets/images/google-pay.webp" alt="Google Pay" /></a>
            </div>
            <div class="apps_container mobile-only">
                <a class="paybyupiappsbtn" onclick="payViaPaytm()"><img src="../../assets/images/paytm.webp" alt="Paytm" /></a>
            </div>
    
            <div class="apps_container mobile-only">
            <a class="paybyupiappsbtn" onclick="payViaUPI()"><img src="../../assets/images/phonepe.webp"alt="PhonePe" /></a>
            </div>
                               
            <!-- Timeout Section -->
            <div class="validity" style="text-align: center; margin-top: 30px;">
            <p>Valid until:<span id="timeout"></span></p>
            </div>
        </div>
      
    </div>

    <script>
        function payViaGpay() {
            /** Launches payment request flow when user taps on buy button. */
    
            if (!window.PaymentRequest) {
            console.log('Web payments are not supported in this browser.');
            return;
            }else{
            // This function will be called when user clicks the button
            window.location.href = "<?php echo $GpayOrders; ?>";
            }
        }
        
        function payViaPaytm() {
            /** Launches payment request flow when user taps on buy button. */
    
            if (!window.PaymentRequest) {
            console.log('Web payments are not supported in this browser.');
            return;
            }else{
            // This function will be called when user clicks the button
            window.location.href = "<?php echo $PaytmOrders; ?>";
            }
        }
    
        function payViaUPI() {
            /** Launches payment request flow when user taps on buy button. */
    
            if (!window.PaymentRequest) {
            console.log('Web payments are not supported in this browser.');
            return;
            }else{
            // This function will be called when user clicks the button
            window.location.href = "<?php echo $orders; ?>";
            }
        }
        
        function downloadQRCode() {
            var qrCode = document.getElementById('qrCode');
            if (qrCode) {
                var xhr = new XMLHttpRequest();
                xhr.open('GET', qrCode.src, true);
                xhr.responseType = 'blob';
                xhr.onload = function() {
                    var blob = xhr.response;
                    var link = document.createElement('a');
                    link.href = window.URL.createObjectURL(blob);
                    link.download = 'QRCode.png';
                    document.body.appendChild(link);
                    link.click();
                    document.body.removeChild(link);
        };
        xhr.send();
            } else {
                console.error("QR code element not found");
            }
        }


    var createdAt = <?php echo intval($created_at); ?>;
    var totalDuration = 5 * 60; // 5 minutes in seconds

    function updateTimer() {
        var currentTime = Math.floor(Date.now() / 1000);
        var timeElapsed = currentTime - createdAt;
        var remainingTime = totalDuration - timeElapsed;

        if (remainingTime <= 0) {
            Swal.fire({
                title: 'Oops',
                text: 'Transaction Timeout!',
                customClass: {
                        popup: 'swal2-border-radius',
                    },
                icon: 'error'
            }).then(() => {
                window.location.href = "https://couponcart.in";
            });
            return;
        }

        let minutes = Math.floor(remainingTime / 60);
        let seconds = remainingTime % 60;
        document.getElementById("timeout").innerHTML = minutes + ":" + (seconds < 10 ? "0" : "") + seconds;
    }

    // Run updateTimer immediately and then every second
    updateTimer();
    setInterval(updateTimer, 1000);


function check() {
    $.post('../payment-status', { byte_order_status: '<?php echo $cxrkalwaremark ?>' }, function (data) {

        if (data === 'success') {
            Swal.fire({
                title: 'Payment Successful!',
                text: 'Redirecting...',
                allowOutsideClick: false,
                allowEscapeKey: false,
                customClass: {
                    popup: 'swal2-border-radius',
                },
                showConfirmButton: false,
                didOpen: () => {
                    Swal.showLoading();
                }
            });

            setTimeout(() => {
                window.location.href = "<?php echo $redirect_url ?>";
            }, 2000); // Delay for smooth transition
            
        } else if (data === 'AMOUNT_MISMATCH') {
            
            Swal.fire({
                icon: 'error',
                title: 'Payment Failed',
                customClass: {
                    popup: 'swal2-border-radius',
                },
                text: 'Your payment was not successful due to amount mismatch. Please try again.'
            });

            setTimeout(() => {
                window.location.href = "<?php echo $redirect_url ?>";
            }, 2000); // Delay for smooth transition
            
            message = 'Your Payment Failed due to amount mismatch';
            icon = 'error';
            
        } else if (data === 'TXN_FAILED') {
            Swal.fire({
                icon: 'error',
                title: 'Payment Failed',
                customClass: {
                    popup: 'swal2-border-radius',
                },
                text: 'Your payment was not successful. Please try again.'
            });

            setTimeout(() => {
                window.location.href = "<?php echo $redirect_url ?>";
            }, 2000); // Delay for smooth transition
        } else {
            return;
        }

        
    });
}

setInterval(check, 5000);
</script>
</body>
</html>