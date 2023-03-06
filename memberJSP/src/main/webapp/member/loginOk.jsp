<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	//데이터
	String name = null;
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h3><%=name %>님 로그인</h3>
<br>
	<%-- <input type="button" value="회원정보수정" onclick="location.href='updateForm.jsp?id=<%=id %>'"> --%> <!-- 회원정보실행일때 id를 실어보내면 보안상 위험 -->
	<input type="button" value="회원정보수정" onclick="location.href='updateForm.jsp'">
</body>
</html>