package com.test.bookjuck.dtosave;

public class RealTimeSearchDTO {
	
	private String seq;
	private String searchdate;
	private String searchword;
	
	private String rank;
	private int searchcount;
	
	
	public String getSeq() {
		return seq;
	}
	public void setSeq(String seq) {
		this.seq = seq;
	}
	public String getSearchdate() {
		return searchdate;
	}
	public void setSearchdate(String searchdate) {
		this.searchdate = searchdate;
	}
	public String getSearchword() {
		return searchword;
	}
	public void setSearchword(String searchword) {
		this.searchword = searchword;
	}
	public String getRank() {
		return rank;
	}
	public void setRank(String rank) {
		this.rank = rank;
	}
	public int getSearchcount() {
		return searchcount;
	}
	public void setSearchcount(int searchcount) {
		this.searchcount = searchcount;
	}

}
