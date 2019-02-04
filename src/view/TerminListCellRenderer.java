package view;


import java.awt.Component;
import javax.swing.JLabel;
import javax.swing.JList;
import model.Termin;

/**
 * @author Ernesto Escalier
 * Jede Zelle bei der JlIst wird mit dieser Klasse die Farber geändert.
 */
public class TerminListCellRenderer {

	private TerminListCellRenderer defaultRenderer;

	/**Holt jeden Termin aus der Liste und passt anhand von dem die Farbe.
	 * @param list List
	 * @param object Object
	 * @param index Index
	 * @param isSelected IsSelected
	 * @param cellHasFocus CellHasFocus
	 * @return renderer*/
	public Component getListCellRendererComponent(JList<Termin> list, Object object, int index,
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
