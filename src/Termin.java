import enums.Farbe;

public class Termin {
	private String titel;
	private Calendar startDatumZeit;
	private Calendar endDatumZeit;
	private String ort;
	private Farbe statusFarbe;
	private boolean reminder;
	private String einladungen;

	public void setTitel(String titel) {
		this.titel = titel;
	}

	public String getTitel() {
		return titel;
	}

	public void setStartZeit(Calendar zeit) {
		this.startDatumZeit = zeit;
	}

	public Calendar getStartDatumZeit() {
		return startDatumZeit;
	}

	public void setEndZeit(Calendar zeit) {
		this.endDatumZeit = zeit;
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
	
}
