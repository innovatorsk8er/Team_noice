package enums;

public enum AnwenderSicherungStatus {
	KEIN {
		@Override
		public String getAnwenderSicherungsStatus() {
			return "Keine Sicherung geladen.";
		}
	},
	SPEICHERN_ERFOLGREICH {
		@Override
		public String getAnwenderSicherungsStatus() {
			return "Profil speichern, war erfolgreich!";
		}
	},
	SPEICHERN_FEHLGESCHLAGEN {
		@Override
		public String getAnwenderSicherungsStatus() {
			return "Profil speichern, ist fehlgeschlagen!";
		}
	},
	LADEN_ERFOLGREICH {
		@Override
		public String getAnwenderSicherungsStatus() {
			return "Profil laden, war erfolgreich!";
		}
	},
	LADEN_FEHLGESCHLAGEN {
		@Override
		public String getAnwenderSicherungsStatus() {
			return "Profil laden, ist fehlgeschlagen!";
		}
	};

	public abstract String getAnwenderSicherungsStatus();

}
