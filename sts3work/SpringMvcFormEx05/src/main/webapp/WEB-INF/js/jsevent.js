$(function(){
	$("#myimg").attr("src","../image/07.png");
	
	$("#myimg").hover(function(){
	 	$(this).attr("src","../image/08.png");
	}, function(){
	 	$(this).attr("src","../image/07.png");
	});
	
});