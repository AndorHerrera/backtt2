<?php	
	class Sesion {
		private static $idSesion = "ssescom_sesion";
		private static $base_url = "http://localhost/SSESCOM_WEB/views";
		private static $base_log = "http://localhost/SSESCOM_WEB/";
		
		private static $usuario = "id_usuario";
		private static $rol = "id_rol";
		private static $depto = "id_depto";
		private static $correo = "email";
	
		public static function iniciarSesion( $user ) {
			session_start();
			
			$_SESSION[ Sesion::$usuario ] = $user->getIdUsuario();
			$_SESSION[ Sesion::$rol ] = $user->getIdRol();
			$_SESSION[ Sesion::$depto ] = $user->getIdDepto();
			$_SESSION[ Sesion::$correo ] = $user->getEmail();
			$_SESSION[ Sesion::$idSesion ] = 1;
		}
	
		public static function cerrarSesion() {
			session_start();
			$_SESSION = [];
			session_destroy();
		}
	
		public static function redirect( $url, $permanent = false ) {
			header( 'Location: ' . $url, true, $permanent ? 301 : 302 );
			exit();
		}
		
		public static function isSessionActive() {
			session_start();
			
			if( $_SESSION[Sesion::$idSesion] == 0 ) {
				Sesion::redirect( Sesion::$base_log."index.html", false );
			}
		}
		
		public static function getBaseURL() {
			return Sesion::$base_url;
		}
		
		public static function getURLLogin() {
			return Sesion::$base_log;
		}
		
		////////////////////////////////////////////
		public static function getIdUsuario() {
			//session_start();
			
			return $_SESSION[ Sesion::$usuario ];
		}
		
		public static function getIdRol() {
			//session_start();
			
			return $_SESSION[ Sesion::$rol ];
		}
		
		public static function getIdDepartamento() {
			//session_start();
			
			return $_SESSION[ Sesion::$depto ];
		}

		public static function getEmail() {
			//session_start();
			
			return $_SESSION[ Sesion::$correo ];
		}
	}
?>
