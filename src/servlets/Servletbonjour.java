package servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.*;
import javax.servlet.*;
public class Servletbonjour extends HttpServlet{
   
	public void init(){
		ServletConfig sc = getServletConfig();
		message = (String) sc.getInitParameter("message");
		rep = Integer.valueOf( sc.getInitParameter("rep"));
	}
	
	public void doGet(HttpServletRequest req , HttpServletResponse res)throws ServletException,IOException{
		
		res.setCharacterEncoding("UTF-8");
		res.setContentType("text/html");
		PrintWriter out = res.getWriter();
		for (int i = 0; i <rep; i++) {
			out.println(message);
		}
		
	}
	  String message;
	     int rep;
}
