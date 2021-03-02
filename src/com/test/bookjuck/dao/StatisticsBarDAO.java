package com.test.bookjuck.dao;

import java.beans.Statement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;

import com.test.bookjuck.DBUtil;
import com.test.bookjuck.dto.BookDTO;
import com.test.bookjuck.dto.StatisticsBarDTO;

/**
 * 통계-매출 막대그래프를 구현하기 위한 클래스
 * @author 이현우
 *
 */
public class StatisticsBarDAO {
	
	private Connection conn;
	private Statement stat;
	private PreparedStatement pstat;
	private ResultSet rs;
	
	
	
	public StatisticsBarDAO() {
		//DB 연결
		conn = DBUtil.open();
	}
	
	public void close() {
		try {
			conn.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	}
	
//--------------시작 (이현우)	
//날짜입력 후 종이책차트
	
/**
 * 종이책 매출조회
 * @param 조회날짜
 * @return
 */
public ArrayList<StatisticsBarDTO> getBookStat(HashMap<String, String> map) {
	
	try {
		
		String where ="";
		String sql = "";
		
		
		if (map.get("yearStart") != null && map.get("yearEnd") != null
			&& map.get("monthStart") != null && map.get("monthEnd") != null
			&& map.get("dayStart") != null && map.get("dayEnd") != null) 
		{
			String start = "'" + map.get("yearStart") + map.get("monthStart") + map.get("dayStart") +"'";
			String end = "'" + map.get("yearEnd") + map.get("monthEnd") + map.get("dayEnd") +"'";
			
			where = String.format("where paydate between %s and %s", start, end);
			sql = String.format("select sales from(select sum(sales) as sales from (select sum(totalpay) as sales from tblbookpay %s group by totalpay))", where);
			
			
			
			
		}
		
		
				
		
		pstat = conn.prepareStatement(sql);
		rs = pstat.executeQuery();
		
		//ResultSet -> ArrayList<DTO>
		ArrayList<StatisticsBarDTO> list = new ArrayList<StatisticsBarDTO>();
		
		while(rs.next()) {
			
			StatisticsBarDTO dto = new StatisticsBarDTO();
			
			dto.setSales(rs.getInt("sales"));
			//dto.setPayDate(rs.getString("paydate"));
			
			list.add(dto);
			
			
		}
		
		return list;
				
	} catch (Exception e) {
		System.out.println(e);
	}
	
	
	
	
	
	
	return null;
	
	}
//날짜입력 후 이북차트
/**
 * E북 매출조회
 * @param map 조회기간
 * @return
 */
public ArrayList<StatisticsBarDTO> getEBookStat(HashMap<String, String> map) {
	
	try {
		
		String where ="";
		String sql = "";
		
		
		if (map.get("yearStart") != null && map.get("yearEnd") != null
			&& map.get("monthStart") != null && map.get("monthEnd") != null
			&& map.get("dayStart") != null && map.get("dayEnd") != null) 
		{
			String start = "'" + map.get("yearStart") + map.get("monthStart") + map.get("dayStart") +"'";
			String end = "'" + map.get("yearEnd") + map.get("monthEnd") + map.get("dayEnd") +"'";
			
			where = String.format("where paydate between %s and %s", start, end);
			sql = String.format("select sales from(select sum(sales) as sales from (select sum(totalpay) as sales from tblepay %s group by totalpay))", where);
			
			
			
		}
		

				
		
		pstat = conn.prepareStatement(sql);
		rs = pstat.executeQuery();
		
		//ResultSet -> ArrayList<DTO>
		ArrayList<StatisticsBarDTO> list = new ArrayList<StatisticsBarDTO>();
		
		while(rs.next()) {
			
			StatisticsBarDTO dto = new StatisticsBarDTO();
			
			dto.setSales(rs.getInt("sales"));
			//dto.setPayDate(rs.getString("paydate"));
			
			list.add(dto);
			
			
		}
		
		return list;
				
	} catch (Exception e) {
		System.out.println(e);
	}
	
	
	
	
	
	
	return null;
	
	}
//날짜입력후 바로차트
/**
 * 바로드림 매출조회
 * @param map 조회기간
 * @return
 */
public ArrayList<StatisticsBarDTO> getBaroBookStat(HashMap<String, String> map) {
	
	try {
		
		String where ="";
		String sql = "";
		
		
		if (map.get("yearStart") != null && map.get("yearEnd") != null
			&& map.get("monthStart") != null && map.get("monthEnd") != null
			&& map.get("dayStart") != null && map.get("dayEnd") != null) 
		{
			String start = "'" + map.get("yearStart") + map.get("monthStart") + map.get("dayStart") +"'";
			String end = "'" + map.get("yearEnd") + map.get("monthEnd") + map.get("dayEnd") +"'";
			
			where = String.format("where paydate between %s and %s", start, end);
			sql = String.format("select sales from(select sum(sales) as sales from (select sum(totalpay) as sales from tblbaropay %s group by totalpay))", where);

			
			
		}
		

				
		
		pstat = conn.prepareStatement(sql);
		rs = pstat.executeQuery();
		
		//ResultSet -> ArrayList<DTO>
		ArrayList<StatisticsBarDTO> list = new ArrayList<StatisticsBarDTO>();
		
		while(rs.next()) {
			
			StatisticsBarDTO dto = new StatisticsBarDTO();
			
			dto.setSales(rs.getInt("sales"));
			//dto.setPayDate(rs.getString("paydate"));
			
			list.add(dto);
			
			
		}
		
		return list;
				
	} catch (Exception e) {
		System.out.println(e);
	}
	
	
	
	
	
	
	return null;
	
	}






/**
 * 종이책 매출
 * @return 날짜입력전 default 종이책차트 (누적값)
 */
public ArrayList<StatisticsBarDTO> defBookStat() {
	
	try {
		
		
		String sql = "select sales from vwBooksales";
		
		pstat = conn.prepareStatement(sql);
		rs = pstat.executeQuery();
		
		ArrayList<StatisticsBarDTO> list = new ArrayList<StatisticsBarDTO>();
		
		while(rs.next()) {
			
			StatisticsBarDTO dto = new StatisticsBarDTO();
			
			
			dto.setSales(rs.getInt("sales"));
			
			
			list.add(dto);
		}
		
		return list;
		
		
	} catch (Exception e) {
		System.out.println(e);
	}
	
	return null;
	
	}


/**
 * E북 매출
 * @return 날짜입력전 default E차트 (누적값)
 */
public ArrayList<StatisticsBarDTO> defEBookStat() {
	
	try {
		
		
		String sql = "select sales from vwEBooksales";
		
		pstat = conn.prepareStatement(sql);
		rs = pstat.executeQuery();
		
		ArrayList<StatisticsBarDTO> list = new ArrayList<StatisticsBarDTO>();
		
		while(rs.next()) {
			
			StatisticsBarDTO dto = new StatisticsBarDTO();
			
			
			dto.setSales(rs.getInt("sales"));
			
			
			list.add(dto);
		}
		
		return list;
		
		
	} catch (Exception e) {
		System.out.println(e);
	}
	
	return null;
	
	}
/**
 * 바로드림 매출
 * @return 날짜입력전 default 바로드림 차트 (누적값)
 */
public ArrayList<StatisticsBarDTO> defBaroBookStat() {
	
	try {
		
		
		String sql = "select sales from vwbarobooksales";
		
		pstat = conn.prepareStatement(sql);
		rs = pstat.executeQuery();
		
		ArrayList<StatisticsBarDTO> list = new ArrayList<StatisticsBarDTO>();
		
		while(rs.next()) {
			
			StatisticsBarDTO dto = new StatisticsBarDTO();
			
			
			dto.setSales(rs.getInt("sales"));
			
			
			list.add(dto);
		}
		
		return list;
		
		
	} catch (Exception e) {
		System.out.println(e);
	}
	
	return null;
	
	}

//--------------끝 (이현우)
}
