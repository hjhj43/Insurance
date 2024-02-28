package Insurance;

public class Fire extends Insurance {
	private String buildingManagementGrade;
	private String buildingPrices;
	private int buildingRegistrationNumber;
	private MedicalHistory medicalHistoryOfTheCustomer;
	private int payReward;
	
	public Fire() {
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

	public boolean setGrade(String buildingManagementGrade) {
		this.buildingManagementGrade = buildingManagementGrade;
		return true;
	}

	public boolean setTheStandardForInsuranceRates() {
		
		return true;
	}

	public String getBuildingManagementGrade() {
		return buildingManagementGrade;
	}

	public boolean setBuildingManagementGrade(String buildingManagementGrade) {
		this.buildingManagementGrade = buildingManagementGrade;
		return true;
	}

	public String getBuildingPrices() {
		return buildingPrices;
	}

	public boolean setBuildingPrices(String buildingPrices) {
		this.buildingPrices = buildingPrices;
		return true;
	}

	public int getBuildingRegistrationNumber() {
		return buildingRegistrationNumber;
	}

	public boolean setBuildingRegistrationNumber(int buildingRegistrationNumber) {
		this.buildingRegistrationNumber = buildingRegistrationNumber;
		return true;
	}
}