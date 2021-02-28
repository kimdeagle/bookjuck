package com.test.bookjuck.dao;

import java.beans.Statement;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;

import com.test.bookjuck.DBUtil;
import com.test.bookjuck.dto.StatisticsPiDTO;

import oracle.jdbc.OracleTypes;

public class StatisticsPiDAO {
	
	private Connection conn;
	private Statement stat;
	private PreparedStatement pstat;
	private ResultSet rs;
	private CallableStatement cstat;
	
	
	
	public StatisticsPiDAO()  {
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
	
public ArrayList<StatisticsPiDTO> defaultGetAgeCnt() {//날짜입력전 연령대별 
	
	
try {
		
		
		String sql = "select * from vwdefaultStatAgeCnt";
		
		pstat = conn.prepareStatement(sql);
		rs = pstat.executeQuery();
		
		ArrayList<StatisticsPiDTO> list = new ArrayList<StatisticsPiDTO>();
		
		while(rs.next()) {
			
			StatisticsPiDTO dto = new StatisticsPiDTO();
			
			dto.setAge(rs.getString("age"));
			dto.setAgecnt(rs.getInt("agecnt"));
			
			list.add(dto);
			
		}
		
		return list;
		
		
	} catch (Exception e) {
		System.out.println(e);
	}
	
	
	
	return null;
		

}	
	public ArrayList<StatisticsPiDTO> getAgeCnt(HashMap<String, String> map) {//날짜입력후 연령대별
		
		try { 	String sql = "";
				String start = "";
				String end ="";
		
		
		
		if (map.get("yearStart") != null && map.get("yearEnd") != null
				&& map.get("monthStart") != null && map.get("monthEnd") != null
				&& map.get("dayStart") != null && map.get("dayEnd") != null) 
			{
				start = map.get("yearStart") + map.get("monthStart") + map.get("dayStart");
				end = map.get("yearEnd") + map.get("monthEnd") + map.get("dayEnd");
				
				sql = "{ call proc_StatAgeCnt(?,?,?) }";
				
//				{ call proc_StatAgeCnt(?,?,?) }
//				'19900429'
//				'20220421'
				System.out.println(sql); 
				System.out.println(start);
				System.out.println(end);
				
				
				
			}
		
		
				cstat = conn.prepareCall(sql);
				cstat.setString(1, start);	
				cstat.setString(2, end);
				cstat.registerOutParameter(3, OracleTypes.CURSOR);
				
				cstat.executeQuery();
				
				rs = (ResultSet) cstat.getObject(3);
				
				
				ArrayList<StatisticsPiDTO> list = new ArrayList<StatisticsPiDTO>();
				
				while(rs.next()) {
					
					StatisticsPiDTO dto = new StatisticsPiDTO();
					
					dto.setAge(rs.getString("age"));
					dto.setAgecnt(rs.getInt("agecnt"));
					
					list.add(dto);
					
				}
				
				return list;
			
		} catch (Exception e) {
			System.out.println(e);
		}
		
		return null;
		
		
		
	}
	
	public ArrayList<StatisticsPiDTO> defaultGetGenderCnt() {//날짜입력전 성별 
		
		
		try {
				
				
				String sql = "select * from vwdefaultStatGenderCnt";
				
				pstat = conn.prepareStatement(sql);
				rs = pstat.executeQuery();
				
				ArrayList<StatisticsPiDTO> list = new ArrayList<StatisticsPiDTO>();
				
				while(rs.next()) {
					
					StatisticsPiDTO dto = new StatisticsPiDTO();
					
					dto.setGender(rs.getString("gender"));
					dto.setGendercnt(rs.getInt("gendercnt"));
					
					list.add(dto);
					
				}
				
				return list;
				
				
			} catch (Exception e) {
				System.out.println(e);
			}
			
			
			
			return null;
				

		}	
	
	public ArrayList<StatisticsPiDTO> getGenderCnt(HashMap<String, String> map) {//날짜입력후 성별
		
		try { 	String sql = "";
				String start = "";
				String end ="";
		
		
		
		if (map.get("yearStart") != null && map.get("yearEnd") != null
				&& map.get("monthStart") != null && map.get("monthEnd") != null
				&& map.get("dayStart") != null && map.get("dayEnd") != null) 
			{
				start = map.get("yearStart") + map.get("monthStart") + map.get("dayStart");
				end = map.get("yearEnd") + map.get("monthEnd") + map.get("dayEnd");
				
				sql = "{ call proc_StatGenderCnt(?,?,?) }";
				
//				{ call proc_StatAgeCnt(?,?,?) }
//				'19900429'
//				'20220421'
				System.out.println(sql); 
				System.out.println(start);
				System.out.println(end);
				
				
				
			}
		
		
				cstat = conn.prepareCall(sql);
				cstat.setString(1, start);	
				cstat.setString(2, end);
				cstat.registerOutParameter(3, OracleTypes.CURSOR);
				
				cstat.executeQuery();
				
				rs = (ResultSet) cstat.getObject(3);
				
				
				ArrayList<StatisticsPiDTO> list = new ArrayList<StatisticsPiDTO>();
				
				while(rs.next()) {
					
					StatisticsPiDTO dto = new StatisticsPiDTO();
					
					dto.setGender(rs.getString("gender"));
					dto.setGendercnt(rs.getInt("gendercnt"));
					
					list.add(dto);
					
				}
				
				return list;
			
		} catch (Exception e) {
			System.out.println(e);
		}
		
		return null;
		
		
		
	}
	

}
