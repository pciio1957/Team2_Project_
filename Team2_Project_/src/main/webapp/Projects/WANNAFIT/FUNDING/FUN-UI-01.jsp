<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    import = "jspexp.z01_database.*"
    import = "jspexp.z02_vo.*"
    import = "java.util.*" 
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
<title>detail page_funding</title>
<link rel="stylesheet" type ="text/css" href="main_nav.css"/>

<script type="text/javascript">

</script>
<style>
﻿* {
	margin:0;
	padding:0;
}
h1 {
	width:100%;
	height:150px;
	background: url('../images/top-bg.jpg') no-repeat left top;
	background-size:cover;
	line-height: 150px;
	padding-left:50px;
}
.sec {
width:100%;
align :center;

}



#wrapper {
	width:100%;
	max-width:800px;
	min-width:800px;
	margin: 2px 2px 2px 2px;
	
}
#columns {
	-webkit-column-count:2;
	-webkit-column-gap:10px;
	-moz-column-count:2;
	-moz-column-gap:10px;
	column-count:2;
	column-gap:200px;	
}
.card {
	display:inline-block; 
	width:180px;
	background:#ffff;
	box-shadow:0px 1px 1px #ccc;
	padding:15px;
	padding-bottom:15px;
	margin:2px;
}
.card img {
	width:100%;
	border-bottom:1px solid #ccc;
	padding-bottom:15px;
	margin-bottom:5px;
}

.card p {
	font-family:"맑은 고딕", 돋움;
	color:#333;
	margin:0;
	padding:10px;
}
	
@media(min-width:600px){
	#columns{
		-webkit-column-count:3;
		-moz-column-count:3;
		column-count:3;
	}
}

@media(min-width:600px) {
	#columns{
		-webkit-column-count:4;
		-moz-column-count:4;
		column-count:4;
	}
}

#img {
width :150px;
height: 100px;
}

.p {
height:100px;
}
</style>
</head>
<%-- 
# 
<jsp:include page="/MINI/MAIN/Main.jsp"></jsp:include>

--%>
	<% 	
	A05_PreparedDao dao = new A05_PreparedDao();
	ArrayList<VO_FUN> funlist = dao.getfunding();
	//getfundinglist
	
	%>
<body>
<script src="<%=path%>/a00_com/jquery-3.6.0.js" 
	type="text/javascript"></script>
<script type ="text/javascript">
$(document).ready(function() {
	$("#img").click(function() {
		var code= $("[name=code]").val();
		console.log(code);
		location.href = "FUN-UI-02.jsp?code="+code; 
	});
	
	
});
</script>
<nav class="navbar">
    <div class="nav-wrapper">
      <ul class="logo">
        <li><a href="#">WANNAFIT</a></li>  
      </ul>
    </div>
    
    <div class="menu-wrapper">
      <ul class="menu">
    	<li><a href="#">워너핏 X 파트너</a></li>
        <li><a href="#">로그인</a></li>
        <li><a href="#">회원가입</a></li>
      </ul>
    </div>
  </nav>
  
  <nav class="navar1-1">
 
  <div><b>내가 원하는 삶을 살기 위한 건강 프로젝트! 워너핏</b></div>

  </nav>
  
  
  <nav class="navbar2">
	   <ul class="side_menu1">
	        <li><a href="#"><b>맵핏</b></a></li>
	        <li><a href="#"><b>예약</b></a></li>
	        <li><a href="#"><b>그룹핏</b></a></li>
	        <li><a href="#"><b>펀인핏</b></a></li>
	        <li><a href="#"><b>워너핏</b></a></li>
	   </ul>
   </nav>
<nav><hr></nav>
<p class = "p"></p>   

<section class ="sec">
	<div id ="wrapper">
	<div id = "columns">	
	
	<form action = "FUN-UI-01.jsp" method ="post">
	<%for(VO_FUN f:funlist) {%>
	<div onclick = "function()"class = "card">
	<p id = "title"><%=f.getTitle()%></p>
	<img id = "img" src = "img/<%=f.getUrl_pic()%>">
	<p id = "goal"><%= f.getGoal_money()%></p>
	<p id = "title"><%= f.getTitle()%></p>
	<p id = "enddate"><%= f.getEnd_date()%></p>
	<p id = "attend"><%= f.getAttend()%></p>
	<p id = "accumulate"><%= f.getAccumulate_money()%></p>
	<input id = "funding" name ="code" value ="<%= f.getFunding()%>"/>
	
	<!--  //F1000004 -->
	
	</div>
	<%} %>
	</form>
	
	</div>
	</div>
</section>
</body>

</html>