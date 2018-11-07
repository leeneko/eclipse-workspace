
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class SelectAllSystem {

	public ArrayList<VO> select() {
		
		ArrayList<VO> list = new ArrayList<VO>();
		
		try {
			String sql = "SELECT * FROM MEMBER";
			
			Connection conn = DBConnection.getConnection();
			PreparedStatement pst = conn.prepareStatement(sql);
			ResultSet rs = pst.executeQuery();
			
			if(rs != null) {
				while (rs.next()) {
					String name = rs.getString(1);
					int age = rs.getInt(2);
					String phone = rs.getString(3);
					list.add(new VO(name, age, phone));
				}
			} else {
				System.out.println("테이블에 정보가 없습니다");
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
