<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    import = "jspexp.z01_database.*"
    import = "jspexp.z02_vo.*"
    import = "java.util.*"
    import ="PRO9.VO_FUN"       
    %>
<%
	request.setCharacterEncoding("utf-8");
	String path = request.getContextPath();
%>     
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>근면하고 성실하게 살아라. 그리고 늘 유익한 일에 열중하라(프랭클린)</title>
<link rel="stylesheet" href="<%=path%>/a00_com/a00_com.css">
<style>
	
</style>

<%
String codeS = request.getParameter("code");

if(codeS ==null) codeS = "";

A05_PreparedDao dao = new A05_PreparedDao();
ArrayList<VO_FUN> fundinglist = dao.getfundinglist(codeS);

%>
<script src="<%=path%>/a00_com/jquery-3.6.0.js" type="text/javascript"></script>
<script type="text/javascript">
//var today = new Date();
//console.log(today);
//console.log(new Date(November+" "+day+","+year+", "+"00:00:00"));
	
	//var dayday = document.querySelector("input[name=end_Day]");
		var dayday ="2021-09-21";
		console.log(dayday);
		//var dayday = $("[name=end_Day]").val();
		var daysplit = dayday.split("-");
		var year = daysplit[0];
		console.log(year);
	    var month = daysplit[1];
		console.log(month);
		var day = daysplit[2];
		console.log(day);
		//데이터객체 만들고
		var ddate2 = new Date();
		
		ddate2.setFullYear(year);
		ddate2.setMonth(month-1);
		ddate2.setDate(day);
		
		var dday = new Date("November 30, 2020, 0:00:00").getTime();
		//var dday = new Date("2021,02,11,11,00,00").getTime();
		var dday = new Date(November+" "+day+","+year+", "+"00:00:00").getTime();

	//F000004
	
setInterval(function() {
  var today = new Date().getTime();
  var gap = dday - today;
  var day = Math.ceil(gap / (1000 * 60 * 60 * 24));
  var hour = Math.ceil((gap % (1000 * 60 * 60 * 24)) / (1000 * 60 * 60));
  var min = Math.ceil((gap % (1000 * 60 * 60)) / (1000 * 60));
  var sec = Math.ceil((gap % (1000 * 60)) / 1000);

  document.getElementById("count").innerHTML = "D-DAY까지 " + day + "일 " + hour + "시간 " + min + "분 " + sec + "초 남았습니다.";
}, 1000);


</script>




</head>
<%-- 
# 

--%>
<%

%>
<body>

<%for(VO_FUN f:fundinglist) {%>
	<input name ="end_Day" type ="hidden" value ="<%=f.getEnd_date()%>"/>
<%} %>

<div class="content"></div>
	<div id="count"></div>
	<div></div>
</body>
</html>