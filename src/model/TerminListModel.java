package model;

import java.util.ArrayList;

import javax.swing.AbstractListModel;

public class TerminListModel extends AbstractListModel<Termin> {

	private static final long serialVersionUID = 1L;
	private final ArrayList<Termin> terminListe;

	public TerminListModel() {
		terminListe = new ArrayList<Termin>();
	}
    public void addElement(Termin Termin) {
    	terminListe.add(Termin);
        fireIntervalAdded(this, terminListe.size()-1, terminListe.size()-1);
    }
    
    public ArrayList<Termin> getTerminListe(){
    	return terminListe;
    }

    @Override
    public Termin getElementAt(int index) { return terminListe.get(index); }

    @Override
    public int getSize() { return terminListe.size(); }
}