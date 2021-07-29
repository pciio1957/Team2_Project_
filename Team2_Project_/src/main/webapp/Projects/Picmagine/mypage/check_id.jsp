<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<jsp:useBean id="membermanager" class="DaEun.Picmagine.member.MemberManager" />

<%
request.setCharacterEncoding("utf-8");
%>

<%
String id = request.getParameter("id");
%>

<%
boolean b = membermanager.checkId(id);
%>

<!DOCTYPE html>

<html>

<head>

<meta charset="UTF-8">

<title>id 중복 검사</title>

</head>

<body>

	<b><%=id%></b>

	<%
	if (b) {
	%>

	는(은) 이미 사용중인 id 입니다.
	<p />

	<a href="#"
		onclick="opener.document.regForm.id.focus(); window.close();">닫기</a>
	<%
	} else {
	%>

	는(은) 사용 가능 합니다.
	<p />

	<a href="#"
		onclick="opener.document.regForm.pass.focus(); window.close();">닫기</a>

	<%
	}
	%>

</body>

</html>
