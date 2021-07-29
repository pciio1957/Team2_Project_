<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"
	import="DaEun.Picmagine.member.MemberManager"
	import="DaEun.Picmagine.member.MemberDto"
	
	%>
<%--	
<jsp:useBean id="membermanager"
	class="DaEun.Picmagine.member.MemberManager" />
<jsp:useBean id="Dto" class="DaEun.Picmagine.member.MemberDto"></jsp:useBean>	
 --%>
<%
MemberManager membermanager = new MemberManager();
// session  idKey는 어디서 가져오실건지
//String idkey = (String) session.getAttribute("idKey");
// 세션값 임의로 해볼께요..
String idkey = "higirl";
MemberDto dto = membermanager.getData(idkey);


%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="../js/script.js?ver=2"></script>
<script type="text/javascript"></script>
<!-- 공통 메뉴 부분 -->
<style type="text/css"> 

@import url('https://fonts.googleapis.com/css2?family=Nanum+Gothic&display=swap');

* {
	font-family: 'Nanum Gothic', sans-serif;
}

a {
	color:skyblue;
	text-decoration:none;
	font-weight: bold;  
}

a:hover {
	background:skyblue;
	color:white;
	font-weight: bold;  
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
	width:80%; 
	text-align:center;
	margin:0 auto;
}

.table {
	width:30%; 
	text-align:center;
	margin:0 auto;
}

#divmypage {
	width:80%;
	margin:0 auto;
	text-align:center;
}

#tabmypage {
	width:300px;
	margin:0 auto; padding:0px;
	margin-top:20px;
	margin-bottom:40px;	
}

#tabmypage td {
	margin:0 auto; 
	padding:0px;
}

.updatemember {
	border-bottom:1px solid #C8C8C8;
	padding:10px;
}

.updatemember:hover {
	padding:10px;
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
  	
  	  	<div id="divmypage">
	  		<table id="tabmypage">
	  			<tr>
		  			<td><a class="updatemember" href="..\..\home\ACI01_ArtistRequest.jsp">작가신청</a>
		  			<a class="updatemember" href="#">개인정보 수정</a></td>
	  			</tr>
	  		</table>
  		</div>
		<table class="table">
			<tr>
				<td align="center" valign="middle" style="background-color: #FFFFff">
					<form name="regForm" method="post" action="modify_member_action.jsp">
						<table border="1">
							<tr align="center" style="background-color: sktblue"></tr>
							<td colspan="2"><b style="color: skyblue">회원 정보 수정</b></td>
							</tr>
							<tr>
								<td width="16%">아이디</td>
	
								<td width="57%"><input type="text" name="id" size="15"
									style="background-color: lightgray" readonly="readonly"
									value="<%=dto.getId()%>"></td>
							</tr>
							<tr>
								<td>패스워드</td>
								<td><input type="password" name="pass" size="15"
									value="<%=dto.getPass()%>"></td>
							</tr>
							<tr>
								<td>패스워드 확인</td>
								<td><input type="password" name="repass" size="15"></td>
							</tr>
							<tr>
								<td>핸드폰번호</td>
								<td><input type="text" name="phone" size="27"
									value="<%=dto.getPhone()%>"></td>
							</tr>
							<tr>
								<td>이메일</td>
								<td><input type="text" name="mail" size="27"
									value="<%=dto.getMail()%>"></td>
							</tr>
							<tr>
		
								<td colspan="2" align="center">
								<input type="submit" value="수정완료" id="btnModify" /> &nbsp;&nbsp; 
								<input type="button" value="수정취소" id="btnModifyCancel" /> 
								<input type="button" value="회원탈퇴" id="btnDelete" /></td>
							</tr>
						</table>
					</form>
				</td>
			</tr>
		</table>
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
