
$(window).load(function() {
	$(".btnDel").click(function() {
		var seq = $(this).val();
		$("#delok").click(function() {
			location.href = "/bookjuck/admin/book/delok.do?seq=" + seq;
		});
	});	
});