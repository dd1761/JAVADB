<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
div#pwdDiv{
	color:red;
	font-weight: bold;
}
</style>
</head>
<body>
<form name="deleteForm" method="post" action="delete.jsp">
	<div style="text-align: center;">
		비밀번호 입력 : 
		<input type="password" name="pwd" id="pwd">
		<input type="button" value="검색" onclick="checkDelete()">
		<br><br>
		<div id="pwdDiv"></div>
	</div>
</form>
<script type="text/javascript">
function checkDelete(){
	document.getElementById("pwdDiv").innerText = "";
	
	if(document.getElementById("pwd").value == "")
		document.getElementById("pwdDiv").innerText = "먼저 비밀번호를 입력하시오";
	else
		document.deleteForm.submit();
}

</script>
</body>
</html>