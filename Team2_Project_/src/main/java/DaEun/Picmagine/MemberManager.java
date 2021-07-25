package DaEun.Picmagine;

public class MemberManager{

public MemberDto getData(String id){

	MemberDto dto = null;

	try {

		String sql = "select id, pass, mail";

		conn = ds.getConnection();

		pstmt = conn.prepareStatement(sql);

		pstmt.setString(1, id);

		rs = pstmt.executeQuery();

		if(rs.next()){

			dto = new MemberDto();

			dto.setId(rs.getString("id"));

			dto.setPass(rs.getString("pass"));

			dto.setName(rs.getString("name"));

			dto.setMail(rs.getString("mail"));

		}

		

	} catch (Exception e) {

		System.out.println("getData err : " + e);

	} finally {

		try {

			if(rs!=null)rs.close();

			if(pstmt!=null)pstmt.close();

			if(conn!=null)conn.close();

		} catch (Exception e2) {

			// TODO: handle exception

		}

	}

	return dto;

}

}