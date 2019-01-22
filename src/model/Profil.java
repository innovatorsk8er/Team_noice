
package model;
/**
 * @author Viviane Traber
 *  Profilklasse, wo Email gesetzt wird und dann an Anwender vererbt.    
 */
public class Profil {
	private String email;
	private String domain = "@student.fh-hwz.ch";

	public Profil() {
		this.email = "";
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}
