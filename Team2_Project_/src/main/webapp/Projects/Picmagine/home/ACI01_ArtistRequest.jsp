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

</style>
<style type="text/css"> 

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

#atRequest {
	width:70%;
	margin:0 auto;
}

#tabin {
	width:50%;
	margin:0 auto;
	padding:20px;
}

#tabin th, td {
	width:120px;
	height:40px;
	margin:20px;
	padding:5px;
}

[name=btnRequest] {
	background-color:skyblue;
	color:white;
	width:100px;
	height:30px;
	border:none;
	border-top:30px;
	border-radius:10px 10px 10px 10px;
}


</style>
</head>

<%

	ACI01_DAO dao = new ACI01_DAO();
	Member member = new Member();
	member = dao.getMemInfo("mb1003");

%>


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
  	
  	<h1> Picmagine 작가 신청 </h1>	
  	<h4> 작가신청을 위해 비밀번호를 입력하세요 </h4>
  	<h4 id="h4title">  </h4>
  	<form id="atRequest" action="ACI02_Artistcom.jsp" method="post">
  		<table id="tabin">
  			<tr><th>아이디</th><td><input type="text" name="memberid" value="<%= member.getMemid() %>"></td></tr>
  			<tr><th>비밀번호</th><td><input type="password" name="memberPw"></td></tr>
  			<tr><th>이메일</th><td><input type="text" name="memberemail" value="<%= member.getMememail() %>" readonly></td></tr>
  			<tr>
	  			<td colspan="2">
	  				<input type="submit"  value="신청하기" name="btnRequest"/> 
	  			</td>
  			</tr>
  		</table>
  	</form>	
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