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
	
	/* E-Book 선택 > 파일명 가져오기 */
	var fileTarget = $("#ebook");
	fileTarget.on("change", function() {
		var filename = $(this)[0].files[0].name;
		$(this).siblings("#ebookname").val(filename);
	});
	
	//도서추가 -> 추가 버튼 클릭
	$("#btnadd").click(function() {
		if (!($("#imagename").val().toLowerCase().endsWith("jpg") || $("#imagename").val().toLowerCase().endsWith("gif") || $("#imagename").val().toLowerCase().endsWith("png"))) {
			//이미지가 아니면
			alert("지원되는 이미지 파일만 첨부할 수 있습니다.");
			return;
		} else {		
			$("#formAdd").submit();
		}
	});
	
	//도서수정 -> 수정 버튼 클릭
	$("#btnedit").click(function() {
		if (!($("#imagename").val().toLowerCase().endsWith("jpg") || $("#imagename").val().toLowerCase().endsWith("gif") || $("#imagename").val().toLowerCase().endsWith("png"))) {
			//이미지가 아니면
			alert("지원되는 이미지 파일만 첨부할 수 있습니다.");
			return;
		} else {		
			$("#formEdit").submit();
		}
	});
	
	//작가 새로추가 -> seqAuthor 삭제
	$("#btnaddauthor").click(function() {
		$("#seqAuthor").val("");
	});
	
	

});