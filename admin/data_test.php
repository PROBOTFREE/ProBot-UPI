<?php

include ("include/connection.php");

$postData = $_POST;

## Read value
$draw = $postData['draw'];
$start = $postData['start'];
$rowperpage = $postData['length']; // Rows display per page
$columnIndex = $postData['order'][0]['column']; // Column index
$columnName = $postData['columns'][$columnIndex]['data']; // Column name
$columnSortOrder = $postData['order'][0]['dir']; // asc or desc
$searchValue = $postData['search']['value']; // Search value

## Search 
$searchQuery = "";
if($searchValue != ''){
	$searchQuery = "WHERE 1 AND (id like '%".$searchValue."%' or mobile like '%".$searchValue."%' or email like '%".$searchValue."%' or owncode like '%".$searchValue."%' or code like '%".$searchValue."%' or createdate like '%".$searchValue."%') ";
}else{
	$searchQuery = "WHERE 1";
}

## Total number of records without filtering
$sqlCount = "SELECT id FROM tbl_user";
$queryCount = mysqli_query($con, $sqlCount);
$totalRecords = mysqli_num_rows($queryCount);
// print_r($totalRecords); exit;

## Total number of record with filtering
$sqlCountSearch = "SELECT id FROM tbl_user ".$searchQuery;
$queryCountSearch = mysqli_query($con, $sqlCountSearch);
$totalRecordwithFilter = mysqli_num_rows($queryCountSearch);

## Fetch records
$data = array();
$sql = "SELECT * FROM tbl_user ".$searchQuery." ORDER BY id DESC LIMIT ".$rowperpage." OFFSET ".$start; 
// echo $sql;
// exit;
$query = mysqli_query($con, $sql);
$action = '';

while($row = mysqli_fetch_array($query)){
	// echo $row['name']; exit;
	$id = $row['id'];
		$username = $row['username'];
	$wallet = wallet($con,'amount',$id);
	$walletAction = '<a href="javascript:void(0);" onClick="edit('.$id.','.$row['mobile'].','.$wallet.')" class="text-aqua" title="Delete"><i class="fa fa-edit"></i></a>';
	$wallet = number_format($wallet,2).$walletAction;
	
	$totalrecharge=mysqli_query($con,"select sum(`amount`)as total from  `tbl_walletsummery` where `userid`='".$row["id"]."' and `actiontype`='recharge'");
	$totalResult=mysqli_fetch_array($totalrecharge);
	$recharge = number_format($totalResult['total'],2);
	
	$totalreward=mysqli_query($con,"select sum(`amount`)as total from  `tbl_walletsummery` where `userid`='".$row["id"]."' and `actiontype`='reward'");
	$totalResult=mysqli_fetch_array($totalreward);
	$reward = number_format($totalResult['total'],2);
	
	
	 $totalwithdrawal=mysqli_query($con,"select sum(`amount`)as total from  `tbl_withdrawal` where status = 0 and `userid`='".$row["id"]."'");
	$totalResult=mysqli_fetch_array($totalwithdrawal);
	$withdrawal = number_format($totalResult['total'],2);
	
	  $total_refer = mysqli_query(mysqli_query($con,"SELECT count(id) as total FROM `tbl_user` where code = '".$owncode."'"));
	  	$totalResult=mysqli_fetch_array($total_refer);
$refer = number_format($totalResult['total'],1); 
	
		$total_bonus =mysqli_query($con,"select sum(`level1`)as total from `tbl_bonus` where level1 > 0 AND userid = '".$row["id"]."'");
	$totalResult=mysqli_fetch_array($total_bonus);
$totalResultl1 = number_format($totalResult['total'],1); 


			  	$total_bonus1 =mysqli_query($con,"select sum(`level2`)as total from `tbl_bonus` where level2 > 0 AND userid = '".$row["id"]."'");
	$totalResult=mysqli_fetch_array($total_bonus1);
$totalResultl2 =  number_format($totalResult['total'],1); 


   $total_bonus = mysqli_query($con,"SELECT sum(amount) as total FROM `tbl_bonus` where amount > 0 AND userid = '".$row["id"]."'");
		$totalResult=mysqli_fetch_array($total_bonus);
$totalbonus =  number_format($totalResult['total'],1);
	
	
	if($row['status']==1){
        $del = '<a href="javascript:void(0);" onClick="Respond('.$id.')" class="update-person" style="color:#090; font-size:16px;" data-toggle="tooltip" title="Publish"><i class="fa fa-check-square-o"></i></a>';
    } else if($row['status']==0){
        $del = '<a href="javascript:void(0);" onClick="UnRespond('.$id.')" class="update-person" style="color:#f00; font-size:16px;" data-toggle="tooltip" title="Unpublish"><i class="fa fa-square-o"></i></a>';
    }
	
	$action =  '<a href="javascript:void(0);" onClick="delete_row('.$id.')" class="update-person" style="color:#f56954; font-size:16px;" title="Delete"><i class="fa fa-trash"></i></a>'.$del.'
	
			 <a href="edit_user_info.php?user='.$id.'"  class="update-person" style="color:#0E0E44; font-size:16px;" data-toggle="tooltip" title="Edit"><i class="fa fa-edit"></i></a>
       <a href="user-details.php?user='.$id.'"  class="update-person" style="color:#0E0E44; font-size:16px;" data-toggle="tooltip" title="Edit"><i class="fa fa-info"></i></a>
       &nbsp;  <a href="user_game_history.php?user='.$id.'"  class="update-person" style="color:#E9D94F; font-size:16px;" data-toggle="tooltip" title="History"><i class="fa fa-history"></i></a>';    
       
	
	$data[] = array( 
		    "id" => $id,
		      "username" => $row['username'],
            "mobile" => $row['mobile'],
            "email" => $row['email'],
            "owncode" => $row['owncode'],
            "code" => $row['code'],
            "wallet" => $wallet,
            "recharge" => $recharge,
            "reward" => $reward,
             "withdrawal" => $withdrawal,
              "reffer" => $refer,
             "bonusl1" => $totalResultl1,
             "bonusl2" => $totalResultl2,
             "bonus" => $totalbonus,
            "createdate" => $row['createdate'],
            "action" => $action,
		); 
}

## Response
$response = array(
	"draw" => intval($draw),
	"iTotalRecords" => $totalRecords,
	"iTotalDisplayRecords" => $totalRecordwithFilter,
	"data" => $data
	);

echo json_encode($response); exit;

// print_r(json_encode($response)); exit;
// return json_encode($response); 


