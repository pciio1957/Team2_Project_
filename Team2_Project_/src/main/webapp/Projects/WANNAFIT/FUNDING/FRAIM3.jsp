<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
   
     import = "jspexp.z01_database.A05_PreparedDao"
    import = "jspexp.z02_vo.Emp"
    import="PG8.*"
    import = "java.util.ArrayList"
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

<style>
.sec {
align: center;
padding :20px;
margin : 0, auto;
}

</style>
<script type="text/javascript">
	window.onload=function(){
		document.querySelector("h3").innerText="검색목록!!";
	};

</script>
</head>
<body>

<section class = "section"> 
<div class ="sec">
	<h4></h4>

	<% 	
	A05_PreparedDao dao = new A05_PreparedDao();
	ArrayList<VO_FUN> funlist = dao.getfunding();
	%>
	
	<%
	String funding_key= request.getParameter("funding_key");
	String category_f= request.getParameter("category_f");
	String company_id= request.getParameter("company_id");
	String goal_money = request.getParameter("goal_money");
	String  start_date = request.getParameter("start_date");
	String end_date = request.getParameter("end_date");
	String title = request.getParameter("title");
	String content = request.getParameter("content");
	String attend = request.getParameter("attend");
	String state = request.getParameter("state");
	String accumulate_money = request.getParameter("accumulate_money");
	String url_pic = request.getParameter("url_pic");
	String report_cnt = request.getParameter("report_cnt");
	
	
	
	%>
	

<form id="frm01" action="Fund_Detail.jsp">
<table border="1">
<tr>
	<%for(VO_FUN f:funlist) {%>
	<td onclick = function() >
	<%=f.getGoal_money()%><br>
	<%= f.getTitle()%><br>
	<%= f.getEnd_date()%><br>
	<%= f.getAttend()%><br>
	<%= f.getAccumulate_money()%><br>
	<input type="submit"/>
	</td>
	<%}%>
	</tr>
</table>
</form>	

</div>
</section>
<script type="text/javascript">

var itemS= document.querySelector("#item");

function item() {
	if(itme1.clicked()){
		itme1.style.backgroundColor = "skyblue";
		console.log("작품 클릭");
		location.href ="#";
	} else if(itme1.clicked()) {
		console.log("시리즈 클릭");
	}
}

</script>

</body>


</html>