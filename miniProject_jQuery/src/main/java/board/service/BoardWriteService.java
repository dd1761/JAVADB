package board.service;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.control.CommandProcess;

import board.dao.BoardDAO;

public class BoardWriteService implements CommandProcess {

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) {
		String subject = request.getParameter("subject");
		String content = request.getParameter("content");
		

		
		//세션
		HttpSession session = request.getSession(); 
		// jsp에 이미 내장객체로 session이 존재하기 때문에 안적어도 사용가능하다.
		String id = request.getParameter("id");
		String name = request.getParameter("name");
		String email = request.getParameter("email");
				
		Map<String, String> map = new HashMap();
		map.put("id", id);
		map.put("name", name);
		map.put("email", email); 
		map.put("subject", subject);
		map.put("content", content);
		
		//DB
		BoardDAO boardDAO = BoardDAO.getInstance();
		boardDAO.boardWrite(map);
		
		
		//응답
		return "/board/boardWrite.jsp";
	}

}
