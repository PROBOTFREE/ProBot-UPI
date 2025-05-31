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
  <title>Adminsuit | Manage User</title>
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
     
    <style>
        .list{
            padding: 0;
        }
        
        .user-info .list li{
            list-style: none;
        }
        .uinfo,.user-box{
            margin: 0px;
            padding: 10px;
            margin-bottom: 20px;
        }
        .uinfo{
            background: #fff;
        }
        .uinfo h2{
            text-align: right;
        }
        .uinfo strong {
            margin-left: 16px;
            font-weight: 600;
            font-size: 15px;
        }
        .uinfo span {
            font-weight: 600;
            font-size: 15px;
        }
        .ubox{
            margin: 0 150px;
        }
        .user-box div {
            width: 22%;
            margin: 0px 23px 25px 25px;
            padding: 27px;
        }
    </style>

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
      <h1>Users</h1>
      <ol class="breadcrumb">
        <li><a href="desktop.php"><i class="fa fa-dashboard"></i> Home</a></li>
        <li class="active">User</li>
      </ol>
    </section>

    <!-- Main content -->
    <section class="content">
        
        <?php
            $userid = $_GET['user'];
            $snum = mysqli_fetch_assoc(mysqli_query($con, "SELECT * FROM `tbl_user` WHERE `id` = '".$userid."' "));
            
            $total_balance = wallet($con,'amount',$userid);
            $owncode = $snum['owncode'];
            
          $total_recharge = mysqli_fetch_assoc(mysqli_query($con,"SELECT sum(amount) as total FROM `tbl_recharge` WHERE status = 1 AND userid = '".$userid."'"));
          
          $total_withdraw = mysqli_fetch_assoc(mysqli_query($con,"SELECT sum(amount) as total FROM `tbl_withdrawal` WHERE status = 0 AND userid = '".$userid."'"));
          
           $total_bonus = mysqli_fetch_assoc(mysqli_query($con,"SELECT sum(amount) as total FROM `tbl_bonus` where amount > 0 AND userid = '".$userid."'"));
           
           $total_bonusw = mysqli_fetch_assoc(mysqli_query($con,"SELECT sum(amount) as total FROM `tbl_bonuswithdrawal` where amount > 0 AND userid = '".$userid."'"));
            
            $total_reward = mysqli_fetch_assoc(mysqli_query($con,"SELECT sum(amount) as total FROM `tbl_reward` where userid = '".$userid."'"));
            
            $total_refer = mysqli_fetch_assoc(mysqli_query($con,"SELECT count(id) as total FROM `tbl_user` where code = '".$owncode."'"));
            
            $total_bet = mysqli_fetch_assoc(mysqli_query($con,"SELECT sum(amount) as total FROM `tbl_betting` where userid = '".$userid."'"));
            
            $deposite_record = mysqli_query($con,"SELECT * FROM `tbl_recharge` where userid = '".$userid."'");
            
            $withdraw_record = mysqli_query($con,"SELECT * FROM `tbl_withdrawal` where userid = '".$userid."'");
            
             $bonus_withdraw_record = mysqli_query($con,"SELECT * FROM `tbl_bonuswithdrawal` where userid = '".$userid."'");
            
             $totale_reward = mysqli_query($con,"SELECT * FROM `tbl_reward` where userid = '".$userid."'");
            
            // echo "SELECT * FROM `tbl_withdrawal` where userid = '".$userid."'";
            
            $refer_record = mysqli_query($con,"SELECT * FROM `tbl_user` where code = '".$owncode."'");
            
            $game_bet = mysqli_query($con,"SELECT * FROM `tbl_betting` where userid = '".$userid."'");
            
            $bank_details = mysqli_query($con,"SELECT * FROM `tbl_bankdetail` where userid = '".$userid."'");
            
            
        ?>
        
        <div class="row uinfo">
            <h4 class="box-title" style="font-weight:600;margin-left:16px;">User Details</h4>
            <div class="col-lg-6 col-sm-6 col-xs-6 user-info">
                <ul class="list">
                    <li>User Id : <?php echo "<b>".$snum['id']."</b>"; ?></li>
                    <li>Referal Id : <?php echo "<b>".$snum['owncode']."</b>"?></li>
                    <li>Email : <?php echo "<b>".$snum['email']."</b>"; ?></li>
                </ul>
            </div>
            
            <div class="col-lg-6 col-sm-6 col-xs-6 user-info">
                <ul class="list">
                    <li>Phone No. : <?php echo "<b>".$snum['mobile']."</b>"; ?>  </li>
                    <li>Created At : <?php echo "<b>".$snum['createdate']."</b>"; ?></li>
                    <li>Refered By : <?php echo "<b>".$snum['code']."</b>"?></li>
                </ul>
            </div>
        </div>
        
        <div class="row user-box" style="margin:0px;padding:0px;width:100%;">
            <div class="col-md-3 col-sm-12  col-lg-3 uinfo" style="margin-left:0 !important">
                <strong>TOTAL BALANCE</strong>
                <h2><?= (float) $total_balance;?></h2>
            </div>
            <div class="col-md-3 col-sm-12  col-lg-3 uinfo ubox">
                <strong>TOTAL REFERRAL</strong>
                <h2><?= (float) $total_refer['total'];?></h2>
            </div>
            <div class="col-md-3 col-sm-12 col-lg-3 uinfo">
                <strong>TOTAL BET</strong>
                <h2><?= (float) $total_bet['total'];?></h2>
            </div>
             <div class="col-md-3 col-sm-12 col-lg-3 uinfo" style="margin-right:0 !important">
                <strong>TOTAL Recharge</strong>
                <h2><?= (float) $total_recharge['total'];?></h2>
            </div>
            <div class="col-md-3 col-sm-12 col-lg-3 uinfo" style="margin-right:0 !important">
                <strong>TOTAL WITHDRAWN</strong>
                <h2><?= (float) $total_withdraw['total'];?></h2>
            </div>
              <div class="col-md-3 col-sm-12 col-lg-3 uinfo" style="margin-right:0 !important">
                <strong>TOTAL Reward</strong>
                <h2><?= (float) $total_reward['total'];?></h2>
            </div>
              <div class="col-md-3 col-sm-12 col-lg-3 uinfo" style="margin-right:0 !important">
                <strong>Avaliable Bonus</strong>
                <h2><?= (float) $total_bonus['total'];?></h2>
            </div>
               <div class="col-md-3 col-sm-12 col-lg-3 uinfo" style="margin-right:0 !important">
                <strong>Total Bonus Withdraw</strong>
                <h2><?= (float) $total_bonusw['total'];?></h2>
            </div>
        </div>
         <div class="row uinfo">
            <div class="col-lg-12 col-sm-12 col-xs-12 user-info">
                <span>REFERAL RECORD</span>
                <table id="example3" class="table table-condensed">
                    <thead>
                        <tr>
                            <th>Updated At</th>
                            <th>Refered To</th>
                            <th>Email</th>
                            <th>Total Recharge</th> 
                        </tr>
                    </thead>
                    <tbody>
                        <?php 
                            while($item=mysqli_fetch_array($refer_record)) { ?>
                                <tr>
                                    <td><?= $item['createdate']; ?></td>
                                    <td><?= $item['mobile']; ?></td>
                                    <td><?= $item['email']; ?></td>
                                      <td>		    <?php
														    
														    $totalRecharge['total'] = 0;
                                                                $q = mysqli_query($con,"SELECT sum(amount) as total FROM tbl_recharge WHERE status = 1 AND userid = '".$row['id']."' ");
                                                                $totalRecharge = mysqli_fetch_assoc($q);
                                                                echo round($totalRecharge['total'],2);
                                                            
                                                            ?></td>
													
                                </tr>
                            <?php } ?>
                    </tbody>
                </table>
            </div>
        </div>
        
          <div class="row uinfo">
            <div class="col-lg-12 col-sm-12 col-xs-12 user-info">
                <span>REWARD RECORD</span>
                                    <?php //echo '<pre>';
                                    //print_r($withdraw_record); exit('deposite');?>
                <table id="example1" class="table table-condensed">
                    <thead>
                        <tr>
                            <th>Updated At</th>
                            <th>Amount</th>
                            
                        </tr>
                    </thead>
                    <tbody>
                         <?php 
                                    while($item = mysqli_fetch_array($totale_reward)){  ?>
                                       <tr>
                                            <td><?= $item['createdate'] ?></td>
                                            <td><?= $item['amount'] ?></td>
                                            
                                       </tr> 
                            <?php
                                    } ?>
                    </tbody>
                </table>
            </div>
        </div>
        <div class="row uinfo">
            <div class="col-lg-12 col-sm-12 col-xs-12 user-info">
                <span>DEPOSIT RECORD</span>
                                    <?php //echo '<pre>';
                                    //print_r($withdraw_record); exit('deposite');?>
                <table id="example1" class="table table-condensed">
                    <thead>
                        <tr>
                            <th>Updated At</th>
                            <th>Transaction ID</th>
                            <th>Payment Method</th>
                            <th>Phone</th>
                            <th>Amount</th>
                            <th>Status</th>
                        </tr>
                    </thead>
                    <tbody>
                         <?php 
                                    while($item = mysqli_fetch_array($deposite_record)){  ?>
                                       <tr>
                                            <td><?= $item['createdate'] ?></td>
                                            <td><?= $item['txn'] ?></td>
                                            <td><?= ucfirst($item['paymentMethod']) ?></td>
                                            <td><?= $item['mobile'] ?></td>
                                            <td><?= $item['amount'] ?></td>
                                            <td>    <?php if($item["status"]=='1'){echo"Success";}elseif($item["status"]=='0'){echo"Cancel";}elseif($item["status"]=='2'){echo"Pending";}?>
                                           </td>
                                       </tr> 
                            <?php
                                    } ?>
                    </tbody>
                </table>
            </div>
        </div>
        
        <div class="row uinfo">
            <div class="col-lg-12 col-sm-12 col-xs-12 user-info">
                <span>WITHDRAW RECORD</span>
                <table id="example2" class="table table-condensed">
                    <thead>
                        <tr>
                            <th>Updated At</th>
                            <th>Amount</th>
                            <th>Payout</th>
                            <th>Status</th>
                        </tr>
                    </thead>
                    <tbody>
                        
                            <?php
                                
                                    while($item = mysqli_fetch_array($withdraw_record)){ ?>
                                        <tr>
                                            <td><?= $item['createdate'] ?></td>
                                            <td><?= $item['amount'] ?></td>
                                            <td><?= $item['payout'] ?></td>
                                            
                                        <td>    <?php if($item["status"]=='1'){echo"Pending";}elseif($item["status"]=='0'){echo"Success";}elseif($item["status"]=='2'){echo"Cancel & Refund";}?>
                                           </td>
                                        </tr>
                            <?php   } ?>
                        </tr>
                    </tbody>
                </table>
            </div>
        </div>
            <div class="row uinfo">
            <div class="col-lg-12 col-sm-12 col-xs-12 user-info">
                <span>BONUS WITHDRAW RECORD</span>
                <table id="example2" class="table table-condensed">
                    <thead>
                        <tr>
                            <th>Updated At</th>
                            <th>Amount</th>
                            <
                        </tr>
                    </thead>
                    <tbody>
                        
                            <?php
                                
                                    while($item = mysqli_fetch_array($bonus_withdraw_record)){ ?>
                                        <tr>
                                            <td><?= $item['createdate'] ?></td>
                                            <td><?= $item['amount'] ?></td>
                                           
                                        </tr>
                            <?php   } ?>
                        </tr>
                    </tbody>
                </table>
            </div>
        </div>
      
       
        <div class="row uinfo">
            <div class="col-lg-12 col-sm-12 col-xs-12 user-info">
                <span>GAME BET RECORD</span>
                <table id="example4" class="table table-condensed">
                    <thead>
                        <tr>
                            <th>Created At</th>
                            <th>Period Id</th>
                            <th>Result</th>
                            <th>Value</th>
                            <th>Amount</th>
                            <th>Tab</th>
                        </tr>
                    </thead>
                    <tbody>
                        <?php if(!empty($game_bet)){
                            while($item=mysqli_fetch_array($game_bet)) {  ?>
                                <tr>
                                    <td><?=$item['createdate'] ?></td>
                                    <td><?=$item['periodid'] ?></td>
                                    <td><?=$item['type'] ?></td>
                                    <td><?=$item['value'] ?></td>
                                    <td><?=$item['amount'] ?></td>
                                 <td><?=$item['tab'] ?></td>
                                </tr>
                            <?php }
                            }else{?>
                                <tr>
                                    <td colspan="6">No data found </td>
                                </tr>
                            <?php }?>
                    </tbody>
                </table>
            </div>
        </div>
        
        <div class="row uinfo">
            <div class="col-lg-12 col-sm-12 col-xs-12 user-info">
                <span>BANK DETAILS</span>
                <table id="example5" class="table table-condensed">
                    <thead>
                        <tr>
                            <th>Bank Name</th>
                            <th>Account Holder</th>
                            <th>Account Number</th>
                            <th>IFSC</th>
                            <th>Type</th>
                            <th>Status</th>
                        </tr>
                    </thead>
                    <tbody>
                        <?php while($item=mysqli_fetch_array($bank_details)) { ?>
                        <tr>
                            <td><?= $item['bankname'] ?> </td>
                            <td><?= $item['name'] ?> </td>
                            <td><?= $item['account'] ?> </td>
                            <td><?= $item['ifsc'] ?> </td>
                            <td><?= $item['type'] ?> </td>
                              <td>    <?php if($item["status"]=='1'){echo"Activate";}elseif($item["status"]=='0'){echo"Deactivate";}?>
                                           </td>
                        </tr>
                        <?php } ?>
                    </tbody>
                </table>
            </div>
        </div>
        
        
      
      
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
	  "pageLength": 100,
	  /*"processing": true,
      "serverSide": true,
      "ajax": '../server_side/scripts/server_processing.php',*/
    });
    $('#example2').DataTable({
      "paging": true,
      "lengthChange": false,
      "searching": true,
      "ordering": false,
      "info": true,
      "autoWidth": true,
	  "pageLength": 100,
	  /*"processing": true,
      "serverSide": true,
      "ajax": '../server_side/scripts/server_processing.php',*/
    });
    $('#example3').DataTable({
      "paging": true,
      "lengthChange": false,
      "searching": true,
      "ordering": false,
      "info": true,
      "autoWidth": true,
	  "pageLength": 100,
	  /*"processing": true,
      "serverSide": true,
      "ajax": '../server_side/scripts/server_processing.php',*/
    });
    $('#example4').DataTable({
      "paging": true,
      "lengthChange": false,
      "searching": true,
      "ordering": false,
      "info": true,
      "autoWidth": true,
	  "pageLength": 100,
	  /*"processing": true,
      "serverSide": true,
      "ajax": '../server_side/scripts/server_processing.php',*/
    });
    $('#example5').DataTable({
      "paging": true,
      "lengthChange": false,
      "searching": true,
      "ordering": false,
      "info": true,
      "autoWidth": true,
	  "pageLength": 100,
	  /*"processing": true,
      "serverSide": true,
      "ajax": '../server_side/scripts/server_processing.php',*/
    });
  });
</script>

</body>
</html>
