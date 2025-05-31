<?php 
   ob_start();
   session_start();
   if($_SESSION['userid']=="")
   {
   	header("location:index.php");
   	exit();
   }
   
   include ("include/connection.php");
   
   
   ?>
<!DOCTYPE html>
<html>
   <head>
      <meta charset="utf-8">
      <meta http-equiv="X-UA-Compatible" content="IE=edge">
      <title>Admin Panel - User Info Edit</title>
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
            (int)$edit_user_id = $_GET['user'];
            
            
            $user_edit_query = mysqli_query($con, "SELECT * FROM tbl_user where id = $edit_user_id");
            
            $user_info_edit = mysqli_fetch_array($user_edit_query);
        

        $bank_edit_query = mysqli_query($con, "SELECT * FROM tbl_bankdetail where userid = $edit_user_id order by id desc limit 0,1");
            
            $bank_info_edit = mysqli_fetch_array($bank_edit_query);




            ?>
            
            
  <div class="content-wrapper">

    



  <!-- Main content -->

  <section class="content">
            
            <!-- Main content -->
    <section class="content">
      <div class="row">
      <div class="col-xs-12 text-center">
          
          <?php if(isset($_GET['msg'])=="updt"){ ?>
              <span class="text-center red_txt">Update Successfully......</span><?php  } ?></div>
        <div class="col-xs-12">
          

          <div class="box">
            
            <!-- /.box-header -->


 <div class="row">
                  <div class="col-xs-12">
                     <h4 class="table_bg ">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;User Personal Informattion</h4>
                     <!-- /.box-header -->
                     <form action="" method="POST">
                        <div class="box-body blue_bg">
                           <div class="clearfix"></div>
                           <div class="col-md-12 col-sm-12 col-xs-12">
                              <div class="form-group">
                                 <label for="address">Mobile</label>
                                 <input class="form-control"  name="u_mobile" type="number" value="<?php echo @$user_info_edit['mobile']; ?>">
                              </div>
                           </div>
                           <div class="col-md-12 col-sm-12 col-xs-12">
                              <div class="form-group">
                                 <label for="email"> Email</label>
                                 <input class="form-control"  name="u_email" type="email" value="<?php echo @$user_info_edit['email']; ?>">
                              </div>
                           </div>
                           <div class="col-md-12 col-sm-12 col-xs-12">
                              <div class="form-group">
                                 <label for="content1">Invite Code</label>
                                 <input class="form-control"  name="u_code" type="text" value="<?php echo @$user_info_edit['owncode']; ?>">
                              </div>
                           </div>
                           <div class="col-md-12 col-sm-12 col-xs-12">
                              <div class="form-group">
                                 <label for="content1">Password</label>
                                 <input class="form-control"  name="u_password" type="text" value="<?php echo @$user_info_edit['password']; ?>">
                              </div>
                           </div>
                           <div class="col-md-12 col-sm-12 col-xs-12">
                              <div class="form-group">
                                 <label > Status</label>
                                 <select name="u_status" class="form-control">
                                    <option value="1">Active</option>
                                    <option value="0">Block</option>
                                 </select>
                              </div>
                           </div>
                           <div class="clearfix"></div>
                           <div class="clearfix"></div>
                           <div class="col-md-12 col-sm-12 col-xs-12">
                              <div class="form-group">
                                 <div class="text-center">
                                    <input type="submit" name="user_info" class="btn btn-primary" value="Update User Info" >
                                 </div>
                              </div>
                           </div>
                        </div>
                        <div class="clearfix"></div>
                     </form>
                     <!-- /.box-body -->
                  </div>

                  <!-- /.col -->
                  <!-- Bank -->
                  
                  <!-- Bank -->
               </div>
               
                        <div class="clearfix"></div>
                        
                        </br></br>
                  
                        

              <!-- <div class="row">
                  <div class="col-xs-12">
                     <h4 class="table_bg ">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;User Bank Informattion</h4>
                     <!-- /.box-header 
                     <form  action="" method="POST">
                        <div class="box-body blue_bg">
                           <div class="clearfix"></div>
                           <div class="col-md-12 col-sm-12 col-xs-12">
                              <div class="form-group">
                                 <label for="address">Name</label>
                                 <input class="form-control"  name="b_name" type="text" value="<?php echo @$bank_info_edit['name']; ?>">
                              </div>
                           </div>
                           <div class="col-md-12 col-sm-12 col-xs-12">
                              <div class="form-group">
                                 <label for="email">IfSC</label>
                                 <input class="form-control"  name="ifsc" type="text" value="<?php echo @$bank_info_edit['ifsc']; ?>">
                              </div>
                           </div>
                           <div class="col-md-12 col-sm-12 col-xs-12">
                              <div class="form-group">
                                 <label for="content1">Bank Name</label>
                                 <input class="form-control"  name="bankname" type="text" value="<?php echo @$bank_info_edit['bankname']; ?>">
                              </div>
                           </div>
                          



                           <div class="col-md-12 col-sm-12 col-xs-12">
                              <div class="form-group">
                                 <label for="content1">Account Number</label>
                                 <input class="form-control"  name="account" type="text" value="<?php echo @$bank_info_edit['account']; ?>">
                              </div>
                           </div>
                          


                           <div class="col-md-12 col-sm-12 col-xs-12">
                              <div class="form-group">
                                 <label for="content1">UPI Address</label>
                                 <input class="form-control"  name="upi" type="text" value="<?php echo @$bank_info_edit['upi']; ?>">
                              </div>
                           </div>
                          

                          <div class="col-md-12 col-sm-12 col-xs-12">
                              <div class="form-group">
                                 <label>Type</label>
                                 <select name="type" class="form-control">
                                    <option value="bank">Bank</option>
                                    <option value="upi">UPI</option>
                                 </select>
                              </div>
                           </div>
                          


                           
                           <div class="clearfix"></div>
                           <div class="col-md-12 col-sm-12 col-xs-12">
                              <div class="form-group">
                                 <div class="text-center">
                                    <input type="submit" name="bank_info" class="btn btn-primary" value="Update Bank Info" >
                                 </div>
                              </div>
                           </div>
                        </div>
                        <div class="clearfix"></div>
                     </form>
                     <!-- /.box-body -->
                  </div>

                  <!-- /.col -->
                  <!-- Bank -->
                  <!-- Bank -->
               </div>
               <!-- /.row -->
               
               <!-- /.col -->
            </section>
            <!-- /.content -->
         </div>
         <!-- /.content-wrapper -->
         <?php  include("include/footer.inc.php");?>
      </div>
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
                   window.location = 'manage_user.php'; 
                   }
         
               }
          
      </script> 
      <!--sucess modal-->
   </body>
