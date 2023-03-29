package board.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import com.control.CommandProcess;

import board.bean.BoardDTO;
import board.dao.BoardDAO;

public class GetBoardService implements CommandProcess {

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) {
		//데이터
		int pg = Integer.parseInt(request.getParameter("pg"));
		int seq = Integer.parseInt(request.getParameter("seq"));
		
		//DB
		BoardDAO boardDAO = BoardDAO.getInstance();
		BoardDTO dto = new BoardDTO();
		dto = boardDAO.getBoard(seq);	
		
		JSONObject json = new JSONObject();
		
		
		
		if(dto !=null) {
			JSONArray array = new JSONArray();
			JSONObject json2 = new JSONObject();
			json2.put("content", dto.getContent());
			json2.put("subject", dto.getSubject());
			
			array.add(json2);
			json.put("json",array);
		}
		
			request.setAttribute("json", json);
			
		return null;
	}

}
