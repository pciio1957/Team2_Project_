<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<jsp:useBean id="membermanager"
	class="DaEun.Picmagine.member.MemberManager" />
<jsp.useBean id="Dto"
	class="DaEun.Picmagine.member.MemberDto" />

<%
String idkey = (String) session.getAttribute("idKey");
MemberDto dto = membermanager.getData(idkey);
%>
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
				<form name="regForm" method="post" action=".jsp">
					<table border="1">
						<tr align="center" style="background-color: sktblue"></tr>
						<td colspan="2"><b style="color: #FFFFFF">회원 정보 수정</b></td>
						</tr>
						<tr>
							<td width="16%">아이디</td>

							<td width="57%"><input type="text" name="id" size="15"
								style="background-color: lightgray" readonly="readonly"
								value="<%=dto.getId()%>"></td>
						</tr>
						<tr>
							<td>패스워드</td>
							<td><input type="password" name="pass" size="15"
								value="<%=dto.getPass()%>"></td>
						</tr>
						<tr>
							<td>패스워드 확인</td>
							<td><input type="password" name="repass" size="15"></td>
						</tr>
						<tr>
							<td>이름</td>
							<td><input type="text" name="name" size="15"
								value="<%=dto.getName()%>"></td>
						</tr>
						<tr>
							<td>이메일</td>
							<td><input type="text" name="mail" size="27"
								value="<%=dto.getMail()%>"></td>
						</tr>
						<tr>

							<td colspan="2" align="center">
							<input type="button"value="수정완료" id="btnModify" /> 
							&nbsp;&nbsp; 
								<input type="button" value="수정취소" id="btnModifyCancel" /> 
								<input type="button" value="회원탈퇴" id="btnDelete" /></td>
						</tr>
					</table>
				</form>
			</td>
		</tr>
	</table>

</body>
</html>
