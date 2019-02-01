package control;

import java.awt.Font;
import java.text.ParseException;
import java.util.Calendar;

import enums.AnwenderStatus;
import enums.TerminErstellenStatus;
import enums.TerminWiederkehrend;
import model.Model;
import model.Termin;
import view.ConsoleView;

/**
 * @author Ernesto Escalier 
 * Gibt die Anweisungen weiter an das GUI(View) bzw. die ausgew\u00e4hlten Werte 
 * im GUI an das Model weiter f\u00fcr die Weiterverarbeitung.
 */
public class Controller {

	private Model model;
	private ConsoleView consoleView;

	/*
	 * Hier werden die Schnittstellen zu den Schwesternklassen Model und View
	 * sichergestellt. Ebenfalls werden hier die Listener der Gui-Objekte
	 * initialisiert.
	 */
	public Controller(Model model, ConsoleView consoleView) {
		super();
		this.model = model;
		this.consoleView = consoleView;
		initView();
	}

	// Start initialsierung des GUI
	private void initView() {
		consoleView.getLblStatus().setText(model.getWillkommenTxt());
		consoleView.getLblStatus().setFont(new Font(Font.DIALOG, Font.BOLD, 18));

		consoleView.getLblReminder().setText(model.getKeineZukuenftigeTermine());
		consoleView.getLblReminder().setFont(new Font(Font.DIALOG, Font.BOLD, 18));

		consoleView.getJbtnNeuerTermin().setEnabled(false);
		consoleView.getJbtnTerminBearbeiten().setEnabled(false);
	}

	// Die ActionsListener der Buttons werden hier initialisiert.
	public void initController() {
		consoleView.getJbtnProfilLaden().addActionListener(e -> ladeProfil());
		consoleView.getJbtnProfilspeichern().addActionListener(e -> speichereProfil());
		consoleView.getJbtnNeuerTermin().addActionListener(e -> neuerTermin());
		consoleView.getJbtnTabNeuerTerminSchliessen().addActionListener(e -> neuerTerminSchliessen());
		consoleView.getJbtnTerminBearbeiten().addActionListener(e -> bearbeiteTermin());
		consoleView.getJbtnTabBearbeteTerminSchliessen().addActionListener(e -> bearbeiteTerminSchliessen());
		consoleView.getJbtnTerminSpeichern().addActionListener(e -> neuerTerminSpeichern());
		consoleView.getJbtnTabBearbeteTerminSchliessen().addActionListener(e -> bearbeiterTerminSpeichern());
	}

	// Hiermit wird ein neuer Termin erstellt
	private void neuerTermin() {
		consoleView.initNeuerTermin();
		consoleView.getJbtnNeuerTermin().setEnabled(false);
	}

	// Termin-Tab wird geschlossen
	private void neuerTerminSchliessen() {
		consoleView.getTabbedPane().remove(consoleView.getPanelNeuerTermin());
		consoleView.getJbtnNeuerTermin().setEnabled(true);
	}

	// Termin-Tab wird geschlossen
	private void bearbeiteTermin() {
		consoleView.initBearbeiteTermin(consoleView.getjList().getSelectedValue());
		consoleView.getJbtnTerminBearbeiten().setEnabled(false);
	}

	// "Termin-Tab bearbeiten" wird geschlossen
	private void bearbeiteTerminSchliessen() {
		consoleView.getTabbedPane().remove(consoleView.getPanelTerminBearbeiten());
		consoleView.getJbtnTerminBearbeiten().setEnabled(true);
	}

	// Das Profil-Tab übergibt alle eingetragenen Werte an das Model weiter.
	private void speichereProfil() {
		if (consoleView.getTxtVorname().getText().equals("")) {
			consoleView.getLblStatus().setText(AnwenderStatus.OFFEN_VORNAME.getAnwenderStatus());
		} else if (consoleView.getTxtNachname().getText().equals("")) {
			consoleView.getLblStatus().setText(AnwenderStatus.OFFEN_NAME.getAnwenderStatus());
		} else if (consoleView.getTxtMail().getText().equals("")) {
			consoleView.getLblStatus().setText(AnwenderStatus.OFFEN_EMAIL.getAnwenderStatus());
		} else {
			consoleView.getLblStatus().setText(AnwenderStatus.EINSATZBEREIT.getAnwenderStatus());
			model.getAnwender().setVorname(consoleView.getTxtVorname().getText());
			model.getAnwender().setNachname(consoleView.getTxtNachname().getText());
			model.getAnwender().setEmail(consoleView.getTxtMail().getText());
			model.getAnwender().setAnwenderStatus(AnwenderStatus.EINSATZBEREIT);
			model.speichereAnwenderSicherung();
		}
		consoleView.getLblStatus().setFont(new Font(Font.DIALOG, Font.BOLD, 18));
	}

