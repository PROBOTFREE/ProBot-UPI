<?php 
include("include/connection.php");
$userid=$_POST['userid'];
$oldpassword=md5($_POST['oldpassword']);
$newpassword=$_POST['newpassword'];
$cpassword=$_POST['cpassword'];
$finalnewpassword=md5($newpassword);
if(strlen($newpassword!==$cpassword)){echo "2";}else{
$sql="select * from `tbl_admin` where `id`='".$userid."' and `password`='".$oldpassword."'";
	$result=mysqli_query($con,$sql);
	$num=mysqli_num_rows($result);
	$line=mysqli_fetch_assoc($result);
	if($num!='')
	{
$sql2= "UPDATE `tbl_admin` SET `password`= '".$finalnewpassword."' WHERE `id`='".$userid."'";
$query2=mysqli_query($con,$sql2);

	echo "1";
	
session_start();
session_unset();
session_destroy();
	}
	else
	{
echo "0";
	}
}
	?>