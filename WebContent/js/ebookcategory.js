/* ebookcategory.js */

$(window).load(function() {

	$("#categorylist > a").mouseenter(function() {
		var p = $(this).offset();
		$(this).next().css("left", p.left + 180);
		$(this).next().css("top", p.top);
		$(this).next().show();
	});
	
	$("#categorylist > a").mouseleave(function() {
		$(this).next().hide();
	});
	
	$(".subcategorylist").mouseenter(function() {
		$(this).show();
	});
	
	$(".subcategorylist").mouseleave(function() {
		$(this).hide();
	});
	

});