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
include "../pages/dbFunctions.php";
include "../auth/config.php";


?>

<!doctype html>
<html lang="en" class="light-theme">

<head>
  <!-- Required meta tags -->
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">

  <!-- loader-->
  <link href="assets/css/pace.min.css" rel="stylesheet" />
  <script src="assets/js/pace.min.js"></script>

  <!--plugins-->
  <link href="assets/plugins/perfect-scrollbar/css/perfect-scrollbar.css" rel="stylesheet" />

  <!-- CSS Files -->
  <link href="assets/css/bootstrap.min.css" rel="stylesheet">
  <link href="assets/css/bootstrap-extended.css" rel="stylesheet">
  <link href="assets/css/style.css" rel="stylesheet">
  <link href="assets/css/icons.css" rel="stylesheet">
  <link href="https://fonts.googleapis.com/css2?family=Roboto:wght@400;500&display=swap" rel="stylesheet">
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
    
    .hidethemenu {
  display: none !important;
}
</style>
</head>

<?php

if (isset($_POST['loginow'])) {
   
    $username = $_POST['username'];
    $password = $_POST['password'];
   

    $query = "SELECT * FROM admin WHERE username = '$username' AND status = 'on'";
    $result = mysqli_query($conn, $query);
    if (mysqli_num_rows($result) > 0) {
        $row = mysqli_fetch_assoc($result);
        $hashedPassword = $row['password']; // Assuming password column name is 'password' in your database
       

        if (password_verify($password, $hashedPassword)) {
           
                
                $_SESSION['username'] = $username;
                $_SESSION['user_type'] = 'admin';
                header("location: dashboard");
                exit;
           
        } else {
            
        echo '<script>
        window.onload = function() {
        Swal.fire({
            icon: "error",
            title: "Invalid Credentials",
            text: "The credentials you entered are incorrect. Please try again.",
            showConfirmButton: false,
            allowOutsideClick: false,
            customClass: {
                popup: "swal2-border-radius"
            },
            allowEscapeKey: false,
            timer: 3000
        });
        };
      </script>';

        }
    } else {
        
        echo '<script>
        window.onload = function() {
    Swal.fire({
        icon: "error",
        title: "User Not Found",
        text: "The Admin ID you entered is either disabled or does not exist. Please contact support or try again.",
        allowOutsideClick: false,
        customClass: {
            popup: "swal2-border-radius"
        },
        showConfirmButton: false,
        allowEscapeKey: false,
        timer: 3000
    });
        };
</script>';

    }
}

?>


<body>

  <!--start wrapper-->
  <div class="wrapper">
    <header>
      <nav class="navbar navbar-expand-lg navbar-light bg-transparent p-3">
        <div class="container-fluid">
          <a href="javascript:;"><img src="/favicon.ico" alt="" /></a>
          <button class="navbar-toggler" type="button" data-bs-toggle="collapse"
            data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false"
            aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
          </button>
          <div class="collapse navbar-collapse" id="navbarSupportedContent">
            <ul class="navbar-nav mx-auto mb-2 mb-lg-0 gap-3">
              <!-- Removed Home, About Us, Team, Products, Blog, Contact -->
            </ul>
            <!-- Removed Buy Now button -->
          </div>
        </div>
      </nav>
    </header>
    <div class="container">
      <div class="row">
        <div class="col-xl-4 col-lg-5 col-md-7 mx-auto mt-5">
          <div class="card radius-10">
            <div class="card-body p-4">
              <div class="text-center">
                <h4>Sign In</h4>
                <p>Sign In to your account</p>
              </div>
              <form method="post" action="" class="form-body row g-3">
                <div class="col-12">
                  <label for="inputEmail" class="form-label">Username</label>
                  <input type="text" class="form-control" id="inputEmail" name="username" required>
                </div>
                <div class="col-12">
                  <label for="inputPassword" class="form-label">Password</label>
                  <input type="password" class="form-control" id="inputPassword" name="password" required>
                  <input type="hidden" name="recaptcha_response" id="recaptchaResponse">
                </div>
                <div class="col-12 col-lg-6">
                  <div class="form-check form-switch">
                    <input class="form-check-input" type="checkbox" role="switch" id="flexSwitchCheckRemember">
                    <label class="form-check-label" for="flexSwitchCheckRemember">Remember Me</label>
                  </div>
                </div>
                
                <div class="col-12 col-lg-12">
                  <div class="d-grid">
                    <button type="submit" name="loginow" class="btn btn-primary">Sign In</button>
                  </div>
                </div>
              </form>
            </div>
          </div>
        </div>
      </div>
    </div>
    
  </div>
  <!--end wrapper-->

  <script src="assets/js/bootstrap.bundle.min.js"></script>
</body>

</html>


