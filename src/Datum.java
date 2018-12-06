
public class Datum extends Calendar {

	private String format = "dd/mm/yyyy";
	public int tag;
	public int monat;
	public int jahr;

	public Datum() {
	}

	public Datum(int tag, int monat, int jahr) {
	
	}
	

	public int getTag() {
		return tag;
	}

	public void setTag(int tag) {
		this.tag = tag;
	}

	public int getMonat() {
		return monat;
	}

	public void setMonat(int monat) {
		this.monat = monat;
	}

	public int getJahr() {
		return jahr;
	}

	public void setJahr(int jahr) {
		this.jahr = jahr;
	}

}
