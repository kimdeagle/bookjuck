package com.test.bookjuck.dto;

/**
 * QnA 질문 DTO입니다.
 * @author 조아라
 *
 */
public class QuestionDTO {
	
	private String seq;				// 번호
	private String seqMember;		// 회원번호
	private String seqQCategory;	// 질문분야번호
	private String title;			// 제목
	private String content;			// 내용
	private String regDate;			// 작성일
	
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
	public String getSeqQCategory() {
		return seqQCategory;
	}
	public void setSeqQCategory(String seqQCategory) {
		this.seqQCategory = seqQCategory;
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

}
