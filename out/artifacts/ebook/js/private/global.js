function getParams(key) {  
	var url = location.search; //获取url中"?"符后的字串  
	var val;  
	if (url.indexOf("?") != -1) {  
		var str = url.substr(1);  
		strs = str.split("&");  
		for(var i = 0; i < strs.length; i ++) {
			if(key==strs[i].split("=")[0]){
				val=decodeURI(strs[i].split("=")[1]);  
			}
		}  
	}
	return val;  
}
function showGoodsType(){
	$.ajax({
		url:"goodsType",
		type:"POST",
		data:{
			oper:"showAll"
		},
		dataType:"json",
		success:function(data){
			var content="";
			var sortContent="";
			for(var index=0;index<data.length;index++){
				var goodsType=data[index];
//				alert(goodsType.name);
				content+=" <li><a href='goods.html?gtid="+goodsType.id+"'>"+goodsType.name+"</a></li>";
				sortContent+="<li><h2><a href='goods.html?gtid="+goodsType.id+"'>"+goodsType.name+"</a></h2></li>";
			}
			$("#goodsType").append(content);
			$("#div_allsort").html(sortContent);
		}
	});
}
function isLogin(){
	$.ajax({
		url:"user",
		type:"POST",
		data:{
			oper:"isLogin"
		},
		dataType:"json",
		success:function(data){
			var content="";
			if(data!=0){
				content+="<ul class='shortcut'>"
					+"<li class='first'><a href='personal.html'>个人中心</a></li>"
					+"<li><a href='myOrders.html'>我的订单</a></li>"
					+"</ul>"
					+"<p class='loginfo'>你好!"+data.account+"[<a href='javaScript:logout()'>安全退出</a>]</p>";
			}else{
				content+="<p class='loginfo'>"
					+"[<a href='login.html'>登录</a> <a class='reg' href='register.html'>免费注册</a>]"
					+"</p>";
			}
			$("#header").append(content);
		}
	});
}
function logout(){
	$.ajax({
		url:"user",
		type:"POST",
		data:{
			oper:"logout"
		},
		dataType:"json",
		success:function(data){
			location.href="/woniumall2.0.0/index.html";
		}
	});
}
function countMyCart(){
	$.ajax({
		url:"myCart",
		type:"POST",
		data:{
			oper:"count"
		},
		dataType:"json",
		success:function(data){
			$("#mycart_nums").text(data);
		}
	});
}
function search(pword,ppage){
	$.ajax({
		url:"goods",
		type:"POST",
		data:{
			oper:"search",
			word:pword,
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
					+"	<span>总销量：500(0人评论)</span><span class='grade' lay-data=''><i style='width: 56px'></i></span>"
					+"</h3>"
					+"<div class='handle'>"
					+"	<label class='btn_gray_m'><img"
					+"		src='images/front/ucenter/shopping.gif' width='15' height='15' /><input"
					+"		type='button' value='加入购物车' onclick='joinCart_list(1);' /></label>"
					+"</div>"
					+"<div class='price'>￥"+g.sellprice+"<s>￥"+g.price+"</s>"
					+"</div>"
					+"</li>";
			}
			var pageBar="<a href='javascript:void(0)' onclick='search(\""+pword+"\",1)'>首页</a> ";
				for(var index=0;index<data.pages;index++){
					pageBar+="<a class='current_page' href='javascript:void(0)' onclick='search(\""+pword+"\","+(index+1)+")'>"+(index+1)+"</a>"
				}
				pageBar+="<a href='javascript:void(0)'  onclick='search(\""+pword+"\","+data.pages+")'>尾页</a>";
				pageBar+="当前第<span id='currentPage'>"+data.pageNum+"</span>页/共<span id='totalPage'>"+data.pages+"</span>页";
			$("#page-bar").html(pageBar);
			$("#goods").html(goodsContent);
		}
	});
}
$(function(){
	countMyCart();
});