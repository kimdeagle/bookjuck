<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<aside>
    <!-- 마이페이지 좌측메뉴 -->

    <div id="introtitle">
        <h6 class="h6-white">MY ACCOUNT</h6>
    </div>

    <div id="intro">
        <p>어서오세요, <strong>${name}</strong>님!</p>
        <p><a href="/bookjuck/member/mypage/point.do">포인트 : ${points}원 </a></p>
    </div>

    <div id="mypagemenu">
        <ul>
            <li class="menuitem"><h6>나의 주문 내역</h6></li>
                <ul>
                    <li class="menusubitem"><a href="/bookjuck/member/mypage/orderlist.do">주문/배송/결제</a></li>
                    <li class="menusubitem"><a href="/bookjuck/member/refund/list.do">교환/환불/취소</a></li>
                </ul>
            <li class="menuitem"><h6>나의 정보</h6></li>
                <ul>
                    <li class="menusubitem"><a href="/bookjuck/member/mypage/custinfo.do">회원정보 조회/수정 </a></li>
                    <li class="menusubitem"><a href="/bookjuck/member/mypage/pwedit.do">비밀번호 수정</a></li>
                    <li class="menusubitem"><a href="/bookjuck/member/mypage/withdrawal.do">회원탈퇴</a></li>
                </ul>
            <li class="menuitem"><h6>기타</h6></li>
                <ul>
                    <li class="menusubitem"><a href="/bookjuck/member/order/cart.do">장바구니</a></li>
                    <li class="menusubitem"><a href="/bookjuck/member/fleamarket/list.do">중고게시판</a></li>
                    <li class="menusubitem"><a href="/bookjuck/member/review/list.do">나의 독후감</a></li>
                </ul>
            <li class="menuitem"><h6>고객센터</h6></li>
                <ul>
                    <li class="menusubitem"><a href="/bookjuck/member/qna/list.do">QnA</a></li>
                	<li class="menusubitem"><a href="/bookjuck/member/faq/list.do">자주 하는 질문</a></li>
                </ul>
        </ul>
    </div>
</aside>
