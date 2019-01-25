package prototyp;
import java.awt.*;
import java.util.*;
import java.text.*;
import javax.swing.*;
import javax.swing.event.*;
import javax.swing.text.DateFormatter;

public class SpinnerTest {
	public static void main(String[] args) {
		Calendar calendar = new GregorianCalendar();
		Date now = new Date();
		calendar.add(Calendar.DAY_OF_MONTH, -1);
		Date deadline = calendar.getTime();

		final SpinnerDateModel model = new SpinnerDateModel(now, deadline, null, Calendar.DAY_OF_MONTH);
		JSpinner spinner = new JSpinner(model);

		JSpinner.DateEditor editor = new JSpinner.DateEditor(spinner, "dd.MM.yyyy hh:mm:ss");
		DateFormatter formatter = (DateFormatter) editor.getTextField().getFormatter();
		formatter.setAllowsInvalid(false); // this makes what you want
		formatter.setOverwriteMode(true);
		//
		JFormattedTextField ftf = editor.getTextField();
		ftf.setEditable(true);
		ftf.setHorizontalAlignment(JTextField.CENTER);
		ftf.setBackground(new Color(240, 200, 220));
		spinner.setEditor(editor);
		spinner.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				Date value = (Date) model.getValue();
				Date next = (Date) model.getNextValue();
				if (value != null && next != null)
					System.out.println(
							"value = " + editor.getTextField().getText());
			}
		});
		JLabel label = new JLabel("Von-Datum");
		JPanel panel = new JPanel();
		panel.setLayout(null);
		label.setBounds(10, 20, 90, 40);
		panel.add(label);
		spinner.setBounds(90, 20, 150, 40);
		panel.add(spinner);
		
		
		JFrame f = new JFrame();
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.getContentPane().add(panel);
		f.setSize(260, 100); //Breite des Panels! --> Für Einbau
		f.setLocation(500, 500);
		f.setVisible(true);
	}
}