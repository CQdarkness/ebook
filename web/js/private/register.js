function changePic(){
	$("#captchaImg").prop("src","/woniumall2.0.0/pic?a="+Math.random());
}
function register(){
	var pw=$("#pw").val();
	var rpw=$("#rpw").val();
	if(pw!=rpw){
		$("#rpwmes").css("color","red");
		return;
	}
	$.ajax({
		url:"user",
		type:"POST",
		data:{
			oper:"register",
			account:$("#account").val(),
			pass:$("#pw").val(),
			email:$("#email").val(),
			pic:$("#pic").val()
		},
		dataType:"json",
		success:function(data){
			$("#picmes").html("");
			if(data==1){
				//验证码有误
				changePic();
				$("#picmes").html("验证码有误!看仔细点!");
				$("#picmes").css("color","red");
			}else if(data==2){
				//账号格式有误
				$("#accountmsg").css("color","red");
			}else if(data==3){
				//密码格式有误
				$("#pwmes").css("color","red");
			}else if(data==4){
				//邮箱格式有误
				$("#emailmes").css("color","red");
			}else if(data==5){
				//账号已存在
				$("#accountmsg").css("color","red");
				$("#accountmsg").html("账号已存在!请直接登录!");
			}else if(data==6){
				alert("注册成功!请前往注册邮箱激活账号，否则该账号不可使用!");
				//注册成功
				location.href="login.html";
			}else if(data==7){
				//数据插入失败
				alert("数据插入失败!请稍后再试!或者联系管理员!");
			}
		}
	});
}
$(function(){
	changePic();
	$("#change").click(function(){
		changePic();
	});
	$("#registerbtn").click(function(){
		register();
	});
});