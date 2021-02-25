package com.test.bookjuck.dto;

/**
 * 큐레이션레터전송내역 DTO입니다.
 * @author 조아라
 *
 */
public class LetterLogDTO {
	
	private String seq;			// 번호
	private String seqMember;	// 회원번호
	private String id;			// 회원아이디
	private String seqLetter;	// 큐레이션레터번호
	private String sendDate; 	// 전송일
	private String title;		// 큐레이션레터 제목
	private String content;		// 큐레이션레터 내용
	
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
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getSeqLetter() {
		return seqLetter;
	}
	public void setSeqLetter(String seqLetter) {
		this.seqLetter = seqLetter;
	}
	public String getSendDate() {
		return sendDate;
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
	public void setSendDate(String sendDate) {
		this.sendDate = sendDate;
	}
	
	

}
