<?php
	include "../php/login/sesion.php"; 
  
  Sesion::isSessionActive();
  $_SESSION["rol"] = Sesion::getIdRol();
  $_SESSION["idUsuario"] = Sesion::getIdUsuario();
  $_SESSION["idDepartamento"] = Sesion::getIdDepartamento();
  $_SESSION["email"] = Sesion::getEmail();
?>
<!DOCTYPE html>
<html lang="es">
<head>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
	<title>SSEscom</title>

	<!-- CSS -->
	<link rel="stylesheet" type="text/css" href="../assets/css/bootstrap.min.css">
	<link rel="stylesheet" type="text/css" href="../assets/css/datatables.min.css"/>
	<link rel="stylesheet" type="text/css" href="../assets/css/styles.css">
	<link rel="stylesheet" type="text/css" href="../assets/css/styles_responsive.css">
</head>
<body>
	<div id="Proyectos" class="container">
		<nav class="navbar navbar-default nav_SSEscom">
			<div class="container-fluid">

				<div class="navbar-header">
					<button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1" aria-expanded="false">
						<span class="sr-only">Toggle navigation</span>
						<span class="icon-bar"></span>
						<span class="icon-bar"></span>
						<span class="icon-bar"></span>
					</button>
					<div class="capa_logo navbar-brand">
						<h2>SSEscom</h2>
					</div>
				</div>

				<div class="collapse navbar-collapse capa_menu" id="bs-example-navbar-collapse-1">
					<ul class="nav navbar-nav">
						<li class="menu_txt"><a href="dashboard.php">
							<span class="glyphicon glyphicon-dashboard"></span> Dashboard</a>
						</li>
						<li class="menu_txt"><a href="proyectos.php">
							<span class="glyphicon glyphicon-briefcase"></span> Proyectos</a>
						</li>
						<li class="menu_txt"><a href="docentes.php">
							<span class="glyphicon glyphicon-education"></span> Docentes</a></li>
						<li class="menu_txt"><a href="alumnos.php">
							<span class="glyphicon glyphicon-apple"></span> Alumnos</a></li>
						<li class="menu_txt active"><a href="perfil.php">
							<span class="glyphicon glyphicon-user"></span> Perfil</a>
						</li>
						<hr class="divisor_cerrar_sesion">
						<li><a class="menu_txt" href="../php/login/cerrarSesion.php">
							<span class="glyphicon glyphicon-log-out"></span> Cerrar sesión</a></li>
					</ul>
				</div>
			</div>
		</nav>



		<div class="container_SSEscom">
			<section class="main col-xs-12">
				<div id="container_block" class="col-xs-12">
					<h1 id="titulo_seccion" class="navy_blue">Perfil</h1>

				</div>
        <div id="tabla_dashboard" class="white_bg col-xs-12 noPadding">
          <div class="row">
            <div class="col-xs-12 col-xs-offset-1">
              <h1>Datos de la cuenta</h1>
            </div>
          </div>
          <div class="row">
            <div class="col-xs-6" style="text-align: right;">
              <h4><b>Tipo de Cuenta:</b></h4>
            </div>
            <div class="col-xs-6">
              <h4><?php  echo $_SESSION["rol"]; ?></h4>
            </div>
          </div>
          <div class="row">
            <div class="col-xs-6" style="text-align: right;">
              <h4><b>Correo Electrónico:</b></h4>
            </div>
            <div class="col-xs-6">
              <h4><?php echo $_SESSION["email"]; ?>
                <a href="" data-toggle="modal" data-target=".cambiaCorreo" data-backdrop="static">
                  <span class="glyphicon glyphicon-edit"></span>
                </a>
              </h4>
            </div>
          </div>
          <div class="row">
            <div class="col-xs-6" style="text-align: right;">
              <h4><b>Contraseña:</b></h4>
            </div>
            <div class="col-xs-6">
              <h4>************
                <a href="" data-toggle="modal" data-target=".cambiaPassword" data-backdrop="static">
                  <span class="glyphicon glyphicon-edit"></span>
                </a>
              </h4>
            </div>
          </div>
        </div>

        <div id="tabla_dashboard" class="white_bg col-xs-12 noPadding">
          <div class="row">
            <div class="col-xs-12 col-xs-offset-1">
              <br><br>
              <h5>
                En caso de haber olvidado tu contraseña puedes reestablecerla enviándote un
                correo de recuperación
              </h5>
              <br><br>
              <a class="btn_new Bold col-xss-12" href="#" data-toggle="modal" data-target=".agregarDocente" data-backdrop="static">
                Enviar correo de recuperación
              </a>
              <br><br>
            </div>
          </div>
        </div>


			</section>

		</div>
	</div>

  <!-- **************************** M O D A L S ******************************************** -->
  <!-- ************* MODAL Cambiar Password-->
    <div class="modal fade cambiaPassword" tabindex="-1" role="dialog" aria-labelledby="cambiaPassword">
        <div class="modal-dialog modal-md" role="document" style="height: 20%;">
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button"
                            class="close azul_color"
                            data-dismiss="modal"
                            aria-label="Close">
                      <span aria-hidden="true">&times;</span>
                    </button>
                    <h4 class="modal-title navy_blue" id="addTeacher">Cambia Password</h4>
                </div>
                <div class="modal-body">
                    <div class="row">
            <div class="col-xs-12 col-xs-offset-1">
              <h1>Datos de la cuenta</h1>
            </div>
          </div>
          <div class="row">
            <div class="col-xs-6" style="text-align: right;">
              <h4><b>Tipo de Cuenta:</b></h4>
            </div>
            <div class="col-xs-6">
              <h4><?php echo $_SESSION["rol"]; ?></h4>
            </div>
          </div>
          <div class="row">
            <div class="col-xs-6" style="text-align: right;">
              <h4><b>Contraseña Actual:</b></h4>
            </div>
            <div class="col-xs-6">
              <form data-parsley-validate="" id="formCambiarContrasena">
              <h4><input type="password" data-parsley-maxlength="100" id="contrasenaActual" data-parsley-trigger="keyup" data-parsley-minlength="8" name="contrasenaActual" required="">

              </h4>
            </div>
          </div>
          <div class="row">
            <div class="col-xs-6" style="text-align: right;">
              <h4><b>Nueva Contraseña:</b></h4>
            </div>
            <div class="col-xs-6">
              <h4><input type="password" data-parsley-maxlength="100" id="contrasenaNueva" data-parsley-trigger="keyup" data-parsley-minlength="8" name="contrasenaNueva" required="">
              </h4>
            </div>
          </div>
          <div class="row">
            <div class="col-xs-6" style="text-align: right;">
              <h4><b>Confirmar Contraseña:</b></h4>
            </div>
            <div class="col-xs-6">
              <h4>
                <input type="password" data-parsley-equalto="#contrasenaNueva" id="contrasenaConfirmar" data-parsley-trigger="keyup" name="contrasenaConfirmar" value="" required="">
              </h4>
            </div>
          </div>
                </div>

                <div class="modal-footer">
                  <div class="row">
                    <div class="col-xs-6 col-xs-offset-0 col-xss-12 col-xss-offset-0"
                         style="margin-left: -20px;">
                      <button id="cancel" class="btn btn_blue btn_250" data-dismiss="modal" aria-label="Close">Cancelar</button>
                    </div>
                    <div class="col-xs-5 col-xs-offset-0 col-xss-12 col-xss-offset-0">
                      <button type="submit" id="agregar" class="btn btn_blue btn_250" aria-label="Close">Guardar</button>
                      </form>
                    </div>
                  </div>
                </div>
            </div>
        </div>
    </div>
    <!-- ********Fin Modal Cambiar Password********************************* -->
    
    <!-- ************* MODAL Cambiar Correo-->
    <div class="modal fade cambiaCorreo" tabindex="-1" role="dialog" aria-labelledby="cambiaCorreo">
        <div class="modal-dialog modal-md" role="document" style="height: 20%;">
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button"
                            class="close azul_color"
                            data-dismiss="modal"
                            aria-label="Close">
                      <span aria-hidden="true">&times;</span>
                    </button>
                    <h4 class="modal-title navy_blue" id="addTeacher">Cambia Correo</h4>
                </div>
                <div class="modal-body">
                    <div class="row">
            <div class="col-xs-12 col-xs-offset-1">
              <h1>Datos de la cuenta</h1>
            </div>
          </div>
          <div class="row">
            <div class="col-xs-6" style="text-align: right;">
              <h4><b>Tipo de Cuenta:</b></h4>
            </div>
            <div class="col-xs-6">
              <h4><?php echo $_SESSION["rol"]; ?></h4>
            </div>
          </div>
          <div class="row">
            <div class="col-xs-6" style="text-align: right;">
              <h4><b>Correo Electrónico:</b></h4>
            </div>
            <div class="col-xs-6">
              <h4><?php echo $_SESSION["email"]; ?>
                <!--a>
                  <span class="glyphicon glyphicon-edit"></span>
                </a-->
              </h4>
            </div>
          </div>
          <div class="row">
            <div class="col-xs-6" style="text-align: right;">
              <h4><b>Confirmar Correo:</b></h4>
            </div>
            <div class="col-xs-6">
              <h4>

        
                <form data-parsley-validate="" id="formCambiarCorreo">
                  <input type="email" id="correoEditar" name="correoEditar" placeholder="correo@dominio.com" required="" data-parsley-trigger="keyup" data-parsley-maxlength="100">
                  
                        <!--a >
                          <span class="glyphicon glyphicon-edit"></span>
                        </a-->
                      </h4>
                    </div>
                  </div>
                      </div>
                <div class="modal-footer">
                  <div class="row">
                    <div class="col-xs-6 col-xs-offset-0 col-xss-12 col-xss-offset-0"
                         style="margin-left: -20px;">
                      <button id="cancel" class="btn btn_blue btn_250" data-dismiss="modal" aria-label="Close">Cancelar</button>
                    </div>
                    <div class="col-xs-5 col-xs-offset-0 col-xss-12 col-xss-offset-0">
                      <button type="submit" id="agregar" class="btn btn_blue btn_250" aria-label="Close">Aceptar</button>

                    

                </form>
                    </div>
                  </div>
                </div>
            </div>
        </div>
    </div>
    <!-- ********   Fin Modal Cambiar Correo********************************* -->
  
  
</body>
	<!-- JS -->
	<script type="text/javascript" src="../assets/js/jquery-3.2.1.min.js"></script>
	<script type="text/javascript" src="../assets/js/bootstrap.min.js"></script>
  <script type="text/javascript" src="../assets/js/parsley.js"></script>

  <!-- AJAX -->
  <script type="text/javascript" src="../assets/js/AX/Proyecto_AX.js"></script>

  <script>
    var instance = $('#contrasenaNueva').parsley();
    var instance = $('#contrasenaConfirmar').parsley();
    
  </script>

</html>
