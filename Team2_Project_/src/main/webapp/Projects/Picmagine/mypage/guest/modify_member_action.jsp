<%@ page language="java" contentType="text/html; charset=UTF-8"

    pageEncoding="UTF-8"
    import="DaEun.Picmagine.member.*"
    
    %>
<%	request.setCharacterEncoding("utf-8"); %>



<jsp:useBean id="membermanager" class="DaEun.Picmagine.member.MemberManager"/>
<jsp:useBean id="bean" class="DaEun.Picmagine.member.MemberBean"/>
<jsp:setProperty property="id" name="bean" value=""/>
<jsp:setProperty property="pass" name="bean"/>
<jsp:setProperty property="phone" name="bean"/>
<jsp:setProperty property="mail" name="bean"/>


<%
	String id = request.getParameter("id");
	String pass = request.getParameter("pass");
	String phone = request.getParameter("phone");
	String mail = request.getParameter("mail");
	bean.setId(id);
	bean.setPass(pass);
	bean.setPhone(phone);
	bean.setMail(mail);
	
	boolean b = membermanager.modifyData(bean);

	if(b){

%>

	<script>

		alert("수정 성공");
		location.href = "../main.html";
	</script>	

<% } else { %>

	<script>

		alert("수정 실패!\n관리자에 문의바람");

		history.back();

	</script>	

<%

	}

%>
