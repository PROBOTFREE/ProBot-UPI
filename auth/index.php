<?php
// **PREVENTING SESSION HIJACKING**
// Prevents javascript XSS attacks aimed to steal the session ID
ini_set('session.cookie_httponly', 1);

// **PREVENTING SESSION FIXATION**
// Session ID cannot be passed through URLs
ini_set('session.use_only_cookies', 1);

// Uses a secure connection (HTTPS) if possible
ini_set('session.cookie_secure', 1);
session_start();


// Define the base directory constant
define('BASE_DIR', realpath(dirname(__FILE__)) . '/');
// Include the config.php file to load configuration settings
include "config.php";
// Securely include other files using the BASE_DIR constant
include "../pages/dbFunctions.php";

// Check if the user is already logged in
if(isset($_SESSION['user_id'])) {
    // Redirect to the dashboard if the user is already logged in
    header("Location: dashboard");
    exit();
}

?>

<head>
    <html lang="en" data-bs-theme="dark">
    <title>PROBOT UPI</title>

    
    

  
  <!--- Main Login Page Header --->
  <meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	
	<link rel="icon" type="image/png" href="../favicon.ico"/>

	<link rel="stylesheet" type="text/css" href="assets/fonts/font-awesome-4.7.0/css/font-awesome.min.css">

	<link rel="stylesheet" type="text/css" href="vendor/animate/animate.css">
	
	<link rel="stylesheet" type="text/css" href="vendor/css-hamburgers/hamburgers.min.css">

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
if (isset($_POST['submit'])) {
    $username = mysqli_real_escape_string($conn, $_POST['username']);
    $password = mysqli_real_escape_string($conn, $_POST['password']);

    $stmt = $conn->prepare("SELECT * FROM users WHERE mobile = ?");
    $stmt->bind_param("s", $username);
    $stmt->execute();
    $result = $stmt->get_result();
    $row = $result->fetch_assoc();
    
    // Check if user exists
    if ($result->num_rows > 0) {
       
        
        $hashFromDatabase = $row['password'];
        $acc_lock = $row['acc_lock'];
        $acc_ban = $row['acc_ban'];
        $byteuserid = $row['id'];
        $cxrtotp_user = $row['totp_user'];
        $cxrtotp_secret = $row['totp_secret'];
        $CXrcompanyname = $row['company'];
        $cxrtheme = $row['theme'];

        if ($acc_ban == 'on') {
            echo '<script>
            document.addEventListener("DOMContentLoaded", function() {
            Swal.fire({
                title: "Account Got Locked!", 
                text: "Please contact our support team.", 
                icon: "error", 
                customClass: {
                        popup: "swal2-border-radius",
                        confirmButton: "swal2-confirm-lg",
                    },
                confirmButtonText: "Contact Us"}).then((result) => { 
                    if (result.isConfirmed) {
                    window.location.href = "https://telegram.me/SonixMusicDev"; 
                    }
                });
            });
                </script>';
            exit;
        }
        if ($acc_lock >= 3) {
            echo '<script>
            document.addEventListener("DOMContentLoaded", function() {
            Swal.fire({
            title: "Account Got Locked!", 
            text: "Too many failed login attempts. Please contact the administrator.",
            icon: "error", 
            customClass: {
                        popup: "swal2-border-radius",
                        confirmButton: "swal2-confirm-lg",
                    },
            confirmButtonText: "Contact Us"}).then((result) => { 
                if (result.isConfirmed) { window.location.href = "https://telegram.me/SonixMusicDev"; }
                
                });
            });
                </script>';
            exit;
        }

        if (password_verify($password, $hashFromDatabase)) {
            $_SESSION['username'] = $username;
            $_SESSION['user_id'] = $byteuserid;
            $_SESSION['company_name'] = $CXrcompanyname;
            $_SESSION['theme'] = $cxrtheme;

            $update_stmt = $conn->prepare("UPDATE users SET acc_lock = ? WHERE mobile = ?");
            $update_stmt->bind_param("is", $acc_lock, $username);
            $update_stmt->execute();

            $paymentUrl="dashboard";

            header('Location: ' . $paymentUrl);
            exit;
        } else {
            $acc_lock++;
            $update_stmt = $conn->prepare("UPDATE users SET acc_lock = ? WHERE mobile = ?");
            $update_stmt->bind_param("is", $acc_lock, $username);
            $update_stmt->execute();


            echo '<script>
            document.addEventListener("DOMContentLoaded", function() {
            Swal.fire({
                title: "Invalid Credentials!",
                text: "The credentials you entered are incorrect. Please try again.",
                icon: "error",
                customClass: {
                        popup: "swal2-border-radius",
                        confirmButton: "swal2-confirm-lg",
                    },
                confirmButtonText: "Ok"}).then((result) => { 
                    if (result.isConfirmed) { window.location.href = "index"; }
                    
                });
            });
                    </script>';
            exit;
        }
    } else {
        echo '<script>
        document.addEventListener("DOMContentLoaded", function() {
        Swal.fire({
            title: "Username Does not Exist!", 
            text: "The username you entered does not exist. Please check and try again.",
            icon: "error", 
            customClass: {
                        popup: "swal2-border-radius",
                        confirmButton: "swal2-confirm-lg",
                    },
            confirmButtonText: "Ok"}).then((result) => {
                if (result.isConfirmed) { window.location.href = "index"; }
                
            });
        });
                </script>';
        exit;
    }
} else {
    // Form not submitted
}
?>

