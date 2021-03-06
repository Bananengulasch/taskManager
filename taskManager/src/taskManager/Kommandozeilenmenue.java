package taskManager;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
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
		String a ="20.11.2018";
		String b ="30.11.2018";
		GregorianCalendar gc = stringToCalendar(a, "dd.mm.yyyy");
		GregorianCalendar gc2 = stringToCalendar(b, "dd.mm.yyyy");
		Aufgabe a1 = new AufgabeMitDeadline("APR Hausaufgabe", gc, gc2);
		ab.aufgabeHinzufuegen(a1);
		
		String c ="25.11.2018";
		GregorianCalendar gc3 = stringToCalendar(c, "dd.mm.yyyy");
		Aufgabe a2 = new Aufgabe("BW Hausaufgabe", gc3);
		ab.aufgabeHinzufuegen(a2);
	}

	public void MenueAnzeigen() {
		System.out.println("------------------------------");
		System.out.println("HAUPTMENUE");
		System.out.println("1) HINZUFUEGEN/ENTFERNEN");
		System.out.println("2) AUSGABE");
		System.out.println("3) FILTERN");
		System.out.println("4) exit");
	}
	
	public void MenueBearbeiten() {
		System.out.println("------------------------------");
		System.out.println("HAUPTMENUE");
		System.out.println("1) HINZUFUEGEN");
		System.out.println("2) ENTFERNEN");
		System.out.println("3) exit");
	}
	
	public void MenueAusgabe() {
		System.out.println("------------------------------");
		System.out.println("AUSGABENMENUE");
		System.out.println("1) OHNE DEADLINE");
		System.out.println("2) MIT DEADLINE");
		System.out.println("3) ALLE AUFGABEN");
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
				MenueBearbeiten();
				while (!s.equals("3")) {
					s = scan.nextLine();
					switch(s)
					{
					case "1":			
						this.hinzufuegen();
						break;
					case "2":
						this.entfernen();
						break;
					case "3":
						start();
						break;
					default:
						this.fehler();
						break;
						}			
					}
				this.hinzufuegen();
				break;
			case "2":
				this.ausgabeAuswahl();
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
	
	//neue Aufgabe hinzufuegen
	public void hinzufuegen() {
		System.out.println("------------------------------");
		System.out.println("Aufgabe mit oder ohne Deadline hinzufÃ¼gen?");
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
		
		System.out.println("------------------------------");
		System.out.println("Geben Sie den Aufgabentext ein:");
		String text = scan.nextLine();
		Date date = new Date();
		SimpleDateFormat formatter = new SimpleDateFormat("dd.MM.yyyy");
		String aktuellesDatum = formatter.format(date);
		GregorianCalendar gc = stringToCalendar(aktuellesDatum, "dd.mm.yyyy");	
		System.out.println("Geben Sie die Deadline der Aufgabe ein:");
		String deadline = scan.nextLine();
		GregorianCalendar gc2 = stringToCalendar(deadline, "dd.mm.yyyy");
		if(gc2.before(gc))
		{
			Aufgabe a = new AufgabeMitDeadline(text.toUpperCase(), gc, gc2);
			ab.aufgabeHinzufuegen(a);
		} else {
			Aufgabe a = new AufgabeMitDeadline(text, gc, gc2);
			ab.aufgabeHinzufuegen(a);
		}
		
		System.out.println("Erfolgreich hinzugefuegt!");
		start();

	}
	
	public void hinzufuegenOhneDeadline() {
		System.out.println("------------------------------");
		System.out.println("Geben Sie den Aufgabentext ein:");
		String text = scan.nextLine();
		Date date = new Date();
		SimpleDateFormat formatter = new SimpleDateFormat("dd.MM.yyyy");
		String aktuellesDatum = formatter.format(date);
		GregorianCalendar gc = stringToCalendar(aktuellesDatum, "dd.mm.yyyy");	
		Aufgabe b = new Aufgabe(text, gc);
		ab.aufgabeHinzufuegen(b);
		start();
		
	}
	
	public void entfernen() {
		System.out.println("-----------------------------------------");
		System.out.println("Bitte geben Sie den vollstaendigen Name der gesuchten Aufgabe ein:");
		String s = scan.nextLine();
		ab.medienEntfernen(s);
		start();
	}
		
	public void ausgabe(){	
		ab.anzeigen();
	}
	
	public void ausgabeAuswahl() {
		String s = "-";
		while (!s.equals("3")) {
		MenueAusgabe();
		s = scan.nextLine();
			switch(s)
			{
			case "1":
				this.filternOhneDeadline();
				break;
			case "2":
				this.filternNachDeadline();
				break;
			case "3":
				this.ausgabe();
				break;
			case "4":
				this.start();
				break;
			default:
				this.fehler();
				break;
			}			
		}
	}
		
	public void filternNachDeadline(){
		System.out.println("------------------------------");
		for(Aufgabe a : ab.alleDeadlineAlsListe()) {
			System.out.println(a);
		}
	}
	
	public void filternOhneDeadline(){
		System.out.println("------------------------------");
		ab.anzeigen();
	}
	
	public void filtern() {
		System.out.println("-----------------------------------------");
		System.out.println("Bitte geben Sie den vollstaendigen Text der Aufgabe ein:");
		String s = scan.nextLine();
		ab.aufgabeFiltern(s);
		start();
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
