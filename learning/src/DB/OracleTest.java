package DB;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class OracleTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Connection conn = null; // DB 연결된 상태(세션)을 담는 객체
		PreparedStatement pstm = null; // SQL 문을 나타내는 객체
		ResultSet rs = null; // 쿼리문을 날린 것에 대한 반환 값을 담는 객체

		try {
			String quary = "SELECT * FROM MEMBER";

			conn = DBConnection.getConnection();
			pstm = conn.prepareStatement(quary);
			rs = pstm.executeQuery();

			System.out.println("이름\t나이\t전화번호");
			System.out.println("========================");

			while (rs.next()) {
				String name = rs.getString(1);
				int age = rs.getInt(2);
				String phone = rs.getString(3);
				
				System.out.println(name + "\t" + age + "\t" + phone);
			}
		} catch (SQLException sqle) {
			System.out.println("SELECT문에서 예외 발생");
			sqle.printStackTrace();
		} finally {
			// DB 연걸 disconnected(DB 종료)
			try {
				if (rs != null)
					rs.close();
				if (pstm != null)
					pstm.close();
				if (conn != null)
					conn.close();
			} catch (Exception e) {
				throw new RuntimeException(e.getMessage());
			}
		}
	}

}
