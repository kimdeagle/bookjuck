package com.test.bookjuck.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;

import com.test.bookjuck.DBUtil;
import com.test.bookjuck.dto.QCategoryDTO;

/**
 * 질문카테고리 DB에 접근하는 DAO입니다.
 * @author 조아라
 *
 */
public class QCategoryDAO {

	private Connection conn;
	private Statement stat;
	private PreparedStatement pstat;
	private ResultSet rs;

	
	public QCategoryDAO() {
	      // DB 연결
	      conn = DBUtil.open();
	   }

	public void close() {

		try {

			conn.close();

		} catch (Exception e) {
			System.out.println(e);
		}

	}
	
	// ############ (조아라) 시작
	
	/**
	 * 질문카테고리 목록을 가져오는 메서드입니다.
	 * @return 질문카테고리 정보가 담긴 QCategoryDTO들의 ArrayList를 반환합니다.
	 */
	public ArrayList<QCategoryDTO> getList() {
		
		try {
			
			String sql="select * from tblQCategory";
			
			stat=conn.createStatement();
			rs=stat.executeQuery(sql);
			
			ArrayList<QCategoryDTO> list=new ArrayList<QCategoryDTO>();
			
			while(rs.next()) {
				QCategoryDTO dto=new QCategoryDTO();
				dto.setSeq(rs.getString("seq"));
				dto.setCategory(rs.getString("category"));
				
				list.add(dto);
			}
			
			return list;
			
		} catch (Exception e) {
			System.out.println("QCategoryDAO.getList()");
			e.printStackTrace();
		}
		
		return null;
	}
	
	/**
	 * 질문카테고리 목록을 가져오는 메서드입니다.
	 * @param map 
	 * @return 질문카테고리 정보가 담긴 DTO들의 ArrayList를 반환합니다.
	 */
	public ArrayList<QCategoryDTO> getList(HashMap<String, String> map) {
		
		try {
			
			String sql=String.format("select * from (select qc.*, rownum as rnum from (select * from tblQCategory order by seq) qc)"
					+ " where rnum between %s and %s", map.get("begin"), map.get("end"));
			
			stat=conn.createStatement();
			rs=stat.executeQuery(sql);
			ArrayList<QCategoryDTO> list=new ArrayList<QCategoryDTO>();
			
			while (rs.next()) {
				QCategoryDTO dto=new QCategoryDTO();
				dto.setSeq(rs.getString("seq"));
				dto.setCategory(rs.getString("category"));
				list.add(dto);
			}
			
			return list;
			
		} catch (Exception e) {
			System.out.println("QCategoryDAO.getList()");
			e.printStackTrace();
		}
		
		return null;
	}

	/**
	 * 질문카테고리를 추가하는 메서드입니다.
	 * @param category 질문카테고리명입니다.
	 * @return 성공하면 1, 실패하면 0을 반환합니다.
	 */
	public int add(String category) {
		
		try {
			
			String sql="insert into tblQCategory(seq, category) values (seqQcategory.nextVal, ?)";
			pstat=conn.prepareStatement(sql);
			pstat.setString(1, category);
			
			return pstat.executeUpdate();
			
		} catch (Exception e) {
			System.out.println("QCategoryDAO.add()");
			e.printStackTrace();
		}
		
		return 0;
	}

	/**
	 * 질문카테고리를 수정하는 메서드입니다.
	 * @param dto 질문카테고리 정보를 담고 있는 DTO입니다.
	 * @return 성공하면 1, 실패하면 0을 반환합니다.
	 */
	public int edit(QCategoryDTO dto) {
		
		try {
			String sql="update tblQCategory set category=? where seq=?";
			
			pstat=conn.prepareStatement(sql);
			pstat.setString(1, dto.getCategory());
			pstat.setString(2, dto.getSeq());
			
			return pstat.executeUpdate();
			
		} catch (Exception e) {
			System.out.println("QCategoryDAO.edit()");
			e.printStackTrace();
		}
		
		return 0;
	}

	/**
	 * 질문카테고리 총 개수를 가져오는 메서드입니다.
	 * @param map pagination을 위한 시작 질문카테고리번호와 끝 질문카테고리번호가 들어있는 HashMap입니다.
	 * @return 질문카테고리 총개수를 반환합니다.
	 */
	public int getTotalCount(HashMap<String, String> map) {
		
		try {
			
			String sql="select count(*) as cnt from tblQCategory";
			
			stat=conn.createStatement();
			rs=stat.executeQuery(sql);
			
			if (rs.next()) {
				return rs.getInt("cnt");
			}
			
		} catch (Exception e) {
			System.out.println("QCategoryDAO.getTotalCount()");
			e.printStackTrace();
		}
		
		return 0;
	}
	
	// ############ (조아라) 끝
	
}