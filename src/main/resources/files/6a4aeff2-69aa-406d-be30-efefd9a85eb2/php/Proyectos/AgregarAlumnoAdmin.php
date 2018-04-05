<?php  
	
	include '../conf.php';
	
	// Get a connection
	$connection = getConnection();

	// prepare and bind
	$stmt2 = $connection->prepare("INSERT INTO ProyectoAlumno VALUES(?,?,?,?,?,?)");
	$stmt2->bind_param("sissss", $status, $boleta, $estadoAlumno, $situacionAlumno, $fechaInicio, $fechaFin);

	$boleta = $_POST['boleta'];
	$estadoAlumno = $_POST['estadoAlumno'];
	$situacionAlumno = $_POST['situacionAlumno'];
	$fechaInicio = $_POST['fechaInicio'];
	$fechaFin = $_POST['fechaFin'];
	$status = $_POST['status'];
	
	//Result
	if ($stmt2->execute()){
		echo 1;
	} else {
		echo -1;
	}

	// Close connection
	closeConnection($stmt2);
	closeConnection($connection);


?>