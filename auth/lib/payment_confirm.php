<?php
session_start();
include "../config.php"; // Database connection

ini_set('display_errors', 1);
ini_set('display_startup_errors', 1);
error_reporting(E_ALL);




// Regular page logic starts here
if (!isset($_SESSION['user_id'])) {
    header("Location: ../auth/index");
    exit;
}

$order_id = $_GET['order_id'] ?? '';

if (empty($order_id) || !ctype_alnum($order_id)) {
    header("Location: ../dashboard?error=invalid_order");
    exit;
}

// Fetch order details securely
$query = "SELECT plan_id, user_id, status FROM plan_orders WHERE order_id = ?";
$stmt = $conn->prepare($query);
$stmt->bind_param("s", $order_id);
$stmt->execute();
$stmt->bind_result($planid, $user_id, $status);
$stmt->fetch();
$stmt->close();

$vip_check_query = "SELECT route_2 FROM users WHERE id = ?";
$stmt = $conn->prepare($vip_check_query);
$stmt->bind_param("i", $user_id);
$stmt->execute();
$stmt->bind_result($route_2);
$stmt->fetch();
$stmt->close();

//Step 3: Prevent reprocessing of successful orders (Show Swal instead of redirect)
if ($status === "success") { 
    if ($_SERVER['REQUEST_METHOD'] === 'POST') {
        /*echo json_encode(["status" => "success"]);
        exit;*/
    } else {
        echo '<script src="https://cdn.jsdelivr.net/npm/sweetalert2@11.0.18"></script>';
        echo "<script>
            document.addEventListener('DOMContentLoaded', function() {
                Swal.fire({
                    icon: 'info',
                    title: 'Already VIP!',
                    text: 'You already have VIP access. Enjoy your benefits!',
                    confirmButtonText: 'Go to Dashboard',
                    allowOutsideClick: false
                }).then((result) => {
                    if (result.isConfirmed) {
                        window.location.href = '../dashboard';
                    }
                });
            });
        </script>";
        exit;
    }
}


if ($_SERVER['REQUEST_METHOD'] === 'POST' && $_POST['action'] === 'check_status') {
    $order_id = $_POST['order_id'] ?? '';

    if (empty($order_id) || !ctype_alnum($order_id)) {
        echo json_encode(["status" => "error", "message" => "Invalid order ID"]);
        exit;
    }

    // Fetch the order details
    $query = "SELECT plan_id, user_id, status FROM plan_orders WHERE order_id = ?";
    $stmt = $conn->prepare($query);
    $stmt->bind_param("s", $order_id);
    $stmt->execute();
    $stmt->bind_result($planid, $user_id, $status);
    $stmt->fetch();
    $stmt->close();

    // 🚨 Ensure a valid response is always returned
    if ($status === null) {
        echo json_encode(["status" => "error", "message" => "Order not found"]);
        exit;
    }

    if ($status === "success") {
        $duration = "";

        switch ($planid) {
            case 1: $duration = "+28 days"; break;
            case 2: $duration = "+84 days"; break;
            case 3: $duration = "+168 days"; break;
            case 4: $duration = "+336 days"; break;
        }

        // Fetch current VIP expiry date
        $vip_expiry_query = "SELECT vip_expiry FROM users WHERE id = ?";
        $stmt = $conn->prepare($vip_expiry_query);
        $stmt->bind_param("i", $user_id);
        $stmt->execute();
        $stmt->bind_result($current_expiry);
        $stmt->fetch();
        $stmt->close();

        $now = date("Y-m-d H:i:s");
        
        if ($current_expiry && strtotime($current_expiry) > strtotime($now)) {
            // If the user is already VIP, extend from the current expiry date
         $expiry_date = date("Y-m-d H:i:s", strtotime($current_expiry . " " . $duration));
        } else {
            // If not VIP, start the duration from now
            $expiry_date = date("Y-m-d H:i:s", strtotime($duration));
        }
        
        if ($planid > 1) {
            // Update route_2 status
        $update_route_query = "UPDATE users SET route_2 = 'on' WHERE id = ?";
        $stmt = $conn->prepare($update_route_query);
        $stmt->bind_param("i", $user_id);
        $stmt->execute();
        $stmt->close();
        }

        // Update VIP expiry date
        $update_vip_query = "UPDATE users SET vip_expiry = ? WHERE id = ?";
        $stmt = $conn->prepare($update_vip_query);
        $stmt->bind_param("si", $expiry_date, $user_id);
        $stmt->execute();
        $stmt->close();

        

        echo json_encode(["status" => "success"]);
        exit;
    }

    // Always return JSON, even if still pending
    echo json_encode(["status" => "pending"]);
    exit;
}




?>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Payment Confirmation</title>
    <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/sweetalert2@11"></script>
    
    <style>
        .swal2-border-radius { border-radius: 20px !important; }
        .swal2-confirm-lg {
            border-radius: 50px !important;
            font-size: 18px !important;
            padding: 14px 40px !important;
            min-width: 150px !important;
        }
    </style>
</head>
<body>
<script>
document.addEventListener("DOMContentLoaded", function () {
    function checkPaymentStatus() {
        $.ajax({
            url: window.location.href, 
            type: 'POST',
            data: { action: 'check_status', order_id: '<?php echo $order_id; ?>' },
            dataType: 'json',
            success: function(response) {
                console.log("AJAX Response:", response);

                if (!response || !response.status) {
                    console.error("Invalid JSON response:", response);
                    return;
                }

                if (response.status === 'success') {
                    clearInterval(checkInterval);
                    Swal.fire({
                        icon: "success",
                        title: "Congratulations!",
                        text: "You are now a VIP. Enjoy your exclusive benefits!",
                        confirmButtonText: "Explore Now",
                        customClass: {
                        popup: "swal2-border-radius",
                        confirmButton: "swal2-confirm-lg",
                    },
                        allowOutsideClick: false
                    }).then(() => {
                        window.location.href = "../dashboard";
                    });
                } else if (response.status === 'pending') {
                    console.log("Payment still pending...");
                } else if (response.status === 'error') {
                    clearInterval(checkInterval);
                    console.error("Payment error:", response.message);
                    Swal.fire({
                        icon: "error",
                        title: "Payment Failed",
                        customClass: {
                            popup: "swal2-border-radius",
                            confirmButton: "swal2-confirm-lg",
                        },
                        text: response.message || "There was an issue processing your payment.",
                        confirmButtonText: "Try Again",
                        allowOutsideClick: false
                    });
                }
            },
            error: function(xhr, status, error) {
                clearInterval(checkInterval);
                console.error("AJAX Error:", status, error, xhr.responseText);
                Swal.fire({
                    icon: "error",
                    title: "Connection Error",
                    customClass: {
                        popup: "swal2-border-radius",
                        confirmButton: "swal2-confirm-lg",
                    },
                    text: "Response: " + xhr.responseText,
                    confirmButtonText: "Retry",
                    allowOutsideClick: false
                });
            }
        });
    }

    var checkInterval = setInterval(checkPaymentStatus, 5000);

    Swal.fire({
        title: "Processing Payment...",
        text: "Please do not press the back button or refresh the page.",
        showConfirmButton: false,
        allowOutsideClick: false,
        customClass: {
                        popup: "swal2-border-radius",
                        confirmButton: "swal2-confirm-lg",
                    },
        willOpen: () => Swal.showLoading()
    });
});

</script>

</body>
</html>
