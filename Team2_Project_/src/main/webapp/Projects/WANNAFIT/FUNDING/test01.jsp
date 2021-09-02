<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    import = "jspexp.z01_database.*"
    import = "jspexp.z02_vo.*"
    import = "java.util.*"    
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
<link rel="stylesheet" href="<%=path%>/a00_com/a00_com.css">
<style>
	
</style>
<script type="text/javascript">
var showObj = document.querySelector("#show");

var intID = setInterval(function(){
	var toDay = new Date(); // 현재 날짜 객체..
	showObj.innerHTML+="<h3>"+toDay.toLocaleString()+"</h3>";
},1000); // 1초마다, 현재시간을 출력 처리..

var setID = setTimeout(function(){
	alert("종료");
	clearInterval(intID);
	clearTimeout(setID);
},10000);
</script>
</head>
<%-- 
# <!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
/*  */

</style>
<script>
/*   
# setInterval(반복적으로 수행할 함수, 반복적인 시간1/1000);


 */
</script>

</head>
<body>
	<div id="show"></div>
	<h2 id="cntDn"></h2>
</body>
<script>
/*
	var showObj = document.querySelector("#show");
	
	var intID = setInterval(function(){
		var toDay = new Date(); // 현재 날짜 객체..
		showObj.innerHTML+="<h3>"+toDay.toLocaleString()+"</h3>";
	},1000); // 1초마다, 현재시간을 출력 처리..
	
	var setID = setTimeout(function(){
		alert("종료");
		clearInterval(intID);
		clearTimeout(setID);
	},10000);
*/	
	// 10초 후에, clearInterval(intID); 반복을 중단 처리.
	/// clearTimeout(setID); timeout 메모리 중단 처리..
	
	// ex) 카운트 다운 10..  1.0   발사!! alert으로 처리.. 2조, 3조
	var cntDn = document.querySelector("#cntDn");
	var cnt = 10;
	var intID2 = setInterval(function(){
		cntDn.innerText = "카운트 다운:"+cnt;
		cnt--;
		if(cnt<0){
			alert("로켓발사!!");
			clearInterval(intID2);
		}
	},1000);
/* 


*/
	
</script>
</html>

--%>
<%

%>
<body>
	<div id="show"></div>
	<h2 id="cntDn"></h2>
</body>
</html>