package com.test.bookjuck.dto;

/**
 * 작가 정보 DTO
 * @author 김주혁
 *
 */
public class AuthorDTO {

	private String seq; //작가 번호
	private String name; //작가 이름
	private String intro; //작가 소개
	
	public String getSeq() {
		return seq;
	}
	public void setSeq(String seq) {
		this.seq = seq;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getIntro() {
		return intro;
	}
	public void setIntro(String intro) {
		this.intro = intro;
	}
	
	
}
