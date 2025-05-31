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
  <title>Adminsuit | Dashboard</title>
  <!-- Tell the browser to be responsive to screen width -->
  <meta content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" name="viewport">
  <!-- Bootstrap 3.3.6 -->
  <link rel="stylesheet" href="bootstrap/css/bootstrap.min.css">
  <!-- Font Awesome -->
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.5.0/css/font-awesome.min.css">
  <!-- Ionicons -->
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/ionicons/2.0.1/css/ionicons.min.css">
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

  <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
  <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
  <!--[if lt IE 9]>
  <script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
  <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
  <![endif]-->
</head>
<body class="hold-transition skin-red sidebar-mini">
<div class="wrapper">
<?php include ("include/connection.php");?>
<?php include ("include/header.inc.php");?>
  <!-- Left side column. contains the logo and sidebar -->
 <?php include ("include/navigation.inc.php");
function counter($table){
$rs=mysql_query("select count(*) from `$table`");
$row = mysql_fetch_row($rs);
return $row["0"];
} 

 ?> 
 
 
 
 <?php		  
$Level1q = mysqli_query($con , "SELECT * FROM `tbl_user` ");
  $rowcount = mysqli_num_rows( $Level1q );
  
  $deposits = mysqli_query($con , "SELECT * FROM `tbl_recharge`  where status = 1 ");
  $depositsshow = mysqli_num_rows( $deposits );
  
    $withdrawal = mysqli_query($con , "SELECT * FROM `tbl_withdrawal` where status = 0 ");
  $withdrawalshow = mysqli_num_rows( $withdrawal );
  
  $bonus = mysqli_query($con , "SELECT * FROM `tbl_bonus` ");
  $bonusshow = mysqli_num_rows( $bonus );
  
  $bonus1 = mysqli_query($con , "SELECT sum(amount) as totaldeposite FROM `deposits` WHERE `status` = '2' ");
  $bonusshow1 = mysqli_num_rows( $bonus1 );
  $row = mysqli_fetch_array($bonus1);
  
  
  
 


 //$bonus11 = mysqli_query($con , "SELECT sum(amount) as totalwithdrawal FROM `tbl_withdrawal` WHERE `status` = '0' ");
  //$bonusshow11 = mysqli_num_rows( $bonus11 );
  //$row = mysqli_fetch_array($bonus11);
 
  
   ?>
   


  <!-- Content Wrapper. Contains page content -->
  <div class="content-wrapper">
    <!-- Content Header (Page header) -->
    <section class="content-header">
	
      <h1>
        Dashboard
        <small>Control panel</small>
      </h1>
      <ol class="breadcrumb">
        <li><a href="desktop.php"><i class="fa fa-dashboard"></i> Home</a></li>
        <li class="active">Dashboard</li>
      </ol>
    </section>
 <section  class="content">
      <div  class="container">
      <!-- Small boxes (Stat box) -->
      <div class="row">

 <div style="background-color: #A6382B; color: white; padding: 20px; margin: 10px;" class="dashboard_box blue_bg col-md-3 border-radius">



          <div class="title">
            <p class="text-title" style="text-align:left">Today User Join</p>
            <h4 class="text-amount" style="text-align:left"><?php



$result = mysqli_query($con,"SELECT count(*) as 'total_user' FROM tbl_user where status = 1 AND DATE(createdate) = CURDATE();");
?>

<?php
if (mysqli_num_rows($result) > 0) {
  $row = mysqli_fetch_array($result);

  $total_user = $row["total_user"];
              echo "$total_user";                  
                    
}

else 
{
  echo "0";
}
?></h4>

          </div>

      </div>  
  
  <div style="background-color: #A6382B; color: white; padding: 20px; margin: 10px;" class="dashboard_box blue_bg col-md-3 border-radius">

          <div class="title">
            <p class="text-title" style="text-align:left">Today's Recharge</p>
            <h4 class="text-amount" style="text-align:left">₹ <?php



$result = mysqli_query($con,"SELECT  sum(amount) as 'pending' FROM tbl_walletsummery  where actiontype = 'recharge' AND DATE(createdate) = CURDATE();");
?>

