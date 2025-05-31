<?php

// Define the absolute path to the functions.php file
define('ABSPATH', dirname(__FILE__) . '/'); // Adjust the path as needed

require_once(ABSPATH . 'header.php');

?>
<head>
    
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
  
  <!-- SweetAlert2 -->
    <script src="https://cdn.jsdelivr.net/npm/sweetalert2@11"></script>

</head>

<?php
$userid=$_SESSION['user_id'];

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

if ($route_2 == 'off') {  // Corrected line
    
    echo '<script>
        Swal.fire({
            icon: "error",
            title: "Subscribe Vip",
            text: "Please subscribe to the VIP plan.",
            showConfirmButton: true,
            customClass: {
                        popup: "swal2-border-radius",
                        confirmButton: "swal2-confirm-lg",
                    },
            confirmButtonText: "Maybe later",
            allowOutsideClick: false,
            allowEscapeKey: false
        }).then((result) => {
            if (result.isConfirmed) {
                window.location.href = "subscription";
            }
        });
    </script>';
    exit;
}

?>

<body>
    <!--start main wrapper-->
<main class="main-wrapper">
  <div class="main-content">
      
    <div class="container d-flex justify-content-center align-items-center vh-100">
  <div class="card shadow-lg p-4" style="max-width: 450px; width: 100%;">
    <div class="card-body">

    <h5 class="card-title text-center">Enter Amount</h5>
    <form id="amountForm">
      <div class="mb-3">
        <label for="amount" class="form-label">Amount:</label>
        <input type="number" id="amount" name="amount" class="form-control rounded" required>
        <?php if ($isExpired): ?>
          <small class="text-danger">Your Plan has expired. Please renew now.</small>
        <?php endif; ?>
      </div>
      <div class="mb-3">
          <label for="remark" class="form-label">Remark:</label>
          <input id="remark" name="remark" class="form-control rounded" placeholder="Add a remark (optional)">

        </div>

      <button type="button" class="btn btn-primary w-100 rounded" onclick="validateAmount()">Next</button>
    </form>
  </div>
 </div>
</div>
  
</div>
</main>

</body>

<script src="assets/js/jquery.min.js"></script>

<script src="assets/plugins/perfect-scrollbar/js/perfect-scrollbar.js"></script>
<script src="assets/plugins/metismenu/metisMenu.min.js"></script>
<script src="assets/plugins/datatable/js/jquery.dataTables.min.js"></script>
<script src="assets/plugins/datatable/js/dataTables.bootstrap5.min.js"></script>

<script src="assets/plugins/simplebar/js/simplebar.min.js"></script>
<script src="assets/js/main.js"></script>

<script>

// Pass VIP restriction to JavaScript
const isVipRestricted = <?php echo json_encode($isExpired); ?>;

function validateAmount() {
    const amount = document.getElementById('amount').value;
    const remark = document.getElementById('remark').value.trim();
    const sanitizedAmount = parseFloat(amount);
    
    if (isNaN(sanitizedAmount) || sanitizedAmount <= 0) {
    Swal.fire("Invalid Input", "Please enter a valid amount.", "warning");
    return;
}


    if (isVipRestricted) {
        Swal.fire("Buy a Plan", "Your Plan has expired. Please renew now.", "warning");
        return;
    }

    selectRoute(sanitizedAmount, remark);
}

function selectRoute(amount, remark) {
    Swal.fire({
        title: "Select Route",
        html: `
            <p style="margin-bottom: 15px;"><strong>Note:</strong> Route 2 is for VIP users and requires an amount greater than ₹100.</p>
            <div style="display: flex; flex-direction: column; align-items: center; gap: 10px;">
                <label style="display: flex; align-items: center; gap: 8px; font-size: 16px;">
                    <input type="radio" name="route" value="route_1" checked> (Default)
                </label>
                <label style="display: flex; align-items: center; gap: 8px; font-size: 16px;">
                    <input type="radio" name="route" value="route_2">(VIP Only)
                </label>
            </div>
        `,
        didOpen: () => {
            document.querySelectorAll('input[name="route"]').forEach((input) => {
                input.addEventListener("change", function () {
                    if (this.value === "route_2" && amount < 100) {
                        Swal.showValidationMessage("For VIP, the amount must be at least ₹100.");
                    } else {
                        Swal.resetValidationMessage();
                    }
                });
            });
        },
        showCancelButton: true,
        confirmButtonText: "Submit",
        preConfirm: () => {
            const selectedRoute = document.querySelector('input[name="route"]:checked').value;
            if (selectedRoute === "route_2" && amount < 100) {
                return Swal.showValidationMessage("For VIP, the amount must be at least ₹100.");
            }
            return selectedRoute;
        },
        customClass: {
            popup: "swal2-border-radius",
            confirmButton: "swal2-confirm-lg",
            cancelButton: "swal2-confirm-lg",
        },
    }).then((routeResult) => {
        if (routeResult.isConfirmed) {
            submitForm(routeResult.value, amount, remark);
        } else {
            window.location.href = "#";
        }
    });
}


function submitForm(route, amount, remark) {
    const form = document.createElement('form');
    form.method = 'post';
    form.action = 'paylinkgen.php';
    
    const amountInput = document.createElement('input');
    amountInput.type = 'hidden';
    amountInput.name = 'amount';
    amountInput.value = amount;

    const routeInput = document.createElement('input');
    routeInput.type = 'hidden';
    routeInput.name = 'route';
    routeInput.value = route;

    const remarkInput = document.createElement('input');
    remarkInput.type = 'hidden';
    remarkInput.name = 'remark';
    remarkInput.value = remark;

    form.appendChild(routeInput);
    form.appendChild(amountInput);
    form.appendChild(remarkInput);
    document.body.appendChild(form);
    form.submit();
}

</script>