package Main;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.table.DefaultTableModel;

import AfterContract.Accident;
import Asset.AccountList;
import Asset.AccountList.Account;
import Contract.Contract;
import Customer.Customer;
import Customer.CustomerList;
import Customer.CustomerListImpl;
import Employee.Employee;
import Employee.EmployeeList;
import Employee.EmployeeListImpl;
import Insurance.Insurance;
import Insurance.InsuranceList;
import Insurance.InsuranceListImpl;

public class DB extends connectDB {
	@SuppressWarnings("unused")
	private CustomerListImpl cli;
	@SuppressWarnings("unused")
	private DefaultTableModel model;

	private EmployeeList employeeList;
	private CustomerList customerList;
	private InsuranceList InsuranceList;
	private AccountList accountList;

	private ArrayList<Contract> contractList;
	private Vector<String> proposalVector;
	private Vector<String> subscriptionFormVector;
	private Vector<Customer> checkReceiptList;
	private Vector<String> acceptanceList;
	private Vector<Customer> completeTestingList;
	private Vector<Contract> finishList;
	private Vector<Accident> registerList;
	private Vector<String> guidelineList;
	private Vector<String> paymentList;
	private Vector<String> expirationList;
	private ArrayList<Accident> accidentList;
	private ArrayList<Customer> TargetAcceptance;
	private ArrayList<Accident> SueAccidentList; 
	private ArrayList<Accident> completeDealList;

	//////// --------------////--------------////////
	private ArrayList<String> contractManagementGuideList;
	private ArrayList<Accident> completeClaimList;
	private ArrayList<Accident> EndAccident;

	public DB() {
		this.completeDealList = new ArrayList<Accident>();
		this.SueAccidentList = new ArrayList<Accident>();
		this.TargetAcceptance = new ArrayList<Customer>();
		this.InsuranceList = new InsuranceListImpl();
		this.employeeList = new EmployeeListImpl();
		this.customerList = new CustomerListImpl();
		this.accountList = new AccountList();
		this.accidentList = new ArrayList<Accident>();
		// this.insuranceList = new ArrayList<Insurance>();
		this.proposalVector = new Vector<String>();
		this.subscriptionFormVector = new Vector<String>();
		this.contractList = new ArrayList<Contract>();
		this.checkReceiptList = new Vector<Customer>();
		this.acceptanceList = new Vector<String>();
		this.completeTestingList = new Vector<Customer>();
		this.finishList = new Vector<Contract>();
		this.registerList = new Vector<Accident>();
		this.guidelineList = new Vector<String>();
		this.paymentList = new Vector<String>();
		this.expirationList = new Vector<String>();
		this.completeClaimList= new ArrayList<Accident>();
		this.contractManagementGuideList = new ArrayList<String>();
		this.EndAccident = new ArrayList<Accident>();

		connectData();
		Proposal();
		Customer();
		insurance();
		Employee();
		Accident();
		Account();
		Contract();
		Expiration();
		Guideline();
		Subscription();
		completeTesting();
		checkReceipt();
		paymentList();
	}

	public boolean insert(Customer customer) {
		String sql = "INSERT INTO Customer values('" + customer.getID() + "', " + customer.getAge() + ", "
				+ customer.getDateOfBirth() + ", '" + customer.getEmailAddress() + "', '" + customer.getJob() + "', '"
				+ customer.getMedicalHistory() + "', '" + customer.getName() + "', '" + customer.getPassword() + "', "
				+ customer.getPersonalAccountNumber() + ", " + customer.getPersonalRegistrationNumber() + ",  "
				+ customer.getPhoneNumber() + ", '" + customer.getRegistrationAddress() + "');";
		return this.execute(sql);
	}

	public boolean insert(Account account) {
		String sql = "INSERT INTO Account values('" + account.getID() + "', '" + account.getPW() + "', '"
				+ account.getPosition() + "', '" + account.getName() + "');";
		return this.execute(sql);
	}