<?php
if (mysqli_num_rows($result) > 0) {
  $row = mysqli_fetch_array($result);

  $pending = $row["pending"];
              echo number_format($pending,0);                
                    
}

else 
{
  echo "0";
}
?></h4>

          </div>


      </div>


        <div style="background-color: #A6382B; color: white; padding: 20px; margin: 10px;" class="dashboard_box blue_bg col-md-3 border-radius">


          <div class="title">
            <p class="text-title" style="text-align:left">Today's Withdrawal</p>
            <h4 class="text-amount" style="text-align:left">₹ <?php



$result = mysqli_query($con,"SELECT sum(amount) as 'pending_w' FROM tbl_withdrawal where status = 0 AND DATE(createdate) = CURDATE();");
?>

<?php
if (mysqli_num_rows($result) > 0) {
  $row = mysqli_fetch_array($result);

  $pending_w = $row["pending_w"];
              echo  number_format($pending_w);             
                    
}

else 
{
  echo "0";
}
?></h4>

          </div>


      </div>
        <div style="background-color: #A6382B; color: white; padding: 20px; margin: 10px;" class="dashboard_box blue_bg col-md-3 border-radius">

    


          <div class="title">
            <p class="text-title" style="text-align:left">User Balance</p>
            <h4 class="text-amount" style="text-align:left">₹ <?php



$result = mysqli_query($con,"SELECT sum(amount) as 'wallt' FROM tbl_wallet where amount > 0");
?>

<?php
if (mysqli_num_rows($result) > 0) {
  $row = mysqli_fetch_array($result);

  $zero_bl = $row["wallt"];
              
              
                 echo  number_format($zero_bl,2); 
                    
}

else 
{
  echo "0.00";
}
?></h4>

          </div>

<a href="manage_user.php">
               <div class="panel-footer">
                  <span class="pull-left">See in Detail</span>
                  <span class="pull-right"><i class="fa fa-arrow-circle-right"></i></span>
                  <div class="clearfix"></div>
               </div>
            </a>
      </div>
 

      <!--  <div class="dashboard_box blue_bg col-md-3 border-radius">

          <h4 class="gradiant_bg dashboard_icon" ><i class="fa fa-clone" aria-hidden="true"></i></h4>


          <div class="title">
            <p class="text-title">Zero Balance</p>
            <h4 class="text-amount"><?php



$result = mysqli_query($con,"SELECT count(*) as 'gif' FROM tbl_wallet where amount = 0");
?>

<?php
if (mysqli_num_rows($result) > 0) {
  $row = mysqli_fetch_array($result);

  $zero_bl = $row["gif"];
              echo "$zero_bl";                  
                    
}

else 
{
  echo "0";
}
?></h4>

          </div>


      </div>-->


   <div style="background-color: #A6382B; color: white; padding: 20px; margin: 10px;" class="dashboard_box blue_bg col-md-3 border-radius">



          <div class="title">
            <p class="text-title" style="text-align:left">Total User</p>
            <h4 class="text-amount" style="text-align:left"><?php



$result = mysqli_query($con,"SELECT count(*) as 'total_user' FROM tbl_user where status = 1");
?>

<?php
if (mysqli_num_rows($result) > 0) {
  $row = mysqli_fetch_array($result);

  $total_user = $row["total_user"];
              echo "$total_user";                  
                    
}

else 
{
  echo "0";
}
?></h4>

          </div>

<a href="manage_user.php">
               <div class="panel-footer">
                  <span class="pull-left">See in Detail</span>
                  <span class="pull-right"><i class="fa fa-arrow-circle-right"></i></span>
                  <div class="clearfix"></div>
               </div>
            </a>
      </div>


         <div style="background-color: #A6382B; color: white; padding: 20px; margin: 10px;" class="dashboard_box blue_bg col-md-3 border-radius">


          <div class="title">
            <p class="text-title" style="text-align:left">Pending Recharges</p>
            <h4 class="text-amount" style="text-align:left">₹ <?php



$result = mysqli_query($con,"SELECT  sum(amount) as '2' FROM tbl_recharge  where status = '2'");
?>

