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
            background: #667eea;
            background: -webkit-linear-gradient(to right, #764ba2, #667eea);
            background: linear-gradient(to right, #764ba2, #667eea);
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
            margin: 0;
            font-family: Arial, sans-serif;
        }
         /* Custom SweetAlert2 styles */
    .custom-swal2-popup {
        font-family: Arial, sans-serif;
        border-radius: 20px; /* Rounded corners for the popup */
    }

    .custom-swal2-backdrop {
        /* Matching the page's gradient background */
        background: rgba(118, 75, 162, 0.4);
        background: -webkit-linear-gradient(to right, rgba(118, 75, 162, 0.4), rgba(102, 110, 234, 0.4));
        background: linear-gradient(to right, rgba(118, 75, 162, 0.4), rgba(102, 110, 234, 0.4));
    }

    /* Additional styling for SweetAlert2's buttons for better integration */
    .swal2-styled.swal2-confirm {
        background-color: #764ba2; /* Button color to match the gradient start */
        color: white; /* White text color */
        border: 0; /* Remove default border */
        border-radius: 10px; /* Rounded button edges */
        padding: 10px 24px; /* Button padding */
    }

    .swal2-styled.swal2-confirm:focus {
        box-shadow: 0 0 0 2px rgba(118, 75, 162, 0.5); /* Focus ring color close to button color */
    }

    /* Adjusting the input field to better match the design */
    .swal2-input {
        border: 1px solid #764ba2; /* Border color to match the gradient */
        border-radius: 10px; /* Rounded edges for the input field */
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
$sql_fetch_order_id = "SELECT order_id, created_at FROM payment_links WHERE link_token = '$link_token'";
$result = getXbyY($sql_fetch_order_id);

if (count($result) === 0) {
    // Token not found or expired
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

// Assume $link_token is already sanitized and validated as shown previously
$nonce = bin2hex(random_bytes(16)); // Generates a secure random nonce

// Store the nonce in the session or pass to JavaScript directly (shown below)
// Update the `payment_links` table with this nonce where the link_token matches

$update_nonce_sql = "UPDATE payment_links SET nonce = ? WHERE link_token = ?";
$stmt = $conn->prepare($update_nonce_sql);
$stmt->bind_param("ss", $nonce, $link_token);
$stmt->execute();
?>
<script>
$(document).ready(function() {
    const token = "<?php echo $link_token; ?>";
    const cxr_XsRFtoken = "<?php echo $nonce; ?>";

    Swal.fire({
        title: 'Enter your UPI ID',
        input: 'text',
        inputAttributes: {
            autocapitalize: 'off'
        },
        confirmButtonText: `Pay ₹<?php echo $amount; ?>`,
        backdrop: `rgba(102, 110, 234, 0.4)`, // Custom backdrop color with transparency
        customClass: {
            popup: 'custom-swal2-popup',
            backdrop: 'custom-swal2-backdrop'
        },
        showLoaderOnConfirm: true,
        preConfirm: (upiId) => {
            const form = document.createElement("form");
            form.method = "POST";
            form.action = `https://couponcart.in/payment/instant-pay/hdfcupipay/${token}`;

            const upiInput = document.createElement("input");
            upiInput.type = "hidden";
            upiInput.name = "upiId";
            upiInput.value = upiId;
            form.appendChild(upiInput);
            
            // Nonce input with an obscure name
            const nonceInput = document.createElement("input");
            nonceInput.type = "hidden";
            nonceInput.name = "cxr_XsRFtoken"; // Obscure name for the nonce
            nonceInput.value = cxr_XsRFtoken; // Nonce value generated by PHP and included in JavaScript
            form.appendChild(nonceInput);

            
            document.body.appendChild(form);
            form.submit();
        },
        allowOutsideClick: false // Prevent closing by clicking outside
    });
});


        // Calculate remaining time
        var expirationTime = <?php echo $created_at + (5 * 60); ?>; // Expiration time of the token
        var currentTime = <?php echo time(); ?>; // Current time
        var remainingTime = expirationTime - currentTime; // Remaining time in milliseconds

        // Set timeout for redirecting if token is expired
        setTimeout(function() {
            // Check if token is expired
            if (<?php echo time(); ?> > expirationTime) {
                // Token is expired, redirect to the specified URL
                window.location.href = "<?php echo $redirect_url; ?>";
            }
        }, remainingTime);
    </script>





</body>
</html>

