<?php
// Prevent direct access to this file

include "config.php";
session_start();
// Regenerate the session ID
session_regenerate_id(true);

// Secure session settings
ini_set('session.cookie_httponly', 1);
ini_set('session.cookie_secure', 1); // Enable this only if you are using HTTPS


// Retrieve user data from the database
$user_id = $_SESSION["user_id"];

if (isset($_SESSION['username'])) {
    // Prevent SQL Injection
    $mobile = mysqli_real_escape_string($conn, $_SESSION['username']);
    $userQuery = "SELECT * FROM users WHERE mobile = ?";
    $stmt = $conn->prepare($userQuery);
    $stmt->bind_param('s', $mobile);
    $stmt->execute();
    $result = $stmt->get_result();
    $userdata = $result->fetch_array(MYSQLI_ASSOC);
    $stmt->close();
} else {
   header("location:index");
   exit;
}


// Fetch route_2 from the database
$query = "SELECT route_2 FROM users WHERE id = ?";
$stmt = $conn->prepare($query);
$stmt->bind_param("i", $user_id);
$stmt->execute();
$stmt->bind_result($route_2);
$stmt->fetch();
$stmt->close();


$themetouse = $_SESSION['theme']; 

?>


<!doctype html>
<html lang="en" data-bs-theme="<?php echo htmlspecialchars($themetouse, ENT_QUOTES, 'UTF-8'); ?>">
<head>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  
  <title>Dashboard</title>
  
  <!--plugins-->
  <link href="assets/plugins/perfect-scrollbar/css/perfect-scrollbar.css" rel="stylesheet">
  <link rel="stylesheet" type="text/css" href="assets/plugins/metismenu/metisMenu.min.css">
  <link rel="stylesheet" type="text/css" href="assets/plugins/metismenu/mm-vertical.css">
  <link rel="stylesheet" type="text/css" href="assets/plugins/simplebar/css/simplebar.css">
  <!--bootstrap css-->
    <link href="https://fonts.googleapis.com/css2?family=Noto+Sans:wght@300;400;500;600&display=swap" rel="stylesheet">
  <link href="https://fonts.googleapis.com/css?family=Material+Symbols+Rounded" rel="stylesheet">
  <link href="assets/css/bootstrap.min.css" rel="stylesheet">
  <link href="assets/plugins/datatable/css/dataTables.bootstrap5.min.css" rel="stylesheet" />

  <!--main css-->
  <link href="assets/css/bootstrap-extended.css" rel="stylesheet">
  <link href="sass/main.css" rel="stylesheet">
  <link href="sass/dark-theme.css" rel="stylesheet">
  <link href="sass/semi-dark.css" rel="stylesheet">
  <link href="sass/bordered-theme.css" rel="stylesheet">
  <link href="sass/responsive.css" rel="stylesheet">
  
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
    .swal2-input-radius{
        border-radius: 16px !important; /* Adjust the value as needed */
    }
    
    .hidethemenu {
  display: none !important;
}
</style>
</head>

  <!--start header-->
<!--start header-->
<header class="top-header">
  <nav class="navbar navbar-expand align-items-center justify-content-between">
    <div class="btn-toggle">
      <a href="javascript:;"><i class="material-symbols-rounded">menu</i></a>
    </div>
    
    

    <ul class="navbar-nav gap-1 nav-right-links align-items-center ms-auto">
        
        <div onclick="window.open('https://t.me/SonixMusicDev', '_blank');" 
     style="display: inline-flex; align-items: center; gap: 0.5rem; padding: 0.5rem 1rem; 
            font-weight: 500; background-color: rgba(0, 123, 255, 0.1); 
            color: #007bff; text-align: center; border-radius: 1rem; 
            cursor: pointer; user-select: none;" 
     role="button" tabindex="0">
  
  <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" viewBox="0 0 24 24" 
       fill="none" stroke="currentColor" stroke-width="2" stroke-linecap="round" 
       stroke-linejoin="round" class="feather feather-phone">
    <path d="M22 16.92v3a2 2 0 0 1-2.18 2 19.79 19.79 0 0 1-8.63-3.07 19.5 19.5 0 0 1-6-6 
             19.79 19.79 0 0 1-3.07-8.67A2 2 0 0 1 4.11 2h3a2 2 0 0 1 2 1.72 12.84 12.84 
             0 0 0 .7 2.81 2 2 0 0 1-.45 2.11L8.09 9.91a16 16 0 0 0 6 6l1.27-1.27a2 2 0 
             0 1 2.11-.45 12.84 12.84 0 0 0 2.81.7A2 2 0 0 1 22 16.92z"></path>
  </svg> 
  Contact Us
