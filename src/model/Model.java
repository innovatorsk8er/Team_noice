package model;

import enums.AnwenderStatus;

public class Model {
	private Anwender anwender = null;
	private AnwenderSicherung anwenderSicherung;
	private AnwenderStatus anwenderStatus;

	public Model() {
		// Fragen nach neuen Anwender oder laden der Datei

		// wenn neuer Anwender, dann Profil erstellen
	}

	public String setWillkommenTxt() {
		return "< ---- Willkommen 'mir' noch unbekannter Benutzer! ---- >"
				+ "\nBitte Dr�cke [Return] f�r vorhanden Benutzer laden" + "\noder [Enter] f�r neuen Benutzer";
	}

	public String setBenutzerVerwaltungTxt() {
		return "< ---- BENUTZER VERWALTUNG ---- >";
	}

	public AnwenderStatus isAnwenderBereit() {
		if (anwender == null) {
			return anwenderStatus = AnwenderStatus.NICHT_EINSATZBEREIT;
		} else if (anwender.isKontaktDatenVorhanden()) {
			return anwenderStatus = AnwenderStatus.EINSATZBEREIT;
		}
		return anwenderStatus = AnwenderStatus.EINSATZBEREIT;
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

	public AnwenderStatus getAnwenderStatus() {
		return anwenderStatus;
	}

	public void setAnwenderStatus(AnwenderStatus status) {
		anwenderStatus = status;
	}
}
