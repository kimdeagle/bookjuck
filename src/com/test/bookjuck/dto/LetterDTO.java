package com.test.bookjuck.dto;

/**
 * 큐레이션레터 DTO입니다.
 * @author 조아라
 *
 */
public class LetterDTO {
	
	private String seq;			// 번호
	private String title;		// 큐레이션레터 제목
	private String content;		// 큐레이션레터 내용
	private String regDate;	// 큐레이션레터 전송일
	
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
	public String getRegDate() {
		return regDate;
	}
	public void setRegDate(String sendDate) {
		this.regDate = sendDate;
	}
	

}
