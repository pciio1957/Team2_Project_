<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
@import url('https://fonts.googleapis.com/css2?family=Nanum+Gothic&display=swap');

a {
	text-decoration:none;
	color:skyblue;
	font-weight: bold;  
}

a:hover {
	color:white;
}

/* 시멘틱 : CSS 적용부분 */
html, body {
	font-family: 'Nanum Gothic', sans-serif;
	margin:0 auto; padding:0px;
	height:100%;
}

.header{
	font-family: 'Nanum Gothic', sans-serif;
	width:100%; height:10%; 
	background:skyblue;
	margin:0px; padding:0px;
}

.footer {
	font-family: 'Nanum Gothic', sans-serif;
	width:100%; height:10%; clear:both;
	text-align:center;
	color:skyblue;
}

/* 헤더 : 사용자기능 */
.wTitle {
	float:left;
	display:block;
	margin-left:20%;
	font-weight: bold;
	color:RGB(253, 223, 225);
}

.wMempart {
	font-family: "Nanum Gothic", Dotum, Arial; 
	padding:10px; 
	text-decoration:none;	
	font-size: 12px;                          
    font-weight: bold; 
    color:white;	
    
}

.wMempart:hover {
    color: skyblue;                   
    background-color: #4d4d4d;   
    padding:10px;
}

#wMemSapn {
	float:right;
	margin-right:25%;
}


/* 네비 : 메뉴 네비게이션 */
#topMenu {
 	width:100%; height: 30px;
	background-color: skyblue;  
}

#topMenuBlock {
	margin-left:10%;
}
 
 /*메뉴 전체 크기*/
#topMenu ul li {  
  	 list-style: none;           
     color: white;               
     background-color: skyblue;  
     float: left;                
     line-height: 30px;          
     vertical-align: middle;    
     text-align: center;         
}
 
#topMenu ul {
  	margin:0px;
}
 
 
 /*메뉴 한 칸*/
#topMenu .menuLink {                              
    text-decoration:none;                     
    color: white;                              
    display: block;                            
    width: 120px;                              
    font-size: 12px;                          
    font-weight: bold;                         
    font-family: "Nanum Gothic", Dotum, Arial; 
}


#topMenu .menuLink:hover {           
    color: skyblue;                   
    background-color: #4d4d4d;    
}
 * {margin: 0px; padding : 0px; box-sizing: border-box;}
 
 .wrap{width : 900px; 
 margin-left:280;}
 
