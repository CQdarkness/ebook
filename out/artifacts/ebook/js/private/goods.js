
function showGoodsByPage(ppage){
	$.ajax({
		url:"goods",
		type:"POST",
		data:{
			oper:"showByPage",
			gtid:getParams("gtid"),
			page:ppage
		},
		dataType:"json",
		success:function(data){
			var goodsContent="";
			for (var index = 0; index < data.list.length; index++) {
				var g=data.list[index];
				goodsContent+="<li class='clearfix win'>"
					+"<div class='pic'>"
					+"	<a title='"+g.name+"' href='goodsDetail.html?gid="+g.id+"' target='_blank'>"
					+"	<img src='"+g.img+"' width='200' height='200' alt='"+g.name+"' title='"+g.name+"' /></a>"
					+"</div>"
					+"<h3 class='title'>"
					+"	<a class='p_name' href='goodsDetail.html?gid="+g.id+"' target='_blank' alt='"+g.name+"' title='"+g.name+"'>"+g.name+"</a>"
					+"	<span>总销量：500</span>"
					+"</h3>"
					+"<div class='handle'>"
					+"	<label class='btn_gray_m'><img"
					+"		src='images/front/ucenter/shopping.gif' width='15' height='15' /><input"
					+"		type='button' value='加入购物车' onclick='addCart("+g.id+")' /></label>"
					+"</div>"
					+"<div class='price' style='padding-top:18px'>￥"+g.sellprice+"<s>￥"+g.price+"</s>"
					+"</div>"
					+"</li>";
			}
			var pageBar="<a href='javascript:void(0)' onclick='firstPage()'>首页</a> ";
			for(var index=0;index<data.pages;index++){
				pageBar+="<a class='current_page' href='javascript:void(0)' onclick='showGoodsByPage("+(index+1)+")'>"+(index+1)+"</a>"
			}
			pageBar+="<a href='javascript:void(0)'  onclick='lastPage()'>尾页</a>";
			pageBar+="当前第<span id='currentPage'>"+data.pageNum+"</span>页/共<span id='totalPage'>"+data.pages+"</span>页";
			$("#page-bar").html(pageBar);
			$("#goods").html(goodsContent);
		}
	});
}
function lastPage(){
	var cp=$("#currentPage").html();
	var totalPage=$("#totalPage").html();
	if(cp!=totalPage){
		showGoodsByPage(totalPage);
	}
}
function firstPage(){
	var cp=$("#currentPage").html();
	if(cp!=1){
		showGoodsByPage(1);
	}
}
function addCart(pgid){
	$.ajax({
		url:"myCart",
		type:"POST",
		data:{
			oper:"update",
			gid:pgid,
			num:1
		},
		dataType:"json",
		success:function(data){
			if(data==1){
				alert("操作成功!")
			}
		}
	});
}
$(function(){
	if(getParams("oper")=="search"){
		search(getParams("word"),1);
	}else{
		showGoodsByPage(1);
	}
	showGoodsType();
	isLogin();
	$("#search-btn").click(function(){
		search($("#word").val(),1);
	});
});