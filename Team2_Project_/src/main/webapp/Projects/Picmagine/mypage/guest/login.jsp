<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%
String id = (String) session.getAttribute("idKey");
%>

<!DOCTYPE html>

<html>

<head>

<meta charset="UTF-8">

<title>사용자 로그인</title>
<script src="DaEun\Picmagine\script.js"></script>
<script type="text/javascript">
	window.onload = function() {
		document.getElementById("btnLogin").onclick = funcLogin;
		document.getElementById("btnHome").onclick = funcHome;

	}
</script>
</head>
<body>

	<form name="loginForm">

		<%
		if (id == null || id == "") {
		%>

		<table>
			<tr>
				<td colspan="2">** 사용자 로그인 **</td>

			</tr>
			<tr>

				<td>아이디 :</td>
				<td><input type="text" name="id" />
			</tr>
			<tr>

				<td>비밀번호 :</td>
				<td><input type="text" name="passwd" />
			</tr>
			<tr>

				<td colspan="2"><input type="button" value="로 그 인"
					id="btnLogin" /> <input type="button" value="홈페이지" id="btnHome" />

				</td>

			</tr>

		</table>

		<%
		} else {
		%>

		<%=id%>님 로그인 중입니다<br /> <a href="../main.html">메인 화면으로</a> <a
			href="login_out.jsp">로그아웃</a>

		<%
		}
		%>
	</form>

</body>

</html>
