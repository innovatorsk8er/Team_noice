package main;

import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;

import control.Controller;
import model.Model;
import view.ConsoleView;

/*
 * @author Ernesto Escalier 
 * MainKlasse; von hier wird das Programm gestartet
 * Start Programm mit Klick auf "Run"
 */

public class StartOfEverything {

	/*
	 * In der Main-Methode wird auch das Look & Feel - Design "Nimbus"
	 * initialisiert. Ansonsten f\u00fcr das MVC-Pattern die wichtigen KLassen
	 * Model, View und Controller. Args-Paramter werden hier nicht bearbeitet oder
	 * ben\u00f6tigt.
	 */
	public static void main(String[] args) {
		// NIMBUS Design
		try {
			for (LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
				if ("Nimbus".equalsIgnoreCase(info.getName())) {
					UIManager.setLookAndFeel(info.getClassName());
					break;
				}
			}
		} catch (Exception e) {
			// Wenn Nimbus-Design nicht vorhanden ist, dann wird das Standard-GUI Design geladen.
		}
		Model model = new Model();
		ConsoleView consoleView = new ConsoleView("TerminListe 1.0", model.getTerminListeModel());
		Controller controller = new Controller(model, consoleView);
		controller.initController();
	}
}
