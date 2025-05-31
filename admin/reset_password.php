<?php 
include("include/connection.php");
$userid=$_POST['puserid'];
$newpassword=$_POST['nnewpassword'];
$cpassword=$_POST['ccpassword'];
$finalnewpassword=md5($newpassword);
if(strlen($newpassword!==$cpassword)){echo "2";}else{
$sql2= "UPDATE `tbl_admin` SET `password`= '".$finalnewpassword."' WHERE `id`='".$userid."'";
$query2=mysqli_query($con,$sql2);

	echo "1";
}
	?>