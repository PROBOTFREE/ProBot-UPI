<?php
header("Access-Control-Allow-Origin: *");
header("Content-Type: application/json; charset=utf-8");
$sql = new Sql();
$query = "SELECT * FROM items";
$items = $sql->getItems($query);
exit(json_encode($items));