package AfterContract;

public class InstallmentCollectionPayment {

	private int installmentCollectionCustomerPersonalRegistrationNumber;
	private String installmentCollectionName;

	public InstallmentCollectionPayment() {

	}

	public boolean ManageInstallmentCollectionPayment() {
		return true;
	}

	public int getInstallmentCollectionCustomerPersonalRegistrationNumber() {
		return installmentCollectionCustomerPersonalRegistrationNumber;
	}

	public boolean setInstallmentCollectionCustomerPersonalRegistrationNumber(
			int installmentCollectionCustomerPersonalRegistrationNumber) {
		this.installmentCollectionCustomerPersonalRegistrationNumber = installmentCollectionCustomerPersonalRegistrationNumber;
		return true;
	}

	public String getInstallmentCollectionName() {
		return installmentCollectionName;
	}

	public boolean setInstallmentCollectionName(String installmentCollectionName) {
		this.installmentCollectionName = installmentCollectionName;
		return true;
	}
}