package JiEun.DB;

import java.sql.*;
import java.util.ArrayList;

import javaexp.z01_vo.Emp;

public class a05_PreparedDao {
	private Connection con;
	private Statement stmt;
	private PreparedStatement pstmt;
	private ResultSet rs;

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

	public ArrayList<Emp> getEmpList() {
		ArrayList<Emp> emplist = new ArrayList<Emp>();
		
		try {
			setCon();

			String sql = "select * from emp02";
			stmt = con.createStatement();
			rs = stmt.executeQuery(sql);

			int rowCount = 0;
			
			System.out.println("사원번호\t사원명\t직급\t관리자번호\t입사일\t월급\t보너스\t부서번호");
			while(rs.next()) {
				System.out.print(rowCount++ + "\t");
				System.out.print(rs.getInt("empno") + "\t");
				System.out.print(rs.getString("ename") + "\t");
				System.out.print(rs.getString("job") + "\t");
				System.out.print(rs.getInt("mgr") + "\t");
				System.out.print(rs.getDate("hiredate") + "\t");
				System.out.print(rs.getDouble("sal") + "\t");
				System.out.print(rs.getDouble("comm") + "\t");
				System.out.print(rs.getInt("deptno") + "\n");
			
				emplist.add(new Emp(rs.getInt("empno"), 
						rs.getString("ename"),
						rs.getString("job"),
						rs.getInt("mgr"),
						rs.getDate("hiredate"),
						rs.getDouble("sal"),
						rs.getDouble("comm"),
						rs.getInt("deptno")
				));
			
			}
			
		System.out.println("ArrayList의 데이터갯수 : " + emplist.size());

		rs.close(); stmt.close(); con.close();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		return emplist;	
	}
		
	// 단일 객체 처리 : 리턴값을 단일 객체로 변경
	public Emp getEmp(int empno) {
		Emp emp = null;

		try {
			setCon();	
			String sql = "SELECT *\r\n"
					+ "FROM emp02\r\n"
					+ "WHERE empno = " + empno + "\r\n"
					+ "ORDER BY empno desc";
			stmt = con.createStatement();
			rs = stmt.executeQuery(sql);
			
			System.out.println("사원번호\t사원명\t직급\t관리자번호\t입사일\t월급\t보너스\t부서번호");

			if(rs.next()) {
				emp = new Emp (
						rs.getInt("empno"),
						rs.getString("ename"),
						rs.getString("job"),
						rs.getInt("mgr"),
						rs.getDate("hiredate"),
						rs.getDouble("sal"),
						rs.getDouble("comm"),
						rs.getInt("deptno")	
				);

				System.out.print(rs.getInt("empno") + "\t");
				System.out.print(rs.getString("ename") + "\t");
				System.out.print(rs.getString("job") + "\t");
				System.out.print(rs.getInt("mgr") + "\t");
				System.out.print(rs.getDate("hiredate") + "\t");
				System.out.print(rs.getDouble("sal") + "\t");
				System.out.print(rs.getDouble("comm") + "\t");
				System.out.print(rs.getInt("deptno") + "\n");
			}
			
			rs.close(); stmt.close(); con.close();
	
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
			return emp;	
	}
	
	// 다중 객체 처리 : 리턴값을 리스트로 처리, 보안을 위해 PreparedStatement() 처리
	public ArrayList<Emp> select01(int deptno) {
		ArrayList<Emp> list = new ArrayList<Emp>();
		
		try {
			setCon();
			
			String sql = "select deptno, empno, ename, job, sal "
					+ "from emp02 where deptno = ?";
			
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, deptno);
			rs = pstmt.executeQuery();
			
			System.out.println("부서번호\t사원번호\t사원명\t직급\t월급");
			while(rs.next()) {
				System.out.print(rs.getInt(1) + "\t");
				System.out.print(rs.getInt(2) + "\t");
				System.out.print(rs.getString(3) + "\t");
				System.out.print(rs.getString(4) + "\t");
				System.out.print(rs.getDouble(5) + "\n");
			}

			rs.close(); pstmt.close();con.close();
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("SQL 예외 발생 " + e.getMessage());
		} catch (Exception e) {
			System.out.println("일반 예외 발생 : " + e.getMessage());
		} finally {
			
			if(rs != null) {
				try {
					rs.close();
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
		return list;
	}
	
	// 응용) A05_PreparedDao.java에서 기능메소드 추가하여
	// PreparedStatement를 활용하여 위 sql을 처리하기 (4,5조)
	public ArrayList<Emp> getEnameJobSch(String ename, String job) {
		ArrayList<Emp> ejlist = new ArrayList<Emp>();
		
		try {
			setCon();
			
			String sql = "SELECT *\r\n"
					+ "	FROM emp01\r\n"
					+ "	WHERE ename LIKE '%'||?||'%'\r\n"
					+ "	AND job LIKE '%'||?||'%'";
			
			System.out.println(" - sql 확인 : " + sql);
			
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, ename);
			pstmt.setString(2, job);
			rs = pstmt.executeQuery();
			
			System.out.println(" * prepared 다중 객체 결과 ");
			while(rs.next()) {
				ejlist.add(new Emp(
						rs.getInt("empno"),
						rs.getString("ename"),
						rs.getString("job"),
						rs.getInt("mgr"),
						rs.getDate("hiredate"),
						rs.getDouble("sal"),
						rs.getDouble("comm"),
						rs.getInt("deptno")		
				));
				
				System.out.print(rs.getInt(1) + "\t");
				System.out.print(rs.getString(2) + "\t");
				System.out.print(rs.getString(3) + "\t");
				System.out.print(rs.getString(4) + "\t");
				System.out.print(rs.getString(5) + "\n");
			}
			
			
			rs.close(); pstmt.close(); con.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("SQL 예외 발생 " + e.getMessage());
		} catch (Exception e) {
			System.out.println("일반 예외 발생 : " + e.getMessage());
		} finally {
			
			if(rs != null) {
				try {
					rs.close();
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
		
		
		return ejlist;
	}
	
	// 데이터 입력을 위한 메소드
	public void insertEmp(Emp em) {
		
		try {
			setCon();
			
			// 자동으로 커밋되서 잘못된 데이터를 넣지않도록 하기위해 방지
			con.setAutoCommit(false);
			
			String sql = "INSERT INTO emp02 values(emp_seq_01.nextval,?, ?, ?, sysdate, ?, ?, ?)";
	
			System.out.println(" - sql 확인 : " + sql);
			
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, em.getEname());
			pstmt.setString(2, em.getJob());
			pstmt.setInt(3, em.getMgr());
			pstmt.setDouble(4, em.getSal());
			pstmt.setDouble(5, em.getComm());
			pstmt.setInt(6, em.getDeptno());
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
		
		a05_PreparedDao dao = new a05_PreparedDao();
		ArrayList<Emp> emplist = new ArrayList<Emp>();
			
		try {
			
			dao.setCon();
			dao.getEmpList(); 
			dao.select01(30); 
			dao.getEnameJobSch("A", "A");
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		dao.insertEmp(new Emp(0, "마길동", "대리", 7780, null, 4000, 1000, 10));
		
		
		// 결과 조회용 
		emplist = dao.getEnameJobSch("", "");
		
		for(Emp e:emplist) {
			System.out.println(e.getDeptno());
			System.out.println(e.getEname());
			System.out.println(e.getJob());
		}


	}
}
