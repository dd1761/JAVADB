<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="member.dao.MemberDAO"%>
<%
	//데이터
	String id = (String)session.getAttribute("memId");
	String pwd = request.getParameter("pwd");	//넘어온 데이터
	
	
	//DB
	MemberDAO memberDAO = MemberDAO.getInstance();	//클래스 생성
	
	
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

</body>
</html>