
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class InsertSystem {
	
	public void insert(String name, int age, String phone) {
		
		VO vo = new VO(name, age, phone);
		
		try {
			String sql = "INSERT INTO MEMBER VALUES(?, ?, ?)";
			
			Connection conn = DBConnection.getConnection();
			PreparedStatement pst = conn.prepareStatement(sql);
			pst.setString(1, vo.getName());
			pst.setInt(2, vo.getAge());
			pst.setString(3, vo.getPhone());
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
