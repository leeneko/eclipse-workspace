
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class SelectSystem {
	
	public ArrayList<VO> select(String s) {
		
		ArrayList<VO> list = new ArrayList<VO>();
		
		try {
//			String sql = "SELECT * FROM MEMBER WHERE name LIKE '%" + s + "%'";
			String sql = "SELECT * FROM MEMBER WHERE name LIKE ?";
			
			Connection conn = DBConnection.getConnection();
			PreparedStatement pst = conn.prepareStatement(sql);
			pst.setString(1, "%" + s + "%");
			ResultSet rs = pst.executeQuery();
			
			if (rs != null) {
				while (rs.next()) {
					String tempName = rs.getString("name");
					int tempAge = rs.getInt("age");
					String tempPhone = rs.getString("phonenum");
					list.add(new VO(tempName, tempAge, tempPhone));
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
		return list;
	}
}
