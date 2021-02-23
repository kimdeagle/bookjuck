package com.test.bookjuck.dto;

/**
 * 종이책 장바구니
 * @author 오수경
 *
 */
public class BookCartDTO {

	private String seq; //종이책 장바구니 번호
	private String seqMember; //회원번호
	private String seqBook; //책번호
	private int amount; //수량
	private String pick; //선택여부
}
