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
<style type="text/css">

.section {
	width:100%;
	height:100%;
	margin:0 auto;
}

.main-container {
	position:relative;
	width: 450px;
	height: 500px;
	margin:0 auto;
	border:1px solid black;
	border-radius:5px 5px 5px 5px;
}

.member-container {
	position:relative;
	top:40px;
	margin:0 auto;
	text-align:center;
	display:block;
}

.member-class {
	width:60px;
	height:30px;
	margin:0 auto;
	padding:5px;
	display:inline-block;
	font-size:14px;
}

.member-class:hover {
	width:60px;
	height:30px;
	margin:0 auto;
	padding:5px;
	display:inline-block;
	color:#A9BF9F;
	border-bottom:1px solid black;
}

.login-container {
	position:relative;
	top:40px;
	margin:0 auto;
	display:block;
}


#logon_form_table{
	margin:0 auto;
	border:1px solid #D8D9D7;
	padding:30px 50px 30px 50px;
	text-align:center;
}

#login-header{
	text-align:center;
	font-size:20px;
	height:40px;
	padding-bottom:20px;
}

#login-footer{
	height:40px;
	padding-top:10px;
	text-align:center;
	font-size:13px;
}

#btn_login {
	width:193px;
	height:40px;
}

[type=text] {
	width:185px;
	height:30px;
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
		<div class="member-container">
			<span class="member-class">회원</span>
			<span class="member-class">트레이너</span>
			<span class="member-class">헬스장</span>
			<span class="member-class">기업</span>
		</div>
		<div class="login-container">
			<form>
				<table id="logon_form_table">
					<tr>
						<td id="login-header"> 로그인 </td>
					</tr>
					<tr>
						<td><input type="text" name="user_id" value=""/></td>
					</tr>
					<tr><td><input type="text" name="user_pw" value=""/></td></tr>
					<tr><td><input type="submit" id="btn_login" value="로그인"/></td></tr>
					<tr><td id="login-footer">
						<a>비밀번호 찾기 </a>
						<a> 회원가입</a>
					</td></tr>
					<tr><td colspan="2" id="login-footer">
						<a>카톡 </a>
						<a> 네이버</a>
					</td></tr>
				</table>
			</form>
		</div>
	</div>
		
</section>


</body>
</html>