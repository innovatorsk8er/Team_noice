package enums;

/**
 * @author Viviane Traber Enumerations 
 * fuer den Status in dem sich der Anwender befindet. Rueckgabewerte fuers GUI
 */

public enum AnwenderStatus {

	NICHT_EINSATZBEREIT {
		@Override
		public String getAnwenderStatus() {
			return "Profil unvollstaendig & nicht einsatzbereit!";
		}
	},

	EINSATZBEREIT {
		@Override
		public String getAnwenderStatus() {
			return "Profil ist vollstaendig, einsatzbereit und gespeichert!";
		}
	},

	OFFEN_NAME {
		@Override
		public String getAnwenderStatus() {
			return "Nachname-Feld ist leer - Bitte befuellen!";
		}
	},

	OFFEN_VORNAME {
		@Override
		public String getAnwenderStatus() {
			return "Vorname-Feld ist leer - Bitte befuellen!";
		}
	},

	OFFEN_EMAIL {
		@Override
		public String getAnwenderStatus() {
			return "E-Mail-Feld ist leer - Bitte befuellen!";
		}
	};

	public abstract String getAnwenderStatus();
}
