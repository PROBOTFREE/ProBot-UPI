<?php
include('include/connection.php');
if(isset($_POST['editid']))
{
@$amount = mysqli_real_escape_string($con,$_POST['amount']);
@$roleid = ($_POST['editid']);

$date=date( 'Y-m-d h:i:s' );


$role_query=mysqli_query($con,"UPDATE `tbl_wallet` SET `amount`='".$amount."' WHERE `userid` ='".$roleid."'");
if($role_query){	
echo"1";}else{ echo"0";}		
	
	}
		

?>