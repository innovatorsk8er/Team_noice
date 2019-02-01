package testCases;

import org.junit.jupiter.api.Test;

import enums.AnwenderSicherungStatus;
import enums.AnwenderStatus;
import junit.framework.TestCase;
import model.Anwender;
import model.AnwenderSicherung;
import model.Model;
import model.TerminListModel;

public class ModelTest extends TestCase{

	private Anwender anwender;
	private AnwenderSicherung anwenderSicherung;
	private TerminListModel terminListModel;
	private Model			model;
	
	/* Test: Initialisiere Model*/
	@Test
	public void testInitModel() {
		model = new Model();
		assertEquals(model.getAnwender().getAnwenderStatus(), AnwenderStatus.NICHT_EINSATZBEREIT);
		assertEquals(model.getAnwenderSicherung().getAnwenderSicherungStatus(), AnwenderSicherungStatus.KEIN);
		assertEquals(model.getTerminListeModel().getTerminListe().isEmpty(), true);
		assertEquals(model.getWillkommenTxt(), "Willkommen 'mir' noch unbekannter Benutzer!" + " Bitte lade das Profil");
		assertEquals(model.getKeineZukuenftigeTermine(), "Keine k\u00FCnftige Termine momentan vorhanden");
	}
}
