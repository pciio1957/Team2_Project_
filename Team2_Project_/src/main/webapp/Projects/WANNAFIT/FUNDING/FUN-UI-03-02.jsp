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

<style>

.sec01 {
width:70%;
margin: 0 auto;

}
.tab01 {
font-size:20px;
font-weight:bold;
text-align: center;
align:center;
background:#A9BF9F;
margin : 10px 10px 10px 10px;
width:100%;
border: 1px solid #D9B68B; 
background-color: #D9B68B; 
border-radius: 16px;
box-shadow: inset 0 0 8px #deb13a;
height:90%;
}

.user_Info {
background: #D8D9D7;
width:80%;
margin-left:20px;
}

#Info_font {
font-size : 20px;
margin-left:20px;
font-weight: bold;
}

#reserve_Btn {
background:#D9B68B;
width:100px;
}

#reserve {
align:center;
text-align:center;
float:center;
}

.blinking{
 -webkit-animation:blink 1.5s ease-in-out infinite alternate; 
-moz-animation:blink 1.5s ease-in-out infinite alternate; 
animation:blink 1.5s ease-in-out infinite alternate; 
color:white;
} 

@-webkit-keyframes blink{ 
0% {opacity:0;
} 100% {opacity:1;
} 
} 

@-moz-keyframes blink{ 0% {opacity:0;} 100% {opacity:1;} } @keyframes blink{ 0% {opacity:0;} 100% {opacity:1;} }




 .agree a{cursor:pointer;}
 .agree .hide{display:none;}

.card_num {
width:30px;
}

</style>
<script src="<%=path%>/a00_com/jquery-3.6.0.js" type="text/javascript"></script>
<link rel="stylesheet" type ="text/css" href="main_nav.css"/>
<script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
<script type="text/javascript">

function findAddr(){
	new daum.Postcode({
        oncomplete: function(data) {	
        	console.log(data);
        	
            // 팝업에서 검색결과 항목을 클릭했을때 실행할 코드를 작성하는 부분.
            // 도로명 주소의 노출 규칙에 따라 주소를 표시한다.
            // 내려오는 변수가 값이 없는 경우엔 공백('')값을 가지므로, 이를 참고하여 분기 한다.
            var roadAddr = data.roadAddress; // 도로명 주소 변수
            var jibunAddr = data.jibunAddress; // 지번 주소 변수
            // 우편번호와 주소 정보를 해당 필드에 넣는다.
            document.getElementById('member_post').value = data.zonecode;
            if(roadAddr !== ''){
                document.getElementById("member_addr").value = roadAddr;
            } 
            else if(jibunAddr !== ''){
                document.getElementById("member_addr").value = jibunAddr;
            }
        }
    }).open();
}

</script>
<script type="text/javascript">

  
$(document).ready(function() {
	
	 $("#reserve_btn").click(function() {
	    	alert("다음페이지로이동");
	    	location.href="FUN-UI-03-03.jsp";
	    });
	 
	 
	$(".card_num").click(function() {
	var adress[] = $("[name=add1]").val();
	var adress[] = $("[name=add2]").val();
	var adress[] = $("[name=add3]").val();
	console.log(adress);
	});
});


</script>
</head>
<%-- 
# 

--%>
<%
String codeS = request.getParameter("code");


if(codeS ==null) codeS = "";

A05_PreparedDao dao = new A05_PreparedDao();
ArrayList<VO_FUN> fundinglist = dao.getfundinglist(codeS);

%>
<body>

	<nav class="navbar">
    <div class="nav-wrapper">
      <ul class="logo">
        <li><a href="FUN-UI-01.jsp">WANNAFIT</a></li>  
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

<section class ="sec01">
	<Form action = "FUN-UI-03-03.jsp" method ="post">
	<div>
		<table class ="tab01">
			<tr><td><span > 후원금액입력 <<< </span><span class="image blinking" > 개인정보입력 <<< </span><span > 약관동의 <<< </span></td></tr>
		</table>
	</div>
	<jsp:useBean id="FUN2" class="PRO9.VO_FUN2" scope="session" />
	<B>이름: </B> <%=FUN2.getSupport_money()%><br>
	
	
		<p id = "Info_font"> 서포터정보 </p>
			<table class = "user_Info">
			<tr><td>이름:</td><td></td></tr>
			<tr><td>이메일:</td><td></td></tr>
			<tr><td>휴대폰번호:</td><td></td></tr>
			</table>
	
			<ul>
				<li><p>리워드주소: 
		<input name = "add1" id="member_post"  type="text" placeholder="우편번호" readonly onclick="findAddr()">
	    <input name = "add2"id="member_addr" type="text" placeholder="주소" readonly> <input name = "add3" type="text" placeholder="상세주소">
  		</p></li></ul>
  		
  		
  		<p id = "Info_font"> 결제정보 </p>
  		
  		<ul>
		
			
			<li><p>카드번호: 	&nbsp;	&nbsp;<input class ="card_num" type = "text" value="0"/>
			<input class ="card_num" type = "text" value="0"/>
			<input class ="card_num" type = "text" value="0"/>
			<input class ="card_num"type = "text" value="0"/></p></li>
		
			<li><p>유효기간: 	&nbsp;	&nbsp;
			<select>
				<option>MM</option>
			<%for(int i =1; i<=12; i++) {  %>
				<option><%=i %></option>
			<%} %>
			
			</select>
			
			<select>
			<option>YY</option>
			<%for(int i=1900; i<=2021; i++){ %>
				<option><%=i %></option>
			<%} %>
			</select>
			
						
			<li><p>생년월일: 	&nbsp;	&nbsp;
			<select>
			<%for(int i=1900; i<=2021; i++){ %>
				<option><%=i %></option>
			<%} %>
			</select>
			
			<select>
			<%for(int i =1; i<=12; i++) {  %>
				<option><%=i %></option>
			<%} %>
			</select>
			
			<select>
			<%for(int i=1; i<=31; i++) {%>
				<option><%=i %></option>
			<%} %>
			</select>
			
			
			</p></li>
			
			<li><p>할부기간: 	&nbsp;	&nbsp;
			<select>
			<%for(int i=1; i<=24; i++) {%>
				<option><%=i%>개월</option>
			<%} %>
			<option>일시불</option>
			</select></p></li>
			
		</ul>
	
  	
		


		
		
		
  		<div id="reserve">
  		<input type ="submit" id = "reserve_btn" onclick ="function()" value = "다음으로 <<"/>
  		</div>
  		</Form>
  		
  		
</section>
<p class = "p"></p>   	
	
</body>
</html>