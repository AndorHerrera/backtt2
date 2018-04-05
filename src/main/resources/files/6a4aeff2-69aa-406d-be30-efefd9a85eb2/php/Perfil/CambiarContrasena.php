<?php 
	include '../conf.php';
	session_start();

	// Get a connection
	$connection = getConnection();
	
	// prepare and bind
	$stmt = $connection->prepare("UPDATE Usuario SET contrasenia = ? WHERE contrasenia = ? and idUsuario = ?");

	$stmt->bind_param("sss", $contrasenaNueva, $contrasenaActual, $status);

	$contrasenaActual = $_POST["contrasenaActual"];
	$contrasenaNueva = $_POST["contrasenaNueva"];
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