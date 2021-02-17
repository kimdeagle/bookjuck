/* ebookcategory.js */

$(window).load(function() {

	$("#categorylist a").mouseenter(function() {
		var p = $(this).offset();
		$("#subcategorylist").css("left", p.left + 180);
		$("#subcategorylist").css("top", p.top);
		$("#subcategorylist").show();
	});
	
	$("#categorylist a").mouseleave(function() {
		$("#subcategorylist").hide();
	});
	
	$("#subcategorylist").mouseenter(function() {
		$("#subcategorylist").show();
	});
	
	$("#subcategorylist").mouseleave(function() {
		$("#subcategorylist").hide();
	});		
});