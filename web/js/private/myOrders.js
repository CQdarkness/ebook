function showOrder(ppage){
	$.ajax({
		url:"personal",
		type:"POST",
		data:{
			oper:"order",
			page:ppage
		},
		dataType:"json",
		success:function(data){
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
			$("#currentPage").html(data.currentPage);
			$("#totalPage").html(data.totalPage);
			var pages="";
			for (var i = 0; i < data.totalPage; i++) {
				pages+="<a href='javascript:void(0)' class='current_page'>"+(i+1)+"</a> ";
			}
			$("#pages").html(pages);
		}
	});
}
$(function(){
	showOrder(1);
	isLogin();
});