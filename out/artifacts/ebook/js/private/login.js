function login(){
	$("#loginbtn").prop("disabled","disabled");
//	发送登录异步请求
	$.ajax({
		url:"user",
		type:"POST",
		data:{
			oper:"login",
			account:$("#login_info").val(),
			pass:$("#password").val()
		},
		dataType:"json",
		success:function(data){
//			alert(data);
//			for(var index=0;index<data.list.length;index++){
//				alert(data.list[index]);
//			}
			if(data==1){
				//登录成功
				location.href="index.html";
			}else if(data==2){
				//账号有误
				$("#namemsg").html("账号不存在!");
				$("#pwdmsg").empty();
				$("#loginbtn").removeAttr("disabled");
			}else if(data==3){
				//密码有误
				$("#pwdmsg").html("密码有误!");
				$("#namemsg").empty();
				$("#loginbtn").removeAttr("disabled");
			}
		}
	});
}
$(function(){
	//入口函数:在页面加载完成后执行
	$("#loginbtn").click(function(){
		login();
	});
});