//회원가입 입력검사

function inputCheck(){

	if(regForm.id.value == "") {

		alert("id를 입력하시오.");

		regForm.id.focus();

		return;

	} 

	

	if(regForm.pass.value == "") {

		alert("passwd를 입력하시오.");

		regForm.passwd.focus();

		return;

	}

	

	if(regForm.pass.value !== regForm.repass.value) {

		alert("비밀번호 불일치!");

		regForm.passwd.focus();

		return;

	} 

	// 이름, 이메일, 전화번호 - 정규표현식

	regForm.submit();

}

//regform id 중복확인

function checkid() {

	if(regForm.id.value == "") {

		alert("id를 입력하시오.");

		regForm.id.focus();

	} else {

		url = "check_id.jsp?id=" + regForm.id.value;

		window.open(

				url, 

				"id check", "toolbar=no, width=350, height=150, top=150, left=150");

	}

}


function memberModify() {

	if (regForm.id.value == "") {

		alert("id를 입력하시오.");

		regForm.id.focus();

		return;

	}



	if (regForm.pass.value == "") {

		alert("passwd를 입력하시오.");

		regForm.pass.focus();

		return;

	}



	if (regForm.pass.value !== regForm.repass.value) {

		alert("비밀번호 불일치!");

		regForm.pass.focus();

		return;

	}

	// 이름, 이메일, 전화번호 

	regForm.submit();

}
//회원정보 수정 취소

function memberModifyCancel(){

	location.href = "../index.jsp";

}

//회원정보 삭제

function memberDelete(id){

	var deletepass = prompt("비밀번호를 입력하세요");

	post_to_url("delete_member_form.jsp",{'id':id,'pass':deletepass});

}



//javascript에서 post방식으로 데이터 전송 (id/pw 확인용)

function post_to_url(path,params,method){

	method = method||"post";

	

  var form = document.createElement("form");

  form.setAttribute("method", method);

  form.setAttribute("action", path);



  //히든으로 값을 주입시킨다.

  for(var key in params) {

      var hiddenField = document.createElement("input");

      hiddenField.setAttribute("type", "hidden");

      hiddenField.setAttribute("name", key);

      hiddenField.setAttribute("value", params[key]);



      form.appendChild(hiddenField);

  }



  document.body.appendChild(form);

  form.submit();

}

