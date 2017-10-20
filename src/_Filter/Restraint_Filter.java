package _Filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import _Form.Connexion_Form;
import beans.Utilisateur;

public class Restraint_Filter implements Filter{
	public static final String path ="/Connexion.jsp";
	@Override
	public void destroy() {
	}

	@Override
	public void doFilter(ServletRequest arg0, ServletResponse arg1,
			FilterChain chain) throws IOException, ServletException {
		  HttpServletRequest request =(HttpServletRequest)arg0;
		HttpServletResponse res = (HttpServletResponse)arg1;
		    Connexion_Form con = new Connexion_Form();
	        Utilisateur user =con.Verifier(request);
	        if(user==null){
             
	        }else{
	        	chain.doFilter(request, res);
	         }
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
	
	}
}
