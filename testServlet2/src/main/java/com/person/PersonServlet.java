package com.person;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/PersonServlet")
public class PersonServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 데이터 받기
		String name = request.getParameter("name");
		int gender = Integer.parseInt(request.getParameter("gender"));
		String color = request.getParameter("color");
		String[] subject = request.getParameterValues("subject");
		String[] hobby = request.getParameterValues("hobby");
		
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();
		out.println("<html>");
		out.println("<body>");
		out.println("<h3>");
		out.println("<ul>");
		out.println("<li>이름 : " + name + "</li>");
		
		if(gender == 0) {
			out.println("<li> 성별 : 남자 </li>" );
		}
		else if(gender == 1) {
			out.println("<li> 성별 : 여자 </li>");
		}

		out.println("<li> 색깔 : " + color + "</li>");
		
		out.println("<li> 취미 : ");
		for(int i = 0; i < hobby.length; i++) {
				out.println(hobby[i]);
			
		}
		
		out.println("<li> 과목 : ");
		for(int i = 0; i < subject.length; i++) {
				out.println(subject[i]);
			
		}
		
//		for(String data : subject) {
//			out.println(data);
//		}
		
		out.println("</h3>");
		out.println("<input type='button' value='뒤로' onclick='javascript:history.go(-1)'>");
		out.println("<input type='button' value='뒤로' onclick=location.href='http://localhost:8080/testServlet/calc/input.html'>");
		out.println("<input type='button' value='연령제한' onclick=location.href='http://localhost:8080/testServlet/param.html'>");
		out.println("</ul>");
		out.println("</body>");
		out.println("</html>");
	}
	
	
	

}
