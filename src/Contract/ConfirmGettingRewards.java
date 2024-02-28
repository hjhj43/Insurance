package Contract;

public class ConfirmGettingRewards {

	private boolean checkingInsuranceFee;
	private int customerAccountNumber;
	private String customerName;
	private int customerPersonalRegistrationNumber;

	public ConfirmGettingRewards() {

	}

	public void getFinalContract() {

	}
	
	
	
	////////////////////////////
	public boolean isCheckingInsuranceFee() {
		return checkingInsuranceFee;
	}

	public boolean setCheckingInsuranceeFee(boolean checking_Insurance_fee) {
		checkingInsuranceFee = checking_Insurance_fee;
		return true;
	}

	public int getCustomerAccountNumber() {
		return customerAccountNumber;
	}

	public boolean setCustomerAccountNumber(int customer_account_number) {
		customerAccountNumber = customer_account_number;
		return true;
	}

	public String getCustomerName() {
		return customerName;
	}

	public boolean setCustomerName(String customer_name) {
		customerName = customer_name;
		return true;
	}

	public int getCustomerPersonalRegistrationNumber() {
		return customerPersonalRegistrationNumber;
	}

	public boolean setCustomerPersonalRegistrationNumber(int customer_personal_registration_number) {
		customerPersonalRegistrationNumber = customer_personal_registration_number;
		return true;
	}


}