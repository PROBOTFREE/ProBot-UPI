<?php
include('include/connection.php');
if(isset($_POST['add_item']))
{
@$particular = mysqli_real_escape_string($con,$_POST['add_item']);
@$roleid = ($_POST['editid']);

$date=date( 'Y-m-d h:i:s' );
if($roleid==''){	
	$filename=$_FILES['material']['name'];
	@$ext = end(explode(".", $filename));
$random_digit=newname();
$new_file_name1=strtolower($random_digit.".".$ext);
		if($filename!=''){
    $filesize=$_FILES['material']['size'];
    $path=$_FILES['material']['tmp_name'];

$des1="../banner/$new_file_name1";
 $des="banner/$new_file_name1";

if(move_uploaded_file($path,$des1))	
		{}
  $sql= "INSERT INTO `banner`(banner_title,material,status) VALUES ('". $particular ."','". $des ."','1')";
$query=mysqli_query($con,$sql);
if($query){
	echo "1";
	}else{ echo"0";}
		}

	
}else{
$filename1=$_FILES['material']['name'];
@$ext1 = end(explode(".", $filename1));
$random_digit122=newname();
$new_file_name12=strtolower($random_digit122.".".$ext1);
    if($filename1!=''){
	$delete = "SELECT `material` FROM `banner` where `id`='".$roleid."'";   
	$ress_details1=mysqli_query($con,$delete);
		$numfeat1=mysqli_num_rows($ress_details1);
		if($numfeat1>'0')
{	$rowfeat1=mysqli_fetch_array($ress_details1);
 $filename1=$rowfeat1['material'];
unlink( '../'.$filename1);
		}
    $filesize1=$_FILES['material']['size'];
    $path111=$_FILES['material']['tmp_name'];

$des111="../banner/$new_file_name12";
$des12="banner/$new_file_name12";

if(move_uploaded_file($path111,$des111))
$sql="update `banner` set `material`='$des12' where `id`='".$roleid."'"; 
						mysqli_query($con,$sql);
}
$role_query=mysqli_query($con,"UPDATE `banner` SET `banner_title`='".$particular."' WHERE `id` ='".$roleid."'");
if($role_query){	
echo"2";}else{ echo"0";}		
	
	}
		
}



if(isset($_POST['type']))
{
	if($_POST['type']=='chk'){

	 $sqlA = "Update `banner` set status = '0' where `id`='".$_POST['id']."' ";
			mysqli_query($con,$sqlA);
}else if($_POST['type']=='unchk') 
{
 $sqlA = "Update `banner` set status = '1' where `id`='".$_POST['id']."' ";
			mysqli_query($con,$sqlA);
	}
	
	
	
else if($_POST['type']=='delete'){	
	$dellid=$_POST['id'];	
$result = "SELECT `material` FROM `banner` where `id`in($dellid)";   
$ress_details=mysqli_query($con,$result);
		$numfeat=mysqli_num_rows($ress_details);

		if($numfeat>'0')
{
	while($rowfeat=mysqli_fetch_array($ress_details))
		{
 $filename=$rowfeat['material'];
unlink( '../'.$filename);
		}}
			$sqlDel = "Delete from `banner` where `id` in ($dellid) ";
			$querydel=mysqli_query($con,$sqlDel);
			if($querydel){echo "1";}else{echo "0";}
		}
	
	}

?>