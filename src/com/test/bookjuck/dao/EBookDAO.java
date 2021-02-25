package com.test.bookjuck.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;

import com.test.bookjuck.DBUtil;
import com.test.bookjuck.dto.EBookDTO;

public class EBookDAO {

	private Connection conn;
	private Statement stat;
	private PreparedStatement pstat;
	private ResultSet rs;

	public EBookDAO() {
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

	//주혁 시작
	
	//EBookList 서블릿 -> ebooklist 반환
	public ArrayList<EBookDTO> getEBookList(HashMap<String, String> map) {
		
		try {
			
			String sql = "";
			String innerSql = "";
			
			if (map.get("seqSCategory") == null) {
				//E-Book 리스트 첫 화면
				innerSql = "select eb.*, (select name from tblAuthor where seq = eb.seqAuthor) as author from tblEbook eb order by eb.pubDate desc, eb.title asc";

			} else {
				//도서 리스트 좌측 소분류 선택
				innerSql = String.format("select eb.*, (select name from tblAuthor where seq = eb.seqAuthor) as author from tblEbook eb where eb.seqSCategory = %s order by eb.pubDate desc, eb.title asc", map.get("seqSCategory"));

			}
			
			sql = String.format("select * from (select a.*, rownum as rnum from (%s) a) where rnum between %s and %s", innerSql, map.get("begin"), map.get("end"));
			
			pstat = conn.prepareStatement(sql);
			rs = pstat.executeQuery();
			
			ArrayList<EBookDTO> eblist = new ArrayList<EBookDTO>();
			
			while (rs.next()) {
				EBookDTO dto = new EBookDTO();
				
				dto.setSeq(rs.getString("seq"));
				dto.setImage(rs.getString("image"));
				dto.setTitle(rs.getString("title"));
				dto.setAuthor(rs.getString("author"));
				dto.setPublisher(rs.getString("publisher"));
				dto.setPubDate(rs.getString("pubDate"));
				dto.setIntro(rs.getString("intro"));
				dto.setPrice(rs.getInt("price"));
				dto.setSalePrice(rs.getInt("salePrice"));
				
				eblist.add(dto);
			}
			
			return eblist;
			
			
		} catch (Exception e) {
			System.out.println(e);
		}
		
		return null;
	}
	
	//EBookDetail 서블릿 -> E-Book 상세정보 호출
	public EBookDTO getEBookDetail(String seq) {
		
		try {
			
			String sql = "select eb.*, (select name from tblAuthor where seq = eb.seqAuthor) as author, (select intro from tblAuthor where seq = eb.seqAuthor) as authorIntro, sc.sCategory as sCategory, mc.mCategory as mCategory, lc.lCategory as lCategory from tblEBook eb inner join tblSCategory sc on eb.seqSCategory = sc.seq inner join tblMCategory mc on sc.seqMCategory = mc.seq inner join tblLCategory lc on mc.seqLCategory = lc.seq where eb.seq = ?";
			
			pstat = conn.prepareStatement(sql);
			pstat.setString(1, seq);
			rs = pstat.executeQuery();
			
			EBookDTO dto = new EBookDTO();
			
			if (rs.next()) {
				dto.setSeq(rs.getString("seq"));
				dto.setSeqAuthor(rs.getString("seqAuthor"));
				dto.setSeqSCategory(rs.getString("seqSCategory"));
				dto.setTitle(rs.getString("title"));
				dto.setPublisher(rs.getString("publisher"));
				dto.setPrice(rs.getInt("price"));
				dto.setSalePrice(rs.getInt("salePrice"));
				dto.setPubDate(rs.getString("pubDate"));
				dto.setIntro(rs.getString("intro"));
				dto.setIsbn(rs.getString("isbn"));
				dto.setCopy(rs.getString("copy"));
				dto.setImage(rs.getString("image"));
				dto.setContents(rs.getString("contents"));
				dto.seteFile(rs.getString("eFile"));
				
				dto.setAuthor(rs.getString("author"));
				dto.setAuthorIntro(rs.getString("authorIntro"));
				
				dto.setsCategory(rs.getString("sCategory"));
				dto.setmCategory(rs.getString("mCategory"));
				dto.setlCategory(rs.getString("lCategory"));
				
				return dto;
			}
			
		} catch (Exception e) {
			System.out.println(e);
		}
		
		return null;
	}

	//EBookList 서블릿 -> E-Book 수 반환
	public int getEBookCount(HashMap<String, String> map) {
		
		try {
			
			String where = "";
			
			if (map.get("seqSCategory") != null) {
				//소분류 선택
				where = String.format("where seqSCategory = %s", map.get("seqSCategory"));
			}
			
			String sql = String.format("select count(*) as cnt from tblEBook %s", where);
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
	
	//주혁 끝
	
} //EBookDAO
