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
}

.main-container {
	position:relative;
	width: 620px;
	height: 500px;
	margin:0 auto;
	border:1px solid black;
	border-radius:1px 1px 1px 1px;
}

div {
	padding:30px;
}

.member-stipulation div {
	border:1px solid #D8D9D7;
	padding:20px;
	margin:0 auto;
	text-align:center;
}

.member-stipulation form {
	padding:20px 5px 40px 5px;
}


</style>
</head>
<script src="<%=path%>/Projects/WANNAFIT/a01_setting/jquery-3.6.0.js" type="text/javascript"></script>
<script type="text/javascript">
	$(document).ready(function(){
		
	});
</script>
<body>

<section class="section">
	<div class="main-container">
		<div class="member-stipulation">
			<h3> 회원가입 </h3>
			<div>
				<p> 회원약관... </p>
			</div>
			<form>
				<input type="radio" name="isAgree" value="비동의" checked/>약관에 동의하지 않습니다
				<input type="radio" name="isAgree" value="동의"/>약관에 동의합니다
			</form>
			<div>
				<h3> 휴대폰 번호 인증</h3>
				<p> 원활한 서비스 제공을 위해 <br> 휴대폰 번호 인증이 필요합니다 </p>
				<input type="button" value="휴대폰 인증"/>
			</div>
		</div>
		
	</div>
		
</section>


</body>
</html>