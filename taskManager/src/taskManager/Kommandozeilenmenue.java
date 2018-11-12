package taskManager;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Scanner;

public class Kommandozeilenmenue {

	Scanner scan;
	Aufgabenbibliothek ab = new Aufgabenbibliothek();

	public Kommandozeilenmenue() {
		this.scan = new Scanner(System.in);
		bisherigeAufgaben();
	}
	
	public void bisherigeAufgaben() {
		String aktuellesDatum ="20.11.2018";
		String deadline ="30.11.2018";
		GregorianCalendar gc = stringToCalendar(aktuellesDatum, "dd.mm.yyyy");
		GregorianCalendar gc2 = stringToCalendar(deadline, "dd.mm.yyyy");
		Aufgabe a = new AufgabeMitDeadline("APR-H�", gc, gc2);
		ab.aufgabeHinzufuegen(a);
	}

	public void MenueAnzeigen() {
		System.out.println("------------------------------");
		System.out.println("HAUPTMENUE");
		System.out.println("1) HINZUFUEGEN");
		System.out.println("2) AUSGABE");
		System.out.println("3) FILTERN");
		System.out.println("4) exit");
	}

	public void start() {
		String s = "-";
		while (!s.equals("4")) {
		MenueAnzeigen();
		s = scan.nextLine();
			switch(s)
			{
			case "1":
				this.hinzufuegen();
				break;
			case "2":
				this.ausgabe();
				break;
			case "3":
				this.filtern();
				break;
			case "4":
				break;
			default:
				this.fehler();
				break;
			}			
		}
			scan.close();
		}
	
	//neue Aufgabe hinzufügen
	public void hinzufuegen() {
		System.out.println("------------------------------");
		System.out.println("Aufgabe mit oder ohne Deadline hinzufügen?");
		System.out.println("     Mit		Ohne");
		String s = scan.nextLine();
		switch(s.toLowerCase())
		{
			case "mit":
				this.hinzufuegenMitDeadline();
				break;
			case "ohne":
				this.hinzufuegenOhneDeadline();
				break;
			default:
				this.fehler();
				break;
		}			
	}
	
	public void hinzufuegenMitDeadline() {
		System.out.println("Geben Sie den Aufgabentext ein:");
		String text = scan.nextLine();
		System.out.println("Geben Sie das aktuelle Datum ein:");
		String aktuellesDatum = scan.nextLine();
		GregorianCalendar gc = stringToCalendar(aktuellesDatum, "dd.mm.yyyy");
		System.out.println("Geben Sie die Deadline der Aufgabe ein:");
		String deadline = scan.nextLine();
		GregorianCalendar gc2 = stringToCalendar(deadline, "dd.mm.yyyy");
		Aufgabe a = new AufgabeMitDeadline(text, gc, gc2);
		ab.aufgabeHinzufuegen(a);
		System.out.println("Erfolgreich hinzugefuegt!");

	}
	
	public void hinzufuegenOhneDeadline() {
		System.out.println("Geben Sie den Aufgabentext ein:");
		String text = scan.nextLine();
		System.out.println("Geben Sie den Aufgabentext ein:");
		String datumErstellung = scan.nextLine();
	}
		
	public void ausgabe(){			
		System.out.println("------------------------------");
		ab.anzeigen();
	}
		
	public void filtern(){
		System.out.println("------------------------------");
		
	}
		
	public void fehler(){
		System.out.println("Sie koennen nur 1,2 oder 3 eingeben!");
	}
	
	public static GregorianCalendar stringToCalendar(String stringDate, String datePattern) {
	    if (stringDate == null) {
	      return null;
	    }
	    GregorianCalendar calendar = new GregorianCalendar();
	    try {
	      Timestamp newDate = Timestamp.valueOf(stringDate);
	      calendar.setTime(newDate);
	    }
	    catch (Exception e) {
	      SimpleDateFormat simpleDateFormat = new SimpleDateFormat(datePattern);
	      try {
	        calendar.setTime(simpleDateFormat.parse(stringDate));
	      }
	      catch (ParseException pe) {
	        calendar = null;
	      }
	    }
	    return calendar;
	  }
	
}
