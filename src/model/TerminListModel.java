package model;

import java.util.ArrayList;

import javax.swing.AbstractListModel;

/** 
 * 
 * @author Ernesto Escalier
 * das TerminListModel enthaelt Termine als Entities.
 * Somit wird die JList moeglichst aktuell gehalten.
 * 
 */
public class TerminListModel extends AbstractListModel<Termin> {

	private static final long serialVersionUID = 1L;
	private final ArrayList<Termin> terminListe;

	/**Standard Konsttruktor. Hier wird die ArrayList initialisert.*/
	public TerminListModel() {
		terminListe = new ArrayList<Termin>();
	}

	/**
	 * Einfuegen eines Termin-Objekts
	 * @param termin Termin
	 */
	public void addElement(Termin termin) {
		terminListe.add(termin);
		fireIntervalAdded(this, terminListe.size() - 1, terminListe.size() - 1);
	}

	/** Die ArrayListe mit den Terminen drin abholen
	 * @return terminList*/
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