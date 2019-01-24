package control;

import java.awt.Font;
import enums.AnwenderStatus;
import model.Model;
import view.ConsoleView;
/**
 * @author Ernesto Escalier
 * 
 */
public class Controller {

	private Model model;
	private ConsoleView consoleView;

	public Controller(Model model, ConsoleView consoleView) {
		super();
		this.model = model;
		this.consoleView = consoleView;

		initView();
	}

	private void initView() {
		consoleView.getLblStatus().setText(model.getWillkommenTxt());
		consoleView.getLblStatus().setFont(new Font(Font.DIALOG, Font.BOLD, 18));
		
		consoleView.getLblReminder().setText(model.getKeineZukuenftigeTermine());
		consoleView.getLblReminder().setFont(new Font(Font.DIALOG, Font.BOLD, 18));
		
		consoleView.getJbtnNeuerTermin().setEnabled(false);
		consoleView.getJbtnTerminBearbeiten().setEnabled(false);
	}

	public void initController() {
		consoleView.getJbtnProfilLaden().addActionListener(e -> ladeProfil());
		consoleView.getJbtnProfilspeichern().addActionListener(e -> speichereProfil());
		consoleView.getJbtnNeuerTermin().addActionListener(e -> neuerTermin());
		consoleView.getJbtnTabNeuerTerminSchliessen().addActionListener(e -> neuerTerminSchliessen());
		consoleView.getJbtnTerminBearbeiten().addActionListener(e -> bearbeiteTermin());
		consoleView.getJbtnTabBearbeteTerminSchliessen().addActionListener(e -> bearbeiteTerminSchliessen());
	}

	private void neuerTermin() {
		consoleView.initNeuerTermin();
		consoleView.getJbtnNeuerTermin().setEnabled(false);
	}
	
	private void neuerTerminSchliessen() {
		consoleView.getTabbedPane().remove(consoleView.getPanelNeuerTermin());
		consoleView.getJbtnNeuerTermin().setEnabled(true);
	}

	private void bearbeiteTermin() {
		consoleView.initBearbeiteTermin();
		consoleView.getJbtnTerminBearbeiten().setEnabled(false);
	}

	private void bearbeiteTerminSchliessen() {
		consoleView.getTabbedPane().remove(consoleView.getPanelTerminBearbeiten());
		consoleView.getJbtnTerminBearbeiten().setEnabled(true);
		
	}
	
	private void speichereProfil() {
		if (consoleView.getTxtVorname().getText().equals("")) {
			consoleView.getLblStatus().setText(AnwenderStatus.OFFEN_VORNAME.getAnwenderStatus());
		}
		else if (consoleView.getTxtNachname().getText().equals("")) {
			consoleView.getLblStatus().setText(AnwenderStatus.OFFEN_NAME.getAnwenderStatus());
		} 
		else if (consoleView.getTxtMail().getText().equals("")) {
			consoleView.getLblStatus().setText(AnwenderStatus.OFFEN_EMAIL.getAnwenderStatus());
		}
		else {
			consoleView.getLblStatus().setText(AnwenderStatus.EINSATZBEREIT.getAnwenderStatus());
			model.getAnwender().setVorname(consoleView.getTxtVorname().getText());
			model.getAnwender().setNachname(consoleView.getTxtNachname().getText());
			model.getAnwender().setEmail(consoleView.getTxtMail().getText());
			model.getAnwender().setAnwenderStatus(AnwenderStatus.EINSATZBEREIT);
			model.speichereAnwenderSicherung();
		}
		consoleView.getLblStatus().setFont(new Font(Font.DIALOG, Font.BOLD, 18));
	}

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
}
