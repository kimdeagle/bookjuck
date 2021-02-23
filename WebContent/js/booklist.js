/* booklist JavaScript */

$(window).load(function() {
	
	/* 수량 증감 js */
	var c;
		
	$(".plus").click(function() {
		c = $(this).prev().val();
		c++;
		$(this).prev().val(c);
	});
	
	$(".minus").click(function() {
		c = $(this).next().val();
		if (c > 1) {
			c--;
			$(this).next().val(c);
		}
	});

});

