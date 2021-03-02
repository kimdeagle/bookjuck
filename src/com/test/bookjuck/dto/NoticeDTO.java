package com.test.bookjuck.dto;

/**
 * 공지사항 정보를 담고 있는 DTO입니다.
 * @author 조아라
 *
 */
public class NoticeDTO {
	
	private String seq;		//번호
	private String title;	//제목
	private String content; //내용
	private String regdate; //작성일
	
	
	public String getSeq() {
		return seq;
	}
	public void setSeq(String seq) {
		this.seq = seq;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getRegdate() {
		return regdate;
	}
	public void setRegdate(String regdate) {
		this.regdate = regdate;
	}
	
	
	
	
	
}
