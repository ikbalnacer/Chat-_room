package _Form;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

import javax.servlet.http.HttpServletRequest;

import beans.Utilisateur;
import UserDao.UserDaoImp;

public class InscriptionForm {
	Map<String ,String> tm = new  HashMap<String,String>(); ;
    
    public static final String NAME ="name";
    public static final String PRENOM="prenom";
    public static final String NICKNAME="nickname";
    public static final String PASSWORD="password";
    public static final String EMAIL="email";

	public Utilisateur Inscrire(HttpServletRequest request){
		UserDaoImp userimpl = new UserDaoImp();
		
		String password =request.getParameter(PASSWORD);
		String email =request.getParameter(EMAIL);
		String nom =request.getParameter(NAME);
		String prenom =request.getParameter(PRENOM);
		String nickname =request.getParameter(NICKNAME);
		String repassword = request.getParameter("re"+password);
		
		verifieemail(email);
		verifiemotdepass(password);
		verifiename(nom);
		verifieprenom(prenom);
		verifienickname(nickname);
		
		

		 Utilisateur  user = new Utilisateur(0,password,email,
				   nom,prenom,nickname);
			userimpl.Inscription(user);
			
	 return user;
	}
	
	public Map<String, String> getTm() {
		return tm;
	}

	public void setTm(Map<String, String> tm) {
		this.tm = tm;
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
			tm.put(PASSWORD, "doit contenir au moin 5 caractere");
		}
	}
    public void verifieremotdepass(String str){
		if (str.length()>4) {
			
		}else{
			tm.put("re"+PASSWORD, "doit contenir au moin 5 caractere");
		}
	}
    public void verifiename(String str){
		if (str.length()>4) {
			
		}else{
			tm.put(NAME, "doit contenir au moin 5 caractere");
		}
	}
    public void verifieprenom(String str){
		if (str.length()>4) {
			
		}else{
			tm.put(PRENOM, "doit contenir au moin 5 caractere");
		}
	}
    public void verifienickname(String str){
		if (str.length()>4) {
			
		}else{
			tm.put(NICKNAME, "doit contenir au moin 5 caractere");
		}
	}
	
}
