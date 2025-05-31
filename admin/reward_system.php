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
	$userid=($_POST['userid']);
	$reward=($_POST['reward']);
$sql= "INSERT INTO `tbl_reward`(`userid`,`amount`) VALUES ('".$userid."','".$reward."')";
$query=mysqli_query($con,$sql);
$sqlorder= mysqli_query($con,"INSERT INTO `tbl_order`(`userid`,`transactionid`,`amount`,`status`) VALUES ('".$userid."','reward','".$reward."','1')");
@$orderid=mysqli_insert_id($con);

$today = date("Y-m-d H:i:s");
$sql3= mysqli_query($con,"INSERT INTO `tbl_walletsummery`(`userid`,`orderid`,`amount`,`type`,`actiontype`,`createdate`) VALUES ('".$userid."','".$orderid."','".$reward."','credit','reward','".$today."')");


$walletAvailablebalance=wallet($con,'amount',$userid);	
$finalbalanceCredit=$walletAvailablebalance+$reward;	
$sqlwallet= mysqli_query($con,"UPDATE `tbl_wallet` SET `amount` = '$finalbalanceCredit' WHERE `userid`= '$userid'");
if($query){
	
	header("location:reward_system.php?msg=updt");
	
	}

	}
?>
<!DOCTYPE html>
<html>
<head>
  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <title>Adminsuit | Reward System</title>
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
 <?php include ("include/navigation.inc.php");?> 
  <div class="content-wrapper">
    <section class="content-header">
      <h1>Reward System</h1>
      <ol class="breadcrumb">
        <li><a href="desktop.php"><i class="fa fa-dashboard"></i>Home</a></li>
        <li class="active">Reward System</li>
      </ol>
    </section>

                        
    <!-- Main content -->
    <section class="content">
      <div class="row">
      <div class="col-xs-12 text-center">
          
          <?php if(isset($_GET['msg'])=="updt"){ ?>
              <span class="text-center red_txt">Update Successfully......</span><?php  } ?></div>
        <div class="col-xs-12">
          <div class="box">
          
      <form id="formID" name="formID" method="post" action="<?php echo $_SERVER['PHP_SELF'];?>" enctype="multipart/form-data">
            <div class="box-body">
<div class="clearfix"></div>

<div class="col-sm-6">
              <div class="form-group">
              <label>Select User <i class="red_txt">*</i></label>
              <select class="select2 form-control" name="userid" id="userid" required>
              <option selected value="">Select Mobile No.</option>
              <?php
              $user=mysqli_query($con,"select * from `tbl_user` where `status`='1'");
			  while($userResult=mysqli_fetch_array($user)){
			  ?>
              <option value="<?php echo $userResult['id'];?>"><?php echo $userResult['mobile'];?></option>
              <?php }?>
              </select>
              </div>
              </div>
  <div class="col-sm-6">
              <div class="form-group">
              <label>Reward Amount</label>
              <input type="text" class="form-control" onkeypress="return isNumber(event)" name="reward" id="reward" required>
              </div>
              </div>          
                
             <div class="clearfix"></div>   
              <div class="form-group">
              <div class="text-center">
  
 <input type="submit" class="btn btn-primary" value="Submit"  name="submit" ></div>
                </div> 
               </div>
                <div class="clearfix"></div>
             
 

          </form>
          <div class="row">
      <div class="col-xs-12">
          
          <div id="rewardlist"></div>
          
          </div></div>
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
  
<?php include("include/footer.inc.php"); ?></div>
<script type="text/javascript">
$(document).ready(function () {
$("#userid").change(function()
{ 
var id=$(this).val(); 
var dataString = 'id='+ id;
//alert(dataString);
$.ajax
({
type: "POST",
url: "ajax_rewardlist.php",
data: dataString,
cache: false,
success: function(html)
{
$("#rewardlist").html(html);
} 
});
});
});
</script>

</body>
</html>
