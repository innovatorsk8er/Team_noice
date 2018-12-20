/**
 * @author Viviane Traber, BWI-A17; Codingstart: 6.12.18; Profilklasse, wo Email
 *         gesetzt wird und dann an Anwender & Eingeladener vererbt. Es können
 *         nur Profile mit einer "@student.fh-hwz.ch"-Adresse erstellt werden
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
	{
	if(email.contains(domain)){		//warum muss hier {} rein?! 
		System.out.println("Domain ist korrekt");
	}
	else System.out.println("Bitte verwenden Sie eine Student.fh-hwz.ch Adresse.");
	}

}