</div>

        
      <li class="nav-item dropdown">
        <a class="nav-link dropdown-toggle dropdown-toggle-nocaret position-relative" data-bs-auto-close="outside"
          data-bs-toggle="dropdown" href="javascript:(0);" id="notification">
          <i class="material-symbols-rounded">notifications</i>
          <span class="badge-notify">1</span>
        </a>
      </li>

      <li class="nav-item dropdown">
        <a href="javascript:;" class="dropdown-toggle dropdown-toggle-nocaret" data-bs-toggle="dropdown">
          <img src="assets/images/avatars/01.png" class="rounded-circle p-1 border" width="45" height="45">
        </a>
        <div class="dropdown-menu dropdown-user dropdown-menu-end shadow">
          <a class="dropdown-item gap-2 py-2" href="javascript:;">
            <div class="text-center">
              <img src="assets/images/avatars/01.png" class="rounded-circle p-1 shadow mb-3" width="90" height="90"
                alt="">
              <h5 class="user-name mb-0 fw-bold"><?php echo $_SESSION['company_name'];?></h5>
            </div>
          </a>
          <hr class="dropdown-divider">
          <a class="dropdown-item d-flex align-items-center gap-2 py-2" href="vip"><i class="material-symbols-rounded">person_outline</i>Profile</a>
          <a class="dropdown-item d-flex align-items-center gap-2 py-2" href="settings"><i class="material-symbols-rounded">settings</i>Setting</a>
          <a class="dropdown-item d-flex align-items-center gap-2 py-2" href="plugin"><i class="material-symbols-rounded">cloud_download</i>Downloads</a>
          <hr class="dropdown-divider">
          <a class="dropdown-item d-flex align-items-center gap-2 py-2" href="javascript:void(0);" onclick="confirmLogout()">
            <i class="material-symbols-rounded text-danger">power_settings_new</i>Logout 
          </a>
        </div>
      </li>
    </ul>
  </nav>
