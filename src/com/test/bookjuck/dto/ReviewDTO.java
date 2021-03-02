package com.test.bookjuck.dto;

/**
 * 독후감 DTO입니다.
 * @author 조아라
 *
 */
public class ReviewDTO {
	
	private String seq;				// 번호
	private String seqMember;		// 회원번호
	private String id;				// 회원아이디
	private String seqBook;			// 도서정보번호
	private String bookTitle;		// 도서제목
	private String reviewTitle; 	// 독후감제목
	private String reviewContent;	// 내용
	private String regDate;			// 작성일자
	private String isPrize;			// 우수독후감여부
	
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
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getSeqBook() {
		return seqBook;
	}
	public void setSeqBook(String seqBook) {
		this.seqBook = seqBook;
	}
	public String getBookTitle() {
		return bookTitle;
	}
	public void setBookTitle(String bookTitle) {
		this.bookTitle = bookTitle;
	}
	public String getReviewTitle() {
		return reviewTitle;
	}
	public void setReviewTitle(String reviewTitle) {
		this.reviewTitle = reviewTitle;
	}
	public String getReviewContent() {
		return reviewContent;
	}
	public void setReviewContent(String reviewContent) {
		this.reviewContent = reviewContent;
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
