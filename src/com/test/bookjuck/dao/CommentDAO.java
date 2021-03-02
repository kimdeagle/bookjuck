package com.test.bookjuck.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import com.test.bookjuck.DBUtil;
import com.test.bookjuck.dto.CommentDTO;

public class CommentDAO {
	
	private Connection conn;
	private Statement stat;
	private PreparedStatement pstat;
	private ResultSet rs;

	public CommentDAO() {
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
     * 게시물번호에 따른 댓글들을 가져오는 메서드입니다.
     * @param seq 게시물번호입니다.
     * @return 댓글정보인 CommentDTO들이 담긴 ArrayList를 반환합니다.
     */
	public ArrayList<CommentDTO> getList(String seq) {
	
		try {
			
			String sql="select c.seq as seq, c.ccontent as ccontent, c.regdate as regdate, m.id as id from tblComment c\n"
					+ "                inner join tblMember m\n"
					+ "                    on m.seq=c.seqmember where c.sequsedboard=? order by c.seq desc";
			pstat=conn.prepareStatement(sql);
			pstat.setString(1, seq);
			rs=pstat.executeQuery();
			
			ArrayList<CommentDTO> list=new ArrayList<CommentDTO>();
			
			while (rs.next()) {
				CommentDTO dto=new CommentDTO();
				dto.setSeq(rs.getString("seq"));
				dto.setCcontent(rs.getString("ccontent"));
				dto.setRegdate(rs.getString("regdate"));
				dto.setId(rs.getString("id"));
				
				list.add(dto);
			}
			
			return list;
			
		} catch (Exception e) {
			System.out.println("CommentDAO.getList()");
			e.printStackTrace();
		}
		   
		   return null;
	}

	/**
	 * 중고거래게시판 글의 댓글을 삭제하는 메서드입니다.
	 * @param cseq 댓글의 PK인 댓글번호입니다.
	 * @return 성공하면 1, 실패하면 0을 반환합니다.
	 */
	public int del(String cseq) {
		
		try {
			
			String sql="delete from tblComment where seq=?";
			pstat=conn.prepareStatement(sql);
			pstat.setString(1, cseq);
			
			return pstat.executeUpdate();
			
		} catch (Exception e) {
			System.out.println("CommentDAO.del()");
			e.printStackTrace();
		}
		
		return 0;
	}
   
   // ############ (조아라) 끝

}