</header>

  <!--end top header-->


  <!--start sidebar-->
  <aside class="sidebar-wrapper">
      
    <div class="sidebar-header">
      <div class="logo-icon">
        <img src="../favicon.ico" class="logo-img" alt="">
      </div>
      <div class="logo-name flex-grow-1">
        <h5 class="mb-0">PROBOT UPI</h5>
      </div>
      <div class="sidebar-close">
        <span class="material-symbols-rounded">close</span>
      </div>
    </div>
    
    <div class="sidebar-nav" data-simplebar="true">
      
        <!--navigation-->
        <ul class="metismenu" id="sidenav">
            
         <li>
        <a href="dashboard">
        <div class="parent-icon"><i class="material-symbols-rounded">dashboard</i></div>
        <div class="menu-title">Dashboard</div>
        </a>
        </li>

        <li>
            <a href="upisettings">
              <div class="parent-icon"><i class="material-symbols-rounded">storefront</i>
              </div>
              <div class="menu-title">Connect Merchant</div>
              <span class="ms-auto text-info" id="merchant_menu_label" style="font-size: 1.5rem;"> <span class="svg-icon d-flex align-items-center badge-soft-danger text-danger"><svg class="mr-0 icon icon-tabler icon-tabler-link bg-danger p-1 rounded bg-opacity-10" width="24" height="24" viewBox="0 0 24 24" stroke-width="2" stroke="currentColor" fill="none" stroke-linecap="round" stroke-linejoin="round"><path stroke="none" d="M0 0h24v24H0z" fill="none"></path><path d="M10 14a3.5 3.5 0 0 0 5 0l4 -4a3.5 3.5 0 0 0 -5 -5l-.5 .5"></path><path d="M14 10a3.5 3.5 0 0 0 -5 0l-4 4a3.5 3.5 0 0 0 5 5l.5 -.5"></path><line x1="16" y1="21" x2="16" y2="19"></line><line x1="19" y1="16" x2="21" y2="16"></line><line x1="3" y1="8" x2="5" y2="8"></line><line x1="8" y1="3" x2="8" y2="5"></line></svg></span></span>
            </a>
        </li>
              
              
            <?php if ($route_2 == 'on') { ?>
          <li class="menu-label">Services</li>
        
          <li>
            <a href="javascript:;" class="has-arrow">
              <div class="parent-icon"><i class="material-symbols-rounded">payments</i>
              </div>
              <div class="menu-title">Pay To </div>
            </a>
            <ul>
              </li>
              <li><a href="pay-to-bank"><i class="material-symbols-rounded">arrow_right</i>Bank</a>
              </li>
              <li><a href="pay-to-upi"><i class="material-symbols-rounded">arrow_right</i>Upi</a>
              </li>
               <li><a href="pay-to-user"><i class="material-symbols-rounded">arrow_right</i>User</a>
              </li>
            </ul>     
          </li>
          
          
           <li>
            <a href="javascript:;" class="has-arrow">
              <div class="parent-icon"><i class="material-symbols-rounded">history_edu</i>
              </div>
              <div class="menu-title">Payout History</div>
            </a>
            <ul>
              <li><a href="payouts-upi"><i class="material-symbols-rounded">arrow_right</i>Upi Payouts</a>
              </li>
              <li><a href="payouts-bank"><i class="material-symbols-rounded">arrow_right</i>Bank Payouts</a>
              </li>
            </ul>     
          </li>
          <?php } ?>
          

           <?php if ($route_2 == 'on') { ?>
          <li>
            <a class="has-arrow" href="javascript:;">
              <div class="parent-icon"><i class="material-symbols-rounded">card_giftcard</i>
              </div>
              <div class="menu-title">Gift</div>
            </a>
            <ul>
              <li><a href="gift-claim"><i class="material-symbols-rounded">arrow_right</i>Reedem</a>
              </li>
              <li><a href="component-accordions.html"><i class="material-symbols-rounded">arrow_right</i>Transfer</a>
              </li>
            </ul>
          </li>
          
          <li>
            <a href="paylink">
                <div class="parent-icon"><i class="material-symbols-rounded">link</i></div>
                <div class="menu-title">Payment Link</div>
            </a>
          </li>

        <?php } ?>

        <li class="menu-label">Transaction</li>
           
          <li>
            <a href="transactions">
                <div class="parent-icon"><i class="material-symbols-rounded">history</i></div>
                <div class="menu-title">Transaction</div>
            </a>
        </li>
          
          
          
         <li class="menu-label">Plans</li>
          
         <li>
            <a href="subscription">
                <div class="parent-icon"><i class="material-symbols-rounded">shopping_cart</i></div>
                <div class="menu-title">Buy Plan</div>
            </a>
            
        </li>
        <li>
            <a href="buy-plan-transactions">
                <div class="parent-icon"><i class="material-symbols-rounded">toggle_on</i></div>
                <div class="menu-title">Active Subscription</div>
            </a>
        </li>

          
          
      
          <li class="menu-label">API & Docs</li>
          
          <li>
            <a href="api_keys"><i class="material-symbols-rounded">terminal</i>
                <div class="menu-title">API Keys & Webhooks</div>
            </a>
        </li>
          
           <li>
            <a href="#" class="has-arrow">
              <div class="parent-icon"><i class="material-symbols-rounded">description</i>
              </div>
              <div class="menu-title"> API Documentation</div>
            </a>
            <ul>
               
              <li><a href="docs-payin"><i class="material-symbols-rounded">arrow_right</i>PayIn Docs</a>
              </li>
               <?php if ($route_2 == 'on') { ?>
              <li><a href="docs-payout"><i class="material-symbols-rounded">arrow_right</i>Payout Docs</a>
              </li>
              <?php } ?>
            </ul>     
          </li>
          
          
          
          <li>
            <a href="plugin">
              <div class="parent-icon"><i class="material-symbols-rounded">
                  electrical_services
              </i>
              </div>
              <div class="menu-title">Plugins</div>
            </a>
          </li>
        
        
          <!--<li class="menu-label">Settings</li>
          
          <li>
            <a href="settings">
              <div class="parent-icon"><i class="material-symbols-rounded">settings</i>
              </div>
              <div class="menu-title">Settings</div>
            </a>
          </li>-->
          
         <!--
          <li>
            <a href="2fa">
              <div class="parent-icon"><i class="material-symbols-rounded">verified_user</i>
              </div>
              <div class="menu-title">2FA</div>
            </a>
          </li>-->
          
          <!--<li>
            <a href="faq">
              <div class="parent-icon"><i class="material-symbols-rounded">help_outline</i>
              </div>
              <div class="menu-title">FAQ</div>
            </a>
          </li>-->

          <!--<li>
            <a href="sync">
              <div class="parent-icon"><i class="material-symbols-rounded">autorenew</i>
              </div>
              <div class="menu-title">Sync Panel</div>
            </a>
          </li>-->
          
        <!--<li>
                <a href="control">
                    <div class="parent-icon"><i class="material-symbols-rounded">build</i></div>
                    <div class="menu-title">Control Panel</div>
                </a>
            </li>

            <li>
                <a href="paygram">
                    <div class="parent-icon"><i class="material-symbols-rounded">account_tree</i></div>
                    <div class="menu-title">PayGram</div>
                </a>
            </li>  -->


         </ul>
        <!--end navigation-->
    </div>
    
    <div class="sidebar-bottom gap-4">
        <div class="dark-mode">
          <a href="javascript:;" class="footer-icon dark-mode-icon">
            <i class="material-symbols-rounded">dark_mode</i>  
          </a>
        </div>
        <div class="dropdown dropup-center dropup dropdown-laungauge">
          <a class="dropdown-toggle dropdown-toggle-nocaret footer-icon" href="javascript:;" data-bs-toggle="dropdown"><img src="assets/images/county/08.png" width="22" alt="">
          </a>
          <ul class="dropdown-menu dropdown-menu-end">
            <li><a class="dropdown-item d-flex align-items-center py-2" href="javascript:;"><img src="assets/images/county/08.png" width="20" alt=""><span class="ms-2">English</span></a>
            </li>
          </ul>
        </div>
    </div>
    
