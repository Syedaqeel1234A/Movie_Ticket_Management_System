package invalid_Details_Exceptions;

public class Admin_Invalid_Details_Exceptions extends RuntimeException {

	String invalid_Data;

	public Admin_Invalid_Details_Exceptions() {
		super();
	}

	public Admin_Invalid_Details_Exceptions(String invalid_Data) {
		super();
		this.invalid_Data = invalid_Data;
	}

	public String getInvalid_Data() {
		return invalid_Data;
	}

	public void setInvalid_Data(String invalid_Data) {
		this.invalid_Data = invalid_Data;
	}

	@Override
	public String toString() {
		return "Admin_Invalid_Details_Exceptions [invalid_Data=" + invalid_Data + "]";
	}
	
	
}
