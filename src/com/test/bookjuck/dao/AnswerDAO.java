package com.test.bookjuck.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import com.test.bookjuck.DBUtil;
import com.test.bookjuck.dto.AnswerDTO;

/**
 * QnA 답변 DB에 접근하는 DAO입니다.
 * @author 조아라
 *
 */
public class AnswerDAO {

	private Connection conn;
	private Statement stat;
	private PreparedStatement pstat;
	private ResultSet rs;

	public AnswerDAO() {
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
	 * 고객화면에서 질문에 따른 답변글 정보를 가져오는 메서드입니다.
	 * @param seq 질문글번호입니다.
	 * @param seqMember 회원PK인 회원번호입니다.
	 * @return 답변글정보를 담고 있는 AnswerDTO를 반환합니다.
	 */
	public AnswerDTO getInfo(String seq, String seqMember) {
		
		try {
			
			String sql="select * from tblAnswer a\n"
					+ "    inner join tblQuestion q\n"
					+ "        on q.seq=a.seqquestion\n"
					+ "            where seqquestion=?\n"
					+ "                and q.seqmember=?;";
			pstat=conn.prepareStatement(sql);
			pstat.setString(1, seq);
			pstat.setString(2, seqMember);
			rs=pstat.executeQuery();
			
			AnswerDTO dto=new AnswerDTO();
			
			if (rs.next()) {
				
				dto.setSeq(rs.getString("seq"));
				dto.setSeqQuestion(rs.getString("seqquestion"));
				dto.setAnswerContent(rs.getString("answercontent"));
				dto.setAnswerDate(rs.getString("answerdate"));
			}
			
			return dto;
			
		} catch (Exception e) {
			System.out.println("AnswerDAO.getInfo()");
			e.printStackTrace();
		}
		
		return null;
	}
	
	/**
	 * 관리자화면에서 질문에 따른 답변글 정보를 가져오는 메서드입니다.
	 * @param seq 질문글번호입니다.
	 * @return 답변글정보를 담고 있는 AnswerDTO를 반환합니다.
	 */
	public AnswerDTO getInfo(String seq) {
		
		try {
			
			String sql="select * from tblAnswer a\n"
					+ "    inner join tblQuestion q\n"
					+ "        on q.seq=a.seqquestion\n"
					+ "            where seqquestion=?\n";
			pstat=conn.prepareStatement(sql);
			pstat.setString(1, seq);
			rs=pstat.executeQuery();
			
			AnswerDTO dto=new AnswerDTO();
			
			if (rs.next()) {
				
				dto.setSeq(rs.getString("seq"));
				dto.setSeqQuestion(rs.getString("seqquestion"));
				dto.setAnswerContent(rs.getString("answercontent"));
				dto.setAnswerDate(rs.getString("answerdate"));
			}
			
			return dto;
			
		} catch (Exception e) {
			System.out.println("AnswerDAO.getInfo()");
			e.printStackTrace();
		}
		
		return null;
	}

	/**
	 * 답변글을 작성하는 메서드입니다.
	 * @param dto 작성할 답변글 정보를 담고 있는 AnswerDTO입니다.
	 * @return 성공하면 1, 실패하면 0을 반환합니다.
	 */
	public int add(AnswerDTO dto) {
		
		try {
			
			String sql="insert into tblAnswer(seq, seqquestion, answercontent, answerdate) values (seqAnswer.nextVal, ?, ?, sysdate)";
			
			pstat=conn.prepareStatement(sql);
			pstat.setString(1, dto.getSeqQuestion());
			pstat.setString(2, dto.getAnswerContent());
			
			return pstat.executeUpdate();
			
		} catch (Exception e) {
			System.out.println("AnswerDAO.add()");
			e.printStackTrace();
		}
		
		return 0;
	}

	/**
	 * 답변글을 수정하는 메서드입니다.
	 * @param dto 수정할 답변글 정보를 담고 있는 AnswerDTO입니다.
	 * @return 성공하면 1, 실패하면 0을 반환합니다.
	 */
	public int edit(AnswerDTO dto) {

		try {
			
			String sql="update tblAnswer set answerContent=? where seq=?";
			
			pstat=conn.prepareStatement(sql);
			pstat.setString(1, dto.getAnswerContent());
			pstat.setString(2, dto.getSeq());
			return pstat.executeUpdate();
			
		} catch (Exception e) {
			System.out.println("AnswerDAO.add()");
			e.printStackTrace();
		}
		
		return 0;
	}
	
	// ############ (조아라) 끝
}
