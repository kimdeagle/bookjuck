package com.test.bookjuck.dto;

/**
 * 
 * 바로드림 상세 주문 DTO
 * @author 오수경
 *
 */

public class BaroOrderDetailDTO {

	private String seq; // 바로드림 상세주문번호
	private String seqBaroOrder; //바로드림 주문번호
	private String seqMember;//회원번호
	private String orderDate;//주문일자
	private String orderState;//주문상태
	private String orderName;//주문자 연락처
	private String orderTel;//주문자 연락처
	private String seqBook; //책 번호
	private String isbn; //isbn
	private String image;//책 이미지
	private String title;//책 제목
	private int amount; //주문 수량
	private String payment;//결제방법
	private int totalPay;//총결제액
	private int usePoint;//사용 포인트
	private int actualPay;//실결제액
	private int savePoints;//적립 포인트
	private String payDate;//결제일
	
	
	//다은 추가 ) 주문 취소/환불/교환 관련 추가
	//1. 취소관련
	private String cancelReason;		//취소사유
	private String cancelReasonDetail;	//취소상세사유
	private String cancelState;			//취소상태
	private String cancelDate;			//취소날짜
	
	
	
	
	public String getCancelReason() {
		return cancelReason;
	}

	public void setCancelReason(String cancelReason) {
		this.cancelReason = cancelReason;
	}

	public String getCancelReasonDetail() {
		return cancelReasonDetail;
	}

	public void setCancelReasonDetail(String cancelReasonDetail) {
		this.cancelReasonDetail = cancelReasonDetail;
	}

	public String getCancelState() {
		return cancelState;
	}

	public void setCancelState(String cancelState) {
		this.cancelState = cancelState;
	}

	public String getCancelDate() {
		return cancelDate;
	}

	public void setCancelDate(String cancelDate) {
		this.cancelDate = cancelDate;
	}

	private int total;

	public String getSeq() {
		return seq;
	}

	public void setSeq(String seq) {
		this.seq = seq;
	}

	public String getSeqBaroOrder() {
		return seqBaroOrder;
	}

	public void setSeqBaroOrder(String seqBaroOrder) {
		this.seqBaroOrder = seqBaroOrder;
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

	public String getOrderName() {
		return orderName;
	}

	public void setOrderName(String orderName) {
		this.orderName = orderName;
	}

	public String getOrderTel() {
		return orderTel;
	}

	public void setOrderTel(String orderTel) {
		this.orderTel = orderTel;
	}

	public String getSeqBook() {
		return seqBook;
	}

	public void setSeqBook(String seqBook) {
		this.seqBook = seqBook;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public String getPayment() {
		return payment;
	}

	public void setPayment(String payment) {
		this.payment = payment;
	}

	public int getTotalPay() {
		return totalPay;
	}

	public void setTotalPay(int totalPay) {
		this.totalPay = totalPay;
	}

	public int getUsePoint() {
		return usePoint;
	}

	public void setUsePoint(int usePoint) {
		this.usePoint = usePoint;
	}

	public int getActualPay() {
		return actualPay;
	}

	public void setActualPay(int actualPay) {
		this.actualPay = actualPay;
	}

	public int getSavePoints() {
		return savePoints;
	}

	public void setSavePoints(int savePoints) {
		this.savePoints = savePoints;
	}

	public String getPayDate() {
		return payDate;
	}

	public void setPayDate(String payDate) {
		this.payDate = payDate;
	}

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}
	
}
