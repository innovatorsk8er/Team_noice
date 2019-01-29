package testCases;

import org.junit.jupiter.api.Test;

import enums.AnwenderStatus;
import junit.framework.TestCase;
import model.Anwender;
import model.AnwenderSicherung;

public class AnwenderSicherungTest extends TestCase {
private AnwenderSicherung anwenderSicherung; 
	
	
	@Test
	 public void testReverse()
	 {
		 anwenderSicherung = new AnwenderSicherung();
		 assertEquals(AnwenderStatus.NICHT_EINSATZBEREIT.getAnwenderStatus(),
					anweder.getAnwenderStatus().getAnwenderStatus());
		 
	 }
}



