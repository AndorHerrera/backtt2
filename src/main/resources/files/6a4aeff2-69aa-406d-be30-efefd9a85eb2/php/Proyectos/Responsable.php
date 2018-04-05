<?php  

		function getNombreProyecto(){
			
			$idProyecto = $_GET['status'];

			//include 'php/conf.php';

			$connection = getConnection();

			$sqlProyecto = "SELECT p.titulo FROM Usuario u, Proyecto p WHERE u.idUsuario = p.idUsuario AND p.idProyecto='$idProyecto'";

			$resultProyecto = $connection->query($sqlProyecto);
			$rowProyecto = $resultProyecto->fetch_array(MYSQLI_ASSOC);
			$nombreProyecto = $rowProyecto["titulo"];
		

			echo $nombreProyecto;
		
			$resultProyecto->free();
			closeConnection($connection);
		}
	
		function getDescripcion(){
			
			$idProyecto = $_GET['status'];

			//include 'php/conf.php';

			$connection = getConnection();

			$sqlProyecto = "SELECT p.descripcion FROM Usuario u, Proyecto p WHERE u.idUsuario = p.idUsuario AND p.idProyecto='$idProyecto'";

			$resultProyecto = $connection->query($sqlProyecto);
			$rowProyecto = $resultProyecto->fetch_array(MYSQLI_ASSOC);
			$descripcionProyecto = $rowProyecto["descripcion"];
		

			echo $descripcionProyecto;
		
			$resultProyecto->free();
			closeConnection($connection);
		}

		function getResponsable(){
			
			include '../php/conf.php';

			$idProyecto = $_GET['status'];

			$connection = getConnection();

			$sqlProyecto = "SELECT u.nombre, u.aPaterno, u.aMaterno FROM Usuario u, Proyecto p WHERE u.idUsuario = p.idUsuario AND p.idProyecto='$idProyecto'";

			$resultProyecto = $connection->query($sqlProyecto);
			$rowProyecto = $resultProyecto->fetch_array(MYSQLI_ASSOC);
			$nombreResponsable = $rowProyecto["nombre"]." ".$rowProyecto["aPaterno"]." ".$rowProyecto["aMaterno"];
		

			echo $nombreResponsable;
		
			$resultProyecto->free();
			closeConnection($connection);
		}			

?>