
public interface Email {
	public String email = "";
	public String textinhalt = "";
	public String betreff = "";

	public default void sendEmail() {
	}

	public default void receiveEmail() {
	}

	public default String getTextinhalt() {
		return textinhalt;
	}

	public default void setTextinhalt(String textinhalt) {
		this.textinhalt = textinhalt;
	}
	
	public default String getBetreff() {
		return betreff;
	}
	
	public default void setBetreff(String betreff) {
		this.betreff = betreff;
	}

}