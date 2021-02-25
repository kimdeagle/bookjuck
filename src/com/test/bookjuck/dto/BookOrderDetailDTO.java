package com.test.bookjuck.dto;

/**
 * 종이책 상세주문
 * @author 오수경
 *
 */

public class BookOrderDetailDTO {
	
	private String seqBookOrder; //종이책 주문 번호
	private String seqMember;//회원번호
	private String orderdate;
	private String orderstate;
	private String ordertel;
	private String deliveryName;
	private String deliveryAddress;
	private String deliveryCompany;
	private String deliverytel;
	private String deliveryNumber;
	private String seqBook; //책 번호
	private String image;
	private String title;
	private int amount; //수량
	private String payment;
	private String totalPay;
	private int usePoint;
	private int savePoint;
	private int actualPoints;
	private String payDate;

}
