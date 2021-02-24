package com.test.bookjuck.dto;

/**
 * 종이책 결제
 * @author 오수경
 *
 */

public class BookPayDTO {
	
	private String seq; // 종이책 결제번호
	private String seqBookOrder; //종이책 주문번호 
	private String payment; //결제방법
	private int totalPay; //결제금액
	private int usePoint; //사용포인트
	private int actualPay; //실결제액
	private int savePoint; //적립포인트
	private String payDate;//결제일
	
}
