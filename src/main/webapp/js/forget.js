// 验证码
var verifyCode = new GVerify("v_container");
	 	
	 	document.getElementById("refreshCaptcha").onclick = function(){
	 		verifyCode.refresh();
	 	}
	 	
	 	document.getElementById("forgotPasswordForm").onsubmit = function(){
	 		var res = verifyCode.validate(document.getElementById("code_input").value);
	 		if(res){
	 			alert("验证正确");
	 		}else{
	 			alert("验证码错误");
	 			return false;
	 		}
	 	}