</html>



<?php 

/*user info update Start*/
if(isset($_POST['user_info']))
{

$user_mobile= strval($_POST['u_mobile']);


$user_email= $_POST['u_email'];


$user_pass= strval($_POST['u_password']);

$user_code= strval($_POST['u_code']);

$user_status= $_POST['u_status'];


$user_sql = "UPDATE tbl_user SET mobile='$user_mobile', email='$user_email', password='$user_pass', owncode='$user_code', status='$user_status' WHERE id=$edit_user_id";



if (!mysqli_query($con,$user_sql)) {




echo '<script>
alert("Something Went Wrong");
window.location.href="manage_user.php";
</script>';


}
else
{
  echo '<script>
alert("User Info Updating...");
window.location.href="manage_user.php";
</script>';

}
}


/*user info update end*/








/*Bank Info Update*/


if(isset($_POST['bank_info']))
{





$b_name = $_POST['b_name'];

$ifsc = $_POST['ifsc'];

$bankname = $_POST['bankname'];

$account = $_POST['account'];

$upi = $_POST['upi'];

$type = $_POST['type'];




$bank_sql = "UPDATE tbl_bankdetail SET name='$b_name', ifsc='$ifsc', bankname='$bankname', account='$account', upi='$upi', type='$type'  WHERE userid=$edit_user_id";





if (!mysqli_query($con,$bank_sql)) {



echo "$bank_sql";

/*
echo '<script>
alert("Something Went Wrong");
window.location.href="manage_user.php";
</script>';*/



}
else
{
  echo '<script>
alert("Bank Info Updating...");
window.location.href="manage_user.php";
</script>';

}



   }


   /*Bank Info Update*/
    ?>