package Insurance;

public class Car extends Insurance {

	@SuppressWarnings("unused")
	private enum carPrice {
	};

	private int carRegistrationNumberOfCustomer;
	private String drivingGradeOfCustomer;
	private int numberOfCarAccidentsOfCustomer;
	private MedicalHistory medicalHistoryOfTheCustomer;
	private int payReward;

	public Car() {
	}

	public boolean setMedicalHistoryOfTheCustomer(MedicalHistory medicalHistoryOfTheCustomer) {
		this.medicalHistoryOfTheCustomer = medicalHistoryOfTheCustomer;
		return false;
	}

	public int getPayReward() {
		return payReward;
	}

	public boolean setPayReward(int payReward) {
		this.payReward = payReward;
		return false;
	}

	public boolean setPayRewards(int pay) {
		this.payReward = pay;
		return true;
	}

	public int payRewards() {
		return this.payReward;
	}

	public boolean setMedicalHistoryOfTheCustomer(String grade) {
		this.medicalHistoryOfTheCustomer.setGrade(grade);
		return true;
	}

	public String getMedicalHistoryOfTheCustomer() {
		return this.medicalHistoryOfTheCustomer.getGrade();
	}

	public boolean setGrade(String drivingGradeOfCustomer) {
		this.drivingGradeOfCustomer = drivingGradeOfCustomer;
		return true;
	}

	public boolean setTheStandardForInsuranceRates() {
		return true;
	}

	public int getCarRegistrationNumberofcustomer() {
		return carRegistrationNumberOfCustomer;
	}

	public boolean setCarRegistrationNumberOfCustomer(int carRegistrationNumberOfCustomer) {
		this.carRegistrationNumberOfCustomer = carRegistrationNumberOfCustomer;
		return true;
	}

	public String getDrivingGradeOfCustomer() {
		return drivingGradeOfCustomer;
	}

	public boolean setDrivingGradeOfCustomer(String drivingGradeOfCustomer) {
		this.drivingGradeOfCustomer = drivingGradeOfCustomer;
		return true;
	}

	public int getNumberOfCarAccidentsOfCustomer() {
		return numberOfCarAccidentsOfCustomer;
	}

	public boolean setNumberOfCarAccidentsOfCustomer(int numberOfCarAccidentsOfCustomer) {
		this.numberOfCarAccidentsOfCustomer = numberOfCarAccidentsOfCustomer;
		return true;
	}
}