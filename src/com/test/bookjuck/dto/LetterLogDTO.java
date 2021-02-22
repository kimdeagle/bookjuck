package com.test.bookjuck.dto;

/**
 * 큐레이션레터전송내역 DTO입니다.
 * @author 조아라
 *
 */
public class LetterLogDTO {
	
	private String seq;			// 번호
	private String seqMember;	// 회원번호
	private String seqLetter;	// 큐레이션레터번호
	private String sendDate; 	// 전송일
	
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
	public String getSeqLetter() {
		return seqLetter;
	}
	public void setSeqLetter(String seqLetter) {
		this.seqLetter = seqLetter;
	}
	public String getSendDate() {
		return sendDate;
	}
	public void setSendDate(String sendDate) {
		this.sendDate = sendDate;
	}
	
	

}
