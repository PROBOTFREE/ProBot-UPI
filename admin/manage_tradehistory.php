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
  <title>Adminsuit | User Trade History</title>
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
      <h1>User Trade History</h1>
      <ol class="breadcrumb">
        <li><a href="desktop.php"><i class="fa fa-dashboard"></i> Home</a></li>
        <li class="active">User Trade History</li>
      </ol>
    </section>

    <!-- Main content -->
    <section class="content">
      <div class="row">
        <div class="col-xs-12">
          

          <div class="box">
            <div class="box-header box-header2">
            <div class="col-xs-6 text-right">
         <h3 class="box-title"><?php 
				if(isset($_GET['msg'])=="updt") 
				{ ?>
                <font size="+1" color="#FF0000">Update Successfully...</font>
                <?php  } ?></h3>
         </div>
              <div class="col-sm-6">
              <div class="pull-right">&nbsp;</div>
       </div>
      
            </div>
            <!-- /.box-header -->
            <div class="box-body">
  <form id="formID" name="formID" method="post" action="#" enctype="multipart/form-data">
          <!--<div class="table-responsive"> -->
          <div class="margin-bottom">&nbsp;</div>
              <div class="col-sm-4">
              <div class="form-group">
              <label>Filter By User <i class="red_txt">*</i></label>
              <select class="select2 form-control" name="userid" id="userid">
              <option selected value="all">Select All</option>
              <?php
              $user=mysqli_query($con,"select * from `tbl_user` where `status`='1'");
			  while($userResult=mysqli_fetch_array($user)){
			  ?>
              <option value="<?php echo $userResult['id'];?>"><?php echo $userResult['mobile'];?>&nbsp;<small>[<?php echo $userResult['code'];?>]</small></option>
              <?php }?>
              </select>
              </div>
              </div>
              <div class="col-sm-4">
              <div class="form-group">
              <label>Filter By Game Space <i class="red_txt">*</i></label>
              <select class="select2 form-control" name="tabtype" id="tabtype">
              <option selected value="all">Select All</option>
              <option value="parity">Parity</option>
              <option value="sapre">Sapre</option>
              <option value="bcone">Bcone</option>
              <option value="emerd">Emerd</option>
              </select>
              </div>
              </div>
              <div class="col-sm-4">
              <div class="form-group">
              <label>Filter By PeriodId</label>
              <input type="text" class="form-control" onkeypress="return isNumber(event)" name="periodid" id="periodid">
              </div>
              </div>
 <div class="col-sm-12"><h3 class="text-center text-capitalize text-maroon">Filter By Date</h3></div>
              <div class="col-sm-6">
              <div class="form-group">
              <label>Start Date <i class="red_txt">*</i></label>
              <input type="text" class="form-control datepicker" id="startdate" name="startdate" onkeypress="return isNumber(event)" required>
              </div>
              </div>
              <div class="col-sm-6">
              <div class="form-group">
              <label>End Date <i class="red_txt">*</i></label>
              <input type="text" class="form-control datepicker" id="enddate" name="enddate" onkeypress="return isNumber(event)" required>
              </div>
              </div>
              <input class="form-control" id="type" name="type"  type="hidden"  value="chk">
              <div class="col-md-12 col-sm-6 col-xs-12 margin-bottom">
                    <div class="form-group text-center">
        <input type="submit" id="" name="Action" class="btn btn-danger" value="Download Excel">
                    </div>
                  </div>
              <!--</div>-->
<div class="row">              
<div class="col-sm-10"></div>
              <div class="col-sm-2">
               &nbsp;
            </div>
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
  
<?php include("include/footer.inc.php");?></div>
<!-- ./wrapper -->
<script src="js/tradehistory_excel.js"></script> 
 <script>
 $('.datepicker').datepicker({
    format: 'dd-mm-yyyy',
    autoclose:true
});
 </script>
<script>

  $(function () {
    $('#example1').DataTable({
      "paging": true,
      "lengthChange": false,
      "searching": true,
      "ordering": false,
      "info": true,
      "autoWidth": true,
	  "pageLength": 100
    });
  });
</script>

</body>
</html>
