package testCases;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;

import org.junit.jupiter.api.Test;

import enums.AnwenderSicherungStatus;
import enums.DatumFormat;
import enums.TerminErstellenStatus;
import junit.framework.TestCase;
import model.Anwender;
import model.AnwenderSicherung;
import model.Termin;

/**
 * @author Fatma Gediz 
 * Test-Terminklasse, f\u00fcr Terminerstellung und Terminstatus
 */

public class TerminTest extends TestCase {

	private Termin termin;
	private TerminErstellenStatus terminStatus;
	private SimpleDateFormat sdf;
	
	//Test: Termin erstellen
	@Test
	public void testTermin()
	{
		SimpleDateFormat sdf = new SimpleDateFormat(DatumFormat.DATUM_ZEIT_SCHWEIZ.getFormat());
		Calendar start = new GregorianCalendar(2019,2,1,13,24,00);	
		Calendar end = new GregorianCalendar(2019,2,2,13,24,00);
		termin = new Termin("TerminTest", start, end);
		termin.setOrt("HWZ");
		termin.setReminder(true);
		termin.setEinladungen("ernesto.escalier@blabla.ch;viviane.traber@blabla.ch;alessio.crincoli@bblabla.ch");
		assertEquals("TerminTest",
				termin.getTitel());
		assertEquals(start,
				termin.getStartDatumZeit());
		assertEquals(end,
				termin.getEndDatumZeit());
		assertEquals("HWZ",
				termin.getOrt());
		assertEquals(true,
				termin.isReminder());
		assertEquals("ernesto.escalier@blabla.ch;viviane.traber@blabla.ch;alessio.crincoli@bblabla.ch",
				termin.getEinladungen());	
	}

	
}
