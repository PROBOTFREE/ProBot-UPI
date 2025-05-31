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
  <title>Adminsuit | Manage AdminUser</title>
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
      <h1>Red Envelope</h1>
      <ol class="breadcrumb">
        <li><a href="desktop.php"><i class="fa fa-dashboard"></i> Home</a></li>
        <li class="active">Red Envelope</li>
      </ol>
    </section>

    <!-- Main content -->
    <section class="content">
      <div class="row">
        <div class="col-xs-12">
          

          <div class="box">
            <div class="box-header box-header2">
             <div class="col-sm-10">
         <h3 class="box-title"><?php 
        if(isset($_GET['msg'])=="updt") 
        { ?>
                <font size="+1" color="#FF0000">Update Successfully...</font>
                <?php  } ?></h3>
         </div>
              <div class="col-sm-2">
              <div class="pull-right-btn">
       <a href="add_red_envelope.php" class="btn btn-block btn-danger">Add New</a>
       </div>
       </div>
            </div>
            <!-- /.box-header -->
            <?php
				                if(isset($_GET['delete']))
				                { ?>
				                  <div class="container">
				                <div class='alert alert-success'>
				                  <button class='close' data-dismiss='alert'>&times;</button>
				                  <strong>Deleted SUCCESSFULLY</strong> 
				                </div>
				              </div>
				                <?php
				                }
				                ?>

            <div class="box-body">
            <form id="formID" name="formID" method="post" action="#" enctype="multipart/form-data">
              <table id="example1" class="table table-bordered table-striped">
                <thead>
                  <tr>
                    <th>SR #</th>
                    <th>Amount</th>
                    <th>Limit</th>
                    <th>Reg Date</th>
                    <th>Expiry Date</th>
                    <th>Action</th>
                </tr>
                </thead>
                <tbody>
     <?php
  $Query=mysqli_query($con,"select * from `tbl_envelope` order by id desc");
  $i=0; 
  while($row=mysqli_fetch_array($Query)){$i++;
   ?>   
                <tr>
                  <td><?php echo $i;?>.</td>
                  <td><?php echo @$row["amount"]; ?>₹</td>
                  <td><?php echo @$row["limits"]; ?></td>
                  <td><?php echo @$row["reg_date"]; ?></td>
                  <td><?php echo @$row["ex_date"]; ?></td>
                   <td><a href="delete_redenvelope.php"  class="update-person" style="color:#f56954; font-size:16px; margin-right: 10px" title="Delete"><i class="fa fa-trash"></i></a> 
                    <a href="../red-envelope.php?id=<?php echo $row['id']; ?>" target="_blank" class="update-person" style="color:green; font-size:16px;" title=""><i class="fa fa-link"></i></a></td>

               
                 
   
     
                </tr>
        <?php }?>

               
                </tbody>
                
              </table>
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
  
<?php include("include/footer.inc.php");?></div>
<!-- ./wrapper -->
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
 function delete_row(Id) {
 var strconfirm = confirm("Are You Sure You Want To Delete?");

           if (strconfirm == true) {
               $.ajax({
                   type: "Post",
                  data:"id=" + Id + "& type=" + "delete" ,
                   url: "manage_adminuserAction.php",
                   success: function (html) { 
                      if(html==1){
              alert("Selected Item Deleted Sucessfully....");
                     window.location = 'red_envelope.php';
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
     
function resetpassword(Id) {
 var strconfirm = confirm("Are You Sure You Want To Reset Password?");

           if (strconfirm == true) {
        $('#password').modal('show');
    document.getElementById('puserid').value = Id; 

           }

       }
     
     
     
</script>
<script type="text/javascript">
 function Respond(Id) {
 var strconfirm = confirm("Are you sure you want to Inactive?");

           if (strconfirm == true) {
               $.ajax({
                   type: "Post",
                  data:"id=" + Id + "& type=" + "chk" ,
                   url: "manage_adminuserAction.php",
                   success: function (html) {
                       //alert(html);
                       window.location = 'manage_adminuser.php';
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
           var strconfirm = confirm("Are you sure you want to Active?");
           if (strconfirm == true) {
               $.ajax({
                   type: "Post",
                   data:"id=" + Id + "& type=" + "unchk" ,
                   url: "manage_adminuserAction.php",
                   success: function (html) {
                       //alert(html);
                    window.location = 'manage_adminuser.php';
                       return false;
                   },
                   error: function (e) {
                   }
               });
           }

       }
</script>
<script src="js/resetpassword.js"></script>
<div id="password" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true" class="modal fade">
  <div class="modal-dialog modal-sm">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" data-dismiss="modal" aria-label="Close" class="close" onclick="window.location='';"> <span aria-hidden="true">&times;</span> </button>
        <h4 id="myModalLabel" class="modal-title">Reset Password </h4>
        <span class="parsley-errors-list filled" id="resetresponse"></span>
      </div>
      <div class="modal-body">
        <form class="form-horizontal clearfix resetpassword" action="#" data-parsley-validate="" novalidate="" id="resetpassword" method="post">
          <div class="col-lg-12" >
           
            
            <label class="control-label" >New Password</label>
            <input class="form-control" type="password" id="nnewpassword" name="nnewpassword" required>
            <label class="control-label" >Confirm New Password</label>
 <input class="form-control" type="password" id="ccpassword" name="ccpassword" required>
       <span class="parsley-errors-list filled" id="matchresponse"></span>     
    <input class="form-control" type="hidden" id="puserid" name="puserid" value="">
            <br />
            
            <div class="form-group">
              <div class="col-lg-offset-2 col-lg-8 text-center">
                <button type="button" class="btn btn-default" onclick="window.location='';">Cancel</button>
                <button type="submit" class="mb-sm btn btn-primary">Submit</button>
              </div>
            </div>
          </div>
        </form>
      </div>
      <!--<div class="modal-footer">
        <button type="button" data-dismiss="modal" class="btn btn-default">Close</button>
      </div>-->
    </div>
  </div>
</div>
</body>
</html>
