var msgOn = false;
var funcRet;

 
function feedback(message, type, func) {
	funcRet = func;    	
	if (!msgOn) {
		setTimeout("closeFeedback()", 3000);    
		var alertPlaceholder = document.getElementById('feedbackPlaceholder');
		var wrapper = document.createElement('div');		
		
	  	wrapper.innerHTML = '<div id="msgbox" class="alert alert-' + type + ' d-flex align-items-center alert-dismissible fade show" role="alert">' 
	                          + '<svg class="bi flex-shrink-0 me-2" width="24" height="24" role="img" aria-label="Success:"><use xlink:href="#check-circle-fill"/></svg>'
	                          + message
	                          + '<button type="button" class="btn-close" data-bs-dismiss="alert" aria-label="Close"></button>'
	                        +'</div>';
	
	  	alertPlaceholder.append(wrapper);
		msgOn = true;
	}	
}
    
 function closeFeedback() {
	if (msgOn) {
		var alertPlaceholder = document.getElementById('msgbox');
		var wrapper = document.createElement('div');
		alertPlaceholder.remove(wrapper);
		timer_alert = null;
		msgOn = false;
	}
	if (funcRet != null) {
		funcRet();	
	}
  }    
