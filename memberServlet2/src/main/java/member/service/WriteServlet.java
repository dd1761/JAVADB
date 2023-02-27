package member.service;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import member.bean.MemberDTO;
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
		String tel1 = request.getParameter("tel1");
		String tel2 = request.getParameter("tel2");
		String tel3 = request.getParameter("tel3");
		String zipcode = request.getParameter("zipcode");
		String addr1 = request.getParameter("addr1");
		String addr2 = request.getParameter("addr2");
		String addr3 = request.getParameter("addr3");
	
		
		MemberDTO memberDTO = new MemberDTO();
		memberDTO.setName(name);
		memberDTO.setId(id);
		memberDTO.setId(pwd);
		memberDTO.setId(gender);
		memberDTO.setId(email1);
		memberDTO.setId(email2);
		memberDTO.setId(tel1);
		memberDTO.setId(tel2);
		memberDTO.setId(tel3);
		memberDTO.setId(zipcode);
		memberDTO.setId(addr1);
		memberDTO.setId(addr2);
		
		//DB
		MemberDAO memberDAO = new MemberDAO();
		int su = memberDAO.memberWrite(memberDTO);
		// memberDTO의 데이터를 memberDAO에 memberWrite로 넘긴 다음
		// su를 리턴받아온다. 
		
		
		//응답
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();//스트림 생성
		out.println("<html>");
		out.println("<body>");
		
		if(su == 0) {
			out.println("<h3>회원가입 실패</h3>");
		}
		else {
			out.println("<h3>회원가입 성공</h3>");
		}
		
		out.println("</body>");
		out.println("</html>");
	}
		
		

	
}
