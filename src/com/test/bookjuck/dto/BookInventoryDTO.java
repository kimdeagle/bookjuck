package com.test.bookjuck.dto;

/**
 * 도서 재고 DTO
 * @author 김주혁
 *
 */
public class BookInventoryDTO {

	private String seq; //재고 번호
	private String seqBook; //도서 번호
	private String amount; //수량
	
	public String getSeq() {
		return seq;
	}
	public void setSeq(String seq) {
		this.seq = seq;
	}
	public String getSeqBook() {
		return seqBook;
	}
	public void setSeqBook(String seqBook) {
		this.seqBook = seqBook;
	}
	public String getAmount() {
		return amount;
	}
	public void setAmount(String amount) {
		this.amount = amount;
	}
	
}
