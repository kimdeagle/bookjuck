package com.test.bookjuck.dto;

/**
 * 바로드림 결제
 * @author 오수경
 *
 */
public class BaroPayDTO {
	
	private String seq;//바로드림 결제번호
	private String seqBaroOrder; //바로드림 주문번호
	private String payment; //결제방법
	private int totalPay;//총결제액
	private int usePoint;//사용포인트
	private int actualPay;//실결제액
	private int savePoint;//적립포인트
	private String payDate;//결제일
	
}
