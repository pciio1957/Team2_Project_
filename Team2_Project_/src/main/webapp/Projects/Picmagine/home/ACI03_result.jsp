<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    import="JiEun.Picmagine.vo.*"
    import="JiEun.Picmagine.ArtistRequest.*"
    import="java.util.*"
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

h2 {
	text-align:center;
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

	String memid = request.getParameter("memberid");
	String mempw = request.getParameter("memberpw");
	String inartname = request.getParameter("inartname");
	String inarteng = request.getParameter("inarteng");
	String inartimg = request.getParameter("inartimg");
	String inartemail = request.getParameter("inartemail");

	boolean isCor = false;
	boolean isDone = false;
	
	if(memid == null) memid = "";
	if(mempw == null) mempw = "";
	if(inartname == null) inartname = "";
	if(inarteng == null) inarteng = "";
	if(inartimg == null) inartimg = "";
	if(inartemail == null) {
		inartemail = "";
	%>
	<h2>  데이터 입력이 없습니다 </h2>
	
	<% } else { %>	
	
	<% 	
		Member member = new Member(memid, mempw);
		Artist atis = new Artist(inartname, inarteng, inartimg, inartemail);
		
		ACI01_DAO dao = new ACI01_DAO();
		isDone = dao.setArtist(member, atis);
	}
	
	if(!isDone) { %>
  	
  	<h2> 작가 신청이 실패했습니다.. </h2>
  	
  	<% } else { %>	
  	<h2> 작가 신청이 완료되었습니다! </h2> 	
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