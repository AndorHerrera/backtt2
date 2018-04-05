<?php 
	
		$idProyecto = $_GET['status'];
		
		// To refresh content
		if (isset($_GET["direction"])){
			include '../conf.php';
			session_start();	
		} else {
			//include '../php/conf.php';	
		}

		//sanitized String
		$idProyecto = trim($idProyecto);
		$idProyecto = stripslashes($idProyecto);
		$idProyecto = htmlspecialchars($idProyecto); 

		$connection = getConnection();
		
		// Obtener Alumnos y detalle

		$sql = "SELECT a.boleta, a.nombre, a.aPaterno, a.aMaterno, pa.estado, pa.situacion, pa.fechaInicial, pa.fechaFinal FROM Alumno a, ProyectoAlumno pa WHERE a.boleta = pa.alumno AND pa.idProyecto = '$idProyecto' ORDER BY a.aPaterno ASC";

		
		$result = $connection->query($sql);

		if ($result->num_rows > 0){
			
			if ($_SESSION["rol"] == "Administrador"){

				while ($row = $result->fetch_array(MYSQLI_ASSOC)){
				
					$nombre = $row["nombre"]." ".$row["aPaterno"]." ".$row["aMaterno"];

					echo "<tr><td>".$row['boleta']."</td><td>".$nombre."</td><td>".$row["fechaInicial"]."</td><td>".$row["fechaFinal"]."</td><td>".$row["estado"]."</td><td>".$row["situacion"]."</td><td>

					<a href='#' onclick='changeValueEditarAlumno(\"".$row['boleta']."\"); changeValueStatus();'><span class='glyphicon glyphicon-edit' data-toggle='modal' data-target='.editarAlumno' data-backdrop='static'></span></a>

					<a href='#' onclick='changeValueEditar(\"".$row['boleta']."\")'><span class='glyphicon glyphicon-trash' data-toggle='modal' data-target='.eliminarAlumno' data-backdrop='static'></span></a>
					</td></tr>";
				}

			} else {
				while ($row = $result->fetch_array(MYSQLI_ASSOC)){
				
					$nombre = $row["nombre"]." ".$row["aPaterno"]." ".$row["aMaterno"];

					echo "<tr><td>".$row['boleta']."</td><td>".$nombre."</td><td>".$row["fechaInicial"]."</td><td>".$row["fechaFinal"]."</td><td>".$row["estado"]."</td><td>".$row["situacion"]."</td><td><a href='#' onclick='changeValueEditar(\"".$row['boleta']."\")'><span class='glyphicon glyphicon-trash' data-toggle='modal' data-target='.eliminarAlumno' data-backdrop='static'></span></a></td></tr>";
				}
			}
		} else {
			echo '<script type="text/javascript">createEmpty();</script>';
		}	
		$result->free();
	
		closeConnection($connection);
	
?>
