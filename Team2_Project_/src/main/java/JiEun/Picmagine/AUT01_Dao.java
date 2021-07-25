package JiEun.Picmagine;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import JiEun.Picmagine.vo.*;

public class AUT01_Dao {
	
	public ArrayList<Artworks> artList = new ArrayList<Artworks>();
	public ArrayList<Writer> wrtList = new ArrayList<Writer>();
	public ArrayList<WriterIntro> wrtIntroList = new ArrayList<WriterIntro>();
	
	private Connection con;
	private PreparedStatement pstmt;
	private ResultSet rs;

	public AUT01_Dao() {
		super();
		// TODO Auto-generated constructor stub
		
		// 작가 신청시 필수요소 : (String wrtno, String wrtkorname, String memno) 
		wrtList.add(new Writer("w001", "허브맛쿠키", "m001"));
		wrtList.add(new Writer("w002", "퍼플", "m002"));
		wrtList.add(new Writer("w003", "알로하", "m003"));
		wrtList.add(new Writer("w004", "퐁실", "m004"));
		wrtList.add(new Writer("w005", "정원", "m005"));
		
		// 작가소개 : (String wrtno, String wrtactivity, String wrtsmallline, String wrtbigline, String wrtwebsite)
		wrtIntroList.add(new WriterIntro("w001", "자연", "여행을 좋아합니다. 언제든지 놀러오세요", null, null));
		wrtIntroList.add(new WriterIntro("w002", "배경화면", "많은 관심 부탁드립니다", "안녕하세요:D 퍼플입니다. 많은 관심 부탁드립니다", "naver.com/purple"));
		wrtIntroList.add(new WriterIntro("w003", "자연", null, null, null));
		wrtIntroList.add(new WriterIntro("w004", "배경화면", "귀여운 토끼 폼실", "따듯한걸 좋아해 불에 가까이 가다 수염이 타버린 토끼 폼실입니다 :)", null));
		wrtIntroList.add(new WriterIntro("w005", "배경화면", "사진으로 위로가 되었으면 합니다.", null, null));
		
		
		// 팔로우 : (String flwno, String wrtno, String memno)
		
		
	}
	
	public void setCon() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			String info = "jdbc:oracle:thin:@localhost:1521:xe";
			con = DriverManager.getConnection(info, "system", "1111");
			
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
	public Writer WriterInfo(String wrtno) {
		System.out.println(" [dao] 작가정보 호출 ");
		Writer writer = new Writer();
		
		try {
			setCon();

			String sql = "SELECT a.wrtno, a.wrtkorname, a.wrtengname, \r\n"
					+ "	a.wrtimgtitle, b.wrtactivity, b.wrtsmallline, b.wrtwebsite\r\n"
					+ "FROM AUT01_Writer a, AUT01_WriterIntro b \r\n"
					+ "WHERE a.wrtno = b.wrtno \r\n"
					+ "AND a.wrtno = ?";
			
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, wrtno);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				writer.setWrtno(rs.getString(1));
				writer.setWrtkorname(rs.getString(2));
				writer.setWrtengname(rs.getString(3));
				writer.setWrtimgtitle(rs.getString(4));
				writer.setWrtactivity(rs.getString(5));
				writer.setWrtsmallline(rs.getString(6));
				writer.setWrtwebsite(rs.getString(7));
				System.out.println(" [check] Writer Table 호출 성공 ");
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
	
	// 작가 팔로우/팔로잉 : 작가를 팔로우한 수, 작가가 팔로우한 수 -> 별개로 해야할지..?
	// 작가 테이블에 작가번호, 작가의 회원번호가 있음. 
	// 화면에 작가번호가 있다고 생각하고 넘겨주는데 회원번호는 없으니까 작가번호로 회원번호 데이터를 가져와서 ..??
	// 회원의 정보는 로그인했을시라고 생각하고 회원번호를 가지고 옴
	public boolean followCheck(String memno, String wrtno) {
		System.out.println(" [dao] 팔로우 여부 ");
		boolean isFollower = false;
		int follwingCnt = 0;

		try {
					
			setCon();
			
			// 팔로워 수 
			String sql1 = "SELECT count(*)\r\n"
					+ "FROM AUT01_Follow\r\n"
					+ "WHERE memno = ?\r\n"
					+ "AND wrtno = ?";
			
			pstmt = con.prepareStatement(sql1);
			pstmt.setString(1, memno);
			pstmt.setString(2, wrtno);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				isFollower = rs.getInt(1)==1?true:false;
				System.out.println(" [check] 팔로워 했는지 확인 : " + isFollower);
			}
			
			
			// 팔로잉 수 : 작가번호를 이용해서 멤버번호를 가져온다음 해당 작가가 팔로우한 수 체크
			String sql2 = "SELECT count(*)\r\n"
					+ "FROM AUT01_Follow a\r\n"
					+ "WHERE memno = (SELECT memno\r\n"
					+ "				FROM AUT01_WRITER\r\n"
					+ "				WHERE wrtno = ?)";
			
			pstmt = con.prepareStatement(sql2);
			pstmt.setString(1, wrtno);
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
		
		return isFollower;
	}
	
	// 작가의 작품리스트 출력
	public void WorkList(String wrtno) {
		
		try {
			setCon();
			
			String sql = "SELECT * \r\n"
					+ "FROM AUT01_Artworks\r\n"
					+ "WHERE wrtno = ?";
			
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, wrtno);
			rs = pstmt.executeQuery();

			
			while(rs.next()) {
				artList.add(new Artworks(
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
			
			for(Artworks a:artList) {
				a.workInfo();
			}
			
			System.out.println(" [check] 검색결과 수 : " + artList.size());
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
	}
	
	// 작가 시리즈 출력
	public void SeriesList() {
		
	}
}