	// Das Profil wird hiermit ins GUI geladens
	private void ladeProfil() {
		model.ladeAnwenderSicherung();
		consoleView.getLblStatus().setText(model.getAnwender().getAnwenderStatus().getAnwenderStatus());
		consoleView.getTxtVorname().setText(model.getAnwender().getVorname());
		consoleView.getTxtNachname().setText(model.getAnwender().getNachname());
		consoleView.getTxtMail().setText(model.getAnwender().getEmail());
		consoleView.getLblStatus().setFont(new Font(Font.DIALOG, Font.BOLD, 18));
		if (model.getAnwender().getAnwenderStatus() == AnwenderStatus.EINSATZBEREIT) {
			consoleView.getJbtnNeuerTermin().setEnabled(true);
			consoleView.getJbtnTerminBearbeiten().setEnabled(true);
		}
	}

	// Termin anpassungen im GUI werden hier an das Model \u00fcbergeben f\u00fcr
	// das Sichern
	private void neuerTerminSpeichern() {
		if (consoleView.getTxtTerminTitel().getText().equals("")) {
			consoleView.getLblStatus().setText(TerminErstellenStatus.TITEL.getTerminStatus());
		} else {
			Termin termin;
			try {
				termin = new Termin(consoleView.getTxtTerminTitel().getText(), consoleView.getVonDatum().getCalendar(),
						consoleView.getBisDatum().getCalendar());
				termin.setOrt(consoleView.getTxtTerminOrt().getText());
				termin.setReminder(consoleView.getCheckBoxReminder().isSelected());
				termin.setEinladungen(consoleView.getTxtMail().getText());

				if (consoleView.getjComboBoxWTermine().getSelectedItem().equals(TerminWiederkehrend.NEIN)) {
					model.getTerminListeModel().addElement(termin);
				} else {
					while (termin.getStartDatumZeit().before(termin.getEndDatumZeit())) {
						if (consoleView.getjComboBoxWTermine().getSelectedItem().equals(TerminWiederkehrend.TAEGLICH)) {
							termin.getStartDatumZeit().add(Calendar.DATE, 1);
							model.getTerminListeModel().addElement(termin);
						}

						if (consoleView.getjComboBoxWTermine().getSelectedItem()
								.equals(TerminWiederkehrend.WOECHENTLICH)) {
							termin.getStartDatumZeit().add(Calendar.DAY_OF_WEEK_IN_MONTH, 1);
							model.getTerminListeModel().addElement(termin);
						}

						if (consoleView.getjComboBoxWTermine().getSelectedItem()
								.equals(TerminWiederkehrend.MONATLICH)) {
							termin.getStartDatumZeit().add(Calendar.MONTH, 1);
							model.getTerminListeModel().addElement(termin);
						}
						if (consoleView.getjComboBoxWTermine().getSelectedItem()
								.equals(TerminWiederkehrend.JAEHRLICH)) {
							termin.getStartDatumZeit().add(Calendar.YEAR, 1);
							model.getTerminListeModel().addElement(termin);
						}
					}
				}
				consoleView.getTabbedPane().remove(consoleView.getPanelNeuerTermin());
				consoleView.getJbtnNeuerTermin().setEnabled(true);
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	// Button Befehl-Methode
	private void bearbeiterTerminSpeichern() {
		consoleView.getjList().getSelectedValue().setTitel(consoleView.getTxtTerminTitel().getText());
		consoleView.getjList().getSelectedValue().setOrt(consoleView.getTxtTerminOrt().getText());
		consoleView.getjList().getSelectedValue().setEinladungen(consoleView.getTxtMail().getText());
		consoleView.getjList().repaint();
	}

}
