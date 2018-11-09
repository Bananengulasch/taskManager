package taskManager;

import java.util.ArrayList;

public class Aufgabenbibliothek {

	private ArrayList<Aufgabe> aufgabenliste = new ArrayList<Aufgabe>();
	private ArrayList<Aufgabe> deadlineliste = new ArrayList<Aufgabe>();
	
	//neue Aufgabe hinzufügen
	public void aufgabeHinzufügen(Aufgabe a) {
		aufgabenliste.add(a);
	}
	
	//Aufgabe durch Filtern als erledigt kennzeichnen
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
	
	//Prüft ob die Deadline abgelaufen ist
	public void deadlineAbgelaufen() {
		
	}
	
	//Gibt Meldung, wenn die Deadline abgelaufen ist
	public void deadlinePruefung() {
		
	}
	
	//Fügt alle Deadlines zu einer separaten Liste hinzu
	public void deadlineFiltern() {
		for (Aufgabe a : aufgabenliste)
		{
			if(a instanceof AufgabeMitDeadline) {
				deadlineliste.add(a);
			}
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
	
	//Ausgabe aller Aufgaben
	public void anzeigen() {
		for (Aufgabe a : aufgabenliste) {
			a.toString();
		}
	}
}
