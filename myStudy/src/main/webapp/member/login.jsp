<%@page import="java.util.Map"%>
<%@page import="java.util.HashMap"%>
<%@page import="member.bean.MemberDTO"%>
<%@page import="member.dao.MemberDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%
	//데이터
	String id = request.getParameter("id");
	String pwd = request.getParameter("pwd");
	
	//DB
	MemberDAO memberDAO = MemberDAO.getInstance();
	Map<String, String> map = new HashMap<String, String>();
	
	map.put("id", id);
	map.put("pwd", pwd);
	MemberDTO memberDTO = memberDAO.memberLogin(map);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<% if(memberDTO == null) {
	response.sendRedirect("loginFail.jsp");
	
	
	
} %>
</body>
</html>