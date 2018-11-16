package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
	public static Connection dbConn;

	public static Connection getConn() {
		Connection conn = null;
		
		try {
			String url = "jdbc:oracle:thin:@localhost:1521:XE";
			String user = "system";
			String pw = "1234";
			
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection(url, user, pw);
			
			System.out.println("DB에 연결되었습니다.\n");
		} catch (ClassNotFoundException cnfe) {
			System.out.println("DB 드라이버 로딩 실패 : " + cnfe.toString());
		} catch (SQLException sqle) {
			System.out.println("DB 접속 실패 : " + sqle.toString());
		} catch (Exception e) {
			System.out.println("Unknown error");
			e.printStackTrace();
		}
		return conn;
	}
}
