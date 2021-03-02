package com.test.bookjuck.dto;

/**
 * 이북 결제 DTO
 * @author 오수경
 *
 */
public class EBookPayDTO {
	
	private String seq;// 이북결제번호
	private String seqEOrder; //이북 주문번호
	private String payment; //결제방법
	private int totalPay; //총결제액
	private int usePoint; //사용포인트
	private int actualPay; //실결제액
	private int savePoints; //적립 포인트
	private String payDate; //결제일
	public String getSeq() {
		return seq;
	}
	public void setSeq(String seq) {
		this.seq = seq;
	}
	public String getSeqEOrder() {
		return seqEOrder;
	}
	public void setSeqEOrder(String seqEOrder) {
		this.seqEOrder = seqEOrder;
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

	public String getPayDate() {
		return payDate;
	}
	public void setPayDate(String payDate) {
		this.payDate = payDate;
	}
	public int getSavePoints() {
		return savePoints;
	}
	public void setSavePoints(int savePoints) {
		this.savePoints = savePoints;
	}
	
}
