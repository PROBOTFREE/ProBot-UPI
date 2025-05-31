<?php

include "include/connection.php"; // Using database connection file here

$id = $_GET['id']; // get id through query string

$qry = mysqli_query($db,"select * from tblemp where id='$id'"); // select query

$data = mysqli_fetch_array($qry); // fetch data

if(isset($_POST['update'])) // when click on Update button
{
    $amount = $_POST['amount'];
    
	
    $edit = mysqli_query($db,"update tblemp set amount='$amount where id='$id'");
	
    if($edit)
    {
        mysqli_close($db); // Close connection
        header("manage_user.php"); // redirects to all records page
        exit;
    }
    else
    {
        echo mysqli_error();
    }    	
}
?>

<h3>Update Data</h3>

<form method="POST">
  <input type="text" name="tbl_wallet" value="<?php echo $data['tbl_wallet'] ?>" placeholder="Change Balance" Required>
  
  <input type="submit" name="update" value="Update">
</form>