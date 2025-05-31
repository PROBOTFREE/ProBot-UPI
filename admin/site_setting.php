<?php 
ob_start();
session_start();
if($_SESSION['userid']=="")
{
	header("location:index.php");
	exit();
}

include ("include/connection.php");

if(isset($_POST['submit'])=='Save'){
	$address=mysqli_real_escape_string($con,$_POST['address']);;
	$email=mysqli_real_escape_string($con,$_POST['email']);;
	$mobile=mysqli_real_escape_string($con,$_POST['mobile']);;

	$content1=mysqli_real_escape_string($con,$_POST['content1']);
	$content2=mysqli_real_escape_string($con,$_POST['content2']);
	$content3=mysqli_real_escape_string($con,$_POST['content3']);
	$content4=mysqli_real_escape_string($con,$_POST['content4']);
	
	$content5=mysqli_real_escape_string($con,$_POST['content5']);
	$content6=mysqli_real_escape_string($con,$_POST['content6']);
	$content7=mysqli_real_escape_string($con,$_POST['content7']);
	$content8=mysqli_real_escape_string($con,$_POST['content8']);
	$content9=mysqli_real_escape_string($con,$_POST['content9']);
	
$sql= "UPDATE `site_setting` SET `address` = '".$address."',`email` = '".$email."',`mobile` = '".$mobile."',`fblink` = '".$content1."',`twlink` = '".$content2."',`ln`='".$content3."',`insta`='".$content4."',`fbcount`='".$content5."',`twcount`='".$content6."',`youtubecount`='".$content7."',`instacount`='".$content8."' WHERE `id`= '1'";
$query=mysqli_query($con,$sql);
if($query){
	
	header("location:site_setting.php?msg=updt");
	
	}
	}
?>
<!DOCTYPE html>
<html>
<head>
  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <title>Adminsuit | Site Setting</title>
  <meta content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" name="viewport">
  <link rel="stylesheet" href="bootstrap/css/bootstrap.min.css">
  <link rel="stylesheet" href="css/font-awesome.min.css">
  <link rel="stylesheet" href="css/ionicons.min.css">
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
  <!--[if lt IE 9]>
  <script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
  <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
  <![endif]-->
  <link rel="stylesheet" href="css/style.css">
  <link rel="stylesheet" href="css/app.css" id="maincss">

</head>
<body class="hold-transition skin-red sidebar-mini">
<div class="wrapper">
<?php include ("include/header.inc.php");?>
 <?php include ("include/navigation.inc.php");
 $sql="SELECT * FROM `site_setting` where `id`='1'";
