package Qusetion6;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class StudentDAO {
	
	Connection conn;
	
	public void conn() {
		try {
			String url = "jdbc:oracle:thin:@localhost:1521:xe";
			String user = "system";
			String pw = "1234";
			
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection(url, user, pw);
		} catch (ClassNotFoundException cnfe) {
			System.out.println("DB 드라이버 로딩 실패 : " + cnfe.toString());
		} catch (SQLException sqle) {
			System.out.println("DB 접속 실패 : " + sqle.toString());
		} catch (Exception e) {
			System.out.println("Unknown error");
			e.printStackTrace();
		}
	}
	
	public void insert(StudentVO vo) {
		conn();
		
		String sql = "INSERT INTO student_info values(?, ?, ?, ?, ?)"; // name, stuNumber, java, web, android
		
		try {
			PreparedStatement pst = conn.prepareStatement(sql);
			pst.setString(1, vo.getName());
			pst.setString(2, vo.getStuNumber());
			pst.setInt(3, vo.getScoreJava());
			pst.setInt(4, vo.getScoreWeb());
			pst.setInt(5, vo.getScoreAndroid());
			int result = pst.executeUpdate();
			
			if (result > 0) {
				System.out.println("성적입력이 완료되었습니다.");
			}
			
			pst.close();
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public ArrayList<StudentVO> select() {
		ArrayList<StudentVO> list = new ArrayList<StudentVO>();
		conn();
		
		String sql = "SELECT * FROM student_info";
		
		try {
			PreparedStatement pst = conn.prepareStatement(sql);
			ResultSet rs = pst.executeQuery();
			
			while (rs.next()) {
				String name = rs.getString("name");
				String number = rs.getString("stuNumber");
				int java = rs.getInt("scoreJava");
				int web = rs.getInt("scoreWeb");
				int and = rs.getInt("scoreAndroid");
				
				list.add(new StudentVO(name, number, java, web, and));
			}
			pst.close();
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return list;
	}

	public ArrayList<StudentVO> select(String next) {
		ArrayList<StudentVO> list = new ArrayList<StudentVO>();
		conn();
		
		String sql = "SELECT * FROM student_info WHERE name LIKE ?";
		
		try {
			PreparedStatement pst = conn.prepareStatement(sql);
			pst.setString(1, "%" + next + "%");
			ResultSet rs = pst.executeQuery();
			
			while (rs.next()) {
				String name = rs.getString("name");
				String number = rs.getString("stuNumber");
				int java = rs.getInt("scoreJava");
				int web = rs.getInt("scoreWeb");
				int and = rs.getInt("scoreAndroid");
				
				list.add(new StudentVO(name, number, java, web, and));
			}
			pst.close();
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return list;
	}
	
}
