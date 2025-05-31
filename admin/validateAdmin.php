<?php 
ob_start();
session_start();
include("include/connection.php");
if(isset($_POST['login'])=="login")
{
    $admin_name=mysqli_real_escape_string($con,$_POST['admin_id' ]);
     $password=mysqli_real_escape_string($con,$_POST['password_admin' ]);

	$sql="select * from `tbl_admin` where `admin_name`='".$admin_name."' and `password`='".md5($password)."' and `status`='1'";
	$result=mysqli_query($con,$sql);
	$num=mysqli_num_rows($result);
	$line=mysqli_fetch_assoc($result);
	if($num>=1)
	{
		
		$userid=$line['id'] ;
		$_SESSION['userid']=$userid;
		$_SESSION['admin_name']=$line['admin_name'];
		$_SESSION['role_id']=$line['role'];
		
		
		header("location:desktop.php");
		exit;
	}
	else
	{
		header("location:index.php?err=ture");
		exit;
	}
}
else
{
	header("location:index.php?err=ture");
	exit;
}
?>