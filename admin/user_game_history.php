<?php 
ob_start();
session_start();
if($_SESSION['userid']=="")
{
	header("location:index.php?msg1=notauthorized");
	exit();
}
	?>
<!DOCTYPE html>
<html>
<head>
  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <title>Admin Panel | User Game History</title>
  <!-- Tell the browser to be responsive to screen width -->
  <meta content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" name="viewport">
  <!-- Bootstrap 3.3.6 -->
  <link rel="stylesheet" href="bootstrap/css/bootstrap.min.css">
  <!-- Font Awesome -->
  <link rel="stylesheet" href="css/font-awesome.min.css">
  <!-- Ionicons -->
  <link rel="stylesheet" href="css/ionicons.min.css">
  <!-- Theme style -->
  <link rel="stylesheet" href="dist/css/AdminLTE.min.css">
  <!-- AdminLTE Skins. Choose a skin from the css/skins
       folder instead of downloading all of them to reduce the load. -->
  <link rel="stylesheet" href="dist/css/skins/_all-skins.min.css">
  <!-- iCheck -->
  <link rel="stylesheet" href="plugins/iCheck/flat/blue.css">
  <!-- Morris chart -->
  <link rel="stylesheet" href="plugins/morris/morris.css">
  <!-- jvectormap -->
  <link rel="stylesheet" href="plugins/jvectormap/jquery-jvectormap-1.2.2.css">
  <!-- Date Picker -->
  <link rel="stylesheet" href="plugins/datepicker/datepicker3.css">
  <!-- Daterange picker -->
  <link rel="stylesheet" href="plugins/daterangepicker/daterangepicker-bs3.css">
  <!-- bootstrap wysihtml5 - text editor -->
  <link rel="stylesheet" href="plugins/bootstrap-wysihtml5/bootstrap3-wysihtml5.min.css">
<link rel="stylesheet" href="plugins/datatables/dataTables.bootstrap.css">
<link rel="stylesheet" href="plugins/select2/select2.min.css">
<link rel="stylesheet" href="plugins/iCheck/all.css">
    <link href="css/custom.css" rel="stylesheet" type="text/css">

<style>
{
  font-family: Arial, Helvetica, sans-serif;
  border-collapse: collapse;
  width: 100%;
}

td, th {
  border: 1px solid #ddd;
  padding: 8px;
}