$query=mysqli_query($con,$sql);
$role=mysqli_fetch_array($query);

 ?>
   
  <div class="content-wrapper">
    <section class="content-header">
      <h1> Site Setting</h1>
      <ol class="breadcrumb">
        <li><a href="desktop.php"><i class="fa fa-dashboard"></i> Home</a></li>
        <li class="active"> Site Setting</li>
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
            
            <!-- /.box-header -->
            
      <form  method="post" action="<?php echo $_SERVER['PHP_SELF'];?>" id="taskform">
            <div class="box-body">
           
                <div class="clearfix"></div>
                <div class="col-md-6 col-sm-6 col-xs-12">
                  <div class="form-group">
                  <label for="address"> Address</label>
         <input class="form-control" id="address" name="address" type="text" value="<?php echo @$role['address']; ?>">
                </div>
                </div>
                
              <div class="col-md-6 col-sm-6 col-xs-12">
                  <div class="form-group">
                  <label for="email"> Email</label>
         <input class="form-control" id="email" name="email" type="text" value="<?php echo @$role['email']; ?>">
                </div>
                </div>
                <div class="col-md-6 col-sm-6 col-xs-12">
                  <div class="form-group">
                  <label for="mobile"> Mobile</label>
         <input class="form-control" id="mobile" name="mobile" type="text" value="<?php echo @$role['mobile']; ?>" maxlength="15">
                </div>
                </div>
                
                <div class="col-md-6 col-sm-6 col-xs-12">
                  <div class="form-group">
                  <label for="content1">Facebook Link</label>
         <input class="form-control" id="content1" name="content1" type="text" value="<?php echo @$role['fblink']; ?>">
                </div>
                </div>
                <div class="col-md-6 col-sm-6 col-xs-12">
                  <div class="form-group">
                  <label for="content2">Twitter Link</label>
         <input class="form-control" id="content2" name="content2" type="text" value="<?php echo @$role['twlink']; ?>">
                </div>
                </div>
                <div class="col-md-6 col-sm-6 col-xs-12">
                  <div class="form-group">
                  <label for="content3">Linkedin Link</label>
         <input class="form-control" id="content3" name="content3" type="text" value="<?php echo @$role['ln']; ?>">
                </div>
                </div>
                
                <div class="col-md-6 col-sm-6 col-xs-12">
                  <div class="form-group">
                  <label for="content4">Instagram Link</label>
         <input class="form-control" id="content4" name="content4" type="text" value="<?php echo @$role['insta']; ?>">
                </div>
                </div>
                
                <div class="col-md-6 col-sm-6 col-xs-12">
                  <div class="form-group">
                  <label for="content5">Facebook Count</label>
         <input class="form-control" id="content5" name="content5" type="text" value="<?php echo @$role['fbcount']; ?>">
                </div>
                </div>
                <div class="col-md-6 col-sm-6 col-xs-12">
                  <div class="form-group">
                  <label for="content6">Twitter Count</label>
         <input class="form-control" id="content6" name="content6" type="text" value="<?php echo @$role['twcount']; ?>">
                </div>
                </div>
                <div class="col-md-6 col-sm-6 col-xs-12">
                  <div class="form-group">
                  <label for="content7">Youtube Count</label>
         <input class="form-control" id="content7" name="content7" type="text" value="<?php echo @$role['youtubecount']; ?>">
                </div>
                </div>
                <div class="col-md-6 col-sm-6 col-xs-12">
                  <div class="form-group">
                  <label for="content8">Instagram Count</label>
         <input class="form-control" id="content8" name="content8" type="text" value="<?php echo @$role['instacount']; ?>">
                </div>
                </div>
          <div class="clearfix"></div>      
  
            <input name="id" value="<?php echo @$id?>" type="hidden">
<div class="clearfix"></div>
              
                
                <div class="clearfix"></div>
            
             <div class="clearfix"></div> 
             <div class="col-md-12 col-sm-6 col-xs-12">  
              <div class="form-group">
              <div class="text-center">
 
 <input type="submit" name="submit" class="btn btn-primary" value="Save" ></div>
                </div> </div>
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
  
<?php  include("include/footer.inc.php");?></div>
<script>
 
	
$('input[type="checkbox"].minimal, input[type="radio"].minimal').iCheck({
      checkboxClass: 'icheckbox_minimal-blue',
      radioClass: 'iradio_minimal-blue'
    });
  $(function () {
	  $(".checkbox-toggle").click(function () { 
      var clicks = $(this).data('clicks');
      if (clicks) {
        //Uncheck all checkboxes
        $("input[type='checkbox']").iCheck("uncheck");
        $(".fa", this).removeClass("fa-check-square-o").addClass('fa-square-o');
      } else {
        //Check all checkboxes
        $("input[type='checkbox']").iCheck("check");
        $(".fa", this).removeClass("fa-square-o").addClass('fa-check-square-o');
      }
      $(this).data("clicks", !clicks);
    });
    //$("#example1").DataTable();
    $('#example1').DataTable({
      "paging": true,
      "lengthChange": false,
      "searching": true,
      "ordering": false,
      "info": true,
      "autoWidth": true
    });
  });
</script>
<script type="text/javascript">
 function cancel() {
 var strconfirm = confirm("Are you sure you want to cancel ?");
           if (strconfirm == true) {
           window.location = 'manage_quotation.php'; 
           }

       }
	 
</script> 

<!--sucess modal-->


</body>
</html>
