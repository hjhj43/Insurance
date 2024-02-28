package AfterContract;

import java.sql.Blob;

public class Accident {

	private String contractId;
	private int accidentNumber;
	private Blob accidentPicture;
	private String accidentDate;
	private int accidentTime;
	private int amountOfDamage;
	private int calculatedInsuranceFee;
	private String customerName;
	private int customerRegistrationNumber;
	private String kindsOfAccident;
	public ClaimAdjustment mClaimAdjustment;

	@SuppressWarnings("unused")
	private enum accidentDate {
		
	}

	public Accident() {

	}

	public String getAccidentDate() {
		return accidentDate;
	}

	public void setAccidentDate(String accidentDate) {
		this.accidentDate = accidentDate;
	}
	
	public boolean AcceptAccident() {
		return true;
	}
	
	public String getContract_id() {
		return contractId;
	}

	public void setContract_id(String contractId) {
		this.contractId = contractId;
	}

	public boolean calculatedInsuranceFee() {
		return true;
	}

	public boolean proceedClaimAdjustment() {
		
		return true;
	}

	public boolean reportAccident() {
		return true;
	}

	public int getAccidentNumber() {
		return accidentNumber;
	}

	public boolean setAccidentNumber(int accidentNumber) {
		this.accidentNumber = accidentNumber;
		return true;
	}

	public Blob getAccidentPicture() {
		return accidentPicture;
	}

	public boolean setAccidentPicture(Blob blob) {
		this.accidentPicture = blob;
		return true;
	}

	public int getAccidentTime() {
		return accidentTime;
	}

	public boolean setAccidentTime(int accidentTime) {
		this.accidentTime = accidentTime;
		return true;
	}

	public int getAmountOfDamage() {
		return amountOfDamage;
	}

	public boolean setAmountOfDamage(int amountOfDamage) {
		this.amountOfDamage = amountOfDamage;
		return true;
	}

	public int getCalculatedInsuranceFee() {
		return calculatedInsuranceFee;
	}

	public boolean setCalculatedInsuranceFee(int calculatedInsuranceFee) {
		this.calculatedInsuranceFee = calculatedInsuranceFee;
		return true;
	}

	public String getCutomerName() {
		return customerName;
	}

	public boolean setCutomerName(String customerName) {
		this.customerName = customerName;
		return true;
	}

	public int getCutomerRegistrationNumber() {
		return customerRegistrationNumber;
	}

	public boolean setCutomerRegistrationNumber(int cutomerRegistrationNumber) {
		this.customerRegistrationNumber = cutomerRegistrationNumber;
		return true;
	}

	public String getKindsOfAccident() {
		return kindsOfAccident;
	}

	public boolean setKindsOfAccident(String kindsOfAccount) {
		this.kindsOfAccident = kindsOfAccount;
		return true;
	}
}