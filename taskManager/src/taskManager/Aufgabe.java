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
	
	public GregorianCalendar getDatumErstellung() {
		return datumErstellung;
	}
	
	public void setDatumErstellung(GregorianCalendar datumErstellung) {
		this.datumErstellung = datumErstellung;
	}
	
	public static Calendar stringToCalendar(String stringDate, String datePattern) {
	    if (stringDate == null) {
	      return null;
	    }
	    Calendar calendar = new GregorianCalendar();
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
	
	@Override
	public String toString() {
		return "Aufgabe --> " + this.getAufgabentext() + "\n" + "Erstellungsdatum --> " + this.getDatumErstellung();
	}
	 
}
