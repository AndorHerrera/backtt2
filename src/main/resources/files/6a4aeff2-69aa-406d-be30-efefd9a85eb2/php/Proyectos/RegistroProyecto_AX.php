<?php  

	include '../conf.php';
	include '../util/idSSL.php';

	// Get a connection
	$connection = getConnection();

	// prepare and bind
	$stmt = $connection->prepare("INSERT INTO Proyecto (idProyecto, titulo, descripcion, idUsuario) VALUES (?, ?, ?, ?)");
	$stmt->bind_param("ssss", $idProyecto, $titulo, $descripcion, $idUsuario);

	// Get an ID SSL
	$idProyecto = idSSL(11);

	// Get variables from FORM
	$titulo = $_POST['titulo'];
	$idUsuario = $_POST['responsable']; //Responsable 
	$descripcion = $_POST['descripcion'];
	
	//Result
	if ($stmt->execute()){
		echo 1;
	} else {
		echo -1;
	}

	// Close connection
	closeConnection($stmt);
	closeConnection($connection);

?>