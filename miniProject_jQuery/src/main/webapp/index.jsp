<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
html, body {
   width: 100%;
   height: 100%;
}
html {
   overflow-y: scroll;
}

#wrap{
   width: 1100px; 
   margin: 0 auto;
}

#header {
   height: 10%;
   text-align: center;
}

#container {
   margin: auto;
   width: 1100px;
   height: 500px;
}

#container:after {
   content: '';
   display: block;
   clear: both;
   float: none;
}

#nav {
   margin-left: 10px;
   width: 25%;
   height: 100%;
   float: left;
}

#section {
   width: 70%;
   height: 100%;
   float: left;
}

#footer {
   width: 1100px;
   height: 10%;
}
</style>
</head>
<body>
<div id="wrap">
	<div id="header">
		<h1>
			<img src="./image/mokoko_03.gif" width="70" height="70">MVC를 이용한 미니 프로젝트
		</h1>
	</div>

	<div id="container">
		<div id="nav">
			<jsp:include page="./main/nav.jsp"></jsp:include>
		</div>
		<div id="section">
			<h3>
				저희 홈페이지를 방문해주셔서 감사합니다.
				Have a nice day!!
				<img src="./image/mokoko_01.gif">
			</h3>
		</div>
	</div>
	<hr/>
	
	<div id="footer">
		<h4>비트캠프</h4>
	</div>
</div>
</body>
</html>