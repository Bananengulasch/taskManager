package taskManager;

import java.util.Scanner;

public class Kommandozeilenmen� {

	Scanner scan;

	public Kommandozeilenmen�() {
		this.scan = new Scanner(System.in);
	}

	public void Men�Anzeigen() {
		System.out.println("------------------------------");
		System.out.println("HAUPTMEN�");
		System.out.println("1) HINZUF�GEN");
		System.out.println("2) AUSGABE");
		System.out.println("3) FILTERN");
		System.out.println("4) exit");
	}

	public void start() {
		String s = "-";
		while (!s.equals("4")) {
		Men�Anzeigen();
		s = scan.nextLine();
			switch(s)
			{
			case "1":
				this.hinzuf�gen();
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
	
	public void hinzuf�gen() {
		System.out.println("------------------------------");
		System.out.println("Aufgabe mit oder ohne Deadline hinzuf�gen?");
		System.out.println("     Mit		Ohne");
		String s = scan.nextLine();
		switch(s.toLowerCase())
		{
			case "mit":
				this.hinzuf�genMitDeadline();
				break;
			case "ohne":
				this.hinzuf�genOhneDeadline();
				break;
			default:
				this.fehler();
				break;
		}			
	}
	
	public void hinzuf�genMitDeadline() {
		System.out.println("Geben Sie den Aufgabentext ein:");
		String text = scan.nextLine();
		System.out.println("Geben Sie das aktuelle Datum ein:");
		String aktuellesDatum = scan.nextLine();
		System.out.println("Geben Sie die Deadline der Aufgabe ein:");
		String deadline = scan.nextLine();
		
//		Aufgabe a = new AufgabeMitDeadline(text, aktuellesDatum, deadline);

	}
	
	public void hinzuf�genOhneDeadline() {
		System.out.println("Geben Sie den Aufgabentext ein:");
		String text = scan.nextLine();
		
//		Aufgabe a = new Aufgabe(text, datumErstellung);
	}
		
	public void ausgabe(){			
		System.out.println("------------------------------");
		System.out.println("");
	}
		
	public void filtern(){
		System.out.println("------------------------------");
	}
		
	public void fehler(){
		System.out.println("Sie k�nnen nur 1,2 oder 3 eingeben!");
	}
}
