
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class DAO {

	public ArrayList<VO> select(String s) {
		
		ArrayList<VO> list = new ArrayList<VO>();
		
		try {
//			String sql = "SELECT * FROM MEMBER WHERE name LIKE '%" + s + "%'";
			String sql = "SELECT * FROM MEMBER WHERE name LIKE ?";
			
			Connection conn = DBConnection.conn();
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
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	
	public ArrayList<VO> select() {
		
		ArrayList<VO> list = new ArrayList<VO>();
		
		try {
			String sql = "SELECT * FROM MEMBER";
			
			Connection conn = DBConnection.conn();
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
	
	public void insert(String name, int age, String phone) {
		
		VO vo = new VO(name, age, phone);
		
		try {
			String sql = "INSERT INTO MEMBER VALUES(?, ?, ?)";
			
			Connection conn = DBConnection.conn();
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

	public int delete(String s) {
		int result = 0;
		try {
			String sql = "DELETE FROM member WHERE name = ?";
			
			Connection conn = DBConnection.conn();
			PreparedStatement pst = conn.prepareStatement(sql);
			pst.setString(1, s);
			result = pst.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
}
