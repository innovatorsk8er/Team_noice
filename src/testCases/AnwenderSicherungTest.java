package testCases;

import org.junit.jupiter.api.Test;

import enums.AnwenderSicherungStatus;
import enums.AnwenderStatus;
import junit.framework.TestCase;
import model.Anwender;
import model.AnwenderSicherung;

public class AnwenderSicherungTest extends TestCase {
private AnwenderSicherung anwenderSicherung;
private Anwender anwender;
	
	
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
		anwenderSicherung.deserialzeModel();
		assertEquals(AnwenderSicherungStatus.LADEN_ERFOLGREICH.getAnwenderSicherungsStatus(),
				anwenderSicherung.getAnwenderSicherungStatus().LADEN_ERFOLGREICH.getAnwenderSicherungsStatus());
	 }

	@Test
	public void testAnwenderSicherungSpeichern()
	{
		anwenderSicherung = new AnwenderSicherung();
		anwender = new Anwender();
		anwender.setVorname("Fatma");
		anwender.setNachname("Gediz");
		anwender.setEmail("fg@ch.ch");
		anwenderSicherung.serializeModel(anwender);
		assertEquals(AnwenderSicherungStatus.SPEICHERN_ERFOLGREICH.getAnwenderSicherungsStatus(),
				anwenderSicherung.getAnwenderSicherungStatus().SPEICHERN_ERFOLGREICH.getAnwenderSicherungsStatus());
	}
}


