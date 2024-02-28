package Employee;

import java.util.ArrayList;

public interface EmployeeList {
	public ArrayList<Employee> select();
	public boolean add(Employee employee);
	public boolean delete(int employee_number);
	public Employee search(int employee_number);
	public boolean update(String TypeName, String Content, int index);
	public boolean update(String TypeName, int Content, int index);
	public int ShowSize();
}