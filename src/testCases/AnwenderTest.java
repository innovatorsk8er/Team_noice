package testCases;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.platform.commons.logging.Logger;

import enums.AnwenderStatus;
import junit.framework.TestCase;
import model.Anwender;


/**
 * Test-Anwender und Profil
 * @author Ernesto Escalier 
 */
public class AnwenderTest extends TestCase {

	private static Logger log;
	private Anwender anwender;

	@DisplayName("Test - Benutzer ist nicht einsatzbereit.")
	@Test
	public void testBenutzerFrischInstantiert() {
		anwender = new Anwender();
		assertEquals(AnwenderStatus.NICHT_EINSATZBEREIT.getAnwenderStatus(),
				anwender.getAnwenderStatus().getAnwenderStatus());

	}

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