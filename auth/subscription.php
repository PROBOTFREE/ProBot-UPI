<?php

// Dene the absolute path to the functions.php file
define('ABSPATH', dirname(__FILE__) . '/'); // Adjust the path as needed
// Include the database connection file
require_once(ABSPATH . 'header.php');

include "../pages/dbFunctions.php";
?>

<head>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">

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
  
  <script src="https://cdn.jsdelivr.net/npm/sweetalert2@11"></script>

</head>

<?php

$purchased_plans = []; // Keep fetched plans, do NOT overwrite

$query = "SELECT plan_id FROM plan_orders WHERE user_id = ? AND status = 'success'";
$stmt = $conn->prepare($query);
$stmt->bind_param("i", $user_id);
$stmt->execute();
$result = $stmt->get_result();

while ($row = $result->fetch_assoc()) {
    $purchased_plans[$row['plan_id']] = true; // Correctly mark purchased plans
}
$stmt->close();

// Define plans
$plans = [
    1 => "Basic Pack",
    2 => "Starter Pack",
    3 => "Business Pack",
    4 => "Enterprise Pack"
];


?>

<!--start main wrapper-->
  <main class="main-wrapper">
    <div class="main-content">
      <!--breadcrumb-->
				<div class="d-flex flex-wrap justify-content-between flex-1"><div class="mb-lg-0 mb-2 me-8"><h1 class="pg-title">Choose a plan</h1><p>Flexible pricing solutions for your business</p>
			            </div>
			        <div>
			    </div>
			</div>

				<!--end breadcrumb-->
      
        	<!--end breadcrumb-->
      
        <div class="row">
           <div class="col-12 col-xl-4">
             <div class="card border-top border-4 border-primary">
               <div class="card-body p-4">
                    <form method="POST" action="lib/pay">
                
                <input type="hidden" name="planid" value="1">
                <input type="hidden" name="buyplan" value="Basic Pack">
                
                <div style="display: inline-block; padding: 0.25rem 0.5rem; font-weight: 500; background-color: rgba(0, 123, 255, 0.1); color: #007bff; text-transform: uppercase; text-align: center; border-radius: 0.25rem;">Starter Pack</div>
                 <div class="my-4">
                    <h3 class="mb-2" style="text-align: center; font-weight: 900;">Starter Pack </h3>
                    <div class="price-tag d-flex align-items-center justify-content-center gap-2 my-4">
                   <h1 class="mb-0 lh-1 price-amount text-dark" style="font-weight: 900;">₹328</h1>
                   <h5 class="mb-0 align-self-end text-secondary">/1 months</h5>
                 </div>
                 </div>
                 <div class="pricing-content align-items-center justify-content-center d-flex flex-column gap-3">
                <div class="d-flex align-items-center justify-content-between">
                    <p class="mb-0 fs-6">✔ Local Payment Access</p>
                </div>
                <div class="d-flex align-items-center justify-content-between">
                    <p class="mb-0 fs-6">✔ No Merchant Required</p>
                </div>
                <div class="d-flex align-items-center justify-content-between">
                    <p class="mb-0 fs-6">✔ Access To Route2 (VIP)</p>
                </div>
                <div class="d-flex align-items-center justify-content-between">
                    <p class="mb-0 fs-6">✔ Fast Transations</p>
                </div>
                <div class="d-flex align-items-center justify-content-between">
                    <p class="mb-0 fs-6">✔ Automated Settlements</p>
                </div>
                <div class="d-flex align-items-center justify-content-between">
                    <p class="mb-0 fs-6">✔ Realtime Fast Transaction</p>
                </div>
                <div class="d-flex align-items-center justify-content-between">
                    <p class="mb-0 fs-6">✔ Automatic Settlement</p>
                </div>
                <div class="d-flex align-items-center justify-content-between">
                    <p class="mb-0 fs-6">✔ 24*7 Telegram Support</p>
                </div>
                <div class="d-flex align-items-center justify-content-between">
                    <p class="mb-0 fs-6">✔ Monthly Updates</p>
                </div>
                <br>
                
            </div>
                 
                 <div class="d-grid my-4">
                   <button type="button" name="buyplan" class="btn btn-lg btn-success" 
    <?= isset($purchased_plans[1]) ? 'disabled' : '' ?> 
    onclick="confirmPurchase('Basic Pack', this)">
    <?= isset($purchased_plans[1]) ? 'Purchased' : 'Buy Now' ?>
