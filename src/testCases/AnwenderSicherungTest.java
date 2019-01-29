package testCases;

import org.junit.jupiter.api.Test;

import enums.AnwenderSicherungStatus;
import enums.AnwenderStatus;
import junit.framework.TestCase;
import model.Anwender;
import model.AnwenderSicherung;

public class AnwenderSicherungTest extends TestCase {
private AnwenderSicherung anwenderSicherung; 
	
	
	@Test
	 public void testAnwenderSicherung()
	 {
		 anwenderSicherung = new AnwenderSicherung();
		 assertEquals(AnwenderSicherungStatus.KEIN.getAnwenderSicherungsStatus(),
					anwenderSicherung.getAnwenderSicherungStatus().getAnwenderSicherungsStatus());
		 assertEquals("c:\\temp\\TerminListe.noice",
				 	anwenderSicherung.getFileNamePath());
	 }
	
	@Test
	 public void testAnwenderSicherungLaden()
	 {
		anwenderSicherung = new AnwenderSicherung();
		assertEquals(null,
					anwenderSicherung.deserialzeModel());
		anwenderSicherung.setFileNamePath("/Users/gast/git/Team_noice_EndEdition/c:/temp/TerminListe.noice");
		assertEquals(AnwenderSicherungStatus.LADEN_ERFOLGREICH.getAnwenderSicherungsStatus(),
				anwenderSicherung.deserialzeModel().getAnwenderStatus().getAnwenderStatus());
	 }

}



