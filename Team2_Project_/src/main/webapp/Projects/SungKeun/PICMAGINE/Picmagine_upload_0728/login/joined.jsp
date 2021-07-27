<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
	import="java.util.*"
	import="java.sql.*"
	import="SungKeun.PICMAGINE.Join.JOINDAO"
	import="SungKeun.PICMAGINE.Join.JOINDTO"
%>
<%

	request.setCharacterEncoding("utf-8");
	String path = request.getContextPath(); 
%>   
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title> PICMAGINE : 회원 가입 완료 </title>
<link rel="stylesheet" href="<%=path%>/a00_com/a00_com.css">
<style>
	
</style>
<script type="text/javascript">
	window.onload=function(){
		document.querySelector("h3").innerText="PICMAGINE : 회원 가입이 완료되었습니다!";
	};

</script>
</head>
<body>
	<%	
		String memno = request.getParameter("memno");
		if(memno==null) memno = "";
		String memid = request.getParameter("memid");
		if(memid==null) memid = "";
		String mempw = request.getParameter("mempw");
		if(mempw==null) mempw = "";
		String memtel = request.getParameter("memtel");
		if(memtel==null) memtel = "";
		String mememail = request.getParameter("mememail");
		if(mememail==null) mememail = "";
		String memauth = request.getParameter("memauth");
		if(memauth==null) memauth = "회원";
	
		JOINDTO join = new JOINDTO(memno, memid, mempw, memtel, mememail, memauth);
		// 기존 저장되있는 회원목록을 보여주기 위한 변수
		JOINDAO dao = new JOINDAO();
		ArrayList<JOINDTO> jlist = dao.memberList();						

	%>
 
	<h3 align="center"></h3>
	<table>
		<h4 align="center"> * <%=join.getMemid() %> 님의 회원정보 등록 * </h4>
		<tr><th> NO. </th><th> ID </th><th> PW </th><th> TEL </th><th> EMAIL </th><th> AUTH </th></tr>
		<tr>
			<td><%=join.getMemno() %></td>
			<td><%=join.getMemid() %></td>
			<td><%=join.getMempw() %></td>
			<td><%=join.getMemtel() %></td>
			<td><%=join.getMememail() %></td>
			<td><%=join.getMemauth() %></td>
		</tr>
	</table><br>
	<table>
		<h4 align="center"> * 회원정보 리스트 * </h4>
		<tr><th> NO. </th><th> ID </th><th> PW </th><th> TEL </th><th> EMAIL </th><th> AUTH </th></tr>
		<%for(JOINDTO j:jlist) { %>
		<tr>
			<td><%=j.getMemno() %></td>
			<td><%=j.getMemid() %></td>
			<td><%=j.getMempw() %></td>
			<td><%=j.getMemtel() %></td>
			<td><%=j.getMememail() %></td>
			<td><%=j.getMemauth() %></td>
		</tr>
		<% } %>
	</table>
	 
	
</body>
</html>