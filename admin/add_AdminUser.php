<?php 
ob_start();
session_start();
if($_SESSION['userid']=="")
{
	header("location:index.php");
	exit();
}

if(isset($_POST['Action'])){
	include ("include/connection.php");
	$name=$_POST['name'];
	$user_name=$_POST['admin_name'];
	$role=$_POST['role'];
	$password=$_POST['password'];
	$repassword=$_POST['repassword'];
	$allowtime=$_POST['allowtime'];
	$default_status=1;
	$time=date( 'Y-m-d h:i:s');


if($_POST['Action']=="Add"){

if(strlen($password!==$repassword))	
{
header("location:add_AdminUser.php?msgnot=notmached"); exit();
}else{
$username = mysqli_real_escape_string($con,$_POST['admin_name']);

$check_for_username = mysqli_query($con,"SELECT `id` FROM `tbl_admin` WHERE admin_name='$username'");

if(mysqli_num_rows($check_for_username))
{header("location:add_AdminUser.php?msgg=notavailable");
}
else
{	
 $sql= "INSERT INTO `tbl_admin`(`name`,`admin_name`,`password`,`role`,`expiry_date`,`status`,`date`) VALUES ('". $name ."','". $user_name ."','". md5($repassword) ."','". $role ."','no','".$default_status."','".$time."')";
 
 $query=mysqli_query($con,$sql);

if($query){
	header("location:add_AdminUser.php?msg=ins");
	}
}//else user chk
}exit();
}
if(($_POST['Action'])=='Edit'){
@$id=$_POST['id'];
 $sql2= "UPDATE `tbl_admin` SET `name`='".$name."',`admin_name`='".$user_name."',`role`='".$role."',`date`= '".$time."' WHERE `id`='$id'";
	
$query2=mysqli_query($con,$sql2);

if($query2){
	
	header("location:manage_adminuser.php?msg=updt");
	
	}exit();
	
	
}

}

	?>
<!DOCTYPE html>
<html>
<head>
  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <title>Adminsuit | <?php if(@$_GET['id']!=''){echo "Edit";}else{echo "Add";} ?> AdminUser</title>
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
 <?php include ("include/navigation.inc.php");
 ?>
   
  <?php 
  if(@$id=encryptor('decrypt', $_GET['id'])){
$sql="SELECT * FROM `tbl_admin` where id=$id";
$query=mysqli_query($con,$sql);
$role=mysqli_fetch_array($query);
  }
	?>

  <div class="content-wrapper">
    <section class="content-header">
      <h1><?php if(@$_GET['id']!=''){echo "Edit";}else{echo "Add";} ?> AdminUser</h1>
      <ol class="breadcrumb">
        <li><a href="manage_adminuser.php"><i class="fa fa-dashboard"></i> Manage AdminUser</a></li>
        <li class="active"><?php if(@$_GET['id']!=''){echo "Edit";}else{echo "Add";} ?> AdminUser</li>
      </ol>
    </section>

    <!-- Main content -->
    <section class="content">
      <div class="row">
        <div class="col-xs-12">
          

          <div class="box">
            <div class="box-header box-header2">
             <div class="col-sm-10">
         <h3 class="box-title">
		 <?php 
				if((@$_GET['msg'])=="ins") 
				{ ?>
              <font size="+2" color="#FF0000">User added successfully......</font>
              <?php  } ?></h3></div>
              
            </div>
            <!-- /.box-header -->
            
      <form  method="post" action="<?php echo $_SERVER['PHP_SELF'];?>" id="taskform">
            <div class="box-body">
           
                <div class="clearfix"></div>
              <div class="col-md-5 col-sm-6 col-xs-12">
                  <div class="form-group">
                  <label for="company">Name</label>
         <input class="form-control" id="name" name="name" type="text" value="<?php echo @$role['name']; ?>">
                </div>
                </div>            
            <input name="id" value="<?php echo @$id?>" type="hidden">
<div class="clearfix"></div>
              <div class="col-md-5 col-sm-6 col-xs-12">
                  <div class="form-group">
                  <label for="company">User Name</label>
         <input class="form-control" id="admin_name" name="admin_name" type="text" value="<?php echo @$role['admin_name']; ?>">
         <span  class="red_txtt" id="erremail">
     <?php if(isset($_GET['msgg'])=="notavailable") 
				{echo "Username All Ready Registered";} ?></span>
                </div>
                </div>
                <div class="clearfix"></div>
                <div class="col-md-5 col-sm-6 col-xs-12">
                  <div class="form-group">
                  <label for="role">Select Role <span>*</span></label>
<select class="form-control" id="role" name="role" required>
               <option value="" selected="selected">Select Role</option>
 <?php 
$sql_role="SELECT SQL_NO_CACHE * FROM `role` where `status`='1'";
  $result_role=mysqli_query($con,$sql_role)or die(mysql_error());
  $num=mysqli_num_rows($result_role);
  while($row_role=mysqli_fetch_array($result_role))
  {
  ?>
  
   <option <?php if(@$role['role']==$row_role['id']) {echo "selected='selected'";} ?> value="<?php echo $row_role['id']?>" >
    <?php echo $row_role['role']?>
  </option>
  <?php
  }	  
  ?>  </select>
  <input name="id" value="<?php echo @$id?>" type="hidden">
                   
                  
                </div>
                </div>
                <div class="clearfix"></div>
            <?php 
			if(@$id==''){
			?>    
              <div class="col-md-5 col-sm-6 col-xs-12">
                  <div class="form-group">
                  <label for="company">Password</label>
         <input class="form-control" id="password" name="password" type="password">
                </div>
                </div>
<div class="clearfix"></div>
              <div class="col-md-5 col-sm-6 col-xs-12">
                  <div class="form-group">
                  <label for="company">Re-Enter Password</label>
         <input class="form-control" id="repassword" name="repassword" type="password">
          <span  class="red_txtt" id="erremail"> 
		  <?php if(isset($_GET['msgnot'])=="notmached") 
				{echo "Password Not Matched";} ?></span>
                </div>
                </div>
                <?php }?>
             <div class="clearfix"></div> 
             <div class="col-md-5 col-sm-6 col-xs-12">  
              <div class="form-group">
              <div class="text-center">
  <button type="reset" class="btn btn-default" onClick="location.href='manage_task.php'">Cancel</button>
 <input type="submit" name="Action" class="btn btn-primary" value="<?php if(@$id != ''){echo 'Edit';}else{echo 'Add';}?>" ></div>
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

</body>
</html>
