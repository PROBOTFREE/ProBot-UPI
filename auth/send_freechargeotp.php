<?php
session_start();
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
if (isset($_POST['Verify'])) {
    

    function sanitizeInput($input) {
        if (is_string($input)) {
            return htmlspecialchars(trim($input), ENT_QUOTES, 'UTF-8');
        } else {
            return $input;
        }
    }

    function curlGet2($url) {
        $ch = curl_init();
        curl_setopt($ch, CURLOPT_URL, $url);
        curl_setopt($ch, CURLOPT_RETURNTRANSFER, true);
        curl_setopt($ch, CURLOPT_SSL_VERIFYPEER, false);
        $response = curl_exec($ch);
        
        if (curl_errno($ch)) {
            echo 'cURL error: ' . curl_error($ch);
            curl_close($ch);
            return null;
        }
        
        curl_close($ch);
        return $response;
    }

    $no = sanitizeInput($_REQUEST['freecharge_mobile']);
    $url = "https://couponcart.in/fcharge/otp.php?no=" . urlencode($no);
    $response = curlGet2($url);

    if ($response !== null) {
        $json = json_decode($response, true);
        
        if (json_last_error() === JSON_ERROR_NONE) {
            $status = isset($json["status"]) ? $json["status"] : '';
            $data = isset($json["data"]) ? $json["data"] : [];
            $msg = isset($json["msg"]) ? $json["msg"] : '';
            $otpId = isset($data["otpId"]) ? $data["otpId"] : '';

            if ($status === 'success') {
                $_SESSION['otpId'] = $otpId;

echo '<script>
    Swal.fire({
        title: "Your OTP Has Been Sent!!",
        toast: true,
        position: "top-end",
        showConfirmButton: false,
        customClass: {
                        popup: "swal2-border-radius",
                        confirmButton: "swal2-confirm-lg",
                    },
        timer: 3000,
        icon: "success",
    });
                </script>';
?>

<!--start main wrapper-->
<main class="main-wrapper">
    <div class="main-content">
        <!--breadcrumb-->
        <div class="page-breadcrumb d-none d-sm-flex align-items-center mb-3">
            <div class="breadcrumb-title pe-3">Vip Menu</div>
            <div class="ps-3">
                <nav aria-label="breadcrumb">
                    <ol class="breadcrumb mb-0 p-0">
                        <li class="breadcrumb-item"><a href="javascript:;"><i class="bx bx-home-alt"></i></a>
                        </li>
                        <li class="breadcrumb-item active" aria-current="page">My Vip Profile</li>
                    </ol>
                </nav>
            </div>
        </div>
        <!--end breadcrumb-->
        <div class="container-fluid">
            <h4 class="page-title">UPI Settings</h4>
            <div class="row row-card-no-pd">
                <div class="col-md-12">
                    <form method="POST" action="freecharge_vf" class="mb-2">
                        <div class="row" id="merchant">
                            <div class="col-md-4 mb-2">
                                <label>Enter OTP</label>
                                <input type="number" name="otp" placeholder="Enter OTP" class="form-control" required="">
                            </div>
                            <div class="col-md-4 mb-2">
                                <label>OTP ID</label>
                                <input type="text" name="otpId" value="<?php echo $_SESSION['otpId']; ?>" class="form-control" readonly>
                            </div>
                            <input type="hidden" class="form-control" id="number" name="number" value="<?php echo $no; ?>">
                            <input type="hidden" class="form-control" id="number" name="UPI" value="<?php echo ''; ?>">
                            <input type="hidden" class="form-control" id="user_token" name="user_token" value="<?php echo $userdata['user_token']; ?>"><br><br>
                            <input type="hidden" name="csrf_token" value="<?php echo $_SESSION['csrf_token']; ?>"><br><br>
                            <input type="hidden" class="form-control" id="seassion" name="seassion" value="<?php echo $sessionId; ?>"><br><br>
                            <input type="hidden" class="form-control" id="deviceid" name="deviceid" value="<?php echo $deviceid; ?>"><br><br>
                            <div class="col-md-4 mb-2">
                                <label>&nbsp;</label>
                                <button type="submit" name="verifyotp" class="btn btn-primary btn-block">Verify OTP</button>
                            </div>
                        </div>
                    </form>
<?php
            } else {
            echo '<script>
    Swal.fire({
        icon: "error",       
        title: "' . $msg . '",
        showConfirmButton: false,
        timer: 3000,
        toast: true,
        position: "top-end",
        allowOutsideClick: false,
        customClass: {
                        popup: "swal2-border-radius",
                        confirmButton: "swal2-confirm-lg",
                    },
        allowEscapeKey: false
    });
    setTimeout(() => {
        window.location.href = "upisettings";
    }, 3000);
</script>';

            }
        }
    }
}
?>
