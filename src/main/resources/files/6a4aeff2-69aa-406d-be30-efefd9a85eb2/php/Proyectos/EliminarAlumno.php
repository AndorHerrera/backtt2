<?php  
	include '../conf.php';

	$connection = getConnection();

	$idAlumno = $_POST['idAlumnoEliminar'];

	$sql = "DELETE FROM ProyectoAlumno WHERE alumno = $idAlumno";

	if ($result = $connection->query($sql)){
		echo 1;
	} else {
		echo -1;
	}

	$result->free();
	
	closeConnection($connection);

?>