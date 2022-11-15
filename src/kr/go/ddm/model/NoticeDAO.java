package kr.go.ddm.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import kr.go.ddm.dto.NoticeDTO;

public class NoticeDAO {
	private Connection con = null;
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;
	String sql ="";
	
	public ArrayList<NoticeDTO> getNoticeList() {
		ArrayList<NoticeDTO> notiList = new ArrayList<NoticeDTO>();
		try {	
			con = Maria.getConnection();
			pstmt = con.prepareStatement(Maria.NOTICE_SELECT_ALL);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				//매핑(Mapping)
				NoticeDTO dto = new NoticeDTO();
				dto.setNo(rs.getInt("no"));
				dto.setTitle(rs.getString("title"));
				dto.setContent(rs.getString("content"));
				dto.setRegDate(rs.getString("regdate"));
				dto.setVisited(rs.getInt("visited"));
				notiList.add(dto);
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
		return notiList;
	}
	
	public NoticeDTO getNotice(int no) {
		NoticeDTO dto = new NoticeDTO();
		try {	
			con = Maria.getConnection();
			//조회수 증가
			pstmt = con.prepareStatement(Maria.NOTICE_UPDATE_VISITED);
			pstmt.setInt(1, no);
			pstmt.executeUpdate();
			pstmt.close();
			//레코드 검색
			pstmt = con.prepareStatement(Maria.NOTICE_SELECT_ONE);
			pstmt.setInt(1, no);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				//매핑(Mapping)
				dto.setNo(rs.getInt("no"));
				dto.setTitle(rs.getString("title"));
				dto.setContent(rs.getString("content"));
				dto.setRegDate(rs.getString("regdate"));
				dto.setVisited(rs.getInt("visited"));
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

	public int addNotice(NoticeDTO dto) {
		int cnt = 0;
		try {	
			con = Maria.getConnection();
			pstmt = con.prepareStatement(Maria.NOTICE_INSERT);
			pstmt.setString(1, dto.getTitle());
			pstmt.setString(2, dto.getContent());
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

	public int delNotice(int no) {
		int cnt = 0;
		try {	
			con = Maria.getConnection();
			pstmt = con.prepareStatement(Maria.NOTICE_DELETE);
			pstmt.setInt(1, no);
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

	public int updateNotice(NoticeDTO dto) {
		int cnt = 0;
		try {	
			con = Maria.getConnection();
			pstmt = con.prepareStatement(Maria.NOTICE_UPDATE);
			pstmt.setString(1, dto.getTitle());
			pstmt.setString(2, dto.getContent());
			pstmt.setInt(3, dto.getNo());
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
