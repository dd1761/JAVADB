<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="board.bean.BoardDTO" %>
<%@page import="board.bean.BoardPaging"%>
<%@page import="board.dao.BoardDAO"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>

<%
	//데이터
	int pg = Integer.parseInt(request.getParameter("pg"));
	
	
	//DB
	BoardDAO boardDAO = BoardDAO.getInstance();
	
	//1페이지당 5개씩

	/* 
	pg=1    rn>=1 and rn<=5
	pg=2    rn>=6 and rn<=10
	pg=3    rn>=11 and rn<=15
	*/
	int endNum = pg*5;
	int startNum = endNum-4;
	
	Map<String, Integer> map = new HashMap<String, Integer>();
	map.put("startNum", startNum);
	map.put("endNum", endNum);
	
	List<BoardDTO> list = boardDAO.boardList(map);
	//ArrayList<BoardDTO> arrayList = new ArrayList<BoardDTO>();
	
	//페이징 처리
	int totalA = boardDAO.getTotalA();//총 글수
	
	BoardPaging boardPaging = new BoardPaging();
	boardPaging.setCurrentPage(pg);
	boardPaging.setPageBlock(3);
	boardPaging.setPageSize(5);
	boardPaging.setTotalA(totalA);
	
	boardPaging.makePagingHTML();
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
.subjectA:link{ color: black; text-decoration: none;}
.subjectA:visited{color: black; text-decoration: none;}
.subjectA:hover{ color: green; text-decoration: underline;}
.subjectA:active{ color: black; text-decoration: none;}
#currentPaging{
	color: red;
	border: 1px solid red;
	padding: 5px 8px; /* top / bottom, left / right  */
	margin: 5px; /* top, right, bottom, left  */
	cursor: pointer;
}
#paging{
	color: black;
	padding: 5px;
	margin: 5px;
	cursor: pointer;
	/* board: 1px solid black; */
}

</style>
</head>
<body>
<img src="../image/mokoko_01.gif" width="100" height="100" alt="모코코" 
onclick="location.href='http://localhost:8080/miniProject_JSP/index.jsp'" style="cursor: pointer;">
<table border="1" cellpadding="5" cellspacing="0" frame="hsides" rules="rows">
	<tr>
		<th width="100">글번호</th>
		<th width="300">제목</th>
		<th width="150">작성자</th>
		<th width="100">조회수</th>
		<th width="150">작성일</th>
	</tr>
	<% if(list != null) {%>
		<% for(BoardDTO boardDTO : list) {%>
			<tr>
				<td align="center"><%=boardDTO.getSeq() %></td>
				<td><a class="subjectA" onclick="checkLogin()" href="boardView.jsp"><%=boardDTO.getSubject() %></a></td>
				<td align="center"><%=boardDTO.getId() %></td>
				<td align="center"><%=boardDTO.getHit() %></td>
				<td align="center">
					<%= new SimpleDateFormat("yyyy.MM.dd").format(boardDTO.getLogtime()) %>
				</td>
			</tr>
		<% } %>
	<% } %>
</table>
<div style="solid blue; margin-top: 15px; width: 850px; text-align: center;">
	<%=boardPaging.getPagingHTML() %>
</div>
	
<script type="text/javascript">
function boardPaging(pg){
	location.href = "boardList.jsp?pg=" + pg;
}
</script>
<script type="text/javascript">
function checklogin(){
		String id = null;
		if( id == null){
			alert("ㅎㅇ");
		}
		else{
			alert("꽝");
		}
		
	}
</script>
</body>
</html>