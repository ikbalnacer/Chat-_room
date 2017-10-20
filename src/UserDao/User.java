package UserDao;

import beans.Utilisateur;

public interface User {
	Utilisateur authentifie(Auth auth);
	void Inscription(Utilisateur user);
}
