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
<title>Adminsuit | Manage Product Specification</title>
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
  <?php include ("include/navigation.inc.php");
 $segmentid=encryptor('decrypt', $_GET['id']);
 ?>
  <!-- Content Wrapper. Contains page content -->
  <div class="content-wrapper"> 
    <!-- Content Header (Page header) -->
    <section class="content-header">
      <h1>Manage Product Specification</h1>
      <ol class="breadcrumb">
        <li><a href="desktop.php"><i class="fa fa-dashboard"></i> Home</a></li>
        <li><a href="manage_product.php">Manage Products</a></li>
        <li class="active">Manage Product Specification</li>
      </ol>
    </section>
    
    <!-- Main content -->
    <section class="content">
      <div class="row">
        <div class="col-xs-12">
          <div class="box">
            <div class="box-header box-header2">
              <div class="col-xs-6 text-right">
                <h3 class="box-title">
                  <?php 
				if(isset($_GET['msg'])=="updt") 
				{ ?>
                  <font size="+1" color="#FF0000">Update Successfully...</font>
                  <?php  } ?>
                </h3>
              </div>
              <div class="col-sm-6">
                <div class="pull-right"> <a href="add_specification.php?testid=<?php echo encryptor('encrypt', $segmentid);?>" class="btn btn-danger">Add New</a> </div>
              </div>
            </div>
            <!-- /.box-header -->
            <div class="box-body">
              <form id="formID" name="formID" method="post" action="#" enctype="multipart/form-data">
                <!--<div class="table-responsive"> -->
                <table id="example1" class="table table-bordered table-striped">
                  <thead>
                    <tr>
                      <th>Sr.No</th>
                      <th>Title</th>
                      <th>Specification</th>
                      <th>Action</th>
                    </tr>
                  </thead>
                  <tbody>
                    <?php
  $Query=mysqli_query($con,"select * from `tbl_productfeature` where `productid`='".$segmentid."'");
  $i=0; 
  while($row=mysqli_fetch_array($Query)){$i++;?>
                    <tr>
                      <td><?php echo $i;?>.</td>
                      <td><?php echo @$row["title"]; ?></td>
                      <td><?php echo @$row["feature"]; ?></td>
                      <td><a href="edit_specification.php?id=<?php echo encryptor('encrypt', $row['id']); ?>&testid=<?php echo encryptor('encrypt', $segmentid);?>" class="text-info" data-toggle="tooltip" title="Edit"><i class="fa fa-edit"></i></a>
                      &nbsp;&nbsp;&nbsp; <a href="javascript:void(0);" onClick="delete_row(<?php echo $row['id']; ?>)" class="text-danger" data-toggle="tooltip" title="Delete"><i class="fa fa-trash"></i></a>&nbsp;&nbsp;&nbsp;
                        <?php 
	  if($row['status']==1){
	  ?>
                        <a href="javascript:void(0);" onClick="Respond(<?php echo $row['id']; ?>)" class="text-success" data-toggle="tooltip" title="Publish"><i class="fa fa-check-square-o"></i></a>
                        <?php } else if($row['status']==0){?>
                        <a href="javascript:void(0);" onClick="UnRespond(<?php echo $row['id']; ?>)" class="text-danger" data-toggle="tooltip" title="Unpublish"><i class="fa fa-square-o"></i></a>
                        <?php }?></td>
                    </tr>
                    <?php }?>
                  </tbody>
                </table>
                <!--</div>-->
                <div class="box-header box-header2" style="margin-bottom: 10px;">&nbsp; </div>
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
<!-- ./wrapper --> 
<script type="text/javascript" src="js/add_olymquestion.js"></script>

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
<script type="text/javascript">
 function delete_row(Id) {
 var strconfirm = confirm("Are You Sure You Want To Delete?");

           if (strconfirm == true) {
               $.ajax({
                   type: "Post",
                  data:"id=" + Id + "& type=" + "delete" ,
                   url: "addspecificationNow.php",
                   success: function (html) { 
                      if(html==1){
						  alert("Selected Item Deleted Sucessfully....");
                     window.location = '';
					  }
					  else if(html==0){
						  alert("Some Technical Problem");
						  
						  }
                   },
                   error: function (e) {
                   }
               });
           }

       }
</script> 
<script type="text/javascript">
 function Respond(Id) {
 var strconfirm = confirm("Are you sure you want to Unpublish?");

           if (strconfirm == true) {
               $.ajax({
                   type: "Post",
                  data:"id=" + Id + "& type=" + "chk" ,
                   url: "addspecificationNow.php",
                   success: function (html) {
                       //alert(html);
                       window.location = '';
                       return false;
                   },
                   error: function (e) {
                   }
               });
           }

       }
</script> 
<script type="text/javascript">
 function UnRespond(Id) {
           var strconfirm = confirm("Are you sure you want to Publish?");
           if (strconfirm == true) {
               $.ajax({
                   type: "Post",
                   data:"id=" + Id + "& type=" + "unchk" ,
                   url: "addspecificationNow.php",
                   success: function (html) {
                       //alert(html);
                    window.location = '';
                       return false;
                   },
                   error: function (e) {
                   }
               });
           }

       }
</script>

</body>
</html>
