<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
	import="java.util.*"
	import="java.sql.*"
	import="SungKeun.PICMAGINE.Join.JOINDAO"
	import="SungKeun.PICMAGINE.Join.JOINDTO"
%>
<%

	request.setCharacterEncoding("utf-8");
	String path = request.getContextPath(); 
%>   
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title> PICMAGINE : 회원가입 </title>
<%-- <link rel="stylesheet" href="<%=path%>/a00_com/a00_com.css"> --%>
<style>
	
			@import url('https://fonts.googleapis.com/css2?family=Nanum+Gothic&display=swap');
			
			html, body {
				font-family: 'Nanum Gothic', sans-serif;
				margin:0px; padding:0px;
				height:100%;
			}

           header{
                display:flex;
                justify-content: center;
            }
            form{
                padding:10px;
            }
            .input-box{
                position:relative;
                margin:10px 0;
            }
            .input-box > input{
                background:transparent;
                border:none;
                border-bottom: solid 1px #ccc;
                padding:20px 0px 5px 0px;
                font-size:14pt;
                width:100%;
            }
            input::placeholder{
                color:transparent;
            }
            input:placeholder-shown + label{
                color:#aaa;
                font-size:14pt;
                top:15px;

            }
            input:focus + label, label{
                color:#8aa1a1;
                font-size:10pt;
                pointer-events: none;
                position: absolute;
                left:0px;
                top:0px;
                transition: all 0.2s ease ;
                -webkit-transition: all 0.2s ease;
                -moz-transition: all 0.2s ease;
                -o-transition: all 0.2s ease;
            }

            input:focus, input:not(:placeholder-shown){
                border-bottom: solid 1px #8aa1a1;
                outline:none;
            }
            
           input[type=button]{
                background-color: #8aa1a1;
                border:none;
                color:white;
                border-radius: 5px;
                width:100%;
                height:35px;
                font-size: 14pt;
                margin-top:100px;
            }
            
            input[type=submit]{
                background-color: #8aa1a1;
                border:none;
                color:white;
                border-radius: 5px;
                width:100%;
                height:35px;
                font-size: 14pt;
                margin-top:100px;
            }
            #forgot{
                text-align: right;
                font-size:12pt;
                color:rgb(164, 164, 164);
                margin:10px 0px;
            }
			.main-wrap {
			    width: 330px;
			    height: 90%;
			    background: var(--main-background-color);
			    margin-left: 37%;
			    padding: 35px 40px 40px 40px;
			    box-shadow: 0px 1px 10px rgb(160 160 160 / 30%);
			}
	
			element.style {
			    text-align: center;
			    padding-top: 60px;
			}
	
