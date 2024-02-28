package Contract;

import Insurance.Insurance;

public class ContractList {

	private String targetCustomer;
	private Insurance targetCustomerInsurance;
	private boolean checkingAT = false;
	private String viewList;

	public ContractList(String TargetCustomer, Insurance TargetCustomerInsurance) {
		this.targetCustomer = TargetCustomer;
		this.targetCustomerInsurance = TargetCustomerInsurance;
		this.viewList = this.targetCustomer + " / " + this.targetCustomerInsurance.getInsuranceID();
	}
	

	public String getTargetCustomer() {
		return this.targetCustomer;

	}

	public Insurance getTargetCustomerInsurance() {
		return this.targetCustomerInsurance;

	}

	public boolean getCheckingAt() {
		return this.checkingAT;
	}

	public void setCheckingAT(boolean check) {
		this.checkingAT = check;
	}

	public String getView() {
		return this.viewList;
	}
	
	
}
