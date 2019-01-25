import enums.Farbe;

public class Termin {
	private String titel;
	private Datum startDatum;
	private Datum endDatum;
	private Calendar startZeit;
	private Calendar endZeit;
	private String ort;
	private Farbe statusFarbe;

	public void setTitel(String titel) {
		this.titel = titel;
	}

	public String getTitel() {
		return titel;
	}

	public void setStartDatum(Datum datum) {
		this.startDatum = datum;
	}

	public Datum getStartDatum() {
		return startDatum;
	}

	public void setStartZeit(Calendar zeit) {
		this.startZeit = zeit;
	}

	public Calendar getStartZeit() {
		return startZeit;
	}

	public void setEndDatum(Datum datum) {
		this.endDatum = datum;
	}

	public Datum getEndDatum() {
		return endDatum;
	}

	public void setEndZeit(Calendar zeit) {
		this.endZeit = zeit;
	}

	public Calendar getEndZeit() {
		return endZeit;
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
}
