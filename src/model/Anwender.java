package model;

import java.io.Serializable;

import enums.AnwenderStatus;

/**
 * @author Viviane Traber
 * Anwenderklasse, die beschreibt, welche Eigenschaften ein Anwender hat.
 * Ergänzungen des Profils/Profildaten
 */

public class Anwender extends Profil implements Serializable{
	private static final long serialVersionUID = 1L;
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

	public AnwenderStatus getAnwenderStatus() {
		return anwenderStatus;
	}

	public void setAnwenderStatus(AnwenderStatus anwenderStatus) {
		this.anwenderStatus = anwenderStatus;
	}
}
