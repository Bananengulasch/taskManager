package taskManager;

import java.util.GregorianCalendar;

public class AufgabeMitDeadline extends Aufgabe{

	private GregorianCalendar deadline;

	public AufgabeMitDeadline(String aufgabentext, GregorianCalendar datumErstellung, GregorianCalendar deadline) {
		super(aufgabentext, datumErstellung);
		this.deadline = deadline;
		deadline = new GregorianCalendar(2004,12,1);
	}

	public GregorianCalendar getDeadline() {
		return deadline;
	}

	public void setDeadline(GregorianCalendar deadline) {
		this.deadline = deadline;
	}

	@Override
	public String toString() {
		super.toString();
		return "Deadline --> " + getDeadline();
	}
}
