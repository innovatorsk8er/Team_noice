package enums;
import java.awt.Color;
/**
 * 
 * @author Alessio Crincoli
 * Enums für die Status-Farben der Termine
 *
 */

public enum Farbe {

	OFFEN(255, 255, 255),
	FAELLIG(255, 59, 48),
	ABGESCHLOSSEN(76, 217, 100);

	private final int r;
	private final int g;
	private final int b;
	private final String rgb;

	private Farbe(final int r, final int g, final int b) {
		this.r = r;
		this.g = g;
		this.b = b;
		this.rgb = r + ", " + g + ", " + b;
	}
	
	public String getRGB() {
        return rgb;
    }

    //You can add methods like this too
    public int getRed(){
        return r;
    }

    public int getGreen(){
        return g;
    }

    public int getBlue(){
        return b;
    }

    //Or even these
    public Color getColor(){
        return new Color(r,g,b);
    }

    public int getARGB(){
        return 0xFF000000 | ((r << 16) & 0x00FF0000) | ((g << 8) & 0x0000FF00) | b;
    }
}
