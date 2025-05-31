<?php
include("include/connection.php");
if($_POST['type']=='roleedit'){
$id=$_POST['id'];
  $department_query=mysqli_query($con,"select * from `role` where `id`='".$id."'");
  $department_result=mysqli_fetch_array($department_query);
   echo $SocietyDepartmentName=$department_result['role'];
}
?>