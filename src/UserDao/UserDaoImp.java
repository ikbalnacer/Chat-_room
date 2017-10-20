package UserDao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import beans.Utilisateur;

public class UserDaoImp implements Administrateur {
 
	UserFactory usefac;
    PreparedStatement prep ;
    PreparedStatement prep1 ;
    PreparedStatement prep2 ;
    PreparedStatement prep3 ;
    PreparedStatement prep4 ;
    PreparedStatement prep5 ;
    PreparedStatement prep6 ;
    PreparedStatement prep7 ;
    PreparedStatement prep8 ;
    PreparedStatement prep9 ;
    
    public UserDaoImp(){
    	try {
			usefac = UserFactory.getInstance("chat_room","ikbal","ikol1945");
		} catch (RoomException e) {
			e.printStackTrace();
		}
    	try {
			usefac.getConnection();
		} catch (RoomException e) {
			e.printStackTrace();
		}
    	prep = usefac.prepare("select *from user where email=? and mot_de_pass=? ;");
    	prep1 = usefac.prepare("insert into user values(?,?,?,?,?,?);");
    	prep2 = usefac.prepare("update user set nom=? ,prenom=?,nickname=? where email=?");
    	prep3 = usefac.prepare("update user set nom=? ,prenom=? where email=?");
    	prep4 = usefac.prepare("update user set nom=?,nickname=? where email=?");
    	prep5 = usefac.prepare("update user set prenom=?,nickname=? where email=?");
    	prep6 = usefac.prepare("update user set nom=?  where email=?");
    	prep7 = usefac.prepare("update user set nickname=? where email=?");
    	prep8 = usefac.prepare("insert into chat values(?,?,?);");
    	prep9 = usefac.prepare("select *from chat ");
    }
    
    public List<String> getMessage(){
      ResultSet r=	usefac.executeQuery(prep9);
  	List<String> list = new ArrayList<String>();
    	try {
			while (r.next()) {
			 list.add(r.getString("email")+":"+r.getString("message"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
    	return list;
    }
    
    @Override
	public Utilisateur authentifie(Auth auth) {
    	ResultSet result=null;
    	try {
			prep.setString(1,auth.getEmail());
			prep.setString(2,auth.getMot_de_pass());
	    	result= usefac.executeQuery(prep);	
		} catch (SQLException e1) {
			e1.printStackTrace();	}
    	Utilisateur user=null;
    	try {
			while (result.next()){
				user = new Utilisateur(result.getInt("id"), result.getString("mot_de_pass"),result.getString("email"),
						result.getString("nom"), result.getString("prenom"),result.getString("nickname"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return user;
	}
    		
   

	@Override
	public void Inscription(Utilisateur user) {
		try {
			prep1.setInt(1,user.getId());
			prep1.setString(2,user.getMotDepass());
			prep1.setString(3,user.getEmail());
			prep1.setString(4,user.getNom());
			prep1.setString(5,user.getPrenom());
			prep1.setString(6,user.getNickname());
		} catch (SQLException e) {
			e.printStackTrace();
		}
		usefac.executeUpdate(prep1);
	}

	@Override
	public void Modifier(String email,String message) {
			try {
				prep8.setInt(1,0 );
				prep8.setString(2,email );
				prep8.setString(3,message );
			} catch (SQLException e) {
				e.printStackTrace();
			}
			usefac.executeUpdate(prep8);
			
	}

	@Override
	public void supprimer(String  email) {
      try {
		prep9.setString(1, email);
	} catch (SQLException e) {
		e.printStackTrace();
	}
	usefac.executeUpdate(prep9);
	}
    
    
}
