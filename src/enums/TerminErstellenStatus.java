package enums;

/**
 * @author Fatma Gediz 
 * Enumerations fuer den Status den ein Termin annehmen kann
 */
public enum TerminErstellenStatus {

	TITEL {
		@Override
		public String getTerminStatus() {
			return "Bitte Titel angeben!";
		}
	},

	START_DATUM_ZEIT {
		@Override
		public String getTerminStatus() {
			return "Bitte Von-Datum angeben!";
		}
	},

	END_DATUM_ZEIT {
		@Override
		public String getTerminStatus() {
			return "Bitte Bis-Adtum angeben!";
		}
	},

	ORT_EINGEBEN {
		@Override
		public String getTerminStatus() {
			return "Ort-Angabe ist leer - Bitte befuellen!";
		}
	},

	WIEDERKEHRENDER_TERMIN {
		@Override
		public String getTerminStatus() {
			return "Kein Wiederkehrender gesetzt!";
		}
	},

	EINLADUNGEN {
		@Override
		public String getTerminStatus() {
			return "Keine Einladung versendet!";
		}
	},

	REMINDER {
		@Override
		public String getTerminStatus() {
			return "Kein Reminder gesetzt.";
		}
	},;

	public abstract String getTerminStatus();
}
