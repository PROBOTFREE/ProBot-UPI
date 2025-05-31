<?php
include('include/connection.php');

if(isset($_POST['type']))
{
	if($_POST['type']=='delete'){	
	$dellid=$_POST['id'];	
			$sqlDel = "Delete from `lifafa` where `id` in ($dellid) ";
			$querydel=mysqli_query($con,$sqlDel);
			if($querydel){echo "1";}else{echo "0";}
		}	
	}

?>