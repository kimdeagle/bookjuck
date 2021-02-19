/* admin/book/adminbook.js */

$(window).load(function() {
	/* 작가 새로 추가 클릭 시 입력창 활성화 */
	$("#btnaddauthor").click(function() {
		$("#authorname").removeAttr("readonly");
		$("#authorname").val("");
		$("#authorintro").removeAttr("readonly");
		$("#authorintro").val("");
		
	});
	
	/* 이미지 선택 > 파일명 가져오기 */
	var fileTarget = $("#image");
	fileTarget.on("change", function() {
		var filename = $(this)[0].files[0].name;
		$(this).siblings("#imagename").val(filename);
	});	

});

/* 카테고리 모달 > 카테고리 선택 완료 */
function selcategory() {
	$("#firstcategory").val($("#selfirstcategory").val());
	$("#secondcategory").val($("#selsecondcategory").val());
	$("#thirdcategory").val($("#selthirdcategory").val());
	$("#categorymodal").modal("hide");
}

/* 작가선택 모달 > 작가 선택 완료 (맞는건가...) */
function selauthor() {
	
	$("#authorname").val($("#tblauthorlist input[type=radio]:checked").parent().next().text());
	$("#authorintro").val($("#tblauthorlist input[type=radio]:checked").parent().next().next().text());
	$("#authorname").attr("readonly", true);
	$("#authorintro").attr("readonly", true);
	$("#authormodal").modal("hide");
}

