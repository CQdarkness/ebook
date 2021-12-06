function showDetail(){
	$.ajax({
		url:"goods",
		type:"POST",
		data:{
			oper:"showGoodsDetial",
			gid:getParams("gid")
		},
		dataType:"json",
		success:function(data){
			$("#title").html(data.name);
			var content="<li><span class='f_r light_gray'>图书编号：<label id='data_goodsNo'>"+data.sno+"</label></span></li>"
							+"<li id='priceLi'>销售价：￥<b class='price red2'><span"
					+"		class='f30' id='real_price'>"+data.sellprice+"</span></b></li>"
							+"<li>市场价：￥<del id='data_marketPrice'>"+data.price+"</del>"
					+"</li>"
					+"<li>作者："+data.writer+"</li>"
					+"<li>出版社："+data.output+"</li>"
					+"<li>出版时间："+data.time+"</li>"
					+"<li>库存：现货<span>(<label id='data_storeNums'>"+data.inventory+"</label>)"
					+"</span>"
					+"</li>";
			$("#infor").html(content);
			$("#pic").prop("src",data.img);
			$("#pic").prop("title",data.name);
		}
	});
}
$(function(){
	showDetail();
	showGoodsType();
	isLogin();
	$("#search-btn").click(function(){
		location.href="goods.html?oper=search&word="+$("#word").val();
	});
});