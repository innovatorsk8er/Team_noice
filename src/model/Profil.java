
package model;

/**
 * @author Viviane Traber Profilklasse, wo Email gesetzt wird und dann an
 *         Anwender vererbt.
 */
public class Profil {
	private String email;
	private String domain = "@student.fh-hwz.ch";

	/*
	 * Standard Konstruktor - Die E-Mail Adresse wird mit leerem String initialisiert.
	 */
	public Profil() {
		this.email = "";
	}

	/*
	 * E-Mail Adresse des Profils holen.
	 */
	public String getEmail() {
		return email;
	}

	/*
	 * E-Mail Adress des Profils setzen.
	 */
	public void setEmail(String email) {
		this.email = email;
	}

}
