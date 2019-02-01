package testCases;

import java.util.GregorianCalendar;
import org.junit.jupiter.api.Test;
import junit.framework.TestCase;
import model.Termin;
import model.TerminListModel;

/**
 * @author Ernesto Escalier 
 * Test-TerminListModel, f\u00fcr Terminliste
 */

public class TerminListModelTest extends TestCase {

	private TerminListModel terminListModel;
	private Termin termin;

	// Test: Initialisiere ArrayList leer 
	@Test
	public void testEmptyArrayList() {
		terminListModel = new TerminListModel();
		assertEquals(terminListModel.getTerminListe().isEmpty(), true);
	}

	// Test: F\u00fcge ein Termin in die ArrayListe 
	@Test
	public void testAddArrayList() {
		terminListModel = new TerminListModel();
		termin = new Termin("HWZ-Programmieren", new GregorianCalendar(2019, 2, 1, 13, 24, 00),
				new GregorianCalendar(2019, 2, 2, 13, 24, 00));
		terminListModel.addElement(termin);
		assertEquals(terminListModel.getElementAt(0).getTitel(), "HWZ-Programmieren");
		assertEquals(terminListModel.getSize(), 1);
	}
}
