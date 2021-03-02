package com.test.bookjuck.dto;

/**
 * 통계 성별, 연령대별 정보를 저장하는 클래스
 * @author 이현우
 *
 */
public class StatisticsPiDTO {
	

	private int agecnt;
	

	private String age;
	

	private int gendercnt;
	
	private String gender;
	
	

	public String getAge() {
		return age;
	}
	public void setAge(String age) {
		this.age = age;
	}
	public int getAgecnt() {
		return agecnt;
	}
	public void setAgecnt(int agecnt) {
		this.agecnt = agecnt;
	}
	public int getGendercnt() {
		return gendercnt;
	}
	public void setGendercnt(int gendercnt) {
		this.gendercnt = gendercnt;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	
	

}
