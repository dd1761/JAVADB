package com.calc;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CalcServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 데이터 받기
		int x = Integer.parseInt(request.getParameter("xValue"));
		int y = Integer.parseInt(request.getParameter("yValue"));
		
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();
		out.println("<html>");
		out.println("<body>");
		out.println("<h3>");
		out.println(x + " + " + y + " = " + (x+y) +"<br>");
		out.println(x + " - " + y + " = " + (x-y) +"<br>");
		out.println(x + " * " + y + " = " + (x*y) +"<br>");
		out.println(x + " / " + y + " = " + ((double)x/y) +"<br>");
		out.println("</h3>");
		out.println("<input type='button' value='뒤로' onclick='javascript:history.go(-1)'>");
		out.println("<input type='button' value='뒤로' onclick=location.href='http://localhost:8080/testServlet/calc/input.html'>");
		out.println("<input type='button' value='연령제한' onclick=location.href='http://localhost:8080/testServlet/param.html'>");
		out.println("</body>");
		out.println("</html>");
	}

	
}
