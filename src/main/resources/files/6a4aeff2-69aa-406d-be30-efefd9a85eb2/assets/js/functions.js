$(document).ready(function(){


	// Cambio entre pestañas dashboard
	$(".pestania_content").hide(); 
		$(".pestania_content").first().show().addClass("active");
		$(".pestania_header").first().addClass("active");
		$(".pestania_header").click(function() {
			$(".pestania_header").removeClass("active"); 
			$(this).addClass("active");
			$(".pestania_content").hide();
			var idP = $(this).attr("idPestania");
			$(".pestania_content[idPestania='"+idP+"']").show();
		});

});