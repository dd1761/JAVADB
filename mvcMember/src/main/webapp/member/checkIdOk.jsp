<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%-- ${param.id }는 사용가능 --%>
${requestScope.id}는 사용 가능
<br>
<input type="button" value="사용하기" onclick="checkIdClose('${id}')">

<script type="text/javascript">
function checkIdClose(id){	
	opener.writeForm.id.value = id //javascript에서 숫자는 그냥 써도 되지만 문자는 "" 써주어야함
	opener.writeForm.check.value = id	// 중복체크 버튼을 눌렀다는 확인
	window.close()
	opener.writeForm.pwd.focus();
}
</script>
</body>
</html>