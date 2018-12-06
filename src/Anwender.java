
public class Anwender extends Profil { //Speicher Verbindung muss noch hergestellt werden
	
	Anwender Email = (Anwender) new Profil(); 	
	private String Name;
	private String Vorname;
	//Anwender Speicher = new Speicher();

	
	public Anwender () {
		this.Name = "Gediz";
		this.Vorname = "Fatma";
		
		
	}
	public String getName() {
		return Name;
	}


	public void setName(String name) {
		Name = name;
	}


	public String getVorname() {
		return Vorname;
	}


	public void setVorname(String vorname) {
		Vorname = vorname;
	}
	
	
}
