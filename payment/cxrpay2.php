<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <!-- Include SweetAlert2 and jQuery -->
    <script src="https://cdn.jsdelivr.net/npm/sweetalert2@11"></script>
    <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
    <title>PROBOT PAYMENTS</title>
   <style>
        body {
            font-family: 'Poppins', sans-serif;
            background-color: #f4f7f6;
            margin: 0;
            padding: 0;
            display: flex;
            justify-content: center;
            align-items: center;
            min-height: 100vh;
            color: #333;
        }

        .payment-container {
            background: #ffffff;
            background: linear-gradient(to bottom right, #ffffff, #e9eff9);
            border-radius: 12px;
            box-shadow: 0 6px 20px rgba(0, 0, 0, 0.1);
            padding: 40px;
            max-width: 400px;
            width: 90%;
            text-align: center;
            position: relative;
            overflow: hidden;
        }

        .payment-title {
            font-size: 24px;
            color: #0a58ca;
            margin-bottom: 25px;
        }

        .payment-expiration, .payment-footer {
            color: #6c757d;
            font-size: 14px;
            margin-bottom: 25px;
        }

        .payment-instructions {
            text-align: left;
            font-size: 16px;
            line-height: 1.6;
            margin-bottom: 30px;
        }

        .payment-instructions li {
            margin-bottom: 10px;
        }

        #timeout {
            font-size: 18px;
            color: #dc3545;
            margin-bottom: 20px;
        }

        .btn {
            display: inline-block;
            padding: 10px 20px;
            background-color: #0d6efd;
            color: white;
            border-radius: 5px;
            text-decoration: none;
            transition: background-color 0.3s ease;
        }

        .btn:hover {
            background-color: #0a58ca;
        }

        @media (max-width: 768px) {
            .payment-container {
                padding: 20px;
                max-width: 90%;
            }
        }
    </style>
</head>
<?php




// Define the base directory constant
define('ROOT_DIR', realpath(dirname(__FILE__)) . '/../');

// Securely include files using the ROOT_DIR constant
include ROOT_DIR . 'pages/dbFunctions.php';
include ROOT_DIR . 'auth/config.php';
include ROOT_DIR . 'pages/dbInfo.php';





$link_token = sanitizeInput($_GET["token"]);

// Fetch order_id based on the token from the payment_links table
$sql_fetch_order_id = "SELECT order_id, created_at,nonce FROM payment_links WHERE link_token = '$link_token'";
$result = getXbyY($sql_fetch_order_id);

if (count($result) === 0) {
    // Token not found or expired
    echo "Token not found or expired";
    exit;
}

$order_id = $result[0]['order_id'];
$created_at = strtotime($result[0]['created_at']);
$current_time = time();
$dbnonce= $result[0]['nonce'];

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
$upiLink = $res_p[0]['upiLink'];
$upiLink=str_replace("https://","","$upiLink");
$method = $res_p[0]['method'];
$hdfc_txn = $res_p[0]['HDFC_TXNID'];


 $slq_p1 = "SELECT * FROM users where user_token='$user_token'";
        $res_p1 = getXbyY($slq_p1);    
 $name=$res_p1[0]['name'];





?>


<body>
    <div class="payment-container">
        <div class="payment-title">Pay ₹<?php echo$amount;?></div>
        <div class="payment-expiration">This page will automatically expire in <span id="timeout"></span> minutes.</div>
        <ul class="payment-instructions">
            <li>Go to your UPI App.</li>
            <li>Select the payment request from <?php echo $name?>.</li>
            <li>Enter the UPI PIN and complete the payment.</li>
        </ul>
        <div class="payment-footer">
            Please do not press back or close the app.
        </div>
    </div>

    
 <script>
    var paymentProcessed = false;
    var interval;

window.onload = function () {
    // Calculate the difference between the current time and the created_at time, then subtract it from the 5 minutes limit
    var timeNow = Math.floor(Date.now() / 1000); // Current time in seconds
    var created_at = <?php echo $created_at; ?>; // Assuming this is in seconds
    var timePassed = timeNow - created_at; // Time passed in seconds since the creation of the link
    var totalDuration = 5 * 60; // Total duration of 5 minutes in seconds
    var remainingTime = totalDuration - timePassed; // Remaining time in seconds

    var display = document.querySelector('#timeout');
    if(remainingTime < 0) {
        // If the remaining time is already past, you can handle it as you see fit, maybe by showing the page has expired.
        display.textContent = "00:00";
        // Handling for expired link can go here
    } else {
        startTimer(remainingTime, display); // Start the timer with the remaining time
        check(); // Do an initial check before starting the interval
        interval = setInterval(check, 5000); // Continue to check payment status every 5 seconds
    }
};

// You should also adjust the startTimer function to accept the `duration` as a parameter from where it's called.
function startTimer(duration, display) {
    var timer = duration, minutes, seconds;
    interval = setInterval(function () {
        minutes = parseInt(timer / 60, 10);
        seconds = parseInt(timer % 60, 10);

        minutes = minutes < 10 ? "0" + minutes : minutes;
        seconds = seconds < 10 ? "0" + seconds : seconds;

        display.textContent = minutes + ":" + seconds;

        if (--timer < 0) {
            clearInterval(interval);
            // Your existing code for handling expiration
        }
    }, 1000);
}

    function check() {
        if (paymentProcessed || !interval) {
            clearInterval(interval); // Stop the interval when the payment is processed or countdown finished
            return;
        }

        $.ajax({
            type: 'get',
            url: 'https://couponcart.in/order/payment-status',
            data: { order_id: '<?php echo $order_id ?>' },
            dataType: 'text', // Assuming the response is text. Change if it's JSON or another dataType.
            success: function (data) {
                if (data === 'success') {
                    paymentProcessed = true;
                    Swal.fire({
                        title: 'Payment Received Successfully ✅',
                        text: 'Please wait...',
                        icon: 'success'
                    }).then(() => {
                        window.location.href = "<?php echo $redirect_url ?>";
                    });
                } else if (data === 'FAILURE' || data === 'FAILED') {
                    paymentProcessed = true;
                    Swal.fire({
                        title: 'Payment Failed',
                        icon: 'error'
                    }).then(() => {
                        window.location.href = "<?php echo $redirect_url ?>";
                    });
                }
            },
            error: function (xhr, status, error) {
                console.log('AJAX Error:', status, error);
            }
        });
    }

    window.onload = function () {
        var fiveMinutes = 60 * 5,
            display = document.querySelector('#timeout');
        startTimer(fiveMinutes, display);
        check(); // Do an initial check before starting the interval
        interval = setInterval(check, 5000);
    };
</script>


</body>
</html>