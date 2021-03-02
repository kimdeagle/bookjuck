package com.test.bookjuck.dto;

/**
 * 통계 매출 막대그래프 정보를 저장하는 클래스
 * @author 이현우
 *
 */
public class StatisticsBarDTO {
	
	
	private int sales;
	

	private String payDate;
	

	public int getSales() {
		return sales;
	}

	public void setSales(int sales) {
		this.sales = sales;
	}

	public String getPayDate() {
		return payDate;
	}

	public void setPayDate(String payDate) {
		this.payDate = payDate;
	}

}
