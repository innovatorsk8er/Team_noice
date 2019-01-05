package control;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.text.BadLocationException;
import javax.swing.text.Utilities;

import enums.AnwenderStatus;
import enums.Navigation;
import enums.Transaktion;
import model.Model;
import view.ConsoleView;

public class Controller {

	private Model model;
	private ConsoleView consoleView;
	private Transaktion transaktion = Transaktion.GESCHLOSSEN;
	private int welchesMenu = 1;
	private static int MENU = 6;

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
				// --> Muss leider drin gelassen werden.
			}

			@Override
			public void keyPressed(KeyEvent e) {
				// System.out.println("KEY-Event: "+e.getKeyText(e.getKeyCode()));
				if (e.getKeyCode() == KeyEvent.VK_ENTER) {
					try {
						zeigeEntsprechendesMenu(welchesMenu);
					} catch (BadLocationException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				} else if (e.getKeyCode() == KeyEvent.VK_DELETE) {
					try {
						zeigeEntsprechendesMenu(MENU);
					} catch (BadLocationException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			}

			@Override
			public void keyReleased(KeyEvent e) {
				// Auto-generated method stub --> Muss leider drin gelassen werden.
			}
		});
	}

	private void kontrolliereBenutzer() throws BadLocationException {
		model.ladeAnwenderSicherung();

		if (model.isAnwenderBereit() == AnwenderStatus.EINSATZBEREIT) {
			consoleView.getTxtArea().setText("Hallo " + model.getAnwender().getVorname()
					+ " deine Termine sind alle geladen und bereit für dich! :-)" + "\n\n Drücke [ENTER]");
		} else if (model.isAnwenderBereit() == AnwenderStatus.KEINE_INSTANZ){
			model.setAnwender();
			consoleView.getTxtArea().setText("Oje! Es konnte kein Profil für dich geladen werden. :-("
					+ "\n\nEröffne bitte einen Neuen Account" + "\n\n Drücke [ENTER]");
		}
	}

	private void zeigeMenuliste() throws NumberFormatException, BadLocationException {
		if (transaktion == Transaktion.GESCHLOSSEN) {
			ttsAnfang("<--- Willkommen in der Navigation --->"
					+ "\n\nGib die Nummer ein und Bestätige mit [ENTER] um ins jeweilige Menu reinzukommen\n"
					+ "\n1. Benutzerverwaltung" + "\n2. Termin erstellen" + "\n3. Terminliste" + "\n4. Speichern"
					+ "\n5. Exit" + "\n\n", MENU);
		} else {
			ttsEnde("");
			zeigeEntsprechendesMenu(Integer.parseInt(getAnwenderEingabe()));
		}

	}

	private void ttsAnfang(String konsolenInfoAnfang, int welchesMenu) {
		transaktion = Transaktion.OFFEN;
		this.welchesMenu = welchesMenu;
		consoleView.getTxtArea().setText(konsolenInfoAnfang);
	}

	private void ttsEnde(String konsolenInfoEnde) {
		if (!konsolenInfoEnde.isEmpty()) {
			consoleView.getTxtArea().setText(konsolenInfoEnde);
		}
		transaktion = Transaktion.GESCHLOSSEN;
	}

	private String getAnwenderEingabe() throws BadLocationException {
		int end = consoleView.getTxtArea().getDocument().getLength();
		int start = Utilities.getRowStart(consoleView.getTxtArea(), end);

		while (start == end) {
			end--;
			start = Utilities.getRowStart(consoleView.getTxtArea(), end);
		}

		String text = consoleView.getTxtArea().getText(start, end - start);
		System.out.println("Antwort Benutzer: " + text);
		return text;
	}

	private void zeigeEntsprechendesMenu(int welches) throws BadLocationException {
		System.out.println("Welches Menu: "+welches);
		Navigation navigation = Navigation.values()[welches];

		switch (navigation) {
		case BENUTZER_VERWALTEN:
			if (model.isAnwenderBereit() == AnwenderStatus.KEINE_INSTANZ) {
				kontrolliereBenutzer();
			}
			zeigeBenutzerverwaltung();
			break;
		case TERMIN_ERSTELLEN:

			break;
		case TERMIN_LISTE:

			break;
		case SPEICHERN:

			break;
		case EXIT:
			consoleView.exit();
			break;
		case MENU:
			zeigeMenuliste();
			break;
		default:
			break;
		}
	}

	protected void zeigeBenutzerverwaltung() throws BadLocationException {
		System.out.println("AnwenderStatus: "+model.getAnwender().getAnwenderStatus());
		if (model.getAnwender().getAnwenderStatus() == AnwenderStatus.EINSATZBEREIT) {
			if (transaktion == Transaktion.GESCHLOSSEN) {
				ttsAnfang("Überprüfe bitte deine Eingaben" + "\nVorname: " + model.getAnwender().getVorname()
						+ "\nNachname: " + model.getAnwender().getNachname() + "\nE-Mail: "
						+ model.getAnwender().getEmail() + "\n" + "\nWillst du sie berarbeiten? " + "\n [ENTER] -> JA"
						+ "\n [DEL] -> NEIN", 1);
				model.getAnwender().setAnwenderStatus(AnwenderStatus.BEARBEITEN);
				System.out.println("AnwenderStatus Nachher: "+model.getAnwender().getAnwenderStatus());
				ttsEnde("");
			}
		} else {
			System.out.println("Bearbeiten: "+model.getAnwender().getAnwenderStatus());
			switch (model.getAnwender().getAnwenderStatus()) {
			case NICHT_EINSATZBEREIT:
			case BEARBEITEN:
			case OFFEN_VORNAME:
				if (transaktion == Transaktion.GESCHLOSSEN) {
					ttsAnfang("Bitte gebe deinen Vornamen ein und Bestätige mit [ENTER]:\n\n"
							+ model.getAnwender().getVorname(), 1);
				} else {
					model.getAnwender().setVorname(getAnwenderEingabe());
					model.getAnwender().setAnwenderStatus(AnwenderStatus.OFFEN_NAME);
					ttsEnde("");
					zeigeBenutzerverwaltung();
				}
				break;
			case OFFEN_NAME:
				if (transaktion == Transaktion.GESCHLOSSEN) {
					ttsAnfang("Bitte gebe deinen Nachnamen ein und Bestätige mit [ENTER]:\n\n"
							+ model.getAnwender().getNachname(), 1);
				} else {
					model.getAnwender().setNachname(getAnwenderEingabe());
					model.getAnwender().setAnwenderStatus(AnwenderStatus.OFFEN_EMAIL);
					ttsEnde("");
					zeigeBenutzerverwaltung();
				}
				break;
			case OFFEN_EMAIL:
				if (transaktion == Transaktion.GESCHLOSSEN) {
					ttsAnfang("Bitte gebe deinen E-Mail ein und Bestätige mit [ENTER]:\n\n"
							+ model.getAnwender().getEmail(), 1);
				} else {
					model.getAnwender().setEmail(getAnwenderEingabe());
					model.getAnwender().setAnwenderStatus(model.getAnwender().isKontaktDatenVorhanden());
					//TODO Speicherfunktion hier einbauen!
					ttsEnde("Alle Eingaben als Profil gespeichert - Weiter mit [ENTER]");
				}
				break;
			default:
				break;
			}
		}
	}
}
