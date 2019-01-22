package model;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

import enums.AnwenderSicherungStatus;
/**
 * @author Ernesto Escalier
 * Sicherungsmechanismus des Anwenderprofils. 
 */
public class AnwenderSicherung implements Serializable {


	private static final long serialVersionUID = 1L;
	private final String FILE_NAME_PATH = "c:\\temp\\TerminListe.noice";
	private AnwenderSicherungStatus anwenderSicherungStatus = AnwenderSicherungStatus.KEIN;

	public String getFileNamePath() {
		return FILE_NAME_PATH;
	}
	
	public AnwenderSicherungStatus getAnwenderSicherungStatus() {
		return anwenderSicherungStatus;
	}

	public void serializeModel(Anwender anwender) {
		FileOutputStream fout = null;
		ObjectOutputStream oos = null;

		try {
			fout = new FileOutputStream(FILE_NAME_PATH);
			oos = new ObjectOutputStream(fout);
			oos.writeObject(anwender);

			System.out.println("Done");
			anwenderSicherungStatus = AnwenderSicherungStatus.SPEICHERN_ERFOLGREICH;

		} catch (Exception ex) {

			ex.printStackTrace();
			anwenderSicherungStatus = AnwenderSicherungStatus.SPEICHERN_FEHLGESCHLAGEN;

		} finally {

			if (fout != null) {
				try {
					fout.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}

			if (oos != null) {
				try {
					oos.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}

	public Anwender deserialzeModel() {
		Anwender anwender = null;

		FileInputStream fin = null;
		ObjectInputStream ois = null;

		try {
			fin = new FileInputStream(FILE_NAME_PATH);
			ois = new ObjectInputStream(fin);
			anwender = (Anwender) ois.readObject();
			anwenderSicherungStatus = AnwenderSicherungStatus.LADEN_ERFOLGREICH;
		} catch (Exception ex) {
			anwenderSicherungStatus = AnwenderSicherungStatus.LADEN_FEHLGESCHLAGEN;
			ex.printStackTrace();
		} finally {

			if (fin != null) {
				try {
					fin.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}

			if (ois != null) {
				try {
					ois.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return anwender;
	}
}
