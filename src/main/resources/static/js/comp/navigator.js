$( document ).ready(function() {
	
	const path =  $("#path").val();
	const filter =  $("#filter").val();
	
    // Controle dos cliques no botoes de navegação da grid
    $(".btn-nav").click(function (event) {
        event.preventDefault();
        window.location.assign(/*[[@{/}]]*/ "/"+path+"?pag="+this.textContent+filter);
    });

	$(".btn-anterior").click(function (event) {
		const val = parseInt($(".page-item.active").find('a').text())-1;		
        event.preventDefault();
        window.location.assign(/*[[@{/}]]*/ "/"+path+"?pag="+val+filter);
    });

  	$(".btn-proximo").click(function (event) {	   	
		const val = parseInt($(".page-item.active").find('a').text())+1;	
		const totalPages = $("#totalPages").val();	
        event.preventDefault();
		if (totalPages >= val)  {
			window.location.assign(/*[[@{/}]]*/ "/"+path+"?pag="+val+filter);	
		}
        
    });

    // Desabilitar botoes maiores que o numero de paginas
	$(".btn-nav").each(function() {
		if (Number($( this ).text()) > Number($("#totalPages").val())) {
   			$( this ).parent().addClass('disabled');
 	 	} 
	});	
	if (Number($(".page-item.active").find('a').text()) == Number($("#totalPages").val())) {
		$(".btn-proximo").parent().addClass('disabled');		
	}
	if (Number($("#totalPages").val()) == 0) {
		$(".btn-proximo").parent().addClass('disabled');
	}
	
});