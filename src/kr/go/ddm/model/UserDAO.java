package kr.go.ddm.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.crypto.util.AES256;

import kr.go.ddm.dto.NoticeDTO;
import kr.go.ddm.dto.UserDTO;

public class UserDAO {
	private Connection con = null;
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;
	String sql ="";
	String key = "%15x";
	
	//회원목록
	public ArrayList<UserDTO> getUserList() {
		ArrayList<UserDTO> userList = new ArrayList<UserDTO>();
		try {	
			con = Maria.getConnection();
			pstmt = con.prepareStatement(Maria.USER_SELECT_ALL);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				//매핑(Mapping)
				UserDTO dto = new UserDTO();
				dto.setId(rs.getString("id"));
				dto.setPw(AES256.decryptAES256(rs.getString("pw"), key));
				dto.setName(rs.getString("name"));
				dto.setTel(rs.getString("tel"));
				dto.setBirth(rs.getString("birth"));
				dto.setEmail(rs.getString("email"));
				dto.setAddr(rs.getString("addr"));
				dto.setRegdate(rs.getString("regdate"));
				dto.setVisited(rs.getInt("visited"));				
				userList.add(dto);
			}
			
		} catch(ClassNotFoundException e) {
			System.out.println("드라이버 로딩에 실패했습니다.");
			e.printStackTrace();
		} catch(SQLException e) {
			System.out.println("SQL구문이 정상적으로 처리되지 않았습니다.");
			e.printStackTrace();
		} catch(Exception e) {
			System.out.println("잘못된 연산 및 요청으로 목록을 불러오지 못했습니다.");
			e.printStackTrace();
		} finally {
			Maria.close(rs, pstmt, con);
		}
		return userList;
	}
	
	//회원가입
	public int addUser(UserDTO user) {
		int cnt = 0;
		try {	
			con = Maria.getConnection();
			pstmt = con.prepareStatement(Maria.USER_JOIN);

			//저장
			pstmt.setString(1, user.getId());
			pstmt.setString(2, user.getPw());
			pstmt.setString(3, user.getName());
			pstmt.setString(4, user.getBirth());
			pstmt.setString(5, user.getEmail());
			pstmt.setString(6, user.getTel());
			pstmt.setString(7, user.getAddr());
			
			cnt = pstmt.executeUpdate();			
			
			
		} catch(ClassNotFoundException e) {
			System.out.println("드라이버 로딩에 실패했습니다.");
			e.printStackTrace();
		} catch(SQLException e) {
			System.out.println("SQL구문이 정상적으로 처리되지 않았습니다.");
			e.printStackTrace();
		} catch(Exception e) {
			System.out.println("잘못된 연산 및 요청으로 목록을 불러오지 못했습니다.");
			e.printStackTrace();
		} finally {
			Maria.close(pstmt, con);
		}
		return cnt;
	}
	
	//중복아이디 체크
	public int idCheckPro(String id) {
		int cnt = 0;
		try {	
			con = Maria.getConnection();
			pstmt = con.prepareStatement(Maria.USER_ID_CHECK);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				//매핑(Mapping)
				cnt = cnt +1;
			} else {
				cnt = 0;
			}
			
		} catch(ClassNotFoundException e) {
			System.out.println("드라이버 로딩에 실패했습니다.");
			e.printStackTrace();
		} catch(SQLException e) {
			System.out.println("SQL구문이 정상적으로 처리되지 않았습니다.");
			e.printStackTrace();
		} catch(Exception e) {
			System.out.println("잘못된 연산 및 요청으로 목록을 불러오지 못했습니다.");
			e.printStackTrace();
		} finally {
			Maria.close(rs, pstmt, con);
		}
		return cnt;
	}
	
	//로그인
	public int userLogin(String id, String pw) {
		int cnt = 0;
		String apw = "";
		
		try {	
			con = Maria.getConnection();
			pstmt = con.prepareStatement(Maria.USER_UPDATE_VISITED);
			pstmt.setString(1, id);
			pstmt.executeUpdate();
			pstmt.close();
			
			pstmt = con.prepareStatement(Maria.USER_ID_CHECK);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				//매핑(Mapping)
				apw = AES256.decryptAES256(rs.getString("pw"), key);
				/*System.out.println("비밀번호 복호화 : "+apw);*/
				if(pw.equals(apw)){
					cnt = 1;
				} else {
					cnt = 0;
				} 
			} else {
				cnt = 9;
			}
			
		} catch(ClassNotFoundException e) {
			System.out.println("드라이버 로딩에 실패했습니다.");
			e.printStackTrace();
		} catch(SQLException e) {
			System.out.println("SQL구문이 정상적으로 처리되지 않았습니다.");
			e.printStackTrace();
		} catch(Exception e) {
			System.out.println("잘못된 연산 및 요청으로 목록을 불러오지 못했습니다.");
			e.printStackTrace();
		} finally {
			Maria.close(rs, pstmt, con);
		}
		return cnt;
	}
	
	//회원정보
	public UserDTO userInfo(String id) {
		UserDTO dto = new UserDTO();		
		try {	
			con = Maria.getConnection();
			pstmt = con.prepareStatement(Maria.USER_SELECT_ALL);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				//매핑(Mapping)
				dto.setId(rs.getString("id"));
				dto.setPw(AES256.decryptAES256(rs.getString("pw"), key));
				dto.setName(rs.getString("name"));
				dto.setTel(rs.getString("tel"));
				dto.setBirth(rs.getString("birth"));
				dto.setEmail(rs.getString("email"));
				dto.setAddr(rs.getString("addr"));
				dto.setVisited(rs.getInt("visited"));
				dto.setRegdate(rs.getString("regdate"));
			}
			
		} catch(ClassNotFoundException e) {
			System.out.println("드라이버 로딩에 실패했습니다.");
			e.printStackTrace();
		} catch(SQLException e) {
			System.out.println("SQL구문이 정상적으로 처리되지 않았습니다.");
			e.printStackTrace();
		} catch(Exception e) {
			System.out.println("잘못된 연산 및 요청으로 목록을 불러오지 못했습니다.");
			e.printStackTrace();
		} finally {
			Maria.close(rs, pstmt, con);
		}
		return dto;
	}
	
	//회원수정
	public int updateUser(UserDTO user) {
		int cnt = 0;
		try {	
			con = Maria.getConnection();
			pstmt = con.prepareStatement(Maria.USER_UPDATE);

			//저장
			pstmt.setString(1, user.getPw());
			pstmt.setString(2, user.getName());
			pstmt.setString(3, user.getTel());			
			pstmt.setString(4, user.getBirth());
			pstmt.setString(5, user.getEmail());
			pstmt.setString(6, user.getAddr());
			pstmt.setString(7, user.getId());			
			
			cnt = pstmt.executeUpdate();			
			
			
		} catch(ClassNotFoundException e) {
			System.out.println("드라이버 로딩에 실패했습니다.");
			e.printStackTrace();
		} catch(SQLException e) {
			System.out.println("SQL구문이 정상적으로 처리되지 않았습니다.");
			e.printStackTrace();
		} catch(Exception e) {
			System.out.println("잘못된 연산 및 요청으로 목록을 불러오지 못했습니다.");
			e.printStackTrace();
		} finally {
			Maria.close(pstmt, con);
		}
		return cnt;
	}
}
