package model;

import java.util.ArrayList;
import java.util.List;


/**
 * @author Fatma Gediz
 * GUI-Anweisungen für den User 
 */

public class Model {
	private Anwender anwender;
	private AnwenderSicherung anwenderSicherung;
	private TerminListModel terminListModel;

	public Model() {
		// Fragen nach neuen Anwender oder laden der Datei
		anwender = new Anwender();
		anwenderSicherung = new AnwenderSicherung();
		terminListModel = new TerminListModel();
	}

	public String getWillkommenTxt() {
		return "Willkommen 'mir' noch unbekannter Benutzer!"
				+ " Bitte lade das Profil";
	}

	public String getKeineZukuenftigeTermine() {
		return "Keine k\u00FCnftige Termine momentan vorhanden";
	}

	public void ladeAnwenderSicherung() {
		anwender = anwenderSicherung.deserialzeModel();
		if (anwender == null) {
			anwender = new Anwender();
		}
	}

	public void speichereAnwenderSicherung() {
		anwenderSicherung.serializeModel(anwender);
	}
	
	public AnwenderSicherung getAnwenderSicherung() {
		return anwenderSicherung;
	}
	
	public void setAnwender() {
		anwender = new Anwender();
	}

	public Anwender getAnwender() {
		return anwender;
	}
	
	public TerminListModel getTerminListeModel() {
		return terminListModel;
	}
	
}
