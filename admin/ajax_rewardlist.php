<?php
include ("include/connection.php");
if($_POST['id'])
{

$id=$_POST['id'];

$sql=mysqli_query($con,"select * from `tbl_reward` where `userid` ='".$id."'");
$rows=mysqli_num_rows($sql);
if($rows!=''){
?>
<div class="col-xs-12 text-center">
<h4>Reward History</h4>
<table class="table table-bordered table-striped text-center">
    <tr>
        <th>Amount</th>
        <th>Date</th>
    </tr>
<?php
while($row=mysqli_fetch_array($sql))
{
$id=$row['id'];
?>
<tr>
    <td><?php echo $row['amount']; ?></td>
    <td><?php echo @date('d-m-Y', strtotime($row['createdate']));?></td>
    </tr>
<?php }?>
</table>
</div>
<?php 
}else{
$id='0';
$data='Nothing found...';
?>
<div class="col-xs-12 text-center">
<h4>Reward History</h4>
<table class="table table-bordered table-striped text center">
    <tr><td colspan="2"><?php echo $data;?></td></tr>
</table>
</div>
<?php
}
}
?>