package testCases;

import org.junit.jupiter.api.Test;

import enums.AnwenderSicherungStatus;
import enums.AnwenderStatus;
import junit.framework.TestCase;
import model.Anwender;
import model.AnwenderSicherung;

/**
 * @author Fatma Gediz 
 * Test-AnwendersicheurngsKlasse, f\u00fcr Anwender speichern, laden und Anwendersicherungsstatus
 */

public class AnwenderSicherungTest extends TestCase {
	private AnwenderSicherung anwenderSicherung;
	private Anwender anwender;

	// Test: Status beim Anlegen bzw. Speichernn des Profils/Anwenders 
	@Test
	public void testAnwenderSicherung() {
		anwenderSicherung = new AnwenderSicherung();
		assertEquals(AnwenderSicherungStatus.KEIN.getAnwenderSicherungsStatus(),
				anwenderSicherung.getAnwenderSicherungStatus().getAnwenderSicherungsStatus());
		assertEquals("c:\\temp\\TerminListe.noice", anwenderSicherung.getFileNamePath());
	}

	//Test: Status beim Laden des Anwender 
	@Test
	public void testAnwenderSicherungLaden() {
		anwenderSicherung = new AnwenderSicherung();
		anwenderSicherung.deserialzeModel();
		assertEquals(AnwenderSicherungStatus.LADEN_ERFOLGREICH.getAnwenderSicherungsStatus(),
				anwenderSicherung.getAnwenderSicherungStatus().LADEN_ERFOLGREICH.getAnwenderSicherungsStatus());
	}
	
	// Test: Staus nach dem die Daten des Anwenders bearbeitet werden
	@Test
	public void testAnwenderSicherungSpeichern() {
		anwenderSicherung = new AnwenderSicherung();
		anwender = new Anwender();
		anwender.setVorname("Hans");
		anwender.setNachname("Muster");
		anwender.setEmail("hm@ch.ch");
		anwenderSicherung.serializeModel(anwender);
		assertEquals(AnwenderSicherungStatus.SPEICHERN_ERFOLGREICH.getAnwenderSicherungsStatus(),
				anwenderSicherung.getAnwenderSicherungStatus().SPEICHERN_ERFOLGREICH.getAnwenderSicherungsStatus());
	}
}
