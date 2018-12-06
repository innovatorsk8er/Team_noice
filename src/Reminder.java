
public class Reminder {
	private Zeit reminderZeit;
	private Datum reminderDatum;
	private Termin termin;
	private Termin startDatum;
	private Termin startZeit;

	public Reminder(Datum reminderDatum, Zeit reminderZeit) {
		this.reminderZeit = reminderZeit;
		this.reminderDatum = reminderDatum;
	}

	public Termin geReminder() {
		return this.termin;
	}

	public void setMinutenReminder(int minuten) {
		reminderZeit = Termin.getStartZeit - minuten;
		reminderDatum = if reminderZeit
	}

	public void setStundenReminder(int stunden) {
		reminderZeit = Termin.getStartZeit - stunden;
		reminderDatum = if reminderZeit
	}

	public void setTagReminder(int tag) {
		reminderZeit = Termin.getStartZeit;
		reminderDate = Termin.getStartDatum - tag;
	}

	public void setMonatReminder(int monat) {
		reminderZeit = Termin.getStartZeit;
		reminderDate = Termin.getStartDatum - monat;
	}

}
