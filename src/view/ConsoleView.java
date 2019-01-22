package view;
/**
 * @author Ernesto Escalier
 * GUI; Benutzeroberfläche unserer TerminListe
 */

import java.awt.BorderLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.JList;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JButton;

public class ConsoleView extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JPanel termineListePane;
	private JTabbedPane tabbedPane;
	private JList terminListe = new JList<>();
	private JButton jbtnNeuerTermin;
	private JButton jbtnTerminBearbeiten;
	private JPanel profilPane;
	private JLabel lblVorname;
	private JLabel lblNachname;
	private JLabel lblMail;
	private JButton jbtnProfilspeichern;
	private JTextField txtVorname;
	private JTextField txtNachname;
	private JTextField txtMail;
	private JLabel lblReminder;
	private JLabel lblStatus;
	private JButton jbtnProfilLaden;

	/**
	 * Create the frame.
	 * 
	 * @param titel
	 */
	public ConsoleView(String titel) {
		setTitle(titel);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 780, 615);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		initMainContent();
		setVisible(true);
	}

	private void initTermineListePane() {
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setViewportView(terminListe);
		termineListePane = new JPanel();
		tabbedPane.addTab("Termin Liste", null, termineListePane, "Siehe deine Termine an");
		termineListePane.setLayout(new BorderLayout());
		termineListePane.add(terminListe, BorderLayout.CENTER);
		// Button-Bereich
		JPanel panelButtons = new JPanel();
		panelButtons.setLayout(new BorderLayout(0, 0));
		jbtnNeuerTermin = new JButton("Neuer Termin");
		panelButtons.add(jbtnNeuerTermin, BorderLayout.WEST);
		jbtnTerminBearbeiten = new JButton("Termin bearbeiten");
		panelButtons.add(jbtnTerminBearbeiten, BorderLayout.EAST);
		termineListePane.add(panelButtons, BorderLayout.SOUTH);
	}

	private void initProfil() {
		profilPane = new JPanel();
		tabbedPane.addTab("Profil", null, profilPane, "Passe hier dein Profil an");
		// Profil Daten
		profilPane.setLayout(null);
		// Vorname
		lblVorname = new JLabel("Vorname:");
		lblVorname.setBounds(65, 20, 90, 40);
		profilPane.add(lblVorname);
		txtVorname = new JTextField();
		txtVorname.setBounds(168, 20, 190, 40);
		profilPane.add(txtVorname);
		// Nachname
		lblNachname = new JLabel("Nachname:");
		lblNachname.setBounds(65, 70, 90, 40);
		profilPane.add(lblNachname);
		txtNachname = new JTextField();
		txtNachname.setBounds(168, 70, 190, 40);
		profilPane.add(txtNachname);
		// Mail
		lblMail = new JLabel("E-Mail");
		lblMail.setBounds(65, 120, 90, 40);
		profilPane.add(lblMail);
		txtMail = new JTextField();
		txtMail.setBounds(168, 120, 190, 40);
		profilPane.add(txtMail);
		// Button Bereich
		jbtnProfilspeichern = new JButton("Speichern");
		jbtnProfilspeichern.setBounds(168, 170, 190, 30);
		profilPane.add(jbtnProfilspeichern);
		// Button Bereich
		jbtnProfilLaden = new JButton("Laden");
		jbtnProfilLaden.setBounds(168, 220, 190, 30);
		profilPane.add(jbtnProfilLaden);
	}

	private void initReminderContent() {
		lblReminder = new JLabel();
		lblReminder.setToolTipText("Infoleiste \u00FCber k\u00FCnftige Termine.");
		lblReminder.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(lblReminder, BorderLayout.NORTH);
	}

	private void initStatusContent() {
		lblStatus = new JLabel("Alles OK");
		lblStatus.setToolTipText("Status-Leiste \u00FCber Eingaben.");
		lblStatus.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(lblStatus, BorderLayout.SOUTH);
	}

	private void initMainContent() {
		tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		contentPane.add(tabbedPane, BorderLayout.CENTER);

		initReminderContent();
		initStatusContent();
		initTermineListePane();
		initProfil();
	}

	public JList getTerminListe() {
		return terminListe;
	}

	public void setTerminListe(JList terminListe) {
		this.terminListe = terminListe;
	}

	public JTextField getTxtVorname() {
		return txtVorname;
	}

	public void setTxtVorname(JTextField txtVorname) {
		this.txtVorname = txtVorname;
	}

	public JTextField getTxtNachname() {
		return txtNachname;
	}

	public void setTxtNachname(JTextField txtNachname) {
		this.txtNachname = txtNachname;
	}

	public JTextField getTxtMail() {
		return txtMail;
	}

	public void setTxtMail(JTextField txtMail) {
		this.txtMail = txtMail;
	}

	public JLabel getLblReminder() {
		return lblReminder;
	}

	public JLabel getLblStatus() {
		return lblStatus;
	}

	public JButton getJbtnNeuerTermin() {
		return jbtnNeuerTermin;
	}

	public JButton getJbtnTerminBearbeiten() {
		return jbtnTerminBearbeiten;
	}

	public JButton getJbtnProfilspeichern() {
		return jbtnProfilspeichern;
	}

	public JButton getJbtnProfilLaden() {
		return jbtnProfilLaden;
	}

}
