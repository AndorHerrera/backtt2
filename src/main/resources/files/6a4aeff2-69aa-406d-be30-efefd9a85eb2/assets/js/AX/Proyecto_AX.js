$(document).ready(function() {
    
  //Registrar proyecto
  $("#formNewProject").submit(function(e){
      $.ajax({
        method:"post",
        url:"../php/Proyectos/RegistroProyecto_AX.php",
        cache:false,
        data:$("#formNewProject").serialize(),
        success: function(resp){
          if (resp == 1){
            $("#datat").load("../php/Proyectos/ConsultarProyectos_AX.php?direction=1");
            $("#formNewProject")[0].reset();
            $('.nuevoProyecto').modal('hide');
            alert("Proyecto registrado correctamente");
          } else {
            alert("No pudimos registrar el proyecto");
          }
        }
      })
    return false;
  });


  // Eliminar Proyecto
  $("#formEliminarProyeto").submit(function(e){
      $.ajax({
        method:"post",
        url:"../php/Proyectos/EliminarProyecto_AX.php",
        cache:false,
        data:$("#formEliminarProyeto").serialize(),
        success: function(resp){
          if (resp == 1){
            $("#datat").load("../php/Proyectos/ConsultarProyectos_AX.php?direction=1");
            $("#formEliminarProyeto")[0].reset();
            $('.eliminarProyecto').modal('hide');
            alert("Proyecto eliminado correctamente");
          } else {
            alert("No pudimos eliminar el proyecto");
          }
        }
      })
    return false;
  });

  //Editar Proyecto
  $("#formEditarProyecto").submit(function(e){
      $.ajax({
        method:"post",
        url:"../php/Proyectos/EditarProyecto_AX.php",
        cache:false,
        data:$("#formEditarProyecto").serialize(),
        success: function(resp){
          if (resp == 1) {
            alert("Proyecto modificado correctamente");
            $("#datat").load("../php/Proyectos/ConsultarProyectos_AX.php?direction=1");
            $('.editarProyecto').modal('hide');
            $("#formEditarProyecto")[0].reset();
          } else {
            alert("No pudimos modificar el proyecto");
          }
        }
      })
    return false;
  });  

  // Eliminar Alumno
  $("#eliminarAlumno").submit(function(e){
      $.ajax({
        method:"post",
        url:"../php/Proyectos/EliminarAlumno_AX.php",
        cache:false,
        data:$("#eliminarAlumno").serialize(),
        success: function(resp){
          if (resp != -1){
            
            // To recharge students list
            var $_GET = {};
            document.location.search.replace(/\??(?:([^=]+)=([^&]*)&?)/g, function () {
            function decode(s) {
              return decodeURIComponent(s.split("+").join(" "));
            }
            $_GET[decode(arguments[1])] = decode(arguments[2]);
            });
            var path = "../php/Proyectos/DetalleProyecto_AX.php?direction=1&status=" + $_GET['status'];            
            
            $("#datat").load(path);
            $('.eliminarAlumno').modal('hide');
            $("#alumnosRegistro").load("../php/Proyectos/ConsultarAlumnos.php");
            alert("Alumno eliminado correctamente");


          } else {
            alert("No pudimos eliminar al alumno");
          }
        }
      })
    return false;
  });

  $("#eliminarProyectoButton").click(function() {
      // To recharge students list
            var $_GET = {};
            document.location.search.replace(/\??(?:([^=]+)=([^&]*)&?)/g, function () {
            function decode(s) {
              return decodeURIComponent(s.split("+").join(" "));
            }
            $_GET[decode(arguments[1])] = decode(arguments[2]);
            });

            $('#idEliminarProyecto').val($_GET['status']);
  });


  $("#editarProyectoButton").click(function() {
      // To recharge students list
            var $_GET = {};
            document.location.search.replace(/\??(?:([^=]+)=([^&]*)&?)/g, function () {
            function decode(s) {
              return decodeURIComponent(s.split("+").join(" "));
            }
            $_GET[decode(arguments[1])] = decode(arguments[2]);
            });

            $('#idEditarProyecto').val($_GET['status']);
  });


  $("#formNewProjectd").submit(function(e){
      $.ajax({
        method:"post",
        url:"../php/Proyectos/RegistroProyecto_AX.php",
        cache:false,
        data:$("#formNewProjectd").serialize(),
        success: function(resp){
          if (resp == 1){
            $('.nuevoProyecto').modal('hide');
            alert("Proyecto registrado correctamente");
          } else {
            alert("No pudimos registrar el proyecto");
          }
        }
      })
    return false;
  });


  // Eliminar Proyecto dentro de Detalle proyecto
  $("#formEliminarProyetod").submit(function(e){
      $.ajax({
        method:"post",
        url:"../php/Proyectos/EliminarProyecto_AX.php",
        cache:false,
        data:$("#formEliminarProyetod").serialize(),
        success: function(resp){
          if (resp == 1){
           //alert("Proyecto eliminado correctamente");
           location.href ="proyectos.php";
          } else {
            alert("No pudimos eliminar el proyecto");
          }
        }
      })
    return false;
  });

  //Editar Proyecto
  $("#formEditarProyectod").submit(function(e){
      $.ajax({
        method:"post",
        url:"../php/Proyectos/EditarProyecto_AX.php",
        cache:false,
        data:$("#formEditarProyectod").serialize(),
        success: function(resp){
          if (resp == 1) {
            $('.editarProyecto').modal('hide');
            alert("Proyecto modificado correctamente");
            
            var $_GET = {};
            document.location.search.replace(/\??(?:([^=]+)=([^&]*)&?)/g, function () {
            function decode(s) {
              return decodeURIComponent(s.split("+").join(" "));
            }
            $_GET[decode(arguments[1])] = decode(arguments[2]);
            });

            var path = "proyectos_detalle.php?status=" + $_GET['status'];            

            location.href = path;
          } else {
            alert("No pudimos modificar el proyecto");
          }
        }
      })
    return false;
  });  


  // Eliminar Proyecto dentro de Detalle proyecto
  $("#formEditarAlumnod").submit(function(e){
      $.ajax({
        method:"post",
        url:"../php/Proyectos/EditarAlumno.php",
        cache:false,
        data:$("#formEditarAlumnod").serialize(),
        success: function(resp){
          if (resp == 1){
           alert("Alumno modificado correctamente");
           $('.editarAlumno').modal('hide');
           // To recharge students list
            var $_GET = {};
            document.location.search.replace(/\??(?:([^=]+)=([^&]*)&?)/g, function () {
            function decode(s) {
              return decodeURIComponent(s.split("+").join(" "));
            }
            $_GET[decode(arguments[1])] = decode(arguments[2]);
            });
            var path = "../php/Proyectos/DetalleProyecto_AX.php?direction=1&status=" + $_GET['status'];            
            $("#datat").load(path);
            $("#alumnosRegistro").load("../php/Proyectos/ConsultarAlumnos.php");
           //location.href ="proyectos.php";
          } else {
            alert("No pudimos modificar el alumno");
          }
        }
      })
    return false;
  });


  // Eliminar Proyecto dentro de Detalle proyecto
  $("#formRegistrarAlumnoAdmin").submit(function(e){
      $.ajax({
        method:"post",
        url:"../php/Proyectos/AgregarAlumnoAdmin.php",
        cache:false,
        data:$("#formRegistrarAlumnoAdmin").serialize(),
        success: function(resp){
          if (resp == 1){
           alert("Alumno agregado correctamente");
           $('.nuevoAlumno').modal('hide');
            // To recharge students list
            var $_GET = {};
            document.location.search.replace(/\??(?:([^=]+)=([^&]*)&?)/g, function () {
            function decode(s) {
              return decodeURIComponent(s.split("+").join(" "));
            }
            $_GET[decode(arguments[1])] = decode(arguments[2]);
            });
            var path = "../php/Proyectos/DetalleProyecto_AX.php?direction=1&status=" + $_GET['status'];            
            
            $("#datat").load(path);

            $("#alumnosRegistro").load("../php/Proyectos/ConsultarAlumnos.php");


            //document.getElementById('alumnosRegistro').innerHTML = "<option>hola</option>";
          } else {
            alert("No pudimos agregar al alumno");
          }
        }
      })
    return false;
  });


  // Eliminar Proyecto dentro de Detalle proyecto
  $("#formCambiarCorreo").submit(function(e){
      $.ajax({
        method:"post",
        url:"../php/Perfil/CambiarCorreo.php",
        cache:false,
        data:$("#formCambiarCorreo").serialize(),
        success: function(resp){
          if (resp == 1){
            alert("Correo electrónico modificado exitosamente");
            $('.cambiaCorreo').modal('hide');
            $("#formCambiarCorreo")[0].reset();
          } else {
            alert("No pudimos modificar tu correo electrónico");
          }
        }
      })
    return false;
  });


  $("#formCambiarContrasena").submit(function(e){
      $.ajax({
        method:"post",
        url:"../php/Perfil/CambiarContrasena.php",
        cache:false,
        data:$("#formCambiarContrasena").serialize(),
        success: function(resp){
          if (resp == 1){
            alert("Contraseña modificada exitosamente");
            $('.cambiaPassword').modal('hide');
            $("#formCambiarContrasena")[0].reset();
          } else {
            alert("Verifica tu información");
          }
        }
      })
    return false;
  });

  $("#formRegistrarAlumnoDocente").submit(function(e){
      $.ajax({
        method:"post",
        url:"../php/Proyectos/AgregarAlumnoDocente.php",
        cache:false,
        data:$("#formRegistrarAlumnoDocente").serialize(),
        success: function(resp){
          if (resp >= 1){
            alert("Alumnos agregados exitosamente");
            $('.nuevoAlumno').modal('hide');
            // To recharge students list
            var $_GET = {};
            document.location.search.replace(/\??(?:([^=]+)=([^&]*)&?)/g, function () {
            function decode(s) {
              return decodeURIComponent(s.split("+").join(" "));
            }
            $_GET[decode(arguments[1])] = decode(arguments[2]);
            });
            var path = "../php/Proyectos/DetalleProyecto_AX.php?direction=1&status=" + $_GET['status'];            
            
            $("#datat").load(path);
          } else {
            alert("No pudimos registrar a los alumnos");
          }
        }
      })
    return false;
  });



});