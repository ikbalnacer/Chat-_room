package servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import _Form.form_Online;
import _Form.form_messages;
import beans.Utilisateur;

public class Is_online_Servlet extends HttpServlet{
	public void doGet(HttpServletRequest request,HttpServletResponse res) throws ServletException, IOException{
		HttpSession session =(HttpSession) request.getSession();  
		Utilisateur user =(Utilisateur) session.getAttribute("user");
		if(user==null){
		    res.sendRedirect("/chat_room/Connexion");
		}else
		{   
			this.getServletContext().getRequestDispatcher("/WEB-INF/Online.jsp").forward(request, res);
		}
		}
	public void doPost(HttpServletRequest request , HttpServletResponse res) throws ServletException, IOException{
		HttpSession session =(HttpSession) request.getSession();  
		Utilisateur user =(Utilisateur) session.getAttribute("user");
		form_messages.setMessage(user,request.getParameter("message"));
	    res.sendRedirect("/chat_room/Refreche");
	}
	}

