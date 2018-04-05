<?php  

	// To refresh content
	if (isset($_GET["direction"])){
		include '../conf.php';
		session_start();
	} else {
		include '../php/conf.php';	
	}

	$connection = getConnection();

	if($_SESSION["rol"] == "Administrador"){
		//Suponiendo que el identificador del Administrador tenga 10 caracteres
		
		$sql = "SELECT p.titulo, p.idProyecto, u.nombre, u.aPaterno, u.aMaterno FROM proyecto p, usuario u WHERE p.idUsuario = u.idUsuario ORDER BY titulo ASC";

		// get and print results
		$result = $connection->query($sql);
		
		if ($result->num_rows > 0){ 
			while ($row = $result->fetch_array(MYSQLI_ASSOC)){
				$nombreResponsable = $row["nombre"]." ".$row["aPaterno"]." ".$row["aMaterno"];
				$nombreAlumno = "";
				$contador = 0;
				
				$id = $row["idProyecto"];

				$sqlProyecto = "SELECT a.nombre, a.aPaterno, a.aMaterno FROM Alumno a, ProyectoAlumno pa WHERE a.boleta = pa.alumno AND pa.idProyecto = '$id' ORDER BY a.aPaterno ASC";
				$resultProyecto = $connection->query($sqlProyecto);

				// Get name of students
				while ($rowProyecto = $resultProyecto->fetch_array(MYSQLI_ASSOC)){
					$nombreAlumno .= $rowProyecto["nombre"]." ".$rowProyecto["aPaterno"]." ".$rowProyecto["aMaterno"]."<br>";
					$contador += 1;
				}

				echo "<tr><td>".$row['titulo']."</td><td>".$nombreResponsable."</td><td>".$nombreAlumno."</td><td>".(3 - $contador)."</td><td><a href=proyectos_detalle.php?status=".$row['idProyecto']."><span class='glyphicon glyphicon-eye-open'></span></a><a href='#' data-toggle='modal' data-target='.editarProyecto' data-backdrop='static' onclick='changeValueEditar(\"".$row['idProyecto']."\")'><span class='glyphicon glyphicon-edit'></span></a><a href='#' data-toggle='modal' data-target='.eliminarProyecto' data-backdrop='static' onclick='changeValueEliminar(\"".$row['idProyecto']."\")'><span class='glyphicon glyphicon-trash'></span></a></td></tr>";

				$nombreAlumno = "";
				$contador = 0;
			}
		} else {
			//Create empty table
			echo '<script type="text/javascript">createEmpty();</script>';
		}

		//$result->free();
		//$resultProyecto->free();


	} else if ($_SESSION["rol"] == "Jefe de Area") {
		//Suponiendo que el identificador del jefe tenga 9 caracteres
		//bien

		$departamentoJefe = $_SESSION["idDepartamento"];

		$sql = "SELECT p.titulo,  p.idProyecto, u.nombre, u.aPaterno, u.aMaterno FROM proyecto p, usuario u, departamento d WHERE u.idUsuario = p.idUsuario AND u.idDepartamento = d.idDepartamento AND u.idDepartamento = '$departamentoJefe' ORDER BY titulo ASC"; 

		 
		// get and print results
		$result = $connection->query($sql);
		
		if ($result->num_rows > 0){
			while ($row = $result->fetch_array(MYSQLI_ASSOC)){
				$nombreResponsable = $row["nombre"]." ".$row["aPaterno"]." ".$row["aMaterno"];
				$nombreAlumno = "";
				$contador = 0;
				
				$id = $row["idProyecto"];

				$sqlProyecto = "SELECT a.nombre, a.aPaterno, a.aMaterno FROM Alumno a, ProyectoAlumno pa WHERE a.boleta = pa.alumno AND pa.idProyecto = '$id' ORDER BY a.aPaterno ASC";
				$resultProyecto = $connection->query($sqlProyecto);

				// Get name of students
				while ($rowProyecto = $resultProyecto->fetch_array(MYSQLI_ASSOC)){
					$nombreAlumno .= $rowProyecto["nombre"]." ".$rowProyecto["aPaterno"]." ".$rowProyecto["aMaterno"]."<br>";
					$contador += 1;
				}
				
				echo "<tr><td>".$row['titulo']."</td><td>".$nombreResponsable."</td><td>".$nombreAlumno."</td><td>".(3 - $contador)."</td><td><a href=proyectos_detalle.php?status=".$row['idProyecto']."><span class='glyphicon glyphicon-eye-open'></span></a><a href='#' data-toggle='modal' data-target='.editarProyecto' data-backdrop='static' onclick='changeValueEditar(\"".$row['idProyecto']."\")'><span class='glyphicon glyphicon-edit'></span></a><a href='#' data-toggle='modal' data-target='.eliminarProyecto' data-backdrop='static' onclick='changeValueEliminar(\"".$row['idProyecto']."\")'><span class='glyphicon glyphicon-trash'></span></a></td></tr>";


				$nombreAlumno = "";
				$contador = 0;
			}	
		} else {
			//Create empty table
			echo '<script type="text/javascript">createEmpty();</script>';
		}

		
	
		//$result->free();
		//$resultProyecto->free();

	} else if ($_SESSION["rol"] == "Docente") {
		//Suponiendo que el identificador del docente tenga 8 caracteres
		//bien		

		$docente = $_SESSION["idUsuario"];

		$sql = "SELECT p.titulo, p.idProyecto, u.nombre, u.aPaterno, u.aMaterno FROM proyecto p, usuario u WHERE p.idUsuario = u.idUsuario AND  p.idUsuario = '$docente' ORDER BY titulo ASC";	

		$result = $connection->query($sql);

		if ($result->num_rows > 0){
			while ($row = $result->fetch_array(MYSQLI_ASSOC)){
				$nombreResponsable = $row["nombre"]." ".$row["aPaterno"]." ".$row["aMaterno"];
				$nombreAlumno = "";
				$contador = 0;
				
				$id = $row["idProyecto"];

				$sqlProyecto = "SELECT a.nombre, a.aPaterno, a.aMaterno FROM Alumno a, ProyectoAlumno pa WHERE a.boleta = pa.alumno AND pa.idProyecto = '$id' ORDER BY a.aPaterno ASC";
				$resultProyecto = $connection->query($sqlProyecto);

				// Get name of students
				while ($rowProyecto = $resultProyecto->fetch_array(MYSQLI_ASSOC)){
					$nombreAlumno .= $rowProyecto["nombre"]." ".$rowProyecto["aPaterno"]." ".$rowProyecto["aMaterno"]."<br>";
					$contador += 1;
				}

				echo "<tr><td>".$row['titulo']."</td><td>".$nombreResponsable."</td><td>".$nombreAlumno."</td><td>".(3 - $contador)."</td><td><a href=proyectos_detalle.php?status=".$row['idProyecto']."><span class='glyphicon glyphicon-eye-open'></span></a><a href='#' data-toggle='modal' data-target='.editarProyecto' data-backdrop='static' onclick='changeValueEditar(\"".$row['idProyecto']."\")'><span class='glyphicon glyphicon-edit'></span></a><a href='#' data-toggle='modal' data-target='.eliminarProyecto' data-backdrop='static' onclick='changeValueEliminar(\"".$row['idProyecto']."\")'><span class='glyphicon glyphicon-trash'></span></a></td></tr>";

				$nombreAlumno = "";
				$contador = 0;
			}	
		} else {
			//Create empty table
			echo '<script type="text/javascript">createEmpty();</script>';
		}

		//$result->free();
		//$resultProyecto->free();

	} else {
		echo "Ha habido un problema con tu sesion...";
	}

	//Clean session
	//session_unset();
	//session_destroy();

	//Close connection
	closeConnection($connection);

?>
