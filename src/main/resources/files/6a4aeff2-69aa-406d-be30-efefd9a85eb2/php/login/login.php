<?php
	include '../conf.php';
	include 'Usuario.php';
	include 'sesion.php';
	
	// define variables and set to empty values
	$email = $password = "";
	
	if( $_SERVER["REQUEST_METHOD"] == "POST" ) {
		$email = sanitized_string( $_POST["email"] );
		$password = sanitized_string( $_POST["password"] );
		
		//Get a conection to the database
		$result = login_compare( $email, $password );
		
		if( $result->num_rows > 0 ) {
			//Almacena los datos del usuario en una variable global.
			$user = getInfoUser( $email, $password );
			Sesion::iniciarSesion( $user );
			echo Sesion::getBaseURL()."/dashboard.php";
			
		} else {
			echo -1; //Error al iniciar sesión. Las credenciales no coinciden.
		}
	}

	function login_compare( $email, $password ) {
		$connection_bd = getConnection();
		$sql = "SELECT email, contrasenia FROM Usuario WHERE email = '".$email."' AND contrasenia = '".$password."'";
		$result = $connection_bd->query( $sql );
		
		//echo $sql."<br>";
		
		return $result;
	}

	function getInfoUser( $email, $password ) {
		$connection_bd = getConnection();
		$sql = "SELECT * FROM Usuario WHERE email = '".$email."' AND contrasenia = '".$password."'";
		$result = $connection_bd->query( $sql );
		$user;
		
		while( $row = $result->fetch_assoc() ) {
			$user = new Usuario( $row["nombre"], $row["idUsuario"], $row["idRol"], $row["idDepartamento"], $row["email"] );
		}
		
		return $user;
	}

	function sanitized_string( $data ) {
		$data = trim( $data );
		$data = stripslashes( $data );
		$data = htmlspecialchars( $data );

		return $data;
	}
?>
