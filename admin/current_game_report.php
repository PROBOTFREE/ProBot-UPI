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
  <title>Admin Panel | Active Game Report</title>
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
  

    <!-- Main content -->
    <section class="content">
      <div class="row">
        <div class="col-xs-12">
          

          <div class="box">

            <div class="box-body">
  <form id="formID" name="formID" method="post" action="#" enctype="multipart/form-data">
          <!--<div class="table-responsive"> -->
              <table id="example1" class="table table-striped text-center">


                 <h4 class="table_bg ">Current Game Report <span class="pull-right">Game ID- <?php



$result = mysqli_query($con,"SELECT * FROM tbl_gameid order by id desc limit 0,1");
?>

<?php
if (mysqli_num_rows($result) > 0) {

$i=0;
while($row = mysqli_fetch_array($result)) {

                  
                 $cr_gameid = $row["gameid"];
              echo "$cr_gameid";                  
                    


$i++;
}}
?></span></h4><br>

                <thead>
                <tr>
                                  
                                   <th>Values</th>
                    <th>Total Users</th>
                    <th>Total Amount</th>
                   
                    
                </tr>
                </thead>
              <tbody>
<?php



$result = mysqli_query($con,"SELECT value , count( userid) as 'all_users', sum(amount) as 'total_amount' FROM tbl_betting where periodid = $cr_gameid group by value");
?>

<?php
if (mysqli_num_rows($result) > 0) {
?>
 
<?php
$i=0;
while($row = mysqli_fetch_array($result)) {
?>
                  
                     <tr>
   
  
                    <td><?php echo $row["value"]; ?></td>
                     <td><?php echo $row["all_users"]; ?></td>
 <td>₹ <?php echo number_format($row["total_amount"]) ; ?></td>

</tr>
    
<?php
$i++;
}}
?>


                  
                 
                 
                  
                  </tbody>
                
              </table>
              <!--</div>-->
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
      <section class="content">
            <div class="row">
                <div class="col-xs-12">


                    <div class="box">
                       
                        <!-- /.box-header -->
                        <div class="box-body">
                            <form id="formID" name="formID" method="post" action="#" enctype="multipart/form-data">
                                <!--<div class="table-responsive"> -->
                                <table id="example2" class="table table-bordered table-striped">
                                    <thead>
                                    <tr>

                                      
                                        <th>User ID</th>
                                           <th>Period ID</th>
                                              <th>Select</th>
                                       
                                        <th>Amount</th>
                                       <th>Tab</th>
                                        <th>Date</th>


                                    </tr>
                                    </thead>
                                    <tbody>
                                    <?php
                                    $Query=mysqli_query($con,"select * FROM tbl_betting where periodid = $cr_gameid  ");
                                    $i=0;
                                    while($row=mysqli_fetch_array($Query)){$i++;?>


                                     <tr>

                                         <td>   <a href="user-details.php?user=<?php echo @$row["userid"]; ?>" ><?php echo @$row["userid"]; ?></a>
                                            </td>
                                            <td><?php echo @$row["periodid"]; ?></td>
                                            <td style="color:<?php if($row["value"]=='Green'){echo"#1DCC70";}elseif($row["value"]=='Red'){echo"#ff2d55";}else{echo"#3D67B3";}?>"><?php echo @$row["value"]; ?></td>
                                            
                                            
                                                    <td><?php echo number_format($row["amount"], 2) ?></td>
                                                    
                                       <td><?php echo @$row["tab"]; ?></td>
                                        
                                    
                                        
                                      
                                            <td><?php echo @$row["createdate"]; ?></td>
                                        </tr>
                                    <?php }?>


                                    </tbody>

                                </table>
                                <!--</div>-->
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
<script>

    $(function () {
        $('#example2').DataTable({
            "paging": true,
            "lengthChange": true,
            "searching": true,
            "ordering": true,
            "info": true,
            "autoWidth": true,
            "pageLength": 50
        });
    });
</script>
</body>
</html>
