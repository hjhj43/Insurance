package Contract;

import java.sql.SQLException;
import java.util.ArrayList;

import Customer.CustomerListImpl;
import Insurance.Insurance;
import Insurance.InsuranceListImpl;
import Main.DB;
import Main.connectDB;

@SuppressWarnings("unused")
public class Contract extends connectDB{

	private AcceptanceTesting AT;
	private CustomerListImpl customerList;
	private InsuranceListImpl insuranceList;
	private ArrayList<ContractList> contractList;
	private DB db;

	private ArrayList<Contract> sqlContractList;
	private String contractId;
	private String customerId;
	private String salesmanID;
	private String salesmanEmailAddress;
	private int salesmanEmployeeNumber;
	private String salesmanName;
	private int salesmanPhoneNumber;
	private String targetCustomer;
	
	public AcceptanceTesting mAcceptanceTesting;
	public Proposal mProposal;
	public ApplicationForm mApplicationForm;
	public ConfirmGettingRewards mConfirmGettingRewards;
	private Insurance targetCustomerInsurance;

	public Contract(InsuranceListImpl insuaranceList, CustomerListImpl customerList2) {
		this.AT = new AcceptanceTesting();
		this.insuranceList = insuaranceList;
		this.customerList = customerList2;
	}
	
	
	public void run() {
		this.targetCustomer = this.setTarget();
//		System.out.println("고객이 선택되었습니다.");
		// MakeProposal(); 제안서
		// ApplicationForm(); 청약서
		this.targetCustomerInsurance = this.SelectInsurance();
		AT.SendTarget(this.targetCustomer, this.targetCustomerInsurance);
		this.contractList = AT.getContractList();
		FinalContract();
	}
	
	public Contract() {
		
	}
	
	public ArrayList<Contract> select() {
		this.sqlContractList = new ArrayList<Contract>();
		
		
		return sqlContractList;
	}
	
	private boolean FinalContract() {
		// AfterContract
//		System.out.println("최종 완료할 계약을 선택하세요");
//		for (int i = 0; i < this.Contractlist.size(); i++) {
//			System.out.println(i + "번." + this.Contractlist.get(i).getView());
//		}
//		Scanner scan = new Scanner(System.in);
	//	System.out.println(scan.nextInt());
//		System.out.println("계약 완료되었습니다.");

		return true;
	}

	public String setTarget() { // 목표고객 선정
//		for (int i = 0; i < customerList.ShowSize(); i++) {
//			System.out.println(this.customerList.search(i));
//		}
//		Scanner scan = new Scanner(System.in);
//		System.out.println("고객번호 선택하세요:");
//		String a = scan.next();
//		scan.close();
		return null;

	}

	public Insurance SelectInsurance() {
//		System.out.println("상품을 선택하세요 (번호)");
//		for (int i = 0; i < this.InsuranceList.ShowSize(); i++) {
//			System.out.println(i + "번." + this.InsuranceList.search(i));
//		}
//		Scanner scan = new Scanner(System.in);
//		
//		System.out.println(this.InsuranceList.search(scan.nextInt()) + "이 선택되었습니다.");
		return this.insuranceList.search(0);

	}

	public boolean MakeProposal() {
		return true;
	}

	public String getTargetCustomer() {
		return targetCustomer;
	}

	///////////////////////////////////
	public boolean checkRewards() {
		return true;
	}

	public boolean makeApplicationForm() {
		return true;
	}

	public boolean makeProposal() {
		return true;

	}

	public boolean performAcceptanceTesting() {
		return true;

	}

	////////////////////////////////////////////////////////////
	public String getContract_ID() {
		return contractId;
	}


	public void setContract_ID(String contract_ID) {
		contractId = contract_ID;
	}


	public String getCustomer_ID() {
		return customerId;
	}


	public void setCustomer_ID(String customer_ID) {
		customerId = customer_ID;
	}


	public String getSalesMan_ID() {
		return salesmanID;
	}


	public void setSalesMan_ID(String salesMan_ID) {
		salesmanID = salesMan_ID;
	}


	public String getSalesMan_Email_Address() {
		return salesmanEmailAddress;
	}


	public void setSalesMan_Email_Address(String salesMan_Email_Address) {
		salesmanEmailAddress = salesMan_Email_Address;
	}


	public int getSalesMan_Employee_Number() {
		return salesmanEmployeeNumber;
	}


	public void setSalesMan_Employee_Number(int salesMan_Employee_Number) {
		salesmanEmployeeNumber = salesMan_Employee_Number;
	}


	public String getSalesMan_Name() {
		return salesmanName;
	}


	public void setSalesMan_Name(String salesMan_Name) {
		salesmanName = salesMan_Name;
	}


	public int getSalesMan_Phone_Number() {
		return salesmanPhoneNumber;
	}


	public void setSalesMan_Phone_Number(int salesMan_Phone_Number) {
		salesmanPhoneNumber = salesMan_Phone_Number;
	}


	public void setAT(AcceptanceTesting aT) {
		AT = aT;
	}

	public void setTargetCustomer(String targetCustomer) {
		this.targetCustomer = targetCustomer;
	}

	public AcceptanceTesting getMAcceptanceTesting() {
		return mAcceptanceTesting;
	}

	public boolean setMAcceptanceTesting(AcceptanceTesting m_Acceptance_Testing) {
		this.mAcceptanceTesting = m_Acceptance_Testing;
		return true;
	}

	public Proposal getMProposal() {
		return mProposal;
	}

	public boolean setMProposal(Proposal m_Proposal) {
		this.mProposal = m_Proposal;
		return true;
	}

	public ApplicationForm getMApplicationForm() {
		return mApplicationForm;
	}

	public boolean setMApplicationForm(ApplicationForm m_Application_Form) {
		this.mApplicationForm = m_Application_Form;
		return true;
	}

	public ConfirmGettingRewards getMConfirmGettingRewards() {
		return mConfirmGettingRewards;
	}

	public boolean setMConfirmGettingRewards(ConfirmGettingRewards m_Confirm_Getting_Rewards) {
		this.mConfirmGettingRewards = m_Confirm_Getting_Rewards;
		return true;
	}
	public void association(InsuranceListImpl insuaranceList) {
		this.insuranceList = insuaranceList;
	}

}