<?php

// Define the absolute path to the functions.php file
define('ABSPATH', dirname(__FILE__) . '/'); // Adjust the path as needed
// Include the database connection file
require_once(ABSPATH . 'header.php');


?>
<head>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <!--favicon-->
  <link rel="icon" href="assets/images/favicon-32x32.png" type="image/png">

  <!--plugins-->
  <link href="assets/plugins/perfect-scrollbar/css/perfect-scrollbar.css" rel="stylesheet">
  <link rel="stylesheet" type="text/css" href="assets/plugins/metismenu/metisMenu.min.css">
  <link rel="stylesheet" type="text/css" href="assets/plugins/metismenu/mm-vertical.css">
  <link rel="stylesheet" type="text/css" href="assets/plugins/simplebar/css/simplebar.css">
  <!--bootstrap css-->
  <link href="assets/css/bootstrap.min.css" rel="stylesheet">
  <link href="assets/plugins/datatable/css/dataTables.bootstrap5.min.css" rel="stylesheet" />
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
</style>
</head>




<?php
// Function to sanitize user input
    function sanitizeInput($input) {
        if (is_string($input)) {
            return htmlspecialchars(trim($input), ENT_QUOTES, 'UTF-8');
        } else {
            // Handle non-string input here (e.g., arrays, objects, etc.) if needed.
            return $input;
        }
    }
    

if(isset($_POST['verifyotp'])) {
    
    // Show SweetAlert2 error message
echo '<script>
    Swal.fire({
        icon: "error",
        title: "Merchant instance is not set in instance app!!",
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
            window.location.href = "upisettings"; // Redirect to "upisettings" when the user clicks the confirm button
        }
    });
</script>';
exit;

    
    $bbbyteuserid=$_SESSION['user_id'];
    
    $postinstanceid=sanitizeInput($_POST["IID"]);
    $postinstancesecret=sanitizeInput($_POST["IIDSecret"]);
    $postupiid=sanitizeInput($_POST["UPI"]);
    
    // Check if instance_id and instance_secret match a record in the users table
$query = "SELECT id, user_token FROM users WHERE instance_id = ? AND instance_secret = ?";
$stmt = $conn->prepare($query);
$stmt->bind_param("ss", $postinstanceid, $postinstancesecret);
$stmt->execute();
$result = $stmt->get_result();

if ($result->num_rows !== 1) {
    // Code to execute when the conditions are not met
    // Show SweetAlert2 error message
echo '<script>
    Swal.fire({
        icon: "error",
        title: "Invalid Instance ID!!",
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
            window.location.href = "upisettings"; // Redirect to "upisettings" when the user clicks the confirm button
        }
    });
</script>';
exit;

} else {
    // Matching record found, fetch id and user_token
    $row = $result->fetch_assoc();
    $user_id = $row['id'];
    $user_token = $row['user_token'];
    $cxrabbidverify=$userdata['user_token'];
    
    if ($cxrabbidverify==$user_token){
        
       
       $sqlUpdateUser = "UPDATE users SET googlepay_connected='Yes' WHERE user_token='$cxrabbidverify'";
    $resultUpdateUser = mysqli_query($conn, $sqlUpdateUser);
    
    
       $sqlw = "UPDATE googlepay_tokens SET Instance_Id='$postinstanceid', Upiid='$postupiid', status='Active', user_id=$bbbyteuserid WHERE user_token='$cxrabbidverify'";
$result = mysqli_query($conn, $sqlw);

if ($result) {
       
  
    
     
    // Show SweetAlert2 success message
        
echo '<script>
    Swal.fire({
        icon: "success",
        title: "Congratulations",
        text: "Your Google Pay has been connected successfully!",
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
            window.location.href = "upisettings"; // Redirect to "upisettings" when the user clicks the confirm button
        }
    });
</script>';

    //exit;
    
    
} else {
    // Query failed
  //  echo "Error: " . mysqli_error($conn);
  
   // Show SweetAlert2 error message
echo '<script>
    Swal.fire({
        icon: "error",
        title: "Please try again later!!",
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
            window.location.href = "upisettings"; // Redirect to "upisettings" when the user clicks the confirm button
        }
    });
</script>';
exit;

  
}

    } else{
        
echo '<script>
    Swal.fire({
        icon: "error",
        title: "Invalid Token Mismatch!!",
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
            window.location.href = "upisettings"; // Redirect to "upisettings" when the user clicks the confirm button
        }
    });
</script>';
exit;
    }  //> token mismatch

}
    
    
    
   

    
}
//form


if(isset($_POST['Verify'])) {
    


if ($userdata['googlepay_connected']=="Yes"){
echo '<script>
    Swal.fire({
        icon: "error",
        title: "Merchant is already connected !!",
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
            window.location.href = "upisettings"; // Redirect to "upisettings" when the user clicks the confirm button
        }
    });
</script>';
exit;

        
        
    }
    
    $bbgooglepaymobile=sanitizeInput($_POST['googlepay_mobile']); 
    $constructedUpi = $bbgooglepaymobile . '-1@okaxis';
    
    $instanceId=$userdata['instance_id'];
    $secret=$userdata['instance_secret'];
    
    $baseUrl = 'https://couponcart.in/api/instance/events/google-pay';
$fullUrl = $baseUrl . '?instance=' . urlencode($instanceId) . '&secret=' . urlencode($secret);

    

    // Now, you can use the $paytm_mobile variable as needed
?>
<body>
    <!--start main wrapper-->
<main class="main-wrapper">
    <div class="main-content">
        
        <!--breadcrumb-->
        <div class="page-breadcrumb d-none d-sm-flex align-items-center mb-3">
            <div class="breadcrumb-title pe-3">Upi Settings</div>
            <div class="ps-3">
                <nav aria-label="breadcrumb">
                    <ol class="breadcrumb mb-0 p-0">
                        <li class="breadcrumb-item"><a href="javascript:;"><i class="bx bx-home-alt"></i></a>
                        </li>
                        <li class="breadcrumb-item active" aria-current="page">Google Pay UPI Settings</li>
                    </ol>
                </nav>
            </div>
        </div>
        <!--end breadcrumb-->
            <div class="container-fluid">
                <h4 class="page-title">Google Pay UPI Settings</h4>
                <div class="row row-card-no-pd">
                    <div class="col-md-12">
                        <form method="POST" action="<?php echo htmlspecialchars($_SERVER["PHP_SELF"]); ?>" class="mb-2">
                            <div class="row" id="merchant">
                                <div class="col-md-4 mb-2"> 
                                    <label>Enter Instance ID</label> 
                                    <input type="text" name="IID" placeholder="Enter Instance ID"  class="form-control" required=""> 
                                    <input type="hidden" class="form-control" id="IIDSecret" name="IIDSecret" value="<?php echo $secret; ?>">
                                </div>
                                
                               <div class="col-md-4 mb-2"> 
                               <label>Instance Url</label> 
                               <input type="text" name="Iurl" placeholder="Instance Url" value="<?php echo $fullUrl; ?>" class="form-control" required readonly> 
                               </div>

                                <div class="col-md-4 mb-2"> 
                                    <label>Upi ID</label>
                                <input type="text" class="form-control" id="number" name="UPI" value="<?php echo $constructedUpi; ?>">
                                
                                </div>
                                <div class="col-md-4 mb-2"> 
                                
                                </div>
                                    <label>&nbsp;</label> 
                                    <button type="submit" name="verifyotp" class="btn btn-primary btn-block">Verify Google Pay</button> 
                                </div>
                            </div>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </div>
    </body>
<?php
} // End of if(isset($_POST['Verify']))

?>
