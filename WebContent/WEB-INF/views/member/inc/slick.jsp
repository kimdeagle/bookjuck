<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    
<!-- 도서 회전 영역 -->
<section class="section">
    <div class="slick-items">
        <div class="slick-item">
            <img src="image/달러구트 꿈 백화점.png" class="book-sm">
            <h6>달러구트 꿈 백화점</h6>
            <p>여기는 잠들어야만 입장할 수 있는 ‘달러구트 꿈 백화점’입니다</p>
        </div>
		
        <div class="slick-item">
            <img src="image/어떻게 살 것인가.png" class="book-sm">
            <h6>어떻게 살 것인가</h6>
            <p>멘붕 사회에 해독제로 쓰일 책</p>
        </div>

        <div class="slick-item">
            <img src="image/유럽 도시 기행 1.png" class="book-sm">
            <h6>유럽 도시 기행 1</h6>
            <p>‘인생은 너무 짧은 여행’이란 말에 끌려 시작한 유럽 탐사</p>
        </div>

        <div class="slick-item">
            <img src="image/일중독자의 여행.png" class="book-sm">
            <h6>일중독자의 여행</h6>
            <p>형과 함께한 특별한 길</p>
        </div>

        <div class="slick-item">
            <img src="image/일인칭 단수.png" class="book-sm">
            <h6>일인칭 단수</h6>
            <p>하루키 월드를 구성하는 다채로운 요소들을 한데 만나볼 수 있는 단편집</p>
        </div>
    </div>
</section>

<!-- 스크립트 영역 -->
<!-- 도서 회전 -->
<script type="text/javascript">

	$(document).ready(function () {
	    $('.slick-items').slick({
	        autoplay : true,
	        dots: true,
	        speed : 300 /* 이미지가 슬라이딩시 걸리는 시간 */,
	        infinite: true,
	        autoplaySpeed: 1000 /* 이미지가 다른 이미지로 넘어 갈때의 텀 */,
	        arrows: true,
	        slidesToShow: 3,
	        slidesToScroll: 1,
	        fade: false
	    });
	});

</script>