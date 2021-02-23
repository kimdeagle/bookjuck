package com.test.bookjuck.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import com.test.bookjuck.DBUtil;
import com.test.bookjuck.dto.CategoryDTO;

public class CategoryDAO {

	private Connection conn;
	private Statement stat;
	private PreparedStatement pstat;
	private ResultSet rs;
	
	public CategoryDAO() {
		conn = DBUtil.open();
	}
	
	public void close() {
		
		try {
			conn.close();			
		} catch (Exception e) {
			System.out.println(e);
		}
		
	}

	//주혁 시작
	
	//Header 서블릿 -> 중분류 카테고리 리스트 반환
	public ArrayList<CategoryDTO> mCategoryList() {
		
		try {
			
			String sql = "select * from vwMCategory";
			stat = conn.createStatement();
			rs = stat.executeQuery(sql);
			
			ArrayList<CategoryDTO> mCategoryList = new ArrayList<CategoryDTO>();
			
			while (rs.next()) {
				CategoryDTO dto = new CategoryDTO();
				
				dto.setSeqLCategory(rs.getString("seqLCategory"));
				dto.setSeqMCategory(rs.getString("seqMCategory"));
				dto.setlCategory(rs.getString("lCategory"));
				dto.setmCategory(rs.getString("mCategory"));
				
				mCategoryList.add(dto);
			}
			
			return mCategoryList;
			
		} catch (Exception e) {
			System.out.println(e);
		}
		
		return null;
	}

	//Category 서블릿 -> 소분류 카테고리 리스트 반환
	public ArrayList<CategoryDTO> sCategoryList(String seqLCategory, String seqMCategory) {
		
		try {
			
			String sql = "select * from vwSCategory where seqLCategory = ? and seqMCategory = ?";
			pstat = conn.prepareStatement(sql);
			pstat.setString(1, seqLCategory);
			pstat.setString(2, seqMCategory);
			
			rs = pstat.executeQuery();
			
			ArrayList<CategoryDTO> sCategoryList = new ArrayList<CategoryDTO>();
			
			while (rs.next()) {
				CategoryDTO dto = new CategoryDTO();
				
				dto.setSeqLCategory(rs.getString("seqLCategory"));
				dto.setSeqMCategory(rs.getString("seqMCategory"));
				dto.setSeqSCategory(rs.getString("seqSCategory"));
				dto.setlCategory(rs.getString("lCategory"));
				dto.setmCategory(rs.getString("mCategory"));
				dto.setsCategory(rs.getString("sCategory"));
				
				sCategoryList.add(dto);
			}
			
			return sCategoryList;
			
		} catch (Exception e) {
			System.out.println(e);
		}
		
		return null;
	}
	
	//주혁 끝
	
} //CategoryDAO
