<?php  

	include '../conf.php';

	$connection = getConnection();

	$proyecto = $_POST['idEliminarProyecto'];

	$sqlProyectoAlumno = "DELETE FROM ProyectoAlumno WHERE idProyecto = '$proyecto'";
	$sqlProyecto = "DELETE FROM Proyecto WHERE idProyecto = '$proyecto'";

	if ($result = $connection->query($sqlProyectoAlumno) && $resulta = $result = $connection->query($sqlProyecto)){
		echo 1;
	} else {
		echo -1;
	}

	//$result->free();
	//$resulta->free();

	closeConnection($connection);

?>