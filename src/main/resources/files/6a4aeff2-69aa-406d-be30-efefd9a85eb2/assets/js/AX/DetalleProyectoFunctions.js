        function changeValueEditar(valor){
            document.getElementById("idEliminarAlumno").value = valor;
        }

        function changeValueEditarAlumno(valor){
            document.getElementById("idAlumnoEditar").value = valor;
        }

        function decode(s) {
            return decodeURIComponent(s.split("+").join(" "));
        }

        function changeValueStatus(){
            
            var $_GET = {};
            document.location.search.replace(/\??(?:([^=]+)=([^&]*)&?)/g, function () {
            
            $_GET[decode(arguments[1])] = decode(arguments[2]);
            });

            document.getElementById("status").value = $_GET['status'];
        }   


        function changeRegistrarAlumno(){
            
            var $_GET = {};
            document.location.search.replace(/\??(?:([^=]+)=([^&]*)&?)/g, function () {
            
            $_GET[decode(arguments[1])] = decode(arguments[2]);
            });

            document.getElementById("statusAgregarAlumno").value = $_GET['status'];
        }



         function createEmpty(){
            document.getElementById("tabla_dashboard").innerHTML = "<div class='panel-body'> <div class='capa_table table-responsive col-xs-12'> <div id='proyectos_table_wrapper' class='dataTables_wrapper no-footer'><div class='dataTables_length' id='proyectos_table_length'><label>Mostrar <select name='proyectos_table_length' aria-controls='proyectos_table' class=''><option value='10'>10</option><option value='25'>25</option><option value='50'>50</option><option value='100'>100</option></select> registros</label></div><div id='proyectos_table_filter' class='dataTables_filter'><label>Buscar:<input type='search' class='' placeholder='' aria-controls='proyectos_table'></label></div><table id='proyectos_table' class='display translateTable dataTable no-footer' cellspacing='0' width='100%' role='grid' aria-describedby='proyectos_table_info' style='width: 100%;'> <thead> <tr role='row'><th class='sorting_asc' tabindex='0' aria-controls='proyectos_table' rowspan='1' colspan='1' aria-sort='ascending' aria-label='Titulo: Activar para ordenar la columna de manera descendente' style='width: 78px;'>Titulo</th><th class='sorting' tabindex='0' aria-controls='proyectos_table' rowspan='1' colspan='1' aria-label='Responsable: Activar para ordenar la columna de manera ascendente' style='width: 157px;'>Responsable</th><th class='sorting' tabindex='0' aria-controls='proyectos_table' rowspan='1' colspan='1' aria-label='Alumnos: Activar para ordenar la columna de manera ascendente' style='width: 113px;'>Alumnos</th><th class='sorting' tabindex='0' aria-controls='proyectos_table' rowspan='1' colspan='1' aria-label='Lugares disponibles: Activar para ordenar la columna de manera ascendente' style='width: 233px;'>Lugares disponibles</th><th class='sorting' tabindex='0' aria-controls='proyectos_table' rowspan='1' colspan='1' aria-label='Acciones: Activar para ordenar la columna de manera ascendente' style='width: 119px;'>Acciones</th></tr></thead> <tbody> <tr class='odd'><td valign='top' colspan='5' class='dataTables_empty'>Ningún dato disponible en esta tabla</td></tr></tbody> </table><div class='dataTables_info' id='proyectos_table_info' role='status' aria-live='polite'>Mostrando registros del 0 al 0 de un total de 0 registros</div><div class='dataTables_paginate paging_simple_numbers' id='proyectos_table_paginate'><a class='paginate_button previous disabled' aria-controls='proyectos_table' data-dt-idx='0' tabindex='0' id='proyectos_table_previous'>Anterior</a><span></span><a class='paginate_button next disabled' aria-controls='proyectos_table' data-dt-idx='1' tabindex='0' id='proyectos_table_next'>Siguiente</a></div></div></div></div>";
        }
