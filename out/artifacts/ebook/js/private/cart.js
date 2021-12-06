function showMyCarts(){
	$.ajax({
		url:"myCart",
		type:"POST",
		data:{
			oper:"search"
		},
		async:false,
		dataType:"json",
		success:function(data){
			var content="";
			for(var index=0;index<data.length;index++){
				var myCart=data[index];
				content+="<tr>"
					+"<td><input type='checkbox' name='goodsid' value='"+myCart.id+"' /></td>"
					+"<td><img src='"+myCart.img+"' width='66px'"
					+"	height='66px' alt='"+myCart.name+"' title='"+myCart.name+"' /></td>"
					+"<td class='t_l'><a"
					+"	href='goods?opr=view&amp;id="+myCart.id+"'"
					+"	class='blue'>"+myCart.name+"</a></td>"
					+"	<td>￥<b id='goods_price_"+myCart.id+"'>"+myCart.sellprice+"</b></td>"
					+"<td>"
					+"	<div class='num'>"
					+"		<a class='reduce' href='javascript:void(0)' data-id='"+myCart.id+"'>-</a> <input"
					+"			name='num' class='tiny' value='"+myCart.number+"' data-id='"+myCart.id+"'"
					+"			type='text' id='goods_num_"+myCart.id+"' > <a"
					+"			class='add' href='javascript:void(0)'"
					+"			data-id='"+myCart.id+"'>+</a>"
					+"	</div>"
					+"</td>"
					+"<td>￥<b class='red2' id='goods_sum_"+myCart.id+"'>"+(myCart.sellprice*myCart.number)+"</b></td>"
					+"<td><a href='javascript:void(0)'"
					+"	onclick=''>删除</a></td>"
					+"</tr>";
			}
			content+="<tr class='stats'><td colspan='8'>金额总计（不含运费）：￥<b class='orange'id='totalmoney'>0.0</b></td></tr>";
			$("#bookList").html(content);
		}
	});
}
$(function(){
	showMyCarts();
	isLogin();
});
$(function() {
	getTotalMoney();
	//全选复选框注册单击事件
	$("#selAll").click(function() {
		$(":checkbox[name=goodsid]").prop("checked",$(this).prop("checked"));
		getTotalMoney();
	});
	//商品复选框注册单击事件
	function selGoods() {
		if ($("[name=goodsid]:checked").length == $("[name=goodsid]").length) {
			$("#selAll").prop("checked", true);
		} else {
			$("#selAll").prop("checked", false);
		}
		getTotalMoney();
	}
	$("[name=goodsid]").click(selGoods);
	
	//更新数量按钮注册单击事件
	$(".add").click(function() {
		let id = $(this).data("id");
		let price = $("#goods_price_" + id).text();
		let nums = $("#goods_num_" + id);
		nums.val(parseInt(nums.val()) + 1);
		$("[name=goodsid][value=" + id + "]").prop("checked", true);
		$("#goods_sum_" + id).text((price * nums.val()).toFixed(2));
		selGoods();
	});
	//更新数量按钮注册单击事件
	$(".reduce").click(function() {
		let id = $(this).data("id");
		let price = $("#goods_price_" + id).text();
		let nums = $("#goods_num_" + id);
		if (nums.val() == 1) {
			return;
		}
		nums.val(parseInt(nums.val()) - 1);
		$("[name=goodsid][value=" + id + "]").prop("checked", true);
		$("#goods_sum_" + id).text((price * nums.val()).toFixed(2));
		selGoods();
	});

	$(":input[name=num]").change(function() {
		let num=$(this).val();
		if(isNaN(num)){
			alert("数量无效");
			return;
		}
		if(num<1){
			alert("数量无效");
			return;
		}
		let id=$(this).data("id");
		$("[name=goodsid][value=" + id + "]").prop("checked", true);
		let price = $("#goods_price_" + id).text();
		$("#goods_sum_" + id).text((price * num).toFixed(2));
		selGoods();
	})
});

//计算总金额
function getTotalMoney() {
	let totalMoney = 0;
	$("[name=goodsid]:checked").each(function() {
		let price = $("#goods_price_" + $(this).val()).text();
		let num = $("#goods_num_" + $(this).val()).val();
		totalMoney += price * num;
	});
	$("#totalmoney").text(totalMoney.toFixed(2));
}

function finish() {
	if ($("[name=goodsid]:checked").length == 0) {
		alert("请至少选中一件商品");
		return;
	}
	var arr=new Array();
	$("[name=goodsid]:checked").each(function() {
		arr.push($(this).val());
	});
//	Object->json JSON.stringify(Object)
	location.href="/woniumall2.0.0/order.html?id="+encodeURI(JSON.stringify(arr));
}

function del(id, cart) {
	if (confirm("您确认删除吗?")) {
		$.getJSON("cart?opr=del&id=" + id, function(result) {
			if (result.code == 200) {
				$(cart).parent().parent().remove();
				selGoods();
			} else {
				alert("系统维护中...")
			}
		});
	}
}