package DaEun.LTM;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class LTM1Dao {

	public int insertData(LTM1Dto dto) {
		int result = 0;
		Connection conn = DBConn.getConnection();

		PreparedStatement pstmt = null;

		String sql;

		try {

			sql = "insert into naverMember (id,pw,name,gender,birth,email,tel) ";

			sql += "values (?,?,?,?,?,?,?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dto.getId());
			pstmt.setString(2, dto.getPass());
			pstmt.setString(3, dto.getBrith());
			pstmt.setString(4, dto.getTel());
			pstmt.setString(5, dto.getEmail());
			pstmt.setString(6, dto.getLoc());
			result = pstmt.executeUpdate();
			pstmt.close();
		} catch (Exception e) {
			System.out.println(e.toString());
		}
		return result;

	}

	// update
	public int updateData(LTM1Dto dto) {
		int result = 0;
		return result;

	}

}