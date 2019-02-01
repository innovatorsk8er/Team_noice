package testCases;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.platform.commons.logging.Logger;

import enums.AnwenderStatus;
import junit.framework.TestCase;
import model.Anwender;

/**
 * @author Ernesto Escalier 
 * Test-Anwender mit 2 Methoden und mehreren Test-Cases
 */
public class AnwenderTest extends TestCase {

	private static Logger log;
	private Anwender anwender;

	
	 // Benutzer-Objekt wird leer instanziert getestet
	@DisplayName("Test - Benutzer ist nicht einsatzbereit.")
	@Test
	public void testBenutzerFrischInstantiert() {
		anwender = new Anwender();
		assertEquals(AnwenderStatus.NICHT_EINSATZBEREIT.getAnwenderStatus(),
				anwender.getAnwenderStatus().getAnwenderStatus());

	}

	//Benutzer wird befüllt und die Werte abgerufen
	@DisplayName("Test - Benutzer ist einsatzbereit.")
	@Test
	public void testBenutzerEinsatzbereit() {
		anwender = new Anwender();
		anwender.setVorname("Hans");
		anwender.setNachname("Muster");
		anwender.setEmail("hans@muster.ch");
		anwender.setAnwenderStatus(AnwenderStatus.EINSATZBEREIT);

		assertEquals(AnwenderStatus.EINSATZBEREIT.getAnwenderStatus(),
				anwender.getAnwenderStatus().getAnwenderStatus());

		assertEquals("Hans", anwender.getVorname());
		assertEquals("Muster", anwender.getNachname());
		assertEquals("hans@muster.ch", anwender.getEmail());

	}

}