<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("UTF-8");
	String email = null;
	String subject = null;
	String content = null;

	email = (String)session.getAttribute("memEmail");
	subject = request.getParameter("subject");
	content = request.getParameter("content");

%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%=email %>
<%=subject %>
<%=content %>
</body>
</html>