package kr.go.ddm.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.crypto.util.AES256;

import kr.go.ddm.dto.TourDTO;

public class TourDAO {
	private Connection con = null;
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;
	String sql ="";

	
	//회원가입
	public int addTour(TourDTO user) {
		int cnt = 0;
		try {	
			con = Maria.getConnection();
			pstmt = con.prepareStatement(Maria.USER_JOIN);

			//저장
			
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
}