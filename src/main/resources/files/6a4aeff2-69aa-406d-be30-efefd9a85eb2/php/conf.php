<?php
  DEFINE('DB_USERNAME', 'root');
  DEFINE('DB_PASSWORD', 'xBEEWUL0kt26');
  DEFINE('DB_HOST', 'localhost');
  DEFINE('DB_DATABASE', 'ssescom');

  function getConnection(){
  	$mysqli = new mysqli(DB_HOST, DB_USERNAME, DB_PASSWORD, DB_DATABASE);	
  	
	  if (mysqli_connect_error()) {
	    die('Connect Error ('.mysqli_connect_errno().') '.mysqli_connect_error());
	  }

	return $mysqli;
  }

  function closeConnection($connection){
  	$connection->close();
  }
  
?>