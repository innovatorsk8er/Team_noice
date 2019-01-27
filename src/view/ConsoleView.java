package view;
/**
 * @author Ernesto Escalier
 * GUI; Benutzeroberfläche unserer TerminListe
 */

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import enums.Navigation;
import enums.TerminWiederkehrend;
import model.Termin;
import model.TerminListModel;

import javax.swing.JTabbedPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JList;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.AbstractListModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;

public class ConsoleView extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JPanel termineListePane;
	private JTabbedPane tabbedPane;
	private JList jList;
	private TerminListModel terminListModel;
	private JButton jbtnNeuerTermin;
	private JButton jbtnTerminBearbeiten;
	private JPanel profilPane;
	private JPanel neuerTerminPanel;
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
	private JButton jbtnTabNeuerTerminSchliessen = new JButton("[X]");
	private JButton jbtnTabBearbeteTerminSchliessen = new JButton("[X]");
	private JPanel bearbeiteTerminPanel;
	private JTextField txtTerminTitel;
	private JTextField txtTerminOrt;
	private PanelDatumAuswahl vonDatum;
	private PanelDatumAuswahl bisDatum;
	private JComboBox<TerminWiederkehrend> jComboBoxWTermine;
	private JCheckBox checkBoxReminder;
	private JTextArea jTextAreaEinladungen;
	private JButton jbtnTerminSpeichern = new JButton(Navigation.SPEICHERN.getString());

	/**
	 * Create the frame.
	 * 
	 * @param titel
	 */
	public ConsoleView(String titel, TerminListModel terminListModel) {
		setTitle(titel);
		this.terminListModel = terminListModel;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 780, 615);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		initMainContent();
		setResizable(false);
		setVisible(true);
	}

	public void initNeuerTermin() {
		// Tab-Header-Bereich
		jbtnTabNeuerTerminSchliessen.setOpaque(false);
		jbtnTabNeuerTerminSchliessen.setContentAreaFilled(false);
		jbtnTabNeuerTerminSchliessen.setPreferredSize(new Dimension(45, 15));
		jbtnTabNeuerTerminSchliessen.setFont(new Font("Arial", Font.BOLD, 10));
		String titel = Navigation.NEUER_TERMIN.getString();
		neuerTerminPanel = new JPanel();
		neuerTerminPanel.setName(Navigation.NEUER_TERMIN.getString());

		JPanel pnlTab = new JPanel(new GridBagLayout());
		pnlTab.setOpaque(false);
		JLabel lblTitle = new JLabel(titel);

		GridBagConstraints gbc = new GridBagConstraints();
		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.weightx = 0;

		pnlTab.add(lblTitle, gbc);

		gbc.gridx++;
		gbc.weightx = 0;
		pnlTab.add(jbtnTabNeuerTerminSchliessen, gbc);

		tabbedPane.addTab(titel, null, neuerTerminPanel, "Erstelle hier ein neuen Termin");
		int tabNeuIndex = tabbedPane.indexOfTab(titel);
		tabbedPane.setTabComponentAt(tabNeuIndex, pnlTab);
		tabbedPane.setSelectedIndex(tabNeuIndex);

		// Tab-Body
		neuerTerminPanel.setLayout(null);
		// Titel
		JLabel lblTerminTitel = new JLabel("Titel:");
		lblTerminTitel.setBounds(65, 20, 90, 40);
		neuerTerminPanel.add(lblTerminTitel);
		txtTerminTitel = new JTextField();
		txtTerminTitel.setBounds(168, 20, 455, 40);
		neuerTerminPanel.add(txtTerminTitel);
		// Ort
		JLabel lblTerminOrt = new JLabel("Ort:");
		lblTerminOrt.setBounds(65, 70, 90, 40);
		neuerTerminPanel.add(lblTerminOrt);
		txtTerminOrt = new JTextField();
		txtTerminOrt.setBounds(168, 70, 455, 40);
		neuerTerminPanel.add(txtTerminOrt);
		// Von-Datum
		vonDatum = new PanelDatumAuswahl("Von-Datum");
		vonDatum.setBounds(65, 120, 260, 40);
		neuerTerminPanel.add(vonDatum);
		// Bis-Datum
		bisDatum = new PanelDatumAuswahl("Bis-Datum");
		bisDatum.setBounds(370, 120, 500, 40);
		neuerTerminPanel.add(bisDatum);
		// Wiederkehrende Termine
		JLabel lblTerminWk = new JLabel("Wiederkehrend:");
		lblTerminWk.setBounds(65, 170, 90, 40);
		neuerTerminPanel.add(lblTerminWk);
		jComboBoxWTermine = new JComboBox<TerminWiederkehrend>();
		jComboBoxWTermine.setModel(new DefaultComboBoxModel<TerminWiederkehrend>(TerminWiederkehrend.values()));
		jComboBoxWTermine.setBounds(168, 170, 150, 40);
		neuerTerminPanel.add(jComboBoxWTermine);
		// Reminder
		JLabel lblTerminReminder = new JLabel("Reminder:");
		lblTerminReminder.setBounds(65, 220, 90, 40);
		neuerTerminPanel.add(lblTerminReminder);
		checkBoxReminder = new JCheckBox();
		checkBoxReminder.setBounds(168, 220, 150, 40);
		neuerTerminPanel.add(checkBoxReminder);
		// Personen Einladen
		JLabel lblTerminEinladung = new JLabel("Einladen:");
		lblTerminEinladung.setBounds(65, 270, 90, 40);
		neuerTerminPanel.add(lblTerminEinladung);
		jTextAreaEinladungen = new JTextArea();
		jTextAreaEinladungen.setBounds(168, 270, 455, 80);
		jTextAreaEinladungen.setLineWrap(true);
		neuerTerminPanel.add(jTextAreaEinladungen);
		// Termin Speichern
		jbtnTerminSpeichern.setBounds(65, 370, 90, 30);
		neuerTerminPanel.add(jbtnTerminSpeichern);
	}

	public void initBearbeiteTermin() {
		// Tab-Close Button
		jbtnTabBearbeteTerminSchliessen.setOpaque(false);
		jbtnTabBearbeteTerminSchliessen.setContentAreaFilled(false);
		jbtnTabBearbeteTerminSchliessen.setPreferredSize(new Dimension(45, 15));
		jbtnTabBearbeteTerminSchliessen.setFont(new Font("Arial", Font.BOLD, 10));
		String titel = Navigation.TERMIN_BEARBEITEN.getString();
		bearbeiteTerminPanel = new JPanel();
		bearbeiteTerminPanel.setName(Navigation.TERMIN_BEARBEITEN.getString());

		JPanel pnlTab = new JPanel(new GridBagLayout());
		pnlTab.setOpaque(false);
		JLabel lblTitle = new JLabel(titel);

		GridBagConstraints gbc = new GridBagConstraints();
		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.weightx = 0;

		pnlTab.add(lblTitle, gbc);

		gbc.gridx++;
		gbc.weightx = 0;
		pnlTab.add(jbtnTabBearbeteTerminSchliessen, gbc);

		tabbedPane.addTab(titel, null, bearbeiteTerminPanel, "Termin wird bearbeitet");

		int tabBearbeiteIndex = tabbedPane.indexOfTab(titel);
		tabbedPane.setTabComponentAt(tabBearbeiteIndex, pnlTab);
		tabbedPane.setSelectedIndex(tabBearbeiteIndex);
		// Neuer Termin erstellen Ansicht
		bearbeiteTerminPanel.setLayout(null);
		// Vorname
		/*
		 * neuerTerminPanel = new JLabel("Vorname:"); neuerTerminPanel.setBounds(65, 20,
		 * 90, 40); profilPane.add(lblVorname); txtVorname = new JTextField();
		 * txtVorname.setBounds(168, 20, 190, 40); profilPane.add(txtVorname); //
		 * Nachname lblNachname = new JLabel("Nachname:"); lblNachname.setBounds(65, 70,
		 * 90, 40); profilPane.add(lblNachname); txtNachname = new JTextField();
		 * txtNachname.setBounds(168, 70, 190, 40); profilPane.add(txtNachname); // Mail
		 * lblMail = new JLabel("E-Mail"); lblMail.setBounds(65, 120, 90, 40);
		 * profilPane.add(lblMail); txtMail = new JTextField(); txtMail.setBounds(168,
		 * 120, 190, 40); profilPane.add(txtMail); // Button Bereich jbtnProfilspeichern
		 * = new JButton("Speichern"); jbtnProfilspeichern.setBounds(168, 170, 190, 30);
		 * profilPane.add(jbtnProfilspeichern); // Button Bereich jbtnProfilLaden = new
		 * JButton("Laden"); jbtnProfilLaden.setBounds(168, 220, 190, 30);
		 */
		// profilPane.add(jbtnProfilLaden);
	}

	private void initTermineListePane() {
		jList = new JList<Termin>(terminListModel);
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setViewportView(jList);
		termineListePane = new JPanel();
		tabbedPane.addTab(Navigation.TERMIN_LISTE.getString(), null, termineListePane, "Siehe deine Termine an");
		termineListePane.setLayout(new BorderLayout());
		termineListePane.add(jList, BorderLayout.CENTER);
		// Button-Bereich
		JPanel panelButtons = new JPanel();
		panelButtons.setLayout(new BorderLayout(0, 0));
		jbtnNeuerTermin = new JButton(Navigation.NEUER_TERMIN.getString());
		panelButtons.add(jbtnNeuerTermin, BorderLayout.WEST);
		jbtnTerminBearbeiten = new JButton(Navigation.TERMIN_BEARBEITEN.getString());
		panelButtons.add(jbtnTerminBearbeiten, BorderLayout.EAST);
		termineListePane.add(panelButtons, BorderLayout.SOUTH);
	}

	private void initProfil() {
		profilPane = new JPanel();
		tabbedPane.addTab(Navigation.PROFIL.getString(), null, profilPane, "Passe hier dein Profil an");
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
		jbtnProfilspeichern = new JButton(Navigation.SPEICHERN.getString());
		jbtnProfilspeichern.setBounds(168, 170, 190, 30);
		profilPane.add(jbtnProfilspeichern);
		// Button Bereich
		jbtnProfilLaden = new JButton(Navigation.LADEN.getString());
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
		return jList;
	}

	public void setTerminListe(JList terminListe) {
		this.jList = terminListe;
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

	public JTabbedPane getTabbedPane() {
		return tabbedPane;
	}

	public JButton getJbtnTabNeuerTerminSchliessen() {
		return jbtnTabNeuerTerminSchliessen;
	}

	public JButton getJbtnTabBearbeteTerminSchliessen() {
		return jbtnTabBearbeteTerminSchliessen;
	}

	public JButton getJbtnTerminSpeichern() {
		return jbtnTerminSpeichern;
	}

	public JPanel getPanelTerminBearbeiten() {
		return bearbeiteTerminPanel;
	}

	public JPanel getPanelNeuerTermin() {
		return neuerTerminPanel;
	}

	public JTextField getTxtTerminTitel() {
		return txtTerminTitel;
	}

	public JTextField getTxtTerminOrt() {
		return txtTerminOrt;
	}

	public PanelDatumAuswahl getVonDatum() {
		return vonDatum;
	}

	public PanelDatumAuswahl getBisDatum() {
		return bisDatum;
	}

	public JComboBox<TerminWiederkehrend> getjComboBoxWTermine() {
		return jComboBoxWTermine;
	}

	public JCheckBox getCheckBoxReminder() {
		return checkBoxReminder;
	}

	public JTextArea getjTextAreaEinladungen() {
		return jTextAreaEinladungen;
	}

	public JList getjList() {
		return jList;
	}
	
}
