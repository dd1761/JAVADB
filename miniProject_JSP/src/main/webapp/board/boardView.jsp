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
		<h3>
		<img src="../image/mokoko_01.gif" width="100" height="100" alt="모코코" 
		onclick="location.href='http://localhost:8080/miniProject_JSP/index.jsp'" 
		style="cursor: pointer;"> 작성한 글확인
		</h3>
		<table width="450" border="1" cellpadding="5" cellspacing="0" frame="hsides" rules="rows">
			<tr>
				<td colspan="3">
					<h2><%=boardDTO.getSubject() %></h2>
				</td>
			</tr>
			
			<tr>
				<td width="150" align="center">글번호 : <%=boardDTO.getSeq() %></td>
				<td width="150" align="center">작성자 : <%=boardDTO.getId() %></td>
				<td width="150" align="center">조회수 : <%=boardDTO.getHit() %></td>
				
			</tr>
			
			<tr>
				<td colspan="3" height="250" valign="top">
					<div style="width: 100%; height: 100%; overflow:auto;">
						<pre style="white-space: pre-line; word-break: break-all;"><%=boardDTO.getContent() %></pre>
					</div>
				</td>
			</tr>
		</table> 
		<input type="button" value="목록" onclick="history.go(-1)">
</form>
<%} %>
</body>
</html>
















