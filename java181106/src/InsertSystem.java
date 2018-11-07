import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class InsertSystem {
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

	public void insert(String name, int age, String phone) {
		conn();
		String sql = "INSERT INTO MEMBER VALUES('" + name + "', " + age + ", '" + phone + "')";
		try {
			PreparedStatement pst = conn.prepareStatement(sql);
			int cnt = pst.executeUpdate();
			if (cnt > 0) {
				System.out.println("입력 성공");
			} else {
				System.out.println("입력 실패");
			}
			pst.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
}
