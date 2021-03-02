package com.test.bookjuck.dto;
/**
 * 일반배송 주문환불 DTO입니다.
 * @author 김다은
 *
 */
public class BookRefundDTO {
	
	private String seq;
	private String seqBookOrder; 
	private String refundDate; 
	private String refundReason;
	private String refundReasonDetail;
	private String returnAddress;
	private String refundState; 
	private String endDate;
	
	
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
	public String getRefundDate() {
		return refundDate;
	}
	public void setRefundDate(String refundDate) {
		this.refundDate = refundDate;
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
	public String getReturnAddress() {
		return returnAddress;
	}
	public void setReturnAddress(String returnAddress) {
		this.returnAddress = returnAddress;
	}
	public String getRefundState() {
		return refundState;
	}
	public void setRefundState(String refundState) {
		this.refundState = refundState;
	}
	public String getEndDate() {
		return endDate;
	}
	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}
    
	

}
