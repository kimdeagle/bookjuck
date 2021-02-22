package com.test.bookjuck.dto;

public class GhostMemberDTO {
	
	private int seq;		//번호
	private int seqMember;	//회원번호
	private String state;   //상태
	private String regDate; //등록일
	
	public int getSeq() {
		return seq;
	}
	public void setSeq(int seq) {
		this.seq = seq;
	}
	public int getSeqMember() {
		return seqMember;
	}
	public void setSeqMember(int seqMember) {
		this.seqMember = seqMember;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getRegDate() {
		return regDate;
	}
	public void setRegDate(String regDate) {
		this.regDate = regDate;
	}
	
	
}
