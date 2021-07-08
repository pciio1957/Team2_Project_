package JiEun.DB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

// java.sql.* : sql하위에 있는DB연결할때 사용하는 패키지를 모두 자동 import 처리 

import javaexp.z01_vo.Dept;
import javaexp.z01_vo.Emp;

public class A02_DeptDao {
	
	private Connection con;
	private Statement stmt;
	private PreparedStatement pstmt;
	private ResultSet rs;
	
	public void setConnection() {
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			String url = "jdbc:oracle:thin:@localhost:1521:xe";
			// 이 부분에서 예외처리는 위임처리 해서 throws SQLException 해줌 
			con = DriverManager.getConnection(url, "scott", "tiger");
			
			System.out.println(" dept 접속 성공");
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	// 응용) A02_DeptDao.java에 부서번호를 통해서 검색되게 기능메소드를 구현하기 (3조)		
	public ArrayList<Dept> getDetpList(int deptno) {
		ArrayList<Dept> deptList = new ArrayList<Dept>();	
		
		try {
			
			setConnection();
			
			String sql = "SELECT * \r\n"
				+ "FROM dept \r\n"
				+ "WHERE deptno = " + deptno;
			
			stmt = con.createStatement();
			rs = stmt.executeQuery(sql);
			
			while(rs.next()) {
				deptList.add(new Dept(
						rs.getInt("deptno"),
						rs.getString("dname"),
						rs.getString("loc")		
				));
			}
			
			System.out.println("sql 검색 결과 : " + deptList.size());
			
			
			rs.close(); stmt.close(); con.close();
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("sql 오류 : " + e.getMessage());
		} catch (Exception e) {
			System.out.println("일반 오류 : " + e.getMessage());
		} finally {
			
			if(rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
			if(stmt != null) {
				try {
					stmt.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
			if(con != null) {
				try {
					con.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		return deptList;
	}
	
	public ArrayList<Dept> getDetpList() {
		ArrayList<Dept> deptList = new ArrayList<Dept>();	
		
		try {
			
			setConnection();
			
			String sql = "SELECT * \r\n"
				+ "FROM dept \r\n";
			
			stmt = con.createStatement();
			rs = stmt.executeQuery(sql);
			
			while(rs.next()) {
				deptList.add(new Dept(
						rs.getInt("deptno"),
						rs.getString("dname"),
						rs.getString("loc")		
				));
			}
			
			System.out.println("sql 검색 결과 : " + deptList.size());
			
			
			rs.close(); stmt.close(); con.close();
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("sql 오류 : " + e.getMessage());
		} catch (Exception e) {
			System.out.println("일반 오류 : " + e.getMessage());
		} finally {
			
			if(rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
			if(stmt != null) {
				try {
					stmt.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
			if(con != null) {
				try {
					con.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		return deptList;
	}
	
	
	
	// 데이터 입력을 위한 메소드
	public void insertDept(Dept dp) {
		
		try {
			setConnection();
			
			// 자동으로 커밋되서 잘못된 데이터를 넣지않도록 하기위해 방지
			con.setAutoCommit(false);
			
			String sql = "INSERT INTO dept02 values(?, ?, ?)";
	
			System.out.println(" - sql 확인 : " + sql);
			
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, dp.getDeptno());
			pstmt.setString(2, dp.getDname());
			pstmt.setString(3, dp.getLoc());
			pstmt.executeUpdate();

			// 제대로 진행되었다면 commit 진행
			con.commit();
			
			pstmt.close(); con.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("SQL 예외 발생 " + e.getMessage());
			
			try {
				con.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
		} catch (Exception e) {
			System.out.println("일반 예외 발생 : " + e.getMessage());
		} finally {

			if(pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
			if(con != null) {
				try {
					con.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		A02_DeptDao dao = new A02_DeptDao();
		ArrayList<Dept> dp = new ArrayList<Dept>();
		dp = dao.getDetpList(10);
		
		if(dp != null) {
			for(Dept d:dp) {
				System.out.println(" Deptno : " + d.getDeptno());
				System.out.println(" Dname : " + d.getDname());
				System.out.println(" Loc : " + d.getLoc());	
			}
		}
		
		dao.insertDept(new Dept(12, "총무", "강남"));
		
		for(Dept d:dao.getDetpList()) {
			System.out.println(" Deptno : " + d.getDeptno());
			System.out.println(" Dname : " + d.getDname());
			System.out.println(" Loc : " + d.getLoc());	
		}
	}
}
