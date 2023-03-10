<%@page import="member.dao.MemberDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%
	//데이터
	String id = request.getParameter("id");

	//DB
	MemberDAO memberDAO = new MemberDAO();
	boolean existId = memberDAO.isExistId(id); //아이디가 있다/true/사용 불가능
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<% if(existId) {%>
		사용 불가능
	<% } else { %>
		사용 가능
	<%} %>
	
</body>
</html>