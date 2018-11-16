package order.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDAO {
	private String url = "jdbc:oracle:thin:@localhost:1521:xe";
	private String user = "system";
	private String password = "1234";
	private Connection conn;
	private PreparedStatement psmt;
	private ResultSet rs;
	
	public void getConnection() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection(url, user, password);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	public void close() {
		try {
			if (rs != null) rs.close();
			if (psmt != null) psmt.close();
			if (conn != null) conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public UserVO login(String inputId, String inputPw) {
		UserVO vo = null;
		getConnection(); // DB연결
		String sql = "SELECT NAME FROM USERS WHERE ID = ? AND PW = ?"; // SQL작성
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, inputId);
			psmt.setString(2, inputPw);
			rs = psmt.executeQuery(); // 실행
			
			while (rs.next()) {
				String name = rs.getString("name");
				vo = new UserVO(inputId, inputPw, name);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close();
		}
		
		return vo;
	}

}
