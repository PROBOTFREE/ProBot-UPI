<?php 
ob_start();
session_start();
if($_SESSION['userid']=="")
{
	header("location:index.php?msg1=notauthorized");
	exit();
}
	?>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<title>Adminsuit | Manage Winner Settings</title>
<!-- Tell the browser to be responsive to screen width -->
<meta content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" name="viewport">
<!-- Bootstrap 3.3.6 -->
<link rel="stylesheet" href="bootstrap/css/bootstrap.min.css">
<!-- Font Awesome -->
<link rel="stylesheet" href="css/font-awesome.min.css">
<!-- Ionicons -->
<link rel="stylesheet" href="css/ionicons.min.css">
<!-- Theme style -->
<link rel="stylesheet" href="dist/css/AdminLTE.min.css">
<!-- AdminLTE Skins. Choose a skin from the css/skins
       folder instead of downloading all of them to reduce the load. -->
<link rel="stylesheet" href="dist/css/skins/_all-skins.min.css">
<!-- iCheck -->
<link rel="stylesheet" href="plugins/iCheck/flat/blue.css">
<!-- Morris chart -->
<link rel="stylesheet" href="plugins/morris/morris.css">
<!-- jvectormap -->
<link rel="stylesheet" href="plugins/jvectormap/jquery-jvectormap-1.2.2.css">
<!-- Date Picker -->
<link rel="stylesheet" href="plugins/datepicker/datepicker3.css">
<!-- Daterange picker -->
<link rel="stylesheet" href="plugins/daterangepicker/daterangepicker-bs3.css">
<!-- bootstrap wysihtml5 - text editor -->
<link rel="stylesheet" href="plugins/bootstrap-wysihtml5/bootstrap3-wysihtml5.min.css">
<link rel="stylesheet" href="plugins/datatables/dataTables.bootstrap.css">
<link rel="stylesheet" href="plugins/select2/select2.min.css">
<link rel="stylesheet" href="plugins/iCheck/all.css">
<link href="css/custom.css" rel="stylesheet" type="text/css">

<!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
<!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
<!--[if lt IE 9]>
  <script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
  <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
  <![endif]-->
<link rel="stylesheet" href="css/app.css" id="maincss">
<link rel="stylesheet" href="css/style.css" id="maincss">
<style>
#overlay {
  position:absolute;
  display: none;
  width: 70%;
  height: 70px;
  top: 0;
  left: 0;
  right: 0;
  bottom: 0;
  background-color: rgba(0,0,0,0.5);
  z-index: 9;
  cursor: pointer;
}
</style>
</head>
<body class="hold-transition skin-red sidebar-mini">
<div class="wrapper">
  <?php include ("include/connection.php");?>
  <?php include ("include/header.inc.php");?>
  <!-- Left side column. contains the logo and sidebar -->
  <?php include ("include/navigation.inc.php");?>
  <!-- Content Wrapper. Contains page content -->
  <div class="content-wrapper"> 
    <!-- Content Header (Page header) -->
    <section class="content-header">
      <h1>Manage Winner Setting</h1>
      <ol class="breadcrumb">
        <li><a href="desktop.php"><i class="fa fa-dashboard"></i> Home</a></li>
        <li class="active">Manage Winner Setting</li>
      </ol>
    </section>
    
    <!-- Main content -->
    <section class="content">
      <div class="row">
        <div class="col-xs-12">
          <div class="box">
            
            <!-- /.box-header -->
            <div class="box-body">
              <form id="formID" name="formID" method="post" action="#" enctype="multipart/form-data">
                <!--<div class="table-responsive"> -->
             
              <?php 
 $chkswitchQuery=mysqli_query($con,"select * from `tbl_gamesettings` where `id`='1'");
 $role=mysqli_fetch_array($chkswitchQuery);
 ?>
              
              <div class="col-xs-12 text-center">
                <div class="main-input pad">
                    <label>Which mode do you want to run ?</label>
                    <div class="mt-0">
                <div class="btn-group btn-group-toggle" data-toggle="buttons">
          <label class="btn btn-secondary <?php if($role['settingtype']=='high'){echo"active";} ?>">
          <input class="switchbutton" type="radio" name="switch" id="switchyes" value="high" <?php if($role['settingtype']=='high'){echo"checked";} ?>> High Profit Mode</label>
           <label class="btn btn-secondary <?php if($role['settingtype']=='low'){echo"active";} ?>">
          <input type="radio" class="switchbutton" name="switch" id="switchno" value="low" <?php if($role['settingtype']=='low'){echo"checked";} ?>> Low Profit Mode</label>
                      </div>
                    </div>
                    <p>&nbsp;</p>
                  <label>[ <span class="red_txt">Note:-</span> On low profit mode manual result option may <span class="red_txt">intrupted</span>, please do action accordingly. ]</label>
                  </div>
              </div>
           
                <!--</div>-->
               
                <div class="row">
                  <div class="col-sm-10"></div>
                  <div class="col-sm-2"> &nbsp; </div>
                </div>
              </form>
            </div>
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
  
  <?php include("include/footer.inc.php");?>
</div>
<script>
$(".switchbutton").change(function(){ //alert($(this).val());
var value=$(this).val();
$.ajax({
   type: "Post",
    data:"value=" + value + "& type=" + "switchhilow" ,
    url: "activePeriodid.php",
    success: function (html){},
});
});
</script>

</body>
</html>
