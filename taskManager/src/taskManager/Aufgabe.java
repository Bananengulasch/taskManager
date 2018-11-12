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
	public String toString() {
		return "Aufgabe --> " + this.getAufgabentext() + "\n" + "Erstellungsdatum --> " + this.getDatumErstellungFormatiert();
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
	
	public static String calendarToString(Calendar calendar, String datePattern) {
		
	    SimpleDateFormat simpleDateFormat = new SimpleDateFormat(datePattern);
	    String calendarString = simpleDateFormat.format(calendar.getTime());
	    return calendarString;
	    
	  }
}
