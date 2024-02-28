package AfterContract;

import java.util.ArrayList;

import Main.connectDB;

public class AccidentList extends connectDB {
	private ArrayList<Accident> accidentList;

	public ArrayList<Accident> select() {
		this.accidentList = new ArrayList<Accident>();
		return accidentList;
	}
}
