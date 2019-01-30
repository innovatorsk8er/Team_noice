package model;

import java.io.Serializable;

import enums.AnwenderStatus;

/**
 * @author Viviane Traber
 * Anwenderklasse, die beschreibt, welche Eigenschaften ein Anwender hat.
 * Erg\u00e4nzungen des Profils/Profildaten
 */

public class Anwender extends Profil implements Serializable{
	private static final long serialVersionUID = 1L;
	private String nachname;
	private String vorname;
	private String email;
	private AnwenderStatus anwenderStatus;

	/*
	 * Standard Konstruktor, der alle erforderlichen Variabeln mit einem Standard-Wert initialsiert.
	 */
	public Anwender() {
		this.nachname = "";
		this.vorname = "";
		this.email = "";
		anwenderStatus = AnwenderStatus.NICHT_EINSATZBEREIT;
	}

	/*
	 * Gibt den Namen des Benutzers zurück
	 */
	public String getNachname() {
		return nachname;
	}

	/*
	 * Setzt den Namen des Benutzers
	 */
	public void setNachname(String nachname) {
		this.nachname = nachname;
	}

	/*
	 * Gibt den Vornamen des Benutzers zurück
	 */
	public String getVorname() {
		return vorname;
	}

	/*
	 * Setzt den Vornamen des Benutzers.
	 */
	public void setVorname(String vorname) {
		this.vorname = vorname;
	}
	
	/*
	 * (non-Javadoc)
	 * @see model.Profil#getEmail()
	 */
	public String getEmail() {
		return email;
	}

	/*
	 * (non-Javadoc)
	 * @see model.Profil#setEmail(java.lang.String)
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/*
	 * Gibt den Status des Anwender-Profils zurück, ob dieser Vollstädnig ist oder nicht.
	 */
	public AnwenderStatus getAnwenderStatus() {
		return anwenderStatus;
	}

	/*
	 * Setzt den Status des AnwenderProfils
	 */
	public void setAnwenderStatus(AnwenderStatus anwenderStatus) {
		this.anwenderStatus = anwenderStatus;
	}
}
