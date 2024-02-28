package Contract;

import java.util.ArrayList;
import java.util.Scanner;

import Insurance.Insurance;

public class AcceptanceTesting {

	private String customerAddress;
	private ArrayList<ContractList> list;

	private int customerAge;
	private String customerMedicalHistory;
	private String customerName;
	private String customerSex;
	private int dateOfBirthOfCustomer;
	@SuppressWarnings("unused")
	private String acceptanceTestingSuccess;
	@SuppressWarnings("unused")
	private String acceptanceTestingFail;

	public AcceptanceTesting() {
		// contract
		// list �߰��ؼ� ����Ʈ�� �ܼ�â�� �����
		// �μ��˻��� ��ư �ֿܼ� �ļ� �ϰ� �ϸ� �μ��˻縦 �ϰ� �����.

		this.list = new ArrayList<ContractList>();
	
	}

	public void SendTarget(String TargetCustomer, Insurance TargetCustomerInsurance) {
		ContractList CL = new ContractList(TargetCustomer,TargetCustomerInsurance);
		this.list.add(CL);
//		ACRun();
	}
	
	public ArrayList<ContractList> getContractList() {
		return this.list;
	}

	public boolean ACRun() {
		Scanner sc = new Scanner(System.in);
		sc.close();
		// ArrayList ���� Ȯ��

//		System.out.println("�μ��˻��� ����Ʈ�� �����ϼ���.");
//		// ArrayList ��ȸ
//		for (int i = 0; i < this.list.size(); i++) {
//			System.out.println(i + "��." + this.list.get(i));
//		}

		String num = "1";

		while (true) {
			if (num.equals("1")) {
				System.out.println("1�� ����Ʈ�� ��ȸ�մϴ�.");
				String list1 = this.list.get(0).getView();
				System.out.println(list1);
				System.out.println("�μ��˻縦 �����մϴ�.");
				this.list.get(0).setCheckingAT(true);
				
				break;

			} else if (num.equals("2")) {
				System.out.println("2�� ����Ʈ�� ��ȸ�մϴ�.");
				String list2 = this.list.get(1).getView();
				System.out.println(list2);
				System.out.println("�μ��˻縦 �����մϴ�.");
				this.list.get(1).setCheckingAT(true);
				
				break;

			} else if (num.equals("3")) {
				System.out.println("3�� ����Ʈ�� ��ȸ�մϴ�.");
				String list3 = this.list.get(2).getView();
				System.out.println(list3);
				System.out.println("�μ��˻縦 �����մϴ�.");
				this.list.get(2).setCheckingAT(true);
				
				break;

			} else if (num.equals("4")) {
				System.out.println("4�� ����Ʈ�� ��ȸ�մϴ�.");
				String list4 = this.list.get(3).getView();
				System.out.println(list4);
				System.out.println("�μ��˻縦 �����մϴ�.");
				this.list.get(3).setCheckingAT(true);
				
				break;

			} else {
				System.out.println("�߸� �Է��߽��ϴ�! �ٽ� ����Ʈ�� �Է����ּ���.");

			}
		}
		return true;

	}
////////////////////////////////////	
	public String getCustomerAddress() {
		return customerAddress;
	}

	public boolean setCustomerAddress(String customer_address) {
		customerAddress = customer_address;
		return true;
	}

	public int getCustomerAge() {
		return customerAge;
	}

	public boolean setCustomerAge(int customer_age) {
		customerAge = customer_age;
		return true;
	}

	public String getCustomerMedicalHistory() {
		return customerMedicalHistory;
	}

	public boolean setCustomerMedicalHistory(String customer_Medical_History) {
		
		customerMedicalHistory = customer_Medical_History;
		return true;
	}

	public String getCustomerName() {
		return customerName;
	}

	public boolean setCustomerName(String customer_name) {
		customerName = customer_name;
		return true;
	}

	public String getCustomerSex() {
		return customerSex;
	}

	public boolean setCustomerSex(String customer_sex) {
		customerSex = customer_sex;
		return true;
	}

	public int getDateOfBirthOfCustomer() {
		return dateOfBirthOfCustomer;
	}

	public boolean setDateOfBirthOfCustomer(int date_of_Birth_of_Customer) {
		dateOfBirthOfCustomer = date_of_Birth_of_Customer;
		return true;
	}

	public boolean DoAcceptanceTesting(String Acceptance_Testing_Success, String Acceptance_Testing_Fail) {
		
		this.acceptanceTestingSuccess = Acceptance_Testing_Success;
		this.acceptanceTestingFail = Acceptance_Testing_Fail;

		return true;

	}

}