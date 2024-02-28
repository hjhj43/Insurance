package Insurance;

import java.util.ArrayList;

import Main.connectDB;

public class InsuranceListImpl extends connectDB implements InsuranceList {

	private ArrayList<Insurance> insuranceList;

	public InsuranceListImpl() {
		this.insuranceList = new ArrayList<Insurance>();
	}

	@Override
	public ArrayList<Insurance> select() {
		this.insuranceList = new ArrayList<Insurance>();
		return insuranceList;
	}

	public boolean add(Insurance insurance) {
		this.insuranceList.add(insurance);
		return true;
	}

	public boolean delete(int index) {
		this.insuranceList.remove(index);
		return true;
	}

	public int ShowSize() {
		return this.insuranceList.size();
	}

	public Insurance search(int insuranceId) {
		return insuranceList.get(insuranceId);
	}

	public boolean update(String TypeName, String Content, int index) {
		switch (TypeName) {
		case "Guaranteed_content":
			insuranceList.get(index).setGuaranteedContent(Content);
			return true;
		case "Insurance_ID":
			insuranceList.get(index).setInsuranceID(Content);
			return true;
		case "Reward_Condition":
			insuranceList.get(index).setRewardCondition(Content);
			return true;
		}
		return true;
	}

	public boolean update(String TypeName, int Content, int index) {
		if (TypeName.equals("Customer_age")) {
			insuranceList.get(index).setCustomerAge(index);
			return true;
		}
		return false;
	}

}