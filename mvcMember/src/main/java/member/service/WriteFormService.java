package member.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.control.CommandProcess;

public class WriteFormService implements CommandProcess {

	@Override									//서블릿의 request					//서블릿의 response
	public String requestPro(HttpServletRequest request, HttpServletResponse response) {
		
		return "/member/writeForm.jsp";
	}

}