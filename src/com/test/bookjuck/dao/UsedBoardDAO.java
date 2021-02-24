package com.test.bookjuck.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;

import com.test.bookjuck.DBUtil;
import com.test.bookjuck.dto.CommentDTO;
import com.test.bookjuck.dto.UsedBoardDTO;

public class UsedBoardDAO {

	private Connection conn;
	private Statement stat;
	private PreparedStatement pstat;
	private ResultSet rs;

	public UsedBoardDAO() {
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

	// WriteOk 서블릿이 글쓰기를 위임
	public int write(UsedBoardDTO dto) {

		try {
			
			String sql = "insert into tblUsedBoard (seq, seqMember, title, content, regdate, dealstate, readcnt, image, orgimage) values (seqUsedBoard.nextVal, ?, ?, ?, default, '판매중', default, ?, ?)";
			
			pstat = conn.prepareStatement(sql);
			pstat.setString(1, dto.getSeqMember());
			pstat.setString(2, dto.getTitle());
			pstat.setString(3, dto.getContent());
			
			pstat.setString(4, dto.getImage());
			pstat.setString(5, dto.getOrgimage());
			
			
			return pstat.executeUpdate(); //1 or 0
			
		} catch (Exception e) {
			System.out.println(e);
		}
		
		return 0;

	}
	
	
	
	//List 서블릿이 글 목록을 달라고 위임
	public ArrayList<UsedBoardDTO> list(HashMap<String, String> map) {

		try {
			
			String where = "";
			
			if (map.get("fleamarketsearch")!= null) {
				
				where = String.format("where id like '%%%s%%' or title like '%%%s%%' or content like '%%%s%%'", map.get("fleamarketsearch"), map.get("fleamarketsearch"), map.get("fleamarketsearch"));
			}
			
			
			//String sql = String.format("select * from vwUsedBoard %s order by seq desc", where);
			
			String sql = String.format("select * from (select a.*, rownum as rnum from (select * from vwUsedBoard %s order by seq desc) a) where rnum between %s and %s"
					, where
					, map.get("begin")
					, map.get("end"));
			
			
			pstat = conn.prepareStatement(sql);
			rs = pstat.executeQuery();
			
			ArrayList<UsedBoardDTO> list = new ArrayList<UsedBoardDTO>();
			
			while (rs.next()) {
				
				//레코드 1줄 -> DTO 1개
				UsedBoardDTO dto = new UsedBoardDTO();
			
				dto.setSeq(rs.getString("seq"));
				dto.setSeqMember(rs.getString("seqMember"));
				dto.setTitle(rs.getString("title"));
				dto.setRegDate(rs.getString("regDate"));
				dto.setDealState(rs.getString("dealState"));
				dto.setReadcnt(rs.getInt("readcnt"));
				dto.setImage(rs.getString("image"));
				dto.setId(rs.getString("id"));
				
				dto.setGap(rs.getInt("gap"));
				
				list.add(dto); //***잘 빼먹는 부분 : 에러메세지 안뜨니 주의할 것
				
			}
			
			return list; //***잘 빼먹는 부분 : 에러메세지 안뜨니 주의할 것
			
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
		}
		
		
		return null;
	}

	
	//View 서블릿 -> 글 1개 반환해달라고 요청 : 글 번호에 해당하는 글 정보 가져오기
	public UsedBoardDTO get(String seq) {
		
		try {
			
			String sql = "select u.*, (select id from tblMember m where u.seqmember = m.seq) as id, (select email from tblMember m where u.seqmember = m.seq) as email from tblUsedBoard u where seq = ?";
			
			pstat = conn.prepareStatement(sql);
			pstat.setString(1, seq);
			
			rs = pstat.executeQuery();
			
			if (rs.next()) {
				
				UsedBoardDTO dto = new UsedBoardDTO();
				
				dto.setSeq(rs.getString("seq"));
				dto.setTitle(rs.getString("title"));
				dto.setContent(rs.getString("content"));
				dto.setRegDate(rs.getString("regdate"));
				dto.setDealState(rs.getString("dealstate"));
				dto.setReadcnt(rs.getInt("readcnt"));
				dto.setSeqMember(rs.getString("seqMember"));
				
				dto.setId(rs.getString("id"));
				
				dto.setImage(rs.getString("image"));
				dto.setOrgimage(rs.getString("orgimage"));
				
				return dto;
			}
			
		} catch (Exception e) {
			System.out.println(e);
		}
		
		return null;
	}

	
	//조회 수 증가시키기
	public void updateReadcnt(String seq) {

		try {
			
			String sql = "update tblUsedBoard set readcnt = readcnt + 1 where seq = ?";
			
			pstat = conn.prepareStatement(sql);
			pstat.setString(1, seq);
			
			rs = pstat.executeQuery();
			
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
		}
		
		
	}

	
	//EditOk 서블릿 -> 글 수정해달라고 요청
	public int edit(UsedBoardDTO dto) {

		try {
			
			String sql = "update tblUsedBoard set title = ?, content = ?, dealstate = ? where seq = ?";
			
			pstat = conn.prepareStatement(sql);
			pstat.setString(1, dto.getTitle());
			pstat.setString(2, dto.getContent());
			pstat.setString(3, dto.getDealState());
			pstat.setString(4, dto.getSeq());  //글 번호
			
			return pstat.executeUpdate(); //1 or 0
			
		} catch (Exception e) {
			System.out.println(e);
		}
		
		
		return 0;
	}
	
	
	//DeleteOk 서블릿 -> 글 삭제하기
	public int del(String seq) {
		
		try {

			String sql = "delete from tblUsedBoard where seq = ?";

			pstat = conn.prepareStatement(sql);	
			pstat.setString(1, seq);	//글 번호

			return pstat.executeUpdate(); // 1 or 0

		} catch (Exception e) {
			System.out.println(e);
		}
		
		return 0;
	}

	

	//총 게시물 수 를 세는 메서드
	//List 서블릿 -> 총 게시물 수 반환
	public int getTotalCount(HashMap<String, String> map) {
		
		try {
			
			String where = "";
			
			if (map.get("fleamarketsearch")!= null) {
				
				where = String.format("where id like '%%%s%%' or title like '%%%s%%' or content like '%%%s%%'", map.get("fleamarketsearch"), map.get("fleamarketsearch"), map.get("fleamarketsearch"));
				
			}
			
			String sql = String.format("select count(*) as cnt from vwUsedBoard %s", where);
			
			
			stat = conn.createStatement();
			rs = stat.executeQuery(sql);
			
			if (rs.next()) {
				return rs.getInt("cnt");
			}
			
			
			
		} catch (Exception e) {
			System.out.println(e);
		}
		return 0;
	}
	
	
	
	//CommentOk 서블릿 -> 댓글 쓰기
	public int writeComment(CommentDTO dto) {
		
		try {
			
			String sql = "insert into tblComment (seq, ccontent, regdate, seqUsedBoard, seqMember) values (seqComment.nextVal, ?, default, ?, ?)";
			
			pstat = conn.prepareStatement(sql);
			pstat.setString(1, dto.getCcontent());
			pstat.setString(2, dto.getSeqUsedBoard());
			pstat.setString(3, dto.getSeqMember());
			
			return pstat.executeUpdate(); //1 or 0
			
		} catch (Exception e) {
			System.out.println(e);
		}
		
		return 0;
		
	}
	
	
	//View 서블릿 -> 댓글 목록
	public ArrayList<CommentDTO> listComment(String seq) {
		

		try {
			
			String sql = "select c.*, (select name from tblMember where seq = c.seqMember) as name, (select id from tblMember where seq = c.seqMember) as id from tblComment c where c.seqUsedBoard = ? order by c.seq desc"; 
			
			pstat = conn.prepareStatement(sql);
			pstat.setString(1, seq);//부모 글번호
			
			rs = pstat.executeQuery();
			
			ArrayList<CommentDTO> clist = new ArrayList<CommentDTO>();
			
			while (rs.next()) {
				
				CommentDTO dto = new CommentDTO();
				
				dto.setSeq(rs.getString("seq"));
				dto.setCcontent(rs.getString("ccontent"));
				dto.setRegdate(rs.getString("regDate"));
				dto.setSeqMember(rs.getString("seqMember"));
				dto.setSeqUsedBoard(rs.getString("seqUsedBoard"));
				dto.setId(rs.getString("id"));
				
				clist.add(dto);
				
			}
			
			return clist;
			
			
		} catch (Exception e) {
			
			System.out.println(e);
		}
		
		return null;
	}
	

}