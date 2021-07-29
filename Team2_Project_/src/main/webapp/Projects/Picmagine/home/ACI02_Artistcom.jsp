<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    import="java.util.*"
    import="JiEun.Picmagine.vo.*"
    import="JiEun.Picmagine.ArtistRequest.*"
%>
   
<%
	request.setCharacterEncoding("utf-8");
	String path = request.getContextPath();
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<!-- 공통 메뉴 부분 -->
<style type="text/css"> 

@import url('https://fonts.googleapis.com/css2?family=Nanum+Gothic&display=swap');

* {
	font-family: 'Nanum Gothic', sans-serif;
}

a {
	text-decoration:none;
	color:skyblue;
	font-weight: bold;  
}

a:hover {
	color:white;
}

/* 시멘틱 : CSS 적용부분 */
html, body {
	font-family: 'Nanum Gothic', sans-serif;
	margin:0 auto; padding:0px;
	height:100%;
}

.header{
	font-family: 'Nanum Gothic', sans-serif;
	width:100%; height:10%; 
	background:skyblue;
	margin:0px; padding:0px;
}

.footer {
	font-family: 'Nanum Gothic', sans-serif;
	width:100%; height:10%; clear:both;
	text-align:center;
	color:skyblue;
}

/* 헤더 : 사용자기능 */
.wTitle {
	float:left;
	display:block;
	margin-left:20%;
	font-weight: bold;
	color:RGB(253, 223, 225);
	text-shadow:0px 0px 3px darkblue;
}

.wMempart {
	font-family: "Nanum Gothic", Dotum, Arial; 
	padding:10px; 
	text-decoration:none;	
	font-size: 12px;                          
    font-weight: bold; 
    color:white;	
    
}

.wMempart:hover {
    color: skyblue;                   
    background-color: #4d4d4d;   
    padding:10px;
}

#wMemSapn {
	float:right;
	margin-right:25%;
}


/* 네비 : 메뉴 네비게이션 */
#topMenu {
 	width:100%; height: 40px;
	background-color: skyblue;  
}

#topMenuBlock {
	margin-left:10%;
}
 
 /*메뉴 전체 크기*/
#topMenu ul li {  
  	 list-style: none;           
     color: white;               
     background-color: skyblue;  
     float: left;                
     line-height: 30px;          
     vertical-align: middle;    
     text-align: center;         
     width:120px;
}
 
#topMenu ul {
  	margin:0px;
}
 
 /*메뉴 한 칸*/
#topMenu .menuLink {                              
    text-decoration:none;                     
    color: white;                              
    display: block;                            
    width: 120px;                              
    font-size: 12px;                          
    font-weight: bold;                         
    font-family: "Nanum Gothic", Dotum, Arial; 
}


#topMenu .menuLink:hover {           
    color: skyblue;                   
    background-color: #4d4d4d;    
}

/* 아래 : 제작자 */
.wTeam {
	padding:20px;
	margin-top:100px;
}

.section {
	width:70%; 
	text-align:center;
	margin:0 auto;
}

h3 {
	margin:20px;
}

#h4title {
	margin-bottom:20px;
	border-bottom:1px solid #C8C8C8;
}

[type=button]{
	width:100px;
	height:30px;
	border-radius:10px 10px 10px 10px;
	border:none;
	background-color:skyblue;
	color:white;
	border-top:20px;
}
#inform {
	
	width:80%;
	margin:0 auto;
}

#intable {
	width:60%;
	margin:0 auto;
	padding:20px;
}

table th, td {
	width:150px;
	height:40px;
	margin:20px;
	padding:10px;
}

#titletd {
	text-align:center;
	background:skyblue;
	color:white;
}


</style>

</head>
<body>
	<header class="header"> 
		<h2 class="wTitle"> Picmagine </h2>
		<span id="wMemSapn">
			<a class="wMempart" href="../login/login.html">로그인</a>
			<a class="wMempart" href="../login/join.html">회원가입</a>
		</span>
	</header>
	<nav id="topMenu"> 
		<div id="topMenuBlock">
			<ul>
				<li><a class="menuLink" href="#">HOME</a></li>
				<li><a class="menuLink" href="#">배경화면</a></li>
				<li><a class="menuLink" href="../wepage.html">사이트 소개</a></li>
			</ul>
		</div>
  	</nav>
  	<section class="section">
  	
	<%

		String memId = request.getParameter("memberid");
		String memPw = request.getParameter("memberPw");
		String memEmail = request.getParameter("memberemail");
		
		ACI01_DAO dao = new ACI01_DAO();
		boolean hasMem = false;
		hasMem = dao.login(memId, memPw);
	
	%>
	
	<% if(!hasMem) {%>
	
		<h3 align="center"> 입력한 비밀번호가 틀렸습니다! </h3>
  		
  	<% } else { %>
  		<form id="inform" action="ACI03_result.jsp">
  			<table id="intable">
  				<tr><td id="titletd" colspan="2">작가 신청 정보</td></tr>
  				<!--  작가번호, 작가명, 작가영어이름, 작가대표이미지, 작가URL, 작가외부이메일, 회원번호  -->
  				<tr><th>아이디</th><td><input type="text" name="memberid" value="<%= memId %>" readonly></td></tr>
  				<tr><th>비밀번호</th><td><input type="password" name="memberpw" value="<%= memPw %>" readonly></td></tr>
  				<tr><th>작가명</th><td><input type="text" name="inartname"></td></tr>
  				<tr><th>작가영어이름</th><td><input type="text" name="inarteng"></td></tr>
  				<tr><th>작가대표이미지</th><td><input type="file" name="inartimg"></td></tr>
  				<tr><th>작가외부이메일</th><td><input type="text" name="inartemail"></td></tr>
  				<tr><td colspan="2"><input type="submit" name="inRequest" value="입력완료"></td></tr>
  			</table>
  		</form>
  	<% } %>
  	</section>
	<footer class="footer">
		<div class="wTeam">
			<h5> 쌍용 교육센터 - 2조 <br>
			김지은, 김다은, 유혜진, 유성근, 이덕재 
			</h5>
		</div>
	</footer>
</body>
</html>