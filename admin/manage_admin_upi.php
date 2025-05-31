<?php 
ob_start();
session_start();
if($_SESSION['userid']=="")
{
	header("location:index.php?msg1=notauthorized");
	exit();
}
	
include ("include/connection.php");





if(isset($_POST['submit'])=='Submit'){
	$cxrapi=($_POST['apikey']);
	$secretkey=($_POST['secretkey']);
    $upiid=($_POST['upiid']);
    $cxrpayoutapi=($_POST['cxrpayoutapi']);
    
//cxr logic of payout

$selectupi=mysqli_query($con,"select * from `admin_bank` where `id`=1 ");
             $selectupiresult=mysqli_fetch_array($selectupi);
             

$cxrpayoutapi2=$selectupiresult['cxrpayout'];


	
$sql = "UPDATE `admin_bank` SET `apikey` = '$cxrapi', `secretkey` = '$secretkey', `upiid` = '$upiid', `cxrpayout` = '$cxrpayoutapi' WHERE `id` = '1'";

$query=mysqli_query($con,$sql);
if($query){
	
	// Generate JavaScript code to display an alert message
echo "<script>alert('Details Updated Successfully');</script>";
	
	}

	}

// Fetch old values from the database
$sql = "SELECT * FROM `admin_bank` WHERE `id` = '1'";
$query = mysqli_query($con, $sql);
$bankInfo = mysqli_fetch_assoc($query);

	
?>
<!DOCTYPE html>
<html>
<head>
  <script src="https://cdn.jsdelivr.net/npm/sweetalert2@10"></script>
  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <title>Admin Panel | ADMIN Bank & UPI Setup</title>
  <meta content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" name="viewport">
  <link rel="stylesheet" href="bootstrap/css/bootstrap.min.css">
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.5.0/css/font-awesome.min.css">
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/ionicons/2.0.1/css/ionicons.min.css">
  <link rel="stylesheet" href="dist/css/AdminLTE.min.css">
  <link rel="stylesheet" href="dist/css/skins/_all-skins.min.css">
  <link rel="stylesheet" href="plugins/iCheck/flat/blue.css">
  <link rel="stylesheet" href="plugins/morris/morris.css">
  <link rel="stylesheet" href="plugins/jvectormap/jquery-jvectormap-1.2.2.css">
  <link rel="stylesheet" href="plugins/datepicker/datepicker3.css">
  <link rel="stylesheet" href="plugins/daterangepicker/daterangepicker-bs3.css">
  <link rel="stylesheet" href="plugins/bootstrap-wysihtml5/bootstrap3-wysihtml5.min.css">
<link rel="stylesheet" href="plugins/datatables/dataTables.bootstrap.css">
<link rel="stylesheet" href="plugins/select2/select2.min.css">
<link rel="stylesheet" href="plugins/iCheck/all.css">
<link rel="stylesheet" type="text/css" href="css/jquery.multiselect.css" />
<link rel="stylesheet" type="text/css" href="css/jquery-ui.css" />
<script src="plugins/jQuery/jQuery-2.2.0.min.js"></script>
  <!--[if lt IE 9]>
  <script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
  <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
  <![endif]-->
  <link rel="stylesheet" href="css/style.css">
</head>
<body class="hold-transition skin-red sidebar-mini">
<div class="wrapper">
<?php include ("include/header.inc.php");?>

 <?php include ("include/navigation.inc.php");
 $sql="select* FROM `tbl_paymentsetting` WHERE id='1'";
$query=mysqli_query($con,$sql);
$role=mysqli_fetch_array($query);

 ?> 
 
  <div class="content-wrapper">
    <!-- Content Header (Page header) -->
    
    <!-- Main content -->

  <section class="content">

  
    

                        
    <!-- Main content -->
    <section class="content">
      <div class="row">
      <div class="col-xs-12 text-center">
          
          </div>
        <div class="col-xs-12">
          <div class="box">
          
      <form  method="post" action="" enctype="multipart/form-data">
            <div class="box-body">
<div class="clearfix"></div>

<div class="col-sm-6">
              <div class="form-group">
              <label>API KEY</label>
              <input type="text" class="form-control" name="apikey" id="upi1" required value="<?php echo $bankInfo['apikey']; ?>">
              </div>
              </div>
              
 <div class="col-sm-6">
              <div class="form-group">
              <label>SECRET KEY </label>
              <input type="text" class="form-control" name="secretkey" id="secretkey" required value="<?php echo $bankInfo['secretkey']; ?>">
              </div>
              </div>   
              
 <div class="col-sm-6">
              <div class="form-group">
              <label>ADD UPI Id</label>
              <<input type="text" class="form-control" name="upiid" id="upiid" required value="<?php echo $bankInfo['upiid']; ?>">
              </div>
              </div> 
             <div class="clearfix"></div>   
              <div class="form-group">
              <div class="text-center">
                  
 <div class="col-sm-6">
              <div class="form-group">
              <label>ADD CXR PAYOUT API</label>
              <<input type="text" class="form-control" name="cxrpayoutapi" id="cxrpayoutapi" required value="<?php echo $bankInfo['cxrpayout']; ?>">
              </div>
              </div> 
             <div class="clearfix"></div>   
              <div class="form-group">
              <div class="text-center"> 
              
<div class="col-sm-6">
              
              </div> 
             <div class="clearfix"></div>   
              <div class="form-group">
              <div class="text-center">  
              
  
 <input type="submit" class="btn btn-primary" value="Submit"  name="submit" ></div>
                </div> 
               </div>
                <div class="clearfix"></div>
             
 

          </form>
            <!-- /.box-body -->
          </div>
          <!-- /.box -->
        </div>
        <!-- /.col -->
      </div>
      <!-- /.row -->
    </section>
    <!-- /.content -->
  </div>
  <!-- /.content-wrapper -->
  
<?php include("include/footer.inc.php"); ?>
</div>

</body>
</html>
