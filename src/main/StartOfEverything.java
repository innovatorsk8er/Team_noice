package main;

import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;

import control.Controller;
import model.Model;
import view.ConsoleView;
/** 
 * @author Ernesto Escalier
 * MainKlasse; von hier wird das Programm gestartet
 * Start Programm mit Klick auf "Run"
 */

public class StartOfEverything {

	
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
			// If Nimbus is not available
		}
		Model model = new Model();
		ConsoleView consoleView = new ConsoleView("TerminListe 1.0");
		Controller controller = new Controller(model, consoleView);
		controller.initController();
	}
}
