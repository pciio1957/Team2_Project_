package PICMAGINE.MEMBER;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.sql.DataSource;


public class MemberManager {
	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs;
	private DataSource ds;

	// 데이터베이스 연결
	public MemberManager() throws SQLException {

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} 
		String sql = "jdbc:oracle:thin:@localhost:1521:xe";
		conn = DriverManager.getConnection(sql, "scott", "tiger");
		System.out.println("접속성공!!");
	}

	// 아이디 체크
	public boolean checkId(String id){

		boolean b = false;

		try {

			String sql = "select id from webshop_member where id like ?";

			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			b=rs.next();

		} catch (Exception e) {

			System.out.println("checkId err : " + e);

		} finally {

			try {

				if(rs!=null)rs.close();
				if(pstmt!=null)pstmt.close();
				if(conn!=null)conn.close();
		} catch (Exception e2) {

				// TODO: handle exception

			}

		}

		return b;

	}
	//회원가입

		public boolean insertData(MemberBean bean){

			boolean b = false;

			try {

				String sql = "insert into webshop_member values(?,?,?,?,?)";

				conn = ds.getConnection();

				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, bean.getId());
				pstmt.setString(2, bean.getName());
				pstmt.setString(3, bean.getPass());
				pstmt.setString(4, bean.getPhone());				
				pstmt.setString(5, bean.getMail());

				if(pstmt.executeUpdate()>0)b=true;

				

			} catch (Exception e) {

				System.out.println("insertData err : " + e);

			} finally {

				try {

					if(rs!=null)rs.close();
					if(pstmt!=null)pstmt.close();
					if(conn!=null)conn.close();
				} catch (Exception e2) {

					// TODO: handle exception

				}

			}

			return b;

		}

		//로그인용 데이터 탐색

		public String login(String id, String pass){

			String str="";

			try {

				String sql = "select id, name from webshop_member where id=? and pass=?";
				// 왜 돌아가??????????????????????

				
				//conn = ds.getConnection();
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, id);
				pstmt.setString(2, pass); 
				rs = pstmt.executeQuery();

				if(rs.next()) str=rs.getString("name");



			} catch (Exception e) {

				System.out.println("login err : " + e);

			} finally {

				try {

					if(rs!=null)rs.close();
					if(pstmt!=null)pstmt.close();
					if(conn!=null)conn.close();
				} catch (Exception e2) {

					// TODO: handle exception

				}
			}
			return str;

		}
	
		
		// 회왼정보 수정 데이터 보내기

	public MemberDto getData(String id) {

		MemberDto dto = null;

		try {

			String sql = "select id, pass, phone, email from member01 where id=?";

			//conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			if (rs.next()) {

				dto = new MemberDto();
				dto.setId(rs.getString("id"));
				dto.setPass(rs.getString("pass"));
				dto.setName(rs.getString("phone"));
				dto.setMail(rs.getString("email"));

			}
			System.out.println("dto:"+dto.getName());

		} catch (Exception e) {

			System.out.println("getData err : " + e);

		} finally {

			try {

				if (rs != null)
					rs.close();

				if (pstmt != null)
					pstmt.close();

				if (conn != null)
					conn.close();

			} catch (Exception e2) {

				// TODO: handle exception

			}

		}

		return dto;

	}

	// 데이터 수정 
	public boolean modifyData(MemberBean bean) {

		boolean b = false;

		try {

			String sql = "update member01 set pass=?, phone=?, email=? where id=?";
 
			//conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, bean.getPass());
			pstmt.setString(2, bean.getPhone());			
			pstmt.setString(3, bean.getMail());
			pstmt.setString(4, bean.getId());

			if (pstmt.executeUpdate() > 0)
				b = true;

		} catch (Exception e) {

			System.out.println("modifyData err : " + e);

		} finally {

			try {

				if (rs != null)
					rs.close();

				if (pstmt != null)
					pstmt.close();

				if (conn != null)
					conn.close();

			} catch (Exception e2) {

				// TODO: handle exception

			}

		}

		return b;

	}

	
	//회원 탈퇴 - 비밀번호 확인

	public boolean deleteConfirm(String id, String passwd) {

		boolean b = false;

		try {

			String sql = "select * from webshop_member where id = ? and pass = ?";
			// 오라클로 수정
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			pstmt.setString(2, passwd);
			rs = pstmt.executeQuery();

			if (rs.next())
				b = true;

		} catch (Exception e) {

			System.out.println("deleteConfirm err : " + e);

		} finally {

			try {

				if (rs != null)
					rs.close();

				if (pstmt != null)
					pstmt.close();

				if (conn != null)
					conn.close();

			} catch (Exception e2) {

				// TODO: handle exception

			}

		}

		return b;

	}

//회원 탈퇴 - 탈퇴하기

	public boolean deleteData(String id){

		boolean b = false;

		try {

			String sql = "delete from webshop_member where id = ?";
			
			conn = ds.getConnection();

			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, id);

			int re = pstmt.executeUpdate();

			if(re>0) b = true;

			

		} catch (Exception e) {

			System.out.println("deleteData err : " + e);

		} finally {

			try {

				if(rs!=null)rs.close();

				if(pstmt!=null)pstmt.close();

				if(conn!=null)conn.close();

			} catch (Exception e2) {

				// TODO: handle exception

			}

		}

		return b;

	}
}