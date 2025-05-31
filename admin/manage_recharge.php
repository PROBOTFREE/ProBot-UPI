<?php 
ob_start();
session_start();
if($_SESSION['userid']=="")
{
	header("location:index.php?msg1=notauthorized");
	exit();
}
	?>
	
<?php

//include ("include/connection.php");

if(isset($_POST['approve'])){
    
    include ("include/connection.php");
    
     $id = $_POST['id'];
     $userid = $_POST['userid'];
     $amount = $_POST['amount'];
     $status = 'success';
       $userref=mysqli_query($con,"select * from `tbl_user` where `id`='".$userid."'");
$userRows=mysqli_num_rows($userref);
$userResult=mysqli_fetch_array($userref);
$owncode=$userResult['code'];
$userlevel1=mysqli_query($con,"select *  from `tbl_user` where `owncode`='".$owncode."'");
$userlevel1Rows=mysqli_fetch_array($userlevel1); $userreferfineded = $userlevel1Rows['id'];
  
    $sql = "SELECT count(id) as rechargeId FROM `tbl_recharge` WHERE status = 1 AND userid =  $userid" ;
    $checkUser = mysqli_query($con,$sql);
    $userCount=mysqli_num_rows($checkUser);
    $dt = mysqli_fetch_assoc($checkUser);
    $rechargeCount = $dt['rechargeId'];
    
    if($rechargeCount == 0){
      $findUserSql = "SELECT code FROM `tbl_user` WHERE id = $userid";
      $findUser = mysqli_query($con,$findUserSql);
    //   echo mysqli_num_rows($findUser);
      if(mysqli_num_rows($findUser) > 0){
        $userCode = mysqli_fetch_assoc($findUser);
        $referrerCode = $userCode['code'];
        $findReferredUserSql = "SELECT id,mobile,code FROM `tbl_user` WHERE owncode = $referrerCode";
        $findReferredUser = mysqli_query($con,$findReferredUserSql); 
       
      }
    }
    
    $wal1 = mysqli_query($con, "UPDATE `tbl_recharge` SET status = 1 WHERE userid =  $userid  && id = $id ");
    // end
    
    	
	if ($status == 'success' ) { 
	    
	    
		$userid=$_POST['userid'];
		
		$chkorder=mysqli_query($con,"select * from `tbl_order` where `transactionid`='".$id."'");
		$chkorderRow=mysqli_num_rows($chkorder);
		$today = date("Y-m-d H:i:s");
		
		  $getBonus1 = mysqli_query($con,"SELECT * FROM `tbl_paymentsetting` ORDER BY id DESC");
		   $getBonusAmount1 = mysqli_fetch_assoc($getBonus1);
		   $amount2 = $_POST['amount'];
          $total2 = (float)$getBonusAmount1['rechargebonus'];
          
             $total3 = (float)$getBonusAmount1['rcomission'];
          
          $bamount1 = $amount2*$total2/100;
             $bamount2 = $amount2*$total3/100;
		if($chkorderRow==''){
			$sql= mysqli_query($con,"INSERT INTO `tbl_order`(`userid`,`transactionid`,`amount`,`status`) VALUES ('".$userid."','".$id."','".$amount."','1')");
			$orderid=mysqli_insert_id($con);

			$sql3= mysqli_query($con,"INSERT INTO `tbl_walletsummery`(`userid`,`orderid`,`amount`,`type`,`actiontype`,`createdate`) VALUES ('".$userid."','".$id."','".$amount."','credit','recharge','".$today."')");
			
				$sql4= mysqli_query($con,"INSERT INTO `tbl_walletsummery`(`userid`,`orderid`,`amount`,`type`,`actiontype`,`createdate`) VALUES ('".$userid."','".$id."','".$bamount1."','credit','recharge_bonus','".$today."')");
			  if($rechargeCount == 0){
			 $walletSql = mysqli_query($con,"UPDATE `tbl_bonus` SET `amount`= `amount`+'".$bamount2."' WHERE userid = $userreferfineded");
			 
			 	$sql6= mysqli_query($con,"INSERT INTO `tbl_walletsummery`(`userid`,`orderid`,`amount`,`type`,`actiontype`,`createdate`) VALUES ('".$userreferfineded."','".$id."','".$bamount2."','credit','refer_commission','".$today."')");
			  }
			
			              

			$sqlwall="SELECT * FROM `tbl_wallet` WHERE `userid`='$userid'";
			$reswall=mysqli_query($con,$sqlwall);
			if(mysqli_num_rows($reswall)>0)
			{
				$rowwall=mysqli_fetch_assoc($reswall);
				$walletbalance=$rowwall['amount'];	
				$finalbalanceCredit=$walletbalance+$amount+$bamount1;	

				$sqlwallet= mysqli_query($con,"UPDATE `tbl_wallet` SET `amount` = '$finalbalanceCredit' WHERE `userid`= '$userid'");
			}
			else
			{

				$walletbalance=0;	
				$finalbalanceCredit=$walletbalance+$amount+$bamount1;	
			
				$sqlwallet= mysqli_query($con,"INSERT INTO `tbl_wallet`(`userid`,`amount`,`envelopestatus`)VALUES('$userid','$finalbalanceCredit','0')");
			}
			
			
			
		}
		
		echo '<meta http-equiv="refresh" content="1">';

	}	else {
		//tampered or failed
		/*$msg = "Payment failed for Hash not verified...";*/
		echo '<script>alert("Recharge not Done !"); </script>';
	} 
    
}

