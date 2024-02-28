package AfterContract;

public class LawSuit {

	private int accidentNumber;
	private String lawSuitReason;

	public LawSuit() {

	}

	public boolean sue() {
		return true;
	}

	public int getAccidentNumber() {
		return accidentNumber;
	}

	public boolean setAccidentNumber(int accidentNumber) {
		this.accidentNumber = accidentNumber;
		return true;
	}

	public String getLawSuitReason() {
		return lawSuitReason;
	}

	public boolean setLawSuitReason(String lawSuitReason) {
		this.lawSuitReason = lawSuitReason;
		return true;
	}
}