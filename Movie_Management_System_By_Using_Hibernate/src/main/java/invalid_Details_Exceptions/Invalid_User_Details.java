package invalid_Details_Exceptions;

public class Invalid_User_Details extends RuntimeException {
	
	String invalidDetails;
	
	public Invalid_User_Details() {
		super();
	}
	
	public Invalid_User_Details(String invalidDetails) {
		super();
		this.invalidDetails = invalidDetails;
	}

	public String getInvalidDetails() {
		return invalidDetails;
	}

	public void setInvalidDetails(String invalidDetails) {
		this.invalidDetails = invalidDetails;
	}

	@Override
	public String toString() {
		return "Invalid_User_Details [invalidDetails=" + invalidDetails + "]";
	}
	
	
	
	

}
