package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Vector;
import java.util.Vector;

import VO.CarVO;
import VO.MemberVO;
import VO.ReviewVO;

public class DAO {
	private Connection conn = null;
	private PreparedStatement pstm = null;
	private ResultSet rs = null;
	private MemberVO vo = null;
	private CarVO vo2 = null;
	private ArrayList<String> list;

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
			return null;
		} finally {
			close();
		}
		return vo;
	}

	public int join(MemberVO vo) { // 회원가입
		int result = 0;
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
				result = 1;
			}
		} catch (SQLException e) {
			// 참고 사이트 : http://rosebud90.tistory.com/entry/18-Oracle-Exception-%EC%98%88%EC%99%B8%EC%B2%98%EB%A6%AC
			String[] except = e.toString().split(" ");
			if (except[1].equals("ORA-00001:")) { // 아이디 중복 오류
				result = 2;
			}
		} catch (Exception e) {
			return 0;
		} finally {
			close();
		}
		return result; // 0. 알 수 없는 회원가입 오류, 1. 회원가입 성공, 2. 아이디 중복 오류  
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
			close();
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
			close();
		}
		return vo;
	}

	public int insertCar(CarVO vo2) {
		int result = 0;
		try {
			conn = DBConnection.getConn();
			// INSERT INTO car VALUES ('73호4296', '소형', '넥스트 스파크', '등록', 30000, 180, 1980);
			String sql = "INSERT INTO car VALUES (?, ?, ?, ?, ?, ?, ?)";
			pstm = conn.prepareStatement(sql);
			pstm.setString(1, vo2.getCarnum());
			pstm.setString(2, vo2.getCartype());
			pstm.setString(3, vo2.getCarname());
			pstm.setString(4, vo2.getCarstat());
			pstm.setInt(5, vo2.getRentalfee());
			pstm.setInt(6, vo2.getRunfee());
			pstm.setInt(7, vo2.getOilfee());
			result = pstm.executeUpdate();
			if (result > 0) {
				result = 1;
			}
		} catch (SQLException e) {
			// 참고 사이트 : http://rosebud90.tistory.com/entry/18-Oracle-Exception-%EC%98%88%EC%99%B8%EC%B2%98%EB%A6%AC
			String[] except = e.toString().split(" ");
			if (except[1].equals("ORA-00001:")) { // 프라이머리키 값 중복 오류
				result = 2;
			}
		} catch (Exception e) {
			return 0;
		} finally {
			close();
		}
		return result; // 0. 알 수 없는 회원가입 오류, 1. 회원가입 성공, 2. 아이디 중복 오류  
	}

	public int showMeTheMoney() {
		int result = 0;
		try {
			conn = DBConnection.getConn();
			// SELECT SUM(fee) FROM rent GROUP BY ROLLUP(fee);
			String sql = "SELECT SUM(fee) FROM rent GROUP BY ROLLUP(fee)";
			result = pstm.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			close();
		}
		return result;
	}

	public Vector<Vector<Object>> selectMember() {
		Vector<Vector<Object>> list = new Vector<Vector<Object>>();
		
		String sql = "SELECT * FROM member";
		try {
			conn = DBConnection.getConn();
			pstm = conn.prepareStatement(sql);
			rs = pstm.executeQuery();
			
			while (rs.next()) {
				Vector<Object> small = new Vector<Object>();
				// 회원 정보 확인 (id, pw, name, phone, post, address, license)
				small.add(rs.getString("id"));
				small.add(rs.getString("pw"));
				small.add(rs.getString("name"));
				small.add(rs.getString("phone"));
				small.add(rs.getInt("post"));
				small.add(rs.getString("address"));
				small.add(rs.getString("license"));
				list.add(small);
			}
		} catch (SQLException e) {
		} catch (Exception e) {
		} finally {
			close();
		}
		return list;
	}

	public Vector<Vector<Object>> selectMember(String s) {
		Vector<Vector<Object>> list = new Vector<Vector<Object>>();
		// SELECT * FROM member WHERE UPPER(name) LIKE '%관리%'
		String sql = "SELECT * FROM member WHERE UPPER(name) LIKE ?";
		try {
			conn = DBConnection.getConn();
			pstm = conn.prepareStatement(sql);
			pstm.setString(1, "%" + s + "%");
			rs = pstm.executeQuery();
			
			while (rs.next()) {
				Vector<Object> small = new Vector<Object>();
				// 회원 정보 확인 (id, pw, name, phone, post, address, license)
				small.add(rs.getString("id"));
				small.add(rs.getString("pw"));
				small.add(rs.getString("name"));
				small.add(rs.getString("phone"));
				small.add(rs.getInt("post"));
				small.add(rs.getString("address"));
				small.add(rs.getString("license"));
				list.add(small);
			}
		} catch (SQLException e) {
		} catch (Exception e) {
		} finally {
			close();
		}
		return list;
	}

	public Vector<Vector<Object>> selectCar() {
		Vector<Vector<Object>> list = new Vector<Vector<Object>>();
		
		String sql = "SELECT * FROM car";
		try {
			conn = DBConnection.getConn();
			pstm = conn.prepareStatement(sql);
			rs = pstm.executeQuery();
			while (rs.next()) {
				Vector<Object> small = new Vector<Object>();
				// 차량 확인 car (carnum, cartype, carname, carstat, rentalfee, runfee, oilfee)
				small.add(rs.getString("carnum"));
				small.add(rs.getString("cartype"));
				small.add(rs.getString("carname"));
				small.add(rs.getString("carstat"));
				small.add(rs.getInt("rentalfee"));
				small.add(rs.getString("runfee"));
				small.add(rs.getString("oilfee"));
				list.add(small);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return list;
	}
	
	public Vector<Vector<Object>> selectCar(String s) {
		Vector<Vector<Object>> list = new Vector<Vector<Object>>();
		// SELECT * FROM car WHERE cartype='소형';
		String sql = "SELECT * FROM car WHERE cartype = ?";
		try {
			conn = DBConnection.getConn();
			pstm = conn.prepareStatement(sql);
			pstm.setString(1, s);
			rs = pstm.executeQuery();
			while (rs.next()) {
				Vector<Object> small = new Vector<Object>();
				// 차량 확인 car (carnum, cartype, carname, carstat, rentalfee, runfee, oilfee)
				small.add(rs.getString("carnum"));
				small.add(rs.getString("cartype"));
				small.add(rs.getString("carname"));
				small.add(rs.getString("carstat"));
				small.add(rs.getInt("rentalfee"));
				small.add(rs.getString("runfee"));
				small.add(rs.getString("oilfee"));
				list.add(small);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return list;
	}

	public ArrayList<CarVO> carList() {
		ArrayList<CarVO> list = new ArrayList<CarVO>();
		String sql = "SELECT * FROM car";
		try {
			conn = DBConnection.getConn();
			pstm = conn.prepareStatement(sql);
			rs = pstm.executeQuery();
			while (rs.next()) {
				// 차량 확인 car (carnum, cartype, carname, carstat, rentalfee, runfee, oilfee)
				CarVO vo = new CarVO(rs.getString("carnum"),
						rs.getString("cartype"),
						rs.getString("carname"),
						rs.getString("carstat"),
						rs.getInt("rentalfee"),
						rs.getInt("runfee"),
						rs.getInt("oilfee")
						);
				list.add(vo);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return list;
	}

	public CarVO carInfoEdit(CarVO vo) {
		CarVO result = null;
		// UPDATE car SET CARTYPE = '중형', CARNAME = '뉴 SM5', CARSTAT = '등록',
		// RENTALFEE = 45000, RUNFEE = 230, OILFEE = 1700 WHERE CARNUM = '73호4296'
		String sql = "UPDATE car SET CARTYPE = ?, CARNAME = ?, CARSTAT = ?, RENTALFEE = ?, RUNFEE = ?, OILFEE = ? WHERE CARNUM = ?";
		try {
			conn = DBConnection.getConn();
			pstm = conn.prepareStatement(sql);
			pstm.setString(1, vo.getCartype());
			pstm.setString(2, vo.getCarname());
			pstm.setString(3, vo.getCarstat());
			pstm.setInt(4, vo.getRentalfee());
			pstm.setInt(5, vo.getRunfee());
			pstm.setInt(6, vo.getOilfee());
			pstm.setString(7, vo.getCarnum());
			rs = pstm.executeQuery();
			while (rs.next()) {
				// 차량 확인 car (carnum, cartype, carname, carstat, rentalfee, runfee, oilfee)
				result = new CarVO(rs.getString("carnum"),
						rs.getString("cartype"),
						rs.getString("carname"),
						rs.getString("carstat"),
						rs.getInt("rentalfee"),
						rs.getInt("runfee"),
						rs.getInt("oilfee")
						);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return result;
	}

	public CarVO carInfo(String s) {
		CarVO result = null;
		// SELECT * FROM car WHERE carnum = '11하1111';
		String sql = "SELECT * FROM car WHERE carnum = ?";
		try {
			conn = DBConnection.getConn();
			pstm = conn.prepareStatement(sql);
			pstm.setString(1, s);
			rs = pstm.executeQuery();
			while (rs.next()) {
				// 차량 확인 car (carnum, cartype, carname, carstat, rentalfee, runfee, oilfee)
				result = new CarVO(rs.getString("carnum"),
						rs.getString("cartype"),
						rs.getString("carname"),
						rs.getString("carstat"),
						rs.getInt("rentalfee"),
						rs.getInt("runfee"),
						rs.getInt("oilfee")
						);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return result;
	}

	public ArrayList<String> rentList() {
		list = null;
		String sql = "SELECT * FROM rent";
		try {
			conn = DBConnection.getConn();
			pstm = conn.prepareStatement(sql);
			rs = pstm.executeQuery();
			while (rs.next()) {
				String temp = rs.getString("rcarnum");
				System.out.println(temp);
				list.add(temp);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return list;
	}

	public Vector<Vector<Object>> selectRent(String s) {
		Vector<Vector<Object>> list = new Vector<Vector<Object>>();
		// SELECT * FROM rent WHERE rcarnum = '11하1111';
		String sql = "SELECT * FROM rent WHERE rcarnum = ?";
		try {
			conn = DBConnection.getConn();
			pstm = conn.prepareStatement(sql);
			pstm.setString(1, s);
			rs = pstm.executeQuery();
			while (rs.next()) {
				Vector<Object> small = new Vector<Object>();
				// rentnum, rcarnum, rentdate, returndate, deposit, startkm, endkm, startamount, endamount, returned, fee
				small.add(rs.getInt("rentnum"));
				small.add(rs.getString("rcarnum"));
				small.add(rs.getString("rentdate"));
				small.add(rs.getString("returndate"));
				small.add(rs.getInt("deposit"));
				small.add(rs.getInt("startkm"));
				small.add(rs.getInt("endkm"));
				small.add(rs.getInt("startamount"));
				small.add(rs.getInt("endamount"));
				small.add(rs.getString("retured"));
				small.add(rs.getInt("fee"));
				list.add(small);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return list;
	}

	public Vector<Vector<Object>> selectRent() {
		Vector<Vector<Object>> list = new Vector<Vector<Object>>();
		// SELECT * FROM rent;
		String sql = "SELECT * FROM rent";
		try {
			conn = DBConnection.getConn();
			pstm = conn.prepareStatement(sql);
			rs = pstm.executeQuery();
			while (rs.next()) {
				Vector<Object> small = new Vector<Object>();
				// rentnum, rcarnum, rentdate, returndate, deposit, startkm, endkm, startamount, endamount, returned, fee
				small.add(rs.getInt("rentnum"));
				small.add(rs.getString("rcarnum"));
				small.add(rs.getString("rentdate"));
				small.add(rs.getString("returndate"));
				small.add(rs.getInt("deposit"));
				small.add(rs.getInt("startkm"));
				small.add(rs.getInt("endkm"));
				small.add(rs.getInt("startamount"));
				small.add(rs.getInt("endamount"));
				small.add(rs.getString("returned"));
				small.add(rs.getInt("fee"));
				list.add(small);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return list;
	}

	public Vector<Vector<Object>> selectReview() {
		Vector<Vector<Object>> list = new Vector<Vector<Object>>();
		// SELECT * FROM rent;
		String sql = "SELECT * FROM review";
		try {
			conn = DBConnection.getConn();
			pstm = conn.prepareStatement(sql);
			rs = pstm.executeQuery();
			while (rs.next()) {
				Vector<Object> small = new Vector<Object>();
				// postnum, title, author, posted
				small.add(rs.getInt("postnum"));
				small.add(rs.getString("title"));
				small.add(rs.getString("author"));
				small.add(rs.getString("posted"));
				list.add(small);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return list;
	}

	public ReviewVO selectReview(int i) {
		ReviewVO result = new ReviewVO();
		String sql = "SELECT * FROM review WHERE postnum = ?";
		try {
			conn = DBConnection.getConn();
			pstm = conn.prepareStatement(sql);
			pstm.setInt(1, i);
			rs = pstm.executeQuery();
			while (rs.next()) {
				result.setPostnum(rs.getInt("postnum"));
				result.setAuthor(rs.getString("author"));
				result.setPosted(rs.getString("posted"));
				result.setTitle(rs.getString("title"));
				result.setContent(rs.getString("content"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return result;
	}

	public ReviewVO updateReview(ReviewVO vo) {
		ReviewVO result = new ReviewVO();
		
		// UPDATE review SET title='수정된 게시물', content='내용수정' WHERE postnum = 0;
		String sql = "UPDATE review SET title = ?, content = ? WHERE postnum = ?";
		
		try {
			conn = DBConnection.getConn();
			pstm = conn.prepareStatement(sql);
			pstm.setString(1, vo.getTitle());
			pstm.setString(2, vo.getContent());
			pstm.setInt(3, vo.getPostnum());
			rs = pstm.executeQuery();
			while (rs.next()) {
				vo.setPostnum(rs.getInt("postnum"));
				vo.setAuthor(rs.getString("author"));
				vo.setPosted(rs.getString("posted"));
				vo.setTitle(rs.getString("title"));
				vo.setContent(rs.getString("content"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close();
		}
		
		return result;
	}

	public int deleteReview(int i) {
		int result = 0;
		
		// DELETE FROM review WHERE postnum = 1;
		String sql = "DELETE FROM review WHERE postnum = ?";
		
		try {
			conn = DBConnection.getConn();
			pstm = conn.prepareStatement(sql);
			pstm.setInt(1, i);
			result = pstm.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close();
		}
		
		return result;
	}
}
