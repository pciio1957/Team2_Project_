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

#reg-table {
	width:600px;
	border:1px solid black;
	padding:30px 30px 30px 40px;
}

#reg-table td{
	height:40px;
}

#reg-choice {
	padding-top:40px;
}


</style>
</head>
<script src="<%=path%>/Projects/WANNAFIT/a01_setting/jquery-3.6.0.js" type="text/javascript"></script>
<script type="text/javascript">
	
	// 중복확인
	function idCheck(id) { 
	    frm = $("[name=regfrm]");

	    if (id == "") { 
	        alert("아이디를 입력해 주세요.");
	        frm.id.focus();
	        return;
	    }
	    url = "idCheck.jsp?id=" + id;
	    window.open(url, "IDCheck", "width=300,height=150");
	}

	$(document).ready(function(){

		
	});
</script>
<body>

<section class="section">
    <div align="center">
        <form name="regfrm" method="post" action="memberProc.jsp">
        	<table id="reg-table">
        		<tr align="center">
        			<td colspan="2"><b>회원 가입</b></td>
        		</tr>
        		<tr>
         			<td width="30%">아이디</td>
        			<td width="60%"><input name="id" size="20"> 
        				<input type="button" value="중복확인" onClick="idCheck(this.form.id.value)"></td>
        		</tr>
        		<tr>
        			<td>비밀번호</td>
	        		<td><input type="password" name="pwd" size="20"></td>
        		</tr>
        		<tr>
        			<td>비밀번호 확인</td>
        			<td><input type="password" name="repwd" size="20"></td>
        		</tr>
        		<tr>
        			<td>닉네임</td>
        			<td><input name="nickname" size="20"></td>
        		</tr>
        		<tr>
        			<td>휴대폰번호</td>
        			<td>휴대폰인증 후 넘어오기</td>
        		</tr>
        		<tr>
        			<td>Email</td>
        			<td><input name="email" size="10"> @ <input name="email" size="10">
        				<select name="email-select">
	        				<option value="0" selected>이메일 선택</option>
	        				<option value="1">naver.com</option>
	        				<option value="2">hanmail.net</option>
	        				<option value="3">google.com</option>
	        				<option value="4">직접 입력</option>
	        			</select>
						
        			</td>
        		</tr>
        		<tr>
					<td>성별</td>
        			<td>남 <input type="radio" name="gender" value="1" checked> 
	        			여 <input type="radio" name="gender" value="2"></td>
        		</tr>
        		<tr>
	        		<td>주로 하는 운동</td>
        			<td>헬스 <input type="checkbox" name="interest" value="헬스">
        				런데이 <input type="checkbox" name="interest" value="런데이"> 
        				홈트레이닝 <input type="checkbox" name="interest" value="홈트레이닝"></td>
        		</tr>
        		<tr>
        			<td>연령대</td>
        			<td><select name="age">
        				<option value="0" selected>연령대 선택</option>
        				<option value="10">10대</option>
        				<option value="20">20대</option>
        				<option value="30">30대</option>
        				<option value="40">40대</option>
        				<option value="50">50대 이상</option>
        			</select></td>
        		</tr>
        		<tr>
        			<td>가입이유</td>
        			<td><select name="result">
        				<option value="0" selected>가입이유 선택</option>
        				<option value="다이어트">다이어트</option>
        				<option value="근력향상">근력향상</option>
        				<option value="자세교정">자세교정</option>
        				<option value="성장기어린이">성장기어린이</option>
        				<option value="기타">기타</option>
        			</select></td>
        		</tr>
        		<tr><td id="reg-choice" colspan="2" align="center" >
        			<input type="button" value="회원가입" onclick="inputCheck()"> &nbsp; &nbsp; 
        			<input type="reset" value="다시쓰기"> &nbsp; &nbsp; 
        			<input type="button" value="로그인" onClick="javascript:location.href='login.jsp'"></td>
        		</tr>
        	</table>
        </form>
    </div>
</section>
</body>
</html>