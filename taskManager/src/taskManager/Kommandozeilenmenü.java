package taskManager;


	import java.util.Scanner;

public class Kommandozeilenmenü {

	Scanner scan;

	public Kommandozeilenmenü() {
		this.scan = new Scanner(System.in);
	}

	public void MenüAnzeigen() {
		System.out.println("MENÜ");
		System.out.println("1) HINZUFÜGEN");
		System.out.println("2) AUSGABE");
		System.out.println("3) FILTERN");
		System.out.println("4) exit");
	}

	public void start() {
		String s = "-";
		while (!s.equals("4")) {
		MenüAnzeigen();
		s = scan.nextLine();
			switch(s)
			{
			case "1":
				this.ausgabe();
				break;
			case "2":
				this.rechnen();
				break;
			case "3":
				this.rechnen();
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
		
	public void ausgabe()
	{			
		System.out.println("AUSGABE");
	}
		
	public void rechnen()
	{
		System.out.println("RECHNEN 1+1 = 2");
	}
		
	public void fehler()
	{
		System.out.println("Sie können nur 1,2 oder 3 eingeben!");
	}
}
