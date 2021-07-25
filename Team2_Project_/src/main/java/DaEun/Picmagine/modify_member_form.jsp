<%@page import="Picmagine\MemberDto"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<jsp:useBean id="membermanager" class="Picmagine.MemberManager" />

<% String idkey = (String) session.getAttribute("idKey");
  MemberDto dto = membermanager.getData(idkey); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="../js/script.js?ver=2"></script>
<script type="text/javascript"></script>
</head>
<body>
<br>
<table class="table">
<tr>
	<td align="center" valign="middle" style="background-color: #FFFFff">
</td>
</tr>
</table>

</body>
</html>
