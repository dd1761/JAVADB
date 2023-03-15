<%@page import="java.util.List"%>
<%@page import="java.util.Map"%>
<%@page import="java.util.HashMap"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="member.bean.MemberDTO" %>
<%@ page import="member.dao.MemberDAO" %>
<%
	//데이터
	String id = request.getParameter("id");
	String pwd = request.getParameter("pwd");
	
	Map<String, String> map = new HashMap<String, String>();
	map.put("id", id);
	map.put("pwd", pwd);

	//DB
	MemberDAO memberDAO = MemberDAO.getInstance();
	/* MemberDTO memberDTO = memberDAO.memberLogin(id, pwd); */
	List<MemberDTO> list = memberDAO.memberLogin(map);
	
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<% if(list == null) {
	//페이지 이동
	response.sendRedirect("loginFail.jsp");
	
}else{
	MemberDTO memberDTO = list.get(0);
	//세션 생성
	session.setAttribute("memName", memberDTO.getName());
	session.setAttribute("memId", memberDTO.getId());
	session.setAttribute("memPwd", memberDTO.getPwd());
	session.setAttribute("memEmail", memberDTO.getEmail1()+"@"+memberDTO.getEmail2());
	
	//페이지 이동
	response.sendRedirect("loginOk.jsp");     
	
} %>
</body>
</html>






