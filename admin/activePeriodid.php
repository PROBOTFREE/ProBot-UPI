<?php 
include("include/connection.php");
echo sprintf("%03d",gameid($con));

if(isset($_POST['type']))
{
$today=date('Y-m-d H:i:s');

if($_POST['type']=='switch'){
$value=$_POST['value'];
$sqlA = mysqli_query($con,"Update `tbl_manualresultswitch` set `switch` = '".$value."',`createdate` = '".$today."' where `id`='1'");
}
else if($_POST['type']=='switchhilow'){
$value=$_POST['value'];
$sqlA = mysqli_query($con,"Update `tbl_gamesettings` set `settingtype` = '".$value."',`createdate` = '".$today."' where `id`='1'");
}
else if($_POST['type']=='tab'){
$value=$_POST['value'];
$sqlA = mysqli_query($con,"Update `tbl_manualresultswitch` set `tab` = '".$value."',`createdate` = '".$today."' where `id`='1'");
}
else if($_POST['type']=='tabreset'){
$value=$_POST['value'];
$sqlA = mysqli_query($con,"Update `tbl_manualresultswitch` set `tab` = '".$value."',`createdate` = '".$today."' where `id`='1'");
}

if($_POST['type']=='chk'){

	 $sqlA = "Update `tbl_manualresult` set status = '0' where `id`='".$_POST['id']."' ";
			mysqli_query($con,$sqlA);
}else if($_POST['type']=='unchk') 
{
	$chkresult=mysqli_query($con," select * from `tbl_manualresult` where `status`='1'");
	$chkRows=mysqli_num_rows($chkresult);
	if($chkRows==''){
 $sqlA = "Update `tbl_manualresult` set status = '1' where `id`='".$_POST['id']."' ";
			mysqli_query($con,$sqlA);
	}else{echo"1";}
	}

}

?>