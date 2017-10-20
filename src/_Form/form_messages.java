package _Form;

import java.util.List;
import java.util.Map;

import beans.Utilisateur;
import UserDao.UserDaoImp;

public class form_messages {
   
	public static List<String> getmessages(){
		UserDaoImp userd = new UserDaoImp();
		return userd.getMessage();
	}
	public static void setMessage(Utilisateur user,String message){
		UserDaoImp userd = new UserDaoImp();
        userd.Modifier(user.getEmail(),message);
	}
}
