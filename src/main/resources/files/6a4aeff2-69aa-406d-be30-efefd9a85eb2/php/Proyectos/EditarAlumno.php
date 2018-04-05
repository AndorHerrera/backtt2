<?php  
	include '../conf.php';

	// Get a connection
	$connection = getConnection();

	// prepare and bind
	$stmt1 = $connection->prepare("UPDATE ProyectoAlumno SET estado = ?, situacion = ?, fechaInicial = ?, fechaFinal = ? WHERE idProyecto = ? AND alumno = ?");
	$stmt1->bind_param("sssssi", $estado, $situacion, $fechaInicio, $fechaFin, $idProyecto, $idAlumno);


	$situacion = $_POST['situacionAlumno'];
	$estado = $_POST['estadoAlumno'];
	$fechaInicio = $_POST['fechaInicio'];
	$fechaFin = $_POST['fechaFin'];
	$idAlumno = $_POST['idAlumnoEditar'];
	$idProyecto = $_POST['status'];


	//Result
	if ($stmt1->execute()){
		echo 1;
	} else {
		echo -1;
	}

	// Close connection
	closeConnection($stmt1);
	closeConnection($connection);

?>