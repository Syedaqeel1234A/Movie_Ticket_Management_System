package invalid_Details_Exceptions;

public class InvalidTicketSelection extends RuntimeException {
	
	String expMessage;
	
	

	public InvalidTicketSelection() {
		super();
	}

	public InvalidTicketSelection(String expMessage) {
		super();
		this.expMessage = expMessage;
	}

	public String getExpMessage() {
		return expMessage;
	}

	public void setExpMessage(String expMessage) {
		this.expMessage = expMessage;
	}

	@Override
	public String toString() {
		return "InvalidTicketSelection [expMessage=" + expMessage + "]";
	}
	
	

}
