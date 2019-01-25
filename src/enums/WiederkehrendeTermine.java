package enums;

public enum WiederkehrendeTermine {
	NEIN("Nein",0),
	TAEGLICH("T\u00e4glich", 1), 
	WOECHENTLICH("W\u00f6chentlich", 7), 
	MONATLICH("Monatlich", 30),
	JAEHRLICH("J\u00e4hrlich",365);
	
    private final String anzeigen;
    private final int tage;
    
    private WiederkehrendeTermine(String string, int zahl) {
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
