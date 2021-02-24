<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<aside>
	<!-- 카테고리 좌측메뉴 -->
	<div id="categorytitle">
		<h6 class="h6-white">E-Book</h6>
	</div>

	<div id="categorylist">
		<h6>국내E-Book</h6>
		<c:forEach items="${mCategoryList}" var="dto">
			<c:if test="${dto.seqLCategory == 1}">
				<a href="#">${dto.mCategory}</a>
				<div class="subcategorylist">
				<c:forEach items="${categoryList}" var="sdto">
					<c:if test="${dto.mCategory == sdto.mCategory}">
						<a href="/bookjuck/member/book/ebooklist.do?seqLCategory=${sdto.seqLCategory}&lCategory=${sdto.lCategory}&seqMCategory=${sdto.seqMCategory}&mCategory=${sdto.mCategory}&seqSCategory=${sdto.seqSCategory}&sCategory=${sdto.sCategory}">${sdto.sCategory}</a>
					</c:if>
				</c:forEach>
				</div>
			</c:if>
		</c:forEach>
		<h6>해외E-Book</h6>
		<c:forEach items="${mCategoryList}" var="dto">
			<c:if test="${dto.seqLCategory == 2}">
				<a href="#">${dto.mCategory}</a>
				<div class="subcategorylist">
				<c:forEach items="${categoryList}" var="sdto">
					<c:if test="${dto.mCategory == sdto.mCategory}">
						<a href="/bookjuck/member/book/ebooklist.do?seqLCategory=${sdto.seqLCategory}&lCategory=${sdto.lCategory}&seqMCategory=${sdto.seqMCategory}&mCategory=${sdto.mCategory}&seqSCategory=${sdto.seqSCategory}&sCategory=${sdto.sCategory}">${sdto.sCategory}</a>
					</c:if>
				</c:forEach>
				</div>
			</c:if>
		</c:forEach>
	</div>

</aside>

