package view;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.SpinnerDateModel;
import javax.swing.text.DateFormatter;

import enums.DatumFormat;

/**
 * @author Ernesto Escalier
 * JPanel mit den Datumfelder, damit für der Benutzer eine Auswahl treffen kann.
 */
public class PanelDatumAuswahl extends JPanel{
	private static final long serialVersionUID = 1L;
	private String strName;
	private JSpinner.DateEditor editor;

	/**
	 * Dieser JPanel hat eine Bezeichnung, damit beim 
	 * GUI-Aufbau dies unterschieden werden kann
	 * @param strName StrName
	 */
	public PanelDatumAuswahl(String strName) {
		this.strName = strName;

		erstelleDatumZeitPanel();
	}

	/** Die Felder Von-Bis-Datum werden mit einem Spinner initialisiert.*/
	private void erstelleDatumZeitPanel() {
		Calendar calendar = new GregorianCalendar();
		Date now = new Date();
		calendar.add(Calendar.DAY_OF_MONTH, -1);
		Date deadline = calendar.getTime();

		final SpinnerDateModel model = new SpinnerDateModel(now, deadline, null, Calendar.DAY_OF_MONTH);
		JSpinner spinner = new JSpinner(model);

		editor = new JSpinner.DateEditor(spinner, "dd.MM.yyyy hh:mm:ss");
		DateFormatter formatter = (DateFormatter) editor.getTextField().getFormatter();
		formatter.setAllowsInvalid(false); // Hier werden die Eingaben sofort kontrolliert.
		formatter.setOverwriteMode(true);
		spinner.setEditor(editor);

		JLabel label = new JLabel(strName+":");
		this.setLayout(null);
		label.setBounds(0, 0, 90, 40);
		this.add(label);
		spinner.setBounds(103, 0, 150, 40);
		this.add(spinner);
	}

	/** Hier wird das Datum initialisiert. 
	 * @return Calendar-Objekt
	 * @throws ParseException wirft eine Fehlermeldung, falls ein String nicht ins Datum-Objekt umwegendalt werden kann
	 */
	public Calendar getCalendar() throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat(DatumFormat.DATUM_ZEIT_SCHWEIZ.getFormat());
		Date date = sdf.parse(editor.getTextField().getText());
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		return cal;
	}
	
	// Name des JPanels wird geladen.
	public String getName() {
		return strName;
	}

	/**
	 * Damit das Datum bearbeitet werden kann wird der Editor des Spinners
	 * returniert.
	 * @return JSpinner
	 */
	public JSpinner.DateEditor getEditor() {
		return editor;
	}
}