	public boolean insert(Insurance insurance) {
		String sql = "INSERT INTO insurance"
				+ "(Insurance_id,InsuranceType,Insurance_Target,restriction,Insurance_period,Insurance_fee,Guaranteed_content,Panalty)"
				+ "values"
				+ "('"+(int)(Math.random()*999)+"', '"+insurance.getInsuranceType()+"', '"+insurance.getInsuranceTarget()+"', '"+insurance.getRestriction()
				+"', '"+insurance.getInsurancePeriod()+"', "+insurance.getInsuranceFee()+", '"+insurance.getGuaranteedContent()+"', "+insurance.getPenalty()+")";
		return this.execute(sql);
	}

	public void connectData() {
		sstart();
		connect();
	}

	public void paymentList() { // 보험료 수령 확인
		String sql = "SELECT * FROM Customer";
		this.read(sql);
		try {
			while (resultSet.next()) {
				Customer customer = new Customer();
				customer.setName(resultSet.getString("Name"));
				customer.setID(resultSet.getString("ID"));
				customer.setAge(resultSet.getInt("age"));
				String pl = customer.getName() + " " + customer.getID() + " " + customer.getAge();
				this.paymentList.add(pl);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public void Expiration() {
		String sql = "SELECT * FROM customer";
		this.read(sql);
		try {
			while (resultSet.next()) {
				Customer customer = new Customer();
				customer.setID(resultSet.getString("ID"));
				customer.setName(resultSet.getString("Name"));
				customer.setAge(resultSet.getInt("age"));
				String ep = customer.getID() + " " + customer.getName() + " " + customer.getAge();
				this.expirationList.add(ep);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void Guideline() {
		String sql = "SELECT * FROM contract";
		this.read(sql);
		try {
			while (resultSet.next()) {
				Contract contract = new Contract();
				contract.setContract_ID(resultSet.getString("Contract_Id"));
				contract.setCustomer_ID(resultSet.getString("Customer_Id"));
				contract.setSalesMan_ID(resultSet.getString("Employee_Id"));
				String gl = contract.getCustomer_ID() + " " + contract.getCustomer_ID() + " "
						+ contract.getSalesMan_ID();
				this.guidelineList.add(gl);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void Subscription() { // 청약서
		String sql = "SELECT * FROM insurance";
		this.read(sql);
		try {
			while (resultSet.next()) {
				Insurance insurance = new Insurance();
				insurance.setInsuranceID(resultSet.getString("Insurance_id"));
				insurance.setCustomerName(resultSet.getString("ID"));// customer
				insurance.setInsuranceTarget(resultSet.getString("Insurance_Target"));
				insurance.setInsurancePeriod(resultSet.getString("Insurance_period"));
				insurance.setInsuranceFee(resultSet.getInt("Insurance_fee"));
				insurance.setGuaranteedContent(resultSet.getString("Guaranteed_content"));
				String didi = insurance.getInsuranceID() + " " + insurance.getCustomerName() + " "
						+ insurance.getInsuranceTarget() + " " + insurance.getInsurancePeriod() + " "
						+ insurance.getInsuranceFee() + " " + insurance.getGuaranteedContent();
				this.subscriptionFormVector.add(didi);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void completeTesting() {
		String sql = "SELECT * FROM customer";
		this.read(sql);
		try {
			while (resultSet.next()) {
				Customer customer = new Customer();
				customer.setName(resultSet.getString("Name"));
				customer.setAge(resultSet.getInt("age"));
				customer.setRegistrationAddress(resultSet.getString("Registration_address"));
				customer.setMedicalHistory(resultSet.getString("Medical_History"));
				customer.setDateOfBirth(resultSet.getInt("Date_Of_Birth"));
				this.completeTestingList.add(customer);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void checkReceipt() {
		String sql = "SELECT * FROM customer";
		this.read(sql);
		try {
			while (resultSet.next()) {
				Customer customer = new Customer();
				customer.setID(resultSet.getString("ID"));
				customer.setName(resultSet.getString("Name"));
				this.checkReceiptList.add(customer);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void Proposal() {
		String sql = "SELECT * FROM insurance";
		this.read(sql);
		try {
			while (resultSet.next()) {
				Insurance insurance = new Insurance();
				insurance.setInsuranceID(resultSet.getString("Insurance_id"));
				insurance.setCustomerName(resultSet.getString("ID"));
				String pp = insurance.getInsuranceID() + " " + insurance.getCustomerName();
				this.proposalVector.add(pp);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void Contract() {
		String sql = "SELECT * FROM contract";
		this.read(sql);
		try {
			while (resultSet.next()) {
				Contract contract = new Contract();
				contract.setContract_ID(resultSet.getString("Contract_Id"));
				contract.setCustomer_ID(resultSet.getString("Customer_Id"));
				contract.setSalesMan_ID(resultSet.getString("Employee_Id"));
				contract.setSalesMan_Email_Address(resultSet.getString("SalesMan_Email_Address"));
				contract.setSalesMan_Employee_Number(resultSet.getInt("SalesMan_Employee_Number"));
				contract.setSalesMan_Name(resultSet.getString("SalesMan_Name"));
				contract.setSalesMan_Phone_Number(resultSet.getInt("SalesMan_Phone_Number"));
				contract.setTargetCustomer(resultSet.getString("TargetCustomer"));
				this.contractList.add(contract);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void Account() {
		String sql = "SELECT * FROM account";
		this.read(sql);
		try {
			while (resultSet.next()) {
				this.accountList.add(resultSet.getString("ID"), resultSet.getString("PW"),
						resultSet.getString("Position"), resultSet.getString("Employee_name"));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void Accident() {
		String sql = "SELECT * FROM accident";
		this.read(sql);
		try {
			while (resultSet.next()) {
				Accident accident = new Accident();
				accident.setContract_id(resultSet.getString("Contract_id"));
				accident.setAccidentDate(resultSet.getString("Date"));
				accident.setAccidentNumber(resultSet.getInt("Number"));
				accident.setAccidentPicture(resultSet.getBlob("Picture"));
				accident.setAccidentTime(resultSet.getInt("Time"));
				accident.setAmountOfDamage(resultSet.getInt("Amount_of_Damage"));
				accident.setCalculatedInsuranceFee(resultSet.getInt("Calculated_insurance_fee"));
				accident.setCutomerName(resultSet.getString("Customer_name"));
				accident.setCutomerRegistrationNumber(resultSet.getInt("Customer_registration_number"));
				accident.setKindsOfAccident(resultSet.getString("Kinds_of_accident"));
				this.accidentList.add(accident);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void Employee() {
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
	}

	public void insurance() {
		String sql = "SELECT * FROM insurance";
		this.read(sql);
		try {
			while (resultSet.next()) {
				Insurance insurance = new Insurance();
				insurance.setInsuranceID(resultSet.getString("Insurance_id"));
				insurance.setCustomerName(resultSet.getString("ID"));
				insurance.setCustomerAge(resultSet.getInt("Customer_age"));
				insurance.setRewardCondition(resultSet.getString("Reward_Condition"));
				insurance.setInsuranceType(resultSet.getString("InsuranceType"));
				insurance.setInsuranceTarget(resultSet.getString("Insurance_Target"));
				insurance.setRestriction(resultSet.getString("restriction"));
				insurance.setInsurancePeriod(resultSet.getString("Insurance_period"));
				insurance.setInsuranceFee(resultSet.getInt("Insurance_fee"));
				insurance.setPenalty(resultSet.getInt("Panalty"));
				insurance.setGuaranteedContent(resultSet.getString("Guaranteed_content"));
				this.InsuranceList.add(insurance);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void Customer() {
		String sql = "SELECT * FROM customer";
		this.read(sql);
		try {
			while (resultSet.next()) {
				Customer customer = new Customer();
				customer.setID(resultSet.getString("ID"));
				customer.setAge(resultSet.getInt("age"));
				customer.setDateOfBirth(resultSet.getInt("Date_Of_Birth"));
				customer.setEmailAddress(resultSet.getString("Email_address"));
				customer.setJob(resultSet.getString("Job"));
				customer.setMedicalHistory(resultSet.getString("Medical_History"));
				customer.setName(resultSet.getString("Name"));
				customer.setPassword(resultSet.getString("PW"));
				customer.setPersonalAccountNumber(resultSet.getInt("Personal_Account_Number"));
				customer.setPersonalRegistrationNumber(resultSet.getInt("Personal_registration_Number"));
				customer.setPhoneNumber(resultSet.getInt("Phone_number"));
				customer.setRegistrationAddress(resultSet.getString("Registration_address"));
				this.customerList.add(customer);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public boolean setSue(Accident accident) {
		this.SueAccidentList.add(accident);
		return true;
	}
	
	public ArrayList<Accident> getSueList() {
		return this.SueAccidentList;
	}

	public void setAcceptanceList(String acceptance) {
		this.acceptanceList.add(acceptance);
	}

	public void setAcceptanceTarget(Customer customer) {
		this.TargetAcceptance.add(customer);
	}

	public ArrayList<Customer> getAcceptanceTarget() {
		return this.TargetAcceptance;
	}

	public EmployeeList getEmployeeList() {
		return employeeList;
	}

	public void setEmployeeList(EmployeeList employeeList) {
		this.employeeList = employeeList;
	}

	public AccountList getAccountList() {
		return this.accountList;
	}
	
	public boolean setAccidentList(Accident accident) {
		this.accidentList.add(accident);
		return true;
	}
	
	public ArrayList<Accident> getEndAccident() {
		return EndAccident;
	}

	public void setEndAccident(Accident endAccident) {
		EndAccident.add(endAccident);
	}

	public ArrayList<Accident> getCompleteDealList() {
		return completeDealList;
	}

	public void setCompleteDealList(Accident completeDeal) {
		this.completeDealList.add(completeDeal);
	}
	

	/*
	 * public ArrayList<Customer> getCustomerList() { return this.CustomerList; }
	 */

	public CustomerList getCustomerList() {
		return this.customerList;
	}

	public InsuranceList getInsuranceList() {
		return this.InsuranceList;
	}
	
	public ArrayList<Accident> getCompleteClaimList() {
		return this.completeClaimList;
	}
	
	public boolean setCompleteClaimList(Accident Accident) {
		this.completeClaimList.add(Accident);
		return true;
	}
	
	public boolean setInsuranceList(Insurance insurance) {
		this.InsuranceList.add(insurance);
		return true;
	}

	public boolean setProposalVector(String proposal) {
		this.proposalVector.add(proposal);
		return true;
	}

	public boolean setSubscriptionFormVector(String Subscription) {
		this.subscriptionFormVector.add(Subscription);
		return true;
	}

	public boolean repairSubscriptionFormVector(String Subscription) {

		this.subscriptionFormVector.remove(this.subscriptionFormVector.size() - 1);
		this.subscriptionFormVector.add(Subscription);
		return true;
	}

	public Vector<String> getProposalVector() {
		return this.proposalVector;
	}

	public Vector<String> getSubscriptionFormVector() {
		return this.subscriptionFormVector;
	}

	public Vector<Contract> getfinishList() {
		return this.finishList;
	}
	
	public Vector<Accident> getRegisterList(){
		return this.registerList;
	}
	
	public boolean RegisterList() {
		return true;
	}

	public boolean setContractManagementGuideList(String guideline) {
		this.contractManagementGuideList.add(guideline);
		return true;
	}

	public boolean setContractList(ArrayList<Contract> contractList) {
		this.contractList = contractList;
		return true;
	}

	public boolean setCheckReceiptList(Customer checkReceipt) {
		this.checkReceiptList.add(checkReceipt);
		return true;
	}

	public Vector<Customer> getCheckReceiptList() {
		return this.checkReceiptList;
	}
	
	public ArrayList<Accident> getAccidentList() {
		return this.accidentList;
	}

	
	
	public boolean setCompleteAcceptanceList(Vector<String> acceptanceList) {
		this.acceptanceList = acceptanceList;
		return true;
	}

	public Vector<String> getAcceptanceList() {
		return this.acceptanceList;
	}

	public boolean setCompleteTestingList(Customer completeTestingList) {
		this.completeTestingList.add(completeTestingList);
		return true;
	}

	public Vector<Customer> getCompleteTestingList() {
		return this.completeTestingList;
	}

	public boolean setRegisterList(Accident registerList) {
		this.registerList.add(registerList);
		return true;
	}


	public boolean setfinishList(Contract Contract) {
		this.finishList.add(Contract);
		return true;
	}

	public boolean setGuidelineList(Vector<String> guidelineList) {
		this.guidelineList = guidelineList;
		return true;

	}

	public boolean setPaymentList(Vector<String> paymentList) {
		this.paymentList = paymentList;
		return true;

	}

	public boolean setExpirationList(Vector<String> expirationList) {
		this.expirationList = expirationList;
		return true;
	}
}
