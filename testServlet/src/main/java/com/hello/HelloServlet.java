package com.hello;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/HelloServlet")
public class HelloServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	public void init() {
		System.out.println("init()");
	}
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doGet()");
		
		response.setContentType("text/html");
		
		
//		1.
//		System.out.println("<html>"); // 콘솔창에 html 출력
//		
//		2.
//		PrintWriter out = new PrintWriter(new FileWriter("result.txt"));	// 파일로 가서 찍히게 됨.
//		out.println("<html>");
//		
//		3.
		PrintWriter out = response.getWriter(); // 아웃객체를 response로 생성하여 브라우저(web)으로 감.
		out.println("<html>");
		out.println("<body>");
		out.println("Hello Servlet");
		out.println("</body>");
		out.println("</html>");
	}
	
	public void destroy() {
		System.out.println("destory()");
	}

}
