function showCurrentOrder(){
	$.ajax({
		url:"order",
		type:"POST",
		data:{
			oper:"showCurrentOrder"
		},
		dataType:"json",
		success:function(data){
			var content="<tr>"
						+"<th>订单编号：</th>"
						+"<td class='f18 bold red2'>"+data.ordernumber+"</td>"
						+"</tr>"
						+"<tr>"
						+"<th>订单金额：</th>"
						+"<td class='f18 bold red2'>￥<b>"+data.totalPrice+"</b></td>"
						+"</tr>";
			$("#payType").before(content);
		}
	});
}
$(function(){
	showCurrentOrder();
	isLogin();
});