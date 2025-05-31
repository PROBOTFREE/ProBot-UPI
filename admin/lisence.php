<?php
use Mollie\Api\MollieApiClient;
use GuzzleHttp\Client;

$title.= " Integrations";

if( $_SESSION["msmbilisim_userlogin"] != 1  || $user["client_type"] == 1  ){
    Header("Location:".site_url('logout'));
}

if($_SESSION["otp_login"]  == false){
  Header("Location:".site_url('otp_auth'));
}


$integrationsList = $conn->prepare("SELECT * FROM integrations  ");
$integrationsList->execute(array());
$integrationsList = $integrationsList->fetchAll(PDO::FETCH_ASSOC);
foreach ($integrationsList as $index => $integration) {
    $extra = json_decode($integration["method_extras"], true);
    $methoList[$index]["method_name"] = $extra["name"];
    $methoList[$index]["id"] = $integration["id"];
}
$WhatsApp = $conn->prepare("SELECT * FROM integrations WHERE id=:id ");
$WhatsApp->execute(array("id" => 1));
$WhatsApp = $WhatsApp->fetch(PDO::FETCH_ASSOC);
$whatsappnumber = json_decode($WhatsApp['method_extras'], true);
$whatsappnumber = $whatsappnumber["number"];
$whatsappvisibility = json_decode($WhatsApp['method_extras'], true);
$whatsappvisibility = $whatsappvisibility["visibility"];
$whatsappposition = json_decode($WhatsApp['method_extras'], true);
$whatsappposition = $whatsappposition["position"];
                        