package com.test.bookjuck.dto;

/**
 * 이북 장바구니
 * @author 오수경
 *
 */
public class EBookCartDTO {

	private String seq; //이북 장바구니 번호
	private String seqMember;//멤버 번호
	private String seqEbook;//이북번호
	
	private String title;//이북 제목
	private String image; //이북 이미지
	private int price;//이북 정가
	private int salePrice;//이북 판매가
	
	private String pick;//선택여부

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

	public String getSeqEbook() {
		return seqEbook;
	}

	public void setSeqEbook(String seqEbook) {
		this.seqEbook = seqEbook;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
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

	public String getPick() {
		return pick;
	}

	public void setPick(String pick) {
		this.pick = pick;
	}
	
}
