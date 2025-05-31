<!DOCTYPE html>
<html>
    
<?php
// Define the base directory constant
define('BASE_DIR', realpath(dirname(__FILE__)) . '/');
// Include the config.php file to load configuration settings
include BASE_DIR . 'config.php';
// Securely include other files using the BASE_DIR constant
include BASE_DIR . '../pages/dbFunctions.php';
?>

<head>
    <html lang="en" data-bs-theme="dark">
	<title>PROBOT UPI</title>

	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	
	<link rel="icon" type="image/png" href="../favicon.ico"/>

	<link rel="stylesheet" type="text/css" href="vendor/bootstrap/css/bootstrap.min.css">

	<link rel="stylesheet" type="text/css" href="assets/fonts/font-awesome-4.7.0/css/font-awesome.min.css">

	<link rel="stylesheet" type="text/css" href="vendor/animate/animate.css">
	
	<link rel="stylesheet" type="text/css" href="vendor/css-hamburgers/hamburgers.min.css">

	<link rel="stylesheet" type="text/css" href="vendor/select2/select2.min.css">

	<link rel="stylesheet" type="text/css" href="assets/css/util.css">
	<link rel="stylesheet" type="text/css" href="assets/css/main.css">
	
	<link rel="stylesheet" href="/auth/assets/css/bootstrap.min.css">
    <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i">

  <script type="text/javascript">if(window.history.replaceState){window.history.replaceState(null,null,window.location.href);}</script>
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
</style>
</head>




<?php

