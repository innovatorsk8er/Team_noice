/**
 * @author Viviane Traber, BWI-A17
 * @since 6.12.18 Anwenderklasse, die beschreibt, welche Eigenschaften ein
 *        Anwender hat.
 */
public class Anwender extends Profil { 
	// AnwenderSicherung Verbindung muss noch hergestellt werden
	Anwender email = (Anwender) new Profil();
	//TerminEinladung einladung = new Anwender();

	private String nachname;
	private String vorname;
	// Speicher speicher = new Anwender ();

	public Anwender() {
		this.nachname = "";
		this.vorname = "";

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

	{if(nachname.length(0))

	{
		if (vorname.length(0)) {
			System.out.println(vorname + nachname + "Vorname und Nachname ist leer, bitte eingeben.");
		} else g
		et.Speicher // Vorname & Nachname in Speicher übergeben		
	}
}
}

