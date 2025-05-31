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
<title>Adminsuit | Manage Winning Result</title>
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

<!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
<!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
<!--[if lt IE 9]>
  <script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
  <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
  <![endif]-->
<link rel="stylesheet" href="css/app.css" id="maincss">
<link rel="stylesheet" href="css/style.css" id="maincss">
<style>
#overlay {
  position:absolute;
  display: none;
  width: 70%;
  height: 70px;
  top: 0;
  left: 0;
  right: 0;
  bottom: 0;
  background-color: rgba(0,0,0,0.5);
  z-index: 9;
  cursor: pointer;
}
</style>
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
      <h1>Manage Winning Result</h1>
      <ol class="breadcrumb">
        <li><a href="desktop.php"><i class="fa fa-dashboard"></i> Home</a></li>
        <li class="active">Manage Winning Result</li>
      </ol>
    </section>
    
    <!-- Main content -->
    <section class="content">
      <div class="row">
        <div class="col-xs-12">
          <div class="box">
            <div class="box-header box-header2">
<div id="overlay"></div>
              <div class="col-xs-2">
                <div class="gameidtimer"> 
      <h4>Count Down:</br><spam id="demo" class="red_txt"></spam></h4>       
      </div>
              </div>
              <div class="col-xs-3 text-center">
    <h4>Active Period Id:</br> <spam id="activeperiodid" class="text-success"><?php echo sprintf("%03d",gameid($con));?></spam></h4>
    <input type="hidden" name="periodid" id="periodid" value="<?php echo sprintf("%03d",gameid($con));?>">
              </div>
              <?php 
 $chkswitchQuery=mysqli_query($con,"select * from `tbl_manualresultswitch` where `id`='1'");
 $role=mysqli_fetch_array($chkswitchQuery);
 ?>
              <div class="col-xs-4 text-center">
              <h5 class="text-maroon">
             <label>Parity <br><input type="radio" class="tabbtn" name="tab" value="parity" <?php if($role['tab']=='parity'){echo"checked";} ?>></label>&nbsp;&nbsp;&nbsp;&nbsp;
          <label>Sapre <br><input type="radio" class="tabbtn" name="tab" value="sapre" <?php if($role['tab']=='sapre'){echo"checked";} ?>></label>&nbsp;&nbsp;&nbsp;&nbsp;
             <label>Bcone <br><input type="radio" class="tabbtn" name="tab" value="bcone" <?php if($role['tab']=='bcone'){echo"checked";} ?>></label>&nbsp;&nbsp;&nbsp;&nbsp;
             <label>Emerd <br><input type="radio" class="tabbtn" name="tab" value="emerd" <?php if($role['tab']=='emerd'){echo"checked";} ?>></label> 
             <input type="hidden" name="tabtype" id="tabtype" value="<?php echo $role['tab'];?>">
             </h5>
              </div>
              <div class="col-xs-3">
                <div class="main-input pull-right">
 
                    <b>Alert: </b><label style="color: red;">Don't Touch This Button!</label>
                    <div class="mt-0">
                <div class="btn-group btn-group-toggle padd-l-15" data-toggle="buttons">
          <label class="btn btn-secondary <?php if($role['switch']=='yes'){echo"active";} ?>">
          <input class="switchbutton" type="radio" name="switch" id="switchyes" value="yes" <?php if($role['switch']=='yes'){echo"checked";} ?>> Yes </label>
           <label class="btn btn-secondary <?php if($role['switch']=='no'){echo"active";} ?>">
          <input type="radio" class="switchbutton" name="switch" id="switchno" value="no" <?php if($role['switch']=='no'){echo"checked";} ?>> No </label>
                      </div>
                    </div>
                  </div>
              </div>
            </div><br>
             <center><b>Note: </b><label style="color: red;">Don't Close or Change Page After Raising Manual Result, wait For 2:45 Countdown Timer.</label> </center>
            <!-- /.box-header -->
            <div class="box-body">
              <form id="formID" name="formID" method="post" action="#" enctype="multipart/form-data">
                <!--<div class="table-responsive"> -->
                <table id="example1" class="table table-bordered table-striped">
                  <thead>
                    <tr>
                      <th>Result</th>
                      <th>Number</th>
                      <th>No. of User</th>
                      <th>Amount</th>
                      <th>Action</th>
                    </tr>
                  </thead>
                  <tbody id="betdetail">
                    <?php
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
                        &nbsp; <a href="javascript:void(0);" class="update-person" style="color:#f00; font-size:16px;" data-toggle="tooltip" title="Wait..."><i class="fa fa-square-o"></i></a>
                        <?php }?></td>
                    </tr>
                    <?php }?>
                  </tbody>
                </table>
                <!--</div>-->
                <div class="box-header box-header2" style="margin-bottom: 10px;">&nbsp; </div>
                <div class="row">
                  <div class="col-sm-10"></div>
                  <div class="col-sm-2"> &nbsp; </div>
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
  
  <?php include("include/footer.inc.php");?>
