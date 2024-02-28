package Insurance;

public class MedicalHistory extends Insurance {
	private String healthGradeOfCustomer;
	private String medicalHistoryOfTheCustomer;
	private int payReward;

	public MedicalHistory() {
	}

	public boolean setPayRewards(int pay) {
		this.payReward = pay;
		return true;
	}

	public int PayRewards() {
		return this.payReward;
	}

	public boolean setGrade(String healthGradeOfCustomer) {
		this.healthGradeOfCustomer = healthGradeOfCustomer;
		return true;
	}

	public boolean setTheStandardForInsuranceRates() {
		return true;
	}

	public String getHealthGradeOfCustomer() {
		return healthGradeOfCustomer;
	}

	public boolean setHealthGradeOfCustomer(String healthGradeOfCustomer) {
		this.healthGradeOfCustomer = healthGradeOfCustomer;
		return true;
	}

	public String getMedicalHistoryOfTheCustomer() {
		return medicalHistoryOfTheCustomer;
	}

	public boolean setMedicalHistoryOfTheCustomer(String medicalHistoryOfTheCustomer) {
		this.medicalHistoryOfTheCustomer = medicalHistoryOfTheCustomer;
		return true;
	}

	public String getGrade() {
		return healthGradeOfCustomer;
	}
}