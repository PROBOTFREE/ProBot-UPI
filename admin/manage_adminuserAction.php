<?php
include('include/connection.php');

if(isset($_POST['type']))
{
	if($_POST['type']=='chk'){

	 $sqlA = "Update `tbl_admin` set status = '0' where `id`='".$_POST['id']."' ";
			mysqli_query($con,$sqlA);
}else if($_POST['type']=='unchk') 
{
 $sqlA = "Update `tbl_admin` set status = '1' where `id`='".$_POST['id']."' ";
			mysqli_query($con,$sqlA);
	}
	
	
	
else if($_POST['type']=='delete'){	
@$id=$_POST['id'];
	$sqlDel = "Delete from `tbl_admin` where `id` in ($id) ";
			$queryDel=mysqli_query($con,$sqlDel);
			if($queryDel){ echo "1";}else{ echo "0";}
}
	
	}

?>