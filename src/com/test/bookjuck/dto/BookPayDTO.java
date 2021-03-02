package com.test.bookjuck.dto;

/**
 * 종이책 결제 DTO
 * @author 오수경
 *
 */

public class BookPayDTO {
	
	private String seq; // 종이책 결제번호
	private String seqBookOrder; //종이책 주문번호 
	private String payment; //결제방법
	private int totalPay; //결제금액
	private int usePoint; //사용포인트
	private int actualPay; //실결제액
	private int savePoints; //적립포인트
	private String payDate;//결제일
	
	public String getSeq() {
		return seq;
	}
	public void setSeq(String seq) {
		this.seq = seq;
	}
	public String getSeqBookOrder() {
		return seqBookOrder;
	}
	public void setSeqBookOrder(String seqBookOrder) {
		this.seqBookOrder = seqBookOrder;
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
	
}
