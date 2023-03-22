<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String name = (String) session.getAttribute("memName");
	
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h3><img src="../image/mokoko_01.gif" width="100" height="100" alt="모코코" onclick="location.href='http://localhost:8080/myStudy/index.jsp'" style="cursor: pointer;">
<%=name %>님이 로그인</h3>
<input type="button" value="홈으로" onclick="location.href='../index.jsp'"/>
</body>
</html>