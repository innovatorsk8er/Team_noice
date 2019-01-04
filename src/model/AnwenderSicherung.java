package model;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class AnwenderSicherung {

	private Anwender	anwender;
	private ObjectOutputStream oos;
	

	public void setSicherung(Anwender anwender)
	{
		try {
			FileOutputStream fos = new FileOutputStream ("Team.noice"); //TODO Pfad ist noch undefiniert.
			 oos = new ObjectOutputStream (fos);
			 oos.writeObject (anwender);
			 
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public Anwender	getSicherung() {
		try {
			FileInputStream fis = new FileInputStream ("Team.noice");
		    ObjectInputStream ois = new ObjectInputStream (fis);
		    this.anwender = (Anwender) ois.readObject ();
		    ois.close();
		} catch (Exception e) {
			// TODO: handle exception
		}
		return anwender;
	}
}
