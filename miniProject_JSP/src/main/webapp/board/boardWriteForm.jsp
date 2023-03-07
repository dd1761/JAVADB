<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
	div {
	color: red;
	font-size: 8pt;
	font-weight: bold;
	}
</style>
</head>
<body>
	<h3>
		<img src="../image/mokoko_01.gif" width="100" height="100" alt="모코코" 
		onclick="location.href='http://localhost:8080/miniProject_JSP/index.jsp'" 
		style="cursor: pointer;">글쓰기
	</h3>
<form name="boardWriteForm" method="post" action="boardWrite.jsp">
	<table border="1" cellpadding="5" cellspacing="0">
		<tr>
			<th>제목</th>
			<td>
				<input type="text" name="subject" id="subject" size="50" placeholder="제목 입력">
				<div id="subjectDiv"></div>
			</td>
		</tr>
		<tr>
			<th>내용</th>
			<td>
				<textarea id="content" name="content" cols="50" rows="15" ></textarea>
				<div id="contentDiv"></div>
			</td>
		</tr>
		<tr>
			<td colspan="2" align="center">
				<input type="button" value="글쓰기" onclick="checkBoardWrite()"> 
				<input type="reset" value="다시작성">
			</td>
		</tr>
	</table>
</form>
<script type="text/javascript">
	function checkBoardWrite(){
		document.getElementById("subjectDiv").innerText = "";
		document.getElementById("contentDiv").innerText = "";
		if(document.getElementById("subject").value == ""){
			document.getElementById("subjectDiv").innerText = "제목 입력";
			document.getElementById("subject").focus();
		}
		else if(document.getElementById("content").value == ""){
			document.getElementById("contentDiv").innerText = "내용 입력";
			document.getElementById("content").focus();
		}
		else
			document.boardWriteForm.submit();
}
</script>
</body>
</html>