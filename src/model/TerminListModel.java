package model;

import java.util.ArrayList;

import javax.swing.AbstractListModel;

/** 
 * @author Ernesto Escalier
 * das TerminListModel enthält Termine als Entities.
 * Somit wird die JList möglichst aktuell gehalten.
 */
public class TerminListModel extends AbstractListModel<Termin> {

	private static final long serialVersionUID = 1L;
	private final ArrayList<Termin> terminListe;

	/*
	 * Standard Konsttruktor. Hier wird die ArrayList initialisert.
	 */
	public TerminListModel() {
		terminListe = new ArrayList<Termin>();
	}

	/*
	 * Einfügen eines Termin-Objekts
	 * @param termin
	 */
	public void addElement(Termin Termin) {
		terminListe.add(Termin);
		fireIntervalAdded(this, terminListe.size() - 1, terminListe.size() - 1);
	}

	/*
	 * Die ArrayListe mit den Terminen drin abholen
	 */
	public ArrayList<Termin> getTerminListe() {
		return terminListe;
	}
	
	/*
	 * (non-Javadoc)
	 * @see javax.swing.ListModel#getElementAt(int)
	 */
	@Override
	public Termin getElementAt(int index) {
		return terminListe.get(index);
	}

	/*
	 * (non-Javadoc)
	 * @see javax.swing.ListModel#getSize()
	 */
	@Override
	public int getSize() {
		return terminListe.size();
	}
}