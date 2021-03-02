package com.test.bookjuck.dto;

/**
 * 종이책 배달 DTO
 * @author 오수경
 *
 */
public class BookDeliveryDTO {
	
	private String seq;
	private String seqBookOrder;
	private String name;
	private String address;
	private String tel;
	private String deliveryCompany;
	private String deliveryNumber;
	
	
	public String getSeq() {
		return seq;
	}
	public void setSeq(String seq) {
		this.seq = seq;
	}
	public String getSeqBookOrder() {
		return seqBookOrder;
	}
	public void setSeqBookOrder(String seqBookOrder) {
		this.seqBookOrder = seqBookOrder;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public String getDeliveryCompany() {
		return deliveryCompany;
	}
	public void setDeliveryCompany(String deliveryCompany) {
		this.deliveryCompany = deliveryCompany;
	}
	public String getDeliveryNumber() {
		return deliveryNumber;
	}
	public void setDeliveryNumber(String deliveryNumber) {
		this.deliveryNumber = deliveryNumber;
	}


	
	
}
