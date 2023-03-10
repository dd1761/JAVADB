<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="board.bean.BoardDTO"%>
<%@page import="board.dao.BoardDAO"%>

<%
	//데이터
	int seq = Integer.parseInt(request.getParameter("seq"));
	int pg = Integer.parseInt(request.getParameter("pg"));
	
	//DB
	BoardDAO boardDAO = BoardDAO.getInstance();
	BoardDTO boardDTO = boardDAO.getBoard(seq);

%>

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
<%if(boardDTO != null){ %>
	<form name="boardViewForm" method="post">
	<table border="1" cellpadding="5" cellspacing="0">
		<tr>
		<h3>
		<img src="../image/mokoko_01.gif" width="100" height="100" alt="모코코" 
		onclick="location.href='http://localhost:8080/miniProject_JSP/index.jsp'" 
		style="cursor: pointer;"> 작성한 글확인
		</h3>
			<th>제목</th>
			<td>
				<input type="text" name="subject" id="subject" size="50" value="<%=boardDTO.getSubject()%>">
				<div id="subjectDiv"></div>
			</td>
		</tr>
		<tr>
			<th>내용</th>
			<td>
				<textarea id="content" name="content" cols="50" rows="15" ><%=boardDTO.getContent()%>"</textarea>
				<div id="contentDiv"></div>
			</td>
		</tr>
		<tr>
			<td colspan="2" align="center">
				<input type="button" value="목록" onclick=""> 
				<input type="reset" value="다시작성">
			</td>
		</tr>
	</table>
</form>
<%} %>
</body>
</html>
















