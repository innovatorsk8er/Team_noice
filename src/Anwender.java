/**
 * @author Viviane Traber, BWI-A17
 * @since 6.12.18 Anwenderklasse, die beschreibt, welche Eigenschaften ein
 *        Anwender hat.
 */
public class Anwender implements Profil {
	// TerminEinladung einladung = new Anwender();
	private String email;
	private String nachname;
	private String vorname;
	private AnwenderSicherung anwenderSicherung;
	private String domain = "@student.fh-hwz.ch";

	public Anwender() {
		this.getAnwenderSicherung();
		if (anwenderSicherung.getHatProfil()) {

			this.nachname = anwenderSicherung.getAnwender().getNachname();
			this.vorname = anwenderSicherung.getAnwender().getVorname();
			this.email = anwenderSicherung.getAnwender().getEmail();
		} else {
			kontrolleProfil();
		}

	}

	public String getNachname() {
		return nachname;
	}

	public void setNachname(String nachname) {
		this.nachname = nachname;
	}

	public String getVorname() {
		return vorname;
	}

	public void setVorname(String vorname) {
		this.vorname = vorname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Anwender getAnwenderSicherung() {
		return this.anwenderSicherung.getSicherung();
	}

	public void setAnwenderSicherung() {
		this.anwenderSicherung.setSicherung(this);
	}

	private void kontrolleProfil(){
		if(nachname.isEmpty())
		{
			System.out.println(vorname + "Nachname ist leer, bitte eingeben.");
		}
		if (vorname.isEmpty()) 
		{
			System.out.println(nachname + "Vorname ist leer, bitte eingeben.");
		} 
		
	}

	public String domainkontrolle() {
		if (email.contains(domain)) {
			return "Domain ist korrekt";
		} else {
			return "Bitte verwenden Sie eine Student.fh-hwz.ch Adresse.";
		}
	}

	@Override
	public void setEmail() {
		// TODO Auto-generated method stub
		
	}
}
