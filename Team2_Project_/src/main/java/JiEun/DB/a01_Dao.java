package JiEun.DB;

import java.sql.*;
import java.util.ArrayList;

import javaexp.z01_vo.Emp;

public class a01_Dao {
	
	private Connection con;
	private Statement stmt;
	private PreparedStatement pstmt;
	private ResultSet rs;
	
	// 공통기능 메소드(연결처리하는 기능메소드)
	public void setCon() throws SQLException {
		// 1. 드라이버 메모리 로딩
		try {
			// 필수예외처리 
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		// 2. 특정 서버 접속
		// 		1) 서버 정보
		String info = "jdbc:oracle:thin:@localhost:1521:xe";
		// 이 부분에서 예외처리는 위임처리 해서 throws SQLException 해줌 
		con = DriverManager.getConnection(info, "scott", "tiger");
		
		System.out.println("접속 성공");
		
	}

		/*
		 
		 #emp 테이블 조회 -> ArrayList<Emp>에 담는 것까지 처리하기
		 기능메소드 선언 순서
		 	1) 최종 결과값에 대한 확인 -> 객체를 return 처리
		 	 	=> 이때 리턴 유형과 실제 리턴할 객체를 확인해야함
		 	2) 최종 결과를 위해 입력할 데이터 확인 -> VO객체로 만들고 입력데이터를 변수로 선언 
		 	3) 생성한 VO객체를 이용해 ArrayList에 입력데이터 삽입 

	
		*/
		
		// 기본 select문 가져오기
	public ArrayList<Emp> getEmpList() {
		ArrayList<Emp> emplist = new ArrayList<Emp>();
		
		// 1. 연결 공통메소드 호출 - Connection 객체 생성됨
		try {
			setCon();
			
			
			// 2. sql 문자열로 할당한 다음
			String sql = "select * from emp02";
		
			// 3. statement 객체를 생성하고
			//		1) setCon()을 통해서 만들어지는 Connection 객체의 
			//		기능 메소드를 통해서 Statement 객체 생성
			stmt = con.createStatement();
					
			// 4. ResultSet 객체를 생성한다
			//		1) Statement가 지원하는 기능메소드인 executeQuery에
			//			매개변수로 sql을 입력 (sql문 처리)
			//		2) 그 수행 결과를 담기위한 ResultSet 객체에 할당한다.
			rs = stmt.executeQuery(sql);
			
			//		3) ResultSet의 next()메소드를 이용해서 데이터가 
			//			더이상 없을때까지 반복해서 데이터를 가져온다. 
			//			행단위로 데이터를 가져옴. 다음 행의 데이터 유무를 true/false로 리턴
			//		4) ResultSet의 getXXX("컬럼명")
			//			모든 컬럼의 데이터유형(XXX)에 따라 데이터를 가져올 수 있다
			//			정수형일 경우 getInt(), 실수형 getDouble(), 문자열 getString()
			//			어떤 유형이든 상관없이 getString()은 다 지원됨 
			//			getString("컬럼명") : next()로 이동한 행의 해당 컬럼의 데이터를 가져온다
			//System.out.println(rs.next()); 
			//System.out.println(rs.getString("ename")); 
			
			
			// 응용1) 3번째 행의 부서번호와 5번째 행의 입사일, 8번쨰 행의 급여 출력하기 
//			for(int idx=0;idx<8;idx++) {
//
//				rs.next();
//				
//				if(idx==2) {
//					System.out.println(rs.getString("deptno")); 
//				} else if(idx==4) {
//					System.out.println(rs.getString("hiredate")); 
//				} else if(idx==7) {
//					System.out.println(rs.getString("sal")); 
//				}
//			}
			
			// 응용2) 1번째 행의 사원번호 3번째행의 급여, 5번째 행의 관리자번호 출력하기 (2,3조)
			
//			int idx = 0;
//			while(rs.next()) {
//				if(idx == 0) {
//					System.out.println(rs.getString("empno")); 
//				} else if(idx == 2) {
//					System.out.println(rs.getString("sal")); 
//				} else if(idx == 4) {
//					System.out.println(rs.getString("mgr")); 
//				}
//				idx++;
//			}
			
			
			// 응용3) 부서번호, 사원번호, 사원명을 데이터 유형에 맞게 출력하기 (4, 5조)
			// 컬럼명을 지정해서 데이터를 불러온다 
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
			
			// re.getInt(1) : 출력하는 컬럼을 1부터 시작하는 인덱스순서로
			//			컬럼명 대신 사용해서 데이터를 가져올 수 있다. 
			
		// 5. 사용이 끝나면 자원을 해제하고 : 생성된 역순으로 해제한다 
		rs.close(); 
		stmt.close();
		con.close();
		// 6. 예외처리를 통한 기타 예외 처리 하기 
			
		
		// 응용 4번 아래에 작성함
		
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
		
		
		return emplist;	
	}
	
	
	// 응용1) 조회문 select * from dept를 하기 위한 A02_DeptDao.java를 만들고
	//		공통 연결메소드와 기능메소드(부서정보조회)틀을 만들기 (1조)
		
	
	/*  응용4) 아래 sql문을 사용한 예제 만들기 
	SELECT deptno, empno, ename, job, sal
	FROM emp02
	WHERE deptno=10; 를 처리하는 기능메소드 추가하기  */
	// 조건을 입력받아서 데이터 처리함 
	public String select01(int deptno) {
		
		try {
			// 1. 연결 처리 
			setCon();
			
			// 이때 문자열을 조건처리할 경우 ' ' 사용해줘야함 
			// DB에서 sql문에서 문자열은 ' ' 표시하므로 작성해줘야함 
			String sql = "select deptno, empno, ename, job, sal "
					+ "from emp02 where deptno = " + deptno;
			
			stmt = con.createStatement();
			rs = stmt.executeQuery(sql);
			
			System.out.println("부서번호\t사원번호\t사원명\t직급\t월급");
			while(rs.next()) {
				System.out.print(rs.getInt(1) + "\t");
				System.out.print(rs.getInt(2) + "\t");
				System.out.print(rs.getString(3) + "\t");
				System.out.print(rs.getString(4) + "\t");
				System.out.print(rs.getDouble(5) + "\n");
			}
			
			
			// 다 끝났으면 연결해제
			rs.close(); 
			stmt.close();
			con.close();
			
			
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
			
			if(stmt != null) {
				try {
					rs.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
			if(con != null) {
				try {
					rs.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		
		
		return "";
	}
	
	// 단일 객체 처리 : 리턴값을 단일 객체로 변경
	public Emp getEmp(int empno) {
		Emp emp = null;

		try {
			setCon();	
			String sql = "SELECT *\r\n"
					+ "FROM emp02\r\n"
					+ "WHERE empno = " + empno;
		
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
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		// 해당 DAO 객체를 생성함 
		a01_Dao dao = new a01_Dao();
			
		
		try {
			
			// dao 객체의 setCon() 메소드 호출
			dao.setCon();
			dao.getEmpList(); //- 조회
			//dao.select01(10); // - 검색
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		// 데이터 없음 
		Emp e = dao.getEmp(0);
		if(e != null) {
			System.out.println("Empno로 0 검색결과");
			System.out.print(e.getEmpno() + "\t");
			System.out.print(e.getEname() + "\t");
			System.out.print(e.getJob() + "\n");
		} else {
			System.out.println("데이터가 없습니다");
		}
		
		Emp e2 = dao.getEmp(7369);
		if(e2 != null) {
			System.out.println("Empno로 7369 검색결과");
			System.out.print(e2.getEmpno() + "\t");
			System.out.print(e2.getEname() + "\t");
			System.out.print(e2.getJob() + "\n");
		} else {
			System.out.println("데이터가 없습니다");
		}
		
		
		// 응용) A02_DeptDao.java에 부서번호를 통해서 검색되게 기능메소드를 구현하기 (3조)		
		/*
		
		#java를 통해 데이터베이스 처리 		 	
		1. DAO(database access object)에서 하는일
			1) 생각해봐야할 것 
				[1] 소켓통신을 통한 여러가지 모듈이 필요함 -> jdbc드라이버 설치
					해당 드라이버는 각 DB 서버 회사에서 지원하는 jar을 받는다.
					오라클의 경우 web-inf 폴더의 lib안에 ojdbc6.jar를 말함 
				[2] *DB 연결을 위해서 필요한 정보는 무엇? 
						-> ip, port번호, sid, 계정, 비밀번호 등
				[3] DB의 처리 순서는? 
					- 우선 DB서버가 있어야 하고
					- driver를 메모리에 로딩해야 한다
					- DB를 연결해야하는 정보를 통해서 연결 
						연결할 때에는 명령어를 통해서 서버에 요청한다 (Statement) 
							->  sql과 statement 객체가 필요함
					- select(sql) : 서버에서 해당 명령의 결과를 전달해줌
							-> 전달한 내용을 받는 객체가 필요한데 이때 사용하는게 ResultSet 
							-> ArrayList<VO>로 받아준다
					- insert, update, delete(dml) : 요청정보를 DB서버내에서 처리한다.
							-> 트랜잭션 처리와 함께 명령어인 commit과 rollback을 처리한다. 
					이후 사용이 끝나면 자원을 해제한다.
					기타 DB처리를 할 때에는 예외처리를 반드시 해줘야한다.
						try {} catch(SQLException e) {}
			2) DAO의 역할
				[1] 데이터베이스 서버 연결
				[2] 메소드를 통해서 입력받은 데이터인 VO를 통해서 
					조회하거나 등록, 수정, 삭제를 처리한다
				[3] 자원 해제처리 
				
				
			3) DAO의 전역변수 (DAO의 공통적인 전역변수로 DB연결을 위함)
				[1] 데이터베이스 연결을 처리하는 객체 
					private Connection con;
				[2] 서버와 대화를 하는 객체 (2가지 형태)
					private Statement stmt; 
				[3] 결과값을 받는 객체 
		
		
		*/
	}
	

}
