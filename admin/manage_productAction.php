<?php
include('include/connection.php');

if(isset($_POST['type']))
{
	if($_POST['type']=='chk'){

	 $sqlA = "Update `tbl_product` set status = '0' where `id`='".$_POST['id']."' ";
			mysqli_query($con,$sqlA);
}else if($_POST['type']=='unchk') 
{
$time=date( 'Y-m-d H:i:s' );
 $sqlA = "Update `tbl_product` set status = '1' where `id`='".$_POST['id']."' ";
			mysqli_query($con,$sqlA);
	}

else if($_POST['type']=='delete'){	
	$dellid=$_POST['id'];	
$result = "SELECT `images` FROM `tbl_product` where `id`in($dellid)";   
$ress_details=mysqli_query($con,$result);
		$numfeat=mysqli_num_rows($ress_details);

		if($numfeat>'0')
{
	while($rowfeat=mysqli_fetch_array($ress_details))
		{
 $filename=$rowfeat['images'];
unlink( '../lottlucyappadmin/'.$filename);
		}}
			$sqlDel = "Delete from `tbl_product` where `id` in ($dellid) ";
			$querydel=mysqli_query($con,$sqlDel);
			if($querydel){echo "1";}else{echo "0";}
		}	
	}

?>