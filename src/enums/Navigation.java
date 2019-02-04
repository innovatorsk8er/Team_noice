package enums;

/**
 * @author Alessio Crincoli 
 * Navigation fuer das GUI
 */
public enum Navigation {

	PROFIL {
		@Override
		public String getString() {
			return "Profil";
		}
	},
	TERMIN_LISTE {
		@Override
		public String getString() {
			return "Termin Liste";
		}
	},
	NEUER_TERMIN {
		@Override
		public String getString() {
			return "Neuer Termin";
		}
	},
	TERMIN_BEARBEITEN {
		@Override
		public String getString() {
			return "Termin bearbeiten";
		}
	},
	SPEICHERN {
		@Override
		public String getString() {
			return "Speichern";
		}
	},
	LADEN {
		@Override
		public String getString() {
			return "Laden";
		}
	};

	public abstract String getString();

}
