<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    import = "jspexp.z01_database.*"
    import = "jspexp.z02_vo.*"
    import = "java.util.*"
    import ="PRO9.VO_FUN"  
    import = "PRO9.VO_FUN2"     
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


label { 
         display: block; 
         margin-top: 20px; 
         letter-spacing: 2px; 
     } 
     form { 
         margin: 0 auto; 
         width: 459px; 
     } 
     input, textarea { 
         width: 439px; 
         height: 27px; 
         background-color: #efefef; 
         border-radius: 6px; 
         border: 1px solid #dedede; 
         padding: 10px; 
         margin-top: 3px; 
         font-size: 0.9em; 
         color: #3a3a3a; 
     } 
         input:focus, textarea:focus{ 
             border: 1px solid #97d6eb; 
         } 
     
     textarea{ 
         height: 60px; 
         background-color: #efefef; 
     } 
     #submit{ 
         width: 127px; 
         height: 48px; 
         text-align: center; 
         border: none; 
         margin-top: 20px; 
         cursor: pointer; 
     } 
     #submit:hover{ 
         color: #fff; 
         background-color: #216282; 
         opacity: 0.9; 
     } 
     #cancel { 
         width: 127px; height: 48px; 
         text-align: center; 
         border: none; 
         margin-top: 20px; 
         cursor: pointer; 
     } 
     #cancel:hover{ 
         color: #fff; 
         background-color: #216282; 
         opacity: 0.9; 
     }

    .modal { 
         position: fixed; 
         left: 0; 
         top: 0; 
         width: 100%; 
         height: 100%; 
         background-color: rgba(0, 0, 0, 0.5); 
         opacity: 0; 
         visibility: hidden; 
         transform: scale(1.1); 
         transition: visibility 0s linear 0.25s, opacity 0.25s 0s, transform 0.25s; 
     } 
     .modal-content { 
         position: absolute; 
         top: 50%; 
         left: 50%; 
         transform: translate(-50%, -50%); 
         background-color: white; 
         padding: 1rem 1.5rem; 
         width: 500px; 
         height: 700px; 
         border-radius: 0.5rem; 
     } 
     .close-button { 
         float: right; 
         width: 1.5rem; 
         line-height: 1.5rem; 
         text-align: center; 
         cursor: pointer; 
         border-radius: 0.25rem; 
         background-color: lightgray; 
     } 
     .close-button:hover { 
         background-color: darkgray; 
     } 
     .show-modal { 
         opacity: 1; 
         visibility: visible; 
         transform: scale(1.0); 
         transition: visibility 0s linear 0s, opacity 0.25s 0s, transform 0.25s; 
     } 
     table{
      border-radius: 6px; 
         border: 1px solid #dedede; 
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
	//1. 버튼 입력 시 plus메서드 실행 
	
	// 입력과 동시에 이벤트로 요청값과 결과값을 서버에전달해서 처리..
	//2. input1, 2에 키보드 입력시 plus 실행 
	$("[name=support1],[name=support2]").keyup(plus);
	});

	//결론적으로 위의 2선택자 결과는 둘 다 plus 메서드 실행 

function plus(){
	var num01 = $("[name=support1]").val();
	var num02 = $("[name=support2]").val();
	var tot02 = num01 + num02;
	var snd = "?num01="+num01+"&num02="+num02+"&tot02="+tot02;
	
	
	//1.서버전달 객체 선언 
	var xhr = new XMLHttpRequest();
	//2.자원요청값 
	xhr.open("get","FUN_data_01.jsp"+snd,false);
	//3. 전달 
	xhr.send();
	//4. 결과값 div에 나타내기 
	$("#tot").html(xhr.responseText);
	
}




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
			<tr><td><span class="image blinking"> 후원금액입력 <<< </span><span > 개인정보입력 <<< </span><span > 약관동의 <<< </span></td></tr>
		</table>
	</div>
	
			<p id = "Info_font"> 후원정보 </p>
			<form id="frm01" method="post">
		<ul>
			<% for(VO_FUN f:fundinglist){ %>
			<li><p>선택한 프로젝트명 : <%=f.getTitle()%></li>
		
			<%} %>
			
			<li><p>후원금 선택: <select name="support1"><option>10000</option><option>20000</option><option>30000</option></select></li>
		
			<li><p>추가후원금입력:<input name = "support2" type = "text" value="0"/></p></li>
			
		</ul>
			</form>
		<div align ="center"><span>총 펀딩금액</span></div>
		<span id="tot"></span>
		<span></span>

