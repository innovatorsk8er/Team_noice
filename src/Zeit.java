
public class Zeit extends Calendar {

	private String format = "hh/mm";
	public int stunde;
	public int minute;

	public Zeit() {
	}

	public Zeit(int stunde, int minute) {
	}

	public int getStunde() {
		return stunde;
	}

	public void setStunde(int stunde) {
		this.stunde = stunde;
	}

	public int getMinute() {
		return minute;
	}

	public void setMinute(int minute) {
		this.minute = minute;
	}

}
