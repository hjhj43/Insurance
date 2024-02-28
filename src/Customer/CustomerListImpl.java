package Customer;

import java.util.ArrayList;

public class CustomerListImpl implements CustomerList {

	private ArrayList<Customer> customerList;

	@Override
	public ArrayList<Customer> select() {
		this.customerList = new ArrayList<Customer>();
		return customerList;
	}

	public CustomerListImpl() {
		this.customerList = new ArrayList<Customer>();
	}

	public boolean delete(int customerId) {
		this.customerList.remove(customerId);
		return true;
	}

	public Customer search(int customerId) {
		return customerList.get(customerId);
	}

	public boolean add(Customer customer) {
		this.customerList.add(customer);
		return true;
	}

	public int ShowSize() {
		return this.customerList.size();
	}

	public boolean update(String TypeName, String Content, int index) {
		switch (TypeName) {
		case "email_address":
			customerList.get(index).setEmailAddress(Content);
			return true;
		case "ID":
			customerList.get(index).setID(Content);
			return true;
		case "job":
			customerList.get(index).setJob(Content);
			return true;
		case "Medical_History":
			customerList.get(index).setMedicalHistory(Content);
			return true;
		case "name":
			customerList.get(index).setName(Content);
			return true;
		case "password":
			customerList.get(index).setPassword(Content);
			return true;
		case "Sex":
			customerList.get(index).setSex(Content);
			return true;
		case "registration_address":
			customerList.get(index).setRegistrationAddress(Content);
			return true;
		}
		return true;
	}

	public boolean update(String TypeName, int Content, int index) {
		switch (TypeName) {
		case "Age":
			customerList.get(index).setAge(Content);
			return true;
		case "Date_Of_Birth":
			customerList.get(index).setDateOfBirth(Content);
			return true;
		case "Personal_Account_Number":
			customerList.get(index).setPersonalAccountNumber(Content);
			return true;
		case "personal_registration_number":
			customerList.get(index).setPersonalRegistrationNumber(Content);
			return true;
		case "phone_number":
			customerList.get(index).setPhoneNumber(Content);
			return true;
		}
		return true;
	}

	public String getCustomerList(int i) {
		String List = this.customerList.get(i).getName() + " / " + this.customerList.get(i).getSex() + " / "
				+ this.customerList.get(i).getPersonalRegistrationNumber() + " / " + this.customerList.get(i).getAge()
				+ " / " + this.customerList.get(i).getPhoneNumber() + " / "
				+ this.customerList.get(i).getRegistrationAddress() + " / " + this.customerList.get(i).getEmailAddress()
				+ " / " + this.customerList.get(i).getPersonalAccountNumber();
		return List;
	}
}