</style>
</head>
<body>

	<%
		JOINDAO dao = new JOINDAO();
	
		String memid = request.getParameter("memid");
		String mempw = request.getParameter("mempw");
		String memtel = request.getParameter("memtel");
		String mememail = request.getParameter("mememail");
		
		if(memid == null) memid = ""; 
		if(mempw == null) mempw = ""; 
		if(memtel == null) memtel = ""; 
		if(mememail == null) mememail = "";
	%>

	<!-- 로그인 / 회원가입 폼 -->
	<div class="main-wrap" style="margin-top: 60px;">
		<img onclick="login(this)" src="https://img.icons8.com/small/32/000000/delete-sign.png"/>
		<header>
		<div style="text-align : center; padding-top: 60px;">
			<img style="width:100%" src="image/logo.png" alt="picmagine">
		</div>
		</header>
		
		<div align="center">
			<h3> 회원가입 <h3>
		</div>
		
		<form name="joinForm" action="joined.jsp"> <!-- 회원정보 등록 페이지 이동 -->
			<!-- 
			<div class="input-box">
				<input id="name" type="text" name="name" onkeyup="checkCapsLock(event)" minlength="2" maxlength="5" placeholder="이름"/>
				<label for="name" id="nameChk"> 이름 (2-5자) </label>
			</div>
			 -->
			
			<div class="input-box">
				<input id="memid" type="text" name="memid" onkeyup="checkCapsLock(event)" placeholder="아이디"/>
				<label for="memid" id="idChk"> ID </label>
				<div class="idMsg"></div>
				<input type="button" value="중복 확인" onclick="ckDupl()" style="margin-top: 0px; padding-top: 0px;"/>
			</div>
			
			<div class="input-box">
				<input type="password" id="mempw" name="mempw" onkeyup="checkCapsLock(event)" placeholder="비밀번호"/>
				<label for="userPw"> PW </label>
				<div class="pwMsg"></div>
			</div>
			
			<div class="input-box">
				<input type="password" id="userPwChk" name="userPwChk" onkeyup="checkCapsLock(event)" placeholder="비밀번호 확인"/>
				<label for="userPwChk" id="chkNoitce"> PW Confirm </label>
			</div>
			
			<div class="input-box">
				<input type="text" name="memtel" id="memtel" maxlength="13" placeholder="핸드폰"/>
				<label for="memtel"> Tel </label>
			</div>
			
			<div class="input-box">
				<input id="mememail" type="text" name="mememail" onkeyup="checkCapsLock(event)" placeholder="이메일"/>
				<label for="mememail" id="emailChk"> Email </label>
				<div id="message"></div>
			</div>
			
			<div class="input-box">
				<textarea style="resize:none; margin: 0px 8.03977px 0px 0px; width: 303px; height: 106px;" readonly>
					사이트가 취급하는 모든 개인정보는 관련법령에 근거하거나 정보주체의 동의에 의하여 수집ㆍ보유 및 처리되고 있습니다.
					「개인정보보호법률」은 이러한 개인정보의 취급에 대한 일반적 규범을 제시하고 있으며, 사이트는 이러한 법령의 규정에 따라 개인정보의 처리목적에 필요한 최소한의 개인정보를 수집ㆍ보유 및 처리하는 개인정보를 공공업무의 적절한 수행과 국민의 권익을 보호하기 위해 적법하고 적정하게 취급할 것입니다.
					또한, 사이트는 관련 법령에서 규정한 바에 따라 사이트에서 보유하고 있는 개인정보에 대한 열람청구권 및 정정청구권 등 이용자 여러분의 권익을 존중하며, 이용자 여러분은 이러한 법령상 권익의 침해 등에 대하여 법률이 정하는 바에 따라 정보주체의 권익을 보호 받을 수 있습니다.
					사이트의 개인정보처리방침은 사이트가 운영하는 여러 홈페이지에서 이용자 여러분의 개인정보를 보호하기 위한 [홈페이지 이용자의 개인정보보호]와 소관업무를 수행하는데 필요한 개인정보 취급에 관한 [컴퓨터에 의해 처리되는 개인정보보호] 두 가지로 구성되어 있습니다.
					위와 같이 자동 수집ㆍ저장되는 정보는 이용자 여러분에게 보다 나은 서비스를 제공하기 위해 홈페이지의 개선과 보완을 위한 통계분석, 이용자와 홈페이지 간의 원활한 의사소통, 보안 침해 대응 등을 위해 이용될 수 있으며, 이러한 정보는 관계법령의 규정에 따라 제출될 수 있음을 유념하시기 바랍니다.
					사이트가 운영하는 홈페이지에서 이메일 주소 등 식별할 수 있는 개인정보를 취득하여서는 아니 됩니다. 적법하지 아니한 방법으로 이러한 개인정보를 열람 또는 제공받은 자는 [개인정보보호법률]에 의하여 처벌을 받을 수 있습니다.
				</textarea>
				<span style="font-size:10px;">
					개인정보 취급 방침에 동의하십니까?
					<input type="radio" onclick="chk()" name="agree" checked/> 동의
					<input type="radio" onclick="chk()" name="agree"/> 미동의
					<div class="agreement"></div>
				</span>
			</div>
			
			<div align="center" class="input-box">
				<input type="button" value="회원가입" onclick="formChk(this)" style="margin-top: 0px;padding-top: 0px;width: 100px;"/>
				<input type="button" value="취소" onclick="login(this)" style="margin-top: 0px;padding-top: 0px;width: 100px;"/>
			</div>
			
		</form>
		
	</div>
	
</body>
<script type="text/javascript">

	var idReg = /^[a-zA-Z0-9]{6,12}$/;
	var pwReg = /^[a-zA-Z0-9]{6,14}$/;
//	var name = document.querySelector("[name=name]");
	var id = document.querySelector("[name=memid]");
	var idChk = document.querySelector("#idChk");
	var idMsg = document.querySelector(".idMsg");
	var pw = document.querySelector("[name=mempw]");
	var pwMsg = document.querySelector(".pwMsg");
	var pwChk = document.querySelector("[name=userPwChk]");
	var pwChkMsg = document.querySelector("#chkNoitce");
	var email = document.querySelector("[name=mememail]");