<body>
    
<div class="limiter">

<div class="container-login100">
  <div class="wrap-login100">
    <div class="login100-pic js-tilt" data-tilt>
      <img src="assets/images/img-01.png" alt="IMG">
    </div>
    
    

    <div class="container-register">
        <div class="probot-logo">
            <a href="#" style="display: flex; align-items: center; padding-bottom: 20px; text-decoration: none;">
            <img src="../assets/images/logo.webp" alt="Logo" width="52" height="52" style="margin-right: 10px;">
            <h1 class="logo" style="font-size: 24px; color: #333; margin: 0;">PROBOT UPI        </h1>
            </a>
        </div>
        <form class="login100-form validate-form" method="POST" action="<?php echo htmlspecialchars($_SERVER["PHP_SELF"]); ?>">
        <span class="login100-form-title">
            Member Login
        </span>

      <div class="wrap-input100 validate-input" data-validate="Valid email is required: ex@abc.xyz">
        <input class="input100" type="text" name="username" placeholder="Enter Mobile Number" minlength="10" maxlength="10" oninput="this.value = this.value.replace(/[^0-9]/g, '');" required>
        <span class="focus-input100"></span>
        <span class="symbol-input100">
          <i class="fa fa-phone" aria-hidden="true"></i>
        </span>
      </div>

      <div class="wrap-input100 validate-input" data-validate="Password is required">
        <input class="input100" type="password" name="password" placeholder="Password" required>
        <span class="focus-input100"></span>
        <span class="symbol-input100">
          <i class="fa fa-lock" aria-hidden="true"></i>
        </span>
      </div>

      <div class="container-login100-form-btn">
        <button class="login100-form-btn" type="submit" name="submit">
          Login
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
        <a class="txt2" href="https://couponcart.in/auth/register">
          Create your Account
          <i class="fa fa-long-arrow-right m-l-5" aria-hidden="true"></i>
        </a>
      </div>
    </form>
    </div>
  </div>
</div>
</body>



<!--===============================================================================================-->	
	
	<script src="vendor/jquery/jquery-3.2.1.min.js"></script>

<!--===============================================================================================-->
	<script src="vendor/bootstrap/js/popper.js"></script>
	<script src="vendor/bootstrap/js/bootstrap.min.js"></script>
<!--===============================================================================================-->
	<script src="vendor/select2/select2.min.js"></script>
<!--===============================================================================================-->
	<script src="vendor/tilt/tilt.jquery.min.js"></script>

</html>
