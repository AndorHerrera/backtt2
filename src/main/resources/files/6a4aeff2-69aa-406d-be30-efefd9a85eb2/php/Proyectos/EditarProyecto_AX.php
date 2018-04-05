<?php  
	include '../conf.php';

	// Get a connection
	$connection = getConnection();

	// prepare and bind
	$stmt1 = $connection->prepare("UPDATE Proyecto SET titulo = ?, descripcion = ?, idUsuario = ? WHERE idProyecto = ?");
	$stmt1->bind_param("ssss", $titulo, $descripcion, $idUsuario, $idProyecto);

	// Get variables from FORM
	$titulo = $_POST['tituloEditar'];
	$idUsuario = $_POST['responsableEditar']; //Responsable 
	$descripcion = $_POST['descripcion'];
	$idProyecto = $_POST['idEditarProyecto'];


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