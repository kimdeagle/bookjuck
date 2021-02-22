package com.test.bookjuck.dto;

public class UsedBoardDTO {
	
	private String seq;
	private String seqMember; 
	private String title; 
	private String content;
	private String regDate;
	private String dealState; 
	private int readcnt; 
	private String image; 
	private String orgimage;
	
	
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
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getRegDate() {
		return regDate;
	}
	public void setRegDate(String regDate) {
		this.regDate = regDate;
	}
	public String getDealState() {
		return dealState;
	}
	public void setDealState(String dealState) {
		this.dealState = dealState;
	}
	public int getReadcnt() {
		return readcnt;
	}
	public void setReadcnt(int readcnt) {
		this.readcnt = readcnt;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public String getOrgimage() {
		return orgimage;
	}
	public void setOrgimage(String orgimage) {
		this.orgimage = orgimage;
	} 
	
	
	

}
