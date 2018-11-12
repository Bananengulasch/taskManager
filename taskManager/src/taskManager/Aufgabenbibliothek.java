package taskManager;

import java.util.ArrayList;

public class Aufgabenbibliothek {

	ArrayList<Aufgabe> aufgabenliste = new ArrayList<Aufgabe>();
	ArrayList<AufgabeMitDeadline> deadlineliste = new ArrayList<AufgabeMitDeadline>();
	
	//neue Aufgabe hinzufÃ¼gen
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
	
	public void medienEntfernen(String name) {
		for (Aufgabe a : aufgabenliste)
		{
	       if (a.getAufgabentext().toLowerCase().trim().contains(name.toLowerCase().trim())) {
	    	   aufgabenliste.remove(a);
	    	   System.out.println("Medium erfolgreich entfernt!");
	    	   break;
	       }else {
	    	   System.out.println("Dieses Medium existiert nicht!");
	       }
		}
	}
	
	//Aufgabe durch Filtern in der Liste finden
	public void aufgabeFiltern(String aufgabe) {
		for (Aufgabe a : aufgabenliste)
		{
	       if (a.getAufgabentext().toLowerCase().trim().equals(aufgabe.toLowerCase().trim())) {
	    	   System.out.println(a);
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
			System.out.println("------------------------------");
			System.out.println(a);
		}
	}
	
	//Entfernen der ausgewählten Aufgabe
		public void erledigt(int index) {
			
				aufgabenliste.remove(index);
			
			}
		}
