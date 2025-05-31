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
    <title>Adminsuit | Result History</title>
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
	<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.6.0/jquery.min.js" type="text/javascript"></script>
	<!--<link href='//cdn.datatables.net/1.10.19/css/jquery.dataTables.min.css' rel='stylesheet' type='text/css'>-->
	<script src="//cdn.datatables.net/1.10.19/js/jquery.dataTables.min.js"></script>
	<link rel="stylesheet" href="plugins/select2/select2.min.css">
<link rel="stylesheet" href="plugins/iCheck/all.css">
    <link href="css/custom.css" rel="stylesheet" type="text/css">

	<link href='//cdn.datatables.net/1.10.19/css/jquery.dataTables.min.css' rel='stylesheet' type='text/css'>
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
            <h1>User Result History</h1>
            <ol class="breadcrumb">
                <li><a href="desktop.php"><i class="fa fa-dashboard"></i> Home</a></li>
                <li class="active">Result</li>
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
          <div class="table-responsive"> 
			<table width="98%" border="1" id='empTable' class='dataTable table table-bordered table-striped'>
				<thead>
                                    <tr>

                                        <th>User ID</th>
                                        <th>Period ID</th>
                                        <th>Select</th>
                                        <th>Amount</th>
                                       
                                        <th>Fees</th>
                                        <th>Status</th>
                                        <th>Date</th>
                                        </tr>
                </thead>
			</table>
		</article>
	</div>
	  <div class="box-header box-header2" style="margin-bottom: 10px;">&nbsp; </div>
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
	<script type="text/javascript">
		$(document).ready(function(){
			$('#empTable').DataTable({
				'processing': true,
				'serverSide': true,
				'serverMethod': 'post',
				'pageLength': 100,
				"aaSorting": [[0, "asc"]],
				"searchable": true,
				'ajax': {
					'url':'user_data.php'
				},
				'columns': [
    			
    				{ data: 'userid' },
    				{ data: 'periodid' },
    				{ data: 'value' },
    				{ data: 'amount' },
    			
    				{ data: 'fee' },
    				{ data: 'status' },
    				{ data: 'createdate' },
    			
				]
				
				
				
			});
		});
	</script>	<script src="//cdn.datatables.net/1.10.19/js/jquery.dataTables.min.js"></script>
    <?php include("include/footer.inc.php");?></div>
<!-- ./wrapper -->


<script>

    $(function () {
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


</body>
</html>
