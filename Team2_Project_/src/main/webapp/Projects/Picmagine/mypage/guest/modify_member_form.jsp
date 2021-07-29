<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"
	import="DaEun.Picmagine.member.MemberManager"
	import="DaEun.Picmagine.member.MemberDto"
	
	%>
<%--	
<jsp:useBean id="membermanager"
	class="DaEun.Picmagine.member.MemberManager" />
<jsp:useBean id="Dto" class="DaEun.Picmagine.member.MemberDto"></jsp:useBean>	
 --%>
<%
MemberManager membermanager = new MemberManager();
// session  idKey는 어디서 가져오실건지
//String idkey = (String) session.getAttribute("idKey");
// 세션값 임의로 해볼께요..
String idkey = "higirl";
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
				<form name="regForm" method="post" action="modify_member_action.jsp">
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
							<td>핸드폰번호</td>
							<td><input type="text" name="phone" size="27"
								value="<%=dto.getPhone()%>"></td>
						</tr>
						<tr>
							<td>이메일</td>
							<td><input type="text" name="mail" size="27"
								value="<%=dto.getMail()%>"></td>
						</tr>
						<tr>
	
							<td colspan="2" align="center">
							<input type="submit" value="수정완료" id="btnModify" /> &nbsp;&nbsp; 
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
