package taskManager;

import java.util.ArrayList;

public class Aufgabenbibliothek {

	ArrayList<Aufgabe> aufgabenliste = new ArrayList<Aufgabe>();
	ArrayList<AufgabeMitDeadline> deadlineliste = new ArrayList<AufgabeMitDeadline>();
	
	//neue Aufgabe hinzufügen
	public void aufgabeHinzufuegen(Aufgabe a) {
		aufgabenliste.add(a);
	}
	
	//Aufgabe durch Filtern als erledigt "abhaken"
	public void aufgabeErledigt(String aufgabe) {
		for (Aufgabe a : aufgabenliste)
		{
	       if (a.getAufgabentext().toLowerCase().equals(aufgabe.toLowerCase())) {
	    	   aufgabenliste.remove(a);
	    	   System.out.println("Medium erfolgreich entfernt!");
	       }else {
	    	   System.out.println("Dieses Medium existiert nicht!");
	       }
		}
	}
	
	//prüft ob die Deadline abgelaufen ist
	//Wenn ja, gib Meldung
	public void deadlinePruefung() {
		
	}
	
	//Deadline ist abgelaufen
	public void deadlineAbgelaufen() {
		for (Aufgabe a : aufgabenliste)
		{
			
		}
	}
	
	//Aufgabe durch Suchen in der Liste finden
	public void aufgabeFiltern(String aufgabe) {
		for (Aufgabe a : aufgabenliste)
		{
	       if (a.getAufgabentext().toLowerCase().equals(aufgabe.toLowerCase())) {
	    	   a.toString();
	       }
		}
	}
	
	//Aufgabe nach Deadline-Aufgaben in der Liste filtern
	public ArrayList<AufgabeMitDeadline> alleDeadlineAlsListe() {
		for(Aufgabe a : aufgabenliste) {
			if(a instanceof AufgabeMitDeadline) {
				deadlineliste.add((AufgabeMitDeadline)a);
			}
		}
		return deadlineliste;
	}
	
	//Ausgabe aller Aufgaben
	public void anzeigen() {
		for (Aufgabe a : aufgabenliste) {
			System.out.println(a);
		}
	}
	
	//Entfernen der ausgew�hlten Aufgabe
		public void erledigt(int index) {
			
				aufgabenliste.remove(index);
			
			}
		}


