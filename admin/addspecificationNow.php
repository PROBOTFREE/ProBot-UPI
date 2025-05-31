<?php
ob_start();
session_start();
include('include/connection.php');
if(isset($_POST['editid']))
{
	
	$testid=$_POST['testid'];

	$title=mysqli_real_escape_string($con,$_POST['title']);;
	$feature=mysqli_real_escape_string($con,$_POST['feature']);;

$editid=$_POST['editid'];
$time=date( 'Y-m-d h:i:s');

if($editid==''){

$sql= "INSERT INTO `tbl_productfeature`(`productid`, `title`, `feature`, `status`) VALUES ('".$testid."','". $title ."','". $feature ."','1')";
$query=mysqli_query($con,$sql);

if($query){
	echo "1";
	}else{ echo"0";}

}else{
	
$role_query=mysqli_query($con,"UPDATE `tbl_productfeature` SET `title`='".$title."',`feature`='".$feature."' WHERE `id` ='".$editid."'");
if($role_query){	
echo"2";}else{ echo"0";}		
	
	}
		
}
if(isset($_POST['type']))
{
	if($_POST['type']=='chk'){

	 $sqlA = "Update `tbl_productfeature` set status = '0' where `id`='".$_POST['id']."' ";
			mysqli_query($con,$sqlA);
}else if($_POST['type']=='unchk') 
{
 $sqlA = "Update `tbl_productfeature` set status = '1' where `id`='".$_POST['id']."' ";
			mysqli_query($con,$sqlA);
	}
	
	
	
else if($_POST['type']=='delete'){	
	$dellid=$_POST['id'];	

			$sqlDel = "Delete from `tbl_productfeature` where `id` in ($dellid) ";
			$querydel=mysqli_query($con,$sqlDel);
			if($querydel){echo "1";}else{echo "0";}
		}
	
	}


?>