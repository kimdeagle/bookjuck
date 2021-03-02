package com.test.bookjuck.dto;

/**
 * 중고거래게시판 댓글 정보를 담고 있는 DTO입니다.
 * @author 조아라
 *
 */
public class CommentDTO {
	
	private String seq;			// 댓글번호
	private String ccontent;	// 내용
	private String regdate;		// 등록일
	private String seqUsedBoard;// 이 댓글이 달린 중고거래글번호
	private String seqMember;	// 댓글을 작성한 회원번호
	private String id;			// 댓글을 작성한 회원아이디
	
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getSeq() {
		return seq;
	}
	public void setSeq(String seq) {
		this.seq = seq;
	}
	public String getCcontent() {
		return ccontent;
	}
	public void setCcontent(String ccontent) {
		this.ccontent = ccontent;
	}
	public String getRegdate() {
		return regdate;
	}
	public void setRegdate(String regdate) {
		this.regdate = regdate;
	}
	public String getSeqUsedBoard() {
		return seqUsedBoard;
	}
	public void setSeqUsedBoard(String seqUsedBoard) {
		this.seqUsedBoard = seqUsedBoard;
	}
	public String getSeqMember() {
		return seqMember;
	}
	public void setSeqMember(String seqMember) {
		this.seqMember = seqMember;
	}
	
	
	
	

}
