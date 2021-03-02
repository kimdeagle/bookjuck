package com.test.bookjuck.dto;
/**
 * 일반배송 주문교환 DTO입니다.
 * @author 김다은
 *
 */
public class BookChangeDTO {
	
	private String seq; 
	private String seqBookOrder; 
	private String changeDate; 
	private String changeReason; 
	private String changeReasonDetail;
	private String returnAddress;
	private String changeState;
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
	public String getChangeDate() {
		return changeDate;
	}
	public void setChangeDate(String changeDate) {
		this.changeDate = changeDate;
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
	public String getReturnAddress() {
		return returnAddress;
	}
	public void setReturnAddress(String returnAddress) {
		this.returnAddress = returnAddress;
	}
	public String getChangeState() {
		return changeState;
	}
	public void setChangeState(String changeState) {
		this.changeState = changeState;
	}
	public String getEndDate() {
		return endDate;
	}
	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}
	
	
}
