package com.test.bookjuck.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;

import com.test.bookjuck.DBUtil;
import com.test.bookjuck.dto.FAQDTO;
import com.test.bookjuck.dto.NoticeDTO;
import com.test.bookjuck.dto.QuestionDTO;

/**
 * 자주하는 질문 DB에 접근하는 DAO입니다.
 * @author 조아라
 *
 */
public class FAQDAO {

	private Connection conn;
	private Statement stat;
	private PreparedStatement pstat;
	private ResultSet rs;
	
	public FAQDAO() {
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
	 * 자주하는 질문 목록을 가져오는 메서드입니다.
	 * @param map 
	 * @return 자주하는 질문 정보인 FAQDTO들이 담긴 ArrayList를 반환합니다.
	 */
	public ArrayList<FAQDTO> getList(HashMap<String, String> map) {
		try {
			
			// 검색어 처리
			String where = "";
			
			if (map.get("search") != null) {
				//검색 중..
				where = String.format("where category like '%%%s%%' or title like '%%%s%%' or content like '%%%s%%'", map.get("search"), map.get("search"), map.get("search"));
			}
			
			// 자주하는 질문을 최신순으로 가져오는 쿼리
			String sql = String.format("select * from (select a.*, rownum as rnum from (select * from tblFAQ f\n"
					+ "    inner join tblQCategory c\n"
					+ "        on  f.seqqcategory=c.seq"
					+ "            %s\n"
					+ "                order by f.seq desc) a) where rnum between %s and %s"
					, where
					, map.get("begin")
					, map.get("end"));
			
			stat=conn.createStatement();
			rs=stat.executeQuery(sql);
			
			ArrayList<FAQDTO> flist=new ArrayList<FAQDTO>();
			
			while (rs.next()) {
				FAQDTO dto=new FAQDTO();
				dto.setSeq(rs.getString("seq"));
				dto.setTitle(rs.getString("title"));
				dto.setContent(rs.getString("content"));
				dto.setqCategory(rs.getString("category"));
				flist.add(dto);
			}
			
			return flist;
			
		} catch (Exception e) {
			System.out.println("FAQDAO.getList()");
			e.printStackTrace();
		}
		
		return null;
	}

	/**
	 * 자주하는 질문을 추가하는 메서드입니다.
	 * @param dto 자주하는 질문 정보를 담고 있는 dto입니다.
	 * @return 성공하면 1, 실패하면 0을 반환합니다.
	 */
	public int add(FAQDTO dto) {
		
		try {
			
			String sql="insert into tblFAQ(seq, seqqcategory, title, content) values (seqFAQ.nextVal, ?, ?, ?)";
			pstat=conn.prepareStatement(sql);
			pstat.setString(1, dto.getSeqQcategory());
			pstat.setString(2, dto.getTitle());
			pstat.setString(3, dto.getContent());
			
			
			return pstat.executeUpdate();
			
		} catch (Exception e) {
			System.out.println("FAQDAO.add()");
			e.printStackTrace();
		}
		
		return 0;
	}

	/**
	 * 총 게시물 수를 반환하는 메서드입니다.
	 * @param map 페이징시의 시작 FAQ번호와 끝 FAQ번호를 담고 있는 HashMap입니다. 
	 * @return 총 게시물 수를 반환합니다.
	 */
	public int getTotalCount(HashMap<String, String> map) {
		
		try {
			
			String where = "";
			
			if (map.get("search") != null) {
				where = String.format("where c.category like '%%%s%%' or f.title like '%%%s%%' or f.content like '%%%s%%'", map.get("search"), map.get("search"), map.get("search"));
			}
			
			String sql=String.format("select count(*) as cnt from tblFAQ f\n"
					+ "    inner join tblQCategory c\n"
					+ "        on f.seqqcategory=c.seq %s", where);
			stat=conn.createStatement();
			rs=stat.executeQuery(sql);
			
			if (rs.next()) {
				return rs.getInt("cnt");
			}
			
		} catch (Exception e) {
			System.out.println("FAQDAO.getTotalCount()");
			e.printStackTrace();
		}
		return 0;
	}

	/**
	 * 자주하는 질문 글 한 개를 가져오는 메서드입니다.
	 * @param seq 자주하는 질문의 PK인 seq입니다.
	 * @return 자주하는 질문 정보를 담고 있는 FAQDTO를 반환합니다.
	 */
	public FAQDTO getInfo(String seq) {
		
		try {
			
			String sql="select f.seq as seq, f.title as title, f.content as content, c.seq as seqqcategory, c.category as category from tblFAQ f"
					+ "    inner join tblQcategory c"
					+ "        on f.seqqcategory=c.seq where f.seq=?";
			pstat=conn.prepareStatement(sql);
			pstat.setString(1, seq);
			
			rs=pstat.executeQuery();
			
			if (rs.next()) {
				FAQDTO dto=new FAQDTO();
				dto.setSeq(rs.getString("seq"));
				dto.setTitle(rs.getString("title"));
				dto.setContent(rs.getString("content"));
				dto.setSeqQcategory(rs.getString("seqqcategory"));
				dto.setqCategory(rs.getString("category"));
				
				return dto;
				
			}
			
		} catch (Exception e) {
			System.out.println("FAQDAO.getInfo()");
			e.printStackTrace();
		}
		
		return null;
	}

	/**
	 * 자주하는 질문 한 개를 수정하는 메서드입니다.
	 * @param dto 자주하는 질문 정보를 가지고 있는 FAQDTO입니다.
	 * @return 성공하면 1, 실패하면 0을 반환합니다.
	 */
	public int edit(FAQDTO dto) {
		
		try {
			String sql="update tblFAQ set title=?, content=?, seqqcategory=? where seq=?";
			
			pstat=conn.prepareStatement(sql);
			pstat.setString(1, dto.getTitle());
			pstat.setString(2, dto.getContent());
			pstat.setString(3, dto.getSeqQcategory());
			pstat.setString(4, dto.getSeq());
			return pstat.executeUpdate();
			
		} catch (Exception e) {
			System.out.println("FAQDAO.edit()");
			e.printStackTrace();
		}
		
		return 0;
	}

	/**
	 * 자주하는 질문을 삭제하는 메서드입니다.
	 * @param seq 자주하는 질문의 PK인 seq입니다.
	 * @return 성공하면 1, 실패하면 0을 반환합니다.
	 */
	public int del(String seq) {
		
		try {
			
			String sql="delete from tblFAQ where seq=?";
			pstat=conn.prepareStatement(sql);
			pstat.setString(1, seq);
			
			return pstat.executeUpdate();
			
		} catch (Exception e) {
			System.out.println("FAQDAO.del()");
			e.printStackTrace();
		}
		
		return 0;
	}
	
	// ############ (조아라) 끝
}
