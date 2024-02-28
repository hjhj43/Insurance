package AfterContract;

public class AfterContractImpl implements AfterContract {

	private String employeeEmailAddress;
	private String employeeId;
	private String employeeName;
	private int employeePhoneNumber;
	private String employeePosition;
	public Accident mAccident;
	public LawSuit mLawSuit;
	public InstallmentCollectionPayment mInstallmentCollectionPayment;
	public ExpirationContract mExpirationContract;

	public AfterContractImpl() {

	}

	public String getEmployeeEmailaddress() {
		return this.employeeEmailAddress;
	}

	public String getEmployeeID() {
		return this.employeeId;
	}

	public String getEmployeeName() {
		return this.employeeName;
	}

	public int getEmployeePhoneNumber() {
		return this.employeePhoneNumber;

	}

	public String getEmployeePosition() {
		return this.employeePosition;
	}

	public String getEmployeeEmailAddress() {
		
		return employeeEmailAddress;
	}

	public boolean setEmployeeEmailAddress(String employeeEmailAddress) {
		this.employeeEmailAddress = employeeEmailAddress;
		return true;
	}


	public boolean setEmployeePhoneNumber(int employeePhoneNumber) {
		this.employeePhoneNumber = employeePhoneNumber;
		return true;
	}

	public boolean setEmployeeID(String employeeId) {
		this.employeeId = employeeId;
		return true;
	}

	public boolean setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
		return true;
	}

	public boolean setEmployeePosition(String employeePosition) {
		this.employeePosition = employeePosition;
		return true;
	}
}