</button>
                 </div>
                 
                 </form>
               </div>
             </div>
           </div>
      
      
        
           <div class="col-12 col-xl-4">
             <div class="card border-top border-4 border-primary">
               <div class="card-body p-4">
                    <form method="POST" action="lib/pay">
                
                <input type="hidden" name="planid" value="2">
                <input type="hidden" name="buyplan" value="Starter Pack">
                
                <div style="display: inline-block; padding: 0.25rem 0.5rem; font-weight: 500; background-color: rgba(0, 123, 255, 0.1); color: #007bff; text-transform: uppercase; text-align: center; border-radius: 0.25rem;">Starter Pack</div>
                 <div class="my-4">
                    <h3 class="mb-2" style="text-align: center; font-weight: 900;">Starter Pack </h3>
                    <div class="price-tag d-flex align-items-center justify-content-center gap-2 my-4">
                   <h1 class="mb-0 lh-1 price-amount text-dark" style="font-weight: 900;">₹828</h1>
                   <h5 class="mb-0 align-self-end text-secondary">/3 months</h5>
                 </div>
                 </div>
                 <div class="pricing-content align-items-center justify-content-center d-flex flex-column gap-3">
                <div class="d-flex align-items-center justify-content-between">
                    <p class="mb-0 fs-6">✔ Local Payment Access</p>
                </div>
                <div class="d-flex align-items-center justify-content-between">
                    <p class="mb-0 fs-6">✔ No Merchant Required</p>
                </div>
                <div class="d-flex align-items-center justify-content-between">
                    <p class="mb-0 fs-6">✔ Access To Route2 (VIP)</p>
                </div>
                <div class="d-flex align-items-center justify-content-between">
                    <p class="mb-0 fs-6">✔ Fast Transations</p>
                </div>
                <div class="d-flex align-items-center justify-content-between">
                    <p class="mb-0 fs-6">✔ Automated Settlements</p>
                </div>
                <div class="d-flex align-items-center justify-content-between">
                    <p class="mb-0 fs-6">✔ Realtime Fast Transaction</p>
                </div>
                <div class="d-flex align-items-center justify-content-between">
                    <p class="mb-0 fs-6">✔ Automatic Settlement</p>
                </div>
                <div class="d-flex align-items-center justify-content-between">
                    <p class="mb-0 fs-6">✔ 24*7 Telegram Support</p>
                </div>
                <div class="d-flex align-items-center justify-content-between">
                    <p class="mb-0 fs-6">✔ Monthly Updates</p>
                </div>
                <br>
                
            </div>
                 
                 <div class="d-grid my-4">
                   <button type="button" name="buyplan" class="btn btn-lg btn-success" 
    <?= isset($purchased_plans[2]) ? 'disabled' : '' ?> 
    onclick="confirmPurchase('Starter Pack', this)">
    <?= isset($purchased_plans[2]) ? 'Purchased' : 'Buy Now' ?>
</button>
                 </div>
                 
                 </form>
               </div>
             </div>
           </div>
           
           
           <div class="col-12 col-xl-4">
            <div class="card border-top border-4 border-success">
              <div class="card-body p-4">
                <form method="POST" action="lib/pay">
                
                <input type="hidden" name="planid" value="3">
                <input type="hidden" name="buyplan" value="Business Pack">
                <div style="display: inline-block; padding: 0.25rem 0.5rem; font-weight: 500; background-color: rgba(0, 123, 255, 0.1); color: #28a745; text-transform: uppercase; text-align: center; border-radius: 0.25rem;">Business Pack</div>
                <div class="my-4">
                   <h3 class="mb-2" style="text-align: center; font-weight: 900;">Business Pack </h3>
                   <div class="price-tag d-flex align-items-center justify-content-center gap-2 my-4">
                  <h1 class="mb-0 lh-1 price-amount text-dark" style="font-weight: 900;">₹1,656</h1>
                  <h5 class="mb-0 align-self-end text-secondary">/6 months</h5>
                </div>
                </div>
                <div class="pricing-content align-items-center justify-content-center d-flex flex-column gap-3">
                <div class="d-flex align-items-center justify-content-between">
                    <p class="mb-0 fs-6">✔ Local Payment Access</p>
                </div>
                <div class="d-flex align-items-center justify-content-between">
                    <p class="mb-0 fs-6">✔ No Merchant Required</p>
                </div>
                <div class="d-flex align-items-center justify-content-between">
                    <p class="mb-0 fs-6">✔ Access To Route2 (VIP)</p>
                </div>
                <div class="d-flex align-items-center justify-content-between">
                    <p class="mb-0 fs-6">✔ Super Fast Transations</p>
                </div>
                <div class="d-flex align-items-center justify-content-between">
                    <p class="mb-0 fs-6">✔ Automated Settlements</p>
                </div>
                <div class="d-flex align-items-center justify-content-between">
                    <p class="mb-0 fs-6">✔ Realtime Fast Transaction</p>
                </div>
                <div class="d-flex align-items-center justify-content-between">
                    <p class="mb-0 fs-6">✔ Automatic Settlement</p>
                </div>
                <div class="d-flex align-items-center justify-content-between">
                    <p class="mb-0 fs-6">✔ Accept All UPI Payments</p>
                </div>
                <div class="d-flex align-items-center justify-content-between">
                    <p class="mb-0 fs-6">✔ 24*7 WhatsApp Support</p>
                </div>
                <div class="d-flex align-items-center justify-content-between">
                    <p class="mb-0 fs-6">✔ Monthly Updates</p>
                </div>
            </div>

                <div class="d-grid my-4">
                  <button type="button" name="buyplan" class="btn btn-lg btn-success" 
    <?= isset($purchased_plans[3]) ? 'disabled' : '' ?> 
    onclick="confirmPurchase('Business Pack', this)">
    <?= isset($purchased_plans[3]) ? 'Purchased' : 'Buy Now' ?>
