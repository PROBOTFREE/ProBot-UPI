<?php
//twice in 1 hour


// Define the base directory constant
define('PROJECT_ROOT', realpath(dirname(__FILE__)) . '/../');

// Securely include files using the PROJECT_ROOT constant
include PROJECT_ROOT . 'pages/dbFunctions.php';
include PROJECT_ROOT . 'auth/config.php';




$cxrurl=$_SERVER["SERVER_NAME"];
// Query to fetch data where status=Active
$sql = "SELECT device_id, pin, number FROM hdfc WHERE status = 'Active'";

// Execute the query
$result = mysqli_query($conn, $sql);

// Check if the query was successful
if ($result) {
    // Fetch the data into variables
    while ($row = mysqli_fetch_assoc($result)) {
        $PIN = $row['pin'];
        $deviceid = $row['device_id'];
        $no = $row['number'];

        $url = "https://{$cxrurl}/HDFCSoft/sesion.php?no=$no&device=$deviceid";
        $responseSEASION = file_get_contents($url);
        $json = json_decode($responseSEASION, true);
        $status = $json["status"];
        $sessionId = $json["sessionId"];
        $loginName = $json["loginName"];
        
        echo "<br>";
        echo "cronjob runned successfully"; //$sessionId we will use this session id to pin.php for vadilate
        echo "<br>";

        $sqlw = "UPDATE hdfc SET seassion='$sessionId' WHERE number='$no'";
        $rod = mysqli_query($conn, $sqlw);

        if ($status == 'Success') {
            $url = "https://{$cxrurl}/HDFCSoft/pin.php?&pin=$PIN&no=$no&sessionid=$sessionId";
            $response = file_get_contents($url);
            $json = json_decode($response, true);
            $status = $json["status"];
            
        }
    }
} else {
    echo "Error: " . mysqli_error($conn);
}

// Close the database connection
mysqli_close($conn);


/*
function todaysDate() {
    $tdate = date("Y-m-d", mktime(0, 0, 0, date("m"), date("d"), date("y")));
    return $tdate;
}
$date=todaysDate();


 $txn_data = file_get_contents('https://couponcart.in/HDFCSoft/miniStatement.php?&count=10&no='.$no.'&tidList='.$dynamicNumber.'&sessionid='.$sessionId.'&startDate='.$date.'&endDate='.$date.''); 
$row = json_decode($txn_data, true);


$upi_id = $row['transactionParams']['merchantVPA'];

echo $upi_id;
*/


?>
