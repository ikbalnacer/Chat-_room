package UserDao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserFactory {

    public static final String Driver="com.mysql.jdbc.Driver";
    public static final String URL_S="jdbc:mysql://localhost:3306/";
    Connection con;
    String url;
    String User_name;
    String MOtDepass;
    
    public UserFactory(String url,String username,String password){
  	  this.url=url;
  	 User_name=username;
  	 MOtDepass = password;
    }
    
    public static UserFactory getInstance(String basename,String user,String mot_de_pass) throws RoomException{
  	  try {
			Class.forName(Driver);
		} catch (ClassNotFoundException e) {
			throw new RoomException("Driver PRoblem");
		} 
  	  return  new UserFactory(URL_S+basename, user, mot_de_pass);
    }
    
    public  void getConnection()throws RoomException{
		try {
			con= (Connection) DriverManager.getConnection(url,User_name,MOtDepass);
		} catch (SQLException e) {
			 new RoomException("n'est pas Connecter");
		}
    }
    
    public java.sql.PreparedStatement prepare(String str){
  	  try {
			return con.prepareStatement(str);
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
  	  
    }
    
    public ResultSet executeQuery(PreparedStatement prep){
  	  try {
			return prep.executeQuery();
		} catch (SQLException e) {
			e.printStackTrace();
          return null;
          }
  	  
    }
    public void executeUpdate(PreparedStatement prep){
  	  try {
			prep.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
    }
    
}
