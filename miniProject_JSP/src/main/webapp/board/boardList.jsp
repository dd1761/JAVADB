<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="java.util.ArrayList"%>
<%@page import="board.dao.BoardDAO"%>
<%@ page import="board.bean.BoardDTO" %>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.List"%>

<%
	//데이터
	request.setCharacterEncoding("UTF-8");
	String id = (String)session.getAttribute("memId");
	String name = (String)session.getAttribute("memName");
	String email = (String)session.getAttribute("memEmail");
	
	//DB
	BoardDAO boardDAO = BoardDAO.getInstance();
	List<BoardDTO> list = boardDAO.boardList();
	//ArrayList<BoardDTO> arrayList = new ArrayList<BoardDTO>();
	

%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
.subjectA:link{ color: black; text-decoration: none;}
.subjectA:visited{color: black; text-decoration: none;}
.subjectA:hover{ color: green; text-decoration: underline;}
.subjectA:active{ color: black; text-decoration: none;}

</style>
</head>
<body>
<img src="../image/mokoko_01.gif" width="100" height="100" alt="모코코" 
onclick="location.href='http://localhost:8080/miniProject_JSP/index.jsp'" 
style="cursor: pointer;">
<table border="1" cellpadding="5" cellspacing="0" frame="hsides" rules="rows">
	<tr>
		<th width="100">글번호</th>
		<th width="300">제목</th>
		<th width="150">작성자</th>
		<th width="100">조회수</th>
		<th width="150">작성일</th>
	</tr>
	<% if(list != null) {%>
		<% for(BoardDTO boardDTO : list) {%>
			<tr>
				<td align="center"><%=boardDTO.getSeq() %></td>
				<td><a class="subjectA" href=""><%=boardDTO.getSubject() %></a></td>
				<td align="center"><%=boardDTO.getId() %></td>
				<td align="center"><%=boardDTO.getHit() %></td>
				<td align="center">
					<%= new SimpleDateFormat("yyyy.MM.dd").format(boardDTO.getLogtime()) %>
				</td>
			</tr>
		<% } %>
	<% } %>
</table>	
</body>
</html>