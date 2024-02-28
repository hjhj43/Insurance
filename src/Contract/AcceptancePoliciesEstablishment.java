package Contract;

public class AcceptancePoliciesEstablishment {

	private String uwEmailAddress;
	private int uwEmployeeNumber;
	private String uwId;
	private static String uwName;
	private int uwPhoneNumber;

	public AcceptancePoliciesEstablishment() {
		this.uwEmailAddress = "";
		this.uwPhoneNumber = 0;

	}

	
	
	
	
	//////////////////////////////////////////////

	public int getUWEmployeeNumber() {
		return uwEmployeeNumber;
	}

	public boolean setUWEmployeeNumber(int uW_Employee_Number) {
		uwEmployeeNumber = uW_Employee_Number;
		return true;
	}

	public String getUWID() {
		return uwId;
	}

	public boolean setUWID(String uW_ID) {
		uwId = uW_ID;
		return true;
	}

	public static String getUWName() {
		return uwName;
	}

	public static boolean setUWName(String uW_Name) {
		uwName = uW_Name;
		return true;
	}

	public String getUWEmailAddress() {
		return uwEmailAddress;
	}

	public int getUWPhoneNumber() {
		return uwPhoneNumber;
	}

	public boolean establishAcceptanceSpolicies() {
		return true;
	}

}