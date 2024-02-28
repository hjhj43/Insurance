package Employee;

public class Employee {
	private int employeeNumber;
	private int phoneNumber;
	private int personalRegistrationNumber;
	private String id;
	private String name;
	private String password;
	private String emailAddress;
	private String position;

	public InsuranceDesigner mInsuranceDesigner;
	public InsuranceManager mInsuranceManager;
	public SalesMan mSalesman;
	public AccidentHandler mInsuranceAccidentHandler;
	public UW mUW;

	public Employee() {
	}

	public String getEmailAddress() {
		return emailAddress;
	}

	public boolean setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
		return true;
	}

	public int getEmployeeNumber() {
		return employeeNumber;
	}

	public boolean setEmployeeNumber(int employeeNumber) {
		this.employeeNumber = employeeNumber;
		return true;
	}

	public String getID() {
		return id;
	}

	public boolean setID(String iD) {
		id = iD;
		return true;
	}

	public String getName() {
		return name;
	}

	public boolean setName(String name) {
		this.name = name;
		return true;
	}

	public String getPassword() {
		return password;
	}

	public boolean setPassword(String password) {
		this.password = password;
		return true;
	}

	public int getPersonalRegistrationNumber() {
		return personalRegistrationNumber;
	}

	public boolean setPersonalRegistrationNumber(int personalRegistrationNumber) {
		this.personalRegistrationNumber = personalRegistrationNumber;
		return true;
	}

	public int getPhoneNumber() {
		return phoneNumber;
	}

	public boolean setPhoneNumber(int phoneNumber) {
		this.phoneNumber = phoneNumber;
		return true;
	}

	public String getPosition() {
		return position;
	}

	public boolean setPosition(String position) {
		this.position = position;
		return true;
	}

}