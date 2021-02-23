package com.test.bookjuck.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;

import com.test.bookjuck.DBUtil;
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
			
			if (map.get("search")!= null) {
				
				where = String.format("where name like '%%%s%%' or title like '%%%s%%' or content like '%%%s%%'", map.get("search"), map.get("search"), map.get("search"));
			}
			
			
			String sql = String.format("select * from vwUsedBoard %s order by seq desc", where);
			
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
				
				list.add(dto); //***잘 빼먹는 부분 : 에러메세지 안뜨니 주의할 것
				
			}
			
			return list; //***잘 빼먹는 부분 : 에러메세지 안뜨니 주의할 것
			
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
		}
		
		
		return null;
	}

}