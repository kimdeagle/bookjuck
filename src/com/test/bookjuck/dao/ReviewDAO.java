package com.test.bookjuck.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;

import com.test.bookjuck.DBUtil;
import com.test.bookjuck.dto.ReviewDTO;

/**
 * 독후감 DB에 접근하는 DAO입니다.
 * @author 조아라
 *
 */
public class ReviewDAO {

	private Connection conn;
	private Statement stat;
	private PreparedStatement pstat;
	private ResultSet rs;

	public ReviewDAO() {
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
	 * 회원 본인의 독후감 목록을 가져오는 메서드입니다.
	 * @param map 회원번호(seq)와 시작 독후감번호, 끝 독후감번호를 담고 있는 HashMap입니다.
	 * @return 독후감정보를 담고 있는 ReviewDTO들의 ArrayList를 반환합니다.
	 */
	public ArrayList<ReviewDTO> getList(HashMap<String, String> map) {

		try {
			
			String sql=String.format("select * from (select a.*, rownum as rnum from"
					+ "    (select r.seq as seq,"
					+ "        r.title as reviewtitle,"
					+ "        r.content as reviewcontent,"
					+ "        r.regdate as regdate,"
					+ "        r.isprize as isprize,"
					+ "        m.seq as seqmember,"
					+ "        m.id as id,"
					+ "        b.seq as seqbook,"
					+ "        b.title as booktitle"
					+ "    from tblReview r"
					+ "        inner join tblBook b"
					+ "            on r.seqbook=b.seq"
					+ "                inner join tblMember m"
					+ "                    on r.seqmember=m.seq"
					+ "    where r.seqmember=%s"
					+ "    order by r.seq desc) a)"
					+ "where rnum between %s and %s",
							map.get("seq"), map.get("begin"), map.get("end"));
			
			
			stat=conn.createStatement();
			rs=stat.executeQuery(sql);
			
			ArrayList<ReviewDTO> list=new ArrayList<ReviewDTO>();

			while (rs.next()) {
				ReviewDTO dto=new ReviewDTO();
				dto.setSeq(rs.getString("seq"));
				dto.setReviewTitle(rs.getString("reviewtitle"));
				dto.setReviewContent(rs.getString("reviewcontent"));
				dto.setRegDate(rs.getString("regdate"));
				dto.setBookTitle(rs.getString("booktitle"));
				dto.setIsPrize(rs.getString("isprize"));
				dto.setBookTitle(rs.getString("booktitle"));
				dto.setId(rs.getString("id"));
				dto.setSeqMember(rs.getString("seqmember"));
				dto.setSeqBook(rs.getString("seqbook"));
				
				list.add(dto);
				
			}
			
			return list;
			
		} catch (Exception e) {
			System.out.println("ReviewDAO.getList()");
			e.printStackTrace();
		}
		
		return null;
	}
	
	/**
	 * 회원들이 쓴 독후감 전체를 가져오는 메서드입니다.
	 * @param map 시작 독후감 번호와 끝 독후감 번호를 담고 있는 HashMap입니다.
	 * @return 독후감 정보를 담고 있는 ReveiwDTO들의 ArrayList를 반환합니다.
	 */
	public ArrayList<ReviewDTO> getAllList(HashMap<String, String> map) {
		
		try {
			
			String sql=String.format("select * from (select a.*, rownum as rnum from"
					+ "    (select r.seq as seq,"
					+ "        r.title as reviewtitle,"
					+ "        r.content as reviewcontent,"
					+ "        r.regdate as regdate,"
					+ "        r.isprize as isprize,"
					+ "        m.id as id,"
					+ "        b.title as booktitle"
					+ "    from tblReview r"
					+ "        inner join tblBook b"
					+ "            on r.seqbook=b.seq"
					+ "                inner join tblMember m"
					+ "                    on r.seqmember=m.seq"
					+ "    order by r.seq desc) a)"
					+ "where rnum between %s and %s",
							map.get("begin"), map.get("end"));
			
			
			stat=conn.createStatement();
			rs=stat.executeQuery(sql);
			
			ArrayList<ReviewDTO> list=new ArrayList<ReviewDTO>();

			while (rs.next()) {
				ReviewDTO dto=new ReviewDTO();
				dto.setSeq(rs.getString("seq"));
				dto.setReviewTitle(rs.getString("reviewtitle"));
				dto.setReviewContent(rs.getString("reviewcontent"));
				dto.setRegDate(rs.getString("regdate"));
				dto.setBookTitle(rs.getString("booktitle"));
				dto.setIsPrize(rs.getString("isprize"));
				dto.setBookTitle(rs.getString("booktitle"));
				dto.setId(rs.getString("id"));
				
				list.add(dto);
				
			}
			
			return list;
			
		} catch (Exception e) {
			System.out.println("ReviewDAO.getList()");
			e.printStackTrace();
		}
		
		return null;
		
	}
	
	/**
	 * 회원이 쓴 독후감 총 개수를 가져오는 메서드입니다.
	 * @param map pagination을 위한 시작 독후감번호와 끝 독후감번호, 회원번호를 담고 있습니다.
	 * @return 독후감 총 개수가 반환됩니다.
	 */
	public int getTotalCount(HashMap<String, String> map) {
	
		try {
			
			String sql="select count(*) as cnt from tblReview where seqmember=?";
			
			pstat=conn.prepareStatement(sql);
			pstat.setString(1, map.get("seq"));
			rs=pstat.executeQuery();
			
			if (rs.next()) {
				return rs.getInt("cnt");
			}
			
		} catch (Exception e) {
			System.out.println("ReviewDAO.getTotalCount()");
			e.printStackTrace();
		}
		
		return 0;
	}
	
	/**
	 * 전체 회원이 쓴 독후감 총 개수를 가져오는 메서드입니다.
	 * @param map pagination을 위한 시작 독후감번호와 끝 독후감번호를 담고 있습니다.
	 * @return 독후감 총 개수가 반환됩니다.
	 */
	public int getAllTotalCount(HashMap<String, String> map) {
		
		try {
			
			String sql="select count(*) as cnt from tblReview";
			
			stat=conn.createStatement();
			rs=stat.executeQuery(sql);
			
			if (rs.next()) {
				return rs.getInt("cnt");
			}
			
		} catch (Exception e) {
			System.out.println("ReviewDAO.getAllTotalCount()");
			e.printStackTrace();
		}
		
		return 0;
	}

	/**
	 * 독후감 한 개의 정보를 가져오는 메서드입니다.
	 * @param seq 독후감 고유번호 seq입니다.
	 * @return 독후감 정보를 담고 있는 ReviewDTO입니다.
	 */
	public ReviewDTO getInfo(String seq) {
		
		try {
			
			String sql="select r.seq as seq,\n"
					+ "    r.title as reviewtitle,\n"
					+ "    r.content as reviewcontent,\n"
					+ "    r.regdate as regdate,\n"
					+ "    r.isprize as isprize,\n"
					+ "    b.title as booktitle,\n"
					+ "    m.seq as seqmember,\n"
					+ "    m.id as id\n"
					+ "    from tblReview r\n"
					+ "    inner join tblBook b\n"
					+ "        on r.seqbook=b.seq\n"
					+ "            inner join tblMember m\n"
					+ "                on r.seqmember=m.seq\n"
					+ "                    where r.seq=?";
			
			pstat=conn.prepareStatement(sql);
			pstat.setString(1, seq);
			
			rs=pstat.executeQuery();
			
			ReviewDTO dto=new ReviewDTO();
			
			while (rs.next()) {
				
				dto.setSeq(rs.getString("seq"));
				dto.setReviewTitle(rs.getString("reviewtitle"));
				dto.setReviewContent(rs.getString("reviewcontent"));
				dto.setRegDate(rs.getString("regdate"));
				dto.setIsPrize(rs.getString("isprize"));
				dto.setBookTitle(rs.getString("booktitle"));
				dto.setId(rs.getString("id"));
				dto.setSeqMember(rs.getString("seqmember"));
			}
			
			return dto;
			
		} catch (Exception e) {
			System.out.println("ReviewDAO.getInfo()");
			e.printStackTrace();
		}
		
		return null;
	}

	/**
	 * 독후감 한 개를 삭제하는 메서드입니다.
	 * @param seq 독후감의 PK인 독후감번호입니다.
	 * @return 성공하면 1, 실패하면 0을 반환합니다.
	 */
	public int del(String seq) {
		
		try {
			
			String sql="delete from tblReview where seq=?";
			
			pstat=conn.prepareStatement(sql);
			pstat.setString(1, seq);
			
			return pstat.executeUpdate();
			
		} catch (Exception e) {
			System.out.println("ReviewDAO.del()");
			e.printStackTrace();
		}
		
		return 0;
	}

	/**
	 * 우수독후감을 선정하는 메서드입니다.
	 * @return 성공하면 1, 실패하면 0을 반환합니다.
	 */
	public int prize(String seq) {
		
		try {
			
			// 우수독후감 선정은 두 단계에 걸쳐 이루어진다.
			// 1단계. 독후감 isprize컬럼 1로 바꾸기.
			// 2단계. 그 독후감 작성한 작성자 포인트 올려주기.
			
			// 1단계
			String sql="update tblReview set isprize=1 where seq=?";
			pstat=conn.prepareStatement(sql);
			pstat.setString(1, seq);
			
			int result=pstat.executeUpdate();
			
			if (result==1) {
				
				// 우수독후감으로 선정하는 작업이 끝나면
				// 그 독후감의 작성자 포인트를 올려준다.
				String memSeq=getMember(seq);
				
				sql="update tblMember set points=points+5000 where seq=?";
				pstat=conn.prepareStatement(sql);
				pstat.setString(1, memSeq);
				
				return pstat.executeUpdate();
				
			} else {
				new Exception();
			}
			
		} catch (Exception e) {
			System.out.println("ReviewDAO.prize()");
			e.printStackTrace();
		}
		
		return 0;
	}
	
	/**
	 * 독후감번호로 독후감 작성자의 PK(seq)를 가져오는 메서드입니다.
	 * @param seq 독후감번호입니다.
	 * @return 독후감 작성자의 PK(seq)를 반환합니다.
	 */
	public String getMember(String seq) {
		
		try {
			
			String sql="select seqmember from tblReview where seq=?";
			pstat=conn.prepareStatement(sql);
			pstat.setString(1, seq);
			rs=pstat.executeQuery();
			
			if (rs.next()) {
				return rs.getString("seqmember");
			}
			
		} catch (Exception e) {
			System.out.println("ReviewDAO.getMember()");
			e.printStackTrace();
		}
		
		return null;
		
	}

	/**
	 * 독후감을 추가하는 메서드입니다.
	 * @param dto 저장할 독후감 정보를 담고 있는 ReviewDTO입니다.
	 * @return 성공하면 1, 실패하면 0을 반환합니다.
	 */
	public int add(ReviewDTO dto) {
		
		try {
			
			String sql="insert into tblReview(seq, seqmember, seqbook, title, content, regdate, isprize) values(seqReview.nextVal, ?, ?, ?, ?, sysdate, 0)";
			pstat=conn.prepareStatement(sql);
			pstat.setString(1, dto.getSeqMember());
			pstat.setString(2, dto.getSeqBook());
			pstat.setString(3, dto.getReviewTitle());
			pstat.setString(4, dto.getReviewContent());
			
			return pstat.executeUpdate();
			
		} catch (Exception e) {
			System.out.println("ReviewDAO.add()");
			e.printStackTrace();
		}
		
		return 0;
	}

	/**
	 * 독후감을 수정하는 메서드입니다.
	 * @param dto 수정할 독후감 정보를 담고 있는 ReviewDTO입니다.
	 * @return 성공하면 1, 실패하면 0을 반환합니다.
	 */
	public int edit(ReviewDTO dto) {
	
		try {
			
			String sql="update tblReview set title=?, content=? where seq=?";
			pstat=conn.prepareStatement(sql);
			pstat.setString(1, dto.getReviewTitle());
			pstat.setString(2, dto.getReviewContent());
			pstat.setString(3, dto.getSeq());
			
			return pstat.executeUpdate();
			
		} catch (Exception e) {
			System.out.println("ReviewDAO.edit()");
			e.printStackTrace();
		}
		
		return 0;
	}
	
	// ############ (조아라) 끝
}
