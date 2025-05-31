<?php 
ob_start();
session_start();
if($_SESSION['userid']=="")
{
	header("location:index.php");
	exit();
}
include ("include/connection.php");
if(isset($_POST['Action'])){

	$name=mysqli_real_escape_string($con,$_POST['name']);
	$price=mysqli_real_escape_string($con,$_POST['price']);

	$time=date( 'M jS, Y / H:i A' );	
	$default_status=1;
	if(isset($_POST['Action'])=="Submit"){
	
	$filename=$_FILES['images']['name'];
	@$ext = end(explode(".", $filename));
$random_digit=newname();
$new_file_name1=$random_digit.".".$ext;
		if($filename!=''){
    $filesize=$_FILES['images']['size'];
    $path=$_FILES['images']['tmp_name'];

$des1="../product/$new_file_name1";
 $des="product/$new_file_name1";

if(move_uploaded_file($path,$des1))	
		{}
		}


 $sql= "INSERT INTO `tbl_product`(`name`,`price`,`images`,`status`) VALUES ('".$name."','".$price."','".$des."','1')";
$query=mysqli_query($con,$sql);
if($query){
	header("location:add_product.php?msg=updt");
	}exit();
	
	
	} 
		
}	?>
<!DOCTYPE html>
<html>
<head>
  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <title>Adminsuit | Product</title>
  <meta content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" name="viewport">
  <link rel="stylesheet" href="bootstrap/css/bootstrap.min.css">
  <link rel="stylesheet" href="css/font-awesome.min.css">
  <link rel="stylesheet" href="css/ionicons.min.css">
  <link rel="stylesheet" href="dist/css/AdminLTE.min.css">
  <link rel="stylesheet" href="dist/css/skins/_all-skins.min.css">
  <link rel="stylesheet" href="plugins/iCheck/flat/blue.css">
  <link rel="stylesheet" href="plugins/morris/morris.css">
  <link rel="stylesheet" href="plugins/jvectormap/jquery-jvectormap-1.2.2.css">
  <link rel="stylesheet" href="plugins/datepicker/datepicker3.css">
  <link rel="stylesheet" href="plugins/daterangepicker/daterangepicker-bs3.css">
    <link rel="stylesheet" href="plugins/timepicker/bootstrap-timepicker.min.css">

  <link rel="stylesheet" href="plugins/bootstrap-wysihtml5/bootstrap3-wysihtml5.min.css">
<link rel="stylesheet" href="plugins/datatables/dataTables.bootstrap.css">
<link rel="stylesheet" href="plugins/select2/select2.min.css">
<link rel="stylesheet" href="plugins/iCheck/all.css">

  <!--[if lt IE 9]>
  <script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
  <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
  <![endif]-->
  <link rel="stylesheet" href="css/style.css">
  <link rel="stylesheet" href="css/app.css" id="maincss">

</head>
<body class="hold-transition skin-red sidebar-mini">
<div class="wrapper">
<?php include ("include/header.inc.php");?>
 <?php include ("include/navigation.inc.php");?>
   <div class="content-wrapper">
    <section class="content-header">
      <h1>Add Product</h1>
      <ol class="breadcrumb">
    <li><a href="manage_product.php"><i class="fa fa-dashboard"></i> Manage Product</a></li>
     <li class="active">Add Product</li>
      </ol>
    </section>

    <!-- Main content -->
    <section class="content">
      <div class="row">
        <div class="col-xs-12">
          

          <div class="box">
            <div class="box-header box-header2">
             <div class="col-xs-12 text-center">
         <h3 class="box-title">
		 <?php 
				if((@$_GET['msg'])=="updt") 
				{ ?>
              <font size="+1" color="#FF0000">Save Successfully......</font>
              <?php  } ?></h3></div>
              
            </div>
            <!-- /.box-header -->
            
      <form id="addblog" name="formID" method="post" action="<?php echo $_SERVER['PHP_SELF'];?>" enctype="multipart/form-data">
      <div class="col-sm-10 col-xs-offset-1">
            <div class="box-body">
           
                <div class="clearfix"></div>
                <div class="col-md-12 col-sm-6 col-xs-12">
                  <div class="form-group">
                  <label for="name">Description<span>*</span></label>
   <textarea class="form-control" id="name" name="name" type="text" value="" required style="height:100px;"></textarea>
                </div>
                </div>
                 <div class="col-md-12 col-sm-6 col-xs-12">
                  <div class="form-group">
                  <label for="price">Price <span>*</span></label>
    <input class="form-control"  id="price" name="price" type="text" value="" required>
         
                </div>
                </div> 
                 
                
                <div class="col-md-12 col-sm-6 col-xs-12">
                  <div class="form-group">
                  <label for="images">Image <span>*</span> <span style="color:#f00;">Size(1500x1500)</span></label>
         <input class="form-control"  id="images" name="images" type="file" value="" required>
         
                </div>
                </div>
                
                
            
             <div class="clearfix"></div> 
             
              <div class="form-group">
              <div class="text-center">
  <button type="reset" class="btn btn-default" onClick="location.href='manage_product.php'">Cancel</button>
 <input type="submit" id="" name="Action" class="btn btn-primary" value="Submit"></div>
                </div> 
               </div>
               
               </div>
                <div class="clearfix"></div> 
          </form>
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
  
<?php  include("include/footer.inc.php");?></div>
<script type="text/javascript" src="ckeditor/ckeditor.js"></script>
<script type="text/javascript">
		CKEDITOR.replace( 'detail',
				{
				fontSize_sizes : "8/80%;9/90%;10/100%;12/120%;14/135%;16/160%;18/180%;20/200%;24/240%;26/260%;28/280%;36/360%;48/480%;72/650%;",
					toolbar :
					[
						['Source','Undo','Redo','Table'],
						['Bold', 'Italic','Underline'],
						['JustifyLeft','-','JustifyCenter'],
						['JustifyRight','-','JustifyBlock'],
['NumberedList','BulletedList','-','Blockquote','-','Outdent','Indent'],
					['Link', 'Unlink', 'Image', '-','SpecialChar'],
					['Find','-','SelectAll','RemoveFormat'],
						
				['Styles','Format','Font','FontSize' ],['TextColor'],
					],
					// Strip CKEditor smileys to those commonly used in BBCode.	
			//uiColor: 'orange'		
		} );
		
		
			
	</script>

 

</body>
</html>
