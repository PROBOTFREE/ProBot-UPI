<?php 
ob_start();
session_start();
if($_SESSION['userid']=="")
{
	header("location:index.php");
	exit();
}
include ("include/connection.php");?>
<!DOCTYPE html>
<html>
<head>
  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <title>Adminsuit | Add Specification</title>
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
    <link rel="stylesheet" href="plugins/timepicker/bootstrap-timepicker.min.css">

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
 <?php include ("include/navigation.inc.php");	?>
<?php $testid=encryptor('decrypt', $_GET['testid']);?>
  <div class="content-wrapper">
    <section class="content-header">
    <h1>Add Specification</h1>
      <ol class="breadcrumb">
        <li><a href="manage_specification.php?id=<?php echo encryptor('encrypt', $testid);?>"><i class="fa fa-dashboard"></i> Manage Specification</a></li>
        <li class="active">Add Specification </li>
      </ol>
    </section>

    <!-- Main content -->
    <section class="content">
      <div class="row">
        <div class="col-xs-12">
          <div class="box">
            <div class="box-header2"> 
             <div class="col-xs-12"></div>
           <div class="clearfix"></div>   
            </div>
            <!-- /.box-header -->
            
      <form id="addquestionform" name="formID" method="post" action="#" enctype="multipart/form-data">
      <div class="col-sm-10 col-xs-offset-1">
            <div class="box-body">
                  <div class="clearfix"></div>
                
                  
   <input class="form-control" id="testid" name="testid" type="hidden" value="<?php echo @$testid;?>" >
   <input class="form-control" id="convertedtestid" name="convertedtestid" type="hidden" value="<?php echo encryptor('encrypt', $testid);?>">
                <div class="clearfix"></div>
                              
                <div class="col-md-12 col-sm-6 col-xs-12">
                  <div class="form-group">
                  <label for="title">Title :</label>
 <input id="title" name="title" class="form-control">
                </div>
                </div> 
            <div class="col-md-12 col-sm-6 col-xs-12">
                  <div class="form-group">
                  <label for="feature">Specification :</label>
 <input id="feature" name="feature" class="form-control" required>
              </div>
                </div> 
             <div class="clearfix"></div> 
             <input  id="editid" name="editid" type="hidden" value="" required>
              <div class="form-group">
              <div class="text-center">
 <span style="color:#f56954;"><strong></strong></span>
 <input type="submit" id="" name="Action" class="btn btn-primary" value="Submit"  ></div>
                </div> 
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
  
<?php  include("include/footer.inc.php");?></div>
<script type="text/javascript" src="js/add_specification.js"></script>

</body>
</html>
