package com.test.bookjuck.dto;

/**
 * 카테고리 정보 DTO
 * @author 김주혁
 *
 */
public class CategoryDTO {

	private String seqLCategory; //대분류 카테고리 번호
	private String seqMCategory; //중분류 카테고리 번호
	private String seqSCategory; //소분류 카테고리 번호
	private String lCategory; //대분류 카테고리
	private String mCategory; //중분류 카테고리
	private String sCategory; //소분류 카테고리
	
	public String getSeqLCategory() {
		return seqLCategory;
	}
	public void setSeqLCategory(String seqLCategory) {
		this.seqLCategory = seqLCategory;
	}
	public String getSeqMCategory() {
		return seqMCategory;
	}
	public void setSeqMCategory(String seqMCategory) {
		this.seqMCategory = seqMCategory;
	}
	public String getSeqSCategory() {
		return seqSCategory;
	}
	public void setSeqSCategory(String seqSCategory) {
		this.seqSCategory = seqSCategory;
	}
	public String getlCategory() {
		return lCategory;
	}
	public void setlCategory(String lCategory) {
		this.lCategory = lCategory;
	}
	public String getmCategory() {
		return mCategory;
	}
	public void setmCategory(String mCategory) {
		this.mCategory = mCategory;
	}
	public String getsCategory() {
		return sCategory;
	}
	public void setsCategory(String sCategory) {
		this.sCategory = sCategory;
	}
	
	
}
