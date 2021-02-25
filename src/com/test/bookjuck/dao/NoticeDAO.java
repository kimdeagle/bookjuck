package com.test.bookjuck.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;

import com.test.bookjuck.DBUtil;
import com.test.bookjuck.dto.NoticeDTO;

/**
 * 공지사항 DB에 접근하는 DAO입니다.
 * @author 4조
 *
 */
public class NoticeDAO {
	private Connection conn;
	private Statement stat;
	private PreparedStatement pstat;
	private ResultSet rs;

	public NoticeDAO() {
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
	 * 공지사항 추가하는 메서드입니다.
	 * @param dto : 공지사항 정보를 담고 있는 NoticeDTO입니다.
	 * @return 성공하면 1, 실패하면 0을 반환합니다.
	 */
	public int add(NoticeDTO dto) {
		
		try {
			
			String sql="insert into tblNotice(seq, title, content, regdate) values (seqNotice.nextVal, ?, ?, sysdate)";
			pstat=conn.prepareStatement(sql);
			pstat.setString(1, dto.getTitle());
			pstat.setString(2, dto.getContent());
			
			return pstat.executeUpdate();
			
		} catch (Exception e) {
			System.out.println("NoticeDAO.add()");
			e.printStackTrace();
		}
		
		return 0;
	}

	/**
	 * 공지사항 목록을 가져오는 메서드입니다.
	 * @param map 
	 * @return 공지사항정보인 NoticeDTO들이 담긴 ArrayList를 반환합니다.
	 */
	public ArrayList<NoticeDTO> getList(HashMap<String, String> map) {
		try {
			
			// 공지사항을 최신순으로 가져오는 쿼리
			// String sql="select * from tblNotice order by seq desc";
			String sql = String.format("select * from (select a.*, rownum as rnum from (select * from tblNotice order by seq desc) a) where rnum between %s and %s"
					, map.get("begin")
					, map.get("end"));
			
			stat=conn.createStatement();
			rs=stat.executeQuery(sql);
			
			ArrayList<NoticeDTO> nlist=new ArrayList<NoticeDTO>();
			
			while (rs.next()) {
				NoticeDTO dto=new NoticeDTO();
				dto.setSeq(rs.getString("seq"));
				dto.setTitle(rs.getString("title"));
				dto.setContent(rs.getString("content"));
				dto.setRegdate(rs.getString("regdate"));
				
				nlist.add(dto);
			}
			
			return nlist;
			
		} catch (Exception e) {
			System.out.println("NoticeDAO.getList()");
			e.printStackTrace();
		}
		
		return null;
	}

	/**
	 * 공지사항 PK인 번호(seq)로 공지사항 한 개의 정보를 가져오는 메서드입니다.
	 * @return 공지사항의 정보를 담고 있는 NoticeDTO를 반환합니다.
	 */
	public NoticeDTO getInfo(String seq) {
		
		try {
			
			String sql="select * from tblNotice where seq=?";
			pstat=conn.prepareStatement(sql);
			pstat.setString(1, seq);
			rs=pstat.executeQuery();
			
			NoticeDTO dto=new NoticeDTO();
			
			if (rs.next()) {
				
				dto.setSeq(rs.getString("seq"));
				dto.setTitle(rs.getString("title"));
				dto.setContent(rs.getString("content"));
				dto.setRegdate(rs.getString("regdate"));
			}
			
			return dto;
			
		} catch (Exception e) {
			System.out.println("NoticeDAO.getInfo()");
			e.printStackTrace();
		}
		
		return null;
	}
	
	/**
	 * 공지사항을 수정하는 메서드입니다.
	 * @return 성공하면 1, 실패하면 0을 반환합니다.
	 */
	public int edit(NoticeDTO dto) {
		
		try {
			String sql="update tblNotice set title=?, content=? where seq=?";
			pstat=conn.prepareStatement(sql);
			pstat.setString(1, dto.getTitle());
			pstat.setString(2, dto.getContent());
			pstat.setString(3, dto.getSeq());
			
			return pstat.executeUpdate();
			
		} catch (Exception e) {
			System.out.println("NoticeDAO.edit()");
			e.printStackTrace();
		}
		
		return 0;
	}

	/**
	 * 공지사항을 삭제하는 메서드입니다.
	 * @param seq 공지사항 PK인 번호입니다.
	 * @return 성공하면 1, 실패하면 0을 반환합니다.
	 */
	public int del(String seq) {
		try {
			
			String sql="delete from tblNotice where seq=?";
			pstat=conn.prepareStatement(sql);
			pstat.setString(1, seq);
			
			return pstat.executeUpdate();
			
		} catch (Exception e) {
			System.out.println("NoticeDAO.del()");
			e.printStackTrace();
		}
		
		return 0;
	}
	
	/**
	 * 총 게시물 수를 반환하는 메서드입니다.
	 * @param map 페이징시의 시작 공지사항번호와 끝 공지사항번호를 담고 있는 HashMap입니다. 
	 * @return 총 게시물 수를 반환합니다.
	 */
	public int getTotalCount(HashMap<String, String> map) {
		try {
			
			String sql="select count(*) as cnt from tblNotice";
			stat=conn.createStatement();
			rs=stat.executeQuery(sql);
			
			if (rs.next()) {
				return rs.getInt("cnt");
			}
			
		} catch (Exception e) {
			System.out.println("NoticeDAO.getTotalCount()");
			e.printStackTrace();
		}
		return 0;
	}
	
	// ############ (조아라) 끝
	
}
