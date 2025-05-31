<?php



$title .= "Blogs";


if( !route(1) ){

  
  

}elseif( route(1) && preg_replace('/[^a-zA-Z]/', '', route(1))  ){
$templateDir  = "blogpost";
  $templateDir  = $templateDir;

$blog = route(1);
  if (!countRow(['table' => 'blogs', 'where' => ['blog_get' => $blog, 'status' => "1" ]])) {
   
header("Location:".site_url("blog"));
} 
$id = route(2);
  $blogDetail = $conn->prepare("UPDATE blogs SET status=:status WHERE id=:id ");
  $blogDetail-> execute(array("status"=>1, "id"=> $id));
  $blogDetail = $blogDetail->fetch(PDO::FETCH_ASSOC);
  
    }





