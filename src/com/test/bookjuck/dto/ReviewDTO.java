package com.test.bookjuck.dto;

/**
 * 독후감 DTO입니다.
 * @author 조아라
 *
 */
public class ReviewDTO {
	
	private String seq;			// 번호
	private String seqMember;	// 회원번호
	private String seqBook;		// 도서정보번호
	private String title;		// 제목
	private String content;		// 내용
	private String regDate;		// 작성일자
	private String isPrize;		// 우수독후감여부
	
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
	public String getSeqBook() {
		return seqBook;
	}
	public void setSeqBook(String seqBook) {
		this.seqBook = seqBook;
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
	public String getIsPrize() {
		return isPrize;
	}
	public void setIsPrize(String isPrize) {
		this.isPrize = isPrize;
	}

}
