<?php  

	include '../conf.php';

	$connection = getConnection();

	$alumno = $_POST['idEliminarAlumno'];

	if (isset($_GET['status'])){
		$resp = $_GET['status'];
	} else {
		$resp = 1;
	}

	$sqlEliminarAlumno = "DELETE FROM ProyectoAlumno WHERE alumno=$alumno";
	
	if ($result = $connection->query($sqlEliminarAlumno)){
		echo $resp;
	} else {
		echo -1;
	}

	//$result->free();

	closeConnection($connection);

?>