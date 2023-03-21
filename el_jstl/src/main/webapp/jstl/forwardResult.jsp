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

결과 = ${requestScope.list } <br> <br>
세번째 항목 = ${ requestScope.list[2] }<br><br>

결과 = ${requestScope.list2 }<br><br>

<!-- 메소드명을 변수처럼 사용할 수 있다. -->
<c:forEach var="personDTO" items="${list2 }">	<!-- var에게 자료형을 하나씩 넘겨줌 그리고 list2라는 변수가 존재하지 않으면 위에 request부터 차례대로 수행하고 온다.--> 
	이름 = ${personDTO.getName() } &emsp; 나이 = ${personDTO.getAge() } <br>	<!--  -->
	<!-- 여기의 name와 age는 DTO의 name과 age와는 다른 것. -->
	이름 = ${personDTO.name } &emsp; 나이 = ${personDTO.age } <br><br> <!-- 여기의 name은 위에 getName()이란 함수르 의미한다. -->
</c:forEach>


</body>
</html>