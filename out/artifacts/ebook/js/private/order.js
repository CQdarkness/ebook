function showAddress(){
	$.ajax({
		url:"address",
		type:"POST",
		data:{
			oper:"show"
		},
		dataType:"json",
		success:function(data){
			var content="";
			for (var index = 0; index < data.length; index++) {
				content+="<li><label>";
				if(data[index].isdefault==1){
					content+="<input class='radio' checked='checked' name='addresses' type='radio' value='"+data[index].id+"' />";
				}else{
					content+="<input class='radio' name='addresses' type='radio' value='"+data[index].id+"' />";
				}
				content+="<span>"+data[index].recipient+"</span>&nbsp;&nbsp;&nbsp;&nbsp;"
				+"<span>"+data[index].tel+"</span>&nbsp;&nbsp;&nbsp;&nbsp;"
				+"<span>"+data[index].province+"</span>"
				+"<span>"+data[index].city+"</span>"
				+"<span>"+data[index].district+"</span>"
				+"<span>"+data[index].detailaddress+"</span>"
				+"</label></li>";
			}
			$("#address").html(content);
		}
	});
}
function showMyCart(){
	$.ajax({
		url:"myCart",
		type:"POST",
		data:{
			oper:"orderCheck",
			id:decodeURI(getParams("id"))
		},
		dataType:"json",
		success:function(data){
			var content="";
			var totalPrice=0.0;
			for (var index = 0; index < data.length; index++) {
				var g=data[index];
				content+="<tr>"
					+"<td><img src='"+g.img+"' width='66px'"
					+"height='66px' alt='"+g.name+"' title='"+g.name+"' /></td>"
					+"<td class='t_l'><a href='goods?opr=view&amp;id=518'"
					+"class='blue' target='_blank'>"+g.name+"</a></td>"
					+"<td>￥<b>"+g.sellprice+"</b></td>"
					+"<td>"+g.number+"</td>"
					+"<td>￥<b class='red2'>"+(g.number*g.sellprice)+"</b></td>"
					+"</tr>";
				totalPrice+=g.number*g.sellprice;
			}
			$("#myCart-list").html(content);
			$(".totalPrice").html(totalPrice);
		}
	});
}
function createOrder(){
	$.ajax({
		url:"order",
		type:"POST",
		data:{
			oper:"createOrder",
			addressid:$("input[name='addresses']:checked").val()
		},
		dataType:"json",
		success:function(data){
			if(data.indexOf("订单创建成功")!=-1){
				location.href="/woniumall2.0.0/orderFinish.html";
			}else{
				alert(data);
				location.reload();
			}
		}
	});
}
$(function(){
	showAddress();
	showMyCart();
	$("#createOrder-btn").click(function(){
		createOrder();
	});
	isLogin();
//	json -> Object
//	alert(JSON.parse(decodeURI(getParams("id")))[0]);
});