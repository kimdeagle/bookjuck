package com.test.bookjuck.dto;


/**
 * 회원 정보를 담고있는 DTO 입니다.
 * @author 최진영
 *
 */
public class MemberDTO {

	private String seq;			//번호
	private String id;			//아이디
	private String pw;			//비밀번호
	private String name;		//이름
	private int tel;			//연락처
	private String regDate; 	//가입일
	private String address;		//주소
	private String ssn;			//주민번호
	private String login;		//로그인방식
	private String email;		//이메일
	private int points;			//포인트
	private int privacy; 		//개인정보 유효기간
	private String lastDate;	//최종접속일
	
	private int subscript;		//큐레이션 서비스
	private String curation;    //큐레이션 구독여부
	
	
	
	public String getCuration() {
		return curation;
	}
	public void setCuration(String curation) {
		this.curation = curation;
	}
	public int getSubscript() {
		return subscript;
	}
	public void setSubscript(int subscript) {
		this.subscript = subscript;
	}
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
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getTel() {
		return tel;
	}
	public void setTel(int tel) {
		this.tel = tel;
	}
	public String getRegDate() {
		return regDate;
	}
	public void setRegDate(String regDate) {
		this.regDate = regDate;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getSsn() {
		return ssn;
	}
	public void setSsn(String ssn) {
		this.ssn = ssn;
	}
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getPoints() {
		return points;
	}
	public void setPoints(int points) {
		this.points = points;
	}
	public int getPrivacy() {
		return privacy;
	}
	public void setPrivacy(int privacy) {
		this.privacy = privacy;
	}
	public String getLastDate() {
		return lastDate;
	}
	public void setLastDate(String lastDate) {
		this.lastDate = lastDate;
	}
	
	
	
}
