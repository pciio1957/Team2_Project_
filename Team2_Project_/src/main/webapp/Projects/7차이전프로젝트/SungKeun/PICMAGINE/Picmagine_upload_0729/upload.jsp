<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
	import="java.util.*"
	import="java.sql.*"
	import="SungKeun.PICMAGINE.Upload.UPLDAO"
	import="SungKeun.PICMAGINE.Upload.UPLDTO"
%>
<%

	request.setCharacterEncoding("utf-8");
	String path = request.getContextPath(); 
%>   
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title> PICMAGINE : UPLOAD </title>
<!-- <link rel="stylesheet" href="<%=path%>/a00_com/a00_com.css"> -->
<style type="text/css">
	
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
            
			.main-wrap {
			    width: 70%;
			    height: 100%;
			    background: var(--main-background-color);
			    margin-top: 40px;
			    margin-bottom: 60px;
			    margin-left: 300px;
			    margin-right: 500px;
			    padding: 35px 40px 40px 40px;
			    padding-top: 20px; 
			    padding-right: 20px;
			    padding-left: 20px;
			    padding-bottom: 20px;
			    box-shadow: 0px 1px 10px rgb(160 160 160 / 30%);
			}
	
			element.style {
			    text-align: center;
			    padding-top: 60px;
			}
			
			.input-file-button{
			  padding: 6px 25px;
			  background-color:skyblue;
			  border-radius: 4px;
			  color: white;
			  cursor: pointer;
			}	
	
</style>
</head>
<body>

	<%
		UPLDAO dao = new UPLDAO();
		ArrayList<UPLDTO> u = dao.uploadList();

		String artcategory = request.getParameter("artcategory");
		String arttitle = request.getParameter("arttitle");
		String artcontent = request.getParameter("artcontent");
		String artimgtitle = request.getParameter("artimgtitle");
		String tag = request.getParameter("tag");
			
		if(artcategory == null) artcategory = "";
		if(arttitle == null) arttitle = "";
		if(artcontent == null) artcontent = "";
		if(artimgtitle == null) artimgtitle = "";
		if(tag == null) tag = "";
		
		List<String> categorys = Arrays.asList("??????", "??????", "??????", "??????", "??????", "????????????", "?????????", "??????", "??????", "??????");
			
		// ??????
		// dao.Uploaded(new UPLDTO(artcategory, artimgtitle, arttitle, artcontent, tag));
	%>
	 
	<div class="main-wrap">
	<img onclick="main(this)" src="https://img.icons8.com/small/32/000000/delete-sign.png"/>
		<form name="uploadForm" action="uploaded.jsp" enctype="multipart/form-data">
		<!-- <form name="uploadForm" action="../uploaded.jsp" method="post" enctype="multipart/form-data"> -->
			<div class="input-box" align="center">
				<select name="artcategory" onchange="category(this)">
					<option> ???????????? ?????? </option>
					<%for(String cat : categorys){ %>
					<option ><%=cat %></option>
					<% } %>
				</select>
			</div>
			<div class="input-box">
				<!-- <h2 name="artcategory" style="text-align:center;"> ???????????? ?????? </h2> -->
			</div>
			<div class="input-box">
				<input type="text" name="arttitle" onkeyup="checkCapsLock(event)" placeholder="??????">
				<label for="arttitle"> ?????? </label>
			</div>
			<div class="input-box">
				<textarea type="text" name="artcontent" onkeyup="checkCapsLock(event)" style="resize:none; margin: 0px; width: 1305px; height: 467px;"></textarea>
			    <input type='file' id='artimgtitle' name='artimgtitle' accept='image/*, video/*' multiple/>
			</div>
			<div id="message"></div>
			<div class="input-box">
				<input type="text" name="tag" placeholder="??????"/>
				<label for="tag"> ?????? </label>
			</div>
				<input type="button" onclick="formChk(this)" value="??????" style="margin-top: 30px;">
				<input type="button" value="??????" id="cancel" onclick="main(this)" style="margin-top: 3px;">
		</form>
	</div>	 
	 
</body>
<script type="text/javascript">
	/*
	window.onload=function(){
		document.querySelector("h3").innerText="??????!!";
	};
	*/

	// ????????? ??????
	function main(obj) {
//		this.location.href = '../logout_main.html'; // (????????? ??????) ?????? ????????? ?????? (?????? ??????)
		this.location.href = 'logout_main.html'; // (????????? ??????) ?????? ????????? ??????
	}
	
	// ???????????? ????????? ??????
/* 	var artcategory = document.querySelector("[name=artcategory]");

	function category(obj) {
		artcategory.innerText = obj.value;
	} */
	
	// CapsLock ??????
	function checkCapsLock(event) {
	  if (event.getModifierState("CapsLock")) {
	    document.getElementById("message").innerText = "! Caps Lock??? ?????? ????????????.";
	    document.getElementById("message").style.color = "blue";
	  } else {
	    document.getElementById("message").innerText = "";
	  	}
	}

	var arttitle = document.querySelector("[name=arttitle]");
	var artcontent = document.querySelector("[name=artcontent]");
	var artimgtitle = document.querySelector("[name=artimgtitle]");
	var tag = document.querySelector("[name=tag]");

	// ????????? ?????? ??????
	function formChk(obj) {
		
		if(arttitle.value=="") {
			
			// ?????? ??? ?????????
			alert("????????? ???????????????.");
			arttitle.focus();
			
			return false;
			
		} else if(artcontent.value=="") {
			
			// ?????? ??? ?????????
			alert("????????? ???????????????.");
			artcontent.focus();
			
			return false;
			
		} else {
			
			alert("????????? ????????? ?????????????????????!");
			document.uploadForm.submit();
//			location.href='logout_main.html';
	   		submit.location.href='uploaded.jsp'; // [?????????] ???????????? ?????? ?????? (?????? ????????? ??????????????? logout_main.html??? ??????)
			
		}
	}	
	
</script>
</html>