</button>
                </div>
                
                </form>
              </div>
            </div>
          </div>
          
          
          
          
          
          
          
          
          <div class="col-12 col-xl-4">
            <div class="card border-top border-4 border-danger">
              <div class="card-body p-4">
                 <form method="POST" action="lib/pay">
                
                <input type="hidden" name="planid" value="4">
                <input type="hidden" name="buyplan" value="Enterprise Pack">
                 <div style="display: inline-block; padding: 0.25rem 0.5rem; font-weight: 500; background-color: rgba(255, 0, 123, 0.1); color: #ff007b; text-transform: uppercase; text-align: center; border-radius: 0.25rem;">Enterprise Pack</div>
                <div class="my-4">
                   <h3 class="mb-2" style="text-align: center; font-weight: 900;">Enterprise Pack</h3>
                   <div class="price-tag d-flex align-items-center justify-content-center gap-2 my-4">
                  <h1 class="mb-0 lh-1 price-amount text-dark" style="font-weight: 900;">₹3,468</h1>
                  <h5 class="mb-0 align-self-end text-secondary">/1 Year</h5>
                </div>
            
                </div>
                <div class="pricing-content align-items-center justify-content-center d-flex flex-column gap-3">
                <div class="d-flex align-items-center justify-content-between">
                    <p class="mb-0 fs-6">✔ Local Payment Access</p>
                </div>
                <div class="d-flex align-items-center justify-content-between">
                    <p class="mb-0 fs-6">✔ No Merchant Required</p>
                </div>
                <div class="d-flex align-items-center justify-content-between">
                    <p class="mb-0 fs-6">✔ Access To Route2 (VIP)</p>
                </div>
                <div class="d-flex align-items-center justify-content-between">
                    <p class="mb-0 fs-6">✔ Super Fast Transations</p>
                </div>
                <div class="d-flex align-items-center justify-content-between">
                    <p class="mb-0 fs-6">✔ Automated Settlements</p>
                </div>
                <div class="d-flex align-items-center justify-content-between">
                    <p class="mb-0 fs-6">✔ Realtime Fast Transaction</p>
                </div>
                <div class="d-flex align-items-center justify-content-between">
                    <p class="mb-0 fs-6">✔ Automatic Settlement</p>
                </div>
                <div class="d-flex align-items-center justify-content-between">
                    <p class="mb-0 fs-6">✔ Accept All UPI Payments</p>
                </div>
                <div class="d-flex align-items-center justify-content-between">
                    <p class="mb-0 fs-6">✔ 24*7 WhatsApp Support</p>
                </div>
                <div class="d-flex align-items-center justify-content-between">
                    <p class="mb-0 fs-6">✔ Monthly Updates</p>
                </div>
            </div>

                <div class="d-grid my-4">
                <button type="button" name="buyplan" class="btn btn-lg btn-success" 
    <?= isset($purchased_plans[4]) ? 'disabled' : '' ?> 
    onclick="confirmPurchase('Enterprise Pack', this)">
    <?= isset($purchased_plans[4]) ? 'Purchased' : 'Buy Now' ?>
</button>
                </div>
                
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
  <script src="assets/plugins/simplebar/js/simplebar.min.js"></script>
  <script src="assets/js/main.js"></script>
  
  <script src="https://cdn.jsdelivr.net/npm/sweetalert2@11"></script>
  
<script>

function confirmPurchase(planName, button) {
    Swal.fire({
        title: "Confirm Purchase",
        html: `<b>Plan:</b> ${planName}`,
        icon: "question",
        showCancelButton: true,
        confirmButtonColor: "#28a745",
        cancelButtonColor: "#d33",
        confirmButtonText: "Yes, Redirect to Payment",
        customClass: {
                        popup: "swal2-border-radius",
                        confirmButton: "swal2-confirm-lg",
                        cancelButton: "swal2-confirm-lg",
                    },
        cancelButtonText: "No, Cancel"
    }).then((result) => {
        if (result.isConfirmed) {
            let form = button.closest("form");

            // Check if buyplan input already exists
            let input = form.querySelector("input[name='buyplan']");
            if (!input) {
                input = document.createElement("input");
                input.type = "hidden";
                input.name = "buyplan";
                form.appendChild(input);
            }
            
            // Update the value to match the selected plan
            input.value = planName;

            form.submit();
        }
    });
}
</script>



</body>

</html>