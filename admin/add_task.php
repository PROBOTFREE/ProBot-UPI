<?php 
ob_start();
session_start();
if($_SESSION['userid']=="")
{
	header("location:index.php?msg1=notauthorized");
	exit();
}
if(isset($_POST['Action'])){
	include ("include/connection.php");
	$role=$_POST['role'];
	$check=$strDelIds = implode(",",$_POST['check']);
	$default_status=1;
	$time=date( 'M jS, Y / H:i A' );


if($_POST['Action']=="Add"){
   $sql= "INSERT INTO `task`(`role_id`,`task`,`status`) VALUES ('". $role ."','". $check ."','".$default_status."')";
 
 $query=mysqli_query($con,$sql);

if($query){
	header("location:add_task.php?msg=ins");
	}exit();

}

if(isset($_POST['Action'])=='Edit'){
@$id=$_POST['id'];
 $sql2= "UPDATE `task` SET `role_id`='".$role."',`task`='".$check."' WHERE `id`='$id'";
	
$query2=mysqli_query($con,$sql2);

if($query2){
	
	header("location:manage_task.php?msg=updt");
	
	}exit();
	
	
}
}	
	?>
<!DOCTYPE html>
<html>
<head>
  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <title>Adminsuit | <?php if(@$_GET['id']!=''){echo "Edit";}else{echo "Add";} ?> Task</title>
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
<?php include ("include/connection.php");?>
<?php include ("include/header.inc.php");?>
 <?php include ("include/navigation.inc.php");?>
   
  <?php 
  if(@$id=encryptor('decrypt', $_GET['id'])){
$sql="SELECT * FROM `task` where id=$id";
$query=mysqli_query($con,$sql);
$role=mysqli_fetch_array($query);
  }
	?>

  <div class="content-wrapper">
    <section class="content-header">
      <h1><?php if(@$_GET['id']!=''){echo "Edit";}else{echo "Add";} ?> Task</h1>
      <ol class="breadcrumb">
        <li><a href="manage_task.php"><i class="fa fa-dashboard"></i> Manage Task</a></li>
        <li class="active"><?php if(@$_GET['id']!=''){echo "Edit";}else{echo "Add";} ?> Task</li>
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
				if((@$_GET['msg'])=="ins") 
				{ ?>
              <font size="+2" color="#FF0000">Update Successfully......</font>
              <?php  } ?></h3></div>
              
            </div>
            <!-- /.box-header -->
            
      <form  method="post" action="<?php echo $_SERVER['PHP_SELF'];?>" id="taskform">
            <div class="box-body">
           <div class="col-md-5 col-sm-6 col-xs-12">
                  <div class="form-group">
                  <label for="role">Select Role <span>*</span></label>
<select class="form-control" id="role" name="role" required>
           <option value="" selected>Select Role</option>
               <?php 
$sql_role="SELECT SQL_NO_CACHE * FROM `role` where `status`='1'";
  $result_role=mysqli_query($con,$sql_role)or die(mysql_error());
  $num=mysqli_num_rows($result_role);
  while($row_role=mysqli_fetch_array($result_role))
  {
  ?><option <?php if(@$role['role_id']==$row_role['id']) {echo "selected='selected'";} ?> value="<?php echo $row_role['id']?>" >
    <?php echo $row_role['role']?>
  </option>
  <?php
  }	  
  ?> </select>
  <input name="id" value="<?php echo @$id?>" type="hidden">
                   
                  
                </div>
                </div>
                <div class="clearfix"></div>
                     <div class="col-md-5 col-sm-6 col-xs-12">
                  <div class="form-group">
                  <?php 
   	$wsql="SELECT * FROM `services` where `status`='1'";
$wquery=mysqli_query($con,$wsql);
while($wrow=mysqli_fetch_array($wquery)){
			?>     
<div class="checkbox c-checkbox">
  <label>
 <input type="checkbox" <?php $sqlvalue=@$role['task'];
	$HiddenProducts = explode(',',$sqlvalue);
if (in_array($wrow['id'], $HiddenProducts)==$wrow['id']) {
  echo "checked='checked'";
} ?> name="check[]" value="<?php echo $wrow['id'];?>">
<span class="fa fa-check"></span>
 </label>&nbsp;<strong><?php echo $wrow['services'];?></strong>
                              </div>  

<?php }?>

</div></div>     
            


             <div class="clearfix"></div>   
              <div class="form-group">
              <div class="text-center">
  <button type="reset" class="btn btn-default" onClick="location.href='manage_task.php'">Cancel</button>
 <input type="submit" name="Action" class="btn btn-primary" value="<?php if(@$id != ''){echo 'Edit';}else{echo 'Add';}?>" ></div>
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
  <div style="display:none;">
          <button type="button" data-notify="" data-message="Data Saved Sucessfully.." data-options="{&quot;status&quot;:&quot;info&quot;}" class="btn btn-info" id="success"></button>
          <button type="button" data-notify="" data-message="Society Code Allready Exist..." data-options="{&quot;status&quot;:&quot;warning&quot;}" class="btn btn-warning" id="exist"></button>
          <button type="button" data-notify="" data-message="Email Id Exist !" data-options="{&quot;status&quot;:&quot;info&quot;}" class="btn btn-info" id="adminemail"></button>
          <button type="button" data-notify="" data-message="Some Technical Error.." data-options="{&quot;status&quot;:&quot;danger&quot;}" class="btn btn-danger" id="error">Danger</button>
   <button type="button" data-notify="" data-message="Please Check Assigned To And Status Combination...." data-options="{&quot;status&quot;:&quot;danger&quot;}" class="btn btn-danger" id="check">Danger</button>       
        </div>
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
<script src="js/add_particular.js"></script> 

<script src="js/add_quotation.js"></script> 

<!--sucess modal-->
<div id="quotesucess" class="modal modal-info fade" role="dialog">

  <div class="modal-dialog">
            <div class="modal-content">
              <div class="modal-header">
    <button type="button" class="close" data-dismiss="modal" aria-label="Close" onClick="quoteloadwindow();">
                  <span aria-hidden="true">&times;</span></button>
                <h4 class="modal-title">Add Item</h4>
               
              </div>
              <div class="modal-body">
               
                Quotation Added Sucessfully.......
               
              </div>
              <div class="modal-footer">
                <button type="button" class="btn btn-outline pull-left" data-dismiss="modal" onClick="quoteloadwindow();">Close</button>
  
              </div>
            </div>
            <!-- /.modal-content -->
          </div>
         
</div>

</body>
</html>
