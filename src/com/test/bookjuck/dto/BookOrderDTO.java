package com.test.bookjuck.dto;

/**
 * 종이책 주문 DTO
 * @author 오수경, 김다은
 *
 */
public class BookOrderDTO {
	
	private String seq;				//종이책 주문번호
	private String seqMember;		//회원번호
	private String seqNonMember;	//비회원번호
	private String orderDate;		//주문일
	private String orderState;		//주문상태
	
	//다은 추가
	private String applyDate;		//교환/취소/환불 접수일자
	private String title;			//상품 정보 (책이름)
	private String totalAmount;		//주문 총 수량
	
	private String id;				//주문자 id
	private String process;			//처리상태
	

	//수경 추가
	private int totalPay; // 총 결제액


	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
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
	public String getSeqNonMember() {
		return seqNonMember;
	}
	public void setSeqNonMember(String seqNonMember) {
		this.seqNonMember = seqNonMember;
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

	public int getTotalPay() {
		return totalPay;
	}
	public void setTotalPay(int totalPay) {
		this.totalPay = totalPay;
	}

	public String getProcess() {
		return process;
	}
	public void setProcess(String process) {
		this.process = process;

	}
	
	

}
