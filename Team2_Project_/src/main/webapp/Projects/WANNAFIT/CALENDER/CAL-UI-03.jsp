<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    import = "jspexp.z01_database.*"
    import = "jspexp.MINIVO.ScheduleDao"
    import = "jspexp.MINIVO.Schedule"
    import = "java.util.*"    
    %>
<%
	request.setCharacterEncoding("utf-8");
	String path = request.getContextPath();
%>     
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>상세화면</title>
<link rel="stylesheet" href="<%=path%>/a00_com/a00_com.css">
<script src="<%=path%>/a00_com/jquery-3.6.0.js" 
	type="text/javascript"></script>
<style>
.btn {
width: 10%;
font-size: 3px;
margin: 4px 2px;
background :#6C7EAA;
border-radius: 5px;
text-color :white;
}
</style>
<script type="text/javascript">

</script>
</head>
<%-- 
# 

--%>
<%
String dispday = request.getParameter("param");
String Snum = dispday;
if(Snum ==null) Snum = "";

%>


<%
ScheduleDao dao = new ScheduleDao();
ArrayList<Schedule> ScheduleList = dao.getSchedule(Snum);
%>
<body>

<%if(Snum!=null) { %>
	<form method = "post">
	<table>
	<%for(Schedule s:ScheduleList) {%>
		<tr><td>제목</td><td><%=s.getTitle()%></td></tr>
		<tr><td>해야할일1</td><td><%=s.getWork1()%></td></tr>
		<tr><td>해야할일2</td><td><%=s.getWork2()%></td></tr>
		<tr><td>해야할일3</td><td><%=s.getWork3()%></td></tr>
		<tr><td>해야할일4</td><td><%=s.getWork4()%></td></tr>
		<tr><td>날짜</td><td><%=s.getDate()%></td></tr>
		<tr><td>댓글</td><td><%=s.getComment()%></td></tr>
		<%} %>	
		<%} %>
	</table>
		<h3><input type ="button" class ="btn" value ="일정 신규 등록" onclick ="change()"/></h3>
	</form>
</body>
	<script type="text/javascript">
	function change(){
    window.open("a02_scheduler.jsp","popupView","width=350 height=350"); 
}
	</script>
</html>