<?php
if (mysqli_num_rows($result) > 0) {
  $row = mysqli_fetch_array($result);

  $pending = $row["2"];
              echo  number_format($pending);             
                    
}

else 
{
  echo "0";
}
?></h4>

          </div>

<a href="manage_recharge.php">
               <div class="panel-footer">
                  <span class="pull-left">See in Detail</span>
                  <span class="pull-right"><i class="fa fa-arrow-circle-right"></i></span>
                  <div class="clearfix"></div>
               </div>
            </a>
      </div>

      <div style="background-color: #A6382B; color: white; padding: 20px; margin: 10px;" class="dashboard_box blue_bg col-md-3 border-radius">

          <div class="title">
            <p class="text-title" style="text-align:left">Success Recharge</p>
            <h4 class="text-amount" style="text-align:left">₹ <?php



$result = mysqli_query($con,"SELECT  sum(amount) as 'pending' FROM tbl_walletsummery  where actiontype = 'recharge'");
?>

<?php
if (mysqli_num_rows($result) > 0) {
  $row = mysqli_fetch_array($result);

  $pending = $row["pending"];
              echo number_format($pending,0);                
                    
}

else 
{
  echo "0";
}
?></h4>

          </div>

<a href="approve_recharge.php">
               <div class="panel-footer">
                  <span class="pull-left">See in Detail</span>
                  <span class="pull-right"><i class="fa fa-arrow-circle-right"></i></span>
                  <div class="clearfix"></div>
               </div>
            </a>
      </div>


        <div style="background-color: #A6382B; color: white; padding: 20px; margin: 10px;" class="dashboard_box blue_bg col-md-3 border-radius">


          <div class="title">
            <p class="text-title" style="text-align:left">TOTAL WITHDRAWAL</p>
            <h4 class="text-amount" style="text-align:left">₹ <?php



$result = mysqli_query($con,"SELECT sum(amount) as 'pending_w' FROM tbl_withdrawal where status = 0");
?>

<?php
if (mysqli_num_rows($result) > 0) {
  $row = mysqli_fetch_array($result);

  $pending_w = $row["pending_w"];
              echo  number_format($pending_w);             
                    
}

else 
{
  echo "0";
}
?></h4>

          </div>
<a href="manage_withdrawAccept.php">
               <div class="panel-footer">
                  <span class="pull-left">See in Detail</span>
                  <span class="pull-right"><i class="fa fa-arrow-circle-right"></i></span>
                  <div class="clearfix"></div>
               </div>
            </a>

      </div>


      <div style="background-color: #A6382B; color: white; padding: 20px; margin: 10px;" class="dashboard_box blue_bg col-md-3 border-radius">



          <div class="title">
            <p class="text-title" style="text-align:left">Withdrawal Requests</p>
            <h4 class="text-amount" style="text-align:left">₹ <?php



$result = mysqli_query($con,"SELECT sum(amount) as 'approve_withdrawal' FROM tbl_withdrawal where status = 1");
?>

<?php
if (mysqli_num_rows($result) > 0) {
  $row = mysqli_fetch_array($result);

  $approve_withdrawal = $row["approve_withdrawal"];
              echo  number_format($approve_withdrawal);             
                    
}

else 
{
  echo "0";
}
?></h4>

          </div>

<a href="manage_withdraw.php">
               <div class="panel-footer">
                  <span class="pull-left">See in Detail</span>
                  <span class="pull-right"><i class="fa fa-arrow-circle-right"></i></span>
                  <div class="clearfix"></div>
               </div>
            </a>
      </div>

      

        <!-- ./col -->
        <div style="background-color: #A6382B; color: white; padding: 20px; margin: 10px;" class="dashboard_box blue_bg col-md-3 border-radius">

          <div class="title">
            <p class="text-title" style="text-align:left">Website Mode</p>
           <div style="padding-bottom: 10px;" class="huge">
           <?php

  
 $chkswitchQuery=mysqli_query($con,"select * from `tbl_gamesettings` where `id`='1'");
 $role=mysqli_fetch_array($chkswitchQuery);
 
?>
<?php if($role['settingtype']=='high'){echo"High Profit";}else{echo"Low Profit";}?>
</div></div>
         
