package model;

import enums.AnwenderStatus;

/**
 * @author Viviane Traber, BWI-A17
 * @since 6.12.18 Anwenderklasse, die beschreibt, welche Eigenschaften ein
 *        Anwender hat.
 */
public class Anwender extends Profil {
	// TerminEinladung einladung = new Anwender();
	private String nachname;
	private String vorname;
	private String email;
	private AnwenderStatus anwenderStatus;

	public Anwender() {
		this.nachname = "";
		this.vorname = "";
		this.email = "";
		anwenderStatus = AnwenderStatus.NICHT_EINSATZBEREIT;
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

	public AnwenderStatus isKontaktDatenVorhanden() {
		if (vorname.isEmpty() && nachname.isEmpty() && email.isEmpty()) {
			return anwenderStatus = AnwenderStatus.NICHT_EINSATZBEREIT;
		}
		if (vorname.isEmpty()) {
			return anwenderStatus = AnwenderStatus.OFFEN_VORNAME;
		}
		if (nachname.isEmpty()) {
			return anwenderStatus = AnwenderStatus.OFFEN_NAME;
		}
		if (email.isEmpty()) {
			return anwenderStatus = AnwenderStatus.OFFEN_EMAIL;
		}
		return anwenderStatus = AnwenderStatus.EINSATZBEREIT;
	}

	public AnwenderStatus getAnwenderStatus() {
		return anwenderStatus;
	}

	public void setAnwenderStatus(AnwenderStatus anwenderStatus) {
		this.anwenderStatus = anwenderStatus;
	}

	/*
	 * {if(nachname.length(0))
	 * 
	 * { if (vorname.length(0)) { System.out.println(vorname + nachname +
	 * "Vorname und Nachname ist leer, bitte eingeben."); } else g et.Speicher //
	 * Vorname & Nachname in Speicher übergeben }
	 * 
	 * }
	 */

}
