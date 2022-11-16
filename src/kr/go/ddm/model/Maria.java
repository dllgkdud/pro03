package kr.go.ddm.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Maria {
	public static final String DRIVER="org.mariadb.jdbc.Driver";
	public static final String URL = "jdbc:mariadb://127.0.0.1:3308/government?serverTimezone=Asia/Seoul";
	public static final String USER = "root";
	public static final String PW = "1234";
	
	public static final String NOTICE_SELECT_ALL = "select * from notice order by regdate desc";
	public static final String NOTICE_SELECT_ONE = "select * from notice where no=?";
	public static final String NOTICE_UPDATE_VISITED = "update notice set visited=visited+1 where no=?";
	public static final String NOTICE_INSERT = "insert into notice(title, content) values(?, ?)";
	public static final String NOTICE_UPDATE = "update notice set title=?, content=? where no=?";
	public static final String NOTICE_DELETE = "delete from notice where no=?";
	
	public static final String USER_JOIN = "insert into user(id, pw, name, birth, email, tel, addr) values(?, ?, ?, ?, ?, ?, ?)";
	public static final String USER_LOGIN = "select * from user where id=? and pw=?";
	public static final String USER_ID_CHECK = "select * from user where id=?";
	public static final String USER_UPDATE_VISITED = "update user set visited=visited+1 where id=?";
	public static final String USER_SELECT_ALL = "select * from user order by regdate desc";
	public static final String USER_SELECT_ONE = "select * from user where id=?";
	public static final String USER_UPDATE = "update user set pw=?, name=?, tel=?, birth=?, email=?, addr=? where id=?";
	
	
	public static Connection getConnection() throws ClassNotFoundException, SQLException {
		Class.forName(DRIVER);
		Connection con = DriverManager.getConnection(URL, USER, PW);
		return con;
	}
	
	//close() 오버라이딩(sql 실행상황에 따라 다르게 적용)
	public static void close(PreparedStatement pstmt, Connection con) {
		if(pstmt != null) {
			try {
				pstmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if(con != null) {
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	public static void close(ResultSet rs, PreparedStatement pstmt, Connection con) {
		if(rs != null) {
			try {
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if(pstmt != null) {
			try {
				pstmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if(con != null) {
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}