<%

%>
	<div>&nbsp;</div>
	<div>&nbsp;</div>

	
	<p id = "Info_font"> 후원동의 </p>
		 	<form> 
             <table>
             <tr><td>
             <input type = "checkbox"/>알림설정동의
             </td></tr>
             <tr><td>
     		 <h6>펀딩 시작일 날짜에 사이트접속 시 알림을 받습니다.</h6> 
             </td></tr>
             </table>
             </form> 
             
             
             <form> 
             <table>
             <tr><td>
             <input type = "checkbox"/>후원공개여부동의
             </td></tr>
             <tr><td>
     		 <h6>해당 펀딩 후원내역에 이름과 금액이 공개됩니다.</h6> 
             </td></tr>
             </table>
             </form> 
             
	
	<div id="reserve">
  		<button class="trigger">다음으로</button>
  	</div>
  		
  	 <div class="modal"> 
         <div class="modal-content"> 
         	<form>
             <span class="close-button">&times;</span> 
             <h2 class="title">잠깐! 쇼핑과는 다른 워너핏 펀딩</h2>
             <h2>꼭 확인하고 펀딩하세요!</h2> 
             <table>
             <tr><td>
             <input type = "checkbox"/>바로결제되지않으며, 언제든지 취소할수있습니다.
             </td></tr>
             <tr><td>
             <h6>펀딩성공 종료 후 결제 예정일:</h6> 
             <h6>펀딩 취소 가능일:</h6>
             <h6>펀딩 종료 후 취소가 불가합니다.</h6>
             </td></tr>
             </table>
             </form> 
             
             
             <form> 
             <table>
             <tr><td>
             <input type = "checkbox"/>하자가 존재하거나 발송 지연된 경우 펀딩금 반환 신청 가능합ㄴ디ㅏ
             </td></tr>
             <tr><td>
     		<h6> 펀딩 후 리워드를 제작준비하는 특성상 품질이슈가 발생할 수 있으며 리워드는 즉시 배송되지 않고
     		 메이커가 약속한 발송시작일에 발송됩니다. 만일 수령한 리워드에 하자가 존재하거나 메이커가 약속한
     		 발송시작일에 발송이 이뤄지지않은경우 펀딩금 반환신청이 가능합니다.</h6> 
             </td></tr>
             </table>
             </form> 
             
             <form> 
             <table>
             <tr><td>
             <input type = "checkbox"/>단순 변심에 의한 펀딩금 반환한은 불가합니다.
             </td></tr>
             <tr><td>
     		<h6>펀딩은 전자상거래 법상 통신판매에 해당하지 않으므로 단순 변심에 의한
     		펀딩금 반환이 불가합니다.</h6>
             </td></tr>
             </table>
             </form> 
             
             <div id="reserve"> 
             <form action="FUN-UI-03-02.jsp" method="post">
            
  			<input type="submit" class="trigger" value ="다음으로"/>
  			</form>
  			</div>
             
         </div> 
     </div>

    <script type="text/javascript"> 
         var modal = document.querySelector(".modal"); 
         var trigger = document.querySelector(".trigger"); 
         var closeButton = document.querySelector(".close-button"); 
         var cancelButton = document.querySelector("#cancel");

        //console.log(modal);

        function toggleModal() { 
             modal.classList.toggle("show-modal"); 
         }

        function windowOnClick(event) { 
             if (event.target === modal) { 
                 toggleModal(); 
             } 
         }

        trigger.addEventListener("click", toggleModal); 
         closeButton.addEventListener("click", toggleModal); 
         cancel.addEventListener("click", toggleModal); 
         window.addEventListener("click", windowOnClick); 
     </script>

  		<jsp:useBean id="FUN2" class="PRO9.VO_FUN2" scope="session" />
  		<jsp:setProperty property="support_money" name="FUN2" param=""/>
 		

 		
  		
</section>
<p class = "p"></p>   	
	
</body>
</html>