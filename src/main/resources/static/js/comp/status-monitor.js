var timer = null;
var funcReturn;

function startStatusMonitor(x) {
	funcReturn = x;
	timer = setInterval("getStatus()", 2000);
}

function getStatus() {
	var url = $("#path").val();
	$.get("/"+url+"/status", function(res) {
		var status = res.split(":")[0];
		var percent = res.split(":")[1];		
			
		if (status == "Finished") {
			clearInterval(timer);	
			$(".progress-bar").css("width", 100+"%");	
			$(".progress-bar").html(parseInt(100).toFixed()+" %");
			
			setTimeout(function(){
				feedback("Parabens! Processamento concluído com sucesso.", 'success');	
				$(".progress-bar").css("width", 0+"%");
				$(".progress-bar").html(parseInt(0).toFixed()+" %");
				funcReturn();	
			},1000);					
    	} else {	
			$(".progress-bar").css("width", percent+"%");
			$(".progress-bar").html(parseInt(percent).toFixed()+" %");
		}	
	});
}
	