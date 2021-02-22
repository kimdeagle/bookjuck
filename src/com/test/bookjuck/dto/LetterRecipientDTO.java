package com.test.bookjuck.dto;

/**
 * 큐레이션레터수신 DTO입니다.
 * @author 조아라
 *
 */
public class LetterRecipientDTO {
	
	private String seq;			// 번호
	private String seqMember;	// 회원번호
	
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
	
	

}
