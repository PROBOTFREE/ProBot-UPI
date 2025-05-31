<?php 
include("include/connection.php");?>

 <?php
@$periodid=$_POST['periodid'];
@$tab=$_POST['tabtype'];
@$actiontype=$_POST['actiontype'];

if($actiontype=='getdata'){
$Query=mysqli_query($con,"select * from `tbl_manualresult`"); 
  while($row=mysqli_fetch_array($Query)){

if($row['number']==1||$row['number']==3||$row['number']==7||$row['number']==9)	
{//======for green
$totalusernumber=getusercount($con,$periodid,$tab,"'Green',".$row['number']."");

$greentotal=winner($con,$periodid,$tab,'greenwinamount');
$total=$greentotal+winner($con,$periodid,$tab,$numbermappings[$row['number']].'winamount');

}else if($row['number']==2||$row['number']==4||$row['number']==6||$row['number']==8)	
{
$totalusernumber=getusercount($con,$periodid,$tab,"'Red',".$row['number']."");

$redtotal=winner($con,$periodid,$tab,'redwinamount');
$total=$redtotal+winner($con,$periodid,$tab,$numbermappings[$row['number']].'winamount');
	}
else if($row['number']==0)

{
$totalusernumber=getusercount($con,$periodid,$tab,"'Red','Violet',".$row['number']."");	
	
$redtotal=winner($con,$periodid,$tab,'redwinamountwithviolet');
$vtotal=winner($con,$periodid,$tab,'violetwinamount');
$total=$redtotal+$vtotal+winner($con,$periodid,$tab,$numbermappings[$row['number']].'winamount');	
	}
else if($row['number']==5)

{
$totalusernumber=getusercount($con,$periodid,$tab,"'Green','Violet',".$row['number']."");	

$redtotal=winner($con,$periodid,$tab,'greenwinamountwithviolet');
$vtotal=winner($con,$periodid,$tab,'violetwinamount');
$total=$redtotal+$vtotal+winner($con,$periodid,$tab,$numbermappings[$row['number']].'winamount');
	}
	  ?>
                    <tr>
                      <td><?php echo @$row["color"]; ?></td>
                      <td><?php echo $row['number'];?></td>
                      <td><?php echo $totalusernumber;?></td>
                     <td><?php echo number_format($total,2);?></td>
                      <td>
                        <?php 
	  if($row['status']==1){
	  ?>
                        &nbsp; <a href="javascript:void(0);" onClick="Respond(<?php echo $row['id']; ?>)" class="update-person" style="color:#090; font-size:16px;" data-toggle="tooltip" title="Publish"><i class="fa fa-check-square-o"></i></a>
                        <?php } else if($row['status']==0){?>
                        &nbsp; <a href="javascript:void(0);" onClick="UnRespond(<?php echo $row['id']; ?>)" class="update-person" style="color:#f00; font-size:16px;" data-toggle="tooltip" title="Unpublish"><i class="fa fa-square-o"></i></a>
                        <?php }?></td>
                    </tr>
                    
                    
                    <?php }}else if($actiontype=='refreshtdata'){?>
<?php
$sqlA = mysqli_query($con,"Update `tbl_manualresult` set status = '0'");
			
  $Query=mysqli_query($con,"select * from `tbl_manualresult`");
  $i=0; 
  while($row=mysqli_fetch_array($Query)){$i++;?>
                    <tr>
                      <td><?php echo @$row["color"]; ?></td>
                      <td><?php echo $row['number'];?></td>
                      <td class="text-orange">wait..</td>
                     <td class="text-orange">wait..</td>
                      <td>
                        <?php 
	  if($row['status']==1){
	  ?>
                        &nbsp; <a href="javascript:void(0);" class="update-person" style="color:#090; font-size:16px;" data-toggle="tooltip" title="Publish"><i class="fa fa-check-square-o"></i></a>
                        <?php } else if($row['status']==0){?>
                        &nbsp; <a href="javascript:void(0);" class="update-person" style="color:#f00; font-size:16px;" data-toggle="tooltip" title="Wait.."><i class="fa fa-square-o"></i></a>
                        <?php }?></td>
                    </tr>
                    <?php }?>
<?php }?>
