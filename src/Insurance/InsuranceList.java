package Insurance;

import java.util.ArrayList;

public interface InsuranceList {
	public ArrayList<Insurance> select();
	public boolean add(Insurance insurance);
	public boolean delete(int index);
	public Insurance search(int insurance_id);
	public boolean update(String TypeName, String Content, int index);
	public boolean update(String TypeName, int Content, int index);
}