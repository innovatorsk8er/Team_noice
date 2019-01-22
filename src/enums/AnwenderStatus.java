package enums;
/**
 * 
 * @author Viviane Traber
 * Enumerations für den Status in dem sich der Anwender befindet. 
 * Rückgabewerte fürs GUI
 *
 */
public enum AnwenderStatus {

	NICHT_EINSATZBEREIT {
		@Override
		public String getAnwenderStatus() {
			return "Profil unvollständig & nicht einsatzbereit!";
		}
	},

	EINSATZBEREIT {
		@Override
		public String getAnwenderStatus() {
			return "Profil ist vollständig, einsatzbereit und gespeichert!";
		}
	},

	OFFEN_NAME {
		@Override
		public String getAnwenderStatus() {
			return "Nachname-Feld ist leer - Bitte befüllen!";
		}
	},

	OFFEN_VORNAME {
		@Override
		public String getAnwenderStatus() {
			return "Vorname-Feld ist leer - Bitte befüllen!";
		}
	},

	OFFEN_EMAIL {
		@Override
		public String getAnwenderStatus() {
			return "E-Mail-Feld ist leer - Bitte befüllen!";
		}
	};

	public abstract String getAnwenderStatus();
}
