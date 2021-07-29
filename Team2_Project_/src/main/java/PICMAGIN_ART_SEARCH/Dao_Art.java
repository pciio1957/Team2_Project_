package PICMAGIN_ART_SEARCH;

// jspexp.z01_database.A05_PreparedDao
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Scanner;

import com.sun.java.accessibility.util.AccessibilityListenerList;

public class Dao_Art {
	private Connection con;
	private Statement stmt;
	private PreparedStatement pstmt;
	private ResultSet rs;
	Scanner sc = new Scanner(System.in);

	public void setCon() throws SQLException {
		// 1. 드라이버 메모리 로딩..
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String info = "jdbc:oracle:thin:@localhost:1521:xe";
		con = DriverManager.getConnection(info, "scott", "tiger");
		System.out.println("접속 성공!!");
	}

//===================================================================================
	// 1. 댓글조회 DB 연결
	public ArrayList<Comment> Alllist(String sh) {
		ArrayList<Comment> commentlist1 = new ArrayList<Comment>();
		try {
			setCon();
			String sql = "SELECT * \r\n" + "FROM comment01";
			stmt = con.createStatement();
			rs = stmt.executeQuery(sql);
			while (rs.next()) {
				commentlist1.add(new Comment(rs.getString("ccommentcode"), rs.getString("date1"),
						rs.getString("content"), rs.getString("cimg"), rs.getString("ccomentcode2"), rs.getInt("anum"),
						rs.getString("art")));
			}
			System.out.println("ArrayList의 데이터 갯수:" + commentlist1.size());
			rs.close();
			stmt.close();
			con.close();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("SQL 예외 발생~~" + e.getMessage());
		} catch (Exception e) {
			System.out.println("일반예외 발생:" + e.getMessage());
		} finally {
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if (stmt != null) {
				try {
					stmt.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if (con != null) {
				try {
					con.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}

		}
		return commentlist1;
	}

	// ===================================================================================

	public ArrayList<Comment> insertComment1(Comment com) {
		ArrayList<Comment> insertComment = new ArrayList<Comment>();

		try {
			setCon();
			con.setAutoCommit(false);
			String sql = "INSERT INTO comment01 VALUES ('CO'|| pic_commentcode.nextval,"
					+ "?,'sysdate','url','CO00001',0000010,'A0000001');\r\n";

			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, com.getCcomentcode());
			pstmt.setString(2, com.getDate1());
			pstmt.setString(3, com.getContent());
			pstmt.setString(4, com.getCimg());
			pstmt.setString(5, com.getCcomentcode2());
			pstmt.setInt(6, com.getAnum());
			pstmt.setString(7, com.getArt());
			pstmt.executeUpdate();
			con.commit();
			pstmt.close();
			con.close();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("SQL 예외 발생~~" + e.getMessage());
			try {
				// 입력 중간 문제 발생, rollback처리..
				con.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		} catch (Exception e) {
			System.out.println("일반예외 발생:" + e.getMessage());
		} finally {
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if (stmt != null) {
				try {
					stmt.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if (con != null) {
				try {
					con.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}

		}
		return insertComment;
	}

	// 2. 댓글저장

	public static ArrayList<Comment> Comment(Comment com) {
		ArrayList<Comment> CommentList = new ArrayList<Comment>();
		CommentList.add(com);
		saveComment(com);
		System.out.println(CommentList.toString());
		return CommentList;
	}

	static ArrayList<Comment> CommentListSave = new ArrayList<Comment>();

	public static ArrayList<Comment> saveComment(Comment com) {
		CommentListSave.add(com);
		return CommentListSave;
	}

	// 3. 검색

	// 클래스에 입력받는 생성자를 추가 (3개)
	//
	public ArrayList<Art> ArtList(Art search) {
		ArrayList<Art> ArtList = new ArrayList<Art>();
		try {
			setCon();

			String query = "SELECT artimg 이미지, title 제목, b.cStr 카테고리명, introduce 소개, date2 날짜, "
					+ "auth 권한, c.sNum 판매여부, d.aNum 작품시리즈여부\r\n" + "FROM artwork a,category b,sale c,case1 d\r\n"
					+ "WHERE a.category = b.cStr\r\n" + "and a.sale = c.sNum\r\n" + "AND a.case1 = d.aNum\r\n"
					+ "AND b.cStr like ? and c.sNum = ? and d.aNum =?";

			pstmt = con.prepareStatement(query);

			// pstmt.setString(1, search.getArtimg());
			// pstmt.setString(2, search.getTitle());
			pstmt.setString(1, search.getCategory());
			// pstmt.setString(4, search.getIntroduce());
			// pstmt.setString(5, search.getDate2());
			// pstmt.setString(6, search.getAuth());
			pstmt.setInt(2, search.getsNum());
			pstmt.setInt(3, search.getaNum());

			rs = pstmt.executeQuery();

			System.out.println("\t이미지\t제목\t카테고리명\t소개\t날짜\t권한\t판매여부\t작품시리즈여부");

			while (rs.next()) {

				ArtList.add(new Art(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5),
						rs.getString(6), rs.getInt(7), rs.getInt(8)

				));
			}
			System.out.println("ArrayList의 데이터 갯수:" + ArtList.size());

			rs.close();
			pstmt.close();
			con.close();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("SQL 예외 발생~~" + e.getMessage());
		} catch (Exception e) {
			System.out.println("일반예외 발생:" + e.getMessage());
		} finally {
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if (stmt != null) {
				try {
					stmt.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if (con != null) {
				try {
					con.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}

		}
		return ArtList;
	}

	/*
	 * 
	 * public static String alist(String [] search){
	 * System.out.println("DB에서 가져온 작품조회리스트"); ArrayList<Art> alist = new
	 * ArrayList<Art>(); for(int idx=0; idx<alist.size();idx++) {
	 * System.out.println(alist.get(idx).toString());
	 * 
	 * } return ""; }
	 */

	public ArrayList<Comment> insertcomentlist(Comment com) {
		ArrayList<Comment> commentlist1 = new ArrayList<Comment>();
		try {
			setCon();
			con.setAutoCommit(false);
			String sql = "INSERT INTO comment01 VALUES ('CO'|| pic_commentcode.nextval,'?','?','url','CO00001',0000010,'A0000001');\r\n";

			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, com.getCcomentcode());
			pstmt.setString(2, com.getDate1());
			pstmt.setString(3, com.getContent());
			pstmt.setString(4, com.getCimg());
			pstmt.setString(5, com.getCcomentcode2());
			pstmt.setInt(6, com.getAnum());
			pstmt.setString(7, com.getArt());
			pstmt.executeUpdate();
			con.commit();
			pstmt.close();
			con.close();

			while (rs.next()) {
				commentlist1.add(new Comment(rs.getString("ccommentcode"), rs.getString("date1"),
						rs.getString("content"), rs.getString("cimg"), rs.getString("ccomentcode2"), rs.getInt("anum"),
						rs.getString("art")));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("SQL 예외 발생~~" + e.getMessage());
			try {
				// 입력 중간 문제 발생, rollback처리..
				con.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		} catch (Exception e) {
			System.out.println("일반예외 발생:" + e.getMessage());
		} finally {
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if (stmt != null) {
				try {
					stmt.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if (con != null) {
				try {
					con.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}

		}
		return commentlist1;
	}

	public ArrayList<Like> likeadd(Like likecheck) {
		ArrayList<Like> likeadd = new ArrayList<Like>();
		try {

			if (likecheck.equals(0)) {
				setCon();

				String sql = "INSERT INTO LIKEtab VALUES(80001,?,?,?)";
				pstmt.setString(1, likecheck.getLikecase());
				pstmt.setInt(2, likecheck.getLikenum());
				pstmt.setString(3, likecheck.getArtwork());

				pstmt = con.prepareStatement(sql);
				rs = pstmt.executeQuery();

				while (rs.next()) {
					likeadd.add(new Like(rs.getInt("likenum"), rs.getString("likecase"), rs.getInt("Mnum"),
							rs.getString("artwork")));
				}

				System.out.println("ArrayList의 데이터 갯수:" + likeadd.size());
			}
			rs.close();
			pstmt.close();
			con.close();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("SQL 예외 발생~~" + e.getMessage());
		} catch (Exception e) {
			System.out.println("일반예외 발생:" + e.getMessage());
		} finally {
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if (stmt != null) {
				try {
					stmt.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if (con != null) {
				try {
					con.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}

		}
		return likeadd;
	}

	public ArrayList<Like> likedown(Like likecheck) {
		ArrayList<Like> likeadd = new ArrayList<Like>();
		try {

			setCon();

			String sql = "\r\n" + "DELETE FROM liketab \r\n" + "WHERE likecase = ? \r\n" + "AND Mnum =? \r\n"
					+ "AND artwork =?";

			pstmt.setString(1, likecheck.getLikecase());
			pstmt.setInt(2, likecheck.getLikenum());
			pstmt.setString(3, likecheck.getArtwork());

			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				likeadd.add(new Like(rs.getInt("likenum"), rs.getString("likecase"), rs.getInt("Mnum"),
						rs.getString("artwork")));
			}

			System.out.println("ArrayList의 데이터 갯수:" + likeadd.size());
			rs.close();
			pstmt.close();
			con.close();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("SQL 예외 발생~~" + e.getMessage());
		} catch (Exception e) {
			System.out.println("일반예외 발생:" + e.getMessage());

		} finally {
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if (stmt != null) {
				try {
					stmt.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if (con != null) {
				try {
					con.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}

		}
		return likeadd;
	}

	public void likeList(String artwork) {
		int like1cnt = 0;
		int like2cnt = 0;
		int like3cnt = 0;

		try {
			setCon();

			String query = "SELECT count(Mnum) \"좋아요\"\r\n" + "FROM LIKEtab \r\n"
					+ "WHERE artwork=? AND likecase ='좋아요'";

			pstmt = con.prepareStatement(query);
			pstmt.setString(1, artwork);
			rs = pstmt.executeQuery();

			if (rs.next()) {
				// String like1title = rs.getString(1);
				like1cnt = rs.getInt(1);
				System.out.println(" [check] 좋아요 클릭수 : " + like1cnt);
				System.out.println(" [check] 작품번호 : " + artwork);
			}

			String query2 = "SELECT count(Mnum) \"사고싶어요\"\r\n" + "FROM LIKEtab \r\n"
					+ "WHERE artwork=? AND likecase ='사고싶어요'";

			pstmt = con.prepareStatement(query);
			pstmt.setString(1, artwork);
			rs = pstmt.executeQuery();
			System.out.println("\t사고싶어요 수");
			if (rs.next()) {
				like2cnt = rs.getInt(1);
				System.out.println(" [check] 사고싶어요 클릭수: " + like2cnt);
				System.out.println(" [check] 작품번호 : " + artwork);
			}

			String query3 = "SELECT count(Mnum) \"다음작품원해요\"\r\n" + "FROM LIKEtab \r\n"
					+ "WHERE artwork=? AND likecase ='다음작품원해요'";

			pstmt = con.prepareStatement(query);
			pstmt.setString(1, artwork);
			rs = pstmt.executeQuery();

			if (rs.next()) {
				// String like1title = rs.getString(1);
				like3cnt = rs.getInt(1);
				System.out.println(" [check] 다음작품원해요 클릭수 : " + like3cnt);
				System.out.println(" [check] 작품번호 : " + artwork);
			}

			rs.close();
			pstmt.close();
			con.close();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println(" ! sql 에러 : " + e.getMessage());
		} catch (Exception e) {
			System.out.println(" ! 일반 에러 : " + e.getMessage());
		} finally {
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}

			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}

			if (con != null) {
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

		ArrayList<Like> likelist = new ArrayList<Like>();
		for (Like l : likelist) {
			l.toString();
		}

	}

// 
}
