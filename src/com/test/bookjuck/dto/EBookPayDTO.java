package com.test.bookjuck.dto;

/**
 * 이북 결제
 * @author 오수경
 *
 */
public class EBookPayDTO {
	
	private String seq;// 이북결제번호
	private String seqEOrder; //이북 주문번호
	private String payment; //결제방법
	private int totalpay; //총결제액
	private int usePoint; //사용포인트
	private int actualPay; //실결제액
	private int savePoint; //적립 포인트
	private String payDate; //결제일
	
}
