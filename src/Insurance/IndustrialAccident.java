package Insurance;

public class IndustrialAccident extends Insurance {
	private String customerWorkplaceAddress;
	private static int customerWorkplaceBusinessNumber;
	private String customerWorkplacePosition;
	private String customerWorkplaceSafetyGrade;
	private static String customerWorkplaceType;
	private MedicalHistory medicalHistoryOfTheCustomer;
	private int payReward;

	public IndustrialAccident() {
		this.customerWorkplaceSafetyGrade = "";
	}
	
	public boolean setMedicalHistoryOfTheCustomer(MedicalHistory medicalHistoryOfTheCustomer) {
		this.medicalHistoryOfTheCustomer = medicalHistoryOfTheCustomer;
		return false;
	}

	public boolean setPayRewards(int pay) {
		this.payReward = pay;
		return true;
	}

	public int PayRewards() {
		return this.payReward;
	}

	public boolean setMedicalHistoryOfTheCustomer(String grade) {
		this.medicalHistoryOfTheCustomer.setGrade(grade);
		return true;
	}

	public String getMedicalHistoryOfTheCustomer() {
		return this.medicalHistoryOfTheCustomer.getGrade();
	}

	public boolean setGrade(String customerWorkplaceSafetyGrade) {
		this.customerWorkplaceSafetyGrade = customerWorkplaceSafetyGrade;
		return true;
	}

	public boolean setTheStandardForInsuranceRates() {
		return true;
	}

	public String getCustomerWorkplaceAddress() {
		return customerWorkplaceAddress;
	}

	public boolean setCustomerWorkplaceAddress(String customerWorkplaceAddress) {
		
		this.customerWorkplaceAddress = customerWorkplaceAddress;
		return true;
	}

	public static int getCustomerWorkplaceBusinessNumber() {
		return customerWorkplaceBusinessNumber;
	}

	public static void setCustomerWorkplacebusinessnumber(int customerWorkplaceBusinessNumber) {
		customerWorkplaceBusinessNumber = customerWorkplaceBusinessNumber;
	}

	public String getCustomerWorkplacePosition() {
		return customerWorkplacePosition;
	}

	public boolean setCustomerWorkplacePosition(String customerWorkplacePosition) {
		this.customerWorkplacePosition = customerWorkplacePosition;
		return true;
	}

	public static String getCustomer_Workplace_Type() {
		return customerWorkplaceType;
	}

	public static boolean setCustomer_Workplace_Type(String customerWorkplaceType) {
		customerWorkplaceType = customerWorkplaceType;
		return true;
	}

	public String getCustomer_Workplace_Safety_Grade() {
		return customerWorkplaceSafetyGrade;
	}
}