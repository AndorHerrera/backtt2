<?php  
	include '../conf.php';
	
	$connection = getConnection();
	
	$alumnos = $_POST['alumnosAgregar'];
	$status = $_POST['status'];
	$cleanSql = "DELETE FROM ProyectoAlumno WHERE idProyecto = '$status'";			

	// Get a connection

	$contador = 0;

	if ($result = $connection->query($cleanSql)){
		foreach($alumnos as $alumno){
	   		
			$stmt = $connection->prepare("INSERT INTO ProyectoAlumno (idProyecto, alumno, estado, situacion, fechaInicial, fechaFinal) VALUES (?, ?, ?, ?, ?, ?)");
			$stmt->bind_param("sissss", $status, $alumnoRegistrar, $estado, $situacion, $fechaInicial, $fechaFinal);

			$alumnoRegistrar = $alumno;
			$estado = "No validado";
			$situacion = "Sin situacion";
			$fechaInicial = '1900-01-01';
			$fechaFinal = '1900-01-01';
			
			//Result
			if ($stmt->execute()){
				echo 1;
			}

		}
	} else {
		echo -1;
	}

?>