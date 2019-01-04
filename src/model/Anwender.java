package model;

import enums.AnwenderStatus;

/**
 * @author Viviane Traber, BWI-A17
 * @since 6.12.18 Anwenderklasse, die beschreibt, welche Eigenschaften ein
 *        Anwender hat.
 */
public class Anwender extends Profil { 
	//TerminEinladung einladung = new Anwender();
	private String nachname;
	private String vorname;
	private String email;
	private AnwenderStatus anwenderStatus;
	private boolean status;

	public Anwender() {
		this.nachname = "";
		this.vorname = "";
		this.email = "";
		anwenderStatus = AnwenderStatus.OFFEN_VORNAME;
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
	
	public boolean isKontaktDatenVorhanden() {
		status = !(vorname.isEmpty() && nachname.isEmpty() && email.isEmpty()); //Wenn NICHT leer, dann alles ok)
		return status ;
	}
	
/*
	{if(nachname.length(0))

	{
		if (vorname.length(0)) {
			System.out.println(vorname + nachname + "Vorname und Nachname ist leer, bitte eingeben.");
		} else g
		et.Speicher // Vorname & Nachname in Speicher übergeben		
	}
	
}
*/

	
}

