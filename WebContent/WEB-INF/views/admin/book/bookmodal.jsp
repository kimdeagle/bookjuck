<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!-- 도서관리 > 모달 모음 > 조각 페이지 -->

<!-- 카테고리 선택 버튼 클릭 > 모달 -->
<div class="modal fade" id="categorymodal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
	<div class="modal-dialog">
	    <div class="modal-content">
			<div class="modal-header">
		        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
		        <h4 class="modal-title" id="myModalLabel">카테고리 선택</h4>
			</div>
			<div class="modal-body">
				<table class="table tblcategory">
					<thead>
						<tr>
							<th>1차 카테고리</th>
							<th>2차 카테고리</th>
							<th>3차 카테고리</th>
						</tr>
					</thead>
					<tbody>
						<tr>
							<td>
								<select class="form-control" id="selfirstcategory">
									<option>선택</option>
									<option>국내도서</option>
									<option>해외도서</option>
								</select>
							</td>
							<td>
								<select class="form-control" id="selsecondcategory">
									<option>선택</option>
									<option>소설</option>
									<option>시/에세이</option>
									<option>만화</option>
								</select>
							</td>
							<td>
								<select class="form-control" id="selthirdcategory">
									<option>선택</option>
									<option>국내소설</option>
									<option>해외소설</option>
								</select>
							</td>
						</tr>
					</tbody>
					
				</table>
			</div>
			<div class="modal-footer">
		        <button type="button" class="btn btn-primary" onclick=selcategory();>선택완료</button>
		        <button type="button" class="btn btn-default" data-dismiss="modal">취소</button>
			</div>
		</div>
	</div>
</div>


<!-- 작가 검색 버튼 클릭 > 모달 -->
<div class="modal fade" id="authormodal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
	<div class="modal-dialog modal-lg">
	    <div class="modal-content">
			<div class="modal-header">
		        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
		        <h4 class="modal-title" id="myModalLabel">작가 검색</h4>
			</div>
			<div class="modal-body">
			
				<input type="text" class="form-control" id="searchauthor" placeholder="작가명을 입력하세요.">
				<input type="button" class="btn btn-default" id="btnsearchauthor" value="검색">
				
				<table class="table table-hover" id="tblauthorlist">
					<thead>
						<tr>
							<th>선택</th>
							<th>작가명</th>
							<th>작가 소개</th>
						</tr>
					</thead>
					<tbody>
						<tr>
							<td>
								<input type="radio" name="authorlist" id="authorlistname1">
							</td>
							<td><label for="authorlistname1">김소월</label></td>
							<td>유명한 시인이시다...</td>
						</tr>
						<tr>
							<td>
								<input type="radio" name="authorlist" id="authorlistname2">
							</td>
							<td><label for="authorlistname2">덤블도어</label></td>
							<td>유명한 마법사이시다...</td>
						</tr>
					</tbody>
					
				</table>
			</div>
			<div class="modal-footer">
		        <button type="button" class="btn btn-primary" onclick=selauthor();>선택완료</button>
		        <button type="button" class="btn btn-default" data-dismiss="modal">취소</button>
			</div>
		</div>
	</div>
</div>

<!-- 이미지 미리보기 클릭 > 모달 -->
<div class="modal fade" id="previewimagemodal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
	<div class="modal-dialog">
	    <div class="modal-content">
			<div class="modal-header">
		        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
		        <h4 class="modal-title" id="myModalLabel">미리보기</h4>
			</div>
			<div class="modal-body" style="text-align: center;">
			
				<img src="/bookjuck/image/해리포터와 혼혈 왕자 1.png" style="width: 300px;">
				
			</div>
			<div class="modal-footer">
		        <button type="button" class="btn btn-default" data-dismiss="modal">닫기</button>
			</div>
		</div>
	</div>
</div>

<!-- E-Book 미리보기 클릭 > 모달 -->
<div class="modal fade" id="previewebookmodal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
	<div class="modal-dialog modal-lg">
	    <div class="modal-content">
			<div class="modal-header">
		        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
		        <h4 class="modal-title" id="myModalLabel">미리보기</h4>
			</div>
			<div class="modal-body" style="text-align: center;">
			
				<iframe width="100%" height="600" src="/bookjuck/ebook/test.pdf"></iframe>
				
			</div>
			<div class="modal-footer">
		        <button type="button" class="btn btn-default" data-dismiss="modal">닫기</button>
			</div>
		</div>
	</div>
</div>

<!-- 삭제 클릭 > 모달 -->
<div class="modal fade" id="deletemodal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
	<div class="modal-dialog">
	    <div class="modal-content">
			<div class="modal-header">
		        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
		        <h4 class="modal-title" id="myModalLabel">삭제하시겠습니까?</h4>
			</div>
			<div class="modal-body" style="text-align: center;">
			
				<button type="button" class="btn btn-danger" onclick="location.href='/bookjuck/admin/book/deleteok.do';">예</button>				
		        <button type="button" class="btn btn-default" data-dismiss="modal">아니오</button>
				
			</div>
		</div>
	</div>
</div>

