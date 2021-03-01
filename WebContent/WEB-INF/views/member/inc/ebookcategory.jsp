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
		<c:forEach items="${mCategoryList}" var="mdto">
			<c:if test="${mdto.seqLCategory == 1}">
				<a href="#!">${mdto.mCategory}</a>
				<div class="subcategorylist">
				<c:forEach items="${sCategoryList}" var="sdto">
					<c:if test="${mdto.mCategory == sdto.mCategory}">
						<a href="/bookjuck/member/book/ebooklist.do?seqLCategory=${sdto.seqLCategory}&seqMCategory=${sdto.seqMCategory}&seqSCategory=${sdto.seqSCategory}">${sdto.sCategory}</a>
					</c:if>
				</c:forEach>
				</div>
			</c:if>
		</c:forEach>
		<h6>해외E-Book</h6>
		<c:forEach items="${mCategoryList}" var="mdto">
			<c:if test="${mdto.seqLCategory == 2}">
				<a href="#!">${mdto.mCategory}</a>
				<div class="subcategorylist">
				<c:forEach items="${sCategoryList}" var="sdto">
					<c:if test="${mdto.mCategory == sdto.mCategory}">
						<a href="/bookjuck/member/book/ebooklist.do?seqLCategory=${sdto.seqLCategory}&seqMCategory=${sdto.seqMCategory}&seqSCategory=${sdto.seqSCategory}">${sdto.sCategory}</a>
					</c:if>
				</c:forEach>
				</div>
			</c:if>
		</c:forEach>
	</div>

</aside>

