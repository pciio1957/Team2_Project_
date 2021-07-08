package JiEun.DB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;

import javaexp.z01_vo.Dept;
import javaexp.z01_vo.Emp;
import javaexp.z01_vo.Emp_Dept;

public class A04_DaoSch {
	private Connection con;
	private Statement stmt;
	private PreparedStatement pstmt;
	private ResultSet rs;
	
	// 공통기능 메소드(연결처리하는 기능메소드)
	public void setCon() throws SQLException {

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");	
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

		String info = "jdbc:oracle:thin:@localhost:1521:xe";
		con = DriverManager.getConnection(info, "scott", "tiger");
		System.out.println("접속 성공");
		
	}
	
	// 응용) A04_DaoSch.java 파일을 만들고 sql문 출력까지 작성 (1조)
	// 응용2) A04_DaoSch.java 파일에서 데이터 처리 및 main()에서 데이터 확인 (2조)
	public ArrayList<Emp_Dept> getEmpDpSch(Emp_Dept sch) {
		ArrayList<Emp_Dept> epdpList = new ArrayList<Emp_Dept>();
		
		try {
			setCon();
			
			String sql = "SELECT e.*, dname, loc \r\n"
					+ "FROM emp e, dept D \r\n"
					+ "WHERE e.deptno = d.deptno \r\n"
					+ "AND ename LIKE '%'||'" + sch.getEname() + "'||'%'\r\n"
					+ "AND dname LIKE '%'||'" + sch.getDname()+  "'||'%'";
			
			System.out.println("sql문 확인 \n" + sql);
			
			stmt = con.createStatement();
			rs = stmt.executeQuery(sql);
			
			while(rs.next()) {
				
				epdpList.add(new Emp_Dept(
						rs.getInt("empno"),
						rs.getString("ename"),
						rs.getString("job"),
						rs.getInt("mgr"),
						rs.getDate("hiredate"),
						rs.getDouble("sal"),
						rs.getDouble("comm"),
						rs.getInt("deptno"),
						rs.getString("dname"),
						rs.getString("loc")
				));
				
			}
			
			
			System.out.println("검색 건수 : " + epdpList.size());
			rs.close(); stmt.close(); con.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println(e.getMessage());
		} catch (Exception e) {
			System.out.println(e.getMessage());
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
		

		return epdpList;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		A04_DaoSch dao = new A04_DaoSch();
		ArrayList<Emp_Dept> epdpList = dao.getEmpDpSch(new Emp_Dept("A", "A"));
		
		for(Emp_Dept ed:epdpList) {
			System.out.print(ed.getEmpno() + "\t");
			System.out.print(ed.getEname() + "\t");
			System.out.print(ed.getJob() + "\t");
			System.out.print(ed.getMgr() + "\t");
			System.out.print(ed.getHiredate() + "\t");
			System.out.print(ed.getSal() + "\t");
			System.out.print(ed.getComm() + "\t");
			System.out.print(ed.getDeptno() + "\t");
			System.out.print(ed.getDname() + "\t");
			System.out.print(ed.getLoc() + "\n");	
		}
	}
}
