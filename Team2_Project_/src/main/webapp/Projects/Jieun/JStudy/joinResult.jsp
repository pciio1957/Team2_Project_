<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<style type="text/css">

@import url('https://fonts.googleapis.com/css2?family=Nanum+Gothic&display=swap');

html, body {
	font-family: 'Nanum Gothic', sans-serif;
	text-align:center;
}

</style>
<body>

	<% 
		String id = request.getParameter("inid");
		String pw = request.getParameter("inpw");
		String rePw = request.getParameter("inrepw");
		String email = request.getParameter("inemail");
		String bir_yr = request.getParameter("inbir_yr");
		String bir_mt = request.getParameter("inbir_mt");
		String bir_dy = request.getParameter("inbir_dy");
		
	%> 
	
	<h3><%= id %> 님 회원가입을 축하드립니다! </h3>

</body>
</html>