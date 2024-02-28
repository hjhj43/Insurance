package Insurance;

public class Insurance {
	private int customerAge;
	private String customerId;
	private String insuranceId;
	private String rewardCondition;
	private String insuranceType;
	private String insuranceTarget;
	private String restriction;
	private String insurancePeriod;
	private int insuranceFee;
	private String guaranteedContent;
	private int penalty;

	public Insurance() {
	}

	public String getInsuranceType() {
		return insuranceType;
	}

	public void setInsuranceType(String insuranceType) {
		this.insuranceType = insuranceType;
	}

	public String getInsurancePeriod() {
		return this.insurancePeriod;
	}

	public boolean setInsurancePeriod(String insurancePeriod) {
		this.insurancePeriod = insurancePeriod;
		return true;
	}

	public String getCustomerName() {
		return this.customerId;
	}

	public boolean setCustomerName(String name) {
		this.customerId = name;
		return true;
	}

	public int getInsuranceFee() {
		return insuranceFee;
	}

	public boolean setInsuranceFee(int insuranceFee) {
		this.insuranceFee = insuranceFee;
		return false;
	}

	public String getInsuranceTarget() {
		return insuranceTarget;
	}

	public boolean setInsuranceTarget(String insuranceTarget) {
		this.insuranceTarget = insuranceTarget;
		return false;
	}

	public int getPenalty() {
		return penalty;
	}

	public boolean setPenalty(int penalty) {
		this.penalty = penalty;
		return false;
	}

	public String getRestriction() {
		return restriction;
	}

	public boolean setRestriction(String restriction) {
		this.restriction = restriction;
		return false;
	}

	public int getCustomerAge() {
		return customerAge;
	}

	public boolean setCustomerAge(int customerAge) {
		this.customerAge = customerAge;
		return true;
	}

	public String getGuaranteedContent() {
		return guaranteedContent;
	}

	public boolean setGuaranteedContent(String guaranteedContent) {
		this.guaranteedContent = guaranteedContent;
		return true;
	}

	public String getInsuranceID() {
		return insuranceId;
	}

	public boolean setInsuranceID(String insuranceID) {
		insuranceId = insuranceID;
		return true;
	}

	public String getRewardCondition() {
		return rewardCondition;
	}

	public boolean setRewardCondition(String rewardCondition) {
		this.rewardCondition = rewardCondition;
		return true;
	}

}