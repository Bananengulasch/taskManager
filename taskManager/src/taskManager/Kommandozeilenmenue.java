package taskManager;

import java.util.ArrayList;
import java.util.Scanner;

public class Kommandozeilenmenue {

	Scanner scan;
	ArrayList<Aufgabe> aufgabenliste = new ArrayList<Aufgabe>();

	public Kommandozeilenmenue() {
		this.scan = new Scanner(System.in);
	}

	public void MenueAnzeigen() {
		System.out.println("------------------------------");
		System.out.println("HAUPTMENÜ");
		System.out.println("1) HINZUFÜGEN");
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
		System.out.println("Geben Sie die Deadline der Aufgabe ein:");
		String deadline = scan.nextLine();
		
//		Aufgabe a = new AufgabeMitDeadline(text, aktuellesDatum, deadline);

	}
	
	public void hinzufuegenOhneDeadline() {
		System.out.println("Geben Sie den Aufgabentext ein:");
		String text = scan.nextLine();
		System.out.println("Geben Sie den Aufgabentext ein:");
		String datumErstellung = scan.nextLine();
	}
		
	public void ausgabe(){			
		System.out.println("------------------------------");
		System.out.println("");
	}
		
	public void filtern(){
		System.out.println("------------------------------");
		
	}
		
	public void fehler(){
		System.out.println("Sie können nur 1,2 oder 3 eingeben!");
	}
}