if(isset($_POST['reject'])){
    
    include ("include/connection.php");
     $id = $_POST['id'];
     $userid = $_POST['userid'];
     $amount = $_POST['amount'];
  
  $wal11 = mysqli_query($con, "UPDATE `tbl_recharge` SET status = 0 WHERE userid =  $userid && id = $id");
  if($wal11){
        echo '<meta http-equiv="refresh" content="1">';
        
    }else{
         echo '<script>alert("Recharge not Done !"); </script>';
    }
  
}



?>
<!DOCTYPE html>
<html>
<head>
  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <title>Admin Panel | Manage Recharge Request</title>
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
table {
  border-collapse: collapse;
  border-spacing: 0;
  width: 100%;
  border: 1px solid #ddd;
}

th, td {
  text-align: left;
  padding: 8px;
}

tr:nth-child(even){background-color: #f2f2f2}
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
     <br></br>
      <ol class="breadcrumb">
        <li><a href="desktop.php"><i class="fa fa-dashboard"></i> Home</a></li>
        <li class="active">Manage Recharge Request</li>
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
            <div class="box-body" style="overflow-x:auto;">
  <form id="formID" name="formID" method="post" action="#" enctype="multipart/form-data">
          <!--<div class="table-responsive"> -->
              <table id="example1" class="table table-striped">
                  <h4 class="table_bg ">Manage Recharge Request</h4>
              	 
              	 </br>
              	 
                <thead>
                <tr>
                       <th>Sr.No</th>
                         
                <th>User Mobile</th>
                <th>Amount</th>
             <!--   <th>Payment Type</th> -->
                <th>TXN No.</th>
              
                <th>Date</th>
                
                 <th>Status</th>
                  <th>Action</th>
                </tr>
                </thead>
                <tbody>
     <?php
     
    /* $sqlget = mysqli_query($con,"SELECT * FROM tbl_user WHERE id  =  $userid");
     $sqlgetresult =mysqli_fetch_array($sqlget);
     $mobilenew =    $sqlgetresult['mobile'] ;*/


//  $Query=mysqli_query($con,"select *,(select `mobile` from `tbl_user` where `id`=`tbl_withdrawal`.`userid`)as user from `tbl_withdrawal` where `status`='1' order by id desc");
 $Query=mysqli_query($con,"select * from `tbl_recharge` where `status`='2' order by id desc ");
  $i=0;
     $sqlget = mysqli_query($con,"SELECT * FROM tbl_user WHERE id  =  $i");
     $sqlgetresult =mysqli_fetch_array($sqlget);
     $mobilenew =    $sqlgetresult['mobile'] ;
  $total=0; 
  while($row=mysqli_fetch_array($Query)){$i++;
  $post_date = $row['createdate'];
 $post_date2 = strtotime($post_date);
 $convert=date('h:i A d-m-Y',$post_date2);
     $sqlget = mysqli_query($con,"SELECT * FROM tbl_user WHERE id  =  $i");
     $sqlgetresult =mysqli_fetch_array($sqlget);
     $mobilenew =    $sqlgetresult['mobile'] ;
     
     
  $total+=$row['amount'];?>  
                  <tr>
                      <td><?php echo @$row["id"]; ?></td>
                      
           
              <td><?php $userid = $row["userid"];
			$sqlget = mysqli_query($con,"SELECT * FROM tbl_user WHERE id  =  $userid");
             $sqlgetresult = mysqli_fetch_array($sqlget);
            $mobilenew = $sqlgetresult['mobile'];  echo $mobilenew;             ?></td>
              <td><?php echo number_format($row['amount']);?></td>
            <!--  <td><?php echo strtoupper(@$row["paymentMethod"]); ?></td> -->
               <td><?php echo strtoupper(@$row["txn"]); ?></td>
               
               
           
                
              <td><?php echo $convert;?></td>
		
              <td><?php if($row['status']==1){echo "Approved";}elseif($row['status']==2){echo "Pending";}elseif($row['status']==0){echo "Rejected";}?></td>
                <td>
			      <form action="manage_recharge.php" method="POST">
			                <input type="hidden" name="id" value="<?php echo $row['id'];?>">
                            <input type="hidden" name="userid" value="<?php echo $row['userid'];?>">
                            <input type="hidden" name="amount" value="<?php echo $row['amount'];?>">
                            <input class="btn btn-primary" type="submit" name="approve" value="Approve">
                    </form> <br>
                        <form action="manage_recharge.php" method="POST">
                            <input type="hidden" name="id" value="<?php echo $row['id'];?>">
                            <input type="hidden" name="userid" value="<?php echo $row['userid'];?>">
                            <input type="hidden" name="amount" value="<?php echo $row['amount'];?>">
                            <input class="btn btn-danger" type="submit" name="reject" value="Reject">
                    </form> 
              </td>
                </tr>
        <?php }?>
               
                </tbody>
              </table>
              <!--</div>-->
   <div class="box-header box-header2" style="margin-bottom: 10px;">&nbsp; </div>
<div class="row">              
<div class="col-sm-6"></div>
              <div class="col-sm-6 text-right">
<!-- <strong>Total Request Amount: <i class="red_txt"><?php echo number_format($total,2);?></i></strong> -->
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
</body>
</html>
