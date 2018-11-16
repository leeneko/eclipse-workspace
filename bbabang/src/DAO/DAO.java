package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import VO.MemberVO;

public class DAO {
	private Connection conn = null;
	private PreparedStatement pstm = null;
	private ResultSet rs = null;
	private MemberVO vo = null;

	public MemberVO login(String id, String pw) {
		MemberVO vo = new MemberVO();
		try {
			conn = DBConnection.getConn();
			String sql = "SELECT * FROM MEMBER WHERE ID = ? AND PW = ?";
			pstm = conn.prepareStatement(sql);
			pstm.setString(1, id);
			pstm.setString(2, pw);
			rs = pstm.executeQuery();
			while (rs.next()) {
				vo.setId(rs.getString("ID"));
				vo.setPw(rs.getString("PW"));
				vo.setPw(rs.getString("NAME"));
				vo.setPhone(rs.getString("PHONE"));
				vo.setPost(rs.getInt("POST"));
				vo.setAddress(rs.getString("ADDRESS"));
				vo.setLicense(rs.getString("LICENSE"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {

		}
		return vo;
	}

	public boolean join(MemberVO vo) { // 회원가입
		int result = 0;
		boolean bool = false;
		try {
			conn = DBConnection.getConn();
			String sql = "INSERT INTO member VALUES (?, ?, ?, ?, ?, ?, ?)";
			pstm = conn.prepareStatement(sql);
			pstm.setString(1, vo.getId());
			pstm.setString(2, vo.getPw());
			pstm.setString(3, vo.getName());
			pstm.setString(4, vo.getPhone());
			pstm.setInt(5, vo.getPost());
			pstm.setString(6, vo.getAddress());
			pstm.setString(7, vo.getLicense());
			result = pstm.executeUpdate();
			if (result > 0) {
				bool = true;
			}
		} catch (Exception e) {
			return false;
		} finally {
			close();
		}
		return bool;
	}

	private void close() {
		// TODO Auto-generated method stub
		try {
			if (rs != null)
				rs.close();
			if (pstm != null)
				pstm.close();
			if (conn != null)
				conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public MemberVO idsearch(String inputName, String inputPhone) {
		try {
			conn = DBConnection.getConn();
			String sql = "SELECT * FROM MEMBER WHERE NAME LIKE ? AND PHONE LIKE ?";
			pstm = conn.prepareStatement(sql);

			pstm.setString(1, inputName);
			pstm.setString(2, inputPhone);

			rs = pstm.executeQuery();

			while (rs.next()) {
				String id = rs.getString("id");
				String pw = rs.getString("pw");
				int post = rs.getInt("post");
				String address = rs.getString("address");
				String license = rs.getString("license");
				vo = new MemberVO(id, pw, inputName, inputPhone, post, address, license);
			}
		} catch (Exception e) {
			// TODO: handle exception
		} finally {

		}
		return vo;
	}

	public MemberVO pwsearch(String inputName, String inputId, String inputPhone) {
		try {
			conn = DBConnection.getConn();
			String sql = "SELECT * FROM MEMBER WHERE NAME LIKE ? AND ID LIKE ? AND PHONE LIKE ?";
			pstm = conn.prepareStatement(sql);

			pstm.setString(1, inputName);
			pstm.setString(2, inputId);
			pstm.setString(3, inputPhone);

			rs = pstm.executeQuery();

			while (rs.next()) {
				String id = rs.getString("id");
				String pw = rs.getString("pw");
				int post = rs.getInt("post");
				String address = rs.getString("address");
				String license = rs.getString("license");
				vo = new MemberVO(id, pw, inputName, inputPhone, post, address, license);
			}
		} catch (Exception e) {
			// TODO: handle exception
		} finally {

		}
		return vo;
	}
}
