package taskManager;

import java.text.SimpleDateFormat;
import java.util.GregorianCalendar;

public class AufgabeMitDeadline extends Aufgabe{

	private GregorianCalendar deadline;

	public AufgabeMitDeadline(String aufgabentext, GregorianCalendar datumErstellung, GregorianCalendar deadline) {
		super(aufgabentext, datumErstellung);
		this.deadline = deadline;
		
	}

	public GregorianCalendar getDeadline() {
		return deadline;
	}

public String getDeadlineFormatiert() {
		
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd.mm.yyyy");
	    String calendarString = simpleDateFormat.format(deadline.getTime());
	    return calendarString;
	}

	public void setDeadline(GregorianCalendar deadline) {
		this.deadline = deadline;
	}

	@Override
	public String toString() {
		return super.toString() + "\n " + "Deadline --> " + getDeadlineFormatiert();
	}
}
