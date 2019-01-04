package model;

public class Model {
	private Anwender anwender = null;
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

	public boolean isAnwenderBereit() {
		if (anwender == null) {
			return false;
		}
		return anwender.isKontaktDatenVorhanden();
	}
	
	public void ladeAnwenderSicherung() {
		anwenderSicherung = new AnwenderSicherung();
		anwender = anwenderSicherung.getSicherung();
	}

	public Anwender getAnwender() {
		return anwender;
	}
}
