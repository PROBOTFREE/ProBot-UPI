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
    <title>Adminsuit | Envelope History</title>
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
            <h1>Envelope History</h1>
            <ol class="breadcrumb">
                <li><a href="desktop.php"><i class="fa fa-dashboard"></i> Home</a></li>
                <li class="active">Envelope</li>
            </ol>
        </section>

        <!-- Main content -->
        <section class="content">
            <div class="row">
                <div class="col-xs-12">


                    <div class="box">
                        <div class="box-header box-header2">
                            <div class="col-xs-6 text-right">
                                <h3 class="box-title"><?php
                                    if(isset($_GET['msg'])=="updt")
                                    { ?>
                                        <font size="+1" color="#FF0000">Update Successfully...</font>
                                    <?php  } ?></h3>
                            </div>

                        <!-- /.box-header -->
                        <div class="box-body">
                            <form id="formID" name="formID" method="post" action="#" enctype="multipart/form-data">
                                <!--<div class="table-responsive"> -->
                                <table id="example1" class="table table-bordered table-striped">
                                    <thead>
                                    <tr>

                                        <th>ID</th>
                                        <th>Number</th>
                                        <th>Limit</th>
                                         
                                        <th>Amount</th>
                                      
                                        <th>Link</th>
 <th>Action</th>
                                    </tr>
                                    </thead>
                                    <tbody>
                                    <?php
                                    $Query=mysqli_query($con,"select * from `lifafa` ORDER BY id DESC ");
                                    $i=0;
                                    while($row=mysqli_fetch_array($Query)){$i++;
                                    
 
  ?>

                                        <tr>

                                            <td><?php echo @$row["id"]; ?></td>
                                            <td><?php echo @$row["phone"]; ?></td>
                                            <td><?php echo @$row["tqua"]; ?> Limit / <?php echo @$row["qua"]; ?> Remaining</td>
                                       
                                       
                                            <td><?php  $qantity =   $row['tqua'];
                                                   $amount =   $row['amount'] ;
                                                  $total = $amount*$qantity; echo round($total,2);?> / <?php echo number_format($row["amount"], 2) ?></td>
                                      
                                            <td><?php echo @$row["random"]; ?></td>
                                             <td><button  class="btn copyBtn" data-clipboard-text="https://starwingo.com/lifafa/?reward=<?php echo @$row["random"]; ?>">Copy Link</button>
                                             
                                             
                                             <a href="javascript:void(0);" onClick="delete_row(<?php echo $row['id']; ?>)"  class="update-person" style="background-color:#f56954; color:white; font-size:16px; padding: 7px;" title="Delete">Delete</a></td>
                                             
                                        </tr>
                                    <?php }?>


                                    </tbody>

                                </table>
                                <!--</div>-->
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
            "autoWidth": true
        });
    });
</script>
<script type="text/javascript">
    function delete_row(Id) {
        var strconfirm = confirm("Are You Sure You Want To Delete?");

        if (strconfirm == true) {
            $.ajax({
                type: "Post",
                data:"id=" + Id + "& type=" + "delete" ,
                url: "manage_productAction.php",
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
                url: "manage_productAction.php",
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
                url: "manage_productAction.php",
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
 function delete_row(Id) {
 var strconfirm = confirm("Are You Sure You Want To Delete?");

           if (strconfirm == true) {
               $.ajax({
                   type: "Post",
                  data:"id=" + Id + "& type=" + "delete" ,
                   url: "delete_redenvelope.php",
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
   <script src="https://cdnjs.cloudflare.com/ajax/libs/clipboard.js/2.0.6/clipboard.min.js"></script>
        <script type="text/javascript">
            function showToast(text){
                var ele = document.createElement("div");
                ele.className = "toast";
                ele.innerHTML = text;
                document.body.appendChild(ele);
                setTimeout(function(){
                    document.body.removeChild(ele);
                }, 2000)
            }
            var btns = document.querySelectorAll('.btn');
            var clipboard = new ClipboardJS(btns);
            clipboard.on('success', function(e) {
                showToast("COPY SUCCESS");
            });

            clipboard.on('error', function(e) {
                showToast("COPY FAIL");
            });
            
        </script>
</body>
</html>
