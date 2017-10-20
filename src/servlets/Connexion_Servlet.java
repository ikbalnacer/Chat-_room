package servlets;

import java.io.IOException;
import java.util.Map;
import java.util.TreeMap;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import UserDao.Auth;
import UserDao.RoomException;
import UserDao.UserFactory;
import _Form.Connexion_Form;
import beans.Utilisateur;

public class Connexion_Servlet extends HttpServlet {
	public static final String USER ="user";
	public static final String AUTH ="auth";
	public static final String CON="mp";
	public void init(){
		try {
		UserFactory user=	UserFactory.getInstance("chat_room", "ikbal", "ikol1945");
		user.getConnection();
		} catch (RoomException e) {
		}
	}
public void doGet(HttpServletRequest request,HttpServletResponse res) throws ServletException, IOException{
   go(request, res);
}
public void doPost(HttpServletRequest request,HttpServletResponse res) throws ServletException, IOException{
	  Connexion_Form con = new Connexion_Form();
      Utilisateur user =con.Verifier(request); 
      HttpSession session = (HttpSession)request.getSession();
      Auth auth = con.getAuth();
      session.setAttribute(USER,user);
       Map<String,String> mp = con.getTm();
    if( user == null )
	{
    request.setAttribute(CON,mp);
    request.setAttribute(AUTH,auth);
	request.getRequestDispatcher("/WEB-INF/Connexion.jsp").forward(request, res);
	}
	else {
    res.sendRedirect("/chat_room/Online");
	}
}
public void go(HttpServletRequest request,HttpServletResponse res)throws ServletException,IOException{
	this.getServletContext().getRequestDispatcher("/WEB-INF/Connexion.jsp").forward(request, res);

}
}
