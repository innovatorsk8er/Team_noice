package enums;
/**
 * 
 * @author Alessio Crincoli
 * Status der GUI Navigation
 *
 */

public enum NavationStatus {
	KOMPLETT {
        @Override
        public boolean isNavigationStatusAbgeschlossen() {
            return true;
        }
    }, OFFEN {
        @Override
        public boolean isNavigationStatusAbgeschlossen() {
            return false;
        }
    };
	
	public abstract boolean isNavigationStatusAbgeschlossen();
}