<a href="manage_gamewinnersetting.php">
               <div class="panel-footer">
                  <span class="pull-left">See in Detail</span>
                  <span class="pull-right"><i class="fa fa-arrow-circle-right"></i></span>
                  <div class="clearfix"></div>
               </div>
            </a>
      </div>
   <div style="background-color: #A6382B; color: white; padding: 20px; margin: 10px;" class="dashboard_box blue_bg col-md-3 border-radius">

          <div class="title">
            <p class="text-title" style="text-align:left">Withdrawal Status</p>
            <div style="padding-bottom: 10px;" class="huge">
           <?php

  
 $chkswitchQuery=mysqli_query($con,"select * from `tbl_paymentsetting` where `id`='1'");
 $role=mysqli_fetch_array($chkswitchQuery);
 
?>
<?php if($role['withdrawal_status']=='on'){echo"On";}else{echo"Off";}?>
</div></div>
         
<a href="manage_amount.php">
               <div class="panel-footer">
                  <span class="pull-left">See in Detail</span>
                  <span class="pull-right"><i class="fa fa-arrow-circle-right"></i></span>
                  <div class="clearfix"></div>
               </div>
            </a>
      </div>
<div style="background-color: #A6382B; color: white; padding: 20px; margin: 10px;" class="dashboard_box blue_bg col-md-3 border-radius">

        <div class="title">
            <p class="text-title" style="text-align:left">Pending Complaints</p>
          <h4 class="text-amount" style="text-align:left">
                     <?php

	$sql = "SELECT * from `complaint` where `complaint_status`='Under Review'";
	if ($complaint = mysqli_query($con, $sql)) {
	$rowcount1 = mysqli_num_rows( $complaint );
	printf(" %d\n",$rowcount1);
};
?>
</h4>
                  </div>
         
<a href="all_queries.php">
               <div class="panel-footer">
                  <span class="pull-left">See in Detail</span>
                  <span class="pull-right"><i class="fa fa-arrow-circle-right"></i></span>
                  <div class="clearfix"></div>
               </div>
            </a>
      </div> </div>
  </div>

    </section>
        <!-- ./col -->
         <section  class="content">
      <div style="margin-top: -28px;" class="container">
      <!-- Small boxes (Stat box) -->
      <div class="row">
        <div style="background-color: #A6382B; color: white; padding: 20px; margin: 10px;" class="dashboard_box blue_bg col-md-3 border-radius">

        <div class="title">
            <p class="text-title" style="text-align:left">No. of Deposits</p>
               <h4 class="text-amount" style="text-align:left"><?php echo $depositsshow;?></h4>
             
            </div>
          
          </div>
         

          <div style="background-color: #A6382B; color: white; padding: 20px; margin: 10px;" class="dashboard_box blue_bg col-md-3 border-radius">

        <div class="title">
            <p class="text-title" style="text-align:left">No. of Withdrawal</p>
              <h4><?php echo $withdrawalshow;?></h4>
             
            </div>
          
          </div>
         

     
        
           <div style="background-color: #A6382B; color: white; padding: 20px; margin: 10px;" class="dashboard_box blue_bg col-md-3 border-radius">

         <div class="title">
            <p class="text-title" style="text-align:left">Total Earning</p>
              <h4>₹ <?php 
$result = mysqli_query($con,"SELECT sum(amount) as 'wallt' FROM tbl_wallet where amount > 0");

  $row = mysqli_fetch_array($result);

  $zero_bl = $row["wallt"];
  
  $result = mysqli_query($con,"SELECT  sum(amount) as 'pending' FROM tbl_walletsummery  where actiontype = 'recharge'");

  $row = mysqli_fetch_array($result);

  $pending = $row["pending"];
  
  $result = mysqli_query($con,"SELECT sum(amount) as 'pending_w' FROM tbl_withdrawal where status = 0");

  $row = mysqli_fetch_array($result);

  $pending_w = $row["pending_w"];
            
			$total_earning = $pending-$pending_w-$zero_bl;
			
echo  number_format($total_earning);               
                    


