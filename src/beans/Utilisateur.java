package beans;

import java.io.Serializable;

public class Utilisateur implements Serializable {
	private int id ;
	private String motDepass;
	private String Email;
	private String Nom;
	private String prenom;
	private String nickname;
	private int numberonline ;


	 public int getNumberonline() {
		return numberonline;
	}
	public void setNumberonline(int numberonline) {
		this.numberonline = numberonline;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	public Utilisateur(int id, String motDepass, String email, String nom,
			String prenom,String nickname) {
		this.id = id;
		this.motDepass = motDepass;
		this.Email = email;
		this.Nom = nom;
		this.prenom = prenom;
		this.nickname=nickname;
	    }
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getMotDepass() {
		return motDepass;
	}
	public void setMotDepass(String motDepass) {
		this.motDepass = motDepass;
	}
	public String getEmail() {
		return Email;
	}
	public void setEmail(String Email) {
		this.Email = Email;
	}
	public String getNom() {
		return Nom;
	}
	public void setNom(String nom) {
		Nom = nom;
	}
}
