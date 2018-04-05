<?php  
	
	//include '../php/conf.php'; 

	$connection = getConnection();
	session_start();

	if ($_SESSION["rol"] == "Administrador"){
    	$sql = "SELECT idUsuario, nombre, aPaterno, aMaterno FROM Usuario WHERE idRol != 'Administrador' ORDER BY aPaterno ASC";
		$result = $connection->query($sql);

		while($row = $result->fetch_array(MYSQLI_ASSOC)){
			$nombreResponsable = $row['nombre']." ".$row['aPaterno']." ".$row['aMaterno'];
			echo "<option value='".$row['idUsuario']."'>".$nombreResponsable."</option>";
		}
    } else if ($_SESSION["rol"]=="Jefe de Area"){
               
        $idDepartamento = $_SESSION["idDepartamento"];
        $sql = "SELECT idUsuario, nombre, aPaterno, aMaterno FROM Usuario WHERE idDepartamento = '$idDepartamento' AND idRol != 'Jefe de Area' AND idRol != 'Administrador' ORDER BY aPaterno ASC";
		$result = $connection->query($sql);

		while($row = $result->fetch_array(MYSQLI_ASSOC)){
			$nombreResponsable = $row['nombre']." ".$row['aPaterno']." ".$row['aMaterno'];
			echo "<option value='".$row['idUsuario']."'>".$nombreResponsable."</option>";
		}
    } else {
           echo "<option value='".$_SESSION['idUsuario']."'>docente</option>";
    }

	$result->free();

	closeConnection($connection);
?>
