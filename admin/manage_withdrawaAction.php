<?php
include('include/connection.php');

if(isset($_POST['type']))
{
$id=$_POST['id'];
$today=date( 'Y-m-d H:i:s' );
$actiontype='withdraw~'.$id;	

if($_POST['type']=='accept'){

	 $sqlA = mysqli_query($con,"Update `tbl_withdrawal` set status = '0',createdate = '".$today."' where `id`='".$id."' ");
			
$sqlAA = mysqli_query($con,"Update `tbl_walletsummery` set createdate = '".$today."' where `actiontype`='".$actiontype."' ");

			
}else if($_POST['type']=='reject') 
{
$sqlA = mysqli_query($con,"Update `tbl_withdrawal` set status = '2',createdate = '".$today."' where `id`='".$id."'");
$useridQuery=mysqli_query($con,"select `userid`,`amount` from `tbl_withdrawal` where `id`='".$id."'");
$userResult=mysqli_fetch_array($useridQuery);
$userid=$userResult['userid'];
$amount=$userResult['amount'];
$walletbalance=wallet($con,'amount',$userid);
$finalbalanceCredit=$walletbalance+$amount;	
$sqlwallet= mysqli_query($con,"UPDATE `tbl_wallet` SET `amount` = '$finalbalanceCredit' WHERE `userid`= '$userid'");	

	}


	}

?>