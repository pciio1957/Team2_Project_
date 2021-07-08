package JiEun.DB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javaexp.z01_vo.Emp;

public class A03_DaoSch {
	
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
	
	

	/*
	
	#작성해야하는 것
	1. sql문 작성 : VO
	2. 메소드 선언 : 리턴데이터, 입력데이터에 맞는 객체 선언
	3. 공통연결메소드 호출 및 기본예외처리
	4. 대화객체
	5. 결과객체
	6. while을 통한 ArrayList할당
	7. 자원해제
	8. main()을 통한 test

	*/
	
	public ArrayList<Emp> empSch(Emp sch) {
		ArrayList<Emp> emplist = new ArrayList<Emp>();
		
		try {
			setCon();
			
			String sql = "SELECT *\r\n"
					+ "FROM emp01 \r\n"
					+ "WHERE ename LIKE '%'||'" + sch.getEname() + "'||'%'\r\n"
					+ "AND job LIKE '%'||'" + sch.getJob() + "'||'%'";
			
			System.out.println(" sql 확인 : " + sql);
 			
			stmt = con.createStatement();
			rs = stmt.executeQuery(sql);
			
			while(rs.next()) {
				emplist.add(new Emp(
						rs.getInt("empno"),
						rs.getString("ename"),
						rs.getString("job"),
						rs.getInt("mgr"),
						rs.getDate("hiredate"),
						rs.getDouble("sal"),
						rs.getDouble("comm"),
						rs.getInt("deptno")
				));
			}
			
			System.out.println("검색 건수 : " + emplist.size());
			rs.close(); stmt.close(); con.close();
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("sql 예외 : " + e.getMessage());
		} catch (Exception e) {
			System.out.println("일반 예외 : " + e.getMessage());
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
		
		return emplist;
	}
	
	// 

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		A03_DaoSch dao = new A03_DaoSch();
		// " " 안에 데이터를 넣으면 검색이고 "" 비워서 하면 전체조회
		ArrayList<Emp> elist = dao.empSch(new Emp("A", "A"));
		
		
		for(Emp e:elist) {
			System.out.print(e.getEmpno() + "\t");
			System.out.print(e.getEname() + "\t");
			System.out.print(e.getJob() + "\n");
		}
		
		// 응용1) A04_DaoSch.java 파일을 만들고 sql문 출력까지 작성 (1조)
		
		// 응용2) A04_DaoSch.java 파일에서 데이터 처리 및 main()에서 데이터 확인 (2조)
	}

}
