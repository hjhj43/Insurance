package Insurance;

public class Life extends Insurance {

	private String deathRelatedRestrictions;
	private String healthGradeOfCustomer;
	private MedicalHistory medicalHistoryOfTheCustomer;
	private int payReward;
	
	public Life() {

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

	public boolean setGrade(String healthGradeOfCustomer) {
		this.healthGradeOfCustomer = healthGradeOfCustomer;
		return true;
	}

	public boolean setTheStandardForInsuranceRates() {
		return true;
	}

	public String getDeathRelatedRestrictions() {
		return deathRelatedRestrictions;
	}

	public boolean setDeathRelatedRestrictions(String deathRelatedRestrictions) {
		this.deathRelatedRestrictions = deathRelatedRestrictions;
		return true;
	}

	public String getHealthGradeOfCustomer() {
		return healthGradeOfCustomer;
	}

	public boolean setHealthGradeOfCustomer(String healthGradeOfCustomer) {
		this.healthGradeOfCustomer = healthGradeOfCustomer;
		return true;
	}
}