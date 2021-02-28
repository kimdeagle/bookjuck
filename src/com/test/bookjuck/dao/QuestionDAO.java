package com.test.bookjuck.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;

import com.test.bookjuck.DBUtil;
import com.test.bookjuck.dto.QuestionDTO;

/**
 * QnA 질문 DB에 접근하는 DAO입니다.
 * @author 조아라
 *
 */
public class QuestionDAO {

	private Connection conn;
	private Statement stat;
	private PreparedStatement pstat;
	private ResultSet rs;

	public QuestionDAO() {
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
	 * 1대1 문의글을 추가하는 메서드입니다.
	 * @param dto 1대1 문의글 정보를 담고 있는 DTO입니다.
	 * @return 성공하면 1, 실패하면 0을 반환합니다.
	 */
	public int add(QuestionDTO dto) {
		
		try {
			
			String sql="insert into tblQuestion(seq, seqmember, seqqcategory, title, content, regdate)  values(seqQuestion.nextVal, ?, ?, ?, ?, sysdate)";
			
			pstat=conn.prepareStatement(sql);
			pstat.setString(1, dto.getSeqMember());
			pstat.setString(2, dto.getSeqQCategory());
			pstat.setString(3, dto.getTitle());
			pstat.setString(4, dto.getContent());
			
			return pstat.executeUpdate();
			
		} catch (Exception e) {
			System.out.println("QuestionDAO.add()");
			e.printStackTrace();
		}
		
		return 0;
	}

	/**
	 * 회원 본인의 1대1 문의글 목록을 가져오는 메서드입니다.
	 * @param map pagination에 필요한 begin, end와 본인의 글임을 식별할 seq가 들어있는 map입니다.
	 * @return 1대1 문의글 정보를 담고 있는 QuestionDTO들이 담긴 ArrayList를 반환합니다.
	 */
	public ArrayList<QuestionDTO> getList(HashMap<String, String> map) {
		
		try {
			
			String sql="select * from\n"
					+ "    (select r.*, rownum as rnum from\n"
					+ "        (select q.seq as seq,\n"
					+ "                c.category as category,\n"
					+ "                q.title as title,\n"
					+ "                q.content as content,\n"
					+ "                q.regdate as regdate,\n"
					+ "                nvl(a.answerdate, '1900-01-01') as isdone\n"
					+ "from tblQuestion q\n"
					+ "    left outer join tblAnswer a\n"
					+ "        on q.seq=a.seqquestion\n"
					+ "            inner join tblQcategory c\n"
					+ "                on q.seqqcategory=c.seq\n"
					+ "                    where q.seqmember=?\n"
					+ "                        order by q.seq desc) r)\n"
					+ "                         where rnum between ? and ?";
		
			pstat=conn.prepareStatement(sql);
			pstat.setString(1, map.get("seq"));
			pstat.setString(2, map.get("begin"));
			pstat.setString(3, map.get("end"));
			rs=pstat.executeQuery();
			
			ArrayList<QuestionDTO> list=new ArrayList<QuestionDTO>();
			
			while(rs.next()) {
				QuestionDTO dto=new QuestionDTO();
				dto.setSeq(rs.getString("seq"));
				dto.setqCategory(rs.getString("category"));
				dto.setTitle(rs.getString("title"));
				dto.setContent(rs.getString("content"));
				dto.setRegDate(rs.getString("regdate"));
				dto.setIsDone(rs.getString("isdone"));
				list.add(dto);
				
			}
			
			return list;
			
		} catch (Exception e) {
			System.out.println("QuestionDAO.getList()");
			e.printStackTrace();
		}
		
		
		return null;
	}

	/**
	 * 회원 본인의 1대1 문의글 개수를 가져오는 메서드입니다.
	 * @param map pagination에 필요한 begin, end와 본인의 글임을 식별할 seq가 들어있는 map입니다.
	 * @return 본인의 1대1 문의글 개수를 반환합니다.
	 */
	public int getPersonalTotalCount(HashMap<String, String> map) {
		
		try {
			
			String sql="select count(*) as cnt from tblQuestion q"
					+ "    left outer join tblAnswer a"
					+ "        on q.seq=a.seqquestion"
					+ "            inner join tblQcategory c"
					+ "                on q.seqqcategory=c.seq"
					+ "                    where q.seqmember=?";
			
			pstat=conn.prepareStatement(sql);
			pstat.setString(1, map.get("seq"));
			rs=pstat.executeQuery();
			
			if (rs.next()) {
				return rs.getInt("cnt");
			}
			
		} catch (Exception e) {
			System.out.println("QuestionDAO.getTotalCount()");
			e.printStackTrace();
		}
		
		return 0;
	}

	/**
	 * 1대1 문의글 한 개의 정보를 가져오는 메서드입니다.
	 * @param seq 문의글 PK인 seq입니다.
	 * @return 문의글 정보를 담고 있는 QuestionDTO를 반환합니다.
	 */
	public QuestionDTO getInfo(String seq) {
		
		try {
			
			String sql="select"
					+ "    q.seq as seq,"
					+ "    m.seq as seqmember,"
					+ "    m.id as id,"
					+ "    c.seq as seqqcategory,"
					+ "    c.category as category,"
					+ "    q.title as title,"
					+ "    q.content as content,"
					+ "    q.regdate as regdate"
					+ " from tblQuestion q"
					+ "    inner join tblMember m"
					+ "        on q.seqmember=m.seq"
					+ "        inner join tblQcategory c"
					+ "            on q.seqqcategory=c.seq"
					+ "                where q.seq=?";
			pstat=conn.prepareStatement(sql);
			pstat.setString(1, seq);
			rs=pstat.executeQuery();
			
			QuestionDTO dto=new QuestionDTO();
			
			if (rs.next()) {
				dto.setSeq(rs.getString("seq"));
				dto.setSeqMember(rs.getString("seqMember"));
				dto.setId(rs.getString("id"));
				dto.setSeqQCategory(rs.getString("seqqcategory"));
				dto.setqCategory(rs.getString("category"));
				dto.setTitle(rs.getString("title"));
				dto.setContent(rs.getString("content"));
				dto.setRegDate(rs.getString("regdate"));
			}
			
			return dto;
			
		} catch (Exception e) {
			System.out.println("QuestionDAO.getInfo()");
			e.printStackTrace();
		}
		
		return null;
	}

	/**
	 * QnA 질문글을 수정하는 메서드입니다.
	 * @param dto 수정할 정보를 담고 있는 DTO입니다.
	 * @return 성공하면 1, 실패하면 0을 반환합니다.
	 */
	public int edit(QuestionDTO dto) {
		
		try {
			
			String sql="update tblQuestion set title=?, content=?, seqqcategory=? where seq=?";
			
			pstat=conn.prepareStatement(sql);
			pstat.setString(1, dto.getTitle());
			pstat.setString(2, dto.getContent());
			pstat.setString(3, dto.getSeqQCategory());
			pstat.setString(4, dto.getSeq());
			return pstat.executeUpdate();
			
		} catch (Exception e) {
			System.out.println("QuestionDAO.edit()");
			e.printStackTrace();
		}
		
		return 0;
	}

	/**
	 * QnA 질문글을 삭제하는 메서드입니다.
	 * @param dto 삭제할 질문글번호와 답변이 달려있는지 여부를 담고있는 DTO입니다.
	 * @return 성공하면 1, 실패하면 0을 반환합니다.
	 */
	public int del(QuestionDTO dto) {
		
		try {
			
			// 1. 답변글 있으면 답변글 지우고, 없으면 바로 2로.
			// 2. 질문글 지우고
			
			// 1.
			String sql="";
			
			if ((dto.getIsDone()).equals("y")) {
				sql="delete from tblAnswer where seqquestion=?";
				pstat=conn.prepareStatement(sql);
				pstat.setString(1, dto.getSeq());
				pstat.executeUpdate(); // 답변글 삭제
			
			}
			// 2.
			sql="delete from tblQuestion where seq=?";
			pstat=conn.prepareStatement(sql);
			pstat.setString(1, dto.getSeq());
			return pstat.executeUpdate(); // 질문글 삭제
			
		} catch (Exception e) {
			System.out.println("QuestionDAO.del()");
			e.printStackTrace();
		}
		
		return 0;
	}
	
	/**
	 * 관리자용으로 모든 1대1문의글을 DB로부터 가져오는 메서드입니다.
	 * @param map pagination을 위해 시작 글번호, 끝 글번호를 가지고 있는 map입니다.
	 * @return 문의글 정보인 QuestionDTO들이 담긴 ArrayList를 반환합니다.
	 */
	public ArrayList<QuestionDTO> getAllList(HashMap<String, String> map) {
		
		try {
			
			String sql=String.format("select * from (select r.*, rownum as rnum from (select q.seq as seq,"
					+ "    m.id as id,"
					+ "    c.category as category,"
					+ "    q.title as title,"
					+ "    q.content as content,"
					+ "    q.regdate as regdate,"
					+ "    nvl(a.answerdate, '1900-01-01') as isdone"
					+ "    from tblQuestion q\n"
					+ "        left outer join tblAnswer a"
					+ "            on q.seq=a.seqquestion"
					+ "                inner join tblMember m"
					+ "                    on q.seqmember=m.seq"
					+ "                        inner join tblQcategory c"
					+ "                            on q.seqqcategory=c.seq order by q.seq desc) r)"
					+ "                            where rnum between %s and %s"
					, map.get("begin")
					, map.get("end"));
			
			pstat=conn.prepareStatement(sql);
			rs=pstat.executeQuery();
			
			ArrayList<QuestionDTO> qlist=new ArrayList<QuestionDTO>();
			
			while(rs.next()) {
				QuestionDTO dto=new QuestionDTO();
				dto.setSeq(rs.getString("seq"));
				dto.setId(rs.getString("id"));
				dto.setqCategory(rs.getString("category"));
				dto.setTitle(rs.getString("title"));
				dto.setContent(rs.getString("content"));
				dto.setRegDate(rs.getString("regdate"));
				dto.setIsDone(rs.getString("isdone"));
				
				qlist.add(dto);
			}
			
			return qlist;
			
		} catch (Exception e) {
			System.out.println("QuestionDAO.getAllList()");
			e.printStackTrace();
		}
		
		return null;
	}

	/**
	 * 관리자페이지에서 pagination을 위해 모든 1대1문의글 수를 가져오는 메서드입니다.
	 * @param map pagination을 위한 시작 글번호, 끝 글번호가 담긴 HashMap입니다.
	 * @return 문의글 수를 반환합니다.
	 */
	public int getTotalCount(HashMap<String, String> map) {
		
		try {
			
			String sql="select count(*) as cnt from tblQuestion";
			
			stat=conn.createStatement();
			rs=pstat.executeQuery(sql);
			
			if (rs.next()) {
				return rs.getInt("cnt");
			}
			
		} catch (Exception e) {
			System.out.println("QuestionDAO.getTotalCount()");
			e.printStackTrace();
		}
		
		return 0;
	}
	
	// ############ (조아라) 끝
}
