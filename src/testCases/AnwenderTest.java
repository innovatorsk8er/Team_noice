package testCases;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.platform.commons.logging.Logger;

import enums.AnwenderStatus;
import junit.framework.TestCase;
import model.Anwender;

public class AnwenderTest extends TestCase {

	private static Logger log;
	private Anwender anweder;
	
	
	 @Test
	 public void testReverse()
	 {
		 anweder = new Anwender();
		 assertEquals(AnwenderStatus.NICHT_EINSATZBEREIT.getAnwenderStatus(),
					anweder.getAnwenderStatus().getAnwenderStatus());
		 
	 }
}
