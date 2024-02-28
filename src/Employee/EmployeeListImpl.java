package Employee;

import java.sql.SQLException;
import java.util.ArrayList;

import Main.connectDB;

public class EmployeeListImpl extends connectDB implements EmployeeList {

	private ArrayList<Employee> employeeList;

	public EmployeeListImpl() {
		this.employeeList = new ArrayList<Employee>();
	};

	public ArrayList<Employee> select() {
		this.employeeList = new ArrayList<Employee>();
		String sql = "SELECT * FROM employee";
		this.read(sql);
		try {
			while (resultSet.next()) {
				Employee employee = new Employee();
				employee.setID(resultSet.getString("employee_id"));
				employee.setEmployeeNumber(resultSet.getInt("employee_number"));
				employee.setName(resultSet.getString("employee_name"));
				employee.setEmailAddress(resultSet.getString("email_address"));
				employee.setPassword(resultSet.getString("password"));
				employee.setPersonalRegistrationNumber(resultSet.getInt("personal_registration_number"));
				employee.setPhoneNumber(resultSet.getInt("phone_number"));
				employee.setPosition(resultSet.getString("position"));
				this.employeeList.add(employee);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return employeeList;
	}

	public ArrayList<Employee> getEmployeeList() {
		return employeeList;
	}

	public void setEmployeeList(ArrayList<Employee> employeeList) {
		this.employeeList = employeeList;
	}

	public boolean add(Employee employee) {
		this.employeeList.add(employee);
		return true;
	}

	public boolean delete(int employeeNumber) {
		this.employeeList.remove(employeeNumber);
		return true;
	}

	public Employee search(int employeeNumber) {
		return this.employeeList.get(employeeNumber);
	}

	public int ShowSize() {
		return this.employeeList.size();
	}

	@Override
	public boolean update(String TypeName, String Content, int index) {
		employeeList.get(index);
		switch (TypeName) {
		case "ID":
			employeeList.get(index).setID(Content);
			return true;
		case "name":
			employeeList.get(index).setName(Content);
			return true;
		case "password":
			employeeList.get(index).setPassword(Content);
			return true;
		case "email_address":
			employeeList.get(index).setEmailAddress(Content);
			return true;
		case "position":
			employeeList.get(index).setPosition(Content);
			return true;
		}
		return true;
	}

	@Override
	public boolean update(String TypeName, int Content, int index) {
		employeeList.get(index);
		switch (TypeName) {
		case "Employee_number":
			employeeList.get(index).setEmployeeNumber(Content);
			return true;
		case "phone_number":
			employeeList.get(index).setPhoneNumber(Content);
			return true;
		case "personal_registration_number":
			employeeList.get(index).setPersonalRegistrationNumber(Content);
			return true;
		}
		return true;
	}
}