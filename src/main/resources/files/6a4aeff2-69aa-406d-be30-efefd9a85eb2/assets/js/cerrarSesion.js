
$("#cerrarSesion").click( function() {
	$.ajax( {
		url: "php/login/cerrarSesion.php",
		type: "POST",
		cache: false,
		data: { "c_sesion": "true" },
		
		success: function( resp ) {
			
			window.location = resp;
			
		},
		
		error : function( error ) {
			console.log("Hubo un problema " + error );
		}
	} );
});
