package com.test.bookjuck.dto;

/**
 * 종이책 상세주문 DTO
 * @author 오수경, 김다은
 *
 */

public class BookOrderDetailDTO {
	
	private String seqBookOrder; //종이책 주문 번호
	private String id;//회원아이디
	private String seqMember;//회원번호
	private String orderDate;//주문일자
	private String orderState;//주문상태
	private String orderName;//주문자 연락처
	private String orderTel;//주문자 연락처
	private String deliveryName;//수취인 이름
	private String deliveryAddress;//수취인주소
	private String deliveryTel;//수취인 연락처
	private String deliveryCompany;//운송 업체
	private String deliveryNumber;//운송장번호
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
	
	private int total;
	
	private int cnt;
	
	//다은 추가 ) 주문 취소/환불/교환 관련 추가
	//0. 주문타입
	private String orderType;			//주문타입
	
	//1. 취소관련
	private String cancelReason;		//취소사유
	private String cancelReasonDetail;	//취소상세사유
	private String cancelState;			//취소상태
	private String cancelDate;			//취소날짜
	
	//2. 환불관련
	private String refundReason;		//환불사유
	private String refundReasonDetail;	//환불상세사유
	private String refundState;			//환불상태
	private String refundDate;			//환불날짜
	
	//3. 교환관련
	private String changeReason;		//교환사유
	private String changeReasonDetail;	//교환상세사유
	private String changeState;			//교환상태
	private String changeDate;			//교환날짜
	
	//3.2. 교환 새 배송지관련
	private String name;				//교환배송 수취인
	private String address;				//교환배송지
	private String tel;					//교환배송 수취인번호
	private String deliveryCom;			//교환배송 배송회사
	private String deliveryNum;			//교환배송 운송장번호
	
	//4. 통합
	private String returnAddress;		//회수지주소 -> 교환/환불일 때
	private String endDate;				//처리날짜 -> 교환/환불일 때
	
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public String getDeliveryCom() {
		return deliveryCom;
	}
	public void setDeliveryCom(String deliveryCom) {
		this.deliveryCom = deliveryCom;
	}
	public String getDeliveryNum() {
		return deliveryNum;
	}
	public void setDeliveryNum(String deliveryNum) {
		this.deliveryNum = deliveryNum;
	}
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
	public String getChangeReason() {
		return changeReason;
	}
	public void setChangeReason(String changeReason) {
		this.changeReason = changeReason;
	}
	public String getChangeReasonDetail() {
		return changeReasonDetail;
	}
	public void setChangeReasonDetail(String changeReasonDetail) {
		this.changeReasonDetail = changeReasonDetail;
	}
	public String getChangeState() {
		return changeState;
	}
	public void setChangeState(String changeState) {
		this.changeState = changeState;
	}
	public String getChangeDate() {
		return changeDate;
	}
	public void setChangeDate(String changeDate) {
		this.changeDate = changeDate;
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
	public String getSeqBookOrder() {
		return seqBookOrder;
	}
	public void setSeqBookOrder(String seqBookOrder) {
		this.seqBookOrder = seqBookOrder;
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
	public String getOrderTel() {
		return orderTel;
	}
	public void setOrderTel(String orderTel) {
		this.orderTel = orderTel;
	}
	public String getDeliveryName() {
		return deliveryName;
	}
	public void setDeliveryName(String deliveryName) {
		this.deliveryName = deliveryName;
	}
	public String getDeliveryAddress() {
		return deliveryAddress;
	}
	public void setDeliveryAddress(String deliveryAddress) {
		this.deliveryAddress = deliveryAddress;
	}
	public String getDeliveryTel() {
		return deliveryTel;
	}
	public void setDeliveryTel(String deliveryTel) {
		this.deliveryTel = deliveryTel;
	}
	public String getDeliveryCompany() {
		return deliveryCompany;
	}
	public void setDeliveryCompany(String deliveryCompany) {
		this.deliveryCompany = deliveryCompany;
	}
	public String getDeliveryNumber() {
		return deliveryNumber;
	}
	public void setDeliveryNumber(String deliveryNumber) {
		this.deliveryNumber = deliveryNumber;
	}
	public String getSeqBook() {
		return seqBook;
	}
	public void setSeqBook(String seqBook) {
		this.seqBook = seqBook;
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
	public int getSavePoints() {
		return savePoints;
	}
	public void setSavePoints(int savePoint) {
		this.savePoints = savePoint;
	}
	public String getPayDate() {
		return payDate;
	}
	public void setPayDate(String payDate) {
		this.payDate = payDate;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getOrderName() {
		return orderName;
	}
	public void setOrderName(String orderName) {
		this.orderName = orderName;
	}
	public String getIsbn() {
		return isbn;
	}
	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}
	public int getActualPay() {
		return actualPay;
	}
	public void setActualPay(int actualPay) {
		this.actualPay = actualPay;
	}
	public int getTotal() {
		return total;
	}
	public void setTotal(int total) {
		this.total = total;
	}
	public int getCnt() {
		return cnt;
	}
	public void setCnt(int cnt) {
		this.cnt = cnt;
	}
	public String getOrderType() {
		return orderType;
	}
	public void setOrderType(String orderType) {
		this.orderType = orderType;
	}

}
