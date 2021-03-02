package com.test.bookjuck.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;

import com.test.bookjuck.DBUtil;
import com.test.bookjuck.dto.MemberDTO;

/**
 * 
 * @author 최진영
 * 회원 정보를 조작하기 위한 DAO
 */
public class MemberDAO {
	private Connection conn;
	private Statement stat;
	private PreparedStatement pstat;
	private ResultSet rs;

	public MemberDAO() {
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

	
	/**
	 * @author 최진영
	 * @param dto 회원 가입 데이터 저장
	 * @return 회원가입 결과 
	 * 회원가입에서 기입된 정보를 입력하는 메소드
	 */
	// ############ (최진영) 시작
	public int add(MemberDTO dto) {

		try {

			String sql = "insert into tblMember (seq, id, pw, name, tel, regdate, address, ssn, login, email, points, privacy, lastDate) values(seqMember.nextVal, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

			pstat = conn.prepareStatement(sql);

			pstat.setString(1, dto.getId());
			pstat.setString(2, dto.getPw());
			pstat.setString(3, dto.getName());
			pstat.setInt(4, dto.getTel());
			pstat.setString(5, dto.getRegDate());
			pstat.setString(6, dto.getAddress());
			pstat.setString(7, dto.getSsn());
			pstat.setString(8, dto.getLogin());
			pstat.setString(9, dto.getEmail());
			pstat.setInt(10, dto.getPoints());
			pstat.setInt(11, dto.getPrivacy());
			pstat.setString(12, dto.getLastDate());

			return pstat.executeUpdate();

		} catch (Exception e) {
			System.out.println(e);
		}

		return 0;
	}
	// ############ (최진영) 종료

	
	/**
	 * @author최진영
	 * @param dto 로그인 아이디, 비밀번호
	 * @return 로그인 결과 
	 * 로그인시 아이디와 비밀번호를 비교 후 결과값 반환하는 메소드
	 */
	// ############ (최진영) 시작 
	public int login(MemberDTO dto) {

		try {
			
			String sql = "select count(*) as cnt from tblMember where id =? and pw=?";

			pstat = conn.prepareStatement(sql);
			
			pstat.setString(1, dto.getId());
			pstat.setString(2, dto.getPw());

			rs = pstat.executeQuery();
			
			if (rs.next()) {
				
				return rs.getInt("cnt");
			}
			
			

		} catch (Exception e) {
			System.out.println(e);
		}

		return 0;
	}
	// ############ (최진영) 종료 

	
	/**
	 * @author 최진영
	 * @param id 계정 아이디
	 * @return dto 
	 */
	// ############ (최진영) 시작
	public MemberDTO getMember(String id) {
		try {

			String sql = "select * from vwCustMng where id = ?";

			pstat = conn.prepareStatement(sql);
			pstat.setString(1, id);

			rs = pstat.executeQuery();
			
			if (rs.next()) {
				MemberDTO dto = new MemberDTO();

				dto.setSeq(rs.getString("seq"));
				dto.setId(rs.getString("id"));
				dto.setPw(rs.getString("pw"));
				dto.setName(rs.getString("name"));
				dto.setTel(rs.getInt("tel"));
				dto.setRegDate(rs.getString("regdate"));
				dto.setAddress(rs.getString("address"));
				dto.setSsn(rs.getString("ssn"));
				dto.setLogin(rs.getString("login"));
				dto.setEmail(rs.getString("email"));
				dto.setPoints(rs.getInt("points"));
				dto.setPrivacy(rs.getInt("privacy"));
				dto.setLastDate(rs.getString("lastDate"));
				dto.setCuration(rs.getString("curation"));
				
				return dto;
			}

		} catch (Exception e) {
			System.out.println(e);
		}
		return null;
	}
  // ############ (최진영) 종료

	/**
	 * @author 최진영
	 * @param dto 큐레이션 레터 서비스 구독  
	 * @return 결과값
	 * 회원가입 큐레이션 구독 시 사용하는 메소드
	 */
	// ############ (최진영) 시작 
	public int add_c(MemberDTO dto) {
		
		try {
			String sql = "insert into tblLetterRecipient (seq, seqMember) values(seqLetterRecipient.nextVal, seqLetterRecipient.nextVal)";
			
			pstat = conn.prepareStatement(sql);
			
			return pstat.executeUpdate();
			
		} catch (Exception e) {
			System.out.println(e);
		}
		return 0;
	}
	// ############ (최진영) 종료

	
	/**
	 * @author최진영
	 * @param id  아이디
	 * @return 결과값
	 * 회원 가입시 아이디 중복 검사 메소드
	 */
	// ############ (최진영) 시작
	public int checkId(String id) {
	
		
		try {
			String sql = "select count(*) as cnt from tblMember where id = ?";
			
			pstat = conn.prepareStatement(sql);
			pstat.setString(1, id);
			
			
			rs = pstat.executeQuery();
			
			
			if (rs.next()) {
				return rs.getInt("cnt");
			}
		
		} catch (Exception e) {
			System.out.println(e);
		}
		
		return 0;
	}
	// ############ (최진영) 종료

	
	
	/**
	 * @author 최진영
	 * @param ssn 주민번호
	 * @param name 이름
	 * @return 결과값
	 * 주민번호를 이용한 아이디 찾기
	 */ 
	// ############ (최진영) 시작
	public String findIdSsn(String ssn, String name) {
		
		try {
			
			String sql = "select id from tblMember where name=? and ssn = ?";
			
			pstat = conn.prepareStatement(sql);
			pstat.setString(1, name);
			pstat.setString(2, ssn);
			
			rs = pstat.executeQuery();

			
			if(rs.next()) {
				return rs.getString("id");
			}
		} catch (Exception e) {
			System.out.println(e);
		}	
		return null;
	}

	
	// ############ (조아라) 시작
	/**
	 * 큐레이션 레터를 수신하는 회원들의 정보를 가져오는 메서드입니다.
	 * @param id
	 * @return 회원정보를 담고 있는 MemberDTO를 반환합니다.
	 */
	public ArrayList<MemberDTO> getList() {
		
		try {
			
			String sql="select m.email as email, m.id as id, m.seq as seq from tblMember m"
					+ "    inner join tblletterrecipient lr"
					+ "        on m.seq=lr.seqmember";
			
			stat=conn.createStatement();
			rs=stat.executeQuery(sql);
			
			ArrayList<MemberDTO> list=new ArrayList<MemberDTO>();
			
			while (rs.next()) {
				MemberDTO dto=new MemberDTO();
				dto.setSeq(rs.getString("seq"));
				dto.setEmail(rs.getString("email"));
				dto.setId(rs.getString("id"));
				
				list.add(dto);
			}
			
			return list;
			
			
		} catch (Exception e) {
			System.out.println("MemberDAO.getList()");
			e.printStackTrace();
		}
		
		return null;
		
	}
	// ############ (조아라) 끝

	
	/**
	 * @author 최진영
	 * @param email 이메일
	 * @param name	이름
	 * @return 결과값
	 * 이메일을 이용한 아이디 찾기
	 */
	// ############ (최진영) 시작
	public String findIdEmail(String email, String name) {
		try {
			
			String sql = "select id from tblMember where name=? and email = ?";
			
			pstat = conn.prepareStatement(sql);
			pstat.setString(1, name);
			pstat.setString(2, email);
			
			rs = pstat.executeQuery();
			
			
			if(rs.next()) {
				return rs.getString("id");
			}
		} catch (Exception e) {
			System.out.println(e);
		}	
		return null;
	}
	// ############ (최진영) 종료

	
	/**
	 * @author최진영
	 * @param tel 전화번호
	 * @param name 이름
	 * @return 결과값
	 * 전화번호를 이용한 아이디 찾기
	 */
	// ############ (최진영) 시작
	public String findIdTel(int tel, String name) {
		
		try {
			
			String sql = "select id from tblMember where name=? and tel = ?";
			
			pstat = conn.prepareStatement(sql);
			pstat.setString(1, name);
			pstat.setInt(2, tel);
			
			rs = pstat.executeQuery();
			
			
			if(rs.next()) {
				return rs.getString("id");
			}
		} catch (Exception e) {
			System.out.println(e);
		}	
		return null;
	}
	// ############ (최진영) 종료

	
	/**
	 * @author 최진영
	 * @param email 이메일
	 * @param name 이름
	 * @param id 아이디
	 * @return 결과값
	 * 이메일 아이디를 이용한 비밀번호 찾기
	 */
	// ############ (최진영) 시작
	public String findPwEmail(String email, String name, String id) {
		try {
			
			String sql = "select pw from tblMember where name=? and email = ? and id=?";
			
			pstat = conn.prepareStatement(sql);
			pstat.setString(1, name);
			pstat.setString(2, email);
			pstat.setString(3, id);
			
			rs = pstat.executeQuery();
			
			
			if(rs.next()) {
				return rs.getString("pw");
			}
		} catch (Exception e) {
			System.out.println(e);
		}	
		return null;
	}
	// ############ (최진영) 종료

	
	/**
	 * @author 최진영
	 * @param ssn 주민번호
	 * @param name 이름
	 * @param id 아이디
	 * @return 결과값
	 * 주민번호 아이디를 이용한 비밀번호 찾기
	 */
	// ############ (최진영) 시작
	public String findPwSsn(String ssn, String name, String id) {
		try {
			
			String sql = "select pw from tblMember where name=? and ssn = ? and id=?";
			
			pstat = conn.prepareStatement(sql);
			pstat.setString(1, name);
			pstat.setString(2, ssn);
			pstat.setString(3, id);
			
			rs = pstat.executeQuery();
			
			
			if(rs.next()) {
				return rs.getString("pw");
			}
		} catch (Exception e) {
			System.out.println(e);
		}	
		return null;
	}
	// ############ (최진영) 종료

	
	/**
	 * @author 최진영
	 * @param tel 전화번호
	 * @param name 이름
	 * @param id 아이디
	 * @return 결과값
	 *  전화번호 아이디를 이용한 비밀번호 찾기
	 */
	// ############ (최진영) 시작
	public String findPwTel(int tel, String name, String id) {
		try {
			
			String sql = "select pw from tblMember where name=? and tel = ? and id=?";
			
			pstat = conn.prepareStatement(sql);
			pstat.setString(1, name);
			pstat.setInt(2, tel);
			pstat.setString(3, id);
			
			rs = pstat.executeQuery();
			
			
			if(rs.next()) {
				return rs.getString("pw");
			}
		} catch (Exception e) {
			System.out.println(e);
		}	
		return null;
	}
	// ############ (최진영) 종료

	
	
	/**
	 * @author 최진영
	 * @param map 회원관리 페이지 시작번호, 끝 번호
	 * @return 회원정보 리스트 반환
	 * 관리자 회원 관리 페이지 회원 정보 리스트 메소드
	 */
	// ############ (최진영) 시작	
	public ArrayList<MemberDTO> custMngList(HashMap<String, String> map) {
		
		try {
			
			String sql = String.format("select * from vwCustMng where rnum between %s and %s", map.get("begin"), map.get("end"));
			
			pstat =conn.prepareStatement(sql);
			
			rs = pstat.executeQuery();
			
			ArrayList<MemberDTO> mlist = new ArrayList<MemberDTO>();
			
			while(rs.next()){
				MemberDTO dto = new MemberDTO();
				dto.setSeq(rs.getString("seq"));
				dto.setName(rs.getString("name"));
				dto.setId(rs.getString("id"));
				dto.setRegDate(rs.getString("regdate"));
				dto.setTel(rs.getInt("tel"));				
				dto.setLogin(rs.getString("login"));
				dto.setLastDate(rs.getString("lastdate"));
				dto.setCuration(rs.getString("curation"));
				dto.setPrivacy(rs.getInt("privacy"));
				
				dto.setSsn(rs.getString("ssn"));
				dto.setPw(rs.getString("pw"));
				dto.setAddress(rs.getString("address"));
				dto.setEmail(rs.getString("email"));
				
				
				mlist.add(dto);
			}
				return mlist;
			
		} catch (Exception e) {
			System.out.println(e);
		}
		return null;
	}
	// ############ (최진영) 종료
	
	/**
	 * 
	 * @author 최진영
	 * @param map 회원 총 페이지
	 * @return  회원 총 페이지
	 * 총 페이지 개수를 반환하는 메소드
	 */
	// ############ (최진영) 시작
	public int getTotalCount(HashMap<String, String> map) {
		
		try {
			
			
			String sql = String.format("select count(*) as cnt from tblMember");
			
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
	// ############ (최진영) 종료

	
	/**
	 * @author 최진영
	 * @param dto 회원 번호
	 * @return 결과값
	 * 회원 번호를 이용한 회원 삭제 메소드
	 */
	// ############ (최진영) 시작
	public int del(MemberDTO dto) {
		
		try {
			String sql = "DELETE FROM tblMember where seq = ?";
			
			pstat = conn.prepareStatement(sql);
			pstat.setString(1, dto.getSeq());
			
			return pstat.executeUpdate();
			
		} catch (Exception e) {
			System.out.println(e);
		}
		
		return 0;
   }
   // ############ (최진영) 종료

	
	/**
	 * @author 최진영
	 * @param dto_m 회원 정보
	 * @return 결과값 반환
	 * 관리자 휴면 계정 관리에서 휴면 계정 -> 일반 계정 전환 시 중복 확인 메소드
	 */
	// ############ (최진영) 시작
	public int check(MemberDTO dto_m) {
		try {
			String sql ="select count(*) as cnt from vwCustMng where id=? and pw=?";
			
			pstat = conn.prepareStatement(sql);
			
			pstat.setString(1, dto_m.getId());
			pstat.setString(2, dto_m.getPw());
			rs = pstat.executeQuery();
			
			if (rs.next()) {
				
				return rs.getInt("cnt");
			}
		} catch (Exception e) {
			System.out.println(e);
		}
		
		return 0;
	}
   // ############ (최진영) 종료


	//############ 수경 시작
	public int getPoint(String id) {
		try {
			
			String sql = "select points from tblMember where id=?";
			
			pstat = conn.prepareStatement(sql);
			pstat.setString(1, id);
			rs = pstat.executeQuery();
			
			if(rs.next()) {
				return rs.getInt("points");
			}
			
			
		} catch (Exception e) {
			System.out.println(e);
		}
		return 0;
	}

	/**
	 * @author 최진영
	 * @param dto 회원 정보
	 * @return 결과값
	 * 회원 정보 수정 메소드
	 */
	// ############ (최진영) 시작
	public int edit(MemberDTO dto) {
		try {

			String sql = "update tblMember set tel=?, address=?, privacy=?, email=? where id =? and pw =?";

			pstat = conn.prepareStatement(sql);
			
			pstat.setInt(1, dto.getTel());
			pstat.setString(2, dto.getAddress());
			pstat.setInt(3, dto.getPrivacy());
			pstat.setString(4, dto.getEmail());
			pstat.setString(5, dto.getId());
			pstat.setString(6, dto.getPw());
			
			return pstat.executeUpdate();

		} catch (Exception e) {
			System.out.println(e);
		}

		return 0;
	}
	// ############ (최진영) 종료
	

	/**
	 * @author 최진영
	 * @param dto 회원 번호
	 * @return 결과갑 반환
	 * 큐레이션 레터 서비스 구독 -> 비구독 전환 메소드
	 */
	// ############ (최진영) 시작
	public int del_c(MemberDTO dto) {
		try {
			String sql = "delete from tblLetterRecipient where seqmember=?";
			
			pstat = conn.prepareStatement(sql);
			
			pstat.setString(1, dto.getPw());
			
			return pstat.executeUpdate();
			
		} catch (Exception e) {
			System.out.println(e);
		}		
		return 0;
	}
	// ############ (최진영) 종료

	
	/**
	 * @author 최진영
	 * @param dto 회원 비밀번호, 아이디 
	 * @return 결과값
	 * 비밀번호 변경 메소드
	 */
	// ############ (최진영) 시작
	public int pwEdit(MemberDTO dto) {
		
		try {
			
			String sql = "update tblMember set pw =? where id= ? ";
			
			pstat = conn.prepareStatement(sql);
			
			pstat.setString(1, dto.getPw());
			pstat.setString(2, dto.getId());
			
			return pstat.executeUpdate();
			
		} catch (Exception e) {
			System.out.println(e);
		}
		return 0;
	}
	// ############ (최진영) 종료

}
