/* inlist JavaScript */

$(window).load(function() {
	
	/* 수량 증감 js */
	var c;
		
	$("#plus").click(function() {
		c = $("#cnt").val();
		c++;
		$("#cnt").val(c);
	});
	
	$("#minus").click(function() {
		c = $("#cnt").val();
		if (c > 1) {
			c--;
			$("#cnt").val(c);
		}
	});

});

