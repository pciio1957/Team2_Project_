<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
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


<header class="header">  
		<div class="member">
			<span><a href="#" class="aMember">?????????</a></span>
			<span>&nbsp;&nbsp;|&nbsp;&nbsp;</span>
			<span><a href="#"  class="aMember">????????????</a></span>
		</div>
	</header>
<section>


 <div class="searchbox">
      <div class="heade1">
 
        <input onkeyup="filter()" type="text" id="value" placeholder="${param.name}">
      </div>



            <div class="wrap">
    <h1>?????? ??????</h1> 	
    <h2>?????????:${param.name}</h2>
<input type="button" class="box" value="?????????:${param.name}">
		



			<br>
            <table class="detailSearch">
                    <tr class="title">
                        <th>??????</th>
                        <th>??????</th>
                        <th>??????</th>
                        <th>????????????</th>
                      
                    </tr>
                    
                    <tr class="value">
                        <td><div class="box">
						  <select onchange="result(this)" name="artcase">
						    <option>??????</option>
						    <option>??????</option>
						    <option>??????</option>
						    <option>?????????</option>
						  </select>
						</div></td>
						
						
						
                        <td><div class="box">
						  <select onchange="result1(this)" name="categry">
						    <option>??????</option>
						    <option>????????????</option>
						    <option>?????????</option>
						    <option>?????????</option>
						    <option>???????????????</option>
						  </select>
						</div></td>
						
						
						
                        <td><div class="box">
						  <select onchange="result2(this)" name="date">
						  	<option>??????</option>
						    <option>1???</option>
						    <option>?????????</option>
						    <option>??????</option>
						    <option>??????</option>
						  </select>
						</div></td>
						
						  <td><div class="box">
						  <select onchange="result3(this)" name="case">
						  	<option>??????</option>
						    <option>????????????</option>
						    <option>????????????</option>
						    </select>
						</div></td>
						
					  </tr> 
                    
                    <!-- ?????? ????????? ?????? -->   
                    <tr>
                    	
                   	 	
                   	 	<table id="result">
                   	 	<tr id="show"> </tr>

                   	 	</table>
                    	<br>
                    	</td>
                    </tr>
                    <tr>
                    	<td colspan="5"><input type="button" name="search" value="??????"></td></td>
                    
                    	<
                    </tr>
			</table>
          	<br>

<article>
                    <div onclick="location.href='???????????????.html'" style="cursor:pointer">
                        <a hred="#">
                            <img src="????????????.jpg">
                            <h3>heyjinss</h3>
                            <p>??????????????????</p>
                            <span>#??????</span>
                        </a>
                    </div>
                    
                        <div onclick="location.href='???????????????.html'" style="cursor:pointer">
                        <a hred="#">
                            <img src="?????????????????????.JPG">
                            <h3>flyyy</h3>
                            <p>????????? ?????? ?????????</p>
                            <span>#??????</span>
                        </a>
                    </div>
                    
                     <div onclick="location.href='???????????????.html'" style="cursor:pointer">
                        <a hred="#">
                            <img src="???????????????.JPG">
                            <h3>arrrt12</h3>
                            <p>??????????????????</p>
                            <span>#??????</span>
                            <span>?????????</span><span>??????</span>
                        </a>
                    </div>
                    
                    
                    <div onclick="location.href='../???????????????.html'" style="cursor:pointer">
                        <a hred="#">
                            <img src="???????????????2.JPG">
                            <h3>cherryis</h3>
                            <p>??????????????????</p>
                            <span>#??????</span>
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