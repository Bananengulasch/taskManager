package taskManager;

import java.util.GregorianCalendar;

public class Aufgabe {

	private String aufgabentext;
	private GregorianCalendar datumErstellung;
	

	public Aufgabe(String aufgabentext, GregorianCalendar datumErstellung) {
		super();
		this.aufgabentext = aufgabentext;
		this.datumErstellung = datumErstellung;
	}

	public String getAufgabentext() {
		return aufgabentext;
	}

	public void setAufgabentext(String aufgabentext) {
		this.aufgabentext = aufgabentext;
	}
	
	public GregorianCalendar getDatumErstellung() {
		return datumErstellung;
	}
	
	public void setDatumErstellung(GregorianCalendar datumErstellung) {
		this.datumErstellung = datumErstellung;
	}

	@Override
	public String toString() {
		return "Aufgabe --> " + this.getAufgabentext() + "\n" + "Erstellungsdatum --> " + this.getDatumErstellung();
	}
}
