<%@ page language="java" contentType="text/html; charset=UTF-8"

    pageEncoding="UTF-8"%>

<%	request.setCharacterEncoding("utf-8"); %>

<jsp:useBean id="membermanager" class="DaEun.Picmagine.member.MemberManager"/>
<jsp:useBean id="bean" class="DaEun.Picmagine.member.MemberBean"/>
<jsp:setProperty property="*" name="bean"/>

<%

	boolean b = membermanager.modifyData(bean);

	if(b){

%>

	<script>

		alert("수정 성공");

		location.href = "../index.jsp";

	</script>	

<% } else { %>

	<script>

		alert("수정 실패!\n관리자에 문의바람");

		history.back();

	</script>	

<%

	}

%>
