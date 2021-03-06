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
    <div id="Docentes" class="container">
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
                        <li class="menu_txt">
                            <a href="proyectos.php">
                                <span class="glyphicon glyphicon-briefcase"></span> Proyectos</a>
                        </li>
                        <li class="menu_txt active">
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
                <div id="container_block" class="col-xs-12">    <!-- CABECERA -->
                    <div class="cabecera_btn">
                        <h1 id="titulo_seccion" class="navy_blue animated fadeInDown">Docentes</h1>
                        <a class="btn_new Bold col-xss-12" href="#" data-toggle="modal" data-target=".agregarDocente" data-backdrop="static">Agregar Nuevo Docente</a>
                    </div>
                </div>
                <div id="tabla_dashboard" class="white_bg col-xs-12 noPadding">
                    <div class="col-xs-12 col-xss-12 col-xss-offset-0">
                        <p class="titulos navy_blue align_center  col-xs-6 col-xss-12 noPadding hvr-underline-from-center pestania_header" colspan="3" idPestania="1">Docentes</p>
                        <p class="titulos navy_blue align_center disabled_color col-xs-6  col-xss-12 noPadding hvr-underline-from-center pestania_header" colspan="3" idPestania="2">Jefes de Área</p>
                    </div>
                    <div class="panel-body">
                      <div class="pestania_content" idPestania="1">
                        <div class="capa_table table-responsive col-xs-12">
                          <table id="docentes_table" class="display translateTable" cellspacing="0" width="100%">
                              <thead>
                                  <tr>
                                      <th>Nombre</th>
                                      <th>Fecha de Registro</th>
                                      <th>Email</th>
                                      <th>Departamento</th>
                                      <th>Cuenta</th>
                                      <th>Acciones</th>
                                  </tr>
                              </thead>
                              <tbody>
                                  <tr>
                                      <td>Airi Satou</td>
                                      <td>2008011128</td>
                                      <td>Airi@Satou</td>
                                      <td>Formación Básica</td>
                                      <td>Activa</td>
                                      <td>
                                        <a href="proyectos_detalle.php"><span class="glyphicon glyphicon-eye-open"></span></a>
                                          <a data-toggle="modal" data-target=".agregarDocente"><span class="glyphicon glyphicon-edit"></span></a>
                                          <a data-toggle="modal" data-target=".eliminarDocente" data-backdrop="static"><span class="glyphicon glyphicon-trash"></span></a>
                                      </td>
                                  </tr>
                                  <tr>
                                      <td>Sonya Frost</td>
                                      <td>2008012313</td>
                                      <td>Sonya@Frost</td>
                                      <td>Formación Básica</td>
                                      <td>Inactiva</td>
                                      <td>
                                        <a href="proyectos_detalle.php"><span class="glyphicon glyphicon-eye-open"></span></a>
                                          <a data-toggle="modal" data-target=".agregarDocente"><span class="glyphicon glyphicon-edit"></span></a>
                                          <a data-toggle="modal" data-target=".eliminarDocente" data-backdrop="static"><span class="glyphicon glyphicon-trash"></span></a>
                                      </td>
                                  </tr>
                                  <tr>
                                      <td>Colleen Hurst</td>
                                      <td>2009209115</td>
                                      <td>Colleen@Hurst</td>
                                      <td>Servicio Social</td>
                                      <td>Activa</td>
                                      <td>
                                        <a href="proyectos_detalle.php"><span class="glyphicon glyphicon-eye-open"></span></a>
                                          <a data-toggle="modal" data-target=".agregarDocente"><span class="glyphicon glyphicon-edit"></span></a>
                                          <a data-toggle="modal" data-target=".eliminarDocente" data-backdrop="static"><span class="glyphicon glyphicon-trash"></span></a>
                                      </td>
                                  </tr>
                                  <tr>
                                      <td>Ashton Cox</td>
                                      <td>2009301112</td>
                                      <td>Ashton@Cox</td>
                                      <td>Formación Básica</td>
                                      <td>Inactiva</td>
                                      <td>
                                        <a href="proyectos_detalle.php"><span class="glyphicon glyphicon-eye-open"></span></a>
                                          <a data-toggle="modal" data-target=".agregarDocente"><span class="glyphicon glyphicon-edit"></span></a>
                                          <a data-toggle="modal" data-target=".eliminarDocente" data-backdrop="static"><span class="glyphicon glyphicon-trash"></span></a>
                                      </td>
                                  </tr>
                                  <tr>
                                      <td>Rhona Davidson</td>
                                      <td>2010310114</td>
                                      <td>Rhona@Davidson</td>
                                      <td>Formación Básica</td>
                                      <td>Activa</td>
                                      <td>
                                        <a href="proyectos_detalle.php"><span class="glyphicon glyphicon-eye-open"></span></a>
                                          <a data-toggle="modal" data-target=".agregarDocente"><span class="glyphicon glyphicon-edit"></span></a>
                                          <a data-toggle="modal" data-target=".eliminarDocente" data-backdrop="static"><span class="glyphicon glyphicon-trash"></span></a>
                                      </td>
                                  </tr>
                                  <tr role="row" class="even">
                                      <td>Brielle Williamson</td>
                                      <td>2012112302</td>
                                      <td>Brielle@Williamson</td>
                                      <td>Formación Básica</td>
                                      <td>Inactiva</td>
                                      <td>
                                        <a href="proyectos_detalle.php"><span class="glyphicon glyphicon-eye-open"></span></a>
                                          <a data-toggle="modal" data-target=".agregarDocente"><span class="glyphicon glyphicon-edit"></span></a>
                                          <a data-toggle="modal" data-target=".eliminarDocente" data-backdrop="static"><span class="glyphicon glyphicon-trash"></span></a>
                                      </td>
                                  </tr>
                                  <tr>
                                      <td>Cedric Kelly</td>
                                      <td>2012303129</td>
                                      <td>Cedric@Kelly</td>
                                      <td>Formación Básica</td>
                                      <td>Activa</td>
                                      <td>
                                        <a href="proyectos_detalle.php"><span class="glyphicon glyphicon-eye-open"></span></a>
                                          <a data-toggle="modal" data-target=".agregarDocente"><span class="glyphicon glyphicon-edit"></span></a>
                                          <a data-toggle="modal" data-target=".eliminarDocente" data-backdrop="static"><span class="glyphicon glyphicon-trash"></span></a>
                                      </td>
                                  </tr>
                                  <tr>
                                      <td>Herrod Chandler</td>
                                      <td>2012308206</td>
                                      <td>Herrod@Chandler</td>
                                      <td>Formación Básica</td>
                                      <td>Inactiva</td>
                                      <td>
                                        <a href="proyectos_detalle.php"><span class="glyphicon glyphicon-eye-open"></span></a>
                                          <a data-toggle="modal" data-target=".agregarDocente"><span class="glyphicon glyphicon-edit"></span></a>
                                          <a data-toggle="modal" data-target=".eliminarDocente" data-backdrop="static"><span class="glyphicon glyphicon-trash"></span></a>
                                      </td>
                                  </tr>
                                  <tr role="row" class="odd">
                                      <td>Zaira Villa</td>
                                      <td>2017832912</td>
                                      <td>Zaira@Villa</td>
                                      <td>Formación Básica</td>
                                      <td>Activa</td>
                                      <td>
                                        <a href="proyectos_detalle.php"><span class="glyphicon glyphicon-eye-open"></span></a>
                                          <a data-toggle="modal" data-target=".agregarDocente"><span class="glyphicon glyphicon-edit"></span></a>
                                          <a data-toggle="modal" data-target=".eliminarDocente" data-backdrop="static"><span class="glyphicon glyphicon-trash"></span></a>
                                      </td>
                                  </tr>
                                  <tr>
                                      <td>Accountant</td>
                                      <td>2018392262</td>
                                      <td>Accountant@ipn.mx</td>
                                      <td>Formación Básica</td>
                                      <td>Inactiva</td>
                                      <td>
                                        <a href="proyectos_detalle.php"><span class="glyphicon glyphicon-eye-open"></span></a>
                                          <a data-toggle="modal" data-target=".agregarDocente"><span class="glyphicon glyphicon-edit"></span></a>
                                          <a data-toggle="modal" data-target=".eliminarDocente" data-backdrop="static"><span class="glyphicon glyphicon-trash"></span></a>
                                      </td>
                                  </tr>
                              </tbody>
                          </table>
                        </div>
                      </div>
                      <div class="pestania_content" idPestania="2">
                        <div class="capa_table table-responsive col-xs-12">
                          <table id="jefes_area_table" class="display translateTable" cellspacing="0" width="100%">
                              <thead>
                                  <tr>
                                      <th>Nombre</th>
                                      <th>Fecha de Registro</th>
                                      <th>Email</th>
                                      <th>Departamento</th>
                                      <th>Cuenta</th>
                                      <th>Acciones</th>
                                  </tr>
                              </thead>
                              <tbody>
                                  <tr>
                                      <td>Ivan Mosso</td>
                                      <td>2008011128</td>
                                      <td>imosso@ipn.mx</td>
                                      <td>Formación Básica</td>
                                      <td>Activa</td>
                                      <td>
                                        <a href="proyectos_detalle.php"><span class="glyphicon glyphicon-eye-open"></span></a>
                                          <a href="#"><span class="glyphicon glyphicon-edit"></span></a>
                                          <a data-toggle="modal" data-target=".eliminarDocente" data-backdrop="static"><span class="glyphicon glyphicon-trash"></span></a>
                                      </td>
                                  </tr>
                                  <tr>
                                      <td>Claudia Dorantes</td>
                                      <td>2008012313</td>
                                      <td>cl@ipn.mx</td>
                                      <td>Formación Básica</td>
                                      <td>Activa</td>
                                      <td>
                                        <a href="proyectos_detalle.php"><span class="glyphicon glyphicon-eye-open"></span></a>
                                          <a href="#"><span class="glyphicon glyphicon-edit"></span></a>
                                          <a data-toggle="modal" data-target=".eliminarDocente" data-backdrop="static"><span class="glyphicon glyphicon-trash"></span></a>
                                      </td>
                                  </tr>
                                  <tr>
                                      <td>Idalia Maldonado</td>
                                      <td>2009209115</td>
                                      <td>idalia_bebe@ipn.mx</td>
                                      <td>Servicio Social</td>
                                      <td>Activa</td>
                                      <td>
                                        <a href="proyectos_detalle.php"><span class="glyphicon glyphicon-eye-open"></span></a>
                                          <a href="#"><span class="glyphicon glyphicon-edit"></span></a>
                                          <a data-toggle="modal" data-target=".eliminarDocente" data-backdrop="static"><span class="glyphicon glyphicon-trash"></span></a>
                                      </td>
                                  </tr>
                              </tbody>
                          </table>
                        </div>
                      </div>
                    </div>
                </div>
            </section>
        </div>
    </div>

  <!-- **************************** M O D A L S **********************************-->
    <!-- *********************MODAL Eliminar Docente***************************** -->
    <div class="modal fade eliminarDocente" tabindex="-1" role="dialog" aria-labelledby="eliminarDocente">
        <div class="modal-dialog modal-md" role="document">
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close azul_color" data-dismiss="modal" aria-label="Close">
                        <span aria-hidden="true">&times;</span>
                    </button>
                    <h4 class="modal-title navy_blue" id="myModalLabel">Eliminación de Docente</h4>
                </div>
                <div class="modal-body">
                    <div class="col-xs-10 col-xs-offset-1 col-xss-12 col-xss-offset-0 listado">
                        <p>No se puede eliminar al docente porque tiene proyectos asociados, por favor elimine los proyectos del docente e intente de nuevo.</p>
                    </div>
                </div>
                <div class="modal-footer">
                    <button id="" class="btn btn_blue btn_250" data-dismiss="modal" go-to="">Cancelar</button>
                </div>
            </div>
        </div>
    </div>
    <!-- ************FINAL DE eliminar docente *************************-->

    <!-- ************* MODAL Agregar docente -->
    <div class="modal fade agregarDocente" tabindex="-1" role="dialog" aria-labelledby="agregarDocente">
        <div class="modal-dialog modal-md" role="document" style="height: 20%;">
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close azul_color" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                    <h4 class="modal-title navy_blue" id="myModalLabel">Agregar/Editar Docente</h4>
                </div>
                <div class="modal-body">
                    <div class="row">
                        <div class="col-xs-5 col-xs-offset-1 col-xss-12 col-xss-offset-0">
                            <p>Nombre</p>
                            <input type="text" name="">
                        </div>
                        <div class="col-xs-5 col-xs-offset-1 col-xss-12 col-xss-offset-0">
                            <p>Rol</p>
                            <!--input type="text"-->
                            <select id="roles" class="selectpicker" style="margin:0px;">
                                <option value="docente">Docente</option>
                                <option value="jefeArea">Jefe de Área</option>
                            </select>
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-xs-5 col-xs-offset-1 col-xss-12 col-xss-offset-0">
                            <p>Apellido Paterno</p>
                            <input type="text" name="">
                        </div>
                        <div class="col-xs-5 col-xs-offset-1 col-xss-12 col-xss-offset-0">
                            <p>Apellido Materno</p>
                            <input type="text" name="">
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-xs-5 col-xs-offset-1 col-xss-12 col-xss-offset-0">
                            <p>Correo Electrónico</p>
                            <input type="email" name="">
                        </div>
                        <div class="col-xs-5 col-xs-offset-1 col-xss-12 col-xss-offset-0">
                            <p>Departamento</p>
                            <!--input type="text" name=""-->
                            <select class="selectpicker">
                                <option value="formacionB">Formación Básica</option>
                                <option value="formacionB">Ciencias e Ingeniería de la Computación</option>
                                <option value="formacionB">Ingeniería en Sistemas Computacionales</option>
                                <option value="formacionB">Evaluación y Seguimiento Académico</option>
                                <option value="formacionB">Innovación Educativa</option>
                            </select>
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-xs-3">
                        </div>
                        <div class="col-xs-6 col-xs-offset-2 col-xss-12 col-xss-offset-0">
                            <p>Cuenta</p>
                            <label class="switch">
                                <input type="checkbox">
                                <span class="slider round"></span>
                            </label>
                        </div>
                        <div class="col-xs-2">

                        </div>
                    </div>
                </div>

                <div class="modal-footer">
                    <div class="row">
                        <div class="col-xs-6 col-xs-offset-0 col-xss-12 col-xss-offset-0" style="margin-left: -20px;">
                            <button id="" class="btn btn_blue btn_250" data-dismiss="modal" aria-label="Close" go-to="">Cancelar</button>
                        </div>
                        <div class="col-xs-5 col-xs-offset-0 col-xss-12 col-xss-offset-0">
                            <button id="" class="btn btn_blue btn_250" data-dismiss="modal" aria-label="Close" go-to="">Agregar/Editar</button>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <!-- ***************************Fin Agregar Docente********************************* -->

</body>
    <!-- JS -->
    <script type="text/javascript" src="../assets/js/jquery-3.2.1.min.js"></script>
    <script type="text/javascript" src="../assets/js/bootstrap.min.js"></script>
    <script type="text/javascript" src="../assets/js/jquery.dataTables.min.js"></script>
    <script type="text/javascript" src="../assets/js/translateTable.js"></script>
    <script type="text/javascript" src="../assets/js/functions.js"></script>
    <script type="text/javascript" src="../assets/js/bootstrap-select.min.js"></script>
</html>
