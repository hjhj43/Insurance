package Contract;

public class Proposal {
	private String kindsOfInsurance;
	private String proposalContent;
	private String proposalName;

	public Proposal() {

	}

	
	
	/////////////////////////////
	public String getKindsOfInsurance() {
		return kindsOfInsurance;
	}

	public boolean setKindsOfInsurance(String kinds_of_Insurance) {
		kindsOfInsurance = kinds_of_Insurance;
		return true;
	}

	public String getProposalContent() {
		
		return proposalContent;
	}

	public boolean setProposalContent(String proposal_content) {
		
		this.proposalContent = proposal_content;
		return true;
	}

	public String getProposalName() {
		return proposalName;
	}

	public boolean setProposalName(String proposal_name) {
		this.proposalName = proposal_name;
		return true;
	}


}