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



$(document).ready(function(){
    $(".agree>a").click(function(){
        var submenu = $(this).next("ul");

        // submenu 가 화면상에 보일때는 위로 보드랍게 접고 아니면 아래로 보드랍게 펼치기
        if( submenu.is(":visible") ){
            submenu.slideUp();
        }else{
            submenu.slideDown();
        }
    }).mouseover(function(){
        $(this).next("ul").slideDown();
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

<section class ="sec01">
	<div>
		<table class ="tab01">
			<tr><td><span class="image blinking"> 후원금액입력 <<< </span><span > 개인정보입력 <<< </span><span > 승인 <<< </span></td></tr>
		</table>
	</div>
	<div>
			<p id = "Info_font"> 후원정보 </p>
		<ul>
			<% for(VO_FUN f:fundinglist){ %>
			<li><p>선택한 프로젝트명 : <%=f.getTitle()%></li>
		
			<%} %>
			
			<li><p>후원금 선택: <select><option>10000원</option><option>20000원</option><option>30000원</option></select></li>
		
			<li><p>추가후원금입력:<input type = "text" value="0"/></p></li>
			
			<li><p>총 펀딩금액: <input type = "text" value="0"/></p></li>
			
		</ul>
		<p id = "Info_font"> 서포터정보 </p>
			<table class = "user_Info">
			<tr><td>이름:</td><td></td></tr>
			<tr><td>이메일:</td><td></td></tr>
			<tr><td>휴대폰번호:</td><td></td></tr>
			</table>
	</div>
			<ul>
				<li><p>리워드주소: 
		<input id="member_post"  type="text" placeholder="우편번호" readonly onclick="findAddr()">
	    <input id="member_addr" type="text" placeholder="주소" readonly> <input type="text" placeholder="상세주소">
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
	
  		<p id = "Info_font"> 약관동의 </p>
  		
		
		<div>
    <ul>
        <li class="agree">
           <input type ="checkbox" name ="check"/> <a><img src="" alt="3자에 대한 제공 동의"/></a>
            <ul class="hide">
                <li>① 개인정보처리자는 개인정보의 처리 목적을 명확하게 하여야 하고 그 목적에 필요한 범위에서 최소한의 개인정보만을 적법하고 정당하게 수집하여야 한다.

② 개인정보처리자는 개인정보의 처리 목적에 필요한 범위에서 적합하게 개인정보를 처리하여야 하며, 그 목적 외의 용도로 활용하여서는 아니 된다.

③ 개인정보처리자는 개인정보의 처리 목적에 필요한 범위에서 개인정보의 정확성, 완전성 및 최신성이 보장되도록 하여야 한다.

④ 개인정보처리자는 개인정보의 처리 방법 및 종류 등에 따라 정보주체의 권리가 침해받을 가능성과 그 위험 정도를 고려하여 개인정보를 안전하게 관리하여야 한다.

⑤ 개인정보처리자는 개인정보 처리방침 등 개인정보의 처리에 관한 사항을 공개하여야 하며, 열람청구권 등 정보주체의 권리를 보장하여야 한다.

⑥ 개인정보처리자는 정보주체의 사생활 침해를 최소화하는 방법으로 개인정보를 처리하여야 한다.

⑦ 개인정보처리자는 개인정보를 익명 또는 가명으로 처리하여도 개인정보 수집목적을 달성할 수 있는 경우 익명처리가 가능한 경우에는 익명에 의하여, 익명처리로 목적을 달성할 수 없는 경우에는 가명에 의하여 처리될 수 있도록 하여야 한다.  <개정 2020. 2. 4.>

⑧ 개인정보처리자는 이 법 및 관계 법령에서 규정하고 있는 책임과 의무를 준수하고 실천함으로써 정보주체의 신뢰를 얻기 위하여 노력하여야 한다.</li>
               
            </ul>
        </li>
 
        <li class="agree">
            <input type ="checkbox" name ="check"/><a><img src="" alt="책임규정동의"/></a>
            <ul class="hide">
                <li>① 개인정보처리자는 개인정보의 처리 목적을 명확하게 하여야 하고 그 목적에 필요한 범위에서 최소한의 개인정보만을 적법하고 정당하게 수집하여야 한다.

② 개인정보처리자는 개인정보의 처리 목적에 필요한 범위에서 적합하게 개인정보를 처리하여야 하며, 그 목적 외의 용도로 활용하여서는 아니 된다.

③ 개인정보처리자는 개인정보의 처리 목적에 필요한 범위에서 개인정보의 정확성, 완전성 및 최신성이 보장되도록 하여야 한다.

④ 개인정보처리자는 개인정보의 처리 방법 및 종류 등에 따라 정보주체의 권리가 침해받을 가능성과 그 위험 정도를 고려하여 개인정보를 안전하게 관리하여야 한다.

⑤ 개인정보처리자는 개인정보 처리방침 등 개인정보의 처리에 관한 사항을 공개하여야 하며, 열람청구권 등 정보주체의 권리를 보장하여야 한다.

⑥ 개인정보처리자는 정보주체의 사생활 침해를 최소화하는 방법으로 개인정보를 처리하여야 한다.

⑦ 개인정보처리자는 개인정보를 익명 또는 가명으로 처리하여도 개인정보 수집목적을 달성할 수 있는 경우 익명처리가 가능한 경우에는 익명에 의하여, 익명처리로 목적을 달성할 수 없는 경우에는 가명에 의하여 처리될 수 있도록 하여야 한다.  <개정 2020. 2. 4.>

⑧ 개인정보처리자는 이 법 및 관계 법령에서 규정하고 있는 책임과 의무를 준수하고 실천함으로써 정보주체의 신뢰를 얻기 위하여 노력하여야 한다.</li>
               
            </ul>
        </li>
    </ul>
</div>

	
		
		
		
  		<div id="reserve">
  		<button id = "reserve_Btn">예약하기</button>
  		</div>
  		
  		
  		
</section>
<p class = "p"></p>   	
	
</body>
</html>