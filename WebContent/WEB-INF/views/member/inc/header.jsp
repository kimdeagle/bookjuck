<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div class="container">

    <!-- header -->
    <header>

        <!-- 상단메뉴 -->

        <div id="headerlink">
            <a href="#" class="headerlink-item">마이페이지</a>
            <a href="#" class="headerlink-item">로그인</a>
            <a href="#" class="headerlink-item">회원가입</a>
            <a href="#" class="headerlink-item">장바구니</a>
            <a href="#" class="headerlink-item">주문/배송조회</a>
            <a href="#" class="headerlink-item">고객센터</a>
        </div>

        <!-- 로고, 캐릭터, 검색창 -->

        <div id="searchmenu">

            <!-- 로고 및 캐릭터 -->
            <img src="/bookjuck/image/bookjeok/logo.png" class="logo">
            
            <!-- 통합검색창(검색분류선택창) -->
            <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-expanded="false">통합검색<span class="caret"></span></a>
            <!-- <ul class="dropdown-menu" role="menu">
                <li><a href="#">Action</a></li>
                <li><a href="#">Another action</a></li>
                <li><a href="#">Something else here</a></li>
                <li class="divider"></li>
                <li><a href="#">Separated link</a></li>
                <li class="divider"></li>
                <li><a href="#">One more separated link</a></li>
            </ul> -->

            <div class="searchdiv inline">
                <input type="text" id="search" class="form-control noline small inline">
                <input type="button" id="searchbtn" value="검색" class="btn btn-general noline">
            </div>

            <!-- 실시간검색어(현우님이 나중에 수정해주셔야 함! id랑 class는 CSS때문에 주의!) -->
            <div id="realtime" class="inline">실시간검색어</div>

        </div>

        <!-- 도서분류메뉴(navbar) -->
        <nav class="navbar">
            <div class="container-fluid">
                <div class="collapse navbar-collapse">
                    <ul class="nav navbar-nav">
                        <li><a href="#" class="nav-item">베스트도서</a></li>
                        <li><a href="#" class="nav-item">신간도서</a></li>
                        <li><a href="#" class="nav-item">국내도서</a></li>
                        <li><a href="#" class="nav-item">해외도서</a></li>
                        <li><a href="#" class="nav-item">E-Book</a></li>
                        <li><a href="#" class="nav-item">중고게시판</a></li>
                    </ul>
                </div>
            </div>
        </nav>
    </header>
</div>