if (isset($_POST['create'])) {
   
    $mobile = mysqli_real_escape_string($conn, $_POST['mobile']);
    $email = mysqli_real_escape_string($conn, $_POST['email']);
    
    $checkMobileQuery = "SELECT * FROM `users` WHERE `mobile` = '$mobile'";
    $checkMobileResult = mysqli_query($conn, $checkMobileQuery);

    $checkEmailQuery = "SELECT * FROM `users` WHERE `email` = '$email'";
    $checkEmailResult = mysqli_query($conn, $checkEmailQuery);

    if (mysqli_num_rows($checkMobileResult) > 0) {
        echo '
        <script>
    document.addEventListener("DOMContentLoaded", function() {
        Swal.fire({
            title: "Oh! No ...",
            text: "Mobile Number Already Exists.",
            confirmButtonText: "Got it",
            customClass: {
                popup: "swal2-border-radius",
                confirmButton: "swal2-confirm-lg",
            },
            preConfirm: () => {
                location.reload(); 
            }
        });
    });
        </script>';
        exit;
    } elseif (mysqli_num_rows($checkEmailResult) > 0) {
        echo '
        <script>
            document.addEventListener("DOMContentLoaded", function() {
                Swal.fire({
                    title: "Opps! Sorry",
                    text: "Email Already Exist. Please use a different email",
                    confirmButtonText: "Got it",
                    icon: "error",
                    customClass: {
                        popup: "swal2-border-radius",
                        confirmButton: "swal2-confirm-lg",
                    },
                    preConfirm: () => {
                        location.reload();
                    }
                });
            });
        </script>';
        exit;
    } else {  
        // Proceed with user registration
        $password = mysqli_real_escape_string($conn, $_POST['password']);
        $name = mysqli_real_escape_string($conn, $_POST['name']);
        $company = mysqli_real_escape_string($conn, $_POST['company']);
        
        // Generate random instance_id, instance_secret, and merchant_id
        $instanceId = generateRandomInstanceId();
        $instanceSecret = generateRandomInstanceSecret();
        $merchantId = generateMerchantId(12);
        
        // Secure API key and secret key generation
        $api_key = generateApiKey(); // 256-bit secure key
        $secret_key = bin2hex(random_bytes(32)); // 256-bit secret key
        
        $pass = password_hash($password, PASSWORD_BCRYPT);
        $today = date("Y-m-d", strtotime("+7 days"));
        
        // Generate a random binary secret
        $secret = bin2hex(random_bytes(32)); // 80-bit secret key
        $encodedSecret = base32Encode($secret);
        
        $register = "INSERT INTO `users`(`name`, `mobile`, `password`, `email`, `company`, `user_token`, `expiry`, `instance_id`, `instance_secret`, `merchant_id`, `totp_secret`, `secret_key`, `vip_expiry`) 
    VALUES ('$name', '$mobile', '$pass', '$email', '$company', '$api_key', '$today', '$instanceId', '$instanceSecret', '$merchantId', '$encodedSecret', '$secret_key', '$today')";


        $result = mysqli_query($conn, $register);
      
        if ($result) {
            echo '
            <script>
                document.addEventListener("DOMContentLoaded", function() {
                    Swal.fire({
                        title: "Congratulations",
                        text: "You are now the member of Probot family. \nPlease login.",
                        confirmButtonText: "Login Now",
                        customClass: {
                            popup: "swal2-border-radius",
                            confirmButton: "swal2-confirm-lg",
                         },
                        icon: "success"
                    }).then((result) => {
                        if (result.isConfirmed) {
                            window.location.href = "index"; // Replace with your desired redirect URL
                        }
                    });
                });
            </script>';
            exit;
        } else {
            echo '
            <script>
                document.addEventListener("DOMContentLoaded", function() {
                    Swal.fire({
                        title: "Sign Up Failed!!",
                        text: "Please try again later!!",
                        confirmButtonText: "Got it",
                        icon: "error",
                        customClass: {
                            popup: "swal2-border-radius",
                            confirmButton: "swal2-confirm-lg",
                         },
                        preConfirm: () => {
                            location.reload();
                        }
                    });
                });
            </script>';
            exit;
        }
    }
}
?>
<body> 
  <div class="limiter"> 
    <div class="container-login100"> 
      <div class="wrap-Register100"> 
        <div class="login100-pic js-tilt" data-tilt> 
          <img src="assets/images/signup-image.png" alt="IMG"> 
        </div> 
        <div class="container-register">
        <form class="login100-form validate-form" method="POST" action="<?php echo htmlspecialchars($_SERVER["PHP_SELF"]); ?>"> 
          <span class="login100-form-title"> 
            Create an Account 
          </span>
          
          <div class="wrap-input100 validate-input" data-validate="Name is required"> 
            <input class="input100" type="text" name="name" placeholder="Enter Name" required> 
            <span class="focus-input100"></span> 
            <span class="symbol-input100"> 
              <i class="fa fa-user" aria-hidden="true"></i> 
            </span> 
          </div>

          <div class="wrap-input100 validate-input" data-validate="Valid mobile number is required"> 
            <input class="input100" type="text" name="mobile" placeholder="Enter Mobile Number" oninput="this.value = this.value.replace(/[^0-9]/g, '').slice(0, 10);" required> 
            <span class="focus-input100"></span> 
            <span class="symbol-input100"> 
              <i class="fa fa-phone" aria-hidden="true"></i> 
            </span> 
          </div>

          <div class="wrap-input100 validate-input" data-validate="Password is required"> 
            <input class="input100" type="password" name="password" placeholder="Enter Password" required> 
            <span class="focus-input100"></span> 
            <span class="symbol-input100"> 
              <i class="fa fa-lock" aria-hidden="true"></i> 
            </span> 
          </div>

          <div class="wrap-input100 validate-input" data-validate="Valid email is required"> 
            <input class="input100" type="email" name="email" placeholder="Enter Email Address" required> 
            <span class="focus-input100"></span> 
            <span class="symbol-input100"> 
              <i class="fa fa-envelope" aria-hidden="true"></i> 
            </span> 
          </div>

          <div class="wrap-input100 validate-input" data-validate="Company name is required"> 
            <input class="input100" type="text" name="company" placeholder="Enter Company Name" required> 
            <span class="focus-input100"></span> 
            <span class="symbol-input100"> 
              <i class="fa fa-building" aria-hidden="true"></i> 
            </span> 
          </div>

          <div class="wrap-input100 validate-input" data-validate="Website URL is required"> 
            <input class="input100" type="text" name="weburl" placeholder="Enter Website URL" required> 
            <span class="focus-input100"></span> 
            <span class="symbol-input100"> 
              <i class="fa fa-globe" aria-hidden="true"></i> 
            </span> 
          </div>
            
            <div class="checkbox-wrapper-13 terms">
                <input id="c1-13" type="checkbox" id="terms" required>
                    I agree to our <a href="#" style="color: green; text-decoration: none;">terms & conditions</a>
            </div>

          <div class="container-login100-form-btn"> 
            <button class="login100-form-btn" type="submit" name="create"> 
              Submit
            </button> 
          </div>

          <div class="text-center p-t-12"> 
            <span class="txt1"> 
              Forgot 
            </span> 
            <a class="txt2" href="#"> 
              Username / Password? 
            </a> 
          </div>

          <div class="text-center p-t-60"> 
            <a class="txt2" href="index"> 
              Already have an account? Login
              <i class="fa fa-long-arrow-right m-l-5" aria-hidden="true"></i> 
            </a> 
          </div> 
        </form>
        </div>
      </div> 
    </div> 
  </div> 
</body>


<!--===================================-->
	<script src="vendor/bootstrap/js/popper.js"></script>
	<script src="vendor/bootstrap/js/bootstrap.min.js"></script>
<!--===============================================================================================-->
	<script src="vendor/select2/select2.min.js"></script>
<!--===============================================================================================-->
	<script src="vendor/tilt/tilt.jquery.min.js"></script>
	<script >
		$('.js-tilt').tilt({
			scale: 1.1
		})
	</script>

</html>			