?></h4>
             
            </div>
          
          </div>
         
         
        
        
         
         
         
  <div style="background-color: #A6382B; color: white; padding: 20px; margin: 10px;" class="dashboard_box blue_bg col-md-3 border-radius">

         <div class="title">
            <p class="text-title" style="text-align:left">Today Bet Amount</p>
              <h4>₹ <?php 
 $userresult1 = mysqli_query($con , "SELECT sum(amount) as todayamt FROM tbl_userresult WHERE DATE(createdate) = CURDATE(); ");
 
  $row = mysqli_fetch_array($userresult1);
//  echo $row['todayamt'];
  echo number_format($row['todayamt'],2);
  $totalamt =  $row['todayamt'];

  ?></h4>
             
            </div>
          
          </div>
         
      
           <div style="background-color: #A6382B; color: white; padding: 20px; margin: 10px;" class="dashboard_box blue_bg col-md-3 border-radius">

         <div class="title">
            <p class="text-title" style="text-align:left">Today total win</p>
              <h4>₹ <?php 
 $userresult1 = mysqli_query($con , "SELECT sum(amount) as failamtt FROM tbl_walletsummery WHERE DATE(createdate) = CURDATE() AND actiontype ='win'");
 
  $row = mysqli_fetch_array($userresult1);
  $proamt =  $row['failamtt'];
 
  echo number_format($row['failamtt'],2);
  ?>
		</h4>
             
            </div>
          
          </div>
             <div style="background-color: #A6382B; color: white; padding: 20px; margin: 10px;" class="dashboard_box blue_bg col-md-3 border-radius">

         <div class="title">
            <p class="text-title" style="text-align:left">Today Profit </p>
              <h4>₹ <?php 
			  $amount = $totalamt- $proamt; 
			  
			  echo round($amount,2);
  ?>	
		</h4>
             
            </div>
          
          </div>
           <div style="background-color: #A6382B; color: white; padding: 20px; margin: 10px;" class="dashboard_box blue_bg col-md-3 border-radius">

         <div class="title">
            <p class="text-title" style="text-align:left">Level1 Commision</p>
              <h4>₹ <?php

$result = mysqli_query($con,"select sum(`level1`)as 'level' from `tbl_bonus` where level1 > 0");
?>

<?php
if (mysqli_num_rows($result) > 0) {
  $row = mysqli_fetch_array($result);

  $pending = $row["level"];
              echo number_format($pending,0);                
                    
}

else 
{
  echo "0";
}	?>	
		</h4>
             
            </div>
          
          </div>
          
           <div style="background-color: #A6382B; color: white; padding: 20px; margin: 10px;" class="dashboard_box blue_bg col-md-3 border-radius">

         <div class="title">
            <p class="text-title" style="text-align:left">Level2 Commision</p>
              <h4>₹ <?php

$result = mysqli_query($con,"select sum(`level2`)as 'pending' from `tbl_bonus` where level2 > 0");
?>

<?php
if (mysqli_num_rows($result) > 0) {
  $row = mysqli_fetch_array($result);

  $pending = $row["pending"];
              echo number_format($pending,0);                
                    
}

else 
{
  echo "0";
}
?>
		</h4>
             
            </div>
          
          </div>
          
            <div style="background-color: #A6382B; color: white; padding: 20px; margin: 10px;" class="dashboard_box blue_bg col-md-3 border-radius">

         <div class="title">
            <p class="text-title" style="text-align:left">Bonus Wallet</p>
              <h4>₹ <?php



$result = mysqli_query($con,"SELECT  sum(amount) as 'pending' FROM tbl_bonus  where amount > 0");
?>

<?php
if (mysqli_num_rows($result) > 0) {
  $row = mysqli_fetch_array($result);

  $pending = $row["pending"];
              echo number_format($pending,0);                
                    
}

else 
{
  echo "0";
}
?>
		</h4>
             
            </div>
          
          </div>
   </div>
  </div>

    </section>
     

    
    <!-- /.content -->
  </div>
  <!-- /.content-wrapper -->
  <?php include("include/footer.inc.php");?>
<script src="dist/js/pages/dashboard.js"></script>

</div>
<!-- ./wrapper -->


</body>
</html>