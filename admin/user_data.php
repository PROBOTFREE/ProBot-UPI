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
$sqlCount = "SELECT id FROM tbl_userresult";
$queryCount = mysqli_query($con, $sqlCount);
$totalRecords = mysqli_num_rows($queryCount);
// print_r($totalRecords); exit;

## Total number of record with filtering
$sqlCountSearch = "SELECT id FROM tbl_userresult ".$searchQuery;
$queryCountSearch = mysqli_query($con, $sqlCountSearch);
$totalRecordwithFilter = mysqli_num_rows($queryCountSearch);

## Fetch records
$data = array();
$sql = "SELECT * FROM tbl_userresult ".$searchQuery." ORDER BY id DESC LIMIT ".$rowperpage." OFFSET ".$start; 
// echo $sql;
// exit;
$query = mysqli_query($con, $sql);
$action = '';

while($row = mysqli_fetch_array($query)){
	// echo $row['name']; exit;

	
	$data[] = array( 
		    
            "userid" => $row['userid'],
            "periodid" => $row['periodid'],
            "value" => $row['value'],
            "amount" => $row['amount'],
         
            "fee" => $row['fee'],
            "status" => $row['status'],
            "createdate" => $row['createdate'],
          
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


