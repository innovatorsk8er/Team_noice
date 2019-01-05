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
	private Navigation navigation = Navigation.BENUTZER_VORHANDEN;
	private Transaktion transaktion = Transaktion.GESCHLOSSEN;

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
					switch (navigation) {
					case BENUTZER_VORHANDEN:
						kontrolliereBenutzer();
						break;
					case MENU:
						zeigeMenuliste();
						break;
					case BENUTZER_VERWALTEN:
						try {
							zeigeBenutzerverwaltung();
						} catch (BadLocationException e1) {
							// TODO Auto-generated catch block --> Exception Klasse schreiben
							e1.printStackTrace();
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
				} else if (e.getKeyCode() == KeyEvent.VK_DELETE) {
					switch (navigation) {
					case MENU:
						zeigeMenuliste();
						break;
					case BENUTZER_VERWALTEN:
						zeigeMenuliste();
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

	protected void zeigeBenutzerverwaltung() throws BadLocationException {
		if (model.getAnwender().getAnwenderStatus() == AnwenderStatus.EINSATZBEREIT) {
			if (transaktion == Transaktion.GESCHLOSSEN) {
				ttsAnfang("Überprüfe bitte deine Eingaben" + "\nVorname: " + model.getAnwender().getVorname()
						+ "\nNachname: " + model.getAnwender().getNachname() + "\nE-Mail: "
						+ model.getAnwender().getEmail() + "\n" + "\nWillst du sie berarbeiten? " + "\n [ENTER] -> JA"
						+ "\n [DEL] -> NEIN");
			} else {
				model.getAnwender().setAnwenderStatus(AnwenderStatus.BEARBEITEN);
				ttsEnde("Alles klar - Benutzerverwaltung wird aufgerufen! \nBestätige mit [ENTER]"); // TODO Zeile
																										// LASSEN! -->
																										// Todo später
																										// löschen
			}
		} else {
			System.out.println("Zeige Benutzerverwaltung > AnwenderStatus: " + model.getAnwender().getAnwenderStatus());
			switch (model.getAnwender().getAnwenderStatus()) {
			case NICHT_EINSATZBEREIT:
			case BEARBEITEN:
			case OFFEN_VORNAME:
				if (transaktion == Transaktion.GESCHLOSSEN) {
					ttsAnfang("Bitte gebe deinen Vornamen ein und Bestätige mit [ENTER]:\n\n"
							+ model.getAnwender().getVorname());
				} else {
					model.getAnwender().setVorname(getAnwenderEingabe());
					model.getAnwender().setAnwenderStatus(AnwenderStatus.OFFEN_NAME);
					ttsEnde("Eingabe gespeichert - Weiter mit [ENTER]");
				}
				break;
			case OFFEN_NAME:
				if (transaktion == Transaktion.GESCHLOSSEN) {
					ttsAnfang("Bitte gebe deinen Nachnamen ein und Bestätige mit [ENTER]:\n\n"
							+ model.getAnwender().getNachname());
				} else {
					model.getAnwender().setNachname(getAnwenderEingabe());
					model.getAnwender().setAnwenderStatus(AnwenderStatus.OFFEN_EMAIL);
					ttsEnde("Eingabe gespeichert - Weiter mit [ENTER]");
				}
				break;
			case OFFEN_EMAIL:
				if (transaktion == Transaktion.GESCHLOSSEN) {
					ttsAnfang("Bitte gebe deinen E-Mail ein und Bestätige mit [ENTER]:\n\n"
							+ model.getAnwender().getEmail());
				} else {
					model.getAnwender().setEmail(getAnwenderEingabe());
					model.getAnwender().setAnwenderStatus(model.getAnwender().isKontaktDatenVorhanden()); // Abschluss
																											// und
																											// komplette
																											// Kontrolle
					ttsEnde("Eingabe gespeichert - Weiter mit [ENTER]");
				}
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
			model.setAnwender();
			consoleView.getTxtArea().setText("Oje! Es konnte kein Profil für dich geladen werden. :-("
					+ "\n\nEröffne bitte einen Neuen Account" + "\n\n Drücke [ENTER]");
			navigation = Navigation.BENUTZER_VERWALTEN;
		}
	}

	private void zeigeMenuliste() {
		ttsEnde(""); 
		if (transaktion == Transaktion.GESCHLOSSEN) {
			ttsAnfang("<--- Willkommen in der Navigation --->"
					+ "\n\nGib die Nummer ein und Bestätige mit [ENTER] um ins jeweilige Menu reinzukommen\n"
					+ "\n1. Benutzerverwaltung"
					+ "\n2. Termin erstellen"
					+ "\n3. Terminliste"
					+ "\n4. Speichern"
					+ "\n5. Exit"
					+ "\n\n"
					);
		} else {
			/*model.getAnwender().setNachname(getAnwenderEingabe());
			model.getAnwender().setAnwenderStatus(AnwenderStatus.OFFEN_EMAIL);*/
			ttsEnde("Eingabe gespeichert - Weiter mit [ENTER]");
		}

	}

	private void ttsAnfang(String konsolenInfoAnfang) {
		transaktion = Transaktion.OFFEN;
		consoleView.getTxtArea().setText(konsolenInfoAnfang);
	}

	private void ttsEnde(String konsolenInfoEnde) {
		consoleView.getTxtArea().setText(konsolenInfoEnde);
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
}
