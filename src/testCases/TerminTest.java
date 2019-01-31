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

public class TerminTest extends TestCase {

	private Termin termin;
	private TerminErstellenStatus terminStatus;
	
	
	@Test
	public void testTermin()
	{
		SimpleDateFormat sdf = new SimpleDateFormat(DatumFormat.DATUM_ZEIT_SCHWEIZ.getFormat());	
		Calendar calendar = new GregorianCalendar(2019,02,07);
		calendar.getTime();
		termin = new Termin("TerminTest", calendar, calendar);
		termin.setOrt("HWZ");
		termin.setReminder(true);
		termin.setEinladungen("ernesto.escalier@blabla.ch;viviane.traber@blabla.ch;alessio.crincoli@bblabla.ch");
		assertEquals(termin.getTitel(),
				termin.getTitel());
		assertEquals(termin.getStartDatumZeit(),
				termin.getStartDatumZeit());
		assertEquals(termin.getEndDatumZeit(),
				termin.getEndDatumZeit());
		assertEquals(termin.getOrt(),
				termin.getOrt());
		assertEquals(termin.isReminder(),
				termin.isReminder());
		assertEquals(termin.getEinladungen(),
				termin.getEinladungen());	
	}
	@Test
	public void testTerminStatus()
	{
		SimpleDateFormat sdf = new SimpleDateFormat(DatumFormat.DATUM_ZEIT_SCHWEIZ.getFormat());	
		Calendar calendar = new GregorianCalendar(0,0,0);
		calendar.getTime();
		termin = new Termin("",calendar, calendar);
		termin.setOrt("");
		termin.setReminder(false);
		termin.setEinladungen("");
		if (termin.getTitel()=="") {
			terminStatus=TerminErstellenStatus.TITEL;
		}
		assertEquals(TerminErstellenStatus.TITEL.getTerminStatus(),
				terminStatus.getTerminStatus());
	}	
	
	
	
}
