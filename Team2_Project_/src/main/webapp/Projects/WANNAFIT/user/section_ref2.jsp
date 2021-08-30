<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"
    import = "java.util.*"
%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>  
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>  
<%

	request.setCharacterEncoding("utf-8");
	String path = request.getContextPath(); 
%>   
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title> Wanna-Fit, 나만의 핏을 찾아서 </title>
<link rel="stylesheet" href="<%=path%>/WANNAFIT/a01_setting/main_nav.css">


<!-- 섹션 위치 잡는 거 참고용!! -->
<style type="text/css">

.aside {
	width:25%;
	height:1000px;
	background:yellow;
	border-right:1px solid black;
}

.section {
	width:75%;
	height:100%;
	margin:0 auto;
	background:red;
}

.main-container {
	position:relative;
	width: 620px;
	height: 500px;
	margin:0 auto;
	border:1px solid black;
	border-radius:1px 1px 1px 1px;
}






</style>
</head>
<script src="<%=path%>/WANNAFIT/a01_setting/jquery-3.6.0.js" type="text/javascript"></script>
<script type="text/javascript">

	$(document).ready(function(){
		

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
<section class="section">
	<div class="main-container">
		<span class="member-class">로그인</span>
		<span class="member-class">휴대폰인증</span>
		<span class="member-class">헬스장</span>
		<span class="member-class">기업</span>
	</div>
		
</section>
</body>
</html>