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
<link rel="stylesheet" type ="text/css" href="main_nav.css"/>
<style>
body {
width : 70%;
align: center;
margin: 0 auto;
}

.title01 {
text-align : center;
background : #A9BF9F;
height : 50px;
padding-top :10px;
padding-bottom:20px;
}

.sec01 {
width:65%;
text-align :left;
margin-top:30px;
padding:0;
float:left;

}

.sec02{
width:35%;
align :right;
margin:0 auto;
float:right;
margin-top:30px;


}

.tab01 {
text-align: center;
margin : 10px 10px 10px 10px;
width:80%;
}

.tab02 {
text-align: center;
margin : 10px 10px 10px 10px;
float:right;
font-size : 20px;
bord:1px;
width:80%;
}

.tab03 {
text-align: right;
float: right;
background:#A9BF9F;
margin : 10px 10px 10px 10px;
width:80%;
}

.tab04 {
text-align: center;
float:right;
margin : 10px 10px 10px 10px;
width:80%;
}

.tab05 {
text-align: right;
float: right;
background:#A9BF9F;
margin : 10px 10px 10px 10px;
width:80%;
}


.div123 {
align : center;
background : yellow;
}


.wCg {
	line-height:30px;
	padding:14px 20px;
	text-align:center;
	color:none;
	display:inline;
    background:none;
	color:white;
	margin-top:50%;
	width:500px;
	height:200px;
	box-shadow: 0px 0px 20px #000;
}


.wCg:hover {
	background:none;
	color:white;
	margin-top:50%;
	width:300px;
	height:100px;
	box-shadow: 0px 0px 20px #000;
}
.fund_btn {
width:80%;
}

.separate01 {
height:10px;
}
.wantbtn {
width:100%;
}
</style>


</head>
<%-- 
# 

--%>
<%
String codeS = request.getParameter("code");


if(codeS ==null) codeS = "";

A05_PreparedDao dao = new A05_PreparedDao();
ArrayList<VO_FUN> fundinglist = dao.getfundinglist(codeS);

//getfundinglist


%>

<script type="text/javascript">
$(document).ready(function{
	$(".trigger").click(function(){
		console.log(codeS);
		location.href = "FUN-UI-03.jpg?codeS="+codeS;
	});
});

</script>
<body>
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
 <div class ="separate1">
  <p></p>
  </div>

<section> 

<p class = "p"></p>   



	<div class ="sec01">
		<table class ="tab01"> 
			<% for(VO_FUN f:fundinglist){ %>
			<tr><td><p id = "title"><%=f.getTitle()%></p></td></tr>
			<%} %>
			<tr><td><img src ="img/img01.JPG" width ="100%" height ="100%" /></td></tr>
		</table>
		<br>
		<div class= "div123">
			
		<span class="wCg"><a href="det_frame1.jsp" target="contentFrame" onclick="wCgChange()" id="wACate1">펀딩정보</a></span>
		<span class="wCg"><a href="det_frame2.jsp" target="contentFrame" onclick="wCgChange()" id="wACate2">수수료안내</a></span>
		<span class="wCg"><a href="det_frame3.jsp" target="contentFrame" onclick="wCgChange()" id="wACate2">문의내역</a></span>

			
			<div id="wContent">
				<iframe scrolling =yes name="contentFrame" src="det_frame1.jsp"></iframe>
			
			
			</div> <br>
	</div>
	</div>
	
	<div class ="sec02">
		<table class ="tab02">
		<% for(VO_FUN f:fundinglist){ %>
			<tr><td><h4>남은기간:</h4></td>
			<tr><td><h4> <%=f.getEnd_date()%></h4></td></tr>
		<%}%>
		</table>
	
		
		<table class ="tab03">
		<% for(VO_FUN f:fundinglist){ %>
		
			<tr><td><%=f.getAccumulate_money()%>원 달성</td></tr>
			<tr><td><%=f.getGoal_money()%>원 목표</td></tr>
			<tr><td><%=f.getAttend()%>서포터</td></tr>
			<%}%>
		</table>
			<form action = "FUN-UI-03.jsp" method ="post">
			<table class ="tab04">
			<tr><td><button id ="fundingbtn" onclick = "function()" class="trigger">펀딩하기</button></td><tr>
			<tr> 
				<td colspan ="4"><input type ="submit" name = "qna_btn" value = "공유"/>
								<input type ="submit" name = "share_btn" value = "찜"/>
								<input type ="submit" name = "record_btn" value="신고" />
				</td>
			</tr>
			<tr><td><input type ="submit" name = "want_btn" value = "문의하기"/></td></tr>
		</table>
		</form>
	
	
	<table class ="tab05">
			<tr><td>기업명:</td></tr>
			<tr><td>연락처:</td></tr>
			<tr><td>sns주소:</td></tr>
		
		</table>
	</div>
	
	
	
	

</section>
	
</body>
</html>