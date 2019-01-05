package model;

import enums.AnwenderStatus;

public class Model {
	private Anwender anwender;
	private AnwenderSicherung anwenderSicherung;

	public Model() {
		// Fragen nach neuen Anwender oder laden der Datei

		// wenn neuer Anwender, dann Profil erstellen
	}

	public String setWillkommenTxt() {
		return "< ---- Willkommen 'mir' noch unbekannter Benutzer! ---- >"
				+ "\nBitte Drücke [Return] für vorhanden Benutzer laden" + "\noder [Enter] für neuen Benutzer";
	}

	public String setBenutzerVerwaltungTxt() {
		return "< ---- BENUTZER VERWALTUNG ---- >";
	}

	public AnwenderStatus isAnwenderBereit() {
		if (anwender == null) {
			return AnwenderStatus.NICHT_EINSATZBEREIT;
		}
		return anwender.isKontaktDatenVorhanden();
	}

	public void ladeAnwenderSicherung() {
		anwenderSicherung = new AnwenderSicherung();
		anwender = anwenderSicherung.getSicherung();
	}

	public void setAnwender() {
		anwender = new Anwender();
	}

	public Anwender getAnwender() {
		return anwender;
	}
}
