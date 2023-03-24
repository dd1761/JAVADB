<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div>
	<c:if test="${sessionScope.memId == null }">
		<img src="/miniProject_jQuery/image/login.png" 
		onclick="location.href='/miniProject_jQuery/member/loginForm.do'" 
		style="cursor: pointer; width: 275px;"><br><br>
		<input type="button" value="회원가입" onclick="location.href='/miniProject_jQuery/member/writeForm.do'" ><br><br>
	</c:if>
	
	<c:if test="${memId != null }">
		<h3>${memId}님 로그인</h3>
	</c:if>
</div>