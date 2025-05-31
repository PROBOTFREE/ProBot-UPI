<?php
// PHP code


// Define the absolute path to the functions.php file
define('ABSPATH', dirname(__FILE__) . '/'); // Adjust the path as needed

require_once(ABSPATH . 'header.php');
require_once(ABSPATH . '../pages/dbFunctions.php');
?>
<head>
    <!--favicon-->
	<link rel="icon" href="assets/images/favicon-32x32.png" type="image/png">

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

</head>

<main class="main-wrapper">
    <div class="main-content">
        <div class="page-breadcrumb d-none d-sm-flex align-items-center mb-3">
            <div class="breadcrumb-title pe-3">Recharge</div>
            <div class="ps-3">
                <nav aria-label="breadcrumb">
                    <ol class="breadcrumb mb-0 p-0">
                        <li class="breadcrumb-item"><a href="javascript:;"><i class="bx bx-home-alt"></i></a></li>
                        <li class="breadcrumb-item active" aria-current="page">Wallet Load</li>
                    </ol>
                </nav>
            </div>
            <div class="ms-auto">
                <div class="btn-group">
                    <button type="button" class="btn btn-primary">Settings</button>
                    <button type="button" class="btn btn-primary split-bg-primary dropdown-toggle dropdown-toggle-split" data-bs-toggle="dropdown"><span class="visually-hidden">Toggle Dropdown</span></button>
                    <div class="dropdown-menu dropdown-menu-right dropdown-menu-lg-end">
                        <a class="dropdown-item" href="javascript:;">Action</a>
                        <div class="dropdown-divider"></div>
                        <a class="dropdown-item" href="javascript:;">Separated link</a>
                    </div>
                </div>
            </div>
        </div>

        <div class="row">
            <div class="card">
                <div class="card-body p-4">
                    <h5 class="mb-4">Upi Payments 1</h5>
                    <form action="cxrpay/pay" method="POST" onsubmit="return validateForm()">
                    <div class="row mb-3">
                        <label for="input50" class="col-sm-3 col-form-label">Amount</label>
                        <div class="col-sm-9">
                            <div class="input-group">
                                <span class="input-group-text"><i class="material-symbols-rounded fs-5">smartphone</i></span>
                                <input type="text" class="form-control" id="input50"  placeholder="Amount" name="amount" min="100" required>
                            </div>
                        </div>
                    </div>
                    <div class="row mb-3">
                        <label for="input51" class="col-sm-3 col-form-label">Current Time</label>
                        <div class="col-sm-9">
                            <div class="input-group">
                                <span class="input-group-text"><i class="material-symbols-rounded fs-5">send</i></span>
                                <input type="text" class="form-control" id="input51" placeholder="currenttime" readonly>
                            </div>
                        </div>
                    </div>
                    <div class="row">
                        <label class="col-sm-3 col-form-label"></label>
                        <div class="col-sm-9">
                            <div class="d-md-flex d-grid align-items-center gap-3">
                                <button type="submit" class="btn btn-primary px-4">Submit</button>
                                <button type="reset" class="btn btn-dark px-4">Reset</button>
                            </div>
                        </div>
                    </div>
                    </form>
                </div>
            </div>
        </div><!--end row-->
        <div class="row">
            <div class="card">
                <div class="card-body p-4">
                    <h5 class="mb-4">Upi Payments 2</h5>
                    <form action="cxrpay/pay" method="POST" onsubmit="return validateForm()">
                    <div class="row mb-3">
                        <label for="input50" class="col-sm-3 col-form-label">Amount</label>
                        <div class="col-sm-9">
                            <div class="input-group">
                                <span class="input-group-text"><i class="material-symbols-rounded fs-5">smartphone</i></span>
                                <input type="text" class="form-control" id="input50"  placeholder="Amount" name="amount" min="100" required>
                            </div>
                        </div>
                    </div>
                   <div class="row mb-3">
    <label for="input51" class="col-sm-3 col-form-label">Current Time</label>
    <div class="col-sm-9">
        <div class="input-group">
            <span class="input-group-text"><i class="material-symbols-rounded fs-5">send</i></span>
            <input type="text" class="form-control" id="input52" placeholder="currenttime" readonly>
        </div>
    </div>
</div>

                    <div class="row">
                        <label class="col-sm-3 col-form-label"></label>
                        <div class="col-sm-9">
                            <div class="d-md-flex d-grid align-items-center gap-3">
                                <button type="submit" class="btn btn-primary px-4">Submit</button>
                                <button type="reset" class="btn btn-dark px-4">Reset</button>
                            </div>
                        </div>
                    </div>
                    </form>
                </div>
            </div>
        </div><!--end row-->
    </div>
</main>
<script>
    function updateTime() {
        var now = new Date();
        var hour = now.getHours();
        var ampm = hour >= 12 ? 'PM' : 'AM';
        hour = hour % 12;
        hour = hour ? hour : 12; // handle midnight (0 hours)
        var formattedTime = padZero(hour) + ':' + padZero(now.getMinutes()) + ':' + padZero(now.getSeconds()) + ' ' + ampm;
        document.getElementById('input51').value = formattedTime;
        document.getElementById('input52').value = formattedTime; // Update the second input field
    }

    function padZero(num) {
        return (num < 10 ? '0' : '') + num;
    }

    updateTime(); // Call the function initially to display the current time
    setInterval(updateTime, 1000); // Update the time every second
</script>
<script>
    function validateForm() {
        var amount = document.getElementById("input50").value;
        if (amount < 100) {
            alert("Amount must be at least 100");
            return false; // Prevent form submission
        }
        return true; // Allow form submission
    }
</script>

  <!--plugins-->
  <script src="assets/js/jquery.min.js"></script>
  <!--plugins-->
  <script src="assets/plugins/perfect-scrollbar/js/perfect-scrollbar.js"></script>
  <script src="assets/plugins/metismenu/metisMenu.min.js"></script>
  <script src="assets/plugins/datatable/js/jquery.dataTables.min.js"></script>
	<script src="assets/plugins/datatable/js/dataTables.bootstrap5.min.js"></script>
	
  <script src="assets/plugins/simplebar/js/simplebar.min.js"></script>
  <script src="assets/js/main.js"></script>


</body>

</html>