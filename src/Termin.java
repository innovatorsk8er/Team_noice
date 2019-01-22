import enums.Farbe;

public class Termin {
	private String titel;
	private Datum startDatum;
	private Datum endDatum;
	private Zeit startZeit;
	private Zeit endZeit;
	private String ort;
	private Attachment attachment;
	private Farbe statusFarbe;

	
	
	
	//public void setSpeicher (BufferedWriter dateiAbleger) {
	//}
	
	public void setTitel (String titel) {
		this.titel=titel;
	}
	
	public String getTitel () {
		return titel;
	}
	
	public void setStartDatum (Datum datum) {
		this.startDatum=datum;
	}
	
	public Datum getStartDatum () {
		return startDatum;
	}
	
	public void setStartZeit (Zeit zeit) {
		this.startZeit=zeit;
	}
	
	public Zeit getStartZeit () {
		return startZeit;
	}
	
	public void setEndDatum (Datum datum) {
		this.endDatum=datum;
	}
	
	public Datum getEndDatum () {
		return endDatum;
	}
	
	public void setEndZeit (Zeit zeit) {
		this.endZeit=zeit;
	}
	
	public Zeit getEndZeit () {
		return endZeit;
	}

	public String getOrt() {
		return ort;
	}

	public void setOrt(String ort) {
		this.ort = ort;
	}

	public Attachment getAttachment() {
		return attachment;
	}

	public void setAttachment(Attachment attachment) {
		this.attachment = attachment;
	}

	public Farbe getStatusFarbe() {
		return statusFarbe;
	}

	public void setStatusFarbe(Farbe statusFarbe) {
		this.statusFarbe = statusFarbe;
	}

	
	
	}
	
	

