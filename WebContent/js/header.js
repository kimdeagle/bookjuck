/* header JavaScript */

/* 국내도서, 해외도서 mouse event 관련 JavaScript */
$(window).load(function() {
	
	/* 국내도서 중분류 */
	$("#internalbook").mouseenter(function() {
		var p = $("#internalbook").offset();	
		$("#internalmenu").css("left", p.left);
		$("#internalmenu").css("top", p.top + 50);
		$("#internalmenu").show();
	});
	
	$("#internalbook").mouseleave(function() {
		$("#internalmenu").hide();
	});
	
	$("#internalmenu").mouseenter(function() {
		$("#internalmenu").show();
	});
	
	$("#internalmenu").mouseleave(function() {
		$("#internalmenu").hide();
	});
	
	/* 해외도서 중분류 */
	$("#externalbook").mouseenter(function() {
		var p = $("#externalbook").offset();	
		$("#externalmenu").css("left", p.left);
		$("#externalmenu").css("top", p.top + 50);
		$("#externalmenu").show();
	});
	
	$("#externalbook").mouseleave(function() {
		$("#externalmenu").hide();
	});
	
	$("#externalmenu").mouseenter(function() {
		$("#externalmenu").show();
	});
	
	$("#externalmenu").mouseleave(function() {
		$("#externalmenu").hide();
	});

});

