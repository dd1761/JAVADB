package guestbook.service;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import guestbook.bean.GuestbookDTO;
import guestbook.dao.GuestbookDAO;


@WebServlet("/GuestbookSearchServlet")
public class GuestbookSearchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		int seq = Integer.parseInt("seq");
		
		GuestbookDTO guestbookDTO = new GuestbookDTO();
		
		guestbookDTO.setSeq(seq);
		
		//DB 연동
		GuestbookDAO guestbookDAO = GuestbookDAO.getInstance();
		guestbookDAO.guestbook
	}

}
