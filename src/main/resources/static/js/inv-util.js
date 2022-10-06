function getDatepicker(className) {
	$(className).datepicker({
	    format: "dd/mm/yyyy",
	    todayBtn: "linked",
	    language: "pt-BR",
	    autoclose: true
	});    
}

function reset() {
	let path = $("#path").val();
	window.location.assign('/'+path);
}

$( document ).ready(function() {
    	$("body").prepend($(".modal"));
    	
    	$(".inv_tooltip").tooltip();
});