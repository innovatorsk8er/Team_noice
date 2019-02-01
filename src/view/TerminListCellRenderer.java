package view;


import java.awt.Component;

import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.ListCellRenderer;

import model.Termin;

/**
 * @author Ernesto Escalier
 * Jede Zelle bei der JlIst wird mit dieser Klasse die Farber geändert.
 */
public class TerminListCellRenderer implements ListCellRenderer {

	private TerminListCellRenderer defaultRenderer;

	//Holt jeden Termin aus der Liste und passt anhand von dem die Farbe.ß
	public Component getListCellRendererComponent(JList list, Object object, int index,
		      boolean isSelected, boolean cellHasFocus) {
		
		JLabel renderer = (JLabel) defaultRenderer.getListCellRendererComponent(list, object, index,
		        isSelected, cellHasFocus);
		
		if (object instanceof Termin)
		{
			System.out.println("Farbe anpassen!");
		}
	    return renderer;
	  }

}
