package spring;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

//Mysql 데이터베이스 연결 테스트용 DAO클래스
public class jdbcTest {
	
	
	Member member;
	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	String email = "madvirus@madvirus.net";
	
	
	public Member select() throws SQLException, ClassNotFoundException {
		Class.forName("com.mysql.jdbc.Driver");
		String url = "jdbc:mysql://localhost:3306/spring4fs?characterEncoding=utf8&serverTimezone=UTC";
		
		try {
			conn = DriverManager.getConnection(url, "spring44", "spring44");
			pstmt = conn.prepareStatement("select * from MEMBER where EMAIL = ?");
			pstmt.setString(1, email);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				member = new Member(rs.getString("EMAIL"), 
						rs.getString("password"), 
						rs.getString("NAME"), 
						rs.getTimestamp("regdate"));
				member.setId(rs.getLong("ID"));
				return member;
				
			} else {
				return null;
			}
		} finally {
			if (rs != null)
				try {rs.close();} catch (SQLException e2) {}
			if (pstmt != null)
				try {pstmt.close();} catch (SQLException e1) {}
			if (conn != null)
				try {conn.close();} catch (SQLException e) {}
		}
	}
	
	

}
