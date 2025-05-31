<?php 
ob_start();
session_start();
if($_SESSION['userid']=="")
{
header("location:index.php");
exit();
}
include ("include/connection.php"); 


//$strDelIds = $_POST['rid'];
if(@$_POST['type']=='chk'){		
$filename = "User Traded History-".$time=date('d-m-Y');
@$userid = $_POST['userid']; 
@$tabtype = $_POST['tabtype']; 
@$periodid = $_POST['periodid'];     
@$startdate = $_POST['startdate'];
@$enddate = $_POST['enddate'];
$post_date1 = strtotime($startdate);
$convert1=date('Ymd',$post_date1).'001';

$post_date2 = strtotime($enddate);
$convert2=date('Ymd',$post_date2).'480';
 $where='';
 if(@$userid!='')
		{
if($userid=='all'){}else{
	if(@$where=="")
	{
		@$where = $where." WHERE tbl_userresult.`userid` = '$userid' ";
	}
	else
	{
		@$where = $where." AND tbl_userresult.`userid` = '$userid' ";
	}
}
	}
 
 if(@$tabtype!='')
		{
if($tabtype=='all'){}else{
	if(@$where=="")
	{
		@$where = $where." WHERE tbl_userresult.`tab` = '$tabtype' ";
	}
	else
	{
		@$where = $where." AND tbl_userresult.`tab` = '$tabtype' ";
	}
	}
		}
 
 if(@$periodid!='')
		{
	if(@$where=="")
	{
		@$where = $where." WHERE tbl_userresult.`periodid` = '$periodid' ";
	}
	else
	{
		@$where = $where." AND tbl_userresult.`periodid` = '$periodid' ";
	}
	}


	if(@$where=="")
	{
		@$where = $where." WHERE tbl_userresult.`periodid` BETWEEN '$convert1' AND '$convert2'";
	}
	else
	{
		@$where = $where." AND tbl_userresult.`periodid` BETWEEN '$convert1' AND '$convert2'";
	}
 

$sql = "select tbl_user.`id`,tbl_user.`mobile`,tbl_user.`code`,tbl_user.`owncode`,DATE_FORMAT(tbl_userresult.`createdate`, '%d-%b-%Y')as `createdate`,tbl_userresult.`periodid`,tbl_userresult.tab,tbl_userresult.amount,tbl_userresult.`value`,tbl_result.`result`,tbl_result.`color`,
CASE WHEN tbl_userresult.`status`='success' THEN
            'Win'
         ELSE
            'Lose'
    END 
,tbl_userresult.`paidamount` from `tbl_userresult` 
INNER JOIN tbl_user
ON tbl_user.id = tbl_userresult.userid
INNER JOIN tbl_result
ON tbl_result.`periodid` = tbl_userresult.`periodid` and tbl_result.`tabtype`=tbl_userresult.tab".$where;
 
$result = @mysqli_query($con,$sql) or die("Couldn't execute query:<br>" . mysqli_error($con). "<br>" . mysqli_errno($con));
$numrows=mysqli_num_rows($result);
if($numrows==''){echo"2";}else{  
echo"1";	
}
	
		}else{			

		
$filename = "User Traded History-".$time=date('d-m-Y');
@$userid = $_GET['userid']; 
@$tabtype = $_GET['tabtype']; 
@$periodid = $_GET['periodid'];     
@$startdate = $_GET['startdate'];
@$enddate = $_GET['enddate'];
$post_date1 = strtotime($startdate);
$convert1=date('Ymd',$post_date1).'001';
//$convert1='20210208001';
$post_date2 = strtotime($enddate);
$convert2=date('Ymd',$post_date2).'480';
  //$convert2='20210208480';
 $where='';
 if(@$userid!='')
		{
if($userid=='all'){}else{
	if(@$where=="")
	{
		@$where = $where." WHERE tbl_userresult.`userid` = '$userid' ";
	}
	else
	{
		@$where = $where." AND tbl_userresult.`userid` = '$userid' ";
	}
}
	}
 
 if(@$tabtype!='')
		{
if($tabtype=='all'){}else{
	if(@$where=="")
	{
		@$where = $where." WHERE tbl_userresult.`tab` = '$tabtype' ";
	}
	else
	{
		@$where = $where." AND tbl_userresult.`tab` = '$tabtype' ";
	}
	}
		}
 
 if(@$periodid!='')
		{
	if(@$where=="")
	{
		@$where = $where." WHERE tbl_userresult.`periodid` = '$periodid' ";
	}
	else
	{
		@$where = $where." AND tbl_userresult.`periodid` = '$periodid' ";
	}
	}


	if(@$where=="")
	{
		@$where = $where." WHERE tbl_userresult.`periodid` BETWEEN '$convert1' AND '$convert2'";
	}
	else
	{
		@$where = $where." AND tbl_userresult.`periodid` BETWEEN '$convert1' AND '$convert2'";
	}
 

$sql = "select tbl_user.`id`,tbl_user.`mobile`,tbl_user.`code`,tbl_user.`owncode`,DATE_FORMAT(tbl_userresult.`createdate`, '%d-%b-%Y')as `createdate`,tbl_userresult.`periodid`,tbl_userresult.tab,tbl_userresult.amount,tbl_userresult.`value`,tbl_result.`result`,tbl_result.`color`,
CASE WHEN tbl_userresult.`status`='success' THEN
            'Win'
         ELSE
            'Lose'
    END 
,tbl_userresult.`paidamount` from `tbl_userresult` 
INNER JOIN tbl_user
ON tbl_user.id = tbl_userresult.userid
INNER JOIN tbl_result
ON tbl_result.`periodid` = tbl_userresult.`periodid` and tbl_result.`tabtype`=tbl_userresult.tab".$where;
 
$result = @mysqli_query($con,$sql) or die("Couldn't execute query:<br>" . mysqli_error($con). "<br>" . mysqli_errno($con));
$numrows=mysqli_num_rows($result);
if($numrows==''){echo"2";}else{  

$result = @mysqli_query($con,$sql) or die("Couldn't execute query:<br>" . mysqli_error($con). "<br>" . mysqli_errno($con));
$numrows=mysqli_num_rows($result);
if($numrows==''){echo"2";}else{ 
 
$file_ending = "xls";
header("Content-type: application/octet-stream");
header("Content-Disposition: attachment; filename=$filename.xls");  
header("Pragma: no-cache"); 
header("Expires: 0");
$sep = "\t"; //tabbed character
//for ($i = 0; $i < mysqli_num_fields($result); $i++) {
//$colObj = (mysqli_fetch_field_direct($result,$i)) . "\t";
//$col = $colObj->name;
//echo $col;
//}
echo 'User Id' . "\t";
echo 'Mobile number'. "\t";
echo 'Referral code' . "\t";
echo 'Own code' . "\t";
echo 'Date' . "\t";
echo 'Traded Period' . "\t";
echo 'Game Space' . "\t";
echo 'Traded Amount' . "\t";
echo 'Select' . "\t";
echo 'Result' . "\t";
echo 'Color' . "\t";
echo 'Status' . "\t";
echo 'Trading Amount Status' . "\t";
print("\n");    
    while($row = mysqli_fetch_row($result))
	
    {
		
        $schema_insert = "";
        for($j=0; $j<mysqli_num_fields($result);$j++)
        {
			if($row[$j]==''){$schema_insert .= "".$sep;}
            elseif(!isset($row[$j]))
                $schema_insert .= "NULL".$sep;
            elseif ($row[$j] != "")
                $schema_insert .= "$row[$j]".$sep;
            else
                $schema_insert .= "".$sep;
        }
        $schema_insert = str_replace($sep."$", "", ucwords($schema_insert));
        $schema_insert = preg_replace("/\r\n|\n\r|\n|\r/", " ", ucwords($schema_insert));
        $schema_insert .= "\t";
        echo ((ucwords($schema_insert)));
        print "\n";
    }
			
}
	
}
	
				
		
		
		}

?>