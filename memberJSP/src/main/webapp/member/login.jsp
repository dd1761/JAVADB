<%@page import="member.dao.MemberDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%
   	String id = request.getParameter("id");
	String pwd = request.getParameter("pwd");
	
	//DB
	MemberDAO memberDAO = MemberDAO.getInstance();	//클래스 생성
	String name = memberDAO.memberLogin(id, pwd);
			
	
	
	
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%if(name == null) { 
	//페이지 이동
	response.sendRedirect("loginFail.jsp");
	
}else {
	//쿠키
	Cookie cookie = new Cookie("memName", name);
	cookie.setMaxAge(3);	//기본 단위가 초 단위. 3초.
	response.addCookie(cookie);//클라이언트에 보내기
	
	Cookie cookie2 = new Cookie("memId", id);
	cookie2.setMaxAge(3);	//기본 단위가 초 단위. 3초.
	response.addCookie(cookie2);//클라이언트에 보내기
	
	
	//세션
	
	
	//페이지 이동
	response.sendRedirect("loginOk.jsp");
} %>
</body>
</html>