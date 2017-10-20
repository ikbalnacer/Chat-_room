package UserDao;

import beans.Utilisateur;

public interface Administrateur extends User{
	void Modifier(String email,String message);
	void supprimer(String email);
}
