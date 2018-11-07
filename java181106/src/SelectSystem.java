
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SelectSystem {
	Connection conn = null;

	private void conn() {
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String user = "system";
		String pw = "1234";

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver"); // 클래스 파일 동적 로딩
			conn = DriverManager.getConnection(url, user, pw);
			if (conn == null) {
				System.out.println("연결 실패");
			} else {
				System.out.println("연결 성공");
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void select() {
		conn();
		String sql = "SELECT * FROM MEMBER";
		try {
			PreparedStatement pst = conn.prepareStatement(sql);
			ResultSet rs = pst.executeQuery();

			System.out.println("이름\t나이\t전화번호");
			System.out.println("========================");

			while (rs.next()) {
				String name = rs.getString(1);
				int age = rs.getInt(2);
				String phone = rs.getString(3);
				
				System.out.println(name + "\t" + age + "\t" + phone);
			}
			rs.close();
			pst.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void select(String s) {
		conn();
		String sql = "SELECT name, age, phonenum FROM MEMBER WHERE name = '" + s + "'";
		try {
			PreparedStatement pst = conn.prepareStatement(sql);
			ResultSet rs = pst.executeQuery();
			
			if (rs != null) {
				System.out.println("이름\t나이\t전화번호");
				System.out.println("========================");
				
				while (rs.next()) {
					String name = rs.getString("name");
					int age = rs.getInt("age");
					String phone = rs.getString("phonenum");
					
					System.out.println(name + "\t" + age + "\t" + phone);
				}
			} else {
				System.out.println("검색 실패");
			}
			
			rs.close();
			pst.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
