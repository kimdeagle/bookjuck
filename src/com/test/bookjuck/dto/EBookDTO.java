package com.test.bookjuck.dto;

/**
 * EBook 정보 DTO
 * @author 김주혁
 *
 */
public class EBookDTO {
	
	private String seq; //EBook 번호
	private String seqAuthor; //작가 번호
	private String seqSCategory; //소분류 카테고리 번호
	private String title; //EBook 제목
	private String publisher; //출판사
	private String pubDate; //출간일
	private int price; //가격
	private int salePrice; //판매 가격
	private String isbn; //ISBN
	private String copy; //한줄카피
	private String intro; //도서 소개
	private String contents; //목차 
	private String image; //이미지 파일명
	private String eFile; //EBook 파일명
	
	private String author; //작가명
	
	private String authorIntro; //작가 소개
	
	private String seqLCategory; //카테고리번호(대)
	private String seqMCategory; //카테고리번호(중)
	
	private String sCategory; //카테고리명(소)
	private String mCategory; //카테고리명(중)
	private String lCategory; //카테고리명(대)
	
	
	public String getSeq() {
		return seq;
	}
	public void setSeq(String seq) {
		this.seq = seq;
	}
	public String getSeqAuthor() {
		return seqAuthor;
	}
	public void setSeqAuthor(String seqAuthor) {
		this.seqAuthor = seqAuthor;
	}
	public String getSeqSCategory() {
		return seqSCategory;
	}
	public void setSeqSCategory(String seqSCategory) {
		this.seqSCategory = seqSCategory;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getPublisher() {
		return publisher;
	}
	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}
	public String getPubDate() {
		return pubDate;
	}
	public void setPubDate(String pubDate) {
		this.pubDate = pubDate;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public int getSalePrice() {
		return salePrice;
	}
	public void setSalePrice(int salePrice) {
		this.salePrice = salePrice;
	}
	public String getIsbn() {
		return isbn;
	}
	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}
	public String getCopy() {
		return copy;
	}
	public void setCopy(String copy) {
		this.copy = copy;
	}
	public String getIntro() {
		return intro;
	}
	public void setIntro(String intro) {
		this.intro = intro;
	}
	public String getContents() {
		return contents;
	}
	public void setContents(String contents) {
		this.contents = contents;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public String geteFile() {
		return eFile;
	}
	public void seteFile(String eFile) {
		this.eFile = eFile;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getAuthorIntro() {
		return authorIntro;
	}
	public void setAuthorIntro(String authorIntro) {
		this.authorIntro = authorIntro;
	}
	public String getsCategory() {
		return sCategory;
	}
	public void setsCategory(String sCategory) {
		this.sCategory = sCategory;
	}
	public String getmCategory() {
		return mCategory;
	}
	public void setmCategory(String mCategory) {
		this.mCategory = mCategory;
	}
	public String getlCategory() {
		return lCategory;
	}
	public void setlCategory(String lCategory) {
		this.lCategory = lCategory;
	}
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
	
	
	

}
