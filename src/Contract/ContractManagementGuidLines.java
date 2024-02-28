package Contract;

public class ContractManagementGuidLines {

	private String managerEmailAddress;
	private int managerEmployeeNumber;
	private String managerId;
	private String managerName;
	private int managerPhoneNumber;


	public ContractManagementGuidLines() {

	}

	public void enterContractManagementGuidelines() {

	}
	
	
	
	//////////////////////////////////
	public String getManagerEmailAddress() {
		return managerEmailAddress;
	}

	public boolean setManagerEmailAddress(String manager_Email_Address) {
		managerEmailAddress = manager_Email_Address;
		return true;
	}

	public int getManagerEmployeeNumber() {
		
		return managerEmployeeNumber;
	}

	public boolean setManagerEmployeeNumber(int manager_Employee_Number) {
		managerEmployeeNumber = manager_Employee_Number;
		return true;
	}

	public String getManagerID() {
		return managerId;
	}

	public boolean setManagerID(String manager_ID) {
		managerId = manager_ID;
		return true;
	}

	public String getManagerName() {
		return managerName;
	}

	public boolean setManagerName(String manager_Name) {
		managerName = manager_Name;
		return true;
	}

	public int getManagerPhoneNumber() {
		return managerPhoneNumber;
	}

	public boolean setManagerPhoneNumber(int manager_Phone_Number) {
		managerPhoneNumber = manager_Phone_Number;
		return true;
	}


}