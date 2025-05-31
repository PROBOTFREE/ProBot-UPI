<?php 
ob_start();
session_start();
if($_SESSION['userid']=="")
{
	header("location:index.php?msg1=notauthorized");
	exit();
}
	
include ("include/connection.php");

?>
<!DOCTYPE html>
<html>
<head>
  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <title>Admin Panel | Complaints</title>
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
 <?php include ("include/navigation.inc.php");
 $sql="select* FROM `tbl_paymentsetting` WHERE id='1'";
$query=mysqli_query($con,$sql);
$role=mysqli_fetch_array($query);

 ?> 
  <div class="content-wrapper">
    <section class="content-header">
      <h1>Complaint View</h1>
      <ol class="breadcrumb">
        <li><a href="desktop.php"><i class="fa fa-dashboard"></i>Home</a></li>
        <li class="active">Complaint View</li>
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




         <?php $complaint_id = $_GET['complaint_id']; 



$result = mysqli_query($con,"SELECT * FROM complaint WHERE complaint_id = $complaint_id");
?>

<?php
if (mysqli_num_rows($result) > 0) {
?>
 
<?php
$i=0;
while($row = mysqli_fetch_array($result)) {


?>




                <div class="card-body pb-4">
                 

   
                
 <a style=" background: seashell;"  class="list-group-item list-group-item-action flex-column align-items-start">
    <div class="d-flex w-100 justify-content-between">
      <h4 class="mb-1"><strong>Status:-</strong><?php echo $row["complaint_status"]; ?></h4>
      <small><strong>Member id:-</strong>Member <?php echo $row["user_id"]; ?></small><br>
     <small><strong>Complaint For:-</strong><?php echo $row["complaint_for"]; ?></small>
    </div>
    <p class="mb-1"><strong>WhatsApp:-</strong><?php echo $row["complaint_subject"]; ?></p>
    <p class="mb-1"><strong>Complaint:-</strong><?php echo $row["complaint_text"]; ?></p>
    <small><?php echo $row["complaint_time"]; ?></small>
  </a>
               
  <?php 
 if (!empty($row["complaint_reply"])) {
?>

 	<a style="background: aliceblue;" class="list-group-item list-group-item-action flex-column align-items-start pb-4">

    <p class="mb-1"><strong>Complaint Reply:-</strong><?php echo $row["complaint_reply"]; ?></p>
    <small><?php echo $row["complaint_reply_time"]; ?></small>
  </a>
   <?php 
}
              	
                    
 




?>


                  </div>
  <?php  
             $i++;
}
?>


 <?php
}

?>

         

         <div style="padding: 40px;" class="col-md-8">
     <form method="POST">


                <div class="card-body">



                	   <div class="form-group">
                  
                  <select style="width: 100%;" class="custom-select form-control-border" name="complaint_status" required>
                    <option value="">Complaint Status</option>
                    <option value="Under Reviews">Under Reviews</option>
                    <option value="Pending">Pending</option>
                   
                    <option value="Resolved">Resolved</option>
                   
                    
                  </select>
                </div>


                
                 
                 <div class="form-group">

				    <textarea class="form-control" name="complaint_reply" placeholder="Admin Reply" rows="5" required></textarea>
				  </div>
              
              

               
                  </div>
               
                
                <!-- /.card-body -->
<div class="text-center mt-1">
                  <button type="submit" name="submit"class="btn btn-primary" style="width:264px;">Submit</button>

                </div>


             
              </form></div> 


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
  
<?php include("include/footer.inc.php"); ?>
</div>

</body>
</html>




<?php


if(isset($_POST['submit']))
{


$complaint_status = $_POST['complaint_status'];
$complaint_reply_time = date('d-m-y h:i:s');
$complaint_reply = mysqli_real_escape_string($con, $_POST['complaint_reply']);
 







$sql = "UPDATE complaint
SET complaint_status='$complaint_status', complaint_reply='$complaint_reply',complaint_reply_time='$complaint_reply_time'
WHERE complaint_id=$complaint_id";



if (!mysqli_query($con,$sql)) {
  // code...
echo '<script>
alert("Something Went Wrong");
window.location.href="all_queries.php";
</script>';


}
else
{
  echo '<script>
alert("Complaint Save");
window.location.href="all_queries.php";
</script>';

}

}




?>