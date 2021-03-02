package com.test.bookjuck.dto;

/**
 * 질문카테고리 정보를 담고 있는 DTO입니다.
 * @author 조아라
 *
 */
public class QCategoryDTO {

	private String seq;			// 질문카테고리번호
	private String category;	// 카테고리명
	
	public String getSeq() {
		return seq;
	}
	public void setSeq(String seq) {
		this.seq = seq;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	
}
