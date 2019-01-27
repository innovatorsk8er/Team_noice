package view;

import java.awt.Color;
import java.awt.Component;

import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.ListCellRenderer;

import model.Termin;

public class TerminListCellRenderer implements ListCellRenderer {

	private TerminListCellRenderer defaultRenderer;

	public Component getListCellRendererComponent(JList list, Object object, int index,
		      boolean isSelected, boolean cellHasFocus) {
		
		JLabel renderer = (JLabel) defaultRenderer.getListCellRendererComponent(list, object, index,
		        isSelected, cellHasFocus);
		
		if (object instanceof Termin)
		{
			System.out.println("Farbe anpassen!");
		}
/*		
	    if (isSelected) {
	      setBackground(list.getSelectionBackground());
	      setForeground(list.getSelectionForeground());
	    } else {
	      setBackground(list.getBackground());
	      setForeground(list.getForeground());
	    }
	    */
	    return renderer;
	  }

}
