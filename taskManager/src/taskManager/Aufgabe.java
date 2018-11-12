package taskManager;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.sql.Timestamp;

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
	
	public String getDatumErstellungFormatiert() {
		
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd.mm.yyyy");
	    String calendarString = simpleDateFormat.format(datumErstellung.getTime());
	    return calendarString;
	}
	
	public GregorianCalendar getDatumErstellung() {
		
		return datumErstellung;
	}

	public void setDatumErstellung(GregorianCalendar datumErstellung) {
		this.datumErstellung = datumErstellung;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((aufgabentext == null) ? 0 : aufgabentext.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Aufgabe other = (Aufgabe) obj;
		if (aufgabentext == null) {
			if (other.aufgabentext != null)
				return false;
		} else if (!aufgabentext.equals(other.aufgabentext))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Aufgabe --> " + this.getAufgabentext() + "\n" + "Erstellungsdatum --> " + this.getDatumErstellungFormatiert();
	}
}
