package AfterContract;

import java.awt.Image;

public class ClaimAdjustment {

	private Image accidentPicture;
	private int accidentTime;
	private int amountOfDamage;
	private int calculatedInsuranceFee;
	private boolean checkingComplete;

	@SuppressWarnings("unused")
	private enum accidentDate {

	}

	public ClaimAdjustment() {

	}

	public Image getAccidentPicture() {
		return accidentPicture;
	}

	public boolean setAccidentPicture(Image accidentPicture) {
		this.accidentPicture = accidentPicture;
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

	public boolean isCheckingComplete() {
		return checkingComplete;
	}

	public boolean setCheckingComplete(boolean checkingComplete) {
		this.checkingComplete = checkingComplete;
		return true;
	}
}