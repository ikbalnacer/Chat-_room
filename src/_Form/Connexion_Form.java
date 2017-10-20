package _Form;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

import javax.servlet.http.HttpServletRequest;

import UserDao.Auth;
import UserDao.UserDaoImp;
import beans.Utilisateur;

public class Connexion_Form {
	
    private Map<String ,String> tm = new  HashMap<String,String>() ;
	Auth auth = new Auth();
    public static final String PASSWORD="password";
	public static final String EMAIL="email";
	
	public Auth getAuth() {
		return auth;
	}
	
	public void setAuth(Auth auth) {
		this.auth = auth;
	}
	
	public Map<String, String> getTm() {
		return tm;
	}
	
	public void setTm(Map<String, String> tm) {
		this.tm = tm;
	}
	
	public Utilisateur Verifier(HttpServletRequest request){
	    auth = new Auth();
		auth.setEmail(request.getParameter("email"));
		auth.setMot_de_pass(request.getParameter("password"));
		tm = new  TreeMap<String,String>();
		verifieemail(auth.getEmail());
		verifiemotdepass(auth.getMot_de_pass());
		UserDaoImp useimp = new UserDaoImp();
		return useimp.authentifie(auth);
	}
	
	public void verifieemail(String str){
		if(str.contains("@")&& str.contains(".")&&str.length()>7){		
		}else{
			tm.put(EMAIL,"Verfier votre email svp");
		}
	}
	
    public void verifiemotdepass(String str){
		if (str.length()>4) {
			
		}else{
			tm.put(PASSWORD, " mot de pass doit contenir au moin 5 caractere");
		}
	}
}
