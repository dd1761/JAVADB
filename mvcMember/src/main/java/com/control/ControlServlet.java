package com.control;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(
	urlPatterns = {"*.do"},
	initParams = {
			@WebInitParam(name="propertyConfig", value="command.properties")
	}
)
public class ControlServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Map<String, Object> map = new HashMap<String, Object>();
	
	//init 는 web.xml에서 한번만 읽어오기 때문에 init을 사용한다.
	@Override
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
		super.init(config);
	}
	
//	execute를 사용함으로써 get방식으로 받아오거나 post방식으로 받아와도 전부 execute로 보낼 수 있다.
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		execute(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		execute(request, response);
	}

	protected void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println();
		
		//한글처리
		//get방식으로 받아올 때에는 안해도 한글이 나오지만 post방식으로 받을 때에는 한글처리를 해줘야함
		if(request.getMethod().equals("POST")) request.setCharacterEncoding("UTF-8");
		
		//요청이 들어왔을 때 => http://localhost:8080/mvcmember/member/writeForm.do
	      String category = request.getServletPath();
	      System.out.println("category = "+category); // 결과가 /member/writeForm.do
	      
	      CommandProcess com = (CommandProcess)map.get(category); //member.service.WriteFormService
	      String view = null;
	      
	      try {
	         view = com.requestPro(request, response); // "/member/writeForm.jsp"
	      } catch (Throwable e) {
	         e.printStackTrace();
	      }
	      
	      //forward
	      RequestDispatcher dispatcher = request.getRequestDispatcher(view);//상대번지
	      dispatcher.forward(request, response);//제어권 넘기기
			
	}
}
