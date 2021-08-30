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
	width:100%;
	height:100%;
	margin:0 auto;
}

.main-container {
	position:relative;
	width:350px;
	height:300px;
	padding:20px 20px 20px 50px;
	margin:0 auto;
	border:1px solid black;
	border-radius:5px 5px 5px 5px;
}

#phone-table td {
	height:40px;
}

#phone-table tr>td{
	width:100px;
}

#phone-footer {
	text-align:center;
	margin:0 auto;
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
		<h3>휴대폰 번호 인증</h3>
		<form>
			<table id="phone-table">
				<tr>
					<td>통신사</td>
					<td colspan="2"><select name="telecom">
							<option value="">통신사 선택</option>
							<option value="SK">SK</option>
							<option value="KT">KT</option>
							<option value="LG">LG</option>
					</select></td>
				</tr>
				<tr>
					<td>휴대폰번호</td>
					<td><input type="text" name="phone" value=""/></td>
					<td><input type="button" id="btnMit" value="전송"/></td>
				</tr>
				<tr>
					<td>인증번호</td>
					<td colspan="2"><input type="text" name="conNum" value=""/></td>
				</tr>
				<tr><td colspan="3" id="phone-footer">
					<input type="submit" id="btnOk" value="완료"/>
				</td></tr>
			</table>
		</form>
		
	</div>
		
</section>


</body>
</html>