</aside>
<!--end sidebar-->

<script src="https://cdn.jsdelivr.net/npm/sweetalert2@11"></script>
<script>
    function confirmLogout() {
        Swal.fire({
            title: "Do you really want to log out?",
             text: "If you log out, you will have to log in again to access your account.",
            showCancelButton: true,
            confirmButtonText: "Yes, log out",
            cancelButtonText: "No, stay logged in",
            customClass: {
                        popup: "swal2-border-radius",
                        confirmButton: "swal2-confirm-lg",
                        cancelButton: "swal2-confirm-lg",
                    },
            icon: "warning" 
        }).then((result) => {
            if (result.isConfirmed) {
                window.location.href = "logout";
            }
        });
    }
</script>

<script>
        document.getElementById('notification').addEventListener('click', function() {
            // Add your PHP logic here
            <?php
            // Retrieve user ID from the session
            $merchant_id = $userdata['merchant_id'];

            if ($userdata['telegram_subscribed'] == 'on') {
                // Show SweetAlert2 warning message
                echo '
                Swal.fire({
                    icon: "warning",
                    title: "You are already subscribed to our telegram notifications!",
                    text: "@probot_tohost_bot",
                    showConfirmButton: true,
                    confirmButtonText: "Ok!",
                    allowOutsideClick: false,
                    customClass: {
                                popup: "swal2-border-radius",
                                confirmButton: "swal2-confirm-lg"
                            },
                    allowEscapeKey: false
                });
                ';
            } elseif ($userdata['telegram_subscribed'] == 'off') {
                // Your project, make sure to change this to your actual domain or identifier
                // Your project name or identifier
                $subscribeLink = "https://t.me/probot_tohost_bot?start=" . $merchant_id;

                // Display SweetAlert2 confirmation dialog
                echo '
                Swal.fire({
                    icon: "question",
                    title: "Subscribe to Notifications?",
                    text: "Please subscribe to our telegram notifications",
                    showCancelButton: true,
                    confirmButtonText: "Subscribe",
                    cancelButtonText: "Not now",
                    allowOutsideClick: false,
                    customClass: {
                                popup: "swal2-border-radius",
                                confirmButton: "swal2-confirm-lg",
                                cancelButton: "swal2-confirm-lg"
                            },
                    allowEscapeKey: false
                }).then((result) => {
                    if (result.isConfirmed) {
                        // Redirect to subscribe link
                        window.open("' . $subscribeLink . '", "_blank");
                    } 
                });
                ';
            }
            ?>
        });
    </script>
<script>
    document.addEventListener("DOMContentLoaded", function() {
    var hiddenElements = document.querySelectorAll(".hidden-on-load");
    hiddenElements.forEach(function(element) {
        element.classList.add("hidethemenu");
    });
});
</script>



  <!--plugins-->
  <script src="assets/js/jquery.min.js"></script>
  <!--bootstrap js-->
  <script src="assets/js/bootstrap.bundle.min.js"></script>
  <!--plugins-->
  <script src="assets/plugins/perfect-scrollbar/js/perfect-scrollbar.js"></script>
  <script src="assets/plugins/metismenu/metisMenu.min.js"></script>
  <script src="assets/plugins/peity/jquery.peity.min.js"></script>
  <script src="assets/plugins/simplebar/js/simplebar.min.js"></script>


  
