<?php  
	include "../php/login/sesion.php";
	
	Sesion::isSessionActive();
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
                        <h1 id="titulo_seccion" class="navy_blue animated fadeInDown">Responsable - <span id="responsable"><?php include '../php/Proyectos/Responsable.php'; getResponsable();?></span>
                        </h1>
                        <a class="btn_new Bold col-xss-12 animated zoomIn" data-toggle="modal" data-target=".nuevoProyecto" data-backdrop="static">Nuevo proyecto</a>
                    </div>


                        <!-- Contenedor tabla y cabecera -->

                        <div class="white_bg col-xs-12 ">    
                            <div id="container_block" class="col-xss-12">
                                <div id="descripcion-proyecto">
                                        <h2>Proyecto<span> <?php getNombreProyecto();?></span></h2>
                                        <div class="row">
                                            <div class="col-xs-6">
                                                <h4>Descripción:</h4>
                                            </div>
                                            <div class="col-xs-3">
                                                <h4><a href="" data-toggle="modal" data-target=".editarProyecto" data-backdrop="static" id="editarProyectoButton">Editar Proyecto</a></h4>
                                            </div>
                                            <div class="col-xs-3">
                                                    <h4><a href="" data-toggle="modal" data-target=".eliminarProyecto" data-backdrop="static" id="eliminarProyectoButton">Eliminar Proyecto</a></h4>
                                            </div>
                                        </div>
                                    <p><?php getDescripcion();?></p>              
                                </div>
                            </div>
                            

                            <!-- Botón agregar alumnos-->                  
                            <div class="cabecera_btn">
                                <h1></h1>
                                <a id="agregarAlumnoButton" class="btn_new Bold col-xss-12 animated zoomIn" onclick="changeValueStatus();" data-toggle="modal" data-target=".nuevoAlumno" data-backdrop="static">Agregar Alumnos</a>
                            </div>
                            

                            <!-- Tabla alumnos-->            
                            <div id="tabla_dashboard" class="white_bg col-xs-12 noPadding">
                                <div class="panel-body">
                                    <div class="capa_table table-responsive col-xs-12">
                                        <table id="proyectos_table" class="display translateTable" cellspacing="0" width="100%">
                                            <thead>
                                                <tr>
                                                    <th>Boleta</th>
                                                    <th>Alumno</th>
                                                    <th>Fecha de inicio</th>
                                                    <th>Fecha de Fin</th>
                                                    <th>Estado </th>
                                                    <th>Situación</th>
                                                    <th>Acciones</th>
                                                </tr>
                                            </thead>
                                            
                                            <!-- Imprime datos de la tabla-->
                                            <tbody id="datat">
                                                <?php include '../php/Proyectos/DetalleProyecto_AX.php';?>
                                            </tbody>
                                        </table>
                                    </div>
                                </div>
                            </div> 
                            <!--Fin tabla alumnos-->
                        </div>
                        <!-- Fin Contenedor tabla y cabecera -->
                </section>
            </div>
        </div>
    </div>
    <!-- Fin section-->


  <!-- Modal Nuevo proyecto -->
  <div class="modal fade nuevoProyecto" tabindex="-1" role="dialog" aria-labelledby="nuevoProyecto">
    <div class="modal-dialog modal-md" role="document">
      <div class="modal-content">
        <div class="modal-header">
          <button type="button" class="close azul_color" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
          <h4 id="tituloModal" class="modal-title navy_blue">Nuevo Proyecto</h4>
        </div>
        
                <!-- Inicio Formulario 'Nuevo proyecto'-->
                <form data-parsley-validate="" id="formNewProjectd">
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
                <form data-parsley-validate="" id="formEditarProyectod">
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
                         
                        <form id="formEliminarProyetod">
                            <input type="hidden" id="idEliminarProyecto" name="idEliminarProyecto" value="">
                            <button id="" class="btn btn_disabled btn_small" data-dismiss="modal">Cancelar</button>
                            <button type="submit" class="btn btn_blue btn_small" go-to="">Eliminar</button>
                        </form>
                        
                </div>
            </div>
        </div>
    </div>
    <!-- Fin de Modal Eliminar Proyecto  -->

  <!-- Modal eliminar alumno -->
	<div class="modal fade eliminarAlumno" tabindex="-1" role="dialog" aria-labelledby="eliminarAlumno">
		<div class="modal-dialog modal-md" role="document">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close azul_color" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
					<h4 class="modal-title navy_blue">Eliminar Alumno</h4>
				</div>
				<div class="modal-body">
					<div class="col-xs-10 col-xs-offset-1 col-xss-12 col-xss-offset-0 noPadding listado">

						<p>¿Estás seguro de querer eliminar al Alumno? Una vez realizado no se podrá revertir</p>
					<!--<p>No se puede eliminar el proyecto porque tiene alumnos asociados, por favor elimine a los alumnos del proyecto e intente de nuevo.</p> -->
					</div>
				</div>
				<div class="modal-footer">
            <form id="eliminarAlumno">
              <input type="hidden" name="idEliminarAlumno" id="idEliminarAlumno" value="">
              <button id="" class="btn btn_disabled btn_small" data-dismiss="modal" go-to="" >Cancelar</button>
  						<button type="submit" href="proyectos.php" id="" class="btn btn_blue btn_small" go-to="">Aceptar</button>
            </form>
				</div>
			</div>
		</div>
	</div>
	<!-- Fin de Modal eliminar alumno  -->

    <!-- Modal editar alumno -->
    <div class="modal fade editarAlumno" tabindex="-1" role="dialog" aria-labelledby="eliminarProyecto">
        <div class="modal-dialog modal-md" role="document">
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close azul_color" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                    <h4 class="modal-title navy_blue">Editar Alumno</h4>
                </div>
                <div class="modal-body">
                    <div class="col-xs-10 col-xs-offset-1 col-xss-12 col-xss-offset-0 noPadding listado">

                        <div class="row">
                        <div class="col-xs-5 col-xs-offset-1 col-xss-12 col-xss-offset-0">
                            <p>Situacion</p>
                            <form id="formEditarAlumnod" data-parsley-validate="">
                            <select id="roles" name="situacionAlumno" class="selectpicker" style="margin:0px;">
                                <option value="Liberado">Liberado</option>
                                <option value="Cancelado">Cancelado</option>
                                <option value="Sin situacion">Sin situación</option>
                            </select>
                        </div>
                        <div class="col-xs-5 col-xs-offset-1 col-xss-12 col-xss-offset-0">
                            <p>Estado</p>
                            <!--input type="text" name=""-->
                            <select class="selectpicker" name="estadoAlumno">
                                <option value="Validado">Validado</option>
                                <option value="No validado">No Validado</option>
                            </select>
                        </div>
                    </div><br>
                    <div class="row">
                        <div class="col-xs-5 col-xs-offset-1 col-xss-12 col-xss-offset-0">
                          <p>Fecha Inicial</p>
                          <input type="date" name="fechaInicio" required="">
                        </div>
                        <div class="col-xs-5 col-xs-offset-1 col-xss-12 col-xss-offset-0">
                          <p>Fecha Final</p>
                          <input type="date" name="fechaFin" required="">
                        </div>
                    </div>
                    </div>
                </div>
                <div class="modal-footer">
                         
                        
                            <input type="hidden" id="idAlumnoEditar" name="idAlumnoEditar" value="">
                            <input type="hidden" id="status" name="status" value="">
                            <button id="" class="btn btn_disabled btn_small" data-dismiss="modal">Cancelar</button>
                            <button type="submit" class="btn btn_blue btn_small" go-to="">Modificar</button>
                        </form>
                        
                </div>
            </div>
        </div>
    </div>
    <!-- Fin de Modal Eliminar Proyecto  -->

  <!-- *************************** Modal Agregar Alumno ***************************** -->
	<div class="modal fade nuevoAlumno" tabindex="-1" role="dialog" aria-labelledby="nuevoAlumno">
		<div class="modal-dialog modal-md" role="document">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close azul_color" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
					<h4 class="modal-title navy_blue">Agregar Alumnos al Proyecto</h4>
				</div>

                <div class="modal-body">
                      <p style="text-align:center;">
                        Realize la búsqueda de los alumnos, seleccione los alumnos que desea agregar al proyecto y al finalizar pulse guardar.
                      </p>
                    <div class="row">
                        <div class="col-xs-12">
                            <div id="contenedorFormulario">
                                <?php include '../php/Proyectos/ConsultarAlumnos.php'; ?>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
	</div>
	<!-- ******************** Fin de Modal Agregar Alumno *********************************** -->

</body>


  <!-- JS -->
    <script type="text/javascript" src="../assets/js/jquery-3.2.1.min.js"></script>
    <script type="text/javascript" src="../assets/js/jquery.dataTables.min.js"></script>
    <script type="text/javascript" src="../assets/js/bootstrap.min.js"></script>
    <script type="text/javascript" src="../assets/js/translateTable.js"></script>
    <script type="text/javascript" src="../assets/js/jquery.multi-select.js"></script>
    <script type="text/javascript" src="../assets/js/jquery.quicksearch.js" ></script>
    <script type="text/javascript" src="../assets/js/bootstrap-select.min.js"></script>
    <!--script type="text/javascript">$('#my-select').multiSelect();</script-->
    <script type="text/javascript">
        $('#my-select').multiSelect();
    </script>

  
  <!-- AJAX -->
  <script type="text/javascript" src="../assets/js/AX/Proyecto_AX.js"></script>

  <!-- Functions -->
  <script type="text/javascript" src="../assets/js/AX/DetalleProyectoFunctions.js"></script>  


</html>
