function showAddress(){
	$.ajax({
		url:"personal",
		type:"POST",
		data:{
			oper:"showAddress"
		},
		dataType:"json",
		success:function(data){
			var content="";
			for (var i = 0; i < data.length; i++) {
				content+="<tr>"
						+"<td>"+data[i].recipient+"</td>"
						+"<td>"+data[i].province+data[i].city+data[i].district+"</td>"
						+"<td>"+data[i].detailaddress+"</td>"
						+"<td>"+data[i].tel+"</td>"
						+"<td><a class='blue' href='javascript:void(0)'"
						+"onclick='update(1)'>修改</a>| 默认地址</td>"
						+"</tr>";
			}
			$("#addressdata").html(content);
		}
	});
}
$(function(){
	isLogin();
	showAddress();
});