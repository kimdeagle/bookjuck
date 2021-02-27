package com.test.bookjuck.dummy;

import java.util.Calendar;
import java.util.Random;

public class BookOrderDummy {

	public static void main(String[] args) {

		// 종이책 주문 tblBookOrder --
		// 회원 주문 1000건, 비회원 주문 50건
		// 주문 상태 : 주문완료, 결제완료, 결제취소 -100건, 배송종, 배송완료, 주문교환 --100건, 주문 환불 --100건
		// 비회원 취소, 교환, 환불 안됨
		// 주문번호
		// insert into tblBookOrder(seq,seqMember,seqNonMember,orderDate,orderState)
		// values(seqBookOrder.nextVal,21,null,to_date('2021-01-03
		// 10:11:11','YYYY-MM-DD'),'주문취소');

		// 회원 1000,
		// 주문번호 1~800 카드결제, 801~1000 무통장
		// 주문번호 1~699 배송중/배송완료, 700~800 주문 취소, 801~900 주문교환, 901~1000, 주문 환불

		// 400, 401 699
//
//		String[] orderState = {"배송중","배송완료","배송완료","배송완료","배송완료","배송완료","배송완료","배송완료","배송완료","배송완료"};
//		
//		Random rnd = new Random();
//		
//		int n = 1;
//		for(int i=1; i<=50; i++) {
//			
//			int year = (int)(Math.random()*2);
//			int month = (int)(Math.random()*12)+1;
//			int day = (int)(Math.random()*27)+1;
//					
//			if(year==1) {
//				month = (int)(Math.random()*2)+1;
//			}
//			
//			String orderDate = "202"+year+"-"+month+"-"+day;
//			System.out.println("--"+i);
//			System.out.println(String.format("insert into tblBookOrder(seq,seqNonMember,orderDate,orderState) values(seqBookOrder.nextVal,%d,to_date('%s','YYYY-MM-DD'),'%s');",n++,orderDate,orderState[rnd.nextInt(10)]));
//		
//		}

//		for(int i=901; i<=1000; i++) {
//			
//			int year = (int)(Math.random()*2);
//			int month = (int)(Math.random()*12)+1;
//			int day = (int)(Math.random()*27)+1;
//			
//			if(year==1) {
//				month = (int)(Math.random()*2)+1;
//			}
//			
//			String orderDate = "202"+year+"-"+month+"-"+day;
//			
//			System.out.println("--"+i);
//			System.out.println(String.format("insert into tblBookOrder(seq,seqMember,orderDate,orderState) values(seqBookOrder.nextVal,%d,to_date('%s','YYYY-MM-DD'),'주문환불');",51+(int)(Math.random()*550),orderDate));
//			
//		}

		// 종이책 상세주문,장바구니
		// 주문번호는 1~1000번 //종이책248권
		// insert into tblBookOrderDetail(seq,seqBookOrder,seqBook,amount)
		// values(seqBookOrderDetail.nextVal,1,1,1);
		int n =1;
//		for(int i=1; i<=50; i++) {
//			System.out.println("--"+i);
//			//System.out.println(String.format("insert into tblBookOrderDetail(seq,seqBookOrder,seqBook,amount) values(seqBookOrderDetail.nextVal,%d,%d,%d);",1000+(n++),(int)(Math.random()*247)+1,(int)(Math.random()*3+1)));
//			System.out.println(String.format("insert into tblBookCart(seq,seqNonMember,seqBook,amount) values(seqBookCart.nextVal,%d,%d,%d);",1000+(n++),(int)(Math.random()*247)+1,(int)(Math.random()*3+1)));
//			
//		}

		// 종이책 결제
		// insert into tblBookPay(seq, seqBookOrder, payment, totalPay, usePoint,
		// actualPay, savePoints, payDate) values (seqBookPay.nextVal, 1, '카드결제', 26000,
		// 500, 25500, 1275, to_date('2021-01-03 10:11:11','YYYY-MM-DD HH24:MI:SS'));

//		for(int i=1; i<=50; i++) {
//			
//			int[] totalPayA = {10000,13000,15000,17000,20000,23000,25000,27000,30000,32000,35000,37000,40000,43000,50000};			
//			int totalPay = totalPayA[(int)(Math.random()*14)+1];
//			//int usePoint = ((int)(Math.random()*3)+1)*1000;
//			//int actualPay = totalPay-usePoint;
//			
//			int year = (int)(Math.random()*2);
//			int month = (int)(Math.random()*12)+1;
//			int day = (int)(Math.random()*27)+1;
//					
//			if(year==1) {
//				month = (int)(Math.random()*2)+1;
//			}
//			
//			String payDate = "202"+year+"-"+month+"-"+day;
//			
//			System.out.println("--"+i);
//			System.out.println(String.format("insert into tblBookPay(seq, seqBookOrder, payment, totalPay, usePoint, actualPay, savePoints, payDate) values (seqBookPay.nextVal, %d, '카드결제', %d, 0, %d, 0, to_date('%s','YYYY-MM-DD'));",1000+(n++),totalPay,totalPay,payDate));
//			
//		}

		// 종이책 배송
		// insert into tblBookDelivery(seq, seqBookOrder, name, address, tel,
		// deliveryCompany, deliveryNumber) values (seqBookDelivery.nextVal, 3, '홍길동',
		// '서울 강남구 테헤란로 132 한독약품빌딩 8층 쌍용교육센터', 01011111111,'CJ대한통운', 123456789125);
//		String[] n1 = { "김", "이", "박", "최", "정", "강", "조", "윤", "선우", "장", "임", "한", "오", "서", "신", "권", "황", "안", "송",
//				"류", "전", "제갈", "홍", "고", "문", "양", "손", "배", "조", "백", "허", "유", "남", "심", "노", "정", "하", "곽", "독고",
//				"성", "차", "주", "우", "구", "신", "임", "나", "전", "민", "유", "진", "지", "엄", "채", "원", "천", "방", "공", "황보",
//				"강", "현", "함", "변", "염", "양", "변", "여", "추", "노", "도", "소", "신", "석", "선", "설", "마", "길", "주", "연", "방",
//				"위", "표", "명", "기", "반", "왕", "금", "옥", "육", "인", "맹", "제", "모", "장", "남", "탁", "국", "여", "진", "어", "은",
//				"편", "구", "용", "남" };
//
//		String[] n2 = { "민", "서", "예", "도", "시", "주", "하", "지", "준", "현", "건", "우", "선", "승", "유", "현", "연", "유", "찬",
//				"다", "수", "태", "은", "동", "재", "성", "정", "경", "원", "호", "진", "슬", "소", "혁", "구", "종", "세", "백", "신", "나",
//				"보", "해" };
//
//		String[] n3 = { "원", "진", "영", "혜", "원", "미", "승", "현", "혁", "희", "온", "율", "후", "환", "람", "리", "슬", "주", "호",
//				"나", "빈", "안", "수", "오", "기", "훈", "", "우", "준", "람", "석", "찬", "양", "결", "안", "원", "창", "철", "인", "경",
//				"니", "하", "지", "예", "시" };
//
//		String[] address1 = {"서울시 용산구 한남동", "광명시 마포구 송파동", "경기도 일산동구 청학동", "인천시 연수구 송도동", "서울시 강남구 역삼동", "하남시 서초구 아현동", "안양시 강북구 병점동", "경기도 군포시 산본동", "서울시 영등포구 신길동", "서울시 관악구 신림동", "서울시 종로구 청운동", "서울시 종로구 사직동", "서울시 동작구 노량진동", "서울시 구로구 신도림동", "서울시 구로구 구로동", "서울시 마포구 도화동", "서울시 마포구 공덕동", "서울시 은평구 녹번동", "서울시 성북구 성북동", "서울시 성북구 삼선동", "서울시 성동구 왕십리동", "서울시 성동구 마장동", "서울시 강남구 대치동", "서울시 강남구 청담동", "서울시 강남구 도곡동", "서울시 강남구 논현동", "서울시 강남구 신사동", "서울시 강남구 압구정동", "서울시 양천구 목제동", "서울시 양천구 신월동", "서울시 강북구 삼양동", "서울시 강북구 송중동", "서울시 강북구 번제동", "서울시 강북구 수유동", "서울시 강북구 우이동", "서울시 강북구 인수동", "서울시 도봉구 쌍문동", "서울시 도봉구 방학동", "서울시 도봉구 창제동", "서울시 도봉구 도봉동", "서울시 송파구 풍납제동", "서울시 송파구 삼전동", "서울시 송파구 오금동"};
//
//		String[] address2 = {"자곡로", "강남대로", "역삼로", "압구정로", "삼성로", "미추홀대로", "인주대로", "아암대로", "인하로", "인하로", "우각로", "평택제천고속도로", "충청대로", "국원대로", "금봉대로", "번영대로", "탄금대로", "충원대로", "서부순환대로", "중원대로", "문강로", "미륵송계로", "후삼로", "감노로", "구룡로", "동산로"};  
//		
//		for (int i = 1001; i <= 1050; i++) {
//
//			int dn = (int) (Math.random() * 899999999) + 1000000000;
//			String phone = "010" + String.format("%08d", (int) (Math.random() * 77777777) + 10000000);
//			String name = n1[(int)(Math.random()*n1.length)] + n2[(int)(Math.random()*n2.length)] + n3[(int)(Math.random()*n3.length)];
//			
//			int load_seq=(int)(Math.random()*100)+1;
//			int load2_seq=(int)(Math.random()*100)+1;
//			String address = address1[(int)(Math.random()*address1.length)]+" "+address2[(int)(Math.random()*address2.length)]+" "+load_seq+"번길 "+ load2_seq;
//			
//			System.out.println("--" + i);
//			System.out.println(String.format(
//					"insert into tblBookDelivery(seq, seqBookOrder, name, address, tel, deliveryCompany, deliveryNumber) values (seqBookDelivery.nextVal, %d, '%s', '%s', %s,'CJ대한통운', %d);",
//					i, name, address, phone, dn));
//			
//		}

//		
//		
//		//비회원 50건
//		for(int i=0; i<50; i++) {
//			
//			System.out.println(String.format("insert into tblBookOrder(seq,seqNonMember,orderDate,orderState) values(seqBookOrder.nextVal,%d,to_date('2020-01-03 10:11:11','YYYY-MM-DD'),'주문완료')",i));
//			
//		}

	}

}
