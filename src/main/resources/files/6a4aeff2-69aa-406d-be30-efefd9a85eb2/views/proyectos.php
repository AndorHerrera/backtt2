<?php
	include "../php/login/sesion.php";	
	
	Sesion::isSessionActive();
    $_SESSION["rol"] = Sesion::getIdRol();
    $_SESSION["idUsuario"] = Sesion::getIdUsuario();
    $_SESSION["idDepartamento"] = Sesion::getIdDepartamento();
?>
<!DOCTYPE html>
<html lang="es">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <title>SSEscom</title>

    <!-- CSS -->
    <link rel="stylesheet" type="text/css" href="../assets/css/bootstrap.min.css">
    <link rel="stylesheet" type="text/css" href="../assets/css/datatables.min.css">
    <link rel="stylesheet" type="text/css" href="../assets/css/animate.css">
    <link rel="stylesheet" type="text/css" href="../assets/css/hover.css">
    <link rel="stylesheet" type="text/css" href="../assets/css/styles.css">
    <link rel="stylesheet" type="text/css" href="../assets/css/styles_responsive.css">
    <link rel="stylesheet" type="text/css" href="../assets/css/bootstrap-select.min.css">
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
                        <li class="menu_txt">
                            <a href="dashboard.php">
                                <span class="glyphicon glyphicon-dashboard"></span> Dashboard</a>
                        </li>
                        <li class="menu_txt active">
                            <a href="proyectos.php">
                                <span class="glyphicon glyphicon-briefcase"></span> Proyectos</a>
                        </li>
                        <li class="menu_txt">
                            <a href="docentes.php">
                                <span class="glyphicon glyphicon-education"></span> Docentes</a>
                        </li>
                        <li class="menu_txt">
                            <a href="alumnos.php">
                                <span class="glyphicon glyphicon-apple"></span> Alumnos</a>
                        </li>
                        <li class="menu_txt">
                            <a href="perfil.php">
                                <span class="glyphicon glyphicon-user"></span> Perfil</a>
                        </li>
                        <hr class="divisor_cerrar_sesion">
                        <li>
                            <a class="menu_txt" href="../php/login/cerrarSesion.php">
                                <span class="glyphicon glyphicon-log-out"></span> Cerrar sesión</a>
                        </li>
                    </ul>
                </div>
            </div>
        </nav>

        <div class="container_SSEscom">
            <section class="main col-xs-12">
                <div id="container_block" class="col-xs-12">
                    <div class="cabecera_btn">
                        <h1 id="titulo_seccion" class="navy_blue animated fadeInDown">Proyectos</h1>
                        <a class="btn_new Bold col-xss-12 animated zoomIn" data-toggle="modal" data-target=".nuevoProyecto" data-backdrop="static" onclick="modalNuevo()">Nuevo proyecto</a>
                    </div>
                    <div id="tabla_dashboard" class="white_bg col-xs-12 noPadding">
                        <div class="panel-body">
                            <div class="capa_table table-responsive col-xs-12">
                                <table id="proyectos_table" class="display translateTable" cellspacing="0" width="100%">
                                    <thead>
                                        <tr>
                                            <th>Titulo</th>
                                            <th>Responsable</th>
                                            <th>Alumnos</th>
                                            <th>Lugares disponibles</th>
                                            <th>Acciones</th>
                                        </tr>
                                    </thead>
                                    <tbody id="datat">
                                        <!-- Data from DB-->
                                        <?php  include '../php/Proyectos/ConsultarProyectos_AX.php'; ?>
                                    </tbody>
                                </table>
                            </div>
                        </div>
                    </div>
                </div>
            </section>
        </div>
    </div>



    <!-- Modal Nuevo proyecto -->
	<div class="modal fade nuevoProyecto" tabindex="-1" role="dialog" aria-labelledby="nuevoProyecto">
		<div class="modal-dialog modal-md" role="document">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close azul_color" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
					<h4 id="tituloModal" class="modal-title navy_blue">Nuevo Proyecto</h4>
				</div>
				
                <!-- Inicio Formulario 'Nuevo proyecto'-->
                <form data-parsley-validate="" id="formNewProject">
                    <div class="modal-body"> 
                        <div class="col-xs-10 col-xs-offset-1 col-xss-12 col-xss-offset-0 noPadding listado">
    						<div class="col-xss-12 capa_input">
    							<p class="navy_blue">Titulo</p>
    							<input type="text" name="titulo" data-parsley-trigger="keyup" data-parsley-maxlength="70" required="">                    
    						</div>
    					
                            <div class="row">
                                <br><div class="col-xs-5 col-xs-offset-0 col-xss-12 col-xss-offset-0">
                                    <p>Responsable:</p>
                                    <select name="responsable" id="roles" class="selectpicker" style="margin:0px;">
                                        <?php include '../php/Proyectos/mostrarResponsables.php';?>
                                    </select>
                                </div>
                            </div>

    						<div class="col-xss-12 capa_input">
    							<br><p class="navy_blue">Descripción</p>
    							<textarea name="descripcion" class="textAreaForm" data-parsley-trigger="keyup" data-parsley-maxlength="120" required=""></textarea>
    						</div>
    					</div>				
    				</div>
    				<div class="modal-footer">
    					<!-- <button id="" class="btn btn_disabled btn_250" go-to="">Crear</button> -->
    						 <button id="" class="btn btn_blue btn_250 actionButton" go-to="" type="submit">Crear</button> 
    				</div>
                </form>
                <!-- Fin Formulario 'Nuevo proyecto'-->
			</div>
		</div>
	</div>
	<!-- Fin de Modal Nuevo proyecto -->

    <!-- Modal Editar Proyecto -->
    <div class="modal fade editarProyecto" tabindex="-1" role="dialog" aria-labelledby="editarProyecto">
        <div class="modal-dialog modal-md" role="document">
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close azul_color" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                    <h4 id="tituloModal" class="modal-title navy_blue">Editar Proyecto</h4>
                </div>
                
                <!-- Inicio Formulario 'Editar proyecto'-->
                <form data-parsley-validate="" id="formEditarProyecto">
                    <div class="modal-body"> 
                        <div class="col-xs-10 col-xs-offset-1 col-xss-12 col-xss-offset-0 noPadding listado">
                            <div class="col-xss-12 capa_input">
                                <p class="navy_blue">Titulo</p>
                                <input type="text" name="tituloEditar" data-parsley-trigger="keyup" data-parsley-maxlength="70" required="">                    
                            </div>
                             <div class="row">
                                <br><div class="col-xs-5 col-xs-offset-0 col-xss-12 col-xss-offset-0">
                                    <p>Responsable:</p>
                                    <select name="responsable" id="roles" class="selectpicker" style="margin:0px;">
                                        <?php include '../php/Proyectos/mostrarResponsables.php';?>
                                    </select>
                                </div>
                            </div>
                            <div class="col-xss-12 capa_input">
                                <br><p class="navy_blue">Descripción</p>
                                <textarea name="descripcion" class="textAreaForm" data-parsley-trigger="keyup" data-parsley-maxlength="120" required=""></textarea>
                            </div>
                        </div>              
                    </div>
                    <input type="hidden" id="idEditarProyecto" name="idEditarProyecto" value="">
                    <div class="modal-footer">
                        <!-- <button id="" class="btn btn_disabled btn_250" go-to="">Crear</button> -->
                             <button id="" class="btn btn_blue btn_250 actionButton" go-to="" type="submit">Editar</button> 
                    </div>
                </form>
                <!-- Fin Formulario 'Editar proyecto'-->
            </div>
        </div>
    </div>
    <!-- Fin de Modal Editar Proyecto -->

	
    <!-- Modal eliminar proyecto -->
    <div class="modal fade eliminarProyecto" tabindex="-1" role="dialog" aria-labelledby="eliminarProyecto">
        <div class="modal-dialog modal-md" role="document">
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close azul_color" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                    <h4 class="modal-title navy_blue">Eliminar Proyecto</h4>
                </div>
                <div class="modal-body">
                    <div class="col-xs-10 col-xs-offset-1 col-xss-12 col-xss-offset-0 noPadding listado">

                        <p>¿Estás seguro de querer eliminar el proyecto? Una vez realizado no se podrá revertir</p>
                    <!--<p>No se puede eliminar el proyecto porque tiene alumnos asociados, por favor elimine a los alumnos del proyecto e intente de nuevo.</p> -->
                    </div>
                </div>
                <div class="modal-footer">
                         
                        <form id="formEliminarProyeto">
                            <input type="hidden" id="idEliminarProyecto" name="idEliminarProyecto" value="">
                            <button id="" class="btn btn_disabled btn_small" data-dismiss="modal">Cancelar</button>
                            <button type="submit" class="btn btn_blue btn_small" go-to="">Eliminar</button>
                        </form>
                        
                </div>
            </div>
        </div>
    </div>
    <!-- Fin de Modal Eliminar Proyecto  -->

</body>

<!-- JS -->
<script type="text/javascript" src="../assets/js/jquery-3.2.1.min.js"></script>
<script type="text/javascript" src="../assets/js/parsley.js"></script>
<script type="text/javascript" src="../assets/js/jquery.dataTables.min.js"></script>
<script type="text/javascript" src="../assets/js/bootstrap.min.js"></script>
<script type="text/javascript" src="../assets/js/translateTable.js"></script>
<script type="text/javascript" src="../assets/js/bootstrap-select.min.js"></script>


<!-- AJAX -->
<script type="text/javascript" src="../assets/js/AX/Proyecto_AX.js"></script>


<!-- Functions-->
<script type="text/javascript" src="../assets/js/AX/ProyectoFunctions.js"></script>



</html>
