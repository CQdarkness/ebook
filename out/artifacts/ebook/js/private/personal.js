function showInfor(){
	$.ajax({
		url:"personal",
		type:"POST",
		data:{
			oper:"personalIndex"
		},
		dataType:"json",
		success:function(data){
			$("#account").text(data.username);
			$("#user_ico_img").prop("src",data.icon);
			$("#countOrder").text(data.countOrder+"笔");
			$("#countPrice").text("￥"+data.countPrice);
			$("#countNotPay").text(data.countNotPay);
			$("#countNotReceive").text(data.countNotReceive);
			var order="";
			for (var index = 0; index < data.orders.length; index++) {
				var o=data.orders[index];
				order+="<tr>"
						+"		<td><a href='#' class='orange'>"+o.ordernumber+"</a></td>"
						+"			<td>"+o.time+"</td>"
						+"			<td>"+o.recipient+"</td>"
						+"			<td>支付宝</td>"
						+"			<td>￥"+o.totalPrice+"</td>";
				if(o.status==1){
					order+="<td>待支付</td>";
				}else if(o.status==2){
					order+="<td>已支付</td>";
				}else if(o.status==3){
					order+="<td>退款中</td>";
				}else if(o.status==4){
					order+="<td>已退款</td>";
				}else if(o.status==5){
					order+="<td>待收货</td>";
				}else if(o.status==6){
					order+="<td>已完成</td>";
				}else{
					order+="<td>无效状态</td>";
				}
				order+="</tr>";
			}
			$("#orderData").html(order);
		}
	});
}
$(function(){
	showInfor();
	isLogin();
});