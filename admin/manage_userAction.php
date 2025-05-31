<?php
include('include/connection.php');

if(isset($_POST['type']))
{
	if($_POST['type']=='chk'){

	 $sqlA = "Update `tbl_user` set status = '0' where `id`='".$_POST['id']."' ";
			mysqli_query($con,$sqlA);
}else if($_POST['type']=='unchk') 
{
$time=date( 'Y-m-d H:i:s' );
 $sqlA = "Update `tbl_user` set status = '1' where `id`='".$_POST['id']."' ";
			mysqli_query($con,$sqlA);
	}

else if($_POST['type']=='delete'){	
	$dellid=$_POST['id'];	
			$sqlDel = "Delete from `tbl_user` where `id` in ($dellid) ";
			$querydel=mysqli_query($con,$sqlDel);
			if($querydel){echo "1";}else{echo "0";}
		}	
	}

?>