<?php


$url = $_SERVER["SERVER_NAME"];
$dab = "$url[0]$url[1]$url[2]$url[3]$url[4]" ; 
		$mysqli = new mysqli(
			"localhost",
			"Panels_$dab",
			"Panels_$dab",
			"Panels_$dab"
		);
		$query = file_get_contents('smmclick1.sql');
		$mysqli->multi_query($query);
		$mysqli->close();
		
		
