package com.test.bookjuck.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;

import com.test.bookjuck.DBUtil;
import com.test.bookjuck.dto.LetterLogDTO;

/**
 * 큐레이션레터 전송내역 DB에 접근하는 DAO입니다.
 * @author 조아라
 *
 */
public class LetterLogDAO {

	private Connection conn;
	private Statement stat;
	private PreparedStatement pstat;
	private ResultSet rs;

	public LetterLogDAO() {
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
	 * 큐레이션레터 전송내역을 가져오는 메서드입니다.
	 * @param pagination을 위한 시작 큐레이션레터 전송내역번호와 끝 큐레이션레터 전송내역번호를 담고 있는 HashMap입니다.
	 * @return 큐레이션레터 정보가 담긴 LetterLogDTO들의 ArrayList를 반환합니다.
	 */
	public ArrayList<LetterLogDTO> getList(HashMap<String, String> map) {
		
		try {
			String sql = String.format("select * from"
					+ "(select a.*, rownum as rnum from"
					+ "    (select lo.seq as seq, lo.senddate as senddate, lo.seqletter as seqletter, l.title as title, m.id as id from tblLetterlog lo"
					+ "        inner join tblLetter l"
					+ "            on lo.seqletter=l.seq"
					+ "                inner join tblMember m"
					+ "                    on m.seq=lo.seqmember order by lo.seq desc) a)"
					+ "                        where rnum between %s and %s"
					, map.get("begin")
					, map.get("end"));
		
			stat=conn.createStatement();
			rs=stat.executeQuery(sql);
			
			ArrayList<LetterLogDTO> list=new ArrayList<LetterLogDTO>();
			
			while (rs.next()) {
				LetterLogDTO dto=new LetterLogDTO();
				dto.setSeq(rs.getString("seq"));
				dto.setSendDate(rs.getString("senddate"));
				dto.setSeqLetter(rs.getString("seqletter"));
				dto.setTitle(rs.getString("title"));
				dto.setId(rs.getString("id"));
				
				list.add(dto);
				
			}
			
			return list;
			
		} catch (Exception e) {
			System.out.println("LetterLogDAO.getList()");
			e.printStackTrace();
		}
		
		return null;
	}

	/**
	 * 큐레이션레터 전송내역의 총 개수를 반환하는 메서드입니다.
	 * @return 큐레이션레터 전송내역의 총 개수를 반환합니다.
	 */
	public int getTotalCount(HashMap<String, String> map) {
		
		try {
			
			String sql="select count(*) as cnt from tblLetterLog";
			
			stat=conn.createStatement();
			rs=stat.executeQuery(sql);
			
			if (rs.next()) {
				return rs.getInt("cnt");
			}
			
		} catch (Exception e) {
			System.out.println("LetterLogDAO.getTotalCount()");
			e.printStackTrace();
		}
		
		return 0;
	}
	
	/**
	 * 큐레이션레터 전송내역을 추가하는 메서드입니다.
	 * @param dto 큐레이션레터 전송내역 정보를 담고 있는 LetterLogDTO입니다.
	 * @return 성공하면 1, 실패하면 0을 반환합니다.
	 */
	public int add(LetterLogDTO dto) {
		
		try {
			
			String sql="insert into tblLetterLog(seq, seqmember, seqletter, senddate) values(seqLetterLog.nextVal, ?, ?, sysdate)";
			
			pstat=conn.prepareStatement(sql);
			pstat.setString(1, dto.getSeqMember());
			pstat.setString(2, dto.getSeqLetter());
			
			return pstat.executeUpdate();
			
		} catch (Exception e) {
			System.out.println("LetterLogDAO.add()");
			e.printStackTrace();
		}
		
		return 0;
		
	}
	
	// ############ (조아라) 끝
}
