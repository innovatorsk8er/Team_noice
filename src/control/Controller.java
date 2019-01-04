package control;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import enums.Navigation;
import model.Model;
import view.ConsoleView;

public class Controller {

	private Model model;
	private ConsoleView consoleView;
	private Navigation	navigation = Navigation.BENUTZER_VORHANDEN;
	private boolean		neustart = true;

	public Controller(Model model, ConsoleView consoleView) {
		super();
		this.model = model;
		this.consoleView = consoleView;
		
		initConsoleView();
	}

	private void initConsoleView() {
		consoleView.getTxtArea().setText(model.setWillkommenTxt());
		
	}
	
	public void initController() {
		//consoleView.getBtnEnter().addActionListener(e -> starteErsteOrder());
		consoleView.getTxtArea().addKeyListener(new KeyListener() {            
			@Override
			public void keyTyped(KeyEvent e) {
				// TODO Auto-generated method stub     
	        }

			@Override
			public void keyPressed(KeyEvent e) {
				//System.out.println("test: "+e.getKeyCode());
				//System.out.println("ENTER wurde gedrückt");
	            if (e.getKeyCode() == KeyEvent.VK_ENTER) {
	            	switch (navigation) {
					case BENUTZER_VORHANDEN:
						kontrolliereBenutzer();
						break;
					case MENU:
						zeigeMenuliste();
						break;
					case BENUTZER_VERWALTEN:
						zeigeBenutzerverwaltung();
						break;
					case TERMIN_ERSTELLEN:
						break;
					case TERMIN_LISTE:
						break;
					case SPEICHERN:
						break;
					case EXIT:
						break;
					default:
						break;
					}
	            } 				
			}
			@Override
			public void keyReleased(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
	}

	protected void zeigeBenutzerverwaltung() {
		/*consoleView.getTxtArea().setText(
				"Überprüfe bitte deine Eingaben"
				+ "Vorname: " + model.getAnwender().get
		*/
	}

	private void kontrolliereBenutzer() {
		model.ladeAnwenderSicherung();
		if (model.isAnwenderBereit()) {
			consoleView.getTxtArea().setText(
					"Hallo "
					+ model.getAnwender().getVorname()
					+ " deine Termine sind alle geladen und bereit für dich! :-)"	
					+ "\n\n Drücke [ENTER]"
					); 
			navigation = Navigation.MENU;
		} else {
			consoleView.getTxtArea().setText(
					"Oje! Es konnte kein Profil für dich geladen werden. :-("
					+ "\nEröffne bitte einen Neuen Account"
					+ "\n\n Drücke [ENTER]"
					);
			navigation = Navigation.BENUTZER_VERWALTEN;
		}
	}
	
	private void zeigeMenuliste() {
		// TODO Auto-generated method stub
		
	}
}
