package com.test.bookjuck.dto;

/**
 * 자주하는 질문 DTO입니다.
 * @author 조아라
 *
 */
public class FAQDTO {
	
	private String seq;				// 번호
	private String seqQcategory;	// 질문분야번호
	private String title;			// 제목
	private String content;			// 내용
	private String qCategory; 		// 카테고리명
	
	public String getSeq() {
		return seq;
	}
	public void setSeq(String seq) {
		this.seq = seq;
	}
	public String getSeqQcategory() {
		return seqQcategory;
	}
	public void setSeqQcategory(String seqQcategory) {
		this.seqQcategory = seqQcategory;
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
	public String getqCategory() {
		return qCategory;
	}
	public void setqCategory(String qCategory) {
		this.qCategory = qCategory;
	}
	
	

}
