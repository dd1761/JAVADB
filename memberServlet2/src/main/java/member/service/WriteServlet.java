package member.service;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import member.dao.MemberDAO;

 
//@WebServlet("/WriteServlet")
public class WriteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//데이터
		
		String name = request.getParameter("name");//이름 속성을 얻어온다. 
		//이름, 아이디, 성별, 이메일2, 휴대폰3, 주소3
		String id = request.getParameter("id");
		String pwd = request.getParameter("pwd");
		String gender = request.getParameter("gender");
		String email1 = request.getParameter("email1");
		String email2 = request.getParameter("email2");
		String phone1 = request.getParameter("tel1");
		String phone2 = request.getParameter("tel2");
		String phone3 = request.getParameter("tel3");
		String zipcode = request.getParameter("zipcode");
		String address1 = request.getParameter("addr1");
		String address2 = request.getParameter("addr2");
		String address3 = request.getParameter("addr3");
	
		
		//DB
		MemberDAO memberDAO = new MemberDAO();
		memberDAO.memberWrite();
	}
		//응답
}
