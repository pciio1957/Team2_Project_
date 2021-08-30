<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
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
<title>상세페이지</title>
<link rel="stylesheet" href="main_nav.css" />

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

body {
width :70%;
}
a:hover {
	color:white;
}

/* 헤더 : 사용자기능 */
.wTitle {
	padding:30%
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




</style>


<!-- 작가홈 부분 -->
<style type="text/css">

/* 섹션 : HTML 내용 */
.section { <!--section부분 크기조정-->
	width:80%;
	text-align:center;
	margin:0 auto;
	margin-left:30%;
	margin-right:10%;
}

/* 내용부분 2부분으로 나눠 출력*/
.part1 {
	width:30%;
	height:80%;
	float:left;
	margin-left:40px;
	text-align:center;
	padding:40px 20px 10px 60px;
	margin :0 auto;	
}

.part2 {
	width:70%;
	float:right;
	margin:0 auto;
}

/* 내용 왼쪽 : 사용자 정보 부분 */
/* 왼쪽 테이블 전체 속성 적용 */
#wInfoTable {
	width:80%;
	border-right:2px solid #C8C8C8;
	border-collapse:collapse;
	margin:20px auto;
	margin-left:20px;
	text-align:left;
}

#wInfoTable tr>td {
	width:200px;
	margin:10px auto;
}

.infoCenter {
	width:150px;
	height:60px;
	margin-left:50px;
}

#imgSize {
	width:100px; height:100px;
	border-radius:50%;
	/* 이미지를 원형으로 표시*/
}

/* 팔로우 버튼 */
#btnFollow {
	border:1px solid skyblue;
	border-radius:10px 10px 10px 10px;
	background:#FFFFFF;
	color:skyblue;
	width:120px;
	padding:10px;
}

#btnFollow:active {
	border:none;
	border-radius:10px 10px 10px 10px;
	background:#6799FF;
	color:white;
	padding:10px;
}

/* 작가 정보 */
#wImg {
	width:150px;
	height:150px;
	
}

.infoTitle {
	width:150px;
	height:30px;
	margin:0 auto;
	font-size:13px;
}

.infoHr {
	width:230px; 
	margin-left:0px;
	margin-top:0px;
	border:1px solid #C8C8C8;
}

.wInfoContent {
	width:200px;
	height:80px;
	margin-top:0px;
	padding:0;
	font-size:13px;
}

[name=contentFrame] {
	border:2px solid blue;
	float:center;
	width:550px;
	height:650px;
	border:none;
	
}

/* 내용 오른쪽 : 목록부분 */
#wCategory {
	border-bottom:1px solid #C8C8C8;
	float:left;
	height:30px;
	margin-top:20px;
	margin-left:5%;
	display:inline;
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




.div1 {
	margin-top:20px;
	height:50px;
	width:auto;
}
.div2 {
padding:40px 20px 10px 60px;
	margin :0 auto;
}
.tr1 {
margin-top:20px;
height:10;
font-family: "Helvetica Neue",Helvetica,Arial,sans-serif;
    font-size: 12px;
    font-weight: 700;
    margin: 0 0 20px;
    position: relative;
}
.tab {
margin:0, auto;
height:40px;
}

.text {
color:white;
}
.hr {
width:200px;
float:left;
}

.v {
  border-left: 1px solid white;
  height: 400px;
  position: absolute;
  left: 30%;
  margin-top: 2px;
  margin-left: -3px;
  top: 0;
}
.contentframe {
width: 100%;

}

.section {
margin-left:20px;
margin-right:20px;
}
.container {
width:1080px;
align:center;
margin-bottom:8px;
margin-left: 100px;
margin-right:100px;
}
.leftdetail {
width:740px;
float:left;
backgrond-color:red;

}
.rightdetail {
width:332px;
float:right;
backgrond-color:yellow;
}
.tab {
text-align : left;
color:white;
font-size : 14px;
border-spacing: 0 20px;

}
.tablebox {
border: 1px solid #000; 
  border-radius: 2px;
 box-shadow: 0px 0px 20px #000;
  width:300px;
  height:451px;
  margin-left:800px;
}
.div123{
height:100px;
}

.divtab {
height:90px;

}
.titletext {
color: white;
}
.button {
align : center;
}
</style>


</head>
<%
String funding_key = request.getParameter("funding");
//String category_f = request.getParameter("category_f");
//String company_id = request.getParameter("company_id");
String goal_money = request.getParameter("goal_money");
//String start_date = request.getParameter("start_date");
String end_date = request.getParameter("end_date");
String title = request.getParameter("title");
//String content = request.getParameter("content");
String attend = request.getParameter("attend");
//String state = request.getParameter("state");
String accumulate_money = request.getParameter("accumulate_money");
String url_pic = request.getParameter("url_pic");
String report_cnt = request.getParameter("report_cnt");
%>
	
<body>

	<section class="section">
	<div class="Container">
		<div class="leftdetail" >
			<div class ="titletext"><h3><%=title %></h3></div>
		
				<img width="550" height="238" src="<%=url_pic%>"></img>
			
		
		<div class= "div123"></div>
			
		<span class="wCg"><a href="det_frame1.jsp" target="contentFrame" onclick="wCgChange()" id="wACate1">펀딩정보</a></span>
		<span class="wCg"><a href="det_frame2.jsp" target="contentFrame" onclick="wCgChange()" id="wACate2">펀딩특징</a></span>
		<span class="wCg"><a href="det_frame3.jsp" target="contentFrame" onclick="wCgChange()" id="wACate2">펀딩부가정보</a></span>
		<span class="wCg"><a href="det_frame4.jsp" target="contentFrame" onclick="wCgChange()" id="wACate2">댓글문의</a></span><br>
			</div>
			
			
			<div id="wContent">
				<iframe scrolling =yes name="contentFrame" src="det_frame1.jsp"></iframe>
	
			</div> <br>
		
		</div>
		<div class="rightdetal" >
			<div class = "divtab"> </div>
				<div class="tablebox">
				<table class ="tab"> 
					<tr ><td>사진</td><td><img src="<%=url_pic%>" width = "50px" height = "30px"></img></td></tr>
					<tr><td>참여자수</td><td><%=attend %></td></tr>
					<tr><td>목표금액</td><td><%=goal_money%></td></tr>
					<tr><td>끝일</td><td><%=end_date %></td></tr>
					<tr><td>누적금액</td><td><%=accumulate_money%></td></tr>
			
					<tr class = "button"><td><button>장바구니</button><button>위시리스트</button></td></tr>		
				</table>
				
				<Table><tr><td><button>공유하기</button></td></tr></Table>	
				</div>
		
		
		
		
		
		</div>
			
				
	</div>
	
	</section>
	
	
	
</body>
<script type="text/javascript">
<%-- 
# 

--%>
<%

%>

</script>
</body>
</html>