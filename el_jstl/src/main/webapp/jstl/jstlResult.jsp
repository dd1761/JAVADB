<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<ul>
	<li>이 름 : ${param.name }</li><br>
	<li>
	나 이 : ${param.age }살
	
	<c:if test="${param.age>=19 }"><strong>성인</strong></c:if>
	<c:if test="${param.age<19 }"><strong>청소년</strong></c:if>
	</li><br>
	<li>
	색 깔 : 
	<c:if test="${param.color==('red') }">빨강</c:if>
	<c:if test="${param.color==('green') }">초록</c:if>
	<c:if test="${param.color==('blue') }">파랑</c:if>
	<c:if test="${param.color==('magenta') }">보라</c:if>
	<c:if test="${param.color==('cyan') }">하늘</c:if>
	</li>
	
	<li>
	색 깔 : 
	<c:choose>
		<c:when test="${param.color==('red') }">빨강</c:when>
		<c:when test="${param.color==('green') }">초록</c:when>
		<c:when test="${param.color==('blue') }">파랑</c:when>
		<c:when test="${param.color==('magenta') }">보라</c:when>
		<c:otherwise>하늘</c:otherwise>
	</c:choose>
	</li>
</ul>
</body>
</html>