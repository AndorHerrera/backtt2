<?php  
	
	//include 'php/conf.php'; 

	$connection = getConnection();

	$sql = "SELECT boleta, nombre, aPaterno, aMaterno FROM Alumno" ORDER BY aPaterno ASC;
	$result = $connection->query($sql);
	
	while($row = $result->fetch_array(MYSQLI_ASSOC)){
		$nombreAlumno = $row['nombre']." ".$row['aPaterno']." ".$row['aMaterno'];
		echo "<option value='".$row['boleta']."'>".$nombreAlumno."</option>";
	}

	$result->free();

	closeConnection($connection);
?>