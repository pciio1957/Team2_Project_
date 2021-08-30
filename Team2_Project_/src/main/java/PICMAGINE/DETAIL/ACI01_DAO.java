package PICMAGINE.DETAIL;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import JiEun.Picmagine.vo.Artist;
import JiEun.Picmagine.vo.Member;

public class ACI01_DAO {
	
	private Connection con;
	private PreparedStatement pstmt;
	private ResultSet rs;
	
	
	public void setCon() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			String info = "jdbc:oracle:thin:@localhost:1521:xe";
			con = DriverManager.getConnection(info, "scott", "tiger");
			
			System.out.println(" [dao] DB 접속 성공 \n");
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println(" ! 클래스 인식오류 : " + e.getMessage());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println(" ! sql 오류 : " + e.getMessage());
		}
		
	}
	
	public Member getMemInfo(String memno) {		
		System.out.println(" [dao] 회원정보 호출 ");
		Member member = new Member();
		
		try {
			setCon();

			String sql = "SELECT * \r\n"
					+ "FROM ACI01_Member \r\n"
					+ "WHERE memno = ? \r\n"
					+ "AND memauth = 1";
			
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, memno);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				member.setMemno(rs.getString(1));
				member.setMemid(rs.getString(2));
				member.setMempw(rs.getString(3));
				member.setMemtel(rs.getString(4));
				member.setMememail(rs.getString(5));
				member.setMemauth(rs.getString(6));
				System.out.println(" [check] Member Table 호출 성공 ");
			}
			
			rs.close(); pstmt.close(); con.close();
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println(" ! sql 오류 : " + e.getMessage());
		} catch	(Exception e) {
			System.out.println(" ! 오류 : " + e.getMessage());
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
		return member;
	}

	
	// 작가 Table : 작가번호, 작가명, 작가영어이름, 작가대표이미지, 작가URL, 작가외부이메일, 회원번호
	// 회원번호를 이용해서 작가테이블에 데이터 삽입 (필수입력: 작가명)
	public boolean setArtist(Member mem, Artist atis) {
		String memno = "";
		boolean isDone = false;
		
			
			try {
				setCon();
				
				String sql1 = "SELECT memno\r\n"
						+ "FROM ACI01_Member \r\n"
						+ "WHERE memid = ? \r\n"
						+ "AND mempw = ?";
				
				pstmt = con.prepareStatement(sql1);
				pstmt.setString(1, mem.getMemid());
				pstmt.setString(2, mem.getMempw());
				rs = pstmt.executeQuery();
				
				if(rs.next()) {
					memno = rs.getString(1);
				}
				
				
				con.setAutoCommit(false);
				String sql2 = "INSERT INTO ACI01_Artist values"
						+ "('at'||ACI01_art_seq.nextval, ?, ?, ?, ?, ?, ?)";

				pstmt = con.prepareStatement(sql2);
				pstmt.setString(1, atis.getArtkorname());
				pstmt.setString(2, atis.getArtengname());
				pstmt.setString(3, atis.getArtimgtitle());
				pstmt.setString(4, atis.getArtengname());
				pstmt.setString(5, atis.getArtoutemail());
				pstmt.setString(6, memno);
				System.out.println(" [check] Artist Table 입력 성공 ");

				pstmt.executeUpdate();
				con.commit();
				isDone = true;
				
				pstmt.close(); con.close();
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				System.out.println("SQL 예외 발생~~"+e.getMessage());
				try {
					con.rollback();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			} catch(Exception e) {
				System.out.println("일반예외 발생:"+e.getMessage());
			}finally {
				if(rs!=null) {
					try {
						rs.close();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
		
				if(pstmt!=null) {
					try {
						pstmt.close();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}			
				if(con!=null) {
					try {
						con.close();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}	
				
			}

		return isDone;
	}
	
	public boolean login(String id, String pw){
		boolean hasMember = false;
		try {
			setCon();
			String sql = "select * from ACI01_Member \r\n"
					+ "where memid = ? and mempw = ?";
			
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, id);
			pstmt.setString(2, pw);
			rs = pstmt.executeQuery();
			
			hasMember = rs.next();
			
			System.out.println("로그인 아이디 : " + id);
			System.out.println("로그인 비번 : " + pw);
			System.out.println("로그인 결과 : " + hasMember);
			
			rs.close(); pstmt.close(); con.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("SQL 예외 발생~~"+e.getMessage());
		} catch(Exception e) {
			System.out.println("일반예외 발생:"+e.getMessage());
		}finally {
			if(rs!=null) {
				try {
					rs.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
	
			if(pstmt!=null) {
				try {
					pstmt.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}			
			if(con!=null) {
				try {
					con.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}	
			
		}
		return hasMember;
	}
	

}
