package order.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

public class OrdersDAO {
	
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

	public Vector<Vector<Object>> selectOrderList(String inputId) {
		// TODO Auto-generated method stub
		Vector<Vector<Object>> data = new Vector<>();
		getConnection();
		
		String sql = "SELECT * FROM ORDERS WHERE ORDER_ID = ?"; // SQL작성
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, inputId);
			rs = psmt.executeQuery(); // 실행
			
			while (rs.next()) {
				Vector<Object> small = new Vector<>();
				small.add(rs.getString("PRODUCT_NUM"));
				small.add(rs.getString("PRODUCT_NAME"));
				small.add(rs.getInt("PRODUCT_PRICE"));
				data.add(small);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close();
		}
		
		return data;
	}

}
