package com.test.bookjuck.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import com.test.bookjuck.DBUtil;
import com.test.bookjuck.dto.CategoryDTO;

/**
 * 카테고리 관련 DB 작업 담당 클래스
 * @author 김주혁
 *
 */
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
			System.out.println("CategoryDAO.close()");
			e.printStackTrace();
		}
		
	}

	//주혁 시작
	
	/**
	 * (사용자) 중분류 카테고리 리스트 반환 메서드
	 * @return 중분류 카테고리 리스트
	 */
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
			System.out.println("CategoryDAO.mCategoryList()");
			e.printStackTrace();
		}
		
		return null;
	}

	
	/**
	 * (사용자) 소분류 카테고리 리스트 반환 메서드
	 * @param seqLCategory 대분류 카테고리 번호
	 * @param seqMCategory 중분류 카테고리 번호
	 * @return 소분류 카테고리 리스트
	 */
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
			System.out.println("CategoryDAO.sCategoryList()");
			e.printStackTrace();
		}
		
		return null;
	}

	
	/**
	 * (사용자) EBook 카테고리 리스트 반환 메서드
	 * @return EBook 카테고리 리스트
	 */
	public ArrayList<CategoryDTO> eBookCategoryList() {
		
		try {
			
			String sql = "select * from vwSCategory";
			stat = conn.createStatement();
			rs = stat.executeQuery(sql);
			
			ArrayList<CategoryDTO> categoryList = new ArrayList<CategoryDTO>(); 
			
			while (rs.next()) {
				CategoryDTO dto = new CategoryDTO();
				
				dto.setSeqLCategory(rs.getString("seqLCategory"));
				dto.setSeqMCategory(rs.getString("seqMCategory"));
				dto.setSeqSCategory(rs.getString("seqSCategory"));
				
				dto.setlCategory(rs.getString("lCategory"));
				dto.setmCategory(rs.getString("mCategory"));
				dto.setsCategory(rs.getString("sCategory"));
				
				categoryList.add(dto);
				
			}
			
			return categoryList;			
			
		} catch (Exception e) {
			System.out.println("CategoryDAO.eBookCategoryList()");
			e.printStackTrace();
		}
		
		return null;
	}
	
	
	/**
	 * (관리자) 대분류 카테고리 리스트 반환 메서드
	 * @return 대분류 카테고리 리스트
	 */
	public ArrayList<CategoryDTO> getLCategoryList() {
		
		try {
			
			String sql = "select * from tblLCategory";
			stat = conn.createStatement();
			rs = stat.executeQuery(sql);
			
			ArrayList<CategoryDTO> clist = new ArrayList<CategoryDTO>(); 
			
			while (rs.next()) {
				CategoryDTO dto = new CategoryDTO();
				
				dto.setSeqLCategory(rs.getString("seq"));
				
				dto.setlCategory(rs.getString("lCategory"));
				
				clist.add(dto);
				
			}
			
			return clist;			
			
		} catch (Exception e) {
			System.out.println("CategoryDAO.getLCategoryList()");
			e.printStackTrace();
		}
		
		return null;
	}	

	/**
	 * (관리자) 중분류 카테고리 리스트 반환 메서드
	 * @return 중분류 카테고리 리스트
	 */
	public ArrayList<CategoryDTO> getMCategoryList() {
		
		try {
			
			String sql = "select mc.*, (select lCategory from tblLCategory where seq = mc.seqLCategory) as lCategory from tblMCategory mc";
			stat = conn.createStatement();
			rs = stat.executeQuery(sql);
			
			ArrayList<CategoryDTO> clist = new ArrayList<CategoryDTO>(); 
			
			while (rs.next()) {
				CategoryDTO dto = new CategoryDTO();
				
				dto.setSeqLCategory(rs.getString("seqLCategory"));
				dto.setSeqMCategory(rs.getString("seq"));
				
				dto.setlCategory(rs.getString("lCategory"));
				dto.setmCategory(rs.getString("mCategory"));
				
				clist.add(dto);
				
			}
			
			return clist;			
			
		} catch (Exception e) {
			System.out.println("CategoryDAO.getMCategoryList()");
			e.printStackTrace();
		}
		
		return null;
	}	

	/**
	 * (관리자) 소분류 카테고리 리스트 반환 메서드
	 * @return 소분류 카테고리 리스트
	 */
	public ArrayList<CategoryDTO> getSCategoryList() {
		
		try {
			
			String sql = "select * from vwSCategory";
			stat = conn.createStatement();
			rs = stat.executeQuery(sql);
			
			ArrayList<CategoryDTO> clist = new ArrayList<CategoryDTO>(); 
			
			while (rs.next()) {
				CategoryDTO dto = new CategoryDTO();
				
				dto.setSeqLCategory(rs.getString("seqLCategory"));
				dto.setSeqMCategory(rs.getString("seqMCategory"));
				dto.setSeqSCategory(rs.getString("seqSCategory"));
				
				dto.setlCategory(rs.getString("lCategory"));
				dto.setmCategory(rs.getString("mCategory"));
				dto.setsCategory(rs.getString("sCategory"));
				
				clist.add(dto);
				
			}
			
			return clist;			
			
		} catch (Exception e) {
			System.out.println("CategoryDAO.getSCategoryList()");
			e.printStackTrace();
		}
		
		return null;
	}

	
	/**
	 * (사용자) 도서번호를 통한 소분류 카테고리 리스트 반환 메서드 
	 * @param seqBook 도서번호
	 * @return 소분류 카테고리 리스트
	 */
	public ArrayList<CategoryDTO> sCategoryList(String seqBook) {

		try {
			
			String sql = "select seqMCategory from viewBook where seq = ?";
			pstat = conn.prepareStatement(sql);
			pstat.setString(1, seqBook);
			rs = pstat.executeQuery();
			
			if (rs.next()) {
				String seqMCategory = rs.getString("seqMCategory");
				
				sql = "select * from vwSCategory where seqMCategory = ?";
				pstat = conn.prepareStatement(sql);
				pstat.setString(1, seqMCategory);
				
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
			}
			
		} catch (Exception e) {
			System.out.println("CategoryDAO.sCategoryList()");
			e.printStackTrace();
		}
		
		return null;
	}
	
	//주혁 끝
	
} //CategoryDAO
