package com.test.bookjuck.dto;

/**
 * 중고거래 게시판 관련 생성자들이 있는 DTO입니다.
 * @author 김다은
 *
 */
public class UsedBoardDTO {
	
	//DTO 멤버
	//1. 대상 테이블의 컬럼
	//2. 실제 컬럼은 아니지만 필요에 의해 추가로 생성되는 컬럼
	
	private String seq;
	private String seqMember; 
	private String title; 
	private String content;
	private String regDate;
	private String dealState; 
	private int readcnt; 
	private String image; 
	private String orgimage;
	
	
	private int gap; //최신글
	private String id; //글쓴 회원 id
	
	private String email; //글쓴 회원 email
	
	private String ccount; //현재 글에 달린 댓글 수
	
	
	public String getCcount() {
		return ccount;
	}
	public void setCcount(String ccount) {
		this.ccount = ccount;
	}
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

	public int getGap() {
		return gap;
	}
	public void setGap(int gap) {
		this.gap = gap;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	} 
	
	
	

}
