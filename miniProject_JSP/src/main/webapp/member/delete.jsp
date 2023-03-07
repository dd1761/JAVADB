<%@page import="member.dao.MemberDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	//데이터
	String id = (String)session.getAttribute("memId");

	//세션
	//session.removeAttribute("memName");
	//session.removeAttribute("nmemId");
	
	session.invalidate();
	
	//DB
	MemberDAO memberDAO = MemberDAO.getInstance();	//클래스 생성
	memberDAO.memberDelete(id);
	
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<script type="text/javascript">
	alert("회원탈퇴 완료!!");
	location.href = "loginForm.jsp";
</script>
</body>
</html>