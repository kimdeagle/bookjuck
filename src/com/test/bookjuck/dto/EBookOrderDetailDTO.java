package com.test.bookjuck.dto;

/**
 * 이북 상세주문 DTO
 * @author 오수경
 *
 */

public class EBookOrderDetailDTO {
	
	private String seq; // 이북 상세주문 번호
	private String seqEBookOrder; // 이북 주문번호
	private String seqEBook; //이북 번호
	private String seqMember;//회원번호
	
	private String orderDate;//주문일자
	private String orderState;//주문상태
	private String orderName;//주문자 연락처
	private String orderTel;//주문자 연락처

	private String isbn; //isbn
	private String image;//책 이미지
	private String title;//책 제목

	private String payment;//결제방법
	private int totalPay;//총결제액
	private int usePoint;//사용 포인트
	private int actualPay;//실결제액
	private int savePoints;//적립 포인트
	private String payDate;//결제일
	
	private int total;

	
	//다은 추가 ) 주문 취소/환불/교환 관련 추가
	//2. 환불관련
	private String refundReason;		//환불사유
	private String refundReasonDetail;	//환불상세사유
	private String refundState;			//환불상태
	private String refundDate;			//환불날짜
	
	//4. 통합
	private String returnAddress;		//회수지주소 -> 교환/환불일 때
	private String endDate;				//처리날짜 -> 교환/환불일 때
	
	
	public String getRefundReason() {
		return refundReason;
	}

	public void setRefundReason(String refundReason) {
		this.refundReason = refundReason;
	}

	public String getRefundReasonDetail() {
		return refundReasonDetail;
	}

	public void setRefundReasonDetail(String refundReasonDetail) {
		this.refundReasonDetail = refundReasonDetail;
	}

	public String getRefundState() {
		return refundState;
	}

	public void setRefundState(String refundState) {
		this.refundState = refundState;
	}

	public String getRefundDate() {
		return refundDate;
	}

	public void setRefundDate(String refundDate) {
		this.refundDate = refundDate;
	}

	public String getReturnAddress() {
		return returnAddress;
	}

	public void setReturnAddress(String returnAddress) {
		this.returnAddress = returnAddress;
	}

	public String getEndDate() {
		return endDate;
	}

	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}

	public String getSeq() {
		return seq;
	}

	public void setSeq(String seq) {
		this.seq = seq;
	}

	public String getSeqEBookOrder() {
		return seqEBookOrder;
	}

	public void setSeqEBookOrder(String seqEBookOrder) {
		this.seqEBookOrder = seqEBookOrder;
	}

	public String getSeqEBook() {
		return seqEBook;
	}

	public void setSeqEBook(String seqEBook) {
		this.seqEBook = seqEBook;
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
