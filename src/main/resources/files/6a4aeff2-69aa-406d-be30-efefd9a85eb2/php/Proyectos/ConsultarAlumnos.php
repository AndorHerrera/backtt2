<?php  
	
	//include '../conf.php'; 


	

	$connection = getConnection();

	$sql = "SELECT boleta, nombre, aPaterno, aMaterno FROM Alumno WHERE boleta NOT IN (SELECT alumno FROM ProyectoAlumno) UNION SELECT a.boleta, a.nombre, a.aPaterno, a.aMaterno FROM Alumno a, ProyectoAlumno pa WHERE a.boleta = pa.alumno AND (pa.estado = 'No validado' OR situacion = 'Cancelado') ORDER BY aPaterno ASC";

	$result = $connection->query($sql);

	if ($_SESSION["rol"] == "Administrador"){
				echo "<form id='formRegistrarAlumnoAdmin'><div class='row'><div class='col-xs-12 col-xs-offset-1 col-xss-12 col-xss-offset-0'><p>Alumno</p><select id='alumnosRegistro' name='boleta' class='selectpicker' style='margin:0px;'>";

				while($row = $result->fetch_array(MYSQLI_ASSOC)){
					$nombreAlumno = $row['nombre']." ".$row['aPaterno']." ".$row['aMaterno'];
					echo "<option value='".$row['boleta']."'>".$nombreAlumno."</option>";
				}

				echo "</select></div></div><br><div class='row'> <div class='col-xs-5 col-xs-offset-1 col-xss-12 col-xss-offset-0'> <p>Estado</p><select name='estadoAlumno' class='selectpicker'> <option value='Validado'>Validado</option> <option value='No validado'>No Validado</option></select></div><div class='col-xs-5 col-xs-offset-1 col-xss-12 col-xss-offset-0'> <p>Situación del Alumno</p><select name='situacionAlumno' class='selectpicker'> <option value='Liberado'>Liberado</option> <option value='Cancelado'>Cancelado</option> <option value='Sin situacion'>Sin situación</option> </select> </div></div><br><div class='row'> <div class='col-xs-5 col-xs-offset-1 col-xss-12 col-xss-offset-0'> <p>Fecha Inicial</p><input type='date' name='fechaInicio'> </div><div class='col-xs-5 col-xs-offset-1 col-xss-12 col-xss-offset-0'> <p>Fecha Final</p><input type='date' name='fechaFin'> </div></div><div class='modal-footer'> <div class='row'> <div class='col-xs-6 col-xs-offset-0 col-xss-12 col-xss-offset-0'> <button id='' class='btn btn_blue btn_250' data-dismiss='modal' go-to=''> Cancelar </button> </div><input type='hidden' id='statusAgregarAlumno' name='status' value=''> <div class='col-xs-6 col-xs-offset-0 col-xss-12 col-xss-offset-0' style='margin-left:-3rem;'> <button onclick='changeRegistrarAlumno();' class='btn btn_blue btn_250' go-to=''>Aceptar</button> </form>";
	} else {
				echo "<form id='formRegistrarAlumnoDocente'> <div class='row'> <div class='col-xs-11 col-xs-offset-1 col-xss-12 col-xss-offset-0'> <select name='alumnosAgregar[]' id='my-select' multiple='multiple'>";

				while($row = $result->fetch_array(MYSQLI_ASSOC)){
					$nombreAlumno = $row['nombre']." ".$row['aPaterno']." ".$row['aMaterno'];
					echo "<option value='".$row['boleta']."'>".$nombreAlumno."</option>";
				}

				echo "</select> </div></div><div class='modal-footer'> <div class='row'> <div class='col-xs-6 col-xs-offset-0 col-xss-12 col-xss-offset-0'> <button id='' class='btn btn_blue btn_250' data-dismiss='modal' go-to=''> Cancelar </button> </div><input type='hidden' id='statusAgregarAlumno' name='status' value=''> <div class='col-xs-6 col-xs-offset-0 col-xss-12 col-xss-offset-0' style='margin-left:-3rem;'> <button onclick='changeRegistrarAlumno();' class='btn btn_blue btn_250' go-to=''>Aceptar</button> </form>";
	}
	
	

	$result->free();

	closeConnection($connection);
?>