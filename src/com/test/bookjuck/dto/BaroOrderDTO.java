package com.test.bookjuck.dto;

/**
 * 
 * 바로드림 주문 DTO
 * @author 오수경, 김다은
 *
 */

public class BaroOrderDTO {
	
	private String seq; //바로드림 주문번호
	private String seqMember; //회원번호
	private String orderDate; //주문일
	private String orderState; //주문상태
	
	private int actualPay;
	private String image;
	private String seqBook;
	
	//교/취/환 추가
	private String applyDate;		//교환/취소/환불 접수일자
	private String title;			//상품 정보 (책이름)
	private String totalAmount;		//주문 총 수량
	

	private String id;				//주문자 id

  
	public int getActualPay() {
		return actualPay;
	}
	public void setActualPay(int actualPay) {
		this.actualPay = actualPay;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public String getSeqBook() {
		return seqBook;
	}
	public void setSeqBook(String seqBook) {
		this.seqBook = seqBook;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getSeq() {
		return seq;
	}
	public void setSeq(String seq) {
		this.seq = seq;
	}
	public String getSeqMember() {
		return seqMember;
	}
	public void setSeqMember(String seqMember) {
		this.seqMember = seqMember;
	}
	public String getOrderDate() {
		return orderDate;
	}
	public void setOrderDate(String orderDate) {
		this.orderDate = orderDate;
	}
	public String getOrderState() {
		return orderState;
	}
	public void setOrderState(String orderState) {
		this.orderState = orderState;
	}
	public String getApplyDate() {
		return applyDate;
	}
	public void setApplyDate(String applyDate) {
		this.applyDate = applyDate;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getTotalAmount() {
		return totalAmount;
	}
	public void setTotalAmount(String totalAmount) {
		this.totalAmount = totalAmount;
	}
	
	

	
}
