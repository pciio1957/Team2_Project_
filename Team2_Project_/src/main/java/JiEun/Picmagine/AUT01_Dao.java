package JiEun.Picmagine;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import JiEun.Picmagine.vo.*;

public class AUT01_Dao {
	
	public ArrayList<Works> workList = new ArrayList<Works>();
	public ArrayList<Works> seriesList = new ArrayList<Works>();
	
	public ArrayList<Artist> wrtList = new ArrayList<Artist>();
	public ArrayList<ArtistIntro> wrtIntroList = new ArrayList<ArtistIntro>();
	
	private Connection con;
	private PreparedStatement pstmt;
	private ResultSet rs;

	public AUT01_Dao() {
		super();
		// TODO Auto-generated constructor stub		
	}
	
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

	// 작가 정보 출력
	public Artist writerInfo(String artno) {
		System.out.println(" [dao] 작가정보 호출 ");
		Artist writer = new Artist();
		
		try {
			setCon();

			String sql = "SELECT a.artno, a.artkorname, a.artengname, \r\n"
					+ "	a.artimgtitle, b.artactivity, b.artsmallline, b.artwebsite\r\n"
					+ "FROM AUT01_Artist a, AUT01_ArtistIntro b \r\n"
					+ "WHERE a.artno = b.artno \r\n"
					+ "AND a.artno = ?";
			
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, artno);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				writer.setArtno(rs.getString(1));
				writer.setArtkorname(rs.getString(2));
				writer.setArtengname(rs.getString(3));
				writer.setArtimgtitle(rs.getString(4));
				writer.setArtactivity(rs.getString(5));
				writer.setArtsmallline(rs.getString(6));
				writer.setArtwebsite(rs.getString(7));
				System.out.println(" [check] Artist Table 호출 성공 ");
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

		return writer;
	}
	
	// 작가 팔로우 정보 출력
	// 작가번호를 이용해 작가의 팔로워/팔로잉 수 출력
	public void followCheck(String artno) {
		int follwingCnt = 0; 
		int follwerCnt = 0;
		
			try {
					setCon();
					
					// 팔로워 수 : 작가를 팔로우한 수
					String sql1 = "SELECT count(*)\r\n"
							+ "FROM AUT01_Follow \r\n"
							+ "WHERE artno = ?";
					
					pstmt = con.prepareStatement(sql1);
					pstmt.setString(1, artno);
					rs = pstmt.executeQuery();
					
					if(rs.next()) {
						follwerCnt = rs.getInt(1);
						System.out.println(" [check] 작가의 팔로워수 확인 : " + follwerCnt);
					}
		
					// 팔로잉 수 : 작가번호를 이용해서 멤버번호를 가져온다음 해당 작가가 팔로우한 수 체크
					String sql2 = "SELECT count(*)\r\n"
							+ "FROM AUT01_Follow a\r\n"
							+ "WHERE memno = (SELECT memno\r\n"
							+ "FROM AUT01_Artist\r\n"
							+ "WHERE artno = ?)";
						
						
					pstmt = con.prepareStatement(sql2);
					pstmt.setString(1, artno);
					rs = pstmt.executeQuery();
					
					if(rs.next()) {
						follwingCnt = rs.getInt(1);
						System.out.println(" [check] 작가의 팔로잉수 확인 : " + follwingCnt);
					}	
						
					
					rs.close(); pstmt.close(); con.close();
		
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
						System.out.println(" ! sql 에러 : " + e.getMessage());
					} catch (Exception e) {
						System.out.println(" ! 일반 에러 : " + e.getMessage());
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
	}
	
	// 작가 팔로우/팔로잉 : 작가를 팔로우한 수, 작가가 팔로우한 수 -> 별개로 해야할지..?
	// 작가 테이블에 작가번호, 작가의 회원번호가 있음. 
	// 화면에 작가번호가 있다고 생각하고 넘겨주는데 회원번호는 없으니까 작가번호로 회원번호 데이터를 가져와서 ..??
	// 회원의 정보는 로그인했을시라고 생각하고 회원번호를 가지고 옴
	public boolean followerCheck(String memno, String artno) {
		System.out.println(" [dao] 팔로우 여부 ");
		boolean isFollower = false; 

		try {
					
			setCon();
			
			// 팔로워 수 
			String sql1 = "SELECT count(*)\r\n"
					+ "FROM AUT01_Follow\r\n"
					+ "WHERE memno = ?\r\n"
					+ "AND artno = ?";
			
			pstmt = con.prepareStatement(sql1);
			pstmt.setString(1, memno);
			pstmt.setString(2, artno);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				isFollower = rs.getInt(1)==1?true:false;
				System.out.println(" [check] 팔로워 했는지 확인 : " + isFollower + "\n");
			}
			
			rs.close(); pstmt.close(); con.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println(" ! sql 에러 : " + e.getMessage());
		} catch (Exception e) {
			System.out.println(" ! 일반 에러 : " + e.getMessage());
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
		
		return isFollower;
	}
	

	
	public void followDown() {
		
	}
	
	public void followUp() {
		
	}
	
	// 작가의 작품리스트 출력
	public ArrayList<Works> workList(String artno) {
		
		try {
			setCon();
			
			String sql = "SELECT * \r\n"
					+ "FROM AUT01_Works\r\n"
					+ "WHERE artno = ?";
			
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, artno);
			rs = pstmt.executeQuery();

			
			while(rs.next()) {
				workList.add(new Works(
						rs.getString(1), 
						rs.getString(2), 
						rs.getString(3), 
						rs.getString(4), 
						rs.getString(5), 
						rs.getDate(6), 
						rs.getString(7), 
						rs.getString(8), 
						rs.getString(9)
				));
			}
			
			
			for(Works w:workList) {
				w.workInfo();
			}
			
			System.out.println(" [check] 검색결과 수 : " + workList.size());
			rs.close(); pstmt.close(); con.close();
			
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println(" ! sql 오류 : " + e.getMessage());
		} catch (Exception e) {
			System.out.println(" ! 일반 오류 : " + e.getMessage());
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
		
		return workList;
	}
	
	// 작가 시리즈(시리즈+작가정보) 출력
	public ArrayList<Works> seriesList(String artno) {
		try {
			setCon();
			
			String sql = "SELECT w.*, s.sercategory, s.sertitle, s.sercontent\r\n"
					+ "FROM AUT01_Works w, AUT01_Series s\r\n"
					+ "WHERE w.artno = ?\r\n"
					+ "AND w.serno = s.serno";
			
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, artno);
			rs = pstmt.executeQuery();

			
			while(rs.next()) {
				seriesList.add(new Works(
						rs.getString(1), 
						rs.getString(2), 
						rs.getString(3), 
						rs.getString(4), 
						rs.getString(5), 
						rs.getDate(6), 
						rs.getString(7), 
						rs.getString(8), 
						rs.getString(9),
						rs.getString(10),
						rs.getString(11),
						rs.getString(12)
				));
			}
			
			
			for(Works w:seriesList) {
				w.seriesInfo();
			}
			
			System.out.println(" [check] 검색결과 수 : " + seriesList.size());
			rs.close(); pstmt.close(); con.close();
			
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println(" ! sql 오류 : " + e.getMessage());
		} catch (Exception e) {
			System.out.println(" ! 일반 오류 : " + e.getMessage());
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
		
		return seriesList;
	}
}
