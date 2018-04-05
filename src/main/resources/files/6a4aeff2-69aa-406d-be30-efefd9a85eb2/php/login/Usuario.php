<?php
	
	class Usuario {		
		private $nombre;
		private $id_usuario;
		private $id_rol;
		private $id_depto;
		private $email;
		
		function __construct( $nombre, $id_usuario, $id_rol, $id_depto, $email ) {
			$this->nombre = $nombre;
			$this->id_usuario = $id_usuario;
			$this->id_rol = $id_rol;
			$this->id_depto = $id_depto;
			$this->email = $email;
		}
		
		function __construct1() {
			$this->nombre = "";
			$this->id_usuario = "";
			$this->id_rol = "";
			$this->id_depto = "";
			$this->email= "";
		}
		
		public function getNombre() {
			return $this->nombre;
		}
		
		public function setNombre( $nombre ) {
			$this->nombre = $nombre;
		}
		
		public function getIdUsuario() {
			return $this->id_usuario;
		}
		
		public function setIdUsuario( $id_usuario ) {
			$this->id_usuario = $id_usuario;
		}
		
		public function getIdRol() {
			return $this->id_rol;
		}
		
		public function setIdRol( $id_rol ) {
			$this->id_rol = $id_rol;
		}
		
		public function getIdDepto() {
			return $this->id_depto;
		}
		
		public function setIdDepto( $id_depto ) {
			$this->id_depto = $id_depto;
		}

		public function getEmail() {
			return $this->email;
		}
		
		public function setEmail( $id_depto ) {
			$this->id_depto = $email;
		}
	}
?>