tr:nth-child(even){background-color: #f2f2f2;}

tr:hover {background-color: #ddd;}

th {
  padding-top: 12px;
  padding-bottom: 12px;
  text-align: left;
  background-color: #04AA6D;
  color: white;
}

table {
  width: 100%;
}


table, th, td {
  border: 1px solid;
}


table,
td {
    border: 1px solid #333;
}




table {
  width: 100%;
}


</style>



  <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
  <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
  <!--[if lt IE 9]>
  <script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
  <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
  <![endif]-->
     <link rel="stylesheet" href="css/app.css" id="maincss">

</head>
<body class="hold-transition skin-red sidebar-mini">
<div class="wrapper">
<?php include ("include/connection.php");?>
<?php include ("include/header.inc.php");?>
  <!-- Left side column. contains the logo and sidebar -->
 <?php include ("include/navigation.inc.php");?> 
  <!-- Content Wrapper. Contains page content -->
  <div class="content-wrapper">
    <!-- Content Header (Page header) -->
   <section class="content-header">
      <h1>User Game History</h1>
      <ol class="breadcrumb">
        <li><a href="desktop.php"><i class="fa fa-dashboard"></i> Home</a></li>
        <li class="active">User Game History</li>
      </ol>
    </section>

    <!-- Main content -->
    <section class="content">
      <div class="row">
        <div class="col-xs-12">
          

          <div class="box">
          
            <!-- /.box-header -->
            <div class="box-body">
  <form id="formID" name="formID" method="post" action="#" enctype="multipart/form-data">
          <div class="table-responsive"> 
              <table id="example1" class="table table-striped">
                 <h4 class="table_bg ">Users Mobile - <?php 

                 $userid =  $_GET['user'];

$user_mobile_number = mysqli_fetch_array(mysqli_query($con,"SELECT * FROM tbl_user where id = '$userid'"));
echo $user_mobile_number['mobile'];
 ?></h4></br>
                <thead>
                <tr>

<th>S.No.</th>
<th>Periodid</th>
<th>Value</th>

<th>Amount</th>
<th>Tab</th>
<th>Paidamount</th>

<th>Fee</th>
<th>Status</th>
<th>Createdate</th>






                </tr>
                </thead>
                <tbody>
     <?php
  $user_game_history=mysqli_query($con,"SELECT * FROM tbl_userresult where userid = '$userid'");
  $i=0; 
  while($row=mysqli_fetch_array($user_game_history)){$i++;?>  
                  <tr>
              <td><?php echo @$i ?></td>
              <td><?php echo $row["periodid"];
              ?></td>
              <td><?php echo @$row["value"]; ?></td>

              

              <td><?php 
              echo number_format($row["amount"],2);             ?></td>
            <td><?php if($row["tab"]=='parity'){echo"Star";}elseif($row["tab"]=='sapre'){echo"Parity";}elseif($row["tab"]=='bcone'){echo"Sapre";}elseif($row["tab"]=='emerd'){echo"Bcone";}?></td>
              <td><?php echo  number_format($row["paidamount"],2); ?></td>



              <td><?php echo number_format($row["fee"],2); ?></td>
            



  <td><?php echo @$row["status"]; ?></td>
    <td><?php echo @$row["createdate"]; ?></td>

  
              
			 
                </tr>
        <?php }?>
               
               
                </tbody>
                
              </table>
             </div>
   <div class="box-header box-header2" style="margin-bottom: 10px;">&nbsp; </div>
<div class="row">              
<div class="col-sm-10"></div>
              <div class="col-sm-2">
               &nbsp;
            </div>
              </div>
              </form>
            </div>
            <!-- /.box-body -->
          </div>
          <!-- /.box -->
        </div>
        <!-- /.col -->
      </div>
      <!-- /.row -->
    </section>
    <!-- /.content -->
  </div>
  <!-- /.content-wrapper -->
  <div id="excel" class="modal fade" role="dialog">
  <div class="modal-dialog modal-sm">
            <div class="modal-content">
              <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                  <span aria-hidden="true">&times;</span></button>
                <h4 class="modal-title" id="chn">Change Amount<br>
<small id="mob"></small></h4>
              </div>
  <form name="type" id="type" enctype="multipart/form-data" action="#" method="post">
              <div class="modal-body">
              
              <div class="form-group ">
                  <label for="add_item">Amount</label>  
   <input class="form-control" id="amount" name="amount" type="text" value="" onkeypress="return isNumber(event)" required>
    <input class="form-control" id="editid" name="editid"  type="hidden">
    <i id="error"></i>
                </div>
            			
              </div>
              <div class="modal-footer">
                
  <button type="submit" class="btn btn-danger" id="add_role">Save</button>
              </div>
              </form>
            </div>
            <!-- /.modal-content -->
          </div>
         
</div>
<?php include("include/footer.inc.php");?></div>
<!-- ./wrapper -->
 

<script>

  $(function () {
    $('#example1').DataTable({
      "paging": true,
      "lengthChange": false,
      "searching": true,
      "ordering": false,
      "info": true,
      "autoWidth": true,
	  "pageLength": 100
    });
  });
</script>
<script type="text/javascript">

function edit(id,mob,balance) {
$('#excel').modal({backdrop: 'static', keyboard: false})   
 $('#excel').modal('show');
 document.getElementById('mob').innerHTML = 'Mobile: '+mob;
 document.getElementById('amount').value = balance;
 document.getElementById('editid').value = id;
}

$(document).ready(function () {
		$("#type").on('submit',(function(e) {
		e.preventDefault();
var quantity = $('input#quantity').val();
if ((quantity)== "") {
            $("input#quantity").focus();
			$('#quantity').css({'border-color': '#f00'});
            return false;}
			
			
		$.ajax({
			type: "POST", 
			url: "updatewalletNow.php",              
			data: new FormData(this), 
			contentType: false,       
			cache: false,             
			processData:false,       

			success: function(html)   
			{ //alert(html);
			if (html == 1) {
			alert("Amount update successfully...");			
            $("#type")[0].reset();
			 $('#excel').modal('hide');
			  window.location ='';
			}
			
			else if(html==0)
			{ alert("Some Technical Error....");		
				}
			
			}
		});
	
	}));
	
	
	
});
</script>
<script type="text/javascript">
 function delete_row(Id) {
 var strconfirm = confirm("Are You Sure You Want To Delete?");

           if (strconfirm == true) {
               $.ajax({
                   type: "Post",
                  data:"id=" + Id + "& type=" + "delete" ,
                   url: "manage_userAction.php",
                   success: function (html) { 
                      if(html==1){
						  alert("Selected Item Deleted Sucessfully....");
                     window.location = '';
					  }
					  else if(html==0){
						  alert("Some Technical Problem");
						  
						  }
                   },
                   error: function (e) {
                   }
               });
           }

       }
</script>
<script type="text/javascript">
 function Respond(Id) {
 var strconfirm = confirm("Are you sure you want to Unpublish?");

           if (strconfirm == true) {
               $.ajax({
                   type: "Post",
                  data:"id=" + Id + "& type=" + "chk" ,
                   url: "manage_userAction.php",
                   success: function (html) {
                       //alert(html);
                       window.location = '';
                       return false;
                   },
                   error: function (e) {
                   }
               });
           }

       }
</script>
<script type="text/javascript">
 function UnRespond(Id) {
           var strconfirm = confirm("Are you sure you want to Publish?");
           if (strconfirm == true) {
               $.ajax({
                   type: "Post",
                   data:"id=" + Id + "& type=" + "unchk" ,
                   url: "manage_userAction.php",
                   success: function (html) {
                       //alert(html);
                    window.location = '';
                       return false;
                   },
                   error: function (e) {
                   }
               });
           }

       }
</script>

</body>
</html>
