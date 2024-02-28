package Contract;

import java.awt.Graphics;

public class ApplicationForm {
	private String contractor;
	private String guaranteedContent;
	private String insurancePeriod;
	private int insuredPerson;
	private String nameOfApplicationForm;
	private Graphics signatureColumn;
	private int totalInsuranceFee;

	
	public ApplicationForm() {

	}
	
	
	
	
	//////////////////////////////////
	public String getContractor() {
		return contractor;
	}

	public boolean setContractor(String contractor) {
		this.contractor = contractor;
		return true;
	}

	public String getGuaranteedContent() {
		return guaranteedContent;
	}

	public boolean setGuaranteedContent(String guaranteed_content) {
		guaranteedContent = guaranteed_content;
		return true;
	}

	public String getInsurancePeriod() {
		return insurancePeriod;
	}

	public boolean setInsurancePeriod(String insurance_period) {
		insurancePeriod = insurance_period;
		return true;
	}

	public int getInsuredPerson() {
		return insuredPerson;
	}

	public boolean setInsuredPerson(int insured_person) {
		this.insuredPerson = insured_person;
		return true;
	}

	public String getNameOfApplicationForm() {
		
		return nameOfApplicationForm;
	}

	public boolean setNameOfApplicationForm(String name_of_application_form) {
		this.nameOfApplicationForm = name_of_application_form;
		return true;
	}

	public Graphics getSignatureColumn() {
		return signatureColumn;
	}

	public boolean setSignatureColumn(Graphics signature_column) {
		this.signatureColumn = signature_column;
		return true;
	}

	public int getTotalInsuranceFee() {
		return totalInsuranceFee;
	}

	public boolean setTotalInsuranceFee(int total_Insurance_fee) {
		
		totalInsuranceFee = total_Insurance_fee;
		return true;
	}


}