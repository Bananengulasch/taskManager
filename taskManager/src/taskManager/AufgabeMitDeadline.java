package taskManager;

import java.util.GregorianCalendar;

public class AufgabeMitDeadline extends Aufgabe {

	private GregorianCalendar deadline;

	public AufgabeMitDeadline(GregorianCalendar deadline) {
		super();
		this.deadline = deadline;
	}

	public GregorianCalendar getDeadline() {
		return deadline;
	}

	public void setDeadline(GregorianCalendar deadline) {
		this.deadline = deadline;
	}

	
	public String toString() {
		
	}
}
