
window.onkeyup = function( e ) {
   var key = e.keyCode ? e.keyCode : e.which;

   if( key == 13 ) {
       request();
   }
}

$("#submit").click( request );


function request() {
	var email = $("#email").val();
	var password = $("#password").val();
	
	$.ajax( {
		url: "php/login/login.php",
		type: "POST",
		data: { "email": email, "password" : password },
		
		success: function( resp ) {
		
			if( resp == -1 ) {
				alert("Credenciales incorrectas.");
				
			} else {
				window.location = resp;
			}
			
		},
		
		error : function( error ) {
			alert("Hubo un problema");
		}
	} );
}