//	var emailChk = document.querySelector("#emailChk");
	var phone = document.querySelector("[name=memtel]");
	var agree = document.querySelector("[name=agree]");
	var agreement = document.querySelector(".agreement");

	/*
	// 이름 길이 제한
	name.onkeyup = function() {
		var namelen = name.length;
		if(namelen < 1 || namelen > 6) {
			nameChk.style.backgroundColor="white";
			nameChk.style.color="red";	
		} else {
			nameChk.style.backgroundColor="skyblue";
			nameChk.style.color="white";
		}
	}
	*/
	
	// ID 정규식 표현 활용 형식 지정
	id.onkeyup = function() {
		if(!idReg.test(id.value)) {
			idMsg.innerText = "* ID는 영문자 및 숫자를 포함하여 6-12자로 입력하세요. *";
			idMsg.style.color="red";
			idMsg.style.fontSize="12px";
		} else {
			idMsg.innerText = "";
			return true;
		}
	}
	
	// ID 유효성 체크
	function ckDupl() {
		var idVal = document.querySelector("[name=memid]").value;
		
		if(idVal != "") {
			if(!idReg.test(id.value)) {
				alert("ID 형식에 맞지 않습니다. (ID 형식 : 영문자 및 숫자 포함하여 6-12자)");
			} else {
				// goodjob이 DB에 있으면 중복으로 판단
				if(idVal == "goodjob") {
					alert("등록된 ID가 있습니다.");
				} else {
					alert("해당 ID는 등록 가능합니다.");
					idChk.style.backgroundColor="skyblue";
					idChk.style.color="white";
				}
			}
		} else {
			alert("ID를 입력하세요.");
		}
	}
	
	// PW 유효성 체크
	pw.onkeyup = function() {
		if(!pwReg.test(pw.value)){
			pwMsg.innerText = "* PW는 6-14자로 입력하세요. *";
			pwMsg.style.color="red";
			pwMsg.style.fontSize="12px";
		} else {
			pwMsg.innerText="";
		}
	}
	
	pwChk.onkeyup = function() {
		if(pwChk.value!=pw.value) {
			pwChkMsg.style.backgroundColor="white";
			pwChkMsg.style.color="red";
			//pwChkMsg.style.fontSize="12px";
		} else {
			pwChkMsg.style.backgroundColor="skyblue";
			pwChkMsg.style.color="white";
			//pwChkMsg.style.fontSize="12px";
		}
	}
	
	// 휴대폰 번호 자동 하이픈
	var autoHypenPhone = function(str) {
	      str = str.replace(/[^0-9]/g, '');
	      var tmp = '';
	      if( str.length < 4) {
	          return str;
	      } else if(str.length < 7) {
	          tmp += str.substr(0, 3);
	          tmp += '-';
	          tmp += str.substr(3);
	          return tmp;
	      } else if(str.length < 11) {
	          tmp += str.substr(0, 3);
	          tmp += '-';
	          tmp += str.substr(3, 3);
	          tmp += '-';
	          tmp += str.substr(6);
	          return tmp;
	      } else {              
	          tmp += str.substr(0, 3);
	          tmp += '-';
	          tmp += str.substr(3, 4);
	          tmp += '-';
	          tmp += str.substr(7);
	          return tmp;
	      }
	      
	      return str;
	}
		
	var phoneNum = document.getElementById('memtel');
	
	phoneNum.onkeyup = function(){
	  console.log(this.value);
	  this.value = autoHypenPhone( this.value );
	}
	
	/*
	// 이메일 유효성 체크
	email.onkeyup = function () {
		//alert(document.getElementById("email").value);

		var exptext = /^[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*.[a-zA-Z]{2,3}$/i;
		if(exptext.test(email) == false) {
			// 이메일 형식이 알파벳+숫자 @ 알파벳+숫자.알파벳+숫자 형식이 아닐 경우
			emailChk.style.color="red";
			emailChk.style.fontSize="12px";
			
			return false;
			
		} else if(exptext.test(email) == true) {
			emailChk.style.backgroundColor="skyblue";
			emailChk.style.color="white";
			
			return true;
			
		} else {
			console.log ("이메일 형식이 올바르지 않습니다.");			
		}
			
	}
	*/
	
	// CapsLock 여부
	function checkCapsLock(event) {
	  if (event.getModifierState("CapsLock")) {
	    document.getElementById("message").innerText = "! Caps Lock이 켜져 있습니다.";
	    document.getElementById("message").style.color = "blue";
	  } else {
	    document.getElementById("message").innerText = "";
	  	}
	}
	
	// 회원가입 등록 여부 체크
	function formChk(obj){
		
		if(name.value == "") {
			
			// 이름 미 입력시
			alert("이름을 입력하세요.");
			name.focus();
			
			return false;
			
		} else if(id.value == "") {
			
			// ID 미 입력시			
			alert("ID를 입력하세요.");
			id.focus();
			
			return false;
			
		} else if(pw.value == "") {
			
			// PW 미 입력시			
			alert("PW를 입력하세요.");
			pw.focus();
			
			return false;
			
		} else if(pwChk.value == "") {
			
			// PW Confirm 미 입력시			
			alert("PW Confirm을 입력하세요.");
			pwChk.focus();
			
			return false;
			
		} else if(pw.value != pwChk.value) {
			
			// PW와 PW Confirm이 일치하지 않을시
			alert("PW와 PW Confirm이 서로 일치하지 않습니다. 다시 입력하세요.");
			pw.focus();
			
			return false;

		} else if(phone.value == "") {
			
			// Tel 미 입력시			
			alert("휴대폰 번호를 입력하세요.");
			phone.focus();
			
			return false;
			
		} else if(email.value == "") {
			
			// Email 미 입력시
			alert("이메일을 입력하세요.");
			email.focus();
			
			return false;
			
		} else {
			
			// 정보 입력 후 회원가입 완료시
			alert(memid.value + " 님의 회원가입이 완료되었습니다!");
			document.joinForm.submit();
			submit.location.href='joined.jsp'; // [관리자] 화면으로 임시 설정 (실제 사용자 화면에서는 login.jsp로 이동)
//    		location.href='login.jsp';
    		
		}
	}
	
	// '취소' 버튼 클릭 시 로그인 페이지 이동
	function login(obj) {
		location.href = 'login.jsp';
	}

</script>
</html>