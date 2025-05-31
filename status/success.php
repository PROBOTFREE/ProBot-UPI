<?php
include "../pages/dbFunctions.php";
include "../pages/dbInfo.php";

$servername = DB_HOST;
$username = DB_USERNAME;
$password = DB_PASSWORD;
$dbname = DB_NAME;

$conn = new mysqli($servername, $username, $password, $dbname);

if (!isset($_GET['token']) || !preg_match('/^[a-f0-9]{32}$/i', $_GET['token'])) {
    echo "Invalid request. No transaction details found.";
    exit;
}

$secureToken = sanitizeInput($_GET['token']);

// Fetch order details using the secure token
$sql = "SELECT order_id, amount, status, paytm_txn_ref FROM orders WHERE secure_token=?";
$stmt = $conn->prepare($sql);
$stmt->bind_param("s", $secureToken);
$stmt->execute();
$result = $stmt->get_result()->fetch_all(MYSQLI_ASSOC);

// Close statement
$stmt->close();

if (empty($result)) {
    echo "Transaction not found.";
    exit;
}

$payment = $result[0];

// ✅ Fix: Define $order_id
$order_id = $payment['order_id'];
$amount = $payment['amount'];
$status = $payment['status']; // Assuming 'status' field is present in the database
$txn_id = $payment['paytm_txn_ref']; // Assuming 'paytm_txn_ref' is the transaction ID

// Delete the secure token after processing the order
$sqlUpdate = "UPDATE orders SET secure_token=NULL WHERE order_id=? AND secure_token=?";
$stmtUpdate = $conn->prepare($sqlUpdate);
$stmtUpdate->bind_param("ss", $order_id, $secureToken);
$stmtUpdate->execute();
$stmtUpdate->close();


?>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Payment Success</title>
<style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f4f4f4;
            text-align: center;
            padding: 50px;
        }
        
        .container {
            background: rgb(255 255 255 / var(--tw-bg-opacity, 1));
            padding: 24px;
            max-width: 400px;
            margin: auto;
            border-radius: 20px;
            box-shadow: 0px 4px 8px rgba(0,0,0,0.2);
        }
        
        .my-6 {
         margin-top: 1.5rem;
         margin-bottom: 1.5rem;
        }
        
        .mx-auto {
         margin-left: auto;
         margin-right: auto;
        }
 
        .h-16 {
         height: 6rem;
         }

        .w-16 {
        width: 6rem
        }
        
        .text-green-600 {
            --tw-text-opacity: 1;
            color: rgb(22 163 74 / var(--tw-text-opacity, 1));
        }
        
        .text-red-600{
            --tw-text-opacity: 1;
            color: rgb(220 38 38 / var(--tw-text-opacity, 1)); /* Red */
        }

        .details {
            text-align: left;
            margin-top: 20px;
        }
        
        .details p {
            font-size: 16px;
            margin: 8px 0;
        }
        
        .btn {
            display: inline-block;
            padding: 18px 20px;
            background: #2C3E88;
            color: white;
            text-decoration: none;
            margin-top: 20px;
            border-radius: 50px;
        }
        
    </style>
</head>
<body>
    <div class="container">
        <?php if (strtolower($status) === "success") : ?>
            <!-- Success Icon -->
            <svg viewBox="0 0 24 24" class="text-green-600 w-16 h-16 mx-auto my-6">
                <path fill="currentColor"
                    d="M12,0A12,12,0,1,0,24,12,12.014,12.014,0,0,0,12,0Zm6.927,8.2-6.845,9.289a1.011,1.011,0,0,1-1.43.188L5.764,13.769a1,1,0,1,1,1.25-1.562l4.076,3.261,6.227-8.451A1,1,0,1,1,18.927,8.2Z">
                </path>
            </svg>
            <h2>Payment Successful</h2>
            <p>Thank you for your payment!</p>
            <p> Have a great day! </p>

        <?php else : ?>
            <!-- Failure Icon -->
            <svg viewBox="0 0 24 24" class="text-red-600 w-16 h-16 mx-auto my-6">
                <path fill="currentColor"
                    d="M12 0C5.37 0 0 5.37 0 12s5.37 12 12 12 12-5.37 12-12S18.63 0 12 0zm5 16.59L16.59 17l-4.59-4.59L7.41 17 7 16.59l4.59-4.59L7 7.41 7.41 7l4.59 4.59L16.59 7 17 7.41l-4.59 4.59L17 16.59z">
                </path>
            </svg>
            <h2>Payment Failed</h2>
            <p>Sorry, your payment was unsuccessful.</p>

        <?php endif; ?>
        
        <div class="details">
            <p><strong>Order ID:</strong> <?php echo $order_id; ?></p>
            <p><strong>Amount Paid:</strong> ₹<?php echo number_format($amount, 2); ?></p>
            <p><strong>Transaction ID:</strong> <?php echo $txn_id; ?></p>
            <p><strong>Status:</strong> <?php echo ucfirst($status); ?></p>
        </div>

        <a href="https://couponcart.in" class="btn">Return to Home</a>
    </div>
</body>
</html>
