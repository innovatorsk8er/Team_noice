package testCases;

import org.junit.jupiter.api.Test;

import enums.AnwenderSicherungStatus;
import enums.AnwenderStatus;
import junit.framework.TestCase;
import model.Model;


/**
 * @author Ernesto Escalier
 * Mit diesem TestCase wird das Model im MVC-Pattern getestet.
 */

public class ModelTest extends TestCase{


	private Model			model;
	
	//Test: Alle wichtigen Variabeln für das Model werden getestet
	@Test
	public void testInitModel() {
		model = new Model();
		assertEquals(model.getAnwender().getAnwenderStatus(), AnwenderStatus.NICHT_EINSATZBEREIT);
		assertEquals(model.getAnwenderSicherung().getAnwenderSicherungStatus(), AnwenderSicherungStatus.KEIN);
		assertEquals(model.getTerminListeModel().getTerminListe().isEmpty(), true);
		assertEquals(model.getWillkommenTxt(), "Willkommen 'mir' noch unbekannter Benutzer!" + " Bitte lade das Profil");
		assertEquals(model.getKeineZukuenftigeTermine(), "Keine kuenftige Termine momentan vorhanden");
	}
}
