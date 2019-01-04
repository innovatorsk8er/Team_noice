package control;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import enums.AnwenderStatus;
import enums.Navigation;
import model.Model;
import view.ConsoleView;

public class Controller {

	private Model model;
	private ConsoleView consoleView;
	private Navigation navigation = Navigation.BENUTZER_VORHANDEN;

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
		// consoleView.getBtnEnter().addActionListener(e -> starteErsteOrder());
		consoleView.getTxtArea().addKeyListener(new KeyListener() {
			@Override
			public void keyTyped(KeyEvent e) {
				//  --> Muss leider drin gelassen werden.
			}

			@Override
			public void keyPressed(KeyEvent e) {
				// System.out.println("KEY-Event: "+e.getKeyText(e.getKeyCode()));
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
				} else if (e.getKeyCode() == KeyEvent.VK_DELETE) {
					switch (navigation) {
					case MENU:
						zeigeMenuliste();
						break;
					case BENUTZER_VERWALTEN:
						if (model.getAnwenderStatus() == AnwenderStatus.EINSATZBEREIT) {
							zeigeMenuliste();
							System.out.println(AnwenderStatus.EINSATZBEREIT);
						}
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
				// Auto-generated method stub --> Muss leider drin gelassen werden.
			}
		});
	}

	protected void zeigeBenutzerverwaltung() {
		if (model.isAnwenderBereit() == AnwenderStatus.EINSATZBEREIT) {
			consoleView.getTxtArea()
					.setText("Überprüfe bitte deine Eingaben" + "\nVorname: " + model.getAnwender().getVorname()
							+ "\nNachname: " + model.getAnwender().getNachname() + "\nE-Mail: "
							+ model.getAnwender().getEmail() + "\n" + "\nWillst du sie berarbeiten? "
							+ "\n [ENTER] -> JA" + "\n [DEL] -> NEIN");
		} else {
			model.setAnwender();
			switch (model.getAnwenderStatus()) {
			case OFFEN_NAME:
				//TODO
				model.setAnwenderStatus(AnwenderStatus.OFFEN_VORNAME);
				break;
			case OFFEN_VORNAME:
				//TODO
				model.setAnwenderStatus(AnwenderStatus.OFFEN_EMAIL);
				break;
			case OFFEN_EMAIL:
				//TODO
				model.setAnwenderStatus(AnwenderStatus.EINSATZBEREIT);
				break;
			default:
				break;
			}
		}
	}

	private void kontrolliereBenutzer() {
		model.ladeAnwenderSicherung();
		if (model.isAnwenderBereit() == AnwenderStatus.EINSATZBEREIT) {
			consoleView.getTxtArea().setText("Hallo " + model.getAnwender().getVorname()
					+ " deine Termine sind alle geladen und bereit für dich! :-)" + "\n\n Drücke [ENTER]");
			navigation = Navigation.MENU;
		} else {
			consoleView.getTxtArea().setText("Oje! Es konnte kein Profil für dich geladen werden. :-("
					+ "\nEröffne bitte einen Neuen Account" + "\n\n Drücke [ENTER]");
			navigation = Navigation.BENUTZER_VERWALTEN;
		}
	}

	private void zeigeMenuliste() {
		// TODO Auto-generated method stub

	}
}
