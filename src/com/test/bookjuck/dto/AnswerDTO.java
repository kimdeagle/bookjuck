package com.test.bookjuck.dto;

/**
 * QnA 답변 DTO입니다.
 * @author 조아라
 *
 */
public class AnswerDTO {
	
	private String seq;				// 번호
	private String seqQuestion;		// QnA 번호
	private String answerContent;	// 답변내용
	private String answerDate;		// 답변일
	
	public String getSeq() {
		return seq;
	}
	public void setSeq(String seq) {
		this.seq = seq;
	}
	public String getSeqQuestion() {
		return seqQuestion;
	}
	public void setSeqQuestion(String seqQuestion) {
		this.seqQuestion = seqQuestion;
	}
	public String getAnswerContent() {
		return answerContent;
	}
	public void setAnswerContent(String answerContent) {
		this.answerContent = answerContent;
	}
	public String getAnswerDate() {
		return answerDate;
	}
	public void setAnswerDate(String answerDate) {
		this.answerDate = answerDate;
	}

}
