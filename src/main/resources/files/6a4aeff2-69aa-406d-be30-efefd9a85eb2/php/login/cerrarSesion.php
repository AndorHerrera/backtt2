<?php
	include '../conf.php';
	include 'sesion.php';
	
	if( $_SERVER["REQUEST_METHOD"] == "GET" ) {
		$c_sesion = sanitized_string( $_POST["c_sesion"] );
		
		Sesion::cerrarSesion();	
		Sesion::redirect( Sesion::getURLLogin()."index.html", true );
		echo Sesion::getBaseURL()."index.html";
		
	} else {
		echo -1; //Error
	}

	function sanitized_string( $data ) {
		$data = trim( $data );
		$data = stripslashes( $data );
		$data = htmlspecialchars( $data );

		return $data;
	}

?>
