package com.test.bookjuck.dao;

import java.io.File;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;

import com.test.bookjuck.DBUtil;
import com.test.bookjuck.dto.CommentDTO;
import com.test.bookjuck.dto.UsedBoardDTO;

/**
 * 중고게시판 관련 메서드들이 있는 DAO입니다.
 * @author 김다은
 *
 */
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
	
	// ############ (김다은) 시작

	// WriteOk 서블릿이 글쓰기를 위임
	/**
	 * 중고거래 게시판에서 글쓰기를 위한 메서드입니다.
	 * @param dto
	 * @return 반환 결과 성공시 1, 실패시 0
	 */
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
	/**
	 * 중고거래 게시판에서 글목록을 반환하는 메서드입니다.
	 * @param map
	 * @return list
	 */
	public ArrayList<UsedBoardDTO> list(HashMap<String, String> map) {

		try {
			
			String where = "";
			
			if (map.get("fleamarketsearch")!= null) {
				
				where = String.format("where id like '%%%s%%' or title like '%%%s%%' or content like '%%%s%%'", map.get("fleamarketsearch"), map.get("fleamarketsearch"), map.get("fleamarketsearch"));
			}
			
			
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
				
				dto.setCcount(rs.getString("ccount")); //댓글 수
				
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
			
			String sql = "select u.*, (select id from tblMember m where u.seqmember = m.seq) as id, (select email from tblMember m where u.seqmember = m.seq) as email, (select count(*) from tblComment where seqUsedBoard = u.seq) as ccount from tblUsedBoard u where seq = ?";
			
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
				
				dto.setCcount(rs.getString("ccount")); //댓글 수
				
				return dto;
			}
			
		} catch (Exception e) {
			System.out.println(e);
		}
		
		return null;
	}

	
	//조회 수 증가시키기
	/**
	 * 중고게시판 글 조회 수를 증가시키는 메서드입니다.
	 * @param seq
	 */
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
	/**
	 * 중고게시판에서 글을 수정하는 메서드입니다.
	 * @param dto
	 * @return
	 */
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
	
	
	//DeleteOk 서블릿 -> 글 삭제하기(다은)
	// 아라) 중고거래게시판 글 삭제는 아래의 세 단계에 따라 이루어져야 한다.
	// 1. 댓글 삭제
	// 2. 글의 첨부파일 서버에서 삭제
	// 3. 글삭제
	public int del(String seq, String path) {
		
		try {
			
			// 1. 댓글 삭제(댓글이 없는 경우는 0개 삭제로 그냥 지나갈 수 있도록 따로 분기하지 않는다.)
			String sql="delete from tblComment where sequsedboard=?";
			pstat=conn.prepareStatement(sql);
			pstat.setString(1, seq);
			pstat.executeUpdate();
			
			// 2. 첨부파일 서버에서 삭제
			// 직전페이지에서 쿼리스트링으로 파일명 얻어오는 게 제일 좋을 거 같긴 한데
			// 그럼 다은님 코드도 바꿔야 해서 그냥 여기서 파일명 얻어오는 걸로.
			sql="select image from tblUsedBoard where seq=?";
			pstat=conn.prepareStatement(sql);
			pstat.setString(1, seq);
			rs=pstat.executeQuery();
			rs.next();
			String filename=rs.getString("image");
			File file=new File(path+filename);
			file.delete(); // 서버에서 삭제
			
			// 3. 글 삭제
			sql = "delete from tblUsedBoard where seq = ?";

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
	/**
	 * 중고거래 게시판의 총 게시물 수 를 세는 메서드입니다.
	 * @param map
	 * @return
	 */
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
	/**
	 * 중고거래 게시판의 댓글을 쓰는 메서드입니다.
	 * @param dto
	 * @return
	 */
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
	/**
	 * 중고게시판 상세보기에서 댓글 목록을 불러오는 메서드입니다.
	 * @param seq
	 * @return
	 */
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

	
	//Comment 삭제 메서드
	/**
	 * 중고거래 게시판에서 댓글을 삭제하는 메서드입니다.
	 * @param seq
	 * @return
	 */
	public int deleteComment(String seq) {
		
		try {
			
			String sql = "delete from tblComment where seq = ?";
			
			pstat = conn.prepareStatement(sql);
			pstat.setString(1, seq);
			
			return pstat.executeUpdate(); //1 or 0
			
		} catch (Exception e) {
			System.out.println(e);
		}
		
		return 0;
	}

	// ############ (김다은) 끝
	
	
	// ############ (조아라) 시작
	
	/**
	 * 관리자가 목록조회할 용도로 중고거래게시판의 전체 게시물 정보을 가져오는 메서드입니다.
	 * @param map pagination을 위한 시작 글번호와 끝 글번호가 담긴 HashMap입니다.
	 * @return 중고거래게시판 게시물의 정보를 담고 있는 UsedBoardDTO의 ArrayList를 반환합니다.
	 */
	public ArrayList<UsedBoardDTO> getAllList(HashMap<String, String> map) {
		
		try {
			
			String where = "";
			
			if (map.get("fleamarketsearch")!= null) {
				
				where = String.format("where ub.title like '%%%s%%' or ub.content like '%%%s%%' or m.id like '%%%s%%'", map.get("fleamarketsearch"), map.get("fleamarketsearch"), map.get("fleamarketsearch"));
			}
			
			String sql=String.format("select * from (select a.*, (select count(*) from tblComment cm where cm.seq=a.seq"
					+ "    group by seq) as ccount, rownum as rnum from (select ub.seq, m.id, ub.title, ub.regdate, ub.readcnt from tblUsedBoard ub\n"
					+ "        inner join tblMember m\n"
					+ "            on ub.seqmember=m.seq %s order by ub.seq desc) a) where rnum between %s and %s", where, map.get("begin"), map.get("end"));
			
			stat=conn.createStatement();
			rs=stat.executeQuery(sql);
			
			ArrayList<UsedBoardDTO> list=new ArrayList<UsedBoardDTO>();
			
			while (rs.next()) {
				UsedBoardDTO dto=new UsedBoardDTO();
				dto.setSeq(rs.getString("seq"));
				dto.setId(rs.getString("id"));
				dto.setTitle(rs.getString("title"));
				dto.setRegDate(rs.getString("regdate"));
				dto.setReadcnt(rs.getInt("readcnt"));
				dto.setCcount(rs.getString("ccount"));
				
				list.add(dto);
			}
			
			return list;
			
		} catch (Exception e) {
			System.out.println("UsedBoardDAO.getAllList()");
			e.printStackTrace();
		}
		
		return null;
	}
	
	// ############ (조아라) 끝

}