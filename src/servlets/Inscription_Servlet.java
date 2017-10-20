package servlets;

import java.io.IOException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import beans.Utilisateur;
import _Form.InscriptionForm;

public class Inscription_Servlet extends HttpServlet {
	public static final String USER ="user";
	public static final String MP ="mp";
	
	public void doGet(HttpServletRequest request,HttpServletResponse res) throws ServletException, IOException{
	 this.getServletContext().getRequestDispatcher("/WEB-INF/Inscription.jsp").forward(request, res);   
	}
	public void doPost(HttpServletRequest request,HttpServletResponse res) throws ServletException, IOException{
	 InscriptionForm form = new InscriptionForm();
	 Utilisateur user = form.Inscrire(request);
	 Map<String,String> mp =form.getTm();	 
	 request.setAttribute(USER,user);
	 request.setAttribute(MP,mp);
	 if(user==null){
      this.getServletContext().getRequestDispatcher("/WEB-INF/Inscription.jsp").forward(request, res);
	 }else{
	  HttpSession sesion = request.getSession();
	  sesion.setAttribute(USER, user);
	  res.sendRedirect("/chat_room/Online");
	 }
	}
}
