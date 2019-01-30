package model;

/**
 * @author Fatma Gediz GUI-Anweisungen f\u00fcr den User
 */

public class Model {
	private Anwender anwender;
	private AnwenderSicherung anwenderSicherung;
	private TerminListModel terminListModel;

	/*
	 * Standart Konstruktor: Hier werden die 3 Variabeln initialisiert:
	 * Anwender, Anwendersicherung und den TerminListModel
	 */
	public Model() {
		// Fragen nach neuen Anwender oder laden der Datei
		anwender = new Anwender();
		anwenderSicherung = new AnwenderSicherung();
		terminListModel = new TerminListModel();
	}

	/* 
	 * Begrüssungstext wird hier abgeholt.
	 */
	public String getWillkommenTxt() {
		return "Willkommen 'mir' noch unbekannter Benutzer!" + " Bitte lade das Profil";
	}

	/*
	 * 1.Standart Info-Meldung bei neu Initialisierung oder wenn wirklich keine Termine vorhanden sind.
	 */
	public String getKeineZukuenftigeTermine() {
		return "Keine k\u00FCnftige Termine momentan vorhanden";
	}

	/*
	 * Das Profil des Anwenders wird über die Schnittstelle AnwenderSicherung
	 * geladen oder wenn es nicht existiert,
	 * leer initialisiert.
	 */
	public void ladeAnwenderSicherung() {
		anwender = anwenderSicherung.deserialzeModel();
		if (anwender == null) {
			anwender = new Anwender();
		}
	}

	/*
	 * Hier wird das Profil über die Schnittstelle AnwenderSicherung abgespeichert.
	 */
	public void speichereAnwenderSicherung() {
		anwenderSicherung.serializeModel(anwender);
	}

	/*
	 * Schnittsstelle zur Anwendersicherungs-Objekt
	 */
	public AnwenderSicherung getAnwenderSicherung() {
		return anwenderSicherung;
	}

	/*
	 * Schnittsstellen-Aktualisierung des Anwendersicherungs-Objekt
	 */
	public void setAnwender() {
		anwender = new Anwender();
	}

	/*
	 * Schnittstelle zum Anwender-Objekt
	 */
	public Anwender getAnwender() {
		return anwender;
	}
	
	/*
	 * Schnittstelle zum TerminListModel-Objekt.
	 * 
	 */
	public TerminListModel getTerminListeModel() {
		return terminListModel;
	}

}
