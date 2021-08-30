<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"
    import = "Project.a09_wannafit.Database.*"
    import = "Project.a09_wannafit.VO.*"
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
<!-- 
스타일시트 작성되면 올리기
<link rel="stylesheet" href="<%=path%>/Projects/WANNAFIT/a01_setting/a01_com.css">
-->

<!-- 섹션 위치 잡는 거 참고용!! -->
<style type="text/css">
.section {
	width:70%;
	height:100%;
	margin:0 auto;
	background:yellow;
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
<script src="<%=path%>/Projects/WANNAFIT/a01_setting/jquery-3.6.0.js" type="text/javascript"></script>
<script type="text/javascript">
	$(document).ready(function(){
		
		// 로그인창 확인용 
		$(".member-class").eq(0).click(function(){
			var login = window.open("UT001-Login.jsp", "get", "width = 500, height = 520");
			
		});
		
		$(".member-class").eq(1).click(function(){
			var confirm = window.open("UT003-Confirm.jsp", "get", "width = 450, height = 350");
		});
		
	});
</script>
<body>

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