</div>
<!-- ./wrapper --> 

<script>
  $(function () {
    $('#example1').DataTable({
      "paging": true,
      "lengthChange": false,
      "searching": false,
      "ordering": false,
      "info": true,
      "autoWidth": true,
	  "pageLength": 15
    });
  });
$(document).ready(function () {
var x = setInterval(function() { 
start_count_down();  
}, 1e3);

$(".switchbutton").change(function(){ //alert($(this).val());
var value=$(this).val();
$.ajax({
   type: "Post",
    data:"value=" + value + "& type=" + "switch" ,
    url: "activePeriodid.php",
    success: function (html){},
});
});

$(".tabbtn").change(function(){ //alert($(this).val());
var value=$(this).val();
document.getElementById("tabtype").value = value;
$.ajax({
   type: "Post",
    data:"value=" + value + "& type=" + "tab" ,
    url: "activePeriodid.php",
    success: function (html){},
});

});
});  
function resettab()
{
$(".tabbtn").prop('checked', false);
$("#tabtype").val('');
var value='';
	$.ajax({
    type: "Post",
    data:"value=" + value + "& type=" + "tabreset" ,
    url: "activePeriodid.php",
    success: function (html){},
});
	}

//====================counter start===================================
function start_count_down() { 
$(".showload").hide();
$(".none").show();
var countDownDate = Date.parse(new Date) / 1e3;
  var now = new Date().getTime();
  var distance = 180 - countDownDate % 180;
  //alert(distance);
  var i = distance / 60,
   n = distance % 60,
   o = n / 10,
   s = n % 10;
  var minutes = Math.floor(i);
  var seconds = ('0'+Math.floor(n)).slice(-2);
  document.getElementById("demo").innerHTML = "<span class='timer'>0"+Math.floor(minutes)+"</span>" + "<span>:</span>" +"<span class='timer'>"+seconds+"</span>";

if(distance==180){
document.getElementById("activeperiodid").innerHTML = 'Wait...';
}
if(distance==166){
getbettingdata('refreshtdata');
}
if(distance==165){
getactivegameid();
$("#switchno").click();
document.getElementById("overlay").style.display = "none";
resettab();
}

if(distance<=180)
{ 
getbettingdata('getdata');
document.getElementById("overlay").style.display = "none";
}
}
//=====================counter end=====================================
function getactivegameid()
{
	$.ajax({
    type: "Post",
    url: "activePeriodid.php",
    success: function (html) {
     //alert(html);
	 document.getElementById("activeperiodid").innerHTML = html;
	 document.getElementById("periodid").value = html;
      return false;
      },
      error: function (e) {}
      });
	}

function getbettingdata(actiontype)
{
var periodid=$("#periodid").val();
var tabtype=$("#tabtype").val();
if ((tabtype)== "")
 {return false;}

	$.ajax({
    type: "Post",
	data:"periodid=" + periodid + "& tabtype=" + tabtype+ "& actiontype=" + actiontype ,
    url: "getbettinguseramount.php",
    success: function (html) {
     //alert(html);
	 document.getElementById("betdetail").innerHTML = html;
      return false;
      },
      error: function (e) {}
      });
	}

</script>

 
<script type="text/javascript">
 function Respond(Id) { 
 var strconfirm = confirm("Are you sure you want to Unpublish?");

           if (strconfirm == true) {
                $("#switchno").click();
               $.ajax({
                   type: "Post",
                  data:"id=" + Id + "& type=" + "chk" ,
                   url: "activePeriodid.php",
                   success: function (html) {
                       //alert(html);
                       //window.location = '';
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
			   $("#switchyes").click();
               $.ajax({
                   type: "Post",
                   data:"id=" + Id + "& type=" + "unchk" ,
                   url: "activePeriodid.php",
                   success: function (html) {
                       if(html==1)
					   {alert("You have allready selected !");}
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
