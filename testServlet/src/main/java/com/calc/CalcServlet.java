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

	public void init() {

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 데이터 받기
		int x = Integer.parseInt(request.getParameter("xValue"));
		int y = Integer.parseInt(request.getParameter("yValue"));
		
		PrintWriter out = response.getWriter();
		out.println("<html>");
		out.println("<body>");
		
		out.println(x + " + " + y  + " = "  + (x+y) +"<br>");
		out.println(x + " - " + y  + " = "  + (x-y) +"<br>");
		out.println(x + " * " + y  + " = "  + (x*y) +"<br>");
		out.println(x + " / " + y  + " = "  + (x/y) +"<br>");
		
		out.println("</body>");
		out.println("</html>");
	}

	public void destory() {

	}
}
