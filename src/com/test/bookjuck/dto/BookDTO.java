package com.test.bookjuck.dto;
	

/**
 * 도서 정보 DTO
 * @author 김주혁, 이현우
 *
 */
public class BookDTO {
	
	private String seq; //도서 번호
	private String seqAuthor; //작가 번호
	private String seqSCategory; //소분류 카테고리 번호
	private String title; //도서 제목
	private String publisher; //출판사
	private int price; //가격
	private int salePrice; //판매 가격
	private String pubDate; //출간일
	private String summary; //도서 소개 or 줄거리
	private String isbn; //ISBN
	private String copy; //한줄카피
	private String image; //이미지 파일명
	private String contents; //목차
	private int page; //페이지 수
	private String paydate; //
	
	
	private String author; //작가명
	private String authorIntro; //작가 소개
	
	private String seqLCategory; //대분류 카테고리번호
	private String lCategory; //대분류 카테고리
	
	private String totalSale;//매출액
	private String saleRank;//판매순위
	
	private String rank;//순위
	
	
	private String seqMCategory; //중분류 카테고리번호
	private String mCategory; //중분류 카테고리
	
	private String sCategory; //소분류 카테고리
	
	private int amount; //도서 수량
	
	
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
	public String getPubDate() {
		return pubDate;
	}
	public void setPubDate(String pubDate) {
		this.pubDate = pubDate;
	}
	public String getSummary() {
		return summary;
	}
	public void setSummary(String summary) {
		this.summary = summary;
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
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public String getContents() {
		return contents;
	}
	public void setContents(String contents) {
		this.contents = contents;
	}
	public int getPage() {
		return page;
	}
	public void setPage(int page) {
		this.page = page;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getLCategory() {
		return lCategory;
	}
	public void setLCategory(String lCategory) {
		this.lCategory = lCategory;
	}
	public String getTotalSale() {
		return totalSale;
	}
	public void setTotalSale(String totalSale) {
		this.totalSale = totalSale;
	}
	public String getSaleRank() {
		return saleRank;
	}
	public void setSaleRank(String saleRank) {
		this.saleRank = saleRank;
	}
	public String getRank() {
		return rank;
	}
	public void setRank(String rank) {
		this.rank = rank;
	}
	public String getAuthorIntro() {
		return authorIntro;
	}
	public void setAuthorIntro(String authorIntro) {
		this.authorIntro = authorIntro;
	}
	public String getSeqMCategory() {
		return seqMCategory;
	}
	public void setSeqMCategory(String seqMCategory) {
		this.seqMCategory = seqMCategory;
	}
	public String getsCategory() {
		return sCategory;
	}
	public void setsCategory(String sCategory) {
		this.sCategory = sCategory;
	}
	public String getSeqLCategory() {
		return seqLCategory;
	}
	public void setSeqLCategory(String seqLCategory) {
		this.seqLCategory = seqLCategory;
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
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	public String getPaydate() {
		return paydate;
	}
	public void setPaydate(String paydate) {
		this.paydate = paydate;
	}
	
	
	

}
