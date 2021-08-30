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

<style>

.sec01 {
width:70%;
margin: 0 auto;

}
.tab01 {
font-size:20px;
font-weight:bold;
text-align: center;
align:center;
background:#A9BF9F;
margin : 10px 10px 10px 10px;
width:100%;
border: 1px solid #D9B68B; 
background-color: #D9B68B; 
border-radius: 16px;
box-shadow: inset 0 0 8px #deb13a;
height:90%;
}

.user_Info {
background: #D8D9D7;
width:80%;
margin-left:20px;
}

#Info_font {
font-size : 20px;
margin-left:20px;
font-weight: bold;
}

#reserve_Btn {
background:#D9B68B;
width:100px;
}

#reserve {
align:center;
text-align:center;
float:center;
}

.blinking{
 -webkit-animation:blink 1.5s ease-in-out infinite alternate; 
-moz-animation:blink 1.5s ease-in-out infinite alternate; 
animation:blink 1.5s ease-in-out infinite alternate; 
color:white;
} 

@-webkit-keyframes blink{ 
0% {opacity:0;
} 100% {opacity:1;
} 
} 

@-moz-keyframes blink{ 0% {opacity:0;} 100% {opacity:1;} } @keyframes blink{ 0% {opacity:0;} 100% {opacity:1;} }




 .agree a{cursor:pointer;}
 .agree .hide{display:none;}

.card_num {
width:30px;
}

input {
align :center;
float::center;
text-align:center;

}

</style>
<script src="<%=path%>/a00_com/jquery-3.6.0.js" type="text/javascript"></script>
<link rel="stylesheet" type ="text/css" href="main_nav.css"/>
<script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
<script type="text/javascript">


</script>
</head>
<%-- 
# 

--%>
<%
String codeS = request.getParameter("code");


if(codeS ==null) codeS = "";

A05_PreparedDao dao = new A05_PreparedDao();
ArrayList<VO_FUN> fundinglist = dao.getfundinglist(codeS);

%>
<body>

	<nav class="navbar">
    <div class="nav-wrapper">
      <ul class="logo">
        <li><a href="FUN-UI-01.jsp">WANNAFIT</a></li>  
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

<section class ="sec01">
	<div>
		<table class ="tab01">
			<tr><td><span > 신청이 완료되었습니다.</span></td></tr>
		</table>
		
		<input name = "detail" value ="상세내역보러가기" type ="submit"/>
		<input name ="mylist" value ="나의내역바로가기" type ="submit"/>
	</div>
	

  		
</section>
</body>
</html>