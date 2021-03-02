package com.test.bookjuck.dto;

/**
 * 어드민 계정 정보를 담고 있는 DTO 입니다.
 * @author 최진영
 *
 */
public class AdminDTO {
	
	private String seq; 		//번호
	private String id;  		//아이디
	private String pw;			//비밀번호
	
	
	
	public String getSeq() {
		return seq;
	}
	public void setSeq(String seq) {
		this.seq = seq;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPw() {
		return pw;
	}
	public void setPw(String pw) {
		this.pw = pw;
	}
	
	

	
}
