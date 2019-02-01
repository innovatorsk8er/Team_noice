package enums;

/**
 * @author Viviane Traber Enumerations 
 * f\u00fcr den Status in dem sich der Anwender befindet. R\u00fcckgabewerte f\u00fcrs GUI
 */

public enum AnwenderStatus {

	NICHT_EINSATZBEREIT {
		@Override
		public String getAnwenderStatus() {
			return "Profil unvollst\u00e4ndig & nicht einsatzbereit!";
		}
	},

	EINSATZBEREIT {
		@Override
		public String getAnwenderStatus() {
			return "Profil ist vollst\u00e4ndig, einsatzbereit und gespeichert!";
		}
	},

	OFFEN_NAME {
		@Override
		public String getAnwenderStatus() {
			return "Nachname-Feld ist leer - Bitte bef\u00fcllen!";
		}
	},

	OFFEN_VORNAME {
		@Override
		public String getAnwenderStatus() {
			return "Vorname-Feld ist leer - Bitte bef\u00fcllen!";
		}
	},

	OFFEN_EMAIL {
		@Override
		public String getAnwenderStatus() {
			return "E-Mail-Feld ist leer - Bitte bef\u00fcllen!";
		}
	};

	public abstract String getAnwenderStatus();
}
