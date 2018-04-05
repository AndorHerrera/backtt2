<?php 
	include '../conf.php';
	session_start();

	// Get a connection
	$connection = getConnection();
	
	// prepare and bind
	$stmt = $connection->prepare("UPDATE Usuario SET email = ? WHERE idUsuario = ?");

	$stmt->bind_param("ss", $correo, $status);
	$correo = $_POST["correoEditar"];
	$status = $_SESSION["idUsuario"];

	//Result
	if ($stmt->execute()){
		if ($stmt->affected_rows) {
			echo 1;
		} else {
			echo -1;
		}
	} else {
		echo -1;
	}

	closeConnection($stmt);
?>