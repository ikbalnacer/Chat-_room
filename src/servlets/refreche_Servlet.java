package servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import _Form.form_messages;

public class refreche_Servlet extends HttpServlet {
	public void doGet(HttpServletRequest req,HttpServletResponse resp) 
			throws ServletException, IOException{
	  	List<String> list = form_messages.getmessages();

	req.setAttribute("list",list);
	this.getServletContext().getRequestDispatcher("/WEB-INF/Online.jsp").forward(req, resp);
	}
}
