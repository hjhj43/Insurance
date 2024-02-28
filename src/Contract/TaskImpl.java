package Contract;

import AfterContract.AfterContractImpl;
import Employee.Login;

public class TaskImpl implements Task {

	@SuppressWarnings("unused")
	private Contract contract;
	@SuppressWarnings("unused")
	private AcceptanceTesting AT;
	
	private String employeeName;
	private int employeeNumber;
	private String employeePosition;
	public ProductDevelopment  mProductDevelopment ;
	public Contract mContract;
	public AfterContractImpl mAfterContractImpl;
	public ContractManagementGuidLines mContractManagementGuidLines;
	public AcceptancePoliciesEstablishment  mAcceptancePoliciesEstablishment ;
	public Login mLogin;

	public TaskImpl(){

	}

	public String getEmployeeName(){
		
		return this.employeeName;
	}

	public int getEmployeeNumber(){
		return this.employeeNumber;
	}

	public String getEmployeePosition(){
		return this.employeePosition;
	}

}