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
	private String fileNamePath = "c:\\temp\\TerminListe.noice";
	private AnwenderSicherungStatus anwenderSicherungStatus = AnwenderSicherungStatus.KEIN;

	// Gibt den Speicher.Pfad zur\u00fcck
	public String getFileNamePath() {
		return fileNamePath;
	}

	//Gibt den Enum-Wert des Sicherungsstatus zur\u00fcck
	public AnwenderSicherungStatus getAnwenderSicherungStatus() {
		return anwenderSicherungStatus;
	}

	// Setzt einen neuen Speicherort fest.
	public void setFileNamePath(String path) {
		fileNamePath = path;
	}

	/**
	 * Mit der Uebergabe des Paramemeters Anwenders, werden all Termine sowie
	 * dessen Profil gespeichert. Im Uebrigen wird der Benutzer informiert, ob
	 * der Speichervorgang erfolgreich war oder nicht.
	 * @param anwender Anwender
	 */
	public void serializeModel(Anwender anwender) {
		FileOutputStream fout = null;
		ObjectOutputStream oos = null;

		try {
			fout = new FileOutputStream(fileNamePath);
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

	/**
	 * Es wird das Profil des Benutzers geladen (Objekt Anwender) Auch hier wird der
	 * Status durchgegeben, ob das Laden erfolreich war oder nicht.
	 * @return anwender
	 */
	public Anwender deserialzeModel() {
		Anwender anwender = null;

		FileInputStream fin = null;
		ObjectInputStream ois = null;

		try {
			fin = new FileInputStream(fileNamePath);
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
