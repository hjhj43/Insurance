package Customer;

enum job {
	driver, no_job, soldier, alba
}

public class Customer {
	private int age;
	private int dateOfBirth;
	private String emailAddress;
	private String id;
	private String job;
	private String medicalHistory;
	private String name;
	private String password;
	private int personalAccountNumber;
	private int personalRegistrationNumber;
	private int phoneNumber;
	private String registrationAddress;
	private String sex;
	private String Testing;

	public Customer() {
	}

	public String getTesting() {
		return this.Testing;
	}

	public boolean setTesting(String Test) {
		this.Testing = Test;
		return true;
	}

	public int getAge() {
		return age;
	}

	public boolean setAge(int age) {
		this.age = age;
		return true;
	}

	public int getDateOfBirth() {
		return dateOfBirth;
	}

	public boolean setDateOfBirth(int dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
		return true;
	}

	public String getEmailAddress() {
		return emailAddress;
	}

	public boolean setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
		return true;
	}

	public String getID() {
		return id;
	}

	public boolean setID(String iD) {
		id = iD;
		return true;
	}

	public String getJob() {
		return job;
	}

	public boolean setJob(String job) {
		this.job = job;
		return true;
	}

	public String getMedicalHistory() {
		return medicalHistory;
	}

	public boolean setMedicalHistory(String medicalHistory) {
		this.medicalHistory = medicalHistory;
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

	public int getPersonalAccountNumber() {
		return personalAccountNumber;
	}

	public boolean setPersonalAccountNumber(int personalAccountNumber) {
		this.personalAccountNumber = personalAccountNumber;
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

	public String getRegistrationAddress() {
		return registrationAddress;
	}

	public boolean setRegistrationAddress(String registrationAddress) {
		this.registrationAddress = registrationAddress;
		return true;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

}