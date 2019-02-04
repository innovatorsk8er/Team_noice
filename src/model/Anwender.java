package model;

import java.io.Serializable;

import enums.AnwenderStatus;

/**
 * @author Viviane Traber 
 * Anwenderklasse, die beschreibt, welche Eigenschaften ein Anwender hat.
 */

public class Anwender implements Serializable {
	private static final long serialVersionUID = 1L;
	private String nachname;
	private String vorname;
	private String email;
	private AnwenderStatus anwenderStatus;

	/**
	 * Standard Konstruktor, der alle erforderlichen Variabeln mit einem
	 * Standard-Wert initialsiert.
	 */
	public Anwender() {
		this.nachname = "";
		this.vorname = "";
		this.email = "";
		anwenderStatus = AnwenderStatus.NICHT_EINSATZBEREIT;
	}

	//Gibt den Namen des Benutzers zur\u00fcck
	public String getNachname() {
		return nachname;
	}

	//Setzt den Namen des Benutzers

	public void setNachname(String nachname) {
		this.nachname = nachname;
	}

	//Gibt den Vornamen des Benutzers zur\u00fcck
	public String getVorname() {
		return vorname;
	}

	// Setzt den Vornamen des Benutzers.
	public void setVorname(String vorname) {
		this.vorname = vorname;
	}

	//Gibt die Email des Benutzers zur\u00fcck
	public String getEmail() {
		return email;
	}

	//Setzt die Email des Benutzers
	public void setEmail(String email) {
		this.email = email;
	}

	/*
	 * Gibt den Status des Anwender-Profils zur\u00fcck, ob dieser Vollst\u00e4dnig
	 * ist oder nicht.
	 */
	public AnwenderStatus getAnwenderStatus() {
		return anwenderStatus;
	}

	//Setzt den Status des AnwenderProfils
	public void setAnwenderStatus(AnwenderStatus anwenderStatus) {
		this.anwenderStatus = anwenderStatus;
	}
}
