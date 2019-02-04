package enums;

/**
 * @author Ernesto Escalier 
 * Enumerations fuer die GUI-Auswahlliste
 */
public enum TerminWiederkehrend {
	NEIN("Nein", 0), TAEGLICH("Taeglich", 1), WOECHENTLICH("Woechentlich", 7), MONATLICH("Monatlich", 30),
	JAEHRLICH("Jaehrlich", 365);

	private final String anzeigen;
	private final int tage;

	private TerminWiederkehrend(String string, int zahl) {
		anzeigen = string;
		tage = zahl;
	}

	@Override
	public String toString() {
		return anzeigen;
	}

	public int getTage() {
		return tage;
	}
}