html, body {
	font-family: 'Nanum Gothic', sans-serif;
	margin:0px; padding:0px;
	height:100%;
}
.header{
	font-family: 'Nanum Gothic', sans-serif;
	width:100%; height:15%; 
	background:skyblue;
}
.member {
	float:right;
	margin-right:30px;
	margin-top:10px;
}
.aMember {
	text-decoration:none;
	color:white;
}
  section {
            	width: 1600px; background-color: #F1F4F8; 
            	padding: 30px; overflow: hidden;}
            	
            			
			table.detailSearch { 
				box-sizing: border-box; font-family: 'Noto Sans KR', sans-serif; background-color: #ffffff; 
				border: 1px solid #EAEAEA; height: 200px; text-align: center;}
			table.detailSearch .title th { 
				font-size: 15px; width: 800px ; background-color : #F6F6F6; height: 50px;}
			table.detailSearch .value td { 
				 width: 800px}
			#result {color: #0563af; font-size: 13px;}
			
            table.detailSearch input[type=button] {
				width:40px; height:23px; 
				line-height:20px; border:1px #EAEAEA solid;; 
				margin:3px auto; background-color:#EAEAEA; text-align:center; border-radius: 2px;
				cursor: pointer; color:#F1F4F8; transition:all 0.9s, color 0.3; color:#0563af;
            }
            
            
	
            section {
            	width: 1519px; background-color: #F1F4F8; 
            	padding: 30px; overflow: hidden;}

           section article {
                width: 100%;
                height: 120%;
                background-color: #ffffff;
                padding: 25px;
				border: 1px solid #EAEAEA;
            }
            section article div {
                width: 25%;
                height: 250px;
                padding: 25px;
                float: left;
                text-align: center;
                border-bottom: 3px solid #dadada;
                border-radius: 25px;
            }
            section article div img{
                width: 200px;
                height: 100px;
            }
            section article div p {
                padding: 10px;
                font-size: 13px;
            }
	input {
    width: 100%;
    border-radius: 20px;
    border: 1px solid #bbb;
    margin: 10px 0;
    padding: 10px 12px;
    font-family: fontAwesome;
}



.search {
    position: relative;
    text-align: center;
    width: 400px;
    margin: 0 auto;
}

.searchbox{
  width: 30%;
   margin-left:200px ;
   margin-right:150px;
}


#value:focus{
  outline: none;
  margin:400px 300px 10px 10px;
}



 
</style>
</head>
<body>

<body>	
		<header class="header"> 
		<h2 class="wTitle"> Picmagine </h2>
		<span id="wMemSapn">
			<a class="wMempart" href="login.html">로그인</a>
			<a class="wMempart" href="join.html">회원가입</a>
		</span>
	</header>
	<nav id="topMenu"> 
		<div id="topMenuBlock">
			<ul>
				<li><a class="menuLink" href="#">HOME</a></li>
				<li><a class="menuLink" href="#">배경화면</a></li>
				<li><a class="menuLink" href="#">사이트 소개</a></li>
			</ul>
		</div>
  	</nav>
<section>


 <div class="searchbox">
      <div class="heade1">
 
        <input onkeyup="filter()" type="text" id="value" placeholder="${param.name}">
      </div>



            <div class="wrap">
    <h1>태그 검색</h1> 	
    <h2>검색어:${param.name}</h2>
<input type="button" class="box" value="검색어:${param.name}">
		



			<br>
            <table class="detailSearch">
                    <tr class="title">
                        <th>종류</th>
                        <th>분야</th>
                        <th>기간</th>
                        <th>배경화면</th>
                      
                    </tr>
                    
                    <tr class="value">
                        <td><div class="box">
						  <select onchange="result(this)" name="artcase">
						    <option>선택</option>
						    <option>사람</option>
						    <option>삽화</option>
						    <option>스토리</option>
						  </select>
						</div></td>
						
						
						
                        <td><div class="box">
						  <select onchange="result1(this)" name="categry">
						    <option>사진</option>
						    <option>일러스트</option>
						    <option>디자인</option>
						    <option>사운드</option>
						    <option>캘리그라피</option>
						  </select>
						</div></td>
						
						
						
                        <td><div class="box">
						  <select onchange="result2(this)" name="date">
						  	<option>선택</option>
						    <option>1일</option>
						    <option>일주일</option>
						    <option>한달</option>
						    <option>이외</option>
						  </select>
						</div></td>
						
						  <td><div class="box">
						  <select onchange="result3(this)" name="case">
						  	<option>선택</option>
						    <option>배경화면</option>
						    <option>판매작품</option>
						    </select>
						</div></td>
						
					  </tr> 
                    
                    <!-- 결과 들어갈 부분 -->   
                    <tr>
                    	
                   	 	
                   	 	<table id="result">
                   	 	<tr id="show"> </tr>

                   	 	</table>
                    	<br>
                    	</td>
                    </tr>
                    <tr>
                    	<td colspan="5"><input type="button" name="search" value="검색"></td></td>
                    
                    	<
                    </tr>
			</table>
          	<br>

<article>
                    <div onclick="location.href='상세페이지.html'" style="cursor:pointer">
                        <a hred="#">
                            <img src="제주여행.jpg">
                            <h3>heyjinss</h3>
                            <p>제주여행일기</p>
                            <span>#비행</span>
                        </a>
                    </div>
                    
                        <div onclick="location.href='상세페이지.html'" style="cursor:pointer">
                        <a hred="#">
                            <img src="작가대표이미지.JPG">
                            <h3>flyyy</h3>
                            <p>아트로 일상 꾸미기</p>
                            <span>#비행</span>
                        </a>
                    </div>
                    
                     <div onclick="location.href='상세페이지.html'" style="cursor:pointer">
                        <a hred="#">
                            <img src="검색이미지.JPG">
                            <h3>arrrt12</h3>
                            <p>제주여행일기</p>
                            <span>#비행</span>
                            <span>조회수</span><span>댓글</span>
                        </a>
                    </div>
                    
                    
                    <div onclick="location.href='../상세페이지.html'" style="cursor:pointer">
                        <a hred="#">
                            <img src="검색이미지2.JPG">
                            <h3>cherryis</h3>
                            <p>제주여행일기</p>
                            <span>#비행</span>
                        </a>
                     </div>   
                      
                        
                        
                </article>


        </section>


</body>
<script  type = "text/javascript">
function filter(){

    var value, name, item, i;

    value = document.getElementById("value").value.toUpperCase();
    item = document.getElementsByClassName("item");

    for(i=0;i<item.length;i++){
      name = item[i].getElementsByClassName("name");
      if(name[0].innerHTML.toUpperCase().indexOf(value) > -1){
        item[i].style.display = "flex";
      }else{
        item[i].style.display = "none";
      }
    }
  }



</script>
</html>