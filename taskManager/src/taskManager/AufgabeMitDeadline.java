package taskManager;

import java.util.GregorianCalendar;

public class AufgabeMitDeadline extends Aufgabe{

	private GregorianCalendar deadline;

	public AufgabeMitDeadline(String aufgabentext, GregorianCalendar datumErstellung, GregorianCalendar deadline) {
		super(aufgabentext, datumErstellung);
		this.deadline = new GregorianCalendar(2005,12,1);
	}

	public GregorianCalendar getDeadline() {
		return deadline;
	}

	public void setDeadline(GregorianCalendar deadline) {
		this.deadline = deadline;
	}

	//Überschreiben der toString
	@Override
	public String toString() {
		super.toString();
		return "\n"+"Deadline --> " + getDeadline();
	}
}
