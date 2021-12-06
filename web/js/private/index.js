
function showNewest(){
	$.ajax({
		url:"goods",
		type:"POST",
		data:{
			oper:"showNewest"
		},
		dataType:"json",
		success:function(data){
			var content="";
			for(var index=0;index<data.length;index++){
				var goods=data[index];
				content+="<li style='overflow: hidden'><a"
					+" href='goodsDetail.html?gid="+goods.id+"' target='_blank'><img"
					+"	src='"+goods.img+"'"
					+"	width='175' height='175'"
					+"	alt='"+goods.name+"'"
					+"	title='"+goods.name+"' /></a>"
					+"<p class='pro_title'>"
					+"	<a title='"+goods.name+"'"
					+"		href='goods?opr=view&amp;id=137'>"+goods.name+"</a>"
					+"</p>"
					+"<p class='brown'>"
					+"	惊喜价：￥<b>"+goods.sellprice+"</b>"
					+"</p>"
					+"<p class='light_gray'>"
					+"	市场价： ￥"
					+"	<del>"+goods.price+"</del>"
					+"</p></li>";
			}
			$("#newest").html(content);

		}
	});
}
function showHot(){
	$.ajax({
		url:"goods",
		type:"POST",
		data:{
			oper:"showHot"
		},
		dataType:"json",
		success:function(data){
			var content="";
			for(var index=0;index<data.length;index++){
				var goods=data[index];
				content+="<li><a"
						+" href='goodsDetail.html?gid="+goods.id+"'><img	src='"+goods.img+"'"
						+"	width='85' height='85'"
						+"	alt='"+goods.name+"'"
						+"	title='"+goods.name+"'></a>"
						+"	<p class='pro_title'>"
						+"	<a href='goodsDetail.html?gid="+goods.id+"'>"+goods.name+"</a>"
						+"	</p>"
						+"	<p class='brown'>"
						+"	￥<b>"+goods.sellprice+"</b>"
						+"	</p></li>";
			}
			$("#hot").html(content);

		}
	});
}

$(function(){
	showGoodsType();
	showNewest();
	showHot();
	isLogin();
	$("#search-btn").click(function(){
		location.href="goods.html?oper=search&word="+$("#word").val();
	});
});