<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.sql.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<%



Connection con;
Statement stmt;
PreparedStatement pstmt;
ResultSet rs;
String name = ""; 
boolean isCon = false;


	try {
	
		Class.forName("oracle.jdbc.driver.OracleDriver");

		String info = "jdbc:oracle:thin:@localhost:1521:xe";
		con = DriverManager.getConnection(info, "scott", "tiger");

		String sql = "select * from emp";
		stmt = con.createStatement();
		rs = stmt.executeQuery(sql);
		
		while(rs.next()){
			name = rs.getString("ename");
			isCon = true;
		}
		

		rs.close(); stmt.close(); con.close();

	} catch (SQLException e) {
		System.out.println("SQL Error : " + e.getMessage());
	} catch (ClassNotFoundException e1) {
		System.out.println("[JDBC Connector Driver 오류 : " + e1.getMessage() + "]");
	} 

%>


<%= name %>
연결 확인 : <%= isCon %>


</body>
</html>