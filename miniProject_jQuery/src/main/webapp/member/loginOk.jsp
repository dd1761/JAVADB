<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%-- String name = session.getAttribute("memName); 이렇게 썼던 java코드가 $하나로 바뀐다. --%>
<h3>${sessionScope.memName }님 로그인</h3>
<br>
	<input type="button" value="로그아웃" onclick="location.href='/mvcMember/member/logout.do'">
	<input type="button" value="회원정보수정" onclick="location.href=''">
	<input type="button" value="회원탈퇴" onclick="location.href=''">
	<input type="button" value="메인메뉴" onclick="location.href=''">
</body>
</html>