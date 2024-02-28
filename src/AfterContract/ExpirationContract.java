package AfterContract;

public class ExpirationContract {

	private int expirationContractCustomerPersonalRegistrationNumber;
	private String expirationContractName;

	public ExpirationContract() {

	}

	public boolean ManageExpirationContract() {
		return true;
	}

	public int getExpirationContractCustomerPersonalRegistrationNumber() {
		return expirationContractCustomerPersonalRegistrationNumber;
	}

	public boolean setExpirationContractCustomerPersonalRegistrationNumber(
			int expirationContractCustomerPersonalRegistrationNumber) {
		this.expirationContractCustomerPersonalRegistrationNumber = expirationContractCustomerPersonalRegistrationNumber;
		return true;
	}

	public String getExpirationContractName() {
		
		return expirationContractName;
	}

	public boolean setExpirationContractName(String expirationContractName) {
		this.expirationContractName = expirationContractName;
		return true;
	}
}