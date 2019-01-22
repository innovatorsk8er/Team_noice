package enums;
/**
 * 
 * @author Viviane Traber
 * Enumerations f�r den Status in dem sich der Anwender befindet. 
 * R�ckgabewerte f�rs GUI
 *
 */
public enum AnwenderStatus {

	NICHT_EINSATZBEREIT {
		@Override
		public String getAnwenderStatus() {
			return "Profil unvollst�ndig & nicht einsatzbereit!";
		}
	},

	EINSATZBEREIT {
		@Override
		public String getAnwenderStatus() {
			return "Profil ist vollst�ndig, einsatzbereit und gespeichert!";
		}
	},

	OFFEN_NAME {
		@Override
		public String getAnwenderStatus() {
			return "Nachname-Feld ist leer - Bitte bef�llen!";
		}
	},

	OFFEN_VORNAME {
		@Override
		public String getAnwenderStatus() {
			return "Vorname-Feld ist leer - Bitte bef�llen!";
		}
	},

	OFFEN_EMAIL {
		@Override
		public String getAnwenderStatus() {
			return "E-Mail-Feld ist leer - Bitte bef�llen!";
		}
	};

	public abstract String getAnwenderStatus();
}
