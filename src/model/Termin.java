package model;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

import enums.DatumFormat;
import enums.Farbe;

/**
 * @author Fatma Gediz Terminklasse, f\u00fcr Terminerstellung inkl. allen Optionen
 */
public class Termin {
	private String titel;
	private Calendar startDatumZeit;
	private Calendar endDatumZeit;
	private String ort;
	private Farbe statusFarbe;
	private boolean reminder;
	private String einladungen;
	
	public Termin(String titel, Calendar startDatumZeit, Calendar endDatumZeit) {
		this.titel = titel;
		this.startDatumZeit = startDatumZeit;
		this.endDatumZeit = endDatumZeit;
	}

	public void setTitel(String titel) {
		this.titel = titel;
	}

	public String getTitel() {
		return titel;
	}

	public void setStartZeit(Calendar startDatumZeit) {
		this.startDatumZeit = startDatumZeit;
	}

	public Calendar getStartDatumZeit() {
		return startDatumZeit;
	}

	public void setEndZeit(Calendar endDatumZeit) {
		this.endDatumZeit = endDatumZeit;
	}

	public Calendar getEndDatumZeit() {
		return endDatumZeit;
	}

	public String getOrt() {
		return ort;
	}

	public void setOrt(String ort) {
		this.ort = ort;
	}

	public Farbe getStatusFarbe() {
		return statusFarbe;
	}

	public void setStatusFarbe(Farbe statusFarbe) {
		this.statusFarbe = statusFarbe;
	}

	public boolean isReminder() {
		return reminder;
	}

	public void setReminder(boolean reminder) {
		this.reminder = reminder;
	}

	public String getEinladungen() {
		return einladungen;
	}

	public void setEinladungen(String einladungen) {
		this.einladungen = einladungen;
	}
	
	private String toDatumString(Calendar cal) {
		Date date = cal.getTime();             
		SimpleDateFormat format = new SimpleDateFormat(DatumFormat.DATUM_SCHWEIZ.getFormat());          
		return format.format(date).toString();
	}
	
	private String toZeitVonBisString(Calendar calVon, Calendar calBis) {
		Date dateVon = calVon.getTime();    
		Date dateBis = calBis.getTime();  
		SimpleDateFormat format = new SimpleDateFormat(DatumFormat.ZEIT_SCHWEIZ.getFormat());          
		return format.format(dateVon).toString() +" - "+format.format(dateBis).toString();
	}
	
	
    public String toString() {
		return toDatumString(startDatumZeit) 
				+ "     " 
				+ toZeitVonBisString(startDatumZeit,endDatumZeit) 
				+ "             "
				+ titel
				;
    }

}
