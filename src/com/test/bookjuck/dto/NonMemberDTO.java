package com.test.bookjuck.dto;

public class NonMemberDTO {
	
	private int seq;		//번호
	private String name;	//이름
	private String email;	//이메일
	private String pw;		//비밀번호
	private int tel;		//휴대폰 번호
	
	
	public int getSeq() {
		return seq;
	}
	public void setSeq(int seq) {
		this.seq = seq;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPw() {
		return pw;
	}
	public void setPw(String pw) {
		this.pw = pw;
	}
	public int getTel() {
		return tel;
	}
	public void setTel(int tel) {
		this.tel = tel;
	}

	
	
}
